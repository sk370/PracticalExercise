<template><div><h1 id="java语言基础-下" tabindex="-1"><a class="header-anchor" href="#java语言基础-下" aria-hidden="true">#</a> Java语言基础（下）</h1>
<h2 id="第14章-jdbc和数据库连接池" tabindex="-1"><a class="header-anchor" href="#第14章-jdbc和数据库连接池" aria-hidden="true">#</a> 第14章 JDBC和数据库连接池</h2>
<blockquote>
<ul>
<li>要求：学习了Mysql（sql语句）之后</li>
</ul>
</blockquote>
<h3 id="_14-1-jdbc概述" tabindex="-1"><a class="header-anchor" href="#_14-1-jdbc概述" aria-hidden="true">#</a> 14.1 JDBC概述</h3>
<h4 id="_14-1-1-jdbc基本介绍" tabindex="-1"><a class="header-anchor" href="#_14-1-1-jdbc基本介绍" aria-hidden="true">#</a> 14.1.1 JDBC基本介绍</h4>
<ol>
<li>含义：Java DataBase Connectivity，Java数据库连接，用于执行SQL语句的JavaAPI，由类和接口组成，提供了个可以构建更高级工具和接口去访问数据库的基准。</li>
<li>作用：java程序员使用JDBC，可以连接任何提供了JDBC驱动程序的数据库系统，从而完成对数据库的各种操作。JDBC为访问不同的数据库提供了统一的接口，为使用者屏蔽了细节问题。</li>
<li>基本原理图：
<ul>
<li><img src="/images/javase/java-3/1555575941569.png" alt="1555575941569.png" loading="lazy"></li>
</ul>
</li>
<li>模拟JDBC接口</li>
</ol>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token keyword">public</span> <span class="token keyword">interface</span> <span class="token class-name">JdbcInterface</span> <span class="token punctuation">{</span>
    <span class="token comment">//连接</span>
    <span class="token keyword">public</span> <span class="token class-name">Object</span> <span class="token function">getConnection</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">;</span>
    <span class="token comment">//crud</span>
    <span class="token keyword">public</span> <span class="token keyword">void</span> <span class="token function">crud</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token comment">//关闭连接</span>
    <span class="token keyword">public</span> <span class="token keyword">void</span> <span class="token function">close</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
<span class="token punctuation">}</span>

</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token keyword">public</span> <span class="token keyword">class</span> <span class="token class-name">MysqlJdbcImpl</span> <span class="token keyword">implements</span>  <span class="token class-name">JdbcInterface</span><span class="token punctuation">{</span>
    <span class="token annotation punctuation">@Override</span>
    <span class="token keyword">public</span> <span class="token class-name">Object</span> <span class="token function">getConnection</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
        <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span><span class="token string">"得到 mysql 的连接"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token keyword">return</span> <span class="token keyword">null</span><span class="token punctuation">;</span>
    <span class="token punctuation">}</span>

    <span class="token annotation punctuation">@Override</span>
    <span class="token keyword">public</span> <span class="token keyword">void</span> <span class="token function">crud</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
        <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span><span class="token string">"完成 mysql 增删改查"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token punctuation">}</span>

    <span class="token annotation punctuation">@Override</span>
    <span class="token keyword">public</span> <span class="token keyword">void</span> <span class="token function">close</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
        <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span><span class="token string">"关闭 mysql 的连接"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token punctuation">}</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><h4 id="_14-1-2-jdbc-api" tabindex="-1"><a class="header-anchor" href="#_14-1-2-jdbc-api" aria-hidden="true">#</a> 14.1.2 JDBC API</h4>
<p>![JDBC API.jpeg](/images/javase/java-3/JDBC API.jpeg)</p>
<ul>
<li><img src="/images/javase/java-3/image.png" alt="image.png" loading="lazy"><img src="/images/javase/java-3/image-1660813495995.png" alt="image.png" loading="lazy"></li>
<li><img src="/images/javase/java-3/image-1660813502282.png" alt="image.png" loading="lazy"><img src="/images/javase/java-3/image-1660813505362.png" alt="image.png" loading="lazy"></li>
</ul>
<h4 id="_14-1-3-mysqljdbc" tabindex="-1"><a class="header-anchor" href="#_14-1-3-mysqljdbc" aria-hidden="true">#</a> 14.1.3 MySQLJDBC</h4>
<ol>
<li>版本支持：
<ul>
<li><img src="/images/javase/java-3/image-1660813508433.png" alt="image.png" loading="lazy"></li>
</ul>
</li>
<li>下载地址：
<ul>
<li><img src="/images/javase/java-3/image-1660813510303.png" alt="image.png" loading="lazy"></li>
<li><img src="/images/javase/java-3/image-1660813517697.png" alt="image.png" loading="lazy"></li>
</ul>
</li>
</ol>
<h4 id="_14-1-3-jdbc程序编写步骤" tabindex="-1"><a class="header-anchor" href="#_14-1-3-jdbc程序编写步骤" aria-hidden="true">#</a> 14.1.3 JDBC程序编写步骤</h4>
<blockquote>
<ul>
<li>前置工作：在项目文件目录中加载对应数据库的JDBC工具包</li>
<li><img src="/images/javase/java-3/image-1660813520667.png" alt="image.png" loading="lazy"><img src="/images/javase/java-3/image-1660813523872.png" alt="image.png" loading="lazy"></li>
</ul>
</blockquote>
<ol>
<li>注册驱动——加载Driver类
<ul>
<li>有异常问题</li>
</ul>
</li>
<li>获取连接——得到Connection</li>
<li>执行CRUD——发送sql语句（字符串）给mysql执行</li>
<li>释放资源——关闭相关连接</li>
</ol>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token comment">//1. 注册驱动——加载Driver类</span>
<span class="token class-name">Driver</span> driver <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name"><span class="token namespace">com<span class="token punctuation">.</span>mysql<span class="token punctuation">.</span>jdbc<span class="token punctuation">.</span></span>Driver</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
<span class="token comment">//2. 获取连接——得到Connection</span>
<span class="token class-name">String</span> url <span class="token operator">=</span> <span class="token string">"jdbc:mysql://localhost:13306/db01"</span><span class="token punctuation">;</span>

<span class="token class-name">Properties</span> properties <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">Properties</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
properties<span class="token punctuation">.</span><span class="token function">setProperty</span><span class="token punctuation">(</span><span class="token string">"user"</span><span class="token punctuation">,</span><span class="token string">"root"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
properties<span class="token punctuation">.</span><span class="token function">setProperty</span><span class="token punctuation">(</span><span class="token string">"password"</span><span class="token punctuation">,</span><span class="token string">"dimitre123"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>

<span class="token class-name">Connection</span> connect <span class="token operator">=</span> driver<span class="token punctuation">.</span><span class="token function">connect</span><span class="token punctuation">(</span>url<span class="token punctuation">,</span> properties<span class="token punctuation">)</span><span class="token punctuation">;</span>
<span class="token comment">//3. 执行CRUD——发送sql语句（字符串）给mysql执行</span>
<span class="token class-name">String</span> sql <span class="token operator">=</span> <span class="token string">"crud的SQL语句"</span><span class="token punctuation">;</span>
<span class="token comment">//3.1 statement对象用于向数据库发送sql语句</span>
<span class="token class-name">Statement</span> statement <span class="token operator">=</span> connect<span class="token punctuation">.</span><span class="token function">createStatement</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
<span class="token keyword">int</span> rows <span class="token operator">=</span> statement<span class="token punctuation">.</span><span class="token function">executeUpdate</span><span class="token punctuation">(</span>sql<span class="token punctuation">)</span><span class="token punctuation">;</span>
<span class="token comment">//4. 释放资源——关闭相关连接</span>
statement<span class="token punctuation">.</span><span class="token function">close</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
connect<span class="token punctuation">.</span><span class="token function">close</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><div class="custom-container danger"><p class="custom-container-title">警告</p>
<ul>
<li>解读：
<ul>
<li>url：
<ul>
<li><code v-pre>jdbc:mysql</code>：使用的连接协议</li>
<li><code v-pre>localhost</code>：连接地址（数据库地址）</li>
<li><code v-pre>13306</code>：数据库端口号</li>
<li><code v-pre>db01</code>：数据库名称</li>
<li>mysql连接的本质是socket连接</li>
</ul>
</li>
<li>properties对象：
<ul>
<li><code v-pre>setProperty()</code>的<code v-pre>user</code>、<code v-pre>password</code>是规定好的</li>
</ul>
</li>
<li><code v-pre>excuteUpdate(sql)</code>：dml语句时，返回的是影响的行数。
:::</li>
</ul>
</li>
</ul>
<h3 id="_14-2-获取数据库连接-connection-的5种方式" tabindex="-1"><a class="header-anchor" href="#_14-2-获取数据库连接-connection-的5种方式" aria-hidden="true">#</a> 14.2 获取数据库连接（connection）的5种方式</h3>
<h4 id="_14-2-1-使用driver类的connect-方法" tabindex="-1"><a class="header-anchor" href="#_14-2-1-使用driver类的connect-方法" aria-hidden="true">#</a> 14.2.1 使用Driver类的<code v-pre>connect()</code>方法</h4>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token comment">//1. 注册驱动——加载Driver类</span>
<span class="token class-name">Driver</span> driver <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name"><span class="token namespace">com<span class="token punctuation">.</span>mysql<span class="token punctuation">.</span>jdbc<span class="token punctuation">.</span></span>Driver</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
<span class="token comment">//2. 获取连接——得到Connection</span>
<span class="token class-name">String</span> url <span class="token operator">=</span> <span class="token string">"jdbc:mysql://localhost:13306/db01"</span><span class="token punctuation">;</span>

<span class="token class-name">Properties</span> properties <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">Properties</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
properties<span class="token punctuation">.</span><span class="token function">setProperty</span><span class="token punctuation">(</span><span class="token string">"user"</span><span class="token punctuation">,</span><span class="token string">"root"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
properties<span class="token punctuation">.</span><span class="token function">setProperty</span><span class="token punctuation">(</span><span class="token string">"password"</span><span class="token punctuation">,</span><span class="token string">"dimitre123"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>

<span class="token class-name">Connection</span> connect <span class="token operator">=</span> driver<span class="token punctuation">.</span><span class="token function">connect</span><span class="token punctuation">(</span>url<span class="token punctuation">,</span> properties<span class="token punctuation">)</span><span class="token punctuation">;</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ul>
<li>存在问题：Driver()是第三方工具，依赖强、灵活性差，且属于静态加载。</li>
</ul>
<h4 id="_14-2-2-使用反射获取driver-再使用connect-方法" tabindex="-1"><a class="header-anchor" href="#_14-2-2-使用反射获取driver-再使用connect-方法" aria-hidden="true">#</a> 14.2.2 使用反射获取Driver，再使用<code v-pre>connect()</code>方法</h4>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token comment">//1. 注册驱动——加载Driver类</span>
<span class="token class-name">Class</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token operator">?</span><span class="token punctuation">></span></span> aClass <span class="token operator">=</span> <span class="token class-name">Class</span><span class="token punctuation">.</span><span class="token function">forName</span><span class="token punctuation">(</span><span class="token string">"com.mysql.jdbc.Driver"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
<span class="token class-name">Driver</span> driver <span class="token operator">=</span> <span class="token punctuation">(</span><span class="token class-name">Driver</span><span class="token punctuation">)</span>aClass<span class="token punctuation">.</span><span class="token function">newInstance</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
<span class="token comment">//2. 获取连接——得到Connection</span>
<span class="token class-name">String</span> url <span class="token operator">=</span> <span class="token string">"jdbc:mysql://localhost:13306/db01"</span><span class="token punctuation">;</span>

<span class="token class-name">Properties</span> properties <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">Properties</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
properties<span class="token punctuation">.</span><span class="token function">setProperty</span><span class="token punctuation">(</span><span class="token string">"user"</span><span class="token punctuation">,</span><span class="token string">"root"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
properties<span class="token punctuation">.</span><span class="token function">setProperty</span><span class="token punctuation">(</span><span class="token string">"password"</span><span class="token punctuation">,</span><span class="token string">"dimitre123"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>

<span class="token class-name">Connection</span> connect <span class="token operator">=</span> driver<span class="token punctuation">.</span><span class="token function">connect</span><span class="token punctuation">(</span>url<span class="token punctuation">,</span> properties<span class="token punctuation">)</span><span class="token punctuation">;</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ul>
<li>好处：动态加载，减少依赖性，更加灵活。</li>
</ul>
<h4 id="_14-2-3-使用drivermanager注册驱动" tabindex="-1"><a class="header-anchor" href="#_14-2-3-使用drivermanager注册驱动" aria-hidden="true">#</a> 14.2.3 使用DriverManager注册驱动</h4>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token comment">//1. 注册驱动——加载Driver类</span>
<span class="token class-name">Class</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token operator">?</span><span class="token punctuation">></span></span> aClass <span class="token operator">=</span> <span class="token class-name">Class</span><span class="token punctuation">.</span><span class="token function">forName</span><span class="token punctuation">(</span><span class="token string">"com.mysql.jdbc.Driver"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
<span class="token class-name">Driver</span> driver <span class="token operator">=</span> <span class="token punctuation">(</span><span class="token class-name">Driver</span><span class="token punctuation">)</span>aClass<span class="token punctuation">.</span><span class="token function">newInstance</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
<span class="token comment">//2. 获取连接——得到Connection</span>
<span class="token class-name">String</span> url <span class="token operator">=</span> <span class="token string">"jdbc:mysql://localhost:13306/db01"</span><span class="token punctuation">;</span>

<span class="token class-name">Properties</span> properties <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">Properties</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
properties<span class="token punctuation">.</span><span class="token function">setProperty</span><span class="token punctuation">(</span><span class="token string">"user"</span><span class="token punctuation">,</span><span class="token string">"root"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
properties<span class="token punctuation">.</span><span class="token function">setProperty</span><span class="token punctuation">(</span><span class="token string">"password"</span><span class="token punctuation">,</span><span class="token string">"dimitre123"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>

<span class="token class-name">DriverManager</span><span class="token punctuation">.</span><span class="token function">registerDriver</span><span class="token punctuation">(</span>driver<span class="token punctuation">)</span><span class="token punctuation">;</span><span class="token comment">//注册Driver驱动</span>

<span class="token class-name">Connection</span> connection <span class="token operator">=</span> <span class="token class-name">DriverManager</span><span class="token punctuation">.</span><span class="token function">getConnection</span><span class="token punctuation">(</span>url<span class="token punctuation">,</span> properties<span class="token punctuation">)</span><span class="token punctuation">;</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><h4 id="_14-2-4-class-forname-自动完成注册驱动-简化代码" tabindex="-1"><a class="header-anchor" href="#_14-2-4-class-forname-自动完成注册驱动-简化代码" aria-hidden="true">#</a> 14.2.4 Class.forName 自动完成注册驱动，简化代码</h4>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token comment">//1. 注册驱动——加载Driver类</span>
<span class="token class-name">Class</span><span class="token punctuation">.</span><span class="token function">forName</span><span class="token punctuation">(</span><span class="token string">"com.mysql.jdbc.Driver"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
<span class="token comment">//2. 获取连接——得到Connection</span>
<span class="token class-name">String</span> url <span class="token operator">=</span> <span class="token string">"jdbc:mysql://localhost:13306/db01"</span><span class="token punctuation">;</span>

<span class="token class-name">Properties</span> properties <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">Properties</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
properties<span class="token punctuation">.</span><span class="token function">setProperty</span><span class="token punctuation">(</span><span class="token string">"user"</span><span class="token punctuation">,</span><span class="token string">"root"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
properties<span class="token punctuation">.</span><span class="token function">setProperty</span><span class="token punctuation">(</span><span class="token string">"password"</span><span class="token punctuation">,</span><span class="token string">"dimitre123"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>

<span class="token class-name">Connection</span> connection <span class="token operator">=</span> <span class="token class-name">DriverManager</span><span class="token punctuation">.</span><span class="token function">getConnection</span><span class="token punctuation">(</span>url<span class="token punctuation">,</span> properties<span class="token punctuation">)</span><span class="token punctuation">;</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ul>
<li>mysql实现java.sql的Driver接口时，创建了静态代码块，自动执行<code v-pre>DriverManager.registerDriver(new Driver());</code></li>
<li>不写<code v-pre>Class.forName(&quot;com.mysql.jdbc.Driver&quot;);</code>也会正常运行，是因为jdk1.5之后使用了jdbc4，会自动调用<code v-pre>……\libs\mysql-connector-java-5.1.37-bin.jar!\META-INF\services\java.sql.Driver</code>文件中的类名（<code v-pre>com.mysql.jdbc.Driver</code>）去注册</li>
</ul>
<h4 id="_14-2-5-使用配置文件读取连接地址等信息" tabindex="-1"><a class="header-anchor" href="#_14-2-5-使用配置文件读取连接地址等信息" aria-hidden="true">#</a> 14.2.5 使用配置文件读取连接地址等信息</h4>
<div class="language-properties ext-properties line-numbers-mode"><pre v-pre class="language-properties"><code><span class="token key attr-name">user</span><span class="token punctuation">=</span><span class="token value attr-value">root</span>
<span class="token key attr-name">password</span><span class="token punctuation">=</span><span class="token value attr-value">dimitre123</span>
<span class="token key attr-name">url</span><span class="token punctuation">=</span><span class="token value attr-value">jdbc:mysql://localhost:13306/hsp_db02</span>
<span class="token key attr-name">driver</span><span class="token punctuation">=</span><span class="token value attr-value">com.mysql.jdbc.Driver</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token class-name">Properties</span> properties <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">Properties</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
properties<span class="token punctuation">.</span><span class="token function">load</span><span class="token punctuation">(</span><span class="token keyword">new</span> <span class="token class-name">FileInputStream</span><span class="token punctuation">(</span><span class="token string">"src\\mysql.properties"</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>

<span class="token class-name">String</span> user <span class="token operator">=</span> properties<span class="token punctuation">.</span><span class="token function">getProperty</span><span class="token punctuation">(</span><span class="token string">"user"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
<span class="token class-name">String</span> password <span class="token operator">=</span> properties<span class="token punctuation">.</span><span class="token function">getProperty</span><span class="token punctuation">(</span><span class="token string">"password"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
<span class="token class-name">String</span> driver <span class="token operator">=</span> properties<span class="token punctuation">.</span><span class="token function">getProperty</span><span class="token punctuation">(</span><span class="token string">"driver"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
<span class="token class-name">String</span> url <span class="token operator">=</span> properties<span class="token punctuation">.</span><span class="token function">getProperty</span><span class="token punctuation">(</span><span class="token string">"url"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
<span class="token comment">//1. 注册驱动——加载Driver类</span>
<span class="token class-name">Class</span><span class="token punctuation">.</span><span class="token function">forName</span><span class="token punctuation">(</span>driver<span class="token punctuation">)</span><span class="token punctuation">;</span>

<span class="token comment">//2. 获取连接——得到Connection</span>
<span class="token class-name">Connection</span> connection <span class="token operator">=</span> <span class="token class-name">DriverManager</span><span class="token punctuation">.</span><span class="token function">getConnection</span><span class="token punctuation">(</span>url<span class="token punctuation">,</span> user<span class="token punctuation">,</span>password<span class="token punctuation">)</span><span class="token punctuation">;</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><h3 id="_14-3-结果集-resultset" tabindex="-1"><a class="header-anchor" href="#_14-3-结果集-resultset" aria-hidden="true">#</a> 14.3 结果集（ResultSet）</h3>
<ol>
<li>含义：执行查DQL语句返回的查询结果。</li>
<li>ResultSet对象保持一个光标指向其当前的数据行，最初光标位于第一行之前，next方法将光标移动到下一行，并且由于再ResultSet对象中没有更多行时返回false。可以使用while循环遍历。</li>
<li>使用：<code v-pre>ReultSet resultSet = statement.excuteQuery(sql);</code>
<ul>
<li>关闭结果集：<code v-pre>resultSet.close();</code></li>
</ul>
</li>
<li>方法：</li>
<li>底层：ResultSet是个接口，底层的数据是表是一个ArrayList
<ul>
<li><img src="/images/javase/java-3/image-1660813543071.png" alt="image.png" loading="lazy"></li>
</ul>
</li>
</ol>
<h3 id="_14-4-sql注入" tabindex="-1"><a class="header-anchor" href="#_14-4-sql注入" aria-hidden="true">#</a> 14.4 SQL注入</h3>
<ol>
<li>含义：利用某些系统没有对用户输入的数据进行充分的检查，而在用户输入数据中注入非法的SQL语句段或命令，恶意攻击数据库。</li>
<li>访问数据库、执行sql语句的三种方法：
<ul>
<li><code v-pre>Statement</code>对象【存在sql注入问题】</li>
<li><code v-pre>PreparedStatement</code>对象【预处理】</li>
<li><code v-pre>CallableStatement</code>对象【存储过程】</li>
</ul>
</li>
<li>万能用户名：<code v-pre>1' or</code>，万能密码：<code v-pre>or '1'='1'</code></li>
</ol>
<h3 id="_14-5-preparedstatement预处理的使用" tabindex="-1"><a class="header-anchor" href="#_14-5-preparedstatement预处理的使用" aria-hidden="true">#</a> 14.5 PreparedStatement预处理的使用</h3>
<ol>
<li>PreparedStatement是Statement的子接口，可以使用Statement的方法（怎么使用的，Statement的方法都是抽象的，是因为加载了JDBCjar包的原因吗？）
<ul>
<li><img src="/images/javase/java-3/image-1660813545901.png" alt="image.png" loading="lazy"></li>
</ul>
</li>
<li>语法变化：
<ul>
<li>书写sql语句（定义sql字符串）：使用<code v-pre>?</code>代替参数值，作为占位符。
<ul>
<li><code v-pre>String sql = &quot;select name , pwd from admin where name =? and pwd = ?&quot;;</code></li>
</ul>
</li>
<li>创建PreparedStatement对象：<code v-pre>PreparedStatement preparedStatement = connection.prepareStatement(sql);</code>
<ul>
<li>Statement此时不需要传入sql语句</li>
</ul>
</li>
<li>使用PreparedStatement的对象给sql语句的占位符赋值：使用<code v-pre>setXxx(int n, String str)</code>
<ul>
<li>n表示<code v-pre>?</code>在sql语句中从左至右出现的次序，从1开始。</li>
<li>str表示参数值。</li>
</ul>
</li>
<li>调用<code v-pre>excuteUpade()</code>或<code v-pre>excuteQuery()</code>方法，返回结果集。不需要再传入sql语句当作参数。</li>
</ul>
</li>
<li>预处理好处：
<ul>
<li>不再使用<code v-pre>+</code>拼接sql语句，减少了语法错误。</li>
<li>有效避免了sql注入问题</li>
<li>减少了编译次数，提高了效率</li>
</ul>
</li>
</ol>
<h3 id="_14-6-jdbc事务" tabindex="-1"><a class="header-anchor" href="#_14-6-jdbc事务" aria-hidden="true">#</a> 14.6 JDBC事务</h3>
<h4 id="_14-6-1-jdbc事务介绍" tabindex="-1"><a class="header-anchor" href="#_14-6-1-jdbc事务介绍" aria-hidden="true">#</a> 14.6.1 JDBC事务介绍</h4>
<ol>
<li>JDBC创建一个Connection对象后，默认是自动提交事务，执行成功后不能回滚。</li>
<li>调用Connetcion对象的<code v-pre>setAutoCommit(false)</code>可以取消自动提交事务。</li>
<li>调用Connetcion对象的<code v-pre>commit()</code>可以提交事务。</li>
<li>调用Connetcion对象的<code v-pre>rollback()</code>可以回滚事务。</li>
</ol>
<h4 id="_14-6-2-应用场景" tabindex="-1"><a class="header-anchor" href="#_14-6-2-应用场景" aria-hidden="true">#</a> 14.6.2 应用场景</h4>
<ol>
<li>银行转账。</li>
</ol>
<h3 id="_14-7-批处理-batch" tabindex="-1"><a class="header-anchor" href="#_14-7-批处理-batch" aria-hidden="true">#</a> 14.7 批处理（batch）</h3>
<h4 id="_14-7-1-批处理介绍" tabindex="-1"><a class="header-anchor" href="#_14-7-1-批处理介绍" aria-hidden="true">#</a> 14.7.1 批处理介绍</h4>
<ol>
<li>java的批量更新机制允许多条语句一次性提交给数据库处理，提高处理效率。相当于公交车拉一车人。</li>
<li>批处理方法（statement对象调用）：
<ul>
<li><code v-pre>addBatch()</code>：添加需要批处理的SQL语句或参数</li>
<li><code v-pre>excuteBatch()</code>：执行批处理语句</li>
<li><code v-pre>clearBatch()</code>：清空批处理包的语句</li>
</ul>
</li>
<li>使用：
<ul>
<li>url添加参数<code v-pre>?rewriteBatchedStatements=true</code></li>
</ul>
</li>
</ol>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token class-name">Connection</span> connection <span class="token operator">=</span> <span class="token class-name">JDBCUtils</span><span class="token punctuation">.</span><span class="token function">getConnection</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
<span class="token class-name">String</span> sql <span class="token operator">=</span> <span class="token string">"insert into admin2 values(null, ?, ?)"</span><span class="token punctuation">;</span>
<span class="token class-name">PreparedStatement</span> preparedStatement <span class="token operator">=</span> connection<span class="token punctuation">.</span><span class="token function">prepareStatement</span><span class="token punctuation">(</span>sql<span class="token punctuation">)</span><span class="token punctuation">;</span>
<span class="token keyword">for</span> <span class="token punctuation">(</span><span class="token keyword">int</span> i <span class="token operator">=</span> <span class="token number">0</span><span class="token punctuation">;</span> i <span class="token operator">&lt;</span> <span class="token number">5000</span><span class="token punctuation">;</span> i<span class="token operator">++</span><span class="token punctuation">)</span> <span class="token punctuation">{</span><span class="token comment">//5000执行</span>
    preparedStatement<span class="token punctuation">.</span><span class="token function">setString</span><span class="token punctuation">(</span><span class="token number">1</span><span class="token punctuation">,</span> <span class="token string">"jack"</span> <span class="token operator">+</span> i<span class="token punctuation">)</span><span class="token punctuation">;</span>
    preparedStatement<span class="token punctuation">.</span><span class="token function">setString</span><span class="token punctuation">(</span><span class="token number">2</span><span class="token punctuation">,</span> <span class="token string">"666"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
    preparedStatement<span class="token punctuation">.</span><span class="token function">addBatch</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token keyword">if</span><span class="token punctuation">(</span><span class="token punctuation">(</span>i <span class="token operator">+</span> <span class="token number">1</span><span class="token punctuation">)</span> <span class="token operator">%</span> <span class="token number">1000</span> <span class="token operator">==</span> <span class="token number">0</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
        preparedStatement<span class="token punctuation">.</span><span class="token function">executeBatch</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        preparedStatement<span class="token punctuation">.</span><span class="token function">clearBatch</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token punctuation">}</span>
<span class="token punctuation">}</span>
preparedStatement<span class="token punctuation">.</span><span class="token function">executeBatch</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span><span class="token comment">//避免没到1000条的数据存在遗漏</span>
<span class="token class-name">JDBCUtils</span><span class="token punctuation">.</span><span class="token function">close</span><span class="token punctuation">(</span><span class="token keyword">null</span><span class="token punctuation">,</span> preparedStatement<span class="token punctuation">,</span> connection<span class="token punctuation">)</span><span class="token punctuation">;</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ol start="4">
<li>源码分析：
<ul>
<li>执行<code v-pre>addBatch()</code>会创建 ArrayList - elementData =&gt; Object[]</li>
<li>elementData =&gt; Object[] 就会存放我们预处理的sql语句</li>
<li>当elementData满后,就按照1.5扩容</li>
<li>当添加到指定的值后，就executeBatch批量处理会减少我们发送sql语句的网络开销，而且减少编译次数，因此效率提高</li>
</ul>
</li>
</ol>
<h3 id="_14-8-数据库连接池" tabindex="-1"><a class="header-anchor" href="#_14-8-数据库连接池" aria-hidden="true">#</a> 14.8 数据库连接池</h3>
<h4 id="_14-8-1-传统方式连接数据库的问题" tabindex="-1"><a class="header-anchor" href="#_14-8-1-传统方式连接数据库的问题" aria-hidden="true">#</a> 14.8.1 传统方式连接数据库的问题</h4>
<ol>
<li>传统JDBC连接数据库使用DriverManager来获取，每次向数据库简历连接时，需要将Connection加载到内存中，再验证ip地址、用户名、密码（0.05~1s时间），频繁进行数据库连接操作会占用系统资源，导致服务器崩溃。</li>
<li>每次连接数据库操作后，使用结束都应断开，如果程序出现异常而未关闭，将导致数据库内存泄漏，导致数据库重启</li>
<li>传统连接方式，不能控制创建的连接数量，如果连接过多，也可能导致内存泄漏，mysql崩溃</li>
<li>使用数据库连接池（connection pool）技术，可以解决上述问题。</li>
</ol>
<h4 id="_14-8-2-数据库连接池介绍" tabindex="-1"><a class="header-anchor" href="#_14-8-2-数据库连接池介绍" aria-hidden="true">#</a> 14.8.2 数据库连接池介绍</h4>
<ol>
<li>预先再缓冲池中放入一定数量的连接，当需要建立数据库连接时，只需从“缓冲池”取出连接，使用完毕后放回到“缓冲池”</li>
<li>数据库连接池负责分配、管理、释放数据库的连接，它允许用用程序重复使用一个现有的数据库连接，而不用重新建立。</li>
<li>当应用程序向连接池请求的连接数量超过最大连接数量时，这些请求会被加入到等待队列中。</li>
<li>JDBC的数据库连接池使用<code v-pre>javax.sql.DataSource</code>表示，DataSource是一个接口，该接口由第三方提供实现【提供.jar】</li>
<li>数据库连接池种类：
<ul>
<li>C3P0：速度较慢，稳定性好</li>
<li>DBCP：速度较快，但不稳定</li>
<li>Proxool：有监控连接池状态的功能，稳定性不如C3P0</li>
<li>BoneCP：速度快</li>
<li>Druid（德鲁伊）：阿里提供，具有DBCP、C3P0、Proxool优点</li>
</ul>
</li>
</ol>
<h4 id="_14-8-3-c3p0使用" tabindex="-1"><a class="header-anchor" href="#_14-8-3-c3p0使用" aria-hidden="true">#</a> 14.8.3 C3P0使用</h4>
<ol>
<li>将c3p0的jar包添加到开发环境，同jdbc。</li>
<li>连接方式一：</li>
</ol>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token comment">//1. 创建一个数据源对象</span>
<span class="token class-name">ComboPooledDataSource</span> comboPooledDataSource <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">ComboPooledDataSource</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
<span class="token comment">//2. 通过配置文件mysql.properties 获取相关连接的信息</span>
<span class="token class-name">Properties</span> properties <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">Properties</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
properties<span class="token punctuation">.</span><span class="token function">load</span><span class="token punctuation">(</span><span class="token keyword">new</span> <span class="token class-name">FileInputStream</span><span class="token punctuation">(</span><span class="token string">"src\\mysql.properties"</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
<span class="token class-name">String</span> user <span class="token operator">=</span> properties<span class="token punctuation">.</span><span class="token function">getProperty</span><span class="token punctuation">(</span><span class="token string">"user"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
<span class="token class-name">String</span> password <span class="token operator">=</span> properties<span class="token punctuation">.</span><span class="token function">getProperty</span><span class="token punctuation">(</span><span class="token string">"password"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
<span class="token class-name">String</span> url <span class="token operator">=</span> properties<span class="token punctuation">.</span><span class="token function">getProperty</span><span class="token punctuation">(</span><span class="token string">"url"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
<span class="token class-name">String</span> driver <span class="token operator">=</span> properties<span class="token punctuation">.</span><span class="token function">getProperty</span><span class="token punctuation">(</span><span class="token string">"driver"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>

<span class="token comment">//给数据源 comboPooledDataSource 设置相关的参数</span>
comboPooledDataSource<span class="token punctuation">.</span><span class="token function">setDriverClass</span><span class="token punctuation">(</span>driver<span class="token punctuation">)</span><span class="token punctuation">;</span>
comboPooledDataSource<span class="token punctuation">.</span><span class="token function">setJdbcUrl</span><span class="token punctuation">(</span>url<span class="token punctuation">)</span><span class="token punctuation">;</span>
comboPooledDataSource<span class="token punctuation">.</span><span class="token function">setUser</span><span class="token punctuation">(</span>user<span class="token punctuation">)</span><span class="token punctuation">;</span>
comboPooledDataSource<span class="token punctuation">.</span><span class="token function">setPassword</span><span class="token punctuation">(</span>password<span class="token punctuation">)</span><span class="token punctuation">;</span>

<span class="token comment">//设置初始化连接数</span>
comboPooledDataSource<span class="token punctuation">.</span><span class="token function">setInitialPoolSize</span><span class="token punctuation">(</span><span class="token number">10</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
<span class="token comment">//最大连接数</span>
comboPooledDataSource<span class="token punctuation">.</span><span class="token function">setMaxPoolSize</span><span class="token punctuation">(</span><span class="token number">50</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
<span class="token comment">//测试连接池的效率, 测试对mysql 5000次操作</span>
<span class="token keyword">for</span> <span class="token punctuation">(</span><span class="token keyword">int</span> i <span class="token operator">=</span> <span class="token number">0</span><span class="token punctuation">;</span> i <span class="token operator">&lt;</span> <span class="token number">5000</span><span class="token punctuation">;</span> i<span class="token operator">++</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
    <span class="token class-name">Connection</span> connection <span class="token operator">=</span> comboPooledDataSource<span class="token punctuation">.</span><span class="token function">getConnection</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span> 
    connection<span class="token punctuation">.</span><span class="token function">close</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ol start="3">
<li>连接方式二：使用c3p0的配置文件（整合了登录名、用户密码、连接地址、设置了连接数量等），放到src路径下</li>
</ol>
<div class="language-xml ext-xml line-numbers-mode"><pre v-pre class="language-xml"><code><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>c3p0-config</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>named-config</span> <span class="token attr-name">name</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>hello<span class="token punctuation">"</span></span><span class="token punctuation">></span></span> <span class="token comment">&lt;!-- 数据源名称，可以任意 --></span>
    <span class="token comment">&lt;!-- 驱动类，跟数据库相关 --></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>property</span> <span class="token attr-name">name</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>driverClass<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>com.mysql.jdbc.Driver<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>property</span><span class="token punctuation">></span></span>
    <span class="token comment">&lt;!-- url--></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>property</span> <span class="token attr-name">name</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>jdbcUrl<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>jdbc:mysql://127.0.0.1:3306/girls<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>property</span><span class="token punctuation">></span></span>
    <span class="token comment">&lt;!-- 用户名 --></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>property</span> <span class="token attr-name">name</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>user<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>root<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>property</span><span class="token punctuation">></span></span>
    <span class="token comment">&lt;!-- 密码 --></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>property</span> <span class="token attr-name">name</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>password<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>root<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>property</span><span class="token punctuation">></span></span>
    <span class="token comment">&lt;!-- 每次增长的连接数--></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>property</span> <span class="token attr-name">name</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>acquireIncrement<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>5<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>property</span><span class="token punctuation">></span></span>
    <span class="token comment">&lt;!-- 初始的连接数 --></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>property</span> <span class="token attr-name">name</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>initialPoolSize<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>10<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>property</span><span class="token punctuation">></span></span>
    <span class="token comment">&lt;!-- 最小连接数 --></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>property</span> <span class="token attr-name">name</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>minPoolSize<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>5<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>property</span><span class="token punctuation">></span></span>
    <span class="token comment">&lt;!-- 最大连接数 --></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>property</span> <span class="token attr-name">name</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>maxPoolSize<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>10<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>property</span><span class="token punctuation">></span></span>
    <span class="token comment">&lt;!-- 可连接的最多的命令对象数 --></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>property</span> <span class="token attr-name">name</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>maxStatements<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>5<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>property</span><span class="token punctuation">></span></span> 
    <span class="token comment">&lt;!-- 每个连接对象可连接的最多的命令对象数 --></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>property</span> <span class="token attr-name">name</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>maxStatementsPerConnection<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>2<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>property</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>named-config</span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>c3p0-config</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code>
<span class="token class-name">ComboPooledDataSource</span> comboPooledDataSource <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">ComboPooledDataSource</span><span class="token punctuation">(</span><span class="token string">"hello"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
<span class="token comment">//测试5000次连接mysql</span>
<span class="token keyword">for</span> <span class="token punctuation">(</span><span class="token keyword">int</span> i <span class="token operator">=</span> <span class="token number">0</span><span class="token punctuation">;</span> i <span class="token operator">&lt;</span> <span class="token number">500000</span><span class="token punctuation">;</span> i<span class="token operator">++</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
    <span class="token class-name">Connection</span> connection <span class="token operator">=</span> comboPooledDataSource<span class="token punctuation">.</span><span class="token function">getConnection</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
    connection<span class="token punctuation">.</span><span class="token function">close</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><h4 id="_14-8-4-druid使用" tabindex="-1"><a class="header-anchor" href="#_14-8-4-druid使用" aria-hidden="true">#</a> 14.8.4 Druid使用</h4>
<p><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1656325855512-4881c7ae-2b44-4ffd-a2e1-6ee955c962b1.png#clientId=uaf046232-8b05-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=54&amp;id=u3c51dba8&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=54&amp;originWidth=635&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=8940&amp;status=done&amp;style=none&amp;taskId=u1a983deb-461c-4d31-bbd6-0c7b64ba3e7&amp;title=&amp;width=635" alt="image.png" loading="lazy"></p>
<ol>
<li>将Druid的jar包添加到开发环境，同jdbc。</li>
</ol>
<div class="language-properties ext-properties line-numbers-mode"><pre v-pre class="language-properties"><code><span class="token comment">#key=value</span>
<span class="token key attr-name">driverClassName</span><span class="token punctuation">=</span><span class="token value attr-value">com.mysql.jdbc.Driver</span>
<span class="token key attr-name">url</span><span class="token punctuation">=</span><span class="token value attr-value">jdbc:mysql://localhost:3306/girls?rewriteBatchedStatements=true</span>
<span class="token comment">#url=jdbc:mysql://localhost:3306/girls</span>
<span class="token key attr-name">username</span><span class="token punctuation">=</span><span class="token value attr-value">root</span>
<span class="token key attr-name">password</span><span class="token punctuation">=</span><span class="token value attr-value">root</span>
<span class="token comment">#initial connection Size</span>
<span class="token key attr-name">initialSize</span><span class="token punctuation">=</span><span class="token value attr-value">10</span>
<span class="token comment">#min idle connecton size</span>
<span class="token key attr-name">minIdle</span><span class="token punctuation">=</span><span class="token value attr-value">5</span>
<span class="token comment">#max active connection size</span>
<span class="token key attr-name">maxActive</span><span class="token punctuation">=</span><span class="token value attr-value">20</span>
<span class="token comment">#max wait time (5000 mil seconds)</span>
<span class="token key attr-name">maxWait</span><span class="token punctuation">=</span><span class="token value attr-value">5000</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token class-name">Properties</span> properties <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">Properties</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
properties<span class="token punctuation">.</span><span class="token function">load</span><span class="token punctuation">(</span><span class="token keyword">new</span> <span class="token class-name">FileInputStream</span><span class="token punctuation">(</span><span class="token string">"src\\druid.properties"</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
<span class="token class-name">DataSource</span> dataSource <span class="token operator">=</span> <span class="token class-name">DruidDataSourceFactory</span><span class="token punctuation">.</span><span class="token function">createDataSource</span><span class="token punctuation">(</span>properties<span class="token punctuation">)</span><span class="token punctuation">;</span>
<span class="token keyword">for</span> <span class="token punctuation">(</span><span class="token keyword">int</span> i <span class="token operator">=</span> <span class="token number">0</span><span class="token punctuation">;</span> i <span class="token operator">&lt;</span> <span class="token number">500000</span><span class="token punctuation">;</span> i<span class="token operator">++</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
    <span class="token class-name">Connection</span> connection <span class="token operator">=</span> dataSource<span class="token punctuation">.</span><span class="token function">getConnection</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
    connection<span class="token punctuation">.</span><span class="token function">close</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><h3 id="_14-9-apache之dbutils" tabindex="-1"><a class="header-anchor" href="#_14-9-apache之dbutils" aria-hidden="true">#</a> 14.9 Apache之DBUtils</h3>
<h4 id="_14-9-1-基本介绍" tabindex="-1"><a class="header-anchor" href="#_14-9-1-基本介绍" aria-hidden="true">#</a> 14.9.1 基本介绍</h4>
<ol>
<li>commons-dbutils是Apache组织提供的一个开源JDBC工具类库，它是对JDBC的封装。简化Dao层的操作。</li>
<li>树结构：<img src="/images/javase/java-3/image-1660813554861.png" alt="image.png" loading="lazy"></li>
<li>作用：将数据库查询得到的数据放到一个ArrayList中，即使连接关闭了，也能使用这些数据。（正常情况下连接关闭，就访问不到这些数据）。</li>
<li>使用步骤：
<ul>
<li>得到连接（使用数据库连接池等方式）</li>
<li>将common-dbutils加入库文件</li>
<li>创建QueryRunner的对象<code v-pre>QueryRunner queryRunner = new QueryRunner()</code></li>
<li>执行DQL，返回ArrayList结果集
<ul>
<li>返回多个对象（查询多行）：queryRunner.query(connection, sql, new BeanListHandler&lt;&gt;(类名.class)</li>
<li>返回单个对象（查询单行）：queryRunner.query(connection, sql, new BeanHandler&lt;&gt;(类名.class)</li>
<li>返回单行单列对象（对象类型为Object）：queryRunner.query(connection, sql, new ScalarHandler&lt;&gt;()</li>
</ul>
</li>
<li>执行DML，返回受影响的行数。
<ul>
<li>queryRunner.update(connection, sql, ?的值)</li>
</ul>
</li>
</ul>
</li>
<li>底层分析：
<ul>
<li>调用query()方法时，底层会创建PreparedStatement、ResultSet、 一个接收结果的Object对象</li>
<li>底层调用handle(查询结果)，利用反射机制将查询到的结果传入到Object对象里</li>
<li>执行完毕关闭结果集、statement</li>
</ul>
</li>
<li>ResultSetSHandler接口实现类的主要作用：ResultSetSHandler用于处理java.sql.ResultSet，将数据按要求转换为另一种形式。
<ul>
<li><img src="/images/javase/java-3/image-1660813562406.png" alt="image.png" loading="lazy"></li>
<li><img src="/images/javase/java-3/image-1660813564055.png" alt="image.png" loading="lazy"></li>
</ul>
</li>
</ol>
<h4 id="_14-9-2-模仿dbutils-理解原理" tabindex="-1"><a class="header-anchor" href="#_14-9-2-模仿dbutils-理解原理" aria-hidden="true">#</a> 14.9.2 模仿dbutils，理解原理</h4>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token keyword">public</span> <span class="token class-name">ArrayList</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">Actor</span><span class="token punctuation">></span></span> <span class="token function">testSelectToArrayList</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
    <span class="token comment">//1. 得到连接</span>
    <span class="token class-name">Connection</span> connection <span class="token operator">=</span> <span class="token keyword">null</span><span class="token punctuation">;</span>
    <span class="token comment">//2. 组织一个sql</span>
    <span class="token class-name">String</span> sql <span class="token operator">=</span> <span class="token string">"select * from actor where id >= ?"</span><span class="token punctuation">;</span>
    <span class="token class-name">PreparedStatement</span> preparedStatement <span class="token operator">=</span> <span class="token keyword">null</span><span class="token punctuation">;</span>
    <span class="token class-name">ResultSet</span> set <span class="token operator">=</span> <span class="token keyword">null</span><span class="token punctuation">;</span>
    <span class="token class-name">ArrayList</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">Actor</span><span class="token punctuation">></span></span> list <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">ArrayList</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token punctuation">></span></span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span><span class="token comment">//创建ArrayList 对象,存放actor 对象</span>
    <span class="token comment">//3. 创建PreparedStatement 对象</span>
    <span class="token keyword">try</span> <span class="token punctuation">{</span>
        connection <span class="token operator">=</span> <span class="token class-name">JDBCUtilsByDruid</span><span class="token punctuation">.</span><span class="token function">getConnection</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        preparedStatement <span class="token operator">=</span> connection<span class="token punctuation">.</span><span class="token function">prepareStatement</span><span class="token punctuation">(</span>sql<span class="token punctuation">)</span><span class="token punctuation">;</span>
        preparedStatement<span class="token punctuation">.</span><span class="token function">setInt</span><span class="token punctuation">(</span><span class="token number">1</span><span class="token punctuation">,</span> <span class="token number">1</span><span class="token punctuation">)</span><span class="token punctuation">;</span><span class="token comment">//给?号赋值</span>
        <span class="token comment">//执行, 得到结果集</span>
        set <span class="token operator">=</span> preparedStatement<span class="token punctuation">.</span><span class="token function">executeQuery</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token comment">//遍历该结果集</span>
        <span class="token keyword">while</span> <span class="token punctuation">(</span>set<span class="token punctuation">.</span><span class="token function">next</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
            <span class="token keyword">int</span> id <span class="token operator">=</span> set<span class="token punctuation">.</span><span class="token function">getInt</span><span class="token punctuation">(</span><span class="token string">"id"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
            <span class="token class-name">String</span> name <span class="token operator">=</span> set<span class="token punctuation">.</span><span class="token function">getString</span><span class="token punctuation">(</span><span class="token string">"name"</span><span class="token punctuation">)</span><span class="token punctuation">;</span><span class="token comment">//getName()</span>
            <span class="token class-name">String</span> sex <span class="token operator">=</span> set<span class="token punctuation">.</span><span class="token function">getString</span><span class="token punctuation">(</span><span class="token string">"sex"</span><span class="token punctuation">)</span><span class="token punctuation">;</span><span class="token comment">//getSex()</span>
            <span class="token class-name">Date</span> borndate <span class="token operator">=</span> set<span class="token punctuation">.</span><span class="token function">getDate</span><span class="token punctuation">(</span><span class="token string">"borndate"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
            <span class="token class-name">String</span> phone <span class="token operator">=</span> set<span class="token punctuation">.</span><span class="token function">getString</span><span class="token punctuation">(</span><span class="token string">"phone"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
            <span class="token comment">//把得到的resultset 的记录，封装到Actor 对象，放入到list 集合</span>
            list<span class="token punctuation">.</span><span class="token function">add</span><span class="token punctuation">(</span><span class="token keyword">new</span> <span class="token class-name">Actor</span><span class="token punctuation">(</span>id<span class="token punctuation">,</span> name<span class="token punctuation">,</span> sex<span class="token punctuation">,</span> borndate<span class="token punctuation">,</span> phone<span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token punctuation">}</span>
        <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span><span class="token string">"list 集合数据="</span> <span class="token operator">+</span> list<span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token keyword">for</span><span class="token punctuation">(</span><span class="token class-name">Actor</span> actor <span class="token operator">:</span> list<span class="token punctuation">)</span> <span class="token punctuation">{</span>
            <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span><span class="token string">"id="</span> <span class="token operator">+</span> actor<span class="token punctuation">.</span><span class="token function">getId</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token operator">+</span> <span class="token string">"\t"</span> <span class="token operator">+</span> actor<span class="token punctuation">.</span><span class="token function">getName</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token punctuation">}</span>
    <span class="token punctuation">}</span> <span class="token keyword">catch</span> <span class="token punctuation">(</span><span class="token class-name">SQLException</span> e<span class="token punctuation">)</span> <span class="token punctuation">{</span>
        e<span class="token punctuation">.</span><span class="token function">printStackTrace</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token punctuation">}</span> <span class="token keyword">finally</span> <span class="token punctuation">{</span>
        <span class="token comment">//关闭资源</span>
        <span class="token class-name">JDBCUtilsByDruid</span><span class="token punctuation">.</span><span class="token function">close</span><span class="token punctuation">(</span>set<span class="token punctuation">,</span> preparedStatement<span class="token punctuation">,</span> connection<span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token punctuation">}</span>
    <span class="token comment">//因为ArrayList 和connection 没有任何关联，所以该集合可以复用.</span>
    <span class="token keyword">return</span> list<span class="token punctuation">;</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><h3 id="_14-10-dao和增删改查方法" tabindex="-1"><a class="header-anchor" href="#_14-10-dao和增删改查方法" aria-hidden="true">#</a> 14.10 Dao和增删改查方法</h3>
<h4 id="_14-10-1-dao层及basicdao-与数据库的相关操作" tabindex="-1"><a class="header-anchor" href="#_14-10-1-dao层及basicdao-与数据库的相关操作" aria-hidden="true">#</a> 14.10.1 Dao层及BasicDao：与数据库的相关操作</h4>
<ol>
<li>Dao：data access object：数据访问对象
<ul>
<li>Dao中的方法均为”单精度方法“——一个方法只干一件事。</li>
<li>Service层中的方法可以是”非单精度方法“，一个方法可以干好几件事。</li>
<li>如Dao中的添加只是添加，Service层中的添加还有先查询（判断是否重复）的功能，然后才是添加。</li>
</ul>
</li>
<li>根据数据访问对象设计的类叫Dao，高度抽象的该类叫BasicDao。</li>
<li>在BasicDao的基础上，设计继承自其的实现特定与数据库操作的Dao类，可以更好完成开发任务。</li>
</ol>
<p><img src="/images/javase/java-3/image-1660813567265.png" alt="image.png" loading="lazy">
<img src="/images/javase/java-3/image-1660813571004.png" alt="image.png" loading="lazy"></p>
<ol start="4">
<li>BasicDao：可以设计成类、也可以设计成接口</li>
</ol>
<h4 id="_14-10-2-domain-javabean-pojo层-数据库对应的java类" tabindex="-1"><a class="header-anchor" href="#_14-10-2-domain-javabean-pojo层-数据库对应的java类" aria-hidden="true">#</a> 14.10.2 domain/JavaBean/pojo层：数据库对应的java类</h4>
<h4 id="_14-10-3-service层-具体业务层" tabindex="-1"><a class="header-anchor" href="#_14-10-3-service层-具体业务层" aria-hidden="true">#</a> 14.10.3 service层：具体业务层</h4>
<h4 id="_14-10-3-view层-页面层" tabindex="-1"><a class="header-anchor" href="#_14-10-3-view层-页面层" aria-hidden="true">#</a> 14.10.3 view层：页面层</h4>
<h3 id="_14-11-封装jdbc工具类及使用" tabindex="-1"><a class="header-anchor" href="#_14-11-封装jdbc工具类及使用" aria-hidden="true">#</a> 14.11 封装JDBC工具类及使用</h3>
<h4 id="_14-11-1-封装数据库连接功能" tabindex="-1"><a class="header-anchor" href="#_14-11-1-封装数据库连接功能" aria-hidden="true">#</a> 14.11.1 封装数据库连接功能</h4>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token keyword">import</span> <span class="token import"><span class="token namespace">java<span class="token punctuation">.</span>io<span class="token punctuation">.</span></span><span class="token class-name">FileInputStream</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">java<span class="token punctuation">.</span>io<span class="token punctuation">.</span></span><span class="token class-name">IOException</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">java<span class="token punctuation">.</span>sql<span class="token punctuation">.</span></span><span class="token operator">*</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">java<span class="token punctuation">.</span>util<span class="token punctuation">.</span></span><span class="token class-name">Properties</span></span><span class="token punctuation">;</span>

<span class="token keyword">public</span> <span class="token keyword">class</span> <span class="token class-name">JDBCUtils</span> <span class="token punctuation">{</span>
    <span class="token comment">//定义相关的属性(4个), 因为只需要一份，因此，我们做出static</span>
    <span class="token keyword">private</span> <span class="token keyword">static</span> <span class="token class-name">String</span> user<span class="token punctuation">;</span> <span class="token comment">//用户名</span>
    <span class="token keyword">private</span> <span class="token keyword">static</span> <span class="token class-name">String</span> password<span class="token punctuation">;</span> <span class="token comment">//密码</span>
    <span class="token keyword">private</span> <span class="token keyword">static</span> <span class="token class-name">String</span> url<span class="token punctuation">;</span> <span class="token comment">//url</span>
    <span class="token keyword">private</span> <span class="token keyword">static</span> <span class="token class-name">String</span> driver<span class="token punctuation">;</span> <span class="token comment">//驱动名</span>

    <span class="token comment">//在static代码块初始化</span>
    <span class="token keyword">static</span> <span class="token punctuation">{</span>

        <span class="token keyword">try</span> <span class="token punctuation">{</span>
            <span class="token class-name">Properties</span> properties <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">Properties</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
            properties<span class="token punctuation">.</span><span class="token function">load</span><span class="token punctuation">(</span><span class="token keyword">new</span> <span class="token class-name">FileInputStream</span><span class="token punctuation">(</span><span class="token string">"src\\mysql.properties"</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
            user <span class="token operator">=</span> properties<span class="token punctuation">.</span><span class="token function">getProperty</span><span class="token punctuation">(</span><span class="token string">"user"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
            password <span class="token operator">=</span> properties<span class="token punctuation">.</span><span class="token function">getProperty</span><span class="token punctuation">(</span><span class="token string">"password"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
            url <span class="token operator">=</span> properties<span class="token punctuation">.</span><span class="token function">getProperty</span><span class="token punctuation">(</span><span class="token string">"url"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
            driver <span class="token operator">=</span> properties<span class="token punctuation">.</span><span class="token function">getProperty</span><span class="token punctuation">(</span><span class="token string">"driver"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token punctuation">}</span> <span class="token keyword">catch</span> <span class="token punctuation">(</span><span class="token class-name">IOException</span> e<span class="token punctuation">)</span> <span class="token punctuation">{</span>
            <span class="token keyword">throw</span> <span class="token keyword">new</span> <span class="token class-name">RuntimeException</span><span class="token punctuation">(</span>e<span class="token punctuation">)</span><span class="token punctuation">;</span>

        <span class="token punctuation">}</span>
    <span class="token punctuation">}</span>

    <span class="token comment">//连接数据库, 返回Connection</span>
    <span class="token keyword">public</span> <span class="token keyword">static</span> <span class="token class-name">Connection</span> <span class="token function">getConnection</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>

        <span class="token keyword">try</span> <span class="token punctuation">{</span>
            <span class="token keyword">return</span> <span class="token class-name">DriverManager</span><span class="token punctuation">.</span><span class="token function">getConnection</span><span class="token punctuation">(</span>url<span class="token punctuation">,</span> user<span class="token punctuation">,</span> password<span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token punctuation">}</span> <span class="token keyword">catch</span> <span class="token punctuation">(</span><span class="token class-name">SQLException</span> e<span class="token punctuation">)</span> <span class="token punctuation">{</span>
            <span class="token keyword">throw</span> <span class="token keyword">new</span> <span class="token class-name">RuntimeException</span><span class="token punctuation">(</span>e<span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token punctuation">}</span>
    <span class="token punctuation">}</span>

    <span class="token comment">//关闭相关资源</span>
    <span class="token comment">/*
        1. ResultSet 结果集
        2. Statement 或者 PreparedStatement
        3. Connection
        4. 如果需要关闭资源，就传入对象，否则传入 null
     */</span>
    <span class="token keyword">public</span> <span class="token keyword">static</span> <span class="token keyword">void</span> <span class="token function">close</span><span class="token punctuation">(</span><span class="token class-name">ResultSet</span> set<span class="token punctuation">,</span> <span class="token class-name">Statement</span> statement<span class="token punctuation">,</span> <span class="token class-name">Connection</span> connection<span class="token punctuation">)</span> <span class="token punctuation">{</span>
        <span class="token keyword">try</span> <span class="token punctuation">{</span>
            <span class="token keyword">if</span> <span class="token punctuation">(</span>set <span class="token operator">!=</span> <span class="token keyword">null</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
                set<span class="token punctuation">.</span><span class="token function">close</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
            <span class="token punctuation">}</span>
            <span class="token keyword">if</span> <span class="token punctuation">(</span>statement <span class="token operator">!=</span> <span class="token keyword">null</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
                statement<span class="token punctuation">.</span><span class="token function">close</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
            <span class="token punctuation">}</span>
            <span class="token keyword">if</span> <span class="token punctuation">(</span>connection <span class="token operator">!=</span> <span class="token keyword">null</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
                connection<span class="token punctuation">.</span><span class="token function">close</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
            <span class="token punctuation">}</span>
        <span class="token punctuation">}</span> <span class="token keyword">catch</span> <span class="token punctuation">(</span><span class="token class-name">SQLException</span> e<span class="token punctuation">)</span> <span class="token punctuation">{</span>
            <span class="token keyword">throw</span> <span class="token keyword">new</span> <span class="token class-name">RuntimeException</span><span class="token punctuation">(</span>e<span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token punctuation">}</span>
    <span class="token punctuation">}</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><div class="language-properties ext-properties line-numbers-mode"><pre v-pre class="language-properties"><code><span class="token key attr-name">user</span><span class="token punctuation">=</span><span class="token value attr-value">root</span>
<span class="token key attr-name">password</span><span class="token punctuation">=</span><span class="token value attr-value">dimitre123</span>
<span class="token key attr-name">url</span><span class="token punctuation">=</span><span class="token value attr-value">jdbc:mysql://localhost:13306/hsp_db02</span>
<span class="token key attr-name">driver</span><span class="token punctuation">=</span><span class="token value attr-value">com.mysql.jdbc.Driver</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><h4 id="_14-11-2-使用" tabindex="-1"><a class="header-anchor" href="#_14-11-2-使用" aria-hidden="true">#</a> 14.11.2 使用</h4>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token keyword">import</span> <span class="token import"><span class="token namespace">org<span class="token punctuation">.</span>junit<span class="token punctuation">.</span>jupiter<span class="token punctuation">.</span>api<span class="token punctuation">.</span></span><span class="token class-name">Test</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">java<span class="token punctuation">.</span>sql<span class="token punctuation">.</span></span><span class="token operator">*</span></span><span class="token punctuation">;</span>

<span class="token keyword">public</span> <span class="token keyword">class</span> <span class="token class-name">JDBCUtils_Use</span> <span class="token punctuation">{</span>
    <span class="token annotation punctuation">@Test</span>
    <span class="token keyword">public</span> <span class="token keyword">void</span> <span class="token function">testSelect</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span><span class="token comment">//select</span>
        <span class="token class-name">Connection</span> connection <span class="token operator">=</span> <span class="token keyword">null</span><span class="token punctuation">;</span>
        <span class="token class-name">String</span> sql <span class="token operator">=</span> <span class="token string">"select * from actor where id = ?"</span><span class="token punctuation">;</span>
        <span class="token class-name">PreparedStatement</span> preparedStatement <span class="token operator">=</span> <span class="token keyword">null</span><span class="token punctuation">;</span>
        <span class="token class-name">ResultSet</span> set <span class="token operator">=</span> <span class="token keyword">null</span><span class="token punctuation">;</span>
        <span class="token keyword">try</span> <span class="token punctuation">{</span>
            connection <span class="token operator">=</span> <span class="token class-name">JDBCUtils</span><span class="token punctuation">.</span><span class="token function">getConnection</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
            preparedStatement <span class="token operator">=</span> connection<span class="token punctuation">.</span><span class="token function">prepareStatement</span><span class="token punctuation">(</span>sql<span class="token punctuation">)</span><span class="token punctuation">;</span>
            preparedStatement<span class="token punctuation">.</span><span class="token function">setInt</span><span class="token punctuation">(</span><span class="token number">1</span><span class="token punctuation">,</span> <span class="token number">5</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
            set <span class="token operator">=</span> preparedStatement<span class="token punctuation">.</span><span class="token function">executeQuery</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
            <span class="token keyword">while</span> <span class="token punctuation">(</span>set<span class="token punctuation">.</span><span class="token function">next</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
                <span class="token keyword">int</span> id <span class="token operator">=</span> set<span class="token punctuation">.</span><span class="token function">getInt</span><span class="token punctuation">(</span><span class="token string">"id"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
                <span class="token class-name">String</span> name <span class="token operator">=</span> set<span class="token punctuation">.</span><span class="token function">getString</span><span class="token punctuation">(</span><span class="token string">"name"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
                <span class="token class-name">String</span> sex <span class="token operator">=</span> set<span class="token punctuation">.</span><span class="token function">getString</span><span class="token punctuation">(</span><span class="token string">"sex"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
                <span class="token class-name">Date</span> borndate <span class="token operator">=</span> set<span class="token punctuation">.</span><span class="token function">getDate</span><span class="token punctuation">(</span><span class="token string">"borndate"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
                <span class="token class-name">String</span> phone <span class="token operator">=</span> set<span class="token punctuation">.</span><span class="token function">getString</span><span class="token punctuation">(</span><span class="token string">"phone"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
                <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span>id <span class="token operator">+</span> <span class="token string">"\t"</span> <span class="token operator">+</span> name <span class="token operator">+</span> <span class="token string">"\t"</span> <span class="token operator">+</span> sex <span class="token operator">+</span> <span class="token string">"\t"</span> <span class="token operator">+</span> borndate <span class="token operator">+</span> <span class="token string">"\t"</span> <span class="token operator">+</span> phone<span class="token punctuation">)</span><span class="token punctuation">;</span>
            <span class="token punctuation">}</span>
        <span class="token punctuation">}</span> <span class="token keyword">catch</span> <span class="token punctuation">(</span><span class="token class-name">SQLException</span> e<span class="token punctuation">)</span> <span class="token punctuation">{</span>
            e<span class="token punctuation">.</span><span class="token function">printStackTrace</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token punctuation">}</span> <span class="token keyword">finally</span> <span class="token punctuation">{</span>
            <span class="token class-name">JDBCUtils</span><span class="token punctuation">.</span><span class="token function">close</span><span class="token punctuation">(</span>set<span class="token punctuation">,</span> preparedStatement<span class="token punctuation">,</span> connection<span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token punctuation">}</span>
    <span class="token punctuation">}</span>

    <span class="token annotation punctuation">@Test</span>
    <span class="token keyword">public</span> <span class="token keyword">void</span> <span class="token function">testDML</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span><span class="token comment">//insert , update, delete</span>
        <span class="token class-name">Connection</span> connection <span class="token operator">=</span> <span class="token keyword">null</span><span class="token punctuation">;</span>
        <span class="token class-name">String</span> sql <span class="token operator">=</span> <span class="token string">"update actor set name = ? where id = ?"</span><span class="token punctuation">;</span>
        <span class="token class-name">PreparedStatement</span> preparedStatement <span class="token operator">=</span> <span class="token keyword">null</span><span class="token punctuation">;</span>
        <span class="token keyword">try</span> <span class="token punctuation">{</span>
            connection <span class="token operator">=</span> <span class="token class-name">JDBCUtils</span><span class="token punctuation">.</span><span class="token function">getConnection</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
            preparedStatement <span class="token operator">=</span> connection<span class="token punctuation">.</span><span class="token function">prepareStatement</span><span class="token punctuation">(</span>sql<span class="token punctuation">)</span><span class="token punctuation">;</span>
            preparedStatement<span class="token punctuation">.</span><span class="token function">setString</span><span class="token punctuation">(</span><span class="token number">1</span><span class="token punctuation">,</span> <span class="token string">"周星驰"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
            preparedStatement<span class="token punctuation">.</span><span class="token function">setInt</span><span class="token punctuation">(</span><span class="token number">2</span><span class="token punctuation">,</span> <span class="token number">4</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
            preparedStatement<span class="token punctuation">.</span><span class="token function">executeUpdate</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token punctuation">}</span> <span class="token keyword">catch</span> <span class="token punctuation">(</span><span class="token class-name">SQLException</span> e<span class="token punctuation">)</span> <span class="token punctuation">{</span>
            e<span class="token punctuation">.</span><span class="token function">printStackTrace</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token punctuation">}</span> <span class="token keyword">finally</span> <span class="token punctuation">{</span>
            <span class="token class-name">JDBCUtils</span><span class="token punctuation">.</span><span class="token function">close</span><span class="token punctuation">(</span><span class="token keyword">null</span><span class="token punctuation">,</span> preparedStatement<span class="token punctuation">,</span> connection<span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token punctuation">}</span>
    <span class="token punctuation">}</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><h4 id="_14-11-3-封装成druid工具类——将连接功能使用线程池实现" tabindex="-1"><a class="header-anchor" href="#_14-11-3-封装成druid工具类——将连接功能使用线程池实现" aria-hidden="true">#</a> 14.11.3 封装成Druid工具类——将连接功能使用线程池实现</h4>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token keyword">package</span> <span class="token namespace">com<span class="token punctuation">.</span>hspedu<span class="token punctuation">.</span>jdbc<span class="token punctuation">.</span>datasource</span><span class="token punctuation">;</span>

<span class="token keyword">import</span> <span class="token import"><span class="token namespace">com<span class="token punctuation">.</span>alibaba<span class="token punctuation">.</span>druid<span class="token punctuation">.</span>pool<span class="token punctuation">.</span></span><span class="token class-name">DruidDataSourceFactory</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">javax<span class="token punctuation">.</span>sql<span class="token punctuation">.</span></span><span class="token class-name">DataSource</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">java<span class="token punctuation">.</span>io<span class="token punctuation">.</span></span><span class="token class-name">FileInputStream</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">java<span class="token punctuation">.</span>io<span class="token punctuation">.</span></span><span class="token class-name">IOException</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">java<span class="token punctuation">.</span>sql<span class="token punctuation">.</span></span><span class="token class-name">Connection</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">java<span class="token punctuation">.</span>sql<span class="token punctuation">.</span></span><span class="token class-name">ResultSet</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">java<span class="token punctuation">.</span>sql<span class="token punctuation">.</span></span><span class="token class-name">SQLException</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">java<span class="token punctuation">.</span>sql<span class="token punctuation">.</span></span><span class="token class-name">Statement</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">java<span class="token punctuation">.</span>util<span class="token punctuation">.</span></span><span class="token class-name">Properties</span></span><span class="token punctuation">;</span>

<span class="token keyword">public</span> <span class="token keyword">class</span> <span class="token class-name">JDBCUtilsByDruid</span> <span class="token punctuation">{</span>
    <span class="token keyword">private</span> <span class="token keyword">static</span> <span class="token class-name">DataSource</span> ds<span class="token punctuation">;</span>
    <span class="token keyword">static</span> <span class="token punctuation">{</span>
        <span class="token class-name">Properties</span> properties <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">Properties</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token keyword">try</span> <span class="token punctuation">{</span>
            properties<span class="token punctuation">.</span><span class="token function">load</span><span class="token punctuation">(</span><span class="token keyword">new</span> <span class="token class-name">FileInputStream</span><span class="token punctuation">(</span><span class="token string">"src\\druid.properties"</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
            ds <span class="token operator">=</span> <span class="token class-name">DruidDataSourceFactory</span><span class="token punctuation">.</span><span class="token function">createDataSource</span><span class="token punctuation">(</span>properties<span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token punctuation">}</span> <span class="token keyword">catch</span> <span class="token punctuation">(</span><span class="token class-name">Exception</span> e<span class="token punctuation">)</span> <span class="token punctuation">{</span>
            e<span class="token punctuation">.</span><span class="token function">printStackTrace</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token punctuation">}</span>
    <span class="token punctuation">}</span>
    <span class="token keyword">public</span> <span class="token keyword">static</span> <span class="token class-name">Connection</span> <span class="token function">getConnection</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token keyword">throws</span> <span class="token class-name">SQLException</span> <span class="token punctuation">{</span>
        <span class="token keyword">return</span> ds<span class="token punctuation">.</span><span class="token function">getConnection</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token punctuation">}</span>
    <span class="token keyword">public</span> <span class="token keyword">static</span> <span class="token keyword">void</span> <span class="token function">close</span><span class="token punctuation">(</span><span class="token class-name">ResultSet</span> resultSet<span class="token punctuation">,</span> <span class="token class-name">Statement</span> statement<span class="token punctuation">,</span> <span class="token class-name">Connection</span> connection<span class="token punctuation">)</span> <span class="token punctuation">{</span>
        <span class="token keyword">try</span> <span class="token punctuation">{</span>
            <span class="token keyword">if</span> <span class="token punctuation">(</span>resultSet <span class="token operator">!=</span> <span class="token keyword">null</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
                resultSet<span class="token punctuation">.</span><span class="token function">close</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
            <span class="token punctuation">}</span>
            <span class="token keyword">if</span> <span class="token punctuation">(</span>statement <span class="token operator">!=</span> <span class="token keyword">null</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
                statement<span class="token punctuation">.</span><span class="token function">close</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
            <span class="token punctuation">}</span>
            <span class="token keyword">if</span> <span class="token punctuation">(</span>connection <span class="token operator">!=</span> <span class="token keyword">null</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
                connection<span class="token punctuation">.</span><span class="token function">close</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
            <span class="token punctuation">}</span>
        <span class="token punctuation">}</span> <span class="token keyword">catch</span> <span class="token punctuation">(</span><span class="token class-name">SQLException</span> e<span class="token punctuation">)</span> <span class="token punctuation">{</span>
            <span class="token keyword">throw</span> <span class="token keyword">new</span> <span class="token class-name">RuntimeException</span><span class="token punctuation">(</span>e<span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token punctuation">}</span>
    <span class="token punctuation">}</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><div class="language-properties ext-properties line-numbers-mode"><pre v-pre class="language-properties"><code><span class="token comment">#key=value</span>
<span class="token key attr-name">driverClassName</span><span class="token punctuation">=</span><span class="token value attr-value">com.mysql.jdbc.Driver</span>
<span class="token key attr-name">url</span><span class="token punctuation">=</span><span class="token value attr-value">jdbc:mysql://localhost:3306/girls?rewriteBatchedStatements=true</span>
<span class="token comment">#url=jdbc:mysql://localhost:3306/数据库名?rew……表示批处理</span>
<span class="token key attr-name">username</span><span class="token punctuation">=</span><span class="token value attr-value">root</span>
<span class="token key attr-name">password</span><span class="token punctuation">=</span><span class="token value attr-value">root</span>
<span class="token comment">#initial connection Size</span>
<span class="token key attr-name">initialSize</span><span class="token punctuation">=</span><span class="token value attr-value">10</span>
<span class="token comment">#min idle connecton size</span>
<span class="token key attr-name">minIdle</span><span class="token punctuation">=</span><span class="token value attr-value">5</span>
<span class="token comment">#max active connection size</span>
<span class="token key attr-name">maxActive</span><span class="token punctuation">=</span><span class="token value attr-value">20</span>
<span class="token comment">#max wait time (5000 mil seconds)</span>
<span class="token key attr-name">maxWait</span><span class="token punctuation">=</span><span class="token value attr-value">5000</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><h4 id="_14-11-4-使用druid工具类" tabindex="-1"><a class="header-anchor" href="#_14-11-4-使用druid工具类" aria-hidden="true">#</a> 14.11.4 使用Druid工具类</h4>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token keyword">public</span> <span class="token keyword">class</span> <span class="token class-name">JDBCUtilsByDruid_USE</span> <span class="token punctuation">{</span>
    <span class="token keyword">public</span> <span class="token keyword">void</span> <span class="token function">testSelect</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
        <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span><span class="token string">"使用 druid方式完成"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token comment">//1. 得到连接</span>
        <span class="token class-name">Connection</span> connection <span class="token operator">=</span> <span class="token keyword">null</span><span class="token punctuation">;</span>
        <span class="token comment">//2. 组织一个sql</span>
        <span class="token class-name">String</span> sql <span class="token operator">=</span> <span class="token string">"select * from actor where id >= ?"</span><span class="token punctuation">;</span>
        <span class="token class-name">PreparedStatement</span> preparedStatement <span class="token operator">=</span> <span class="token keyword">null</span><span class="token punctuation">;</span>
        <span class="token class-name">ResultSet</span> set <span class="token operator">=</span> <span class="token keyword">null</span><span class="token punctuation">;</span>
        <span class="token comment">//3. 创建PreparedStatement 对象</span>
        <span class="token keyword">try</span> <span class="token punctuation">{</span>
            connection <span class="token operator">=</span> <span class="token class-name">JDBCUtilsByDruid</span><span class="token punctuation">.</span><span class="token function">getConnection</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
            <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span>connection<span class="token punctuation">.</span><span class="token function">getClass</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span><span class="token comment">//运行类型 com.alibaba.druid.pool.DruidPooledConnection</span>
            preparedStatement <span class="token operator">=</span> connection<span class="token punctuation">.</span><span class="token function">prepareStatement</span><span class="token punctuation">(</span>sql<span class="token punctuation">)</span><span class="token punctuation">;</span>
            preparedStatement<span class="token punctuation">.</span><span class="token function">setInt</span><span class="token punctuation">(</span><span class="token number">1</span><span class="token punctuation">,</span> <span class="token number">1</span><span class="token punctuation">)</span><span class="token punctuation">;</span><span class="token comment">//给?号赋值</span>
            <span class="token comment">//执行, 得到结果集</span>
            set <span class="token operator">=</span> preparedStatement<span class="token punctuation">.</span><span class="token function">executeQuery</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
            <span class="token keyword">while</span> <span class="token punctuation">(</span>set<span class="token punctuation">.</span><span class="token function">next</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
                <span class="token keyword">int</span> id <span class="token operator">=</span> set<span class="token punctuation">.</span><span class="token function">getInt</span><span class="token punctuation">(</span><span class="token string">"id"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
                <span class="token class-name">String</span> name <span class="token operator">=</span> set<span class="token punctuation">.</span><span class="token function">getString</span><span class="token punctuation">(</span><span class="token string">"name"</span><span class="token punctuation">)</span><span class="token punctuation">;</span><span class="token comment">//getName()</span>
                <span class="token class-name">String</span> sex <span class="token operator">=</span> set<span class="token punctuation">.</span><span class="token function">getString</span><span class="token punctuation">(</span><span class="token string">"sex"</span><span class="token punctuation">)</span><span class="token punctuation">;</span><span class="token comment">//getSex()</span>
                <span class="token class-name">Date</span> borndate <span class="token operator">=</span> set<span class="token punctuation">.</span><span class="token function">getDate</span><span class="token punctuation">(</span><span class="token string">"borndate"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
                <span class="token class-name">String</span> phone <span class="token operator">=</span> set<span class="token punctuation">.</span><span class="token function">getString</span><span class="token punctuation">(</span><span class="token string">"phone"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
                <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span>id <span class="token operator">+</span> <span class="token string">"\t"</span> <span class="token operator">+</span> name <span class="token operator">+</span> <span class="token string">"\t"</span> <span class="token operator">+</span> sex <span class="token operator">+</span> <span class="token string">"\t"</span> <span class="token operator">+</span> borndate <span class="token operator">+</span> <span class="token string">"\t"</span> <span class="token operator">+</span> phone<span class="token punctuation">)</span><span class="token punctuation">;</span>
            <span class="token punctuation">}</span>
        <span class="token punctuation">}</span> <span class="token keyword">catch</span> <span class="token punctuation">(</span><span class="token class-name">SQLException</span> e<span class="token punctuation">)</span> <span class="token punctuation">{</span>
            e<span class="token punctuation">.</span><span class="token function">printStackTrace</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token punctuation">}</span> <span class="token keyword">finally</span> <span class="token punctuation">{</span>
            <span class="token class-name">JDBCUtilsByDruid</span><span class="token punctuation">.</span><span class="token function">close</span><span class="token punctuation">(</span>set<span class="token punctuation">,</span> preparedStatement<span class="token punctuation">,</span> connection<span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token punctuation">}</span>
    <span class="token punctuation">}</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ul>
<li>JDBCUtilsByDruid的connection类型是DruidPooledConnection，当connection关闭时，只是将连接的引用断开，连接还是在连接池内。</li>
<li>JDBCUtils的connection类型是JDBC4connection，当connection关闭时，就真正实现了连接的关闭。</li>
</ul>
<h4 id="_14-11-5-封装dbutils——实现关闭连接也能使用数据" tabindex="-1"><a class="header-anchor" href="#_14-11-5-封装dbutils——实现关闭连接也能使用数据" aria-hidden="true">#</a> 14.11.5 封装DBUtils——实现关闭连接也能使用数据</h4>
<h2 id="第15章-正则表达式" tabindex="-1"><a class="header-anchor" href="#第15章-正则表达式" aria-hidden="true">#</a> 第15章 正则表达式</h2>
<p><a href="https://www.yuque.com/attachments/yuque/0/2022/txt/1604140/1656599308654-6972a374-338e-4c72-b6f1-b888b5aa49ea.txt" target="_blank" rel="noopener noreferrer">常用正则表达式.txt<ExternalLinkIcon/></a></p>
<h3 id="_15-1-基本介绍" tabindex="-1"><a class="header-anchor" href="#_15-1-基本介绍" aria-hidden="true">#</a> 15.1 基本介绍</h3>
<ol>
<li>用某种模式去匹配字符串的一个公式。</li>
</ol>
<h3 id="_15-2-快速入门" tabindex="-1"><a class="header-anchor" href="#_15-2-快速入门" aria-hidden="true">#</a> 15.2 快速入门</h3>
<h3 id="_15-2-底层实现" tabindex="-1"><a class="header-anchor" href="#_15-2-底层实现" aria-hidden="true">#</a> 15.2 底层实现</h3>
</div>
</div></template>
