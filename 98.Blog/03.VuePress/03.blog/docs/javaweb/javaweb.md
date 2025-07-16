---
icon: edit
date: 2022-07-12
category:
  - JavaWeb
# tag:
#   - tag A
#   - tag B
description: 
  - JavaWeb 是指，所有通过 Java 语言编写可以通过浏览器访问的程序的总称，叫 JavaWeb。
---
# JavaWeb

> - JavaWeb 是指，所有通过 Java 语言编写可以通过浏览器访问的程序的总称，叫 JavaWeb。
>
> - JavaWeb 是基于请求和响应来开发的。  
<!-- > - ![](/images/javaweb/20181022211418240) -->
> - ![image.png](/images/javaweb/image.png)

## 第1章 前端基础

> 参见Wbe前端知识库：[Web前端](https://www.yuque.com/zhuyuqi/lfm0mh?view=doc_embed)

关键知识点：

1. 表单提交后，数据未提交（发给服务器）的三种情况：
   - 表单标签没有name属性
   - 单选、复选、下拉列表（`<option>`）都添加上value属性
   - 表单标签没有放在`<form>`标签内
   - action属性不能带参数时，可以设计隐藏域`<input type="hidden">`使用
2. GET 请求的特点是：

   - 浏览器地址栏中的地址是：action 属性[+?+请求参数]
     - 请求参数的格式是：name=value&name=value
   - 提交内容明文显示，不安全
   - 它有数据长度的限制

3. POST 请求的特点是：
   - 浏览器地址栏中只有 action 属性值
   - 相对于 GET 请求要安全
   - 理论上没有数据长度的限
4. &&运算符：全为真时，返回最后一个表达式的值：
   - `alert("abc"&&true)`，返回true
   - `alert(true&&"abc")`，返回abc
5. &&运算符：全为假时，返回第一个表达式为假的值：
   - `alert("abc"&&false)`，返回false
6. || 运算符：

   - 当表达式全为假时，返回最后一个表达式的值
   - 只要有一个表达式为真，就会把回第一个为真的表达式的值  

7. js中变量未初始化，默认为undefined。
7. 隐形参数arguments：
   - js中定义函数时声明形参个数与调用时参数无关，即声明时不传参数，但调用可传入参数，或声明传入参数、调用不传入参数。
   - 在函数内部使用arguments可以获取实际传入的参数个数，arguments是一个数组，可以遍历。
   - 相当于定义函数时：`function(arguments)`，arguments是一个可变长参数
9. 表单验证不合法时阻止提交：本质——`onsubmit="return false"`

```html
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script type="text/javascript" >
      // 静态注册表单提交事务
      function onsubmitFun(){
        // 要验证所有表单项是否合法，如果，有一个不合法就阻止表单提交
        alert("静态注册表单提交事件----发现不合法");
        
        return flase;
      }
      
      window.onload = function () {
        //1 获取标签对象
        var formObj = document.getElementById("form01");
        //2 通过标签对象.事件名 = function(){}
        formObj.onsubmit = function () {
          // 要验证所有表单项是否合法，如果，有一个不合法就阻止表单提交
          alert("动态注册表单提交事件----发现不合法");
          
          return false;
        }
      }
      
    </script>
  </head>
  <body>
    <!--return false 可以阻止 表单提交 -->
    <form action="http://localhost:8080" method="get" onsubmit="return onsubmitFun();">
      <input type="submit" value="静态注册"/>
    </form>
    <form action="http://localhost:8080" id="form01">
      <input type="submit" value="动态注册"/>
    </form>
    
  </body>
</html>
```

10. 验证提示效果：

```html
<!DOCTYPE html>
<html>
 <head>
  <meta charset="UTF-8">
  <title>尚硅谷会员注册页面</title>
  <link type="text/css" rel="stylesheet" href="../../static/css/style.css" >
  <script type="text/javascript" src="../../static/script/jquery-1.7.2.js"></script>
  <script type="text/javascript">
   // 页面加载完成之后
   $(function () {
    // 给注册绑定单击事件
    $("#sub_btn").click(function () {
     // 验证用户名：必须由字母，数字下划线组成，并且长度为5到12位
     //1 获取用户名输入框里的内容
     var usernameText = $("#username").val();
     //2 创建正则表达式对象
     var usernamePatt = /^\w{5,12}$/;
     //3 使用test方法验证
     if (!usernamePatt.test(usernameText)) {
      //4 提示用户结果
      $("span.errorMsg").text("用户名不合法！");

      return false;
     }

     // 验证密码：必须由字母，数字下划线组成，并且长度为5到12位
     //1 获取用户名输入框里的内容
     var passwordText = $("#password").val();
     //2 创建正则表达式对象
     var passwordPatt = /^\w{5,12}$/;
     //3 使用test方法验证
     if (!passwordPatt.test(passwordText)) {
      //4 提示用户结果
      $("span.errorMsg").text("密码不合法！");

      return false;
     }

     // 验证确认密码：和密码相同
     //1 获取确认密码内容
     var repwdText = $("#repwd").val();
     //2 和密码相比较
     if (repwdText != passwordText) {
      //3 提示用户
      $("span.errorMsg").text("确认密码和密码不一致！");

      return false;
     }

     // 邮箱验证：xxxxx@xxx.com
     //1 获取邮箱里的内容
     var emailText = $("#email").val();
     //2 创建正则表达式对象
     var emailPatt = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
     //3 使用test方法验证是否合法
     if (!emailPatt.test(emailText)) {
      //4 提示用户
      $("span.errorMsg").text("邮箱格式不合法！");

      return false;
     }

     // 验证码：现在只需要验证用户已输入。因为还没讲到服务器。验证码生成。
     var codeText = $("#code").val();

     //去掉验证码前后空格
     // alert("去空格前：["+codeText+"]")
     codeText = $.trim(codeText);
     // alert("去空格后：["+codeText+"]")

     if (codeText == null || codeText == "") {
      //4 提示用户
      $("span.errorMsg").text("验证码不能为空！");

      return false;
     }

     // 去掉错误信息
     $("span.errorMsg").text("");

    });

   });

  </script>
 <style type="text/css">
  .login_form{
   height:420px;
   margin-top: 25px;
  }

 </style>
 </head>
 <body>
  <div id="login_header">
   <img class="logo_img" alt="" src="../../static/img/logo.gif" >
  </div>

   <div class="login_banner">

    <div id="l_content">
     <span class="login_word">欢迎注册</span>
    </div>

    <div id="content">
     <div class="login_form">
      <div class="login_box">
       <div class="tit">
        <h1>注册尚硅谷会员</h1>
        <span class="errorMsg"></span>
       </div>
       <div class="form">
        <form action="http://localhost:8080">
         <label>用户名称：</label>
         <input class="itxt" type="text" placeholder="请输入用户名"
             autocomplete="off" tabindex="1" name="username" id="username" />
         
         <label>用户密码：</label>
         <input class="itxt" type="password" placeholder="请输入密码"
             autocomplete="off" tabindex="1" name="password" id="password" />
         
         <label>确认密码：</label>
         <input class="itxt" type="password" placeholder="确认密码"
             autocomplete="off" tabindex="1" name="repwd" id="repwd" />
         
         <label>电子邮件：</label>
         <input class="itxt" type="text" placeholder="请输入邮箱地址"
             autocomplete="off" tabindex="1" name="email" id="email" />
         
         <label>验证码：</label>
         <input class="itxt" type="text" style="width: 150px;" id="code"/>
         <img alt="" src="../../static/img/code.bmp" style="float: right; margin-right: 40px">
         <input type="submit" value="注册" id="sub_btn" />
        </form>
       </div>

      </div>
     </div>
    </div>
   </div>
  <div id="bottom">
   <span>
    尚硅谷书城.Copyright &copy;2015
   </span>
  </div>
 </body>
</html>
```

11. 正则表达式：

[常用正则表达式.txt](https://www.yuque.com/attachments/yuque/0/2022/txt/1604140/1656635437474-a756d548-72b5-4d16-a716-2b86802009db.txt)

- `patt.test(str)`：验证str是否满足patt的规则。

12. `<base>`标签：

- 设置当前页面中所有相对路径的参照路径

13. web中`/`的不同含义：代表绝对路径

- 浏览器解析：【<http://ip:port/>】
- 服务器解析：【<http://ip:port/>工程路径】
  - 服务器重定向时（`response.sendRediect("/")`）：表示把`/`发送给浏览器解析，得到的是【`<http://ip:port/>`】

## 第2章 BS和CS

### 2.1 BS

1. 浏览器服务器架构模式
   - 优点：客户端不需要安装，升级维护成本较低
   - 缺点：所有计算和存储都放在服务器端，服务器计算完成后将结果传输给客户端，服务器符合较重，且客户端与服务器端会进行非常频繁的数据通信，导致网络负荷较重。

### 2.2 CS

1. 客户端服务器架构模式
   - 优点：充分来利用客户端机器资源，减轻服务器的负荷。
      - 一部分安全要求不高的计算任务、存储任务放在客户端执行，减轻服务器的压力，也减轻网络负荷。
   - 缺点：需要安装客户端程序，且升级维护成本较高。

## 第3章 Tomcat的使用

### 3.1 Tomcat简介

1. Tomcat 服务器是一个免费的开放源代码的Web 应用服务器，属于轻量级应用服务器，在中小型系统和并发访问用户不是很多的场合下被普遍使用，是开发和调试JSP 程序的首选。
1. java官方提供。

1. 版本
   -

   - ![image.png](/images/javaweb/image-1660813756160.png)
4. import包时，tomcat8和tomcat10的包名不一样

### 3.2 Tomcat使用

1. 下载：
   - 使用JDK8开发，本文下载了Tomcat8.5版本。
   - ![image.png](/images/javaweb/image-1660813758818.png)
2. 安装：解压至非中文、无空格、特殊字符路径下。
2. 目录介绍：
   - ![image.png](/images/javaweb/image-1660813764793.png)
   -
      - bin：程序运行文件夹
      - lib：程序运行的依赖库
      - conf：配置文件
      - logs：运行日志
      - temp：缓存文件目录
      - webapps：项目布署目录
      - work：工作目录
4. 配置环境变量：
   - 前提：需要配置`JAVA_HOME`环境变量。虽然安装java时，环境变量`Path`下已经有默认配置，能够在任何位置的cmd终端执行`java`命令，但配置Tomcat仍然需要重新配置`JAVA_HOME`，否则会出现执行Tomcat的开启命令会出现一闪而过的情况，Tomcat也不会运行起来。
      - ![image.png](/images/javaweb/image-1660813767426.png)
   - 配置了java环境变量后，执行`bin/startup.bat`
      - ![image.png](/images/javaweb/image-1660813769887.png)
      - 乱码问题：修改`conf/logging.properties`文件，添加`java.util.logging.ConsoleHandler.encoding = GBK`指令。
         - ![image.png](/images/javaweb/image-1660813772535.png)
   - 访问：[http://localhost:8080/](http://localhost:8080/)
      - ![image.png](/images/javaweb/image-1660813774651.png)
5. 新建Web项目，并布署：
   - 在`webapps`路径下，新建`网址名/WEB-INF`，如`webdesign`，将写好的网页放到该目录下
      - ![image.png](/images/javaweb/image-1660813777135.png)
      - ![image.png](/images/javaweb/image-1660813779100.png)
      - `WEB-INF`不能修改。

## 第4章 IDEA中新建Web项目

### 4.1 创建项目

#### 4.1.1 方式一

1. 不同版本的IDEA创建web项目的操作方式，本文以IDEA2022.1.3为例。
1. 新建项目（模块），指明存放路径，jdk版本
   - ![image.png](/images/javaweb/image-1660813782764.png)
   - ![image.png](/images/javaweb/image-1660813785306.png)
3. 右键项目（模块），添加Web框架支持
   - ![image.png](/images/javaweb/image-1660813787347.png)
   - ![image.png](/images/javaweb/image-1660813789996.png)
   - ![image.png](/images/javaweb/image-1660813792934.png)

#### 4.1.2 方式二

1. 新建模块：
   - ![image.png](/images/javaweb/image-1660813795072.png)
2. 设置项目结构
   - ![image.png](/images/javaweb/image-1660813797250.png)
3. 添加Web程序：
   - ![image.png](/images/javaweb/image-1660813799406.png)
4. 生成部署包（工件、atrifacts）：
   - ![image.png](/images/javaweb/image-1660813801515.png)
   - 拓展：war包，压缩后的web应用程序包，打包放到tomcat的webapps路径下，会自动解压
      - ![image.png](/images/javaweb/image-1660813803578.png)

#### 4.1.2 导入其他人项目

1. 同4.1.1操作
1. ![image.png](/images/javaweb/image-1660813805878.png)

### 4.2 运行配置（Tomcat配置）

1. 添加Tomcat本地服务器
   - ![image.png](/images/javaweb/image-1660813808548.png)
   - ![image.png](/images/javaweb/image-1660813811945.png)
   - ![image.png](/images/javaweb/image-1660813813569.png)
2. 配置访问地址：
   - ![image.png](/images/javaweb/image-1660813815788.png)
   - url表示默认打开浏览器时的地址。
3. 部署服务器端的文件（使服务器能打开本地文件）
   - ![image.png](/images/javaweb/image-1660813818318.png)
   - ![image.png](/images/javaweb/image-1660813820704.png)
   - `应用程序上下文`：设置为`/`时，表示访问服务器根目录即能访问到该web程序。
      - 如果找不到工件，则按照下面的方式
      - ![image.png](/images/javaweb/image-1660813829522.png)![image.png](/images/javaweb/image-1660813825953.png)
>
> - 配置总结：
>
![image.png](/images/javaweb/image-1660813833442.png)
> 这个页面的地址最后带不带/都没有关系
> ![image.png](/images/javaweb/image-1660813835468.png)
> 这个页面的这个名称要写到第一个图的地址后面
> ![image.png](/images/javaweb/image-1660813838004.png)
> 这个界面的路径要到`web`目录下

### 4.3 热更新配置

1. 设置热更新：
   - ![image.png](/images/javaweb/image-1660813841000.png)

### 4.4 配置servlet api

1. 要能写服务端程序，则要求改程序必须实现自servlet接口或继承自GenericServlet 类和 HttpServlet 类（参见5.1）
1. 方式一：添加`servlet-api.jar`至lib文件夹，同Druid
   - ![image.png](/images/javaweb/image-1660813843805.png)
3. 方式二：
   - ![image.png](/images/javaweb/image-1660813845443.png)
   - ![image.png](/images/javaweb/image-1660813848904.png)
   - 添加后会显示为外部库文件
      - ![image.png](/images/javaweb/image-1660813851541.png)

### 4.5 部分错误类型及解决方式

#### 4.5.1 未添加Servlet运行程序（容易404）

1. ![image.png](/images/javaweb/image-1660813853774.png)
1. ![image.png](/images/javaweb/image-1660813856741.png)

## 第5章 Servlet入门

[06_尚硅谷_Servlet_王振国 - 课堂笔记.pdf](https://www.yuque.com/attachments/yuque/0/2022/pdf/1604140/1656685756637-9de0d9a4-333f-4269-a645-e8560308393e.pdf)

### 5.1 Servlet简介

#### 5.1.1 Servlet介绍

1. 作用：Servlet是Server Applet的缩写，称为服务器端小程序，是一种使用Java语言来开发动态网站的技术。
1. Serlet几乎可以使用Java的所有API。
1. 出现背景：使用Java原生代码开发动态网站需要手动解析HTTP请求报头、需要分析用户的请求参数、需要加载数据库组件……过程极其麻烦，基于上述原因，Java官方推出了Servlet技术，对开发动态网站需要使用的JavaAPI进行了封装，形成了一套新的API，称为Servlet API。
1. 本质：Servlet是一套Java Web的开发规范（开发技术标准），只有实现（编写代码实现Servlet规范中的各类功能——类、方法、属性）了该规范才能进行web开发。
1. 体现：一个Servlet程序实际上是按照Servlet规范编写的Java类，Servlet程序需要编译成字节码文件（`.class`）才能部署到服务器运行。
1. Servlet功能实现方式：实现Servlet接口能获得Servlet的所有功能。但需要实现很多方法，比较麻烦，所以Servlet规范提供了两个实现了Servlet接口常用功能（方法）的类：GenericServlet 类和 HttpServlet 类，其中HttpServlet 类的使用更为方便。
   - ![image.png](/images/javaweb/image-1660813864059.png)
7. Servlet 就是JavaWeb 三大组件之一。三大组件分别是：Servlet 程序、Filter 过滤器、Listener 监听器 。

#### 5.1.2 Servlet继承关系

1. 类图：
   - ![image.png](/images/javaweb/image-1660813866216.png)
   - ![image.png](/images/javaweb/image-1660813868112.png)
   - Tomcat8中，包为`javax`，Tomcat10中，包为`jakarta`
2. 相关方法：
   - `javax.servlet.Servlet`接口:
      - `void init(config)` - 初始化方法
      - `void service(request,response)`- 服务方法
      - `void destory()`- 销毁方法
   - `javax.servlet.GenericServlet`抽象类：
      - `void service(request,response)`- 仍然是抽象的
   - `javax.servlet.http.HttpServlet` 抽象子类：
      - `void service(request,response)`- 不是抽象的
3. 当有请求过来时，service方法会自动响应（其实是tomcat容器调用的）

### 5.2 Servlet容器（Web容器）

#### 5.2.1 Web服务器

1. web服务器功能比较单一，一般只能提供http(s)服务，使用户可以访问静态资源（HTML 文档、图片、CSS 文件、JavaScript 文件等），它们不能执行任何编程语言，也不能访问数据库，更不能让用户注册和登录。——静态网站。
1. 要部署动态网站，还要有编程语言运行环境和数据库管理系统的支持。
   - 运行环境：支持脚本语言运行的部件（解释器、垃圾回收器、标准库等）的统称。又称运行时（Runtime)
   - 数据库：mysql等
3. 常见web服务器：
   - 运行 PHP 网站一般选择 Apache 或者 Nginx；
   - 运行 ASP/ASP.NET 网站一般选择 IIS；
   - 运行 Python 网站一般选择内置的 WSGI 服务器模块——wsgiref。
4. 动态网站三大组件：Web服务器+脚本语言运行环境+数据库

#### 5.2.2 web容器

1. servlet容器：servlet代码的运行环境，包括：
   - jre（JVM、Java核心类库、一些副属性文件），并不支持Servlet规范？
   - 实现Servlet规范定义的各类接口和类：
   - 管理用户编写的Servlet类，以及实例化以后的对象——我们编写的Servlet类没有main()，不能独立运行，知道能当作一个模块加载到Servlet容器，由容器进行实例化并调用方法。
   - 提供HTTP服务，相当于简化web服务器。
2. 常见web容器：Tomcat、Jboss、Jetty、WebLogic等，实现了Servlet规范。
2. 工作过程：一个动态页面对应一个Servlet类，开发一个动态页面就是编写一个 Servlet 类，当用户请求到达时，Servlet 容器会根据配置文件（web.xml）来决定调用哪个类。

### 5.3 url地址到Servlet程序的访问

#### 5.3.1 Servlet部署

1. Servlet 规范规定，JavaWeb 应用必须采用固定的目录结构，即每种组件在 JavaWeb 应用中都有固定的存放目录。
   - ![image.png](/images/javaweb/image-1660813872416.png)
| 目录 | 描述 | 是否必需 |
| --- | --- | --- |
| \\servletDemo | Web 应用的根目录，属于该 Web 应用的所有资源都存放在这个目录下。 | 是 |
| \\servletDemo\\WEB-INF | 存放 web.xml、lib 目录以及 classes 目录等。 | 是 |
| \\servletDemo\\WEB-INF\\classes | 存放各种 .class 文件或者包含 .class 文件的目录，Servlet 类的 .class 文件也存放在此。 | 否 |
| \\servletDemo\\WEB-INF\\lib | 存放应用所需的各种 jar 包，例如 JDBC 驱动程序的 jar 包。 | 否 |
| \\servletDemo\\WEB-INF\\web.xml | web.xml 中包含应用程序的配置和部署信息。 | 是 |

2. 部署（手动不使用IDEA工具的方式）：将servletDemo文件夹复制到`/webapps`目录下
   - ——实质是在`/webapps`目录下编写程序。

#### 5.3.2 Servlet访问配置

![image.png](/images/javaweb/image-1660813876459.png)

#### 5.3.3 Servlet虚拟路径映射

1. Servlet单一映射：
   - 方式一：在web.xml文件中配置
   - 方式二：使用@WebServlet：`@WebServlet("/MyServlet")`，省略了urlPatterns =
2. Servlet多重映射：
   - 方式一：在web.xml文件中配置多个`<servlet-mapping>`元素
   - 方式一：在web.xml文件中配置多个`<url-pattern>`元素
   - 方式二：使用@WebServlet：`@WebServlet(urlPatterns = {"/MyServlet", "/MyServlet2"})`

#### 5.3.4 项目中地址的使用

1. 开发中一般使用绝对路径+相对路径的形式，或者绝对路径的形式
1. `<base>`标签设置在html文件中，只对当前的html页面生效。写路径时`/`配合`<base>`标签一起看。
   - 一般不写`/`
   - 但也可以写为`./`
   - html页面的所有地址【HTML的和servlet的】，都要配合`<base>`标签一起看。
   - 建议规范：html页都不带`/`
3. 在servlet程序中，默认为工程路径（Tomcat配置的http全路径）【忽略了src目录、各个包目录，直接到类】，写路径时带不带`/`都不影响【有影响，但规律还没把握】
   - 建议规范：servlet页面都带`/`
   - `<%@include file="/pages/common/manager_meun.jsp"%>`必须以`/`开头
4. `/`被web解析，表示`http://ip:port/`，被服务器解析，表示`http://ip:port/工程路径`

### 5.4 Servlet的生命周期

![image.png](/images/javaweb/image-1660813880939.png)

1. Servlet构造器方法（创建Servlet实例——由于是tomcat去创建，所以构造器不能用private修饰）
   - 第一次访问时调用。
2. init初始化方法
   - 第一次访问时调用。
   - 作用：建立数据库连接，获取配置信息等
3. service方法
   - 每次访问都会调用。
4. destroy销毁方法
   - web工程停止的时候调用（工程停止不是切换浏览器的访问地址）
5. 默认情况下，第一此请求时tomcat才会创建Servlet实例化对象、调用`init()`，便于提高启动速度，但会造成首次请求等待时间较长。
5. xml文件中，配置`<load-on-startup>`控制创建实例对象、初始化方法的时机【见5.7.4】。这样的好处是提高了首次请求的响应时间，但带来问题是启动变慢。
5. Servlet在容器中是单例、线程不安全的。
   - 单例：所有的请求都是同一个实例去响应
   - 线程不安全：一个线程需要根据这个实例中的某个成员变量值去做逻辑判断。但是在中间某个时机，另一个线程改变了这个成员变量的值，从而导致第一个线程的执行路径发生了变化
      - 尽量的不要在servlet中定义成员变量。如果不得不定义成员变量，那么：①不要去修改成员变量的值 ②不要去根据成员变量的值做一些逻辑判断

### 5.5 GET和POST请求分发处理

1. 实现Servlet接口的HttpServlet类中的service方法，会根据http数据传输方式不同做不同的处理。

```java
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String method = req.getMethod();
    long lastModified;
    if (method.equals("GET")) {
        lastModified = this.getLastModified(req);
        if (lastModified == -1L) {
            this.doGet(req, resp);
        } else {
            long ifModifiedSince;
            try {
                ifModifiedSince = req.getDateHeader("If-Modified-Since");
            } catch (IllegalArgumentException var9) {
                ifModifiedSince = -1L;
            }

            if (ifModifiedSince < lastModified / 1000L * 1000L) {
                this.maybeSetLastModified(resp, lastModified);
                this.doGet(req, resp);
            } else {
                resp.setStatus(304);
            }
        }
    } else if (method.equals("HEAD")) {
        lastModified = this.getLastModified(req);
        this.maybeSetLastModified(resp, lastModified);
        this.doHead(req, resp);
    } else if (method.equals("POST")) {
        this.doPost(req, resp);
    } else if (method.equals("PUT")) {
        this.doPut(req, resp);
    } else if (method.equals("DELETE")) {
        this.doDelete(req, resp);
    } else if (method.equals("OPTIONS")) {
        this.doOptions(req, resp);
    } else if (method.equals("TRACE")) {
        this.doTrace(req, resp);
    } else {
        String errMsg = lStrings.getString("http.method_not_implemented");
        Object[] errArgs = new Object[]{method};
        errMsg = MessageFormat.format(errMsg, errArgs);
        resp.sendError(501, errMsg);
    }

}
```

2. 如果后端的处理方法（do方法）与请求方法不一致，会报405错误

### 5.6 IDEA创建Servlet程序

1. 确认模块添加了Tomcat依赖（步骤4.4，即添加了servlet api）
   - ![image.png](/images/javaweb/image-1660813885254.png)
2. 右键src目录，新建servlet程序
   - ![image.png](/images/javaweb/image-1660813887292.png)

### 5.7 Servlet底层原理

#### 5.7.1 Servlet类的继承关系

![image.png](/images/javaweb/image-1660813889693.png)

#### 5.7.2 ServletConfig类

1. servlet程序的配置信息类
1. Servlet程序和ServletConfig对象都是由Tomcat创建的，程序员负责使用
   - Servlet程序默认是第一次访问时创建
   - ServletConfig是每个Servlet程序创建时创建
3. 获取（假设MyServlet继承自HttpServlet）：
   - 方式一：定义`private ServletConfig servletConfig`，重写`init()`方法
      - 如果不声明`servletConfig`，则必须在重写`init()`方法时，显式的调用`super.init(config)`，否则会空指针异常
   - 方式二：调用 GenericServlet 提供的 getServletConfig()方法：`ServletConfig servletConfig = this.getServletConfig()`
4. 配置Servlet初始化参数：
   - 方式一：在web.xml文件中配置
   - 方式二：使用@WebServlet配置
5. 作用：
   - 获取Servlet程序的别名`<servlet-name>`的值。（web.xml文件中）
      - 使用`servletConfig.getServletName()`
   - 获取初始化参数`<init-param>`
      - 使用`servletConfig.getInitParameter("参数名")`——参数名是web.xml文件中配置的`<param-name>`，获取到的值是`<param-value>`
   - 获取ServletContext对象:getServletContext() 方法
      - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1656726016040-1da277bb-bac4-45dc-85c4-a91202787a74.png#clientId=u74efd510-37c1-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=27&id=u1234f848&margin=%5Bobject%20Object%5D&name=image.png&originHeight=27&originWidth=667&originalType=binary&ratio=1&rotation=0&showTitle=false&size=29987&status=done&style=none&taskId=u1fedd3ce-082f-4439-8434-0572309b2f6&title=&width=667)

#### 5.7.3 ServletContext类

1. 表示Servlet上下文对象的一个接口，一个web工程，只有一个ServletContext实例。
   - Servlet上下文：Servlet容器启动时，为每个Web应用（webapps文件夹下的每个目录）创建一个唯一的ServletContext对象，该对象称为Servlet上下文
2. ServletContext对象是一个域对象
   - 域对象：可以像map一样存储数据的对象，域指的是存储数据的操作范围，域对象是值服务器在内存上创建的存储空间，该空间用于不同资源之间共享数据。
   - ServletContext的域是整个工程。所以不同Servlet之间可以通过ServletContext对象实现数据通信。
      - 域对象特性：![image.png](/images/javaweb/image-1660813894254.png)
   - 另外两个域对象时reques和session
3. ServletContext在web工程启动时创建，停止时销毁。
3. 获取ServletContext对象：
   - 通过 GenericServlet 提供的 getServletContext() 方法
   - 通过 ServletConfig 提供的 getServletContext() 方法
   - 通过 HttpSession 提供的 getServletContext() 方法
   - 通过 HttpServletRequest 提供的 getServletContext() 方法
5. 作用：
   - 获取web.xml 中配置的上下文参数context-param
      - `getInitParameter(str)`
   - 获取当前的工程路径，格式: `/工程路径`，![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1656756489508-35845f43-e306-4be9-8970-8107842f7512.png#clientId=u74efd510-37c1-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=28&id=ud53e2d6a&margin=%5Bobject%20Object%5D&name=image.png&originHeight=28&originWidth=190&originalType=binary&ratio=1&rotation=0&showTitle=false&size=1193&status=done&style=none&taskId=uc3c2d893-4827-453a-b5c8-ddaf2cc9634&title=&width=190)
      - `getContextPath()`
   - 获取工程部署后在服务器硬盘上的绝对路径，`D:\实践练习\07.JavaWeb\out\artifacts\servlet1_8_war_exploded\`
      - `getRealPath("/")`
   - 像Map 一样存取数据
6. 获取上下文初始化参数：
   - 设置上下文初始化参数：
      - 方式一：在web.xml文件中，使用`<context-param>`及其子标签
      - 方式二：在Servlet程序中，使用ServletContext对象的`setAtrribute()`方法
   - 获取上下文初始化参数：
      - 方式一：![image.png](/images/javaweb/image-1660813897647.png)
      - 方式二：![image.png](/images/javaweb/image-1660813900275.png)
   - 两种方式对比：
      - ![image.png](/images/javaweb/image-1660813902107.png)
7. 读取web应用下的资源文件
   - ![image.png](/images/javaweb/image-1660813903978.png)
   - 参数 path 代表资源文件的虚拟路径，它以正斜线`/`开始，`/`表示当前 Web 应用的根目录。

#### 5.7.4 load-on-startup元素

1. 作用：控制Servlet启动优先级
1. 使用在web.xml文件中，是`<servlet>`的子元素节点。
1. 取值规则
   - 它的取值必须是一个整数；
   - 当值小于 0 或者没有指定时，则表示容器在该 Servlet 被首次请求时才会被加载；
   - 当值大于 0 或等于 0 时，表示容器在启动时就加载并初始化该 Servlet，取值越小，优先级越高；
   - 当取值相同时，容器就会自行选择顺序进行加载。

#### 5.7.5 HttpServletRequest类

1. 作用：每次Servlet容器接收到HTTP请求，就会创建一个HttpServletRequest对象，通过该对象，可以获取对象传递给服务器的信息。
1. 生命周期：Servlet容器接到HTTP请求时创建，Servlet容器将响应信息返回给客户端后销毁。
1. 获取请求行的方法：
   - ![image.png](/images/javaweb/image-1660813908306.png)
   - `getRemoteHost()`：在浏览器中使用localhost、127.0.0.1访问时，返回127.0.0.1，使用真实ip访问时，返回真实的客户端ip
4. 获取请求头的方法
   - ![image.png](/images/javaweb/image-1660813911884.png)
5. 获取表单数据的方法：
   - ![image.png](/images/javaweb/image-1660813914280.png)
6. 中文乱码问题：
   - GET请求：Get 请求将请求数据附加到 URL 后面作为参数，浏览器发送文字时采用的编码格式与页面编码保持一致（utf-8）。如果 Tomcat 没有设置字符集，接收 URL 时默认使用 ISO-8859-1 进行解码，ISO-8859-1 不兼容中文
   - POST请求：POST 提交的数据在请求体中，其所使用的编码格式时页面一致（即 utf-8）。request 对象接收到数据之后，会将数据放到 request 缓冲区，缓冲区的默认字符集是 ISO-8859-1（该字符集不支持中文），两者使用的字符集不一致导致乱码。
   - GET请求：【jdk8之前，jdk8及之后版本不会乱码】
      - 方式一：修改 tomcat/conf/server.xml 中的配置：`<Connector port="80" protocol="HTTP/1.1" connectionTimeout="20000" redirectPort="8443" URIEncoding="UTF-8"/>`【第70行左右】
      - 方式二：使用 URLEncoder 和 URLDecoder 进行编码和解码的操作（逆向编解码）：
         - `String username = request.getParameter("username");`
         - `username = URLEncoder.encode(username, "ISO8859-1");`
         - `username = URLDecoder.decode(username, "UTF-8");`
      - 方式三：使用 String 的构造方法：String(byte[] bytes, String charset) ，对字节数组（bytes）按照指定的字符集（charset）进行解码，返回解码后的字符串
         - `String username = request.getParameter("username");`
         - `username = new String(username.getBytes("ISO-8859-1"),"UTF-8");`
   - POST请求：
      - 在获取请求参数之前设置 request 缓冲区字符集为 utf-8
         - `request.setCharacterEncoding("utf-8");`
         - `String username = request.getParameter("username");`

#### 5.7.6 请求转发

1. 含义：容器接收请求后，Servlet 会先对请求做一些预处理，然后将请求传递给其他 Web 资源，来完成包括生成响应在内的后续工作。
1. 对象：RequestDispatcher对象由Servlet容器创建，用于封装由路径所标识的Web资源。利用RequestDispatcher 对象可以把请求转发给其他的 Web 资源。
1. 获取RequestDispatcher对象：
   - 调用 ServletContext 的 getRequestDispatcher(String path) 方法，参数 path 指定目标资源的路径，必须为绝对路径——以`/`打头；
   - 调用 ServletRequest 的 getRequestDispatcher(String path) 方法，参数 path 指定目标资源的路径，可以为绝对路径，也可以为相对路径。
   - 绝对路径是指以符号“/”开头的路径，“/”表示当前 Web 应用的根目录。相对路径是指相对当前 Web 资源的路径，不以符号“/”开头。
4. RequestDispatcher对象的方法：
   - ![image.png](/images/javaweb/image-1660813918418.png)
5. 请求转发特点：
   - 请求转发不支持跨域访问，只能跳转到当前应用中的资源。
   - 请求转发之后，浏览器地址栏中的 URL 不会发生变化，因此浏览器不知道在服务器内部发生了转发行为，更无法得知转发的次数。
   - 参与请求转发的 Web 资源之间共享同一 request 对象和 response 对象。
   - 由于 forward() 方法会先清空 response 缓冲区，因此只有转发到最后一个 Web 资源时，生成的响应才会被发送到客户端。
6. request域对象：
   - 作用：不同Servlet程序间传递数据
   - 方法：
      - ![image.png](/images/javaweb/image-1660813920671.png)
   - 与Context域对象的不同点：
      - ![image.png](/images/javaweb/image-1660813923031.png)

#### 5.7.7 HttpServletResponse类

1. 作用：每次Servlet容器接收到HTTP请求，就会创建一个HttpServletResponse对象，通过该对象，可以向客户端传递信息。
1. 生命周期：Servlet容器接到HTTP请求时创建，Servlet容器将响应信息返回给客户端后销毁。
1. 设置响应行的方法：
   - ![image.png](/images/javaweb/image-1660813924894.png)
4. 设置响应头的方法
   - ![image.png](/images/javaweb/image-1660813927311.png)
5. 向客户端传递信息（响应体设置）的方法：
   - ![image.png](/images/javaweb/image-1660813930245.png)
   - getOutputStream() 和 getWriter() 方法互相排斥，不可同时使用，否则会发生 IllegalStateException 异常。
6. 中文乱码问题：
   - 字节流输出：不一定乱码，取决于服务器Servlet程序的字符集是否与浏览器字符集一致。
   - 字符流输出：一定乱码。response 缓冲区的默认字符集是 ISO-8859-1，该字符集不支持中文。
   - 字节流解决方案：将中文转成字节数组时和浏览器默认采用的字符集保持一致
      - `response.setHeader("Content-Type", "text/html;charset=UTF-8");`
      - `byte[] str = "编程帮 www.biancheng.net".getBytes("UTF-8");`
   - 字符流解决方案：将resopnse缓冲区编码与浏览器设置一致
      - 方式一：
         - `response.setCharacterEncoding("UTF-8");`
         - `response.setHeader("Content-Type", "text/html;charset=UTF-8");`
      - 方式二：
         - `response.setContentType("text/html;charset=UTF-8");`

#### 5.7.8 请求重定向

1. 含义：服务器端接收到请求后，通知客户端去请求另外的地址。
1. 属于客户端行为。
1. 本质上是2次Http请求。
1. 工作流程：
   - ![image.png](/images/javaweb/image-1660813933673.png)
5. 重定向和转发的区别：
   - ![image.png](/images/javaweb/image-1660813935590.png)
6. 方法：
   - 方式一：
      - ![image.png](/images/javaweb/image-1660813937750.png)
   - 方式二：（推荐）
      - ![image.png](/images/javaweb/image-1660813939580.png)
      - 注意路径问题，该路径由浏览器解析
7. **经典案例：生成验证码**

### 5.8 @WebServlet注解（Servlet注解）

#### 5.8.1 Servlet注解介绍

1. 出现原因：解决Servlet程序过多，web.xml文件过长的问题。
1. 使用方式：注解写在Servlet程序（类）中，只对当前类有效。
1. 出现版本：Servlet3.0，使用注解使web.xml不再是必选项。
   - @WebServlet
   - @WebInitParm
   - @WebFilter
   - @WebLitener等

#### 5.8.2 @WebServlet注解的属性

![image.png](/images/javaweb/image-1660813942463.png)

#### 5.8.3 @WebServlet 注解的使用

1. 在web.xml文件中，将属性`metadata-complete`设置为fasle或不配置时，表示启用注解支持，配置为true时，表示容器部署时至依赖web.xml
1. 示例：

> @WebServlet(
> asyncSupported =**true**,
> name ="myServlet",
> description ="name描述",
> loadOnStartup =1,
> urlPatterns ={"/MyServlet","/*"},
> initParams ={
> @WebInitParam(name ="编程帮", value ="www.biancheng.net", description ="init参数1"),
> @WebInitParam(name ="京东", value ="www.jd.com", description ="init参数2")
> })

3. 注意点：
   - 通过实现 Serlvet 接口或继承 GenericServlet 创建的 Servlet 类无法使用 @WebServlet 注解。
   - 通过web.xml文件和注解同时配置属性时，若取值相同则忽略注解中的配置。

### 5.9 Listener 监听器

#### 5.9.1 介绍

1. 本质：JavaEE的规范（接口）
1. 作用：监听另一个Java对象的方法调用或属性改变，当监听到上述事件，监听器的方法立即执行。

#### 5.9.2 分类

1. Servlet 规范中定义了 8 个监听器接口，可以用于监听 ServletContext、HttpSession 和 ServletRequest 对象的生命周期和属性变化事件。
1. 开发 Servlet 监听器需要实现相应的监听器接口并重写接口中的方法。
1. 按照监听的事件划分，分为三类：
   - 监听对象创建和销毁的监听器
   - 监听对象中属性变更的监听器
   - 监听 HttpSession 中的对象状态改变的监听器

#### 5.9.3 监听对象创建和销毁的监听器

![image.png](/images/javaweb/image-1660813946211.png)

- 目前仅有`ServletContextListener`有使用机会。
  - 作用：监听`SrvletContext`对象的创建和销毁
  - 生命周期：web工程启动时创建，web工程停止时销毁

#### 5.9.4 监听属性变更的监听器

![image.png](/images/javaweb/image-1660813948157.png)

#### 5.9.5 监听 Session 中对象状态改变的监听器

![image.png](/images/javaweb/image-1660813950697.png)

#### 5.9.6 注册监听器

1. 在 web.xml 中注册监听器；
   - ![image.png](/images/javaweb/image-1660813955374.png)
2. 使用 @WebListener 注册监听器。
2. 使用 HttpSessionBindingListener 和 HttpSessionActivationListener 时，不必进行注册，直接创建 Java 类实现这两个接口即可。

#### 5.9.7 设置监听器参数

1. 在xml文件中设置初始化参数：

```java
@WebListener
public class ContextLoaderListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //1.获取ServletContext对象
        ServletContext application = servletContextEvent.getServletContext();
        //2.获取上下文的初始化参数
        String path = application.getInitParameter("contextConfigLocation");
        //3.创建IOC容器
        BeanFactory beanFactory = new ClassPathXmlApplicationContext(path);
        //4.将IOC容器保存到application作用域
        application.setAttribute("beanFactory",beanFactory);
    }
    
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        
    }
}
```

#### 5.9.7 经典案例——统计在线人数

### 5.x 其他技术

#### 5.x.1 JSP

1. Servlet是第一代Java Web开发技术，编写HTML代码相当于拼接字符串，最后以字符串的形式向外输出。
1. JSP是第二代Java Web开发技术。允许 HTML 代码和 JSP 代码分离，让程序员能够在 HTML 文档中直接嵌入 JSP 代码。 分离了还是嵌入了？？？？

#### 5.x.2 Applet

1. Applet是客户端小程序，一般嵌入HTML页面，运行在支持Java的浏览器（安装了Java虚拟机）中。
1. 目前已经被JavaScript全面代替。

## 第6章 XML

[05_尚硅谷_xml_王振国 - 课堂笔记.pdf](https://www.yuque.com/attachments/yuque/0/2022/pdf/1604140/1656817155842-f32022ea-88f2-4c60-9aee-e42ffa537ff8.pdf)

### 6.1 作用

1. 用来保存数据，而且这些数据具有自我描述性
1. 它还可以做为项目或者模块的配置文件
1. 还可以做为网络传输数据的格式（现在 JSON 为主）。  

### 6.2 语法

#### 6.2.1 文档声明

1. `<?xml version="1.0" encoding="UTF-8"?>`
   - `<?xml`要连写在一起，否则会报错
   - `version`版本号
   - `encoding`编码
   - `standalone="yes/no"`表示这个xml文件是否是独立的xml文件
2. xml是强语言，必须符合语法规则。使用浏览器打开会进行语法校验。
2. xml文档必须要有一对根标签（顶级标签——没有父级标签的标签），且必须唯一。

#### 6.2.2 xml注释

1. 同HTML

#### 6.2.3 xml元素

1. 元素是指从开始标签到结束标签的内容。
1. 特殊字符语法同HTML
1. 文本区域（CDATA）：告诉xml解析器，改区域内的内容为纯文本，不需要解析
   - `<![CDATA[ 内容xxxx ]]>`

#### 6.2.4 xml标签

1. 标签名可以含字母、数字以及其他的字符
1. 标签名不能以数字或标点符号开始
1. ~~标签名不能以~~`~~xml~~`~~、~~`~~XML~~`~~、~~`~~Xml~~`~~开始~~——验证可行。
1. 标签名不能包含空格。
1. 标签分为单标签和双标签，但必须闭合。
1. 标签的属性值必须使用`""`包裹
1. 标签对大小写敏感
1. 标签必须正确嵌套

### 6.3 xml解析技术

#### 6.3.1 dom解析技术

1. w3c制定

#### 6.3.2 Sax解析技术

1. sun公司在jdk5版本对dom技术进行了升级：Sax（Simple api for xml）
1. 使用了类似事件机制，边读取边解析。

#### 6.3.4 dom4j

1. 第三方解析
1. 是对jdom的封装，jdom是对dom的封装
1. 使用：
   - 引入jar包
   - 创建xml对应的类（JavaBean）
   - 创建一个SAXReader对象：`SAXReader reader = new SAXReader()`
   - 通过SAXReader对象读取xml文件，并获取document对象：`Document document = reader.read(url)`
   - 通过document对象，获取根元素对象（Element类型）：`Element root = document.getRootElement()`
      - 根元素对象的`asXML()`方法可以将Element对象转换为String
   - 通过根元素对象获取所有子元素集合：`List<Element> books = root.elements()`
      - 单个子元素使用`element()`方法
      - 可传入参数，传入参数时，参数名与子元素标签名一致。
   - 循环遍历得到每个book对象的各类属性对象，仍然使用`elements()`或`element()`方法
   - 使用`getText`方法得到元素的内容。
      - `element()`和`getText()`可以整合成一个`elementText()`
   - 获取属性值：`attributeValue()`

```java
package service;

import domain.Book;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import java.util.List;

/**
* @author: INFINITY https://juejin.cn/user/2788017217999896/posts
* @date: 2022/7/1 13:30
*/
public class Dom4jParseXML {
    public static void main(String[] args) throws DocumentException {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read("file:\\D:\\实践练习\\07.JavaWeb\\parsexml\\src\\books.xml");
        Element rootElement = document.getRootElement();
        List<Element> books = rootElement.elements();
        for(Element book : books){
            String sn = book.attributeValue("sn");
            Element nameElement = book.element("name");
            String nameElementText = nameElement.getText();
            Element priceElement = book.element("price");
            String priceElementText = priceElement.getText();
            String authorElement = book.elementText("author");
            System.out.println(new Book(sn,nameElementText,Double.parseDouble(priceElementText),authorElement));
        }
    }
}
```

#### 6.3.5 pull

1. 类似于sax，利用事件机制，用于Android开发

## 第7章 HTTP协议

### 7.1 Http协议简述

1. HyperText Transfer Protocol：超文本传输协议
1. 基于 TCP/IP 通信协议来传递数据
1. http是无状态的，服务器无法判断两次请求时同一客户端发送，还是不同客户端发送。
   - 通过会话跟踪技术解决无状态问题【session】

### 7.2 Http请求

#### 7.2.1 请求结构

1. 由四个部分组成，分别为请求行、请求头、空行和请求体

![](/images/javaweb/5-200929133350160.gif)

- 上面的`URL`应该是`URI`？

#### 7.2.2 请求行

1. 请求行是由请求方法、请求 URI（URI 全称为 Universal Resource Identifier，中文含义为“统一资源标志符”，是用来标识抽象或物理资源的字符串）和 HTTP 协议版本三个部分组成，每个部分使用空格分隔，在请求行的最后以回车符与换行符结尾。
1. 8种请求方法：
| 方法 | 描述 |
| --- | --- |
| GET | 请求指定 URI 所指向的资源，并返回 |
| HEAD | 与 GET 请求类似，但只获取由 URI 所指向资源的响应消息报头 |
| POST | 将数据提交到服务器（例如提交表单或者上传文件），数据被包含在请求体中 |
| PUT | 使用从客户端向服务器传送的数据替换指定文档的内容 |
| DELETE | 请求服务器删除 URI 所指向的目标资源 |
| CONNECT | HTTP/1.1 协议中预留的能够将连接改为管道方式的代理服务器 |
| OPTIONS | 允许客户端查看服务器的性能 |
| TRACE | 回显服务器收到的请求，主要用于测试或诊断 |
| PATCH | 是对 PUT 方法的补充，用来对已知资源进行局部更新 |

#### 7.2.3 请求头

1. 请求头是客户端传递给服务器的一系列有关本次请求和客户端本身的相关信息。请求头一般由头部字段名、冒号（:）、空格、值组成

![image.png](/images/javaweb/image-1660813966216.png)

#### 7.2.4 空行

- 由回车符和换行符组成，无特殊含义，分隔请求行和请求体

#### 7.2.5 请求体

- 一般出现在POST请中，表示提交给服务器的数据，以`key=value&key=value`的形式传输
- get请求：没有请求体，但有一个queryString

-

#### 7.2.6 GET请求

1. 由请求行和请求头两部分组成
1. 常见组成内容含义：
   - ![image.png](/images/javaweb/image-1660813969163.png)
3. GET请求有哪些：
   - form 标签method=get
   - a 标签
   - link 标签引入css
   - Script 标签引入js 文件
   - img 标签引入图片
   - iframe 引入html 页面
   - 在浏览器地址栏中输入地址后敲回车

#### 7.2.7 POST请求

1. 由请求行、请求头、请求体三部分组成
1. 常见组成内容含义：
   - ![image.png](/images/javaweb/image-1660813972156.png)
3. POST请求有哪些
   - form 标签method=post

### 7.3 HTTP响应

#### 7.3.1 响应结构

1. 由响应行（状态行）、响应头、空行和响应体组成

![](/images/javaweb/5-20092913350O96.gif)

#### 7.3.2 响应行

1. 由HTTP 协议版本、表示响应状态的状态码和形容这个状态词三部分组成
   - 协议版本号，当前一般为`HTTP1.1`
   - 响应状态：
      - ![image.png](/images/javaweb/image-1660813977376.png)
      - 状态词：OK、Not Modified、Found 等。

#### 7.3.3 响应头

1. 由头部字段名、冒号、空格和值组成。

![image.png](/images/javaweb/image-1660813981756.png)

#### 7.3.4 空行

- 同请求空行

#### 7.3.5 响应体

- 服务器根据客户端的请求返回给客户端的具体数据。

#### 7.3.6 响应示例

 ![image.png](/images/javaweb/image-1660813985681.png)

#### 7.3.7 常见响应状态码

1. 200：请求成功。
1. 302：请求重定向
1. 404：服务器收到了请求，但客户端需要的资源不存在（请求地址有误）
1. 500：服务器收到了请求，但服务器内部错误（代码错误）

### 7.4 MIME类型

1. Multipurpose Internet Mail Extensions，多用途互联网邮件扩展类型”，它是一种标准，用来表示文档、文件或字节流的性质和格式。
1. 设定在请求头的Acdept中，格式如下：
   - `Accept: type/subtype [q=qvalue]`
   - [q=qvalue]是可选项，表示MIME优先顺序（权重），取值范围为0~1
   - 多个MIME使用`;`隔开
3. 常见类型：
   - ![image.png](/images/javaweb/image-1660813989003.png)

## 第8章 JSP

### 8.1 JSP入门

#### 8.1.1 JSP介绍

1. JSP是Java Servlet Pages的所系，是一种动态网页开发技术。
   - 动态网页显式内容可以随时间、环境或数据库操作的结果而发生改变。
2. 本质：JSP本质是一个Java类（Servlet），可以在JSP页面嵌入Java代码。
2. 运行过程：客户端请求JSP时，服务器内部会经历一次动态资源（JSP）到静态资源（HTML）的转化。服务器会自动把 JSP 中的 HTML 片段和数据拼接成静态资源响应给浏览器。也就是说，JSP 运行在服务器端，但最终发给客户端的是已经转换好的 HTML 静态页面。
2. 组成：包括 Java Bean、自定义标签（Custom Tags）、EL 表达式（Expression Language）、JSTL 标准标签类库（Java Standard Tag Library）等。
2. JSP与Servlet的异同：
   - 相同点：都用于生成动态网页
   - 不同点：![image.png](/images/javaweb/image-1660813992123.png)

#### 8.1.2 JSP生命周期

1. 编译：当浏览器请求 JSP 时，JSP 容器会首先检查是否需要编译页面。如果该页面从未被编译过，或者自上次编译以来对其进行了修改，则编译该页面。（JSP容器就是Servlet容器——Tomcat）
   - 解析 JSP：JSP 容器解析 JSP 文件，查看是否有语法错误
   - 翻译 JSP：JSP 容器把 JSP 文件翻译为 Servlet 类
   - 编译 Servlet
2. 初始化：当容器加载 JSP 时，它将在处理任何请求之前调用 jspInit() 方法。一般情况下，程序只初始化一次。与 Servlet init 方法一样，我们通常在 jspInit() 方法中初始化数据库连接、打开文件。
2. 执行：SP 页面完成初始化后，JSP 将会调用 _jspService() 方法。_jspService() 以 HttpServletRequest 对象和 HttpServletResponse 对象作为方法参数。
2. 销毁：从容器中删除 JSP。jspDestroy() 方法等效于 Servlet 中的 destroy() 方法。通常在 jspDestroy() 方法中释放数据库连接、关闭打开的文件。

### 8.2 JSP语句

#### 8.2.1 JSP脚本

1. 含义：在JSP页面中，写入Java代码。
1. 作用：在jsp页面中编写java功能
1. 特点：
   - 脚本翻译之后都在_jspService 方法中
   - 在_jspService()方法中的现有对象都可以直接使用。
   - 多个jsp脚本块组合完成一个完整的 java 语句。
   - 和jsp表达式组合使用，在 jsp中数据数据。
4. JSP 脚本可以包含任意数量的 Java 语句，变量、方法和表达式。JSP 脚本会把包含的内容插入到 Servlet 的 service() 方法中。
4. 语法：`<% Java语句 %>`
   - 等价于`<jsp:script> Java语句 </jsp:script>`
   - 任何文本、HTML 标签和 JSP 元素（声明，表达式等）都必须在脚本程序之外。

#### 8.2.2 JSP声明

1. 作用：用于声明一个或多个变量、方法，以供后面的 Java 代码使用。
   - 声明属性
   - 声明static代码块
   - 声明方法
   - 声明内部类
2. 语法：`<%! Java语句 %>`
   - 等价于`<jsp:declaration> Java语句 </jsp:declaration>`
3. 与JSP脚本的区别：
   - JSP 脚本只能声明变量，不能声明方法。JSP 声明语句可以声明变量和方法。
      - JSP脚本声明的内容会插入到Servlet的service()方法中，而Java中方法不允许嵌套方法
      - JSP声明声明的内容会添加到Servlet类中，是类的成员。

#### 8.2.3 JSP表达式

1. 作用：把变量或者表达式输出到网页上，不需要 out.print() 就能输出数据。通常用于打印变量和方法的值。
1. 语法：`<%= Java语句 %>`
   - 等价于`<jsp:expression> Java语句 </jsp:expression>`
3. 特点：
   - 都会被翻译到_jspService() 方法中
   - 都会被翻译成为 out.print()输出到页面上
   - _jspService()方法中的对象都可以直接使用。
   - 表达式不能以分号结束。

#### 8.2.4 JSP注释

1. JSP页面中，可以有四种注释。
   - HTML注释：`<-- 注释内容 -->`。 会被翻译到 java 源代码中。在_jspService 方法里，以 out.writer 输出到客户端。  
      - 客户端访问看不到，客户端检查源码可以看到
   - HTM注释中嵌套JSP表达式：`<-- 注释内容 <%= java语句 %> -->`
      - 客户端访问看不到，客户端检查源码可以看到翻译后的JSP表达式
   - 隐藏注释：`<%-- 注释内容 --%>`
      - 客户端访问看不到，客户端检查源码也看不到
   - 脚本程序（Scriptlet）中的注释：客户端访问看不到，客户端检查源码也看不到
      - 单行注释：`//`
      - 多行注释：`/* */`
      - 文档注释：`/** */`

### 8.3 JSP指令

1. 作用：告诉 Web 服务器如何处理 JSP 页面的请求和响应。服务器会根据 JSP 指令来编译 JSP，生成 Java 文件。JSP 指令不产生任何可见输出，在生成的 Java 文件中，不存在 JSP 指令。
1. 语法：`<%@ directive attribute = "value" [attribute2 = "value2" ...]%>`
1. 分类：
   - ![image.png](/images/javaweb/image-1660813996806.png)

#### 8.3.1 JSP page指令

1. 作用：定义当前页面的相关属性。可以在 JSP 页面的任意位置编写，通常放在页面的顶部
1. 语法：`<%@ page attribute = "value" %>`
1. 常用属性：
   - ![image.png](/images/javaweb/image-1660813999069.png)
   - import可以声明多个，其他只能出现一个

#### 8.3.2 JSP include指令

1. 作用：在 JSP 页面引入其它内容，可以是 JSP 文件、html 文件和文本文件等，相当于把文件的内容复制到 JSP 页面。引入的文件和 JSP 页面同时编译运行。
1. 语法：`<%@ include file="URL" %>` ，url代表相对路径，必须以`/`开头
1. 优点：
   - 增加代码的可重用性
   - 使 JSP 页面的代码结构清晰易懂
   - 维护简单
4. 特点：静态包含的页面会出现在包含它的jsp页面翻译后的servlet程序中
   - out.write()

#### 8.3.3 JSP taglib指令

1. 作用：声明并引入标签库。Java API 允许在页面中自定义标签，标签库就是自定义标签的集合。
1. 语法：`<%@ taglib uri="tagliburl" prefix="tagPre" %>`
   - uri指定自定义标签库的存放位置；prefix 指定标签库的前缀。

### 8.4 JSP动作

未学

### 8.5 JSP 九大内置对象

#### 8.5.1 九大内置对象介绍

1. 作用：简化页面开发过程。
1. 特点：JSP 内置对象又称为隐式对象，它们由容器实现和管理。在 JSP 页面中，这些内置对象不需要预先声明，也不需要进行实例化，可以直接在脚本和表达式中使用。
   - Tomcat将jsp页面翻译成Servlet源码后，内部提供
   - 不能在JSP声明中使用
3. 分类：含4大域对象
   - ![image.png](/images/javaweb/image-1660814002836.png)
4. 四大域对象：pageContext（page 域对象）、request（request 域对象）、session（session 域对象）、以及 application（application 域对象）
   - 操作域对象的3个方法：
      - ![image.png](/images/javaweb/image-1660814006417.png)
   - 4个域对象的不同点：
      - ![image.png](/images/javaweb/image-1660814008238.png)
   - 使用原则：从小到大。page到application。对于内存的优化

#### 8.5.2 pageContext对象

1. javax.servlet.jsp.PageContext 的实例对象。
1. 本质是Servlet的ServletContext
1. 常用方法：
   - ![image.png](/images/javaweb/image-1660814010471.png)

#### 8.5.3 request对象

1. javax.servlet.http.HttpServletRequest 的实例对象
1. 常用方法：
   - ![image.png](/images/javaweb/image-1660814012637.png)
   - `getScheme()`：获取请求协议
   - `getServerName()`：获取服务器IP地址
   - `getServerPort()`：获取服务器端口号
   - `getContextPath()`：获取工程路径（名）

#### 8.5.4 session对象

1. javax.servlet.http.HttpSession 的实例对象，主要用来访问用户数据，记录客户的连接信息。
1. HTTP 协议是一种无状态的协议（即不保存连接状态的协议）。每次用户向服务器发出请求，且服务器接收请求并返回响应后，该连接就被关闭了，服务器端与客户端的连接被断开。此时，服务器端不保留连接的有关信息，要想记住客户的连接信息，就用到了 session 对象。
1. 常用方法：
   - ![image.png](/images/javaweb/image-1660814015963.png)

#### 8.5.5 application对象

1. javax.servlet.ServletContext 的实例对象。一般用于保存应用程序的公用数据。非常占用服务器资源，实际开发中一般不用。
1. application 是 pageContext的一种，获取pageContext的参数可以获得application\session\request\page范围的所有参数；而获取application参数则不能获取其他三个范围的参数。
1. 常用方法：
   - ![image.png](/images/javaweb/image-1660814018073.png)

#### 8.5.6 config对象

1. javax.servlet.ServletConfig 的实例对象，一般用于获取页面和 Servlet 的初始化参数。
1. 常用方法：
   - ![image.png](/images/javaweb/image-1660814020352.png)

#### 8.5.7 response对象

1. javax.servlet.http.HttpServletResponse 的实例对象
1. 常用方法：
   - ![image.png](/images/javaweb/image-1660814022407.png)

#### 8.5.8 out对象

1. javax.servlet.jsp.JspWriter的实例，常用于输出内容到HTML中
1. 常用方法：
   - ![image.png](/images/javaweb/image-1660814024609.png)
3. out.write()和resopnse.getWrite().write()对象的区别
   - 两个方法都有自己的缓冲区
   - jsp页面中输出内容时即使不用write()，jsp页面翻译成servlet程序时，都是用的是out.write()
   - 输出是Tomcat服务器默认输出response缓冲区的内容，而out缓冲区的内容会追写到response的缓冲区中。【表现：总是response输出的内容先输出】
      - jsp页面的内容执行完后，会默认执行`out.flush()`，将out缓冲区内容追写到response缓缓从区中。
4. `out.write()`和`out.print()`
   - `print()`方法输出数据时，都会转为String类型
   - `write()`方法输出数据时，如果为非String类型，则有乱码问题（如int类型，输出的是整数型对应的ascii码）
      - 缓冲区使用字符数组存放数据

#### 8.5.9 page对象

1. 实质是java.lang.Object 对象相当于 Java 中的 this 关键字。page 对象是指当前的 JSP 页面本身，在实际开发中并不常用。
1. 常用方法：
   - ![image.png](/images/javaweb/image-1660814028036.png)

#### 8.5.10 exception对象

### 8.6 JSP标签

#### 8.6.1 动态包含

1. 语法：`<jsp:include page="url"></js:include>`
1. 特点：动态包含的页面会出现在包含它的jsp页面翻译后的servlet程序中
   - 出现形式：`JspRuntimeLibrary.include(request, response, "url", out, false)`
3. 底层原理：
   - ![image.png](/images/javaweb/image-1660814030156.png)
   - 被包含的页面out对象是父页面传过去的，是同一个对象，所以共享缓冲区。
4. 传递参数：
   - ![image.png](/images/javaweb/image-1660814032577.png)
   - 父页面中，使用request的getParameter("str")可以获取属性值。
      - 两个页面request是同一个

#### 8.6.2 转发

1. 语法：`<jsp:forward page="url"></jsp:fowrard>`
1. 作用：请求转发

#### 8.6.3 自定义标签

没学会

### 8.7 EL表达式

#### 8.7.1 简介

1. Excepssion Language，简化jsp页面，主要用于代替jsp输出页面的数据【主要是域对象的数据】
1. 语法：`${}`
1. 等同于`<%= %>`
1. 不同：EL表达式在输出null值时，输出为空串，jsp表达式输出时，输出null【用户体验不好】

#### 8.7.2 运算

1. 关系运算
   - ![image.png](/images/javaweb/image-1660814035300.png)
2. 逻辑运算
   - ![image.png](/images/javaweb/image-1660814037661.png)
3. 算数运算
   - ![image.png](/images/javaweb/image-1660814039356.png)
4. 条件表达式：`${ 条件表达式? true : false }`
4. 其他运算符
   - empty：判断对象或变量是否为null
      - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1656921126525-5ec07703-b414-4d36-8296-651cb6bde781.png#clientId=uba4a2df0-32ab-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=104&id=u0feb767a&margin=%5Bobject%20Object%5D&name=image.png&originHeight=104&originWidth=272&originalType=binary&ratio=1&rotation=0&showTitle=false&size=17867&status=done&style=none&taskId=u91d2aa7d-13e9-4115-8b45-559e0991b02&title=&width=272)
   - `.`和`[]`：访问 JavaBean 中的属性和隐式对象的数据。
      - `.`访问 JavaBean 属性【实际上调用的是属性的geteer或isValue()，如果未设置会报错】或 Map 类型的值
      - `[]`用来访问数组或者列表的元素。

#### 8.7.3 内置对象

![image.png](/images/javaweb/image-1660814041933.png)

#### 8.7.4 pageContext域对象的使用

![image.png](/images/javaweb/image-1660814044305.png)

- EL域对象调用属性，其实是调用的该属性的getter，如果是布尔值，则调用的是isValue()

#### 8.7.5 禁用EL表达式

1. 禁用单个表达式：`\${2+3}`页面会输出`${2+3`
1. 当前页面禁用：配置page指令中的`isELIgnored`属性
   - `<%@ page isELIgnored = "true" %>`
3. 整个web禁用：
   - ![image.png](/images/javaweb/image-1660814046556.png)

### 8.8 文件传输

> 可以使用的第三方jar包（同时导入）
>
> -
>
> -

#### 8.8.0 Commons-FileUpload组件API

1. ServletFileUpload类：解析文件上传的数据
| 方  法 | 说  明 |
| --- | --- |
| public void setSizeMax(long sizeMax) | 设置上传文件总量的最大值 (包含文件和表单数据) |
| public List parseRequest(HttpServletRequest req) | 解析 form 表单提交的数据，返回一个 FileItem 实例的集合 |
| public static final boolean isMultipartContent(HttpServletRequest req) | 判断请求信息中的内容是否是”multipart/form-data“类型，是则返回 true，否则返回 false。 |
| public void setHeaderEncoding(String encoding) | 设置转换时所使用的字符集编码 |

2. FileItemFactory接口与实现类：创建ServletFileUpload实例，DiskFileItemFactory 是 FileItemFactory 接口的实现类
| 方  法 | 说  明 |
| --- | --- |
| public void setSizeThreshold(int sizeThreshold) | 设置内存缓冲区的大小 |
| public void setRepository(String path) | 设置临时文件存放的目录 |

3. FileItem接口：一个表单字段对应一个 FileItem 实例，其实现类之一是 DiskFileItem
| 方  法 | 说  明 |
| --- | --- |
| public boolean isFormField() | 用于判断 FileItem 类对象封装的数据是一个普通文本表单字段，还是一个文件表单字段，如果是普通表单字段则返回 true，否则返回 false。因此，可以使用该方法判断是否为普通表单域，还是文件上传表单域。 |
| public String getName() | 获取文件上传的文件名 |
| public String getFieldName() | 返回表单字段元素的 name 属性值 |
| public long getSize() | 获取上传文件的大小 |
| public String getString() | 将 FileItem 对象中保存的主体内容以一个字符串返回。其重载方法 public String getString(String encoding) 中的参数用指定的字符集编码方式 |
| public void write() | 将 FileItem 对象中保存的主体内容保存到指定的文件中。 |

#### 8.8.1 文件上传表单设计

1. `<form>`标签属性为`method="post"`、`enctype="multipart/form-data"`
   - get方法也能传，但是长度有限，太短了不够用。
   - 设置了enctype="multipart/form-data"后，提交给服务器的数据变为二进制流的形式，使用`request.getParameter`不能获取属性值【为null】
2. `<input>`标签属性为`type="file"`

#### 8.8.2 文件上传请求体介绍

![image.png](/images/javaweb/image-1660814059150.png)

#### 8.8.3 使用第三方包完成上传

1. 导入文件上传包和io包：
   - ![image.png](/images/javaweb/image-1660814061257.png)
2. 创建表单JSP文件和文件上传Servlet类

```java
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
IOException {
    //1 先判断上传的数据是否多段数据（只有是多段的数据，才是文件上传的）
    if (ServletFileUpload.isMultipartContent(req)) {
        // 创建 FileItemFactory 工厂实现类
        FileItemFactory fileItemFactory = new DiskFileItemFactory();
        // 创建用于解析上传数据的工具类 ServletFileUpload 类
        ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
        try {
            // 解析上传的数据，得到每一个表单项 FileItem
            List<FileItem> list = servletFileUpload.parseRequest(req);
            // 循环判断，每一个表单项，是普通类型，还是上传的文件
            for (FileItem fileItem : list) {
                if (fileItem.isFormField()) {
                    // 普通表单项
                    System.out.println("表单项的 name 属性值：" + fileItem.getFieldName());
                    // 参数 UTF-8.解决乱码问题
                    System.out.println("表单项的 value 属性值：" + fileItem.getString("UTF-8"));
                } else {
                    // 上传的文件
                    System.out.println("表单项的 name 属性值：" + fileItem.getFieldName());
                    System.out.println("上传的文件名：" + fileItem.getName());
                    fileItem.write(new File("e:\\" + fileItem.getName()));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

#### 8.8.4 使用第三方包完成下载

1. response.getOutputStream();
1. servletContext.getResourceAsStream();
1. `servletContext.getMimeType()`：获取要下载的文件类型
1. `response.setContentType()`：设置返回客户端的数据类型

```java
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //        1、获取要下载的文件名
    String downloadFileName = "2.jpg";
    //        2、读取要下载的文件内容 (通过ServletContext对象可以读取)
    ServletContext servletContext = getServletContext();
    // 获取要下载的文件类型
    String mimeType = servletContext.getMimeType("/file/" + downloadFileName);
    System.out.println("下载的文件类型：" + mimeType);
    //        4、在回传前，通过响应头告诉客户端返回的数据类型
    resp.setContentType(mimeType);
    //        5、还要告诉客户端收到的数据是用于下载使用（还是使用响应头）
    // Content-Disposition响应头，表示收到的数据怎么处理
    // attachment表示附件，表示下载使用
    // filename= 表示指定下载的文件名
    // url编码是把汉字转换成为%xx%xx的格式
    if (req.getHeader("User-Agent").contains("Firefox")) {
        // 如果是火狐浏览器使用Base64编码
        resp.setHeader("Content-Disposition", "attachment; filename==?UTF-8?B?" + new BASE64Encoder().encode("中国.jpg".getBytes("UTF-8")) + "?=");
    } else {
        // 如果不是火狐，是IE或谷歌，使用URL编码操作
        resp.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode("中国.jpg", "UTF-8"));
    }
    /**
         * /斜杠被服务器解析表示地址为http://ip:prot/工程名/  映射 到代码的Web目录
         */
    InputStream resourceAsStream = servletContext.getResourceAsStream("/file/" + downloadFileName);
    // 获取响应的输出流
    OutputStream outputStream = resp.getOutputStream();
    //        3、把下载的文件内容回传给客户端
    // 读取输入流中全部的数据，复制给输出流，输出给客户端
    IOUtils.copy(resourceAsStream, outputStream);
}
```

## 第9章 JSTL

### 9.1 JSTL简介

#### 9.1.1 JSTL介绍

1. JSP Standard Tag Library，核心标签库，替换代码脚本，优化JSP页面编写
   - EL替换表达式脚本`<% %>`
2. 使用：使用 JSTL 需要引入 JSTL 的 JAR 包和标签库描述符文件（扩展名为 .tld），标签库描述符文件内包含标签库中所有标签的定义、标签名、功能类及各种属性。
   - `taglibs-standard-impl-1.2.1.jar`和`taglibs-standard-spec-1.2.1.jar`
   - JSTL 1.2及之后版本只需要引入jstl包？
3. 地址：
3. 组成：
   - ![image.png](/images/javaweb/image-1660814065998.png)

#### 9.1.2 使用

1. 导入 taglibs-standard-impl-1.2.1.jar 和taglibs-standard-spec-1.2.1.jar  
:::danger

- JSTL的两个库文件只支持Servlet4.0，Tomcat10创建的Servlet程序为5.0版本，所以需要单独导入servlet4.0的jar包
:::

2. 使用JSP taglib指令引入使用的标签库地址
   - CORE标签库：`<%@ taglib prefix="c"uri="http://java.sun.com/jsp/jstl/core" % >`
   - FMT标签库：`<%@ taglib prefix="c"uri="http://java.sun.com/jsp/jstl/fmt" % >`
   - FUNCTIONS标签库：`<%@ taglib prefix="c"uri="http://java.sun.com/jsp/jstl/functions" % >`
   - SQL标签库：`<%@ taglib prefix="c"uri="http://java.sun.com/jsp/jstl/sql" % >`
   - XML标签库：`<%@ taglib prefix="c"uri="http://java.sun.com/jsp/jstl/xml" % >`

### 9.2 各库介绍

> **注：下文中表达式指EL表达式。**

#### 9.2.1 CORE核心库

![image.png](/images/javaweb/image-1660814068678.png)

1. `<c:set var="varname" value="表达式" [scope="request|page|session|application"]>表达式</c:set>`：
   - 等价于：`<c:set var="varname" value="表达式" [scope="request|page|session|application"]/>`
   - var：定义变量或属性名称
   - value：变量或属性值
   - scope：可选项，表示属性的作用域，默认为 page
2. `<c:if test="判断条件" [var="varname"] [scope="request|page|session|application"]> 代码块 </c:if>`
   - test：指定判断条件，返回值为 boolean
   - var：可选项，判断条件的执行结果
   - scope：可选项，执行结果的作用域
4. `<c:choose><c:when>`和`<c:otherwise>`标签
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1656935842482-fd4bbe53-c257-4b6c-8385-251edc1bbbb7.png#clientId=u89a3eb69-b878-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=223&id=ub3b7432e&margin=%5Bobject%20Object%5D&name=image.png&originHeight=223&originWidth=309&originalType=binary&ratio=1&rotation=0&showTitle=false&size=5266&status=done&style=none&taskId=u44251ce7-8e1f-413d-b027-5e9c34ac6e8&title=&width=309)
   - 嵌套判断时，`<c:when>`的直接父标签只能是`<c:choose>`，且必须使用。
   - 不存在穿透问题。
   - 多个判断语句同时为true时，只会执行第一个判断为true的语句（同java只有一个入口）
5. `<c:forEach>`
   - ![image.png](/images/javaweb/image-1660814074427.png)
   - items：要被循环的信息，可以是数组、Java 集合等；
   - var：可选项，指定迭代之的别名；
   - varStatus：可选项，当前迭代的状态信息；
      - ![image.png](/images/javaweb/image-1660814082111.png)
      - varStatus可调用的方法，根据EL表达式的`.`运算符，可以直接写属性
   - begin：可选项，迭代开始的元素，起始下标为 0；
   - end：可选项，迭代结束的元素；
   - step：可选项，迭代的步长；

#### 9.2.2 FMT格式化库

![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1656941141080-690e876f-f026-48fe-8872-6c430745e5fb.png#clientId=u89a3eb69-b878-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=369&id=u447293cd&margin=%5Bobject%20Object%5D&name=image.png&originHeight=369&originWidth=755&originalType=binary&ratio=1&rotation=0&showTitle=false&size=34791&status=done&style=none&taskId=u487b1392-9c54-479c-9168-d5202d93ce8&title=&width=755)

#### 9.2.3 FUNCTIONS函数库

![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1656941214185-1d8adb7d-9eaf-470e-9f68-f8147d7324b3.png#clientId=u89a3eb69-b878-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=490&id=uf874b7ff&margin=%5Bobject%20Object%5D&name=image.png&originHeight=490&originWidth=755&originalType=binary&ratio=1&rotation=0&showTitle=false&size=59415&status=done&style=none&taskId=u8143353c-2fd9-49fe-ac0c-8df74fdddf9&title=&width=755)

#### 9.2.4 SQL数据库

![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1656941273043-3e27eb48-29b6-4620-bc0c-e8e84870e06f.png#clientId=u89a3eb69-b878-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=218&id=ua552b4e2&margin=%5Bobject%20Object%5D&name=image.png&originHeight=218&originWidth=630&originalType=binary&ratio=1&rotation=0&showTitle=false&size=17860&status=done&style=none&taskId=u188305a0-a69e-4007-b5fa-51aba7c6999&title=&width=630)

## 第10 章BeanUtils

> 依赖
>
> - [https://commons.apache.org/proper/commons-beanutils/](https://commons.apache.org/proper/commons-beanutils/)（引入）
> - [https://commons.apache.org/proper/commons-collections/](https://commons.apache.org/proper/commons-collections/)（引入）
> - [https://commons.apache.org/proper/commons-logging/](https://commons.apache.org/proper/commons-logging/)（不知道高版本还需要不需要引入）

![image.png](/images/javaweb/image-1660814090705.png)
注入原理：调用JavaBean的seteer
作用：将参数注入到JavaBean的对象中，方便创建对象

## 第11章 MVC

### 11.1 MVC的概念

1. MVC 全称：Model 模型、 View 视图、 Controller 控制器。
1. MVC 最早出现在 JavaEE 三层中的 Web 层，它可以有效的指导 Web 层的代码如何有效分离，单独工作。
1. Model 模型：将与业务逻辑相关的数据封装为具体的 JavaBean 类，其中不掺杂任何与数据处理相关的代码—— JavaBean/domain/entity/pojo。  
1. View 视图：只负责数据和界面的显示，不接受任何与显示数据无关的代码，便于程序员和美工的分工合作—— JSP/HTML。
1. Controller 控制器：只负责接收请求，调用业务层的代码处理请求，然后派发页面，是一个“调度者”的角色——Servlet。 转到某个页面。或者是重定向到某个页面。

![image.png](/images/javaweb/image-1660814094548.png)

## 第12章 Cookie

### 12.1 Cookie概述

#### 12.1.1 Cookie概念

1. 服务器通知客户端保存键值对的一种技术。web应用程序利用Cookie在客户端缓存服务器端的文件。
1. Cookie时由服务器发送给客户端的，客户端保存时注明了Cookie的来源。
1. 客户端再次访问服务器时，客户端的Cookie会保存在请求协议中，服务器端可以获取上次存储的缓存文件内容。

#### 12.1.2 用途

1. 管理浏览网站的人数（其中包含有多少人访问过，多少人是新用户等）
1. 电子商城中购物车功能（每买一样商品，保存一个Cookie）
1. 用户自动登录功能（第一次登录时，将用户名和密码存储在Cookie）

#### 12.1.3 缺点

1. 多人共用一台计算机（例如导致用户名和密码不安全等问题）。
1. Cookie被删除时，利用Cookie统计用户数量出现偏差。
1. 一人使用多台计算机（网站会将看成多个用户等问题）
1. Cookie会被附加在每次Http请求协议中，增加流量。
1. Cookie使用明文（未加密）传递的，安全性低。
1. Cookie的大小限制在4KB左右，无法存储复杂需求。

#### 12.1.4 Cookie规范

1. Cookie存储的大小上限为4KB。
1. 一个服务器最多在客户端浏览器中可以保存20个Cookie。
1. 一个浏览器最多可以保存300个Cookie。
1. 不同浏览器之间不能共享Cookie
:::warning
注意点：Cookie规范时Http协议提供的，浏览器厂商对该Cookie规范进行了一些“扩展”。
:::

### 12.2 使用Cookie

#### 12.2.1 服务器端创建Cookie

1. 创建Cookie对象：`Cookie cookie= new Cookie("name", "value");`
1. 发送给客户端保存：`response.addCookie(cookie);`

#### 12.2.2 服务器端获取Cookie

1. 浏览器是通过请求头将Cookie发送给服务器的，所以可以使用获取请求头的方法：
   - `request.getCokies()`：返回Cookie的对象数组
   - 遍历Cookie数组，使用equals方法比较名字是否一致
2. 获取Cookie的工具类：

```java
public class CookieUtils {
    /**
    * 查找指定名称的 Cookie 对象
    * @param name
    * @param cookies
    * @return
    */
    public static Cookie findCookie(String name , Cookie[] cookies){
        if (name == null || cookies == null || cookies.length == 0) {
            return null;
        }
        for (Cookie cookie : cookies) {
            if (name.equals(cookie.getName())) {//上面判断的为空的情况，所以不会出现空指针异常
            return cookie;
            }
        }
        return null;
    }
}
```

#### 12.2.3 修改Cookie的值

1. 方式一：创建同名的新cookie进行覆盖
>
> - 创建Cookie对象：`Cookie cookie= new Cookie("name", "value");`
> - 发送给客户端保存：`response.addCookie(cookie);`

2. 方式二：查找到指定的Cookie，使用`setValue()`方法
>
> - 查找指定Cookie（使用工具类）：`Cookie cookie = CookieUtils.findCookie("key",request.getCookies());`
> - 发送给客户端保存：`response.addCookie(cookie);`

3. cookie不能保存**空格、方括号、圆括号、等号、逗号、双引号、斜杠、问号、at 符号、冒号和分号以及汉字，同时空值在不同浏览器上表现页不一定一样。**
   - 要保存上述类型的值，可以使用BSE64编码对上述文本进行处置。

#### 12.2.4 Cookie的生命周期控制

1. 使用cookie的`setMaxAge(num)`可以设置cookie如何过期：
   - 正数，表示在指定的秒数后过期
   - 负数，表示浏览器一关，Cookie 就会被删除（默认值是-1）
   - 零，表示马上删除 Cookie  

#### 12.2.5 Cookie有效Path的设置

![image.png](/images/javaweb/image-1660814100767.png)

- `setPath("路径")`

## 第13章 Session

### 13.1 Session概述

#### 13.1.1 Session会话介绍

1. Session 就一个接口（HttpSession）。
1. Session 就是会话。它是用来维护一个客户端和服务器之间关联的一种技术。
1. 每个客户端都有自己的一个 Session 会话。
1. Session 会话中，我们经常用来保存用户登录之后的信息。  

### 13.2 Session的使用

#### 13.2.1 Session的创建、获取、判断、id

1. 创建和获取Session，使用的方法（API）是一样的：`request.getSession()`
   - 第一次调用该方法：创建Session会话
   - 后续掉调用该方法：获取已经存在的Session
2. 判断是否是新创建的Session：`session.isNew()`
   - true：标识新创建的
   - false：标识之前已经存在的
3. 获取sessionID：`session.getId()`
   - 每个session都有一个id，且唯一存在

#### 13.2.2 Session域数据存取

1. 存储：调用session对象的`setAttribute("name", "value")`
1. 获取：调用session对象的`getAttribute("name", "value")`

#### 13.3.3 Session生命周期控制

1. 获取存活时间（超时后销毁）：`session.getMaxInactiveInterval()`，返回整数s。
   - Tomcat服务器中进行了默认配置：1800s（30min）
   - 超时指的是客户端两次请求的最大间隔时长，否则请求一次会创建一次，时间重新开始算。
2. 设置存活时间：`session.setMaxInactiveInterval(int interval)`，超过指定秒数，就销毁该session
2. 设置马上失效：`session.invalidate()`

### 13.3 应用

#### 13.3.1 登录验证码

1. 原理：
   - 第一次访问表单时，给表单生成一个随机验证码，并保存到session域中
   - 提交表单后，将session提交给服务器，服务器获得该验证码，同时服务器清空sessionu域（移除该session的值）
   - 后续点击表单时，再随机生成验证码保存到session域中，提交表单后与服务器上的进行比较，是否相等（字符串内容）
2. 谷歌验证码的使用（kaptcha）：
   - 导入谷歌验证码的 jar 包 kaptcha-2.3.2.ja  
   - 在 web.xml 中去配置用于生成验证码的 Servlet 程
      - ![image.png](/images/javaweb/image-1660814104733.png)
   - 在表单中使用 img 标签去显示验证码图片并使用它
      - ![image.png](/images/javaweb/image-1660814106611.png)
   - 在服务器获取谷歌生成的验证码和客户端发送过来的验证码比较使用。  
      - ![image.png](/images/javaweb/image-1660814108268.png)

## 第14章 Filter过滤器

### 14.1 Filter概述

#### 14.1.1 Filter介绍

1. JavaWeb 的三大组件之一。三大组件分别是：Servlet 程序、Listener 监听器、Filter 过滤器
1. 是 JavaEE 的规范。也就是接口，`**javax.servlet.Filter**`
1. Filter 过滤器它的作用是：拦截请求，过滤响应 。对Servlet容器传给web资源的request对象和response对象进行检查和修改
1. 常见拦截请求场景：
   - 权限检查
   - 日记操作
   - 事务管理
5. 特点：
   - Filter不能直接访问，本身也不能生成request和response对象。
      - 在 Web 资源被访问前，检查 request 对象，修改请求头和请求正文，或对请求进行预处理操作。
      - 将请求传递到下一个过滤器或目标资源。
      - 在 Web 资源被访问后，检查 response 对象，修改响应头和响应正文。

#### 14.1.2 Filter的使用

- 编写类，实现Filter接口
- 实现过滤方法doFilter()
- 在`web.xml`中注册Filter拦截路径

#### 14.1.3 xml配置

1. 语法结构：

```xml
<filter>
    <filter-name>myFilter</filter-name>
    <filter-class>com.baidu.www.MyFilter</filter-class>
    <init-param>
        <param-name>name</param-name>
        <param-value>123</param-value>
    </init-param>
    <init-param>
        <param-name>URL</param-name>
        <param-value>www.baidu.com</param-value>
    </init-param>
</filter>

<filter-mapping>
    <filter-name>myFilter</filter-name>
    <url-pattern>/login</url-pattern>
    <dispatcher>REQUEST</dispatcher>
    <dispatcher>FORWARD</dispatcher>
</filter-mapping>

<filter-mapping>
    <filter-name>myFilter</filter-name>
    <servlet-name>ServletDemo</servlet-name>
</filter-mapping>
```

2. 注意点：
   - `<init-param>`标签内配置filter过滤器的初始化参数，可以配置多个
   - `dispatcher`指定给filter拦截的资源被Servlet容器调用的方式【Filter什么时候工作】，默认值为`REQUEST`，可以设置多个。
      - `REQUERST`：用户直接访问地址时，容器调用过滤器
      - `INCLUDE`：通过请求转发`RequestDispatcher`的`include()`方法时调用
      - `FORWARD`通过请求转发`RequestDispatcher`的`forward()`方法时调用
      - `ERROR`：通过声明式异常处理机制访问，该过滤器被调用。
3. 匹配方式：`<url-pattern>`的值：
   - 精确匹配：如`<url-pattern>/login.</url-pattern>`
   - 目录匹配：如`<url-pattern>/admin/*</url-pattern>`
   - 后缀名匹配：如`<url-pattern>*.html</url-pattern>`

#### 14.1.4 注解配置

| 属性名 | 类型 | 描述 |
| --- | --- | --- |
| filterName | String | 指定过滤器的 name 属性，等价于 `<filter-name>`。 |
| urlPatterns | String[] | 指定过滤器的 URL 匹配模式。等价于 `<url-pattern>` 标签。 |
| value | String[] | 该属性等价于 urlPatterns 属性，但是两者不能同时使用。 |
| servletNames | String[] | 指定过滤器将应用于哪些 Servlet。取值是 @WebServlet 中 filterName 属性的取值，或者 web.xml 中 `<servlet-name>` 的取值。 |
| dispatcherTypes | DispatcherType | 指定过滤器拦截的资源被 Servlet 容器调用的方式。具体取值包括： ASYNC、ERROR、FORWARD、INCLUDE、REQUEST。 |
| initParams | WebInitParam[] | 指定一组过滤器初始化参数，等价于 `<init-param>` 标签。 |
| asyncSupported | boolean | 声明过滤器是否支持异步操作模式，等价于 `<async-supported>` 标签。 |
| description | String | 指定过滤器的描述信息，等价于 `<description>` 标签。 |
| displayName | String | 指定过滤器的显示名，等价于 `<display-name>` 标签。 |

- value、urlPatterns、servletNames 三者必需至少包含一个，且 value 和 urlPatterns 不能共存，如果同时指定，通常忽略 value 的取值。
- 其余均为可选项
- 通过@WebFilter注解注册的Filter，其加载顺序与执行顺序无关
- 通过@WebFilter注解注册的Filter，其加载顺序与注解的filterName值相关（底层通过HashMap存储，key值即filterName值）
- 通过@WebFilter注解注册的Filter，其执行顺序与类名有关，按照类名的字典顺序执行

### 14.2 Filter的生命周期

#### 14.2.1 Filter工作流程

![image.png](/images/javaweb/image-1660814113664.png)

1. 客户端请求访问容器内的 Web 资源。
1. Servlet 容器接收请求，并针对本次请求分别创建一个 request 对象和 response 对象。
1. 请求到达 Web 资源之前，先调用 Filter 的 doFilter() 方法，检查 request 对象，修改请求头和请求正文，或对请求进行预处理操作。
1. 在 Filter 的 doFilter() 方法内，调用 FilterChain.doFilter() 方法，将请求传递给下一个过滤器或目标资源。
1. 目标资源生成响应信息返回客户端之前，处理控制权会再次回到 Filter 的doFilter() 方法，执行 FilterChain.doFilter() 后的语句，检查 response 对象，修改响应头和响应正文。
1. 响应信息返回客户端。

#### 14.2.2 Filter生命周期阶段

1. 初始化阶段：
   - Servlet 容器负责加载和实例化 Filter。容器启动时，读取 web.xml 或 @WebFilter 的配置信息对所有的过滤器进行加载和实例化。
   - 加载和实例化完成后，Servlet 容器调用 init() 方法初始化 Filter 实例。
   - 在 Filter 的生命周期内，初始化阶段只执行一次。
   - 执行Filter构造器方法和init方法
2. 拦截和过滤阶段：
   - 客户端请求的 URL 与过滤器映射匹配时，容器将该请求的 request 对象、response 对象以及 FilterChain 对象以参数的形式传递给 Filter 的 doFilter() 方法，并调用该方法对请求/响应进行拦截和过滤。
   - 拦截一次执行一次。
   - 执行`doFilter()`方法
3. 销毁阶段：
   - Filter 对象创建后会驻留在内存中，直到容器关闭或应用被移除时销毁。
   - 销毁 Filter 对象之前，容器会先调用 destory() 方法，释放过滤器占用的资源。
   - 在 Filter 的生命周期内，destory() 只执行一次。

### 14.3 FilterConfig类

- Tomcat创建Filter类时，同时会创建一个FilterConig类，包含有Filter配置文件的配置信息
- 作用：获取filter过滤器的配置内容
  - 获取Filter的名称——`<filter-name>`的内容
  - 获取Filter中配置的`<init-param>`参数
  - 获取ServletContext对象
| 返回值类型 | 方法 | 描述 |
| --- | --- | --- |
| String | getInitParameter(String name) | 根据初始化参数名 name，返回对应的初始化参数值。 |
| Enumeration | getInitParameterNames() | 返回过滤器的所有初始化参数名的枚举集合。 |
| ServletContext | getServletContext() | 返回 Servlet 上下文对象的引用。 |
| String | getFilterName()  | 返回过滤器的名称。 |

### 14.4 FilterChain——过滤器链

#### 14.4.1 过滤器链概念

- 多个 Filter都拦截同一目标资源，则它们就组成了一个 Filter 链（也称过滤器链）。
- 过滤器链中的每个过滤器负责特定的操作和任务，客户端的请求在这些过滤器之间传递，直到传递给目标资源。
- `**javax.servlet**`

#### 14.4.2 Filter链拦截过程

![image.png](/images/javaweb/image-1660814117749.png)

#### 14.4.3 Filter链中Filter中的执行顺序

1. 通过 web.xml 配置的 Filter 过滤器，执行顺序由 `<filter-mapping>` 标签的配置顺序决定。`<filter-mapping>` 靠前，则 Filter 先执行，靠后则后执行。
1. 通过 @WebFilter 注解配置的 Filter 过滤器，无法进行排序。
1. 默认情况下，一个Filter链中的Filter只有一个线程——在同一个线程中
1. 默认情况下，一个Filter链中的Filter只有一个request对象和一个response对象——即共享request域对象

## 第15章 ThreadLocal

1. 作用：解决多线程的数据安全问题——事务操作的线程安全问题。称为本地线程。
1. 特点：
   - 可以给当前线程关联一个数据（可以是普通变量、对象、数组、集合等）
   - 每个ThreadLocal对象，只能为当前线程关联一个数据，需要关联多个线程，则需要多个ThreadLocal对象实例。
   - 每个ThreadLocal对象实例定义后，一般为static类型
   - ThreadLocal对象实例销毁后，保存的数据由JVM虚拟机自动释放
3. `set(obj)`：在当前线程存储数据

```java
public void set(T value) {
    Thread t = Thread.currentThread(); //获取当前的线程
    ThreadLocalMap map = getMap(t);    //每一个线程都维护各自的一个容器（ThreadLocalMap）
    if (map != null)
        map.set(this, value);          //这里的key对应的是ThreadLocal，因为我们的组件中需要传输（共享）的对象可能会有多个（不止Connection）
    else
        createMap(t, value);           //默认情况下map是没有初始化的，那么第一次往其中添加数据时，会去初始化
}
```

4. `get()`：在当前线程上获取数据

```java
public T get() {
    Thread t = Thread.currentThread(); //获取当前的线程
    ThreadLocalMap map = getMap(t);    //获取和这个线程（企业）相关的ThreadLocalMap（也就是工作纽带的集合）
    if (map != null) {
        ThreadLocalMap.Entry e = map.getEntry(this);   //this指的是ThreadLocal对象，通过它才能知道是哪一个工作纽带
        if (e != null) {
            @SuppressWarnings("unchecked")
            T result = (T)e.value;     //entry.value就可以获取到工具箱了
            return result;
        }
    }
    return setInitialValue();
}
```

## 第16章 JSON

### 16.1 JSON概述

1. JSON (JavaScript Object Notation) 是一种轻量级的数据交换格式。易于人阅读和编写。同时也易于机器解析和生成。JSON 采用完全独立于语言的文本格式，而且很多语言都提供了对 json 的支持（包括 C, C++, C#, Java, JavaScript, Perl, Python 等）。 这样就使得 JSON 成为理想的数据交换格式。

- 数据交换：客户端和服务器之间的业务数据传递

2. 数据格式：json 是由键值对组成，并且由花括号（大括号）包围。每个键由引号引起来，键和值之间使用冒号进行分隔， 多组键值对之间进行逗号进行分隔。
2. 保存形式：
   - 对象形式：json对象——常用于json数据操作
   - 字符串形式：json字符串——常用于数据交换
4. JSON常用方法：
   - `JSON.stringify(xxx)`：对象转为字符串
   - `JSON.parse(xxx)`字符串转为对象

### 16.2 操作JSON

#### 16.2.1 客户端操作JSON

1. 浏览器操作JSON由JavaScript完成。
1. 操作方式：`json对象.key`或`json对象[key]`

#### 16.2.1 服务器端操作JSON
>
> - jar包：gson-2.2.4.jar

1. JavaBean和json相互转换：
   - 创建Gson对象：`Gson gson = new Gson();`
   - JavaBean转换为json字符串：调用`gson.toJson(JavaBean对象);`
   - json字符串转换为JavaBean：调用`gson.formJson(json字符串, JavaBean.class);`
2. List和json相互转换
   - 创建Gson对象：`Gson gson = new Gson();`
   - List转换为json字符串：调用`gson.toJson(List对象);`
   - json字符串转换为List：调用`gson.formJson(json字符串, List.class);`——得到的是一个
      - 注意：此时得到的数据类型为`LinkedTreeMap`，而不是List中保存的对象类型
   - `gson.formJson(json字符串, new PersonListType().getType());`此时得到才是List类型，使用`get(n)`方法可以获取到具体的对象
      - PersonListType类的定义：`class PersonListType extends TypeToken<List<Person>>{}`——反射机制
   - 匿名内部类省去创建PersonListType类：`gson.formJson(json字符串, new TypeToken<ArrayList<Integer, Person>>(){}.getType())`
3. List和json相互转换
   - 创建Gson对象：`Gson gson = new Gson();`
   - Map转换为json字符串：调用`gson.toJson(Map对象);`
   - json字符串转换为Map：调用`gson.formJson(json字符串, Map.class);`——得到的是一个
      - 注意：此时得到的数据类型为`LinkedTreeMap`，而不是List中保存的对象类型
   - `gson.formJson(json字符串, new PersonListType().getType());`此时得到才是List类型，使用`get(n)`方法可以获取到具体的对象
      - PersonListType类的定义：`class PersonListType extends TypeToken<List<Person>>{}`——反射机制
   - 匿名内部类省去创建PersonListType类：`gson.formJson(json字符串, new TypeToken<HashMap<Integer, Person>>(){}.getType())`
4. 举例：

```java
public void test3(){
    Map<Integer,Person> personMap = new HashMap<>(); 
    personMap.put(1, new Person(1, "国哥好帅"));
    personMap.put(2, new Person(2, "康师傅也好帅")); 
    
    Gson gson = new Gson();
    
    // 把map集合转换成为json 字符串
    String personMapJsonString = gson.toJson(personMap); 
    System.out.println(personMapJsonString);
    
    //Map<Integer,Person> personMap2 = gson.fromJson(personMapJsonString, new PersonMapType().getType());
    Map<Integer,Person> personMap2 = gson.fromJson(personMapJsonString, new 
    TypeToken<HashMap<Integer,Person>>(){}.getType());
    
    System.out.println(personMap2); 
    Person p = personMap2.get(1); 
    System.out.println(p);
}
```

### 第17章 Ajax

### 17.1 Ajax概述

- AJAX  即“Asynchronous  Javascript  And  XML”（异步  JavaScript  和  XML），是指一种创建交互式网页应用的网页开发技术。
  - ajax  是一种浏览器通过  js 异步发起请求，局部更新页面的技术。
  - Ajax  请求的局部更新，浏览器地址栏不会发生变化。
  - 局部更新不会舍弃原来页面的内容。
- 同步与异步的区别：
  - 同步：用户发送请求后，页面不可使用，等待服务器响应完成
  - 异步：页面还可以继续使用。
  - 这也就是与重定向回原页面的区别，而且在响应完成后，页面的数据还是旧的。

### 17.2 Ajax使用

#### 17.2.1 原生Ajax请求演示

1. 创建ajax对象：`var ajax= new XMLHttpRequest();`
1. 调用open方法设置请求参数：`ajax.open("GET", url&param);`
1. 绑定onreadystatechange事件：`ajax.onreadystatechange = function(){if (xmlhttprequest.readyState == 4 && xmlhttprequest.status == 200) { ajax.send(); }}|`
   - 调用send方法发送请求：`ajax.send()`

```html
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
  <meta http-equiv="pragma" content="no-cache" />
  <meta http-equiv="cache-control" content="no-cache" />
  <meta http-equiv="Expires" content="0" />
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Insert title here</title>
  <script type="text/javascript">
   // 在这里使用javaScript语言发起Ajax请求，访问服务器AjaxServlet中javaScriptAjax
   function ajaxRequest() {
//     1、我们首先要创建XMLHttpRequest 
    var xmlhttprequest = new XMLHttpRequest();
//     2、调用open方法设置请求参数
    xmlhttprequest.open("GET","http://localhost:8080/16_json_ajax_i18n/ajaxServlet?action=javaScriptAjax",true);
//     4、在send方法前绑定onreadystatechange事件，处理请求完成后的操作。
    xmlhttprequest.onreadystatechange = function(){
     if (xmlhttprequest.readyState == 4 && xmlhttprequest.status == 200) {
      alert("收到服务器返回的数据：" + xmlhttprequest.responseText);
      var jsonObj = JSON.parse(xmlhttprequest.responseText);
      // 把响应的数据显示在页面上
      document.getElementById("div01").innerHTML = "编号：" + jsonObj.id + " , 姓名：" + jsonObj.name;
     }
    }
//     3、调用send方法发送请求
    xmlhttprequest.send();
    alert("我是最后一行的代码");
   }
  </script>
 </head>
 <body>
  <button onclick="ajaxRequest()">ajax request</button>
  <div id="div01"></div>
 </body>
</html>
```

#### 17.2.2 jQuery中ajax演示

1. `$.ajax({参数})`
   - `url`：
   - `type`：请求类型
   - `data`：发送给服务区的数据
      - 格式一：`key1=value1&key2=value2`
      - 格式二：`{key1:value1, key2;value2}`
   - `success`：请求成功时，响应的回调函数，服务器返回的`data`，以参数的形式被success使用
   - `dataType`：响应数据类型
      - `text`
      - `xml`
      - `json`

2.`$.get({参数})`和`$.post({参数})`：对`$.ajax({参数})`的进一步封装

- `url`：
- `data`：发送给服务区的数据
  - 格式一：`key1=value1&key2=value2`
  - 格式二：`{key1:value1, key2;value2}`
- `callback`：请求成功时，响应的回调函数，服务器返回的`data`，以参数的形式被callback使用
- `type`：响应数据类型
  - `text`
  - `xml`
  - `json`

3. `$.getJSON({参数})`：对`$.get({参数})`的进一步封装
   - `url`：
   - `data`：发送给服务区的数据
      - 格式一：`key1=value1&key2=value2`
      - 格式二：`{key1:value1, key2;value2}`
   - `callback`：请求成功时，响应的回调函数，服务器返回的`data`，以参数的形式被callback使用
4. `serialize()`：表单序列化——将表单的内容以`key1=value1&key2=value2`的形式拼接【表单的方法】

## 第18章 国际化（i18）

![image.png](/images/javaweb/image-1660814161711.png)

```properties
username=username 
password=password 
sex=sex
age=age 
regist=regist 
boy=boy 
email=email 
girl=girl 
reset=reset 
submit=submit
```

```properties
username=用户名 
password=密码 
sex=性别
age=年龄 
regist=注册 
boy=男 
girl=女 
email=邮箱 
reset=重置 
submit=提交
```

- 配置文件命名规则：`basename_en_US.pproperties`
- 获取语言国家信息（en_US和zh_CN)：
  - `java.utli.Locale`类实例化`Locale locale = Local.getDefault();`
  - `Locale`的静态常量获取：
    - `Locale.CHINA`
    - `Locale.US`
- 通过指定的basename和Locale对象，读取配置文件及文件内容
  - `ResourceBundle bundle = ResourceBundle.getBundle("i18n", locale);`
  - `bundle.getString("key")`
- 方式一：使用请求头实现国际化：
- 方式二：使用手动选择实现国际化：
- 方式三：使用JSTL标签库实现国际化：需要使用fmt——格式化库，即导入相应包

![](/images/javaweb/image-1660814166873.png)
[16_尚硅谷_JSON、Aajx、i18n_王振国 - 课堂笔记.pdf](https://www.yuque.com/attachments/yuque/0/2022/pdf/1604140/1657613355584-8bdaac8e-f448-476e-b78e-32ca64c4567a.pdf)

## 第19章 Thymeleaf
>
> - 视图模板技术
> - 使用前添加jar包：
>
> -

#### 使用步骤

1. 添加thymeleaf的jar包
1. 新建一个Servlet类`ViewBaseServlet.java`

```java
package myspringmvc;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ViewBaseServlet extends HttpServlet {

    private TemplateEngine templateEngine;

    @Override
    public void init() throws ServletException {

        // 1.获取ServletContext对象
        ServletContext servletContext = this.getServletContext();

        // 2.创建Thymeleaf解析器对象
        ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver(servletContext);

        // 3.给解析器对象设置参数
        // ①HTML是默认模式，明确设置是为了代码更容易理解
        templateResolver.setTemplateMode(TemplateMode.HTML);

        // ②设置前缀
        String viewPrefix = servletContext.getInitParameter("view-prefix");

        templateResolver.setPrefix(viewPrefix);

        // ③设置后缀
        String viewSuffix = servletContext.getInitParameter("view-suffix");

        templateResolver.setSuffix(viewSuffix);

        // ④设置缓存过期时间（毫秒）
        templateResolver.setCacheTTLMs(60000L);

        // ⑤设置是否缓存
        templateResolver.setCacheable(true);

        // ⑥设置服务器端编码方式
        templateResolver.setCharacterEncoding("utf-8");

        // 4.创建模板引擎对象
        templateEngine = new TemplateEngine();

        // 5.给模板引擎对象设置模板解析器
        templateEngine.setTemplateResolver(templateResolver);

    }

    protected void processTemplate(String templateName, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 1.设置响应体内容类型和字符集
        resp.setContentType("text/html;charset=UTF-8");

        // 2.创建WebContext对象
        WebContext webContext = new WebContext(req, resp, getServletContext());

        // 3.处理模板数据
        templateEngine.process(templateName, webContext, resp.getWriter());
    }
}
```

3. 在web.xml文件中添加配置【init方法中会使用到】
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1658132551464-6092141d-4901-4df2-a797-89ced52f6dd0.png#clientId=u9bfe48f2-f53d-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=220&id=u1f989b56&margin=%5Bobject%20Object%5D&name=image.png&originHeight=220&originWidth=521&originalType=binary&ratio=1&rotation=0&showTitle=false&size=26050&status=done&style=none&taskId=uc9563195-292f-4e8e-84df-26dba3a40ed&title=&width=521)
4. 业务Servlet继承ViewBaseServlet
4. 调用父类（ViewBaseServlet）的`processTemplate`方法
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1658132770947-0b3a81d3-81f2-46af-b917-06b1bea5fba4.png#clientId=u9bfe48f2-f53d-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=135&id=u9f24c1ff&margin=%5Bobject%20Object%5D&name=image.png&originHeight=135&originWidth=500&originalType=binary&ratio=1&rotation=0&showTitle=false&size=34079&status=done&style=none&taskId=u057be658-493e-4be3-a5ad-7feca79954f&title=&width=500)
6. html页面使用thymeleaf的标签

- 修改html文件的表头：`<html xmlns:th="http://www.thymeleaf.org">`
- `<th:if>`
- `<th:unless>`
- `<th:each>`
- `<th:text>`

![image.png](/images/javaweb/image-1660814172741.png)

- 如果要利用Java8中，反射获取方法真实的形参名称的话，需要开启上述设置。

## 第20章 IoC

1. 耦合/依赖
   - 依赖指的是某某某离不开某某某。
   - 在软件系统中，层与层之间是存在依赖的。我们也称之为耦合。
   - 系统架构或者是设计的一个原则是： 高内聚低耦合。
   - 层内部的组成应该是高度聚合的，而层与层之间的关系应该是低耦合的，最理想的情况0耦合（就是没有耦合）
2. IOC - 控制反转 / DI - 依赖注入

- 控制反转：
  - 之前在Servlet中，我们创建service对象 ， FruitService fruitService = new FruitServiceImpl();
  - 这句话如果出现在servlet中的某个方法内部，那么这个fruitService的作用域（生命周期）应该就是这个方法级别；
  - 如果这句话出现在servlet的类中，也就是说fruitService是一个成员变量，那么这个fruitService的作用域（生命周期）应该就是这个servlet实例级别
  - 之后我们在applicationContext.xml中定义了这个fruitService。然后通过解析XML，产生fruitService实例，存放在beanMap中，这个beanMap在一个BeanFactory中
  - 因此，我们转移（改变）了之前的service实例、dao实例等等他们的生命周期。控制权从程序员转移到BeanFactory。这个现象我们称之为控制反转
- 依赖注入：
  - 之前我们在控制层出现代码：FruitService fruitService = new FruitServiceImpl()；
  - 那么，控制层和service层存在耦合。
  - 之后，我们将代码修改成FruitService fruitService = null ;
  - 然后，在配置文件中配置:

```xml
<bean id="fruit" class="FruitController">
    <property name="fruitService" ref="fruitService"/>
</bean>
```

## 开发经验

### 1. 表单重复提交

#### 1.1 情况一

:::danger
**问题描述：**web提交完表单。服务器使用请求转来进行页面跳转。这个时候，用户按下功能键 F5，就会发起最后一次的请求。 造成表单重复提交问题
:::
:::warning
**发生原因：**浏览器的地址带了请求参数，没有发生变化，刷新页面相当于再次提交请求。
:::
> **解决方案：**使用重定向来进行跳转，改变浏览器ip

#### 1.2 情况二

:::danger
**问题描述：** 用户正常提交服务器，但是由于网络延迟等原因，迟迟未收到服务器的响应，这个时候，用户以为提交失败， 就会着急，然后多点了几次提交操作，也会造成表单重复提交
:::
:::warning
**发生原因：**
:::
> **解决方案：**使用验证码

#### 1.3 情况三

:::danger
**问题描述：**  用户正常提交服务器。服务器也没有延迟，但是提交完成后，用户回退浏览器。重新提交。也会造成表单重复提交
:::
:::warning
**发生原因：**
:::
> **解决方案：**使用验证码

### 2. 排错

- 如果发现访问不到资源，工程启动后不经过servlet，问题多半是工件是web exploded，将它新建为war exploded即可。

![image.png](/images/javaweb/image-1660814183971.png)

- **一个问题：idea 的项目部署的 web exploded 和 war exploded 和 war 的区别是啥？啥时候用哪个？**
