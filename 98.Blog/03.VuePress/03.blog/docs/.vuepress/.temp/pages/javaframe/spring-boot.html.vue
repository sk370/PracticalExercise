<template><div><h1 id="spring-boot" tabindex="-1"><a class="header-anchor" href="#spring-boot" aria-hidden="true">#</a> Spring Boot</h1>
<blockquote>
<ul>
<li>Spring基础</li>
<li>熟悉Maven</li>
<li>官方文档：</li>
<li>新特性：</li>
<li>版本概览：
<ul>
<li>2.7.2 <strong>CURRENT</strong> <strong>GA</strong>（学习版本为：2.3.4.RELEASE）</li>
<li>3.0.0-SNAPSHOT <strong>SNAPSHOT</strong></li>
<li>3.0.0-M4 PRE</li>
</ul>
</li>
<li>环境要求（基于Spring Boot 2.7.2）：
<ul>
<li>Java：≥8</li>
<li>Spring Framework：≥5.3.22</li>
<li>Maven：≥3.5</li>
</ul>
</li>
<li>Spring Boot 2.7.2支持的Servlet容器版本：
<ul>
<li>Tomacat 9.0：4.0</li>
<li>Jetty 9.4：3.1</li>
<li>Jetty 10.0：4.0</li>
<li>Undertow 2.0：4.0</li>
</ul>
</li>
</ul>
</blockquote>
<h2 id="第1章-spring-boot介绍" tabindex="-1"><a class="header-anchor" href="#第1章-spring-boot介绍" aria-hidden="true">#</a> 第1章 Spring Boot介绍</h2>
<h3 id="_1-1-spring-boot用途" tabindex="-1"><a class="header-anchor" href="#_1-1-spring-boot用途" aria-hidden="true">#</a> 1.1 Spring Boot用途</h3>
<ol>
<li>SpringBoot是Spring官方整合的Spring框架，能够快速创建生产级别的Spring应用。</li>
<li>一句话介绍：
<ul>
<li>SpringBoot是整合Spring技术栈的一站式框架【spring boot是对spring框架整合的整合】</li>
<li>SpringBoot是简化Spring技术栈的快速开发脚手架</li>
</ul>
</li>
<li>优点：
<ul>
<li>创建独立Spring应用</li>
<li>内嵌web服务器</li>
<li>自动配置Spring以及第三方功能</li>
<li>提供生产级别的监控、健康检查及外部化配置</li>
<li>无代码生成、无需编写XML</li>
</ul>
</li>
</ol>
<h3 id="_1-2-spring-boot出现背景" tabindex="-1"><a class="header-anchor" href="#_1-2-spring-boot出现背景" aria-hidden="true">#</a> 1.2 spring boot出现背景</h3>
<h4 id="_1-2-1-微服务-2014年" tabindex="-1"><a class="header-anchor" href="#_1-2-1-微服务-2014年" aria-hidden="true">#</a> 1.2.1 微服务（2014年）</h4>
<ul>
<li>微服务是一种架构风格</li>
<li>一个应用拆分为一组小型服务</li>
<li>每个服务运行在自己的进程内，也就是可独立部署和升级</li>
<li>服务之间使用轻量级HTTP交互</li>
<li>服务围绕业务功能拆分</li>
<li>可以由全自动部署机制独立部署</li>
<li>去中心化，服务自治。服务可以使用不同的语言、不同的存储技术</li>
</ul>
<h4 id="_1-2-2-分布式" tabindex="-1"><a class="header-anchor" href="#_1-2-2-分布式" aria-hidden="true">#</a> 1.2.2 分布式</h4>
<ol>
<li>分布式的难点
<ul>
<li>远程调用</li>
<li>服务发现</li>
<li>负载均衡</li>
<li>服务容错</li>
<li>配置管理</li>
<li>服务监控</li>
<li>链路追踪</li>
<li>日志管理</li>
<li>任务调度</li>
</ul>
</li>
<li>分布式的解决
<ul>
<li>spring boot + spring cloud</li>
</ul>
</li>
</ol>
<h4 id="_1-2-3-云原生" tabindex="-1"><a class="header-anchor" href="#_1-2-3-云原生" aria-hidden="true">#</a> 1.2.3 云原生</h4>
<h3 id="_1-3-创建spring-boot2项目-以web工程为例" tabindex="-1"><a class="header-anchor" href="#_1-3-创建spring-boot2项目-以web工程为例" aria-hidden="true">#</a> 1.3 创建Spring Boot2项目（以web工程为例）</h3>
<h4 id="_1-3-1-手工搭建" tabindex="-1"><a class="header-anchor" href="#_1-3-1-手工搭建" aria-hidden="true">#</a> 1.3.1 手工搭建</h4>
<ol>
<li>创建maven工程
<ul>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1659527526285-61177750-a6ba-402c-a62a-31331262360b.png#clientId=ueca4018c-2697-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=518&amp;id=ua6d15ed3&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=518&amp;originWidth=780&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=99276&amp;status=done&amp;style=none&amp;taskId=u071e5915-dce1-4204-98ef-9f9a92eb73b&amp;title=&amp;width=780" alt="image.png" loading="lazy"></li>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1659527661405-40a65cc3-e3c2-48b7-bbab-a0d2403b3ee5.png#clientId=ueca4018c-2697-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=518&amp;id=u8c33701b&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=518&amp;originWidth=780&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=22401&amp;status=done&amp;style=none&amp;taskId=u09d9853d-8546-4b42-bc3d-78749409e2b&amp;title=&amp;width=780" alt="image.png" loading="lazy"></li>
</ul>
</li>
<li>pom.xml文件中引入依赖</li>
</ol>
<div class="language-xml ext-xml line-numbers-mode"><pre v-pre class="language-xml"><code><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>parent</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>groupId</span><span class="token punctuation">></span></span>org.springframework.boot<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>groupId</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>artifactId</span><span class="token punctuation">></span></span>spring-boot-starter-parent<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>artifactId</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>version</span><span class="token punctuation">></span></span>2.3.4.RELEASE<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>version</span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>parent</span><span class="token punctuation">></span></span>

<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>dependencies</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>dependency</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>groupId</span><span class="token punctuation">></span></span>org.springframework.boot<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>groupId</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>artifactId</span><span class="token punctuation">></span></span>spring-boot-starter-web<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>artifactId</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>dependency</span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>dependencies</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ol start="3">
<li>src/main/java/iceriver.boot包下创建主程序，名称任意</li>
</ol>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token keyword">package</span> <span class="token namespace">iceriver<span class="token punctuation">.</span>boot</span><span class="token punctuation">;</span>

<span class="token keyword">import</span> <span class="token import"><span class="token namespace">org<span class="token punctuation">.</span>springframework<span class="token punctuation">.</span>boot<span class="token punctuation">.</span></span><span class="token class-name">SpringApplication</span></span><span class="token punctuation">;</span>

<span class="token doc-comment comment">/**
 * <span class="token keyword">@author</span>: INFINITY https://developer.aliyun.com/profile/sagwrxp2ua66w
 * <span class="token keyword">@date</span>: 2022/8/3 20:10
 */</span>
<span class="token annotation punctuation">@SpringBootApplication</span>
<span class="token keyword">public</span> <span class="token keyword">class</span> <span class="token class-name">MainApplication</span> <span class="token punctuation">{</span>
    <span class="token keyword">public</span> <span class="token keyword">static</span> <span class="token keyword">void</span> <span class="token function">main</span><span class="token punctuation">(</span><span class="token class-name">String</span><span class="token punctuation">[</span><span class="token punctuation">]</span> args<span class="token punctuation">)</span> <span class="token punctuation">{</span>
        <span class="token class-name">SpringApplication</span><span class="token punctuation">.</span><span class="token function">run</span><span class="token punctuation">(</span><span class="token class-name">MainApplication</span><span class="token punctuation">.</span><span class="token keyword">class</span><span class="token punctuation">,</span>args<span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token punctuation">}</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ol start="4">
<li>src/main/java/iceriver.boot.controller包下创建处理请求的控制器</li>
</ol>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token keyword">package</span> <span class="token namespace">iceriver<span class="token punctuation">.</span>boot<span class="token punctuation">.</span>controller</span><span class="token punctuation">;</span>

<span class="token keyword">import</span> <span class="token import"><span class="token namespace">org<span class="token punctuation">.</span>springframework<span class="token punctuation">.</span>web<span class="token punctuation">.</span>bind<span class="token punctuation">.</span>annotation<span class="token punctuation">.</span></span><span class="token class-name">RequestMapping</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">org<span class="token punctuation">.</span>springframework<span class="token punctuation">.</span>web<span class="token punctuation">.</span>bind<span class="token punctuation">.</span>annotation<span class="token punctuation">.</span></span><span class="token class-name">RestController</span></span><span class="token punctuation">;</span>

<span class="token doc-comment comment">/**
 * <span class="token keyword">@author</span>: INFINITY https://developer.aliyun.com/profile/sagwrxp2ua66w
 * <span class="token keyword">@date</span>: 2022/8/3 20:12
 */</span>
<span class="token annotation punctuation">@RestController</span>
<span class="token keyword">public</span> <span class="token keyword">class</span> <span class="token class-name">HelloController</span> <span class="token punctuation">{</span>
    <span class="token annotation punctuation">@RequestMapping</span><span class="token punctuation">(</span><span class="token string">"/hello"</span><span class="token punctuation">)</span>
    <span class="token keyword">public</span> <span class="token class-name">String</span> <span class="token function">handle01</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">{</span>
        <span class="token keyword">return</span> <span class="token string">"Hello, Spring Boot 2!"</span><span class="token punctuation">;</span>
    <span class="token punctuation">}</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ol start="5">
<li>运行src/main/java/iceriver.boot包下的主程序main方法
<ul>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1659529561840-202e4f4f-25c8-4033-abc0-6dffe1904fda.png#clientId=ueca4018c-2697-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=467&amp;id=uc5059845&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=467&amp;originWidth=1628&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=94001&amp;status=done&amp;style=none&amp;taskId=u57989886-73c4-49cb-92cb-44837d6f3a2&amp;title=&amp;width=1628" alt="image.png" loading="lazy"></li>
</ul>
</li>
<li>浏览器访问<a href="http://localhost:8080/hello" target="_blank" rel="noopener noreferrer">http://localhost:8080/hello<ExternalLinkIcon/></a>
<ul>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1659529585435-d618c9f7-d09c-496f-9675-3bada639bf4c.png#clientId=ueca4018c-2697-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=110&amp;id=u7f5ffd32&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=110&amp;originWidth=347&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=6362&amp;status=done&amp;style=none&amp;taskId=ue98ca60e-c71c-4d6b-9580-167419ff862&amp;title=&amp;width=347" alt="image.png" loading="lazy"></li>
</ul>
</li>
<li>修改端口号：在resources目录下创建application.properties文件【文件名称固定，称为核心配置文件】</li>
</ol>
<div class="language-properties ext-properties line-numbers-mode"><pre v-pre class="language-properties"><code><span class="token key attr-name">server.port</span><span class="token punctuation">=</span><span class="token value attr-value">8888</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div></div></div><ol start="8">
<li>部署：
<ul>
<li>pom.xml文件中添加插件</li>
</ul>
</li>
</ol>
<div class="language-xml ext-xml line-numbers-mode"><pre v-pre class="language-xml"><code> <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>build</span><span class="token punctuation">></span></span>
   <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>plugins</span><span class="token punctuation">></span></span>
     <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>plugin</span><span class="token punctuation">></span></span>
       <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>groupId</span><span class="token punctuation">></span></span>org.springframework.boot<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>groupId</span><span class="token punctuation">></span></span>
       <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>artifactId</span><span class="token punctuation">></span></span>spring-boot-maven-plugin<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>artifactId</span><span class="token punctuation">></span></span>
     <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>plugin</span><span class="token punctuation">></span></span>
   <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>plugins</span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>build</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ul>
<li>执行maven打包命令：
<ul>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1659530307546-2a92c8f6-9599-41dc-a996-46cc344f5083.png#clientId=ueca4018c-2697-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=261&amp;id=u53ec08b2&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=261&amp;originWidth=246&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=12225&amp;status=done&amp;style=none&amp;taskId=uf1562499-e112-4e86-95dd-4131821f834&amp;title=&amp;width=246" alt="image.png" loading="lazy"></li>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1659530398039-8508b94d-3b4a-41ca-a5bb-d7651991b771.png#clientId=ueca4018c-2697-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=187&amp;id=u86292810&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=187&amp;originWidth=410&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=15679&amp;status=done&amp;style=none&amp;taskId=u885981eb-553c-428d-a2a8-1ab2ac7acf8&amp;title=&amp;width=410" alt="image.png" loading="lazy"></li>
</ul>
</li>
<li>执行java -jar jar包名命令
<ul>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1659533060567-c6a4b24a-7643-4ec0-82de-063c623ee686.png#clientId=ueca4018c-2697-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=400&amp;id=u14ac2a4f&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=400&amp;originWidth=1536&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=75625&amp;status=done&amp;style=none&amp;taskId=uc38e8563-5b82-4d2a-a742-c7f23dca9e6&amp;title=&amp;width=1536" alt="image.png" loading="lazy"></li>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1659533099984-6006be85-b281-44f7-9c73-32fedb094fe5.png#clientId=ueca4018c-2697-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=101&amp;id=u8c92532f&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=101&amp;originWidth=531&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=7770&amp;status=done&amp;style=none&amp;taskId=u1a8aaf4a-6004-497b-92df-9a9375bf2d2&amp;title=&amp;width=531" alt="image.png" loading="lazy"></li>
</ul>
</li>
</ul>
<h4 id="_1-3-2-spring-initializr【spring初始化向导】" tabindex="-1"><a class="header-anchor" href="#_1-3-2-spring-initializr【spring初始化向导】" aria-hidden="true">#</a> 1.3.2 spring initializr【spring初始化向导】</h4>
<ol>
<li>创建工程/模块</li>
</ol>
<p><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1659579821858-b308d3ad-d68a-4c6f-9a30-38143d22cc83.png#clientId=ueca4018c-2697-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=670&amp;id=u1fb64b2a&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=670&amp;originWidth=721&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=54502&amp;status=done&amp;style=none&amp;taskId=u8074e434-5144-4652-8a21-0f912d94db6&amp;title=&amp;width=721" alt="image.png" loading="lazy"></p>
<ol start="2">
<li>选择需要的依赖
<ul>
<li>
<p><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1659579962123-d635a819-db90-400b-8bc7-78674635fbea.png#clientId=ueca4018c-2697-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=670&amp;id=uc71dc7a5&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=670&amp;originWidth=721&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=48772&amp;status=done&amp;style=none&amp;taskId=ufa502038-7de6-4443-815b-b80a71bbd1c&amp;title=&amp;width=721" alt="image.png" loading="lazy"></p>
</li>
<li></li>
</ul>
</li>
</ol>
<h2 id="第2章-spring-boot的底层注解" tabindex="-1"><a class="header-anchor" href="#第2章-spring-boot的底层注解" aria-hidden="true">#</a> 第2章 Spring Boot的底层注解</h2>
<h3 id="_2-1-第一组-configuration和-bean" tabindex="-1"><a class="header-anchor" href="#_2-1-第一组-configuration和-bean" aria-hidden="true">#</a> 2.1 第一组：@Configuration和@Bean</h3>
<h4 id="_2-1-1-configuration" tabindex="-1"><a class="header-anchor" href="#_2-1-1-configuration" aria-hidden="true">#</a> 2.1.1 <code v-pre>@Configuration</code></h4>
<ol>
<li>将类声明为配置类，【参见Spring5 4.5完全注解开发<a href="https://www.yuque.com/zhuyuqi/zna9x5/aze75g?view=doc_embed&amp;inner=Ex1iI" target="_blank" rel="noopener noreferrer">02.Spring5<ExternalLinkIcon/></a>】</li>
<li><code v-pre>@Configuration(proxyBeanMethods = true)</code>默认为true，此时Spring Boot总会检查这个组件是否在容器中存在，存在时不会再创建。
<ul>
<li>此时不论是通过MainApplication.java主程序从容器获取组件</li>
<li>还是从配置类MyConfig.java的方法获取组件，都是同一个对象（单实例）</li>
</ul>
</li>
</ol>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token keyword">package</span> <span class="token namespace">iceriver<span class="token punctuation">.</span>boot</span><span class="token punctuation">;</span>

<span class="token keyword">import</span> <span class="token import"><span class="token namespace">iceriver<span class="token punctuation">.</span>boot<span class="token punctuation">.</span>bean<span class="token punctuation">.</span></span><span class="token class-name">Pet</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">iceriver<span class="token punctuation">.</span>boot<span class="token punctuation">.</span>bean<span class="token punctuation">.</span></span><span class="token class-name">User</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">iceriver<span class="token punctuation">.</span>boot<span class="token punctuation">.</span>config<span class="token punctuation">.</span></span><span class="token class-name">MyConfig</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">org<span class="token punctuation">.</span>springframework<span class="token punctuation">.</span>boot<span class="token punctuation">.</span></span><span class="token class-name">SpringApplication</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">org<span class="token punctuation">.</span>springframework<span class="token punctuation">.</span>boot<span class="token punctuation">.</span>autoconfigure<span class="token punctuation">.</span></span><span class="token class-name">SpringBootApplication</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">org<span class="token punctuation">.</span>springframework<span class="token punctuation">.</span>context<span class="token punctuation">.</span></span><span class="token class-name">ConfigurableApplicationContext</span></span><span class="token punctuation">;</span>

<span class="token doc-comment comment">/**
 * <span class="token keyword">@author</span>: INFINITY https://developer.aliyun.com/profile/sagwrxp2ua66w
 * <span class="token keyword">@date</span>: 2022/8/3 20:10
 */</span>
<span class="token comment">//@SpringBootApplication(scanBasePackages = "iceriver.boot")</span>
<span class="token annotation punctuation">@SpringBootApplication</span>
<span class="token keyword">public</span> <span class="token keyword">class</span> <span class="token class-name">MainApplication</span> <span class="token punctuation">{</span>
    <span class="token keyword">public</span> <span class="token keyword">static</span> <span class="token keyword">void</span> <span class="token function">main</span><span class="token punctuation">(</span><span class="token class-name">String</span><span class="token punctuation">[</span><span class="token punctuation">]</span> args<span class="token punctuation">)</span> <span class="token punctuation">{</span>
        <span class="token comment">//1、返回IOC容器</span>
        <span class="token class-name">ConfigurableApplicationContext</span> run <span class="token operator">=</span> <span class="token class-name">SpringApplication</span><span class="token punctuation">.</span><span class="token function">run</span><span class="token punctuation">(</span><span class="token class-name">MainApplication</span><span class="token punctuation">.</span><span class="token keyword">class</span><span class="token punctuation">,</span> args<span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token comment">//2、查看容器里面的组件</span>
        <span class="token class-name">String</span><span class="token punctuation">[</span><span class="token punctuation">]</span> names <span class="token operator">=</span> run<span class="token punctuation">.</span><span class="token function">getBeanDefinitionNames</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token keyword">for</span> <span class="token punctuation">(</span><span class="token class-name">String</span> name <span class="token operator">:</span> names<span class="token punctuation">)</span> <span class="token punctuation">{</span>
            <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span>name<span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token punctuation">}</span>
        <span class="token comment">//3、从容器获取组件</span>
        <span class="token class-name">Pet</span> tom01 <span class="token operator">=</span> run<span class="token punctuation">.</span><span class="token function">getBean</span><span class="token punctuation">(</span><span class="token string">"tom"</span><span class="token punctuation">,</span> <span class="token class-name">Pet</span><span class="token punctuation">.</span><span class="token keyword">class</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token class-name">Pet</span> tom02 <span class="token operator">=</span> run<span class="token punctuation">.</span><span class="token function">getBean</span><span class="token punctuation">(</span><span class="token string">"tom"</span><span class="token punctuation">,</span> <span class="token class-name">Pet</span><span class="token punctuation">.</span><span class="token keyword">class</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span>tom01 <span class="token operator">==</span> tom02<span class="token punctuation">)</span><span class="token punctuation">;</span><span class="token comment">//true</span>

        <span class="token class-name">MyConfig</span> bean <span class="token operator">=</span> run<span class="token punctuation">.</span><span class="token function">getBean</span><span class="token punctuation">(</span><span class="token class-name">MyConfig</span><span class="token punctuation">.</span><span class="token keyword">class</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token comment">//System.out.println(bean);//iceriver.boot.config.MyConfig$$EnhancerBySpringCGLIB$$2bce5da6@585ac855</span>
        <span class="token class-name">User</span> user <span class="token operator">=</span> bean<span class="token punctuation">.</span><span class="token function">user01</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token class-name">User</span> user1 <span class="token operator">=</span> bean<span class="token punctuation">.</span><span class="token function">user01</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span>user <span class="token operator">==</span> user1<span class="token punctuation">)</span><span class="token punctuation">;</span><span class="token comment">//true</span>
    <span class="token punctuation">}</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ol start="3">
<li><code v-pre>@Configuration(proxyBeanMethods = false)</code>时：
<ul>
<li>通过MainApplication.java主程序从容器获取组件是同一个对象</li>
<li>从配置类MyConfig.java的方法获取组件，不是同一个对象</li>
</ul>
</li>
</ol>
<blockquote>
<ul>
<li>⭐该配置为true时，解决了组件依赖问题：比如User类中有Pet类的对象，因为在创建User时，执行到创建Pet对象时，使用的是配置类调用方法创建Pet对象：
<ul>
<li>设置为true：跳过了调用方法创建Pet对象，直接在容器中调用，保证了User对象也是唯一的。</li>
<li>设置为false：调用方法创建Pet对象，由于Pet对象不一致，导致User对象不一致，创建User组件在容器中出现了两个</li>
</ul>
</li>
<li>最佳实战
<ul>
<li>配置类组件之间无依赖关系用Lite模式加速容器启动过程，减少判断，设置为false</li>
<li>配置类组件之间有依赖关系，方法会被调用得到之前单实例组件，用Full模式，设置为true</li>
</ul>
</li>
</ul>
</blockquote>
<h4 id="_2-1-2-bean" tabindex="-1"><a class="header-anchor" href="#_2-1-2-bean" aria-hidden="true">#</a> 2.1.2 <code v-pre>@Bean</code></h4>
<ol>
<li>给容器中添加组件，用在方法前，方法名为组件id，返回类型为组件类型，返回值为组件在容器中的实例。
<ul>
<li>可以使用如下的方式<code v-pre>@Bean(&quot;tom&quot;)</code>使用自定义名称（不以方法名作为组件名）
<ul>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1659539159608-81746c99-4266-411e-970e-841fb8fd5680.png#clientId=ueca4018c-2697-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=97&amp;id=ub6ffc95c&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=97&amp;originWidth=288&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=8177&amp;status=done&amp;style=none&amp;taskId=u24775b18-e062-4ff8-a896-557c6ba181b&amp;title=&amp;width=288" alt="image.png" loading="lazy"></li>
</ul>
</li>
</ul>
</li>
<li>通过MainApplication.java主程序从容器获取组件：
<ul>
<li>默认情况容器中的组件是单实例的</li>
</ul>
</li>
</ol>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token keyword">package</span> <span class="token namespace">iceriver<span class="token punctuation">.</span>boot<span class="token punctuation">.</span>config</span><span class="token punctuation">;</span>

<span class="token keyword">import</span> <span class="token import"><span class="token namespace">iceriver<span class="token punctuation">.</span>boot<span class="token punctuation">.</span>bean<span class="token punctuation">.</span></span><span class="token class-name">Pet</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">iceriver<span class="token punctuation">.</span>boot<span class="token punctuation">.</span>bean<span class="token punctuation">.</span></span><span class="token class-name">User</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">org<span class="token punctuation">.</span>springframework<span class="token punctuation">.</span>context<span class="token punctuation">.</span>annotation<span class="token punctuation">.</span></span><span class="token class-name">Bean</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">org<span class="token punctuation">.</span>springframework<span class="token punctuation">.</span>context<span class="token punctuation">.</span>annotation<span class="token punctuation">.</span></span><span class="token class-name">Configuration</span></span><span class="token punctuation">;</span>

<span class="token doc-comment comment">/**
 * <span class="token keyword">@author</span>: INFINITY https://developer.aliyun.com/profile/sagwrxp2ua66w
 * <span class="token keyword">@date</span>: 2022/8/3 23:00
 */</span>
<span class="token annotation punctuation">@Configuration</span>
<span class="token keyword">public</span> <span class="token keyword">class</span> <span class="token class-name">MyConfig</span> <span class="token punctuation">{</span>
    <span class="token annotation punctuation">@Bean</span>
    <span class="token keyword">public</span> <span class="token class-name">User</span> <span class="token function">user01</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">{</span>
        <span class="token keyword">return</span> <span class="token keyword">new</span> <span class="token class-name">User</span><span class="token punctuation">(</span><span class="token string">"张三"</span><span class="token punctuation">,</span> <span class="token number">18</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token punctuation">}</span>
    <span class="token annotation punctuation">@Bean</span><span class="token punctuation">(</span><span class="token string">"tom"</span><span class="token punctuation">)</span>
    <span class="token keyword">public</span> <span class="token class-name">Pet</span> <span class="token function">tomPet</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">{</span>
        <span class="token keyword">return</span> <span class="token keyword">new</span> <span class="token class-name">Pet</span><span class="token punctuation">(</span><span class="token string">"tom01"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token punctuation">}</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token keyword">package</span> <span class="token namespace">iceriver<span class="token punctuation">.</span>boot</span><span class="token punctuation">;</span>

<span class="token keyword">import</span> <span class="token import"><span class="token namespace">iceriver<span class="token punctuation">.</span>boot<span class="token punctuation">.</span>bean<span class="token punctuation">.</span></span><span class="token class-name">Pet</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">org<span class="token punctuation">.</span>springframework<span class="token punctuation">.</span>boot<span class="token punctuation">.</span></span><span class="token class-name">SpringApplication</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">org<span class="token punctuation">.</span>springframework<span class="token punctuation">.</span>boot<span class="token punctuation">.</span>autoconfigure<span class="token punctuation">.</span></span><span class="token class-name">SpringBootApplication</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">org<span class="token punctuation">.</span>springframework<span class="token punctuation">.</span>context<span class="token punctuation">.</span></span><span class="token class-name">ConfigurableApplicationContext</span></span><span class="token punctuation">;</span>

<span class="token doc-comment comment">/**
 * <span class="token keyword">@author</span>: INFINITY https://developer.aliyun.com/profile/sagwrxp2ua66w
 * <span class="token keyword">@date</span>: 2022/8/3 20:10
 */</span>
<span class="token comment">//@SpringBootApplication(scanBasePackages = "iceriver.boot")</span>
<span class="token annotation punctuation">@SpringBootApplication</span>
<span class="token keyword">public</span> <span class="token keyword">class</span> <span class="token class-name">MainApplication</span> <span class="token punctuation">{</span>
    <span class="token keyword">public</span> <span class="token keyword">static</span> <span class="token keyword">void</span> <span class="token function">main</span><span class="token punctuation">(</span><span class="token class-name">String</span><span class="token punctuation">[</span><span class="token punctuation">]</span> args<span class="token punctuation">)</span> <span class="token punctuation">{</span>
        <span class="token comment">//1、返回IOC容器</span>
        <span class="token class-name">ConfigurableApplicationContext</span> run <span class="token operator">=</span> <span class="token class-name">SpringApplication</span><span class="token punctuation">.</span><span class="token function">run</span><span class="token punctuation">(</span><span class="token class-name">MainApplication</span><span class="token punctuation">.</span><span class="token keyword">class</span><span class="token punctuation">,</span> args<span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token comment">//2、查看容器里面的组件</span>
        <span class="token class-name">String</span><span class="token punctuation">[</span><span class="token punctuation">]</span> names <span class="token operator">=</span> run<span class="token punctuation">.</span><span class="token function">getBeanDefinitionNames</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token keyword">for</span> <span class="token punctuation">(</span><span class="token class-name">String</span> name <span class="token operator">:</span> names<span class="token punctuation">)</span> <span class="token punctuation">{</span>
            <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span>name<span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token punctuation">}</span>
        <span class="token comment">//3、从容器获取组件</span>
        <span class="token class-name">Pet</span> tom01 <span class="token operator">=</span> run<span class="token punctuation">.</span><span class="token function">getBean</span><span class="token punctuation">(</span><span class="token string">"tom"</span><span class="token punctuation">,</span> <span class="token class-name">Pet</span><span class="token punctuation">.</span><span class="token keyword">class</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token class-name">Pet</span> tom02 <span class="token operator">=</span> run<span class="token punctuation">.</span><span class="token function">getBean</span><span class="token punctuation">(</span><span class="token string">"tom"</span><span class="token punctuation">,</span> <span class="token class-name">Pet</span><span class="token punctuation">.</span><span class="token keyword">class</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span>tom01 <span class="token operator">==</span> tom02<span class="token punctuation">)</span><span class="token punctuation">;</span><span class="token comment">//true</span>
    <span class="token punctuation">}</span>
<span class="token punctuation">}</span>

</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ol start="3">
<li>通过MainApplication.java主程序从容器获取配置类组件：
<ul>
<li>配置类是被EnhancerBySpringCGLIB增强了的代理类</li>
</ul>
</li>
</ol>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token keyword">package</span> <span class="token namespace">iceriver<span class="token punctuation">.</span>boot</span><span class="token punctuation">;</span>

<span class="token keyword">import</span> <span class="token import"><span class="token namespace">iceriver<span class="token punctuation">.</span>boot<span class="token punctuation">.</span>config<span class="token punctuation">.</span></span><span class="token class-name">MyConfig</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">org<span class="token punctuation">.</span>springframework<span class="token punctuation">.</span>boot<span class="token punctuation">.</span></span><span class="token class-name">SpringApplication</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">org<span class="token punctuation">.</span>springframework<span class="token punctuation">.</span>boot<span class="token punctuation">.</span>autoconfigure<span class="token punctuation">.</span></span><span class="token class-name">SpringBootApplication</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">org<span class="token punctuation">.</span>springframework<span class="token punctuation">.</span>context<span class="token punctuation">.</span></span><span class="token class-name">ConfigurableApplicationContext</span></span><span class="token punctuation">;</span>

<span class="token doc-comment comment">/**
 * <span class="token keyword">@author</span>: INFINITY https://developer.aliyun.com/profile/sagwrxp2ua66w
 * <span class="token keyword">@date</span>: 2022/8/3 20:10
 */</span>
<span class="token comment">//@SpringBootApplication(scanBasePackages = "iceriver.boot")</span>
<span class="token annotation punctuation">@SpringBootApplication</span>
<span class="token keyword">public</span> <span class="token keyword">class</span> <span class="token class-name">MainApplication</span> <span class="token punctuation">{</span>
    <span class="token keyword">public</span> <span class="token keyword">static</span> <span class="token keyword">void</span> <span class="token function">main</span><span class="token punctuation">(</span><span class="token class-name">String</span><span class="token punctuation">[</span><span class="token punctuation">]</span> args<span class="token punctuation">)</span> <span class="token punctuation">{</span>
        <span class="token comment">//1、返回IOC容器</span>
        <span class="token class-name">ConfigurableApplicationContext</span> run <span class="token operator">=</span> <span class="token class-name">SpringApplication</span><span class="token punctuation">.</span><span class="token function">run</span><span class="token punctuation">(</span><span class="token class-name">MainApplication</span><span class="token punctuation">.</span><span class="token keyword">class</span><span class="token punctuation">,</span> args<span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token comment">//2、查看容器里面的组件</span>
        <span class="token class-name">String</span><span class="token punctuation">[</span><span class="token punctuation">]</span> names <span class="token operator">=</span> run<span class="token punctuation">.</span><span class="token function">getBeanDefinitionNames</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token keyword">for</span> <span class="token punctuation">(</span><span class="token class-name">String</span> name <span class="token operator">:</span> names<span class="token punctuation">)</span> <span class="token punctuation">{</span>
            <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span>name<span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token punctuation">}</span>
        <span class="token comment">//3、从容器获取组件（配置类）</span>
        <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span>run<span class="token punctuation">.</span><span class="token function">getBean</span><span class="token punctuation">(</span><span class="token class-name">MyConfig</span><span class="token punctuation">.</span><span class="token keyword">class</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span><span class="token comment">//iceriver.boot.config.MyConfig$$EnhancerBySpringCGLIB$$2bce5da6@585ac855</span>
    <span class="token punctuation">}</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><h3 id="_2-2-第二组-component、-controller、-service、-repository" tabindex="-1"><a class="header-anchor" href="#_2-2-第二组-component、-controller、-service、-repository" aria-hidden="true">#</a> 2.2 第二组：<strong>@Component、@Controller、@Service、@Repository</strong></h3>
<p>【参见Spring5 2.3.1<a href="https://www.yuque.com/zhuyuqi/zna9x5/aze75g?view=doc_embed&amp;inner=Hz9sp" target="_blank" rel="noopener noreferrer">02.Spring5<ExternalLinkIcon/></a>】</p>
<h3 id="_2-3-第三组-componentscan" tabindex="-1"><a class="header-anchor" href="#_2-3-第三组-componentscan" aria-hidden="true">#</a> 2.3 第三组：@ComponentScan</h3>
<p>指定包扫描的路径，【参见2.3.4<a href="https://www.yuque.com/zhuyuqi/zna9x5/aze75g?view=doc_embed&amp;inner=ZiiVh" target="_blank" rel="noopener noreferrer">02.Spring5<ExternalLinkIcon/></a>】</p>
<h3 id="_2-4-第四组-import" tabindex="-1"><a class="header-anchor" href="#_2-4-第四组-import" aria-hidden="true">#</a> 2.4 第四组：@Import</h3>
<ol>
<li>可以用在任何组件上，配合任何组件注解使用。</li>
<li>导入任意指定类型的组件：
<ul>
<li><code v-pre>@Import({User.class, DBHelper.class})</code></li>
<li>给容器中自动创建出这两个类型的组件、默认组件的名字就是全类名（调用其无参构造器创建）</li>
</ul>
</li>
</ol>
<h3 id="_2-5-第五组-conditional" tabindex="-1"><a class="header-anchor" href="#_2-5-第五组-conditional" aria-hidden="true">#</a> 2.5 第五组：@Conditional</h3>
<ul>
<li>条件装配：满足指定条件，则进行注入</li>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1659570580195-7c8edf1e-1f88-4308-8c01-bac28861e04e.png#clientId=ueca4018c-2697-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=403&amp;id=u950ba11b&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=403&amp;originWidth=560&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=107290&amp;status=done&amp;style=none&amp;taskId=u03212679-667c-43f9-ab55-5d0a266a3b9&amp;title=&amp;width=560" alt="image.png" loading="lazy"></li>
<li>可以用在方法前，表示满足该条件，则对该方法进行bea注入</li>
<li>可以用在类前，表示满足该条件，才对该类中的方法进行ben注入。</li>
</ul>
<h3 id="_2-6-第六组-importsource" tabindex="-1"><a class="header-anchor" href="#_2-6-第六组-importsource" aria-hidden="true">#</a> 2.6 第六组：@ImportSource</h3>
<ul>
<li>导入原生xml配置文件，将该配置文件的bean加入到容器中</li>
</ul>
<h3 id="_2-7-第七组-绑定配置文件" tabindex="-1"><a class="header-anchor" href="#_2-7-第七组-绑定配置文件" aria-hidden="true">#</a> 2.7 第七组：绑定配置文件</h3>
<blockquote>
<ul>
<li>场景：某个javabean的初始值写在了application.properties中，如何在创建该组件时，赋默认值。
<ul>
<li>前置准备：application.properties中要设置值的属性使用mycar作为属性前缀</li>
</ul>
</li>
</ul>
</blockquote>
<h4 id="_2-7-1-configurationproperties" tabindex="-1"><a class="header-anchor" href="#_2-7-1-configurationproperties" aria-hidden="true">#</a> 2.7.1 @<strong>ConfigurationProperties</strong></h4>
<ul>
<li>用在JavaBean前，从配置文件读取属性初始化值。</li>
<li>将JavaBean属性的值写在配置文件中，通过spring boot读取properties配置文件，并把它封装到JavaBean中。</li>
<li><code v-pre>@ConfigurationProperties(prefix = &quot;mycar&quot;)</code>
<ul>
<li>需要与@Component配合使用，将JavaBean通过@Component声明为组件。</li>
<li>或者不使用@Component，在MyConfig.java中使用@Bean创建组件，方法返回无参构造对象</li>
</ul>
</li>
</ul>
<h4 id="_2-7-2-enableconfigurationproperties-configurationproperties" tabindex="-1"><a class="header-anchor" href="#_2-7-2-enableconfigurationproperties-configurationproperties" aria-hidden="true">#</a> 2.7.2 @EnableConfigurationProperties +@ConfigurationProperties</h4>
<ul>
<li>对于无法对JavaBean使用@Component的组件（如别人的JavaBean），在MyConfig.java配置类前使用@EnableConfigurationProperties(Car.Class）
<ul>
<li>作用1：开启Car的配置绑定功能</li>
<li>作用2：将Car这个组件自动注册到容器中</li>
</ul>
</li>
</ul>
<h3 id="_2-8-第八组-springbootapplication" tabindex="-1"><a class="header-anchor" href="#_2-8-第八组-springbootapplication" aria-hidden="true">#</a> 2.8 第八组：@SpringBootApplication</h3>
<h4 id="_2-8-0-介绍" tabindex="-1"><a class="header-anchor" href="#_2-8-0-介绍" aria-hidden="true">#</a> 2.8.0 介绍</h4>
<ul>
<li>将某个类指定为主程序类/主配置类。他自动扫描的路径是同级的其他路径，同下@ComponentScan(&quot;iceriver.boot&quot;)</li>
<li>它是三个组件的合成：
<ul>
<li>@SpringBootConfiguration</li>
<li>@EnableAutoConfiguration</li>
<li>@ComponentScan(&quot;iceriver.boot&quot;)</li>
</ul>
</li>
</ul>
<h4 id="_2-8-1-springbootconfiguration" tabindex="-1"><a class="header-anchor" href="#_2-8-1-springbootconfiguration" aria-hidden="true">#</a> 2.8.1 @SpringBootConfiguration</h4>
<ul>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1659573580275-d1397602-e88f-4145-89dd-e954c7d2d1d8.png#clientId=ueca4018c-2697-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=152&amp;id=ua2ab3daa&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=152&amp;originWidth=350&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=18060&amp;status=done&amp;style=none&amp;taskId=uc0bc00b3-c221-4e6d-95f1-7cc421b779a&amp;title=&amp;width=350" alt="image.png" loading="lazy"></li>
<li>代表当前是一个配置类。</li>
</ul>
<h4 id="_2-8-2-enableautoconfiguration" tabindex="-1"><a class="header-anchor" href="#_2-8-2-enableautoconfiguration" aria-hidden="true">#</a> 2.8.2 @EnableAutoConfiguration</h4>
<ul>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1659573684734-104f5890-9f5d-48e3-be8a-88b67de6cfb6.png#clientId=ueca4018c-2697-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=170&amp;id=ua865a607&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=170&amp;originWidth=384&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=24149&amp;status=done&amp;style=none&amp;taskId=ud78dabde-6cfe-4483-bfaa-c6b7df8e5cf&amp;title=&amp;width=384" alt="image.png" loading="lazy"></li>
<li>@AutoConfigurationPackage：导入主程序类所在位置的包下一系列组件</li>
<li>@Import(AutoConfigurationImportSelector.class)：导入META-INF/spring.factories位置的文件中配置的组件（共127个，加载时全部加载，但使用时由于使用了@ConditionalOnClass注解，可以实现按需配置，用户导入相关的场景启动器后才会激活该注解）</li>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1659575985672-64029f1d-bd7c-4b7a-adaf-92f97973414e.png#clientId=ueca4018c-2697-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=2049&amp;id=u69b0abd8&amp;margin=[object Object]&amp;name=null.png&amp;originHeight=2049&amp;originWidth=2901&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=1413182&amp;status=done&amp;style=none&amp;taskId=udd7aaded-f2de-4664-aa6a-b6c4c78c5a9&amp;title=&amp;width=2901" alt="null.png" loading="lazy"></li>
</ul>
<h4 id="_2-8-3-componentscan-iceriver-boot" tabindex="-1"><a class="header-anchor" href="#_2-8-3-componentscan-iceriver-boot" aria-hidden="true">#</a> 2.8.3 @ComponentScan(&quot;iceriver.boot&quot;)</h4>
<ul>
<li>组件扫描</li>
</ul>
<h2 id="第3章-spring-boot的自动配置" tabindex="-1"><a class="header-anchor" href="#第3章-spring-boot的自动配置" aria-hidden="true">#</a> 第3章 Spring Boot的自动配置</h2>
<h3 id="_3-1-自动配置实现" tabindex="-1"><a class="header-anchor" href="#_3-1-自动配置实现" aria-hidden="true">#</a> 3.1  自动配置实现</h3>
<blockquote>
<ul>
<li>基于1.3.1（<a href="#bAIMR">https://www.yuque.com/zhuyuqi/zna9x5/gs0vv5#bAIMR</a>）创建的spring boot2项目进行分析</li>
</ul>
</blockquote>
<h4 id="_3-1-1-依赖配置" tabindex="-1"><a class="header-anchor" href="#_3-1-1-依赖配置" aria-hidden="true">#</a> 3.1.1 依赖配置</h4>
<ol>
<li>用户项目使用了spring-boot-starter-parent作为父项目进行依赖管理。</li>
<li>spring-boot-starter-parent使用了spring-boot-dependencies作为父项目进行依赖管理。而spring-boot-dependencies中声明了几乎开发中常用的依赖版本号——自动仲裁机制。</li>
<li>依赖中spring-boot-starter-*称为场景启动器，是一组整合好的方便的依赖描述符。只要引入starter，满足该场景的常规依赖都会自动引入。
<ul>
<li>
<p>spring-boot-starter-web底层基础依赖是spring-boot-starter，是所有场景启动最底层的依赖。</p>
</li>
<li>
<p>*-spring-boot-starter： 第三方提供的简化开发的场景启动器。</p>
</li>
<li></li>
</ul>
</li>
</ol>
<h4 id="_3-1-2-自动配置内容" tabindex="-1"><a class="header-anchor" href="#_3-1-2-自动配置内容" aria-hidden="true">#</a> 3.1.2 自动配置内容</h4>
<ol>
<li>自动配置好tomcat
<ul>
<li>spring-boot-starter-web场景启动器引入了tomcat场景启动器</li>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1659536723829-e88cffd4-aae6-4349-8599-6950fcfc21c9.png#clientId=ueca4018c-2697-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=203&amp;id=uotoU&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=203&amp;originWidth=518&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=32810&amp;status=done&amp;style=none&amp;taskId=ub60ae096-6b09-497d-9215-03219441db0&amp;title=&amp;width=518" alt="image.png" loading="lazy"></li>
</ul>
</li>
<li>自动配置好SpringMVC
<ul>
<li>spring-boot-starter-web场景启动器引入了springmvc场景启动器</li>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1659536904354-26b3e34c-9df5-41e8-9aa8-dfa2a9adfb7f.png#clientId=ueca4018c-2697-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=116&amp;id=d730P&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=116&amp;originWidth=462&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=19114&amp;status=done&amp;style=none&amp;taskId=u50f4c69d-ad0a-4f73-a9df-20028ac00d6&amp;title=&amp;width=462" alt="image.png" loading="lazy"></li>
</ul>
</li>
<li>自动配置好了springmvc的常用组件（依赖）
<ul>
<li>配置好了SpringMVC DispatcherServlet以及其他依赖，如jdbc、日志、字符编码等。</li>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1659537156799-579065b9-6900-4766-bc51-4e5dc0002711.png#clientId=ueca4018c-2697-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=294&amp;id=STy2J&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=294&amp;originWidth=777&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=38455&amp;status=done&amp;style=none&amp;taskId=ub25bf47a-1dd3-4193-8ad0-1b1ab8602a0&amp;title=&amp;width=777" alt="image.png" loading="lazy"></li>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1659537273679-3313950d-0315-472f-bf6a-16d1bf05f529.png#clientId=ueca4018c-2697-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=656&amp;id=E5GrE&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=656&amp;originWidth=1038&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=109788&amp;status=done&amp;style=none&amp;taskId=uefa058df-d0e9-4194-881f-e7e183ffa29&amp;title=&amp;width=1038" alt="image.png" loading="lazy"></li>
</ul>
</li>
<li>创建了默认的包结构：
<ul>
<li>官方文档2.1节，说明了使用默认的包结构，会自动进行包扫描，而不需要手动设置</li>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1659537525244-15b0b1d4-ac55-43b1-b382-2cce3da17a40.png#clientId=ueca4018c-2697-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=304&amp;id=hMIeB&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=304&amp;originWidth=394&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=18133&amp;status=done&amp;style=none&amp;taskId=ued1579ac-dac0-45f5-9695-5267ad23133&amp;title=&amp;width=394" alt="image.png" loading="lazy"></li>
<li>当然可以通过<code v-pre>@SpringBootApplication(scanBasePackages = &quot;iceriver.boot&quot;)</code>扫描指定包
<ul>
<li>或者使用<code v-pre>@ComponentScan(scanBasePackages = &quot;iceriver.boot&quot;)</code>、<code v-pre>@EnableAutoConfiguration</code>、<code v-pre>@SpringBootConfiguration</code>三个代替</li>
</ul>
</li>
</ul>
</li>
<li>各种配置拥有默认值。如文件上传设定了最大上传大小
<ul>
<li>默认配置最终都是映射到某个类上，如：MultipartProperties</li>
<li>修改配置时，<code v-pre>application.properties</code>配置文件的值最终会绑定每个类上，这个类会在容器中创建对象</li>
</ul>
</li>
<li>按需加载所有自动配置项
<ul>
<li>springBoot所有的自动配置功能都在 spring-boot-autoconfigure 包里面</li>
<li>引入了哪些场景这个场景的自动配置才会开启</li>
</ul>
</li>
</ol>
<h3 id="_3-2-自动配置原理" tabindex="-1"><a class="header-anchor" href="#_3-2-自动配置原理" aria-hidden="true">#</a> 3.2 自动配置原理</h3>
<p>【参见第2.8<a href="#uvJdT">https://www.yuque.com/zhuyuqi/zna9x5/gs0vv5#uvJdT</a>】</p>
<h3 id="_3-2-自动配置流程" tabindex="-1"><a class="header-anchor" href="#_3-2-自动配置流程" aria-hidden="true">#</a> 3.2 自动配置流程</h3>
<ol>
<li>SpringBoot先加载所有的自动配置类 xxxxxAutoConfiguration</li>
<li>每个自动配置类按照条件进行生效，默认都会绑定配置文件指定的值。xxxxProperties里面拿。xxxProperties和配置文件进行了绑定</li>
<li>生效的配置类就会给容器中装配很多组件</li>
<li>只要容器中有这些组件，相当于这些功能就有了</li>
<li>定制化配置
<ul>
<li>用户直接自己@Bean替换底层的组件</li>
<li>用户去看这个组件是获取的配置文件什么值就去修改。</li>
</ul>
</li>
<li><strong>xxxxxAutoConfiguration ---&gt; 组件 ---&gt; xxxxProperties里面拿值 ----&gt; application.properties</strong></li>
</ol>
<h3 id="_3-4-【心得】spring-boot开发最佳实践流程" tabindex="-1"><a class="header-anchor" href="#_3-4-【心得】spring-boot开发最佳实践流程" aria-hidden="true">#</a> 3.4 【心得】spring boot开发最佳实践流程</h3>
<ol>
<li>
<h2 id="引入场景依赖-场景启动器" tabindex="-1"><a class="header-anchor" href="#引入场景依赖-场景启动器" aria-hidden="true">#</a> 引入场景依赖（场景启动器）</h2>
</li>
<li>
<p>查看自动配置了哪些（选做）</p>
<ul>
<li>自己分析，引入场景对应的自动配置一般都生效了</li>
<li>application.properties核心配置文件中debug=true开启自动配置报告。在控制台输出中查看：Negative（不生效）\Positive（生效）</li>
</ul>
</li>
<li>
<p>是否需要修改</p>
</li>
</ol>
<ul>
<li>
<p>参照文档修改配置项
-</p>
<pre><code>- 自己分析。xxxxProperties绑定了配置文件的哪些。
</code></pre>
<ul>
<li>自定义加入或者替换组件
<ul>
<li>@Bean、@Component。。。</li>
</ul>
</li>
<li>自定义器 <strong>XXXXXCustomizer</strong>；</li>
</ul>
</li>
</ul>
<h2 id="第4章-开发小技巧" tabindex="-1"><a class="header-anchor" href="#第4章-开发小技巧" aria-hidden="true">#</a> 第4章 开发小技巧</h2>
<h3 id="_4-1-lombok" tabindex="-1"><a class="header-anchor" href="#_4-1-lombok" aria-hidden="true">#</a> 4.1 Lombok</h3>
<ol>
<li>简化JavaBean开发</li>
<li>pom.xml中引入lombok</li>
</ol>
<div class="language-xml ext-xml line-numbers-mode"><pre v-pre class="language-xml"><code><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>dependency</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>groupId</span><span class="token punctuation">></span></span>org.projectlombok<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>groupId</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>artifactId</span><span class="token punctuation">></span></span>lombok<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>artifactId</span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>dependency</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ol start="3">
<li>安装Lombok插件
<ul>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1659578930815-05184769-d4f1-4f39-b5e8-3a3b04ac6942.png#clientId=ueca4018c-2697-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=107&amp;id=u7561308d&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=107&amp;originWidth=291&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=7957&amp;status=done&amp;style=none&amp;taskId=u891c3249-e6c4-40a8-8de8-143fa329bbc&amp;title=&amp;width=291" alt="image.png" loading="lazy"></li>
</ul>
</li>
<li>使用：
<ul>
<li>JavaBean只编写属性，不写getter和setter</li>
<li>JavaBean前使用@Data注解，会在编译时生成getter和setter</li>
<li>javabean前使用@ToString，会在编译时自动生成toString()</li>
<li>JavaBean前使用@AllArgsConstructor注解，会在编译时生成全部参数的有参构造器</li>
<li>JavaBean前使用@NoArgsConstructor注解，会在编译时生成无参构造器</li>
<li>JavaBean前使用@EqualsAndHashCode注解，会在编译时生成equals()和hashcode()</li>
<li>JavaBean前使用@Slf4j注解，可以在代码中使用<code v-pre>log.info(&quot;str&quot;)</code>语法在控制台输出内容</li>
</ul>
</li>
</ol>
<h3 id="_4-2-dev-tools" tabindex="-1"><a class="header-anchor" href="#_4-2-dev-tools" aria-hidden="true">#</a> 4.2 Dev-tools</h3>
<ol>
<li>重启restart功能：
<ul>
<li>热更新reload需要收费</li>
</ul>
</li>
<li>引入依赖</li>
</ol>
<div class="language-xml ext-xml line-numbers-mode"><pre v-pre class="language-xml"><code><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>dependency</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>groupId</span><span class="token punctuation">></span></span>org.springframework.boot<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>groupId</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>artifactId</span><span class="token punctuation">></span></span>spring-boot-devtools<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>artifactId</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>optional</span><span class="token punctuation">></span></span>true<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>optional</span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>dependency</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ol start="3">
<li>使用：ctrl+f9</li>
<li>本质：和idea重启效果一样</li>
</ol>
<h2 id="第5章-spring-boot2核心技术-功能" tabindex="-1"><a class="header-anchor" href="#第5章-spring-boot2核心技术-功能" aria-hidden="true">#</a> 第5章 Spring Boot2核心技术（功能）</h2>
<h3 id="_5-1-配置文件" tabindex="-1"><a class="header-anchor" href="#_5-1-配置文件" aria-hidden="true">#</a> 5.1 配置文件</h3>
<h4 id="_5-1-1-application-properties" tabindex="-1"><a class="header-anchor" href="#_5-1-1-application-properties" aria-hidden="true">#</a> 5.1.1 application.properties</h4>
<p>同时配置了<code v-pre>.properties</code>和<code v-pre>.yml</code>，两个文件会同时生效，里面的内容<code v-pre>.properties</code>会覆盖<code v-pre>.yml</code></p>
<h4 id="_5-1-2-application-yml" tabindex="-1"><a class="header-anchor" href="#_5-1-2-application-yml" aria-hidden="true">#</a> 5.1.2 application.yml</h4>
<ol>
<li>简介：YAML 是 &quot;YAML Ain't Markup Language&quot;（YAML 不是一种标记语言）的递归缩写。在开发的这种语言时，YAML 的意思其实是：&quot;Yet Another Markup Language&quot;（仍是一种标记语言）。</li>
<li>基本语法：
<ul>
<li>key: value；kv之间有空格</li>
<li>大小写敏感</li>
<li>使用缩进表示层级关系</li>
<li>缩进不允许使用tab，只允许空格</li>
<li>缩进的空格数不重要，只要相同层级的元素左对齐即可</li>
<li>'#'表示注释</li>
<li>字符串无需加引号，如果要加，<code v-pre>''</code>与<code v-pre>&quot;&quot;</code>表示字符串内容会原样输出字符串/将转义字符转换</li>
</ul>
</li>
<li>数据类型
<ul>
<li>字面量（k: v）：单个的、不可再分的值。date、boolean、string、number、null</li>
<li>对象：键值对的集合。map、hash、set、object</li>
</ul>
</li>
</ol>
<div class="language-yaml ext-yml line-numbers-mode"><pre v-pre class="language-yaml"><code><span class="token comment">#方式一：</span>
<span class="token key atrule">k</span><span class="token punctuation">:</span> <span class="token punctuation">{</span>k1<span class="token punctuation">:</span>v1<span class="token punctuation">,</span>k2<span class="token punctuation">:</span>v2<span class="token punctuation">,</span>k3<span class="token punctuation">:</span>v3<span class="token punctuation">}</span>
<span class="token comment">#方式二：</span>
<span class="token key atrule">k</span><span class="token punctuation">:</span> 
 <span class="token key atrule">k1</span><span class="token punctuation">:</span> v1
  <span class="token key atrule">k2</span><span class="token punctuation">:</span> v2
  <span class="token key atrule">k3</span><span class="token punctuation">:</span> v3
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ul>
<li>数组：一组按次序排列的值。array、list、queue</li>
</ul>
<div class="language-yaml ext-yml line-numbers-mode"><pre v-pre class="language-yaml"><code><span class="token comment">#方式一：</span>
<span class="token key atrule">k</span><span class="token punctuation">:</span> <span class="token punctuation">[</span>v1<span class="token punctuation">,</span>v2<span class="token punctuation">,</span>v3<span class="token punctuation">]</span>
<span class="token comment">#方式二：</span>
<span class="token key atrule">k</span><span class="token punctuation">:</span>
 <span class="token punctuation">-</span> v1
 <span class="token punctuation">-</span> v2
 <span class="token punctuation">-</span> v3
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><h4 id="_5-1-3-配置提示" tabindex="-1"><a class="header-anchor" href="#_5-1-3-配置提示" aria-hidden="true">#</a> 5.1.3 配置提示</h4>
<ol>
<li>给自定义的类和配置文件添加输入提示</li>
<li>引入依赖</li>
</ol>
<div class="language-xml ext-xml line-numbers-mode"><pre v-pre class="language-xml"><code><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>dependency</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>groupId</span><span class="token punctuation">></span></span>org.springframework.boot<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>groupId</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>artifactId</span><span class="token punctuation">></span></span>spring-boot-configuration-processor<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>artifactId</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>optional</span><span class="token punctuation">></span></span>true<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>optional</span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>dependency</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ol start="3">
<li>打包时排除，减少资源占用（对开发没有影响）</li>
</ol>
<div class="language-xml ext-xml line-numbers-mode"><pre v-pre class="language-xml"><code><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>build</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>plugins</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>plugin</span><span class="token punctuation">></span></span>
      <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>groupId</span><span class="token punctuation">></span></span>org.springframework.boot<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>groupId</span><span class="token punctuation">></span></span>
      <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>artifactId</span><span class="token punctuation">></span></span>spring-boot-maven-plugin<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>artifactId</span><span class="token punctuation">></span></span>
      <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>configuration</span><span class="token punctuation">></span></span>
        <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>excludes</span><span class="token punctuation">></span></span>
          <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>exclude</span><span class="token punctuation">></span></span>
            <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>groupId</span><span class="token punctuation">></span></span>org.springframework.boot<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>groupId</span><span class="token punctuation">></span></span>
            <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>artifactId</span><span class="token punctuation">></span></span>spring-boot-configuration-processor<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>artifactId</span><span class="token punctuation">></span></span>
          <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>exclude</span><span class="token punctuation">></span></span>
        <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>excludes</span><span class="token punctuation">></span></span>
      <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>configuration</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>plugin</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>plugins</span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>build</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><h3 id="_5-2-web开发" tabindex="-1"><a class="header-anchor" href="#_5-2-web开发" aria-hidden="true">#</a> 5.2 web开发</h3>
<h4 id="_5-2-1-创建web项目" tabindex="-1"><a class="header-anchor" href="#_5-2-1-创建web项目" aria-hidden="true">#</a> 5.2.1 创建web项目</h4>
<p><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1659587063329-fcb4cbd5-815f-46e8-a1c7-ab15a607f8f5.png#clientId=ueca4018c-2697-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=625&amp;id=u5e48a358&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=625&amp;originWidth=721&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=54587&amp;status=done&amp;style=none&amp;taskId=u2a8e89ab-498a-41ed-bf0a-3446ea3ce79&amp;title=&amp;width=721" alt="image.png" loading="lazy">
<img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1659587168311-e30b2303-404a-49a3-873b-8d73b20e3249.png#clientId=ueca4018c-2697-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=625&amp;id=u69309c6f&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=625&amp;originWidth=721&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=56046&amp;status=done&amp;style=none&amp;taskId=ubf016553-660b-44d3-a67a-9d693c3d55b&amp;title=&amp;width=721" alt="image.png" loading="lazy"></p>
<h4 id="_5-2-2-静态资源访问" tabindex="-1"><a class="header-anchor" href="#_5-2-2-静态资源访问" aria-hidden="true">#</a> 5.2.2 静态资源访问</h4>
<ol>
<li>在resources路径下：静态资源放在/static (or /public or /resources or /META-INF/resources路径下，则可以直接通过当前项目更路径/+静态资源名的方式访问到。
<ul>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1659590434315-ee426e4d-6e40-48ca-9547-721b23244398.png#clientId=ueca4018c-2697-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=136&amp;id=u95a194a8&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=136&amp;originWidth=182&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=4216&amp;status=done&amp;style=none&amp;taskId=udc73e311-f04e-463c-9c3e-47158ed8362&amp;title=&amp;width=182" alt="image.png" loading="lazy"></li>
<li>原理：浏览器地址栏的请求首先经过spring mvc的dispatcherServlet处理，如果控制器controller中有对应的请求方法，则按该方法处理。如果没有对应的请求方法，则被servlet默认的控制器处理，直接去访问静态资源。</li>
</ul>
</li>
<li>修改静态资源访问前缀
<ul>
<li>控制器中设定的拦截请求为<code v-pre>/**</code>所有请求，这样会导致静态资源的访问和控制器处理的请求都被拦截。</li>
<li>开发中一般希望将静态资源内的访问、和控制器处理前端请求分离开，所以一般会在核心配置文件中间通过<code v-pre>spring.mvc.static-path-pattern=/resources/**</code>给静态资源的访问增加前缀（resources可以设定为其他名字）</li>
<li>此时访问地址形式为：当前项目路径+resources+静态资源名</li>
</ul>
</li>
<li>修改静态资源的路径（自定义静态资源路径）
<ul>
<li>在核心配置文件中通过<code v-pre>spring.resources.static-locations=[class:/hh/]</code>进行配置</li>
<li>访问时，地址形式为当前项目路径+修改后的静态资源访问前缀+静态资源名【访问路径没变化，变的只是静态资源的位置】</li>
</ul>
</li>
<li>访问webjar
<ul>
<li>webjar是人们把前端的js文件等制作成了spring依赖，引入相关依赖后，可以通过：当前项目路径+webjas+前端资源名进行访问</li>
<li><a href="https://www.webjars.org/" target="_blank" rel="noopener noreferrer">https://www.webjars.org/<ExternalLinkIcon/></a></li>
<li>原理其实和上面一致，前端的静态资源存放路径也遵循上面个规则</li>
</ul>
</li>
<li>欢迎页（index.html页面）
<ul>
<li>把index.html当作静态资源，放在相关路径下即可解析为首页，访问当前项目路径即可作为欢迎页。
<ul>
<li>注意：静态资源访问前缀会影响访问地址，访问时需要加上访问前缀</li>
</ul>
</li>
<li>也可以通过控制器编写index方法，路径用<code v-pre>/</code>，映射到index页面</li>
</ul>
</li>
<li>自定义Favicon
<ul>
<li>放到静态资源路径下，起名为<code v-pre>favicon.ico</code>，则每个页面都会带上小图标
<ul>
<li>注意：静态资源访问前缀会影响，访问带有访问前缀的的页面才会显示。</li>
</ul>
</li>
<li>小图标保存在session中共享</li>
</ul>
</li>
</ol>
<h4 id="_5-2-3-静态资源配置原理" tabindex="-1"><a class="header-anchor" href="#_5-2-3-静态资源配置原理" aria-hidden="true">#</a> 5.2.3 静态资源配置原理</h4>
<ol>
<li>spring boot启动时，加载的springmvc的自动配置类WebMvcAutoConfiguration生效。</li>
<li>【第25集，没看下去】</li>
</ol>
<h3 id="_5-3-请求处理" tabindex="-1"><a class="header-anchor" href="#_5-3-请求处理" aria-hidden="true">#</a> 5.3 请求处理</h3>
<ol>
<li>请求映射（restful风格）：spring boot启动时WebMvcAutoConfiguration自动配置了OrderedHiddenHttpMethodFilter类，OrderedHiddenHttpMethodFilter类继承自HiddenHttpMethodFilter，从而能够处理restful风格的请求。
<ul>
<li>但默认情况下，spring.mvc.hiddenmethod.filter值是false，即使设置了隐藏域，但也发送的是post请求。</li>
<li>只有在核心配置文件中将spring.mvc.hiddenmethod.filter=true后，才可以正常发送put、delete请求。
<ul>
<li>这个配置只针对于form表单使用</li>
<li>对于postman等这些能直接发送put、delete请求的不用配置</li>
</ul>
</li>
<li>自定义请求方法时，在配置类中重新定义（此时隐藏域的name属性要设置为<code v-pre>_m</code>：
<ul>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1659597076037-9ea67033-f66a-464a-a59b-a97aea421cbe.png#clientId=ueca4018c-2697-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=291&amp;id=u25cb348d&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=291&amp;originWidth=996&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=144529&amp;status=done&amp;style=none&amp;taskId=u731b672d-f615-4a57-9da2-0d227baa38a&amp;title=&amp;width=996" alt="image.png" loading="lazy"></li>
</ul>
</li>
</ul>
</li>
<li>请求映射处理原理（怎么知道是哪种请求）：
<ul>
<li>【参见SpringMVC10.3<a href="https://www.yuque.com/zhuyuqi/zna9x5/zh889g?view=doc_embed&amp;inner=d0PTI" target="_blank" rel="noopener noreferrer">03.Spring MVC<ExternalLinkIcon/></a>】</li>
<li>servlet处理请求的方法是doService()，doService()经过一大堆封装、重写之后变成了DispatcherServlet的doDispatcher()，该方法中调用了getHandler()得到所有handlermappings，去看哪个handlerMapping能处理得到的请求
<ul>
<li><img src="https://cdn.nlark.com/yuque/0/2020/png/1354552/1603181460034-ba25f3c0-9cfd-4432-8949-3d1dd88d8b12.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_14%2Ctext_YXRndWlndS5jb20g5bCa56GF6LC3%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10#crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=url&amp;id=zO0uv&amp;margin=[object Object]&amp;originHeight=217&amp;originWidth=501&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;status=done&amp;style=none&amp;title=" alt="" loading="lazy"></li>
<li><strong>RequestMappingHandlerMapping</strong>：保存了所有@RequestMapping 和handler的映射规则。</li>
<li>WelcomePageHandlerMapping：是springBoot自动配置的，处理index页面（欢迎页）的请求，默认配置好了。</li>
</ul>
</li>
<li>自定义HandlerMapping【没讲】</li>
</ul>
</li>
<li>注解：
<ul>
<li>请求映射注解：
<ul>
<li><code v-pre>@RequestMapping</code>【参见sprignmc2.1节】<a href="https://www.yuque.com/zhuyuqi/zna9x5/zh889g?view=doc_embed&amp;inner=aHUfW" target="_blank" rel="noopener noreferrer">03.Spring MVC<ExternalLinkIcon/></a></li>
<li><code v-pre>@GetMapping</code>、<code v-pre>@PostMapping</code>、<code v-pre>@PutMapping</code>、<code v-pre>@DeleteMapping</code>【参见sprignmc2.1节】<a href="https://www.yuque.com/zhuyuqi/zna9x5/zh889g?view=doc_embed&amp;inner=aHUfW" target="_blank" rel="noopener noreferrer">03.Spring MVC<ExternalLinkIcon/></a></li>
</ul>
</li>
<li>请求传参注解：
<ul>
<li>@PathVariable：路径占位符，将请求路径解析为参数（restful请求）<a href="https://www.yuque.com/zhuyuqi/zna9x5/zh889g?view=doc_embed&amp;inner=XwOqk" target="_blank" rel="noopener noreferrer">03.Spring MVC<ExternalLinkIcon/></a></li>
<li>@RequestHeader：<a href="https://www.yuque.com/zhuyuqi/zna9x5/zh889g?view=doc_embed&amp;inner=Oz9xP" target="_blank" rel="noopener noreferrer">03.Spring MVC<ExternalLinkIcon/></a></li>
<li>@ModelAttribute</li>
<li>@RequestParam：<a href="https://www.yuque.com/zhuyuqi/zna9x5/zh889g?view=doc_embed&amp;inner=JYwbf" target="_blank" rel="noopener noreferrer">03.Spring MVC<ExternalLinkIcon/></a></li>
<li>@MatrixVariable：矩阵变量
<ul>
<li>请求参数以分号分割，如<code v-pre>/cars/{low=34;brand=byd,audi}</code></li>
<li>springBoot默认仅用了矩阵变量，需要在核心配置文件中手动开启：</li>
<li>urlpathhelper需要单独写一章</li>
</ul>
</li>
<li>@CookieValue：<a href="https://www.yuque.com/zhuyuqi/zna9x5/zh889g?view=doc_embed&amp;inner=SFGlQ" target="_blank" rel="noopener noreferrer">03.Spring MVC<ExternalLinkIcon/></a></li>
<li>@RequestBody：<a href="https://www.yuque.com/zhuyuqi/zna9x5/zh889g?view=doc_embed&amp;inner=MrfxD" target="_blank" rel="noopener noreferrer">03.Spring MVC<ExternalLinkIcon/></a></li>
<li>@RequestAttribute：从请求域获取参数</li>
</ul>
</li>
</ul>
</li>
</ol>
</div></template>
