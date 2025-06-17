package com.sk370.opcua.client;

import com.sk370.opcua.config.OpcUaConfig;
import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.eclipse.milo.opcua.sdk.client.OpcUaClient;
import org.eclipse.milo.opcua.sdk.client.api.config.OpcUaClientConfig;
import org.eclipse.milo.opcua.sdk.client.api.identity.AnonymousProvider;
import org.eclipse.milo.opcua.stack.client.DiscoveryClient;
import org.eclipse.milo.opcua.stack.core.security.SecurityPolicy;
import org.eclipse.milo.opcua.stack.core.types.builtin.LocalizedText;
import org.eclipse.milo.opcua.stack.core.types.structured.EndpointDescription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Security;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.Unsigned.uint;

/**
 * opcua客户端类
 *
 * @author sk370
 */
@Slf4j
@Component
public class OpcUAClientRunner {

    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    private final CompletableFuture<OpcUaClient> future = new CompletableFuture<>();

    public static OpcUaClient opcUaClient;

    @Autowired
    private OpcUaConfig opcUaConfig;


    @PostConstruct
    public void createClient() {
        try {
            //System.getproperty(“java.io.tmpdir”)是获取操作系统缓存的临时目录
            Path securityTempDir = Paths.get(System.getProperty("java.io.tmpdir"), "security");
            Files.createDirectories(securityTempDir);
            if (!Files.exists(securityTempDir)) {
                throw new Exception("没有创建安全目录: " + securityTempDir);
            }
            log.info("安全目录: {}", securityTempDir.toAbsolutePath());

            //加载秘钥
            KeyStoreLoader loader = new KeyStoreLoader().load(securityTempDir);

            //安全策略 None、Basic256、Basic128Rsa15、Basic256Sha256
            SecurityPolicy securityPolicy = SecurityPolicy.None;

            // 发现服务
            List<EndpointDescription> endpoints;

            try {
                endpoints = DiscoveryClient.getEndpoints(opcUaConfig.getEndpointUrl()).get();
            } catch (Throwable ex) {
                // 发现服务
                String discoveryUrl = opcUaConfig.getEndpointUrl();

                if (!discoveryUrl.endsWith("/")) {
                    discoveryUrl += "/";
                }
                discoveryUrl += "discovery";

                log.info("开始连接 URL: {}", discoveryUrl);
                endpoints = DiscoveryClient.getEndpoints(discoveryUrl).get();
            }

            EndpointDescription endpoint = endpoints.stream()
                    .filter(e -> e.getSecurityPolicyUri().equals(securityPolicy.getUri()))
                    .filter(opcUaConfig.endpointFilter())
                    .findFirst()
                    .orElseThrow(() -> new Exception("没有连接上端点"));

            log.info("使用端点: {} [{}/{}]", endpoint.getEndpointUrl(), securityPolicy, endpoint.getSecurityMode());

            OpcUaClientConfig config = OpcUaClientConfig.builder()
                    .setApplicationName(LocalizedText.english("eclipse milo opc-ua client"))
                    .setApplicationUri("urn:eclipse:milo:examples:client")
                    .setCertificate(loader.getClientCertificate())
                    .setKeyPair(loader.getClientKeyPair())
                    .setEndpoint(endpoint)
                    //根据匿名验证和第三个用户名验证方式设置传入对象 AnonymousProvider（匿名方式）UsernameProvider（账户密码）
                    //new UsernameProvider("admin","123456")
                    .setIdentityProvider(new AnonymousProvider())
                    .setRequestTimeout(uint(5000))
                    .build();
            opcUaClient = OpcUaClient.create(config);
        } catch (Exception e) {
            log.error("创建客户端失败" + e.getMessage());
        }
    }
}
