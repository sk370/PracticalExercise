---
icon: edit
date: 2022-08-04
category:
  - 框架
  - SpringBoot
# tag:
#   - tag A
#   - tag B
description: 
  - SpringBoot是Spring官方整合的Spring框架，能够快速创建生产级别的Spring应用，是简化Spring技术栈的快速开发脚手架。
---
# Spring Boot
>
> - Spring基础
> - 熟悉Maven
> - 官方文档：
> - 新特性：
> - 版本概览：
>   - 2.7.2 **CURRENT** **GA**（学习版本为：2.3.4.RELEASE）
>   - 3.0.0-SNAPSHOT **SNAPSHOT**
>   - 3.0.0-M4 PRE
> - 环境要求（基于Spring Boot 2.7.2）：
>   - Java：≥8
>   - Spring Framework：≥5.3.22
>   - Maven：≥3.5
> - Spring Boot 2.7.2支持的Servlet容器版本：
>   - Tomacat 9.0：4.0
>   - Jetty 9.4：3.1
>   - Jetty 10.0：4.0
>   - Undertow 2.0：4.0

## 第1章 Spring Boot介绍

### 1.1 Spring Boot用途

1. SpringBoot是Spring官方整合的Spring框架，能够快速创建生产级别的Spring应用。
1. 一句话介绍：
   - SpringBoot是整合Spring技术栈的一站式框架【spring boot是对spring框架整合的整合】
   - SpringBoot是简化Spring技术栈的快速开发脚手架
3. 优点：
   - 创建独立Spring应用
   - 内嵌web服务器
   - 自动配置Spring以及第三方功能
   - 提供生产级别的监控、健康检查及外部化配置
   - 无代码生成、无需编写XML

### 1.2 spring boot出现背景

#### 1.2.1 微服务（2014年）

- 微服务是一种架构风格
- 一个应用拆分为一组小型服务
- 每个服务运行在自己的进程内，也就是可独立部署和升级
- 服务之间使用轻量级HTTP交互
- 服务围绕业务功能拆分
- 可以由全自动部署机制独立部署
- 去中心化，服务自治。服务可以使用不同的语言、不同的存储技术

#### 1.2.2 分布式

1. 分布式的难点
   - 远程调用
   - 服务发现
   - 负载均衡
   - 服务容错
   - 配置管理
   - 服务监控
   - 链路追踪
   - 日志管理
   - 任务调度
2. 分布式的解决
   - spring boot + spring cloud

#### 1.2.3 云原生

### 1.3 创建Spring Boot2项目（以web工程为例）

#### 1.3.1 手工搭建

1. 创建maven工程
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1659527526285-61177750-a6ba-402c-a62a-31331262360b.png#clientId=ueca4018c-2697-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=518&id=ua6d15ed3&margin=%5Bobject%20Object%5D&name=image.png&originHeight=518&originWidth=780&originalType=binary&ratio=1&rotation=0&showTitle=false&size=99276&status=done&style=none&taskId=u071e5915-dce1-4204-98ef-9f9a92eb73b&title=&width=780)
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1659527661405-40a65cc3-e3c2-48b7-bbab-a0d2403b3ee5.png#clientId=ueca4018c-2697-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=518&id=u8c33701b&margin=%5Bobject%20Object%5D&name=image.png&originHeight=518&originWidth=780&originalType=binary&ratio=1&rotation=0&showTitle=false&size=22401&status=done&style=none&taskId=u09d9853d-8546-4b42-bc3d-78749409e2b&title=&width=780)
2. pom.xml文件中引入依赖

```xml
<parent>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-parent</artifactId>
  <version>2.3.4.RELEASE</version>
</parent>

<dependencies>
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
  </dependency>
</dependencies>
```

3. src/main/java/iceriver.boot包下创建主程序，名称任意

```java
package iceriver.boot;

import org.springframework.boot.SpringApplication;

/**
 * @author: INFINITY https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date: 2022/8/3 20:10
 */
@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class,args);
    }
}
```

4. src/main/java/iceriver.boot.controller包下创建处理请求的控制器

```java
package iceriver.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: INFINITY https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date: 2022/8/3 20:12
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String handle01(){
        return "Hello, Spring Boot 2!";
    }
}
```

5. 运行src/main/java/iceriver.boot包下的主程序main方法
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1659529561840-202e4f4f-25c8-4033-abc0-6dffe1904fda.png#clientId=ueca4018c-2697-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=467&id=uc5059845&margin=%5Bobject%20Object%5D&name=image.png&originHeight=467&originWidth=1628&originalType=binary&ratio=1&rotation=0&showTitle=false&size=94001&status=done&style=none&taskId=u57989886-73c4-49cb-92cb-44837d6f3a2&title=&width=1628)
6. 浏览器访问[http://localhost:8080/hello](http://localhost:8080/hello)
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1659529585435-d618c9f7-d09c-496f-9675-3bada639bf4c.png#clientId=ueca4018c-2697-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=110&id=u7f5ffd32&margin=%5Bobject%20Object%5D&name=image.png&originHeight=110&originWidth=347&originalType=binary&ratio=1&rotation=0&showTitle=false&size=6362&status=done&style=none&taskId=ue98ca60e-c71c-4d6b-9580-167419ff862&title=&width=347)
7. 修改端口号：在resources目录下创建application.properties文件【文件名称固定，称为核心配置文件】

```properties
server.port=8888
```

8. 部署：
   - pom.xml文件中添加插件

```xml
 <build>
   <plugins>
     <plugin>
       <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-maven-plugin</artifactId>
     </plugin>
   </plugins>
</build>
```

- 执行maven打包命令：
  - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1659530307546-2a92c8f6-9599-41dc-a996-46cc344f5083.png#clientId=ueca4018c-2697-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=261&id=u53ec08b2&margin=%5Bobject%20Object%5D&name=image.png&originHeight=261&originWidth=246&originalType=binary&ratio=1&rotation=0&showTitle=false&size=12225&status=done&style=none&taskId=uf1562499-e112-4e86-95dd-4131821f834&title=&width=246)
  - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1659530398039-8508b94d-3b4a-41ca-a5bb-d7651991b771.png#clientId=ueca4018c-2697-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=187&id=u86292810&margin=%5Bobject%20Object%5D&name=image.png&originHeight=187&originWidth=410&originalType=binary&ratio=1&rotation=0&showTitle=false&size=15679&status=done&style=none&taskId=u885981eb-553c-428d-a2a8-1ab2ac7acf8&title=&width=410)
- 执行java -jar jar包名命令
  - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1659533060567-c6a4b24a-7643-4ec0-82de-063c623ee686.png#clientId=ueca4018c-2697-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=400&id=u14ac2a4f&margin=%5Bobject%20Object%5D&name=image.png&originHeight=400&originWidth=1536&originalType=binary&ratio=1&rotation=0&showTitle=false&size=75625&status=done&style=none&taskId=uc38e8563-5b82-4d2a-a742-c7f23dca9e6&title=&width=1536)
  - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1659533099984-6006be85-b281-44f7-9c73-32fedb094fe5.png#clientId=ueca4018c-2697-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=101&id=u8c92532f&margin=%5Bobject%20Object%5D&name=image.png&originHeight=101&originWidth=531&originalType=binary&ratio=1&rotation=0&showTitle=false&size=7770&status=done&style=none&taskId=u1a8aaf4a-6004-497b-92df-9a9375bf2d2&title=&width=531)

#### 1.3.2 spring initializr【spring初始化向导】

1. 创建工程/模块

![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1659579821858-b308d3ad-d68a-4c6f-9a30-38143d22cc83.png#clientId=ueca4018c-2697-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=670&id=u1fb64b2a&margin=%5Bobject%20Object%5D&name=image.png&originHeight=670&originWidth=721&originalType=binary&ratio=1&rotation=0&showTitle=false&size=54502&status=done&style=none&taskId=u8074e434-5144-4652-8a21-0f912d94db6&title=&width=721)

2. 选择需要的依赖
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1659579962123-d635a819-db90-400b-8bc7-78674635fbea.png#clientId=ueca4018c-2697-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=670&id=uc71dc7a5&margin=%5Bobject%20Object%5D&name=image.png&originHeight=670&originWidth=721&originalType=binary&ratio=1&rotation=0&showTitle=false&size=48772&status=done&style=none&taskId=ufa502038-7de6-4443-815b-b80a71bbd1c&title=&width=721)

   -

## 第2章 Spring Boot的底层注解

### 2.1 第一组：@Configuration和@Bean

#### 2.1.1 `@Configuration`

1. 将类声明为配置类，【参见Spring5 4.5完全注解开发[02.Spring5](https://www.yuque.com/zhuyuqi/zna9x5/aze75g?view=doc_embed&inner=Ex1iI)】
1. `@Configuration(proxyBeanMethods = true)`默认为true，此时Spring Boot总会检查这个组件是否在容器中存在，存在时不会再创建。
   - 此时不论是通过MainApplication.java主程序从容器获取组件
   - 还是从配置类MyConfig.java的方法获取组件，都是同一个对象（单实例）

```java
package iceriver.boot;

import iceriver.boot.bean.Pet;
import iceriver.boot.bean.User;
import iceriver.boot.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author: INFINITY https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date: 2022/8/3 20:10
 */
//@SpringBootApplication(scanBasePackages = "iceriver.boot")
@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        //1、返回IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);
        //2、查看容器里面的组件
        String[] names = run.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
        //3、从容器获取组件
        Pet tom01 = run.getBean("tom", Pet.class);
        Pet tom02 = run.getBean("tom", Pet.class);
        System.out.println(tom01 == tom02);//true

        MyConfig bean = run.getBean(MyConfig.class);
        //System.out.println(bean);//iceriver.boot.config.MyConfig$$EnhancerBySpringCGLIB$$2bce5da6@585ac855
        User user = bean.user01();
        User user1 = bean.user01();
        System.out.println(user == user1);//true
    }
}
```

3. `@Configuration(proxyBeanMethods = false)`时：
   - 通过MainApplication.java主程序从容器获取组件是同一个对象
   - 从配置类MyConfig.java的方法获取组件，不是同一个对象
>
> - ⭐该配置为true时，解决了组件依赖问题：比如User类中有Pet类的对象，因为在创建User时，执行到创建Pet对象时，使用的是配置类调用方法创建Pet对象：
>   - 设置为true：跳过了调用方法创建Pet对象，直接在容器中调用，保证了User对象也是唯一的。
>   - 设置为false：调用方法创建Pet对象，由于Pet对象不一致，导致User对象不一致，创建User组件在容器中出现了两个
> - 最佳实战
>   - 配置类组件之间无依赖关系用Lite模式加速容器启动过程，减少判断，设置为false
>   - 配置类组件之间有依赖关系，方法会被调用得到之前单实例组件，用Full模式，设置为true

#### 2.1.2 `@Bean`

1. 给容器中添加组件，用在方法前，方法名为组件id，返回类型为组件类型，返回值为组件在容器中的实例。
   - 可以使用如下的方式`@Bean("tom")`使用自定义名称（不以方法名作为组件名）
      - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1659539159608-81746c99-4266-411e-970e-841fb8fd5680.png#clientId=ueca4018c-2697-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=97&id=ub6ffc95c&margin=%5Bobject%20Object%5D&name=image.png&originHeight=97&originWidth=288&originalType=binary&ratio=1&rotation=0&showTitle=false&size=8177&status=done&style=none&taskId=u24775b18-e062-4ff8-a896-557c6ba181b&title=&width=288)
2. 通过MainApplication.java主程序从容器获取组件：
   - 默认情况容器中的组件是单实例的

```java
package iceriver.boot.config;

import iceriver.boot.bean.Pet;
import iceriver.boot.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: INFINITY https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date: 2022/8/3 23:00
 */
@Configuration
public class MyConfig {
    @Bean
    public User user01(){
        return new User("张三", 18);
    }
    @Bean("tom")
    public Pet tomPet(){
        return new Pet("tom01");
    }
}
```

```java
package iceriver.boot;

import iceriver.boot.bean.Pet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author: INFINITY https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date: 2022/8/3 20:10
 */
//@SpringBootApplication(scanBasePackages = "iceriver.boot")
@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        //1、返回IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);
        //2、查看容器里面的组件
        String[] names = run.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
        //3、从容器获取组件
        Pet tom01 = run.getBean("tom", Pet.class);
        Pet tom02 = run.getBean("tom", Pet.class);
        System.out.println(tom01 == tom02);//true
    }
}

```

3. 通过MainApplication.java主程序从容器获取配置类组件：
   - 配置类是被EnhancerBySpringCGLIB增强了的代理类

```java
package iceriver.boot;

import iceriver.boot.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author: INFINITY https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date: 2022/8/3 20:10
 */
//@SpringBootApplication(scanBasePackages = "iceriver.boot")
@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        //1、返回IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);
        //2、查看容器里面的组件
        String[] names = run.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
        //3、从容器获取组件（配置类）
        System.out.println(run.getBean(MyConfig.class));//iceriver.boot.config.MyConfig$$EnhancerBySpringCGLIB$$2bce5da6@585ac855
    }
}
```

### 2.2 第二组：**@Component、@Controller、@Service、@Repository**

【参见Spring5 2.3.1[02.Spring5](https://www.yuque.com/zhuyuqi/zna9x5/aze75g?view=doc_embed&inner=Hz9sp)】

### 2.3 第三组：@ComponentScan

指定包扫描的路径，【参见2.3.4[02.Spring5](https://www.yuque.com/zhuyuqi/zna9x5/aze75g?view=doc_embed&inner=ZiiVh)】

### 2.4 第四组：@Import

1. 可以用在任何组件上，配合任何组件注解使用。
1. 导入任意指定类型的组件：
   - `@Import({User.class, DBHelper.class})`
   - 给容器中自动创建出这两个类型的组件、默认组件的名字就是全类名（调用其无参构造器创建）

### 2.5 第五组：@Conditional

- 条件装配：满足指定条件，则进行注入
- ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1659570580195-7c8edf1e-1f88-4308-8c01-bac28861e04e.png#clientId=ueca4018c-2697-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=403&id=u950ba11b&margin=%5Bobject%20Object%5D&name=image.png&originHeight=403&originWidth=560&originalType=binary&ratio=1&rotation=0&showTitle=false&size=107290&status=done&style=none&taskId=u03212679-667c-43f9-ab55-5d0a266a3b9&title=&width=560)
- 可以用在方法前，表示满足该条件，则对该方法进行bea注入
- 可以用在类前，表示满足该条件，才对该类中的方法进行ben注入。

### 2.6 第六组：@ImportSource

- 导入原生xml配置文件，将该配置文件的bean加入到容器中

### 2.7 第七组：绑定配置文件
>
> - 场景：某个javabean的初始值写在了application.properties中，如何在创建该组件时，赋默认值。
>   - 前置准备：application.properties中要设置值的属性使用mycar作为属性前缀

#### 2.7.1 @**ConfigurationProperties**

- 用在JavaBean前，从配置文件读取属性初始化值。
- 将JavaBean属性的值写在配置文件中，通过spring boot读取properties配置文件，并把它封装到JavaBean中。
- `@ConfigurationProperties(prefix = "mycar")`
  - 需要与@Component配合使用，将JavaBean通过@Component声明为组件。
  - 或者不使用@Component，在MyConfig.java中使用@Bean创建组件，方法返回无参构造对象

#### 2.7.2 @EnableConfigurationProperties +@ConfigurationProperties

- 对于无法对JavaBean使用@Component的组件（如别人的JavaBean），在MyConfig.java配置类前使用@EnableConfigurationProperties(Car.Class）
  - 作用1：开启Car的配置绑定功能
  - 作用2：将Car这个组件自动注册到容器中

### 2.8 第八组：@SpringBootApplication

#### 2.8.0 介绍

- 将某个类指定为主程序类/主配置类。他自动扫描的路径是同级的其他路径，同下@ComponentScan("iceriver.boot")
- 它是三个组件的合成：
  - @SpringBootConfiguration
  - @EnableAutoConfiguration
  - @ComponentScan("iceriver.boot")

#### 2.8.1 @SpringBootConfiguration

- ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1659573580275-d1397602-e88f-4145-89dd-e954c7d2d1d8.png#clientId=ueca4018c-2697-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=152&id=ua2ab3daa&margin=%5Bobject%20Object%5D&name=image.png&originHeight=152&originWidth=350&originalType=binary&ratio=1&rotation=0&showTitle=false&size=18060&status=done&style=none&taskId=uc0bc00b3-c221-4e6d-95f1-7cc421b779a&title=&width=350) 
- 代表当前是一个配置类。

#### 2.8.2 @EnableAutoConfiguration

- ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1659573684734-104f5890-9f5d-48e3-be8a-88b67de6cfb6.png#clientId=ueca4018c-2697-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=170&id=ua865a607&margin=%5Bobject%20Object%5D&name=image.png&originHeight=170&originWidth=384&originalType=binary&ratio=1&rotation=0&showTitle=false&size=24149&status=done&style=none&taskId=ud78dabde-6cfe-4483-bfaa-c6b7df8e5cf&title=&width=384)
- @AutoConfigurationPackage：导入主程序类所在位置的包下一系列组件
- @Import(AutoConfigurationImportSelector.class)：导入META-INF/spring.factories位置的文件中配置的组件（共127个，加载时全部加载，但使用时由于使用了@ConditionalOnClass注解，可以实现按需配置，用户导入相关的场景启动器后才会激活该注解）
- ![null.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1659575985672-64029f1d-bd7c-4b7a-adaf-92f97973414e.png#clientId=ueca4018c-2697-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=2049&id=u69b0abd8&margin=%5Bobject%20Object%5D&name=null.png&originHeight=2049&originWidth=2901&originalType=binary&ratio=1&rotation=0&showTitle=false&size=1413182&status=done&style=none&taskId=udd7aaded-f2de-4664-aa6a-b6c4c78c5a9&title=&width=2901)

#### 2.8.3 @ComponentScan("iceriver.boot")

- 组件扫描

## 第3章 Spring Boot的自动配置

### 3.1  自动配置实现
>
> - 基于1.3.1（[https://www.yuque.com/zhuyuqi/zna9x5/gs0vv5#bAIMR](#bAIMR)）创建的spring boot2项目进行分析

#### 3.1.1 依赖配置

1. 用户项目使用了spring-boot-starter-parent作为父项目进行依赖管理。
1. spring-boot-starter-parent使用了spring-boot-dependencies作为父项目进行依赖管理。而spring-boot-dependencies中声明了几乎开发中常用的依赖版本号——自动仲裁机制。
1. 依赖中spring-boot-starter-*称为场景启动器，是一组整合好的方便的依赖描述符。只要引入starter，满足该场景的常规依赖都会自动引入。
   - spring-boot-starter-web底层基础依赖是spring-boot-starter，是所有场景启动最底层的依赖。
   - *-spring-boot-starter： 第三方提供的简化开发的场景启动器。

   -

#### 3.1.2 自动配置内容

1. 自动配置好tomcat
   - spring-boot-starter-web场景启动器引入了tomcat场景启动器
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1659536723829-e88cffd4-aae6-4349-8599-6950fcfc21c9.png#clientId=ueca4018c-2697-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=203&id=uotoU&margin=%5Bobject%20Object%5D&name=image.png&originHeight=203&originWidth=518&originalType=binary&ratio=1&rotation=0&showTitle=false&size=32810&status=done&style=none&taskId=ub60ae096-6b09-497d-9215-03219441db0&title=&width=518)
2. 自动配置好SpringMVC
   - spring-boot-starter-web场景启动器引入了springmvc场景启动器
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1659536904354-26b3e34c-9df5-41e8-9aa8-dfa2a9adfb7f.png#clientId=ueca4018c-2697-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=116&id=d730P&margin=%5Bobject%20Object%5D&name=image.png&originHeight=116&originWidth=462&originalType=binary&ratio=1&rotation=0&showTitle=false&size=19114&status=done&style=none&taskId=u50f4c69d-ad0a-4f73-a9df-20028ac00d6&title=&width=462)
3. 自动配置好了springmvc的常用组件（依赖）
   - 配置好了SpringMVC DispatcherServlet以及其他依赖，如jdbc、日志、字符编码等。
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1659537156799-579065b9-6900-4766-bc51-4e5dc0002711.png#clientId=ueca4018c-2697-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=294&id=STy2J&margin=%5Bobject%20Object%5D&name=image.png&originHeight=294&originWidth=777&originalType=binary&ratio=1&rotation=0&showTitle=false&size=38455&status=done&style=none&taskId=ub25bf47a-1dd3-4193-8ad0-1b1ab8602a0&title=&width=777)
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1659537273679-3313950d-0315-472f-bf6a-16d1bf05f529.png#clientId=ueca4018c-2697-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=656&id=E5GrE&margin=%5Bobject%20Object%5D&name=image.png&originHeight=656&originWidth=1038&originalType=binary&ratio=1&rotation=0&showTitle=false&size=109788&status=done&style=none&taskId=uefa058df-d0e9-4194-881f-e7e183ffa29&title=&width=1038)
4. 创建了默认的包结构：
   - 官方文档2.1节，说明了使用默认的包结构，会自动进行包扫描，而不需要手动设置
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1659537525244-15b0b1d4-ac55-43b1-b382-2cce3da17a40.png#clientId=ueca4018c-2697-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=304&id=hMIeB&margin=%5Bobject%20Object%5D&name=image.png&originHeight=304&originWidth=394&originalType=binary&ratio=1&rotation=0&showTitle=false&size=18133&status=done&style=none&taskId=ued1579ac-dac0-45f5-9695-5267ad23133&title=&width=394)
   - 当然可以通过`@SpringBootApplication(scanBasePackages = "iceriver.boot")`扫描指定包
      - 或者使用`@ComponentScan(scanBasePackages = "iceriver.boot")`、`@EnableAutoConfiguration`、`@SpringBootConfiguration`三个代替
5. 各种配置拥有默认值。如文件上传设定了最大上传大小
   - 默认配置最终都是映射到某个类上，如：MultipartProperties
   - 修改配置时，`application.properties`配置文件的值最终会绑定每个类上，这个类会在容器中创建对象
6. 按需加载所有自动配置项
   - springBoot所有的自动配置功能都在 spring-boot-autoconfigure 包里面
   - 引入了哪些场景这个场景的自动配置才会开启

### 3.2 自动配置原理

【参见第2.8[https://www.yuque.com/zhuyuqi/zna9x5/gs0vv5#uvJdT](#uvJdT)】

### 3.2 自动配置流程

1. SpringBoot先加载所有的自动配置类 xxxxxAutoConfiguration
1. 每个自动配置类按照条件进行生效，默认都会绑定配置文件指定的值。xxxxProperties里面拿。xxxProperties和配置文件进行了绑定
1. 生效的配置类就会给容器中装配很多组件
1. 只要容器中有这些组件，相当于这些功能就有了
1. 定制化配置
   - 用户直接自己@Bean替换底层的组件
   - 用户去看这个组件是获取的配置文件什么值就去修改。
6. **xxxxxAutoConfiguration ---> 组件 ---> xxxxProperties里面拿值 ----> application.properties**

### 3.4 【心得】spring boot开发最佳实践流程

1. 引入场景依赖（场景启动器）
   -

2. 查看自动配置了哪些（选做）
   - 自己分析，引入场景对应的自动配置一般都生效了
   - application.properties核心配置文件中debug=true开启自动配置报告。在控制台输出中查看：Negative（不生效）\Positive（生效）
3. 是否需要修改

- 参照文档修改配置项
      -

      - 自己分析。xxxxProperties绑定了配置文件的哪些。
   - 自定义加入或者替换组件
      - @Bean、@Component。。。
   - 自定义器 **XXXXXCustomizer**；

## 第4章 开发小技巧

### 4.1 Lombok

1. 简化JavaBean开发
1. pom.xml中引入lombok

```xml
<dependency>
  <groupId>org.projectlombok</groupId>
  <artifactId>lombok</artifactId>
</dependency>
```

3. 安装Lombok插件
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1659578930815-05184769-d4f1-4f39-b5e8-3a3b04ac6942.png#clientId=ueca4018c-2697-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=107&id=u7561308d&margin=%5Bobject%20Object%5D&name=image.png&originHeight=107&originWidth=291&originalType=binary&ratio=1&rotation=0&showTitle=false&size=7957&status=done&style=none&taskId=u891c3249-e6c4-40a8-8de8-143fa329bbc&title=&width=291)
4. 使用：
   - JavaBean只编写属性，不写getter和setter
   - JavaBean前使用@Data注解，会在编译时生成getter和setter
   - javabean前使用@ToString，会在编译时自动生成toString()
   - JavaBean前使用@AllArgsConstructor注解，会在编译时生成全部参数的有参构造器
   - JavaBean前使用@NoArgsConstructor注解，会在编译时生成无参构造器
   - JavaBean前使用@EqualsAndHashCode注解，会在编译时生成equals()和hashcode()
   - JavaBean前使用@Slf4j注解，可以在代码中使用`log.info("str")`语法在控制台输出内容

### 4.2 Dev-tools

1. 重启restart功能：
   - 热更新reload需要收费
2. 引入依赖

```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-devtools</artifactId>
  <optional>true</optional>
</dependency>
```

3. 使用：ctrl+f9
3. 本质：和idea重启效果一样

## 第5章 Spring Boot2核心技术（功能）

### 5.1 配置文件

#### 5.1.1 application.properties

同时配置了`.properties`和`.yml`，两个文件会同时生效，里面的内容`.properties`会覆盖`.yml`

#### 5.1.2 application.yml

1. 简介：YAML 是 "YAML Ain't Markup Language"（YAML 不是一种标记语言）的递归缩写。在开发的这种语言时，YAML 的意思其实是："Yet Another Markup Language"（仍是一种标记语言）。
1. 基本语法：
   - key: value；kv之间有空格
   - 大小写敏感
   - 使用缩进表示层级关系
   - 缩进不允许使用tab，只允许空格
   - 缩进的空格数不重要，只要相同层级的元素左对齐即可
   - '#'表示注释
   - 字符串无需加引号，如果要加，`''`与`""`表示字符串内容会原样输出字符串/将转义字符转换
3. 数据类型
   - 字面量（k: v）：单个的、不可再分的值。date、boolean、string、number、null
   - 对象：键值对的集合。map、hash、set、object

```yaml
#方式一：
k: {k1:v1,k2:v2,k3:v3}
#方式二：
k: 
 k1: v1
  k2: v2
  k3: v3
```

- 数组：一组按次序排列的值。array、list、queue

```yaml
#方式一：
k: [v1,v2,v3]
#方式二：
k:
 - v1
 - v2
 - v3
```

#### 5.1.3 配置提示

1. 给自定义的类和配置文件添加输入提示
1. 引入依赖

```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-configuration-processor</artifactId>
  <optional>true</optional>
</dependency>
```

3. 打包时排除，减少资源占用（对开发没有影响）

```xml
<build>
  <plugins>
    <plugin>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-maven-plugin</artifactId>
      <configuration>
        <excludes>
          <exclude>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-configuration-processor</artifactId>
          </exclude>
        </excludes>
      </configuration>
    </plugin>
  </plugins>
</build>
```

### 5.2 web开发

#### 5.2.1 创建web项目

![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1659587063329-fcb4cbd5-815f-46e8-a1c7-ab15a607f8f5.png#clientId=ueca4018c-2697-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=625&id=u5e48a358&margin=%5Bobject%20Object%5D&name=image.png&originHeight=625&originWidth=721&originalType=binary&ratio=1&rotation=0&showTitle=false&size=54587&status=done&style=none&taskId=u2a8e89ab-498a-41ed-bf0a-3446ea3ce79&title=&width=721)
![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1659587168311-e30b2303-404a-49a3-873b-8d73b20e3249.png#clientId=ueca4018c-2697-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=625&id=u69309c6f&margin=%5Bobject%20Object%5D&name=image.png&originHeight=625&originWidth=721&originalType=binary&ratio=1&rotation=0&showTitle=false&size=56046&status=done&style=none&taskId=ubf016553-660b-44d3-a67a-9d693c3d55b&title=&width=721)

#### 5.2.2 静态资源访问

1. 在resources路径下：静态资源放在/static (or /public or /resources or /META-INF/resources路径下，则可以直接通过当前项目更路径/+静态资源名的方式访问到。
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1659590434315-ee426e4d-6e40-48ca-9547-721b23244398.png#clientId=ueca4018c-2697-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=136&id=u95a194a8&margin=%5Bobject%20Object%5D&name=image.png&originHeight=136&originWidth=182&originalType=binary&ratio=1&rotation=0&showTitle=false&size=4216&status=done&style=none&taskId=udc73e311-f04e-463c-9c3e-47158ed8362&title=&width=182)
   - 原理：浏览器地址栏的请求首先经过spring mvc的dispatcherServlet处理，如果控制器controller中有对应的请求方法，则按该方法处理。如果没有对应的请求方法，则被servlet默认的控制器处理，直接去访问静态资源。
2. 修改静态资源访问前缀
   - 控制器中设定的拦截请求为`/**`所有请求，这样会导致静态资源的访问和控制器处理的请求都被拦截。
   - 开发中一般希望将静态资源内的访问、和控制器处理前端请求分离开，所以一般会在核心配置文件中间通过`spring.mvc.static-path-pattern=/resources/**`给静态资源的访问增加前缀（resources可以设定为其他名字）
   - 此时访问地址形式为：当前项目路径+resources+静态资源名
3. 修改静态资源的路径（自定义静态资源路径）
   - 在核心配置文件中通过`spring.resources.static-locations=[class:/hh/]`进行配置
   - 访问时，地址形式为当前项目路径+修改后的静态资源访问前缀+静态资源名【访问路径没变化，变的只是静态资源的位置】
4. 访问webjar
   - webjar是人们把前端的js文件等制作成了spring依赖，引入相关依赖后，可以通过：当前项目路径+webjas+前端资源名进行访问
   - [https://www.webjars.org/](https://www.webjars.org/)
   - 原理其实和上面一致，前端的静态资源存放路径也遵循上面个规则
5. 欢迎页（index.html页面）
   - 把index.html当作静态资源，放在相关路径下即可解析为首页，访问当前项目路径即可作为欢迎页。
      - 注意：静态资源访问前缀会影响访问地址，访问时需要加上访问前缀
   - 也可以通过控制器编写index方法，路径用`/`，映射到index页面
6. 自定义Favicon
   - 放到静态资源路径下，起名为`favicon.ico`，则每个页面都会带上小图标
      - 注意：静态资源访问前缀会影响，访问带有访问前缀的的页面才会显示。
   - 小图标保存在session中共享

#### 5.2.3 静态资源配置原理

1. spring boot启动时，加载的springmvc的自动配置类WebMvcAutoConfiguration生效。
1. 【第25集，没看下去】

### 5.3 请求处理

1. 请求映射（restful风格）：spring boot启动时WebMvcAutoConfiguration自动配置了OrderedHiddenHttpMethodFilter类，OrderedHiddenHttpMethodFilter类继承自HiddenHttpMethodFilter，从而能够处理restful风格的请求。
   - 但默认情况下，spring.mvc.hiddenmethod.filter值是false，即使设置了隐藏域，但也发送的是post请求。
   - 只有在核心配置文件中将spring.mvc.hiddenmethod.filter=true后，才可以正常发送put、delete请求。
      - 这个配置只针对于form表单使用
      - 对于postman等这些能直接发送put、delete请求的不用配置
   - 自定义请求方法时，在配置类中重新定义（此时隐藏域的name属性要设置为`_m`：
      - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1659597076037-9ea67033-f66a-464a-a59b-a97aea421cbe.png#clientId=ueca4018c-2697-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=291&id=u25cb348d&margin=%5Bobject%20Object%5D&name=image.png&originHeight=291&originWidth=996&originalType=binary&ratio=1&rotation=0&showTitle=false&size=144529&status=done&style=none&taskId=u731b672d-f615-4a57-9da2-0d227baa38a&title=&width=996)
2. 请求映射处理原理（怎么知道是哪种请求）：
   - 【参见SpringMVC10.3[03.Spring MVC](https://www.yuque.com/zhuyuqi/zna9x5/zh889g?view=doc_embed&inner=d0PTI)】
   - servlet处理请求的方法是doService()，doService()经过一大堆封装、重写之后变成了DispatcherServlet的doDispatcher()，该方法中调用了getHandler()得到所有handlermappings，去看哪个handlerMapping能处理得到的请求
      - ![](https://cdn.nlark.com/yuque/0/2020/png/1354552/1603181460034-ba25f3c0-9cfd-4432-8949-3d1dd88d8b12.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_14%2Ctext_YXRndWlndS5jb20g5bCa56GF6LC3%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10#crop=0&crop=0&crop=1&crop=1&from=url&id=zO0uv&margin=%5Bobject%20Object%5D&originHeight=217&originWidth=501&originalType=binary&ratio=1&rotation=0&showTitle=false&status=done&style=none&title=)
      - **RequestMappingHandlerMapping**：保存了所有@RequestMapping 和handler的映射规则。
      - WelcomePageHandlerMapping：是springBoot自动配置的，处理index页面（欢迎页）的请求，默认配置好了。
   - 自定义HandlerMapping【没讲】
3. 注解：
   - 请求映射注解：
      - `@RequestMapping`【参见sprignmc2.1节】[03.Spring MVC](https://www.yuque.com/zhuyuqi/zna9x5/zh889g?view=doc_embed&inner=aHUfW)
      - `@GetMapping`、`@PostMapping`、`@PutMapping`、`@DeleteMapping`【参见sprignmc2.1节】[03.Spring MVC](https://www.yuque.com/zhuyuqi/zna9x5/zh889g?view=doc_embed&inner=aHUfW)
   - 请求传参注解：
      - @PathVariable：路径占位符，将请求路径解析为参数（restful请求）[03.Spring MVC](https://www.yuque.com/zhuyuqi/zna9x5/zh889g?view=doc_embed&inner=XwOqk)
      - @RequestHeader：[03.Spring MVC](https://www.yuque.com/zhuyuqi/zna9x5/zh889g?view=doc_embed&inner=Oz9xP)
      - @ModelAttribute
      - @RequestParam：[03.Spring MVC](https://www.yuque.com/zhuyuqi/zna9x5/zh889g?view=doc_embed&inner=JYwbf)
      - @MatrixVariable：矩阵变量
         - 请求参数以分号分割，如`/cars/{low=34;brand=byd,audi}`
         - springBoot默认仅用了矩阵变量，需要在核心配置文件中手动开启：
         - urlpathhelper需要单独写一章
      - @CookieValue：[03.Spring MVC](https://www.yuque.com/zhuyuqi/zna9x5/zh889g?view=doc_embed&inner=SFGlQ)
      - @RequestBody：[03.Spring MVC](https://www.yuque.com/zhuyuqi/zna9x5/zh889g?view=doc_embed&inner=MrfxD)
      - @RequestAttribute：从请求域获取参数
