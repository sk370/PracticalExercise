<template><div><h1 id="mybatis-plus" tabindex="-1"><a class="header-anchor" href="#mybatis-plus" aria-hidden="true">#</a> MyBatis Plus</h1>
<blockquote>
<ul>
<li>最好学了SpringBoot之后【SpringBoot使用时更简单】</li>
<li>也可以学习了ssm之后</li>
<li>代码发布地址:
<ul>
<li>Github: <a href="https://github.com/baomidou/mybatis-plus" target="_blank" rel="noopener noreferrer">https://github.com/baomidou/mybatis-plus<ExternalLinkIcon/></a></li>
<li>Gitee: <a href="https://gitee.com/baomidou/mybatis-plus" target="_blank" rel="noopener noreferrer">https://gitee.com/baomidou/mybatis-plus<ExternalLinkIcon/></a></li>
</ul>
</li>
<li>文档发布地址:<a href="https://baomidou.com/pages/24112f" target="_blank" rel="noopener noreferrer">https://baomidou.com/pages/24112f<ExternalLinkIcon/></a></li>
</ul>
</blockquote>
<h2 id="第1章-mybatis-plus介绍" tabindex="-1"><a class="header-anchor" href="#第1章-mybatis-plus介绍" aria-hidden="true">#</a> 第1章 MyBatis-Plus介绍</h2>
<h3 id="_1-1-简介" tabindex="-1"><a class="header-anchor" href="#_1-1-简介" aria-hidden="true">#</a> 1.1 简介</h3>
<h3 id="_1-2-特性" tabindex="-1"><a class="header-anchor" href="#_1-2-特性" aria-hidden="true">#</a> 1.2 特性</h3>
<ol>
<li>无侵入：只做增强不做改变，引入它不会对现有工程产生影响</li>
<li>损耗小：启动即会自动注入基本 CURD，性能基本无损耗，直接面向对象操作</li>
<li>强大的 CRUD 操作：内置通用 Mapper、通用 Service，仅仅通过少量配置即可实现单表大部分CRUD 操作，更有强大的条件构造器，满足各类使用需求</li>
<li>支持 Lambda 形式调用：通过 Lambda 表达式，方便的编写各类查询条件，无需再担心字段写错</li>
<li>支持主键自动生成：支持多达 4 种主键策略（内含分布式唯一 ID 生成器 - Sequence），可自由配置，完美解决主键问题</li>
<li>支持 ActiveRecord 模式：支持 ActiveRecord 形式调用，实体类只需继承 Model 类即可进行强大的 CRUD 操作</li>
<li>支持自定义全局通用操作：支持全局通用方法注入（ Write once, use anywhere ）</li>
<li>内置代码生成器：采用代码或者 Maven 插件可快速生成 Mapper 、 Model 、 Service 、Controller 层代码，支持模板引擎等超多自定义配置</li>
<li>内置分页插件：基于 MyBatis 物理分页，开发者无需关心具体操作，配置好插件之后，写分页等同于普通 List 查询</li>
<li>分页插件支持多种数据库：支持 MySQL、MariaDB、Oracle、DB2、H2、HSQL、SQLite、Postgre、SQLServer 等多种数据库</li>
<li>内置性能分析插件：可输出 SQL 语句以及其执行时间，建议开发测试时启用该功能，能快速揪出慢查询</li>
<li>内置全局拦截插件：提供全表 delete 、 update 操作智能分析阻断，也可自定义拦截规则，预防误操作</li>
</ol>
<h3 id="_1-3-框架结构" tabindex="-1"><a class="header-anchor" href="#_1-3-框架结构" aria-hidden="true">#</a> 1.3 框架结构</h3>
<p><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1659436803386-cb40eae4-66da-405e-b2db-05509b797374.png#clientId=u0ce8d131-3c5b-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=852&amp;id=ub42f8704&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=852&amp;originWidth=1330&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=521774&amp;status=done&amp;style=none&amp;taskId=u1ea72db8-18ad-435a-b7c2-0e132d84fb1&amp;title=&amp;width=1330" alt="image.png" loading="lazy"></p>
<h3 id="_1-4-入门案例" tabindex="-1"><a class="header-anchor" href="#_1-4-入门案例" aria-hidden="true">#</a> 1.4 入门案例</h3>
<h4 id="_1-5-1-开发环境" tabindex="-1"><a class="header-anchor" href="#_1-5-1-开发环境" aria-hidden="true">#</a> 1.5.1 开发环境</h4>
<ul>
<li>jdk8</li>
<li>Maven：3.6.1</li>
<li>Spring：5.3.1</li>
<li>My-Batis-Plus：3.4.3.4（注意：引入了mybatisplus，就不要再引入mybatis和mybatsi-spring，避免版本冲突（官网提示）</li>
</ul>
<h4 id="_1-5-2-创建数据表" tabindex="-1"><a class="header-anchor" href="#_1-5-2-创建数据表" aria-hidden="true">#</a> 1.5.2 创建数据表</h4>
<div class="language-sql ext-sql line-numbers-mode"><pre v-pre class="language-sql"><code><span class="token keyword">CREATE</span> <span class="token keyword">DATABASE</span> <span class="token identifier"><span class="token punctuation">`</span>mybatis_plus<span class="token punctuation">`</span></span> <span class="token comment">/*!40100 DEFAULT CHARACTER SET utf8mb4 */</span><span class="token punctuation">;</span>
<span class="token keyword">use</span> <span class="token identifier"><span class="token punctuation">`</span>mybatis_plus<span class="token punctuation">`</span></span><span class="token punctuation">;</span>
<span class="token keyword">CREATE</span> <span class="token keyword">TABLE</span> <span class="token identifier"><span class="token punctuation">`</span>user<span class="token punctuation">`</span></span> <span class="token punctuation">(</span>
<span class="token identifier"><span class="token punctuation">`</span>id<span class="token punctuation">`</span></span> <span class="token keyword">bigint</span><span class="token punctuation">(</span><span class="token number">20</span><span class="token punctuation">)</span> <span class="token operator">NOT</span> <span class="token boolean">NULL</span> <span class="token keyword">COMMENT</span> <span class="token string">'主键ID'</span><span class="token punctuation">,</span>
<span class="token identifier"><span class="token punctuation">`</span>name<span class="token punctuation">`</span></span> <span class="token keyword">varchar</span><span class="token punctuation">(</span><span class="token number">30</span><span class="token punctuation">)</span> <span class="token keyword">DEFAULT</span> <span class="token boolean">NULL</span> <span class="token keyword">COMMENT</span> <span class="token string">'姓名'</span><span class="token punctuation">,</span>
<span class="token identifier"><span class="token punctuation">`</span>age<span class="token punctuation">`</span></span> <span class="token keyword">int</span><span class="token punctuation">(</span><span class="token number">11</span><span class="token punctuation">)</span> <span class="token keyword">DEFAULT</span> <span class="token boolean">NULL</span> <span class="token keyword">COMMENT</span> <span class="token string">'年龄'</span><span class="token punctuation">,</span>
<span class="token identifier"><span class="token punctuation">`</span>email<span class="token punctuation">`</span></span> <span class="token keyword">varchar</span><span class="token punctuation">(</span><span class="token number">50</span><span class="token punctuation">)</span> <span class="token keyword">DEFAULT</span> <span class="token boolean">NULL</span> <span class="token keyword">COMMENT</span> <span class="token string">'邮箱'</span><span class="token punctuation">,</span>
<span class="token keyword">PRIMARY</span> <span class="token keyword">KEY</span> <span class="token punctuation">(</span><span class="token identifier"><span class="token punctuation">`</span>id<span class="token punctuation">`</span></span><span class="token punctuation">)</span>
<span class="token punctuation">)</span> <span class="token keyword">ENGINE</span><span class="token operator">=</span><span class="token keyword">InnoDB</span> <span class="token keyword">DEFAULT</span> <span class="token keyword">CHARSET</span><span class="token operator">=</span>utf8<span class="token punctuation">;</span>
<span class="token keyword">INSERT</span> <span class="token keyword">INTO</span> <span class="token keyword">user</span> <span class="token punctuation">(</span>id<span class="token punctuation">,</span> name<span class="token punctuation">,</span> age<span class="token punctuation">,</span> email<span class="token punctuation">)</span> <span class="token keyword">VALUES</span>
<span class="token punctuation">(</span><span class="token number">1</span><span class="token punctuation">,</span> <span class="token string">'Jone'</span><span class="token punctuation">,</span> <span class="token number">18</span><span class="token punctuation">,</span> <span class="token string">'test1@baomidou.com'</span><span class="token punctuation">)</span><span class="token punctuation">,</span>
<span class="token punctuation">(</span><span class="token number">2</span><span class="token punctuation">,</span> <span class="token string">'Jack'</span><span class="token punctuation">,</span> <span class="token number">20</span><span class="token punctuation">,</span> <span class="token string">'test2@baomidou.com'</span><span class="token punctuation">)</span><span class="token punctuation">,</span>
<span class="token punctuation">(</span><span class="token number">3</span><span class="token punctuation">,</span> <span class="token string">'Tom'</span><span class="token punctuation">,</span> <span class="token number">28</span><span class="token punctuation">,</span> <span class="token string">'test3@baomidou.com'</span><span class="token punctuation">)</span><span class="token punctuation">,</span>
<span class="token punctuation">(</span><span class="token number">4</span><span class="token punctuation">,</span> <span class="token string">'Sandy'</span><span class="token punctuation">,</span> <span class="token number">21</span><span class="token punctuation">,</span> <span class="token string">'test4@baomidou.com'</span><span class="token punctuation">)</span><span class="token punctuation">,</span>
<span class="token punctuation">(</span><span class="token number">5</span><span class="token punctuation">,</span> <span class="token string">'Billie'</span><span class="token punctuation">,</span> <span class="token number">24</span><span class="token punctuation">,</span> <span class="token string">'test5@baomidou.com'</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><h4 id="_1-5-3-创建maven工程-基于spring-boot" tabindex="-1"><a class="header-anchor" href="#_1-5-3-创建maven工程-基于spring-boot" aria-hidden="true">#</a> 1.5.3 创建Maven工程（基于Spring Boot）</h4>
<ol>
<li>新建项目：
<ul>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1659616988189-b08420ae-9350-44b5-b27a-3a336bb6603e.png#clientId=uaf8d940b-efc7-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=625&amp;id=ufa723ed7&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=625&amp;originWidth=802&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=56687&amp;status=done&amp;style=none&amp;taskId=u9c745177-091f-45ab-8f29-68be91bd4aa&amp;title=&amp;width=802" alt="image.png" loading="lazy"></li>
<li>不选择依赖，通过手动编辑pom.xml文件的形式添加</li>
</ul>
</li>
<li>在pom.xml文件中添加依赖
<ul>
<li>空项目默认有spring-boot-starter和spring-boot-starter-test依赖</li>
<li>额外再引入mybatis-plus-boot-starter、lombok（同时须下载该插件）、mysql-connector-java</li>
</ul>
</li>
</ol>
<div class="language-xml ext-xml line-numbers-mode"><pre v-pre class="language-xml"><code><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>dependency</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>groupId</span><span class="token punctuation">></span></span>com.baomidou<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>groupId</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>artifactId</span><span class="token punctuation">></span></span>mybatis-plus-boot-starter<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>artifactId</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>version</span><span class="token punctuation">></span></span>3.5.1<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>version</span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>dependency</span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>dependency</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>groupId</span><span class="token punctuation">></span></span>org.projectlombok<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>groupId</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>artifactId</span><span class="token punctuation">></span></span>lombok<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>artifactId</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>optional</span><span class="token punctuation">></span></span>true<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>optional</span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>dependency</span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>dependency</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>groupId</span><span class="token punctuation">></span></span>mysql<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>groupId</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>artifactId</span><span class="token punctuation">></span></span>mysql-connector-java<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>artifactId</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>scope</span><span class="token punctuation">></span></span>runtime<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>scope</span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>dependency</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ol start="3">
<li>配置数据源及日志输出（该日志用于在控制台查看mybatis-plus生成了什么sql语句）
<ul>
<li>在resources路径下新建application.yml核心配置文件</li>
</ul>
</li>
</ol>
<div class="language-xml ext-xml line-numbers-mode"><pre v-pre class="language-xml"><code>spring:
# 配置数据源信息
  datasource:
  # 配置数据源类型
    type: com.zaxxer.hikari.HikariDataSource
    # 配置连接数据库信息
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:13306/mybatis_plus?characterEncoding=utf-8&amp;useSSL=false
    username: root
    password: dimitre123
# 配置MyBatis日志
mybatis-plus:
  configuration:
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ul>
<li>spring boot 2.0内置jdbc5驱动
<ul>
<li>驱动类使用com.mysql.jdbc.Driver</li>
<li>url使用：jdbc:mysql://localhost:13306/mybatis_plus?characterEncoding=utf-8&amp;useSSL=false</li>
</ul>
</li>
<li>spring boot 2.1以上版本内置jdbc8驱动，
<ul>
<li>驱动类使用com.mysql.cj.jdbc.Driver</li>
<li>url使用：jdbc:mysql://localhost:13306/mybatis_plus?
serverTimezone=GMT%2B8&amp;characterEncoding=utf-8&amp;useSSL=false</li>
</ul>
</li>
</ul>
<h2 id="第2章-mybatis-plus使用" tabindex="-1"><a class="header-anchor" href="#第2章-mybatis-plus使用" aria-hidden="true">#</a> 第2章 mybatis-plus使用</h2>
<h3 id="_2-1-crud功能" tabindex="-1"><a class="header-anchor" href="#_2-1-crud功能" aria-hidden="true">#</a> 2.1 Crud功能</h3>
<h4 id="_2-1-1-基本使用" tabindex="-1"><a class="header-anchor" href="#_2-1-1-基本使用" aria-hidden="true">#</a> 2.1.1 基本使用</h4>
<ol>
<li>创建User JavaBean，使用@Data注解生成无参构造器、getter、setter、equals、tosting、hashcode，没有生成带参的构造器。
<ul>
<li>注意：数据表中id使用的数据类型为bigint，所以User类中的id使用了long类型</li>
<li>之所以这样做是因为mybatis插入数据时，自增的id使用的雪花算法，比较长。</li>
</ul>
</li>
<li>创建UserMapper接口，继承自BaseMapper，范型使用User
<ul>
<li>spring boot的启动程序类，<strong>使用@MapperScan(&quot;&quot;)指定扫描的mapper包</strong>
<ul>
<li><strong>扫描会把扫描到的类交给ioc容器管理，所以不是必须要在UserMapper类前使用</strong>@<strong>Repository进行声明</strong></li>
<li><strong>但是idea工具在自动装配usermapper时，会报红线，如果要消除红线，可以添加</strong>@<strong>Repository注解标记成持久层组件</strong></li>
</ul>
</li>
</ul>
</li>
<li>在test/iceriver.mybatisplus目录下创建测试类UserTests.java，使用@SpringBootTest注解进行标记，实验增删改查方法：</li>
</ol>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token comment">//</span>
<span class="token comment">// Source code recreated from a .class file by IntelliJ IDEA</span>
<span class="token comment">// (powered by FernFlower decompiler)</span>
<span class="token comment">//</span>

<span class="token keyword">package</span> <span class="token namespace">com<span class="token punctuation">.</span>baomidou<span class="token punctuation">.</span>mybatisplus<span class="token punctuation">.</span>core<span class="token punctuation">.</span>mapper</span><span class="token punctuation">;</span>

<span class="token keyword">import</span> <span class="token import"><span class="token namespace">com<span class="token punctuation">.</span>baomidou<span class="token punctuation">.</span>mybatisplus<span class="token punctuation">.</span>core<span class="token punctuation">.</span>conditions<span class="token punctuation">.</span></span><span class="token class-name">Wrapper</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">com<span class="token punctuation">.</span>baomidou<span class="token punctuation">.</span>mybatisplus<span class="token punctuation">.</span>core<span class="token punctuation">.</span>metadata<span class="token punctuation">.</span></span><span class="token class-name">IPage</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">com<span class="token punctuation">.</span>baomidou<span class="token punctuation">.</span>mybatisplus<span class="token punctuation">.</span>core<span class="token punctuation">.</span>toolkit<span class="token punctuation">.</span></span><span class="token class-name">CollectionUtils</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">com<span class="token punctuation">.</span>baomidou<span class="token punctuation">.</span>mybatisplus<span class="token punctuation">.</span>core<span class="token punctuation">.</span>toolkit<span class="token punctuation">.</span></span><span class="token class-name">ExceptionUtils</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">java<span class="token punctuation">.</span>io<span class="token punctuation">.</span></span><span class="token class-name">Serializable</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">java<span class="token punctuation">.</span>util<span class="token punctuation">.</span></span><span class="token class-name">Collection</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">java<span class="token punctuation">.</span>util<span class="token punctuation">.</span></span><span class="token class-name">List</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">java<span class="token punctuation">.</span>util<span class="token punctuation">.</span></span><span class="token class-name">Map</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">org<span class="token punctuation">.</span>apache<span class="token punctuation">.</span>ibatis<span class="token punctuation">.</span>annotations<span class="token punctuation">.</span></span><span class="token class-name">Param</span></span><span class="token punctuation">;</span>

<span class="token keyword">public</span> <span class="token keyword">interface</span> <span class="token class-name">BaseMapper</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">T</span><span class="token punctuation">></span></span> <span class="token keyword">extends</span> <span class="token class-name">Mapper</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">T</span><span class="token punctuation">></span></span> <span class="token punctuation">{</span>
    <span class="token keyword">int</span> <span class="token function">insert</span><span class="token punctuation">(</span><span class="token class-name">T</span> entity<span class="token punctuation">)</span><span class="token punctuation">;</span>
    
    <span class="token keyword">int</span> <span class="token function">deleteById</span><span class="token punctuation">(</span><span class="token class-name">Serializable</span> id<span class="token punctuation">)</span><span class="token punctuation">;</span>
    
    <span class="token keyword">int</span> <span class="token function">deleteById</span><span class="token punctuation">(</span><span class="token class-name">T</span> entity<span class="token punctuation">)</span><span class="token punctuation">;</span>
    
    <span class="token keyword">int</span> <span class="token function">deleteByMap</span><span class="token punctuation">(</span><span class="token annotation punctuation">@Param</span><span class="token punctuation">(</span><span class="token string">"cm"</span><span class="token punctuation">)</span> <span class="token class-name">Map</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">String</span><span class="token punctuation">,</span> <span class="token class-name">Object</span><span class="token punctuation">></span></span> columnMap<span class="token punctuation">)</span><span class="token punctuation">;</span>
    
    <span class="token keyword">int</span> <span class="token function">delete</span><span class="token punctuation">(</span><span class="token annotation punctuation">@Param</span><span class="token punctuation">(</span><span class="token string">"ew"</span><span class="token punctuation">)</span> <span class="token class-name">Wrapper</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">T</span><span class="token punctuation">></span></span> queryWrapper<span class="token punctuation">)</span><span class="token punctuation">;</span>
    
    <span class="token keyword">int</span> <span class="token function">deleteBatchIds</span><span class="token punctuation">(</span><span class="token annotation punctuation">@Param</span><span class="token punctuation">(</span><span class="token string">"coll"</span><span class="token punctuation">)</span> <span class="token class-name">Collection</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token operator">?</span><span class="token punctuation">></span></span> idList<span class="token punctuation">)</span><span class="token punctuation">;</span>
    
    <span class="token keyword">int</span> <span class="token function">updateById</span><span class="token punctuation">(</span><span class="token annotation punctuation">@Param</span><span class="token punctuation">(</span><span class="token string">"et"</span><span class="token punctuation">)</span> <span class="token class-name">T</span> entity<span class="token punctuation">)</span><span class="token punctuation">;</span>
    
    <span class="token keyword">int</span> <span class="token function">update</span><span class="token punctuation">(</span><span class="token annotation punctuation">@Param</span><span class="token punctuation">(</span><span class="token string">"et"</span><span class="token punctuation">)</span> <span class="token class-name">T</span> entity<span class="token punctuation">,</span> <span class="token annotation punctuation">@Param</span><span class="token punctuation">(</span><span class="token string">"ew"</span><span class="token punctuation">)</span> <span class="token class-name">Wrapper</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">T</span><span class="token punctuation">></span></span> updateWrapper<span class="token punctuation">)</span><span class="token punctuation">;</span>
    
    <span class="token class-name">T</span> <span class="token function">selectById</span><span class="token punctuation">(</span><span class="token class-name">Serializable</span> id<span class="token punctuation">)</span><span class="token punctuation">;</span>
    
    <span class="token class-name">List</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">T</span><span class="token punctuation">></span></span> <span class="token function">selectBatchIds</span><span class="token punctuation">(</span><span class="token annotation punctuation">@Param</span><span class="token punctuation">(</span><span class="token string">"coll"</span><span class="token punctuation">)</span> <span class="token class-name">Collection</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token operator">?</span> <span class="token keyword">extends</span> <span class="token class-name">Serializable</span><span class="token punctuation">></span></span> idList<span class="token punctuation">)</span><span class="token punctuation">;</span>
    
    <span class="token class-name">List</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">T</span><span class="token punctuation">></span></span> <span class="token function">selectByMap</span><span class="token punctuation">(</span><span class="token annotation punctuation">@Param</span><span class="token punctuation">(</span><span class="token string">"cm"</span><span class="token punctuation">)</span> <span class="token class-name">Map</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">String</span><span class="token punctuation">,</span> <span class="token class-name">Object</span><span class="token punctuation">></span></span> columnMap<span class="token punctuation">)</span><span class="token punctuation">;</span>
    
    <span class="token keyword">default</span> <span class="token class-name">T</span> <span class="token function">selectOne</span><span class="token punctuation">(</span><span class="token annotation punctuation">@Param</span><span class="token punctuation">(</span><span class="token string">"ew"</span><span class="token punctuation">)</span> <span class="token class-name">Wrapper</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">T</span><span class="token punctuation">></span></span> queryWrapper<span class="token punctuation">)</span> <span class="token punctuation">{</span>
        <span class="token class-name">List</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">T</span><span class="token punctuation">></span></span> ts <span class="token operator">=</span> <span class="token keyword">this</span><span class="token punctuation">.</span><span class="token function">selectList</span><span class="token punctuation">(</span>queryWrapper<span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token keyword">if</span> <span class="token punctuation">(</span><span class="token class-name">CollectionUtils</span><span class="token punctuation">.</span><span class="token function">isNotEmpty</span><span class="token punctuation">(</span>ts<span class="token punctuation">)</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
            <span class="token keyword">if</span> <span class="token punctuation">(</span>ts<span class="token punctuation">.</span><span class="token function">size</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token operator">!=</span> <span class="token number">1</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
                <span class="token keyword">throw</span> <span class="token class-name">ExceptionUtils</span><span class="token punctuation">.</span><span class="token function">mpe</span><span class="token punctuation">(</span><span class="token string">"One record is expected, but the query result is multiple records"</span><span class="token punctuation">,</span> <span class="token keyword">new</span> <span class="token class-name">Object</span><span class="token punctuation">[</span><span class="token number">0</span><span class="token punctuation">]</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
            <span class="token punctuation">}</span> <span class="token keyword">else</span> <span class="token punctuation">{</span>
                <span class="token keyword">return</span> ts<span class="token punctuation">.</span><span class="token function">get</span><span class="token punctuation">(</span><span class="token number">0</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
            <span class="token punctuation">}</span>
        <span class="token punctuation">}</span> <span class="token keyword">else</span> <span class="token punctuation">{</span>
            <span class="token keyword">return</span> <span class="token keyword">null</span><span class="token punctuation">;</span>
        <span class="token punctuation">}</span>
    <span class="token punctuation">}</span>
    
    <span class="token keyword">default</span> <span class="token keyword">boolean</span> <span class="token function">exists</span><span class="token punctuation">(</span><span class="token class-name">Wrapper</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">T</span><span class="token punctuation">></span></span> queryWrapper<span class="token punctuation">)</span> <span class="token punctuation">{</span>
        <span class="token class-name">Long</span> count <span class="token operator">=</span> <span class="token keyword">this</span><span class="token punctuation">.</span><span class="token function">selectCount</span><span class="token punctuation">(</span>queryWrapper<span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token keyword">return</span> <span class="token keyword">null</span> <span class="token operator">!=</span> count <span class="token operator">&amp;&amp;</span> count <span class="token operator">></span> <span class="token number">0L</span><span class="token punctuation">;</span>
    <span class="token punctuation">}</span>
    
    <span class="token class-name">Long</span> <span class="token function">selectCount</span><span class="token punctuation">(</span><span class="token annotation punctuation">@Param</span><span class="token punctuation">(</span><span class="token string">"ew"</span><span class="token punctuation">)</span> <span class="token class-name">Wrapper</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">T</span><span class="token punctuation">></span></span> queryWrapper<span class="token punctuation">)</span><span class="token punctuation">;</span>
    
    <span class="token class-name">List</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">T</span><span class="token punctuation">></span></span> <span class="token function">selectList</span><span class="token punctuation">(</span><span class="token annotation punctuation">@Param</span><span class="token punctuation">(</span><span class="token string">"ew"</span><span class="token punctuation">)</span> <span class="token class-name">Wrapper</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">T</span><span class="token punctuation">></span></span> queryWrapper<span class="token punctuation">)</span><span class="token punctuation">;</span>
    
    <span class="token class-name">List</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">Map</span><span class="token punctuation">&lt;</span><span class="token class-name">String</span><span class="token punctuation">,</span> <span class="token class-name">Object</span><span class="token punctuation">></span><span class="token punctuation">></span></span> <span class="token function">selectMaps</span><span class="token punctuation">(</span><span class="token annotation punctuation">@Param</span><span class="token punctuation">(</span><span class="token string">"ew"</span><span class="token punctuation">)</span> <span class="token class-name">Wrapper</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">T</span><span class="token punctuation">></span></span> queryWrapper<span class="token punctuation">)</span><span class="token punctuation">;</span>
    
    <span class="token class-name">List</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">Object</span><span class="token punctuation">></span></span> <span class="token function">selectObjs</span><span class="token punctuation">(</span><span class="token annotation punctuation">@Param</span><span class="token punctuation">(</span><span class="token string">"ew"</span><span class="token punctuation">)</span> <span class="token class-name">Wrapper</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">T</span><span class="token punctuation">></span></span> queryWrapper<span class="token punctuation">)</span><span class="token punctuation">;</span>
    
    <span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">P</span> <span class="token keyword">extends</span> <span class="token class-name">IPage</span><span class="token punctuation">&lt;</span><span class="token class-name">T</span><span class="token punctuation">></span><span class="token punctuation">></span></span> <span class="token class-name">P</span> <span class="token function">selectPage</span><span class="token punctuation">(</span><span class="token class-name">P</span> page<span class="token punctuation">,</span> <span class="token annotation punctuation">@Param</span><span class="token punctuation">(</span><span class="token string">"ew"</span><span class="token punctuation">)</span> <span class="token class-name">Wrapper</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">T</span><span class="token punctuation">></span></span> queryWrapper<span class="token punctuation">)</span><span class="token punctuation">;</span>
    
    <span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">P</span> <span class="token keyword">extends</span> <span class="token class-name">IPage</span><span class="token punctuation">&lt;</span><span class="token class-name">Map</span><span class="token punctuation">&lt;</span><span class="token class-name">String</span><span class="token punctuation">,</span> <span class="token class-name">Object</span><span class="token punctuation">></span><span class="token punctuation">></span><span class="token punctuation">></span></span> <span class="token class-name">P</span> <span class="token function">selectMapsPage</span><span class="token punctuation">(</span><span class="token class-name">P</span> page<span class="token punctuation">,</span> <span class="token annotation punctuation">@Param</span><span class="token punctuation">(</span><span class="token string">"ew"</span><span class="token punctuation">)</span> <span class="token class-name">Wrapper</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">T</span><span class="token punctuation">></span></span> queryWrapper<span class="token punctuation">)</span><span class="token punctuation">;</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><h4 id="_2-1-2-自定义增删改查方法" tabindex="-1"><a class="header-anchor" href="#_2-1-2-自定义增删改查方法" aria-hidden="true">#</a> 2.1.2 自定义增删改查方法</h4>
<ol>
<li>使用自定义增删改查方法的流程与mybatis中操作一致
<ul>
<li>在mapper接口中定义crud方法</li>
<li>在reosources目录下创建mapper目录，创建对应的mapper.xml映射文件（是不是反过来了，默认不需要创建对应包名的mapper路径，如果是纯mapper路径需要指定？？需要测试下）
<ul>
<li>如果映射文件不在mapper目录下，则需要在application.yml文件中进行配置，指定位置。</li>
<li>mybatis中正好相反，需要在resources文件目录下创建mapper.java对应报名的mapper路径</li>
</ul>
</li>
<li>在mapper.xml文件中编写sql语句</li>
<li>调用mapper接口中的方法进行使用</li>
</ul>
</li>
<li>编写crud方法</li>
</ol>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token keyword">package</span> <span class="token namespace">iceriver<span class="token punctuation">.</span>mybatisplus<span class="token punctuation">.</span>mapper</span><span class="token punctuation">;</span>

<span class="token keyword">import</span> <span class="token import"><span class="token namespace">com<span class="token punctuation">.</span>baomidou<span class="token punctuation">.</span>mybatisplus<span class="token punctuation">.</span>core<span class="token punctuation">.</span>mapper<span class="token punctuation">.</span></span><span class="token class-name">BaseMapper</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">iceriver<span class="token punctuation">.</span>mybatisplus<span class="token punctuation">.</span>bean<span class="token punctuation">.</span></span><span class="token class-name">User</span></span><span class="token punctuation">;</span>

<span class="token keyword">import</span> <span class="token import"><span class="token namespace">java<span class="token punctuation">.</span>util<span class="token punctuation">.</span></span><span class="token class-name">Map</span></span><span class="token punctuation">;</span>

<span class="token doc-comment comment">/**
 * <span class="token keyword">@author</span>: INFINITY https://developer.aliyun.com/profile/sagwrxp2ua66w
 * <span class="token keyword">@date</span>: 2022/8/4 21:01
 */</span>
<span class="token keyword">public</span> <span class="token keyword">interface</span> <span class="token class-name">UserMapper</span> <span class="token keyword">extends</span> <span class="token class-name">BaseMapper</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">User</span><span class="token punctuation">></span></span> <span class="token punctuation">{</span>
    <span class="token doc-comment comment">/**
     * 自定义crud方法：根据id查询用户信息为map集合
     * <span class="token keyword">@param</span> <span class="token parameter">id</span>
     * <span class="token keyword">@return</span>
     */</span>
    <span class="token class-name">Map</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">String</span><span class="token punctuation">,</span> <span class="token class-name">Object</span><span class="token punctuation">></span></span> <span class="token function">selectMapById</span><span class="token punctuation">(</span><span class="token class-name">Long</span> id<span class="token punctuation">)</span><span class="token punctuation">;</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ol start="3">
<li>编写映射文件</li>
</ol>
<div class="language-xml ext-xml line-numbers-mode"><pre v-pre class="language-xml"><code><span class="token prolog">&lt;?xml version="1.0" encoding="UTF-8" ?></span>
<span class="token doctype"><span class="token punctuation">&lt;!</span><span class="token doctype-tag">DOCTYPE</span> <span class="token name">mapper</span>
        <span class="token name">PUBLIC</span> <span class="token string">"-//mybatis.org//DTD Mapper 3.0//EN"</span>
        <span class="token string">"http://mybatis.org/dtd/mybatis-3-mapper.dtd"</span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>mapper</span> <span class="token attr-name">namespace</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>iceriver.mybatisplus.mapper.UserMapper<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
  
  <span class="token comment">&lt;!--Map&lt;String, Object> selectMapById(Long id);--></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>select</span> <span class="token attr-name">id</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>selectMapById<span class="token punctuation">"</span></span> <span class="token attr-name">resultType</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>map<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
    select id,name,age,email from user where id = #{id}
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>select</span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>mapper</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ul>
<li>这里resultType之所以可以直接写map，是因为mybatisplus定义的默认的类型别名。</li>
</ul>
<ol start="4">
<li>执行测试</li>
</ol>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token keyword">package</span> <span class="token namespace">iceriver<span class="token punctuation">.</span>mybatisplus</span><span class="token punctuation">;</span>

<span class="token keyword">import</span> <span class="token import"><span class="token namespace">iceriver<span class="token punctuation">.</span>mybatisplus<span class="token punctuation">.</span>bean<span class="token punctuation">.</span></span><span class="token class-name">User</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">iceriver<span class="token punctuation">.</span>mybatisplus<span class="token punctuation">.</span>mapper<span class="token punctuation">.</span></span><span class="token class-name">UserMapper</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">org<span class="token punctuation">.</span>junit<span class="token punctuation">.</span>jupiter<span class="token punctuation">.</span>api<span class="token punctuation">.</span></span><span class="token class-name">Test</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">org<span class="token punctuation">.</span>springframework<span class="token punctuation">.</span>beans<span class="token punctuation">.</span>factory<span class="token punctuation">.</span>annotation<span class="token punctuation">.</span></span><span class="token class-name">Autowired</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">org<span class="token punctuation">.</span>springframework<span class="token punctuation">.</span>boot<span class="token punctuation">.</span>test<span class="token punctuation">.</span>context<span class="token punctuation">.</span></span><span class="token class-name">SpringBootTest</span></span><span class="token punctuation">;</span>

<span class="token keyword">import</span> <span class="token import"><span class="token namespace">java<span class="token punctuation">.</span>util<span class="token punctuation">.</span></span><span class="token class-name">List</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">java<span class="token punctuation">.</span>util<span class="token punctuation">.</span></span><span class="token class-name">Map</span></span><span class="token punctuation">;</span>

<span class="token doc-comment comment">/**
* <span class="token keyword">@author</span>: INFINITY https://developer.aliyun.com/profile/sagwrxp2ua66w
* <span class="token keyword">@date</span>: 2022/8/4 21:09
*/</span>
<span class="token annotation punctuation">@SpringBootTest</span>
<span class="token keyword">public</span> <span class="token keyword">class</span> <span class="token class-name">UserTests</span> <span class="token punctuation">{</span>
    <span class="token annotation punctuation">@Autowired</span>
    <span class="token keyword">private</span> <span class="token class-name">UserMapper</span> userMapper<span class="token punctuation">;</span>
    <span class="token annotation punctuation">@Test</span>
    <span class="token keyword">public</span> <span class="token keyword">void</span> <span class="token function">testSelectMapById</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">{</span>
        <span class="token class-name">Map</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">String</span><span class="token punctuation">,</span> <span class="token class-name">Object</span><span class="token punctuation">></span></span> map <span class="token operator">=</span> userMapper<span class="token punctuation">.</span><span class="token function">selectMapById</span><span class="token punctuation">(</span><span class="token number">1L</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span>map<span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token punctuation">}</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><h3 id="_2-2-service接口" tabindex="-1"><a class="header-anchor" href="#_2-2-service接口" aria-hidden="true">#</a> 2.2 Service接口</h3>
<ol>
<li>MyBatis-Plus中有一个接口 IService和其实现类 ServiceImpl，封装了常见的业务层逻辑。</li>
<li>由于实际开发中，service层的方法非常复杂，mybatis提供的通用service方法不能满足需求，为了既使用mybatis提供的sevice方法，又能满足实际开发的需要，可参照创建usermapper的方式，让自定义service继承自ISservice，自定义ServiceImpl既实现自定义service，又继承mybatisplus提供的ServiceImpl
<ul>
<li><code v-pre>public interface UserService extends IService&lt;User&gt;</code></li>
<li><code v-pre>public class UserServiceImpl extends ServiceImpl&lt;UserMapper,User&gt; implements UserService</code>
<ul>
<li>需要使用@Service注解创建bean，交给ioc容器管理
<ul>
<li>或者使用配置类，使用@ConponentScan进行扫描</li>
<li>或者在springboot 启动程序，使用@ConponentScan进行扫描</li>
</ul>
</li>
</ul>
</li>
</ul>
</li>
<li>mybatis-plus中批量添加在service接口的方法中，底层实现批量添加的原理是循环。</li>
</ol>
<h3 id="_2-3-雪花算法" tabindex="-1"><a class="header-anchor" href="#_2-3-雪花算法" aria-hidden="true">#</a> 2.3 雪花算法</h3>
<h4 id="_2-3-1-出现背景" tabindex="-1"><a class="header-anchor" href="#_2-3-1-出现背景" aria-hidden="true">#</a> 2.3.1 出现背景</h4>
<ul>
<li>需要选择合适的方案去应对数据规模的增长，以应对逐渐增长的访问压力和数据量。数据库的扩展方式主要包括：业务分库、主从复制，数据库分表。</li>
<li>实现主从表分离.</li>
</ul>
<h4 id="_2-3-2-数据库分表" tabindex="-1"><a class="header-anchor" href="#_2-3-2-数据库分表" aria-hidden="true">#</a> 2.3.2 数据库分表</h4>
<ol>
<li>将不同业务数据分散存储到不同的数据库服务器，能够支撑百万甚至千万用户规模的业务，但如果业务继续发展，同一业务的单表数据也会达到单台数据库服务器的处理瓶颈。例如，淘宝的几亿用户数据，如果全部存放在一台数据库服务器的一张表中，肯定是无法满足性能要求的，此时就需要对单表数据进行拆分 。</li>
<li>单表数据拆分有两种方式：垂直分表和水平分表。</li>
</ol>
<ul>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1659659388736-74b72435-ba59-45d4-95e8-19fb07864616.png#clientId=uaf8d940b-efc7-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=345&amp;id=u5021e883&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=345&amp;originWidth=649&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=38418&amp;status=done&amp;style=none&amp;taskId=u8548c7d7-939b-4462-85b1-d6aa546e874&amp;title=&amp;width=649" alt="image.png" loading="lazy"></li>
<li>垂直分表适合将表中某些不常用且占了大量空间的列拆分出去。</li>
<li>水平分表根据表中数据的行数和实际的业务情况，对标进行拆分。</li>
</ul>
<ol start="3">
<li>水平分表的处置方式：
<ul>
<li>主键自增：以最常见的用户ID为例，可以按照1000000的范围大小进行分段，1<sub>999999放到表1中，1000000</sub>1999999放到表2中，以此类推。
<ul>
<li>复杂点：分段大小的选取。分段太小会导致切分后子表数量过多，增加维护复杂度；分段太大可能会导致单表依然存在性能问题，一般建议分段大小在100万至2000万之间。</li>
<li>优点：可以随着数据的增加平滑地扩充新的表。例如，现在的用户是100万，如果增加到1000万，只需要增加新的表就可以了，原有的数据不需要动。</li>
<li>缺点：分布不均匀。假如按照1000万来进行分表，有可能某个分段实际存储的数据量只有1条，而另外一个分段实际存储的数据量有1000万条。</li>
</ul>
</li>
<li>取模：同样以用户ID为例，假如我们一开始就规划了10个数据库表，可以简单地用user_id%10的值来表示数据所属的数据库表编号，ID为985的用户放到编号为5的子表中，ID为10086的用户放到编号为6的子表中。
<ul>
<li>复杂点：初始表数量的确定。表数量太多维护比较麻烦，表数量太少又可能导致单表性能存在问题。</li>
<li>优点：表分布比较均匀。</li>
<li>缺点：扩充新的表很麻烦，所有数据都要重分布。</li>
</ul>
</li>
</ul>
</li>
<li>雪花算法：水平分表的处置方式。Twitter公布的分布式主键生成算法，它能够保证不同表的主键的不重复性，以及相同表的主键的有序性。
<ul>
<li>核心思想：长度共64bit（一个long型）。首先是一个符号位，1bit标识，由于long基本类型在Java中是带符号的，最高位是符号位，正数是0，负数是1，所以id一般是正数，最高位是0。41bit时间截(毫秒级)，存储的是时间截的差值（当前时间截 - 开始时间截)，结果约等于69.73年。10bit作为机器的ID（5个bit是数据中心，5个bit的机器ID，可以部署在1024个节点）。12bit作为毫秒内的流水号（意味着每个节点在每毫秒可以产生 4096 个 ID）。
<ul>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1659659948338-c45a9c48-746e-4c52-b7fc-7c7e7a431dc4.png#clientId=uaf8d940b-efc7-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=178&amp;id=u1c7e9d59&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=178&amp;originWidth=597&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=47115&amp;status=done&amp;style=none&amp;taskId=ucead0634-41ff-42e0-bc3c-3f5918bf05f&amp;title=&amp;width=597" alt="image.png" loading="lazy"></li>
</ul>
</li>
<li>优点：整体上按照时间自增排序，并且整个分布式系统内不会产生ID碰撞，并且效率较高。</li>
</ul>
</li>
</ol>
<h2 id="第3章-注解" tabindex="-1"><a class="header-anchor" href="#第3章-注解" aria-hidden="true">#</a> 第3章 注解</h2>
<h3 id="_3-1-mapperscan" tabindex="-1"><a class="header-anchor" href="#_3-1-mapperscan" aria-hidden="true">#</a> 3.1 @MapperScan</h3>
<ol>
<li>配置在spring boot启动程序类上，指定扫描的mapper包</li>
</ol>
<h3 id="_3-2-tablename" tabindex="-1"><a class="header-anchor" href="#_3-2-tablename" aria-hidden="true">#</a> 3.2 @TableName</h3>
<ol>
<li>用于实体类pojo前，指定数据库中表名与实体类的对应关系。</li>
<li>未指定改属性时，由basemapper的范型决定表名与实体类的对应关系，对应不上就会报错。</li>
<li>也可以在application.yml核心配置文件中使用<code v-pre>mybatis-plus.global-config.db-config.table-prefix: t_</code>进行全局设置</li>
</ol>
<h3 id="_3-3-tableid" tabindex="-1"><a class="header-anchor" href="#_3-3-tableid" aria-hidden="true">#</a> 3.3 @TableId</h3>
<ol>
<li>mybatis-plus在crud时，默认将字段名为id的列作为主键。</li>
<li>如果表中主键的列名不是id，则会把主键列识别为普通列。</li>
<li>此时可以在实体类pojo的主键列属性前使用改注解，将该属性标记为主键。</li>
<li>value属性：解决实体类pojo中的主键名与表中主键名不一致问题。可以使用value属性设置实体类pojo属性与表中主键名的对应关系。当只设置value时，value可以省略，直接写值。</li>
<li>type属性：设置主键生成策略。默认为IdType.ASSIGN_ID，为雪花算法，IdType.AUTO表示使用数据库设置的自增策略，但必须保证数据库进行了设置，否则报错。</li>
<li>全局配置主键生成策略：在application.yml核心配置文件中使用<code v-pre>mybatis-plus.global.db-config.id-type: auto</code></li>
</ol>
<h3 id="_3-4-tablefield" tabindex="-1"><a class="header-anchor" href="#_3-4-tablefield" aria-hidden="true">#</a> 3.4 @TableField</h3>
<ol>
<li>设置非主键字段实体类pojo中的属性名与数据库表中字段名的对应关系。</li>
<li>指定表中非主键的字段名（属性可以在表中有，也可以没有，没有时使用exist=false）。</li>
</ol>
<h3 id="_3-5-tablelogic" tabindex="-1"><a class="header-anchor" href="#_3-5-tablelogic" aria-hidden="true">#</a> 3.5 @TableLogic</h3>
<ol>
<li>逻辑删除：在表中设置一个字段，标记字段的状态。
<ul>
<li>逻辑删除会将删除功能变为修改功能，修改了标记为逻辑删除字段的值。</li>
<li>逻辑删除后，查询不会显示。</li>
<li>方式一：在数据库表中，给字段设置默认值，根据表中设置的默认值判断，如果默认值为0，则表示处于未删除状态，为其他值，表示删除状态。（好像也不用）</li>
<li>方式二：在核心配置文件中使用mybatis-plus.global-config.db-config.logic-delete-value设置逻辑已删除值和mybatis-plus.global-config.db-config.logic-not-delete-value设置逻辑未删除值（可以不配置）</li>
</ul>
</li>
<li>使用场景：数据恢复。</li>
<li>@TableLogic标记逻辑删除的字段。</li>
</ol>
<h3 id="_3-6-version" tabindex="-1"><a class="header-anchor" href="#_3-6-version" aria-hidden="true">#</a> 3.6 @Version</h3>
<ul>
<li>标识乐观锁本版好号字段</li>
<li>需要在配置类中开启乐观锁插件</li>
</ul>
<h3 id="_3-7-enumvalue" tabindex="-1"><a class="header-anchor" href="#_3-7-enumvalue" aria-hidden="true">#</a> 3.7@EnumValue</h3>
<ul>
<li>根据实体类中取值为枚举类型的属性，创建枚举类</li>
<li>在枚举类中，将对应在实体类中的属性指定为枚举
<ul>
<li>解释：如User实体类的属性sex，创建SexEunm的枚举类，在SexEnum中设定属性sex，给SexEnum中sex指定注解@EunmValue</li>
</ul>
</li>
<li>需要在核心配置文件中开启通用枚举扫描：<code v-pre>mybatis-plus:.typeEnumsPackage: iceriver.mybatisplus.enums</code></li>
</ul>
<h3 id="_3-8-ds" tabindex="-1"><a class="header-anchor" href="#_3-8-ds" aria-hidden="true">#</a> 3.8 @DS</h3>
<ul>
<li>指定数据源，参数名称在核心配置文件中设定</li>
<li>可以用在类上，也可以用有在方法上，同时遵循就近原则</li>
</ul>
<h2 id="第4章-条件构造器" tabindex="-1"><a class="header-anchor" href="#第4章-条件构造器" aria-hidden="true">#</a> 第4章 条件构造器</h2>
<h3 id="_4-1-wapper介绍" tabindex="-1"><a class="header-anchor" href="#_4-1-wapper介绍" aria-hidden="true">#</a> 4.1 wapper介绍</h3>
<ol>
<li>BaseMapper中crud等方法传入的条件。</li>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1659660893144-fe071a70-8296-4b82-b16a-b9e7c3d488e9.png#clientId=uaf8d940b-efc7-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=341&amp;id=ud31d0cf1&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=341&amp;originWidth=658&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=83429&amp;status=done&amp;style=none&amp;taskId=u57eb0ad0-2d33-4efd-9f46-4281014d7ff&amp;title=&amp;width=658" alt="image.png" loading="lazy"></li>
<li>Wrapper ： 条件构造抽象类，最顶端父类
<ul>
<li>AbstractWrapper ： 用于查询条件封装，生成 sql 的 where 条件
<ul>
<li>QueryWrapper ： 查询条件封装</li>
<li>UpdateWrapper ： Update 条件封装</li>
<li>AbstractLambdaWrapper ： 使用Lambda 语法
<ul>
<li>LambdaQueryWrapper ：用于Lambda语法使用的查询Wrapper</li>
<li>LambdaUpdateWrapper ： Lambda 更新封装Wrapper</li>
</ul>
</li>
</ul>
</li>
</ul>
</li>
</ol>
<h3 id="_4-2-querywapper" tabindex="-1"><a class="header-anchor" href="#_4-2-querywapper" aria-hidden="true">#</a> 4.2 QueryWapper</h3>
<ol>
<li>组装查询条件</li>
</ol>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token annotation punctuation">@SpringBootTest</span>
<span class="token keyword">public</span> <span class="token keyword">class</span> <span class="token class-name">QueryWapperTests</span> <span class="token punctuation">{</span>
    <span class="token annotation punctuation">@Autowired</span>
    <span class="token keyword">private</span> <span class="token class-name">UserMapper</span> userMapper<span class="token punctuation">;</span>
    <span class="token annotation punctuation">@Test</span>
    <span class="token keyword">public</span> <span class="token keyword">void</span> <span class="token function">test01</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">{</span>
<span class="token comment">//        查询用户名包含a，年龄在20到30之间的所有用户信息</span>
<span class="token comment">//        SELECT id,name,age,email FROM user WHERE (name LIKE ? AND age BETWEEN ? AND ? AND email IS NOT NULL)</span>
        <span class="token class-name">QueryWrapper</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">User</span><span class="token punctuation">></span></span> queryWrapper <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">QueryWrapper</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token punctuation">></span></span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        queryWrapper<span class="token punctuation">.</span><span class="token function">like</span><span class="token punctuation">(</span><span class="token string">"name"</span><span class="token punctuation">,</span> <span class="token string">"a"</span><span class="token punctuation">)</span>
                    <span class="token punctuation">.</span><span class="token function">between</span><span class="token punctuation">(</span><span class="token string">"age"</span><span class="token punctuation">,</span><span class="token number">20</span><span class="token punctuation">,</span><span class="token number">30</span><span class="token punctuation">)</span>
                    <span class="token punctuation">.</span><span class="token function">isNotNull</span><span class="token punctuation">(</span><span class="token string">"email"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token class-name">List</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">User</span><span class="token punctuation">></span></span> users <span class="token operator">=</span> userMapper<span class="token punctuation">.</span><span class="token function">selectList</span><span class="token punctuation">(</span>queryWrapper<span class="token punctuation">)</span><span class="token punctuation">;</span>
        users<span class="token punctuation">.</span><span class="token function">forEach</span><span class="token punctuation">(</span>user <span class="token operator">-></span> <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">print</span><span class="token punctuation">(</span>user<span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token punctuation">}</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ul>
<li>like()、between()等这些方法中传入的是表中的列名，不是pojo中的属性名。</li>
<li>between()可以使用gt()、lt()代替</li>
</ul>
<ol start="2">
<li>组装排序条件</li>
</ol>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token annotation punctuation">@SpringBootTest</span>
<span class="token keyword">public</span> <span class="token keyword">class</span> <span class="token class-name">QueryWapperTests</span> <span class="token punctuation">{</span>
    <span class="token annotation punctuation">@Autowired</span>
    <span class="token keyword">private</span> <span class="token class-name">UserMapper</span> userMapper<span class="token punctuation">;</span>
    <span class="token annotation punctuation">@Test</span>
    <span class="token keyword">public</span> <span class="token keyword">void</span> <span class="token function">test02</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">{</span>
<span class="token comment">//        按年龄降序查询用户，如果年龄相同则按id升序排列</span>
<span class="token comment">//        SELECT id,name,age,email FROM user ORDER BY age DESC,id ASC</span>
        <span class="token class-name">QueryWrapper</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">User</span><span class="token punctuation">></span></span> queryWrapper <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">QueryWrapper</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token punctuation">></span></span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        queryWrapper<span class="token punctuation">.</span><span class="token function">orderByDesc</span><span class="token punctuation">(</span><span class="token string">"age"</span><span class="token punctuation">)</span>
                    <span class="token punctuation">.</span><span class="token function">orderByAsc</span><span class="token punctuation">(</span><span class="token string">"id"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token class-name">List</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">User</span><span class="token punctuation">></span></span> users <span class="token operator">=</span> userMapper<span class="token punctuation">.</span><span class="token function">selectList</span><span class="token punctuation">(</span>queryWrapper<span class="token punctuation">)</span><span class="token punctuation">;</span>
        users<span class="token punctuation">.</span><span class="token function">forEach</span><span class="token punctuation">(</span>user <span class="token operator">-></span> <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">print</span><span class="token punctuation">(</span>user<span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token punctuation">}</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ol start="3">
<li>组装删除功能</li>
</ol>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token annotation punctuation">@SpringBootTest</span>
<span class="token keyword">public</span> <span class="token keyword">class</span> <span class="token class-name">QueryWapperTests</span> <span class="token punctuation">{</span>
    <span class="token annotation punctuation">@Autowired</span>
    <span class="token keyword">private</span> <span class="token class-name">UserMapper</span> userMapper<span class="token punctuation">;</span>
    <span class="token annotation punctuation">@Test</span>
    <span class="token keyword">public</span> <span class="token keyword">void</span> <span class="token function">test03</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">{</span>
<span class="token comment">//        删除邮箱地址为null的用户</span>
<span class="token comment">//        DELETE FROM user WHERE (email IS NULL)</span>
        <span class="token class-name">QueryWrapper</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">User</span><span class="token punctuation">></span></span> queryWrapper <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">QueryWrapper</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token punctuation">></span></span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        queryWrapper<span class="token punctuation">.</span><span class="token function">isNull</span><span class="token punctuation">(</span><span class="token string">"email"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token keyword">int</span> result <span class="token operator">=</span> userMapper<span class="token punctuation">.</span><span class="token function">delete</span><span class="token punctuation">(</span>queryWrapper<span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span><span class="token string">"result"</span> <span class="token operator">+</span> result<span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token punctuation">}</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ul>
<li>如果启用了逻辑删除功能，对应的删除sql语句会变为修改语句。</li>
</ul>
<ol start="4">
<li>组装修改功能</li>
</ol>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token annotation punctuation">@SpringBootTest</span>
<span class="token keyword">public</span> <span class="token keyword">class</span> <span class="token class-name">QueryWapperTests</span> <span class="token punctuation">{</span>
    <span class="token annotation punctuation">@Autowired</span>
    <span class="token keyword">private</span> <span class="token class-name">UserMapper</span> userMapper<span class="token punctuation">;</span>
    <span class="token annotation punctuation">@Test</span>
    <span class="token keyword">public</span> <span class="token keyword">void</span> <span class="token function">test04</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">{</span>
<span class="token comment">//        将（年龄大于20并且用户名包含a）或者邮箱为null的用户信息修改</span>
<span class="token comment">//        UPDATE user SET name=?, email=? WHERE (age > ? AND name LIKE ? OR email IS NULL)</span>
        <span class="token class-name">QueryWrapper</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">User</span><span class="token punctuation">></span></span> queryWrapper <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">QueryWrapper</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token punctuation">></span></span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        queryWrapper<span class="token punctuation">.</span><span class="token function">gt</span><span class="token punctuation">(</span><span class="token string">"age"</span><span class="token punctuation">,</span> <span class="token number">20</span><span class="token punctuation">)</span>
                    <span class="token punctuation">.</span><span class="token function">like</span><span class="token punctuation">(</span><span class="token string">"name"</span><span class="token punctuation">,</span> <span class="token string">"a"</span><span class="token punctuation">)</span>
                    <span class="token punctuation">.</span><span class="token function">or</span><span class="token punctuation">(</span><span class="token punctuation">)</span>
                    <span class="token punctuation">.</span><span class="token function">isNull</span><span class="token punctuation">(</span><span class="token string">"email"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token class-name">User</span> user1 <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">User</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        user1<span class="token punctuation">.</span><span class="token function">setName</span><span class="token punctuation">(</span><span class="token string">"xiaoming"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        user1<span class="token punctuation">.</span><span class="token function">setEmail</span><span class="token punctuation">(</span><span class="token string">"123@qq.com"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token keyword">int</span> result <span class="token operator">=</span> userMapper<span class="token punctuation">.</span><span class="token function">update</span><span class="token punctuation">(</span>user1<span class="token punctuation">,</span> queryWrapper<span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span><span class="token string">"result"</span> <span class="token operator">+</span> result<span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token punctuation">}</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ul>
<li>如果开启了逻辑删除，则逻辑删除后的不会被修改</li>
<li>注意OR查询条件在mybatis-plus中的用法（不传参，起拼接作用）</li>
</ul>
<ol start="5">
<li>组装查询优先级
<ul>
<li>主要是mybatis-plus的条件构造器中lambda中的条件优先执行</li>
<li>为了能够写lambda，<code v-pre>并且</code>这个查询条件不再用<code v-pre>.</code>代替，而是用<code v-pre>and()</code></li>
</ul>
</li>
</ol>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token annotation punctuation">@SpringBootTest</span>
<span class="token keyword">public</span> <span class="token keyword">class</span> <span class="token class-name">QueryWapperTests</span> <span class="token punctuation">{</span>
    <span class="token annotation punctuation">@Autowired</span>
    <span class="token keyword">private</span> <span class="token class-name">UserMapper</span> userMapper<span class="token punctuation">;</span>
    <span class="token annotation punctuation">@Test</span>
    <span class="token keyword">public</span> <span class="token keyword">void</span> <span class="token function">test05</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">{</span>
<span class="token comment">//        将用户名包含a并且（年龄大于20或者邮箱为null）的用户信息修改</span>
<span class="token comment">//        mybatis-plus的条件构造器中lambda中的条件优先执行</span>
<span class="token comment">//        UPDATE user SET name=?, email=? WHERE (name LIKE ? AND (age > ? AND email IS NULL))</span>
        <span class="token class-name">QueryWrapper</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">User</span><span class="token punctuation">></span></span> queryWrapper <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">QueryWrapper</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token punctuation">></span></span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        queryWrapper<span class="token punctuation">.</span><span class="token function">like</span><span class="token punctuation">(</span><span class="token string">"name"</span><span class="token punctuation">,</span> <span class="token string">"a"</span><span class="token punctuation">)</span>
                    <span class="token punctuation">.</span><span class="token function">and</span><span class="token punctuation">(</span>i <span class="token operator">-></span> i<span class="token punctuation">.</span><span class="token function">gt</span><span class="token punctuation">(</span><span class="token string">"age"</span><span class="token punctuation">,</span> <span class="token number">20</span><span class="token punctuation">)</span><span class="token punctuation">.</span><span class="token function">isNull</span><span class="token punctuation">(</span><span class="token string">"email"</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token class-name">User</span> user1 <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">User</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        user1<span class="token punctuation">.</span><span class="token function">setName</span><span class="token punctuation">(</span><span class="token string">"dazhuang"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        user1<span class="token punctuation">.</span><span class="token function">setEmail</span><span class="token punctuation">(</span><span class="token string">"312@qq.com"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token keyword">int</span> result <span class="token operator">=</span> userMapper<span class="token punctuation">.</span><span class="token function">update</span><span class="token punctuation">(</span>user1<span class="token punctuation">,</span> queryWrapper<span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span><span class="token string">"result"</span> <span class="token operator">+</span> result<span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token punctuation">}</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ul>
<li>如果开启了逻辑删除，则逻辑删除后的不会被修改</li>
</ul>
<ol start="6">
<li>组装查询指定列</li>
</ol>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token annotation punctuation">@SpringBootTest</span>
<span class="token keyword">public</span> <span class="token keyword">class</span> <span class="token class-name">QueryWapperTests</span> <span class="token punctuation">{</span>
    <span class="token annotation punctuation">@Autowired</span>
    <span class="token keyword">private</span> <span class="token class-name">UserMapper</span> userMapper<span class="token punctuation">;</span>
    <span class="token annotation punctuation">@Test</span>
    <span class="token keyword">public</span> <span class="token keyword">void</span> <span class="token function">test06</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">{</span>
<span class="token comment">//        查询用户名、年龄、邮箱</span>
<span class="token comment">//        SELECT name,age,email FROM user</span>
        <span class="token class-name">QueryWrapper</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">User</span><span class="token punctuation">></span></span> queryWrapper <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">QueryWrapper</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token punctuation">></span></span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        queryWrapper<span class="token punctuation">.</span><span class="token function">select</span><span class="token punctuation">(</span><span class="token string">"name"</span><span class="token punctuation">,</span> <span class="token string">"age"</span><span class="token punctuation">,</span> <span class="token string">"email"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token class-name">List</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">Map</span><span class="token punctuation">&lt;</span><span class="token class-name">String</span><span class="token punctuation">,</span> <span class="token class-name">Object</span><span class="token punctuation">></span><span class="token punctuation">></span></span> users <span class="token operator">=</span> userMapper<span class="token punctuation">.</span><span class="token function">selectMaps</span><span class="token punctuation">(</span>queryWrapper<span class="token punctuation">)</span><span class="token punctuation">;</span>
        users<span class="token punctuation">.</span><span class="token function">forEach</span><span class="token punctuation">(</span>user <span class="token operator">-></span> <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span>user<span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token punctuation">}</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ol start="7">
<li>组装子查询</li>
</ol>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token annotation punctuation">@SpringBootTest</span>
<span class="token keyword">public</span> <span class="token keyword">class</span> <span class="token class-name">QueryWapperTests</span> <span class="token punctuation">{</span>
    <span class="token annotation punctuation">@Autowired</span>
    <span class="token keyword">private</span> <span class="token class-name">UserMapper</span> userMapper<span class="token punctuation">;</span>
    <span class="token annotation punctuation">@Test</span>
    <span class="token keyword">public</span> <span class="token keyword">void</span> <span class="token function">test07</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">{</span>
<span class="token comment">//        查询id小于等于100的用户</span>
<span class="token comment">//        SELECT id,name,age,email FROM user WHERE (id IN (select id from user where id&lt;=100))</span>
        <span class="token class-name">QueryWrapper</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">User</span><span class="token punctuation">></span></span> queryWrapper <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">QueryWrapper</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token punctuation">></span></span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        queryWrapper<span class="token punctuation">.</span><span class="token function">inSql</span><span class="token punctuation">(</span><span class="token string">"id"</span><span class="token punctuation">,</span> <span class="token string">"select id from user where id&lt;=100"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token class-name">List</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">User</span><span class="token punctuation">></span></span> users <span class="token operator">=</span> userMapper<span class="token punctuation">.</span><span class="token function">selectList</span><span class="token punctuation">(</span>queryWrapper<span class="token punctuation">)</span><span class="token punctuation">;</span>
        users<span class="token punctuation">.</span><span class="token function">forEach</span><span class="token punctuation">(</span>user <span class="token operator">-></span> <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span>user<span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token punctuation">}</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><h3 id="_4-3-updatewapper" tabindex="-1"><a class="header-anchor" href="#_4-3-updatewapper" aria-hidden="true">#</a> 4.3 UpdateWapper</h3>
<ol>
<li>组装修改条件（按照上文第5项修改）</li>
</ol>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token annotation punctuation">@SpringBootTest</span>
<span class="token keyword">public</span> <span class="token keyword">class</span> <span class="token class-name">UpdateWrapperTests</span> <span class="token punctuation">{</span>
    <span class="token annotation punctuation">@Autowired</span>
    <span class="token keyword">private</span> <span class="token class-name">UserMapper</span> userMapper<span class="token punctuation">;</span>
    <span class="token annotation punctuation">@Test</span>
    <span class="token keyword">public</span> <span class="token keyword">void</span> <span class="token function">test01</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">{</span>
<span class="token comment">//        将用户名包含a并且（年龄大于20或者邮箱为null）的用户信息修改</span>
<span class="token comment">//        UPDATE user SET name=?,email=? WHERE (name LIKE ? AND (age > ? AND email IS NULL))</span>
        <span class="token class-name">UpdateWrapper</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">User</span><span class="token punctuation">></span></span> updateWrapper <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">UpdateWrapper</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token punctuation">></span></span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        updateWrapper<span class="token punctuation">.</span><span class="token function">like</span><span class="token punctuation">(</span><span class="token string">"name"</span><span class="token punctuation">,</span> <span class="token string">"i"</span><span class="token punctuation">)</span>
                     <span class="token punctuation">.</span><span class="token function">and</span><span class="token punctuation">(</span>i <span class="token operator">-></span> i<span class="token punctuation">.</span><span class="token function">gt</span><span class="token punctuation">(</span><span class="token string">"age"</span><span class="token punctuation">,</span> <span class="token number">20</span><span class="token punctuation">)</span><span class="token punctuation">.</span><span class="token function">isNull</span><span class="token punctuation">(</span><span class="token string">"email"</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        updateWrapper<span class="token punctuation">.</span><span class="token function">set</span><span class="token punctuation">(</span><span class="token string">"name"</span><span class="token punctuation">,</span><span class="token string">"大王"</span><span class="token punctuation">)</span><span class="token punctuation">.</span><span class="token function">set</span><span class="token punctuation">(</span><span class="token string">"email"</span><span class="token punctuation">,</span> <span class="token string">"newd@sina.com"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token keyword">int</span> result <span class="token operator">=</span> userMapper<span class="token punctuation">.</span><span class="token function">update</span><span class="token punctuation">(</span><span class="token keyword">null</span><span class="token punctuation">,</span> updateWrapper<span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span><span class="token string">"result"</span> <span class="token operator">+</span> result<span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token punctuation">}</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><h3 id="_4-4-模拟开发中根据提交数据组装条件" tabindex="-1"><a class="header-anchor" href="#_4-4-模拟开发中根据提交数据组装条件" aria-hidden="true">#</a> 4.4 模拟开发中根据提交数据组装条件</h3>
<ol>
<li>手动判断组装——利用mybatis-plus提供的工具类</li>
</ol>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token annotation punctuation">@SpringBootTest</span>
<span class="token keyword">public</span> <span class="token keyword">class</span> <span class="token class-name">ConditionTests</span> <span class="token punctuation">{</span>
    <span class="token annotation punctuation">@Autowired</span>
    <span class="token keyword">private</span> <span class="token class-name">UserMapper</span> userMapper<span class="token punctuation">;</span>
    <span class="token annotation punctuation">@Test</span>
    <span class="token keyword">public</span> <span class="token keyword">void</span> <span class="token function">test01</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
<span class="token comment">//        SELECT id,name,age,email FROM user WHERE (age >= ? AND age &lt;= ?)</span>
        <span class="token class-name">String</span> name <span class="token operator">=</span> <span class="token string">""</span><span class="token punctuation">;</span>
        <span class="token class-name">Integer</span> ageBegin <span class="token operator">=</span> <span class="token number">20</span><span class="token punctuation">;</span>
        <span class="token class-name">Integer</span> ageEnd <span class="token operator">=</span> <span class="token number">30</span><span class="token punctuation">;</span>

        <span class="token class-name">QueryWrapper</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">User</span><span class="token punctuation">></span></span> queryWrapper <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">QueryWrapper</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token punctuation">></span></span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token keyword">if</span> <span class="token punctuation">(</span><span class="token class-name">StringUtils</span><span class="token punctuation">.</span><span class="token function">isNotBlank</span><span class="token punctuation">(</span>name<span class="token punctuation">)</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
            <span class="token comment">//isNotBlank判断某个字符创是否不为空字符串、不为null、不为空白符</span>
            queryWrapper<span class="token punctuation">.</span><span class="token function">like</span><span class="token punctuation">(</span><span class="token string">"user_name"</span><span class="token punctuation">,</span> name<span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token punctuation">}</span>
        <span class="token keyword">if</span> <span class="token punctuation">(</span>ageBegin <span class="token operator">!=</span> <span class="token keyword">null</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
            queryWrapper<span class="token punctuation">.</span><span class="token function">ge</span><span class="token punctuation">(</span><span class="token string">"age"</span><span class="token punctuation">,</span> ageBegin<span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token punctuation">}</span>
        <span class="token keyword">if</span> <span class="token punctuation">(</span>ageEnd <span class="token operator">!=</span> <span class="token keyword">null</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
            queryWrapper<span class="token punctuation">.</span><span class="token function">le</span><span class="token punctuation">(</span><span class="token string">"age"</span><span class="token punctuation">,</span> ageEnd<span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token punctuation">}</span>
        <span class="token class-name">List</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">User</span><span class="token punctuation">></span></span> list <span class="token operator">=</span> userMapper<span class="token punctuation">.</span><span class="token function">selectList</span><span class="token punctuation">(</span>queryWrapper<span class="token punctuation">)</span><span class="token punctuation">;</span>
        list<span class="token punctuation">.</span><span class="token function">forEach</span><span class="token punctuation">(</span><span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token operator">::</span><span class="token function">println</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token punctuation">}</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ol start="2">
<li>使用带condition参数的重载方法构建查询条件</li>
</ol>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token annotation punctuation">@SpringBootTest</span>
<span class="token keyword">public</span> <span class="token keyword">class</span> <span class="token class-name">ConditionTests</span> <span class="token punctuation">{</span>
    <span class="token annotation punctuation">@Autowired</span>
    <span class="token keyword">private</span> <span class="token class-name">UserMapper</span> userMapper<span class="token punctuation">;</span>
    <span class="token annotation punctuation">@Test</span>
    <span class="token keyword">public</span> <span class="token keyword">void</span> <span class="token function">test02</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
<span class="token comment">//        SELECT id,name,age,email FROM user WHERE (age >= ? AND age &lt;= ?)</span>
        <span class="token class-name">String</span> name <span class="token operator">=</span> <span class="token string">""</span><span class="token punctuation">;</span>
        <span class="token class-name">Integer</span> ageBegin <span class="token operator">=</span> <span class="token number">20</span><span class="token punctuation">;</span>
        <span class="token class-name">Integer</span> ageEnd <span class="token operator">=</span> <span class="token number">30</span><span class="token punctuation">;</span>

        <span class="token class-name">QueryWrapper</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">User</span><span class="token punctuation">></span></span> queryWrapper <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">QueryWrapper</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token punctuation">></span></span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        queryWrapper<span class="token punctuation">.</span><span class="token function">like</span><span class="token punctuation">(</span><span class="token class-name">StringUtils</span><span class="token punctuation">.</span><span class="token function">isNotBlank</span><span class="token punctuation">(</span>name<span class="token punctuation">)</span><span class="token punctuation">,</span> <span class="token string">"user_name"</span><span class="token punctuation">,</span> name<span class="token punctuation">)</span>
                <span class="token punctuation">.</span><span class="token function">ge</span><span class="token punctuation">(</span>ageBegin <span class="token operator">!=</span> <span class="token keyword">null</span><span class="token punctuation">,</span> <span class="token string">"age"</span><span class="token punctuation">,</span> ageBegin<span class="token punctuation">)</span>
                <span class="token punctuation">.</span><span class="token function">le</span><span class="token punctuation">(</span>ageEnd <span class="token operator">!=</span> <span class="token keyword">null</span><span class="token punctuation">,</span> <span class="token string">"age"</span><span class="token punctuation">,</span> ageEnd<span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token class-name">List</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">User</span><span class="token punctuation">></span></span> list <span class="token operator">=</span> userMapper<span class="token punctuation">.</span><span class="token function">selectList</span><span class="token punctuation">(</span>queryWrapper<span class="token punctuation">)</span><span class="token punctuation">;</span>
        list<span class="token punctuation">.</span><span class="token function">forEach</span><span class="token punctuation">(</span><span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token operator">::</span><span class="token function">println</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token punctuation">}</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><h3 id="_4-4-lambdaquerywrapper" tabindex="-1"><a class="header-anchor" href="#_4-4-lambdaquerywrapper" aria-hidden="true">#</a> 4.4 LambdaQueryWrapper</h3>
<ul>
<li>解决查询时不小心写错字段名的问题</li>
</ul>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token annotation punctuation">@SpringBootTest</span>
<span class="token keyword">public</span> <span class="token keyword">class</span> <span class="token class-name">LambdaQueryWrapperTests</span> <span class="token punctuation">{</span>
    <span class="token annotation punctuation">@Autowired</span>
    <span class="token keyword">private</span> <span class="token class-name">UserMapper</span> userMapper<span class="token punctuation">;</span>
    <span class="token annotation punctuation">@Test</span>
    <span class="token keyword">public</span> <span class="token keyword">void</span> <span class="token function">test01</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
<span class="token comment">//        SELECT id,name,age,email FROM user WHERE (age >= ? AND age &lt;= ?)</span>
        <span class="token class-name">String</span> name <span class="token operator">=</span> <span class="token string">""</span><span class="token punctuation">;</span>
        <span class="token class-name">Integer</span> ageBegin <span class="token operator">=</span> <span class="token number">20</span><span class="token punctuation">;</span>
        <span class="token class-name">Integer</span> ageEnd <span class="token operator">=</span> <span class="token number">30</span><span class="token punctuation">;</span>

        <span class="token class-name">LambdaQueryWrapper</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">User</span><span class="token punctuation">></span></span> lambdaQueryWrapper <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">LambdaQueryWrapper</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token punctuation">></span></span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        lambdaQueryWrapper<span class="token punctuation">.</span><span class="token function">like</span><span class="token punctuation">(</span><span class="token class-name">StringUtils</span><span class="token punctuation">.</span><span class="token function">isNotBlank</span><span class="token punctuation">(</span>name<span class="token punctuation">)</span><span class="token punctuation">,</span> <span class="token class-name">User</span><span class="token operator">::</span><span class="token function">getName</span><span class="token punctuation">,</span> name<span class="token punctuation">)</span>
                <span class="token punctuation">.</span><span class="token function">ge</span><span class="token punctuation">(</span>ageBegin <span class="token operator">!=</span> <span class="token keyword">null</span><span class="token punctuation">,</span> <span class="token class-name">User</span><span class="token operator">::</span><span class="token function">getAge</span><span class="token punctuation">,</span> ageBegin<span class="token punctuation">)</span>
                <span class="token punctuation">.</span><span class="token function">le</span><span class="token punctuation">(</span>ageEnd <span class="token operator">!=</span> <span class="token keyword">null</span><span class="token punctuation">,</span> <span class="token class-name">User</span><span class="token operator">::</span><span class="token function">getAge</span><span class="token punctuation">,</span> ageEnd<span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token class-name">List</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">User</span><span class="token punctuation">></span></span> list <span class="token operator">=</span> userMapper<span class="token punctuation">.</span><span class="token function">selectList</span><span class="token punctuation">(</span>lambdaQueryWrapper<span class="token punctuation">)</span><span class="token punctuation">;</span>
        list<span class="token punctuation">.</span><span class="token function">forEach</span><span class="token punctuation">(</span><span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token operator">::</span><span class="token function">println</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><h3 id="_4-5-lambdaupdatewrapper" tabindex="-1"><a class="header-anchor" href="#_4-5-lambdaupdatewrapper" aria-hidden="true">#</a> 4.5 LambdaUpdateWrapper</h3>
<ul>
<li>解决修改时不小心写错字段名的问题</li>
</ul>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token annotation punctuation">@SpringBootTest</span>
<span class="token keyword">public</span> <span class="token keyword">class</span> <span class="token class-name">LambdaUpdateWrapperTests</span> <span class="token punctuation">{</span>
    <span class="token annotation punctuation">@Autowired</span>
    <span class="token keyword">private</span> <span class="token class-name">UserMapper</span> userMapper<span class="token punctuation">;</span>
    <span class="token annotation punctuation">@Test</span>
    <span class="token keyword">public</span> <span class="token keyword">void</span> <span class="token function">test01</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">{</span>
<span class="token comment">//        将用户名包含a并且（年龄大于20或者邮箱为null）的用户信息修改</span>
<span class="token comment">//        UPDATE user SET name=?,email=? WHERE (name LIKE ? AND (age > ? AND email IS NULL))</span>
        <span class="token class-name">LambdaUpdateWrapper</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">User</span><span class="token punctuation">></span></span> lambdaUpdateWrapper <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">LambdaUpdateWrapper</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token punctuation">></span></span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        lambdaUpdateWrapper<span class="token punctuation">.</span><span class="token function">like</span><span class="token punctuation">(</span><span class="token class-name">User</span><span class="token operator">::</span><span class="token function">getName</span><span class="token punctuation">,</span> <span class="token string">"i"</span><span class="token punctuation">)</span>
                           <span class="token punctuation">.</span><span class="token function">and</span><span class="token punctuation">(</span>i <span class="token operator">-></span> i<span class="token punctuation">.</span><span class="token function">gt</span><span class="token punctuation">(</span><span class="token class-name">User</span><span class="token operator">::</span><span class="token function">getAge</span><span class="token punctuation">,</span> <span class="token number">20</span><span class="token punctuation">)</span><span class="token punctuation">.</span><span class="token function">isNull</span><span class="token punctuation">(</span><span class="token class-name">User</span><span class="token operator">::</span><span class="token function">getEmail</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        lambdaUpdateWrapper<span class="token punctuation">.</span><span class="token function">set</span><span class="token punctuation">(</span><span class="token class-name">User</span><span class="token operator">::</span><span class="token function">getName</span><span class="token punctuation">,</span><span class="token string">"大王"</span><span class="token punctuation">)</span><span class="token punctuation">.</span><span class="token function">set</span><span class="token punctuation">(</span><span class="token class-name">User</span><span class="token operator">::</span><span class="token function">getEmail</span><span class="token punctuation">,</span> <span class="token string">"newd@sina.com"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token keyword">int</span> result <span class="token operator">=</span> userMapper<span class="token punctuation">.</span><span class="token function">update</span><span class="token punctuation">(</span><span class="token keyword">null</span><span class="token punctuation">,</span> lambdaUpdateWrapper<span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span><span class="token string">"result"</span> <span class="token operator">+</span> result<span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token punctuation">}</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><h2 id="第5章-插件" tabindex="-1"><a class="header-anchor" href="#第5章-插件" aria-hidden="true">#</a> 第5章 插件</h2>
<h3 id="_5-1-分页插件" tabindex="-1"><a class="header-anchor" href="#_5-1-分页插件" aria-hidden="true">#</a> 5.1 分页插件</h3>
<h4 id="_5-1-1-使用mybatisplus的分页方法" tabindex="-1"><a class="header-anchor" href="#_5-1-1-使用mybatisplus的分页方法" aria-hidden="true">#</a> 5.1.1 使用mybatisplus的分页方法</h4>
<ol>
<li>创建分页配置类：config.MyBatisPlusConfig.java</li>
<li>使用@Configuration指定为配置类
<ul>
<li>由于在springboot的启动类上已经使用了@MapperScan注解，所以配置类可以不使用@MapperScan注解</li>
<li>但是为了程序规范化、语义化，建议将@MapperScan注解添加到配置类上</li>
</ul>
</li>
<li>编写分页器方法</li>
</ol>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token keyword">package</span> <span class="token namespace">iceriver<span class="token punctuation">.</span>mybatisplus<span class="token punctuation">.</span>config</span><span class="token punctuation">;</span>

<span class="token keyword">import</span> <span class="token import"><span class="token namespace">com<span class="token punctuation">.</span>baomidou<span class="token punctuation">.</span>mybatisplus<span class="token punctuation">.</span>annotation<span class="token punctuation">.</span></span><span class="token class-name">DbType</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">com<span class="token punctuation">.</span>baomidou<span class="token punctuation">.</span>mybatisplus<span class="token punctuation">.</span>extension<span class="token punctuation">.</span>plugins<span class="token punctuation">.</span></span><span class="token class-name">MybatisPlusInterceptor</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">com<span class="token punctuation">.</span>baomidou<span class="token punctuation">.</span>mybatisplus<span class="token punctuation">.</span>extension<span class="token punctuation">.</span>plugins<span class="token punctuation">.</span>inner<span class="token punctuation">.</span></span><span class="token class-name">PaginationInnerInterceptor</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">org<span class="token punctuation">.</span>springframework<span class="token punctuation">.</span>context<span class="token punctuation">.</span>annotation<span class="token punctuation">.</span></span><span class="token class-name">Bean</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">org<span class="token punctuation">.</span>springframework<span class="token punctuation">.</span>context<span class="token punctuation">.</span>annotation<span class="token punctuation">.</span></span><span class="token class-name">Configuration</span></span><span class="token punctuation">;</span>

<span class="token doc-comment comment">/**
 * <span class="token keyword">@author</span>: INFINITY https://developer.aliyun.com/profile/sagwrxp2ua66w
 * <span class="token keyword">@date</span>: 2022/8/5 11:05
 */</span>
<span class="token annotation punctuation">@Configuration</span>
<span class="token keyword">public</span> <span class="token keyword">class</span> <span class="token class-name">MyBatisPlusConfig</span> <span class="token punctuation">{</span>
    <span class="token doc-comment comment">/**
     * 定义了名为mybatisPlusInterceptor，返回类型为MybatisPlusInterceptor的方法
     * <span class="token keyword">@return</span>
     */</span>
    <span class="token annotation punctuation">@Bean</span>
    <span class="token keyword">public</span> <span class="token class-name">MybatisPlusInterceptor</span> <span class="token function">mybatisPlusInterceptor</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">{</span>
        <span class="token class-name">MybatisPlusInterceptor</span> interceptor <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">MybatisPlusInterceptor</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        interceptor<span class="token punctuation">.</span><span class="token function">addInnerInterceptor</span><span class="token punctuation">(</span><span class="token keyword">new</span> <span class="token class-name">PaginationInnerInterceptor</span><span class="token punctuation">(</span><span class="token class-name">DbType</span><span class="token punctuation">.</span>MYSQL<span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token keyword">return</span> interceptor<span class="token punctuation">;</span>
    <span class="token punctuation">}</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ol start="4">
<li>测试：</li>
</ol>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token keyword">package</span> <span class="token namespace">iceriver<span class="token punctuation">.</span>mybatisplus</span><span class="token punctuation">;</span>

<span class="token keyword">import</span> <span class="token import"><span class="token namespace">com<span class="token punctuation">.</span>baomidou<span class="token punctuation">.</span>mybatisplus<span class="token punctuation">.</span>extension<span class="token punctuation">.</span>plugins<span class="token punctuation">.</span>pagination<span class="token punctuation">.</span></span><span class="token class-name">Page</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">iceriver<span class="token punctuation">.</span>mybatisplus<span class="token punctuation">.</span>bean<span class="token punctuation">.</span></span><span class="token class-name">User</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">iceriver<span class="token punctuation">.</span>mybatisplus<span class="token punctuation">.</span>mapper<span class="token punctuation">.</span></span><span class="token class-name">UserMapper</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">org<span class="token punctuation">.</span>junit<span class="token punctuation">.</span>jupiter<span class="token punctuation">.</span>api<span class="token punctuation">.</span></span><span class="token class-name">Test</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">org<span class="token punctuation">.</span>springframework<span class="token punctuation">.</span>beans<span class="token punctuation">.</span>factory<span class="token punctuation">.</span>annotation<span class="token punctuation">.</span></span><span class="token class-name">Autowired</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">org<span class="token punctuation">.</span>springframework<span class="token punctuation">.</span>boot<span class="token punctuation">.</span>test<span class="token punctuation">.</span>context<span class="token punctuation">.</span></span><span class="token class-name">SpringBootTest</span></span><span class="token punctuation">;</span>

<span class="token doc-comment comment">/**
 * <span class="token keyword">@author</span>: INFINITY https://developer.aliyun.com/profile/sagwrxp2ua66w
 * <span class="token keyword">@date</span>: 2022/8/5 11:16
 */</span>
<span class="token annotation punctuation">@SpringBootTest</span>
<span class="token keyword">public</span> <span class="token keyword">class</span> <span class="token class-name">MyBatisPlusPluginsTests</span> <span class="token punctuation">{</span>
    <span class="token annotation punctuation">@Autowired</span>
    <span class="token keyword">private</span> <span class="token class-name">UserMapper</span> userMapper<span class="token punctuation">;</span>
    <span class="token annotation punctuation">@Test</span>
    <span class="token keyword">public</span> <span class="token keyword">void</span> <span class="token function">test</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">{</span>
        <span class="token class-name">Page</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">User</span><span class="token punctuation">></span></span> page <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">Page</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token punctuation">></span></span><span class="token punctuation">(</span><span class="token number">1</span><span class="token punctuation">,</span> <span class="token number">3</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token class-name">Page</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">User</span><span class="token punctuation">></span></span> page1 <span class="token operator">=</span> userMapper<span class="token punctuation">.</span><span class="token function">selectPage</span><span class="token punctuation">(</span>page<span class="token punctuation">,</span> <span class="token keyword">null</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span>page<span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span><span class="token string">"-------------------"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span>page1<span class="token operator">==</span>page<span class="token punctuation">)</span><span class="token punctuation">;</span><span class="token comment">//true</span>
    <span class="token punctuation">}</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><h4 id="_5-1-2-自定义分页方法" tabindex="-1"><a class="header-anchor" href="#_5-1-2-自定义分页方法" aria-hidden="true">#</a> 5.1.2 自定义分页方法</h4>
<ol>
<li>使用自定义分页方法的流程与mybatis中操作一致
<ul>
<li>在mapper接口中定义分页方法</li>
<li>在reosources目录下创建mapper目录，创建对应的mapper.xml映射文件
<ul>
<li>如果映射文件不在mapper目录下，则需要在application.yml文件中进行配置使用mybatis-plus.mapper-location，指定位置。</li>
</ul>
</li>
<li>在mapper.xml文件中编写sql语句</li>
<li>调用mapper接口中的方法进行使用</li>
</ul>
</li>
<li>编写分页方法</li>
</ol>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token keyword">package</span> <span class="token namespace">iceriver<span class="token punctuation">.</span>mybatisplus<span class="token punctuation">.</span>mapper</span><span class="token punctuation">;</span>

<span class="token keyword">import</span> <span class="token import"><span class="token namespace">com<span class="token punctuation">.</span>baomidou<span class="token punctuation">.</span>mybatisplus<span class="token punctuation">.</span>core<span class="token punctuation">.</span>mapper<span class="token punctuation">.</span></span><span class="token class-name">BaseMapper</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">iceriver<span class="token punctuation">.</span>mybatisplus<span class="token punctuation">.</span>bean<span class="token punctuation">.</span></span><span class="token class-name">User</span></span><span class="token punctuation">;</span>

<span class="token keyword">import</span> <span class="token import"><span class="token namespace">java<span class="token punctuation">.</span>util<span class="token punctuation">.</span></span><span class="token class-name">Map</span></span><span class="token punctuation">;</span>

<span class="token doc-comment comment">/**
 * <span class="token keyword">@author</span>: INFINITY https://developer.aliyun.com/profile/sagwrxp2ua66w
 * <span class="token keyword">@date</span>: 2022/8/4 21:01
 */</span>
<span class="token keyword">public</span> <span class="token keyword">interface</span> <span class="token class-name">UserMapper</span> <span class="token keyword">extends</span> <span class="token class-name">BaseMapper</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">User</span><span class="token punctuation">></span></span> <span class="token punctuation">{</span>
    <span class="token doc-comment comment">/**
     * 自定义分页查询方法：根据年龄查询用户信息并分页
     * <span class="token keyword">@param</span> <span class="token parameter">page</span> mybatis-plus提供的分页对象，必须位于第一个参数的位置
     * <span class="token keyword">@param</span> <span class="token parameter">age</span>
     * <span class="token keyword">@return</span>
     */</span>
    <span class="token class-name">Page</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">User</span><span class="token punctuation">></span></span> <span class="token function">selectPageVo</span><span class="token punctuation">(</span><span class="token annotation punctuation">@Param</span><span class="token punctuation">(</span><span class="token string">"page"</span><span class="token punctuation">)</span> <span class="token class-name">Page</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">User</span><span class="token punctuation">></span></span> page<span class="token punctuation">,</span>
                            <span class="token annotation punctuation">@Param</span><span class="token punctuation">(</span><span class="token string">"age"</span><span class="token punctuation">)</span> <span class="token class-name">Integer</span> age<span class="token punctuation">)</span><span class="token punctuation">;</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ul>
<li>自定义方法中，<code v-pre>Page&lt;T&gt;</code>对象必须作为第一个参数</li>
</ul>
<ol start="3">
<li>编写sql映射文件</li>
</ol>
<div class="language-xml ext-xml line-numbers-mode"><pre v-pre class="language-xml"><code><span class="token prolog">&lt;?xml version="1.0" encoding="UTF-8" ?></span>
<span class="token doctype"><span class="token punctuation">&lt;!</span><span class="token doctype-tag">DOCTYPE</span> <span class="token name">mapper</span>
        <span class="token name">PUBLIC</span> <span class="token string">"-//mybatis.org//DTD Mapper 3.0//EN"</span>
        <span class="token string">"http://mybatis.org/dtd/mybatis-3-mapper.dtd"</span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>mapper</span> <span class="token attr-name">namespace</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>iceriver.mybatisplus.mapper.UserMapper<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
    <span class="token comment">&lt;!--    Page&lt;User> selectPageVo(@Param("page") Page&lt;User> page, @Param("age") Integer age);--></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>select</span> <span class="token attr-name">id</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>selectPageVo<span class="token punctuation">"</span></span> <span class="token attr-name">resultType</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>User<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
    select uid,user_name,age,email from t_user where age > #{age}
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>select</span><span class="token punctuation">></span></span>  
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>mapper</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ul>
<li>这里resultType实用类型别名，指定类型别名要在springboot核心配置文件中进行设定：<code v-pre>mybatis-plus.type-aliases-package: iceriver.mybatisplus.pojo</code></li>
</ul>
<ol start="4">
<li>测试方法：</li>
</ol>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token keyword">package</span> <span class="token namespace">iceriver<span class="token punctuation">.</span>mybatisplus</span><span class="token punctuation">;</span>

<span class="token keyword">import</span> <span class="token import"><span class="token namespace">com<span class="token punctuation">.</span>baomidou<span class="token punctuation">.</span>mybatisplus<span class="token punctuation">.</span>extension<span class="token punctuation">.</span>plugins<span class="token punctuation">.</span>pagination<span class="token punctuation">.</span></span><span class="token class-name">Page</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">iceriver<span class="token punctuation">.</span>mybatisplus<span class="token punctuation">.</span>bean<span class="token punctuation">.</span></span><span class="token class-name">User</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">iceriver<span class="token punctuation">.</span>mybatisplus<span class="token punctuation">.</span>mapper<span class="token punctuation">.</span></span><span class="token class-name">UserMapper</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">org<span class="token punctuation">.</span>junit<span class="token punctuation">.</span>jupiter<span class="token punctuation">.</span>api<span class="token punctuation">.</span></span><span class="token class-name">Test</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">org<span class="token punctuation">.</span>springframework<span class="token punctuation">.</span>beans<span class="token punctuation">.</span>factory<span class="token punctuation">.</span>annotation<span class="token punctuation">.</span></span><span class="token class-name">Autowired</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">org<span class="token punctuation">.</span>springframework<span class="token punctuation">.</span>boot<span class="token punctuation">.</span>test<span class="token punctuation">.</span>context<span class="token punctuation">.</span></span><span class="token class-name">SpringBootTest</span></span><span class="token punctuation">;</span>

<span class="token doc-comment comment">/**
* <span class="token keyword">@author</span>: INFINITY https://developer.aliyun.com/profile/sagwrxp2ua66w
* <span class="token keyword">@date</span>: 2022/8/4 21:09
*/</span>
<span class="token annotation punctuation">@SpringBootTest</span>
<span class="token keyword">public</span> <span class="token keyword">class</span> <span class="token class-name">UserTests</span> <span class="token punctuation">{</span>
    <span class="token annotation punctuation">@Autowired</span>
    <span class="token keyword">private</span> <span class="token class-name">UserMapper</span> userMapper<span class="token punctuation">;</span>
    
    <span class="token annotation punctuation">@Test</span>
    <span class="token keyword">public</span> <span class="token keyword">void</span> <span class="token function">testPageVo</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">{</span>
        <span class="token class-name">Page</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">User</span><span class="token punctuation">></span></span> page <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">Page</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token punctuation">></span></span><span class="token punctuation">(</span><span class="token number">1</span><span class="token punctuation">,</span><span class="token number">3</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token class-name">Page</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">User</span><span class="token punctuation">></span></span> page1 <span class="token operator">=</span> userMapper<span class="token punctuation">.</span><span class="token function">selectPageVo</span><span class="token punctuation">(</span>page<span class="token punctuation">,</span> <span class="token number">20</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span>page<span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span>page1<span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span>page<span class="token operator">==</span>page1<span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token punctuation">}</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><h3 id="_5-2-乐观锁" tabindex="-1"><a class="header-anchor" href="#_5-2-乐观锁" aria-hidden="true">#</a> 5.2 乐观锁</h3>
<h4 id="_5-2-1-乐观锁悲观锁介绍" tabindex="-1"><a class="header-anchor" href="#_5-2-1-乐观锁悲观锁介绍" aria-hidden="true">#</a> 5.2.1 乐观锁悲观锁介绍</h4>
<ol>
<li>场景：</li>
</ol>
<blockquote>
<p>一件商品，成本价是80元，售价是100元。老板先是通知小李，说你去把商品价格增加50元。小李正在玩游戏，耽搁了一个小时。正好一个小时后，老板觉得商品价格增加到150元，价格太高，可能会影响销量。又通知小王，你把商品价格降低30元。此时，小李和小王同时操作商品后台系统。小李操作的时候，系统先取出商品价格100元；小王也在操作，取出的商品价格也是100元。小李将价格加了50元，并将100+50=150元存入了数据库；小王将商品减了30元，并将100-30=70元存入了数据库。是的，如果没有锁，小李的操作就完全被小王的覆盖了。现在商品价格是70元，比成本价低10元。几分钟后，这个商品很快出售了1千多件商品，老板亏1万多。</p>
</blockquote>
<ol start="2">
<li>乐观锁与悲观锁</li>
</ol>
<blockquote>
<p>上面的故事，如果是乐观锁，小王保存价格前，会检查下价格是否被人修改过了。如果被修改过了，则重新取出的被修改后的价格，150元，这样他会将120元存入数据库。如果是悲观锁，小李取出数据后，小王只能等小李操作完之后，才能对价格进行操作，也会保证最终的价格是120元</p>
</blockquote>
<ol start="3">
<li>乐观锁要求数据表有表示数据版本的字段，在修改前，乐观锁会检查一下最新的数据版本版与自己持有的版本号是否一致。</li>
</ol>
<h4 id="_5-2-2-模拟修改冲突" tabindex="-1"><a class="header-anchor" href="#_5-2-2-模拟修改冲突" aria-hidden="true">#</a> 5.2.2 模拟修改冲突</h4>
<ol>
<li>创建商品表</li>
</ol>
<div class="language-sql ext-sql line-numbers-mode"><pre v-pre class="language-sql"><code><span class="token keyword">CREATE</span> <span class="token keyword">TABLE</span> t_product
<span class="token punctuation">(</span>
  id <span class="token keyword">BIGINT</span><span class="token punctuation">(</span><span class="token number">20</span><span class="token punctuation">)</span> <span class="token operator">NOT</span> <span class="token boolean">NULL</span> <span class="token keyword">COMMENT</span> <span class="token string">'主键ID'</span><span class="token punctuation">,</span>
  NAME <span class="token keyword">VARCHAR</span><span class="token punctuation">(</span><span class="token number">30</span><span class="token punctuation">)</span> <span class="token boolean">NULL</span> <span class="token keyword">DEFAULT</span> <span class="token boolean">NULL</span> <span class="token keyword">COMMENT</span> <span class="token string">'商品名称'</span><span class="token punctuation">,</span>
  price <span class="token keyword">INT</span><span class="token punctuation">(</span><span class="token number">11</span><span class="token punctuation">)</span> <span class="token keyword">DEFAULT</span> <span class="token number">0</span> <span class="token keyword">COMMENT</span> <span class="token string">'价格'</span><span class="token punctuation">,</span>
  VERSION <span class="token keyword">INT</span><span class="token punctuation">(</span><span class="token number">11</span><span class="token punctuation">)</span> <span class="token keyword">DEFAULT</span> <span class="token number">0</span> <span class="token keyword">COMMENT</span> <span class="token string">'乐观锁版本号'</span><span class="token punctuation">,</span>
  <span class="token keyword">PRIMARY</span> <span class="token keyword">KEY</span> <span class="token punctuation">(</span>id<span class="token punctuation">)</span>
<span class="token punctuation">)</span><span class="token punctuation">;</span>
<span class="token keyword">INSERT</span> <span class="token keyword">INTO</span> t_product <span class="token punctuation">(</span>id<span class="token punctuation">,</span> NAME<span class="token punctuation">,</span> price<span class="token punctuation">)</span> <span class="token keyword">VALUES</span> <span class="token punctuation">(</span><span class="token number">1</span><span class="token punctuation">,</span> <span class="token string">'外星人笔记本'</span><span class="token punctuation">,</span> <span class="token number">100</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ol start="2">
<li>创建实体类</li>
</ol>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token keyword">package</span> <span class="token namespace">iceriver<span class="token punctuation">.</span>mybatisplus<span class="token punctuation">.</span>bean</span><span class="token punctuation">;</span>

<span class="token keyword">import</span> <span class="token import"><span class="token namespace">lombok<span class="token punctuation">.</span></span><span class="token class-name">Data</span></span><span class="token punctuation">;</span>

<span class="token doc-comment comment">/**
 * <span class="token keyword">@author</span>: INFINITY https://developer.aliyun.com/profile/sagwrxp2ua66w
 * <span class="token keyword">@date</span>: 2022/8/5 14:47
 */</span>
<span class="token annotation punctuation">@Data</span>
<span class="token keyword">public</span> <span class="token keyword">class</span> <span class="token class-name">Product</span> <span class="token punctuation">{</span>
    <span class="token keyword">private</span> <span class="token class-name">Long</span> id<span class="token punctuation">;</span>
    <span class="token keyword">private</span> <span class="token class-name">String</span> name<span class="token punctuation">;</span>
    <span class="token keyword">private</span> <span class="token class-name">Integer</span> price<span class="token punctuation">;</span>
    <span class="token keyword">private</span> <span class="token class-name">Integer</span> version<span class="token punctuation">;</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ol start="3">
<li>创建mapper接口</li>
</ol>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token keyword">package</span> <span class="token namespace">iceriver<span class="token punctuation">.</span>mybatisplus<span class="token punctuation">.</span>mapper</span><span class="token punctuation">;</span>

<span class="token keyword">import</span> <span class="token import"><span class="token namespace">com<span class="token punctuation">.</span>baomidou<span class="token punctuation">.</span>mybatisplus<span class="token punctuation">.</span>core<span class="token punctuation">.</span>mapper<span class="token punctuation">.</span></span><span class="token class-name">BaseMapper</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">iceriver<span class="token punctuation">.</span>mybatisplus<span class="token punctuation">.</span>bean<span class="token punctuation">.</span></span><span class="token class-name">Product</span></span><span class="token punctuation">;</span>

<span class="token doc-comment comment">/**
 * <span class="token keyword">@author</span>: INFINITY https://developer.aliyun.com/profile/sagwrxp2ua66w
 * <span class="token keyword">@date</span>: 2022/8/5 14:49
 */</span>
<span class="token keyword">public</span> <span class="token keyword">interface</span> <span class="token class-name">ProductMapper</span> <span class="token keyword">extends</span> <span class="token class-name">BaseMapper</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">Product</span><span class="token punctuation">></span></span> <span class="token punctuation">{</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ol start="4">
<li>测试</li>
</ol>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token keyword">package</span> <span class="token namespace">iceriver<span class="token punctuation">.</span>mybatisplus</span><span class="token punctuation">;</span>

<span class="token keyword">import</span> <span class="token import"><span class="token namespace">iceriver<span class="token punctuation">.</span>mybatisplus<span class="token punctuation">.</span>bean<span class="token punctuation">.</span></span><span class="token class-name">Product</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">iceriver<span class="token punctuation">.</span>mybatisplus<span class="token punctuation">.</span>mapper<span class="token punctuation">.</span></span><span class="token class-name">ProductMapper</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">org<span class="token punctuation">.</span>junit<span class="token punctuation">.</span>jupiter<span class="token punctuation">.</span>api<span class="token punctuation">.</span></span><span class="token class-name">Test</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">org<span class="token punctuation">.</span>springframework<span class="token punctuation">.</span>beans<span class="token punctuation">.</span>factory<span class="token punctuation">.</span>annotation<span class="token punctuation">.</span></span><span class="token class-name">Autowired</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">org<span class="token punctuation">.</span>springframework<span class="token punctuation">.</span>boot<span class="token punctuation">.</span>test<span class="token punctuation">.</span>context<span class="token punctuation">.</span></span><span class="token class-name">SpringBootTest</span></span><span class="token punctuation">;</span>

<span class="token doc-comment comment">/**
 * <span class="token keyword">@author</span>: INFINITY https://developer.aliyun.com/profile/sagwrxp2ua66w
 * <span class="token keyword">@date</span>: 2022/8/5 14:49
 */</span>
<span class="token annotation punctuation">@SpringBootTest</span>
<span class="token keyword">public</span> <span class="token keyword">class</span> <span class="token class-name">ProductMapperTests</span> <span class="token punctuation">{</span>
    <span class="token annotation punctuation">@Autowired</span>
    <span class="token keyword">private</span> <span class="token class-name">ProductMapper</span> productMapper<span class="token punctuation">;</span>
    <span class="token annotation punctuation">@Test</span>
    <span class="token keyword">public</span> <span class="token keyword">void</span>  <span class="token function">test</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">{</span>
        <span class="token comment">//1. 小李查询商品价格</span>
        <span class="token class-name">Product</span> productL <span class="token operator">=</span> productMapper<span class="token punctuation">.</span><span class="token function">selectById</span><span class="token punctuation">(</span><span class="token number">1</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span><span class="token string">"小李查询的商品价格"</span> <span class="token operator">+</span> productL<span class="token punctuation">.</span><span class="token function">getPrice</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token comment">//2. 小王查询商品价格</span>
        <span class="token class-name">Product</span> productW <span class="token operator">=</span> productMapper<span class="token punctuation">.</span><span class="token function">selectById</span><span class="token punctuation">(</span><span class="token number">1</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span><span class="token string">"小王查询的商品价格"</span> <span class="token operator">+</span> productW<span class="token punctuation">.</span><span class="token function">getPrice</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span><span class="token string">"----------修改价格前------------"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token comment">//3. 小李对商品价格+50</span>
        productL<span class="token punctuation">.</span><span class="token function">setPrice</span><span class="token punctuation">(</span>productL<span class="token punctuation">.</span><span class="token function">getPrice</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token operator">+</span> <span class="token number">50</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        productMapper<span class="token punctuation">.</span><span class="token function">updateById</span><span class="token punctuation">(</span>productL<span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token comment">//4. 小王对商品价格-30</span>
        <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span><span class="token string">"小王查询的商品价格"</span> <span class="token operator">+</span> productW<span class="token punctuation">.</span><span class="token function">getPrice</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        productW<span class="token punctuation">.</span><span class="token function">setPrice</span><span class="token punctuation">(</span>productW<span class="token punctuation">.</span><span class="token function">getPrice</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token operator">-</span> <span class="token number">30</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        productMapper<span class="token punctuation">.</span><span class="token function">updateById</span><span class="token punctuation">(</span>productL<span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span><span class="token string">"----------修改价格后------------"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token comment">//5. 老板检查价格</span>
        <span class="token class-name">Product</span> productB <span class="token operator">=</span> productMapper<span class="token punctuation">.</span><span class="token function">selectById</span><span class="token punctuation">(</span><span class="token number">1</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span><span class="token string">"老板查询的商品价格"</span> <span class="token operator">+</span> productB<span class="token punctuation">.</span><span class="token function">getPrice</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token punctuation">}</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><h4 id="_5-2-3-mybatis-plus乐观锁插件" tabindex="-1"><a class="header-anchor" href="#_5-2-3-mybatis-plus乐观锁插件" aria-hidden="true">#</a> 5.2.3 mybatis-plus乐观锁插件</h4>
<ol>
<li>实体类中添加乐观锁版本号注解@Version
<ul>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1659688919504-55d5902e-fd61-46de-9eac-39c8d18a48ad.png#clientId=uaf8d940b-efc7-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=215&amp;id=u8613ceac&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=215&amp;originWidth=263&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=16333&amp;status=done&amp;style=none&amp;taskId=u54889807-bba9-4686-8769-d86c2fa870e&amp;title=&amp;width=263" alt="image.png" loading="lazy"></li>
</ul>
</li>
<li>配置类中开启乐观锁插件</li>
</ol>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token keyword">package</span> <span class="token namespace">iceriver<span class="token punctuation">.</span>mybatisplus<span class="token punctuation">.</span>config</span><span class="token punctuation">;</span>

<span class="token keyword">import</span> <span class="token import"><span class="token namespace">com<span class="token punctuation">.</span>baomidou<span class="token punctuation">.</span>mybatisplus<span class="token punctuation">.</span>extension<span class="token punctuation">.</span>plugins<span class="token punctuation">.</span></span><span class="token class-name">MybatisPlusInterceptor</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">com<span class="token punctuation">.</span>baomidou<span class="token punctuation">.</span>mybatisplus<span class="token punctuation">.</span>extension<span class="token punctuation">.</span>plugins<span class="token punctuation">.</span>inner<span class="token punctuation">.</span></span><span class="token class-name">OptimisticLockerInnerInterceptor</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">org<span class="token punctuation">.</span>springframework<span class="token punctuation">.</span>context<span class="token punctuation">.</span>annotation<span class="token punctuation">.</span></span><span class="token class-name">Bean</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">org<span class="token punctuation">.</span>springframework<span class="token punctuation">.</span>context<span class="token punctuation">.</span>annotation<span class="token punctuation">.</span></span><span class="token class-name">Configuration</span></span><span class="token punctuation">;</span>

<span class="token doc-comment comment">/**
 * <span class="token keyword">@author</span>: INFINITY https://developer.aliyun.com/profile/sagwrxp2ua66w
 * <span class="token keyword">@date</span>: 2022/8/5 16:38
 */</span>
<span class="token annotation punctuation">@Configuration</span>
<span class="token keyword">public</span> <span class="token keyword">class</span> <span class="token class-name">MyConfig</span> <span class="token punctuation">{</span>
    <span class="token annotation punctuation">@Bean</span>
    <span class="token keyword">public</span> <span class="token class-name">MybatisPlusInterceptor</span> <span class="token function">mybatisPlusInterceptor</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">{</span>
        <span class="token class-name">MybatisPlusInterceptor</span> interceptor <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">MybatisPlusInterceptor</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        interceptor<span class="token punctuation">.</span><span class="token function">addInnerInterceptor</span><span class="token punctuation">(</span><span class="token keyword">new</span> <span class="token class-name">OptimisticLockerInnerInterceptor</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token keyword">return</span> interceptor<span class="token punctuation">;</span>
    <span class="token punctuation">}</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ul>
<li>此时老板获得的价格为150，因为小李的修改会执行，小王的修改不会执行。</li>
<li>小王如果想要修改成功，可以进行判断，修改不成功重新获取最新版本的数据进行修改</li>
</ul>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token keyword">package</span> <span class="token namespace">iceriver<span class="token punctuation">.</span>mybatisplus</span><span class="token punctuation">;</span>

<span class="token keyword">import</span> <span class="token import"><span class="token namespace">iceriver<span class="token punctuation">.</span>mybatisplus<span class="token punctuation">.</span>bean<span class="token punctuation">.</span></span><span class="token class-name">Product</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">iceriver<span class="token punctuation">.</span>mybatisplus<span class="token punctuation">.</span>mapper<span class="token punctuation">.</span></span><span class="token class-name">ProductMapper</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">org<span class="token punctuation">.</span>junit<span class="token punctuation">.</span>jupiter<span class="token punctuation">.</span>api<span class="token punctuation">.</span></span><span class="token class-name">Test</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">org<span class="token punctuation">.</span>springframework<span class="token punctuation">.</span>beans<span class="token punctuation">.</span>factory<span class="token punctuation">.</span>annotation<span class="token punctuation">.</span></span><span class="token class-name">Autowired</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">org<span class="token punctuation">.</span>springframework<span class="token punctuation">.</span>boot<span class="token punctuation">.</span>test<span class="token punctuation">.</span>context<span class="token punctuation">.</span></span><span class="token class-name">SpringBootTest</span></span><span class="token punctuation">;</span>

<span class="token doc-comment comment">/**
 * <span class="token keyword">@author</span>: INFINITY https://developer.aliyun.com/profile/sagwrxp2ua66w
 * <span class="token keyword">@date</span>: 2022/8/5 14:49
 */</span>
<span class="token annotation punctuation">@SpringBootTest</span>
<span class="token keyword">public</span> <span class="token keyword">class</span> <span class="token class-name">ProductMapperTests</span> <span class="token punctuation">{</span>
    <span class="token annotation punctuation">@Autowired</span>
    <span class="token keyword">private</span> <span class="token class-name">ProductMapper</span> productMapper<span class="token punctuation">;</span>
    <span class="token annotation punctuation">@Test</span>
    <span class="token keyword">public</span> <span class="token keyword">void</span>  <span class="token function">test02</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">{</span>
        <span class="token comment">//1. 小李查询商品价格</span>
        <span class="token class-name">Product</span> productL <span class="token operator">=</span> productMapper<span class="token punctuation">.</span><span class="token function">selectById</span><span class="token punctuation">(</span><span class="token number">1</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span><span class="token string">"小李查询的商品价格"</span> <span class="token operator">+</span> productL<span class="token punctuation">.</span><span class="token function">getPrice</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token comment">//2. 小王查询商品价格</span>
        <span class="token class-name">Product</span> productW <span class="token operator">=</span> productMapper<span class="token punctuation">.</span><span class="token function">selectById</span><span class="token punctuation">(</span><span class="token number">1</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span><span class="token string">"小王查询的商品价格"</span> <span class="token operator">+</span> productW<span class="token punctuation">.</span><span class="token function">getPrice</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span><span class="token string">"----------修改价格前------------"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token comment">//3. 小李对商品价格+50</span>
        productL<span class="token punctuation">.</span><span class="token function">setPrice</span><span class="token punctuation">(</span>productL<span class="token punctuation">.</span><span class="token function">getPrice</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token operator">+</span> <span class="token number">50</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        productMapper<span class="token punctuation">.</span><span class="token function">updateById</span><span class="token punctuation">(</span>productL<span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token comment">//4. 小王对商品价格-30</span>
        <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span><span class="token string">"小王查询的商品价格"</span> <span class="token operator">+</span> productW<span class="token punctuation">.</span><span class="token function">getPrice</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        productW<span class="token punctuation">.</span><span class="token function">setPrice</span><span class="token punctuation">(</span>productW<span class="token punctuation">.</span><span class="token function">getPrice</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token operator">-</span> <span class="token number">30</span><span class="token punctuation">)</span><span class="token punctuation">;</span>

        <span class="token keyword">int</span> result <span class="token operator">=</span> productMapper<span class="token punctuation">.</span><span class="token function">updateById</span><span class="token punctuation">(</span>productW<span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token keyword">if</span><span class="token punctuation">(</span>result <span class="token operator">==</span> <span class="token number">0</span><span class="token punctuation">)</span><span class="token punctuation">{</span>
            <span class="token class-name">Product</span> product <span class="token operator">=</span> productMapper<span class="token punctuation">.</span><span class="token function">selectById</span><span class="token punctuation">(</span><span class="token number">1</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
            product<span class="token punctuation">.</span><span class="token function">setPrice</span><span class="token punctuation">(</span>product<span class="token punctuation">.</span><span class="token function">getPrice</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token operator">-</span> <span class="token number">30</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
            productMapper<span class="token punctuation">.</span><span class="token function">updateById</span><span class="token punctuation">(</span>product<span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token punctuation">}</span>

        productMapper<span class="token punctuation">.</span><span class="token function">updateById</span><span class="token punctuation">(</span>productL<span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span><span class="token string">"----------修改价格后------------"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token comment">//5. 老板检查价格</span>
        <span class="token class-name">Product</span> productB <span class="token operator">=</span> productMapper<span class="token punctuation">.</span><span class="token function">selectById</span><span class="token punctuation">(</span><span class="token number">1</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span><span class="token string">"老板查询的商品价格"</span> <span class="token operator">+</span> productB<span class="token punctuation">.</span><span class="token function">getPrice</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token punctuation">}</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><h2 id="第6章-扩展" tabindex="-1"><a class="header-anchor" href="#第6章-扩展" aria-hidden="true">#</a> 第6章 扩展</h2>
<h3 id="_6-1-通用枚举" tabindex="-1"><a class="header-anchor" href="#_6-1-通用枚举" aria-hidden="true">#</a> 6.1 通用枚举</h3>
<ol>
<li>user数据表添加sex字段，用整数1、2表示男、女</li>
<li>User实体类定义SexEnum类型的属性sex</li>
<li>创建SexEunm的枚举类，定义属性sex和sexNmae，并用@EnumValue注解标识sex属性</li>
<li>在springboot核心配置文件中开启通用枚举扫描：<code v-pre>mybatis-plus:.typeEnumsPackage: iceriver.mybatisplus.enums</code></li>
</ol>
<h3 id="_6-2-代码生成器" tabindex="-1"><a class="header-anchor" href="#_6-2-代码生成器" aria-hidden="true">#</a> 6.2 代码生成器</h3>
<p>与mybatis中的逆向工程插件类似，不过mybatis的逆向工程只能生成实体类、dao层mappper和mapper映射文件。
而mybatis-plus可以生成上述文件外，还能生成controller和service及serviceimpl</p>
<ol>
<li>创建新模块
<ul>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1659692726829-c1cf2bb3-96b5-4f6e-ac2c-79ee2a1fcd75.png#clientId=uaf8d940b-efc7-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=625&amp;id=ua7120a9b&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=625&amp;originWidth=721&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=56205&amp;status=done&amp;style=none&amp;taskId=u9a7f8d5e-5a54-448e-997f-9c5848d34b0&amp;title=&amp;width=721" alt="image.png" loading="lazy"></li>
</ul>
</li>
<li>添加依赖：mybatis-plus-generator和freemarker</li>
</ol>
<div class="language-xml ext-xml line-numbers-mode"><pre v-pre class="language-xml"><code><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>dependency</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>groupId</span><span class="token punctuation">></span></span>com.baomidou<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>groupId</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>artifactId</span><span class="token punctuation">></span></span>mybatis-plus-generator<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>artifactId</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>version</span><span class="token punctuation">></span></span>3.5.1<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>version</span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>dependency</span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>dependency</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>groupId</span><span class="token punctuation">></span></span>org.freemarker<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>groupId</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>artifactId</span><span class="token punctuation">></span></span>freemarker<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>artifactId</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>version</span><span class="token punctuation">></span></span>2.3.31<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>version</span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>dependency</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ol start="3">
<li>创建测试类，执行main方法</li>
</ol>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token keyword">package</span> <span class="token namespace">iceriver<span class="token punctuation">.</span>mybatisplus</span><span class="token punctuation">;</span>

<span class="token keyword">import</span> <span class="token import"><span class="token namespace">com<span class="token punctuation">.</span>baomidou<span class="token punctuation">.</span>mybatisplus<span class="token punctuation">.</span>generator<span class="token punctuation">.</span></span><span class="token class-name">FastAutoGenerator</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">com<span class="token punctuation">.</span>baomidou<span class="token punctuation">.</span>mybatisplus<span class="token punctuation">.</span>generator<span class="token punctuation">.</span>config<span class="token punctuation">.</span></span><span class="token class-name">OutputFile</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">com<span class="token punctuation">.</span>baomidou<span class="token punctuation">.</span>mybatisplus<span class="token punctuation">.</span>generator<span class="token punctuation">.</span>engine<span class="token punctuation">.</span></span><span class="token class-name">FreemarkerTemplateEngine</span></span><span class="token punctuation">;</span>

<span class="token keyword">import</span> <span class="token import"><span class="token namespace">java<span class="token punctuation">.</span>util<span class="token punctuation">.</span></span><span class="token class-name">Collections</span></span><span class="token punctuation">;</span>

<span class="token doc-comment comment">/**
* <span class="token keyword">@author</span>: INFINITY https://developer.aliyun.com/profile/sagwrxp2ua66w
* <span class="token keyword">@date</span>: 2022/8/5 17:54
*/</span>
<span class="token keyword">public</span> <span class="token keyword">class</span> <span class="token class-name">FastAutoGeneratorTest</span> <span class="token punctuation">{</span>
    <span class="token keyword">public</span> <span class="token keyword">static</span> <span class="token keyword">void</span> <span class="token function">main</span><span class="token punctuation">(</span><span class="token class-name">String</span><span class="token punctuation">[</span><span class="token punctuation">]</span> args<span class="token punctuation">)</span> <span class="token punctuation">{</span>
        <span class="token class-name">FastAutoGenerator</span><span class="token punctuation">.</span><span class="token function">create</span><span class="token punctuation">(</span><span class="token string">"jdbc:mysql://127.0.0.1:13306/mybatis_plus?characterEncoding=utf-8&amp;userSSL=false"</span><span class="token punctuation">,</span> <span class="token string">"root"</span><span class="token punctuation">,</span> <span class="token string">"dimitre123"</span><span class="token punctuation">)</span>
            <span class="token punctuation">.</span><span class="token function">globalConfig</span><span class="token punctuation">(</span>builder <span class="token operator">-></span> <span class="token punctuation">{</span>
                builder<span class="token punctuation">.</span><span class="token function">author</span><span class="token punctuation">(</span><span class="token string">"zhuyuqi"</span><span class="token punctuation">)</span> <span class="token comment">// 设置作者</span>
                    <span class="token comment">//.enableSwagger() // 开启 swagger 模式</span>
                    <span class="token punctuation">.</span><span class="token function">fileOverride</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token comment">// 覆盖已生成文件</span>
                    <span class="token punctuation">.</span><span class="token function">outputDir</span><span class="token punctuation">(</span><span class="token string">"D:\\PracticalExercise\\16.MyBatis-Plus\\plus04-generator\\mybatis_plus_generate_code"</span><span class="token punctuation">)</span><span class="token punctuation">;</span> <span class="token comment">// 指定输出目录</span>
            <span class="token punctuation">}</span><span class="token punctuation">)</span>
            <span class="token punctuation">.</span><span class="token function">packageConfig</span><span class="token punctuation">(</span>builder <span class="token operator">-></span> <span class="token punctuation">{</span>
                builder<span class="token punctuation">.</span><span class="token function">parent</span><span class="token punctuation">(</span><span class="token string">"iceriver"</span><span class="token punctuation">)</span> <span class="token comment">// 设置父包名</span>
                    <span class="token punctuation">.</span><span class="token function">moduleName</span><span class="token punctuation">(</span><span class="token string">"mybatisplus"</span><span class="token punctuation">)</span> <span class="token comment">// 设置父包模块名</span>
                    <span class="token punctuation">.</span><span class="token function">pathInfo</span><span class="token punctuation">(</span><span class="token class-name">Collections</span><span class="token punctuation">.</span><span class="token function">singletonMap</span><span class="token punctuation">(</span><span class="token class-name">OutputFile</span><span class="token punctuation">.</span>mapperXml<span class="token punctuation">,</span> <span class="token string">"D:\\PracticalExercise\\16.MyBatis-Plus\\plus04-generator\\mybatis_plus_generate_code"</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span> <span class="token comment">// 设置mapperXml生成路径</span>
            <span class="token punctuation">}</span><span class="token punctuation">)</span>
            <span class="token punctuation">.</span><span class="token function">strategyConfig</span><span class="token punctuation">(</span>builder <span class="token operator">-></span> <span class="token punctuation">{</span>
                builder<span class="token punctuation">.</span><span class="token function">addInclude</span><span class="token punctuation">(</span><span class="token string">"user"</span><span class="token punctuation">)</span> <span class="token comment">// 设置需要生成的表名</span>
                    <span class="token comment">//.addTablePrefix("t_", "c_")// 设置过滤表前缀</span>
                    <span class="token punctuation">;</span>
            <span class="token punctuation">}</span><span class="token punctuation">)</span>
            <span class="token punctuation">.</span><span class="token function">templateEngine</span><span class="token punctuation">(</span><span class="token keyword">new</span> <span class="token class-name">FreemarkerTemplateEngine</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span> <span class="token comment">// 使用Freemarker引擎模板，默认的是Velocity引擎模板</span>
            <span class="token punctuation">.</span><span class="token function">execute</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token punctuation">}</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><p><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1659693799119-ca200b6b-cc26-40c1-bae7-b13791d027ad.png#clientId=uaf8d940b-efc7-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=169&amp;id=u7a320ec9&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=169&amp;originWidth=1203&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=49404&amp;status=done&amp;style=none&amp;taskId=uf29dcb37-ff3d-439a-ac61-bea69b3b1a7&amp;title=&amp;width=1203" alt="image.png" loading="lazy">
<img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1659693808006-d5b47311-cee6-449b-8761-2f72a99df0a8.png#clientId=uaf8d940b-efc7-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=223&amp;id=ud35d298d&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=223&amp;originWidth=818&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=21285&amp;status=done&amp;style=none&amp;taskId=u9384fe84-dede-4138-8032-33a61a66338&amp;title=&amp;width=818" alt="image.png" loading="lazy"></p>
<h3 id="_6-3-多数据源" tabindex="-1"><a class="header-anchor" href="#_6-3-多数据源" aria-hidden="true">#</a> 6.3 多数据源</h3>
<ol>
<li>使用场景：表分散在多库、读写分离、一主多从、混合模式</li>
<li>创建数据库及表：
<ul>
<li>第一个使用mybatis_plus库、user表</li>
<li>第二个使用mybatis_plus_01库、product表</li>
</ul>
</li>
<li>新建模块
<ul>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1659694450169-6b20f6b2-bc65-4582-aa1a-2d00cda08215.png#clientId=uaf8d940b-efc7-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=625&amp;id=u45402167&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=625&amp;originWidth=721&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=56463&amp;status=done&amp;style=none&amp;taskId=u8fd3063e-b8b0-48d7-b207-fc9d0c28bfd&amp;title=&amp;width=721" alt="image.png" loading="lazy"></li>
</ul>
</li>
<li>引入依赖：mybaitis-plus、lombok、mysql、dynamic-datasource-spring-boot-starter</li>
</ol>
<div class="language-xml ext-xml line-numbers-mode"><pre v-pre class="language-xml"><code><span class="token prolog">&lt;?xml version="1.0" encoding="UTF-8"?></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>project</span> <span class="token attr-name">xmlns</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>http://maven.apache.org/POM/4.0.0<span class="token punctuation">"</span></span> <span class="token attr-name"><span class="token namespace">xmlns:</span>xsi</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>http://www.w3.org/2001/XMLSchema-instance<span class="token punctuation">"</span></span>
         <span class="token attr-name"><span class="token namespace">xsi:</span>schemaLocation</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>modelVersion</span><span class="token punctuation">></span></span>4.0.0<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>modelVersion</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>parent</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>groupId</span><span class="token punctuation">></span></span>org.springframework.boot<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>groupId</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>artifactId</span><span class="token punctuation">></span></span>spring-boot-starter-parent<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>artifactId</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>version</span><span class="token punctuation">></span></span>2.7.2<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>version</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>relativePath</span><span class="token punctuation">/></span></span> <span class="token comment">&lt;!-- lookup parent from repository --></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>parent</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>groupId</span><span class="token punctuation">></span></span>iceriver.mybatisplus<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>groupId</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>artifactId</span><span class="token punctuation">></span></span>plus05-datasources<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>artifactId</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>version</span><span class="token punctuation">></span></span>0.0.1-SNAPSHOT<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>version</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>name</span><span class="token punctuation">></span></span>plus05-datasources<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>name</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>description</span><span class="token punctuation">></span></span>plus05-datasources<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>description</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>properties</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>java.version</span><span class="token punctuation">></span></span>1.8<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>java.version</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>properties</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>dependencies</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>dependency</span><span class="token punctuation">></span></span>
      <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>groupId</span><span class="token punctuation">></span></span>org.springframework.boot<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>groupId</span><span class="token punctuation">></span></span>
      <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>artifactId</span><span class="token punctuation">></span></span>spring-boot-starter<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>artifactId</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>dependency</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>dependency</span><span class="token punctuation">></span></span>
      <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>groupId</span><span class="token punctuation">></span></span>org.springframework.boot<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>groupId</span><span class="token punctuation">></span></span>
      <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>artifactId</span><span class="token punctuation">></span></span>spring-boot-starter-test<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>artifactId</span><span class="token punctuation">></span></span>
      <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>scope</span><span class="token punctuation">></span></span>test<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>scope</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>dependency</span><span class="token punctuation">></span></span>
    
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>dependency</span><span class="token punctuation">></span></span>
      <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>groupId</span><span class="token punctuation">></span></span>mysql<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>groupId</span><span class="token punctuation">></span></span>
      <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>artifactId</span><span class="token punctuation">></span></span>mysql-connector-java<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>artifactId</span><span class="token punctuation">></span></span>
      <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>scope</span><span class="token punctuation">></span></span>runtime<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>scope</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>dependency</span><span class="token punctuation">></span></span>
    
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>dependency</span><span class="token punctuation">></span></span>
      <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>groupId</span><span class="token punctuation">></span></span>org.projectlombok<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>groupId</span><span class="token punctuation">></span></span>
      <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>artifactId</span><span class="token punctuation">></span></span>lombok<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>artifactId</span><span class="token punctuation">></span></span>
      <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>optional</span><span class="token punctuation">></span></span>true<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>optional</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>dependency</span><span class="token punctuation">></span></span>
    
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>dependency</span><span class="token punctuation">></span></span>
      <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>groupId</span><span class="token punctuation">></span></span>com.baomidou<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>groupId</span><span class="token punctuation">></span></span>
      <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>artifactId</span><span class="token punctuation">></span></span>mybatis-plus-boot-starter<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>artifactId</span><span class="token punctuation">></span></span>
      <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>version</span><span class="token punctuation">></span></span>3.5.1<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>version</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>dependency</span><span class="token punctuation">></span></span>
    
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>dependency</span><span class="token punctuation">></span></span>
      <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>groupId</span><span class="token punctuation">></span></span>com.baomidou<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>groupId</span><span class="token punctuation">></span></span>
      <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>artifactId</span><span class="token punctuation">></span></span>dynamic-datasource-spring-boot-starter<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>artifactId</span><span class="token punctuation">></span></span>
      <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>version</span><span class="token punctuation">></span></span>3.5.0<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>version</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>dependency</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>dependencies</span><span class="token punctuation">></span></span>
  
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>build</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>plugins</span><span class="token punctuation">></span></span>
      <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>plugin</span><span class="token punctuation">></span></span>
        <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>groupId</span><span class="token punctuation">></span></span>org.springframework.boot<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>groupId</span><span class="token punctuation">></span></span>
        <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>artifactId</span><span class="token punctuation">></span></span>spring-boot-maven-plugin<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>artifactId</span><span class="token punctuation">></span></span>
      <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>plugin</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>plugins</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>build</span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>project</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ol start="4">
<li>在springboot核心配置文件中添加多数据源</li>
</ol>
<div class="language-xml ext-xml line-numbers-mode"><pre v-pre class="language-xml"><code>spring:
  # 配置数据源信息
  datasource:
    dynamic:
      # 设置默认的数据源或者数据源组,默认值即为master
      primary: master
      # 严格匹配数据源,默认false.true未匹配到指定数据源时抛异常,false使用默认数据源
      strict: false
      datasource:
        master:
          url: jdbc:mysql://localhost:13306/mybatis_plus?characterEncoding=utf-8&amp;useSSL=false
          driver-class-name: com.mysql.cj.jdbc.Driver
          username: root
          password: dimitre123
        slave_1:
          url: jdbc:mysql://localhost:13306/mybatis_plus_01?characterEncoding=utf-8&amp;useSSL=false
          driver-class-name: com.mysql.cj.jdbc.Driver
          username: root
          password: dimitre123
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ol start="5">
<li>创建相关的实体类、service、mapper
<ul>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1659696078093-f2b62834-e06b-4cf1-8ac4-841bab7b4325.png#clientId=uaf8d940b-efc7-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=340&amp;id=u99f0df0b&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=340&amp;originWidth=357&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=23766&amp;status=done&amp;style=none&amp;taskId=uda14ce1a-d79f-4962-8805-118adc7b8f7&amp;title=&amp;width=357" alt="image.png" loading="lazy"></li>
<li>UserServiceImpl使用@DS(&quot;master&quot;)指定为主数据源</li>
<li>ProductServiceImpl使用@DS(&quot;master&quot;)指定为主数据源</li>
</ul>
</li>
<li>执行测试</li>
</ol>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token keyword">package</span> <span class="token namespace">iceriver<span class="token punctuation">.</span>mybatisplus</span><span class="token punctuation">;</span>

<span class="token keyword">import</span> <span class="token import"><span class="token namespace">iceriver<span class="token punctuation">.</span>mybatisplus<span class="token punctuation">.</span>bean<span class="token punctuation">.</span></span><span class="token class-name">Product</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">iceriver<span class="token punctuation">.</span>mybatisplus<span class="token punctuation">.</span>mapper<span class="token punctuation">.</span></span><span class="token class-name">ProductMapper</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">iceriver<span class="token punctuation">.</span>mybatisplus<span class="token punctuation">.</span>mapper<span class="token punctuation">.</span></span><span class="token class-name">UserMapper</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">iceriver<span class="token punctuation">.</span>mybatisplus<span class="token punctuation">.</span>service<span class="token punctuation">.</span></span><span class="token class-name">ProductService</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">iceriver<span class="token punctuation">.</span>mybatisplus<span class="token punctuation">.</span>service<span class="token punctuation">.</span></span><span class="token class-name">UserService</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">org<span class="token punctuation">.</span>junit<span class="token punctuation">.</span>jupiter<span class="token punctuation">.</span>api<span class="token punctuation">.</span></span><span class="token class-name">Test</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">org<span class="token punctuation">.</span>springframework<span class="token punctuation">.</span>beans<span class="token punctuation">.</span>factory<span class="token punctuation">.</span>annotation<span class="token punctuation">.</span></span><span class="token class-name">Autowired</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">org<span class="token punctuation">.</span>springframework<span class="token punctuation">.</span>boot<span class="token punctuation">.</span>test<span class="token punctuation">.</span>context<span class="token punctuation">.</span></span><span class="token class-name">SpringBootTest</span></span><span class="token punctuation">;</span>

<span class="token annotation punctuation">@SpringBootTest</span>
<span class="token keyword">class</span> <span class="token class-name">Plus05DatasourcesApplicationTests</span> <span class="token punctuation">{</span>
    <span class="token annotation punctuation">@Autowired</span>
    <span class="token keyword">private</span> <span class="token class-name">UserService</span> userService<span class="token punctuation">;</span>
    <span class="token annotation punctuation">@Autowired</span>
    <span class="token keyword">private</span> <span class="token class-name">ProductService</span> productService<span class="token punctuation">;</span>
    <span class="token annotation punctuation">@Test</span>
    <span class="token keyword">public</span> <span class="token keyword">void</span> <span class="token function">test</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">{</span>
        <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span>userService<span class="token punctuation">.</span><span class="token function">getById</span><span class="token punctuation">(</span><span class="token number">1</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span>productService<span class="token punctuation">.</span><span class="token function">getById</span><span class="token punctuation">(</span><span class="token number">1</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token punctuation">}</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><h3 id="_6-4-mybatisx插件" tabindex="-1"><a class="header-anchor" href="#_6-4-mybatisx插件" aria-hidden="true">#</a> 6.4 MyBatisX插件</h3>
<h4 id="_6-4-1-基本介绍" tabindex="-1"><a class="header-anchor" href="#_6-4-1-基本介绍" aria-hidden="true">#</a> 6.4.1 基本介绍</h4>
<ol>
<li>MyBatis-Plus为我们提供了强大的mapper和service模板，能够大大的提高开发效率但是在真正开发过程中，MyBatis-Plus并不能为我们解决所有问题，例如一些复杂的SQL，多表联查，我们就需要自己去编写代码和SQL语句，我们该如何快速的解决这个问题呢，这个时候可以使用MyBatisX插件</li>
<li>MyBatisX一款基于 IDEA 的快速开发插件，为效率而生</li>
<li></li>
<li>安装插件
<ul>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1659697674802-0561f33f-814a-4a87-920d-acd401cc883c.png#clientId=uaf8d940b-efc7-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=121&amp;id=ud4e29187&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=121&amp;originWidth=328&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=8815&amp;status=done&amp;style=none&amp;taskId=ufb1e8160-ec90-45dc-8214-2ba4dc0aff2&amp;title=&amp;width=328" alt="image.png" loading="lazy"></li>
</ul>
</li>
<li>功能：
<ul>
<li>可以快速定位mapper类和映射文件
<ul>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1659698085186-165bfca0-d7c8-44a4-a2f5-809add46b886.png#clientId=uaf8d940b-efc7-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=67&amp;id=u023e5674&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=67&amp;originWidth=540&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=8933&amp;status=done&amp;style=none&amp;taskId=ubbe78765-073e-4f05-83c9-e3e859ca89f&amp;title=&amp;width=540" alt="image.png" loading="lazy"></li>
</ul>
</li>
<li>代替本文6.2代码生成器<a href="#W0v7A">https://www.yuque.com/zhuyuqi/zna9x5/hientp#W0v7A</a>，并可视化操作生成过程。</li>
<li>快速生成自定义curd方法</li>
</ul>
</li>
<li>mapper映射文件的路径设置参见本文2.1.2第1点设置mapper文件路径<a href="#JebDR">https://www.yuque.com/zhuyuqi/zna9x5/hientp#JebDR</a></li>
</ol>
<h4 id="_6-4-2-mybatisx快速代码生成" tabindex="-1"><a class="header-anchor" href="#_6-4-2-mybatisx快速代码生成" aria-hidden="true">#</a> 6.4.2 mybatisx快速代码生成</h4>
<ol>
<li>创建模块：
<ul>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1659698197863-31f3a3bc-7002-4f7e-af86-e36f45a95a38.png#clientId=uaf8d940b-efc7-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=625&amp;id=u2f34ec6f&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=625&amp;originWidth=721&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=56080&amp;status=done&amp;style=none&amp;taskId=u86cf2be1-2ebd-4c26-a69b-ab1ecfc9134&amp;title=&amp;width=721" alt="image.png" loading="lazy"></li>
</ul>
</li>
<li>引入依赖：mybaitis-plus、lombok、mysql</li>
</ol>
<div class="language-xml ext-xml line-numbers-mode"><pre v-pre class="language-xml"><code><span class="token prolog">&lt;?xml version="1.0" encoding="UTF-8"?></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>project</span> <span class="token attr-name">xmlns</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>http://maven.apache.org/POM/4.0.0<span class="token punctuation">"</span></span> <span class="token attr-name"><span class="token namespace">xmlns:</span>xsi</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>http://www.w3.org/2001/XMLSchema-instance<span class="token punctuation">"</span></span>
         <span class="token attr-name"><span class="token namespace">xsi:</span>schemaLocation</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>modelVersion</span><span class="token punctuation">></span></span>4.0.0<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>modelVersion</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>parent</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>groupId</span><span class="token punctuation">></span></span>org.springframework.boot<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>groupId</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>artifactId</span><span class="token punctuation">></span></span>spring-boot-starter-parent<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>artifactId</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>version</span><span class="token punctuation">></span></span>2.7.2<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>version</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>relativePath</span><span class="token punctuation">/></span></span> <span class="token comment">&lt;!-- lookup parent from repository --></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>parent</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>groupId</span><span class="token punctuation">></span></span>iceriver.mybatisplus<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>groupId</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>artifactId</span><span class="token punctuation">></span></span>plus06-mybatisx<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>artifactId</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>version</span><span class="token punctuation">></span></span>0.0.1-SNAPSHOT<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>version</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>name</span><span class="token punctuation">></span></span>plus06-mybatisx<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>name</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>description</span><span class="token punctuation">></span></span>plus06-mybatisx<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>description</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>properties</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>java.version</span><span class="token punctuation">></span></span>1.8<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>java.version</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>properties</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>dependencies</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>dependency</span><span class="token punctuation">></span></span>
      <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>groupId</span><span class="token punctuation">></span></span>org.springframework.boot<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>groupId</span><span class="token punctuation">></span></span>
      <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>artifactId</span><span class="token punctuation">></span></span>spring-boot-starter<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>artifactId</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>dependency</span><span class="token punctuation">></span></span>
    
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>dependency</span><span class="token punctuation">></span></span>
      <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>groupId</span><span class="token punctuation">></span></span>org.springframework.boot<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>groupId</span><span class="token punctuation">></span></span>
      <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>artifactId</span><span class="token punctuation">></span></span>spring-boot-starter-test<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>artifactId</span><span class="token punctuation">></span></span>
      <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>scope</span><span class="token punctuation">></span></span>test<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>scope</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>dependency</span><span class="token punctuation">></span></span>
    
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>dependency</span><span class="token punctuation">></span></span>
      <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>groupId</span><span class="token punctuation">></span></span>mysql<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>groupId</span><span class="token punctuation">></span></span>
      <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>artifactId</span><span class="token punctuation">></span></span>mysql-connector-java<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>artifactId</span><span class="token punctuation">></span></span>
      <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>scope</span><span class="token punctuation">></span></span>runtime<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>scope</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>dependency</span><span class="token punctuation">></span></span>
    
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>dependency</span><span class="token punctuation">></span></span>
      <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>groupId</span><span class="token punctuation">></span></span>org.projectlombok<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>groupId</span><span class="token punctuation">></span></span>
      <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>artifactId</span><span class="token punctuation">></span></span>lombok<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>artifactId</span><span class="token punctuation">></span></span>
      <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>optional</span><span class="token punctuation">></span></span>true<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>optional</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>dependency</span><span class="token punctuation">></span></span>
    
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>dependency</span><span class="token punctuation">></span></span>
      <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>groupId</span><span class="token punctuation">></span></span>com.baomidou<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>groupId</span><span class="token punctuation">></span></span>
      <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>artifactId</span><span class="token punctuation">></span></span>mybatis-plus-boot-starter<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>artifactId</span><span class="token punctuation">></span></span>
      <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>version</span><span class="token punctuation">></span></span>3.5.1<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>version</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>dependency</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>dependencies</span><span class="token punctuation">></span></span>
  
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>build</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>plugins</span><span class="token punctuation">></span></span>
      <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>plugin</span><span class="token punctuation">></span></span>
        <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>groupId</span><span class="token punctuation">></span></span>org.springframework.boot<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>groupId</span><span class="token punctuation">></span></span>
        <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>artifactId</span><span class="token punctuation">></span></span>spring-boot-maven-plugin<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>artifactId</span><span class="token punctuation">></span></span>
      <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>plugin</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>plugins</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>build</span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>project</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ol start="3">
<li>applicaiton.yml核心配置文件中配置数据源</li>
</ol>
<div class="language-xml ext-xml line-numbers-mode"><pre v-pre class="language-xml"><code>spring:
  # 配置数据源信息
  datasource:
    type: com.zaxxer.hikari.HikariDataSource
    url: jdbc:mysql://localhost:13306/mybatis_plus?characterEncoding=utf-8&amp;useSSL=false
    driver-class-name: com.mysql.cj.jdbc.Driver
    username: root
    password: dimitre123
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ol start="4">
<li>在IDEA中连接数据库：
<ul>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1659698504507-bca089e9-1b4a-4e1a-8b14-db86216ee693.png#clientId=uaf8d940b-efc7-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=600&amp;id=udfa7ee93&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=600&amp;originWidth=738&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=82290&amp;status=done&amp;style=none&amp;taskId=u7fe7d4d7-74c4-4300-a7e5-8eb8d9c0456&amp;title=&amp;width=738" alt="image.png" loading="lazy"></li>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1659698597031-4d610d14-9e57-4e3b-a651-1b5fbdf699f1.png#clientId=uaf8d940b-efc7-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=677&amp;id=ub1dfb2c5&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=677&amp;originWidth=800&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=59930&amp;status=done&amp;style=none&amp;taskId=u2339b8f8-8679-4d5d-be6e-1a0d03a4d06&amp;title=&amp;width=800" alt="image.png" loading="lazy"></li>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1659698631044-9ba8daa9-bf24-4341-9570-e8b8085a5ca7.png#clientId=uaf8d940b-efc7-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=226&amp;id=u8ac6520a&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=226&amp;originWidth=646&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=20254&amp;status=done&amp;style=none&amp;taskId=u0a5c8f84-2caf-4703-bc9c-c0a5fa2b57f&amp;title=&amp;width=646" alt="image.png" loading="lazy"></li>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1659698799412-36fca1d5-c216-4eb7-a253-b9c61e83e971.png#clientId=uaf8d940b-efc7-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=471&amp;id=u2a57e47d&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=471&amp;originWidth=984&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=33281&amp;status=done&amp;style=none&amp;taskId=u3957b32d-daaf-4054-b14b-e1354bc5b7c&amp;title=&amp;width=984" alt="image.png" loading="lazy"></li>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1659698910002-5107fe40-9455-4054-8d2f-d70670347135.png#clientId=uaf8d940b-efc7-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=471&amp;id=u62af602b&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=471&amp;originWidth=1064&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=52643&amp;status=done&amp;style=none&amp;taskId=u8a1d4ac0-3148-46b0-a7dc-04d68a7c0b0&amp;title=&amp;width=1064" alt="image.png" loading="lazy"></li>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1659698964321-10a1b54d-026c-4d1b-b314-9e884b73b3f8.png#clientId=uaf8d940b-efc7-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=366&amp;id=ube9589aa&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=366&amp;originWidth=390&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=24077&amp;status=done&amp;style=none&amp;taskId=uc80dab8a-5ccd-4ac5-aaea-b7562a3aaec&amp;title=&amp;width=390" alt="image.png" loading="lazy"></li>
</ul>
</li>
</ol>
<h4 id="_6-4-3-自定义curd-快速生成xml中sql" tabindex="-1"><a class="header-anchor" href="#_6-4-3-自定义curd-快速生成xml中sql" aria-hidden="true">#</a> 6.4.3 自定义CURD（快速生成xml中sql）</h4>
<ol>
<li>以插入为例，输入insert，选择insertSelective
<ul>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1659699159924-b2e1f485-eeb8-4c1b-a14a-160b12db2088.png#clientId=uaf8d940b-efc7-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=212&amp;id=u33dc8b4c&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=212&amp;originWidth=612&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=40959&amp;status=done&amp;style=none&amp;taskId=u5efaca41-13f3-498b-a125-38167a67461&amp;title=&amp;width=612" alt="image.png" loading="lazy"></li>
</ul>
</li>
<li>按下alt+enter，选择第二个，会快速生成mapper方法和sql
<ul>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1659699220698-bcdf6049-edbd-4bf9-befe-63ba0a583d3d.png#clientId=uaf8d940b-efc7-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=144&amp;id=ua2c41f85&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=144&amp;originWidth=581&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=15991&amp;status=done&amp;style=none&amp;taskId=ud52bc66d-0146-464c-94e5-6fa3d1b740f&amp;title=&amp;width=581" alt="image.png" loading="lazy"></li>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1659699341541-94968d2c-8f73-4038-8d53-fc669bd298c9.png#clientId=uaf8d940b-efc7-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=392&amp;id=ucccadde2&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=392&amp;originWidth=584&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=27851&amp;status=done&amp;style=none&amp;taskId=ue28e4dcb-8278-4881-a6e9-bb0cc2da7be&amp;title=&amp;width=584" alt="image.png" loading="lazy"></li>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1659699466652-99dae616-42ca-4ee6-8eef-318f89ce45a5.png#clientId=uaf8d940b-efc7-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=77&amp;id=u5a73b0cf&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=77&amp;originWidth=495&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=10413&amp;status=done&amp;style=none&amp;taskId=u1f1d4078-d9bf-437e-a52c-85cfba8db7a&amp;title=&amp;width=495" alt="image.png" loading="lazy"></li>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1659699456180-1160fe93-8b5e-454f-a51e-9185f384eac3.png#clientId=uaf8d940b-efc7-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=431&amp;id=u032238ac&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=431&amp;originWidth=620&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=68626&amp;status=done&amp;style=none&amp;taskId=ud3e5986c-d337-4d82-8797-fb8b1ef464c&amp;title=&amp;width=620" alt="image.png" loading="lazy"></li>
</ul>
</li>
</ol>
</div></template>
