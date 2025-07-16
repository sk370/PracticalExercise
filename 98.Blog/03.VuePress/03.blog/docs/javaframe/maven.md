---
icon: edit
date: 2022-07-11
category:
  - 构建工具
# tag:
#   - tag A
#   - tag B
description: 
  - Maven是一款“构建工具”，同为构建工具的还有Gradle，本文仅介绍Maven如何使用，如何进行依赖管理、版本控制、打包等操作。
---

# Maven

> Maven是一个Java项目管理和构建工具，它可以定义项目结构、项目依赖，并使用统一的方式进行自动化构建

## 第1章 Maven概述

### 1.1 Maven的作用及必要性

#### 1.1.0 概念

1. Apache 软件基金会组织维护的一款专门为 Java 项目提供**构建**和**依赖**管理支持的工具。
1. 构建：Java开发过程中，使用原材料生产产品的过程。
   - 清理：删除上一次构建的结果，为下一次构建做好准备
   - 编译：Java 源程序编译成 *.class 字节码文件
   - 测试：运行提前准备好的测试程序
   - 报告：针对刚才测试的结果生成一个全面的信息
   - 打包
      - Java工程：jar包
      - Web工程：war包
   - 安装：把一个 Maven 工程经过打包操作生成的 jar 包或 war 包存入 Maven 仓库
   - 部署
      - 部署 jar 包：把一个 jar 包部署到 Nexus 私服服务器上
      - 部署 war 包：借助相关 Maven 插件（例如 cargo），将 war 包部署到 Tomcat 服务器上
3. 依赖：如果 A 工程里面用到了 B 工程的类、接口、配置文件等等这样的资源，那么我们就可以说 A 依赖 B
:::info

- junit-4.12 依赖 hamcrest-core-1.3
- thymeleaf-3.0.12.RELEASE 依赖 ognl-3.1.26
  - ognl-3.1.26 依赖 javassist-3.20.0-GA
- thymeleaf-3.0.12.RELEASE 依赖 attoparser-2.0.5.RELEASE
- thymeleaf-3.0.12.RELEASE 依赖 unbescape-1.1.6.RELEASE
- thymeleaf-3.0.12.RELEASE 依赖 slf4j-api-1.7.26
:::
:::warning
依赖管理中要解决的具体问题：

- jar 包的下载：使用 Maven 之后，jar 包会从规范的远程仓库下载到本地
- jar 包之间的依赖：通过依赖的传递性自动完成
- jar 包之间的冲突：通过对依赖的配置进行调整，让某些jar包不会被导入
:::

#### 1.1.1 作用

Maven 简化并标准化了项目构建过程。它将项目的编译，生成文档，创建报告，发布，部署等任务无缝衔接，构建成一套完整的生命周期。

- 构建项目
- 生成文档
- 创建报告
- 维护依赖
- 软件配置管理
- 发布
- 部署

#### 1.1.2 必要性

- 管理规模庞大的jar包，需要专门的工具
- IDEA完成了本地的构建操作，但项目部署、发布没有IDEA的环境，需要单独配置。

#### 1.1.3 特点

1. 设置简单。
1. 所有项目的用法一致。
1. 可以管理和自动进行更新依赖。
1. 庞大且不断增长的资源库。
1. 可扩展，使用 Java 或脚本语言可以轻松的编写插件。
1. 几乎无需额外配置，即可立即访问新功能。
1. 基于模型的构建：Maven 能够将任意数量的项目构建为预定义的输出类型，例如 JAR，WAR。
1. 项目信息采取集中式的元数据管理：使用与构建过程相同的元数据，Maven 能够生成一个网站（site）和一个包含完整文档的 PDF。
1. 发布管理和发行发布：Maven 可以与源代码控制系统（例如 Git、SVN）集成并管理项目的发布。
1. 向后兼容性：您可以轻松地将项目从旧版本的 Maven 移植到更高版本的 Maven 中。
1. 并行构建：它能够分析项目依赖关系，并行构建工作，使用此功能，可以将性能提高 20%-50％。
1. 更好的错误和完整性报告：Maven 使用了较为完善的错误报告机制，它提供了指向 Maven Wiki 页面的链接，您将在其中获得有关错误的完整描述。

#### 1.1.4 Maven工作机制

![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657377514357-33c7fc70-4a36-4b41-9b55-5ddaf7d5eee7.png#clientId=ueb61176b-5a67-4&crop=0&crop=0&crop=1&crop=1&from=paste&id=u3eb2ced9&margin=%5Bobject%20Object%5D&name=image.png&originHeight=812&originWidth=1169&originalType=url&ratio=1&rotation=0&showTitle=false&size=121268&status=done&style=none&taskId=u6e1cb5c3-c2ae-4ec8-b8f5-798884172eb&title=)
没懂

## 第2章 Maven配置

### 2.1 Maven下载及安装

#### 2.1.1 Maven 官网地址

首页：
下载页面：
下载链接：
![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657377608461-1b28481b-d0d5-497b-9fd5-59e56d29cfaa.png#clientId=ueb61176b-5a67-4&crop=0&crop=0&crop=1&crop=1&from=paste&id=ub225c660&margin=%5Bobject%20Object%5D&name=image.png&originHeight=333&originWidth=1099&originalType=url&ratio=1&rotation=0&showTitle=false&size=39926&status=done&style=none&taskId=u5c96578e-a2e0-4560-a34b-883a3bf6dbd&title=)

#### 2.1.2 解压Maven核心程序

核心程序压缩包：apache-maven-3.8.4-bin.zip，解压到**非中文、没有空格**的目录。例如：
![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657410071439-122719d6-0f81-48a5-ba00-583ecf7bdb5b.png#clientId=u03dec2e6-f7dc-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=292&id=ude6aae4e&margin=%5Bobject%20Object%5D&name=image.png&originHeight=292&originWidth=832&originalType=binary&ratio=1&rotation=0&showTitle=false&size=24757&status=done&style=none&taskId=u357f8c97-e004-40c9-9e76-919e300f1e5&title=&width=832)
Maven 的核心配置文件：**conf/settings.xml**

### 2.2 配置Maven环境

#### 2.2.1 指定本地仓库

- 本地仓库默认值：用户家目录/.m2/repository。
  - 如windows：
  - 刚安装完没有启动过maven的话看不到这个目录
- 修改**conf/settings.xml**文件中的配置（53行），可更换仓库目录。
  - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657410550620-f2b42ed5-e372-4035-8e82-006bb736a39a.png#clientId=u03dec2e6-f7dc-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=157&id=ud59838f8&margin=%5Bobject%20Object%5D&name=image.png&originHeight=157&originWidth=736&originalType=binary&ratio=1&rotation=0&showTitle=false&size=35627&status=done&style=none&taskId=u536f35d8-cc8c-4124-8961-79359abdc0c&title=&width=736)
  - **非中文、没有空格**的目录。
  - 本地没有该目录是，执行maven命令会自动创建

#### 2.2.2 修改远程镜像仓库

- 改成阿里云提供的镜像仓库，让 Maven 下载 jar 包的时候速度更快。
- 修改**conf/settings.xml**文件中的配置（160~165行）
  - 改之前：
    - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657410757792-9b6de0df-68f7-4ddc-9228-e379375e1e34.png#clientId=u03dec2e6-f7dc-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=152&id=u12778de5&margin=%5Bobject%20Object%5D&name=image.png&originHeight=152&originWidth=788&originalType=binary&ratio=1&rotation=0&showTitle=false&size=32473&status=done&style=none&taskId=uf5ff513b-476a-4bef-a7a1-7edef527d96&title=&width=788)
  - 改之后：
    - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657415442911-04750654-e706-4fc5-9932-e56809124448.png#clientId=u0a4a3027-8f37-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=132&id=u62c36709&margin=%5Bobject%20Object%5D&name=image.png&originHeight=132&originWidth=620&originalType=binary&ratio=1&rotation=0&showTitle=false&size=21805&status=done&style=none&taskId=u908ede1f-35ab-4da4-8e6a-088ceec1f0f&title=&width=620)
  - 注意检查最新地址是否变化：，只需要看地址。

#### 2.2.3 配置 Maven 工程的基础 JDK 版本

- maven使用的默认 JDK 版本是 1.5。
- 修改**conf/settings.xml**文件中的配置，更换为JDK1.8。
  - 在最后以一个`</profiles>`标签（约254行）前，插入下述文本，
  - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657415409152-7a01f61e-ed4b-4108-a5de-484285112625.png#clientId=u0a4a3027-8f37-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=283&id=u123e992e&margin=%5Bobject%20Object%5D&name=image.png&originHeight=283&originWidth=778&originalType=binary&ratio=1&rotation=0&showTitle=false&size=55226&status=done&style=none&taskId=uf3f5ee7c-14ae-41b1-ba08-5849d28cdad&title=&width=778)

[maven修改配置.md](https://www.yuque.com/attachments/yuque/0/2022/md/1604140/1657415274747-90d48495-4bfe-4325-a697-c66940e9f6f5.md)

#### 2.2.4 检查Java环境变量

- **注意：安装Java后即使不配置**`**JAVA_HOME**`**路径，终端也能运行Java命令（如下），但这个环境变量配置在了Path里，而一些依赖Java运行环境的软件、工具，由于自身就是Java开发，或者某些配置需要Java环境变量，它依然会找**`**JAVA_HOME**`**，导致运行失败。**
  - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657411910334-ffcafc56-233b-42bb-8b92-891c4100c47c.png#clientId=u0a4a3027-8f37-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=167&id=uf156b9c2&margin=%5Bobject%20Object%5D&name=image.png&originHeight=167&originWidth=550&originalType=binary&ratio=1&rotation=0&showTitle=false&size=45836&status=done&style=none&taskId=ue478e1a8-e79e-420e-ae0e-293818e92d2&title=&width=550)
- 检查环境变量配置：
  - 终端中输入`echo %JAVA_HOME%`、`echo %PATH%`能够正确显示本地JDK路径即可。
  - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657412606746-14454929-86f4-4cee-884d-61bcff468abb.png#clientId=u0a4a3027-8f37-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=168&id=u00e4e4ae&margin=%5Bobject%20Object%5D&name=image.png&originHeight=168&originWidth=957&originalType=binary&ratio=1&rotation=0&showTitle=false&size=10191&status=done&style=none&taskId=ud2a62c0d-d587-4630-afff-3a9d5a18659&title=&width=957)

#### 2.2.5 配置MAVEN_HOME和Path

- `MAVEN_HOME`配置：
  - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657412891168-b104902c-02aa-48c0-9482-1004d11e9bf8.png#clientId=u0a4a3027-8f37-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=142&id=u43ade829&margin=%5Bobject%20Object%5D&name=image.png&originHeight=142&originWidth=669&originalType=binary&ratio=1&rotation=0&showTitle=false&size=20356&status=done&style=none&taskId=ub587e21d-3961-4697-9d18-9501c3d7ff9&title=&width=669)
- `Path`配置：
  - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657413120905-43ff560e-8cfa-442f-a658-6993e88fabd7.png#clientId=u0a4a3027-8f37-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=251&id=ueb0086c5&margin=%5Bobject%20Object%5D&name=image.png&originHeight=251&originWidth=406&originalType=binary&ratio=1&rotation=0&showTitle=false&size=64562&status=done&style=none&taskId=u0a3e659f-d144-4b76-9911-c801fb03521&title=&width=406)
- XXX_HOME 通常指向的是 bin 目录的上一级，PATH 指向的是 bin 目录

#### 2.2.6 检查Maven配置是否成功

- 终端中输入`mvn -v`，是否正常显示相关信息
  - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657413190998-8769e7f6-d385-4c68-8c28-8e9eea8643a4.png#clientId=u0a4a3027-8f37-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=142&id=ub6a9b953&margin=%5Bobject%20Object%5D&name=image.png&originHeight=142&originWidth=832&originalType=binary&ratio=1&rotation=0&showTitle=false&size=20987&status=done&style=none&taskId=u90ffcfff-bab0-464b-b692-922013340b3&title=&width=832)
- 注意：在配置环境变量前打开的终端窗口，在配置完环境变量后要重新打开，以保证终端加载了配置的环境变量。

### 2.3 Maven的核心概念

#### 2.3.1 POM

1. **P**roject **O**bject **M**odel，项目对象模型。是模型化思想的具体体现。
   - POM 表示将工程抽象为一个模型，再用程序中的对象来描述这个模型
2. 模型化思想：将现实生活中的事物抽象为模型，然后封装模型相关的数据作为一个对象，这使得可以在程序中计算与现实事物相关的数据。
2. POM 理念集中体现在 Maven 工程根目录下 **pom.xml** 这个配置文件中。所以这个 pom.xml 配置文件就是 Maven 工程的核心配置文件。其实学习 Maven 就是学这个文件怎么配置，各个配置有什么用。

#### 2.3.2 约定的目录结构

1. 目录结构：
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657425674286-144930a8-c3ff-4080-ac73-c6675e98601e.png#clientId=u52e3b5db-74b7-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=155&id=ua6c004e0&margin=%5Bobject%20Object%5D&name=image.png&originHeight=351&originWidth=658&originalType=url&ratio=1&rotation=0&showTitle=false&size=36974&status=done&style=none&taskId=ua3325d3e-e1a0-47a8-9afb-bedad9baba7&title=&width=291)
   - 另外还有一个 target 目录专门存放构建操作输出的结果
2. 约定目录结构的意义：让构建过程能够尽可能自动化完成
2. 约定大于配置：

## 第3章 使用Maven命令行环境

### 3.1 maven中的坐标，即本地文件存放位置

#### 3.1.1 Maven中的坐标

- maven中使用三个**『向量』**在**『Maven的仓库』**中**唯一**的定位到一个**『jar』**包。
  - **groupId**：公司或组织的 id
  - **artifactId**：一个项目或者是项目中的一个模块的 id
  - **version**：版本号

#### 3.1.2 三个向量的取值方式

- groupId：公司或组织域名的倒序，通常也会加上项目名称
- artifactId：模块的名称，将来作为 Maven 工程的工程名
- version：模块的版本号，根据自己的需要设定
  - 例如：SNAPSHOT 表示快照版本，正在迭代过程中，不稳定的版本
  - 例如：RELEASE 表示正式版本
>
> - 举例：
>   - groupId：com.atguigu.maven
>   - artifactId：pro01-atguigu-maven
>   - version：1.0-SNAPSHOT

#### 3.1.3 坐标和仓库中 jar 包的存储路径之间的对应关系

- 坐标：
  - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657413641627-2d26f9d5-6fcb-4951-9b2b-4fcc7dd7d966.png#clientId=u0a4a3027-8f37-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=65&id=u85519375&margin=%5Bobject%20Object%5D&name=image.png&originHeight=65&originWidth=278&originalType=binary&ratio=1&rotation=0&showTitle=false&size=5417&status=done&style=none&taskId=ubc9ee66b-5266-40b6-841b-1ba486a7b0b&title=&width=278)
- 对应本地存储位置：
  - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657413661834-f84b1265-54ea-463f-8502-93b02a480faa.png#clientId=u0a4a3027-8f37-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=28&id=u3aebeb07&margin=%5Bobject%20Object%5D&name=image.png&originHeight=28&originWidth=517&originalType=binary&ratio=1&rotation=0&showTitle=false&size=3391&status=done&style=none&taskId=u783cb37b-a30b-432c-a5c6-5b9a5994185&title=&width=517)

### 3.2 使用`mvn archetype:generate`命令生成Maven工程

#### 3.2.1 创建工程

> 在需要存放maven工程的路径下打开cmd终端执行

- ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657417449150-54bdf30e-28df-445f-ba33-9538ca95ac90.png#clientId=u0a4a3027-8f37-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=19&id=u9f09c9c5&margin=%5Bobject%20Object%5D&name=image.png&originHeight=19&originWidth=423&originalType=binary&ratio=1&rotation=0&showTitle=false&size=4355&status=done&style=none&taskId=u340a1e24-f95b-4a07-8aae-ec9e11d6150&title=&width=423)
- ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657417462536-654c3127-f08b-4138-97ae-15d2de50563f.png#clientId=u0a4a3027-8f37-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=20&id=ue9784639&margin=%5Bobject%20Object%5D&name=image.png&originHeight=20&originWidth=826&originalType=binary&ratio=1&rotation=0&showTitle=false&size=4366&status=done&style=none&taskId=ud7d19af9-4178-42fc-8518-07ee3069b6a&title=&width=826)
  - 输入7，使用默认值
- ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657415791688-55f3bcbc-6130-430c-8a1e-99ddb01f8428.png#clientId=u0a4a3027-8f37-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=21&id=uc1d317fe&margin=%5Bobject%20Object%5D&name=image.png&originHeight=21&originWidth=300&originalType=binary&ratio=1&rotation=0&showTitle=false&size=663&status=done&style=none&taskId=u08e9b3f9-2528-4322-b791-9d37a91fa16&title=&width=300)
  - 输入groupId，如`iceriver.mavenetst`——`组织名.项目名`
- ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657416808752-de83e432-5851-4427-ba9b-182df03834db.png#clientId=u0a4a3027-8f37-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=20&id=ufd4bfc38&margin=%5Bobject%20Object%5D&name=image.png&originHeight=20&originWidth=320&originalType=binary&ratio=1&rotation=0&showTitle=false&size=723&status=done&style=none&taskId=ub050f842-093c-4903-9f45-1cac3c422bd&title=&width=320)
  - 输入artifactId，如`pro01-maven`——工程名作为模块名
- ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657416975784-2a6cff20-322d-478d-b617-e7a0359916ef.png#clientId=u0a4a3027-8f37-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=17&id=ubd905830&margin=%5Bobject%20Object%5D&name=image.png&originHeight=17&originWidth=408&originalType=binary&ratio=1&rotation=0&showTitle=false&size=810&status=done&style=none&taskId=u4e09875b-5156-45dc-9885-60f9ae0702b&title=&width=408)使用默认
- ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657417005406-f9f8d3e5-6059-43f9-819b-1d4d0bc8047a.png#clientId=u0a4a3027-8f37-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=18&id=u32493e1c&margin=%5Bobject%20Object%5D&name=image.png&originHeight=18&originWidth=462&originalType=binary&ratio=1&rotation=0&showTitle=false&size=861&status=done&style=none&taskId=u112d4279-ee6d-4a44-a23f-1b36e8bb22a&title=&width=462)
  - 包名可使用默认值，与groupId一致。
- ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657417040764-8c2265f5-9858-4224-9aa5-870f9f832d85.png#clientId=u0a4a3027-8f37-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=96&id=u7a3e8d88&margin=%5Bobject%20Object%5D&name=image.png&originHeight=96&originWidth=265&originalType=binary&ratio=1&rotation=0&showTitle=false&size=2214&status=done&style=none&taskId=u6bf9aed9-c64d-4764-bb7c-c841be66b3c&title=&width=265)确认设置。

#### 3.2.2 更改模块设置

1. 模块结构：
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657424308579-3a1eb957-775c-4dd8-8edf-c969e0dfe50d.png#clientId=u52e3b5db-74b7-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=258&id=u9e1f0e6e&margin=%5Bobject%20Object%5D&name=image.png&originHeight=363&originWidth=410&originalType=binary&ratio=1&rotation=0&showTitle=false&size=21253&status=done&style=none&taskId=uc7f86ada-ea2e-41fb-aba9-af24edbcdec&title=&width=291)
2. 修改模块（artifactId）目录下`pro01-maven/pom.xml`中junit的配置
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657424213047-8d64f510-6ec5-4bf5-82d6-1765b8e53ad6.png#clientId=u52e3b5db-74b7-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=177&id=uf374d494&margin=%5Bobject%20Object%5D&name=image.png&originHeight=177&originWidth=412&originalType=binary&ratio=1&rotation=0&showTitle=false&size=25492&status=done&style=none&taskId=u76ea2339-1cc4-44bf-80cc-b875387ab3d&title=&width=412)
3. 可以删除`App.java`和`AppTest.java`两个文件
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657424381673-c5aa3fec-a775-4248-b638-d6bfe83fcfc1.png#clientId=u52e3b5db-74b7-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=229&id=uda6f9762&margin=%5Bobject%20Object%5D&name=image.png&originHeight=363&originWidth=382&originalType=binary&ratio=1&rotation=0&showTitle=false&size=16210&status=done&style=none&taskId=u76a395bc-fb59-4a98-9e63-1fdf5eb9777&title=&width=241)

#### 3.2.3 `pom.xml`文件解读

```xml
<!-- 根标签，表示对当前工程（模块）进行配置、管理 -->
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <!-- 从Maven2开始就是4.0.0，代表pom.xml文件所采用的标签结构 -->
  <modelVersion>4.0.0</modelVersion>
  <!-- 当前Maven工程的坐标 -->
  <groupId>iceriver.maventest</groupId>
  <artifactId>pro01-maven</artifactId>
  <version>1.0-SNAPSHOT</version>
  <!-- 打包方式：jar表示Java工程，war表示web工程，pom表示管理其他工程的工程 -->
  <packaging>jar</packaging>
  
  <name>pro01-maven</name>
  <url>http://maven.apache.org</url>
  <!-- 定义maven使用的属性值 -->
  <properties>
    <!-- 工程读取源码时使用的字符集 -->
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
  </properties>
  <!-- 配置具体依赖信息 -->
  <dependencies>
    <!-- 配置一个具体的依赖 -->
    <dependency>
      <!-- 依赖所在的坐标信息 -->
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.12</version>
      <!-- 配置依赖的作用范围 -->
      <scope>test</scope>
    </dependency>
  </dependencies>
</project>
```

### 3.3 在maven工程中编写代码

#### 3.3.1 主体程序

![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657426038943-3be6e343-b430-4791-9758-3ccf3254c172.png#clientId=u52e3b5db-74b7-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=211&id=u6c733ddd&margin=%5Bobject%20Object%5D&name=image.png&originHeight=211&originWidth=318&originalType=binary&ratio=1&rotation=0&showTitle=false&size=7292&status=done&style=none&taskId=u1a5e7c8e-24d9-46ea-bba9-2717ea15aa8&title=&width=318)
`package`路径。

```java
package iceriver.maventest;

public class Calculator {
    public int sum(int i, int j) {
        return i + j;
    }
}
```

#### 3.3.2 测试程序

![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657426074921-f050e6db-9bba-4dd5-89ae-8d7bc94653b9.png#clientId=u52e3b5db-74b7-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=206&id=ue01dc05a&margin=%5Bobject%20Object%5D&name=image.png&originHeight=206&originWidth=304&originalType=binary&ratio=1&rotation=0&showTitle=false&size=7233&status=done&style=none&taskId=ufac0dc08-71f2-4a74-aaac-e7865fed41b&title=&width=304)

```java
package iceriver;

import org.junit.Test;
import iceriver.maventest.Calculator;

// 静态导入的效果是将Assert类中的静态资源导入当前类
// 这样一来，在当前类中就可以直接使用Assert类中的静态资源，不需要写类名
import static org.junit.Assert.*;

public class CalculatorTest {

  @Test
  public void testSum() {

    // 1.创建Calculator对象
    Calculator calculator = new Calculator();

    // 2.调用Calculator对象的方法，获取到程序运行实际的结果
    int actualResult = calculator.sum(5, 3);

    // 3.声明一个变量，表示程序运行期待的结果
    int expectedResult = 8;

    // 4.使用断言来判断实际结果和期待结果是否一致
    // 如果一致：测试通过，不会抛出异常
    // 如果不一致：抛出异常，测试失败
    assertEquals(expectedResult, actualResult);
  }
}
```

### 3.4 执行Maven的构建命令

#### 3.3.1 构建命令

1. `mvn xxx`
1. 注意：`mvn -v`与构建无关，只要正确配置了maven-path，在任何目录下都可执行。
1. 运行与构建相关的命令，必须进入到`pom.xml`文件所在的目录

#### 3.3.2 清理操作

- `mvn clean`
- 删除trget目录

#### 3.3.3 编译操作

- 主程序编译：`mvn compile`
  - 主体程序编译结果存放的目录：`target/classes`
  - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657427130976-888d1503-ed96-457c-b594-8779504cb607.png#clientId=u52e3b5db-74b7-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=35&id=u1b64e8f4&margin=%5Bobject%20Object%5D&name=image.png&originHeight=35&originWidth=628&originalType=binary&ratio=1&rotation=0&showTitle=false&size=6316&status=done&style=none&taskId=udf416af5-d721-4642-a55f-cd6bf4b0943&title=&width=628)
- 测试程序编译：`mvn test-compile`
  - 测试程序编译结果存放的目录：`target/test-classes`
  - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657427191897-d64ca852-b9f6-47d8-b901-52de3a9211e7.png#clientId=u52e3b5db-74b7-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=37&id=u66379491&margin=%5Bobject%20Object%5D&name=image.png&originHeight=37&originWidth=631&originalType=binary&ratio=1&rotation=0&showTitle=false&size=6431&status=done&style=none&taskId=ue3d108f2-41ff-4dbb-82ed-cb5447d621e&title=&width=631)

#### 3.3.4 测试操作

- `mvn test`
  - 测试的报告存放的目录：`target/surefire-reports`

#### 3.3.5 打包操作

- `mvn package`
  - 打包的结果——jar 包，存放的目录：target
  - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657431492028-a067f79c-b617-40b9-b848-2586a0b730d6.png#clientId=u52e3b5db-74b7-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=36&id=uc45654ae&margin=%5Bobject%20Object%5D&name=image.png&originHeight=36&originWidth=628&originalType=binary&ratio=1&rotation=0&showTitle=false&size=6460&status=done&style=none&taskId=u4414ebe9-65af-4893-a60d-bdf954b1673&title=&width=628)

#### 3.3.6 安装操作

- 将本地构建生成的jar包存入到本地Maven仓库中。
- `mvn install`
  - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657431855734-29b234dd-2af6-40f8-9f9d-22bdea8b272a.png#clientId=u52e3b5db-74b7-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=117&id=udef11f60&margin=%5Bobject%20Object%5D&name=image.png&originHeight=117&originWidth=635&originalType=binary&ratio=1&rotation=0&showTitle=false&size=20263&status=done&style=none&taskId=u3a343e26-b572-45d9-84e4-71b9cb766e7&title=&width=635)
  - 在maven在本地仓库的位置是`pom.xml`中的配置确定的
    - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657431939073-207a4dc2-f428-4f56-b9db-b3b21159eaa7.png#clientId=u52e3b5db-74b7-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=80&id=uf177a9bf&margin=%5Bobject%20Object%5D&name=image.png&originHeight=80&originWidth=311&originalType=binary&ratio=1&rotation=0&showTitle=false&size=8600&status=done&style=none&taskId=u2eadfe45-0280-4a90-8f6f-0aa7663e564&title=&width=311)

#### 3.3.7 查看当前工程的依赖

- `mvn dependency:list`
  - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657446058789-4c19dda0-c14b-49d6-8c8b-b3b388c602ac.png#clientId=u52e3b5db-74b7-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=163&id=uc70bbba9&margin=%5Bobject%20Object%5D&name=image.png&originHeight=228&originWidth=576&originalType=binary&ratio=1&rotation=0&showTitle=false&size=21627&status=done&style=none&taskId=ub07a6a63-6bc2-4d33-9698-8815d91a7e2&title=&width=411)
  - 第一个依赖为junit的依赖

### 3.5 创建Maven版的web工程

#### 3.5.1 创建工程

1. `mvn archetype:generate -DarchetypeGroupId=org.apache.maven.archetypes -DarchetypeArtifactId=maven-archetype-webapp -DarchetypeVersion=1.4`
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657433034162-cffa2479-04d0-4007-aaa7-14134e5f236d.png#clientId=u52e3b5db-74b7-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=25&id=u5428c68b&margin=%5Bobject%20Object%5D&name=image.png&originHeight=25&originWidth=455&originalType=binary&ratio=1&rotation=0&showTitle=false&size=901&status=done&style=none&taskId=ub59b40da-a202-4436-808c-1e9bbe59830&title=&width=455)
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657433126744-a6689e10-e7c8-44ca-8fac-470419f47a5c.png#clientId=u52e3b5db-74b7-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=20&id=u2f20059f&margin=%5Bobject%20Object%5D&name=image.png&originHeight=20&originWidth=457&originalType=binary&ratio=1&rotation=0&showTitle=false&size=969&status=done&style=none&taskId=u56232208-c97c-4ac7-9dda-8e3029bba47&title=&width=457)
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657433187049-c83ea24e-fe9a-4f7b-9e8b-98d8d68d4c7c.png#clientId=u52e3b5db-74b7-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=183&id=uf1d0b0d5&margin=%5Bobject%20Object%5D&name=image.png&originHeight=214&originWidth=362&originalType=binary&ratio=1&rotation=0&showTitle=false&size=3677&status=done&style=none&taskId=u0982e988-954d-4167-a8b2-115c1ab89cc&title=&width=309)

#### 3.5.2 `pom.xml`文件配置

无特殊配置，确认下打包形式——`war`和`junit`版本即可

#### 3.5.3 创建servlet

1. 在main目录下创建java目录，即为servlet程序的根目录
   - 编写测试程序，如HelloServlet.java
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657441368232-171f00db-ec7d-4db0-83e5-a06b185e9d89.png#clientId=u52e3b5db-74b7-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=198&id=u47efe847&margin=%5Bobject%20Object%5D&name=image.png&originHeight=241&originWidth=328&originalType=binary&ratio=1&rotation=0&showTitle=false&size=2695&status=done&style=none&taskId=u69af234f-0759-4dc5-9dba-db45f15bb32&title=&width=269)

```java
package iceriver.maventest;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
 
public class HelloServlet extends HttpServlet{
 
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  response.getWriter().write("hello maven web");
 }
}
```

2. 配置`web.xml`
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657442903890-f4a9b8f4-05c8-4217-9bf4-40aad00e6e39.png#clientId=u52e3b5db-74b7-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=145&id=ua9ffa45a&margin=%5Bobject%20Object%5D&name=image.png&originHeight=197&originWidth=555&originalType=binary&ratio=1&rotation=0&showTitle=false&size=35980&status=done&style=none&taskId=u5c1eccc7-f6e7-4924-b586-e6f47a705ae&title=&width=409)
3. `index.jsp`页面中插入超链接，访问HelloServlet程序

3. 此时还不能启动web程序，是因为缺少必须的依赖
   -

   - 配置`servlet-api.jar`
      - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657444326561-86a1f8ef-cb0b-40c0-98fc-27d5aabd0d61.png#clientId=u52e3b5db-74b7-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=705&id=u6db0a968&margin=%5Bobject%20Object%5D&name=image.png&originHeight=705&originWidth=1368&originalType=binary&ratio=1&rotation=0&showTitle=false&size=53111&status=done&style=none&taskId=ue0e13b1a-ba71-4208-b4e2-2ceda064550&title=&width=1368)
      - 将依赖的配置信息放到`pom.xml`文件中
      - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657444281698-72165e6b-475d-44a9-8f49-9d51db503da6.png#clientId=u52e3b5db-74b7-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=150&id=uc66372e4&margin=%5Bobject%20Object%5D&name=image.png&originHeight=150&originWidth=789&originalType=binary&ratio=1&rotation=0&showTitle=false&size=35081&status=done&style=none&taskId=uc70bf45d-d084-4370-81c5-226d5bde901&title=&width=789)
5. 编译该web程序，在模块目录下（与`pom.xml`同级）执行`mvn compile`
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657442099977-cd2c3d11-b34a-497f-9199-03938085718f.png#clientId=u52e3b5db-74b7-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=131&id=u92038bee&margin=%5Bobject%20Object%5D&name=image.png&originHeight=131&originWidth=685&originalType=binary&ratio=1&rotation=0&showTitle=false&size=4845&status=done&style=none&taskId=ua1e491e0-2ee5-46c3-bc5a-066e974ab33&title=&width=685)
6. 打包web程序——执行`mvn package`
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657442230208-d9fa3372-dc38-478c-a5ff-42c4e4da4a5d.png#clientId=u52e3b5db-74b7-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=189&id=uc06fe1f3&margin=%5Bobject%20Object%5D&name=image.png&originHeight=189&originWidth=859&originalType=binary&ratio=1&rotation=0&showTitle=false&size=8755&status=done&style=none&taskId=u32e5e75b-a703-4246-8e14-82736a68fb9&title=&width=859)
7. 部署：将上面生成的war包拷贝至`tomcat安装目录/webapps`路径下
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657442361725-ddb75eae-4faf-4e07-9834-368203bc5f71.png#clientId=u52e3b5db-74b7-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=223&id=u31bb285c&margin=%5Bobject%20Object%5D&name=image.png&originHeight=223&originWidth=524&originalType=binary&ratio=1&rotation=0&showTitle=false&size=18435&status=done&style=none&taskId=u425f263c-b03d-49a4-874b-34d27eb1118&title=&width=524)
   - 启动tomcat：
      - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657442431125-627d560f-cb5d-4a56-8438-9b879b72ad27.png#clientId=u52e3b5db-74b7-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=307&id=u2b243d42&margin=%5Bobject%20Object%5D&name=image.png&originHeight=307&originWidth=586&originalType=binary&ratio=1&rotation=0&showTitle=false&size=31482&status=done&style=none&taskId=u99619e47-6fa7-44a8-9594-e650b6fb0be&title=&width=586)
   - 浏览器访问该war包的地址
      - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657442504648-cfdd3883-2b35-4f0b-9448-992a28b84206.png#clientId=u52e3b5db-74b7-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=182&id=u774824da&margin=%5Bobject%20Object%5D&name=image.png&originHeight=182&originWidth=387&originalType=binary&ratio=1&rotation=0&showTitle=false&size=15012&status=done&style=none&taskId=u3fd1a048-554a-4e24-ba6a-0b8a00eac8b&title=&width=387)

### 3.6 让web工程依赖Java工程

#### 3.6.1 概念

- 将我们自己的java工程打包成jar包，放在web工程的`WEB-INF/lib`目录下

#### 3.6.2 配置依赖

- 如将3.2构建的Java工程作为3.5创建的web工程的依赖：
  - 配置`pom.xml`文件：
    - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657445072703-901f2b07-e947-4988-a432-dbaeabc016f7.png#clientId=u52e3b5db-74b7-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=119&id=ubf23288d&margin=%5Bobject%20Object%5D&name=image.png&originHeight=119&originWidth=512&originalType=binary&ratio=1&rotation=0&showTitle=false&size=21069&status=done&style=none&taskId=ucf8e965e-d80c-4fd4-b6a3-60360b9d18d&title=&width=512)
      - 即将3.2Java工程的坐标，作为3.5web工程的依赖
      - `<scope>`标签可写可不写，默认值为`compile`

#### 3.6.3 创建test程序的坐标

- 根据依赖的`groupId`，创建相关的文件目录
  - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657445506696-d7615f27-3b2b-4678-b690-c0d77e4ad7af.png#clientId=u52e3b5db-74b7-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=261&id=u75549213&margin=%5Bobject%20Object%5D&name=image.png&originHeight=261&originWidth=359&originalType=binary&ratio=1&rotation=0&showTitle=false&size=4603&status=done&style=none&taskId=u90c1f8b3-b24d-49f2-9354-0a77e5e35cd&title=&width=359)
- 将3.3创建的`CalculatorTest.java`文件复制到maven目录下
- 执行`mvn test`
  - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657445695274-6065957f-62f9-44e3-922b-9ae6f1ca7b08.png#clientId=u52e3b5db-74b7-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=209&id=uc2c0d8ff&margin=%5Bobject%20Object%5D&name=image.png&originHeight=259&originWidth=528&originalType=binary&ratio=1&rotation=0&showTitle=false&size=6675&status=done&style=none&taskId=uff8c2183-2348-453f-830e-7c3f80cdf3d&title=&width=427)

#### 3.6.4 打包

- 执行`mvn package`成功后即可在3.5war包下的lib目录看到3.2的jar包
  - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657445862813-95b6f4e9-3a8b-4deb-b190-9b6adaf68501.png#clientId=u52e3b5db-74b7-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=107&id=ucdd1e68f&margin=%5Bobject%20Object%5D&name=image.png&originHeight=107&originWidth=432&originalType=binary&ratio=1&rotation=0&showTitle=false&size=6250&status=done&style=none&taskId=ue9fdcfe1-a5e4-4a40-b3b3-a6d61bae1bf&title=&width=432)

### 3.7 依赖生效范围

#### 3.7.1 依赖范围的配置

- 在`pom.xml`文件中`dependencies/dependency/**scope**`标签中配置
  - 可选值：`**compile**/**test**/**provided**/system/runtime/**import**`
  - compile：构建后直接放入classpath
  - test：仅在测试时使用，正常运行时并不需要。如junit
  - runtime：编译时不需要，但运行时需要，如JDBC驱动
  - provided：编译时需要，运行时不需要，运行时由环境中的其他支持提供，如servletapi

#### 3.7.2 compile、test和provided对比

|  | main目录
（空间） | test目录
（空间） | 开发过程
（时间） | 部署到服务器
（时间） |
| --- | --- | --- | --- | --- |
| compile | 有效 | 有效 | 有效 | 有效 |
| test | 无效 | 有效 | 有效 | 无效 |
| provided | 有效 | 有效 | 有效 | 无效 |

- compile：通常使用的第三方框架的 jar 包这样在项目实际运行时真正要用到的 jar 包都是以 compile 范围进行依赖的。比如 SSM 框架所需jar包。
- test：测试过程中使用的 jar 包，以 test 范围依赖进来。比如 junit。
- provided：在开发过程中需要用到的“服务器上的 jar 包”通常以 provided 范围依赖进来。比如 servlet-api、jsp-api。而这个范围的 jar 包之所以不参与部署、不放进 war 包，就是避免和服务器上已有的同类 jar 包产生冲突，同时减轻服务器的负担。

#### 3.7.3 依赖的传递性

- 在 A 依赖 B，B 依赖 C 的前提下，C 是否能够传递到 A，取决于 B 依赖 C 时使用的依赖范围。
  - B 依赖 C 时使用 compile 范围：可以传递
  - B 依赖 C 时使用 test 或 provided 范围：不能传递，所以需要这样的 jar 包时，就必须在需要的地方明确配置依赖才可以。

#### 3.7.4 依赖的排除

- 当 A 依赖 B，B 依赖 C 而且 C 可以传递到 A 的时候，A 不想要 C，需要在 A 里面把 C 排除掉。而往往这种情况都是为了避免 jar 包之间的冲突。
  - `<dependency>`标签中使用`<exclusion>`子标签，将依赖jar包的坐标（除`<scope>`）写在`<exclusion>`标签内。

```xml
<dependency>
  <groupId>iceriver.maventest</groupId>
  <artifactId>pro01-maven</artifactId>
  <version>1.0-SNAPSHOT</version>
  <scope>compile</scope>
  <!-- 使用excludes标签配置依赖的排除	-->
  <exclusions>
    <!-- 在exclude标签中配置一个具体的排除 -->
    <exclusion>
      <!-- 指定要排除的依赖的坐标（不需要写version） -->
      <groupId>commons-logging</groupId>
      <artifactId>commons-logging</artifactId>
    </exclusion>
  </exclusions>
</dependency>
```

#### 3.7.5 依赖的继承

1. Maven工程之间，A 工程继承 B 工程，本质上是 A 工程的 pom.xml 中的配置继承了 B 工程中 pom.xml 的配置。
   - 作用：通过父工程统一管理各个模块的依赖及版本，保证项目中依赖的统一，减少冲突等异常情况。
2. 只有打包方式为 pom 的 Maven 工程能够管理其他 Maven 工程。打包方式为 pom 的 Maven 工程中不写业务代码，它是专门管理其他 Maven 工程的工程。
2. 子工程在父工程的本地存储路径下，与父工程的`src`目录同级
   - 父工程的`pom.xml`文件配置：
      - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657452857497-ec59257f-5ffc-48e4-b529-1def574d9f20.png#clientId=u52e3b5db-74b7-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=103&id=u3ca99a0b&margin=%5Bobject%20Object%5D&name=image.png&originHeight=103&originWidth=285&originalType=binary&ratio=1&rotation=0&showTitle=false&size=3459&status=done&style=none&taskId=u1a06c7b2-9f25-4ca8-9b4d-7a2c01703d6&title=&width=285)
      - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657452962281-76395ec0-b6c9-42d5-b43e-55d28f7fb6aa.png#clientId=u52e3b5db-74b7-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=585&id=u41d09179&margin=%5Bobject%20Object%5D&name=image.png&originHeight=585&originWidth=390&originalType=binary&ratio=1&rotation=0&showTitle=false&size=39772&status=done&style=none&taskId=u00a517c4-e5ea-40f0-a244-4df376e292d&title=&width=390)
      - 子工程需要使用父工程管理的依赖时，还需要按需引入。
   - 子工程`pom.xml`文件配置：
      - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657452882114-6da2d3fe-146f-49f7-8060-0d9a598563cd.png#clientId=u52e3b5db-74b7-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=122&id=ub66a7c99&margin=%5Bobject%20Object%5D&name=image.png&originHeight=122&originWidth=327&originalType=binary&ratio=1&rotation=0&showTitle=false&size=7467&status=done&style=none&taskId=ud5fe8a71-29d9-4551-8b24-ee64779d081&title=&width=327)
      - 子工程的`groupId`与父工程一致时，**子工程坐标的**`groupId`可以省略，`version`一致时，也可以省略。
   - 子工程配置依赖时，`version`可以省略，如果子工程配置了`version`，最终会以子工程的版本为准。
   - 子工程可以引入父工程没有管理的依赖吗？
4. 父工程的属性：
   - 设置在`<properties>`标签中
   - 在`<properties>`标签中声明的自定义标签即为自定义属性，使用时`${标签名}`，属性值为标签中间的文本
      - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657454287964-4bd7be4a-50a4-4976-9047-5d13d295e899.png#clientId=u52e3b5db-74b7-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=138&id=u8de793f2&margin=%5Bobject%20Object%5D&name=image.png&originHeight=138&originWidth=505&originalType=binary&ratio=1&rotation=0&showTitle=false&size=10830&status=done&style=none&taskId=u1714b0fb-0c9c-4332-a16b-e7327cc2b66&title=&width=505)

#### 3.7.6 聚合

- 使用一个“总工程”将各个“模块工程”汇集起来，作为一个整体对应完整的项目。
- 好处：
  - 一键执行 Maven 命令：很多构建命令都可以在“总工程”中一键执行。
  - 配置聚合之后，各个模块工程会在总工程中展示一个列表，让项目中的各个模块一目了然。
- 配置：
  - 在父工程中使用`<moudles>`
  - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657452857497-ec59257f-5ffc-48e4-b529-1def574d9f20.png#clientId=u52e3b5db-74b7-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=103&id=mOMjH&margin=%5Bobject%20Object%5D&name=image.png&originHeight=103&originWidth=285&originalType=binary&ratio=1&rotation=0&showTitle=false&size=3459&status=done&style=none&taskId=u1a06c7b2-9f25-4ca8-9b4d-7a2c01703d6&title=&width=285)
- 如果 A 工程依赖 B 工程，B 工程依赖 C 工程，C 工程又反过来依赖 A 工程，那么在执行构建时，会报：`[ERROR] [ERROR] The projects in the reactor contain a cyclic reference:`

## 第4章 IDEA中使用Maven

### 4.1 创建父工程

- 演示版本：
  - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657460021621-5cc21288-59fe-466d-af41-1ebfaf2ed07d.png#clientId=u52e3b5db-74b7-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=274&id=u65ac34dd&margin=%5Bobject%20Object%5D&name=image.png&originHeight=322&originWidth=426&originalType=binary&ratio=1&rotation=0&showTitle=false&size=23007&status=done&style=none&taskId=u5ebe4da3-a3b9-469b-b3f7-7afbbbc0dd7&title=&width=362)
- 创建工程：
  - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657459573271-fc556299-f0d2-4b0d-b28c-0929c4ae95a3.png#clientId=u52e3b5db-74b7-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=365&id=u5d86c0d2&margin=%5Bobject%20Object%5D&name=image.png&originHeight=475&originWidth=542&originalType=binary&ratio=1&rotation=0&showTitle=false&size=66813&status=done&style=none&taskId=u3c9db4c1-8579-48aa-90a1-1e09374086a&title=&width=416)
  - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657459999062-d0c81ab9-cc6e-48a4-8d24-a011287a3fa9.png#clientId=u52e3b5db-74b7-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=406&id=u030c64cf&margin=%5Bobject%20Object%5D&name=image.png&originHeight=659&originWidth=784&originalType=binary&ratio=1&rotation=0&showTitle=false&size=47488&status=done&style=none&taskId=u5385c468-2262-4c65-8d6c-d87b4c4acfb&title=&width=483)
- 更换本地maven配置和仓库【重要】：
  - 不进行此操作可能会出现IDEA创建的模块使用idea的配置文件，造成版本错误、jar包冲突等问题。
  - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657463664100-71fe3028-b0ac-4f6f-bf61-195fd064653b.png#clientId=u52e3b5db-74b7-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=332&id=u3c9d30a9&margin=%5Bobject%20Object%5D&name=image.png&originHeight=713&originWidth=982&originalType=binary&ratio=1&rotation=0&showTitle=false&size=68358&status=done&style=none&taskId=u6c255cd6-97a8-407a-8c6c-64ddd701fe1&title=&width=457)

---

:::danger

- **由于不同版本IDEA创建的过程不一样，需要根据具体的IDEA工具去执行操作，所以下面没必要看**
:::

---

### 4.2 创建Maven-java【子】工程

#### 4.2.1 创建过程演示

![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657463788451-28246a1f-8144-43cf-afc1-a0ecf15293e2.png#clientId=u52e3b5db-74b7-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=610&id=u23fb553c&margin=%5Bobject%20Object%5D&name=image.png&originHeight=610&originWidth=784&originalType=binary&ratio=1&rotation=0&showTitle=false&size=46881&status=done&style=none&taskId=u458338b5-92d9-4ad4-b789-b6ff511477d&title=&width=784)
![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657467294464-1cdb6f9b-3294-46eb-95e4-5eb2e948d16d.png#clientId=u52e3b5db-74b7-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=192&id=u7a321f2b&margin=%5Bobject%20Object%5D&name=image.png&originHeight=192&originWidth=456&originalType=binary&ratio=1&rotation=0&showTitle=false&size=9624&status=done&style=none&taskId=u4e047803-0ebe-4f87-a29c-e1cb42ff225&title=&width=456)

#### 4.2.2 编写测试程序

![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657468463793-7d8c9acc-4efe-4cf3-9c94-81aa34d72db3.png#clientId=u00d27f39-8412-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=356&id=uf674dfe5&margin=%5Bobject%20Object%5D&name=image.png&originHeight=356&originWidth=496&originalType=binary&ratio=1&rotation=0&showTitle=false&size=19922&status=done&style=none&taskId=uaf97d521-148c-4b13-9b97-cd3d71c1d4f&title=&width=496)

```java
package iceriver.maventest;

/**
* @author: INFINITY https://developer.aliyun.com/profile/sagwrxp2ua66w
* @date: 2022/7/10 23:37
*/
public class Hello {
    public void showMessage(){
        System.out.println("IDEA & Maven");
    }
}
```

```java
package iceriver.maven;

import iceriver.maventest.Hello;
import org.junit.Test;

/**
 * @author: https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date: 2022/7/10 23:50
 */
public class HelloTest {
    @Test
    public void showMessage(){
        Hello hello = new Hello();
        hello.showMessage();
    }
}
```

#### 4.2.2 执行maven命令

1. 方式一：
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657468667277-27f5fd5b-74db-4159-b5df-0be99a49ad5b.png#clientId=u00d27f39-8412-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=379&id=u74d43b53&margin=%5Bobject%20Object%5D&name=image.png&originHeight=379&originWidth=733&originalType=binary&ratio=1&rotation=0&showTitle=false&size=42282&status=done&style=none&taskId=u546fb38a-f125-4bea-9a17-09549083286&title=&width=733)
   - 执行下面【插件】内的运行命令效果一致
2. 方式二：
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657469449414-df90b6a3-5043-4172-9a1e-f7c3f25303ba.png#clientId=u00d27f39-8412-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=245&id=u20d189a9&margin=%5Bobject%20Object%5D&name=image.png&originHeight=245&originWidth=701&originalType=binary&ratio=1&rotation=0&showTitle=false&size=28386&status=done&style=none&taskId=ub3a71c33-192c-4529-ada8-a0225db6cfe&title=&width=701)
   - 记得选择执行命令的位置
3. 方式三：
   - 传统命令行终端的形式

### 4.3 创建Maven-web【子】工程

#### 4.3.1 创建过程演示

同4.2.1创建maven-java【子】工程

#### 4.3.2 web环境配置

- 子工程`pom.xml`中添加`<packaging>war</packaging>`
- 生成`WEB-INF`等文件：
  - 方式一：
    - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657470055331-921969f0-69eb-4e84-852d-c70dcac70593.png#clientId=u00d27f39-8412-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=471&id=u04a48bee&margin=%5Bobject%20Object%5D&name=image.png&originHeight=471&originWidth=288&originalType=binary&ratio=1&rotation=0&showTitle=false&size=26995&status=done&style=none&taskId=u4a47fe62-e968-44a2-9eeb-eed73751a5a&title=&width=288)
    - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657470092849-afa254c2-8a15-4f05-b3a7-e28f407bff88.png#clientId=u00d27f39-8412-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=323&id=u549666cb&margin=%5Bobject%20Object%5D&name=image.png&originHeight=323&originWidth=440&originalType=binary&ratio=1&rotation=0&showTitle=false&size=24642&status=done&style=none&taskId=u8fe06ef1-8df0-4d84-ad76-df2258e3855&title=&width=440)
  - 方式二：
    - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657470150323-0481dad9-2cbb-447c-bebc-c3ee30a7796c.png#clientId=u00d27f39-8412-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=366&id=uaca3e91a&margin=%5Bobject%20Object%5D&name=image.png&originHeight=729&originWidth=456&originalType=binary&ratio=1&rotation=0&showTitle=false&size=52435&status=done&style=none&taskId=u6f861734-0bb7-4cb6-b644-b2e07f10ca9&title=&width=229)
    - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657470172300-26c057ea-0a91-4476-9367-c0bc2f0078a8.png#clientId=u00d27f39-8412-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=636&id=u3b663afa&margin=%5Bobject%20Object%5D&name=image.png&originHeight=636&originWidth=666&originalType=binary&ratio=1&rotation=0&showTitle=false&size=44023&status=done&style=none&taskId=uc9abc3e5-3c08-4747-ba67-5a5dd7b1451&title=&width=666)
    - 这里由于使用方式一生成了，所以方式二不显示了

#### 4.3.3 测试环境

![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657470410774-bf64ec0e-b0a2-4be2-b304-f05cbac5b96c.png#clientId=u00d27f39-8412-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=235&id=u67e98755&margin=%5Bobject%20Object%5D&name=image.png&originHeight=235&originWidth=378&originalType=binary&ratio=1&rotation=0&showTitle=false&size=8016&status=done&style=none&taskId=u6d73ea85-86a1-4718-b486-39e74bef529&title=&width=378)

```java
package iceriver.maventest;

/**
 * @author: https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date: 2022/7/11 0:24
 */
public class Message {
    public String getMsg(){
        return "hello maven-web";
    }
}
```

```java
<%@ page import="iceriver.maventest.Message" %><%--
  Created by IntelliJ IDEA.
  User: iceri
  Date: 2022/7/11
  Time: 0:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%= new Message().getMsg()%>
</body>
</html>
```

![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657470555274-83018861-6ea7-4c40-ad59-7cd038afc9e7.png#clientId=u00d27f39-8412-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=715&id=u4b585a40&margin=%5Bobject%20Object%5D&name=image.png&originHeight=715&originWidth=1044&originalType=binary&ratio=1&rotation=0&showTitle=false&size=54894&status=done&style=none&taskId=u3f38a976-ca52-49ad-aa93-40ca9f73c90&title=&width=1044)
![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657470595725-45c420e1-c704-4c98-aa6c-43f485ce7739.png#clientId=u00d27f39-8412-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=145&id=u2da2206e&margin=%5Bobject%20Object%5D&name=image.png&originHeight=145&originWidth=529&originalType=binary&ratio=1&rotation=0&showTitle=false&size=12330&status=done&style=none&taskId=ue4d53023-c6d1-4bdf-888f-519a47b7fb7&title=&width=529)

### 4.4 导入工程

#### 4.4.1 导入自远程仓库

#### 4.4.2 导入自本地磁盘

1. 普通Java工程导入：

![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657499851217-1ffcc2ef-996f-4069-aa65-a7adcd29d787.png#clientId=u00d27f39-8412-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=460&id=u81a2de58&margin=%5Bobject%20Object%5D&name=image.png&originHeight=798&originWidth=510&originalType=binary&ratio=1&rotation=0&showTitle=false&size=76026&status=done&style=none&taskId=u2da88a74-837d-4650-8d97-eedd83a8bf5&title=&width=294)![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657499878242-fd3b4cb5-b416-421e-a336-705b9b9a63fe.png#clientId=u00d27f39-8412-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=187&id=u93409c2c&margin=%5Bobject%20Object%5D&name=image.png&originHeight=187&originWidth=426&originalType=binary&ratio=1&rotation=0&showTitle=false&size=11378&status=done&style=none&taskId=u428de162-3a89-4f99-8efe-45851e22af5&title=&width=426)
![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657499903953-29017671-dc04-4207-a16e-439d0391b5ff.png#clientId=u00d27f39-8412-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=444&id=ud16a86a8&margin=%5Bobject%20Object%5D&name=image.png&originHeight=579&originWidth=424&originalType=binary&ratio=1&rotation=0&showTitle=false&size=35885&status=done&style=none&taskId=u5f8fa191-9a45-44a7-9bd9-e25cde154e2&title=&width=325)![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657499918100-984d72b1-068e-4e30-84da-4dcefde03012.png#clientId=u00d27f39-8412-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=369&id=u8d27dfc3&margin=%5Bobject%20Object%5D&name=image.png&originHeight=584&originWidth=658&originalType=binary&ratio=1&rotation=0&showTitle=false&size=15929&status=done&style=none&taskId=udb03e283-e972-453b-93a5-cfaa5dc3207&title=&width=416)
![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657500653095-aba5083f-1630-46eb-80ae-ec369e5d176b.png#clientId=u00d27f39-8412-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=170&id=u05e771f0&margin=%5Bobject%20Object%5D&name=image.png&originHeight=170&originWidth=355&originalType=binary&ratio=1&rotation=0&showTitle=false&size=9988&status=done&style=none&taskId=ubc5e825d-50d6-4940-86fe-2db41b06c95&title=&width=355)

2. 导入web工程
   - 先按正常Java工程导入
   - 导入后进入为其添加web框架支持即可【4.3.2】

## 第5章 其他核心概念

### 5.1 生命周期

#### 5.1.1 生命周期概述

1. 作用：让构建自动化完成，生命周期的每个环节对应一系列操作
1. 分类：clean、site、default
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657501265535-543e3f59-76fd-4d15-9205-874de80dd7b0.png#clientId=uddf91ff0-5826-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=738&id=uad9eec1e&margin=%5Bobject%20Object%5D&name=image.png&originHeight=738&originWidth=670&originalType=binary&ratio=1&rotation=0&showTitle=false&size=59707&status=done&style=none&taskId=ua6f26f03-d4dd-4a6d-bc23-bc29663e367&title=&width=670)
3. 特点：3个生命周期相互独立，执行任何一个操作，都是从本周起最初的位置开始执行。

### 5.2 插件和目标

#### 5.2.1 插件

- Maven 的核心程序仅仅负责宏观调度，不做具体工作。具体工作都是由 Maven 插件完成的。

#### 5.2.2 仓库

![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1657501965624-b14dab95-fcf8-4903-b7af-c2982f5b8860.png#clientId=u90ba990d-40ae-4&crop=0&crop=0&crop=1&crop=1&from=paste&id=ub744edb0&margin=%5Bobject%20Object%5D&name=image.png&originHeight=231&originWidth=523&originalType=url&ratio=1&rotation=0&showTitle=false&size=15539&status=done&style=none&taskId=ubcfe8829-6460-41bf-8d6c-dc1dc67580c&title=)

- 当 Maven 根据坐标寻找构件时，它会首先查看本地仓库，若本地仓库存在此构件，则直接使用；若本地仓库不存在此构件，Maven 就会去远程仓库查找，若发现所需的构件后，则下载到本地仓库使用。如果本地仓库和远程仓库都没有所需的构件，则 Maven 就会报错。
- 不要中央仓库和阿里云镜像混用，否则 jar 包来源不纯，彼此冲突。
