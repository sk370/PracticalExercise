---
icon: edit
date: 2022-08-02
category:
  - 整合
# tag:
#   - tag A
#   - tag B
description: 
  - SSM（SpringMVC+Spring+MyBatis）是目前市场上最流行的开发web项目的框架，它由SpringMVC、Spring、MyBatis整合而成。
---
# SSM整合

> - SSM（SpringMVC+Spring+MyBatis）是目前市场上最流行的开发web项目的框架，它由SpringMVC、Spring、MyBatis整合而成。
>
> - SpringMVC框架负责接收浏览器发送的请求，并响应浏览器数据；
> - Spring框架使用其核心IOC思想管理服务器中各个组件，使用AOP思想面向切面编程，在不改变源码的基础上实现功能增强；
> - MyBatis框架封装JDBC，负责访问数据库，完成持久化操作。

## 第1章 SpringMVC

[Spring MVC](https://www.yuque.com/zhuyuqi/zna9x5/zh889g?view=doc_embed)

## 第2章 Spring

[Spring](https://www.yuque.com/zhuyuqi/zna9x5/aze75g?view=doc_embed)

## 第3章 MyBatis

[MyBatis](https://www.yuque.com/zhuyuqi/zna9x5/ifzzbt?view=doc_embed)

## 第4章 SSM整合

### 4.1 引入

#### 4.1.1 一个问题

1. SpringMVC中，springMVC.xml用于配置控制层组件。
1. Spring中，bean.xml用于配置各个层组件。
1. 而在SpringMVC项目中，通过`<load-on-startup>`将控制层组件初始化提前到创建tomcat容器时（创建servlet时）完成。
1. 但控制层组件依赖spring管理的service实体，此时要求service实体的自动装配必须在控制层组件装配前完成，否则会报错。
1. 这就要求spirng的配置必须在创建servlet前完成。
1. 由于监听器、过滤器、servlet依次执行，所以可以把Spring的配置放到监听器中完成。不选择过滤器的原因是它是专业处理请求和响应的。

#### 4.1.2 ContextLoaderListener

Spring提供了监听器`ContextLoaderListener`，实现`ServletContextListener`接口，可监听
`ServletContext`的状态，在web服务器的启动，读取Spring的配置文件，创建Spring的IOC容器。
![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1659337815113-68a9f991-e12e-494e-b818-14b3ceb1078e.png#clientId=ubb7f2461-50a9-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=237&id=u7fc4b363&margin=%5Bobject%20Object%5D&name=image.png&originHeight=237&originWidth=565&originalType=binary&ratio=1&rotation=0&showTitle=false&size=14881&status=done&style=none&taskId=ubb17e97d-4832-4942-9e50-5454ce38d79&title=&width=565)

#### 4.1.3 使用监听器加载spring配置文件

1. 创建新工程，使用Maven作为构建工具。
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1659338306075-c0437e3d-21cf-4465-810e-3295e1dd90d5.png#clientId=ubb7f2461-50a9-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=615&id=uecf40d17&margin=%5Bobject%20Object%5D&name=image.png&originHeight=615&originWidth=721&originalType=binary&ratio=1&rotation=0&showTitle=false&size=37867&status=done&style=none&taskId=u3449393b-c7e4-4f22-9405-ce80b97147f&title=&width=721)
2. 引入依赖：

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  
  <groupId>iceriver.ssm.pro01-spring-listener</groupId>
  <artifactId>pro01-spring-listener</artifactId>
  <version>1.0-SNAPSHOT</version>
  
  <properties>
    <maven.compiler.source>8</maven.compiler.source>
    <maven.compiler.target>8</maven.compiler.target>
  </properties>
  
  <dependencies>
    <!-- SpringMVC -->
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-webmvc</artifactId>
      <version>5.3.1</version>
    </dependency>
    <!-- 日志 -->
    <dependency>
      <groupId>ch.qos.logback</groupId>
      <artifactId>logback-classic</artifactId>
      <version>1.2.3</version>
    </dependency>
    <!-- ServletAPI -->
    <dependency>
      <groupId>javax.servlet</groupId>
      <artifactId>javax.servlet-api</artifactId>
      <version>3.1.0</version>
      <scope>provided</scope>
    </dependency>
    <!-- Spring5和Thymeleaf整合包 -->
    <dependency>
      <groupId>org.thymeleaf</groupId>
      <artifactId>thymeleaf-spring5</artifactId>
      <version>3.0.12.RELEASE</version>
    </dependency>
  </dependencies>
</project>
```

3. 配置web工程：
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1659338765872-09d5a0bc-0de0-4829-ac38-7d7396e826ac.png#clientId=ubb7f2461-50a9-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=845&id=u3679ae5a&margin=%5Bobject%20Object%5D&name=image.png&originHeight=845&originWidth=1024&originalType=binary&ratio=1&rotation=0&showTitle=false&size=90463&status=done&style=none&taskId=ufa8d495c-108d-4be1-932e-f2708f6a150&title=&width=1024)
4. 配置springMVC前端控制器，及spring配置文件

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
         version="4.0">

<!--    springmvc前端控制器配置-->
    <servlet>
        <servlet-name>SpringMVC</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>classpath:springmvc.xml</param-value>
        </init-param>
        <load-on-startup>1</load-on-startup>
    </servlet>
    <servlet-mapping>
        <servlet-name>SpringMVC</servlet-name>
        <url-pattern>/</url-pattern>
    </servlet-mapping>
<!--    在监听器配置spring配置文件-->
    <listener>
        <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
    </listener>
    <context-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>classpath:spring.xml</param-value>
    </context-param>
</web-app>
```

- 这里spring的配置文件采用了自定义文件名的方式，如果没有`<context-param>`这段内容，则spring的配置文件名称要为：applicationContext.xml，位置要在/WEB-INF/下。、

5. 创建springmvc.xml和spring.xml配置文件

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:mvc="http://www.springframework.org/schema/mvc"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/context https://www.springframework.org/schema/context/spring-context.xsd http://www.springframework.org/schema/mvc https://www.springframework.org/schema/mvc/spring-mvc.xsd">

    <!--扫描组件-->
    <context:component-scan base-package="iceriver.ssm.pro01.controller"/>

    <!--配置视图解析器-->
    <bean id="viewResolver" class="org.thymeleaf.spring5.view.ThymeleafViewResolver">
        <property name="order" value="1"/>
        <property name="characterEncoding" value="UTF-8"/>
        <property name="templateEngine">
            <bean class="org.thymeleaf.spring5.SpringTemplateEngine">
                <property name="templateResolver">
                    <bean class="org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver">

                        <!-- 视图前缀 -->
                        <property name="prefix" value="/WEB-INF/templates/"/>

                        <!-- 视图后缀 -->
                        <property name="suffix" value=".html"/>
                        <property name="templateMode" value="HTML5"/>
                        <property name="characterEncoding" value="UTF-8" />
                    </bean>
                </property>
            </bean>
        </property>
    </bean>
    <mvc:annotation-driven/>
    <mvc:view-controller path="/" view-name="index"></mvc:view-controller>
</beans>
```

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/context https://www.springframework.org/schema/context/spring-context.xsd">
    <context:component-scan base-package="iceriver.ssm.pro01.service"/>
</beans>
```

- srpingmvc创建的ioc容器是spring创建的ioc容器的子容器。spring中，子容器能够访问父容器，但父容器不能访问子容器。

### 4.2 SSM整合案例

#### 4.2.1 创建工程

1. 创建工程：【同上】
1. 导入依赖：

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>iceriver.ssm.pro02-ssm</groupId>
    <artifactId>pro02-ssm-integration</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.source>8</maven.compiler.source>
        <maven.compiler.target>8</maven.compiler.target>
        <spring.version>5.3.1</spring.version>
    </properties>
    <dependencies>
        <!-- spring上下文依赖-->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <!-- spring bean管理依赖-->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-beans</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <!--springmvc-->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-web</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-webmvc</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <!-- 事务管理需要jdbc-->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-jdbc</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-aspects</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-test</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <!-- Mybatis核心 -->
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>3.5.7</version>
        </dependency>
        <!--mybatis和spring的整合包-->
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis-spring</artifactId>
            <version>2.0.6</version>
        </dependency>
        <!-- 连接池 -->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid</artifactId>
            <version>1.0.9</version>
        </dependency>
        <!-- junit测试 -->
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
            <scope>test</scope>
        </dependency>
        <!-- MySQL驱动 -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.16</version>
        </dependency>
        <!-- log4j日志 -->
        <dependency>
            <groupId>log4j</groupId>
            <artifactId>log4j</artifactId>
            <version>1.2.17</version>
        </dependency>
        <dependency>
            <groupId>com.github.pagehelper</groupId>
            <artifactId>pagehelper</artifactId>
            <version>5.2.0</version>
        </dependency>
        <!-- 日志 -->
        <dependency>
            <groupId>ch.qos.logback</groupId>
            <artifactId>logback-classic</artifactId>
            <version>1.2.3</version>
        </dependency>
        <!-- ServletAPI -->
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>javax.servlet-api</artifactId>
            <version>3.1.0</version>
            <scope>provided</scope>
        </dependency>
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
            <version>2.12.1</version>
        </dependency>
        <dependency>
            <groupId>commons-fileupload</groupId>
            <artifactId>commons-fileupload</artifactId>
            <version>1.3.1</version>
        </dependency>
        <!-- Spring5和Thymeleaf整合包 -->
        <dependency>
            <groupId>org.thymeleaf</groupId>
            <artifactId>thymeleaf-spring5</artifactId>
            <version>3.0.12.RELEASE</version>
        </dependency>
    </dependencies>
</project>
```

3. 创建web支持
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1659343691562-aee5df66-01ba-4da9-b679-7b0b960b51e7.png#clientId=ubb7f2461-50a9-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=845&id=u5dff6430&margin=%5Bobject%20Object%5D&name=image.png&originHeight=845&originWidth=1024&originalType=binary&ratio=1&rotation=0&showTitle=false&size=91274&status=done&style=none&taskId=ucaa0d8d3-5406-4886-a6ea-b2a428bb24b&title=&width=1024)
4. 创建测试表：
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1659343904759-fd36ed39-b800-4a19-a3d0-d698f0d45fa9.png#clientId=ubb7f2461-50a9-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=474&id=ud04d6e06&margin=%5Bobject%20Object%5D&name=image.png&originHeight=474&originWidth=795&originalType=binary&ratio=1&rotation=0&showTitle=false&size=56485&status=done&style=none&taskId=u4a686a45-8ec9-4e7e-bf57-7b89088282c&title=&width=795)
   - 生成数据【任意数量】

#### 4.2.2  配置web.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
         version="4.0">
<!--    1. 配置spring的编码过滤器-->
    <filter>
        <filter-name>CharacterEncodingFilter</filter-name>
        <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
        <init-param>
            <param-name>encoding</param-name>
            <param-value>UTF-8</param-value>
        </init-param>
        <init-param>
            <param-name>forceEncoding</param-name>
            <param-value>true</param-value>
        </init-param>
    </filter>
    <filter-mapping>
        <filter-name>CharacterEncodingFilter</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>
<!--    2. 配置请求方式的过滤器-->
    <filter>
        <filter-name>HiddenHttpMethodFilter</filter-name>
        <filter-class>org.springframework.web.filter.HiddenHttpMethodFilter</filter-class>
    </filter>
    <filter-mapping>
        <filter-name>HiddenHttpMethodFilter</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>
<!--    3. 配置springmvc的前端控制器-->
    <servlet>
        <servlet-name>SpringMVC</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>classpath:springmvc.xml</param-value>
        </init-param>
        <load-on-startup>1</load-on-startup>
    </servlet>
    <servlet-mapping>
        <servlet-name>SpringMVC</servlet-name>
        <url-pattern>/</url-pattern>
    </servlet-mapping>
<!--    4. 在监听器配置spring配置文件-->
    <listener>
        <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
    </listener>
<!--    5. 配置spring配置文件自定义的位置和名称-->
    <context-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>classpath:spring.xml</param-value>
    </context-param>
</web-app>
```

#### 4.2.3 配置springmvc.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:mvc="http://www.springframework.org/schema/mvc"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/context https://www.springframework.org/schema/context/spring-context.xsd http://www.springframework.org/schema/mvc https://www.springframework.org/schema/mvc/spring-mvc.xsd">

    <!--扫描组件-->
    <context:component-scan base-package="iceriver.ssm.pro02.controller"/>

    <!--配置视图解析器-->
    <bean id="viewResolver" class="org.thymeleaf.spring5.view.ThymeleafViewResolver">
        <property name="order" value="1"/>
        <property name="characterEncoding" value="UTF-8"/>
        <property name="templateEngine">
            <bean class="org.thymeleaf.spring5.SpringTemplateEngine">
                <property name="templateResolver">
                    <bean class="org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver">
                        <!-- 视图前缀 -->
                        <property name="prefix" value="/WEB-INF/templates/"/>
                        <!-- 视图后缀 -->
                        <property name="suffix" value=".html"/>
                        <property name="templateMode" value="HTML5"/>
                        <property name="characterEncoding" value="UTF-8" />
                    </bean>
                </property>
            </bean>
        </property>
    </bean>

    <!--配置默认的servlet处理静态资源-->
    <mvc:default-servlet-handler/>

    <!--开启mvc的注解驱动-->
    <mvc:annotation-driven/>

    <!--配置视图控制器-->
    <mvc:view-controller path="/" view-name="index"/>

    <!--配置文件上传解析器-->
    <bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver"/>

    <!--配置异常处理器-->
    <!--配置拦截器-->
</beans>
```

#### 4.2.4 配置spring.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/context https://www.springframework.org/schema/context/spring-context.xsd">
<!--    引入jdbc.properties-->
    <context:property-placeholder location="classpath:jdbc.properties"/>
<!--    扫描组件，除控制层-->
    <context:component-scan base-package="iceriver.ssm.pro02">
        <context:exclude-filter type="annotation" expression="org.springframework.stereotype.Controller"/>
    </context:component-scan>
<!--    配置数据源-->
    <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource">
        <property name="driverClassName" value="${jdbc.driver}"/>
        <property name="url" value="${jdbc.url}"/>
        <property name="username" value="${jdbc.username}"/>
        <property name="password" value="${jdbc.password}"/>
    </bean>
</beans>
```

#### 4.2.5 配置mybatis-config.xml

1. 编写配置文件

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//MyBatis.org//DTD Config 3.0//EN"
        "http://MyBatis.org/dtd/MyBatis-3-config.dtd">
<configuration>
    <properties resource="jdbc.properties"/>
    <typeAliases>
        <package name=""/>
    </typeAliases>
    <environments default="mysql_test">
        <environment id="mysql_test">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <property name="driver" value="${jdbc.driver}"/>
                <property name="url" value="${jdbc.url}"/>
                <property name="username" value="${jdbc.username}"/>
                <property name="password" value="${jdbc.password}"/>
            </dataSource>
        </environment>
    </environments>
    <mappers>
        <package name=""/>
    </mappers>
</configuration>
```

2. 编写mapper类
2. 编写mapper.xml映射文件

#### 4.2.6 spring.xml整合mybatis核心配置文件

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/context https://www.springframework.org/schema/context/spring-context.xsd">
<!--    引入jdbc.properties-->
    <context:property-placeholder location="classpath:jdbc.properties"/>
<!--    扫描组件，除控制层-->
    <context:component-scan base-package="iceriver.ssm.pro02">
        <context:exclude-filter type="annotation" expression="org.springframework.stereotype.Controller"/>
    </context:component-scan>
<!--    配置数据源-->
    <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource">
        <property name="driverClassName" value="${jdbc.driver}"/>
        <property name="url" value="${jdbc.url}"/>
        <property name="username" value="${jdbc.username}"/>
        <property name="password" value="${jdbc.password}"/>
    </bean>
<!--    整合mybatis:-->
<!--    配置sqlsessionfactorybean，可以直接在spring的ioc中获取sqlsessionfactory对象-->
    <bean class="org.mybatis.spring.SqlSessionFactoryBean">
<!--        设置mybatis的核心配置文件路径，如果有这个设置，则允许spring.xml与mybatis-config.xml同时进行配置-->
        <property name="configLocation" value="classpath:mybatis-cofig.xml"/>
<!--        设置数据源-->
        <property name="dataSource" ref="dataSource"/>
<!--        设置类型别名对应的包-->
        <property name="typeAliasesPackage" value="iceriver.ssm.pro02.pojo"/>
<!--        设置映射文件路径：如果映射文件与mapper类的包名一致时，可以不设置。注意，不设置时还需要设置下面的sqlsession实现类对象。不然还是要写-->
<!--        <property name="mapperLocations" value="classpath:iceriver/ssm/pro02/mapper/*.xml"/>-->
    </bean>
<!--    配置mapper接口的扫描，可以将指定包下所有的mapper接口通过sqlsession创建代理实现类对象，并将这些对象交给ioc容器管理-->
<!--    有了这个配置，就可以直接在serviceimple类中直接使用ampper类了，而不用创建sqlsession对象-->
    <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
        <property name="basePackage" value="iceriver.ssm.pro02.mapper"/>
    </bean>
</beans>
```

**注1：**配置后就不需要mybatis-config.xml了，但由于spring.xml中有`<property name="configLocation" value="classpath:mybatis-cofig.xml"/>`，所以还是允许mybatis-config.xml存在的。
**注2：第29行老师讲的时候说可以不配置，他的演示里也没有配置，但本地测试，必须配置，否则会报500错误：**

- ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1659406043168-f9764aac-0c42-4e8d-aeaf-3a051e22690b.png#clientId=ubb7f2461-50a9-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=929&id=ubcfc2e72&margin=%5Bobject%20Object%5D&name=image.png&originHeight=929&originWidth=1920&originalType=binary&ratio=1&rotation=0&showTitle=false&size=76733&status=done&style=none&taskId=u824f8e34-04b7-49eb-9f6d-19753d11c8a&title=&width=1920)

#### 4.2.7 spring.xml整合事务管理

1. 引入`log4j.xml`

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE log4j:configuration SYSTEM "log4j.dtd">
<log4j:configuration xmlns:log4j="http://jakarta.apache.org/log4j/">
    <appender name="STDOUT" class="org.apache.log4j.ConsoleAppender">
        <param name="Encoding" value="UTF-8"/>
        <layout class="org.apache.log4j.PatternLayout">
            <param name="ConversionPattern" value="%-5p %d{MM-dd HH:mm:ss,SSS}%m (%F:%L) \n"/>
        </layout>
    </appender>
    <logger name="java.sql">
        <level value="debug"/>
    </logger>
    <logger name="org.apache.ibatis">
        <level value="info"/>
    </logger>
    <root>
        <level value="debug"/>
        <appender-ref ref="STDOUT"/>
    </root>
</log4j:configuration>
```

2. spring.xml中配置事务：
   - 同spring5事务配置[Spring5](https://www.yuque.com/zhuyuqi/zna9x5/aze75g?view=doc_embed&inner=IORB4)

### 4.3 实践
>
> - 完成查询及分页查询功能
