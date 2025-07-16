---
icon: edit
date: 2022-07-17
category:
  - 框架
  - Spring
# tag:
#   - tag A
#   - tag B
description: 
  - Spring是轻量级的开源JavaEE框架，解决企业应用开发的复杂性，核心原理利用IoC：控制反转，把创建对象过程交给Spring进行管理和Aop：面向切面，不修改源代码进行功能增强使得Java开发变得简介、高效。
---
# Spring
>
> - 基于Spring5.0

## 第1章 Spring概述

### 1.1 Spring框架介绍

#### 1.1.1 基本介绍

1. 是什么：Spring是轻量级的开源JavaEE框架
   - 框架：高效、简洁开发
2. 作用：解决企业应用开发的复杂性
2. 核心：IoC和Aop
   - IoC：控制反转，把创建对象过程交给Spring进行管理
   - Aop：面向切面，不修改源代码进行功能增强
4. 特点：
   - 方便解耦，简化开发
   - Aop 编程支持
   - 方便程序测试
   - 方便和其他框架进行整合
   - 方便进行事务操作
   - 降低 API 开发难度

#### 1.1.2 框架结构图

![](https://cdn.nlark.com/yuque/0/2022/png/1604140/1658023855969-20d592e1-9ac0-4ffb-8848-e8f9430ad58d.png#clientId=u4351ac9e-274f-4&crop=0&crop=0&crop=1&crop=1&from=paste&id=u2b44927f&margin=%5Bobject%20Object%5D&originHeight=540&originWidth=720&originalType=url&ratio=1&rotation=0&showTitle=false&status=done&style=none&taskId=uc0b95a8d-8e60-4988-873e-d6690bb6c4d&title=)

### 1.2 Spring5.2下载

#### 1.2.1 手动下载，引入IDEA

1. 下载地址：
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657585371056-272e5ba6-b89d-4778-ad57-8b449a315fae.png#clientId=u7ad9d3e0-adc3-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=195&id=ud192ddee&margin=%5Bobject%20Object%5D&name=image.png&originHeight=195&originWidth=663&originalType=binary&ratio=1&rotation=0&showTitle=false&size=22932&status=done&style=none&taskId=u97e54b03-b8b6-48ff-9f03-f89c1d5fb0d&title=&width=663)
   - 确认版本：
      - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657585523578-2d093293-d21e-4162-881c-8af91355d33e.png#clientId=u7ad9d3e0-adc3-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=591&id=uc9695e40&margin=%5Bobject%20Object%5D&name=image.png&originHeight=591&originWidth=1244&originalType=binary&ratio=1&rotation=0&showTitle=false&size=100543&status=done&style=none&taskId=u64ab4ba5-9ff1-41c1-a64c-167095a8f13&title=&width=1244)
   - 前往下载页面：
      - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657585552553-c34f32c6-5d72-49e3-895b-372da0c3b7a3.png#clientId=u7ad9d3e0-adc3-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=328&id=ue7141ac7&margin=%5Bobject%20Object%5D&name=image.png&originHeight=328&originWidth=1192&originalType=binary&ratio=1&rotation=0&showTitle=false&size=47265&status=done&style=none&taskId=ud5028943-d9b9-4b5e-b0bf-a3feb19d09a&title=&width=1192)
      - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657585579394-b5c49ca2-1930-486c-acef-81b5e349e209.png#clientId=u7ad9d3e0-adc3-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=354&id=uba4d7d7e&margin=%5Bobject%20Object%5D&name=image.png&originHeight=509&originWidth=380&originalType=binary&ratio=1&rotation=0&showTitle=false&size=27025&status=done&style=none&taskId=u2efe1011-0ce7-457c-9162-98d869280ef&title=&width=264)第一个框中的为最新版本，第二个框中的为历史版本
   - 下载源码：
      - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657585645762-4b610f74-9e97-4431-8dbf-d1b37cd7775c.png#clientId=u7ad9d3e0-adc3-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=124&id=u1baa6aeb&margin=%5Bobject%20Object%5D&name=image.png&originHeight=124&originWidth=886&originalType=binary&ratio=1&rotation=0&showTitle=false&size=12974&status=done&style=none&taskId=uaf1d3141-ab18-486e-838f-af9b9a8072f&title=&width=886)
   - 下载后找个位置存放即可。
2. IDEA中创建普通Java工程【不同版本IDEA的步骤不同】
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657585880731-161341f2-b359-4106-a85f-cb8067441092.png#clientId=u7ad9d3e0-adc3-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=120&id=u39f15434&margin=%5Bobject%20Object%5D&name=image.png&originHeight=120&originWidth=507&originalType=binary&ratio=1&rotation=0&showTitle=false&size=13442&status=done&style=none&taskId=u10d96916-d457-4ab5-866f-273e2bcf6d8&title=&width=507)
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657585956301-06ddb16f-497e-4b62-88a8-e828737b28c0.png#clientId=u7ad9d3e0-adc3-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=467&id=uc8d7f279&margin=%5Bobject%20Object%5D&name=image.png&originHeight=467&originWidth=719&originalType=binary&ratio=1&rotation=0&showTitle=false&size=37442&status=done&style=none&taskId=u753657d4-a238-4082-a23f-9ea488ca163&title=&width=719)
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657585969439-b227f75a-d6bb-4ee7-9f29-8c6fc2988652.png#clientId=u7ad9d3e0-adc3-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=467&id=u87d0fe51&margin=%5Bobject%20Object%5D&name=image.png&originHeight=467&originWidth=719&originalType=binary&ratio=1&rotation=0&showTitle=false&size=10184&status=done&style=none&taskId=u868f6cc9-0115-4744-bbd8-00a863e7288&title=&width=719)
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657586107785-7c5238eb-3a29-4249-b914-ba2210943876.png#clientId=u7ad9d3e0-adc3-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=438&id=u1c2e7f17&margin=%5Bobject%20Object%5D&name=image.png&originHeight=467&originWidth=719&originalType=binary&ratio=1&rotation=0&showTitle=false&size=25643&status=done&style=none&taskId=u39499c23-04b5-475d-8069-8c3d038c49d&title=&width=675)
      - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657586174732-29044663-bbfa-4a49-8ea8-c4614a144fc0.png#clientId=u7ad9d3e0-adc3-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=255&id=u6975d7fb&margin=%5Bobject%20Object%5D&name=image.png&originHeight=255&originWidth=259&originalType=binary&ratio=1&rotation=0&showTitle=false&size=4148&status=done&style=none&taskId=u67630f40-eddb-4623-8b6f-1b563bf1c35&title=&width=259)
      - 文件结构说明：通过本地文件存储结构，可以看到项目名称【1】spring只是一个虚拟的文件管理路径，模块【3】spring5是真实的文件路径。同时由于项目名称和模块名称不一致，所以IDEA自动创建了模块的本地存放路径【4】，【2】的直接子路径下也没有src目录。即如果采取【1】【3】同名的方式，则不会创建【4】路径，而是【4】=【2】，同时【2】的直接子路径下也会生成src目录。——原因为IDEA工具的项目、模块关系设计决定。
3. 导入jar包作为lib库
   - spring5下新建libs文件夹，作为本模块的依赖库
      - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657586679893-d156709e-61b7-48c0-81a7-384b483df8f1.png#clientId=u7ad9d3e0-adc3-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=81&id=ue980873e&margin=%5Bobject%20Object%5D&name=image.png&originHeight=81&originWidth=290&originalType=binary&ratio=1&rotation=0&showTitle=false&size=4152&status=done&style=none&taskId=u2cff0517-d8cd-44cb-9ad8-4b1a0f2c2f1&title=&width=290)
   - 将spring5的核心jar包拷贝至libs目录
      - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657586747768-f8178120-c044-426e-9586-175e36c41bd8.png#clientId=u7ad9d3e0-adc3-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=117&id=uac5ece34&margin=%5Bobject%20Object%5D&name=image.png&originHeight=117&originWidth=319&originalType=binary&ratio=1&rotation=0&showTitle=false&size=4702&status=done&style=none&taskId=ubf4af99d-2ef5-44ee-abdf-4be152abc09&title=&width=319)
      - 这里还引入了`commons-logging.jar`，这是一个apache的一个日志文件，spring5需要这个文件，下载引入即可。下载地址：
   - 将jar包作为【模块】依赖库——也可以作为项目依赖库，看具体需求
      - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657586898175-dab2b20d-a345-4401-bb03-2fe80bbcac5b.png#clientId=u7ad9d3e0-adc3-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=532&id=uf2a98629&margin=%5Bobject%20Object%5D&name=image.png&originHeight=532&originWidth=481&originalType=binary&ratio=1&rotation=0&showTitle=false&size=37376&status=done&style=none&taskId=ubfd71d89-4c7a-498d-a598-9afb8a6032a&title=&width=481)
      - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657586926066-c6f2e5be-c4cf-48eb-96ac-74da1a1cddfc.png#clientId=u7ad9d3e0-adc3-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=181&id=u6cd12a47&margin=%5Bobject%20Object%5D&name=image.png&originHeight=181&originWidth=394&originalType=binary&ratio=1&rotation=0&showTitle=false&size=9638&status=done&style=none&taskId=u3084fe3c-aee3-4e09-af60-22ab80aac11&title=&width=394)
      - 注意：这样添加的5个包会用一个名字。单独一个一个添加可以创建5个名字。

#### 1.2.2 基于maven构建

![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1659490576295-f6c74327-0bc9-4112-a5de-d2f4e48c98a1.png#clientId=u56ab9f1d-5868-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=492&id=u63f89f00&margin=%5Bobject%20Object%5D&name=image.png&originHeight=615&originWidth=721&originalType=binary&ratio=1&rotation=0&showTitle=false&size=113379&status=done&style=none&taskId=uc9bb9f76-dd93-4b79-9f0f-e934f8b330c&title=&width=576.8)
![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1659490612683-f6983e12-5c6c-40a1-9f8b-15312988164c.png#clientId=u56ab9f1d-5868-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=492&id=u62ed95cf&margin=%5Bobject%20Object%5D&name=image.png&originHeight=615&originWidth=721&originalType=binary&ratio=1&rotation=0&showTitle=false&size=22152&status=done&style=none&taskId=u1b3cdd8b-79fe-4820-a898-84b2a991037&title=&width=576.8)
引入依赖

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>iceriver.spring</groupId>
    <artifactId>maven-structre</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.source>8</maven.compiler.source>
        <maven.compiler.target>8</maven.compiler.target>
    </properties>
    <dependencies>
<!--        必须引入-->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>5.3.22</version>
        </dependency>
<!--        按需引入juint-->
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.11</version>
        </dependency>
    </dependencies>
</project>
```

![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1659491064409-bf13645f-aacd-4611-9975-1c49a37d2f99.png#clientId=u56ab9f1d-5868-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=124&id=u96fe3e03&margin=%5Bobject%20Object%5D&name=image.png&originHeight=155&originWidth=409&originalType=binary&ratio=1&rotation=0&showTitle=false&size=14986&status=done&style=none&taskId=u91ff3d7f-cfb1-4da4-870a-7eff6c3c347&title=&width=327.2)
基于配置文件时，配置文件写在resources路径下，名称任意。

### 1.3 体验spring创建对象

#### 1.3.1 使用配置文件方式

1. 编写类及方法【任意】。
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657587328473-59b61dec-ddf6-4111-a86b-ba07c6c615f6.png#clientId=u7ad9d3e0-adc3-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=236&id=ud3c6c6ce&margin=%5Bobject%20Object%5D&name=image.png&originHeight=236&originWidth=849&originalType=binary&ratio=1&rotation=0&showTitle=false&size=36932&status=done&style=none&taskId=ufcd36e06-9b42-4201-a039-44d8cedfed9&title=&width=849)
2. 创建配置文件（位置选择src目录，名字任意）：
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657587965497-207406c7-9a5d-4ebb-bdf9-2a228e5b51a6.png#clientId=u7ad9d3e0-adc3-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=481&id=u3ad79f58&margin=%5Bobject%20Object%5D&name=image.png&originHeight=481&originWidth=751&originalType=binary&ratio=1&rotation=0&showTitle=false&size=73812&status=done&style=none&taskId=u45e588e5-7071-41e1-8070-7d7320fafae&title=&width=751)
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657588009316-bc01c60a-20c8-42cc-b3f1-b8805dd9d919.png#clientId=u7ad9d3e0-adc3-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=153&id=u885b8d13&margin=%5Bobject%20Object%5D&name=image.png&originHeight=153&originWidth=607&originalType=binary&ratio=1&rotation=0&showTitle=false&size=30610&status=done&style=none&taskId=u89e42e60-de08-4ed2-91a8-2de8475be92&title=&width=607)
      - 这个id不是要创建的对象名字，而是通过这个id可以找到对应的类，相当于属性名。
3. 创建测试文件：

```java
package iceriver.spring;

/**
 * @author: INFINITY https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date: 2022/7/12 8:52
 */
public class User {
    private String name;
    private String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User() {
    }

    public void say(){
        System.out.println("lalalla");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
```

## 第2章 IoC及IoC操作

### 2.1 IoC简述

#### 2.1.1 IoC概念

1. 含义：控制反转
1. 作用：把对象创建和对象之间的调用过程，交给Spring进行管理
1. 目的：降低耦合度
1. 底层：xm解析、工厂模式、反射

#### 2.2.2 底层原理

1. 在xml文件中配置类的路径classPath
1. 使用类工厂创建对象
   - 解析xml，读取classPath
   - 使用classPath，利用反射机制`Class.forName(classPath)`获取类的对象
   - 使用`newInstance()`实例化对象

![](https://cdn.nlark.com/yuque/0/2022/png/1604140/1658023894211-a68093e0-917a-46f4-903d-945304f195b9.png#clientId=u4351ac9e-274f-4&crop=0&crop=0&crop=1&crop=1&from=paste&id=u355666bc&margin=%5Bobject%20Object%5D&originHeight=392&originWidth=1080&originalType=url&ratio=1&rotation=0&showTitle=false&status=done&style=none&taskId=u0d86aed7-7055-4ed4-9317-89db972d2c5&title=)

#### 2.2.3 IoC接口

1. IoC思想基于IoC容器，该容器的底层就是对象工厂
   - 容器：为某种特定组件的运行提供必要支持的软件环境
   - IoC容器：管理所有轻量级的JavaBean组件，提供生命周期管理、配置和组装服务、AOP支持、建立在AOP基础上的声明式事务等。
2. IoC容器的实现方式（接口）
   - `BeanFactory`接口：IOC的基本实现，Spring内部使用，不建议开发人员使用
      - 加载配置文件时不会创建，获取对象时采取创建
   - `AplicationContext`接口：`BeanFactory`的子接口，功能更强大，给开发人员使用
      - 加载配置文件时即创建对象
3. `ApplicationContext`的两个重要实现类：（取决于使用哪种方式加载xml配置文件）
>
> - IDEA中ctrl+h打开层次结构图

- ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657704999918-3ea251cd-a5e4-448f-b0f8-537d0ad5e02a.png#clientId=u5557f9b0-ca07-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=266&id=ucfb7e967&margin=%5Bobject%20Object%5D&name=image.png&originHeight=266&originWidth=594&originalType=binary&ratio=1&rotation=0&showTitle=false&size=43546&status=done&style=none&taskId=uf7a35c24-7245-47fb-811f-ef938a3a1cf&title=&width=594)
- `ClassPathXmApplicationContext`
- `FileSystemXmlApplicationContext`
- 基于注解的开发使用`AnnotationConfigApplicationContext`

4. `BeanFactory`：
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657705164789-99bbb5aa-b4eb-4828-b677-9e01e5a28ccc.png#clientId=u5557f9b0-ca07-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=411&id=u33204ab1&margin=%5Bobject%20Object%5D&name=image.png&originHeight=411&originWidth=619&originalType=binary&ratio=1&rotation=0&showTitle=false&size=66919&status=done&style=none&taskId=ucedf4a1c-ee9f-4fa2-97eb-c4a28650c9c&title=&width=619)

#### 2.2.4 Bean管理

1. Bean管理指：Spring创建对象、Spring注入属性
1. 操作方式：基于xml配置文件实现、基于注解方式实现

### 2.2 基于xml操作——Bean管理

#### 2.2.1 创建对象

1. xml文件中：使用`<bean>`标签，`id`指定该类的名字，`class`指向类的全路径
   - `<bean id="user" class="iceriver.spring.User"></bean>`
2. 要使用该对象的类中：加载类对象：
   - `BeanFactory context = new ClassPathXmlApplicationContext("iceriver.xml");`
   - 【建议】`ApplicationContext context = new ClassPathXmlApplicationContext("iceriver.xml");`
3. 要使用该对象的类中：创建对象（默认使用类的无参构造器）：
   - `User user = context.getBean("user", User.class);`
   - 没有无参构造器/无参构造器不可用时会报错。——xml文件找不到类

#### 2.2.2 注入属性

1. `DI`：依赖注入，即注入属性
1. 方式一：使用属性的setter
   - **【前提】：JavaBean的类中声明了对应属性的setter方法、同时无参构造器可用。**
   - xml文件中配置`<bean>`标签的子标签`<property>`
      - `name`表示给哪个属性赋值
      - `value`表示该属性的注入的值
      - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657803988358-7bcd1625-9819-4888-9636-1cd5b4870f54.png#clientId=u045da19a-733e-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=86&id=u33317c92&margin=%5Bobject%20Object%5D&name=image.png&originHeight=86&originWidth=436&originalType=binary&ratio=1&rotation=0&showTitle=false&size=12985&status=done&style=none&taskId=ue0b157da-0f03-4107-b384-2ff87afdc04&title=&width=436)
      - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657803994706-42275894-d215-40ac-af09-1a2ef2aa36ed.png#clientId=u045da19a-733e-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=40&id=u8042f1dc&margin=%5Bobject%20Object%5D&name=image.png&originHeight=40&originWidth=310&originalType=binary&ratio=1&rotation=0&showTitle=false&size=6863&status=done&style=none&taskId=u4969947d-0a1b-405c-9230-71dffc743b0&title=&width=310)
      - `name`是`<poperty>`的必需属性，`value`属性可以作为`<property>`的子标签设置
      - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657843762710-1c62ae1c-4b2c-4a08-b285-891102daec56.png#clientId=u045da19a-733e-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=133&id=uf1618f5e&margin=%5Bobject%20Object%5D&name=image.png&originHeight=133&originWidth=446&originalType=binary&ratio=1&rotation=0&showTitle=false&size=15728&status=done&style=none&taskId=udf9a39f9-2a7d-464d-925f-b7c662210e7&title=&width=446)

- 方式二：使用带参构造器
  - 【前提】：JavaBean中有对应属性的构造器方法，同时也显式地声明**无参构造器，用于xml文件找到对应地类文件。**
  - xml文件中配置`<bean>`标签的子标签`<constructor-arg>`
    - `name`表示给哪个属性赋值；也可以使用索引形式，从0开始
    - `value`表示该属性的注入的值
    - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657804220136-91c30dc4-8c6f-4b85-bdd4-24a7a77046d4.png#clientId=u045da19a-733e-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=86&id=u2ff83144&margin=%5Bobject%20Object%5D&name=image.png&originHeight=86&originWidth=540&originalType=binary&ratio=1&rotation=0&showTitle=false&size=14068&status=done&style=none&taskId=ue11c1d82-ab80-47af-aea3-752234c9e1e&title=&width=540)

3. 方式三：p名称空间注入：对基于xml配置文件注入属性的优化
   - 配置`<beans>`标签的p名称空间：
      - `<beans xmlns:p="http://www.springframework.org/schema/p">`
   - 给`<bean>`标签添加属性：`<bean id="" class="" p:name1="" p:name2="">`
      - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657804422238-34608b4d-9d34-445e-94ca-38ac51663112.png#clientId=u045da19a-733e-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=23&id=u5a01761c&margin=%5Bobject%20Object%5D&name=image.png&originHeight=23&originWidth=683&originalType=binary&ratio=1&rotation=0&showTitle=false&size=6284&status=done&style=none&taskId=ucc452218-5530-452e-8aa6-d6af68fe9ad&title=&width=683)
4. xml注入其他类型的属性：
   - `null`值：
      - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657804616695-c8cff19d-fa02-4695-aa0d-da12dbbbe83e.png#clientId=u045da19a-733e-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=141&id=uadead285&margin=%5Bobject%20Object%5D&name=image.png&originHeight=141&originWidth=377&originalType=binary&ratio=1&rotation=0&showTitle=false&size=14499&status=done&style=none&taskId=u981085b1-33fb-45d8-a92a-b6c1066d06d&title=&width=377)
   - 特殊字符值`>、<`：
      - 使用转义字符：`&lt;`代表`<`，`&gt;`代表`>`
      - 将带`>、<`的文本写入至`CDATA`
         - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657843537367-f04a875a-65c6-4120-be1e-f5f559f0b52c.png#clientId=u045da19a-733e-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=176&id=uae1420eb&margin=%5Bobject%20Object%5D&name=image.png&originHeight=176&originWidth=373&originalType=binary&ratio=1&rotation=0&showTitle=false&size=17500&status=done&style=none&taskId=u3c8bd612-d4dc-46eb-94d2-c5b808cb4c9&title=&width=373)
         - 如果有回车符也会原样输出。
5. 注入属性——外部Bean
   - 原始方法：在service类中创建dao对象，使用dao对象调用其方法
   - 注入方式：在service类中，把dao当作私有化属性，并创建其setter，在xml文件中给service类进行注入属性配置。
      - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657845341320-00e3058e-87fc-4463-ae07-62a2f9ba9146.png#clientId=u045da19a-733e-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=94&id=u1121e493&margin=%5Bobject%20Object%5D&name=image.png&originHeight=94&originWidth=545&originalType=binary&ratio=1&rotation=0&showTitle=false&size=15417&status=done&style=none&taskId=u5fc936eb-cd5d-4b85-8b58-2ff2fe8f64a&title=&width=545)
6. 注入属性——内部Bean和级联赋值
   - 内部Bean：一个`<bean>`中嵌套了另一个`<bean>`
      - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657847972349-c1e2481d-5bbc-4e70-908c-8aeb8daad4a3.png#clientId=u045da19a-733e-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=194&id=eGIAf&margin=%5Bobject%20Object%5D&name=image.png&originHeight=194&originWidth=495&originalType=binary&ratio=1&rotation=0&showTitle=false&size=30669&status=done&style=none&taskId=u6ac159df-ac09-434a-ae46-806b1a41838&title=&width=495)
      - dept2是Dept的私有属性，dept3是Emp的私有属性。
   - 级联赋值：配置嵌套配置【上面的配置也是一种级联赋值】
      - 方式一：![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657848541793-0d9fd67b-eca1-41c1-906f-187788241c6e.png#clientId=u045da19a-733e-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=152&id=K8jEl&margin=%5Bobject%20Object%5D&name=image.png&originHeight=181&originWidth=431&originalType=binary&ratio=1&rotation=0&showTitle=false&size=28214&status=done&style=none&taskId=u47a26d7d-0c91-452e-aac7-8f83b0340a8&title=&width=362)
      - 方式二：![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657849114046-f130b8d8-e078-4ece-be99-8dac614b752c.png#clientId=u045da19a-733e-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=168&id=ua450e7c8&margin=%5Bobject%20Object%5D&name=image.png&originHeight=199&originWidth=528&originalType=binary&ratio=1&rotation=0&showTitle=false&size=34069&status=done&style=none&taskId=u0640a97c-7bed-4de7-90c8-42d600aceec&title=&width=446)
      - 方式二中，要使用`dept3.dept2`，还得给`Emp`类中的`Dept`属性类设置getter，否则会找不到。这样设置后，注释内容（安保部）会失效。
7. 注入数组、集合类属性：
   - 注入数组：
      - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657850736007-adf00640-8e5a-49f9-af5e-ac8acdb4b930.png#clientId=u045da19a-733e-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=160&id=u55ae6dd1&margin=%5Bobject%20Object%5D&name=image.png&originHeight=194&originWidth=529&originalType=binary&ratio=1&rotation=0&showTitle=false&size=19913&status=done&style=none&taskId=u4ba81719-fb58-489e-a69d-0dc1389a82c&title=&width=435)
   - 注入List集合：
      - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657851126547-36113e0b-b399-4fd6-97df-69c0b90175a1.png#clientId=u045da19a-733e-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=151&id=uaeb0755a&margin=%5Bobject%20Object%5D&name=image.png&originHeight=151&originWidth=247&originalType=binary&ratio=1&rotation=0&showTitle=false&size=10756&status=done&style=none&taskId=ub05bfd8b-74c3-4758-b447-2b73fb69b81&title=&width=247)
   - 注入Map类型集合：
      - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657851115630-8d6b44ef-b610-4491-bb8f-b07d254b6c06.png#clientId=u045da19a-733e-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=133&id=ub97ff9f9&margin=%5Bobject%20Object%5D&name=image.png&originHeight=133&originWidth=397&originalType=binary&ratio=1&rotation=0&showTitle=false&size=12482&status=done&style=none&taskId=u24051865-a9f6-4ad4-90b3-74a420c634e&title=&width=397)
   - 注入Set类型集合：
      - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657851206244-bd976f45-0ea8-4731-8739-9e580b3ad4d5.png#clientId=u045da19a-733e-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=132&id=ud924cf1f&margin=%5Bobject%20Object%5D&name=image.png&originHeight=132&originWidth=267&originalType=binary&ratio=1&rotation=0&showTitle=false&size=9948&status=done&style=none&taskId=u4f87c84c-68ac-41ed-b37c-4365f49b395&title=&width=267)
   - 注入指定类型【List】的集合：
      - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657853347337-bc4c3282-b535-448b-84a7-8965e4e5cf87.png#clientId=u045da19a-733e-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=297&id=u794785d8&margin=%5Bobject%20Object%5D&name=image.png&originHeight=397&originWidth=578&originalType=binary&ratio=1&rotation=0&showTitle=false&size=55872&status=done&style=none&taskId=u4ff69d62-a973-49cd-bb98-52ed48a382e&title=&width=432)
   - 注入指定类型【Map】的集合：
      - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657854908320-c151e9b3-4dff-47c7-9b40-93726821cf40.png#clientId=u045da19a-733e-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=298&id=u3a65794c&margin=%5Bobject%20Object%5D&name=image.png&originHeight=375&originWidth=577&originalType=binary&ratio=1&rotation=0&showTitle=false&size=45015&status=done&style=none&taskId=u53c48e9d-ee5e-4c89-a016-f947eac7668&title=&width=458)
   - 提取集合类型的属性注入：
      - 配置util空间：![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657854548854-b2202eca-d1d0-478d-9424-58aaf935112e.png#clientId=u045da19a-733e-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=111&id=u75a1bffd&margin=%5Bobject%20Object%5D&name=image.png&originHeight=111&originWidth=1064&originalType=binary&ratio=1&rotation=0&showTitle=false&size=26353&status=done&style=none&taskId=uc842ddf2-dea7-405a-b6c5-4aaa5ec027e&title=&width=1064)
      - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657855022241-dc69ad6a-da3e-43e4-87e2-600f48e7ac54.png#clientId=u045da19a-733e-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=451&id=u8f5bab2e&margin=%5Bobject%20Object%5D&name=image.png&originHeight=574&originWidth=636&originalType=binary&ratio=1&rotation=0&showTitle=false&size=78346&status=done&style=none&taskId=u0dccef1e-d463-495c-8c1d-e095f363a5e&title=&width=500)
   - 注意事项：注入数组、List集合、set集合的配置中，`<array>`、`<list>`、`<set>`三个标签可互换，其中，`<set>`标签包裹的`<value>`值如果有重复时，重复项只取一项。

#### 2.2.3 FactoryBean

1. Spring有两种`Bean`，一种是普通`Bean`，另一种是`FactoryBean`
   - 普通`Bean`：xml文件中class配置的是什么类，创建实例的时候就返回该类型
   - 工厂`Bean`（`FactoryBean`）：xml文件中class配置的类型，和创建实例时返回的类型可以不一致。
2. `FactoryBean`的使用：
   - 创建普通Bean时，让其实现`FactoryBean`接口。
   - `FactoryBean`使用泛型，指定需要创建实例时，返回的类型。
   - 在实现`FactoryBean`的`getObject()`方法中，将返回值类型指定为传入的泛型类
      - `getObject()`：通过一个对象交给ioc容器管理
      - `getObjectType()`：设置所提供对象的类型
      - `isSingleton()`：所提供的对象是否单例
   - 此时得到的类型不再是实现`FactoryBean`接口的类的类型，而是传给`FactoryBean`接口范型的类型（即`FactoryBean`方法返回的类型。获取实现`FactoryBean`接口的类对象会出错。

#### 2.2.4 Bean作用域

1. Spring中，默认情况下，创建的Bean实例默认是单实例——内存中只有一个实例对象
1. 设置多实例：
   - `<bean>`标签设置`scope`属性
      - `singleton`：单实例，默认值，加载xml配置文件时，即创建对象
      - `prototype`：多实例，调用`getBean()`时创建多实例对象
      - `request`：每次HTTP请求时创建实例
      - `session`：每个会话中创建实例

#### 2.2.5 Bean生命周期（共7步）

1. 通过构造器创建 bean 实例（无参数构造）
   - 读取配置文件，创建Class类对象
2. 为 bean 的属性设置值和对其他 bean 引用（调用 set 方法）
   - 读取配置文件，创建Class类对象
3. 把 bean 实例传递 bean 后置处理器的方法 `postProcess**Before**Initialization()`
   - 要求类实现`BeanPostProcessor`接口
   - 实现`BeanPostProcessor`接口的类的配置，会导致本配置文件中的所有类都添加后置处理器
4. 调用 bean 的初始化的方法（需要进行配置初始化的方法）
   - `<bean>`须配置属性`init-method = "initMethod()"`——方法名任意
5. 把 bean 实例传递 bean 后置处理器的方法 `postProcess**After**Initialization()`
5. bean 可以使用了（对象获取到了）
   - 通过Class对象创建实例对象完毕。
7. 当容器关闭时候，调用 bean 的销毁的方法（需要进行配置销毁的方法）
   - `<bean>`须配置属性`destory-method = "destoryMethod()"`——方法名任意
   - 类中显式调用`context.close()`——`context`是根据xml文件获得的Class类对象

#### 2.2.6 xml自动装配

1. 根据指定的装配规则（属性名称或属性类型），Spring自动将匹配的属性值进行注入
1. `<bean>`标签配置`autowrite`属性
   - `byName`：根据属性名注入，要求外部bean的id值，和要注入的类中的属性名称一样
   - `byType`：根据属性类型注入。

#### 2.2.7 使用配置文件装配

1. xml文件直接配置Druid连接池：
   - 添加druid连接池jar包
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657865726656-271c8655-9b93-4e47-8646-5264d883c0ed.png#clientId=ueb4d9d1f-daaf-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=127&id=uce6b9e34&margin=%5Bobject%20Object%5D&name=image.png&originHeight=127&originWidth=659&originalType=binary&ratio=1&rotation=0&showTitle=false&size=27357&status=done&style=none&taskId=u5716105f-a090-419d-bc6a-59bc4abbfe2&title=&width=659)
2. xml读取配置文件进行配置Druid连接池
   - 新建配置文件`jdbc.properties`
      - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657865908893-41bdc5dc-785d-4569-8e1e-e07ff1b1f1b6.png#clientId=ueb4d9d1f-daaf-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=85&id=u5e95c214&margin=%5Bobject%20Object%5D&name=image.png&originHeight=85&originWidth=379&originalType=binary&ratio=1&rotation=0&showTitle=false&size=13347&status=done&style=none&taskId=u44cdc985-6cfe-4289-8cca-26b24f60f1a&title=&width=379)
   - 引入名称空间：
      - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657866162982-c2b0801d-d21c-49c0-849e-20603eac00a4.png#clientId=ueb4d9d1f-daaf-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=109&id=uc141d691&margin=%5Bobject%20Object%5D&name=image.png&originHeight=109&originWidth=1134&originalType=binary&ratio=1&rotation=0&showTitle=false&size=25349&status=done&style=none&taskId=u641c49b6-18c2-4a7b-a98c-528a1fe0a01&title=&width=1134)
   - 引入配置文件
      - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657866236168-89937a54-f005-4242-9518-24c213100d71.png#clientId=ueb4d9d1f-daaf-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=45&id=u8a183297&margin=%5Bobject%20Object%5D&name=image.png&originHeight=45&originWidth=826&originalType=binary&ratio=1&rotation=0&showTitle=false&size=9970&status=done&style=none&taskId=ub3af7ddd-601a-4f4d-8593-0f854101cfa&title=&width=826)
   - 使用表达式：
      - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657866398333-4dc93e5c-045f-48c5-a6dd-bf314a738c30.png#clientId=ueb4d9d1f-daaf-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=134&id=u5dc2cd55&margin=%5Bobject%20Object%5D&name=image.png&originHeight=152&originWidth=656&originalType=binary&ratio=1&rotation=0&showTitle=false&size=29415&status=done&style=none&taskId=u027825dc-843c-47cf-905f-1a96517b37f&title=&width=579)
      - `{}`中的值要与`.properties`配置文件中的名称一致。

### 2.3 基于注解操作——Bean管理

#### 2.3.1 Spring中Bean管理的注解

1. `@Component`
1. `@Service`
1. `@Controller`
1. `@Repostory`

- 注意：上述四个注解作用一致，只是针对不同JavaBean进行语义化使用

#### 2.3.2 基于注解创建对象

1. 引入依赖`spring-aop-5.2.6.RELEASE`
1. 引入名称空间：
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657866162982-c2b0801d-d21c-49c0-849e-20603eac00a4.png#clientId=ueb4d9d1f-daaf-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=109&id=EucWR&margin=%5Bobject%20Object%5D&name=image.png&originHeight=109&originWidth=1134&originalType=binary&ratio=1&rotation=0&showTitle=false&size=25349&status=done&style=none&taskId=u641c49b6-18c2-4a7b-a98c-528a1fe0a01&title=&width=1134)
3. 开启组件扫描：
   - 方式一：逗号分隔多个包
      - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657869313494-926314e6-4c16-4f49-9927-793809fd030e.png#clientId=uc8368fdc-a6e8-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=24&id=u8b3684a3&margin=%5Bobject%20Object%5D&name=image.png&originHeight=24&originWidth=892&originalType=binary&ratio=1&rotation=0&showTitle=false&size=7231&status=done&style=none&taskId=uc5ba5e91-1dac-45a6-b3fb-f73aafd4a48&title=&width=892)
   - 方式二：扫描上级包
      - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657869345631-2b60a965-366c-4c0a-9f89-dac6ef4e22f5.png#clientId=uc8368fdc-a6e8-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=29&id=u50227659&margin=%5Bobject%20Object%5D&name=image.png&originHeight=29&originWidth=658&originalType=binary&ratio=1&rotation=0&showTitle=false&size=6710&status=done&style=none&taskId=u59a2405f-d2c5-4603-8fce-315d185a551&title=&width=658)
4. 配置注解：
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657870018787-0411d632-cd24-46e6-b870-ad1adebe2bd8.png#clientId=uc8368fdc-a6e8-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=50&id=u72764d68&margin=%5Bobject%20Object%5D&name=image.png&originHeight=62&originWidth=557&originalType=binary&ratio=1&rotation=0&showTitle=false&size=16355&status=done&style=none&taskId=u40a64346-5379-436c-9503-e366e59f988&title=&width=451)
5. 组件扫描配置
   - 设置扫描指定注解为`Controller`的类
      - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657871532541-0520417a-986f-4b12-9fd3-0b2315e2b6a9.png#clientId=uc8368fdc-a6e8-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=63&id=dEvnk&margin=%5Bobject%20Object%5D&name=image.png&originHeight=63&originWidth=833&originalType=binary&ratio=1&rotation=0&showTitle=false&size=18004&status=done&style=none&taskId=u955c6a0d-7813-4241-9f29-cc8a08b9b7c&title=&width=833)
   - 设置不扫描指定注解为`Controller`的类
      - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657871701067-1b01e878-9603-4f9e-8178-ca1693f60f56.png#clientId=uc8368fdc-a6e8-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=65&id=u4afd6a90&margin=%5Bobject%20Object%5D&name=image.png&originHeight=65&originWidth=836&originalType=binary&ratio=1&rotation=0&showTitle=false&size=18219&status=done&style=none&taskId=u260180b8-9fb2-4c61-8252-ef583cd5a85&title=&width=836)

#### 2.3.3 属性注入

1. `@Autowried`：根据属性类型自动装配
   - 在要注入的属性声明上面，添加`@Autowired`
   - 该属性的setter不是必须
2. `@Qualifier`：根据属性名进行注入，需要配合`@Autowired`使用
   - 适用于`@Autowried`查找到多个实现类的情况
   - 给被注入的类指定`value`值
      - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657872690337-ae387c2e-76f8-4529-b31e-ffa0a9243185.png#clientId=uc8368fdc-a6e8-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=45&id=u1e8274cf&margin=%5Bobject%20Object%5D&name=image.png&originHeight=45&originWidth=380&originalType=binary&ratio=1&rotation=0&showTitle=false&size=8210&status=done&style=none&taskId=u4940f9f7-eb4e-492e-bc60-38dd2eeeeb2&title=&width=380)
   - 在要注入的属性声明上面，添加`@Autowired`和`@Qualifier`，给`@Qualifier`配置`value`值
      - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657872867411-85c54bf1-30b5-4271-86f9-f80dcdede43b.png#clientId=uc8368fdc-a6e8-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=67&id=u744f47d1&margin=%5Bobject%20Object%5D&name=image.png&originHeight=67&originWidth=295&originalType=binary&ratio=1&rotation=0&showTitle=false&size=9560&status=done&style=none&taskId=u6c5d1a8b-ff53-4d00-bc11-0c6fb017c2d&title=&width=295)
3. `@Resource`：可以根据类型注入，也可以根据名称注入
   - 在要注入的属性声明上面，添加`@Resource`——根据类型注入
      - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657873155350-bfff3198-011f-4712-8e5c-efc50789f124.png#clientId=uc8368fdc-a6e8-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=43&id=uacd9e372&margin=%5Bobject%20Object%5D&name=image.png&originHeight=43&originWidth=210&originalType=binary&ratio=1&rotation=0&showTitle=false&size=4793&status=done&style=none&taskId=ubd863eba-88e7-412f-b7b5-47577b0f21e&title=&width=210)
   - 在要注入的属性声明上面，添加`@Resource`，并配置`name`属性值——根据类型注入
      - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657873239839-844909c1-afb7-4d25-b7ef-54467c954124.png#clientId=uc8368fdc-a6e8-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=45&id=u1279f323&margin=%5Bobject%20Object%5D&name=image.png&originHeight=45&originWidth=284&originalType=binary&ratio=1&rotation=0&showTitle=false&size=7317&status=done&style=none&taskId=uaf09c470-c907-40fd-bc9f-8399c302ad4&title=&width=284)
      - `@Resource`来源于`import javax.annotation.Resource;`，所以官方不推荐使用这个。
4. `@Value`：给普通属性注入值
   - 在要注入的属性声明上面，添加`@Value`
   - 使用`value`属性设置值
      - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657873412515-2bae1e15-d3c6-4430-a832-12631f148bcb.png#clientId=uc8368fdc-a6e8-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=41&id=u585283bb&margin=%5Bobject%20Object%5D&name=image.png&originHeight=41&originWidth=217&originalType=binary&ratio=1&rotation=0&showTitle=false&size=5492&status=done&style=none&taskId=u324842d7-b0c7-47ff-bf82-937dfe4489e&title=&width=217)

#### 2.3.4 完全注解开发

1. 创建配置类，替代xml配置文件
   - 类的名称任意
   - 使用`@Configuration`声明这是一个配置类
   - 使用`@ComponentScan(basePackages = {"iceriver.spring"})`指定扫描的基本路径
2. 使用`AnnotationConfigApplicationContext`加载配置类
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657873971292-77867767-5892-44e0-9ad0-d38c6efbca36.png#clientId=ua700fae1-c7b5-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=85&id=ub77e5459&margin=%5Bobject%20Object%5D&name=image.png&originHeight=85&originWidth=736&originalType=binary&ratio=1&rotation=0&showTitle=false&size=20219&status=done&style=none&taskId=ud964e43e-232a-438d-a884-1874021e338&title=&width=736)

## 第3章 Aop

### 3.1 Aop介绍

#### 3.1.1 Aop概念

1. `Aspect Oriented Programming`的缩写，意为面向切面编程。
1. 是一种通过预编译和运行期间动态代理实现程序功能统一维护的一种技术。
1. Aop是OOP的延续，也是函数式编程的一种衍生泛型。
1. Aop可以对业务逻辑的各个部分进行隔离，使业务逻辑各部分之间的耦合度降低，提高程序的可重用性，提高开发的效率。
   - 不修改源代码的情况下，在主干功能里面添加新功能。

#### 3.1.2 Aop底层原理

1. 底层使用了动态代理进行实现，有接口情况下，使用JDK实现动态代理；没有接口情况下，通过CGLIB动态代理。
1. JDK实现动态代理：创建接口实现类的代理对象，增强类的方法。
   - 通过`java.lang.reflect.Proxy`中的`newProxyInstance(ClassLoader loader,Class<?>[] interfaces,InvocationHandler h)`
      - loader - 定义代理类的类加载器
      - interfaces - 代理类要实现的接口列表
      - h - 指派方法调用的调用处理程序：可以使用匿名内部类，也可以创建要被代理的类的实现类。

```java
package iceriver.spring.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author: INFINITY https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date: 2022/7/16 7:58
 */
public class JDKProxy {
    public static void main(String[] args) {
        Class[] interfaces = {UserDao.class};
//        1. 方式一：第三个参数使用匿名内部类
//        Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces, new InvocationHandler() {
//            @Override
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                return null;
//            }
//        });
//      2. 方式二：第三个参数使用代理类
        UserDao userDao = new UserDaoImpl();
        UserDao dao = (UserDao) Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces, new UserDaoProxy(userDao));
        int result = dao.add(2, 3);
        System.out.println(result);
    }
}

/**
 * 创建代理对象
 */
class UserDaoProxy implements InvocationHandler{
//    增强原始类功能的代码
    private Object obj;

    public UserDaoProxy(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("方法之前执行……" + method.getName() + "，传递的参数：" + Arrays.toString(args));

        Object res = method.invoke(obj, args);

        System.out.println("方法之后执行" + obj);

        return res;
    }
}
```

3. CGLIB实现动态代理：创建当前类的子类代理对象，增强类的方法。

![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1658023931823-37583d97-e11b-47b3-9370-7da85fa3a055.png#clientId=u4351ac9e-274f-4&crop=0&crop=0&crop=1&crop=1&from=paste&id=u84f558a1&margin=%5Bobject%20Object%5D&name=image.png&originHeight=354&originWidth=720&originalType=url&ratio=1&rotation=0&showTitle=false&size=101006&status=done&style=none&taskId=ud588fa3e-b924-4295-a276-08f04ffbe69&title=)

#### 3.1.3 Aop术语

1. `Joinpoint`(连接点)：类中可以被增强的方法。
1. `Pointcut`(切入点)：实际真正被增强的方法。
1. `Advice`(通知/增强)：实际增强的逻辑部分。
   - 前置通知：`@Before`注解，被代理类的方法【切入点】执行之前执行
   - 后置通知：`AfterReturning`注解，返回结果后执行，后于最终通知
   - 异常通知：`@AfterThrowing`注解，有异常才执行
   - 最终通知：`@After`注解，即使有异常也执行
   - 环绕通知：`@Arround`注解，被代理类的方法【切入点】执行之前、之后都执行
   - 顺序：
      - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657955135197-4bd5fc97-4777-43b8-ba86-b7a7c4c1a030.png#clientId=u159e03e8-ae72-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=130&id=uacb38238&margin=%5Bobject%20Object%5D&name=image.png&originHeight=130&originWidth=128&originalType=binary&ratio=1&rotation=0&showTitle=false&size=4005&status=done&style=none&taskId=uc7721295-dd8e-48bc-8f1b-b3aabd61135&title=&width=128)【无异常】
      - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657955192777-1753df02-872c-4053-82fc-41370426bc01.png#clientId=u159e03e8-ae72-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=80&id=u03feb650&margin=%5Bobject%20Object%5D&name=image.png&originHeight=80&originWidth=134&originalType=binary&ratio=1&rotation=0&showTitle=false&size=3148&status=done&style=none&taskId=u580e5e1f-0ade-4ce2-8efa-6c46c4eb1ca&title=&width=134)【有异常】
4. `Aspect`(切面)：把**通知**应用到**切入点**的过程。
4. `Target`(目标对象)：代理的目标对象(要增强的类)
4. `Weaving`(织入)：把切面应用到目标对象来创建新的代理对象的过程。Spring采用动态代理织入，而AspectJ采用编译期织入和类装载期织入。
4. `Proxy(`代理)：一个类被AOP织入增强后，就产生一个结果代理类。
4. `Introduction`(引介)：引介是一种特殊的通知在不修改类代码的前提下，Introduction可以在运行期为类动态地添加一些方法或Field。

### 3.2 Aop操作

#### 3.2.1 操作方式

1. Spring框架一般都是基于AspectJ实现Aop操作
   - AspectJ是独立的Aop框架，与Spring框架配合使用。
2. 前置准备：
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657950783435-456db6be-a3f6-4217-8ede-dc8401ea732c.png#clientId=u159e03e8-ae72-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=351&id=uea83440d&margin=%5Bobject%20Object%5D&name=image.png&originHeight=351&originWidth=592&originalType=binary&ratio=1&rotation=0&showTitle=false&size=86158&status=done&style=none&taskId=u5333b299-3a9e-40ee-80f5-a788453d36c&title=&width=592)
3. 切入点表达式；
   - 作用：直到对哪个类的方法进行增强
   - 语法结构：`excution([权限修饰符][返回类型][类的全路径][方法名称][参数列表])`
      - 权限修饰符可以用`*`代替，表示任意类型修饰符
      - 返回类型可以省略
      - 对指定方法进行增强：`excution(* iceriver.spring.aop.User.add(..))`
      - 对类中所有方法进行增强：`excution(* iceriver.spring.aop.User.*(..))`
      - 对包下所有类、所有方法增强：`excution(* iceriver.spring.aop.*.*(..))`

#### 3.2.2 基于注解进行Aop操作——（AspectJ注解）

1. 创建被增强【被代理】类，在类中定义方法
1. 创建增强【代理】类，编写增强逻辑
3. 进行通知配置：
   - xml文件中，开启注解扫描：
      - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657952536141-b2f57698-203b-47f6-b904-c77cf3e9afe8.png#clientId=u159e03e8-ae72-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=263&id=u9a7f994b&margin=%5Bobject%20Object%5D&name=image.png&originHeight=263&originWidth=1111&originalType=binary&ratio=1&rotation=0&showTitle=false&size=50923&status=done&style=none&taskId=u20be26ae-5da4-4821-8637-bd32630d913&title=&width=1111)
   - 使用注解创建代理类和被代理类的对象【2.3.2】
      - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657952708077-5e3b68f0-486d-4d1d-b176-2caa70c88d6c.png#clientId=u159e03e8-ae72-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=41&id=u90d978af&margin=%5Bobject%20Object%5D&name=image.png&originHeight=41&originWidth=181&originalType=binary&ratio=1&rotation=0&showTitle=false&size=3516&status=done&style=none&taskId=u243b9e8b-9f88-4283-93c4-2ffbcfcfa46&title=&width=181)
      - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657952716547-c67eddcf-4bd8-497c-a28e-21c093dba42b.png#clientId=u159e03e8-ae72-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=43&id=uba4da77c&margin=%5Bobject%20Object%5D&name=image.png&originHeight=43&originWidth=219&originalType=binary&ratio=1&rotation=0&showTitle=false&size=4180&status=done&style=none&taskId=uef491a3e-5cbe-4cb2-a264-bf6c2c97147&title=&width=219)
   - 代理类添加`@Aspect`注解，生成代理对象
      - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657952846670-8c947fb2-e6ff-4cc0-a9af-eb1fe18dca78.png#clientId=u159e03e8-ae72-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=62&id=u2615e32e&margin=%5Bobject%20Object%5D&name=image.png&originHeight=62&originWidth=209&originalType=binary&ratio=1&rotation=0&showTitle=false&size=5071&status=done&style=none&taskId=ucb7ad2a4-40d4-4d1f-b05f-72f041a94b3&title=&width=209)
   - xml文件中，开启Aspect生成代理对象
      - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657952950045-95397cb6-fd5e-42f0-8604-ebc89a958726.png#clientId=u159e03e8-ae72-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=39&id=ub3eda57e&margin=%5Bobject%20Object%5D&name=image.png&originHeight=39&originWidth=269&originalType=binary&ratio=1&rotation=0&showTitle=false&size=7400&status=done&style=none&taskId=u5ce74c85-bdb3-432a-a716-917468e2a98&title=&width=269)
4. 配置不同类型的通知：
   - 在代理类中，根据不同的通知类型使用对应的注解，并用切入点表达式进行配置

```java
package iceriver.spring.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author: INFINITY https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date: 2022/7/16 14:15
 */
@Component
@Aspect
public class UserProxy {
    @Before(value = "execution(* iceriver.spring.annotation.User.add(..))")
    public void before(){//前置通知
        System.out.println("before");
    }
    @AfterReturning(value = "execution(* iceriver.spring.annotation.User.add(..))")
    public void afterReturning(){//后置通知
        System.out.println("afterReturning");
    }
    @After(value = "execution(* iceriver.spring.annotation.User.add(..))")
    public void after(){//最终通知
        System.out.println("after");
    }
    @AfterThrowing(value = "execution(* iceriver.spring.annotation.User.add(..))")
    public void afterThrowing(){//异常通知
        System.out.println("afterThrowing");
    }
    @Around(value = "execution(* iceriver.spring.annotation.User.add(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {//环绕通知
        System.out.println("around之前");
        proceedingJoinPoint.proceed();//被增强的方法执行，如果不写这句，则被代理的类中的方法、以及前置通知不会被执行
        System.out.println("around之后");
    }
}
```

- ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657954680757-146950a1-2543-4483-82e6-d405b522ff99.png#clientId=u159e03e8-ae72-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=127&id=ue5894d72&margin=%5Bobject%20Object%5D&name=image.png&originHeight=127&originWidth=152&originalType=binary&ratio=1&rotation=0&showTitle=false&size=4112&status=done&style=none&taskId=u11a55e10-9af6-4506-8025-06b4c9b4fdf&title=&width=152)

5. 重用切入点的定义：将不同通知类型的配置中，相同的切入点表达式进行抽取
   - 定义方法【方法名任意】，抽取相同切入点
      - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657955531148-bd49669a-352a-4c5a-87db-b2be3840410f.png#clientId=u159e03e8-ae72-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=118&id=u205669a0&margin=%5Bobject%20Object%5D&name=image.png&originHeight=118&originWidth=620&originalType=binary&ratio=1&rotation=0&showTitle=false&size=13428&status=done&style=none&taskId=u59095938-4236-4257-9e42-c30f115d01a&title=&width=620)
   - 调用方法，作为切入点使用
      - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657955577361-f2e0ca5e-f8ea-4c7e-802b-f7d54e389b1a.png#clientId=u159e03e8-ae72-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=88&id=udb644dda&margin=%5Bobject%20Object%5D&name=image.png&originHeight=88&originWidth=283&originalType=binary&ratio=1&rotation=0&showTitle=false&size=11686&status=done&style=none&taskId=u1bba45fd-b1d0-4362-a372-4a2141b5855&title=&width=283)
6. 被代理类有多个代理类，可以设置优先级
   - 被代理类使用`@Order()`注解，传入整数，设置优先级，值越小优先级越高。
   - 设置了的比不设置的高

#### 3.2.3 完全注解开发

1. 创建配置类，替代xml配置文件
   - 类的名称任意
   - 使用`@Configuration`声明这是一个配置类
   - 使用`@ComponentScan(basePackages = {"iceriver.spring"})`指定扫描的基本路径
   - 使用`@EnableAspectJAutoProxy(proxyTargetClass = true)`开启Aspect生成代理对象

#### 3.2.4 基于xml配置文件进行Aop操作

1. 创建被增强【被代理】类，在类中定义方法
1. 创建增强【代理】类，编写增强逻辑
1. 在xml文件中创建两个类对象
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657956329230-0c70859d-0d4f-4d62-b95f-4f467161179d.png#clientId=u159e03e8-ae72-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=68&id=u07c823f5&margin=%5Bobject%20Object%5D&name=image.png&originHeight=68&originWidth=520&originalType=binary&ratio=1&rotation=0&showTitle=false&size=14821&status=done&style=none&taskId=u53222a1b-7bcb-4277-9091-d187f75b1d1&title=&width=520)
4. 在xml文件中配置切入点。
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657956743056-fbc02b9a-7c34-4a7d-b8ff-4f831c36f90c.png#clientId=u159e03e8-ae72-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=262&id=u066fe86a&margin=%5Bobject%20Object%5D&name=image.png&originHeight=262&originWidth=701&originalType=binary&ratio=1&rotation=0&showTitle=false&size=53338&status=done&style=none&taskId=u632412a4-136b-4c2a-9d2c-27ad1eff9b8&title=&width=701)

## 第4章 Jdbc Template

### 4.1 Jdbc Template介绍

1. Spring框架对Jdbc进行了封装，简化数据库操作
1. 使用前提是添加了相关的依赖：
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657958620236-ecefef62-6f86-43e3-8dc7-1ce55f6fcc73.png#clientId=u159e03e8-ae72-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=108&id=u4c6f637e&margin=%5Bobject%20Object%5D&name=image.png&originHeight=108&originWidth=326&originalType=binary&ratio=1&rotation=0&showTitle=false&size=6357&status=done&style=none&taskId=u5ea589b9-034a-447b-a776-1fe76a1b8bd&title=&width=326)
3. xml中配置Druid：
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657959309840-a9688937-baf1-4bb3-83a0-5461710dc90f.png#clientId=u159e03e8-ae72-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=133&id=u97a58198&margin=%5Bobject%20Object%5D&name=image.png&originHeight=133&originWidth=743&originalType=binary&ratio=1&rotation=0&showTitle=false&size=28584&status=done&style=none&taskId=ub27d6642-86ef-47a0-8a31-6b68147bf33&title=&width=743)
4. 创建Jdbc Temlate对象并注入数据源信息，完成数据库连接
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657960032304-d99dbb72-6e39-4182-b940-6370919ac174.png#clientId=u159e03e8-ae72-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=241&id=u13f2050e&margin=%5Bobject%20Object%5D&name=image.png&originHeight=241&originWidth=779&originalType=binary&ratio=1&rotation=0&showTitle=false&size=51295&status=done&style=none&taskId=uf3b92221-2dad-4f8f-8d03-e1d5cb02ccc&title=&width=779)
5. 创建Service类、Dao类，在Dao类中注入Jdbc Template对象【Bean的创建对象也依赖注入】，完成持久层持有Jdbc

### 4.2 Jdbc Template对象的使用——操作数据库

```sql
CREATE DATABASE `user_db`;
use user_db;
CREATE table `t_book`(
  `user_id` int,
  `username` VARCHAR(100),
 `ustatus` VARCHAR(50));
```

#### 4.2.1 添加功能

- `update()`：
  - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657964863212-8828d05e-74f4-4687-afa9-d32d8f2b863f.png#clientId=ub6522ba0-2b56-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=27&id=u95af1eb0&margin=%5Bobject%20Object%5D&name=image.png&originHeight=27&originWidth=491&originalType=binary&ratio=1&rotation=0&showTitle=false&size=4894&status=done&style=none&taskId=u32cfdf7c-b0bb-4508-9bea-73e23e178c8&title=&width=491)

```java
public void add(Book book) {
    String sql = "insert into t_book values(?,?,?)";
    int update = jdbcTemplate.update(sql, book.getUserId(), book.getUserName(), book.getUstatus());
    System.out.println(update);
}
```

```java
@Test
void add() {
    ApplicationContext context = new ClassPathXmlApplicationContext("iceriver.xml");
    BookService bookService = context.getBean("bookService", BookService.class);
    Book book = new Book();
    book.setUserId(1);
    book.setUserName("java");
    book.setUstatus("a");
    bookService.addBook(book);
}
```

#### 4.2.2 修改功能

- `update()`
  - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657964863212-8828d05e-74f4-4687-afa9-d32d8f2b863f.png#clientId=ub6522ba0-2b56-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=27&id=IqPgj&margin=%5Bobject%20Object%5D&name=image.png&originHeight=27&originWidth=491&originalType=binary&ratio=1&rotation=0&showTitle=false&size=4894&status=done&style=none&taskId=u32cfdf7c-b0bb-4508-9bea-73e23e178c8&title=&width=491)

```java
public void update(Book book) {
    String sql = "update t_book set username=?,ustatus=? where user_id = ?";
    int update = jdbcTemplate.update(sql, book.getUserName(), book.getUstatus(),book.getUserId());
    System.out.println(update);
}
```

```java
@Test
void update() {
    ApplicationContext context = new ClassPathXmlApplicationContext("iceriver.xml");
    BookService bookService = context.getBean("bookService", BookService.class);
    Book book = new Book();
    book.setUserId(1);
    book.setUserName("java");
    book.setUstatus("b");
    bookService.updateBook(book);
}
```

#### 4.2.3 删除功能

- `update()`
  - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657964863212-8828d05e-74f4-4687-afa9-d32d8f2b863f.png#clientId=ub6522ba0-2b56-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=27&id=p2LLx&margin=%5Bobject%20Object%5D&name=image.png&originHeight=27&originWidth=491&originalType=binary&ratio=1&rotation=0&showTitle=false&size=4894&status=done&style=none&taskId=u32cfdf7c-b0bb-4508-9bea-73e23e178c8&title=&width=491)

```java
public void delete(Integer id) {
    String sql = "delete from t_book where user_id=?";
    int update = jdbcTemplate.update(sql, id);
    System.out.println(update);
}
```

```java
@Test
void delete() {
    ApplicationContext context = new ClassPathXmlApplicationContext("iceriver.xml");
    BookService bookService = context.getBean("bookService", BookService.class);
    bookService.deleteBook(1);
}
```

#### 4.2.4 查询功能

1. 查询返回某个值：
   - `queryForObject(sql, 返回值类型.class)`
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657964960968-b9cab6c3-80c8-4dc5-8b6e-7f818b246286.png#clientId=ub6522ba0-2b56-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=24&id=u4673291d&margin=%5Bobject%20Object%5D&name=image.png&originHeight=24&originWidth=491&originalType=binary&ratio=1&rotation=0&showTitle=false&size=6037&status=done&style=none&taskId=u21f8c0c6-feac-44eb-a516-cecf58b0479&title=&width=491)

```java
public int findCount() {
    String sql = "select count(*) from t_book ";
    int count = jdbcTemplate.queryForObject(sql, Integer.class);
    System.out.println(count);
    return count;
}
```

```java
@Test
void findCount() {
    ApplicationContext context = new ClassPathXmlApplicationContext("iceriver.xml");
    BookService bookService = context.getBean("bookService", BookService.class);
    bookService.findCount();
}
```

2. 查询返回对象：
   - `queryForObject(sql, new BeanPropertyRowMapper<>(Book.class), id);`
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657964985563-c254d4c4-0916-4c69-8485-e16a444d3a94.png#clientId=ub6522ba0-2b56-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=22&id=u8830a2ab&margin=%5Bobject%20Object%5D&name=image.png&originHeight=22&originWidth=500&originalType=binary&ratio=1&rotation=0&showTitle=false&size=6085&status=done&style=none&taskId=u427cf121-fe5b-4eb3-9e66-f2faf509266&title=&width=500)
   - 根据id查询一条数据

```java
public Book findOne(Integer id) {
    String sql = "select * from t_book where user_id = ?";
    Book book = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Book.class), id);
    System.out.println(book);
    return book;
}
```

```java
@Test
void findOne() {
    ApplicationContext context = new ClassPathXmlApplicationContext("iceriver.xml");
    BookService bookService = context.getBean("bookService", BookService.class);
    bookService.findOne(500);
}
```

3. 查询返回对象集合：
   - `query(sql, new BeanPropertyRowMapper<>(Book.class));`
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657965023098-bfbbcda9-08da-4f4a-8c17-f33369a6147a.png#clientId=ub6522ba0-2b56-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=20&id=u322eb9d6&margin=%5Bobject%20Object%5D&name=image.png&originHeight=20&originWidth=486&originalType=binary&ratio=1&rotation=0&showTitle=false&size=5379&status=done&style=none&taskId=u9aeff8c3-c06c-4b33-ac38-618ab22ae8b&title=&width=486)
   - 可以传入第三个参数，也可以没有。

```java
public List<Book> findAll() {
    String sql = "select * from t_book";
    List<Book> bookList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Book.class));
    System.out.println(bookList);
    return bookList;
}
```

```java
@Test
void findAll() {
    ApplicationContext context = new ClassPathXmlApplicationContext("iceriver.xml");
    BookService bookService = context.getBean("bookService", BookService.class);
    bookService.findAll();
}
```

### 4.3 Jdbc Template批量操作数据库

![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657965081400-9f5fcbe4-df3c-4a9d-a03d-3277e2f0c9a4.png#clientId=ub6522ba0-2b56-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=21&id=ubaac011e&margin=%5Bobject%20Object%5D&name=image.png&originHeight=21&originWidth=493&originalType=binary&ratio=1&rotation=0&showTitle=false&size=5979&status=done&style=none&taskId=u64dbd931-1f66-4b21-98b8-69d3a1c5f02&title=&width=493)

#### 4.3.1 批量添加

```java
public void batchAdd(List<Object[]> batchArgs) {
    String sql = "insert into t_book values(?,?,?)";
    int[] add = jdbcTemplate.batchUpdate(sql, batchArgs);
    System.out.println(Arrays.toString(add));
}
```

```java
@Test
void batchAdd() {
    ApplicationContext context = new ClassPathXmlApplicationContext("iceriver.xml");
    BookService bookService = context.getBean("bookService", BookService.class);
    List<Object[]> batchArgs = new ArrayList<>();
    Object[] book1 = {3, "java", "a"};
    Object[] book2 = {4, "java", "a"};
    Object[] book3 = {5, "java", "a"};
    batchArgs.add(book1);
    batchArgs.add(book2);
    batchArgs.add(book3);
    bookService.batchAdd(batchArgs);
}
```

#### 4.3.2 批量修改

```java
public void batchUpdate(List<Object[]> batchArgs) {
    String sql = "update t_book set username=?,ustatus=? where user_id = ?";
    int[] update = jdbcTemplate.batchUpdate(sql, batchArgs);
    System.out.println(Arrays.toString(update));
}
```

```java
@Test
void batchUpdate() {
    ApplicationContext context = new ClassPathXmlApplicationContext("iceriver.xml");
    BookService bookService = context.getBean("bookService", BookService.class);
    List<Object[]> batchArgs = new ArrayList<>();
    Object[] book1 = {"前端", "a",3};
    Object[] book2 = {"mysql", "a",4};
    Object[] book3 = {"web", "a",5};
    batchArgs.add(book1);
    batchArgs.add(book2);
    batchArgs.add(book3);
    bookService.batchUpdate(batchArgs);
}
```

#### 4.3.3 批量删除

```java
public void batchDelete(List<Object[]> batchArgs) {
    String sql = "delete from t_book where user_id=?";
    int[] add = jdbcTemplate.batchUpdate(sql, batchArgs);
    System.out.println(Arrays.toString(add));
}
```

```java
@Test
void batchDelete() {
    ApplicationContext context = new ClassPathXmlApplicationContext("iceriver.xml");
    BookService bookService = context.getBean("bookService", BookService.class);
    List<Object[]> batchArgs = new ArrayList<>();
    Object[] book1 = {3};
    Object[] book2 = {4};
    Object[] book3 = {5};
    batchArgs.add(book1);
    batchArgs.add(book2);
    batchArgs.add(book3);
    bookService.batchDelete(batchArgs);
}
```

### 4.4 事务操作

```sql
use user_db;

CREATE table `t_accout`(
  `id` VARCHAR(20),
  username VARCHAR(100),
  money double);
 
```

![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1658020939343-88e3ed2a-5553-4993-b493-2052f3ce3982.png#clientId=u4351ac9e-274f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=81&id=u8940aac5&margin=%5Bobject%20Object%5D&name=image.png&originHeight=81&originWidth=300&originalType=binary&ratio=1&rotation=0&showTitle=false&size=3297&status=done&style=none&taskId=ub53c824f-cc87-4ac4-979d-010d8d92002&title=&width=300)

#### 4.4.1 声明式事务管理

1. Spring中事务管理分为两种方式：编程式、声明式。
1. 声明式事务管理有两种操作方式：基于注解、xml文件配置。
1. 声明式事务管理底层Aop原理。
1. Sping中进行事务管理的类——事务管理器：
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1658022350214-ca5f92c1-81c6-4644-a3e5-5818aa9b6b2a.png#clientId=u4351ac9e-274f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=138&id=u96a18278&margin=%5Bobject%20Object%5D&name=image.png&originHeight=138&originWidth=614&originalType=binary&ratio=1&rotation=0&showTitle=false&size=23181&status=done&style=none&taskId=u656245a7-7645-4349-bcf0-0d1f46b791b&title=&width=614)

#### 4.4.2 注解声明式事务管理

1. 在xml文件中，引入名称空间tx
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1658022802588-defbbedd-4890-4cbe-88c0-1b044b3c4556.png#clientId=u4351ac9e-274f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=158&id=u95bb82e9&margin=%5Bobject%20Object%5D&name=image.png&originHeight=158&originWidth=1107&originalType=binary&ratio=1&rotation=0&showTitle=false&size=34490&status=done&style=none&taskId=uf1fd8f47-e47c-4441-bad8-98b14676f20&title=&width=1107)
2. 在创建事务管理器：
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1658022561859-1d5f35a3-6c61-43d7-b047-839df40d37de.png#clientId=u4351ac9e-274f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=105&id=ueaa6bcd0&margin=%5Bobject%20Object%5D&name=image.png&originHeight=105&originWidth=828&originalType=binary&ratio=1&rotation=0&showTitle=false&size=17461&status=done&style=none&taskId=ud3e47b07-5523-4c1d-8f04-5763d1968e3&title=&width=828)
3. 在xml文件中开启事务注解驱动
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1658022895725-31bd4f05-dcae-4b39-8626-fd42a565105b.png#clientId=u4351ac9e-274f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=152&id=u917acb4f&margin=%5Bobject%20Object%5D&name=image.png&originHeight=152&originWidth=850&originalType=binary&ratio=1&rotation=0&showTitle=false&size=29787&status=done&style=none&taskId=u218f1e69-29d7-4c13-ae98-f6d445454df&title=&width=850)
   -

4. 在业务逻辑类【Service类】添加`@Transactional`
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1658022963213-fad89d2a-b3bb-4bf6-b0c9-dfca00b4b413.png#clientId=u4351ac9e-274f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=63&id=u9a24712b&margin=%5Bobject%20Object%5D&name=image.png&originHeight=63&originWidth=222&originalType=binary&ratio=1&rotation=0&showTitle=false&size=5573&status=done&style=none&taskId=u0fa9dda6-5dc1-4722-95b9-40707165d37&title=&width=222)
   - `@Transactional`可以添加在类上面：表示该类中所有方法都添加事务。
   - `@Transactional`可以添加到方法上面：表示给该方法添加事务。

#### 4.4.3 注解声明式事务管理配置参数![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1658023362591-6a07a61b-c65e-4f57-811d-225455b46a42.png#clientId=u4351ac9e-274f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=218&id=u8caecf36&margin=%5Bobject%20Object%5D&name=image.png&originHeight=218&originWidth=614&originalType=binary&ratio=1&rotation=0&showTitle=false&size=20116&status=done&style=none&taskId=ud78c1395-e51c-4e4d-aa65-e3fa7d3b8eb&title=&width=614)

1. `propagation`：事务传播行为，
   - 事务传播行为是为了解决业务层方法之间互相调用的事务问题。
   - 当事务方法被另一个事务方法调用、或调用其他事务方法时，必须指定事务应该如何传播。——是否开启新事务，新事务如何运行。
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1658027637153-33bf0ac7-c148-4911-bd37-f52c11766a25.png#clientId=u4351ac9e-274f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=627&id=u22b4499e&margin=%5Bobject%20Object%5D&name=image.png&originHeight=627&originWidth=1081&originalType=binary&ratio=1&rotation=0&showTitle=false&size=428149&status=done&style=none&taskId=ub7f5b580-36cc-4acd-824f-74300356202&title=&width=1081)
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1658028373615-2843c66b-401f-4acb-a8ae-b87aa481e2ac.png#clientId=u4351ac9e-274f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=45&id=uc91dde5d&margin=%5Bobject%20Object%5D&name=image.png&originHeight=45&originWidth=415&originalType=binary&ratio=1&rotation=0&showTitle=false&size=8702&status=done&style=none&taskId=u24d5d31c-8fa7-4876-b913-5f2d834d239&title=&width=415)
2. `isolation`：事务隔离级别【默认可重复读】
   - 脏读：一个未提交的事务读取到另一个未提交事务的数据
   - 不可重复读：一个未提交事务读取到另一个提交事务修改的数据。
   - 幻读：一个未提交事务读取到拎一个提交事务添加的数据。
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1658027681856-8839ec98-a0e5-4a03-bf4a-8fbce06f7e4e.png#clientId=u4351ac9e-274f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=193&id=u997909b6&margin=%5Bobject%20Object%5D&name=image.png&originHeight=262&originWidth=543&originalType=binary&ratio=1&rotation=0&showTitle=false&size=53822&status=done&style=none&taskId=u7aff5626-6520-4989-b43e-0ed5c91d202&title=&width=401)
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1658028413998-9069bd0d-146f-4c1c-b6fc-36177792ed05.png#clientId=u4351ac9e-274f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=39&id=uc2c82614&margin=%5Bobject%20Object%5D&name=image.png&originHeight=39&originWidth=709&originalType=binary&ratio=1&rotation=0&showTitle=false&size=10574&status=done&style=none&taskId=u4b74513c-2a54-4396-b336-70fba33e449&title=&width=709)
3. `timeout`：超时时间，规定事务在一定的时间内进行提交，如果未提交就进行回滚，默认为-1，表示不超时。
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1658028483586-e82edcc2-8b2a-4801-80d1-21dfe2e85023.png#clientId=u4351ac9e-274f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=60&id=u8e46bd07&margin=%5Bobject%20Object%5D&name=image.png&originHeight=60&originWidth=707&originalType=binary&ratio=1&rotation=0&showTitle=false&size=11900&status=done&style=none&taskId=u4240fe56-22a0-4730-9b52-22466fe6b1c&title=&width=707)
4. `readOnly`：是否只读，默认值false，表示可以进行CRUD，设置为true时，只能进行查询。
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1658028552854-1e7eab25-49b3-4528-8da6-69ebbf5edfca.png#clientId=u4351ac9e-274f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=63&id=uc21d4dbb&margin=%5Bobject%20Object%5D&name=image.png&originHeight=63&originWidth=716&originalType=binary&ratio=1&rotation=0&showTitle=false&size=13723&status=done&style=none&taskId=ue0a57d20-5233-44d6-b26b-60f1a01c1e3&title=&width=716)
5. `rollbackFor`：回滚，设置出现哪些异常进行回滚
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1658028656991-3ceb1127-617b-44f4-b2cb-b54e7dd850d5.png#clientId=u4351ac9e-274f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=66&id=u45487863&margin=%5Bobject%20Object%5D&name=image.png&originHeight=66&originWidth=711&originalType=binary&ratio=1&rotation=0&showTitle=false&size=16946&status=done&style=none&taskId=u445f4b18-aaaf-453c-81e1-10e1c823b3a&title=&width=711)
6. `noRollbackFor`：不回滚，设置出现哪些异常不进行回滚
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1658028679340-e959e33b-d57d-43b5-9e8f-c14a5ffbdc63.png#clientId=u4351ac9e-274f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=82&id=uf2f8e262&margin=%5Bobject%20Object%5D&name=image.png&originHeight=82&originWidth=712&originalType=binary&ratio=1&rotation=0&showTitle=false&size=20999&status=done&style=none&taskId=u365b4693-1143-4f50-a168-2d7c7279692&title=&width=712)

#### 4.4.4 xml声明式事务管理

1. 配置事务管理器
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1658030100771-0863f2ef-2601-46f1-aee4-1453dcc1a013.png#clientId=u4351ac9e-274f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=350&id=u3054179c&margin=%5Bobject%20Object%5D&name=image.png&originHeight=350&originWidth=827&originalType=binary&ratio=1&rotation=0&showTitle=false&size=74197&status=done&style=none&taskId=u0eafe2d7-159d-47e4-87ef-d5bbd4c2c06&title=&width=827)
2. 配置通知
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1658030134191-ed6130cd-6112-4667-973c-1f9f4f69bf01.png#clientId=u4351ac9e-274f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=196&id=u896ebc0a&margin=%5Bobject%20Object%5D&name=image.png&originHeight=196&originWidth=820&originalType=binary&ratio=1&rotation=0&showTitle=false&size=33534&status=done&style=none&taskId=u7e5f098e-77b5-4c0d-b1dd-6f4047701cd&title=&width=820)
3. 配置切入点和切面
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1658030175134-d1e9c30d-9e1e-4d5b-9982-363c621dfebf.png#clientId=u4351ac9e-274f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=349&id=u3e770f3b&margin=%5Bobject%20Object%5D&name=image.png&originHeight=349&originWidth=833&originalType=binary&ratio=1&rotation=0&showTitle=false&size=64717&status=done&style=none&taskId=u3e46a8b9-7b3c-4050-8d38-7f54adbef2b&title=&width=833)

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:tx="http://www.springframework.org/schema/tx" xmlns:aop="http://www.springframework.org/schema/aop"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
                           http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd
                           http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx.xsd http://www.springframework.org/schema/aop https://www.springframework.org/schema/aop/spring-aop.xsd"
       >
  
  <context:component-scan base-package="iceriver.spring"/>
  
  <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource" destroy-method="close">
    <property name="url" value="jdbc:mysql://localhost:13306/user_db" />
    <property name="username" value="root" />
    <property name="password" value="dimitre123" />
    <property name="driverClassName" value="com.mysql.jdbc.Driver" />
  </bean>
  <!--    创建jdbc template对象-->
  <bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
    <!--    注入dataSource —— 使用setter注入-->
    <property name="dataSource" ref="dataSource"/>
  </bean>
  <!--    1. 创建事务管理器-->
  <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
    <!--        注入数据源-->
    <property name="dataSource" ref="dataSource"/>
  </bean>
  <!--    2. 配置通知-->
  <tx:advice id="txadvice">
    <!--        配置事务参数-->
    <tx:attributes>
      <!--            指定哪种规则上面添加事务-->
      <tx:method name="accoutMoney"/>
      <!--            <tx:method name="accout*"/>&lt;!&ndash;            给前缀是accout的所有方法添加&ndash;&gt;-->
    </tx:attributes>
  </tx:advice>
  <!--    3. 配置切入点和切面-->
  <aop:config>
    <!--        配置切入点-->
    <aop:pointcut id="pt" expression="execution(* iceriver.spring.service.UserService.*(..))"/>
    <!--            配置切面-->
    <aop:advisor advice-ref="txadvice" pointcut-ref="pt"/>
  </aop:config>
</beans>
```

### 4.5 完全注解开发

![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1658031787274-bdc0f5a4-efba-4a1f-bc3e-48282df0b251.png#clientId=u4351ac9e-274f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=1032&id=uca0e85b3&margin=%5Bobject%20Object%5D&name=image.png&originHeight=1032&originWidth=1920&originalType=binary&ratio=1&rotation=0&showTitle=false&size=358636&status=done&style=none&taskId=u0c9c357b-7f72-4028-9645-5a2a8c58d08&title=&width=1920)

```java
package iceriver.spring.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
* @author: INFINITY https://developer.aliyun.com/profile/sagwrxp2ua66w
* @date: 2022/7/17 12:02
*/
@Configuration//1. 声明这是一个配置类
@ComponentScan(basePackages = "iceriver.spring")//2. 开启组件扫描
@EnableTransactionManagement//3. 声明开启事务
public class TxConfig {
    //    4. 创建数据库连接池
    @Bean
    public DruidDataSource getDruidDatasource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:13306/user_db");
        dataSource.setUsername("root");
        dataSource.setPassword("dimitre123");
        return dataSource;
    }
    
    //    4. 创建jadbc Template对象
    @Bean
    public JdbcTemplate getJdbcTemplate(DataSource dataSource){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        //        jdbcTemplate.setDataSource(getDruidDatasource());//注入dataSource，但这种方式会执行两次getDruidDatasource
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }
    //    6. 创建事务管理器对象
    @Bean
    public DataSourceTransactionManager getDataSourceTransactionManager(DataSource dataSource){
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource);
        return transactionManager;
    }
}
```

## 第5章 Spring5 新功能

### 5.0 新功能介绍

1. 整个 Spring5 框架的代码基于 Java8，运行时兼容 JDK9， 许多不建议使用的类和方法在代码库中删除。
1. Spring5框架自带了通用的日志封装，但也可以整合其他日志框架。
   - Spring框架不支持Log4j，因为移除了Log4jConfigListener，官方推荐使用Log4j2。

### 5.1 整合Log4j2日志框架

1. 引入jar包
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1658038769792-bb01f670-51cc-43dd-a193-c040e311d7d8.png#clientId=u4351ac9e-274f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=83&id=u37532490&margin=%5Bobject%20Object%5D&name=image.png&originHeight=83&originWidth=240&originalType=binary&ratio=1&rotation=0&showTitle=false&size=2923&status=done&style=none&taskId=u40e45739-4eae-44b2-9eab-0762ba750de&title=&width=240)
2. 创建`log4j2.xml`配置文件——该文件名固定

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!--日志级别以及优先级排序: OFF < FATAL < ERROR < WARN < INFO < DEBUG < TRACE < ALL -->
<!--Configuration后面的status用于设置log4j2自身内部的信息输出，可以不设置，当设置成trace时，可以看到log4j2内部各种详细输出-->
<configuration status="INFO">
    <!--先定义所有的appender-->
    <appenders>
        <!--输出日志信息到控制台-->
        <console name="Console" target="SYSTEM_OUT">
            <!--控制日志输出的格式-->
            <PatternLayout pattern="%d{yyyy-MM-dd HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n"/>
        </console>
    </appenders>
    <!--然后定义logger，只有定义了logger并引入的appender，appender才会生效-->
    <!--root：用于指定项目的根日志，如果没有单独指定Logger，则会使用root作为默认的日志输出-->
    <loggers>
        <root level="info">
            <appender-ref ref="Console"/>
        </root>
    </loggers>
</configuration>
```

- 整合日志框架前：
  - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1658039149893-f7a63213-cd3f-4849-9010-09b172d641d7.png#clientId=u4351ac9e-274f-4&crop=0&crop=0&crop=1&crop=1&from=paste&id=u00709af9&margin=%5Bobject%20Object%5D&name=image.png&originHeight=110&originWidth=762&originalType=url&ratio=1&rotation=0&showTitle=false&size=11469&status=done&style=none&taskId=u85e7568c-9b51-4c8d-a03b-d8734dec3ab&title=)
- 整合日志框架后：
  - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1658039160611-af6c9260-1e0a-4ddc-8749-8c02556f075c.png#clientId=u4351ac9e-274f-4&crop=0&crop=0&crop=1&crop=1&from=paste&id=u4c3b325d&margin=%5Bobject%20Object%5D&name=image.png&originHeight=83&originWidth=800&originalType=url&ratio=1&rotation=0&showTitle=false&size=9467&status=done&style=none&taskId=u610d4e1e-7af1-4614-ad2d-cb9fd152e5c&title=)

3. 手动输入日志内容至控制台：
   - 创建日志类：
      - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1658039409935-eacba2d2-9918-4ea3-92ac-ce42ac4c1404.png#clientId=u4351ac9e-274f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=100&id=u79efef71&margin=%5Bobject%20Object%5D&name=image.png&originHeight=100&originWidth=233&originalType=binary&ratio=1&rotation=0&showTitle=false&size=3444&status=done&style=none&taskId=u39e836a5-5fc2-4510-b789-4c37604dfab&title=&width=233)
   - 导入`import org.slf4j.Logger;`和`import org.slf4j.LoggerFactory;`
   - 创建log对象：`Logger _log _= LoggerFactory._getLogger_(UserLog.class);`
   - 调用相关的方法：`info(str)`、`warn(str)`等

### 5.2 核心容器支持`@Nullable`注解

1. `@Nullable` 注解可以使用在方法上面，属性上面，参数上面，表示方法返回可以为空，属性值可以为空，参数值可以为空。

### 5.3 核心容器支持函数式风格（GenericApplicationContext)

1. 程序员手动创建的对象交给Spring管理；
1. 使用方式：
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1658041145592-9bd24a10-0c9b-43e0-becf-3cc457732367.png#clientId=u4351ac9e-274f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=258&id=ub224703d&margin=%5Bobject%20Object%5D&name=image.png&originHeight=258&originWidth=591&originalType=binary&ratio=1&rotation=0&showTitle=false&size=47618&status=done&style=none&taskId=u0471cf84-c9e2-48fd-8e3b-342597d3435&title=&width=591)

### 5.4 整合JUnit4

1. 引入`spring-test-5.2.6.RELEASE.jar`依赖【当然还有junit4，以及hamcrest-core-1.3对junit4进行增强】
1. 使用注解创建测试类：
   - 使用注解后，便可通过注入属性的方式创建测试类的对象
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1658041215447-3082b35a-d0ab-441e-8126-a63361a47023.png#clientId=u4351ac9e-274f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=218&id=ub84278e4&margin=%5Bobject%20Object%5D&name=image.png&originHeight=218&originWidth=484&originalType=binary&ratio=1&rotation=0&showTitle=false&size=29385&status=done&style=none&taskId=u5b36c00b-d21d-475d-bfe8-b263b339af4&title=&width=484)

### 5.5 整合JUnit5

1. 引入`spring-test-5.2.6.RELEASE.jar`依赖【当然还有junit5】
1. 使用注解创建测试类：
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1658041461584-0745d31f-5545-48c4-9d7c-1a1796181d19.png#clientId=u4351ac9e-274f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=226&id=uc126b33c&margin=%5Bobject%20Object%5D&name=image.png&originHeight=226&originWidth=458&originalType=binary&ratio=1&rotation=0&showTitle=false&size=24721&status=done&style=none&taskId=u78c420a7-4b2a-49af-a9a8-1a68c5058c9&title=&width=458)
   - 复合注解方式：
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1658041485279-e8628c96-8fef-4467-ade0-b620c7d83b38.png#clientId=u4351ac9e-274f-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=195&id=ueb51b898&margin=%5Bobject%20Object%5D&name=image.png&originHeight=195&originWidth=467&originalType=binary&ratio=1&rotation=0&showTitle=false&size=21305&status=done&style=none&taskId=u396bb483-14b4-4d90-bf65-18370770681&title=&width=467)

### 5.6 SpringWebflux
>
> - 需要SpringMVC、SpringBoot、Maven、Java8新特性知识基础。

#### 5.6.1 介绍

#### 5.6.2 响应式编程

#### 5.6.3 基于注解编程模型

#### 5.6.4 基于函数式编程模型
