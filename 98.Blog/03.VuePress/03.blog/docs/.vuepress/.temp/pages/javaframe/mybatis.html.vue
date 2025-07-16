<template><div><h1 id="mybatis" tabindex="-1"><a class="header-anchor" href="#mybatis" aria-hidden="true">#</a> MyBatis</h1>
<blockquote>
<ul>
<li>持久层框架</li>
<li>与Spring、SpringMVC无先后学习关系</li>
<li>需要JDBC基础</li>
</ul>
</blockquote>
<h2 id="第1章-mybatis入门" tabindex="-1"><a class="header-anchor" href="#第1章-mybatis入门" aria-hidden="true">#</a> 第1章 MyBatis入门</h2>
<h3 id="_1-1-mybatis简介" tabindex="-1"><a class="header-anchor" href="#_1-1-mybatis简介" aria-hidden="true">#</a> 1.1 MyBatis简介</h3>
<h4 id="_1-1-1-mybatis历史" tabindex="-1"><a class="header-anchor" href="#_1-1-1-mybatis历史" aria-hidden="true">#</a> 1.1.1 MyBatis历史</h4>
<ul>
<li>MyBatis最初是Apache的一个开源项目iBatis, 2010年6月这个项目由Apache Software Foundation迁移到了Google Code。随着开发团队转投Google Code旗下， iBatis3.x正式更名为MyBatis。代码于2013年11月迁移到Github。</li>
<li>iBatis一词来源于“internet”和“abatis”的组合，是一个基于Java的持久层框架。 iBatis提供的持久层框架包括SQL Maps和Data Access Objects（DAO）。</li>
</ul>
<h4 id="_1-1-2-mybatis特性" tabindex="-1"><a class="header-anchor" href="#_1-1-2-mybatis特性" aria-hidden="true">#</a> 1.1.2 MyBatis特性</h4>
<ol>
<li>MyBatis 是支持定制化 SQL、存储过程以及高级映射的优秀的持久层框架。</li>
<li>MyBatis 避免了几乎所有的 JDBC 代码和手动设置参数以及获取结果集。</li>
<li>MyBatis可以使用简单的XML或注解用于配置和原始映射，将接口和Java的POJO（<code v-pre>Plain Old Java Objects</code>，普通的Java对象）映射成数据库中的记录。</li>
<li>MyBatis 是一个 半自动的<code v-pre>ORM</code>（<code v-pre>Object Relation Mapping</code>）框架。</li>
<li>MyBatis的配置文件分为核心配置文件和映射配置文件，核心配置文件写项目数据库连接和MyBatis的全局配置，映射配置写SQL语句。</li>
</ol>
<h4 id="_1-1-3-mybatis下载" tabindex="-1"><a class="header-anchor" href="#_1-1-3-mybatis下载" aria-hidden="true">#</a> 1.1.3 MyBatis下载</h4>
<blockquote>
<p>MyBatis下载地址：</p>
</blockquote>
<h4 id="_1-1-4-和其它持久化层技术对比" tabindex="-1"><a class="header-anchor" href="#_1-1-4-和其它持久化层技术对比" aria-hidden="true">#</a> 1.1.4 和其它持久化层技术对比</h4>
<ol>
<li>JDBC：
<ul>
<li>SQL 夹杂在Java代码中耦合度高，导致硬编码内伤</li>
<li>维护不易且实际开发需求中 SQL 有变化，频繁修改的情况多见</li>
<li>代码冗长，开发效率低</li>
</ul>
</li>
<li>Hibernate 和 JPA
<ul>
<li>操作简便，开发效率高</li>
<li>程序中的长难复杂 SQL 需要绕过框架</li>
<li>内部自动生产的 SQL，不容易做特殊优化</li>
<li>基于全映射的全自动框架，大量字段的 POJO 进行部分映射时比较困难。</li>
<li>反射操作太多，导致数据库性能下降 。</li>
</ul>
</li>
<li>MyBatis
<ul>
<li>轻量级，性能出色</li>
<li>SQL 和 Java 编码分开，功能边界清晰。Java代码专注业务、SQL语句专注数据</li>
<li>开发效率稍逊于HIbernate，但是完全能够接受</li>
</ul>
</li>
</ol>
<h3 id="_1-2-使用mybatis" tabindex="-1"><a class="header-anchor" href="#_1-2-使用mybatis" aria-hidden="true">#</a> 1.2 使用MyBatis</h3>
<h4 id="_1-2-1-使用maven构建环境" tabindex="-1"><a class="header-anchor" href="#_1-2-1-使用maven构建环境" aria-hidden="true">#</a> 1.2.1 使用Maven构建环境</h4>
<ol>
<li>软件版本：
<ul>
<li>IDEA：2021.2.4【与3.8.6版本的Maven版本不兼容】</li>
<li>Maven：3.5.4</li>
<li>Mysql：5.7</li>
<li>MyBatis：3.5.7</li>
</ul>
</li>
<li>创建maven工程：参见【Maven 第4章<a href="https://www.yuque.com/zhuyuqi/zna9x5/ewwdt7#m3UvK" target="_blank" rel="noopener noreferrer">Maven<ExternalLinkIcon/></a>】
<ul>
<li>项目结构：
<ul>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1658789705228-62a84150-0441-463a-b573-ea65da2d72e0.png#clientId=u75362e1a-0f0f-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=292&amp;id=ubde706cc&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=292&amp;originWidth=253&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=4220&amp;status=done&amp;style=none&amp;taskId=u6a88bc8c-8744-4720-91ea-bbbec8483cf&amp;title=&amp;width=253" alt="image.png" loading="lazy"></li>
</ul>
</li>
<li>修改<code v-pre>pro01-mybatis</code>打包方式：需要为jar包形式
<ul>
<li><code v-pre>&lt;packaging&gt;jar&lt;/packaging&gt;</code></li>
</ul>
</li>
<li>在父工程<code v-pre>12.MyBits</code>中添加项目依赖：</li>
</ul>
</li>
</ol>
<div class="language-xml ext-xml line-numbers-mode"><pre v-pre class="language-xml"><code><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>dependencies</span><span class="token punctuation">></span></span>
  <span class="token comment">&lt;!-- Mybatis核心 --></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>dependency</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>groupId</span><span class="token punctuation">></span></span>org.mybatis<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>groupId</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>artifactId</span><span class="token punctuation">></span></span>mybatis<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>artifactId</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>version</span><span class="token punctuation">></span></span>3.5.7<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>version</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>dependency</span><span class="token punctuation">></span></span>
  <span class="token comment">&lt;!-- junit测试 --></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>dependency</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>groupId</span><span class="token punctuation">></span></span>junit<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>groupId</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>artifactId</span><span class="token punctuation">></span></span>junit<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>artifactId</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>version</span><span class="token punctuation">></span></span>4.12<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>version</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>scope</span><span class="token punctuation">></span></span>test<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>scope</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>dependency</span><span class="token punctuation">></span></span>
  <span class="token comment">&lt;!-- MySQL驱动 --></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>dependency</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>groupId</span><span class="token punctuation">></span></span>mysql<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>groupId</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>artifactId</span><span class="token punctuation">></span></span>mysql-connector-java<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>artifactId</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>version</span><span class="token punctuation">></span></span>5.1.3<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>version</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>dependency</span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>dependencies</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><h4 id="_1-2-2-配置mybatis" tabindex="-1"><a class="header-anchor" href="#_1-2-2-配置mybatis" aria-hidden="true">#</a> 1.2.2 配置mybatis</h4>
<ol>
<li>创建MyBatis的核心配置文件：
<ul>
<li>在<code v-pre>main/resources</code>目录下创建配置文件，习惯命名为<code v-pre>mybatis-config.xml</code>（名称无要求），整合Spring后，该文件可省略。</li>
<li>官方文档<code v-pre>Getting Started</code>提供了配置文件的模板【正文第3页】</li>
<li>根据本地MySQL的配置，修改配置文件的内容。
<ul>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1658790632007-9d32c1f0-76c7-4cb8-8624-9778927c1c95.png#clientId=u75362e1a-0f0f-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=526&amp;id=u88334d49&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=526&amp;originWidth=728&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=78066&amp;status=done&amp;style=none&amp;taskId=u3f95fc94-5d00-4797-983a-f9756846563&amp;title=&amp;width=728" alt="image.png" loading="lazy"></li>
</ul>
</li>
</ul>
</li>
<li>创建mapper接口：
<ul>
<li>创建数据表：</li>
</ul>
</li>
</ol>
<div class="language-sql ext-sql line-numbers-mode"><pre v-pre class="language-sql"><code><span class="token keyword">CREATE</span> <span class="token keyword">TABLE</span> <span class="token identifier"><span class="token punctuation">`</span>t_user<span class="token punctuation">`</span></span> <span class="token punctuation">(</span>
  <span class="token identifier"><span class="token punctuation">`</span>id<span class="token punctuation">`</span></span> <span class="token keyword">int</span><span class="token punctuation">(</span><span class="token number">11</span><span class="token punctuation">)</span> <span class="token operator">NOT</span> <span class="token boolean">NULL</span> <span class="token keyword">AUTO_INCREMENT</span><span class="token punctuation">,</span>
  <span class="token identifier"><span class="token punctuation">`</span>username<span class="token punctuation">`</span></span> <span class="token keyword">varchar</span><span class="token punctuation">(</span><span class="token number">20</span><span class="token punctuation">)</span> <span class="token keyword">DEFAULT</span> <span class="token boolean">NULL</span><span class="token punctuation">,</span>
  <span class="token identifier"><span class="token punctuation">`</span>password<span class="token punctuation">`</span></span> <span class="token keyword">varchar</span><span class="token punctuation">(</span><span class="token number">20</span><span class="token punctuation">)</span> <span class="token keyword">DEFAULT</span> <span class="token boolean">NULL</span><span class="token punctuation">,</span>
  <span class="token identifier"><span class="token punctuation">`</span>age<span class="token punctuation">`</span></span> <span class="token keyword">int</span><span class="token punctuation">(</span><span class="token number">11</span><span class="token punctuation">)</span> <span class="token keyword">DEFAULT</span> <span class="token boolean">NULL</span><span class="token punctuation">,</span>
  <span class="token identifier"><span class="token punctuation">`</span>sex<span class="token punctuation">`</span></span> <span class="token keyword">char</span><span class="token punctuation">(</span><span class="token number">1</span><span class="token punctuation">)</span> <span class="token keyword">DEFAULT</span> <span class="token boolean">NULL</span><span class="token punctuation">,</span>
  <span class="token identifier"><span class="token punctuation">`</span>email<span class="token punctuation">`</span></span> <span class="token keyword">varchar</span><span class="token punctuation">(</span><span class="token number">100</span><span class="token punctuation">)</span> <span class="token keyword">DEFAULT</span> <span class="token boolean">NULL</span><span class="token punctuation">,</span>
  <span class="token keyword">PRIMARY</span> <span class="token keyword">KEY</span> <span class="token punctuation">(</span><span class="token identifier"><span class="token punctuation">`</span>id<span class="token punctuation">`</span></span><span class="token punctuation">)</span>
<span class="token punctuation">)</span> <span class="token keyword">ENGINE</span><span class="token operator">=</span><span class="token keyword">InnoDB</span> <span class="token keyword">DEFAULT</span> <span class="token keyword">CHARSET</span><span class="token operator">=</span>utf8
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ul>
<li>创建pojo实体：</li>
</ul>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token keyword">package</span> <span class="token namespace">iceriver<span class="token punctuation">.</span>mybatis<span class="token punctuation">.</span>pojo</span><span class="token punctuation">;</span>

<span class="token doc-comment comment">/**
* <span class="token keyword">@author</span>: INFINITY https://developer.aliyun.com/profile/sagwrxp2ua66w
* <span class="token keyword">@date</span>: 2022/7/26 7:18
*/</span>
<span class="token keyword">public</span> <span class="token keyword">class</span> <span class="token class-name">User</span> <span class="token punctuation">{</span>
    <span class="token keyword">private</span> <span class="token class-name">Integer</span> id<span class="token punctuation">;</span>
    <span class="token keyword">private</span> <span class="token class-name">String</span> username<span class="token punctuation">;</span>
    <span class="token keyword">private</span> <span class="token class-name">String</span> password<span class="token punctuation">;</span>
    <span class="token keyword">private</span> <span class="token class-name">Integer</span> age<span class="token punctuation">;</span>
    <span class="token keyword">private</span> <span class="token class-name">String</span> sex<span class="token punctuation">;</span><span class="token comment">//数据库中文为char类型</span>
    <span class="token keyword">private</span> <span class="token class-name">String</span> email<span class="token punctuation">;</span>
    
    <span class="token keyword">public</span> <span class="token class-name">User</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
    <span class="token punctuation">}</span>
    
    <span class="token keyword">public</span> <span class="token class-name">User</span><span class="token punctuation">(</span><span class="token class-name">Integer</span> id<span class="token punctuation">,</span> <span class="token class-name">String</span> username<span class="token punctuation">,</span> <span class="token class-name">String</span> password<span class="token punctuation">,</span> <span class="token class-name">Integer</span> age<span class="token punctuation">,</span> <span class="token class-name">String</span> sex<span class="token punctuation">,</span> <span class="token class-name">String</span> email<span class="token punctuation">)</span> <span class="token punctuation">{</span>
        <span class="token keyword">this</span><span class="token punctuation">.</span>id <span class="token operator">=</span> id<span class="token punctuation">;</span>
        <span class="token keyword">this</span><span class="token punctuation">.</span>username <span class="token operator">=</span> username<span class="token punctuation">;</span>
        <span class="token keyword">this</span><span class="token punctuation">.</span>password <span class="token operator">=</span> password<span class="token punctuation">;</span>
        <span class="token keyword">this</span><span class="token punctuation">.</span>age <span class="token operator">=</span> age<span class="token punctuation">;</span>
        <span class="token keyword">this</span><span class="token punctuation">.</span>sex <span class="token operator">=</span> sex<span class="token punctuation">;</span>
        <span class="token keyword">this</span><span class="token punctuation">.</span>email <span class="token operator">=</span> email<span class="token punctuation">;</span>
    <span class="token punctuation">}</span>
    
    <span class="token keyword">public</span> <span class="token class-name">Integer</span> <span class="token function">getId</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
        <span class="token keyword">return</span> id<span class="token punctuation">;</span>
    <span class="token punctuation">}</span>
    
    <span class="token keyword">public</span> <span class="token keyword">void</span> <span class="token function">setId</span><span class="token punctuation">(</span><span class="token class-name">Integer</span> id<span class="token punctuation">)</span> <span class="token punctuation">{</span>
        <span class="token keyword">this</span><span class="token punctuation">.</span>id <span class="token operator">=</span> id<span class="token punctuation">;</span>
    <span class="token punctuation">}</span>
    
    <span class="token keyword">public</span> <span class="token class-name">String</span> <span class="token function">getUsername</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
        <span class="token keyword">return</span> username<span class="token punctuation">;</span>
    <span class="token punctuation">}</span>
    
    <span class="token keyword">public</span> <span class="token keyword">void</span> <span class="token function">setUsername</span><span class="token punctuation">(</span><span class="token class-name">String</span> username<span class="token punctuation">)</span> <span class="token punctuation">{</span>
        <span class="token keyword">this</span><span class="token punctuation">.</span>username <span class="token operator">=</span> username<span class="token punctuation">;</span>
    <span class="token punctuation">}</span>
    
    <span class="token keyword">public</span> <span class="token class-name">String</span> <span class="token function">getPassword</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
        <span class="token keyword">return</span> password<span class="token punctuation">;</span>
    <span class="token punctuation">}</span>
    
    <span class="token keyword">public</span> <span class="token keyword">void</span> <span class="token function">setPassword</span><span class="token punctuation">(</span><span class="token class-name">String</span> password<span class="token punctuation">)</span> <span class="token punctuation">{</span>
        <span class="token keyword">this</span><span class="token punctuation">.</span>password <span class="token operator">=</span> password<span class="token punctuation">;</span>
    <span class="token punctuation">}</span>
    
    <span class="token keyword">public</span> <span class="token class-name">Integer</span> <span class="token function">getAge</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
        <span class="token keyword">return</span> age<span class="token punctuation">;</span>
    <span class="token punctuation">}</span>
    
    <span class="token keyword">public</span> <span class="token keyword">void</span> <span class="token function">setAge</span><span class="token punctuation">(</span><span class="token class-name">Integer</span> age<span class="token punctuation">)</span> <span class="token punctuation">{</span>
        <span class="token keyword">this</span><span class="token punctuation">.</span>age <span class="token operator">=</span> age<span class="token punctuation">;</span>
    <span class="token punctuation">}</span>
    
    <span class="token keyword">public</span> <span class="token class-name">String</span> <span class="token function">getSex</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
        <span class="token keyword">return</span> sex<span class="token punctuation">;</span>
    <span class="token punctuation">}</span>
    
    <span class="token keyword">public</span> <span class="token keyword">void</span> <span class="token function">setSex</span><span class="token punctuation">(</span><span class="token class-name">String</span> sex<span class="token punctuation">)</span> <span class="token punctuation">{</span>
        <span class="token keyword">this</span><span class="token punctuation">.</span>sex <span class="token operator">=</span> sex<span class="token punctuation">;</span>
    <span class="token punctuation">}</span>
    
    <span class="token keyword">public</span> <span class="token class-name">String</span> <span class="token function">getEmail</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
        <span class="token keyword">return</span> email<span class="token punctuation">;</span>
    <span class="token punctuation">}</span>
    
    <span class="token keyword">public</span> <span class="token keyword">void</span> <span class="token function">setEmail</span><span class="token punctuation">(</span><span class="token class-name">String</span> email<span class="token punctuation">)</span> <span class="token punctuation">{</span>
        <span class="token keyword">this</span><span class="token punctuation">.</span>email <span class="token operator">=</span> email<span class="token punctuation">;</span>
    <span class="token punctuation">}</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ul>
<li>创建mapper接口：
<ul>
<li>mapper接口相当于service接口，但不需要提供实现类 ，实现类由MyBatis生成。</li>
</ul>
</li>
</ul>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token keyword">package</span> <span class="token namespace">iceriver<span class="token punctuation">.</span>mybatis<span class="token punctuation">.</span>mapper</span><span class="token punctuation">;</span>

<span class="token doc-comment comment">/**
 * <span class="token keyword">@author</span>: INFINITY https://developer.aliyun.com/profile/sagwrxp2ua66w
 * <span class="token keyword">@date</span>: 2022/7/26 7:22
 */</span>
<span class="token keyword">public</span> <span class="token keyword">interface</span> <span class="token class-name">UserMapper</span> <span class="token punctuation">{</span>
    <span class="token doc-comment comment">/**
     * 添加用户
     * <span class="token keyword">@return</span> 受影响的行数
     */</span>
    <span class="token keyword">int</span> <span class="token function">insertUser</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ol start="3">
<li>创建MyBatis映射文件：
<ul>
<li><code v-pre>ORM</code>：<code v-pre>Object Relationship Mapping</code>对象关系映射。
<ul>
<li>对象：Java的实体类对象。</li>
<li>关系：关系型数据库。</li>
<li>映射：二者之间的对应关系 。</li>
</ul>
</li>
<li>Java与数据库的对应关系：
<ul>
<li>类&lt;---&gt;表</li>
<li>属性&lt;---&gt;字段/列</li>
<li>对象&lt;---&gt;记录/行</li>
</ul>
</li>
<li>映射文件命名规则：
<ul>
<li>表所对应的实体类的<code v-pre>类名+Mapper.xml</code>
<ul>
<li>例如：表t_user，映射的实体类为User，所对应的映射文件为<code v-pre>UserMapper.xml</code></li>
</ul>
</li>
<li>一个映射文件对应一个实体类，对应一张表的操作</li>
<li>MyBatis映射文件用于编写SQL，访问以及操作表中的数据</li>
<li>MyBatis映射文件存放的位置是<code v-pre>src/main/resources/mappers</code>目录下</li>
</ul>
</li>
<li>官方文档<code v-pre>Getting Started</code>提供了映射文件的模板【正文第4页】</li>
<li>映射文件须与mapper接口文件保持两个一致：
<ul>
<li>映射文件的命名空间（namespace）和mapper接口的全类名和保持一致</li>
<li>映射文件中编写SQL的标签的id属性和mapper接口中方法的方法名保持一致</li>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1658793934195-11eb223e-e70a-415e-8d56-13586561d17e.png#clientId=u75362e1a-0f0f-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=152&amp;id=u509bbf95&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=152&amp;originWidth=677&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=21170&amp;status=done&amp;style=none&amp;taskId=u6af685ff-c4a7-4efd-925b-3697c991c46&amp;title=&amp;width=677" alt="image.png" loading="lazy"></li>
</ul>
</li>
</ul>
</li>
<li>核心配置文件中引入映射文件：
<ul>
<li>以路径的形式引入：
<ul>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1658792570667-ce4f45a6-d62c-4064-9fb5-148285a6a0ea.png#clientId=u75362e1a-0f0f-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=94&amp;id=ua121363a&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=94&amp;originWidth=469&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=11118&amp;status=done&amp;style=none&amp;taskId=u97124be8-e423-4404-9419-b5dd7532942&amp;title=&amp;width=469" alt="image.png" loading="lazy"></li>
</ul>
</li>
</ul>
</li>
<li>执行测试：
<ul>
<li>在<code v-pre>src/test/java</code>下创建测试目录及测试文件
<ul>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1658794182068-7f177a9f-ef1a-4c44-9e4f-17d4ae882071.png#clientId=u75362e1a-0f0f-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=81&amp;id=uddf7bcd9&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=81&amp;originWidth=254&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=4660&amp;status=done&amp;style=none&amp;taskId=ucacafb6d-71bc-4b8a-91f0-c6da5ad3887&amp;title=&amp;width=254" alt="image.png" loading="lazy"></li>
</ul>
</li>
<li>编写测试方法：</li>
</ul>
</li>
</ol>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token keyword">package</span> <span class="token namespace">iceriver<span class="token punctuation">.</span>mybatis<span class="token punctuation">.</span>test</span><span class="token punctuation">;</span>

<span class="token keyword">import</span> <span class="token import"><span class="token namespace">iceriver<span class="token punctuation">.</span>mybatis<span class="token punctuation">.</span>mapper<span class="token punctuation">.</span></span><span class="token class-name">UserMapper</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">org<span class="token punctuation">.</span>apache<span class="token punctuation">.</span>ibatis<span class="token punctuation">.</span>io<span class="token punctuation">.</span></span><span class="token class-name">Resources</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">org<span class="token punctuation">.</span>apache<span class="token punctuation">.</span>ibatis<span class="token punctuation">.</span>session<span class="token punctuation">.</span></span><span class="token class-name">SqlSession</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">org<span class="token punctuation">.</span>apache<span class="token punctuation">.</span>ibatis<span class="token punctuation">.</span>session<span class="token punctuation">.</span></span><span class="token class-name">SqlSessionFactory</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">org<span class="token punctuation">.</span>apache<span class="token punctuation">.</span>ibatis<span class="token punctuation">.</span>session<span class="token punctuation">.</span></span><span class="token class-name">SqlSessionFactoryBuilder</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">org<span class="token punctuation">.</span>junit<span class="token punctuation">.</span></span><span class="token class-name">Test</span></span><span class="token punctuation">;</span>

<span class="token keyword">import</span> <span class="token import"><span class="token namespace">java<span class="token punctuation">.</span>io<span class="token punctuation">.</span></span><span class="token class-name">IOException</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">java<span class="token punctuation">.</span>io<span class="token punctuation">.</span></span><span class="token class-name">InputStream</span></span><span class="token punctuation">;</span>

<span class="token doc-comment comment">/**
 * <span class="token keyword">@author</span>: INFINITY https://developer.aliyun.com/profile/sagwrxp2ua66w
 * <span class="token keyword">@date</span>: 2022/7/26 7:45
 */</span>
<span class="token keyword">public</span> <span class="token keyword">class</span> <span class="token class-name">UserMapperTest</span> <span class="token punctuation">{</span>
    <span class="token annotation punctuation">@Test</span>
    <span class="token keyword">public</span> <span class="token keyword">void</span> <span class="token function">testInsertUser</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token keyword">throws</span> <span class="token class-name">IOException</span> <span class="token punctuation">{</span>
        <span class="token comment">// 1. 加载核心配置文件</span>
        <span class="token class-name">InputStream</span> istream <span class="token operator">=</span> <span class="token class-name">Resources</span><span class="token punctuation">.</span><span class="token function">getResourceAsStream</span><span class="token punctuation">(</span><span class="token string">"mybatis-config.xml"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token comment">// 2. 获取SqlSessionFactoryBuilder对象</span>
        <span class="token class-name">SqlSessionFactoryBuilder</span> sqlSessionFactoryBuilder <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">SqlSessionFactoryBuilder</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token comment">// 3. 获取SqlSessionFactory对象</span>
        <span class="token class-name">SqlSessionFactory</span> sqlSessionFactory <span class="token operator">=</span> sqlSessionFactoryBuilder<span class="token punctuation">.</span><span class="token function">build</span><span class="token punctuation">(</span>istream<span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token comment">// 4. 获取SqlSession对象</span>
        <span class="token class-name">SqlSession</span> sqlSession <span class="token operator">=</span> sqlSessionFactory<span class="token punctuation">.</span><span class="token function">openSession</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token comment">// 5. 获取mapper接口（实现类的）对象</span>
        <span class="token class-name">UserMapper</span> userMapper <span class="token operator">=</span> sqlSession<span class="token punctuation">.</span><span class="token function">getMapper</span><span class="token punctuation">(</span><span class="token class-name">UserMapper</span><span class="token punctuation">.</span><span class="token keyword">class</span><span class="token punctuation">)</span><span class="token punctuation">;</span><span class="token comment">//底层使用了代理模式创建实现类</span>
        <span class="token comment">// 6. 调用mapper接口方法，执行测试</span>
        <span class="token keyword">int</span> result <span class="token operator">=</span> userMapper<span class="token punctuation">.</span><span class="token function">insertUser</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token comment">// 7. 提交事务</span>
        sqlSession<span class="token punctuation">.</span><span class="token function">commit</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span><span class="token comment">//由于核心配置文件开启了事务：&lt;transactionManager type="JDBC"/>，所以这里需要提交</span>
        <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span>result<span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token punctuation">}</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><pre><code>  - 第4步：获取sqlsession时传入参数`true`，即可设置为自动提交事务
  - `SqlSession`：代表Java程序和数据库之间的会话。（HttpSession是Java程序和浏览器之间的会话）
  - `SqlSessionFactory`：是“生产”`SqlSession`的“工厂”。
  - 工厂模式：如果创建某一个对象，使用的过程基本固定，那么我们就可以把创建这个对象的相关代码封装到一个“工厂类”中，以后都使用这个工厂类来“生产”我们需要的对象。 
</code></pre>
<h4 id="_1-2-3-引入log4j日志功能" tabindex="-1"><a class="header-anchor" href="#_1-2-3-引入log4j日志功能" aria-hidden="true">#</a> 1.2.3 引入log4j日志功能</h4>
<ol>
<li>在父工程<code v-pre>pom.xml</code>中加入依赖：
<ul>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1658795385123-6425e2ac-3dfb-40fb-ad61-736d1cd5df87.png#clientId=u75362e1a-0f0f-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=139&amp;id=u42b6251c&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=139&amp;originWidth=299&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=10340&amp;status=done&amp;style=none&amp;taskId=uf034644b-b270-41ab-a4a1-feb56fe4490&amp;title=&amp;width=299" alt="image.png" loading="lazy"></li>
</ul>
</li>
<li>在子工程<code v-pre>src/main/resources</code>目录下创建<code v-pre>log4j.xml</code></li>
</ol>
<div class="language-xml ext-xml line-numbers-mode"><pre v-pre class="language-xml"><code><span class="token prolog">&lt;?xml version="1.0" encoding="UTF-8" ?></span>
<span class="token doctype"><span class="token punctuation">&lt;!</span><span class="token doctype-tag">DOCTYPE</span> <span class="token name">log4j:configuration</span> <span class="token name">SYSTEM</span> <span class="token string">"log4j.dtd"</span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span><span class="token namespace">log4j:</span>configuration</span> <span class="token attr-name"><span class="token namespace">xmlns:</span>log4j</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>http://jakarta.apache.org/log4j/<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>appender</span> <span class="token attr-name">name</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>STDOUT<span class="token punctuation">"</span></span> <span class="token attr-name">class</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>org.apache.log4j.ConsoleAppender<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>param</span> <span class="token attr-name">name</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>Encoding<span class="token punctuation">"</span></span> <span class="token attr-name">value</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>UTF-8<span class="token punctuation">"</span></span> <span class="token punctuation">/></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>layout</span> <span class="token attr-name">class</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>org.apache.log4j.PatternLayout<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
      <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>param</span> <span class="token attr-name">name</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>ConversionPattern<span class="token punctuation">"</span></span> <span class="token attr-name">value</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>%-5p %d{MM-dd HH:mm:ss,SSS}%m (%F:%L) \n<span class="token punctuation">"</span></span> <span class="token punctuation">/></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>layout</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>appender</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>logger</span> <span class="token attr-name">name</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>java.sql<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>level</span> <span class="token attr-name">value</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>debug<span class="token punctuation">"</span></span> <span class="token punctuation">/></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>logger</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>logger</span> <span class="token attr-name">name</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>org.apache.ibatis<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>level</span> <span class="token attr-name">value</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>info<span class="token punctuation">"</span></span> <span class="token punctuation">/></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>logger</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>root</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>level</span> <span class="token attr-name">value</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>debug<span class="token punctuation">"</span></span> <span class="token punctuation">/></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>appender-ref</span> <span class="token attr-name">ref</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>STDOUT<span class="token punctuation">"</span></span> <span class="token punctuation">/></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>root</span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span><span class="token namespace">log4j:</span>configuration</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ul>
<li>放到父工程<code v-pre>src/main/resources</code>目录下报错，不知道为什么。</li>
<li><code v-pre>&lt;level value=&quot;debug&quot; /&gt;</code>中<code v-pre>debug</code>代表输出信息级别的高低
<ul>
<li><code v-pre>FATAL(致命)&gt;ERROR(错误)&gt;WARN(警告)&gt;INFO(信息)&gt;DEBUG(调试)</code></li>
<li>输出的信息内容详细程度从右至左提高</li>
</ul>
</li>
</ul>
<h3 id="_1-3-mybatis的增删改查" tabindex="-1"><a class="header-anchor" href="#_1-3-mybatis的增删改查" aria-hidden="true">#</a> 1.3 MyBatis的增删改查</h3>
<h4 id="_1-3-1-添加" tabindex="-1"><a class="header-anchor" href="#_1-3-1-添加" aria-hidden="true">#</a> 1.3.1 添加</h4>
<div class="language-xml ext-xml line-numbers-mode"><pre v-pre class="language-xml"><code><span class="token comment">&lt;!--  int insertUser();  --></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>insert</span> <span class="token attr-name">id</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>insertUser<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
  insert into t_user values(null,'admin','123456',23,'女','12315415@qq.com')
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>insert</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><h4 id="_1-3-2-修改" tabindex="-1"><a class="header-anchor" href="#_1-3-2-修改" aria-hidden="true">#</a> 1.3.2 修改</h4>
<div class="language-xml ext-xml line-numbers-mode"><pre v-pre class="language-xml"><code><span class="token comment">&lt;!--  void updateUser();  --></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>update</span> <span class="token attr-name">id</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>updateUser<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
  update t_user set username = 'guest' where id = 6
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>update</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><h4 id="_1-3-3-删除" tabindex="-1"><a class="header-anchor" href="#_1-3-3-删除" aria-hidden="true">#</a> 1.3.3 删除</h4>
<div class="language-xml ext-xml line-numbers-mode"><pre v-pre class="language-xml"><code><span class="token comment">&lt;!-- void deleteUser(); --></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>delete</span> <span class="token attr-name">id</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>deleteUser<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
  delete from t_user where id = 8
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>delete</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><h4 id="_1-3-4-查询" tabindex="-1"><a class="header-anchor" href="#_1-3-4-查询" aria-hidden="true">#</a> 1.3.4 查询</h4>
<div class="language-xml ext-xml line-numbers-mode"><pre v-pre class="language-xml"><code><span class="token comment">&lt;!-- User getUserById(); --></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>select</span> <span class="token attr-name">id</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>getUserById<span class="token punctuation">"</span></span> <span class="token attr-name">resultType</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>iceriver.mybatis.pojo.User<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
  select * form t_user where id = 7
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>select</span><span class="token punctuation">></span></span>

<span class="token comment">&lt;!-- List&lt;User> getAllUser(); --></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>select</span> <span class="token attr-name">id</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>getAllUser<span class="token punctuation">"</span></span> <span class="token attr-name">resultType</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>iceriver.mybatis.pojo.User<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
  select * from t_user
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>select</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ul>
<li>查询的标签select必须设置属性<code v-pre>resultType</code>或<code v-pre>resultMap</code>，用于设置实体类和数据库表的映射关系
<ul>
<li><code v-pre>resultType</code>：自动映射，用于属性名和表中字段名一致的情况</li>
<li><code v-pre>resultMap</code>：自定义映射，用于一对多或多对一或字段名和属性名不一致的情况</li>
</ul>
</li>
<li>当查询的数据为多条时，不能使用实体类作为返回值，只能使用集合，否则会抛出异常<code v-pre>TooManyResultsException</code>；但是若查询的数据只有一条，可以使用实体类或集合作为返回值</li>
</ul>
<h3 id="_1-4-核心配置文件详解" tabindex="-1"><a class="header-anchor" href="#_1-4-核心配置文件详解" aria-hidden="true">#</a> 1.4 核心配置文件详解</h3>
<h4 id="_1-4-1-文件标签" tabindex="-1"><a class="header-anchor" href="#_1-4-1-文件标签" aria-hidden="true">#</a> 1.4.1 文件标签</h4>
<div class="language-xml ext-xml line-numbers-mode"><pre v-pre class="language-xml"><code><span class="token prolog">&lt;?xml version="1.0" encoding="UTF-8" ?></span>
<span class="token doctype"><span class="token punctuation">&lt;!</span><span class="token doctype-tag">DOCTYPE</span> <span class="token name">configuration</span>
        <span class="token name">PUBLIC</span> <span class="token string">"-//MyBatis.org//DTD Config 3.0//EN"</span>
        <span class="token string">"http://MyBatis.org/dtd/MyBatis-3-config.dtd"</span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>configuration</span><span class="token punctuation">></span></span>
    <span class="token comment">&lt;!--引入properties文件，此时就可以${属性名}的方式访问属性值--></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>properties</span> <span class="token attr-name">resource</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>jdbc.properties<span class="token punctuation">"</span></span><span class="token punctuation">/></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>typeAliases</span><span class="token punctuation">></span></span>
        <span class="token comment">&lt;!--
            typeAlias：设置某个具体的类型的别名
            属性： type：需要设置别名的类型的全类名
                  alias：设置此类型的别名，
                        （1）若设置了type，但没设置alias，则UserMapper.xml中，该类型拥有默认的别名，即类名且不区分大小写。
                        （2）若设置此属性，则UserMapper.xml中，此时该类型的别名只能使用alias所设置的值。
                        （3）若没有设置type，也没设置alias，则UserMapper.xml中只能使用对应类型的全类名
        --></span>
        <span class="token comment">&lt;!--&lt;typeAlias type="iceriver.mybatis.pojo.User"/>--></span>
        <span class="token comment">&lt;!--&lt;typeAlias type="iceriver.mybatis.pojo.User" alias="abc">&lt;/typeAlias>--></span>
        <span class="token comment">&lt;!--以包为单位，设置改包下所有的类型都拥有默认的别名，即类名且不区分大小写--></span>
        <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>package</span> <span class="token attr-name">name</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>iceriver.mybatis.pojo<span class="token punctuation">"</span></span><span class="token punctuation">/></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>typeAliases</span><span class="token punctuation">></span></span>
    <span class="token comment">&lt;!--
        environments：设置多个连接数据库的环境
        属性：default：设置默认使用的环境的id
    --></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>environments</span> <span class="token attr-name">default</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>mysql_test<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
        <span class="token comment">&lt;!--
            environment：设置具体的连接数据库的环境信息
            属性：id：设置环境的唯一标识，可通过environments标签中的default设置某一个环境的id，表示默认使用的环境
        --></span>
        <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>environment</span> <span class="token attr-name">id</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>mysql_test<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
            <span class="token comment">&lt;!--
                transactionManager：设置事务管理方式
                属性：type：设置事务管理方式，type="JDBC|MANAGED"
                     type="JDBC"：设置当前环境的事务管理都必须手动处理
                     type="MANAGED"：设置事务被管理，例如spring中的AOP
            --></span>
            <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>transactionManager</span> <span class="token attr-name">type</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>JDBC<span class="token punctuation">"</span></span><span class="token punctuation">/></span></span>
            <span class="token comment">&lt;!--
                dataSource：设置数据源
                属性：type：设置数据源的类型，type="POOLED|UNPOOLED|JNDI"
                    （1）type="POOLED"：使用数据库连接池，即会将创建的连接进行缓存，下次使用可以从缓存中直接获取，不需要重新创建
                    （2）type="UNPOOLED"：不使用数据库连接池，即每次使用连接都需要重新创建
                    （3）type="JNDI"：调用上下文中的数据源
            --></span>
            <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>dataSource</span> <span class="token attr-name">type</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>POOLED<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
                <span class="token comment">&lt;!--设置驱动类的全类名--></span>
                <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>property</span> <span class="token attr-name">name</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>driver<span class="token punctuation">"</span></span> <span class="token attr-name">value</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>${jdbc.driver}<span class="token punctuation">"</span></span><span class="token punctuation">/></span></span>
                <span class="token comment">&lt;!--设置连接数据库的连接地址--></span>
                <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>property</span> <span class="token attr-name">name</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>url<span class="token punctuation">"</span></span> <span class="token attr-name">value</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>${jdbc.url}<span class="token punctuation">"</span></span><span class="token punctuation">/></span></span>
                <span class="token comment">&lt;!--设置连接数据库的用户名--></span>
                <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>property</span> <span class="token attr-name">name</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>username<span class="token punctuation">"</span></span> <span class="token attr-name">value</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>${jdbc.username}<span class="token punctuation">"</span></span><span class="token punctuation">/></span></span>
                <span class="token comment">&lt;!--设置连接数据库的密码--></span>
                <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>property</span> <span class="token attr-name">name</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>password<span class="token punctuation">"</span></span> <span class="token attr-name">value</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>${jdbc.password}<span class="token punctuation">"</span></span><span class="token punctuation">/></span></span>
            <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>dataSource</span><span class="token punctuation">></span></span>
        <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>environment</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>environments</span><span class="token punctuation">></span></span>
    <span class="token comment">&lt;!--引入映射文件--></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>mappers</span><span class="token punctuation">></span></span>
        <span class="token comment">&lt;!--&lt;mapper resource="mappers/UserMapper.xml"/>--></span>
        <span class="token comment">&lt;!--
            以包为单位，将包下所有的映射文件引入核心配置文件
            要求：1. mapper接口所在的包和映射文件所在的包一致
                 2. mapper接口的名字和映射文件的名字一致
        --></span>
        <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>package</span> <span class="token attr-name">name</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>iceriver.mybatis.mapper<span class="token punctuation">"</span></span><span class="token punctuation">/></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>mappers</span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>configuration</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ul>
<li>核心配置文件中<code v-pre>&lt;configuration&gt;</code>的子标签必须按照固定的顺序书写：
<ul>
<li><code v-pre>properties?,settings?,typeAliases?,typeHandlers?,objectFactory?,objectWrapperFactory?,reflectorFactory?,plugins?,environments?,databaseIdProvider?,mappers?</code></li>
</ul>
</li>
</ul>
<h4 id="_1-4-2-idea中设置配置文件模板" tabindex="-1"><a class="header-anchor" href="#_1-4-2-idea中设置配置文件模板" aria-hidden="true">#</a> 1.4.2 IDEA中设置配置文件模板</h4>
<ol>
<li>核心配置文件模板：
<ul>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1658806611584-4957a72e-5fba-474f-abfb-7b5144741501.png#clientId=u75362e1a-0f0f-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=713&amp;id=udf094fdc&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=713&amp;originWidth=922&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=135170&amp;status=done&amp;style=none&amp;taskId=u104180a2-5ef4-43b2-ae9e-b2963e1d4af&amp;title=&amp;width=922" alt="image.png" loading="lazy"></li>
</ul>
</li>
<li>映射文件模板：
<ul>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1658806803791-ae5218a9-ecb0-4d82-9891-08cee9326f17.png#clientId=u75362e1a-0f0f-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=713&amp;id=ue6954bcf&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=713&amp;originWidth=922&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=116040&amp;status=done&amp;style=none&amp;taskId=u2fa18a4c-d9ab-4245-9e9c-a0ecf07e9c5&amp;title=&amp;width=922" alt="image.png" loading="lazy"></li>
</ul>
</li>
</ol>
<h2 id="第2章-mybatis获取参数值" tabindex="-1"><a class="header-anchor" href="#第2章-mybatis获取参数值" aria-hidden="true">#</a> 第2章 MyBatis获取参数值</h2>
<h3 id="_2-1-获取参数值的两种方式" tabindex="-1"><a class="header-anchor" href="#_2-1-获取参数值的两种方式" aria-hidden="true">#</a> 2.1 获取参数值的两种方式</h3>
<h4 id="_2-1-1-字符串拼接" tabindex="-1"><a class="header-anchor" href="#_2-1-1-字符串拼接" aria-hidden="true">#</a> 2.1.1 <code v-pre>${}</code>字符串拼接</h4>
<ol>
<li>本质是字符串拼接</li>
<li>参数为字符串类型或日期类型的字段进行赋值时，需要手动加单引号</li>
</ol>
<h4 id="_2-1-2-占位符【优先使用】" tabindex="-1"><a class="header-anchor" href="#_2-1-2-占位符【优先使用】" aria-hidden="true">#</a> 2.1.2 <code v-pre>#{}</code>占位符【优先使用】</h4>
<ol>
<li>本质是占位符赋值</li>
<li>参数为字符串类型或日期类型的字段进行赋值时，可以自动添加单引号</li>
</ol>
<h3 id="_2-2-获取参数值的多种情况" tabindex="-1"><a class="header-anchor" href="#_2-2-获取参数值的多种情况" aria-hidden="true">#</a> 2.2 获取参数值的多种情况</h3>
<h4 id="_2-2-1-单个字面量类型的参数" tabindex="-1"><a class="header-anchor" href="#_2-2-1-单个字面量类型的参数" aria-hidden="true">#</a> 2.2.1 单个字面量类型的参数</h4>
<ol>
<li><code v-pre>#{param}</code>：param名称任意，建议见明知意</li>
<li><code v-pre>'${param}'</code>：param名称任意，建议见明知意；注意单引号<code v-pre>''</code>。</li>
</ol>
<h4 id="_2-2-2-多个字面量类型的参数" tabindex="-1"><a class="header-anchor" href="#_2-2-2-多个字面量类型的参数" aria-hidden="true">#</a> 2.2.2 多个字面量类型的参数</h4>
<ol>
<li>若mapper接口中的方法参数为多个时，此时MyBatis会自动将这些参数放在一个map集合中，以<code v-pre>arg0</code>,<code v-pre>arg1.</code>..为键，以参数为值；以<code v-pre>param1</code>,<code v-pre>param2</code>...为键，以参数为值；
<ul>
<li>注意<code v-pre>arg</code>从0开始，<code v-pre>param</code>从1开始</li>
</ul>
</li>
<li>因此只需要通过<code v-pre>${}</code>和<code v-pre>#{}</code>访问map集合的键就可以获取相对应的值。
<ul>
<li>注意<code v-pre>${}</code>需要手动加单引号。</li>
</ul>
</li>
<li><code v-pre>arg0</code>和<code v-pre>param1</code>可以混用，但要注意先后顺序。</li>
</ol>
<h4 id="_2-2-3-map集合类型的参数" tabindex="-1"><a class="header-anchor" href="#_2-2-3-map集合类型的参数" aria-hidden="true">#</a> 2.2.3 map集合类型的参数</h4>
<ul>
<li>若mapper接口中的方法需要的参数为多个时，此时可以手动创建map集合，将这些数据放在map中，只需要通过<code v-pre>${}</code>和<code v-pre>#{}</code>访问map集合的键就可以获取相对应的值，注意<code v-pre>${}</code>需要手动加单引号。
<ul>
<li>这里的参数名称是自定义map集合时放入的名称。</li>
</ul>
</li>
</ul>
<h4 id="_2-2-4-实体类类型的参数【建议使用】" tabindex="-1"><a class="header-anchor" href="#_2-2-4-实体类类型的参数【建议使用】" aria-hidden="true">#</a> 2.2.4 实体类类型的参数【建议使用】</h4>
<ul>
<li>同2.2.3的访问方式，传入的参数名是实体类的属性名。——不需要使用<code v-pre>对象名.属性名</code>的方式调用，直接使用属性名。</li>
</ul>
<h4 id="_2-2-5-使用-param注解标识参数【建议使用】" tabindex="-1"><a class="header-anchor" href="#_2-2-5-使用-param注解标识参数【建议使用】" aria-hidden="true">#</a> 2.2.5 使用<code v-pre>@param</code>注解标识参数【建议使用】</h4>
<ol>
<li>语句格式：<code v-pre>User checkLoginByParams(@Param(&quot;username&quot;) String username, @Param(&quot;password&quot;) String password);</code>
<ul>
<li>相当于给参数起别名。传参时别名起的啥，mapper映射文件就传啥。</li>
<li>或者以<code v-pre>param1</code>,<code v-pre>param2</code>...为参数</li>
</ul>
</li>
<li>源码：集合中会放2组参数：
<ul>
<li>以<code v-pre>@Param</code>注解的<code v-pre>value</code>属性值为键，以参数为值；</li>
<li>以<code v-pre>param1</code>,<code v-pre>param2</code>...为键，以参数为值。</li>
</ul>
</li>
</ol>
<h2 id="第3章-mybatis的各种查询功能" tabindex="-1"><a class="header-anchor" href="#第3章-mybatis的各种查询功能" aria-hidden="true">#</a> 第3章 MyBatis的各种查询功能</h2>
<blockquote>
<ul>
<li>建议查询语句不要写<code v-pre>;</code>以免将其作为通用查询，与其他查询组合时出现错误。</li>
</ul>
</blockquote>
<h3 id="_3-1-查询返回不同类型、数量结果" tabindex="-1"><a class="header-anchor" href="#_3-1-查询返回不同类型、数量结果" aria-hidden="true">#</a> 3.1 查询返回不同类型、数量结果</h3>
<h4 id="_3-1-1-查询返回一个实体类对象" tabindex="-1"><a class="header-anchor" href="#_3-1-1-查询返回一个实体类对象" aria-hidden="true">#</a> 3.1.1 查询返回一个实体类对象</h4>
<ul>
<li>返回一个数据可以以实体类对象或集合接收。</li>
</ul>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token doc-comment comment">/**
* 根据用户id查询用户信息
* <span class="token keyword">@param</span> <span class="token parameter">id</span>
* <span class="token keyword">@return</span>
*/</span>
<span class="token class-name">User</span> <span class="token function">getUserById</span><span class="token punctuation">(</span><span class="token annotation punctuation">@Param</span><span class="token punctuation">(</span><span class="token string">"id"</span><span class="token punctuation">)</span> <span class="token keyword">int</span> id<span class="token punctuation">)</span><span class="token punctuation">;</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><div class="language-xml ext-xml line-numbers-mode"><pre v-pre class="language-xml"><code><span class="token comment">&lt;!--User getUserById(@Param("id") int id);--></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>select</span> <span class="token attr-name">id</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>getUserById<span class="token punctuation">"</span></span> <span class="token attr-name">resultType</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>User<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
  select * from t_user where id = #{id}
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>select</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><h4 id="_3-1-2-查询返回一个list集合" tabindex="-1"><a class="header-anchor" href="#_3-1-2-查询返回一个list集合" aria-hidden="true">#</a> 3.1.2 查询返回一个List集合</h4>
<ul>
<li>返回多个数据只能通过集合接收。</li>
</ul>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token doc-comment comment">/**
* 查询所有用户信息
* <span class="token keyword">@return</span>
*/</span>
<span class="token class-name">List</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">User</span><span class="token punctuation">></span></span> <span class="token function">getUserList</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><div class="language-xml ext-xml line-numbers-mode"><pre v-pre class="language-xml"><code><span class="token comment">&lt;!--List&lt;User> getUserList();--></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>select</span> <span class="token attr-name">id</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>getUserList<span class="token punctuation">"</span></span> <span class="token attr-name">resultType</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>User<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
  select * from t_user
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>select</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><h4 id="_3-1-3-查询返回单个数据" tabindex="-1"><a class="header-anchor" href="#_3-1-3-查询返回单个数据" aria-hidden="true">#</a> 3.1.3 查询返回单个数据</h4>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token doc-comment comment">/**
* 查询用户的总记录数
* <span class="token keyword">@return</span>
*/</span>
<span class="token keyword">int</span> <span class="token function">getCount</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><div class="language-xml ext-xml line-numbers-mode"><pre v-pre class="language-xml"><code><span class="token comment">&lt;!--
  在MyBatis映射文件的resultType中，对于Java中常用的类型都设置了类型别名
  例如：java.lang.Integer--></span>int|integer
  例如：int-->_int|_integer
  例如：Map-->map,List-->list
-->
<span class="token comment">&lt;!--int getCount();--></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>select</span> <span class="token attr-name">id</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>getCount<span class="token punctuation">"</span></span> <span class="token attr-name">resultType</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>_integer<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
  select count(id) from t_user
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>select</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ul>
<li>别名参见官方文档第15-16页
<ul>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1658839664147-fb3f0591-2275-42e9-93fd-2ed0511695c7.png#clientId=u75362e1a-0f0f-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=356&amp;id=u87618e2d&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=356&amp;originWidth=654&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=31593&amp;status=done&amp;style=none&amp;taskId=u8a46d85b-8928-499f-aa8f-4ba48876cbe&amp;title=&amp;width=654" alt="image.png" loading="lazy"></li>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1658839686192-12915529-45d2-41a8-a6be-9442acca3b8c.png#clientId=u75362e1a-0f0f-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=313&amp;id=u11de14cf&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=313&amp;originWidth=654&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=33985&amp;status=done&amp;style=none&amp;taskId=uc4d51d32-675f-4f2c-a1c5-a304682f948&amp;title=&amp;width=654" alt="image.png" loading="lazy"></li>
</ul>
</li>
</ul>
<h4 id="_3-1-4-查询一条数据为map集合" tabindex="-1"><a class="header-anchor" href="#_3-1-4-查询一条数据为map集合" aria-hidden="true">#</a> 3.1.4 查询一条数据为map集合</h4>
<ul>
<li>将实体类对象转换为map集合，或实体类对象的部分数据转换为集合。</li>
</ul>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token doc-comment comment">/**
* 根据用户id查询用户信息为map集合
* <span class="token keyword">@param</span> <span class="token parameter">id</span>
* <span class="token keyword">@return</span>
*/</span>
<span class="token class-name">Map</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">String</span><span class="token punctuation">,</span> <span class="token class-name">Object</span><span class="token punctuation">></span></span> <span class="token function">getUserToMap</span><span class="token punctuation">(</span><span class="token annotation punctuation">@Param</span><span class="token punctuation">(</span><span class="token string">"id"</span><span class="token punctuation">)</span> <span class="token keyword">int</span> id<span class="token punctuation">)</span><span class="token punctuation">;</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><div class="language-xml ext-xml line-numbers-mode"><pre v-pre class="language-xml"><code><span class="token comment">&lt;!--Map&lt;String, Object> getUserToMap(@Param("id") int id);--></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>select</span> <span class="token attr-name">id</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>getUserToMap<span class="token punctuation">"</span></span> <span class="token attr-name">resultType</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>map<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
  select * from t_user where id = #{id}
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>select</span><span class="token punctuation">></span></span>
<span class="token comment">&lt;!--结果：{password=123456, sex=男, id=1, age=23, username=admin}--></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><h4 id="_3-1-5-查询多条数据为map集合" tabindex="-1"><a class="header-anchor" href="#_3-1-5-查询多条数据为map集合" aria-hidden="true">#</a> 3.1.5 查询多条数据为map集合</h4>
<ol>
<li>方式一：</li>
</ol>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token doc-comment comment">/**
* 查询所有用户信息为map集合
* <span class="token keyword">@return</span>
* 将表中的数据以map集合的方式查询，一条数据对应一个map；若有多条数据，就会产生多个map集合，此
时可以将这些map放在一个list集合中获取
*/</span>
<span class="token class-name">List</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">Map</span><span class="token punctuation">&lt;</span><span class="token class-name">String</span><span class="token punctuation">,</span> <span class="token class-name">Object</span><span class="token punctuation">></span><span class="token punctuation">></span></span> <span class="token function">getAllUserToMap</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><div class="language-xml ext-xml line-numbers-mode"><pre v-pre class="language-xml"><code><span class="token comment">&lt;!--List&lt;Map&lt;String, Object>> getAllUserToMap();--></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>select</span> <span class="token attr-name">id</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>getAllUserToMap<span class="token punctuation">"</span></span> <span class="token attr-name">resultType</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>map<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
  select * from t_user
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>select</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ol start="2">
<li>方式二：
<ul>
<li>使用map集合接收，可以用<code v-pre>@MapKey(&quot;str&quot;)</code>指定某个字段为map集合的键，注意指定为键的属性必须不能重复。</li>
</ul>
</li>
</ol>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token doc-comment comment">/**
* 查询所有用户信息为map集合
* <span class="token keyword">@return</span>
* 将表中的数据以map集合的方式查询，一条数据对应一个map；若有多条数据，就会产生多个map集合，并
且最终要以一个map的方式返回数据，此时需要通过@MapKey注解设置map集合的键，值是每条数据所对应的
map集合
*/</span>
<span class="token annotation punctuation">@MapKey</span><span class="token punctuation">(</span><span class="token string">"id"</span><span class="token punctuation">)</span>
<span class="token class-name">Map</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">String</span><span class="token punctuation">,</span> <span class="token class-name">Object</span><span class="token punctuation">></span></span> <span class="token function">getAllUserToMap</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><div class="language-xml ext-xml line-numbers-mode"><pre v-pre class="language-xml"><code><span class="token comment">&lt;!--Map&lt;String, Object> getAllUserToMap();--></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>select</span> <span class="token attr-name">id</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>getAllUserToMap<span class="token punctuation">"</span></span> <span class="token attr-name">resultType</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>map<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
  select * from t_user
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>select</span><span class="token punctuation">></span></span>
结果：
<span class="token comment">&lt;!--
  {
    1={password=123456, sex=男, id=1, age=23, username=admin},
    2={password=123456, sex=男, id=2, age=23, username=张三},
    3={password=123456, sex=男, id=3, age=23, username=张三}
  } 
--></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><h3 id="_3-2-特殊sql查询" tabindex="-1"><a class="header-anchor" href="#_3-2-特殊sql查询" aria-hidden="true">#</a> 3.2 特殊SQL查询</h3>
<h4 id="_3-2-1-模糊查询" tabindex="-1"><a class="header-anchor" href="#_3-2-1-模糊查询" aria-hidden="true">#</a> 3.2.1 模糊查询</h4>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token doc-comment comment">/**
* 测试模糊查询
* <span class="token keyword">@param</span> <span class="token parameter">mohu</span>
* <span class="token keyword">@return</span>
*/</span>
<span class="token class-name">List</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">User</span><span class="token punctuation">></span></span> <span class="token function">testMohu</span><span class="token punctuation">(</span><span class="token annotation punctuation">@Param</span><span class="token punctuation">(</span><span class="token string">"mohu"</span><span class="token punctuation">)</span> <span class="token class-name">String</span> mohu<span class="token punctuation">)</span><span class="token punctuation">;</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><div class="language-xml ext-xml line-numbers-mode"><pre v-pre class="language-xml"><code><span class="token comment">&lt;!--List&lt;User> testMohu(@Param("mohu") String mohu);--></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>select</span> <span class="token attr-name">id</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>testMohu<span class="token punctuation">"</span></span> <span class="token attr-name">resultType</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>User<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
  <span class="token comment">&lt;!--select * from t_user where username like '%${mohu}%'--></span>
  <span class="token comment">&lt;!--select * from t_user where username like concat('%',#{mohu},'%')--></span>
  select * from t_user where username like "%"#{mohu}"%"
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>select</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ul>
<li>注意<code v-pre>${}</code>单引号与<code v-pre>#{}</code>双引号的区别。</li>
</ul>
<h4 id="_3-2-2-批量删除" tabindex="-1"><a class="header-anchor" href="#_3-2-2-批量删除" aria-hidden="true">#</a> 3.2.2 批量删除</h4>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token doc-comment comment">/**
* 批量删除
* <span class="token keyword">@param</span> <span class="token parameter">ids</span>
* <span class="token keyword">@return</span>
*/</span>
<span class="token keyword">int</span> <span class="token function">deleteMore</span><span class="token punctuation">(</span><span class="token annotation punctuation">@Param</span><span class="token punctuation">(</span><span class="token string">"ids"</span><span class="token punctuation">)</span> <span class="token class-name">String</span> ids<span class="token punctuation">)</span><span class="token punctuation">;</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><div class="language-xml ext-xml line-numbers-mode"><pre v-pre class="language-xml"><code><span class="token comment">&lt;!--int deleteMore(@Param("ids") String ids);--></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>delete</span> <span class="token attr-name">id</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>deleteMore<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
  delete from t_user where id in (${ids})
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>delete</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ul>
<li>不能使用<code v-pre>#{}</code>，因为SQL语句中，<code v-pre>in</code>的括号中不能写引号，而<code v-pre>#{}</code>会自动添加单引号
<ul>
<li><code v-pre>in (1,2,3)</code></li>
</ul>
</li>
</ul>
<h4 id="_3-2-3-动态设置表名" tabindex="-1"><a class="header-anchor" href="#_3-2-3-动态设置表名" aria-hidden="true">#</a> 3.2.3 动态设置表名</h4>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token doc-comment comment">/**
* 动态设置表名，查询所有的用户信息
* <span class="token keyword">@param</span> <span class="token parameter">tableName</span>
* <span class="token keyword">@return</span>
*/</span>
<span class="token class-name">List</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">User</span><span class="token punctuation">></span></span> <span class="token function">getAllUser</span><span class="token punctuation">(</span><span class="token annotation punctuation">@Param</span><span class="token punctuation">(</span><span class="token string">"tableName"</span><span class="token punctuation">)</span> <span class="token class-name">String</span> tableName<span class="token punctuation">)</span><span class="token punctuation">;</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><div class="language-xml ext-xml line-numbers-mode"><pre v-pre class="language-xml"><code><span class="token comment">&lt;!--List&lt;User> getAllUser(@Param("tableName") String tableName);--></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>select</span> <span class="token attr-name">id</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>getAllUser<span class="token punctuation">"</span></span> <span class="token attr-name">resultType</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>User<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
  select * from ${tableName}
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>select</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ul>
<li>不能使用<code v-pre>#{}</code>，因为SQL语句中，表明不能写引号，而<code v-pre>#{}</code>会自动添加单引号</li>
</ul>
<h4 id="_3-2-4-添加功能获取自增的主键" tabindex="-1"><a class="header-anchor" href="#_3-2-4-添加功能获取自增的主键" aria-hidden="true">#</a> 3.2.4 添加功能获取自增的主键</h4>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token doc-comment comment">/**
* 添加用户信息
* <span class="token keyword">@param</span> <span class="token parameter">user</span>
* <span class="token keyword">@return</span>
* useGeneratedKeys：设置使用自增的主键
* keyProperty：因为增删改有统一的返回值是受影响的行数，因此只能将获取的自增的主键放在传输的参
数user对象的某个属性中
*/</span>
<span class="token keyword">int</span> <span class="token function">insertUser</span><span class="token punctuation">(</span><span class="token class-name">User</span> user<span class="token punctuation">)</span><span class="token punctuation">;</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><div class="language-xml ext-xml line-numbers-mode"><pre v-pre class="language-xml"><code><span class="token comment">&lt;!--int insertUser(User user);--></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>insert</span> <span class="token attr-name">id</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>insertUser<span class="token punctuation">"</span></span> <span class="token attr-name">useGeneratedKeys</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>true<span class="token punctuation">"</span></span> <span class="token attr-name">keyProperty</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>id<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
  insert into t_user values(null,#{username},#{password},#{age},#{sex})
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>insert</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ul>
<li>MySQL添加数据后，返回的是受影响的行数，所以无法直接返回新增的主键值，但可以通过返回添加的对象，通过对象去调用主键值。</li>
<li>原生JDBC获取主键的方式：
<ul>
<li>遍历结果集可以获得主键</li>
</ul>
</li>
</ul>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token annotation punctuation">@Test</span>
<span class="token keyword">public</span> <span class="token keyword">void</span> <span class="token function">testJDBC</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token keyword">throws</span> <span class="token class-name">Exception</span> <span class="token punctuation">{</span>
    <span class="token class-name">Class</span><span class="token punctuation">.</span><span class="token function">forName</span><span class="token punctuation">(</span><span class="token string">""</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token class-name">Connection</span> connection <span class="token operator">=</span> <span class="token class-name">DriverManager</span><span class="token punctuation">.</span><span class="token function">getConnection</span><span class="token punctuation">(</span><span class="token string">""</span><span class="token punctuation">,</span> <span class="token string">""</span><span class="token punctuation">,</span> <span class="token string">""</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token class-name">PreparedStatement</span> ps <span class="token operator">=</span> connection<span class="token punctuation">.</span><span class="token function">prepareStatement</span><span class="token punctuation">(</span><span class="token string">"insert"</span><span class="token punctuation">,</span> <span class="token class-name">Statement</span><span class="token punctuation">.</span>RETURN_GENERATED_KEYS<span class="token punctuation">)</span><span class="token punctuation">;</span>
    ps<span class="token punctuation">.</span><span class="token function">executeUpdate</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token class-name">ResultSet</span> resultSet <span class="token operator">=</span> ps<span class="token punctuation">.</span><span class="token function">getGeneratedKeys</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><h2 id="第4章-自定义映射resultmap" tabindex="-1"><a class="header-anchor" href="#第4章-自定义映射resultmap" aria-hidden="true">#</a> 第4章 自定义映射resultMap</h2>
<h3 id="_4-1-resultmap处理sql字段与pojo属性不一致问题" tabindex="-1"><a class="header-anchor" href="#_4-1-resultmap处理sql字段与pojo属性不一致问题" aria-hidden="true">#</a> 4.1 resultMap处理sql字段与pojo属性不一致问题</h3>
<h4 id="_4-1-1-sql语句使用别名方式与pojo属性对应" tabindex="-1"><a class="header-anchor" href="#_4-1-1-sql语句使用别名方式与pojo属性对应" aria-hidden="true">#</a> 4.1.1 sql语句使用别名方式与pojo属性对应</h4>
<div class="language-xml ext-xml line-numbers-mode"><pre v-pre class="language-xml"><code><span class="token comment">&lt;!--List&lt;Emp> getAllEmp();--></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>select</span> <span class="token attr-name">id</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>getAllEmp<span class="token punctuation">"</span></span> <span class="token attr-name">resultType</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>emp<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
  select eid,emp_name empName,age,sex gender,email from t_emp
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>select</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><p><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1658884623220-a8e514e0-b539-4daa-9e64-98845f1cd88e.png#clientId=u262beab3-6cd1-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=115&amp;id=uafc71758&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=115&amp;originWidth=655&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=24857&amp;status=done&amp;style=none&amp;taskId=ua1725f06-b427-4223-a90e-96baa59f5ee&amp;title=&amp;width=655" alt="image.png" loading="lazy"></p>
<h4 id="_4-1-2-设置全局配置将-自动映射为驼峰" tabindex="-1"><a class="header-anchor" href="#_4-1-2-设置全局配置将-自动映射为驼峰" aria-hidden="true">#</a> 4.1.2 设置全局配置将<code v-pre>_</code>自动映射为驼峰</h4>
<ol>
<li><code v-pre>mybatis-config.xml</code>文件中开启<code v-pre>resultMap</code>全局配置
<ul>
<li>官方文档正文第12页</li>
</ul>
</li>
</ol>
<div class="language-xml ext-xml line-numbers-mode"><pre v-pre class="language-xml"><code><span class="token comment">&lt;!--设置MyBatis的全局配置--></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>settings</span><span class="token punctuation">></span></span>
  <span class="token comment">&lt;!--将 _ 自动映射为驼峰，emp_name:empName--></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>setting</span> <span class="token attr-name">name</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>mapUnderscoreToCamelCase<span class="token punctuation">"</span></span> <span class="token attr-name">value</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>true<span class="token punctuation">"</span></span><span class="token punctuation">/></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>settings</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><div class="language-xml ext-xml line-numbers-mode"><pre v-pre class="language-xml"><code><span class="token comment">&lt;!--List&lt;Emp> getAllEmp();--></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>select</span> <span class="token attr-name">id</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>getAllEmp<span class="token punctuation">"</span></span> <span class="token attr-name">resultType</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>emp<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
  select * from t_emp
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>select</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><p><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1658884742398-9f2d9136-8e83-4e56-9a8e-75209e654938.png#clientId=u262beab3-6cd1-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=119&amp;id=u90d2c1e3&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=119&amp;originWidth=677&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=24766&amp;status=done&amp;style=none&amp;taskId=u71a73ebe-e6ab-4580-aa39-7ec20fecfe6&amp;title=&amp;width=677" alt="image.png" loading="lazy"></p>
<h4 id="_4-1-3-当前mapper映射文件中进行自定义设置" tabindex="-1"><a class="header-anchor" href="#_4-1-3-当前mapper映射文件中进行自定义设置" aria-hidden="true">#</a> 4.1.3 当前mapper映射文件中进行自定义设置</h4>
<ul>
<li>可以不将表的所有字段都设置，如字段本身与属性名一致时可不设置，但建议全部进行设置。
<ul>
<li>不需要开启全局映射。</li>
<li>可以设置别名映射，比如将字段sex映射为属性gender。</li>
<li>注意：<code v-pre>&lt;select&gt;</code>的<code v-pre>resultMap</code>属性值，必须与<code v-pre>&lt;resultMap&gt;</code>的<code v-pre>id</code>属性值对应</li>
</ul>
</li>
</ul>
<div class="language-xml ext-xml line-numbers-mode"><pre v-pre class="language-xml"><code><span class="token comment">&lt;!--
  resultMap：设置自定义映射关系
    id：唯一标识，不能重复
    type：设置映射关系中的实体类类型
  子标签：
  id：设置主键的映射关系(主键的映射无论是否一致，都必须写)
  result：设置普通字段的映射关系
    property：设置映射关系中的属性名，必须是type属性所设置的实体类类型中的属性名
    column：设置映射关系中的字段名，必须是sql语句查询出的字段名
--></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>resultMap</span> <span class="token attr-name">id</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>empResultMap<span class="token punctuation">"</span></span> <span class="token attr-name">type</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>Emp<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>id</span> <span class="token attr-name">property</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>eid<span class="token punctuation">"</span></span> <span class="token attr-name">column</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>eid<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>id</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>result</span> <span class="token attr-name">property</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>empName<span class="token punctuation">"</span></span> <span class="token attr-name">column</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>emp_name<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>result</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>result</span> <span class="token attr-name">property</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>age<span class="token punctuation">"</span></span> <span class="token attr-name">column</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>age<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>result</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>result</span> <span class="token attr-name">property</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>gender<span class="token punctuation">"</span></span> <span class="token attr-name">column</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>sex<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>result</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>result</span> <span class="token attr-name">property</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>email<span class="token punctuation">"</span></span> <span class="token attr-name">column</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>email<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>result</span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>resultMap</span><span class="token punctuation">></span></span>

<span class="token comment">&lt;!--List&lt;Emp> getAllEmp();--></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>select</span> <span class="token attr-name">id</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>getAllEmp<span class="token punctuation">"</span></span> <span class="token attr-name">resultMap</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>empResultMap<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
  select * from t_emp
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>select</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><p><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1658885162323-bfa70c1a-532a-41f9-b9da-e23d7e2187c8.png#clientId=u262beab3-6cd1-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=118&amp;id=u0ce6c0a3&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=118&amp;originWidth=659&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=24908&amp;status=done&amp;style=none&amp;taskId=uda1f4e8c-5fea-4afb-a5e5-66ec6529aee&amp;title=&amp;width=659" alt="image.png" loading="lazy"></p>
<h3 id="_4-2-处理表中多对一的映射关系" tabindex="-1"><a class="header-anchor" href="#_4-2-处理表中多对一的映射关系" aria-hidden="true">#</a> 4.2 处理表中多对一的映射关系</h3>
<blockquote>
<ul>
<li>一对多：实体类中有个属性是实体类对象。</li>
</ul>
</blockquote>
<h4 id="_4-2-1-级联赋值" tabindex="-1"><a class="header-anchor" href="#_4-2-1-级联赋值" aria-hidden="true">#</a> 4.2.1 级联赋值</h4>
<div class="language-xml ext-xml line-numbers-mode"><pre v-pre class="language-xml"><code> <span class="token comment">&lt;!--处理多对一映射关系方式一：级联属性赋值--></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>resultMap</span> <span class="token attr-name">id</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>empAndDeptResultMapOne<span class="token punctuation">"</span></span> <span class="token attr-name">type</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>Emp<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>id</span> <span class="token attr-name">property</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>eid<span class="token punctuation">"</span></span> <span class="token attr-name">column</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>eid<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>id</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>result</span> <span class="token attr-name">property</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>empName<span class="token punctuation">"</span></span> <span class="token attr-name">column</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>emp_name<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>result</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>result</span> <span class="token attr-name">property</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>age<span class="token punctuation">"</span></span> <span class="token attr-name">column</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>age<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>result</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>result</span> <span class="token attr-name">property</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>gender<span class="token punctuation">"</span></span> <span class="token attr-name">column</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>sex<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>result</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>result</span> <span class="token attr-name">property</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>email<span class="token punctuation">"</span></span> <span class="token attr-name">column</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>email<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>result</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>result</span> <span class="token attr-name">property</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>dept.did<span class="token punctuation">"</span></span> <span class="token attr-name">column</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>did<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>result</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>result</span> <span class="token attr-name">property</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>dept.deptName<span class="token punctuation">"</span></span> <span class="token attr-name">column</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>dept_name<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>result</span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>resultMap</span><span class="token punctuation">></span></span>
<span class="token comment">&lt;!--Emp getEmpAndDept(@Param("eid") Integer eid);--></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>select</span> <span class="token attr-name">id</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>getEmpAndDept<span class="token punctuation">"</span></span> <span class="token attr-name">resultMap</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>empAndDeptResultMapOne<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
  select * from t_emp left join t_dept on t_emp.did = t_dept .did where t_emp.eid = #{eid}
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>select</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><p><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1658886106614-6070d82e-083e-4669-b588-8c9f582471ad.png#clientId=u262beab3-6cd1-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=336&amp;id=uc864e0e8&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=336&amp;originWidth=775&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=74277&amp;status=done&amp;style=none&amp;taskId=ucc7504f8-cd98-4791-b5a2-e7ddb565d89&amp;title=&amp;width=775" alt="image.png" loading="lazy"><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1658886114813-b619e617-b733-4ec9-819f-51526004503d.png#clientId=u262beab3-6cd1-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=21&amp;id=uf1324d9a&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=21&amp;originWidth=901&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=5723&amp;status=done&amp;style=none&amp;taskId=u5a498ce0-94b1-41f4-9b47-8e15323b133&amp;title=&amp;width=901" alt="image.png" loading="lazy"></p>
<h4 id="_4-2-2-使用-association-标签及其子标签" tabindex="-1"><a class="header-anchor" href="#_4-2-2-使用-association-标签及其子标签" aria-hidden="true">#</a> 4.2.2 使用<code v-pre>&lt;association&gt;</code>标签及其子标签</h4>
<div class="language-xml ext-xml line-numbers-mode"><pre v-pre class="language-xml"><code><span class="token comment">&lt;!--处理多对一映射关系方式二：association--></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>resultMap</span> <span class="token attr-name">id</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>empAndDeptResultMapTwo<span class="token punctuation">"</span></span> <span class="token attr-name">type</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>Emp<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>id</span> <span class="token attr-name">property</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>eid<span class="token punctuation">"</span></span> <span class="token attr-name">column</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>eid<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>id</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>result</span> <span class="token attr-name">property</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>empName<span class="token punctuation">"</span></span> <span class="token attr-name">column</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>emp_name<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>result</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>result</span> <span class="token attr-name">property</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>age<span class="token punctuation">"</span></span> <span class="token attr-name">column</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>age<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>result</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>result</span> <span class="token attr-name">property</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>gender<span class="token punctuation">"</span></span> <span class="token attr-name">column</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>sex<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>result</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>result</span> <span class="token attr-name">property</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>email<span class="token punctuation">"</span></span> <span class="token attr-name">column</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>email<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>result</span><span class="token punctuation">></span></span>
  <span class="token comment">&lt;!--
    association:处理多对一的映射关系
    property:需要处理多对的映射关系的属性名
    javaType:该属性的类型
  --></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>association</span> <span class="token attr-name">property</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>dept<span class="token punctuation">"</span></span> <span class="token attr-name">javaType</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>Dept<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>id</span> <span class="token attr-name">property</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>did<span class="token punctuation">"</span></span> <span class="token attr-name">column</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>did<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>id</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>result</span> <span class="token attr-name">property</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>deptName<span class="token punctuation">"</span></span> <span class="token attr-name">column</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>dept_name<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>result</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>association</span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>resultMap</span><span class="token punctuation">></span></span>
<span class="token comment">&lt;!--Emp getEmpAndDept(@Param("eid") Integer eid);--></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>select</span> <span class="token attr-name">id</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>getEmpAndDept<span class="token punctuation">"</span></span> <span class="token attr-name">resultMap</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>empAndDeptResultMapTwo<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
  select * from t_emp left join t_dept on t_emp.did = t_dept .did where t_emp.eid = #{eid}
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>select</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><h4 id="_4-2-3-分步查询" tabindex="-1"><a class="header-anchor" href="#_4-2-3-分步查询" aria-hidden="true">#</a> 4.2.3 分步查询</h4>
<ol>
<li>分步一：</li>
</ol>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token doc-comment comment">/**
* 查询指定员工的信息及所在部门，分步一：查询所在部门did
* <span class="token keyword">@param</span> <span class="token parameter">eid</span>
* <span class="token keyword">@return</span>
*/</span>
<span class="token class-name">Emp</span> <span class="token function">getEmpAndDeptByStepOne</span><span class="token punctuation">(</span><span class="token annotation punctuation">@Param</span><span class="token punctuation">(</span><span class="token string">"eid"</span><span class="token punctuation">)</span> <span class="token class-name">Integer</span> eid<span class="token punctuation">)</span><span class="token punctuation">;</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><div class="language-xml ext-xml line-numbers-mode"><pre v-pre class="language-xml"><code><span class="token comment">&lt;!--处理多对一映射关系方式三：分步查询、分步一--></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>resultMap</span> <span class="token attr-name">id</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>empAndDeptByStepResultMap<span class="token punctuation">"</span></span> <span class="token attr-name">type</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>Emp<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>id</span> <span class="token attr-name">property</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>eid<span class="token punctuation">"</span></span> <span class="token attr-name">column</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>eid<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>id</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>result</span> <span class="token attr-name">property</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>empName<span class="token punctuation">"</span></span> <span class="token attr-name">column</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>emp_name<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>result</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>result</span> <span class="token attr-name">property</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>age<span class="token punctuation">"</span></span> <span class="token attr-name">column</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>age<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>result</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>result</span> <span class="token attr-name">property</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>gender<span class="token punctuation">"</span></span> <span class="token attr-name">column</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>sex<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>result</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>result</span> <span class="token attr-name">property</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>email<span class="token punctuation">"</span></span> <span class="token attr-name">column</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>email<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>result</span><span class="token punctuation">></span></span>
  <span class="token comment">&lt;!--
    select:设置分步查询的sql的唯一标识（namespace.SQLId或mapper接口的全类名.方法名）
    column:设置分步查询的条件
--></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>association</span> <span class="token attr-name">property</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>dept<span class="token punctuation">"</span></span>
               <span class="token attr-name">select</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>iceriver.mybatis.mapper.DeptMapper.getEmpAndDeptByStepTwo<span class="token punctuation">"</span></span>
               <span class="token attr-name">column</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>did<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>association</span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>resultMap</span><span class="token punctuation">></span></span>
<span class="token comment">&lt;!--Emp getEmpAndDeptByStepOne(@Param("eid") Integer eid);--></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>select</span> <span class="token attr-name">id</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>getEmpAndDeptByStepOne<span class="token punctuation">"</span></span> <span class="token attr-name">resultMap</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>empAndDeptByStepResultMap<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
  select * from t_emp where eid = #{eid}
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>select</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ol start="2">
<li>分步二：</li>
</ol>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token doc-comment comment">/**
* 查询指定员工的信息及所在部门，分步二：根据did查询部门
* <span class="token keyword">@param</span> <span class="token parameter">did</span>
* <span class="token keyword">@return</span>
*/</span>
<span class="token class-name">Dept</span> <span class="token function">getEmpAndDeptByStepTwo</span><span class="token punctuation">(</span><span class="token annotation punctuation">@Param</span><span class="token punctuation">(</span><span class="token string">"did"</span><span class="token punctuation">)</span> <span class="token class-name">Integer</span> did<span class="token punctuation">)</span><span class="token punctuation">;</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><div class="language-xml ext-xml line-numbers-mode"><pre v-pre class="language-xml"><code><span class="token comment">&lt;!--处理多对一映射关系方式三：分步查询、分步二--></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>resultMap</span> <span class="token attr-name">id</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>empAndDeptByStepResultMap<span class="token punctuation">"</span></span> <span class="token attr-name">type</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>Dept<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>id</span> <span class="token attr-name">property</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>did<span class="token punctuation">"</span></span> <span class="token attr-name">column</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>did<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>id</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>result</span> <span class="token attr-name">property</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>deptName<span class="token punctuation">"</span></span> <span class="token attr-name">column</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>dept_name<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>result</span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>resultMap</span><span class="token punctuation">></span></span>

<span class="token comment">&lt;!--Dept getEmpAndDeptByStepTwo(@Param("did") Integer did);--></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>select</span> <span class="token attr-name">id</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>getEmpAndDeptByStepTwo<span class="token punctuation">"</span></span> <span class="token attr-name">resultMap</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>empAndDeptByStepResultMap<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
  select * from t_dept where did = #{did}
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>select</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><p><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1658888042785-8c40e45b-78fa-4cd5-82dd-7a9edea05462.png#clientId=u262beab3-6cd1-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=24&amp;id=uefb999f2&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=24&amp;originWidth=904&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=5771&amp;status=done&amp;style=none&amp;taskId=u4a52481e-8198-4ec0-8c25-38978591711&amp;title=&amp;width=904" alt="image.png" loading="lazy"></p>
<h3 id="_4-3-处理表中一对多的映射关系" tabindex="-1"><a class="header-anchor" href="#_4-3-处理表中一对多的映射关系" aria-hidden="true">#</a> 4.3 处理表中一对多的映射关系</h3>
<blockquote>
<ul>
<li>一对多：实体类中有个属性是集合</li>
</ul>
</blockquote>
<h4 id="_4-3-1-使用-connection-标签及其子标签" tabindex="-1"><a class="header-anchor" href="#_4-3-1-使用-connection-标签及其子标签" aria-hidden="true">#</a> 4.3.1 使用<code v-pre>&lt;connection&gt;</code>标签及其子标签</h4>
<div class="language-xml ext-xml line-numbers-mode"><pre v-pre class="language-xml"><code><span class="token comment">&lt;!--处理一对多映射关系方式一：--></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>resultMap</span> <span class="token attr-name">id</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>deptAndEmpResultMap<span class="token punctuation">"</span></span> <span class="token attr-name">type</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>Dept<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>id</span> <span class="token attr-name">property</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>did<span class="token punctuation">"</span></span> <span class="token attr-name">column</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>did<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>id</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>result</span> <span class="token attr-name">property</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>deptName<span class="token punctuation">"</span></span> <span class="token attr-name">column</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>dept_name<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>result</span><span class="token punctuation">></span></span>
  <span class="token comment">&lt;!--
            collection：处理一对多的映射关系
            ofType：表示该属性所对应的集合中存储数据的类型
        --></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>collection</span> <span class="token attr-name">property</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>emps<span class="token punctuation">"</span></span> <span class="token attr-name">ofType</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>Emp<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>id</span> <span class="token attr-name">property</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>eid<span class="token punctuation">"</span></span> <span class="token attr-name">column</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>eid<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>id</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>result</span> <span class="token attr-name">property</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>empName<span class="token punctuation">"</span></span> <span class="token attr-name">column</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>emp_name<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>result</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>result</span> <span class="token attr-name">property</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>age<span class="token punctuation">"</span></span> <span class="token attr-name">column</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>age<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>result</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>result</span> <span class="token attr-name">property</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>gender<span class="token punctuation">"</span></span> <span class="token attr-name">column</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>sex<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>result</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>result</span> <span class="token attr-name">property</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>email<span class="token punctuation">"</span></span> <span class="token attr-name">column</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>email<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>result</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>collection</span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>resultMap</span><span class="token punctuation">></span></span>
<span class="token comment">&lt;!--Dept getDeptAndEmp(@Param("did") Integer did);--></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>select</span> <span class="token attr-name">id</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>getDeptAndEmp<span class="token punctuation">"</span></span> <span class="token attr-name">resultMap</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>deptAndEmpResultMap<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
  select * from t_dept left join t_emp on t_dept.did = t_emp.did where t_dept.did = #{did}
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>select</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><p><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1658890506614-f44a26d8-3ccb-4b5c-95aa-877572185b9e.png#clientId=u262beab3-6cd1-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=70&amp;id=u82c9432f&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=70&amp;originWidth=659&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=12878&amp;status=done&amp;style=none&amp;taskId=u8efe6c5a-e076-46a2-aaab-053aa48c277&amp;title=&amp;width=659" alt="image.png" loading="lazy"></p>
<h4 id="_4-3-2-分步查询" tabindex="-1"><a class="header-anchor" href="#_4-3-2-分步查询" aria-hidden="true">#</a> 4.3.2 分步查询</h4>
<div class="language-xml ext-xml line-numbers-mode"><pre v-pre class="language-xml"><code><span class="token comment">&lt;!--处理一对多映射关系方式二：分步查询、分步一--></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>resultMap</span> <span class="token attr-name">id</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>deptAndEmpByStepResultMap<span class="token punctuation">"</span></span> <span class="token attr-name">type</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>Dept<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>id</span> <span class="token attr-name">property</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>did<span class="token punctuation">"</span></span> <span class="token attr-name">column</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>did<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>id</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>result</span> <span class="token attr-name">property</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>deptName<span class="token punctuation">"</span></span> <span class="token attr-name">column</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>dept_name<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>result</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>collection</span> <span class="token attr-name">property</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>emps<span class="token punctuation">"</span></span>
              <span class="token attr-name">select</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>iceriver.mybatis.mapper.EmpMapper.getDeptAndEmpByStepTwo<span class="token punctuation">"</span></span> 
              <span class="token attr-name">column</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>did<span class="token punctuation">"</span></span>
              <span class="token attr-name">fetchType</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>eager<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>collection</span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>resultMap</span><span class="token punctuation">></span></span>
<span class="token comment">&lt;!--Dept getDeptAndEmpByStepOne(@Param("did") Integer did);--></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>select</span> <span class="token attr-name">id</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>getDeptAndEmpByStepOne<span class="token punctuation">"</span></span> <span class="token attr-name">resultMap</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>deptAndEmpByStepResultMap<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
  select * from t_dept where did = #{did}
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>select</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><div class="language-xml ext-xml line-numbers-mode"><pre v-pre class="language-xml"><code><span class="token comment">&lt;!--List&lt;Emp> getDeptAndEmpByStepTwo(@Param("did") Integer did);--></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>resultMap</span> <span class="token attr-name">id</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>empAndDeptResultMapOne<span class="token punctuation">"</span></span> <span class="token attr-name">type</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>Emp<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>id</span> <span class="token attr-name">property</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>eid<span class="token punctuation">"</span></span> <span class="token attr-name">column</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>eid<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>id</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>result</span> <span class="token attr-name">property</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>empName<span class="token punctuation">"</span></span> <span class="token attr-name">column</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>emp_name<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>result</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>result</span> <span class="token attr-name">property</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>age<span class="token punctuation">"</span></span> <span class="token attr-name">column</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>age<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>result</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>result</span> <span class="token attr-name">property</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>gender<span class="token punctuation">"</span></span> <span class="token attr-name">column</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>sex<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>result</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>result</span> <span class="token attr-name">property</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>email<span class="token punctuation">"</span></span> <span class="token attr-name">column</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>email<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>result</span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>resultMap</span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>select</span> <span class="token attr-name">id</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>getDeptAndEmpByStepTwo<span class="token punctuation">"</span></span> <span class="token attr-name">resultMap</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>empAndDeptResultMapOne<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
  select * from t_emp where did = #{did}
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>select</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><p><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1658892640895-1a084e5b-d9d2-4821-8ec4-2da093c512d6.png#clientId=u262beab3-6cd1-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=73&amp;id=u164e84a4&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=73&amp;originWidth=671&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=12938&amp;status=done&amp;style=none&amp;taskId=u1c7a01fb-dd1d-4141-b0f9-b7c2c035887&amp;title=&amp;width=671" alt="image.png" loading="lazy"></p>
<h3 id="_4-4-分步查询的优点" tabindex="-1"><a class="header-anchor" href="#_4-4-分步查询的优点" aria-hidden="true">#</a> 4.4 分步查询的优点</h3>
<ol>
<li>分步查询的优点：可以实现延迟加载，但是必须在核心配置文件中设置全局配置信息：</li>
</ol>
<div class="language-xml ext-xml line-numbers-mode"><pre v-pre class="language-xml"><code><span class="token comment">&lt;!--开启延迟加载--></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>settings</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>setting</span> <span class="token attr-name">name</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>lazyLoadingEnabled<span class="token punctuation">"</span></span> <span class="token attr-name">value</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>true<span class="token punctuation">"</span></span><span class="token punctuation">/></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>settings</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ul>
<li><code v-pre>lazyLoadingEnabled</code>：延迟加载的全局开关。当开启时，所有关联对象都会延迟加载</li>
<li><code v-pre>aggressiveLazyLoading</code>：当开启时，任何方法的调用都会加载该对象的所有属性【3.7.5版本默认开启】。 否则，每个属性会按需加载</li>
</ul>
<ol start="2">
<li>核心配置文件开启延迟加载后，所有的分步查询都会延迟加载，如果需要控制当前映射文件中的分步查询，可以通过<code v-pre>association</code>和<code v-pre>collection</code>中的<code v-pre>fetchType</code>属性设置当前的分步查询是否使用延迟加载。
<ul>
<li><code v-pre>fetchType=&quot;lazy&quot;</code>(延迟加载)，开启全局延迟加载时的默认值。</li>
<li><code v-pre>fetchType=&quot;eager&quot;</code>(立即加载) ，未全局延迟加载时的默认值。</li>
</ul>
</li>
</ol>
<h2 id="第5章-动态sql" tabindex="-1"><a class="header-anchor" href="#第5章-动态sql" aria-hidden="true">#</a> 第5章 动态SQL</h2>
<blockquote>
<ul>
<li>解决拼接SQL语句字符串时的痛点问题。</li>
</ul>
</blockquote>
<h3 id="_5-1-if" tabindex="-1"><a class="header-anchor" href="#_5-1-if" aria-hidden="true">#</a> 5.1 <code v-pre>&lt;if&gt;</code></h3>
<ul>
<li><code v-pre>&lt;if&gt;</code>标签可通过<code v-pre>test</code>属性的表达式进行判断，若表达式的结果为<code v-pre>true</code>，则标签中的内容会执行；反之标签中的内容不会执行</li>
</ul>
<div class="language-xml ext-xml line-numbers-mode"><pre v-pre class="language-xml"><code><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>resultMap</span> <span class="token attr-name">id</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>empResultMap<span class="token punctuation">"</span></span> <span class="token attr-name">type</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>Emp<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>id</span> <span class="token attr-name">property</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>eid<span class="token punctuation">"</span></span> <span class="token attr-name">column</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>eid<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>id</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>result</span> <span class="token attr-name">property</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>empName<span class="token punctuation">"</span></span> <span class="token attr-name">column</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>emp_name<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>result</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>result</span> <span class="token attr-name">property</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>age<span class="token punctuation">"</span></span> <span class="token attr-name">column</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>age<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>result</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>result</span> <span class="token attr-name">property</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>gender<span class="token punctuation">"</span></span> <span class="token attr-name">column</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>sex<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>result</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>result</span> <span class="token attr-name">property</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>email<span class="token punctuation">"</span></span> <span class="token attr-name">column</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>email<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>result</span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>resultMap</span><span class="token punctuation">></span></span>

<span class="token comment">&lt;!--List&lt;Emp> getEmpByCondition(Emp emp);--></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>select</span> <span class="token attr-name">id</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>getEmpByCondition<span class="token punctuation">"</span></span> <span class="token attr-name">resultMap</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>empResultMap<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
  select * from t_emp where 1=1
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>if</span> <span class="token attr-name">test</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>empName != null and empName != <span class="token punctuation">'</span><span class="token punctuation">'</span><span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
    and emp_name = #{empName}
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>if</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>if</span> <span class="token attr-name">test</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>age != null and age != <span class="token punctuation">'</span><span class="token punctuation">'</span><span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
    and age = #{age}
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>if</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>if</span> <span class="token attr-name">test</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>gender != null and gender != <span class="token punctuation">'</span><span class="token punctuation">'</span><span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
    or sex = #{gender}
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>if</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>if</span> <span class="token attr-name">test</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>email != null and email != <span class="token punctuation">'</span><span class="token punctuation">'</span><span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
    and email = #{email}
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>if</span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>select</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ul>
<li><code v-pre>if</code>标签中<code v-pre>test</code>属性的值是实体类的属性名，或者别名。</li>
<li><code v-pre>if</code>语句中的查询条件<code v-pre>=</code>左侧字段名是数据表中的字段名，右侧是实体类属性名。
<ul>
<li>这里的实体类中的属性名也相当于表单提交的属性名【表单提交的属性名与实体类的属性名一致】</li>
</ul>
</li>
<li>这里<code v-pre>1=1</code>是为了解决各项条件都不符合，或<code v-pre>emp_name</code>不符合条件，导致<code v-pre>where</code>后面没有语句或<code v-pre>where</code>后面直接出现<code v-pre>and</code>或<code v-pre>or</code>的情况。
<ul>
<li><code v-pre>1=1</code>这种用法可以在正常的SQL语句中使用，且不会影响执行效果。</li>
</ul>
</li>
</ul>
<h3 id="_5-2-where" tabindex="-1"><a class="header-anchor" href="#_5-2-where" aria-hidden="true">#</a> 5.2 <code v-pre>&lt;where&gt;</code></h3>
<div class="language-xml ext-xml line-numbers-mode"><pre v-pre class="language-xml"><code><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>resultMap</span> <span class="token attr-name">id</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>empResultMap<span class="token punctuation">"</span></span> <span class="token attr-name">type</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>Emp<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>id</span> <span class="token attr-name">property</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>eid<span class="token punctuation">"</span></span> <span class="token attr-name">column</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>eid<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>id</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>result</span> <span class="token attr-name">property</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>empName<span class="token punctuation">"</span></span> <span class="token attr-name">column</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>emp_name<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>result</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>result</span> <span class="token attr-name">property</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>age<span class="token punctuation">"</span></span> <span class="token attr-name">column</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>age<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>result</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>result</span> <span class="token attr-name">property</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>gender<span class="token punctuation">"</span></span> <span class="token attr-name">column</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>sex<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>result</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>result</span> <span class="token attr-name">property</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>email<span class="token punctuation">"</span></span> <span class="token attr-name">column</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>email<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>result</span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>resultMap</span><span class="token punctuation">></span></span>

<span class="token comment">&lt;!--List&lt;Emp> getEmpByCondition(Emp emp);--></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>select</span> <span class="token attr-name">id</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>getEmpByCondition<span class="token punctuation">"</span></span> <span class="token attr-name">resultMap</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>empResultMap<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
  select * from t_emp
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>where</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>if</span> <span class="token attr-name">test</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>empName != null and empName != <span class="token punctuation">'</span><span class="token punctuation">'</span><span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
      and emp_name = #{empName}
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>if</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>if</span> <span class="token attr-name">test</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>age != null and age != <span class="token punctuation">'</span><span class="token punctuation">'</span><span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
      and age = #{age}
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>if</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>if</span> <span class="token attr-name">test</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>gender != null and gender != <span class="token punctuation">'</span><span class="token punctuation">'</span><span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
      or sex = #{gender}
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>if</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>if</span> <span class="token attr-name">test</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>email != null and email != <span class="token punctuation">'</span><span class="token punctuation">'</span><span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
      and email = #{email}
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>if</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>where</span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>select</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ul>
<li><code v-pre>where</code>和<code v-pre>if</code>一般结合使用：
<ul>
<li>若<code v-pre>where</code>标签中的if条件都不满足，则<code v-pre>where</code>标签没有任何功能，即不会添加<code v-pre>where</code>关键字</li>
<li>若<code v-pre>where</code>标签中的<code v-pre>if</code>条件满足，则<code v-pre>where</code>标签会自动添加<code v-pre>where</code>关键字，并将条件最前方多余的<code v-pre>and</code>/<code v-pre>or</code>去掉
<ul>
<li>注意：<code v-pre>where</code>标签不能去掉条件最后多余的<code v-pre>and</code>/<code v-pre>or</code></li>
</ul>
</li>
</ul>
</li>
</ul>
<h3 id="_5-3-trim" tabindex="-1"><a class="header-anchor" href="#_5-3-trim" aria-hidden="true">#</a> 5.3 <code v-pre>&lt;trim&gt;</code></h3>
<div class="language-xml ext-xml line-numbers-mode"><pre v-pre class="language-xml"><code><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>resultMap</span> <span class="token attr-name">id</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>empResultMap<span class="token punctuation">"</span></span> <span class="token attr-name">type</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>Emp<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>id</span> <span class="token attr-name">property</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>eid<span class="token punctuation">"</span></span> <span class="token attr-name">column</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>eid<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>id</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>result</span> <span class="token attr-name">property</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>empName<span class="token punctuation">"</span></span> <span class="token attr-name">column</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>emp_name<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>result</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>result</span> <span class="token attr-name">property</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>age<span class="token punctuation">"</span></span> <span class="token attr-name">column</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>age<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>result</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>result</span> <span class="token attr-name">property</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>gender<span class="token punctuation">"</span></span> <span class="token attr-name">column</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>sex<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>result</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>result</span> <span class="token attr-name">property</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>email<span class="token punctuation">"</span></span> <span class="token attr-name">column</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>email<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>result</span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>resultMap</span><span class="token punctuation">></span></span>

<span class="token comment">&lt;!--List&lt;Emp> getEmpByCondition(Emp emp);--></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>select</span> <span class="token attr-name">id</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>getEmpByCondition<span class="token punctuation">"</span></span> <span class="token attr-name">resultMap</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>empResultMap<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
  select * from t_emp
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>trim</span> <span class="token attr-name">prefix</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>where<span class="token punctuation">"</span></span> <span class="token attr-name">prefixOverrides</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>and|or<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>if</span> <span class="token attr-name">test</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>empName != null and empName != <span class="token punctuation">'</span><span class="token punctuation">'</span><span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
      and emp_name = #{empName}
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>if</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>if</span> <span class="token attr-name">test</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>age != null and age != <span class="token punctuation">'</span><span class="token punctuation">'</span><span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
      and age = #{age}
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>if</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>if</span> <span class="token attr-name">test</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>gender != null and gender != <span class="token punctuation">'</span><span class="token punctuation">'</span><span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
      or sex = #{gender}
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>if</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>if</span> <span class="token attr-name">test</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>email != null and email != <span class="token punctuation">'</span><span class="token punctuation">'</span><span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
      and email = #{email}
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>if</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>trim</span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>select</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ul>
<li><code v-pre>trim</code>用于去掉或添加标签中的内容：
<ul>
<li><code v-pre>prefix</code>：在trim标签中的内容的前面添加指定内容</li>
<li><code v-pre>prefixOverrides</code>：在<code v-pre>trim</code>标签中的内容的前面去掉指定内容</li>
<li><code v-pre>suffix</code>：在<code v-pre>trim</code>标签中的内容的后面添加指定内容</li>
<li><code v-pre>suffixOverrides</code>：在<code v-pre>trim</code>标签中的内容的后面去掉指定内容</li>
</ul>
</li>
</ul>
<h3 id="_5-4-choose-、-when-、-otherwise" tabindex="-1"><a class="header-anchor" href="#_5-4-choose-、-when-、-otherwise" aria-hidden="true">#</a> 5.4 <code v-pre>&lt;choose&gt;</code>、<code v-pre>&lt;when&gt;</code>、<code v-pre>&lt;otherwise&gt;</code></h3>
<ul>
<li>相当于if...else if....if</li>
<li><code v-pre>when</code>至少要有一个</li>
<li><code v-pre>otherwise</code>最多只能有一个</li>
</ul>
<div class="language-xml ext-xml line-numbers-mode"><pre v-pre class="language-xml"><code><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>resultMap</span> <span class="token attr-name">id</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>empResultMap<span class="token punctuation">"</span></span> <span class="token attr-name">type</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>Emp<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>id</span> <span class="token attr-name">property</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>eid<span class="token punctuation">"</span></span> <span class="token attr-name">column</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>eid<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>id</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>result</span> <span class="token attr-name">property</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>empName<span class="token punctuation">"</span></span> <span class="token attr-name">column</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>emp_name<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>result</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>result</span> <span class="token attr-name">property</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>age<span class="token punctuation">"</span></span> <span class="token attr-name">column</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>age<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>result</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>result</span> <span class="token attr-name">property</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>gender<span class="token punctuation">"</span></span> <span class="token attr-name">column</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>sex<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>result</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>result</span> <span class="token attr-name">property</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>email<span class="token punctuation">"</span></span> <span class="token attr-name">column</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>email<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>result</span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>resultMap</span><span class="token punctuation">></span></span>

<span class="token comment">&lt;!--List&lt;Emp> getEmpByChoose(Emp emp);--></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>select</span> <span class="token attr-name">id</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>getEmpByChoose<span class="token punctuation">"</span></span> <span class="token attr-name">resultMap</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>empResultMap<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
  select * from t_emp
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>where</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>choose</span><span class="token punctuation">></span></span>
      <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>when</span> <span class="token attr-name">test</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>empName != null and empName != <span class="token punctuation">'</span><span class="token punctuation">'</span><span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
        emp_name = #{empName}
      <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>when</span><span class="token punctuation">></span></span>
      <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>when</span> <span class="token attr-name">test</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>age != null and age != <span class="token punctuation">'</span><span class="token punctuation">'</span><span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
        age = #{age}
      <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>when</span><span class="token punctuation">></span></span>
      <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>when</span> <span class="token attr-name">test</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>gender != null and gender != <span class="token punctuation">'</span><span class="token punctuation">'</span><span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
        sex = #{gender}
      <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>when</span><span class="token punctuation">></span></span>
      <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>when</span> <span class="token attr-name">test</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>email != null and email != <span class="token punctuation">'</span><span class="token punctuation">'</span><span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
        email = #{email}
      <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>when</span><span class="token punctuation">></span></span>
      <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>otherwise</span><span class="token punctuation">></span></span>
        did=1
      <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>otherwise</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>choose</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>where</span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>select</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><h3 id="_5-5-foreach" tabindex="-1"><a class="header-anchor" href="#_5-5-foreach" aria-hidden="true">#</a> 5.5 <code v-pre>&lt;foreach&gt;</code></h3>
<h4 id="_5-5-1-批量删除" tabindex="-1"><a class="header-anchor" href="#_5-5-1-批量删除" aria-hidden="true">#</a> 5.5.1 批量删除</h4>
<div class="language-xml ext-xml line-numbers-mode"><pre v-pre class="language-xml"><code><span class="token comment">&lt;!--int deleteMoreByArray(@Param("eids") Integer[] eids);--></span>
<span class="token comment">&lt;!--
&lt;delete id="deleteMoreByArray">
  delete from t_emp where eid in
    (
      &lt;foreach collection="eids" item="eid" separator=",">
        #{eid}
      &lt;/foreach>
    )
&lt;/delete>
--></span>

<span class="token comment">&lt;!--
&lt;delete id="deleteMoreByArray">
  delete from t_emp where eid in
  &lt;foreach collection="eids" item="eid" separator="," open="(" close=")">
    #{eid}
  &lt;/foreach>
&lt;/delete>
--></span>

<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>delete</span> <span class="token attr-name">id</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>deleteMoreByArray<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
  delete from t_emp where
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>foreach</span> <span class="token attr-name">collection</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>eids<span class="token punctuation">"</span></span> <span class="token attr-name">item</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>eid<span class="token punctuation">"</span></span> <span class="token attr-name">separator</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>or<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
    eid=#{eid}
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>foreach</span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>delete</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ul>
<li><code v-pre>collection</code>：设置要循环的数组或集合</li>
<li><code v-pre>item</code>：表示集合或数组中的每一个数据</li>
<li><code v-pre>separator</code>：设置循环体之间的分隔符</li>
<li><code v-pre>open</code>：设置<code v-pre>foreach</code>标签中的内容的开始符</li>
<li><code v-pre>close</code>：设置<code v-pre>foreach</code>标签中的内容的结束符</li>
</ul>
<h4 id="_5-5-2-批量添加" tabindex="-1"><a class="header-anchor" href="#_5-5-2-批量添加" aria-hidden="true">#</a> 5.5.2 批量添加</h4>
<div class="language-xml ext-xml line-numbers-mode"><pre v-pre class="language-xml"><code><span class="token comment">&lt;!--int insertMoreByList(@Param("emps") List&lt;Emp> emps);--></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>insert</span> <span class="token attr-name">id</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>insertMoreByList<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
  insert into t_emp values
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>foreach</span> <span class="token attr-name">collection</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>emps<span class="token punctuation">"</span></span> <span class="token attr-name">item</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>emp<span class="token punctuation">"</span></span> <span class="token attr-name">separator</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>,<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
    (null,#{emp.empName},#{emp.age},#{emp.gender},#{emp.email},null)
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>foreach</span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>insert</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ul>
<li>注意这里<code v-pre>gender</code>是实体类中的属性名，<code v-pre>sex</code>是表中字段名。由于前文设置了<code v-pre>gender</code>的映射关系，所以这里可以使用<code v-pre>gender</code></li>
</ul>
<h3 id="_5-6-sql-片段" tabindex="-1"><a class="header-anchor" href="#_5-6-sql-片段" aria-hidden="true">#</a> 5.6 <code v-pre>&lt;sql&gt;</code>片段</h3>
<ul>
<li>设置<code v-pre>sql</code>片段，记录一段数据，在使用的地方使用<code v-pre>&lt;include&gt;</code>标签引入，插入到<code v-pre>sql</code>语句中。</li>
</ul>
<div class="language-xml ext-xml line-numbers-mode"><pre v-pre class="language-xml"><code><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>sql</span> <span class="token attr-name">id</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>empColumns<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
  eid,ename,age,sex,did
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>sql</span><span class="token punctuation">></span></span>
select <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>include</span> <span class="token attr-name">refid</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>empColumns<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>include</span><span class="token punctuation">></span></span> from t_emp
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><h2 id="第6章-mybatis的缓存" tabindex="-1"><a class="header-anchor" href="#第6章-mybatis的缓存" aria-hidden="true">#</a> 第6章 MyBatis的缓存</h2>
<blockquote>
<ul>
<li>只针对查询功能有效</li>
</ul>
</blockquote>
<h3 id="_6-1-一级缓存-不同查询在同一个sqlsession下" tabindex="-1"><a class="header-anchor" href="#_6-1-一级缓存-不同查询在同一个sqlsession下" aria-hidden="true">#</a> 6.1 一级缓存（不同查询在同一个<code v-pre>sqlSession</code>下）</h3>
<ol>
<li>一级缓存是<code v-pre>SqlSession</code>级别的，通过同一个SqlSession查询的数据会被缓存，下次查询相同的数据，就会从缓存中直接获取，不会从数据库重新访问【不会执行sql查询】
<ul>
<li>不论<code v-pre>SqlSession</code>对象是否关闭或提交，都会保存一级缓存
<ul>
<li><code v-pre>sqlSession.commit()</code>或<code v-pre>sqlSession.close()</code></li>
</ul>
</li>
</ul>
</li>
<li>使一级缓存失效的四种情况：
<ul>
<li>不同的<code v-pre>SqlSession</code>对应不同的一级缓存</li>
<li>同一个<code v-pre>SqlSession</code>但是查询条件不同</li>
<li>同一个<code v-pre>SqlSession</code>两次查询期间执行了任何一次增删改操作</li>
<li>同一个<code v-pre>SqlSession</code>两次查询期间手动清空了缓存
<ul>
<li><code v-pre>sqlSession.clearCache()</code></li>
</ul>
</li>
</ul>
</li>
</ol>
<h3 id="_6-2-二级缓存-不同查询在同一个sqlsessionfactory下" tabindex="-1"><a class="header-anchor" href="#_6-2-二级缓存-不同查询在同一个sqlsessionfactory下" aria-hidden="true">#</a> 6.2 二级缓存（不同查询在同一个<code v-pre>sqlSessionFactory</code>下）</h3>
<ol>
<li>二级缓存级别大于一级缓存。</li>
<li>二级缓存是<code v-pre>SqlSessionFactory</code>级别，通过同一个<code v-pre>SqlSessionFactory</code>创建的<code v-pre>SqlSession</code>查询的结果会被缓存；此后若再次执行相同的查询语句，结果就会从缓存中获取。</li>
<li>二级缓存开启的条件（同时满足）：
<ul>
<li>在核心配置文件中，设置全局配置属性<code v-pre>cacheEnabled=&quot;true&quot;</code>
<ul>
<li>默认即为<code v-pre>true</code>，不需要设置。</li>
</ul>
</li>
<li>在映射文件中设置标签<code v-pre>&lt;cache/&gt;</code></li>
<li>二级缓存必须在<code v-pre>SqlSession</code>对象关闭或提交之后有效
<ul>
<li><code v-pre>sqlSession.commit()</code>或<code v-pre>sqlSession.close()</code></li>
</ul>
</li>
<li>查询的数据所转换的实体类类型必须实现序列化<code v-pre>Serializable</code>接口</li>
</ul>
</li>
<li>使二级缓存失效的情况：
<ul>
<li>两次查询之间执行了任意的增删改，会使一级和二级缓存同时失效</li>
</ul>
</li>
</ol>
<h3 id="_6-3-二级缓存的相关配置" tabindex="-1"><a class="header-anchor" href="#_6-3-二级缓存的相关配置" aria-hidden="true">#</a> 6.3 二级缓存的相关配置</h3>
<ol>
<li>通过在<code v-pre>mapper</code>映射文件中设置<code v-pre>&lt;cache/&gt;</code> 标签的属性配置：</li>
<li><code v-pre>eviction</code>属性：缓存回收策略
<ul>
<li><code v-pre>LRU</code>（<code v-pre>Least Recently Used</code>） – 最近最少使用的：移除最长时间不被使用的对象。默认值。</li>
<li><code v-pre>FIFO</code>（<code v-pre>First in First out</code>） – 先进先出：按对象进入缓存的顺序来移除它们。</li>
<li><code v-pre>SOFT</code>– 软引用：移除基于垃圾回收器状态和软引用规则的对象。
<code v-pre>WEAK</code>– 弱引用：更积极地移除基于垃圾收集器状态和弱引用规则的对象。</li>
</ul>
</li>
<li><code v-pre>flushInterval</code>属性：刷新间隔，单位毫秒
<ul>
<li>默认情况是不设置，也就是没有刷新间隔，缓存仅仅调用语句时刷新</li>
</ul>
</li>
<li><code v-pre>size</code>属性：引用数目，正整数。代表缓存最多可以存储多少个对象，太大容易导致内存溢出</li>
<li><code v-pre>readOnly</code>属性：只读，<code v-pre>true</code>/<code v-pre>false</code>
<ul>
<li><code v-pre>true</code>：只读缓存；会给所有调用者返回缓存对象的相同实例。因此这些对象不能被修改。这提供了很重要的性能优势。</li>
<li><code v-pre>false</code>：读写缓存；会返回缓存对象的拷贝（通过序列化）。这会慢一些，但是安全，因此默认是<code v-pre>false</code>。</li>
</ul>
</li>
</ol>
<h3 id="_6-4-mybatis缓存查询的顺序" tabindex="-1"><a class="header-anchor" href="#_6-4-mybatis缓存查询的顺序" aria-hidden="true">#</a> 6.4 MyBatis缓存查询的顺序</h3>
<ol>
<li>先查询二级缓存，因为二级缓存中可能会有其他程序已经查出来的数据，可以拿来直接使用。【先搜索大范围，再搜索小范围】。</li>
<li>如果二级缓存没有命中，再查询一级缓存。</li>
<li>如果一级缓存也没有命中，则查询数据库。</li>
<li><code v-pre>SqlSession</code>关闭之后，一级缓存中的数据会写入二级缓存。</li>
</ol>
<h3 id="_6-5-整合第三方缓存ehcache" tabindex="-1"><a class="header-anchor" href="#_6-5-整合第三方缓存ehcache" aria-hidden="true">#</a> 6.5 整合第三方缓存EHCache</h3>
<blockquote>
<ul>
<li>只能代替二级缓存，没法代替一级缓存。【为什么？】</li>
</ul>
</blockquote>
<h4 id="_6-5-1-添加依赖" tabindex="-1"><a class="header-anchor" href="#_6-5-1-添加依赖" aria-hidden="true">#</a> 6.5.1 添加依赖</h4>
<div class="language-xml ext-xml line-numbers-mode"><pre v-pre class="language-xml"><code><span class="token comment">&lt;!-- Mybatis EHCache整合包 --></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>dependency</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>groupId</span><span class="token punctuation">></span></span>org.mybatis.caches<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>groupId</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>artifactId</span><span class="token punctuation">></span></span>mybatis-ehcache<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>artifactId</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>version</span><span class="token punctuation">></span></span>1.2.1<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>version</span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>dependency</span><span class="token punctuation">></span></span>
<span class="token comment">&lt;!-- slf4j日志门面的一个具体实现 --></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>dependency</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>groupId</span><span class="token punctuation">></span></span>ch.qos.logback<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>groupId</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>artifactId</span><span class="token punctuation">></span></span>logback-classic<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>artifactId</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>version</span><span class="token punctuation">></span></span>1.2.3<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>version</span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>dependency</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><p><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1658913695203-c2d10aa6-5f1d-468c-b366-f915afb39b8e.png#clientId=u58a324e4-3d2a-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=184&amp;id=u3f605e66&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=184&amp;originWidth=471&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=21453&amp;status=done&amp;style=none&amp;taskId=u4c4ddf55-8b19-44b0-9373-dcf2a03855b&amp;title=&amp;width=471" alt="image.png" loading="lazy"></p>
<h4 id="_6-5-2-各jar包功能" tabindex="-1"><a class="header-anchor" href="#_6-5-2-各jar包功能" aria-hidden="true">#</a> 6.5.2 各jar包功能</h4>
<table>
<thead>
<tr>
<th>jar包名称</th>
<th>作用</th>
</tr>
</thead>
<tbody>
<tr>
<td>mybatis-ehcache</td>
<td>Mybatis和EHCache的整合包</td>
</tr>
<tr>
<td>ehcache</td>
<td>EHCache核心包</td>
</tr>
<tr>
<td>slf4j-api</td>
<td>SLF4J日志门面包</td>
</tr>
<tr>
<td>logback-classic</td>
<td>支持SLF4J门面接口的一个具体实现</td>
</tr>
</tbody>
</table>
<ul>
<li>日志门面：提供了规范、接口</li>
</ul>
<h4 id="_6-5-3-创建配置文件" tabindex="-1"><a class="header-anchor" href="#_6-5-3-创建配置文件" aria-hidden="true">#</a> 6.5.3 创建配置文件</h4>
<ol>
<li>在<code v-pre>resources</code>目录下创建<code v-pre>ehcache.xml</code></li>
</ol>
<div class="language-xml ext-xml line-numbers-mode"><pre v-pre class="language-xml"><code><span class="token prolog">&lt;?xml version="1.0" encoding="utf-8" ?></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>ehcache</span> <span class="token attr-name"><span class="token namespace">xmlns:</span>xsi</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>http://www.w3.org/2001/XMLSchema-instance<span class="token punctuation">"</span></span>
         <span class="token attr-name"><span class="token namespace">xsi:</span>noNamespaceSchemaLocation</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>../config/ehcache.xsd<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
    <span class="token comment">&lt;!-- 磁盘保存路径 --></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>diskStore</span> <span class="token attr-name">path</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>D:\iceriver\ehcache<span class="token punctuation">"</span></span><span class="token punctuation">/></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>defaultCache</span>
            <span class="token attr-name">maxElementsInMemory</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>1000<span class="token punctuation">"</span></span>
            <span class="token attr-name">maxElementsOnDisk</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>10000000<span class="token punctuation">"</span></span>
            <span class="token attr-name">eternal</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>false<span class="token punctuation">"</span></span>
            <span class="token attr-name">overflowToDisk</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>true<span class="token punctuation">"</span></span>
            <span class="token attr-name">timeToIdleSeconds</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>120<span class="token punctuation">"</span></span>
            <span class="token attr-name">timeToLiveSeconds</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>120<span class="token punctuation">"</span></span>
            <span class="token attr-name">diskExpiryThreadIntervalSeconds</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>120<span class="token punctuation">"</span></span>
            <span class="token attr-name">memoryStoreEvictionPolicy</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>LRU<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>defaultCache</span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>ehcache</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><table>
<thead>
<tr>
<th>属性名</th>
<th>是否必须</th>
<th>作用</th>
</tr>
</thead>
<tbody>
<tr>
<td>maxElementsInMemory</td>
<td>是</td>
<td>在内存中缓存的element的最大数目</td>
</tr>
<tr>
<td>maxElementsOnDisk</td>
<td>是</td>
<td>在磁盘上缓存的element的最大数目，若是0表示无穷大</td>
</tr>
<tr>
<td>eternal</td>
<td>是</td>
<td>设定缓存的elements是否永远不过期。 如果为true，则缓存的数据始终有效， 如果为false那么还要根据timeToIdleSeconds、timeToLiveSeconds判断</td>
</tr>
<tr>
<td>overflowToDisk</td>
<td>是</td>
<td>设定当内存缓存溢出的时候是否将过期的element缓存到磁盘上</td>
</tr>
<tr>
<td>timeToIdleSeconds</td>
<td>否</td>
<td>当缓存在EhCache中的数据前后两次访问的时间超过timeToIdleSeconds的属性取值时， 这些数据便会删除，默认值是0,也就是可闲置时间无穷大</td>
</tr>
<tr>
<td>timeToLiveSeconds</td>
<td>否</td>
<td>缓存element的有效生命期，默认是0.,也就是element存活时间无穷大</td>
</tr>
<tr>
<td>diskSpoolBufferSizeMB</td>
<td>否</td>
<td>DiskStore(磁盘缓存)的缓存区大小。默认是30MB。每个Cache都应该有自己的一个缓冲区</td>
</tr>
<tr>
<td>diskPersistent</td>
<td>否</td>
<td>在VM重启的时候是否启用磁盘保存EhCache中的数据，默认是false。</td>
</tr>
<tr>
<td>diskExpiryThreadIntervalSeconds</td>
<td>否</td>
<td>磁盘缓存的清理线程运行间隔，默认是120秒。每个120s， 相应的线程会进行一次EhCache中数据的清理工作</td>
</tr>
<tr>
<td>memoryStoreEvictionPolicy</td>
<td>否</td>
<td>当内存缓存达到最大，有新的element加入的时候， 移除缓存中element的策略。 默认是LRU（最近最少使用），可选的有LFU（最不常使用）和FIFO（先进先出）</td>
</tr>
</tbody>
</table>
<ol start="2">
<li>在<code v-pre>resources</code>目录下创建<code v-pre>logback.xml</code>
<ul>
<li>存在SLF4J时，作为简易日志的log4j将失效，此时我们需要借助SLF4J的具体实现logback来打印日志
<ul>
<li>问题1：那可以删了<code v-pre>log4j</code>吗？</li>
<li>问题2：可以不使用<code v-pre>logback</code>吗？</li>
</ul>
</li>
</ul>
</li>
</ol>
<div class="language-xml ext-xml line-numbers-mode"><pre v-pre class="language-xml"><code><span class="token prolog">&lt;?xml version="1.0" encoding="UTF-8"?></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>configuration</span> <span class="token attr-name">debug</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>true<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
    <span class="token comment">&lt;!-- 指定日志输出的位置 --></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>appender</span> <span class="token attr-name">name</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>STDOUT<span class="token punctuation">"</span></span> <span class="token attr-name">class</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>ch.qos.logback.core.ConsoleAppender<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
        <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>encoder</span><span class="token punctuation">></span></span>
            <span class="token comment">&lt;!-- 日志输出的格式 --></span>
            <span class="token comment">&lt;!-- 按照顺序分别是：时间、日志级别、线程名称、打印日志的类、日志主体内容、换行 --></span>
            <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>pattern</span><span class="token punctuation">></span></span>[%d{HH:mm:ss.SSS}] [%-5level] [%thread] [%logger][%msg]%n<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>pattern</span><span class="token punctuation">></span></span>
        <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>encoder</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>appender</span><span class="token punctuation">></span></span>
    <span class="token comment">&lt;!-- 设置全局日志级别。日志级别按顺序分别是：DEBUG、INFO、WARN、ERROR --></span>
    <span class="token comment">&lt;!-- 指定任何一个日志级别都只打印当前级别和后面级别的日志。 --></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>root</span> <span class="token attr-name">level</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>DEBUG<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
        <span class="token comment">&lt;!-- 指定打印日志的appender，这里通过“STDOUT”引用了前面配置的appender --></span>
        <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>appender-ref</span> <span class="token attr-name">ref</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>STDOUT<span class="token punctuation">"</span></span> <span class="token punctuation">/></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>root</span><span class="token punctuation">></span></span>
    <span class="token comment">&lt;!-- 根据特殊需求指定局部日志级别 --></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>logger</span> <span class="token attr-name">name</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>com.atguigu.crowd.mapper<span class="token punctuation">"</span></span> <span class="token attr-name">level</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>DEBUG<span class="token punctuation">"</span></span><span class="token punctuation">/></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>configuration</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><h4 id="_6-5-4-设置使用ehcache" tabindex="-1"><a class="header-anchor" href="#_6-5-4-设置使用ehcache" aria-hidden="true">#</a> 6.5.4 设置使用<code v-pre>EHCache</code></h4>
<ol>
<li>在mapper映射文件的<code v-pre>&lt;cache/&gt;</code>标签中指定<code v-pre>type</code>属性值为<code v-pre>EhcacheCache</code>：
<ul>
<li><code v-pre>&lt;cache type=&quot;org.mybatis.caches.ehcache.EhcacheCache&quot;/&gt;</code></li>
</ul>
</li>
</ol>
<h2 id="⭐第7章-mybatis的逆向工程" tabindex="-1"><a class="header-anchor" href="#⭐第7章-mybatis的逆向工程" aria-hidden="true">#</a> ⭐第7章 MyBatis的逆向工程</h2>
<h3 id="_7-1-正向工程与逆向工程" tabindex="-1"><a class="header-anchor" href="#_7-1-正向工程与逆向工程" aria-hidden="true">#</a> 7.1 正向工程与逆向工程</h3>
<ul>
<li>正向工程：先创建Java实体类，由框架负责根据实体类生成数据库表。<code v-pre>Hibernate</code>是支持正向工程的。</li>
<li>逆向工程：先创建数据库表，由框架负责根据数据库表，反向生成如下资源：
<ul>
<li>Java实体类</li>
<li>Mapper接口（持久层）</li>
<li>Mapper映射文件</li>
</ul>
</li>
</ul>
<h3 id="_7-2-创建mybatis的逆向工程" tabindex="-1"><a class="header-anchor" href="#_7-2-创建mybatis的逆向工程" aria-hidden="true">#</a> 7.2 创建MyBatis的逆向工程</h3>
<h4 id="_7-2-1-添加依赖和插件" tabindex="-1"><a class="header-anchor" href="#_7-2-1-添加依赖和插件" aria-hidden="true">#</a> 7.2.1 添加依赖和插件</h4>
<div class="language-xml ext-xml line-numbers-mode"><pre v-pre class="language-xml"><code><span class="token prolog">&lt;?xml version="1.0" encoding="UTF-8"?></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>project</span> <span class="token attr-name">xmlns</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>http://maven.apache.org/POM/4.0.0<span class="token punctuation">"</span></span>
         <span class="token attr-name"><span class="token namespace">xmlns:</span>xsi</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>http://www.w3.org/2001/XMLSchema-instance<span class="token punctuation">"</span></span>
         <span class="token attr-name"><span class="token namespace">xsi:</span>schemaLocation</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>parent</span><span class="token punctuation">></span></span>
        <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>artifactId</span><span class="token punctuation">></span></span>12.MyBatis<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>artifactId</span><span class="token punctuation">></span></span>
        <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>groupId</span><span class="token punctuation">></span></span>iceriver.mybatis<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>groupId</span><span class="token punctuation">></span></span>
        <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>version</span><span class="token punctuation">></span></span>1.0-SNAPSHOT<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>version</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>parent</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>modelVersion</span><span class="token punctuation">></span></span>4.0.0<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>modelVersion</span><span class="token punctuation">></span></span>

    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>artifactId</span><span class="token punctuation">></span></span>pr04-mybatis-MBG<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>artifactId</span><span class="token punctuation">></span></span>

    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>properties</span><span class="token punctuation">></span></span>
        <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>maven.compiler.source</span><span class="token punctuation">></span></span>8<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>maven.compiler.source</span><span class="token punctuation">></span></span>
        <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>maven.compiler.target</span><span class="token punctuation">></span></span>8<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>maven.compiler.target</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>properties</span><span class="token punctuation">></span></span>
    <span class="token comment">&lt;!-- 依赖MyBatis核心包 --></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>dependencies</span><span class="token punctuation">></span></span>
        <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>dependency</span><span class="token punctuation">></span></span>
            <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>groupId</span><span class="token punctuation">></span></span>org.mybatis<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>groupId</span><span class="token punctuation">></span></span>
            <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>artifactId</span><span class="token punctuation">></span></span>mybatis<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>artifactId</span><span class="token punctuation">></span></span>
            <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>version</span><span class="token punctuation">></span></span>3.5.7<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>version</span><span class="token punctuation">></span></span>
        <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>dependency</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>dependencies</span><span class="token punctuation">></span></span>
    <span class="token comment">&lt;!-- 控制Maven在构建过程中相关配置 --></span>

    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>build</span><span class="token punctuation">></span></span>
        <span class="token comment">&lt;!-- 构建过程中用到的插件 --></span>
        <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>plugins</span><span class="token punctuation">></span></span>
            <span class="token comment">&lt;!-- 具体插件，逆向工程的操作是以构建过程中插件形式出现的 --></span>
            <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>plugin</span><span class="token punctuation">></span></span>
                <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>groupId</span><span class="token punctuation">></span></span>org.mybatis.generator<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>groupId</span><span class="token punctuation">></span></span>
                <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>artifactId</span><span class="token punctuation">></span></span>mybatis-generator-maven-plugin<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>artifactId</span><span class="token punctuation">></span></span>
                <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>version</span><span class="token punctuation">></span></span>1.3.0<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>version</span><span class="token punctuation">></span></span>
                <span class="token comment">&lt;!-- 插件的依赖 --></span>
                <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>dependencies</span><span class="token punctuation">></span></span>
                    <span class="token comment">&lt;!-- 逆向工程的核心依赖 --></span>
                    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>dependency</span><span class="token punctuation">></span></span>
                        <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>groupId</span><span class="token punctuation">></span></span>org.mybatis.generator<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>groupId</span><span class="token punctuation">></span></span>
                        <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>artifactId</span><span class="token punctuation">></span></span>mybatis-generator-core<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>artifactId</span><span class="token punctuation">></span></span>
                        <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>version</span><span class="token punctuation">></span></span>1.3.2<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>version</span><span class="token punctuation">></span></span>
                    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>dependency</span><span class="token punctuation">></span></span>
                    <span class="token comment">&lt;!-- 数据库连接池 --></span>
                    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>dependency</span><span class="token punctuation">></span></span>
                        <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>groupId</span><span class="token punctuation">></span></span>com.mchange<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>groupId</span><span class="token punctuation">></span></span>
                        <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>artifactId</span><span class="token punctuation">></span></span>c3p0<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>artifactId</span><span class="token punctuation">></span></span>
                        <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>version</span><span class="token punctuation">></span></span>0.9.2<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>version</span><span class="token punctuation">></span></span>
                    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>dependency</span><span class="token punctuation">></span></span>
                    <span class="token comment">&lt;!-- MySQL驱动 --></span>
                    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>dependency</span><span class="token punctuation">></span></span>
                        <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>groupId</span><span class="token punctuation">></span></span>mysql<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>groupId</span><span class="token punctuation">></span></span>
                        <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>artifactId</span><span class="token punctuation">></span></span>mysql-connector-java<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>artifactId</span><span class="token punctuation">></span></span>
                        <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>version</span><span class="token punctuation">></span></span>5.1.8<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>version</span><span class="token punctuation">></span></span>
                    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>dependency</span><span class="token punctuation">></span></span>
                <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>dependencies</span><span class="token punctuation">></span></span>
            <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>plugin</span><span class="token punctuation">></span></span>
        <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>plugins</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>build</span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>project</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><p><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1658915755603-e891f55c-4f75-4856-8521-199fd7095250.png#clientId=u58a324e4-3d2a-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=218&amp;id=u0b305316&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=218&amp;originWidth=620&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=44626&amp;status=done&amp;style=none&amp;taskId=ua3c14baa-2511-41ab-acdf-fa86d866ac6&amp;title=&amp;width=620" alt="image.png" loading="lazy"></p>
<h4 id="_7-2-2-创建逆向工程配置文件" tabindex="-1"><a class="header-anchor" href="#_7-2-2-创建逆向工程配置文件" aria-hidden="true">#</a> 7.2.2 创建逆向工程配置文件</h4>
<blockquote>
<ul>
<li>在<code v-pre>resources</code>目录下创建配置文件<code v-pre>generatorConfig.xml</code></li>
</ul>
</blockquote>
<div class="language-xml ext-xml line-numbers-mode"><pre v-pre class="language-xml"><code><span class="token prolog">&lt;?xml version="1.0" encoding="UTF-8"?></span>
<span class="token doctype"><span class="token punctuation">&lt;!</span><span class="token doctype-tag">DOCTYPE</span> <span class="token name">generatorConfiguration</span>
        <span class="token name">PUBLIC</span> <span class="token string">"-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN"</span>
        <span class="token string">"http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd"</span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>generatorConfiguration</span><span class="token punctuation">></span></span>
    <span class="token comment">&lt;!--
    targetRuntime: 执行生成的逆向工程的版本
    MyBatis3Simple: 生成基本的CRUD（清新简洁版）
    MyBatis3: 生成带条件的CRUD（奢华尊享版）
    --></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>context</span> <span class="token attr-name">id</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>DB2Tables<span class="token punctuation">"</span></span> <span class="token attr-name">targetRuntime</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>MyBatis3Simple<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
        <span class="token comment">&lt;!-- 数据库的连接信息 --></span>
        <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>jdbcConnection</span> <span class="token attr-name">driverClass</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>com.mysql.jdbc.Driver<span class="token punctuation">"</span></span>
                        <span class="token attr-name">connectionURL</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>jdbc:mysql://localhost:13306/mybatis_db<span class="token punctuation">"</span></span>
                        <span class="token attr-name">userId</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>root<span class="token punctuation">"</span></span>
                        <span class="token attr-name">password</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>dimitre123<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
        <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>jdbcConnection</span><span class="token punctuation">></span></span>
        <span class="token comment">&lt;!-- javaBean的生成策略--></span>
        <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>javaModelGenerator</span> <span class="token attr-name">targetPackage</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>iceriver.mybatis.bean<span class="token punctuation">"</span></span>
                            <span class="token attr-name">targetProject</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>.\src\main\java<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
            <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>property</span> <span class="token attr-name">name</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>enableSubPackages<span class="token punctuation">"</span></span> <span class="token attr-name">value</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>true<span class="token punctuation">"</span></span> <span class="token punctuation">/></span></span>
            <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>property</span> <span class="token attr-name">name</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>trimStrings<span class="token punctuation">"</span></span> <span class="token attr-name">value</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>true<span class="token punctuation">"</span></span> <span class="token punctuation">/></span></span>
        <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>javaModelGenerator</span><span class="token punctuation">></span></span>
        <span class="token comment">&lt;!-- SQL映射文件的生成策略 --></span>
        <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>sqlMapGenerator</span> <span class="token attr-name">targetPackage</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>iceriver.mybatis.mapper<span class="token punctuation">"</span></span>
                         <span class="token attr-name">targetProject</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>.\src\main\resources<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
            <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>property</span> <span class="token attr-name">name</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>enableSubPackages<span class="token punctuation">"</span></span> <span class="token attr-name">value</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>true<span class="token punctuation">"</span></span> <span class="token punctuation">/></span></span>
        <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>sqlMapGenerator</span><span class="token punctuation">></span></span>
        <span class="token comment">&lt;!-- Mapper接口的生成策略 --></span>
        <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>javaClientGenerator</span> <span class="token attr-name">type</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>XMLMAPPER<span class="token punctuation">"</span></span>
                             <span class="token attr-name">targetPackage</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>iceriver.mybatis.mapper<span class="token punctuation">"</span></span>
                             <span class="token attr-name">targetProject</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>.\src\main\java<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
            <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>property</span> <span class="token attr-name">name</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>enableSubPackages<span class="token punctuation">"</span></span> <span class="token attr-name">value</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>true<span class="token punctuation">"</span></span> <span class="token punctuation">/></span></span>
        <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>javaClientGenerator</span><span class="token punctuation">></span></span>
        <span class="token comment">&lt;!-- 逆向分析的表 --></span>
        <span class="token comment">&lt;!-- tableName设置为*号，可以对应所有表，此时不写domainObjectName --></span>
        <span class="token comment">&lt;!-- domainObjectName属性指定生成出来的实体类的类名 --></span>
        <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>table</span> <span class="token attr-name">tableName</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>t_emp<span class="token punctuation">"</span></span> <span class="token attr-name">domainObjectName</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>Emp<span class="token punctuation">"</span></span><span class="token punctuation">/></span></span>
        <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>table</span> <span class="token attr-name">tableName</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>t_dept<span class="token punctuation">"</span></span> <span class="token attr-name">domainObjectName</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>Dept<span class="token punctuation">"</span></span><span class="token punctuation">/></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>context</span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>generatorConfiguration</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ul>
<li>文件名称是固定的吗？</li>
</ul>
<h4 id="_7-2-3-执行mbg插件" tabindex="-1"><a class="header-anchor" href="#_7-2-3-执行mbg插件" aria-hidden="true">#</a> 7.2.3 执行MBG插件</h4>
<p><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1658916411854-120f0333-7fc8-4b58-9260-3105cd9e935a.png#clientId=u58a324e4-3d2a-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=1032&amp;id=uc92f2bfb&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=1032&amp;originWidth=1920&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=316934&amp;status=done&amp;style=none&amp;taskId=ud6ed4f14-0910-4bb7-bb1e-b0caa6e4c6e&amp;title=&amp;width=1920" alt="image.png" loading="lazy"></p>
<ol>
<li>简洁版生成的mapper文件：
<ul>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1658916644615-0e8af097-ee3c-4e9e-8c99-1ce1b30a149c.png#clientId=u58a324e4-3d2a-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=543&amp;id=b2ous&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=543&amp;originWidth=318&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=33494&amp;status=done&amp;style=none&amp;taskId=u1317c607-979b-4128-a9c3-674565551b5&amp;title=&amp;width=318" alt="image.png" loading="lazy"></li>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1658916561997-b54ee404-bfad-4298-866e-918468ebe253.png#clientId=u58a324e4-3d2a-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=525&amp;id=A21Po&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=525&amp;originWidth=681&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=53438&amp;status=done&amp;style=none&amp;taskId=u8b3c6928-02d2-4476-a562-e934a538ac0&amp;title=&amp;width=681" alt="image.png" loading="lazy"></li>
</ul>
</li>
<li>奢华版生成的mapper文件：
<ul>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1658916930928-b297428d-2dd5-4eb7-bec2-095807fd7d9c.png#clientId=u58a324e4-3d2a-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=578&amp;id=u2e652cee&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=578&amp;originWidth=327&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=34174&amp;status=done&amp;style=none&amp;taskId=ubcc0c30a-dc2e-465b-99bf-8ad10affd24&amp;title=&amp;width=327" alt="image.png" loading="lazy"></li>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1658918601306-c5b83ea4-ff78-4ab0-b152-20cc367dc7ef.png#clientId=u58a324e4-3d2a-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=242&amp;id=u91484c7e&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=242&amp;originWidth=394&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=15962&amp;status=done&amp;style=none&amp;taskId=uc2eb6d51-9139-40af-9f0c-605b3cec8f3&amp;title=&amp;width=394" alt="image.png" loading="lazy"></li>
<li>带<code v-pre>Selective</code>的方法与不带的区别是：如果传入的参数有<code v-pre>null</code>，带<code v-pre>Selective</code>的方法不会修改原值，不带<code v-pre>Selective</code>的方法会将原值改为<code v-pre>null</code></li>
</ul>
</li>
</ol>
<h4 id="_7-2-4-qbc查询" tabindex="-1"><a class="header-anchor" href="#_7-2-4-qbc查询" aria-hidden="true">#</a> 7.2.4 QBC查询</h4>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token keyword">package</span> <span class="token namespace">iceriver<span class="token punctuation">.</span>mybatis<span class="token punctuation">.</span>test</span><span class="token punctuation">;</span>

<span class="token keyword">import</span> <span class="token import"><span class="token namespace">iceriver<span class="token punctuation">.</span>mybatis<span class="token punctuation">.</span>bean<span class="token punctuation">.</span></span><span class="token class-name">Emp</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">iceriver<span class="token punctuation">.</span>mybatis<span class="token punctuation">.</span>bean<span class="token punctuation">.</span></span><span class="token class-name">EmpExample</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">iceriver<span class="token punctuation">.</span>mybatis<span class="token punctuation">.</span>mapper<span class="token punctuation">.</span></span><span class="token class-name">EmpMapper</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">org<span class="token punctuation">.</span>apache<span class="token punctuation">.</span>ibatis<span class="token punctuation">.</span>io<span class="token punctuation">.</span></span><span class="token class-name">Resources</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">org<span class="token punctuation">.</span>apache<span class="token punctuation">.</span>ibatis<span class="token punctuation">.</span>session<span class="token punctuation">.</span></span><span class="token class-name">SqlSession</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">org<span class="token punctuation">.</span>apache<span class="token punctuation">.</span>ibatis<span class="token punctuation">.</span>session<span class="token punctuation">.</span></span><span class="token class-name">SqlSessionFactory</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">org<span class="token punctuation">.</span>apache<span class="token punctuation">.</span>ibatis<span class="token punctuation">.</span>session<span class="token punctuation">.</span></span><span class="token class-name">SqlSessionFactoryBuilder</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">org<span class="token punctuation">.</span>junit<span class="token punctuation">.</span></span><span class="token class-name">Test</span></span><span class="token punctuation">;</span>

<span class="token keyword">import</span> <span class="token import"><span class="token namespace">java<span class="token punctuation">.</span>io<span class="token punctuation">.</span></span><span class="token class-name">IOException</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">java<span class="token punctuation">.</span>io<span class="token punctuation">.</span></span><span class="token class-name">InputStream</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">java<span class="token punctuation">.</span>util<span class="token punctuation">.</span></span><span class="token class-name">List</span></span><span class="token punctuation">;</span>


<span class="token doc-comment comment">/**
* <span class="token keyword">@author</span>: INFINITY https://developer.aliyun.com/profile/sagwrxp2ua66w
* <span class="token keyword">@date</span>: 2022/7/27 18:25
*/</span>
<span class="token keyword">public</span> <span class="token keyword">class</span> <span class="token class-name">MBGTest</span> <span class="token punctuation">{</span>
    <span class="token annotation punctuation">@Test</span>
    <span class="token keyword">public</span> <span class="token keyword">void</span> <span class="token function">testMBG</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">{</span>
        <span class="token keyword">try</span><span class="token punctuation">{</span>
            <span class="token class-name">InputStream</span> inputStream <span class="token operator">=</span> <span class="token class-name">Resources</span><span class="token punctuation">.</span><span class="token function">getResourceAsStream</span><span class="token punctuation">(</span><span class="token string">"mybatis-config.xml"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
            <span class="token class-name">SqlSessionFactory</span> build <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">SqlSessionFactoryBuilder</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">.</span><span class="token function">build</span><span class="token punctuation">(</span>inputStream<span class="token punctuation">)</span><span class="token punctuation">;</span>
            <span class="token class-name">SqlSession</span> sqlSession <span class="token operator">=</span> build<span class="token punctuation">.</span><span class="token function">openSession</span><span class="token punctuation">(</span><span class="token boolean">true</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
            <span class="token class-name">EmpMapper</span> mapper <span class="token operator">=</span> sqlSession<span class="token punctuation">.</span><span class="token function">getMapper</span><span class="token punctuation">(</span><span class="token class-name">EmpMapper</span><span class="token punctuation">.</span><span class="token keyword">class</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
            <span class="token comment">//1. 查询所有员工</span>
            <span class="token class-name">List</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">Emp</span><span class="token punctuation">></span></span> emps <span class="token operator">=</span> mapper<span class="token punctuation">.</span><span class="token function">selectByExample</span><span class="token punctuation">(</span><span class="token keyword">null</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
            emps<span class="token punctuation">.</span><span class="token function">forEach</span><span class="token punctuation">(</span>emp <span class="token operator">-></span> <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span>emp<span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
            
            <span class="token comment">//2. 根据条件查询</span>
            <span class="token class-name">EmpExample</span> empExample <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">EmpExample</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
            empExample<span class="token punctuation">.</span><span class="token function">createCriteria</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">.</span><span class="token function">andEmpNameEqualTo</span><span class="token punctuation">(</span><span class="token string">"a1"</span><span class="token punctuation">)</span><span class="token punctuation">.</span><span class="token function">andAgeGreaterThan</span><span class="token punctuation">(</span><span class="token number">20</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
            empExample<span class="token punctuation">.</span><span class="token function">or</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">.</span><span class="token function">andDidIsNotNull</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
            <span class="token class-name">List</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">Emp</span><span class="token punctuation">></span></span> emps <span class="token operator">=</span> mapper<span class="token punctuation">.</span><span class="token function">selectByExample</span><span class="token punctuation">(</span>empExample<span class="token punctuation">)</span><span class="token punctuation">;</span>
            emps<span class="token punctuation">.</span><span class="token function">forEach</span><span class="token punctuation">(</span>emp <span class="token operator">-></span> <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span>emp<span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
            
            <span class="token comment">//3. 修改</span>
            mapper<span class="token punctuation">.</span><span class="token function">updateByPrimaryKey</span><span class="token punctuation">(</span><span class="token keyword">new</span> <span class="token class-name">Emp</span><span class="token punctuation">(</span><span class="token number">1</span><span class="token punctuation">,</span> <span class="token string">"wuxie"</span><span class="token punctuation">,</span> <span class="token keyword">null</span><span class="token punctuation">,</span> <span class="token keyword">null</span><span class="token punctuation">,</span> <span class="token keyword">null</span><span class="token punctuation">,</span><span class="token keyword">null</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token punctuation">}</span> <span class="token keyword">catch</span> <span class="token punctuation">(</span><span class="token class-name">IOException</span> e<span class="token punctuation">)</span> <span class="token punctuation">{</span>
            e<span class="token punctuation">.</span><span class="token function">printStackTrace</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token punctuation">}</span>
    <span class="token punctuation">}</span>
<span class="token punctuation">}</span>

</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><h2 id="⭐第8章-分页插件" tabindex="-1"><a class="header-anchor" href="#⭐第8章-分页插件" aria-hidden="true">#</a> ⭐第8章 分页插件</h2>
<h3 id="_8-1-添加依赖" tabindex="-1"><a class="header-anchor" href="#_8-1-添加依赖" aria-hidden="true">#</a> 8.1 添加依赖</h3>
<div class="language-xml ext-xml line-numbers-mode"><pre v-pre class="language-xml"><code><span class="token comment">&lt;!-- https://mvnrepository.com/artifact/com.github.pagehelper/pagehelper --></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>dependency</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>groupId</span><span class="token punctuation">></span></span>com.github.pagehelper<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>groupId</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>artifactId</span><span class="token punctuation">></span></span>pagehelper<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>artifactId</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>version</span><span class="token punctuation">></span></span>5.2.0<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>version</span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>dependency</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><h3 id="_8-2-配置分页插件" tabindex="-1"><a class="header-anchor" href="#_8-2-配置分页插件" aria-hidden="true">#</a> 8.2 配置分页插件</h3>
<ol>
<li>在<code v-pre>mybatic-config.xml</code>核心配置文件中配置插件：</li>
</ol>
<div class="language-xml ext-xml line-numbers-mode"><pre v-pre class="language-xml"><code><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>plugins</span><span class="token punctuation">></span></span>
  <span class="token comment">&lt;!--设置分页插件--></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>plugin</span> <span class="token attr-name">interceptor</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>com.github.pagehelper.PageInterceptor<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>plugin</span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>plugins</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><h3 id="_8-3-使用分页查询" tabindex="-1"><a class="header-anchor" href="#_8-3-使用分页查询" aria-hidden="true">#</a> 8.3 使用分页查询</h3>
<ol>
<li>在查询功能之前使用<code v-pre>PageHelper.startPage(int pageNum, int pageSize)</code>开启分页功能
<ul>
<li><code v-pre>pageNum</code>：当前页的页码</li>
<li><code v-pre>pageSize</code>：每页显示的条数</li>
</ul>
</li>
<li>在查询获取到list集合之后，使用<code v-pre>PageInfo&lt;T&gt; pageInfo = new PageInfo&lt;&gt;(List&lt;T&gt; list, int navigatePages)</code>获取分页相关数据
<ul>
<li><code v-pre>list</code>：分页之后的数据</li>
<li><code v-pre>navigatePages</code>：导航分页的页码数</li>
</ul>
</li>
<li>分页<code v-pre>pageInfo</code>相关数据：
<ul>
<li><code v-pre>pageNum</code>：当前页的页码</li>
<li><code v-pre>pageSize</code>：每页显示的条数</li>
<li><code v-pre>size</code>：当前页显示的真实条数</li>
<li><code v-pre>total</code>：总记录数</li>
<li><code v-pre>pages</code>：总页数</li>
<li><code v-pre>prePage</code>：上一页的页码</li>
<li><code v-pre>nextPage</code>：下一页的页码</li>
<li><code v-pre>isFirstPage/isLastPage</code>：是否为第一页/最后一页</li>
<li><code v-pre>hasPreviousPage/hasNextPage</code>：是否存在上一页/下一页</li>
<li><code v-pre>navigatePages</code>：导航分页的页码数</li>
<li><code v-pre>navigatepageNums</code>：导航分页的页码，[1,2,3,4,5]</li>
</ul>
</li>
</ol>
</div></template>
