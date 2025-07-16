<template><div><h1 id="spring-mvc" tabindex="-1"><a class="header-anchor" href="#spring-mvc" aria-hidden="true">#</a> Spring MVC</h1>
<h2 id="第1章-springmvc简介" tabindex="-1"><a class="header-anchor" href="#第1章-springmvc简介" aria-hidden="true">#</a> 第1章 SpringMVC简介</h2>
<blockquote>
<ul>
<li>通常认为，Spring MVC是Spring的子项目，其实，它谈不上是一个独立的子项目，因为连一个正规的名字都没有，正如官网所介绍的那样：</li>
<li>Spring Web MVC是基于Servlet API构建的原始Web框架，从一开始就包含在Spring框架中。正式名称“Spring Web MVC”来自其源模块（spring-webmvc）的名称，但更常见的名称是“Spring MVC”。</li>
<li>Spring MVC 官方文档如下所示：</li>
</ul>
</blockquote>
<h3 id="_1-1-spring-mvc介绍" tabindex="-1"><a class="header-anchor" href="#_1-1-spring-mvc介绍" aria-hidden="true">#</a> 1.1 Spring MVC介绍</h3>
<h4 id="_1-1-1-mvc" tabindex="-1"><a class="header-anchor" href="#_1-1-1-mvc" aria-hidden="true">#</a> 1.1.1 MVC</h4>
<ol>
<li><code v-pre>MVC</code>是一种软件架构的思想，将软件按照模型、视图、控制器来划分</li>
<li><code v-pre>M</code>：<code v-pre>Model</code>，模型层，指工程中的<code v-pre>JavaBean</code>，作用是处理数据
<ul>
<li><code v-pre>JavaBean</code>分为两类：
<ul>
<li>一类称为实体类<code v-pre>Bean</code>：专门存储业务数据的，如 <code v-pre>Student</code>、<code v-pre>User</code>等</li>
<li>一类称为业务处理 Bean：指 <code v-pre>Service</code>或 <code v-pre>Dao</code>对象，专门用于处理业务逻辑和数据访问。</li>
</ul>
</li>
</ul>
</li>
<li><code v-pre>V</code>：<code v-pre>View</code>，视图层，指工程中的html或jsp等页面，作用是与用户进行交互，展示数据</li>
<li><code v-pre>C</code>：<code v-pre>Controller</code>，控制层，指工程中的<code v-pre>servlet</code>，作用是接收请求和响应浏览器</li>
<li><code v-pre>MVC</code>的工作流程：用户通过视图层发送请求到服务器，在服务器中请求被<code v-pre>Controller</code>接收，<code v-pre>Controller</code>调用相应的Model层处理请求，处理完毕将结果返回到<code v-pre>Controller</code>，<code v-pre>Controller</code>再根据请求处理的结果找到相应的View视图，渲染数据后最终响应给浏览器</li>
</ol>
<h4 id="_1-1-2-springmvc" tabindex="-1"><a class="header-anchor" href="#_1-1-2-springmvc" aria-hidden="true">#</a> 1.1.2 SpringMVC</h4>
<ol>
<li><code v-pre>SpringMVC</code>是<code v-pre>Spring</code>的一个后续产品，是Spring的一个子项目</li>
<li><code v-pre>SpringMVC</code>是 <code v-pre>Spring</code>为表述层开发提供的一整套完备的解决方案。在表述层框架历经 <code v-pre>Strust</code>、<code v-pre>WebWork</code>、<code v-pre>Strust2</code>等诸多产品的历代更迭之后，目前业界普遍选择了 <code v-pre>SpringMVC</code>作为 JavaEE 项目表述层开发的<strong>首选方案</strong>。</li>
<li>注：三层架构分为表述层（或表示层）、业务逻辑层、数据访问层，表述层表示前台页面和后台<code v-pre>servlet</code></li>
</ol>
<h4 id="_1-1-3-springmvc的特点" tabindex="-1"><a class="header-anchor" href="#_1-1-3-springmvc的特点" aria-hidden="true">#</a> 1.1.3 SpringMVC的特点</h4>
<ol>
<li><strong>Spring</strong>家族原生产品，与<code v-pre>IOC</code>容器等基础设施无缝对接</li>
<li><strong>基于原生的</strong>Servlet，通过了功能强大的<strong>前端控制器</strong><code v-pre>DispatcherServlet</code>，对请求和响应进行统一处理</li>
<li>表述层各细分领域需要解决的问题<strong>全方位覆盖</strong>，提供<strong>全面解决方案</strong></li>
<li><strong>代码清新简洁</strong>，大幅度提升开发效率</li>
<li>内部组件化程度高，可插拔式组件<strong>即插即用</strong>，想要什么功能配置相应组件即可</li>
<li><strong>性能卓著</strong>，尤其适合现代大型、超大型互联网项目要求</li>
</ol>
<h3 id="_1-2-spring-mvc使用" tabindex="-1"><a class="header-anchor" href="#_1-2-spring-mvc使用" aria-hidden="true">#</a> 1.2 Spring MVC使用</h3>
<h4 id="_1-2-1-开发环境" tabindex="-1"><a class="header-anchor" href="#_1-2-1-开发环境" aria-hidden="true">#</a> 1.2.1 开发环境</h4>
<ul>
<li>IDEA2021.2.4</li>
<li>maven3.5.4【3.8.6版本与idea2021使用会找不到依赖】</li>
<li>tomcat8</li>
<li>Spring5.3.1</li>
</ul>
<h4 id="_1-2-2-创建maven工程" tabindex="-1"><a class="header-anchor" href="#_1-2-2-创建maven工程" aria-hidden="true">#</a> 1.2.2 创建maven工程</h4>
<ol>
<li>创建项目：
<ul>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1658208979000-088a4b3c-9ffc-41de-b048-d1b6f1c82871.png#clientId=uf1197a9e-7d2f-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=670&amp;id=u288b1ad4&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=670&amp;originWidth=802&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=20926&amp;status=done&amp;style=none&amp;taskId=ubcc5b10c-1e37-4ca8-a4cf-0128709979b&amp;title=&amp;width=802" alt="image.png" loading="lazy"></li>
</ul>
</li>
<li>修改本地maven仓库：
<ul>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1658209159622-ec097577-0191-4af9-9296-7a7884b3d8a6.png#clientId=uf1197a9e-7d2f-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=713&amp;id=u38426780&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=713&amp;originWidth=982&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=66016&amp;status=done&amp;style=none&amp;taskId=uc67c6b59-f432-4f51-813d-85312e9c990&amp;title=&amp;width=982" alt="image.png" loading="lazy"></li>
</ul>
</li>
<li>添加框架支持，因为为web项目。
<ul>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1658214203401-1eac272a-1732-4b0d-bf81-456e89196af1.png#clientId=uf1197a9e-7d2f-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=70&amp;id=u44ebdeee&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=70&amp;originWidth=438&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=7904&amp;status=done&amp;style=none&amp;taskId=u9c4fad35-1d74-44c5-8251-c52c3530bd3&amp;title=&amp;width=438" alt="image.png" loading="lazy"></li>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1658214221848-8290ba39-215a-4f76-8c1a-a3acec70968b.png#clientId=uf1197a9e-7d2f-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=636&amp;id=u5bec8468&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=636&amp;originWidth=666&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=43846&amp;status=done&amp;style=none&amp;taskId=ubb625e59-dc53-419d-9b2e-27cffefe55c&amp;title=&amp;width=666" alt="image.png" loading="lazy"></li>
<li>这里使用框架支持还是手动建立web目录都没有区别，配置好工件路径即可。【参见JavaWeb4.1】</li>
</ul>
</li>
</ol>
<h4 id="_1-2-3-添加项目依赖" tabindex="-1"><a class="header-anchor" href="#_1-2-3-添加项目依赖" aria-hidden="true">#</a> 1.2.3 添加项目依赖</h4>
<ol>
<li>必须的依赖：
<ul>
<li><code v-pre>Spring MVC</code></li>
<li>日志：<code v-pre>logback</code></li>
<li><code v-pre>servlet api</code></li>
<li><code v-pre>thymeleaf</code></li>
</ul>
</li>
</ol>
<div class="language-xml ext-xml line-numbers-mode"><pre v-pre class="language-xml"><code><span class="token prolog">&lt;?xml version="1.0" encoding="UTF-8"?></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>project</span> <span class="token attr-name">xmlns</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>http://maven.apache.org/POM/4.0.0<span class="token punctuation">"</span></span>
         <span class="token attr-name"><span class="token namespace">xmlns:</span>xsi</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>http://www.w3.org/2001/XMLSchema-instance<span class="token punctuation">"</span></span>
         <span class="token attr-name"><span class="token namespace">xsi:</span>schemaLocation</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>modelVersion</span><span class="token punctuation">></span></span>4.0.0<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>modelVersion</span><span class="token punctuation">></span></span>

    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>groupId</span><span class="token punctuation">></span></span>iceriver.springmvc<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>groupId</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>artifactId</span><span class="token punctuation">></span></span>pro01-demo<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>artifactId</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>version</span><span class="token punctuation">></span></span>1.0-SNAPSHOT<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>version</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>packaging</span><span class="token punctuation">></span></span>war<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>packaging</span><span class="token punctuation">></span></span>

    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>dependencies</span><span class="token punctuation">></span></span>
        <span class="token comment">&lt;!-- SpringMVC --></span>
        <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>dependency</span><span class="token punctuation">></span></span>
            <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>groupId</span><span class="token punctuation">></span></span>org.springframework<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>groupId</span><span class="token punctuation">></span></span>
            <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>artifactId</span><span class="token punctuation">></span></span>spring-webmvc<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>artifactId</span><span class="token punctuation">></span></span>
            <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>version</span><span class="token punctuation">></span></span>5.3.1<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>version</span><span class="token punctuation">></span></span>
        <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>dependency</span><span class="token punctuation">></span></span>

        <span class="token comment">&lt;!-- 日志 --></span>
        <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>dependency</span><span class="token punctuation">></span></span>
            <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>groupId</span><span class="token punctuation">></span></span>ch.qos.logback<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>groupId</span><span class="token punctuation">></span></span>
            <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>artifactId</span><span class="token punctuation">></span></span>logback-classic<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>artifactId</span><span class="token punctuation">></span></span>
            <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>version</span><span class="token punctuation">></span></span>1.2.3<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>version</span><span class="token punctuation">></span></span>
        <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>dependency</span><span class="token punctuation">></span></span>

        <span class="token comment">&lt;!-- ServletAPI --></span>
        <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>dependency</span><span class="token punctuation">></span></span>
            <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>groupId</span><span class="token punctuation">></span></span>javax.servlet<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>groupId</span><span class="token punctuation">></span></span>
            <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>artifactId</span><span class="token punctuation">></span></span>javax.servlet-api<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>artifactId</span><span class="token punctuation">></span></span>
            <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>version</span><span class="token punctuation">></span></span>3.1.0<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>version</span><span class="token punctuation">></span></span>
            <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>scope</span><span class="token punctuation">></span></span>provided<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>scope</span><span class="token punctuation">></span></span>
        <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>dependency</span><span class="token punctuation">></span></span>

        <span class="token comment">&lt;!-- Spring5和Thymeleaf整合包 --></span>
        <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>dependency</span><span class="token punctuation">></span></span>
            <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>groupId</span><span class="token punctuation">></span></span>org.thymeleaf<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>groupId</span><span class="token punctuation">></span></span>
            <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>artifactId</span><span class="token punctuation">></span></span>thymeleaf-spring5<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>artifactId</span><span class="token punctuation">></span></span>
            <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>version</span><span class="token punctuation">></span></span>3.0.12.RELEASE<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>version</span><span class="token punctuation">></span></span>
        <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>dependency</span><span class="token punctuation">></span></span>
        <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>dependency</span><span class="token punctuation">></span></span>
            <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>groupId</span><span class="token punctuation">></span></span>org.springframework<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>groupId</span><span class="token punctuation">></span></span>
            <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>artifactId</span><span class="token punctuation">></span></span>spring-webmvc<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>artifactId</span><span class="token punctuation">></span></span>
            <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>version</span><span class="token punctuation">></span></span>5.3.1<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>version</span><span class="token punctuation">></span></span>
            <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>scope</span><span class="token punctuation">></span></span>compile<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>scope</span><span class="token punctuation">></span></span>
        <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>dependency</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>dependencies</span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>project</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><p><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1658213206936-063bff75-9217-40e8-9dfa-5645fb113eae.png#clientId=uf1197a9e-7d2f-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=233&amp;id=u556e096c&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=233&amp;originWidth=660&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=19433&amp;status=done&amp;style=none&amp;taskId=u326557b5-70f6-48c1-aad0-8c9f45b38cd&amp;title=&amp;width=660" alt="image.png" loading="lazy"></p>
<h4 id="_1-2-4-配置web-xml" tabindex="-1"><a class="header-anchor" href="#_1-2-4-配置web-xml" aria-hidden="true">#</a> 1.2.4 配置<code v-pre>web.xml</code></h4>
<ol>
<li>配置<code v-pre>SpringMVC</code>的前端控制器<code v-pre>DispatcheServlet</code>，对浏览器发送的请求进行统一处理。</li>
<li>配置名为<code v-pre>SpringMVC</code>的<code v-pre>servlet</code></li>
</ol>
<div class="language-xml ext-xml line-numbers-mode"><pre v-pre class="language-xml"><code><span class="token prolog">&lt;?xml version="1.0" encoding="UTF-8"?></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>web-app</span> <span class="token attr-name">xmlns</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>http://xmlns.jcp.org/xml/ns/javaee<span class="token punctuation">"</span></span>
         <span class="token attr-name"><span class="token namespace">xmlns:</span>xsi</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>http://www.w3.org/2001/XMLSchema-instance<span class="token punctuation">"</span></span>
         <span class="token attr-name"><span class="token namespace">xsi:</span>schemaLocation</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd<span class="token punctuation">"</span></span>
         <span class="token attr-name">version</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>4.0<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>servlet</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>servlet-name</span><span class="token punctuation">></span></span>springMVC<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>servlet-name</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>servlet-class</span><span class="token punctuation">></span></span>org.springframework.web.servlet.DispatcherServlet<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>servlet-class</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>servlet</span><span class="token punctuation">></span></span>  
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>servlet-mapping</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>servlet-name</span><span class="token punctuation">></span></span>springMVC<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>servlet-name</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>url-pattern</span><span class="token punctuation">></span></span>/<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>url-pattern</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>servlet-mapping</span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>web-app</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ul>
<li><code v-pre>/</code>所匹配的请求可以是<code v-pre>/login</code>或<code v-pre>.html</code>或<code v-pre>.js</code>或<code v-pre>.css</code>方式的请求路径，但是<code v-pre>/</code>不能匹配<code v-pre>.jsp</code>请求路径的请求</li>
<li><code v-pre>/*</code>会匹配包括<code v-pre>.jsp</code>的请求</li>
</ul>
<ol start="3">
<li>优化：加载<code v-pre>springMVC.xml</code>配置文件，并通过设置<code v-pre>&lt;load-on-startup&gt;</code>改变优先级，让在启动服务器时完成初始化，提高第一次请求的响应速度。
<ul>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1658220334202-bf156ca4-2416-44c2-8d36-66cec72f04dd.png#clientId=uf1197a9e-7d2f-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=308&amp;id=u5190ad08&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=308&amp;originWidth=712&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=38489&amp;status=done&amp;style=none&amp;taskId=u566d4c2a-b080-4d30-be4b-797277312f2&amp;title=&amp;width=712" alt="image.png" loading="lazy"></li>
</ul>
</li>
</ol>
<h4 id="_1-2-5-创建请求控制器" tabindex="-1"><a class="header-anchor" href="#_1-2-5-创建请求控制器" aria-hidden="true">#</a> 1.2.5 创建请求控制器</h4>
<ol>
<li><code v-pre>web.xml</code>中声明了控制路径<code v-pre>/</code>，还需要定义控制servlet程序，如<code v-pre>HelloControler.java</code>，对不同的请求进行不同的处理。</li>
<li>通过<code v-pre>@Controller</code>注解的方式将该控制类交给<code v-pre>IoC</code>管理，声明为控制器文件。</li>
</ol>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token keyword">package</span> <span class="token namespace">iceriver<span class="token punctuation">.</span>springmvc<span class="token punctuation">.</span>controller</span><span class="token punctuation">;</span>

<span class="token keyword">import</span> <span class="token import"><span class="token namespace">org<span class="token punctuation">.</span>springframework<span class="token punctuation">.</span>stereotype<span class="token punctuation">.</span></span><span class="token class-name">Controller</span></span><span class="token punctuation">;</span>

<span class="token doc-comment comment">/**
* <span class="token keyword">@author</span>: INFINITY https://developer.aliyun.com/profile/sagwrxp2ua66w
* <span class="token keyword">@date</span>: 2022/7/19 15:31
*/</span>
<span class="token annotation punctuation">@Controller</span>
<span class="token keyword">public</span> <span class="token keyword">class</span> <span class="token class-name">HelloController</span> <span class="token punctuation">{</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><h4 id="_1-2-6-创建springmvc-xml配置文件" tabindex="-1"><a class="header-anchor" href="#_1-2-6-创建springmvc-xml配置文件" aria-hidden="true">#</a> 1.2.6 创建<code v-pre>springMVC.xml</code>配置文件</h4>
<ol>
<li>1.2.4中步骤二加载了<code v-pre>springMVC.xml</code>配置文件，但此时还没有，<code v-pre>springMVC.xml</code>的作用是spring框架的一个配置文件。这里需要建在<code v-pre>resourses</code>文件夹下。
<ul>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1658221050721-2c516a08-6cc6-487e-9fd9-5e3cffdcfea9.png#clientId=uf1197a9e-7d2f-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=421&amp;id=u371acd11&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=421&amp;originWidth=855&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=66266&amp;status=done&amp;style=none&amp;taskId=u67640b74-0d44-46c5-b1fb-ba986e8644b&amp;title=&amp;width=855" alt="image.png" loading="lazy"></li>
<li>springMVC的配置文件具有默认的位置和名称
<ul>
<li>默认的位置：WEB-INF</li>
<li>默认的名称：<code v-pre>&lt;servlet-name&gt;</code>-servlet.xml</li>
<li>若要为springMVC的配置文件设置自定义的位置和名称，需要在servlet标签中添加<code v-pre>init-param</code>标签</li>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1658931173417-c9438582-ef06-4bc5-8367-52ca6fa9bcf9.png#clientId=u4383bf48-36bd-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=214&amp;id=ud8a2fd2a&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=214&amp;originWidth=680&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=26733&amp;status=done&amp;style=none&amp;taskId=u17e66d79-fe9a-417b-9391-05b086c72a5&amp;title=&amp;width=680" alt="image.png" loading="lazy"></li>
</ul>
</li>
</ul>
</li>
<li>1.2.5中使用了注解，因此需要在<code v-pre>springMVC.xml</code>文件中进行相应的配置以保证生效。
<ul>
<li>引入名称空间、开启组件扫描【参见Spring2.3.2部分】
<ul>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1658221495229-c21d4738-241b-4136-8bcc-27a0b22ad004.png#clientId=uf1197a9e-7d2f-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=171&amp;id=ud4f1d212&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=171&amp;originWidth=1132&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=46482&amp;status=done&amp;style=none&amp;taskId=ue5d339bb-c7dc-4578-ada0-a03eb8f1e5a&amp;title=&amp;width=1132" alt="image.png" loading="lazy"></li>
<li>这里没设置扫面指定注解</li>
</ul>
</li>
<li>配置<code v-pre>thymeleaf</code>视图解析器。
<ul>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1658222075476-ee1ab1b2-aab5-46af-8509-5f10a8fe6a66.png#clientId=uf1197a9e-7d2f-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=415&amp;id=u30efaaaf&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=415&amp;originWidth=834&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=68384&amp;status=done&amp;style=none&amp;taskId=ucaa0699b-d987-4383-920d-aed99ffea57&amp;title=&amp;width=834" alt="image.png" loading="lazy"></li>
<li>采用了<code v-pre>IoC</code>属性注入的级联赋值</li>
<li>这里视图前缀部分规定了前端页面文件要放在<code v-pre>WEB-INF/templates</code>目录下</li>
<li><code v-pre>WEB-INF</code>目录下的文件不能被前端请求直接访问，也不能被重定向访问，只能通过请求转发访问。</li>
</ul>
</li>
</ul>
</li>
</ol>
<div class="language-xml ext-xml line-numbers-mode"><pre v-pre class="language-xml"><code><span class="token prolog">&lt;?xml version="1.0" encoding="UTF-8"?></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>beans</span> <span class="token attr-name">xmlns</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>http://www.springframework.org/schema/beans<span class="token punctuation">"</span></span>
       <span class="token attr-name"><span class="token namespace">xmlns:</span>xsi</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>http://www.w3.org/2001/XMLSchema-instance<span class="token punctuation">"</span></span>
       <span class="token attr-name"><span class="token namespace">xmlns:</span>context</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>http://www.springframework.org/schema/context<span class="token punctuation">"</span></span>
       <span class="token attr-name"><span class="token namespace">xsi:</span>schemaLocation</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
                           http://www.springframework.org/schema/context https://www.springframework.org/schema/context/spring-context.xsd<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
  <span class="token comment">&lt;!-- 自动扫描包 --></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span><span class="token namespace">context:</span>component-scan</span> <span class="token attr-name">base-package</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>iceriver.springmvc.controller<span class="token punctuation">"</span></span><span class="token punctuation">/></span></span>
  
  <span class="token comment">&lt;!-- 配置Thymeleaf视图解析器 --></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>bean</span> <span class="token attr-name">id</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>viewResolver<span class="token punctuation">"</span></span> <span class="token attr-name">class</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>org.thymeleaf.spring5.view.ThymeleafViewResolver<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>property</span> <span class="token attr-name">name</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>order<span class="token punctuation">"</span></span> <span class="token attr-name">value</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>1<span class="token punctuation">"</span></span><span class="token punctuation">/></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>property</span> <span class="token attr-name">name</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>characterEncoding<span class="token punctuation">"</span></span> <span class="token attr-name">value</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>UTF-8<span class="token punctuation">"</span></span><span class="token punctuation">/></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>property</span> <span class="token attr-name">name</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>templateEngine<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
      <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>bean</span> <span class="token attr-name">class</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>org.thymeleaf.spring5.SpringTemplateEngine<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
        <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>property</span> <span class="token attr-name">name</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>templateResolver<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
          <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>bean</span> <span class="token attr-name">class</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
            <span class="token comment">&lt;!-- 视图前缀 --></span>
            <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>property</span> <span class="token attr-name">name</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>prefix<span class="token punctuation">"</span></span> <span class="token attr-name">value</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>/WEB-INF/templates/<span class="token punctuation">"</span></span><span class="token punctuation">/></span></span>
            <span class="token comment">&lt;!-- 视图后缀 --></span>
            <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>property</span> <span class="token attr-name">name</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>suffix<span class="token punctuation">"</span></span> <span class="token attr-name">value</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>.html<span class="token punctuation">"</span></span><span class="token punctuation">/></span></span>
            <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>property</span> <span class="token attr-name">name</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>templateMode<span class="token punctuation">"</span></span> <span class="token attr-name">value</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>HTML5<span class="token punctuation">"</span></span><span class="token punctuation">/></span></span>
            <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>property</span> <span class="token attr-name">name</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>characterEncoding<span class="token punctuation">"</span></span> <span class="token attr-name">value</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>UTF-8<span class="token punctuation">"</span></span> <span class="token punctuation">/></span></span>
          <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>bean</span><span class="token punctuation">></span></span>
        <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>property</span><span class="token punctuation">></span></span>
      <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>bean</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>property</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>bean</span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>beans</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ol start="3">
<li><code v-pre>WEB-INF/templates</code>目录下新建<code v-pre>index.html</code>文件
<ul>
<li>IDEA不配置情况下，新建的html文件不带<code v-pre>&lt;html lang=&quot;en&quot; xmlns:th=&quot;http://www.thymeleaf.org&quot;&gt;</code>后面的thymeleaf命名空间。可以通过设置进行修改
<ul>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1658222772508-807f4f86-0a88-4e15-ade1-266e41d27088.png#clientId=uf1197a9e-7d2f-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=713&amp;id=u41932207&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=713&amp;originWidth=982&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=97535&amp;status=done&amp;style=none&amp;taskId=u3618d77e-f586-4aab-b149-1abcf0c689a&amp;title=&amp;width=982" alt="image.png" loading="lazy"></li>
</ul>
</li>
</ul>
</li>
</ol>
<h4 id="_1-2-7-启动工程" tabindex="-1"><a class="header-anchor" href="#_1-2-7-启动工程" aria-hidden="true">#</a> 1.2.7 启动工程</h4>
<ol>
<li>配置tomcat服务器【参见JavaWeb4.2】</li>
<li>关于404错误：
<ul>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1658229290145-92309e05-7e02-4b44-aa1a-2cca09c94660.png#clientId=uf1197a9e-7d2f-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=845&amp;id=u085f35a2&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=845&amp;originWidth=1024&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=43962&amp;status=done&amp;style=none&amp;taskId=ua1726e89-cc59-400d-bc54-7f4bec5356e&amp;title=&amp;width=1024" alt="image.png" loading="lazy"></li>
</ul>
</li>
</ol>
<h4 id="_1-2-8-前端访问指定页面" tabindex="-1"><a class="header-anchor" href="#_1-2-8-前端访问指定页面" aria-hidden="true">#</a> 1.2.8 前端访问指定页面</h4>
<ol>
<li><code v-pre>index.html</code>下新建<code v-pre>target.html</code>，并在<code v-pre>index.html</code>添加访问链接：<code v-pre>&lt;a th:href=&quot;@{/target}&quot;&gt;访问target&lt;/a&gt;</code></li>
</ol>
<div class="language-html ext-html line-numbers-mode"><pre v-pre class="language-html"><code><span class="token doctype"><span class="token punctuation">&lt;!</span><span class="token doctype-tag">DOCTYPE</span> <span class="token name">html</span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>html</span> <span class="token attr-name">lang</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>en<span class="token punctuation">"</span></span> <span class="token attr-name"><span class="token namespace">xmlns:</span>th</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>http://www.thymeleaf.org<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>head</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>meta</span> <span class="token attr-name">charset</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>UTF-8<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>title</span><span class="token punctuation">></span></span>Title<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>title</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>head</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>body</span><span class="token punctuation">></span></span>
    hello
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>a</span> <span class="token attr-name"><span class="token namespace">th:</span>href</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>@{/target}<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>访问target<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>a</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>a</span> <span class="token attr-name"><span class="token namespace">th:</span>href</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>@{/testForward}<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>testForward<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>a</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>a</span> <span class="token attr-name"><span class="token namespace">th:</span>href</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>@{/testRedirect}<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>testRedirect<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>a</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>body</span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>html</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ol start="2">
<li><code v-pre>HelloController.java</code>中按照<code v-pre>index</code>同样的方式配置<code v-pre>targe.html</code>的访问方法。</li>
</ol>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token keyword">package</span> <span class="token namespace">iceriver<span class="token punctuation">.</span>springmvc<span class="token punctuation">.</span>controller</span><span class="token punctuation">;</span>

<span class="token keyword">import</span> <span class="token import"><span class="token namespace">org<span class="token punctuation">.</span>springframework<span class="token punctuation">.</span>stereotype<span class="token punctuation">.</span></span><span class="token class-name">Controller</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">org<span class="token punctuation">.</span>springframework<span class="token punctuation">.</span>ui<span class="token punctuation">.</span></span><span class="token class-name">ModelMap</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">org<span class="token punctuation">.</span>springframework<span class="token punctuation">.</span>web<span class="token punctuation">.</span>bind<span class="token punctuation">.</span>annotation<span class="token punctuation">.</span></span><span class="token class-name">RequestMapping</span></span><span class="token punctuation">;</span>

<span class="token annotation punctuation">@Controller</span>
<span class="token keyword">public</span> <span class="token keyword">class</span> <span class="token class-name">HelloController</span> <span class="token punctuation">{</span>
    <span class="token comment">//  通过@RequestMapping注解，可以通过请求路径匹配要处理的具体的请求</span>
    <span class="token comment">//  /表示的当前工程的上下文路径</span>
    <span class="token annotation punctuation">@RequestMapping</span><span class="token punctuation">(</span><span class="token string">"/"</span><span class="token punctuation">)</span>
    <span class="token keyword">public</span> <span class="token class-name">String</span> <span class="token function">index</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">{</span>
        <span class="token keyword">return</span> <span class="token string">"index"</span><span class="token punctuation">;</span>
    <span class="token punctuation">}</span>
    <span class="token annotation punctuation">@RequestMapping</span><span class="token punctuation">(</span><span class="token string">"/target"</span><span class="token punctuation">)</span>
    <span class="token keyword">public</span> <span class="token class-name">String</span> <span class="token function">toTarget</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">{</span>
        <span class="token keyword">return</span> <span class="token string">"target"</span><span class="token punctuation">;</span>
    <span class="token punctuation">}</span>
    <span class="token annotation punctuation">@RequestMapping</span><span class="token punctuation">(</span><span class="token string">"/testForward"</span><span class="token punctuation">)</span>
    <span class="token keyword">public</span> <span class="token class-name">String</span> <span class="token function">testForward</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">{</span>
        <span class="token keyword">return</span> <span class="token string">"forward:/target"</span><span class="token punctuation">;</span>
    <span class="token punctuation">}</span>
    <span class="token annotation punctuation">@RequestMapping</span><span class="token punctuation">(</span><span class="token string">"/testRedirect"</span><span class="token punctuation">)</span>
    <span class="token keyword">public</span> <span class="token class-name">String</span> <span class="token function">testRedirect</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">{</span>
        <span class="token keyword">return</span> <span class="token string">"redirect:/target"</span><span class="token punctuation">;</span>
    <span class="token punctuation">}</span>
<span class="token punctuation">}</span>

</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><h4 id="_1-2-9-总结" tabindex="-1"><a class="header-anchor" href="#_1-2-9-总结" aria-hidden="true">#</a> 1.2.9 总结</h4>
<ul>
<li>浏览器发送请求，若请求地址符合前端控制器的<code v-pre>url-pattern</code>（web.xml），该请求就会被前端控制器<code v-pre>DispatcherServlet</code>处理。前端控制器会读取<code v-pre>SpringMVC</code>的核心配置文件(<code v-pre>springmvc.xml</code>)，通过扫描组件找到控制器，将请求地址和控制器中<code v-pre>@RequestMapping</code>注解的<code v-pre>value</code>属性值进行匹配，若匹配成功，该注解所标识的控制器方法就是处理请求的方法。处理请求的方法需要返回一个字符串类型的视图名称，该视图名称会被视图解析器解析，加上前缀和后缀组成视图的路径，通过<code v-pre>Thymeleaf</code>对视图进行渲染，最终<strong>请求转发</strong>到视图所对应页面。</li>
</ul>
<h2 id="第2章-控制器配置" tabindex="-1"><a class="header-anchor" href="#第2章-控制器配置" aria-hidden="true">#</a> 第2章 控制器配置</h2>
<h3 id="_2-1-requestmapping注解" tabindex="-1"><a class="header-anchor" href="#_2-1-requestmapping注解" aria-hidden="true">#</a> 2.1 <code v-pre>@RequestMapping</code>注解</h3>
<h4 id="_2-1-1-使用" tabindex="-1"><a class="header-anchor" href="#_2-1-1-使用" aria-hidden="true">#</a> 2.1.1 使用</h4>
<ol>
<li>作用：用于请求和处理请求的控制器方法建立映射关系。
<ul>
<li>一个请求只能映射到一个控制器方法。一个请求映射多个控制器方法会报错。</li>
</ul>
</li>
<li>使用位置：可以用于类（控制器）前，也可以用在方法前：
<ul>
<li>用在类前：设置请求路径的初始信息</li>
<li>用在方法前：设置请求路径的具体信息</li>
<li>同时使用时，相当于请求路径进行了拼接，要符合类前设置的路径后，再去匹配方法前的路径。</li>
</ul>
</li>
</ol>
<h4 id="_2-1-2-属性" tabindex="-1"><a class="header-anchor" href="#_2-1-2-属性" aria-hidden="true">#</a> 2.1.2 属性</h4>
<ol>
<li><code v-pre>value</code>：配置请求地址
<ul>
<li><code v-pre>value</code>设置多个值时，表示该请求映射能够匹配多个请求地址所对应的请求</li>
<li><code v-pre>value</code>属性必须设置</li>
<li>不匹配时报404错误</li>
</ul>
</li>
</ol>
<div class="language-html ext-html line-numbers-mode"><pre v-pre class="language-html"><code><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>a</span> <span class="token attr-name"><span class="token namespace">th:</span>href</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>@{/testRequestMapping}<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>测试@RequestMapping的value属性-->/testRequestMapping<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>a</span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>a</span> <span class="token attr-name"><span class="token namespace">th:</span>href</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>@{/test}<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>测试@RequestMapping的value属性-->/test<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>a</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div></div></div><div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token annotation punctuation">@RequestMapping</span><span class="token punctuation">(</span>value <span class="token operator">=</span> <span class="token punctuation">{</span><span class="token string">"/testRequestMapping"</span><span class="token punctuation">,</span> <span class="token string">"/test"</span><span class="token punctuation">}</span><span class="token punctuation">)</span>
<span class="token keyword">public</span> <span class="token class-name">String</span> <span class="token function">testRequestMapping</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">{</span>
    <span class="token keyword">return</span> <span class="token string">"success"</span><span class="token punctuation">;</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ol start="2">
<li><code v-pre>mthod</code>：通过请求的请求方式（get或post）匹配请求映射
<ul>
<li><code v-pre>RequestMethod.XXX</code>设置多个时，表示该请求映射能够匹配多种请求方式的请求
<ul>
<li>处理get请求的映射：<code v-pre>@GetMapping</code></li>
<li>处理post请求的映射：<code v-pre>@PostMapping</code></li>
<li>处理put请求的映射：<code v-pre>@PutMapping</code></li>
<li>处理delete请求的映射：<code v-pre>@DeleteMapping</code></li>
</ul>
</li>
<li>请求地址满足请求映射的value属性，但不满足method属性，浏览器报错405错误</li>
<li>目前浏览器只支持get和post，在form表单提交时，设置了其他请求方式的字符串（put或delete），则按照默认的请求方式get处理</li>
<li>要发送put和delete请求，需要通过spring提供的过滤器<code v-pre>HiddenHttpMethodFilter</code>，详见RESTful。</li>
</ul>
</li>
</ol>
<div class="language-html ext-html line-numbers-mode"><pre v-pre class="language-html"><code><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>a</span> <span class="token attr-name"><span class="token namespace">th:</span>href</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>@{/test}<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>测试@RequestMapping的value属性-->/test<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>a</span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>form</span> <span class="token attr-name"><span class="token namespace">th:</span>action</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>@{/test}<span class="token punctuation">"</span></span> <span class="token attr-name">method</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>post<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>input</span> <span class="token attr-name">type</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>submit<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>form</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token annotation punctuation">@RequestMapping</span><span class="token punctuation">(</span>
        value <span class="token operator">=</span> <span class="token punctuation">{</span><span class="token string">"/testRequestMapping"</span><span class="token punctuation">,</span> <span class="token string">"/test"</span><span class="token punctuation">}</span><span class="token punctuation">,</span>
        method <span class="token operator">=</span> <span class="token punctuation">{</span><span class="token class-name">RequestMethod</span><span class="token punctuation">.</span>GET<span class="token punctuation">,</span> <span class="token class-name">RequestMethod</span><span class="token punctuation">.</span>POST<span class="token punctuation">}</span>
<span class="token punctuation">)</span>
<span class="token keyword">public</span> <span class="token class-name">String</span> <span class="token function">testRequestMapping</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">{</span>
    <span class="token keyword">return</span> <span class="token string">"success"</span><span class="token punctuation">;</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ol start="3">
<li><code v-pre>params</code>：通过请求的请求参数匹配请求映射。
<ul>
<li><code v-pre>params</code>可以通过四种表达式设置请求参数和请求映射的匹配关系
<ul>
<li><code v-pre>&quot;param&quot;</code>：要求请求映射所匹配的请求必须携带param请求参数</li>
<li><code v-pre>&quot;!param&quot;</code>：要求请求映射所匹配的请求必须不能携带param请求参数</li>
<li><code v-pre>&quot;param=value&quot;</code>：要求请求映射所匹配的请求必须携带param请求参数且<code v-pre>param=value</code></li>
<li><code v-pre>&quot;param!=value&quot;</code>：要求请求映射所匹配的请求必须携带param请求参数但是<code v-pre>param!=value</code></li>
</ul>
</li>
<li>若当前请求满足@RequestMapping注解的value和method属性，但是不满足params属性，此时页面回报错400</li>
</ul>
</li>
</ol>
<div class="language-html ext-html line-numbers-mode"><pre v-pre class="language-html"><code><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>a</span> <span class="token attr-name"><span class="token namespace">th:</span>href</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>@{/test(username=<span class="token punctuation">'</span>admin<span class="token punctuation">'</span>,password=123456)<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>测试@RequestMapping的params属性-->/test<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>a</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div></div></div><div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token annotation punctuation">@RequestMapping</span><span class="token punctuation">(</span>
        value <span class="token operator">=</span> <span class="token punctuation">{</span><span class="token string">"/testRequestMapping"</span><span class="token punctuation">,</span> <span class="token string">"/test"</span><span class="token punctuation">}</span>
        <span class="token punctuation">,</span>method <span class="token operator">=</span> <span class="token punctuation">{</span><span class="token class-name">RequestMethod</span><span class="token punctuation">.</span>GET<span class="token punctuation">,</span> <span class="token class-name">RequestMethod</span><span class="token punctuation">.</span>POST<span class="token punctuation">}</span>
        <span class="token punctuation">,</span>params <span class="token operator">=</span> <span class="token punctuation">{</span><span class="token string">"username"</span><span class="token punctuation">,</span><span class="token string">"password!=123456"</span><span class="token punctuation">}</span>
<span class="token punctuation">)</span>
<span class="token keyword">public</span> <span class="token class-name">String</span> <span class="token function">testRequestMapping</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">{</span>
    <span class="token keyword">return</span> <span class="token string">"success"</span><span class="token punctuation">;</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ol start="4">
<li><code v-pre>headers</code>：通过请求的请求头信息匹配请求映射
<ul>
<li><code v-pre>headers</code>可以通过四种表达式设置请求头信息和请求映射的匹配关系
<ul>
<li><code v-pre>&quot;header&quot;</code>：要求请求映射所匹配的请求必须携带header请求头信息</li>
<li><code v-pre>&quot;!header&quot;</code>：要求请求映射所匹配的请求必须不能携带header请求头信息</li>
<li><code v-pre>&quot;header=value&quot;</code>：要求请求映射所匹配的请求必须携带header请求头信息且header=value</li>
<li><code v-pre>&quot;header!=value&quot;</code>：要求请求映射所匹配的请求必须携带header请求头信息且header!=value</li>
</ul>
</li>
<li>若当前请求满足<code v-pre>@RequestMapping</code>注解的value和method属性，但是不满足headers属性，此时页面显示404错误，即资源未找到</li>
</ul>
</li>
</ol>
<h4 id="_2-1-3-ant风格路径" tabindex="-1"><a class="header-anchor" href="#_2-1-3-ant风格路径" aria-hidden="true">#</a> 2.1.3 ant风格路径</h4>
<ol>
<li><code v-pre>@RequestMapping</code>修饰的<code v-pre>value</code>属性代表的匹配路径可以使用ant风格，ant风格的规则如下：
<ul>
<li><code v-pre>?</code>：表示任意的单个字符
<ul>
<li>但不能表示<code v-pre>/</code>和<code v-pre>?</code>。</li>
</ul>
</li>
<li><code v-pre>*</code>：表示任意的0个或多个字符</li>
<li><code v-pre>**</code>：表示任意的一层或多层目录
<ul>
<li>使用<code v-pre>**</code>时只能连用，中间有任何其他字符会当作单个<code v-pre>*</code></li>
</ul>
</li>
</ul>
</li>
</ol>
<h4 id="_2-1-4-路径占位符" tabindex="-1"><a class="header-anchor" href="#_2-1-4-路径占位符" aria-hidden="true">#</a> 2.1.4 路径占位符</h4>
<ol>
<li><code v-pre>SpringMVC</code>支持占位符，常用于<code v-pre>RESTful</code>风格中。占位符表示路径中该位置实际上是个参数。</li>
</ol>
<div class="language-html ext-html line-numbers-mode"><pre v-pre class="language-html"><code><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>a</span> <span class="token attr-name"><span class="token namespace">th:</span>href</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>@{/testRest/1/admin}<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>测试路径中的占位符-->/testRest<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>a</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div></div></div><div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token annotation punctuation">@RequestMapping</span><span class="token punctuation">(</span><span class="token string">"/testRest/{id}/{username}"</span><span class="token punctuation">)</span>
<span class="token keyword">public</span> <span class="token class-name">String</span> <span class="token function">testRest</span><span class="token punctuation">(</span><span class="token annotation punctuation">@PathVariable</span><span class="token punctuation">(</span><span class="token string">"id"</span><span class="token punctuation">)</span> <span class="token class-name">String</span> id<span class="token punctuation">,</span> 
                       <span class="token annotation punctuation">@PathVariable</span><span class="token punctuation">(</span><span class="token string">"username"</span><span class="token punctuation">)</span> <span class="token class-name">String</span> username<span class="token punctuation">)</span><span class="token punctuation">{</span>
    <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span><span class="token string">"id:"</span><span class="token operator">+</span>id<span class="token operator">+</span><span class="token string">",username:"</span><span class="token operator">+</span>username<span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token keyword">return</span> <span class="token string">"success"</span><span class="token punctuation">;</span>
<span class="token punctuation">}</span>
<span class="token comment">//最终输出的内容为-->id:1,username:admin</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><h3 id="_2-2-获取请求参数" tabindex="-1"><a class="header-anchor" href="#_2-2-获取请求参数" aria-hidden="true">#</a> 2.2 获取请求参数</h3>
<h4 id="_2-2-1-通过servletapi获取" tabindex="-1"><a class="header-anchor" href="#_2-2-1-通过servletapi获取" aria-hidden="true">#</a> 2.2.1 通过ServletAPI获取</h4>
<ol>
<li>使用<code v-pre>HttpServletRequest</code>对象的表单数据获取方法【参见Javaweb5.7.5】
<ul>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1656810593034-3fdf7e41-ea0f-472f-a141-e718d9405fe0.png#clientId=u74efd510-37c1-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=159&amp;id=u5aac544f&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=159&amp;originWidth=873&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=23985&amp;status=done&amp;style=none&amp;taskId=ud7c0010f-b582-41dc-abc9-4e82989dcb1&amp;title=&amp;width=873" alt="image.png" loading="lazy"></li>
</ul>
</li>
</ol>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token annotation punctuation">@RequestMapping</span><span class="token punctuation">(</span><span class="token string">"/testParam"</span><span class="token punctuation">)</span>
<span class="token keyword">public</span> <span class="token class-name">String</span> <span class="token function">testParam</span><span class="token punctuation">(</span><span class="token class-name">HttpServletRequest</span> request<span class="token punctuation">)</span><span class="token punctuation">{</span>
    <span class="token class-name">String</span> username <span class="token operator">=</span> request<span class="token punctuation">.</span><span class="token function">getParameter</span><span class="token punctuation">(</span><span class="token string">"username"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token class-name">String</span> password <span class="token operator">=</span> request<span class="token punctuation">.</span><span class="token function">getParameter</span><span class="token punctuation">(</span><span class="token string">"password"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span><span class="token string">"username:"</span><span class="token operator">+</span>username<span class="token operator">+</span><span class="token string">",password:"</span><span class="token operator">+</span>password<span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token keyword">return</span> <span class="token string">"success"</span><span class="token punctuation">;</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><h4 id="_2-2-2-通过控制器方法的形参获取" tabindex="-1"><a class="header-anchor" href="#_2-2-2-通过控制器方法的形参获取" aria-hidden="true">#</a> 2.2.2 通过控制器方法的形参获取</h4>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token annotation punctuation">@RequestMapping</span><span class="token punctuation">(</span><span class="token string">"/testParam"</span><span class="token punctuation">)</span>
<span class="token keyword">public</span> <span class="token class-name">String</span> <span class="token function">testParam</span><span class="token punctuation">(</span><span class="token class-name">String</span> username<span class="token punctuation">,</span> <span class="token class-name">String</span> password<span class="token punctuation">)</span><span class="token punctuation">{</span>
    <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span><span class="token string">"username:"</span><span class="token operator">+</span>username<span class="token operator">+</span><span class="token string">",password:"</span><span class="token operator">+</span>password<span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token keyword">return</span> <span class="token string">"success"</span><span class="token punctuation">;</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><div class="language-html ext-html line-numbers-mode"><pre v-pre class="language-html"><code><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>a</span> <span class="token attr-name"><span class="token namespace">th:</span>href</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>@{/testParam(username=<span class="token punctuation">'</span>admin<span class="token punctuation">'</span>,password=123456)}<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>测试获取请求参数-->/testParam<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>a</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div></div></div><ul>
<li>多个同名参数（如复选框），可以使用字符串接收，此时多个参数值会以<code v-pre>,</code>分隔。如<code v-pre>hobby:a,b,c</code></li>
<li>多个同名参数（如复选框），也可以使用字符串数组接收，此时多个参数值会组成数组。</li>
<li>支持<code v-pre>get</code>、<code v-pre>post</code>、<code v-pre>超链接</code>传参。</li>
<li>通过控制方法形参获取请求参数的方式要求形参和实参的名称一模一样。</li>
</ul>
<h4 id="_2-2-3-requestparam" tabindex="-1"><a class="header-anchor" href="#_2-2-3-requestparam" aria-hidden="true">#</a> 2.2.3 <code v-pre>@RequestParam</code></h4>
<ul>
<li>通过控制方法形参获取请求参数的方式要求形参和实参的名称一模一样。对于名称不一样的情况，可以使用<code v-pre>@RequestParam</code>建立参数映射关系。
<ul>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1658278125568-00da5e33-54ee-4de3-aefa-3fb232b3d816.png#clientId=uf1197a9e-7d2f-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=65&amp;id=ubcb18ed4&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=65&amp;originWidth=568&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=15572&amp;status=done&amp;style=none&amp;taskId=u40f5fb3a-37b9-4476-83f0-28a6f800ba2&amp;title=&amp;width=568" alt="image.png" loading="lazy"></li>
</ul>
</li>
<li><code v-pre>@RequestParam</code>的属性：
<ul>
<li><code v-pre>value</code>、<code v-pre>name</code>：二者等价，为形参和实参建立映射关系</li>
<li><code v-pre>defaultValue</code>：为实参设置默认值，如果<code v-pre>user_name</code>没有传递或传递<code v-pre>&quot;&quot;</code>，则使用默认值。
<ul>
<li>不设置<code v-pre>defaultValue</code>，请求未传递参数时值为<code v-pre>null</code></li>
</ul>
</li>
<li><code v-pre>required</code>：该参数是否必须，默认为true，表示必须。
<ul>
<li>设置为true时，同时没有设置<code v-pre>defaultValue</code>，请求未传递参数时报<code v-pre>40</code>错误——请求未传参。</li>
<li>设置为false，同时没有设置<code v-pre>defaultValue</code>，请求未传递参数时值为<code v-pre>null</code>。</li>
</ul>
</li>
</ul>
</li>
</ul>
<h4 id="_2-2-4-pathvariable路径占位符" tabindex="-1"><a class="header-anchor" href="#_2-2-4-pathvariable路径占位符" aria-hidden="true">#</a> 2.2.4 <code v-pre>@PathVariable</code>路径占位符</h4>
<ul>
<li>见本章【2.1.4<a href="#wG0bQ">https://www.yuque.com/zhuyuqi/zna9x5/zh889g#wG0bQ</a>】</li>
<li><code v-pre>@PathVariable</code>与<code v-pre>@RequestParam</code>的区别：
<ul>
<li><code v-pre>@PathVariable</code>只能用于请求路径上<code v-pre>/</code>的参数（RESTful风格），一般用于<code v-pre>get</code>、<code v-pre>delete</code>请求</li>
<li><code v-pre>@RequestParam</code>只能用于传统请求路径上<code v-pre>?</code>和<code v-pre>&amp;</code>风格的请求参数，一般用于<code v-pre>post</code>请求</li>
<li><code v-pre>@PathVariable</code>没有<code v-pre>defaultValue</code></li>
</ul>
</li>
</ul>
<h4 id="_2-2-5-reqquestheader" tabindex="-1"><a class="header-anchor" href="#_2-2-5-reqquestheader" aria-hidden="true">#</a> 2.2.5 <code v-pre>@ReqquestHeader</code></h4>
<ul>
<li>将请求头信息和控制器方法的形参创建映射关系。</li>
<li>属性有三个<code v-pre>value</code>、<code v-pre>required</code>、<code v-pre>defaultValue</code></li>
<li>用法同<code v-pre>@RequestParam</code></li>
</ul>
<h4 id="_2-2-6-cookievalue" tabindex="-1"><a class="header-anchor" href="#_2-2-6-cookievalue" aria-hidden="true">#</a> 2.2.6 <code v-pre>@CookieValue</code></h4>
<ul>
<li>将cookie数据和控制器方法的形参创建映射关系</li>
<li>属性有三个<code v-pre>value</code>、<code v-pre>required</code>、<code v-pre>defaultValue</code>，</li>
<li>用法同<code v-pre>@RequestParam</code></li>
<li>参数类型使用Cookie时，可以得到整个cookie对象</li>
</ul>
<h4 id="_2-2-7-通过pojo获取请求参数" tabindex="-1"><a class="header-anchor" href="#_2-2-7-通过pojo获取请求参数" aria-hidden="true">#</a> 2.2.7 通过POJO获取请求参数</h4>
<ul>
<li>可以在控制器方法形参位置传入一个<code v-pre>pojo</code>类对象作为形参，当请求的参数名和<code v-pre>pojo</code>的属性名一致，会自动赋值，即创建对象。</li>
</ul>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token annotation punctuation">@RequestMapping</span><span class="token punctuation">(</span><span class="token string">"/testpojo"</span><span class="token punctuation">)</span>
<span class="token keyword">public</span> <span class="token class-name">String</span> <span class="token function">testPOJO</span><span class="token punctuation">(</span><span class="token class-name">User</span> user<span class="token punctuation">)</span><span class="token punctuation">{</span>
    <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span>user<span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token keyword">return</span> <span class="token string">"success"</span><span class="token punctuation">;</span>
<span class="token punctuation">}</span>
<span class="token comment">//最终结果-->User{id=null, username='张三', password='123', age=23, sex='男', email='123@qq.com'}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><div class="language-html ext-html line-numbers-mode"><pre v-pre class="language-html"><code><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>form</span> <span class="token attr-name"><span class="token namespace">th:</span>action</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>@{/testpojo}<span class="token punctuation">"</span></span> <span class="token attr-name">method</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>post<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
    用户名：<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>input</span> <span class="token attr-name">type</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>text<span class="token punctuation">"</span></span> <span class="token attr-name">name</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>username<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>br</span><span class="token punctuation">></span></span>
    密码：<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>input</span> <span class="token attr-name">type</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>password<span class="token punctuation">"</span></span> <span class="token attr-name">name</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>password<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>br</span><span class="token punctuation">></span></span>
    性别：<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>input</span> <span class="token attr-name">type</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>radio<span class="token punctuation">"</span></span> <span class="token attr-name">name</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>sex<span class="token punctuation">"</span></span> <span class="token attr-name">value</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>男<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>男<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>input</span> <span class="token attr-name">type</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>radio<span class="token punctuation">"</span></span> <span class="token attr-name">name</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>sex<span class="token punctuation">"</span></span> <span class="token attr-name">value</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>女<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>女<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>br</span><span class="token punctuation">></span></span>
    年龄：<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>input</span> <span class="token attr-name">type</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>text<span class="token punctuation">"</span></span> <span class="token attr-name">name</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>age<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>br</span><span class="token punctuation">></span></span>
    邮箱：<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>input</span> <span class="token attr-name">type</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>text<span class="token punctuation">"</span></span> <span class="token attr-name">name</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>email<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>br</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>input</span> <span class="token attr-name">type</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>submit<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>form</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><h3 id="_2-3处理请求参数的乱码" tabindex="-1"><a class="header-anchor" href="#_2-3处理请求参数的乱码" aria-hidden="true">#</a> 2.3处理请求参数的乱码</h3>
<ul>
<li><code v-pre>GET</code>请求乱码：跟tomcat版本有关，【参见JavaWeb5.7.5】</li>
<li><code v-pre>POST</code>请求乱码：在<code v-pre>web.xml</code>文件中，使用过滤器</li>
</ul>
<div class="language-xml ext-xml line-numbers-mode"><pre v-pre class="language-xml"><code><span class="token comment">&lt;!--配置springMVC的编码过滤器--></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>filter</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>filter-name</span><span class="token punctuation">></span></span>CharacterEncodingFilter<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>filter-name</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>filter-class</span><span class="token punctuation">></span></span>org.springframework.web.filter.CharacterEncodingFilter<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>filter-class</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>init-param</span><span class="token punctuation">></span></span>
        <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>param-name</span><span class="token punctuation">></span></span>encoding<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>param-name</span><span class="token punctuation">></span></span>
        <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>param-value</span><span class="token punctuation">></span></span>UTF-8<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>param-value</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>init-param</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>init-param</span><span class="token punctuation">></span></span>
        <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>param-name</span><span class="token punctuation">></span></span>forceResponseEncoding<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>param-name</span><span class="token punctuation">></span></span>
        <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>param-value</span><span class="token punctuation">></span></span>true<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>param-value</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>init-param</span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>filter</span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>filter-mapping</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>filter-name</span><span class="token punctuation">></span></span>CharacterEncodingFilter<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>filter-name</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>url-pattern</span><span class="token punctuation">></span></span>/*<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>url-pattern</span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>filter-mapping</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><h2 id="第3章-域对象共享数据" tabindex="-1"><a class="header-anchor" href="#第3章-域对象共享数据" aria-hidden="true">#</a> 第3章 域对象共享数据</h2>
<h3 id="_3-1-向request域对象共享数据" tabindex="-1"><a class="header-anchor" href="#_3-1-向request域对象共享数据" aria-hidden="true">#</a> 3.1 向<code v-pre>request</code>域对象共享数据</h3>
<h4 id="_3-1-1-共享request域对象共享数据的原理" tabindex="-1"><a class="header-anchor" href="#_3-1-1-共享request域对象共享数据的原理" aria-hidden="true">#</a> 3.1.1 共享<code v-pre>request</code>域对象共享数据的原理</h4>
<ol>
<li>SpringMVC本质上是请求转发，这样从头到尾是一个请求，所以可以通过<code v-pre>request</code>域对象共享数据。</li>
</ol>
<h4 id="_3-1-2-向request域对象共享数据的方式" tabindex="-1"><a class="header-anchor" href="#_3-1-2-向request域对象共享数据的方式" aria-hidden="true">#</a> 3.1.2 向<code v-pre>request</code>域对象共享数据的方式</h4>
<ol>
<li>使用<code v-pre>ServletAPI</code>向<code v-pre>request</code>域对象共享数据：</li>
</ol>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token annotation punctuation">@RequestMapping</span><span class="token punctuation">(</span><span class="token string">"/testServletAPI"</span><span class="token punctuation">)</span>
<span class="token keyword">public</span> <span class="token class-name">String</span> <span class="token function">testServletAPI</span><span class="token punctuation">(</span><span class="token class-name">HttpServletRequest</span> request<span class="token punctuation">)</span><span class="token punctuation">{</span>
    request<span class="token punctuation">.</span><span class="token function">setAttribute</span><span class="token punctuation">(</span><span class="token string">"testScope"</span><span class="token punctuation">,</span> <span class="token string">"hello,servletAPI"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token keyword">return</span> <span class="token string">"success"</span><span class="token punctuation">;</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ol start="2">
<li>使用<code v-pre>ModelAndView</code>向<code v-pre>request</code>域对象共享数据：</li>
</ol>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token annotation punctuation">@RequestMapping</span><span class="token punctuation">(</span><span class="token string">"/testModelAndView"</span><span class="token punctuation">)</span>
<span class="token keyword">public</span> <span class="token class-name">ModelAndView</span> <span class="token function">testModelAndView</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">{</span>
    <span class="token class-name">ModelAndView</span> mav <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">ModelAndView</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
    mav<span class="token punctuation">.</span><span class="token function">addObject</span><span class="token punctuation">(</span><span class="token string">"testScope"</span><span class="token punctuation">,</span> <span class="token string">"hello,ModelAndView"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
    mav<span class="token punctuation">.</span><span class="token function">setViewName</span><span class="token punctuation">(</span><span class="token string">"success"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token keyword">return</span> mav<span class="token punctuation">;</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ol start="3">
<li>使用Model向request域对象共享数据</li>
</ol>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token annotation punctuation">@RequestMapping</span><span class="token punctuation">(</span><span class="token string">"/testModel"</span><span class="token punctuation">)</span>
<span class="token keyword">public</span> <span class="token class-name">String</span> <span class="token function">testModel</span><span class="token punctuation">(</span><span class="token class-name">Model</span> model<span class="token punctuation">)</span><span class="token punctuation">{</span>
    model<span class="token punctuation">.</span><span class="token function">addAttribute</span><span class="token punctuation">(</span><span class="token string">"testScope"</span><span class="token punctuation">,</span> <span class="token string">"hello,Model"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token keyword">return</span> <span class="token string">"success"</span><span class="token punctuation">;</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ol start="4">
<li>使用map向request域对象共享数据</li>
</ol>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token annotation punctuation">@RequestMapping</span><span class="token punctuation">(</span><span class="token string">"/testMap"</span><span class="token punctuation">)</span>
<span class="token keyword">public</span> <span class="token class-name">String</span> <span class="token function">testMap</span><span class="token punctuation">(</span><span class="token class-name">Map</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">String</span><span class="token punctuation">,</span> <span class="token class-name">Object</span><span class="token punctuation">></span></span> map<span class="token punctuation">)</span><span class="token punctuation">{</span>
    map<span class="token punctuation">.</span><span class="token function">put</span><span class="token punctuation">(</span><span class="token string">"testScope"</span><span class="token punctuation">,</span> <span class="token string">"hello,Map"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token keyword">return</span> <span class="token string">"success"</span><span class="token punctuation">;</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ol start="5">
<li>使用ModelMap向request域对象共享数据</li>
</ol>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token annotation punctuation">@RequestMapping</span><span class="token punctuation">(</span><span class="token string">"/testModelMap"</span><span class="token punctuation">)</span>
<span class="token keyword">public</span> <span class="token class-name">String</span> <span class="token function">testModelMap</span><span class="token punctuation">(</span><span class="token class-name">ModelMap</span> modelMap<span class="token punctuation">)</span><span class="token punctuation">{</span>
    modelMap<span class="token punctuation">.</span><span class="token function">addAttribute</span><span class="token punctuation">(</span><span class="token string">"testScope"</span><span class="token punctuation">,</span> <span class="token string">"hello,ModelMap"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token keyword">return</span> <span class="token string">"success"</span><span class="token punctuation">;</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ol start="6">
<li>五种方式对比：</li>
</ol>
<table>
<thead>
<tr>
<th>类</th>
<th>参数类型</th>
<th>方法</th>
<th>返回值</th>
</tr>
</thead>
<tbody>
<tr>
<td><code v-pre>HttpServletRequest</code></td>
<td><code v-pre>HttpServletRequest</code></td>
<td><code v-pre>setAttribute()</code></td>
<td>字符串页面名</td>
</tr>
<tr>
<td><code v-pre>ModelAndView</code></td>
<td>无参</td>
<td><code v-pre>addObject()</code></td>
<td><code v-pre>ModelAndView</code>的的对象</td>
</tr>
<tr>
<td><code v-pre>Model</code></td>
<td><code v-pre>Model</code></td>
<td><code v-pre>addAttribute()</code></td>
<td>字符串页面名</td>
</tr>
<tr>
<td><code v-pre>Map&lt;String, Object&gt;</code></td>
<td>Map&lt;String, Object&gt;</td>
<td><code v-pre>put()</code></td>
<td>字符串页面名</td>
</tr>
<tr>
<td><code v-pre>ModelMap</code></td>
<td><code v-pre>ModelMap</code></td>
<td><code v-pre>addAttribute()</code></td>
<td>字符串页面名</td>
</tr>
</tbody>
</table>
<ul>
<li><code v-pre>HttpServletRequest</code>是<code v-pre>servlet</code>的原生对象。</li>
<li><code v-pre>Model</code>、<code v-pre>ModelMap</code>、<code v-pre>Map</code>本质运行类型均为<code v-pre>BindingAwareModelMap</code>【使用了多态】，本质一样。
<ul>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1658290087288-a92b3ccd-8a85-4241-a396-ac29623fee14.png#clientId=uf1197a9e-7d2f-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=372&amp;id=u139fc801&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=512&amp;originWidth=535&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=25181&amp;status=done&amp;style=none&amp;taskId=u40ba6b12-b3f7-49ee-a699-1f093076429&amp;title=&amp;width=389" alt="image.png" loading="lazy"></li>
</ul>
</li>
</ul>
<h4 id="_3-1-3-使用request域对象属性" tabindex="-1"><a class="header-anchor" href="#_3-1-3-使用request域对象属性" aria-hidden="true">#</a> 3.1.3 使用<code v-pre>request</code>域对象属性</h4>
<ul>
<li><code v-pre>request</code>域对象设置的属性，<code v-pre>thymeleaf</code>调用时可以直接使用属性名调用。</li>
</ul>
<h3 id="_3-2-向session域对象共享数据" tabindex="-1"><a class="header-anchor" href="#_3-2-向session域对象共享数据" aria-hidden="true">#</a> 3.2 向<code v-pre>session</code>域对象共享数据</h3>
<ol>
<li>使用原生的<code v-pre>HttpSession</code>类对象进行设置，方法为<code v-pre>setAttribute()</code></li>
<li>使用属性时，需要使用<code v-pre>session.属性名</code></li>
</ol>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token annotation punctuation">@RequestMapping</span><span class="token punctuation">(</span><span class="token string">"/testSession"</span><span class="token punctuation">)</span>
<span class="token keyword">public</span> <span class="token class-name">String</span> <span class="token function">testSession</span><span class="token punctuation">(</span><span class="token class-name">HttpSession</span> session<span class="token punctuation">)</span><span class="token punctuation">{</span>
    session<span class="token punctuation">.</span><span class="token function">setAttribute</span><span class="token punctuation">(</span><span class="token string">"testSessionScope"</span><span class="token punctuation">,</span> <span class="token string">"hello,session"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token keyword">return</span> <span class="token string">"success"</span><span class="token punctuation">;</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><h3 id="_3-3-向application域对象共享数据" tabindex="-1"><a class="header-anchor" href="#_3-3-向application域对象共享数据" aria-hidden="true">#</a> 3.3 向<code v-pre>application</code>域对象共享数据</h3>
<h4 id="_3-3-1-获取application域对象" tabindex="-1"><a class="header-anchor" href="#_3-3-1-获取application域对象" aria-hidden="true">#</a> 3.3.1 获取<code v-pre>application</code>域对象</h4>
<ol>
<li><code v-pre>application</code>域对象是<code v-pre>ServletContext</code>的实例对象</li>
<li>获取<code v-pre>ServletContext</code>实例对象的方式有多种：【参见Javaweb5.7.3】
<ul>
<li>通过<code v-pre>request</code>对象获取：<code v-pre>request.getServletContext()</code></li>
<li>通过<code v-pre>session</code>对象获取：<code v-pre>session.getServletContext()</code></li>
<li>通过<code v-pre>init()</code>方法中，通过<code v-pre>ServletConfig</code>对象获取：<code v-pre>servletConfig.getServletContext()</code>。</li>
<li>通过jsp页面的<code v-pre>pageContext</code>内置对象</li>
</ul>
</li>
</ol>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token annotation punctuation">@RequestMapping</span><span class="token punctuation">(</span><span class="token string">"/testApplication"</span><span class="token punctuation">)</span>
<span class="token keyword">public</span> <span class="token class-name">String</span> <span class="token function">testApplication</span><span class="token punctuation">(</span><span class="token class-name">HttpSession</span> session<span class="token punctuation">)</span><span class="token punctuation">{</span>
 <span class="token class-name">ServletContext</span> application <span class="token operator">=</span> session<span class="token punctuation">.</span><span class="token function">getServletContext</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
    application<span class="token punctuation">.</span><span class="token function">setAttribute</span><span class="token punctuation">(</span><span class="token string">"testApplicationScope"</span><span class="token punctuation">,</span> <span class="token string">"hello,application"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token keyword">return</span> <span class="token string">"success"</span><span class="token punctuation">;</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><h4 id="_3-3-2-使用方式" tabindex="-1"><a class="header-anchor" href="#_3-3-2-使用方式" aria-hidden="true">#</a> 3.3.2 使用方式</h4>
<ol>
<li>设置即原生方式：调用<code v-pre>ServletContext</code>类对象的<code v-pre>setAttribute()</code>方法进行设置</li>
<li>使用即原生方式：通过<code v-pre>application.属性名</code></li>
</ol>
<h2 id="第4章-springmvc的视图" tabindex="-1"><a class="header-anchor" href="#第4章-springmvc的视图" aria-hidden="true">#</a> 第4章 SpringMVC的视图</h2>
<h3 id="_4-0-springmvc视图介绍" tabindex="-1"><a class="header-anchor" href="#_4-0-springmvc视图介绍" aria-hidden="true">#</a> 4.0 SpringMVC视图介绍</h3>
<ol>
<li>SpringMVC中的视图是View接口，视图的作用渲染数据，将模型Model中的数据展示给用户</li>
<li>SpringMVC视图的种类很多，默认有转发视图和重定向视图</li>
<li>如果springmvc配置文件没有配置视图解析器，应该样实现请求访问呢？
<ul>
<li>2022.07.20测试：
<ul>
<li>配置了<code v-pre>InternalResourceView</code>视图解析（未配置前后缀）、不配置视图解析器，使用forward、不使用forward，只要控制器地址写从web路径开始的文件全路径，就可以访问到jsp页面。</li>
<li>但不能访问html页面、配置了前后缀会访问不到jsp页面。</li>
</ul>
</li>
</ul>
</li>
</ol>
<h3 id="_4-1-默认视图" tabindex="-1"><a class="header-anchor" href="#_4-1-默认视图" aria-hidden="true">#</a> 4.1 默认视图</h3>
<h4 id="_4-1-1-转发视图" tabindex="-1"><a class="header-anchor" href="#_4-1-1-转发视图" aria-hidden="true">#</a> 4.1.1 转发视图</h4>
<ol>
<li>SpringMVC中默认的转发视图是<code v-pre>InternalResourceView</code></li>
<li>当控制器方法中所设置的视图名称以<code v-pre>forward:</code>为前缀时，此时的视图名称不会被SpringMVC配置文件中所配置的视图解析器解析，而是会将前缀<code v-pre>forward:</code>去掉，剩余部分作为最终路径通过转发的方式实现跳转
<ul>
<li>没有写<code v-pre>forward:</code>，且没有配置视图解析器时，默认的转发视图也是<code v-pre>InternalResourceView</code></li>
</ul>
</li>
<li>不能直接跳转<code v-pre>WEB-INF</code>下的静态资源，必须跳转到控制器中的其他跳转方法。</li>
</ol>
<h4 id="_4-1-2-重定向视图" tabindex="-1"><a class="header-anchor" href="#_4-1-2-重定向视图" aria-hidden="true">#</a> 4.1.2 重定向视图</h4>
<ol>
<li>SpringMVC中默认的重定向视图是<code v-pre>RedirectView</code></li>
<li>当控制器方法中所设置的视图名称以<code v-pre>redirect:</code>为前缀时，此时的视图名称不会被SpringMVC配置文件中所配置的视图解析器解析，而是会将前缀<code v-pre>redirect:</code>去掉，剩余部分作为最终路径通过重定向的方式实现跳转</li>
<li>不能直接跳转<code v-pre>WEB-INF</code>下的静态资源，必须跳转到控制器中的其他跳转方法。</li>
<li>重定向视图和转发视图都会让浏览器地址发生变化，但转发视图最后的地址为请求的地址（<code v-pre>forward</code>后的部分），重定向视图最后的地址为转发后处理的地址（<code v-pre>redirect</code>给了谁，这个谁处理后的地址才是浏览器的地址）
<ul>
<li>从前端请求的角度看，重定向的地址跳到了不是他发起请求的一个地址。</li>
</ul>
</li>
</ol>
<h3 id="_4-2-其他视图" tabindex="-1"><a class="header-anchor" href="#_4-2-其他视图" aria-hidden="true">#</a> 4.2 其他视图</h3>
<h4 id="_4-2-1-thymeleafview" tabindex="-1"><a class="header-anchor" href="#_4-2-1-thymeleafview" aria-hidden="true">#</a> 4.2.1 ThymeleafView</h4>
<ol>
<li>当控制器方法中所设置的视图名称没有任何前缀时，此时的视图名称会被SpringMVC配置文件中所配置的视图解析器解析，视图名称拼接视图前缀和视图后缀所得到的最终路径，会通过转发的方式实现跳转</li>
</ol>
<h4 id="_4-2-2-internalresourceview" tabindex="-1"><a class="header-anchor" href="#_4-2-2-internalresourceview" aria-hidden="true">#</a> 4.2.2 <code v-pre>InternalResourceView</code></h4>
<ol>
<li>SpringMVC默认的视图解析器，不配置视图解析器，或者配置了视图解析器，但转发以<code v-pre>forward:</code>开头，或者配置的视图解析器就是<code v-pre>InternalResourceView</code>（如jsp页面），则使用该视图的方式（前后缀）进行跳转。</li>
</ol>
<h3 id="_4-3-视图控制器view-controller" tabindex="-1"><a class="header-anchor" href="#_4-3-视图控制器view-controller" aria-hidden="true">#</a> 4.3 视图控制器view-controller</h3>
<ol>
<li>当控制器方法中，仅仅用来实现页面跳转，没有其他处理时，可以在<code v-pre>SpringMVC.xm</code>l配置文件中将处理器方法使用<code v-pre>&lt;view-controller&gt;</code>标签进行表示，在配置文件中完成跳转。
<ul>
<li><code v-pre>&lt;mvc:view-controller path=&quot;/testView&quot; view-name=&quot;success&quot;&gt;&lt;/mvc:view-controller&gt;</code>
<ul>
<li><code v-pre>path</code>：设置处理的请求地址</li>
<li><code v-pre>view-name</code>：设置请求地址所对应的视图名称</li>
</ul>
</li>
</ul>
</li>
</ol>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token operator">&lt;</span>mvc<span class="token operator">:</span>view<span class="token operator">-</span>controller path<span class="token operator">=</span><span class="token string">"/"</span> view<span class="token operator">-</span>name<span class="token operator">=</span><span class="token string">"index"</span><span class="token operator">/</span><span class="token operator">></span><span class="token operator">&lt;</span><span class="token operator">!</span><span class="token operator">--</span>配置视图控制器<span class="token operator">--</span><span class="token operator">></span><span class="token operator">&lt;</span><span class="token operator">!</span><span class="token operator">--</span>访问首页<span class="token operator">--</span><span class="token operator">></span>   
<span class="token operator">&lt;</span>mvc<span class="token operator">:</span>annotation<span class="token operator">-</span>driven <span class="token operator">/</span><span class="token operator">></span><span class="token operator">&lt;</span><span class="token operator">!</span><span class="token operator">--</span>开启mvc注解驱动<span class="token operator">--</span><span class="token operator">></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div></div></div><ol start="2">
<li>当SpringMVC配置文件中设置任何一个<code v-pre>&lt;view-controller&gt;</code>时，控制器中的其他请求映射方法将全部失效，此时需要在SpringMVC配置文件中开启mvc注解驱动：
<ul>
<li><code v-pre>&lt;mvc:annotation-driven /&gt;</code></li>
<li><code v-pre>&lt;mvc:annotation-driven /&gt;</code>功能有很多，这里只是用到了它的一个很小的点。</li>
</ul>
</li>
</ol>
<h2 id="第5章-restful风格" tabindex="-1"><a class="header-anchor" href="#第5章-restful风格" aria-hidden="true">#</a> 第5章 RESTful风格</h2>
<h3 id="_5-1-restful简介" tabindex="-1"><a class="header-anchor" href="#_5-1-restful简介" aria-hidden="true">#</a> 5.1 RESTful简介</h3>
<ul>
<li>REST：Representational State Transfer，表现层资源状态转移。</li>
</ul>
<h4 id="_5-1-1-资源" tabindex="-1"><a class="header-anchor" href="#_5-1-1-资源" aria-hidden="true">#</a> 5.1.1 资源</h4>
<ul>
<li>资源是一种看待服务器的方式，即，将服务器看作是由很多离散的资源组成。每个资源是服务器上一个可命名的抽象概念。因为资源是一个抽象的概念，所以它不仅仅能代表服务器文件系统中的一个文件、数据库中的一张表等等具体的东西，可以将资源设计的要多抽象有多抽象，只要想象力允许而且客户端应用开发者能够理解。与面向对象设计类似，资源是以名词为核心来组织的，首先关注的是名词。一个资源可以由一个或多个URI来标识。URI既是资源的名称，也是资源在Web上的地址。对某个资源感兴趣的客户端应用，可以通过资源的URI与其进行交互。</li>
</ul>
<h4 id="_5-1-2-资源的表述" tabindex="-1"><a class="header-anchor" href="#_5-1-2-资源的表述" aria-hidden="true">#</a> 5.1.2 资源的表述</h4>
<ul>
<li>资源的表述是一段对于资源在某个特定时刻的状态的描述。可以在客户端-服务器端之间转移（交换）。资源的表述可以有多种格式，例如HTML/XML/JSON/纯文本/图片/视频/音频等等。资源的表述格式可以通过协商机制来确定。请求-响应方向的表述通常使用不同的格式。</li>
</ul>
<h4 id="_5-1-3-状态转移" tabindex="-1"><a class="header-anchor" href="#_5-1-3-状态转移" aria-hidden="true">#</a> 5.1.3 状态转移</h4>
<ul>
<li>状态转移说的是：在客户端和服务器端之间转移（transfer）代表资源状态的表述。通过转移和操作资源的表述，来间接实现操作资源的目的。</li>
</ul>
<h3 id="_5-2-restful的实现" tabindex="-1"><a class="header-anchor" href="#_5-2-restful的实现" aria-hidden="true">#</a> 5.2 RESTful的实现</h3>
<h4 id="_5-2-1-路径与请求的关系" tabindex="-1"><a class="header-anchor" href="#_5-2-1-路径与请求的关系" aria-hidden="true">#</a> 5.2.1 路径与请求的关系</h4>
<ol>
<li>RESTful中，将 HTTP 协议里面，四个表示操作方式：<code v-pre>GET</code>、<code v-pre>POST</code>、<code v-pre>PUT</code>、<code v-pre>DELETE</code>对应成四种基本操作：
<ul>
<li><code v-pre>GET</code>用来获取资源</li>
<li><code v-pre>POST</code>用来新建资源</li>
<li><code v-pre>PUT</code>用来更新资源</li>
<li><code v-pre>DELETE</code>用来删除资源。</li>
</ul>
</li>
<li>REST 风格提倡 URL 地址使用统一的风格设计，从前到后各个单词使用斜杠分开，不使用问号键值对方式携带请求参数，而是将要发送给服务器的数据作为 URL 地址的一部分，以保证整体风格的一致性。</li>
</ol>
<table>
<thead>
<tr>
<th><strong>操作</strong></th>
<th><strong>传统方式</strong></th>
<th><strong>REST风格</strong></th>
</tr>
</thead>
<tbody>
<tr>
<td>查询操作</td>
<td>getUserById?id=1</td>
<td>user/1--&gt;get请求方式</td>
</tr>
<tr>
<td>保存操作</td>
<td>saveUser</td>
<td>user--&gt;post请求方式</td>
</tr>
<tr>
<td>删除操作</td>
<td>deleteUser?id=1</td>
<td>user/1--&gt;delete请求方式</td>
</tr>
<tr>
<td>更新操作</td>
<td>updateUser</td>
<td>user--&gt;put请求方式</td>
</tr>
</tbody>
</table>
<h4 id="_5-2-2-hiddenhttpmethodfilter" tabindex="-1"><a class="header-anchor" href="#_5-2-2-hiddenhttpmethodfilter" aria-hidden="true">#</a> 5.2.2 HiddenHttpMethodFilter</h4>
<ol>
<li>浏览器只支持发送<code v-pre>get</code>和<code v-pre>post</code>方式的请求，SpringMVC 提供了<code v-pre>HiddenHttpMethodFilter</code>帮助我们将 POST 请求转换为 <code v-pre>DELETE</code>或 <code v-pre>PUT</code>请求。</li>
<li><code v-pre>HiddenHttpMethodFilter</code>处理<code v-pre>put</code>和<code v-pre>delete</code>请求的条件：
<ul>
<li>当前请求的请求方式必须为<code v-pre>post</code>。</li>
<li>当前请求必须传输请求参数<code v-pre>_method</code>。</li>
<li>请求参数<code v-pre>_method</code>的值才是最终的请求方式。</li>
</ul>
</li>
<li><code v-pre>put</code>和<code v-pre>delete</code>请求的实现步骤：
<ul>
<li>在<code v-pre>web.xml</code>中注册<code v-pre>HiddenHttpMethodFilter</code>。
<ul>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1658361732389-819ac78a-7a21-4405-a07a-4d5acc8950a7.png#clientId=uf1197a9e-7d2f-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=205&amp;id=u64d9e692&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=205&amp;originWidth=597&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=14899&amp;status=done&amp;style=none&amp;taskId=ua200d9bf-277d-459a-9f3c-a5baf6f482b&amp;title=&amp;width=597" alt="image.png" loading="lazy"></li>
</ul>
</li>
<li>注意点：在<code v-pre>web.xml</code>中注册时，必须先注册<code v-pre>CharacterEncodingFilter</code>，再注册<code v-pre>HiddenHttpMethodFilter</code>，因为<code v-pre>CharacterEncodingFilter</code>内部有一个获取请求方式的操作，如果不提前设置好编码，会出现乱码情况：
<ul>
<li><code v-pre>String paramValue = request.getParameter(this.methodParam);</code></li>
</ul>
</li>
</ul>
</li>
</ol>
<h3 id="_5-3-模拟增删改查" tabindex="-1"><a class="header-anchor" href="#_5-3-模拟增删改查" aria-hidden="true">#</a> 5.3 模拟增删改查</h3>
<table>
<thead>
<tr>
<th><strong>功能</strong></th>
<th><strong>URL 地址</strong></th>
<th><strong>请求方式</strong></th>
</tr>
</thead>
<tbody>
<tr>
<td>访问首页</td>
<td>/</td>
<td>GET</td>
</tr>
<tr>
<td>查询全部数据</td>
<td>/employee</td>
<td>GET</td>
</tr>
<tr>
<td>删除</td>
<td>/employee/2</td>
<td>DELETE</td>
</tr>
<tr>
<td>跳转到添加数据页面</td>
<td>/toAdd</td>
<td>GET</td>
</tr>
<tr>
<td>执行保存</td>
<td>/employee</td>
<td>POST</td>
</tr>
<tr>
<td>跳转到更新数据页面</td>
<td>/employee/2</td>
<td>GET</td>
</tr>
<tr>
<td>执行更新</td>
<td>/employee</td>
<td>PUT</td>
</tr>
</tbody>
</table>
<h4 id="_5-3-1-查询功能" tabindex="-1"><a class="header-anchor" href="#_5-3-1-查询功能" aria-hidden="true">#</a> 5.3.1 查询功能</h4>
<div class="language-html ext-html line-numbers-mode"><pre v-pre class="language-html"><code><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>a</span> <span class="token attr-name"><span class="token namespace">th:</span>href</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>@{/employee}<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>访问员工信息<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>a</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div></div></div><div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token annotation punctuation">@RequestMapping</span><span class="token punctuation">(</span>value <span class="token operator">=</span> <span class="token string">"/employee"</span><span class="token punctuation">,</span> method <span class="token operator">=</span> <span class="token class-name">RequestMethod</span><span class="token punctuation">.</span>GET<span class="token punctuation">)</span>
<span class="token keyword">public</span> <span class="token class-name">String</span> <span class="token function">getEmployeeList</span><span class="token punctuation">(</span><span class="token class-name">Model</span> model<span class="token punctuation">)</span><span class="token punctuation">{</span>
    <span class="token class-name">Collection</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">Employee</span><span class="token punctuation">></span></span> employeeList <span class="token operator">=</span> employeeDao<span class="token punctuation">.</span><span class="token function">getAll</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
    model<span class="token punctuation">.</span><span class="token function">addAttribute</span><span class="token punctuation">(</span><span class="token string">"employeeList"</span><span class="token punctuation">,</span> employeeList<span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token keyword">return</span> <span class="token string">"employee_list"</span><span class="token punctuation">;</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><div class="language-html ext-html line-numbers-mode"><pre v-pre class="language-html"><code><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>table</span> <span class="token attr-name">border</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>1<span class="token punctuation">"</span></span> <span class="token attr-name">cellpadding</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>0<span class="token punctuation">"</span></span> <span class="token attr-name">cellspacing</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>0<span class="token punctuation">"</span></span> <span class="token special-attr"><span class="token attr-name">style</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span><span class="token value css language-css"><span class="token property">text-align</span><span class="token punctuation">:</span> center<span class="token punctuation">;</span></span><span class="token punctuation">"</span></span></span> <span class="token attr-name">id</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>dataTable<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>tr</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>th</span> <span class="token attr-name">colspan</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>5<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>Employee Info<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>th</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>tr</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>tr</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>th</span><span class="token punctuation">></span></span>id<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>th</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>th</span><span class="token punctuation">></span></span>lastName<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>th</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>th</span><span class="token punctuation">></span></span>email<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>th</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>th</span><span class="token punctuation">></span></span>gender<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>th</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>th</span><span class="token punctuation">></span></span>options(<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>a</span> <span class="token attr-name"><span class="token namespace">th:</span>href</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>@{/toAdd}<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>add<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>a</span><span class="token punctuation">></span></span>)<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>th</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>tr</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>tr</span> <span class="token attr-name"><span class="token namespace">th:</span>each</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>employee : ${employeeList}<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>td</span> <span class="token attr-name"><span class="token namespace">th:</span>text</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>${employee.id}<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>td</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>td</span> <span class="token attr-name"><span class="token namespace">th:</span>text</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>${employee.lastName}<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>td</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>td</span> <span class="token attr-name"><span class="token namespace">th:</span>text</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>${employee.email}<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>td</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>td</span> <span class="token attr-name"><span class="token namespace">th:</span>text</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>${employee.gender}<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>td</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>td</span><span class="token punctuation">></span></span>
      <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>a</span> <span class="token attr-name">class</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>deleteA<span class="token punctuation">"</span></span> <span class="token attr-name">@click</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>deleteEmployee<span class="token punctuation">"</span></span> <span class="token attr-name"><span class="token namespace">th:</span>href</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>@{<span class="token punctuation">'</span>/employee/<span class="token punctuation">'</span>+${employee.id}}<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>delete<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>a</span><span class="token punctuation">></span></span>
      <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>a</span> <span class="token attr-name"><span class="token namespace">th:</span>href</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>@{<span class="token punctuation">'</span>/employee/<span class="token punctuation">'</span>+${employee.id}}<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>update<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>a</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>td</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>tr</span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>table</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><h4 id="_5-3-2-删除功能" tabindex="-1"><a class="header-anchor" href="#_5-3-2-删除功能" aria-hidden="true">#</a> 5.3.2 删除功能</h4>
<div class="language-html ext-html line-numbers-mode"><pre v-pre class="language-html"><code><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>a</span> <span class="token attr-name">class</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>deleteA<span class="token punctuation">"</span></span> <span class="token attr-name">@click</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>deleteEmployee<span class="token punctuation">"</span></span> <span class="token attr-name"><span class="token namespace">th:</span>href</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>@{<span class="token punctuation">'</span>/employee/<span class="token punctuation">'</span>+${employee.id}}<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>delete<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>a</span><span class="token punctuation">></span></span>

<span class="token comment">&lt;!-- 作用：通过超链接控制表单的提交，将post请求转换为delete请求 --></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>form</span> <span class="token attr-name">id</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>delete_form<span class="token punctuation">"</span></span> <span class="token attr-name">method</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>post<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
    <span class="token comment">&lt;!-- HiddenHttpMethodFilter要求：必须传输_method请求参数，并且值为最终的请求方式 --></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>input</span> <span class="token attr-name">type</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>hidden<span class="token punctuation">"</span></span> <span class="token attr-name">name</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>_method<span class="token punctuation">"</span></span> <span class="token attr-name">value</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>delete<span class="token punctuation">"</span></span><span class="token punctuation">/></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>form</span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>script</span> <span class="token attr-name">type</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>text/javascript<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token script"><span class="token language-javascript">
    <span class="token keyword">var</span> vue <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">Vue</span><span class="token punctuation">(</span><span class="token punctuation">{</span>
        <span class="token literal-property property">el</span><span class="token operator">:</span><span class="token string">"#dataTable"</span><span class="token punctuation">,</span>
        <span class="token literal-property property">methods</span><span class="token operator">:</span><span class="token punctuation">{</span>
            <span class="token comment">//event表示当前事件</span>
            <span class="token function-variable function">deleteEmployee</span><span class="token operator">:</span><span class="token keyword">function</span> <span class="token punctuation">(</span><span class="token parameter">event</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
                <span class="token comment">//通过id获取表单标签</span>
                <span class="token keyword">var</span> delete_form <span class="token operator">=</span> document<span class="token punctuation">.</span><span class="token function">getElementById</span><span class="token punctuation">(</span><span class="token string">"delete_form"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
                <span class="token comment">//将触发事件的超链接的href属性为表单的action属性赋值</span>
                delete_form<span class="token punctuation">.</span>action <span class="token operator">=</span> event<span class="token punctuation">.</span>target<span class="token punctuation">.</span>href<span class="token punctuation">;</span>
                <span class="token comment">//提交表单</span>
                delete_form<span class="token punctuation">.</span><span class="token function">submit</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
                <span class="token comment">//阻止超链接的默认跳转行为</span>
                event<span class="token punctuation">.</span><span class="token function">preventDefault</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
            <span class="token punctuation">}</span>
        <span class="token punctuation">}</span>
    <span class="token punctuation">}</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
</span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>script</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ul>
<li>这里用到了<code v-pre>vue.js</code>，由于<code v-pre>vue.js</code>不经过中央控制器处理，所以需要开启静态资源（本地js、css、img）加载：
<ul>
<li><code v-pre>springMVC</code>的前端控制器不能处理静态资源</li>
<li><code v-pre>Servlet</code>的默认前端控制器<code v-pre>defaultServlet</code>可以处理静态资源，这个<code v-pre>defaultServlet</code>定义在tomcat的<code v-pre>web.xml</code>——全局配置</li>
<li>在本地配置——项目的<code v-pre>web.xml</code>中使用<code v-pre>&lt;mvc:default-servlet-handler/&gt;</code>进行开启</li>
<li>静态资源处理顺序：<code v-pre>springmvc</code>→<code v-pre>defaultservlet</code>→404</li>
</ul>
</li>
</ul>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token annotation punctuation">@RequestMapping</span><span class="token punctuation">(</span>value <span class="token operator">=</span> <span class="token string">"/employee/{id}"</span><span class="token punctuation">,</span> method <span class="token operator">=</span> <span class="token class-name">RequestMethod</span><span class="token punctuation">.</span>DELETE<span class="token punctuation">)</span>
<span class="token keyword">public</span> <span class="token class-name">String</span> <span class="token function">deleteEmployee</span><span class="token punctuation">(</span><span class="token annotation punctuation">@PathVariable</span><span class="token punctuation">(</span><span class="token string">"id"</span><span class="token punctuation">)</span> <span class="token class-name">Integer</span> id<span class="token punctuation">)</span><span class="token punctuation">{</span>
    employeeDao<span class="token punctuation">.</span><span class="token function">delete</span><span class="token punctuation">(</span>id<span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token keyword">return</span> <span class="token string">"redirect:/employee"</span><span class="token punctuation">;</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><h4 id="_5-3-3-插入功能" tabindex="-1"><a class="header-anchor" href="#_5-3-3-插入功能" aria-hidden="true">#</a> 5.3.3 插入功能</h4>
<div class="language-html ext-html line-numbers-mode"><pre v-pre class="language-html"><code><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>a</span> <span class="token attr-name"><span class="token namespace">th:</span>href</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>@{/toAdd}<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>add<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>a</span><span class="token punctuation">></span></span><span class="token comment">&lt;!-- 连接通过视图控制器进行转发--></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div></div></div><div class="language-xml ext-xml line-numbers-mode"><pre v-pre class="language-xml"><code><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span><span class="token namespace">mvc:</span>view-controller</span> <span class="token attr-name">path</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>/toAdd<span class="token punctuation">"</span></span> <span class="token attr-name">view-name</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>employee_add<span class="token punctuation">"</span></span><span class="token punctuation">/></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div></div></div><div class="language-html ext-html line-numbers-mode"><pre v-pre class="language-html"><code><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>form</span> <span class="token attr-name"><span class="token namespace">th:</span>action</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>@{/employee}<span class="token punctuation">"</span></span> <span class="token attr-name">method</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>post<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
    lastName:<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>input</span> <span class="token attr-name">type</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>text<span class="token punctuation">"</span></span> <span class="token attr-name">name</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>lastName<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>br</span><span class="token punctuation">></span></span>
    email:<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>input</span> <span class="token attr-name">type</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>text<span class="token punctuation">"</span></span> <span class="token attr-name">name</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>email<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>br</span><span class="token punctuation">></span></span>
    gender:<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>input</span> <span class="token attr-name">type</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>radio<span class="token punctuation">"</span></span> <span class="token attr-name">name</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>gender<span class="token punctuation">"</span></span> <span class="token attr-name">value</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>1<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>male
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>input</span> <span class="token attr-name">type</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>radio<span class="token punctuation">"</span></span> <span class="token attr-name">name</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>gender<span class="token punctuation">"</span></span> <span class="token attr-name">value</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>0<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>female<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>br</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>input</span> <span class="token attr-name">type</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>submit<span class="token punctuation">"</span></span> <span class="token attr-name">value</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>add<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>br</span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>form</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token annotation punctuation">@RequestMapping</span><span class="token punctuation">(</span>value <span class="token operator">=</span> <span class="token string">"/employee"</span><span class="token punctuation">,</span> method <span class="token operator">=</span> <span class="token class-name">RequestMethod</span><span class="token punctuation">.</span>POST<span class="token punctuation">)</span>
<span class="token keyword">public</span> <span class="token class-name">String</span> <span class="token function">addEmployee</span><span class="token punctuation">(</span><span class="token class-name">Employee</span> employee<span class="token punctuation">)</span><span class="token punctuation">{</span>
    employeeDao<span class="token punctuation">.</span><span class="token function">save</span><span class="token punctuation">(</span>employee<span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token keyword">return</span> <span class="token string">"redirect:/employee"</span><span class="token punctuation">;</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><h4 id="_5-3-4-修改功能" tabindex="-1"><a class="header-anchor" href="#_5-3-4-修改功能" aria-hidden="true">#</a> 5.3.4 修改功能</h4>
<div class="language-html ext-html line-numbers-mode"><pre v-pre class="language-html"><code><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>a</span> <span class="token attr-name"><span class="token namespace">th:</span>href</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>@{<span class="token punctuation">'</span>/employee/<span class="token punctuation">'</span> + ${employee.id}}<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>update<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>a</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div></div></div><div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token annotation punctuation">@RequestMapping</span><span class="token punctuation">(</span>value <span class="token operator">=</span> <span class="token string">"/employee/{id}"</span><span class="token punctuation">,</span> method <span class="token operator">=</span> <span class="token class-name">RequestMethod</span><span class="token punctuation">.</span>GET<span class="token punctuation">)</span>
<span class="token keyword">public</span> <span class="token class-name">String</span> <span class="token function">getEmployeeById</span><span class="token punctuation">(</span><span class="token annotation punctuation">@PathVariable</span><span class="token punctuation">(</span><span class="token string">"id"</span><span class="token punctuation">)</span> <span class="token class-name">Integer</span> id<span class="token punctuation">,</span> <span class="token class-name">Model</span> model<span class="token punctuation">)</span><span class="token punctuation">{</span>
    <span class="token class-name">Employee</span> employee <span class="token operator">=</span> employeeDao<span class="token punctuation">.</span><span class="token function">get</span><span class="token punctuation">(</span>id<span class="token punctuation">)</span><span class="token punctuation">;</span>
    model<span class="token punctuation">.</span><span class="token function">addAttribute</span><span class="token punctuation">(</span><span class="token string">"employee"</span><span class="token punctuation">,</span> employee<span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token keyword">return</span> <span class="token string">"employee_update"</span><span class="token punctuation">;</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><div class="language-html ext-html line-numbers-mode"><pre v-pre class="language-html"><code><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>form</span> <span class="token attr-name"><span class="token namespace">th:</span>action</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>@{/employee}<span class="token punctuation">"</span></span> <span class="token attr-name">method</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>post<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>input</span> <span class="token attr-name">type</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>hidden<span class="token punctuation">"</span></span> <span class="token attr-name">name</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>_method<span class="token punctuation">"</span></span> <span class="token attr-name">value</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>put<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>input</span> <span class="token attr-name">type</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>hidden<span class="token punctuation">"</span></span> <span class="token attr-name">name</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>id<span class="token punctuation">"</span></span> <span class="token attr-name"><span class="token namespace">th:</span>value</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>${employee.id}<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>label</span> <span class="token attr-name">for</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span><span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
        lastName：<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>input</span> <span class="token attr-name">type</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>text<span class="token punctuation">"</span></span> <span class="token attr-name">name</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>lastName<span class="token punctuation">"</span></span> <span class="token attr-name"><span class="token namespace">th:</span>value</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>${employee.lastName}<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>label</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>label</span> <span class="token attr-name">for</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span><span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
        email：<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>input</span> <span class="token attr-name">type</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>text<span class="token punctuation">"</span></span> <span class="token attr-name">name</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>email<span class="token punctuation">"</span></span> <span class="token attr-name"><span class="token namespace">th:</span>value</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>${employee.email}<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>label</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>label</span> <span class="token attr-name">for</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span><span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
        gender：<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>input</span> <span class="token attr-name">type</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>radio<span class="token punctuation">"</span></span> <span class="token attr-name">name</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>gender<span class="token punctuation">"</span></span> <span class="token attr-name">value</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>1<span class="token punctuation">"</span></span> <span class="token attr-name"><span class="token namespace">th:</span>field</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>${employee.gender}<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>male
        <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>input</span> <span class="token attr-name">type</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>radio<span class="token punctuation">"</span></span> <span class="token attr-name">name</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>gender<span class="token punctuation">"</span></span> <span class="token attr-name">value</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>0<span class="token punctuation">"</span></span> <span class="token attr-name"><span class="token namespace">th:</span>field</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>${employee.gender}<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>female
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>label</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>input</span> <span class="token attr-name">type</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>submit<span class="token punctuation">"</span></span> <span class="token attr-name">value</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>修改<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>form</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token annotation punctuation">@RequestMapping</span><span class="token punctuation">(</span>value <span class="token operator">=</span> <span class="token string">"/employee"</span><span class="token punctuation">,</span> method <span class="token operator">=</span> <span class="token class-name">RequestMethod</span><span class="token punctuation">.</span>PUT<span class="token punctuation">)</span>
<span class="token keyword">public</span> <span class="token class-name">String</span> <span class="token function">updateEmployee</span><span class="token punctuation">(</span><span class="token class-name">Employee</span> employee<span class="token punctuation">)</span><span class="token punctuation">{</span>
    employeeDao<span class="token punctuation">.</span><span class="token function">save</span><span class="token punctuation">(</span>employee<span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token keyword">return</span> <span class="token string">"redirect:/employee"</span><span class="token punctuation">;</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><h2 id="第6章-httpmessageconverter" tabindex="-1"><a class="header-anchor" href="#第6章-httpmessageconverter" aria-hidden="true">#</a> 第6章 HttpMessageConverter</h2>
<blockquote>
<ul>
<li><code v-pre>HttpMessageConverter</code>，报文信息转换器，将请求报文转换为Java对象，或将Java对象转换为响应报文<code v-pre>HttpMessageConverter</code>提供了两个注解和两个类型：
<ul>
<li><code v-pre>@RequestBody</code>，<code v-pre>@ResponseBody</code>，</li>
<li><code v-pre>RequestEntity</code>，<code v-pre>ResponseEntity</code></li>
</ul>
</li>
</ul>
</blockquote>
<h3 id="_6-1-requestbody" tabindex="-1"><a class="header-anchor" href="#_6-1-requestbody" aria-hidden="true">#</a> 6.1 <code v-pre>@RequestBody</code></h3>
<ul>
<li>标识控制器形参。</li>
<li><code v-pre>@RequestBody</code>可以获取请求体，需要在控制器方法设置一个形参，使用<code v-pre>@RequestBody</code>进行标识，当前请求的请求体就会为当前注解所标识的形参赋值。</li>
</ul>
<div class="language-html ext-html line-numbers-mode"><pre v-pre class="language-html"><code><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>form</span> <span class="token attr-name"><span class="token namespace">th:</span>action</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>@{/testRequestBody}<span class="token punctuation">"</span></span> <span class="token attr-name">method</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>post<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
    用户名：<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>input</span> <span class="token attr-name">type</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>text<span class="token punctuation">"</span></span> <span class="token attr-name">name</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>username<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>br</span><span class="token punctuation">></span></span>
    密码：<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>input</span> <span class="token attr-name">type</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>password<span class="token punctuation">"</span></span> <span class="token attr-name">name</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>password<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>br</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>input</span> <span class="token attr-name">type</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>submit<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>form</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token annotation punctuation">@RequestMapping</span><span class="token punctuation">(</span><span class="token string">"/testRequestBody"</span><span class="token punctuation">)</span>
<span class="token keyword">public</span> <span class="token class-name">String</span> <span class="token function">testRequestBody</span><span class="token punctuation">(</span><span class="token annotation punctuation">@RequestBody</span> <span class="token class-name">String</span> requestBody<span class="token punctuation">)</span><span class="token punctuation">{</span>
    <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span><span class="token string">"requestBody:"</span><span class="token operator">+</span>requestBody<span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token keyword">return</span> <span class="token string">"success"</span><span class="token punctuation">;</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><p><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1658987862055-c1645d39-46d9-43ca-a469-009771cdaf32.png#clientId=u41e8e728-fd0b-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=17&amp;id=u88b03804&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=17&amp;originWidth=340&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=3892&amp;status=done&amp;style=none&amp;taskId=ude6ac60d-48e4-4ec8-8697-8f107c80a79&amp;title=&amp;width=340" alt="image.png" loading="lazy"></p>
<h3 id="_6-2-requestentity" tabindex="-1"><a class="header-anchor" href="#_6-2-requestentity" aria-hidden="true">#</a> 6.2 <code v-pre>RequestEntity</code></h3>
<ul>
<li>标识控制器形参类型。</li>
<li><code v-pre>RequestEntity</code>封装请求报文的一种类型，需要在控制器方法的形参中设置该类型的形参，当前请求的请求报文就会赋值给该形参，可以通过<code v-pre>getHeaders()</code>获取请求头信息，通过<code v-pre>getBody()</code>获取请求体信息</li>
</ul>
<div class="language-html ext-html line-numbers-mode"><pre v-pre class="language-html"><code><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>form</span> <span class="token attr-name"><span class="token namespace">th:</span>action</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>@{/testRequestEntity}<span class="token punctuation">"</span></span> <span class="token attr-name">method</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>post<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>input</span> <span class="token attr-name">type</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>text<span class="token punctuation">"</span></span> <span class="token attr-name">name</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>username<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>input</span> <span class="token attr-name">type</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>text<span class="token punctuation">"</span></span> <span class="token attr-name">name</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>password<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>input</span> <span class="token attr-name">type</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>submit<span class="token punctuation">"</span></span> <span class="token attr-name">value</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>测试RequestEntity<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>form</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token annotation punctuation">@RequestMapping</span><span class="token punctuation">(</span><span class="token string">"/testRequestEntity"</span><span class="token punctuation">)</span>
<span class="token keyword">public</span> <span class="token class-name">String</span> <span class="token function">testRequestEntity</span><span class="token punctuation">(</span><span class="token class-name">RequestEntity</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">String</span><span class="token punctuation">></span></span> requestEntity<span class="token punctuation">)</span><span class="token punctuation">{</span>
    <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span><span class="token string">"requestHeader:"</span><span class="token operator">+</span>requestEntity<span class="token punctuation">.</span><span class="token function">getHeaders</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span><span class="token string">"requestBody:"</span><span class="token operator">+</span>requestEntity<span class="token punctuation">.</span><span class="token function">getBody</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token keyword">return</span> <span class="token string">"success"</span><span class="token punctuation">;</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><p><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1658987910633-00177492-8863-4bb7-beff-516d522dbf68.png#clientId=u41e8e728-fd0b-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=188&amp;id=ub0ccd99d&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=188&amp;originWidth=1215&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=54549&amp;status=done&amp;style=none&amp;taskId=u5052366b-cc71-49d0-95ac-bff30826586&amp;title=&amp;width=1215" alt="image.png" loading="lazy"></p>
<h3 id="_6-3-responsebody" tabindex="-1"><a class="header-anchor" href="#_6-3-responsebody" aria-hidden="true">#</a> 6.3 <code v-pre>@ResponseBody</code></h3>
<ul>
<li>标识控制器方法。</li>
</ul>
<h4 id="_6-3-1-使用原生servletapi的httpservletresponse响应数据" tabindex="-1"><a class="header-anchor" href="#_6-3-1-使用原生servletapi的httpservletresponse响应数据" aria-hidden="true">#</a> 6.3.1 使用原生<code v-pre>servletAPI</code>的<code v-pre>HttpServletResponse</code>响应数据</h4>
<div class="language-html ext-html line-numbers-mode"><pre v-pre class="language-html"><code><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>a</span> <span class="token attr-name"><span class="token namespace">th:</span>href</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>@{/testResponse}<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>通过servletAPI的response对象响应浏览器数据<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>a</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div></div></div><div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token annotation punctuation">@RequestMapping</span><span class="token punctuation">(</span><span class="token string">"/testResponse"</span><span class="token punctuation">)</span>
<span class="token keyword">public</span> <span class="token keyword">void</span> <span class="token function">testResponse</span><span class="token punctuation">(</span><span class="token class-name">HttpServletResponse</span> response<span class="token punctuation">)</span> <span class="token keyword">throws</span> <span class="token class-name">IOException</span> <span class="token punctuation">{</span>
    response<span class="token punctuation">.</span><span class="token function">getWriter</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">.</span><span class="token function">print</span><span class="token punctuation">(</span><span class="token string">"hello,response"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><h4 id="_6-3-2-使用-responsebody返回文本信息" tabindex="-1"><a class="header-anchor" href="#_6-3-2-使用-responsebody返回文本信息" aria-hidden="true">#</a> 6.3.2 使用<code v-pre>@ResponseBody</code>返回文本信息</h4>
<div class="language-html ext-html line-numbers-mode"><pre v-pre class="language-html"><code><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>a</span> <span class="token attr-name"><span class="token namespace">th:</span>href</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>@{/testResponse}<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>通过servletAPI的response对象响应浏览器数据<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>a</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div></div></div><div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token annotation punctuation">@RequestMapping</span><span class="token punctuation">(</span>value <span class="token operator">=</span> <span class="token string">"/testResponseBody"</span><span class="token punctuation">,</span> produces <span class="token operator">=</span> <span class="token string">"text/html;charset=UTF-8"</span><span class="token punctuation">)</span>
<span class="token annotation punctuation">@ResponseBody</span>
<span class="token keyword">public</span> <span class="token class-name">String</span> <span class="token function">testResponseBody</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">{</span>
    <span class="token keyword">return</span> <span class="token string">"成功"</span><span class="token punctuation">;</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ul>
<li>这里返回值不再是视图名称，而是响应体。</li>
</ul>
<h4 id="_6-3-3-使用-responsebody返回实体对象-springmvc处理json" tabindex="-1"><a class="header-anchor" href="#_6-3-3-使用-responsebody返回实体对象-springmvc处理json" aria-hidden="true">#</a> 6.3.3 使用<code v-pre>@ResponseBody</code>返回实体对象（springmvc处理json）</h4>
<blockquote>
<p>浏览器无法直接解析java语言的实体对象，可以通过转换为json格式的字符串进行输出。</p>
</blockquote>
<div class="language-xml ext-xml line-numbers-mode"><pre v-pre class="language-xml"><code><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>dependency</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>groupId</span><span class="token punctuation">></span></span>com.fasterxml.jackson.core<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>groupId</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>artifactId</span><span class="token punctuation">></span></span>jackson-databind<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>artifactId</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>version</span><span class="token punctuation">></span></span>2.12.1<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>version</span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>dependency</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><div class="language-html ext-html line-numbers-mode"><pre v-pre class="language-html"><code><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>a</span> <span class="token attr-name"><span class="token namespace">th:</span>href</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>@{/testResponseUser}<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>通过@ResponseBody响应浏览器User对象<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>a</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div></div></div><div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token annotation punctuation">@RequestMapping</span><span class="token punctuation">(</span>value <span class="token operator">=</span> <span class="token string">"/testResponseUser"</span><span class="token punctuation">,</span> produces <span class="token operator">=</span> <span class="token string">"text/html;charset=UTF-8"</span><span class="token punctuation">)</span>
<span class="token annotation punctuation">@ResponseBody</span>
<span class="token keyword">public</span> <span class="token class-name">User</span> <span class="token function">testResponseUser</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">{</span>
    <span class="token keyword">return</span> <span class="token keyword">new</span> <span class="token class-name">User</span><span class="token punctuation">(</span><span class="token number">1001</span><span class="token punctuation">,</span> <span class="token string">"admin"</span><span class="token punctuation">,</span> <span class="token string">"123456"</span><span class="token punctuation">,</span> <span class="token number">23</span><span class="token punctuation">,</span> <span class="token string">"男"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ul>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1658991069799-5118e963-5652-4433-98da-0a8dddb3ae5d.png#clientId=u41e8e728-fd0b-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=31&amp;id=ud4ffea6f&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=31&amp;originWidth=513&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=1057&amp;status=done&amp;style=none&amp;taskId=u153987fd-1131-4c58-9b73-dc45ff1273d&amp;title=&amp;width=513" alt="image.png" loading="lazy"></li>
<li><code v-pre>springmvc</code>处理<code v-pre>json</code>的必要条件：
<ul>
<li><code v-pre>pom.xml</code>添加了依赖</li>
<li><code v-pre>srpingMVC.xml</code>开启了注解驱动
<ul>
<li><code v-pre>&lt;mvc:annotation-driven /&gt;</code></li>
</ul>
</li>
<li>处理器方法使用<code v-pre>@ResponseBody</code>注解</li>
<li>处理器方法返回值类型为实体类，返回值为实体类对象</li>
</ul>
</li>
</ul>
<h4 id="_6-3-4-使用-responsebody与springmvc处理ajax" tabindex="-1"><a class="header-anchor" href="#_6-3-4-使用-responsebody与springmvc处理ajax" aria-hidden="true">#</a> 6.3.4 使用<code v-pre>@ResponseBody</code>与springmvc处理ajax</h4>
<div class="language-html ext-html line-numbers-mode"><pre v-pre class="language-html"><code><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>div</span> <span class="token attr-name">id</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>app<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>a</span> <span class="token attr-name">@click</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>testAxios<span class="token punctuation">"</span></span> <span class="token attr-name"><span class="token namespace">th:</span>href</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>@{/testAxios}<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>SpringMVC处理ajax<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>a</span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>div</span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>script</span> <span class="token attr-name">type</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>text/javascript<span class="token punctuation">"</span></span> <span class="token attr-name"><span class="token namespace">th:</span>src</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>@{/static/js/vue.js}<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token script"></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>script</span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>script</span> <span class="token attr-name">type</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>text/javascript<span class="token punctuation">"</span></span> <span class="token attr-name"><span class="token namespace">th:</span>src</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>@{/static/js/axios.min.js}<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token script"></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>script</span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>script</span> <span class="token attr-name">type</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>text/javascript<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token script"><span class="token language-javascript">
    <span class="token keyword">new</span> <span class="token class-name">Vue</span><span class="token punctuation">(</span><span class="token punctuation">{</span>
        <span class="token literal-property property">el</span><span class="token operator">:</span><span class="token string">"#app"</span><span class="token punctuation">,</span>
        <span class="token literal-property property">methods</span><span class="token operator">:</span><span class="token punctuation">{</span>
            <span class="token function-variable function">testAxios</span><span class="token operator">:</span><span class="token keyword">function</span> <span class="token punctuation">(</span><span class="token parameter">event</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
                <span class="token function">axios</span><span class="token punctuation">(</span><span class="token punctuation">{</span>
                    <span class="token literal-property property">method</span><span class="token operator">:</span><span class="token string">"post"</span><span class="token punctuation">,</span>
                    <span class="token literal-property property">url</span><span class="token operator">:</span>event<span class="token punctuation">.</span>target<span class="token punctuation">.</span>href<span class="token punctuation">,</span>
                    <span class="token literal-property property">params</span><span class="token operator">:</span><span class="token punctuation">{</span>
                        <span class="token literal-property property">username</span><span class="token operator">:</span><span class="token string">"admin"</span><span class="token punctuation">,</span>
                        <span class="token literal-property property">password</span><span class="token operator">:</span><span class="token string">"123456"</span>
                    <span class="token punctuation">}</span>
                <span class="token punctuation">}</span><span class="token punctuation">)</span><span class="token punctuation">.</span><span class="token function">then</span><span class="token punctuation">(</span><span class="token keyword">function</span> <span class="token punctuation">(</span><span class="token parameter">response</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
                    <span class="token function">alert</span><span class="token punctuation">(</span>response<span class="token punctuation">.</span>data<span class="token punctuation">)</span><span class="token punctuation">;</span>
                <span class="token punctuation">}</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
                event<span class="token punctuation">.</span><span class="token function">preventDefault</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
            <span class="token punctuation">}</span>
        <span class="token punctuation">}</span>
    <span class="token punctuation">}</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
</span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>script</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token annotation punctuation">@RequestMapping</span><span class="token punctuation">(</span><span class="token string">"/testAxios"</span><span class="token punctuation">)</span>
<span class="token annotation punctuation">@ResponseBody</span>
<span class="token keyword">public</span> <span class="token class-name">String</span> <span class="token function">testAxios</span><span class="token punctuation">(</span><span class="token class-name">String</span> username<span class="token punctuation">,</span> <span class="token class-name">String</span> password<span class="token punctuation">)</span><span class="token punctuation">{</span>
    <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span>username<span class="token operator">+</span><span class="token string">","</span><span class="token operator">+</span>password<span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token keyword">return</span> <span class="token string">"hello,axios"</span><span class="token punctuation">;</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><p><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1658991339314-1d1312f9-a67c-4bb7-9533-7b2290ab1e4c.png#clientId=u41e8e728-fd0b-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=125&amp;id=ud18aad79&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=125&amp;originWidth=449&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=3253&amp;status=done&amp;style=stroke&amp;taskId=ub5811ce9-48c1-42ba-9d91-e30e048ddc2&amp;title=&amp;width=449" alt="image.png" loading="lazy"></p>
<h3 id="_6-4-responseentity" tabindex="-1"><a class="header-anchor" href="#_6-4-responseentity" aria-hidden="true">#</a> 6.4 <code v-pre>ResponseEntity</code></h3>
<h4 id="_6-4-1-作用" tabindex="-1"><a class="header-anchor" href="#_6-4-1-作用" aria-hidden="true">#</a> 6.4.1 作用</h4>
<ul>
<li>标识控制器方法的返回值类型。</li>
<li><code v-pre>ResponseEntity</code>用于控制器方法的返回值类型，该控制器方法的返回值就是响应到浏览器的响应报文</li>
</ul>
<h4 id="_6-4-2-应用-文件下载" tabindex="-1"><a class="header-anchor" href="#_6-4-2-应用-文件下载" aria-hidden="true">#</a> 6.4.2 应用：文件下载</h4>
<div class="language-html ext-html line-numbers-mode"><pre v-pre class="language-html"><code><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>a</span> <span class="token attr-name"><span class="token namespace">th:</span>href</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>@{testDown}<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>下载1.jpg<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>a</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div></div></div><div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token keyword">package</span> <span class="token namespace">iceriver<span class="token punctuation">.</span>springmvc<span class="token punctuation">.</span>controller</span><span class="token punctuation">;</span>

<span class="token keyword">import</span> <span class="token import"><span class="token namespace">org<span class="token punctuation">.</span>springframework<span class="token punctuation">.</span>http<span class="token punctuation">.</span></span><span class="token class-name">HttpHeaders</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">org<span class="token punctuation">.</span>springframework<span class="token punctuation">.</span>http<span class="token punctuation">.</span></span><span class="token class-name">HttpStatus</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">org<span class="token punctuation">.</span>springframework<span class="token punctuation">.</span>http<span class="token punctuation">.</span></span><span class="token class-name">ResponseEntity</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">org<span class="token punctuation">.</span>springframework<span class="token punctuation">.</span>stereotype<span class="token punctuation">.</span></span><span class="token class-name">Controller</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">org<span class="token punctuation">.</span>springframework<span class="token punctuation">.</span>util<span class="token punctuation">.</span></span><span class="token class-name">MultiValueMap</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">org<span class="token punctuation">.</span>springframework<span class="token punctuation">.</span>web<span class="token punctuation">.</span>bind<span class="token punctuation">.</span>annotation<span class="token punctuation">.</span></span><span class="token class-name">RequestMapping</span></span><span class="token punctuation">;</span>

<span class="token keyword">import</span> <span class="token import"><span class="token namespace">javax<span class="token punctuation">.</span>servlet<span class="token punctuation">.</span></span><span class="token class-name">ServletContext</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">javax<span class="token punctuation">.</span>servlet<span class="token punctuation">.</span>http<span class="token punctuation">.</span></span><span class="token class-name">HttpSession</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">java<span class="token punctuation">.</span>io<span class="token punctuation">.</span></span><span class="token class-name">FileInputStream</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">java<span class="token punctuation">.</span>io<span class="token punctuation">.</span></span><span class="token class-name">IOException</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">java<span class="token punctuation">.</span>io<span class="token punctuation">.</span></span><span class="token class-name">InputStream</span></span><span class="token punctuation">;</span>

<span class="token doc-comment comment">/**
* <span class="token keyword">@author</span>: INFINITY https://developer.aliyun.com/profile/sagwrxp2ua66w
* <span class="token keyword">@date</span>: 2022/7/28 15:05
*/</span>
<span class="token annotation punctuation">@Controller</span>
<span class="token keyword">public</span> <span class="token keyword">class</span> <span class="token class-name">FileUpAndFileDownload</span> <span class="token punctuation">{</span>
    <span class="token annotation punctuation">@RequestMapping</span><span class="token punctuation">(</span><span class="token string">"/testDown"</span><span class="token punctuation">)</span>
    <span class="token keyword">public</span> <span class="token class-name">ResponseEntity</span><span class="token operator">&lt;</span><span class="token keyword">byte</span><span class="token punctuation">[</span><span class="token punctuation">]</span><span class="token operator">></span> <span class="token function">testResponseEntity</span><span class="token punctuation">(</span><span class="token class-name">HttpSession</span> session<span class="token punctuation">)</span> <span class="token keyword">throws</span> <span class="token class-name">IOException</span> <span class="token punctuation">{</span>
        <span class="token comment">//获取ServletContext对象</span>
        <span class="token class-name">ServletContext</span> servletContext <span class="token operator">=</span> session<span class="token punctuation">.</span><span class="token function">getServletContext</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token comment">//获取服务器中文件的真实路径</span>
        <span class="token class-name">String</span> realPath <span class="token operator">=</span> servletContext<span class="token punctuation">.</span><span class="token function">getRealPath</span><span class="token punctuation">(</span><span class="token string">"/static/img/1.jpg"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token comment">//创建输入流</span>
        <span class="token class-name">InputStream</span> is <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">FileInputStream</span><span class="token punctuation">(</span>realPath<span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token comment">//创建字节数组</span>
        <span class="token keyword">byte</span><span class="token punctuation">[</span><span class="token punctuation">]</span> bytes <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token keyword">byte</span><span class="token punctuation">[</span>is<span class="token punctuation">.</span><span class="token function">available</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">]</span><span class="token punctuation">;</span>
        <span class="token comment">//将流读到字节数组中</span>
        is<span class="token punctuation">.</span><span class="token function">read</span><span class="token punctuation">(</span>bytes<span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token comment">//创建HttpHeaders对象设置响应头信息</span>
        <span class="token class-name">MultiValueMap</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">String</span><span class="token punctuation">,</span> <span class="token class-name">String</span><span class="token punctuation">></span></span> headers <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">HttpHeaders</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token comment">//设置要下载方式以及下载文件的名字</span>
        headers<span class="token punctuation">.</span><span class="token function">add</span><span class="token punctuation">(</span><span class="token string">"Content-Disposition"</span><span class="token punctuation">,</span> <span class="token string">"attachment;filename=1.jpg"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token comment">//设置响应状态码</span>
        <span class="token class-name">HttpStatus</span> statusCode <span class="token operator">=</span> <span class="token class-name">HttpStatus</span><span class="token punctuation">.</span>OK<span class="token punctuation">;</span>
        <span class="token comment">//创建ResponseEntity对象</span>
        <span class="token class-name">ResponseEntity</span><span class="token operator">&lt;</span><span class="token keyword">byte</span><span class="token punctuation">[</span><span class="token punctuation">]</span><span class="token operator">></span> responseEntity <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">ResponseEntity</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token punctuation">></span></span><span class="token punctuation">(</span>bytes<span class="token punctuation">,</span> headers<span class="token punctuation">,</span> statusCode<span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token comment">//关闭输入流</span>
        is<span class="token punctuation">.</span><span class="token function">close</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token keyword">return</span> responseEntity<span class="token punctuation">;</span>
    <span class="token punctuation">}</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><h4 id="_6-4-3-【补充】文件上传" tabindex="-1"><a class="header-anchor" href="#_6-4-3-【补充】文件上传" aria-hidden="true">#</a> 6.4.3 【补充】文件上传</h4>
<ol>
<li><code v-pre>pom.xml</code>文件中，添加依赖：</li>
</ol>
<div class="language-xml ext-xml line-numbers-mode"><pre v-pre class="language-xml"><code><span class="token comment">&lt;!-- https://mvnrepository.com/artifact/commons-fileupload/commons-fileupload --></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>dependency</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>groupId</span><span class="token punctuation">></span></span>commons-fileupload<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>groupId</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>artifactId</span><span class="token punctuation">></span></span>commons-fileupload<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>artifactId</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>version</span><span class="token punctuation">></span></span>1.3.1<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>version</span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>dependency</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ol start="2">
<li><code v-pre>springMVC.xml</code>文件中添加配置——文件上传解析器：</li>
</ol>
<div class="language-xml ext-xml line-numbers-mode"><pre v-pre class="language-xml"><code><span class="token comment">&lt;!--必须通过文件解析器的解析才能将文件转换为MultipartFile对象--></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>bean</span> <span class="token attr-name">id</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>multipartResolver<span class="token punctuation">"</span></span> <span class="token attr-name">class</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>org.springframework.web.multipart.commons.CommonsMultipartResolver<span class="token punctuation">"</span></span><span class="token punctuation">/></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div></div></div><ol start="3">
<li>实现上传：</li>
</ol>
<div class="language-html ext-html line-numbers-mode"><pre v-pre class="language-html"><code><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>form</span> <span class="token attr-name"><span class="token namespace">th:</span>action</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>@{/testUp}<span class="token punctuation">"</span></span> <span class="token attr-name">method</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>post<span class="token punctuation">"</span></span> <span class="token attr-name">enctype</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>multipart/form-data<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
    头像：<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>input</span> <span class="token attr-name">type</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>file<span class="token punctuation">"</span></span> <span class="token attr-name">name</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>photo<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>input</span> <span class="token attr-name">type</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>submit<span class="token punctuation">"</span></span> <span class="token attr-name">value</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>上传<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>form</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token annotation punctuation">@RequestMapping</span><span class="token punctuation">(</span><span class="token string">"/testUp"</span><span class="token punctuation">)</span>
<span class="token keyword">public</span> <span class="token class-name">String</span> <span class="token function">testUp</span><span class="token punctuation">(</span><span class="token class-name">MultipartFile</span> photo<span class="token punctuation">,</span> <span class="token class-name">HttpSession</span> session<span class="token punctuation">)</span> <span class="token keyword">throws</span> <span class="token class-name">IOException</span> <span class="token punctuation">{</span>
    <span class="token comment">//获取上传的文件的文件名</span>
    <span class="token class-name">String</span> fileName <span class="token operator">=</span> photo<span class="token punctuation">.</span><span class="token function">getOriginalFilename</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token comment">//通过ServletContext获取服务器中photo目录的路径</span>
    <span class="token class-name">ServletContext</span> servletContext <span class="token operator">=</span> session<span class="token punctuation">.</span><span class="token function">getServletContext</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token class-name">String</span> photoPath <span class="token operator">=</span> servletContext<span class="token punctuation">.</span><span class="token function">getRealPath</span><span class="token punctuation">(</span><span class="token string">"photo"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token class-name">File</span> file <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">File</span><span class="token punctuation">(</span>photoPath<span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token comment">//判断photoPath所对应路径是否存在</span>
    <span class="token keyword">if</span><span class="token punctuation">(</span><span class="token operator">!</span>file<span class="token punctuation">.</span><span class="token function">exists</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">{</span>
        <span class="token comment">//若不存在，则创建目录</span>
        file<span class="token punctuation">.</span><span class="token function">mkdir</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token punctuation">}</span>
    <span class="token class-name">String</span> finalPath <span class="token operator">=</span> photoPath <span class="token operator">+</span> <span class="token class-name">File</span><span class="token punctuation">.</span>separator <span class="token operator">+</span> fileName<span class="token punctuation">;</span>
    <span class="token comment">//上传文件</span>
    photo<span class="token punctuation">.</span><span class="token function">transferTo</span><span class="token punctuation">(</span><span class="token keyword">new</span> <span class="token class-name">File</span><span class="token punctuation">(</span>finalPath<span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token keyword">return</span> <span class="token string">"success"</span><span class="token punctuation">;</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ol start="4">
<li>解决同名文件上传后“文件内容”发生覆盖的情况：
<ul>
<li>使用<code v-pre>UUID</code></li>
</ul>
</li>
</ol>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token annotation punctuation">@RequestMapping</span><span class="token punctuation">(</span><span class="token string">"/testUp"</span><span class="token punctuation">)</span>
<span class="token keyword">public</span> <span class="token class-name">String</span> <span class="token function">testUp</span><span class="token punctuation">(</span><span class="token class-name">MultipartFile</span> photo<span class="token punctuation">,</span> <span class="token class-name">HttpSession</span> session<span class="token punctuation">)</span> <span class="token keyword">throws</span> <span class="token class-name">IOException</span> <span class="token punctuation">{</span>
    <span class="token comment">//获取上传的文件的文件名</span>
    <span class="token class-name">String</span> fileName <span class="token operator">=</span> photo<span class="token punctuation">.</span><span class="token function">getOriginalFilename</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token comment">//获取上传的文件的后缀名</span>
    <span class="token class-name">String</span> suffixName <span class="token operator">=</span> fileName<span class="token punctuation">.</span><span class="token function">substring</span><span class="token punctuation">(</span>fileName<span class="token punctuation">.</span><span class="token function">lastIndexOf</span><span class="token punctuation">(</span><span class="token string">"."</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token comment">//将UUID作为文件名</span>
    <span class="token class-name">String</span> uuid <span class="token operator">=</span> UUID<span class="token punctuation">.</span><span class="token function">randomUUID</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">.</span><span class="token function">toString</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">.</span><span class="token function">replaceAll</span><span class="token punctuation">(</span><span class="token string">"-"</span><span class="token punctuation">,</span><span class="token string">""</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token comment">//将uuid和后缀名拼接后的结果作为最终的文件名</span>
    fileName <span class="token operator">=</span> uuid <span class="token operator">+</span> suffixName<span class="token punctuation">;</span>
    <span class="token comment">//通过ServletContext获取服务器中photo目录的路径</span>
    <span class="token class-name">ServletContext</span> servletContext <span class="token operator">=</span> session<span class="token punctuation">.</span><span class="token function">getServletContext</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token class-name">String</span> photoPath <span class="token operator">=</span> servletContext<span class="token punctuation">.</span><span class="token function">getRealPath</span><span class="token punctuation">(</span><span class="token string">"photo"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token class-name">File</span> file <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">File</span><span class="token punctuation">(</span>photoPath<span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token comment">//判断photoPath所对应路径是否存在</span>
    <span class="token keyword">if</span><span class="token punctuation">(</span><span class="token operator">!</span>file<span class="token punctuation">.</span><span class="token function">exists</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">{</span>
        <span class="token comment">//若不存在，则创建目录</span>
        file<span class="token punctuation">.</span><span class="token function">mkdir</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token punctuation">}</span>
    <span class="token class-name">String</span> finalPath <span class="token operator">=</span> photoPath <span class="token operator">+</span> <span class="token class-name">File</span><span class="token punctuation">.</span>separator <span class="token operator">+</span> fileName<span class="token punctuation">;</span>
    <span class="token comment">//上传文件</span>
    photo<span class="token punctuation">.</span><span class="token function">transferTo</span><span class="token punctuation">(</span><span class="token keyword">new</span> <span class="token class-name">File</span><span class="token punctuation">(</span>finalPath<span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token keyword">return</span> <span class="token string">"success"</span><span class="token punctuation">;</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><h3 id="_6-5-restcontroller注解" tabindex="-1"><a class="header-anchor" href="#_6-5-restcontroller注解" aria-hidden="true">#</a> 6.5 <code v-pre>@RestController</code>注解</h3>
<ul>
<li><code v-pre>@RestController</code>注解是<code v-pre>springMVC</code>提供的一个复合注解，标识在控制器的<strong>类</strong>上，就相当于为类添加了<code v-pre>@Controller</code>注解，并且为其中的每个方法添加了<code v-pre>@ResponseBody</code>注解。</li>
</ul>
<h2 id="第7章-拦截器-interceptor" tabindex="-1"><a class="header-anchor" href="#第7章-拦截器-interceptor" aria-hidden="true">#</a> 第7章 拦截器（Interceptor）</h2>
<h3 id="_7-1-拦截器的介绍" tabindex="-1"><a class="header-anchor" href="#_7-1-拦截器的介绍" aria-hidden="true">#</a> 7.1 拦截器的介绍</h3>
<ol>
<li>过滤器作用于请求发送到dispatcherservlet之前</li>
<li>拦截器作用于请求由dispatcherservlet发送到其他controllersevlet</li>
<li>拦截器共有3个抽象方法【默认方法】：
<ul>
<li><code v-pre>preHandle()</code>：控制器方法执行之前执行，其<code v-pre>boolean</code>类型的返回值表示是否拦截或放行，返回<code v-pre>true</code>为放行，即调用控制器方法；返回<code v-pre>false</code>表示拦截，即不调用控制器方法</li>
<li><code v-pre>postHandle()</code>：控制器方法执行之后执行</li>
<li><code v-pre>afterComplation()</code>：处理完视图和模型数据，渲染视图完毕之后执行</li>
</ul>
</li>
</ol>
<h3 id="_7-2-创建及配置拦截器" tabindex="-1"><a class="header-anchor" href="#_7-2-创建及配置拦截器" aria-hidden="true">#</a> 7.2 创建及配置拦截器</h3>
<ol>
<li>在<code v-pre>springMVC</code>中配置拦截器：
<ul>
<li>拦截所有请求：
<ul>
<li>方式一：</li>
</ul>
</li>
</ul>
</li>
</ol>
<div class="language-xml ext-xml line-numbers-mode"><pre v-pre class="language-xml"><code><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span><span class="token namespace">mvc:</span>interceptor</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>bean</span> <span class="token attr-name">class</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>com.atguigu.interceptor.FirstInterceptor<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>bean</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>ref</span> <span class="token attr-name">bean</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>firstInterceptor<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>ref</span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span><span class="token namespace">mvc:</span>interceptor</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ul>
<li>方式二（外部bean方式）：</li>
</ul>
<div class="language-xml ext-xml line-numbers-mode"><pre v-pre class="language-xml"><code><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>bean</span> <span class="token attr-name">class</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>com.atguigu.interceptor.FirstInterceptor<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>bean</span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span><span class="token namespace">mvc:</span>interceptor</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>ref</span> <span class="token attr-name">bean</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>firstInterceptor<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>ref</span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span><span class="token namespace">mvc:</span>interceptor</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ul>
<li>方式三（注解方式）：该方式需要对拦截器类<code v-pre>FirstInterceptor.java</code>使用<code v-pre>@Component</code>注解，将拦截器交给spring作为bean管理</li>
</ul>
<div class="language-xml ext-xml line-numbers-mode"><pre v-pre class="language-xml"><code><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span><span class="token namespace">mvc:</span>interceptor</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>ref</span> <span class="token attr-name">bean</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>firstInterceptor<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>ref</span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span><span class="token namespace">mvc:</span>interceptor</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ul>
<li>拦截/放行指定请求：</li>
</ul>
<div class="language-xml ext-xml line-numbers-mode"><pre v-pre class="language-xml"><code><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span><span class="token namespace">mvc:</span>interceptor</span><span class="token punctuation">></span></span>
    <span class="token comment">&lt;!--处理的所有的请求进行拦截 --></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span><span class="token namespace">mvc:</span>mapping</span> <span class="token attr-name">path</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>/**<span class="token punctuation">"</span></span><span class="token punctuation">/></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span><span class="token namespace">mvc:</span>exclude-mapping</span> <span class="token attr-name">path</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>/testRequestEntity<span class="token punctuation">"</span></span><span class="token punctuation">/></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>ref</span> <span class="token attr-name">bean</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>firstInterceptor<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>ref</span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span><span class="token namespace">mvc:</span>interceptor</span><span class="token punctuation">></span></span>
<span class="token comment">&lt;!-- 
	1. ref或bean标签设置拦截器，ref为外部bean方式
  1. mvc:mapping设置需要拦截的请求（请求经过拦截器，拦截器中的方法会被执行），路径为ant风格
  2. mvc:exclude-mapping设置需要放行的请求（请求不会经过拦截器，拦截器中的方法不会被执行）
--></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ol start="2">
<li>编写<code v-pre>Interceptor</code>拦截器类，继承于<code v-pre>HandlerInterceptor</code>，使用<code v-pre>ctr+o</code>进行preHandle()方法重写。
<ul>
<li>将拦截器交给spring管理：
<ul>
<li>方式一：使用<code v-pre>@Component</code>注解，将拦截器交给spring作为spring管理</li>
<li>方式二：在springMVC.xml中使用<code v-pre>&lt;bean/&gt;</code>标签把拦截器交给spring管理</li>
</ul>
</li>
<li>缺少设置白名单、设置管理配置类的内容，还可以再丰富</li>
</ul>
</li>
</ol>
<h3 id="_7-3-多个拦截器执行顺序" tabindex="-1"><a class="header-anchor" href="#_7-3-多个拦截器执行顺序" aria-hidden="true">#</a> 7.3 多个拦截器执行顺序</h3>
<ol>
<li>若每个拦截器的<code v-pre>preHandle()</code>都返回<code v-pre>true</code>
<ul>
<li><code v-pre>preHandle()</code>会按照配置的顺序执行，而<code v-pre>postHandle()</code>和<code v-pre>afterComplation()</code>会按照配置的反序执行</li>
</ul>
</li>
<li>若某个拦截器的<code v-pre>preHandle()</code>返回了<code v-pre>false</code>
<ul>
<li><code v-pre>preHandle()</code>返回<code v-pre>false</code>和它之前的拦截器的<code v-pre>preHandle()</code>都会执行。</li>
<li><code v-pre>postHandle()</code>都不执行。</li>
<li>返回<code v-pre>false</code>的拦截器之前的拦截器的<code v-pre>afterComplation()</code>会执行</li>
</ul>
</li>
</ol>
<p><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1659323858263-0bf7d907-88ee-431f-8609-d0b25ea62a38.png#clientId=ua260f30d-b19d-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=299&amp;id=u8b8032f3&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=299&amp;originWidth=963&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=51560&amp;status=done&amp;style=stroke&amp;taskId=u5e6751a7-55f6-4b32-b9a2-fd3ed3da8d5&amp;title=&amp;width=963" alt="image.png" loading="lazy"></p>
<h2 id="第8章-异常处理器" tabindex="-1"><a class="header-anchor" href="#第8章-异常处理器" aria-hidden="true">#</a> 第8章 异常处理器</h2>
<h3 id="_8-1-基于配置的异常处理" tabindex="-1"><a class="header-anchor" href="#_8-1-基于配置的异常处理" aria-hidden="true">#</a> 8.1 基于配置的异常处理</h3>
<ol>
<li><code v-pre>SpringMVC</code>提供了一个处理控制器方法执行过程中所出现的异常的接口：<code v-pre>HandlerExceptionResolver</code></li>
<li><code v-pre>HandlerExceptionResolver</code>接口的实现类有：<code v-pre>DefaultHandlerExceptionResolver</code>和<code v-pre>SimpleMappingExceptionResolver</code></li>
<li><code v-pre>SpringMVC</code>提供了自定义的异常处理器<code v-pre>SimpleMappingExceptionResolver</code></li>
<li>在<code v-pre>springMVC.xml</code>文件配置异常处理：</li>
</ol>
<div class="language-xml ext-xml line-numbers-mode"><pre v-pre class="language-xml"><code><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>bean</span> <span class="token attr-name">class</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>org.springframework.web.servlet.handler.SimpleMappingExceptionResolver<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>property</span> <span class="token attr-name">name</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>exceptionMappings<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>props</span><span class="token punctuation">></span></span>
      <span class="token comment">&lt;!-- key：表示异常类型
         error：发生异常要跳转到的页面，
         --></span>
      <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>prop</span> <span class="token attr-name">key</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>java.lang.ArithmeticException<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>error<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>prop</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>props</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>property</span><span class="token punctuation">></span></span>
  <span class="token comment">&lt;!--保存异常信息，默认在请求域中，此处保存的异常信息key为ex    --></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>property</span> <span class="token attr-name">name</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>exceptionAttribute<span class="token punctuation">"</span></span> <span class="token attr-name">value</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>ex<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>property</span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>bean</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><h3 id="_8-2-基于注解的异常处理" tabindex="-1"><a class="header-anchor" href="#_8-2-基于注解的异常处理" aria-hidden="true">#</a> 8.2 基于注解的异常处理</h3>
<ol>
<li>创建配置类，使用<code v-pre>@ControllerAdive</code>注解标记为异常处理类</li>
</ol>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token annotation punctuation">@ControllerAdvice</span><span class="token comment">//将当前类标识为异常处理的组件</span>
<span class="token keyword">public</span> <span class="token keyword">class</span> <span class="token class-name">ExceptionController</span> <span class="token punctuation">{</span>
    <span class="token annotation punctuation">@ExceptionHandler</span><span class="token punctuation">(</span><span class="token class-name">ArithmeticException</span><span class="token punctuation">.</span><span class="token keyword">class</span><span class="token punctuation">)</span><span class="token comment">//设置所标识方法处理的异常，参数为异常类型.class</span>
    <span class="token comment">//ex表示当前请求处理中出现的异常对象</span>
    <span class="token keyword">public</span> <span class="token class-name">String</span> <span class="token function">handleArithmeticException</span><span class="token punctuation">(</span><span class="token class-name">Exception</span> ex<span class="token punctuation">,</span> <span class="token class-name">Model</span> model<span class="token punctuation">)</span><span class="token punctuation">{</span>
        model<span class="token punctuation">.</span><span class="token function">addAttribute</span><span class="token punctuation">(</span><span class="token string">"ex"</span><span class="token punctuation">,</span> ex<span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token keyword">return</span> <span class="token string">"error"</span><span class="token punctuation">;</span>
    <span class="token punctuation">}</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><h2 id="第9章-注解配置spring-mvc" tabindex="-1"><a class="header-anchor" href="#第9章-注解配置spring-mvc" aria-hidden="true">#</a> 第9章 注解配置Spring MVC</h2>
<h3 id="_9-1-创建初始化类-代替web-xml" tabindex="-1"><a class="header-anchor" href="#_9-1-创建初始化类-代替web-xml" aria-hidden="true">#</a> 9.1 创建初始化类，代替<code v-pre>web.xml</code></h3>
<ol>
<li>在<code v-pre>Servlet3.0</code>环境中，容器会在类路径中查找实现<code v-pre>javax.servlet.ServletContainerInitializer</code>接口的类，如果找到的话就用它来配置<code v-pre>Servlet</code>容器。</li>
<li><code v-pre>Spring</code>提供了这个接口的实现，名为<code v-pre>SpringServletContainerInitializer</code>，这个类反过来又会查找实现<code v-pre>WebApplicationInitializer</code>的类并将配置的任务交给它们来完成。</li>
<li><code v-pre>Spring3.2</code>引入了一个便利的<code v-pre>WebApplicationInitializer</code>基础实现，名为<code v-pre>AbstractAnnotationConfigDispatcherServletInitializer</code>，当我们的类扩展了<code v-pre>AbstractAnnotationConfigDispatcherServletInitializer</code>并将其部署到<code v-pre>Servlet3.0</code>容器的时候，容器会自动发现它，并用它来配置<code v-pre>Servlet</code>上下文。</li>
</ol>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token keyword">public</span> <span class="token keyword">class</span> <span class="token class-name">WebInit</span> <span class="token keyword">extends</span> <span class="token class-name">AbstractAnnotationConfigDispatcherServletInitializer</span> <span class="token punctuation">{</span>

    <span class="token doc-comment comment">/**
     * 指定spring的配置类
     * <span class="token keyword">@return</span>
     */</span>
    <span class="token annotation punctuation">@Override</span>
    <span class="token keyword">protected</span> <span class="token class-name">Class</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token operator">?</span><span class="token punctuation">></span></span><span class="token punctuation">[</span><span class="token punctuation">]</span> <span class="token function">getRootConfigClasses</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
        <span class="token keyword">return</span> <span class="token keyword">new</span> <span class="token class-name">Class</span><span class="token punctuation">[</span><span class="token punctuation">]</span><span class="token punctuation">{</span><span class="token class-name">SpringConfig</span><span class="token punctuation">.</span><span class="token keyword">class</span><span class="token punctuation">}</span><span class="token punctuation">;</span>
    <span class="token punctuation">}</span>

    <span class="token doc-comment comment">/**
     * 指定SpringMVC的配置类
     * <span class="token keyword">@return</span>
     */</span>
    <span class="token annotation punctuation">@Override</span>
    <span class="token keyword">protected</span> <span class="token class-name">Class</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token operator">?</span><span class="token punctuation">></span></span><span class="token punctuation">[</span><span class="token punctuation">]</span> <span class="token function">getServletConfigClasses</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
        <span class="token keyword">return</span> <span class="token keyword">new</span> <span class="token class-name">Class</span><span class="token punctuation">[</span><span class="token punctuation">]</span><span class="token punctuation">{</span><span class="token class-name">SpringMVC</span><span class="token punctuation">.</span><span class="token keyword">class</span><span class="token punctuation">}</span><span class="token punctuation">;</span>
    <span class="token punctuation">}</span>

    <span class="token doc-comment comment">/**
     * 指定DispatcherServlet的映射规则，即url-pattern
     * <span class="token keyword">@return</span>
     */</span>
    <span class="token annotation punctuation">@Override</span>
    <span class="token keyword">protected</span> <span class="token class-name">String</span><span class="token punctuation">[</span><span class="token punctuation">]</span> <span class="token function">getServletMappings</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
        <span class="token keyword">return</span> <span class="token keyword">new</span> <span class="token class-name">String</span><span class="token punctuation">[</span><span class="token punctuation">]</span><span class="token punctuation">{</span><span class="token string">"/"</span><span class="token punctuation">}</span><span class="token punctuation">;</span>
    <span class="token punctuation">}</span>

    <span class="token doc-comment comment">/**
     * 添加过滤器
     * <span class="token keyword">@return</span>
     */</span>
    <span class="token annotation punctuation">@Override</span>
    <span class="token keyword">protected</span> <span class="token class-name">Filter</span><span class="token punctuation">[</span><span class="token punctuation">]</span> <span class="token function">getServletFilters</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
        <span class="token class-name">CharacterEncodingFilter</span> encodingFilter <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">CharacterEncodingFilter</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        encodingFilter<span class="token punctuation">.</span><span class="token function">setEncoding</span><span class="token punctuation">(</span><span class="token string">"UTF-8"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        encodingFilter<span class="token punctuation">.</span><span class="token function">setForceRequestEncoding</span><span class="token punctuation">(</span><span class="token boolean">true</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token class-name">HiddenHttpMethodFilter</span> hiddenHttpMethodFilter <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">HiddenHttpMethodFilter</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token keyword">return</span> <span class="token keyword">new</span> <span class="token class-name">Filter</span><span class="token punctuation">[</span><span class="token punctuation">]</span><span class="token punctuation">{</span>encodingFilter<span class="token punctuation">,</span> hiddenHttpMethodFilter<span class="token punctuation">}</span><span class="token punctuation">;</span>
    <span class="token punctuation">}</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><h3 id="_9-3-创建springmvc配置类-代替springmvc配置文件" tabindex="-1"><a class="header-anchor" href="#_9-3-创建springmvc配置类-代替springmvc配置文件" aria-hidden="true">#</a> 9.3 创建springmvc配置类，代替springmvc配置文件</h3>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token annotation punctuation">@Configuration</span>
<span class="token annotation punctuation">@ComponentScan</span><span class="token punctuation">(</span><span class="token string">"com.atguigu.mvc.controller"</span><span class="token punctuation">)</span><span class="token comment">//1. 扫描组件</span>
<span class="token annotation punctuation">@EnableWebMvc</span><span class="token comment">//5. 开启MVC注解驱动</span>
<span class="token keyword">public</span> <span class="token keyword">class</span> <span class="token class-name">SpringMVC</span> <span class="token keyword">implements</span> <span class="token class-name">WebMvcConfigurer</span> <span class="token punctuation">{</span>

    <span class="token comment">//4. 使用默认的servlet处理静态资源</span>
    <span class="token annotation punctuation">@Override</span>
    <span class="token keyword">public</span> <span class="token keyword">void</span> <span class="token function">configureDefaultServletHandling</span><span class="token punctuation">(</span><span class="token class-name">DefaultServletHandlerConfigurer</span> configurer<span class="token punctuation">)</span> <span class="token punctuation">{</span>
        configurer<span class="token punctuation">.</span><span class="token function">enable</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token punctuation">}</span>

    <span class="token comment">//6. 配置文件上传解析器</span>
    <span class="token annotation punctuation">@Bean</span>
    <span class="token keyword">public</span> <span class="token class-name">MultipartResolver</span> <span class="token function">multipartResolver</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">{</span>
        <span class="token keyword">return</span> <span class="token keyword">new</span> <span class="token class-name">CommonsMultipartResolver</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token punctuation">}</span>

    <span class="token comment">//8. 配置拦截器</span>
    <span class="token annotation punctuation">@Override</span>
    <span class="token keyword">public</span> <span class="token keyword">void</span> <span class="token function">addInterceptors</span><span class="token punctuation">(</span><span class="token class-name">InterceptorRegistry</span> registry<span class="token punctuation">)</span> <span class="token punctuation">{</span>
        <span class="token class-name">FirstInterceptor</span> firstInterceptor <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">FirstInterceptor</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        registry<span class="token punctuation">.</span><span class="token function">addInterceptor</span><span class="token punctuation">(</span>firstInterceptor<span class="token punctuation">)</span><span class="token punctuation">.</span><span class="token function">addPathPatterns</span><span class="token punctuation">(</span><span class="token string">"/**"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token punctuation">}</span>
    
    <span class="token comment">//3. 配置视图控制器    </span>
    <span class="token annotation punctuation">@Override</span>
    <span class="token keyword">public</span> <span class="token keyword">void</span> <span class="token function">addViewControllers</span><span class="token punctuation">(</span><span class="token class-name">ViewControllerRegistry</span> registry<span class="token punctuation">)</span> <span class="token punctuation">{</span>
        registry<span class="token punctuation">.</span><span class="token function">addViewController</span><span class="token punctuation">(</span><span class="token string">"/success"</span><span class="token punctuation">)</span><span class="token punctuation">.</span><span class="token function">setViewName</span><span class="token punctuation">(</span><span class="token string">"success"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token punctuation">}</span>
    
    <span class="token comment">//7. 配置异常映射</span>
    <span class="token annotation punctuation">@Override</span>
    <span class="token keyword">public</span> <span class="token keyword">void</span> <span class="token function">configureHandlerExceptionResolvers</span><span class="token punctuation">(</span><span class="token class-name">List</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">HandlerExceptionResolver</span><span class="token punctuation">></span></span> resolvers<span class="token punctuation">)</span> <span class="token punctuation">{</span>
        <span class="token class-name">SimpleMappingExceptionResolver</span> exceptionResolver <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">SimpleMappingExceptionResolver</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token class-name">Properties</span> prop <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">Properties</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        prop<span class="token punctuation">.</span><span class="token function">setProperty</span><span class="token punctuation">(</span><span class="token string">"java.lang.ArithmeticException"</span><span class="token punctuation">,</span> <span class="token string">"error"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token comment">//设置异常映射</span>
        exceptionResolver<span class="token punctuation">.</span><span class="token function">setExceptionMappings</span><span class="token punctuation">(</span>prop<span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token comment">//设置共享异常信息的键</span>
        exceptionResolver<span class="token punctuation">.</span><span class="token function">setExceptionAttribute</span><span class="token punctuation">(</span><span class="token string">"ex"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        resolvers<span class="token punctuation">.</span><span class="token function">add</span><span class="token punctuation">(</span>exceptionResolver<span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token punctuation">}</span>

    <span class="token comment">//2. 视图解析器</span>
    <span class="token comment">//配置生成模板解析器</span>
    <span class="token annotation punctuation">@Bean</span>
    <span class="token keyword">public</span> <span class="token class-name">ITemplateResolver</span> <span class="token function">templateResolver</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
        <span class="token class-name">WebApplicationContext</span> webApplicationContext <span class="token operator">=</span> <span class="token class-name">ContextLoader</span><span class="token punctuation">.</span><span class="token function">getCurrentWebApplicationContext</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token class-name">ServletContextTemplateResolver</span> templateResolver <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">ServletContextTemplateResolver</span><span class="token punctuation">(</span>webApplicationContext<span class="token punctuation">.</span><span class="token function">getServletContext</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        templateResolver<span class="token punctuation">.</span><span class="token function">setPrefix</span><span class="token punctuation">(</span><span class="token string">"/WEB-INF/templates/"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        templateResolver<span class="token punctuation">.</span><span class="token function">setSuffix</span><span class="token punctuation">(</span><span class="token string">".html"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        templateResolver<span class="token punctuation">.</span><span class="token function">setCharacterEncoding</span><span class="token punctuation">(</span><span class="token string">"UTF-8"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        templateResolver<span class="token punctuation">.</span><span class="token function">setTemplateMode</span><span class="token punctuation">(</span><span class="token class-name">TemplateMode</span><span class="token punctuation">.</span>HTML<span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token keyword">return</span> templateResolver<span class="token punctuation">;</span>
    <span class="token punctuation">}</span>

    <span class="token comment">//生成模板引擎并为模板引擎注入模板解析器</span>
    <span class="token annotation punctuation">@Bean</span>
    <span class="token keyword">public</span> <span class="token class-name">SpringTemplateEngine</span> <span class="token function">templateEngine</span><span class="token punctuation">(</span><span class="token class-name">ITemplateResolver</span> templateResolver<span class="token punctuation">)</span> <span class="token punctuation">{</span>
        <span class="token class-name">SpringTemplateEngine</span> templateEngine <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">SpringTemplateEngine</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        templateEngine<span class="token punctuation">.</span><span class="token function">setTemplateResolver</span><span class="token punctuation">(</span>templateResolver<span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token keyword">return</span> templateEngine<span class="token punctuation">;</span>
    <span class="token punctuation">}</span>

    <span class="token comment">//生成视图解析器并未解析器注入模板引擎</span>
    <span class="token annotation punctuation">@Bean</span>
    <span class="token keyword">public</span> <span class="token class-name">ViewResolver</span> <span class="token function">viewResolver</span><span class="token punctuation">(</span><span class="token class-name">SpringTemplateEngine</span> templateEngine<span class="token punctuation">)</span> <span class="token punctuation">{</span>
        <span class="token class-name">ThymeleafViewResolver</span> viewResolver <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">ThymeleafViewResolver</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        viewResolver<span class="token punctuation">.</span><span class="token function">setCharacterEncoding</span><span class="token punctuation">(</span><span class="token string">"UTF-8"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        viewResolver<span class="token punctuation">.</span><span class="token function">setTemplateEngine</span><span class="token punctuation">(</span>templateEngine<span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token keyword">return</span> viewResolver<span class="token punctuation">;</span>
    <span class="token punctuation">}</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><h2 id="第10章-springmvc执行流程" tabindex="-1"><a class="header-anchor" href="#第10章-springmvc执行流程" aria-hidden="true">#</a> 第10章 SpringMVC执行流程</h2>
<h3 id="_10-1-springmvc常用组件" tabindex="-1"><a class="header-anchor" href="#_10-1-springmvc常用组件" aria-hidden="true">#</a> 10.1 SpringMVC常用组件</h3>
<ol>
<li><code v-pre>DispatcherServlet</code>：前端控制器，不需要工程师开发，由框架提供
<ul>
<li>作用：统一处理请求和响应，整个流程控制的中心，由它调用其它组件处理用户的请求</li>
</ul>
</li>
<li><code v-pre>HandlerMapping</code>：处理器映射器，不需要工程师开发，由框架提供
<ul>
<li>作用：根据请求的<code v-pre>url</code>、<code v-pre>method</code>等信息查找<code v-pre>Handler</code>，即控制器方法</li>
</ul>
</li>
<li><code v-pre>HandlerAdapter</code>：处理器适配器，不需要工程师开发，由框架提供
<ul>
<li>作用：通过<code v-pre>HandlerAdapter</code>对处理器（控制器方法）进行执行</li>
</ul>
</li>
<li><code v-pre>Handler</code>：处理器，需要工程师开发【即<code v-pre>Controller</code>】
<ul>
<li>作用：在<code v-pre>DispatcherServlet</code>的控制下<code v-pre>Handler</code>对具体的用户请求进行处理</li>
</ul>
</li>
<li><code v-pre>ViewResolver</code>：视图解析器，不需要工程师开发，由框架提供
<ul>
<li>作用：进行视图解析，得到相应的视图，例如：<code v-pre>ThymeleafView</code>、<code v-pre>InternalResourceView</code>、<code v-pre>RedirectView</code></li>
</ul>
</li>
<li><code v-pre>View</code>：视图
<ul>
<li>作用：将模型数据通过页面展示给用户</li>
</ul>
</li>
</ol>
<h3 id="_10-2-dispatcherservlet初始化过程" tabindex="-1"><a class="header-anchor" href="#_10-2-dispatcherservlet初始化过程" aria-hidden="true">#</a> 10.2 DispatcherServlet初始化过程</h3>
<p><code v-pre>DispatcherServlet</code>本质上是一个 <code v-pre>Servlet</code>，所以天然的遵循 <code v-pre>Servlet</code>的生命周期，宏观上是 <code v-pre>Servlet</code>生命周期来进行调度。即，创建web服务时，从Servlet类的init()方法开始执行。
<img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1659331557701-de814dc3-4112-40a4-b99b-9c5603def972.png#clientId=ua260f30d-b19d-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=960&amp;id=u7d3afb2e&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=960&amp;originWidth=2156&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=62916&amp;status=done&amp;style=stroke&amp;taskId=u7d637df5-1164-4329-beec-5361934b5fc&amp;title=&amp;width=2156" alt="image.png" loading="lazy">
<img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1659331028478-df2566ac-98e7-4740-8ee3-a43e073ff20d.png#clientId=ua260f30d-b19d-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=854&amp;id=u17e8b374&amp;margin=[object Object]&amp;name=img005.png&amp;originHeight=854&amp;originWidth=475&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=33721&amp;status=done&amp;style=stroke&amp;taskId=u7d5af00c-5f08-4443-b9bd-f146744bfea&amp;title=&amp;width=475" alt="img005.png" loading="lazy">
从上图可见，<code v-pre>Servlet</code>类中<code v-pre>init()</code>执行到最后是在<code v-pre>FrameworkServlet</code>类中调用了<code v-pre>initWebApplicationContext()</code>方法，而在该方法中，调用了<code v-pre>createWebApplicationContext()</code>方法</p>
<ul>
<li><code v-pre>createWebApplicationContext()</code>方法使用反射创建了IOC容器。</li>
<li><code v-pre>initWebApplicationContext()</code>方法将IOC容器在应用域中共享。</li>
</ul>
<p>同时，在<code v-pre>FrameworkServlet</code>类的初始化<code v-pre>initWebApplicationContext()</code>方法中，调用了<code v-pre>onRefresh(wac)</code>方法，此方法在<code v-pre>DispatcherServlet</code>中进行了重写，调用了<code v-pre>initStrategies(context)</code>方法，初始化策略，即初始化<code v-pre>DispatcherServlet</code>的各个组件：</p>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token keyword">protected</span> <span class="token keyword">void</span> <span class="token function">initStrategies</span><span class="token punctuation">(</span><span class="token class-name">ApplicationContext</span> context<span class="token punctuation">)</span> <span class="token punctuation">{</span>
    <span class="token function">initMultipartResolver</span><span class="token punctuation">(</span>context<span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token function">initLocaleResolver</span><span class="token punctuation">(</span>context<span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token function">initThemeResolver</span><span class="token punctuation">(</span>context<span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token function">initHandlerMappings</span><span class="token punctuation">(</span>context<span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token function">initHandlerAdapters</span><span class="token punctuation">(</span>context<span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token function">initHandlerExceptionResolvers</span><span class="token punctuation">(</span>context<span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token function">initRequestToViewNameTranslator</span><span class="token punctuation">(</span>context<span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token function">initViewResolvers</span><span class="token punctuation">(</span>context<span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token function">initFlashMapManager</span><span class="token punctuation">(</span>context<span class="token punctuation">)</span><span class="token punctuation">;</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><h3 id="_10-3-dispatcherservlet调用组件处理请求过程" tabindex="-1"><a class="header-anchor" href="#_10-3-dispatcherservlet调用组件处理请求过程" aria-hidden="true">#</a> 10.3 DispatcherServlet调用组件处理请求过程</h3>
<ol>
<li>web容器在处理前端请求时，请求由<code v-pre>Servlet</code>类中的<code v-pre>service()</code>方法从上到下处理，而<code v-pre>Servlet</code>中的<code v-pre>service()</code>被<code v-pre>HttpServlet</code>类重写了。</li>
<li>后<code v-pre>FrameworkServlet</code>重写了<code v-pre>HttpServlet</code>中的<code v-pre>service()</code>和<code v-pre>doXxx()</code>（<code v-pre>doGet()</code>等），这些方法中调用了<code v-pre>FrameworkServlet</code>类中的<code v-pre>processRequest(request, response)</code>。</li>
<li><code v-pre>processRequest(request, response)</code>调用了<code v-pre>FrameworkServlet</code>中的<code v-pre>doService()</code>，而<code v-pre>doService()</code>在<code v-pre>FrameworkServlet</code>是一个抽象方法，在<code v-pre>DispatcherServlet</code>类中进行了重写。</li>
<li><code v-pre>DispatcherServlet</code>中的<code v-pre>doService()</code>调用了<code v-pre>DispatcherServlet</code>中的<code v-pre>doDispatch()</code>，即该方法处理了最后的请求。请求处理后的视图处理等后续处理交给<code v-pre>processDispatchResult()</code>完成。</li>
</ol>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token keyword">protected</span> <span class="token keyword">void</span> <span class="token function">doDispatch</span><span class="token punctuation">(</span><span class="token class-name">HttpServletRequest</span> request<span class="token punctuation">,</span> <span class="token class-name">HttpServletResponse</span> response<span class="token punctuation">)</span> <span class="token keyword">throws</span> <span class="token class-name">Exception</span> <span class="token punctuation">{</span>
    <span class="token class-name">HttpServletRequest</span> processedRequest <span class="token operator">=</span> request<span class="token punctuation">;</span>
    <span class="token class-name">HandlerExecutionChain</span> mappedHandler <span class="token operator">=</span> <span class="token keyword">null</span><span class="token punctuation">;</span>
    <span class="token keyword">boolean</span> multipartRequestParsed <span class="token operator">=</span> <span class="token boolean">false</span><span class="token punctuation">;</span>
    
    <span class="token class-name">WebAsyncManager</span> asyncManager <span class="token operator">=</span> <span class="token class-name">WebAsyncUtils</span><span class="token punctuation">.</span><span class="token function">getAsyncManager</span><span class="token punctuation">(</span>request<span class="token punctuation">)</span><span class="token punctuation">;</span>
    
    <span class="token keyword">try</span> <span class="token punctuation">{</span>
        <span class="token class-name">ModelAndView</span> mv <span class="token operator">=</span> <span class="token keyword">null</span><span class="token punctuation">;</span>
        <span class="token class-name">Exception</span> dispatchException <span class="token operator">=</span> <span class="token keyword">null</span><span class="token punctuation">;</span>
        
        <span class="token keyword">try</span> <span class="token punctuation">{</span>
            processedRequest <span class="token operator">=</span> <span class="token function">checkMultipart</span><span class="token punctuation">(</span>request<span class="token punctuation">)</span><span class="token punctuation">;</span>
            multipartRequestParsed <span class="token operator">=</span> <span class="token punctuation">(</span>processedRequest <span class="token operator">!=</span> request<span class="token punctuation">)</span><span class="token punctuation">;</span>
            
            <span class="token comment">// Determine handler for the current request.</span>
            <span class="token comment">/*
            mappedHandler：调用链
            包含handler、interceptorList、interceptorIndex
            handler：浏览器发送的请求所匹配的控制器方法
            interceptorList：处理控制器方法的所有拦截器集合
            interceptorIndex：拦截器索引，控制拦截器afterCompletion()的执行
            */</span>
            mappedHandler <span class="token operator">=</span> <span class="token function">getHandler</span><span class="token punctuation">(</span>processedRequest<span class="token punctuation">)</span><span class="token punctuation">;</span>
            <span class="token keyword">if</span> <span class="token punctuation">(</span>mappedHandler <span class="token operator">==</span> <span class="token keyword">null</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
                <span class="token function">noHandlerFound</span><span class="token punctuation">(</span>processedRequest<span class="token punctuation">,</span> response<span class="token punctuation">)</span><span class="token punctuation">;</span>
                <span class="token keyword">return</span><span class="token punctuation">;</span>
            <span class="token punctuation">}</span>
            
            <span class="token comment">// Determine handler adapter for the current request.</span>
            <span class="token comment">// 通过控制器方法创建相应的处理器适配器，调用所对应的控制器方法</span>
            <span class="token class-name">HandlerAdapter</span> ha <span class="token operator">=</span> <span class="token function">getHandlerAdapter</span><span class="token punctuation">(</span>mappedHandler<span class="token punctuation">.</span><span class="token function">getHandler</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
            
            <span class="token comment">// Process last-modified header, if supported by the handler.</span>
            <span class="token class-name">String</span> method <span class="token operator">=</span> request<span class="token punctuation">.</span><span class="token function">getMethod</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
            <span class="token keyword">boolean</span> isGet <span class="token operator">=</span> <span class="token string">"GET"</span><span class="token punctuation">.</span><span class="token function">equals</span><span class="token punctuation">(</span>method<span class="token punctuation">)</span><span class="token punctuation">;</span>
            <span class="token keyword">if</span> <span class="token punctuation">(</span>isGet <span class="token operator">||</span> <span class="token string">"HEAD"</span><span class="token punctuation">.</span><span class="token function">equals</span><span class="token punctuation">(</span>method<span class="token punctuation">)</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
                <span class="token keyword">long</span> lastModified <span class="token operator">=</span> ha<span class="token punctuation">.</span><span class="token function">getLastModified</span><span class="token punctuation">(</span>request<span class="token punctuation">,</span> mappedHandler<span class="token punctuation">.</span><span class="token function">getHandler</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
                <span class="token keyword">if</span> <span class="token punctuation">(</span><span class="token keyword">new</span> <span class="token class-name">ServletWebRequest</span><span class="token punctuation">(</span>request<span class="token punctuation">,</span> response<span class="token punctuation">)</span><span class="token punctuation">.</span><span class="token function">checkNotModified</span><span class="token punctuation">(</span>lastModified<span class="token punctuation">)</span> <span class="token operator">&amp;&amp;</span> isGet<span class="token punctuation">)</span> <span class="token punctuation">{</span>
                    <span class="token keyword">return</span><span class="token punctuation">;</span>
                <span class="token punctuation">}</span>
            <span class="token punctuation">}</span>
            
            <span class="token comment">// 调用拦截器的preHandle()</span>
            <span class="token keyword">if</span> <span class="token punctuation">(</span><span class="token operator">!</span>mappedHandler<span class="token punctuation">.</span><span class="token function">applyPreHandle</span><span class="token punctuation">(</span>processedRequest<span class="token punctuation">,</span> response<span class="token punctuation">)</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
                <span class="token keyword">return</span><span class="token punctuation">;</span>
            <span class="token punctuation">}</span>
            
            <span class="token comment">// Actually invoke the handler.</span>
            <span class="token comment">// 由处理器适配器调用具体的控制器方法，最终获得ModelAndView对象</span>
            mv <span class="token operator">=</span> ha<span class="token punctuation">.</span><span class="token function">handle</span><span class="token punctuation">(</span>processedRequest<span class="token punctuation">,</span> response<span class="token punctuation">,</span> mappedHandler<span class="token punctuation">.</span><span class="token function">getHandler</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
            
            <span class="token keyword">if</span> <span class="token punctuation">(</span>asyncManager<span class="token punctuation">.</span><span class="token function">isConcurrentHandlingStarted</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
                <span class="token keyword">return</span><span class="token punctuation">;</span>
            <span class="token punctuation">}</span>
            
            <span class="token function">applyDefaultViewName</span><span class="token punctuation">(</span>processedRequest<span class="token punctuation">,</span> mv<span class="token punctuation">)</span><span class="token punctuation">;</span>
            <span class="token comment">// 调用拦截器的postHandle()</span>
            mappedHandler<span class="token punctuation">.</span><span class="token function">applyPostHandle</span><span class="token punctuation">(</span>processedRequest<span class="token punctuation">,</span> response<span class="token punctuation">,</span> mv<span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token punctuation">}</span>
        <span class="token keyword">catch</span> <span class="token punctuation">(</span><span class="token class-name">Exception</span> ex<span class="token punctuation">)</span> <span class="token punctuation">{</span>
            dispatchException <span class="token operator">=</span> ex<span class="token punctuation">;</span>
        <span class="token punctuation">}</span>
        <span class="token keyword">catch</span> <span class="token punctuation">(</span><span class="token class-name">Throwable</span> err<span class="token punctuation">)</span> <span class="token punctuation">{</span>
            <span class="token comment">// As of 4.3, we're processing Errors thrown from handler methods as well,</span>
            <span class="token comment">// making them available for @ExceptionHandler methods and other scenarios.</span>
            dispatchException <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">NestedServletException</span><span class="token punctuation">(</span><span class="token string">"Handler dispatch failed"</span><span class="token punctuation">,</span> err<span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token punctuation">}</span>
        <span class="token comment">// 后续处理：处理模型数据和渲染视图</span>
        <span class="token function">processDispatchResult</span><span class="token punctuation">(</span>processedRequest<span class="token punctuation">,</span> response<span class="token punctuation">,</span> mappedHandler<span class="token punctuation">,</span> mv<span class="token punctuation">,</span> dispatchException<span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token punctuation">}</span>
    <span class="token keyword">catch</span> <span class="token punctuation">(</span><span class="token class-name">Exception</span> ex<span class="token punctuation">)</span> <span class="token punctuation">{</span>
        <span class="token function">triggerAfterCompletion</span><span class="token punctuation">(</span>processedRequest<span class="token punctuation">,</span> response<span class="token punctuation">,</span> mappedHandler<span class="token punctuation">,</span> ex<span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token punctuation">}</span>
    <span class="token keyword">catch</span> <span class="token punctuation">(</span><span class="token class-name">Throwable</span> err<span class="token punctuation">)</span> <span class="token punctuation">{</span>
        <span class="token function">triggerAfterCompletion</span><span class="token punctuation">(</span>processedRequest<span class="token punctuation">,</span> response<span class="token punctuation">,</span> mappedHandler<span class="token punctuation">,</span>
                               <span class="token keyword">new</span> <span class="token class-name">NestedServletException</span><span class="token punctuation">(</span><span class="token string">"Handler processing failed"</span><span class="token punctuation">,</span> err<span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token punctuation">}</span>
    <span class="token keyword">finally</span> <span class="token punctuation">{</span>
        <span class="token keyword">if</span> <span class="token punctuation">(</span>asyncManager<span class="token punctuation">.</span><span class="token function">isConcurrentHandlingStarted</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
            <span class="token comment">// Instead of postHandle and afterCompletion</span>
            <span class="token keyword">if</span> <span class="token punctuation">(</span>mappedHandler <span class="token operator">!=</span> <span class="token keyword">null</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
                mappedHandler<span class="token punctuation">.</span><span class="token function">applyAfterConcurrentHandlingStarted</span><span class="token punctuation">(</span>processedRequest<span class="token punctuation">,</span> response<span class="token punctuation">)</span><span class="token punctuation">;</span>
            <span class="token punctuation">}</span>
        <span class="token punctuation">}</span>
        <span class="token keyword">else</span> <span class="token punctuation">{</span>
            <span class="token comment">// Clean up any resources used by a multipart request.</span>
            <span class="token keyword">if</span> <span class="token punctuation">(</span>multipartRequestParsed<span class="token punctuation">)</span> <span class="token punctuation">{</span>
                <span class="token function">cleanupMultipart</span><span class="token punctuation">(</span>processedRequest<span class="token punctuation">)</span><span class="token punctuation">;</span>
            <span class="token punctuation">}</span>
        <span class="token punctuation">}</span>
    <span class="token punctuation">}</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token keyword">private</span> <span class="token keyword">void</span> <span class="token function">processDispatchResult</span><span class="token punctuation">(</span><span class="token class-name">HttpServletRequest</span> request<span class="token punctuation">,</span> <span class="token class-name">HttpServletResponse</span> response<span class="token punctuation">,</span>
                                   <span class="token annotation punctuation">@Nullable</span> <span class="token class-name">HandlerExecutionChain</span> mappedHandler<span class="token punctuation">,</span> <span class="token annotation punctuation">@Nullable</span> <span class="token class-name">ModelAndView</span> mv<span class="token punctuation">,</span>
                                   <span class="token annotation punctuation">@Nullable</span> <span class="token class-name">Exception</span> exception<span class="token punctuation">)</span> <span class="token keyword">throws</span> <span class="token class-name">Exception</span> <span class="token punctuation">{</span>
    
    <span class="token keyword">boolean</span> errorView <span class="token operator">=</span> <span class="token boolean">false</span><span class="token punctuation">;</span>
    
    <span class="token keyword">if</span> <span class="token punctuation">(</span>exception <span class="token operator">!=</span> <span class="token keyword">null</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
        <span class="token keyword">if</span> <span class="token punctuation">(</span>exception <span class="token keyword">instanceof</span> <span class="token class-name">ModelAndViewDefiningException</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
            logger<span class="token punctuation">.</span><span class="token function">debug</span><span class="token punctuation">(</span><span class="token string">"ModelAndViewDefiningException encountered"</span><span class="token punctuation">,</span> exception<span class="token punctuation">)</span><span class="token punctuation">;</span>
            mv <span class="token operator">=</span> <span class="token punctuation">(</span><span class="token punctuation">(</span><span class="token class-name">ModelAndViewDefiningException</span><span class="token punctuation">)</span> exception<span class="token punctuation">)</span><span class="token punctuation">.</span><span class="token function">getModelAndView</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token punctuation">}</span>
        <span class="token keyword">else</span> <span class="token punctuation">{</span>
            <span class="token class-name">Object</span> handler <span class="token operator">=</span> <span class="token punctuation">(</span>mappedHandler <span class="token operator">!=</span> <span class="token keyword">null</span> <span class="token operator">?</span> mappedHandler<span class="token punctuation">.</span><span class="token function">getHandler</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token operator">:</span> <span class="token keyword">null</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
            mv <span class="token operator">=</span> <span class="token function">processHandlerException</span><span class="token punctuation">(</span>request<span class="token punctuation">,</span> response<span class="token punctuation">,</span> handler<span class="token punctuation">,</span> exception<span class="token punctuation">)</span><span class="token punctuation">;</span>
            errorView <span class="token operator">=</span> <span class="token punctuation">(</span>mv <span class="token operator">!=</span> <span class="token keyword">null</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token punctuation">}</span>
    <span class="token punctuation">}</span>
    
    <span class="token comment">// Did the handler return a view to render?</span>
    <span class="token keyword">if</span> <span class="token punctuation">(</span>mv <span class="token operator">!=</span> <span class="token keyword">null</span> <span class="token operator">&amp;&amp;</span> <span class="token operator">!</span>mv<span class="token punctuation">.</span><span class="token function">wasCleared</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
        <span class="token comment">// 处理模型数据和渲染视图</span>
        <span class="token function">render</span><span class="token punctuation">(</span>mv<span class="token punctuation">,</span> request<span class="token punctuation">,</span> response<span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token keyword">if</span> <span class="token punctuation">(</span>errorView<span class="token punctuation">)</span> <span class="token punctuation">{</span>
            <span class="token class-name">WebUtils</span><span class="token punctuation">.</span><span class="token function">clearErrorRequestAttributes</span><span class="token punctuation">(</span>request<span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token punctuation">}</span>
    <span class="token punctuation">}</span>
    <span class="token keyword">else</span> <span class="token punctuation">{</span>
        <span class="token keyword">if</span> <span class="token punctuation">(</span>logger<span class="token punctuation">.</span><span class="token function">isTraceEnabled</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
            logger<span class="token punctuation">.</span><span class="token function">trace</span><span class="token punctuation">(</span><span class="token string">"No view rendering, null ModelAndView returned."</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token punctuation">}</span>
    <span class="token punctuation">}</span>
    
    <span class="token keyword">if</span> <span class="token punctuation">(</span><span class="token class-name">WebAsyncUtils</span><span class="token punctuation">.</span><span class="token function">getAsyncManager</span><span class="token punctuation">(</span>request<span class="token punctuation">)</span><span class="token punctuation">.</span><span class="token function">isConcurrentHandlingStarted</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
        <span class="token comment">// Concurrent handling started during a forward</span>
        <span class="token keyword">return</span><span class="token punctuation">;</span>
    <span class="token punctuation">}</span>
    
    <span class="token keyword">if</span> <span class="token punctuation">(</span>mappedHandler <span class="token operator">!=</span> <span class="token keyword">null</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
        <span class="token comment">// Exception (if any) is already handled..</span>
        <span class="token comment">// 调用拦截器的afterCompletion()</span>
        mappedHandler<span class="token punctuation">.</span><span class="token function">triggerAfterCompletion</span><span class="token punctuation">(</span>request<span class="token punctuation">,</span> response<span class="token punctuation">,</span> <span class="token keyword">null</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token punctuation">}</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><h3 id="_10-4-springmvc的执行流程" tabindex="-1"><a class="header-anchor" href="#_10-4-springmvc的执行流程" aria-hidden="true">#</a> 10.4 SpringMVC的执行流程</h3>
<ol>
<li>用户向服务器发送请求，经过过滤器后请求被<code v-pre>SpringMVC</code>的前端控制器 <code v-pre>DispatcherServlet</code>捕获。</li>
<li><code v-pre>DispatcherServlet</code>对请求<code v-pre>URL</code>进行解析，得到请求资源标识符（<code v-pre>URI</code>），通过<code v-pre>handlermapping</code>判断请求<code v-pre>URI</code>对应的映射：</li>
</ol>
<ul>
<li>不存在
<ul>
<li>再判断是否配置了<code v-pre>mvc:default-servlet-handler</code>——默认的前端控制器，处理静态资源
<ul>
<li>如果没配置，则控制台报映射查找不到，客户端展示404错误
<ul>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1659335879461-f265f624-cc9e-445d-9487-deb7a86bf48a.png#clientId=ua260f30d-b19d-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=79&amp;id=ucfd52884&amp;margin=[object Object]&amp;name=img006.png&amp;originHeight=79&amp;originWidth=988&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=10226&amp;status=done&amp;style=stroke&amp;taskId=u07d63ee0-ddb7-42ae-ab68-441aec70c42&amp;title=&amp;width=988" alt="img006.png" loading="lazy"></li>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1659335135162-7ec01025-4842-46fb-b301-9cbdf267fea4.png#clientId=ua260f30d-b19d-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=191&amp;id=ucceceb04&amp;margin=[object Object]&amp;name=img007.png&amp;originHeight=191&amp;originWidth=594&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=9079&amp;status=done&amp;style=stroke&amp;taskId=ub3431bc8-b004-4c6b-a715-fa649261bc3&amp;title=&amp;width=594" alt="img007.png" loading="lazy"></li>
</ul>
</li>
<li>如果有配置，则访问目标资源（一般为静态资源，如：JS,CSS,HTML），找不到客户端也会展示404错误
<ul>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1659335950905-758ea4c6-d0ea-4a4a-97ec-863e19a40c80.png#clientId=ua260f30d-b19d-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=89&amp;id=u45dee55b&amp;margin=[object Object]&amp;name=img008.png&amp;originHeight=89&amp;originWidth=1171&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=8813&amp;status=done&amp;style=stroke&amp;taskId=u79fa79e6-6de5-4fb9-bf2e-250655aaee5&amp;title=&amp;width=1171" alt="img008.png" loading="lazy"></li>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1659335141171-5239a20d-f5c7-4b5d-b46f-a38b8796848b.png#clientId=ua260f30d-b19d-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=175&amp;id=ue38f3793&amp;margin=[object Object]&amp;name=img009.png&amp;originHeight=175&amp;originWidth=670&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=13681&amp;status=done&amp;style=stroke&amp;taskId=ub68703ec-a193-4cd9-9fe7-5d550360480&amp;title=&amp;width=670" alt="img009.png" loading="lazy"></li>
</ul>
</li>
</ul>
</li>
<li>存在：执行下面流程</li>
</ul>
</li>
</ul>
<ol start="3">
<li>
<p>根据该<code v-pre>URI</code>，调用<code v-pre>HandlerMapping</code>获得该<code v-pre>Handler</code>配置的所有相关的对象（包括<code v-pre>Handler</code>对象以及<code v-pre>Handler</code>对象对应的拦截器），最后以<code v-pre>HandlerExecutionChain</code>执行链对象的形式返回。</p>
</li>
<li>
<p><code v-pre>DispatcherServlet</code>根据获得的<code v-pre>Handler</code>，选择一个合适的<code v-pre>HandlerAdapter</code>。</p>
</li>
<li>
<p>如果成功获得<code v-pre>HandlerAdapter</code>，此时将开始执行拦截器的<code v-pre>preHandler(…)</code>方法【正向】</p>
</li>
<li>
<p>提取<code v-pre>Request</code>中的模型数据，填充<code v-pre>Handler</code>（控制器方法）入参，开始执行<code v-pre>Handler</code>（<code v-pre>Controller</code>)方法，处理请求。在填充<code v-pre>Handler</code>的入参过程中，根据你的配置，<code v-pre>Spring</code>将帮你做一些额外的工作：</p>
<ul>
<li><code v-pre>HttpMessageConveter</code>： 将请求消息（如<code v-pre>Json</code>、<code v-pre>xml</code>等数据）转换成一个对象，将对象转换为指定的响应信息</li>
<li>数据转换：对请求消息进行数据转换。如<code v-pre>String</code>转换成<code v-pre>Integer</code>、<code v-pre>Double</code>等</li>
<li>数据格式化：对请求消息进行数据格式化。 如将字符串转换成格式化数字或格式化日期等</li>
<li>数据验证： 验证数据的有效性（长度、格式等），验证结果存储到BindingResult或Error中</li>
</ul>
</li>
<li>
<p><code v-pre>Handler</code>执行完成后，向<code v-pre>DispatcherServlet</code>返回一个<code v-pre>ModelAndView</code>对象。</p>
</li>
<li>
<p>此时将开始执行拦截器的<code v-pre>postHandle(...)</code>方法【逆向】。</p>
</li>
<li>
<p>根据返回的<code v-pre>ModelAndView</code>（此时会判断是否存在异常：如果存在异常，则执行<code v-pre>HandlerExceptionResolver</code>进行异常处理）选择一个适合的<code v-pre>ViewResolver</code>进行视图解析，根据<code v-pre>Model</code>和<code v-pre>View</code>，来渲染视图。</p>
</li>
<li>
<p>渲染视图完毕执行拦截器的<code v-pre>afterCompletion(…)</code>方法【逆向】。</p>
</li>
<li>
<p>将渲染结果返回给客户端。
<img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1659336200288-722d9b89-6248-4f13-9351-815165fb1c20.png#clientId=ua260f30d-b19d-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;id=u0c678059&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=460&amp;originWidth=819&amp;originalType=url&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=209273&amp;status=done&amp;style=stroke&amp;taskId=u3c9bc6c3-f664-4525-b997-e38d678b056&amp;title=" alt="image.png" loading="lazy"></p>
</li>
</ol>
</div></template>
