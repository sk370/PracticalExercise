package com.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2021000121665150";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQDWxMJPCp6gSKPLfBe3xBhuAcHX9BcBmuZWtzdZPPpzAaffkIhghMzW8RGtTT9pIHblGGV7dkoheO2vhducXEXAHZ+LJ1f1/2SuRhn4sNN4kLzyfU9AK5OyMc8B5pTB/UW5VYgX9LL2+ywt0zVuYiU5SNR2I1WTzjTukHgmxyGDMBseN/AIEezsh4e/ERNExpjSsjHSoK4aY267lUeFIyEw5Yes2kjKbGkVRSfBf0K6NpmwlDd9umVyrOZROj/Q0uvOipolHq/rI/HMsUWWZyBdgkTEmGvEaO/QfQF4uQuPfZQU5Eyu3q3mzJ0w4qj8JJterBOiLBv+hBtQX8SLriqjAgMBAAECggEBALkVwhraHRAm6bmwTMRa427SZtqUCcuhUYZDyRhHu9KnB6Rca5s6d0l5YXGHk/EmQDB5EOQQchxcmgHdCwC6aIYDQX5rvptKqNqjoTg4M1bA7YTQxx6XL2avFCYgL+zqN09cTbfPcvf0SAOJ9I8XV9sBT9Ar7VE+sVEzAcjxbYketHUxBOHqZkAm8/SlpheIhq9rie10oPuOKHYg1COOluyUm++2nDDjvvtV+gTn+h8SLGp7MCYA0WEQokQw0DppAUmsCidpIsKENM1xTW2UAwbrZfePK0joB2YbeDdkHzEcht9ZosdzWhILbL2oqBDnG62bx/+UcQ47ac2Q4Km5dlECgYEA9eB8AtHvdF613NmD3ddzxQp8HMuGzGsZO8AOqbJ2IWLOqjRy95+VRXDsTs873+pJDuPMCWAN4HUifmRCGHsPPRDaQ6xP+eN/mdHLCuOaUufJJ1g7zj2fora1Ef/Nu5OTOXVDouy3Yr1XmSDPjNcn+yJuYMMQhGmZMiPiyKEqEzsCgYEA35xlgIg/PAI+c2xdG/wCQh7t1syEvKy7l7OQZZInlTI2nAkQv42uCHtfPKSHNUEWwo2d2xlzGkKrDHUZKuowk5eBFMFg6BljMb+qhEJty5oOEjEJqMox0X/At82Ih5JOR/MVynvbHGDqnLRHBzuYTU10Nvu3RugKN74zdpp0f7kCgYEA3BOGbG/ESQDM/1SiN1q1gNSVqqBxk175QwXxGetm2RM7sBUqIoJwdatRmGjdStrFcdJruqiDQzkVGtRaZNchGKOQ+amuHBmJCQFDIAgBBdv5rIHJZhy6WkX3ZJj2aML6sB9J3vbKXlLjqWg43fNnEd4LtghjLGHogXylbLb0likCgYB3fa6r4aLQ4W4X5edXhfJ6/OYhq4afADr6lOTrsg9e5cdS2HFPu1kthSfeUxlBdve/nUemhlIAzXF0Jbr+OMkehY5f1fp/7NkaA48OQCVF8JvmUrgTr4Cxr+//CGEV+TPFtPuHCWqMHqogdSGjltALNwGMRDSrOmIDaas8jMsGWQKBgQD0mRAMK49htxCTL+yogwtqZOK3oW6Flvdwx9XiiT2JdjFrgkqRZINzg0jHqK8yj/FSmqgKne0ChOKmuHxGzqLLKOikcjO2eYn+UhUmnHa2iq3D+KKcPnWRhco34M5fbnJXGCkySptdyDYpxDdT80VzUKja3yqQyI7koYVqDJpwjw==";
	
    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjovGYqCxj2/CqR8e8f1fSrmr0t0/asC9d3UQuVUbHX++sII7j7oVzhkaUl0UCvsNezt3PmlmxFFindxeTb8vedIGt945MGk9HQFOarvbQVy7rqqtMCeCfPzE/N0sIn/sHODVlDmBzxlAIuU3+IjCH4sl/VEMj6s06VrGFUhyYsKSXXobuzYNJfAqAnz6CGPPzC1sqR2fqU+v0qeAPH8JbeH913uw/70Ke69NQU6UuVqqiGp+e7GK9Z5kAJp3aWEQA6g8QvJNej7E+j6PHr78LTI23lam+QsHThpTKSEBMID/PeTlhFxfDOoIGDu+0tyhC2tKdAxQ8LH3tVBMmQzpEQIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝日志
	public static String log_path = "D:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

