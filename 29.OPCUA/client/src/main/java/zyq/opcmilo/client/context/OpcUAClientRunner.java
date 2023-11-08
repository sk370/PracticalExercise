package com.xxmes.opcapp.context;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSON;
import com.xxmes.opcapp.model.opc.ConfigInfo;
import com.xxmes.opcapp.config.AppConfig;
import com.xxmes.opcapp.config.KeyStoreLoaderConfig;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.eclipse.milo.opcua.sdk.client.OpcUaClient;
import org.eclipse.milo.opcua.sdk.client.api.config.OpcUaClientConfig;
import org.eclipse.milo.opcua.sdk.client.api.config.OpcUaClientConfigBuilder;
import org.eclipse.milo.opcua.sdk.client.api.identity.UsernameProvider;
import org.eclipse.milo.opcua.stack.client.UaTcpStackClient;
import org.eclipse.milo.opcua.stack.core.types.builtin.LocalizedText;
import org.eclipse.milo.opcua.stack.core.types.structured.EndpointDescription;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.Unsigned.uint;

public class OpcUAClientRunner {
	
	public static OpcUaClient opcUaClient;
	
	public Logger log = Logger.getLogger(OpcUAClientRunner.class); 
	
    /**
       *   创建OPC UA的服务连接对象
     */
    public void createClient() throws Exception {
    	File file = new File(AppConfig.CONFIG_FILE_PATH);
		String fileStr = FileUtils.readFileToString(file, "UTF-8");
		ConfigInfo info = JSON.parseObject(fileStr, ConfigInfo.class);
    	//读取连接地址
    	String endpointUrl = info.getEndpoint();
    	
        Path securityTempDir = Paths.get(AppConfig.CERTIFICATE_PATH);
//        Path securityTempDir = Paths.get(System.getProperty("java.io.tmpdir"), "security");
        Files.createDirectories(securityTempDir);
        if (!Files.exists(securityTempDir)) {
        	log.error("不能够创建安全路径: " + securityTempDir);
            throw new Exception("不能够创建安全路径: " + securityTempDir);
        }
        KeyStoreLoaderConfig loader = new KeyStoreLoaderConfig().load(securityTempDir);
        // 获取OPC UA的服务器端节点
        EndpointDescription[] endpoints =
                UaTcpStackClient.getEndpoints(endpointUrl).get();
        EndpointDescription endpoint = Arrays.stream(endpoints)
                .filter(e -> e.getEndpointUrl().equals(endpointUrl))
                .findFirst().orElseThrow(() -> new Exception("没有节点返回"));
        // 设置OPC UA的配置信息
        OpcUaClientConfigBuilder builder = OpcUaClientConfig.builder();
        builder.setApplicationName(LocalizedText.english("Eclipse Milo Example Client"))
                .setApplicationUri("urn:eclipse:milo:examples:client")
                .setCertificate(loader.getClientCertificate())
                .setKeyPair(loader.getClientKeyPair())
                .setEndpoint(endpoint)
                .setRequestTimeout(uint(5000));
        //验证配置文件是否存在用户
        List<String> user = info.getUser();
        if(CollUtil.isNotEmpty(user)) {
        	builder.setIdentityProvider(new UsernameProvider(user.get(0), user.get(1)));
        }
        OpcUaClientConfig config = builder.build();
        // 创建OPC UA客户端
        opcUaClient = new OpcUaClient(config);
        if(ObjectUtil.isNotNull(opcUaClient)) {
        	log.info("客户端创建成功！");
        }else {
        	log.info("客户端创建失败。。。");
        }
    }
    
}
