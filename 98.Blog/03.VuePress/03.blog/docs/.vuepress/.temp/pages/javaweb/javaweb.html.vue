<template><div><h1 id="javaweb" tabindex="-1"><a class="header-anchor" href="#javaweb" aria-hidden="true">#</a> JavaWeb</h1>
<blockquote>
<ul>
<li>
<p>JavaWeb 是指，所有通过 Java 语言编写可以通过浏览器访问的程序的总称，叫 JavaWeb。</p>
</li>
<li>
<p>JavaWeb 是基于请求和响应来开发的。</p>
</li>
</ul>
</blockquote>
<!-- > - ![](/images/javaweb/20181022211418240) -->
<blockquote>
<ul>
<li><img src="/images/javaweb/image.png" alt="image.png" loading="lazy"></li>
</ul>
</blockquote>
<h2 id="第1章-前端基础" tabindex="-1"><a class="header-anchor" href="#第1章-前端基础" aria-hidden="true">#</a> 第1章 前端基础</h2>
<blockquote>
<p>参见Wbe前端知识库：<a href="https://www.yuque.com/zhuyuqi/lfm0mh?view=doc_embed" target="_blank" rel="noopener noreferrer">Web前端<ExternalLinkIcon/></a></p>
</blockquote>
<p>关键知识点：</p>
<ol>
<li>
<p>表单提交后，数据未提交（发给服务器）的三种情况：</p>
<ul>
<li>表单标签没有name属性</li>
<li>单选、复选、下拉列表（<code v-pre>&lt;option&gt;</code>）都添加上value属性</li>
<li>表单标签没有放在<code v-pre>&lt;form&gt;</code>标签内</li>
<li>action属性不能带参数时，可以设计隐藏域<code v-pre>&lt;input type=&quot;hidden&quot;&gt;</code>使用</li>
</ul>
</li>
<li>
<p>GET 请求的特点是：</p>
<ul>
<li>浏览器地址栏中的地址是：action 属性[+?+请求参数]
<ul>
<li>请求参数的格式是：name=value&amp;name=value</li>
</ul>
</li>
<li>提交内容明文显示，不安全</li>
<li>它有数据长度的限制</li>
</ul>
</li>
<li>
<p>POST 请求的特点是：</p>
<ul>
<li>浏览器地址栏中只有 action 属性值</li>
<li>相对于 GET 请求要安全</li>
<li>理论上没有数据长度的限</li>
</ul>
</li>
<li>
<p>&amp;&amp;运算符：全为真时，返回最后一个表达式的值：</p>
<ul>
<li><code v-pre>alert(&quot;abc&quot;&amp;&amp;true)</code>，返回true</li>
<li><code v-pre>alert(true&amp;&amp;&quot;abc&quot;)</code>，返回abc</li>
</ul>
</li>
<li>
<p>&amp;&amp;运算符：全为假时，返回第一个表达式为假的值：</p>
<ul>
<li><code v-pre>alert(&quot;abc&quot;&amp;&amp;false)</code>，返回false</li>
</ul>
</li>
<li>
<p>|| 运算符：</p>
<ul>
<li>当表达式全为假时，返回最后一个表达式的值</li>
<li>只要有一个表达式为真，就会把回第一个为真的表达式的值</li>
</ul>
</li>
<li>
<p>js中变量未初始化，默认为undefined。</p>
</li>
<li>
<p>隐形参数arguments：</p>
<ul>
<li>js中定义函数时声明形参个数与调用时参数无关，即声明时不传参数，但调用可传入参数，或声明传入参数、调用不传入参数。</li>
<li>在函数内部使用arguments可以获取实际传入的参数个数，arguments是一个数组，可以遍历。</li>
<li>相当于定义函数时：<code v-pre>function(arguments)</code>，arguments是一个可变长参数</li>
</ul>
</li>
<li>
<p>表单验证不合法时阻止提交：本质——<code v-pre>onsubmit=&quot;return false&quot;</code></p>
</li>
</ol>
<div class="language-html ext-html line-numbers-mode"><pre v-pre class="language-html"><code><span class="token doctype"><span class="token punctuation">&lt;!</span><span class="token doctype-tag">DOCTYPE</span> <span class="token name">html</span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>html</span> <span class="token attr-name">lang</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>en<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>head</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>meta</span> <span class="token attr-name">charset</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>UTF-8<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>title</span><span class="token punctuation">></span></span>Title<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>title</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>script</span> <span class="token attr-name">type</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>text/javascript<span class="token punctuation">"</span></span> <span class="token punctuation">></span></span><span class="token script"><span class="token language-javascript">
      <span class="token comment">// 静态注册表单提交事务</span>
      <span class="token keyword">function</span> <span class="token function">onsubmitFun</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">{</span>
        <span class="token comment">// 要验证所有表单项是否合法，如果，有一个不合法就阻止表单提交</span>
        <span class="token function">alert</span><span class="token punctuation">(</span><span class="token string">"静态注册表单提交事件----发现不合法"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        
        <span class="token keyword">return</span> flase<span class="token punctuation">;</span>
      <span class="token punctuation">}</span>
      
      window<span class="token punctuation">.</span><span class="token function-variable function">onload</span> <span class="token operator">=</span> <span class="token keyword">function</span> <span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
        <span class="token comment">//1 获取标签对象</span>
        <span class="token keyword">var</span> formObj <span class="token operator">=</span> document<span class="token punctuation">.</span><span class="token function">getElementById</span><span class="token punctuation">(</span><span class="token string">"form01"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token comment">//2 通过标签对象.事件名 = function(){}</span>
        formObj<span class="token punctuation">.</span><span class="token function-variable function">onsubmit</span> <span class="token operator">=</span> <span class="token keyword">function</span> <span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
          <span class="token comment">// 要验证所有表单项是否合法，如果，有一个不合法就阻止表单提交</span>
          <span class="token function">alert</span><span class="token punctuation">(</span><span class="token string">"动态注册表单提交事件----发现不合法"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
          
          <span class="token keyword">return</span> <span class="token boolean">false</span><span class="token punctuation">;</span>
        <span class="token punctuation">}</span>
      <span class="token punctuation">}</span>
      
    </span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>script</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>head</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>body</span><span class="token punctuation">></span></span>
    <span class="token comment">&lt;!--return false 可以阻止 表单提交 --></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>form</span> <span class="token attr-name">action</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>http://localhost:8080<span class="token punctuation">"</span></span> <span class="token attr-name">method</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>get<span class="token punctuation">"</span></span> <span class="token special-attr"><span class="token attr-name">onsubmit</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span><span class="token value javascript language-javascript"><span class="token keyword">return</span> <span class="token function">onsubmitFun</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span></span><span class="token punctuation">"</span></span></span><span class="token punctuation">></span></span>
      <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>input</span> <span class="token attr-name">type</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>submit<span class="token punctuation">"</span></span> <span class="token attr-name">value</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>静态注册<span class="token punctuation">"</span></span><span class="token punctuation">/></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>form</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>form</span> <span class="token attr-name">action</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>http://localhost:8080<span class="token punctuation">"</span></span> <span class="token attr-name">id</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>form01<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
      <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>input</span> <span class="token attr-name">type</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>submit<span class="token punctuation">"</span></span> <span class="token attr-name">value</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>动态注册<span class="token punctuation">"</span></span><span class="token punctuation">/></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>form</span><span class="token punctuation">></span></span>
    
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>body</span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>html</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ol start="10">
<li>验证提示效果：</li>
</ol>
<div class="language-html ext-html line-numbers-mode"><pre v-pre class="language-html"><code><span class="token doctype"><span class="token punctuation">&lt;!</span><span class="token doctype-tag">DOCTYPE</span> <span class="token name">html</span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>html</span><span class="token punctuation">></span></span>
 <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>head</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>meta</span> <span class="token attr-name">charset</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>UTF-8<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>title</span><span class="token punctuation">></span></span>尚硅谷会员注册页面<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>title</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>link</span> <span class="token attr-name">type</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>text/css<span class="token punctuation">"</span></span> <span class="token attr-name">rel</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>stylesheet<span class="token punctuation">"</span></span> <span class="token attr-name">href</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>../../static/css/style.css<span class="token punctuation">"</span></span> <span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>script</span> <span class="token attr-name">type</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>text/javascript<span class="token punctuation">"</span></span> <span class="token attr-name">src</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>../../static/script/jquery-1.7.2.js<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token script"></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>script</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>script</span> <span class="token attr-name">type</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>text/javascript<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token script"><span class="token language-javascript">
   <span class="token comment">// 页面加载完成之后</span>
   <span class="token function">$</span><span class="token punctuation">(</span><span class="token keyword">function</span> <span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
    <span class="token comment">// 给注册绑定单击事件</span>
    <span class="token function">$</span><span class="token punctuation">(</span><span class="token string">"#sub_btn"</span><span class="token punctuation">)</span><span class="token punctuation">.</span><span class="token function">click</span><span class="token punctuation">(</span><span class="token keyword">function</span> <span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
     <span class="token comment">// 验证用户名：必须由字母，数字下划线组成，并且长度为5到12位</span>
     <span class="token comment">//1 获取用户名输入框里的内容</span>
     <span class="token keyword">var</span> usernameText <span class="token operator">=</span> <span class="token function">$</span><span class="token punctuation">(</span><span class="token string">"#username"</span><span class="token punctuation">)</span><span class="token punctuation">.</span><span class="token function">val</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
     <span class="token comment">//2 创建正则表达式对象</span>
     <span class="token keyword">var</span> usernamePatt <span class="token operator">=</span> <span class="token regex"><span class="token regex-delimiter">/</span><span class="token regex-source language-regex">^\w{5,12}$</span><span class="token regex-delimiter">/</span></span><span class="token punctuation">;</span>
     <span class="token comment">//3 使用test方法验证</span>
     <span class="token keyword">if</span> <span class="token punctuation">(</span><span class="token operator">!</span>usernamePatt<span class="token punctuation">.</span><span class="token function">test</span><span class="token punctuation">(</span>usernameText<span class="token punctuation">)</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
      <span class="token comment">//4 提示用户结果</span>
      <span class="token function">$</span><span class="token punctuation">(</span><span class="token string">"span.errorMsg"</span><span class="token punctuation">)</span><span class="token punctuation">.</span><span class="token function">text</span><span class="token punctuation">(</span><span class="token string">"用户名不合法！"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>

      <span class="token keyword">return</span> <span class="token boolean">false</span><span class="token punctuation">;</span>
     <span class="token punctuation">}</span>

     <span class="token comment">// 验证密码：必须由字母，数字下划线组成，并且长度为5到12位</span>
     <span class="token comment">//1 获取用户名输入框里的内容</span>
     <span class="token keyword">var</span> passwordText <span class="token operator">=</span> <span class="token function">$</span><span class="token punctuation">(</span><span class="token string">"#password"</span><span class="token punctuation">)</span><span class="token punctuation">.</span><span class="token function">val</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
     <span class="token comment">//2 创建正则表达式对象</span>
     <span class="token keyword">var</span> passwordPatt <span class="token operator">=</span> <span class="token regex"><span class="token regex-delimiter">/</span><span class="token regex-source language-regex">^\w{5,12}$</span><span class="token regex-delimiter">/</span></span><span class="token punctuation">;</span>
     <span class="token comment">//3 使用test方法验证</span>
     <span class="token keyword">if</span> <span class="token punctuation">(</span><span class="token operator">!</span>passwordPatt<span class="token punctuation">.</span><span class="token function">test</span><span class="token punctuation">(</span>passwordText<span class="token punctuation">)</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
      <span class="token comment">//4 提示用户结果</span>
      <span class="token function">$</span><span class="token punctuation">(</span><span class="token string">"span.errorMsg"</span><span class="token punctuation">)</span><span class="token punctuation">.</span><span class="token function">text</span><span class="token punctuation">(</span><span class="token string">"密码不合法！"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>

      <span class="token keyword">return</span> <span class="token boolean">false</span><span class="token punctuation">;</span>
     <span class="token punctuation">}</span>

     <span class="token comment">// 验证确认密码：和密码相同</span>
     <span class="token comment">//1 获取确认密码内容</span>
     <span class="token keyword">var</span> repwdText <span class="token operator">=</span> <span class="token function">$</span><span class="token punctuation">(</span><span class="token string">"#repwd"</span><span class="token punctuation">)</span><span class="token punctuation">.</span><span class="token function">val</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
     <span class="token comment">//2 和密码相比较</span>
     <span class="token keyword">if</span> <span class="token punctuation">(</span>repwdText <span class="token operator">!=</span> passwordText<span class="token punctuation">)</span> <span class="token punctuation">{</span>
      <span class="token comment">//3 提示用户</span>
      <span class="token function">$</span><span class="token punctuation">(</span><span class="token string">"span.errorMsg"</span><span class="token punctuation">)</span><span class="token punctuation">.</span><span class="token function">text</span><span class="token punctuation">(</span><span class="token string">"确认密码和密码不一致！"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>

      <span class="token keyword">return</span> <span class="token boolean">false</span><span class="token punctuation">;</span>
     <span class="token punctuation">}</span>

     <span class="token comment">// 邮箱验证：xxxxx@xxx.com</span>
     <span class="token comment">//1 获取邮箱里的内容</span>
     <span class="token keyword">var</span> emailText <span class="token operator">=</span> <span class="token function">$</span><span class="token punctuation">(</span><span class="token string">"#email"</span><span class="token punctuation">)</span><span class="token punctuation">.</span><span class="token function">val</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
     <span class="token comment">//2 创建正则表达式对象</span>
     <span class="token keyword">var</span> emailPatt <span class="token operator">=</span> <span class="token regex"><span class="token regex-delimiter">/</span><span class="token regex-source language-regex">^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$</span><span class="token regex-delimiter">/</span></span><span class="token punctuation">;</span>
     <span class="token comment">//3 使用test方法验证是否合法</span>
     <span class="token keyword">if</span> <span class="token punctuation">(</span><span class="token operator">!</span>emailPatt<span class="token punctuation">.</span><span class="token function">test</span><span class="token punctuation">(</span>emailText<span class="token punctuation">)</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
      <span class="token comment">//4 提示用户</span>
      <span class="token function">$</span><span class="token punctuation">(</span><span class="token string">"span.errorMsg"</span><span class="token punctuation">)</span><span class="token punctuation">.</span><span class="token function">text</span><span class="token punctuation">(</span><span class="token string">"邮箱格式不合法！"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>

      <span class="token keyword">return</span> <span class="token boolean">false</span><span class="token punctuation">;</span>
     <span class="token punctuation">}</span>

     <span class="token comment">// 验证码：现在只需要验证用户已输入。因为还没讲到服务器。验证码生成。</span>
     <span class="token keyword">var</span> codeText <span class="token operator">=</span> <span class="token function">$</span><span class="token punctuation">(</span><span class="token string">"#code"</span><span class="token punctuation">)</span><span class="token punctuation">.</span><span class="token function">val</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>

     <span class="token comment">//去掉验证码前后空格</span>
     <span class="token comment">// alert("去空格前：["+codeText+"]")</span>
     codeText <span class="token operator">=</span> $<span class="token punctuation">.</span><span class="token function">trim</span><span class="token punctuation">(</span>codeText<span class="token punctuation">)</span><span class="token punctuation">;</span>
     <span class="token comment">// alert("去空格后：["+codeText+"]")</span>

     <span class="token keyword">if</span> <span class="token punctuation">(</span>codeText <span class="token operator">==</span> <span class="token keyword">null</span> <span class="token operator">||</span> codeText <span class="token operator">==</span> <span class="token string">""</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
      <span class="token comment">//4 提示用户</span>
      <span class="token function">$</span><span class="token punctuation">(</span><span class="token string">"span.errorMsg"</span><span class="token punctuation">)</span><span class="token punctuation">.</span><span class="token function">text</span><span class="token punctuation">(</span><span class="token string">"验证码不能为空！"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>

      <span class="token keyword">return</span> <span class="token boolean">false</span><span class="token punctuation">;</span>
     <span class="token punctuation">}</span>

     <span class="token comment">// 去掉错误信息</span>
     <span class="token function">$</span><span class="token punctuation">(</span><span class="token string">"span.errorMsg"</span><span class="token punctuation">)</span><span class="token punctuation">.</span><span class="token function">text</span><span class="token punctuation">(</span><span class="token string">""</span><span class="token punctuation">)</span><span class="token punctuation">;</span>

    <span class="token punctuation">}</span><span class="token punctuation">)</span><span class="token punctuation">;</span>

   <span class="token punctuation">}</span><span class="token punctuation">)</span><span class="token punctuation">;</span>

  </span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>script</span><span class="token punctuation">></span></span>
 <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>style</span> <span class="token attr-name">type</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>text/css<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token style"><span class="token language-css">
  <span class="token selector">.login_form</span><span class="token punctuation">{</span>
   <span class="token property">height</span><span class="token punctuation">:</span>420px<span class="token punctuation">;</span>
   <span class="token property">margin-top</span><span class="token punctuation">:</span> 25px<span class="token punctuation">;</span>
  <span class="token punctuation">}</span>

 </span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>style</span><span class="token punctuation">></span></span>
 <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>head</span><span class="token punctuation">></span></span>
 <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>body</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>div</span> <span class="token attr-name">id</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>login_header<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
   <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>img</span> <span class="token attr-name">class</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>logo_img<span class="token punctuation">"</span></span> <span class="token attr-name">alt</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span><span class="token punctuation">"</span></span> <span class="token attr-name">src</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>../../static/img/logo.gif<span class="token punctuation">"</span></span> <span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>div</span><span class="token punctuation">></span></span>

   <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>div</span> <span class="token attr-name">class</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>login_banner<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>

    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>div</span> <span class="token attr-name">id</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>l_content<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
     <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>span</span> <span class="token attr-name">class</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>login_word<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>欢迎注册<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>span</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>div</span><span class="token punctuation">></span></span>

    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>div</span> <span class="token attr-name">id</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>content<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
     <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>div</span> <span class="token attr-name">class</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>login_form<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
      <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>div</span> <span class="token attr-name">class</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>login_box<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
       <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>div</span> <span class="token attr-name">class</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>tit<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
        <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>h1</span><span class="token punctuation">></span></span>注册尚硅谷会员<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>h1</span><span class="token punctuation">></span></span>
        <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>span</span> <span class="token attr-name">class</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>errorMsg<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>span</span><span class="token punctuation">></span></span>
       <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>div</span><span class="token punctuation">></span></span>
       <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>div</span> <span class="token attr-name">class</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>form<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
        <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>form</span> <span class="token attr-name">action</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>http://localhost:8080<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
         <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>label</span><span class="token punctuation">></span></span>用户名称：<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>label</span><span class="token punctuation">></span></span>
         <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>input</span> <span class="token attr-name">class</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>itxt<span class="token punctuation">"</span></span> <span class="token attr-name">type</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>text<span class="token punctuation">"</span></span> <span class="token attr-name">placeholder</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>请输入用户名<span class="token punctuation">"</span></span>
             <span class="token attr-name">autocomplete</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>off<span class="token punctuation">"</span></span> <span class="token attr-name">tabindex</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>1<span class="token punctuation">"</span></span> <span class="token attr-name">name</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>username<span class="token punctuation">"</span></span> <span class="token attr-name">id</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>username<span class="token punctuation">"</span></span> <span class="token punctuation">/></span></span>
         
         <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>label</span><span class="token punctuation">></span></span>用户密码：<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>label</span><span class="token punctuation">></span></span>
         <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>input</span> <span class="token attr-name">class</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>itxt<span class="token punctuation">"</span></span> <span class="token attr-name">type</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>password<span class="token punctuation">"</span></span> <span class="token attr-name">placeholder</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>请输入密码<span class="token punctuation">"</span></span>
             <span class="token attr-name">autocomplete</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>off<span class="token punctuation">"</span></span> <span class="token attr-name">tabindex</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>1<span class="token punctuation">"</span></span> <span class="token attr-name">name</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>password<span class="token punctuation">"</span></span> <span class="token attr-name">id</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>password<span class="token punctuation">"</span></span> <span class="token punctuation">/></span></span>
         
         <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>label</span><span class="token punctuation">></span></span>确认密码：<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>label</span><span class="token punctuation">></span></span>
         <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>input</span> <span class="token attr-name">class</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>itxt<span class="token punctuation">"</span></span> <span class="token attr-name">type</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>password<span class="token punctuation">"</span></span> <span class="token attr-name">placeholder</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>确认密码<span class="token punctuation">"</span></span>
             <span class="token attr-name">autocomplete</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>off<span class="token punctuation">"</span></span> <span class="token attr-name">tabindex</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>1<span class="token punctuation">"</span></span> <span class="token attr-name">name</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>repwd<span class="token punctuation">"</span></span> <span class="token attr-name">id</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>repwd<span class="token punctuation">"</span></span> <span class="token punctuation">/></span></span>
         
         <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>label</span><span class="token punctuation">></span></span>电子邮件：<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>label</span><span class="token punctuation">></span></span>
         <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>input</span> <span class="token attr-name">class</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>itxt<span class="token punctuation">"</span></span> <span class="token attr-name">type</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>text<span class="token punctuation">"</span></span> <span class="token attr-name">placeholder</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>请输入邮箱地址<span class="token punctuation">"</span></span>
             <span class="token attr-name">autocomplete</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>off<span class="token punctuation">"</span></span> <span class="token attr-name">tabindex</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>1<span class="token punctuation">"</span></span> <span class="token attr-name">name</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>email<span class="token punctuation">"</span></span> <span class="token attr-name">id</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>email<span class="token punctuation">"</span></span> <span class="token punctuation">/></span></span>
         
         <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>label</span><span class="token punctuation">></span></span>验证码：<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>label</span><span class="token punctuation">></span></span>
         <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>input</span> <span class="token attr-name">class</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>itxt<span class="token punctuation">"</span></span> <span class="token attr-name">type</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>text<span class="token punctuation">"</span></span> <span class="token special-attr"><span class="token attr-name">style</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span><span class="token value css language-css"><span class="token property">width</span><span class="token punctuation">:</span> 150px<span class="token punctuation">;</span></span><span class="token punctuation">"</span></span></span> <span class="token attr-name">id</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>code<span class="token punctuation">"</span></span><span class="token punctuation">/></span></span>
         <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>img</span> <span class="token attr-name">alt</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span><span class="token punctuation">"</span></span> <span class="token attr-name">src</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>../../static/img/code.bmp<span class="token punctuation">"</span></span> <span class="token special-attr"><span class="token attr-name">style</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span><span class="token value css language-css"><span class="token property">float</span><span class="token punctuation">:</span> right<span class="token punctuation">;</span> <span class="token property">margin-right</span><span class="token punctuation">:</span> 40px</span><span class="token punctuation">"</span></span></span><span class="token punctuation">></span></span>
         <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>input</span> <span class="token attr-name">type</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>submit<span class="token punctuation">"</span></span> <span class="token attr-name">value</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>注册<span class="token punctuation">"</span></span> <span class="token attr-name">id</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>sub_btn<span class="token punctuation">"</span></span> <span class="token punctuation">/></span></span>
        <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>form</span><span class="token punctuation">></span></span>
       <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>div</span><span class="token punctuation">></span></span>

      <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>div</span><span class="token punctuation">></span></span>
     <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>div</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>div</span><span class="token punctuation">></span></span>
   <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>div</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>div</span> <span class="token attr-name">id</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>bottom<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
   <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>span</span><span class="token punctuation">></span></span>
    尚硅谷书城.Copyright <span class="token entity named-entity" title="&copy;">&amp;copy;</span>2015
   <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>span</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>div</span><span class="token punctuation">></span></span>
 <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>body</span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>html</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ol start="11">
<li>正则表达式：</li>
</ol>
<p><a href="https://www.yuque.com/attachments/yuque/0/2022/txt/1604140/1656635437474-a756d548-72b5-4d16-a716-2b86802009db.txt" target="_blank" rel="noopener noreferrer">常用正则表达式.txt<ExternalLinkIcon/></a></p>
<ul>
<li><code v-pre>patt.test(str)</code>：验证str是否满足patt的规则。</li>
</ul>
<ol start="12">
<li><code v-pre>&lt;base&gt;</code>标签：</li>
</ol>
<ul>
<li>设置当前页面中所有相对路径的参照路径</li>
</ul>
<ol start="13">
<li>web中<code v-pre>/</code>的不同含义：代表绝对路径</li>
</ol>
<ul>
<li>浏览器解析：【<a href="http://ip:port/" target="_blank" rel="noopener noreferrer">http://ip:port/<ExternalLinkIcon/></a>】</li>
<li>服务器解析：【<a href="http://ip:port/" target="_blank" rel="noopener noreferrer">http://ip:port/<ExternalLinkIcon/></a>工程路径】
<ul>
<li>服务器重定向时（<code v-pre>response.sendRediect(&quot;/&quot;)</code>）：表示把<code v-pre>/</code>发送给浏览器解析，得到的是【<code v-pre>&lt;http://ip:port/&gt;</code>】</li>
</ul>
</li>
</ul>
<h2 id="第2章-bs和cs" tabindex="-1"><a class="header-anchor" href="#第2章-bs和cs" aria-hidden="true">#</a> 第2章 BS和CS</h2>
<h3 id="_2-1-bs" tabindex="-1"><a class="header-anchor" href="#_2-1-bs" aria-hidden="true">#</a> 2.1 BS</h3>
<ol>
<li>浏览器服务器架构模式
<ul>
<li>优点：客户端不需要安装，升级维护成本较低</li>
<li>缺点：所有计算和存储都放在服务器端，服务器计算完成后将结果传输给客户端，服务器符合较重，且客户端与服务器端会进行非常频繁的数据通信，导致网络负荷较重。</li>
</ul>
</li>
</ol>
<h3 id="_2-2-cs" tabindex="-1"><a class="header-anchor" href="#_2-2-cs" aria-hidden="true">#</a> 2.2 CS</h3>
<ol>
<li>客户端服务器架构模式
<ul>
<li>优点：充分来利用客户端机器资源，减轻服务器的负荷。
<ul>
<li>一部分安全要求不高的计算任务、存储任务放在客户端执行，减轻服务器的压力，也减轻网络负荷。</li>
</ul>
</li>
<li>缺点：需要安装客户端程序，且升级维护成本较高。</li>
</ul>
</li>
</ol>
<h2 id="第3章-tomcat的使用" tabindex="-1"><a class="header-anchor" href="#第3章-tomcat的使用" aria-hidden="true">#</a> 第3章 Tomcat的使用</h2>
<h3 id="_3-1-tomcat简介" tabindex="-1"><a class="header-anchor" href="#_3-1-tomcat简介" aria-hidden="true">#</a> 3.1 Tomcat简介</h3>
<ol>
<li>
<p>Tomcat 服务器是一个免费的开放源代码的Web 应用服务器，属于轻量级应用服务器，在中小型系统和并发访问用户不是很多的场合下被普遍使用，是开发和调试JSP 程序的首选。</p>
</li>
<li>
<p>java官方提供。</p>
</li>
<li>
<h2 id="版本" tabindex="-1"><a class="header-anchor" href="#版本" aria-hidden="true">#</a> 版本</h2>
<ul>
<li><img src="/images/javaweb/image-1660813756160.png" alt="image.png" loading="lazy"></li>
</ul>
</li>
<li>
<p>import包时，tomcat8和tomcat10的包名不一样</p>
</li>
</ol>
<h3 id="_3-2-tomcat使用" tabindex="-1"><a class="header-anchor" href="#_3-2-tomcat使用" aria-hidden="true">#</a> 3.2 Tomcat使用</h3>
<ol>
<li>下载：
<ul>
<li>使用JDK8开发，本文下载了Tomcat8.5版本。</li>
<li><img src="/images/javaweb/image-1660813758818.png" alt="image.png" loading="lazy"></li>
</ul>
</li>
<li>安装：解压至非中文、无空格、特殊字符路径下。</li>
<li>目录介绍：
<ul>
<li><img src="/images/javaweb/image-1660813764793.png" alt="image.png" loading="lazy"></li>
<li>
<ul>
<li>bin：程序运行文件夹</li>
<li>lib：程序运行的依赖库</li>
<li>conf：配置文件</li>
<li>logs：运行日志</li>
<li>temp：缓存文件目录</li>
<li>webapps：项目布署目录</li>
<li>work：工作目录</li>
</ul>
</li>
</ul>
</li>
<li>配置环境变量：
<ul>
<li>前提：需要配置<code v-pre>JAVA_HOME</code>环境变量。虽然安装java时，环境变量<code v-pre>Path</code>下已经有默认配置，能够在任何位置的cmd终端执行<code v-pre>java</code>命令，但配置Tomcat仍然需要重新配置<code v-pre>JAVA_HOME</code>，否则会出现执行Tomcat的开启命令会出现一闪而过的情况，Tomcat也不会运行起来。
<ul>
<li><img src="/images/javaweb/image-1660813767426.png" alt="image.png" loading="lazy"></li>
</ul>
</li>
<li>配置了java环境变量后，执行<code v-pre>bin/startup.bat</code>
<ul>
<li><img src="/images/javaweb/image-1660813769887.png" alt="image.png" loading="lazy"></li>
<li>乱码问题：修改<code v-pre>conf/logging.properties</code>文件，添加<code v-pre>java.util.logging.ConsoleHandler.encoding = GBK</code>指令。
<ul>
<li><img src="/images/javaweb/image-1660813772535.png" alt="image.png" loading="lazy"></li>
</ul>
</li>
</ul>
</li>
<li>访问：<a href="http://localhost:8080/" target="_blank" rel="noopener noreferrer">http://localhost:8080/<ExternalLinkIcon/></a>
<ul>
<li><img src="/images/javaweb/image-1660813774651.png" alt="image.png" loading="lazy"></li>
</ul>
</li>
</ul>
</li>
<li>新建Web项目，并布署：
<ul>
<li>在<code v-pre>webapps</code>路径下，新建<code v-pre>网址名/WEB-INF</code>，如<code v-pre>webdesign</code>，将写好的网页放到该目录下
<ul>
<li><img src="/images/javaweb/image-1660813777135.png" alt="image.png" loading="lazy"></li>
<li><img src="/images/javaweb/image-1660813779100.png" alt="image.png" loading="lazy"></li>
<li><code v-pre>WEB-INF</code>不能修改。</li>
</ul>
</li>
</ul>
</li>
</ol>
<h2 id="第4章-idea中新建web项目" tabindex="-1"><a class="header-anchor" href="#第4章-idea中新建web项目" aria-hidden="true">#</a> 第4章 IDEA中新建Web项目</h2>
<h3 id="_4-1-创建项目" tabindex="-1"><a class="header-anchor" href="#_4-1-创建项目" aria-hidden="true">#</a> 4.1 创建项目</h3>
<h4 id="_4-1-1-方式一" tabindex="-1"><a class="header-anchor" href="#_4-1-1-方式一" aria-hidden="true">#</a> 4.1.1 方式一</h4>
<ol>
<li>不同版本的IDEA创建web项目的操作方式，本文以IDEA2022.1.3为例。</li>
<li>新建项目（模块），指明存放路径，jdk版本
<ul>
<li><img src="/images/javaweb/image-1660813782764.png" alt="image.png" loading="lazy"></li>
<li><img src="/images/javaweb/image-1660813785306.png" alt="image.png" loading="lazy"></li>
</ul>
</li>
<li>右键项目（模块），添加Web框架支持
<ul>
<li><img src="/images/javaweb/image-1660813787347.png" alt="image.png" loading="lazy"></li>
<li><img src="/images/javaweb/image-1660813789996.png" alt="image.png" loading="lazy"></li>
<li><img src="/images/javaweb/image-1660813792934.png" alt="image.png" loading="lazy"></li>
</ul>
</li>
</ol>
<h4 id="_4-1-2-方式二" tabindex="-1"><a class="header-anchor" href="#_4-1-2-方式二" aria-hidden="true">#</a> 4.1.2 方式二</h4>
<ol>
<li>新建模块：
<ul>
<li><img src="/images/javaweb/image-1660813795072.png" alt="image.png" loading="lazy"></li>
</ul>
</li>
<li>设置项目结构
<ul>
<li><img src="/images/javaweb/image-1660813797250.png" alt="image.png" loading="lazy"></li>
</ul>
</li>
<li>添加Web程序：
<ul>
<li><img src="/images/javaweb/image-1660813799406.png" alt="image.png" loading="lazy"></li>
</ul>
</li>
<li>生成部署包（工件、atrifacts）：
<ul>
<li><img src="/images/javaweb/image-1660813801515.png" alt="image.png" loading="lazy"></li>
<li>拓展：war包，压缩后的web应用程序包，打包放到tomcat的webapps路径下，会自动解压
<ul>
<li><img src="/images/javaweb/image-1660813803578.png" alt="image.png" loading="lazy"></li>
</ul>
</li>
</ul>
</li>
</ol>
<h4 id="_4-1-2-导入其他人项目" tabindex="-1"><a class="header-anchor" href="#_4-1-2-导入其他人项目" aria-hidden="true">#</a> 4.1.2 导入其他人项目</h4>
<ol>
<li>同4.1.1操作</li>
<li><img src="/images/javaweb/image-1660813805878.png" alt="image.png" loading="lazy"></li>
</ol>
<h3 id="_4-2-运行配置-tomcat配置" tabindex="-1"><a class="header-anchor" href="#_4-2-运行配置-tomcat配置" aria-hidden="true">#</a> 4.2 运行配置（Tomcat配置）</h3>
<ol>
<li>添加Tomcat本地服务器
<ul>
<li><img src="/images/javaweb/image-1660813808548.png" alt="image.png" loading="lazy"></li>
<li><img src="/images/javaweb/image-1660813811945.png" alt="image.png" loading="lazy"></li>
<li><img src="/images/javaweb/image-1660813813569.png" alt="image.png" loading="lazy"></li>
</ul>
</li>
<li>配置访问地址：
<ul>
<li><img src="/images/javaweb/image-1660813815788.png" alt="image.png" loading="lazy"></li>
<li>url表示默认打开浏览器时的地址。</li>
</ul>
</li>
<li>部署服务器端的文件（使服务器能打开本地文件）
<ul>
<li><img src="/images/javaweb/image-1660813818318.png" alt="image.png" loading="lazy"></li>
<li><img src="/images/javaweb/image-1660813820704.png" alt="image.png" loading="lazy"></li>
<li><code v-pre>应用程序上下文</code>：设置为<code v-pre>/</code>时，表示访问服务器根目录即能访问到该web程序。
<ul>
<li>如果找不到工件，则按照下面的方式</li>
<li><img src="/images/javaweb/image-1660813829522.png" alt="image.png" loading="lazy"><img src="/images/javaweb/image-1660813825953.png" alt="image.png" loading="lazy"></li>
</ul>
</li>
</ul>
</li>
</ol>
<blockquote>
<ul>
<li>配置总结：</li>
</ul>
</blockquote>
<p><img src="/images/javaweb/image-1660813833442.png" alt="image.png" loading="lazy"></p>
<blockquote>
<p>这个页面的地址最后带不带/都没有关系
<img src="/images/javaweb/image-1660813835468.png" alt="image.png" loading="lazy">
这个页面的这个名称要写到第一个图的地址后面
<img src="/images/javaweb/image-1660813838004.png" alt="image.png" loading="lazy">
这个界面的路径要到<code v-pre>web</code>目录下</p>
</blockquote>
<h3 id="_4-3-热更新配置" tabindex="-1"><a class="header-anchor" href="#_4-3-热更新配置" aria-hidden="true">#</a> 4.3 热更新配置</h3>
<ol>
<li>设置热更新：
<ul>
<li><img src="/images/javaweb/image-1660813841000.png" alt="image.png" loading="lazy"></li>
</ul>
</li>
</ol>
<h3 id="_4-4-配置servlet-api" tabindex="-1"><a class="header-anchor" href="#_4-4-配置servlet-api" aria-hidden="true">#</a> 4.4 配置servlet api</h3>
<ol>
<li>要能写服务端程序，则要求改程序必须实现自servlet接口或继承自GenericServlet 类和 HttpServlet 类（参见5.1）</li>
<li>方式一：添加<code v-pre>servlet-api.jar</code>至lib文件夹，同Druid
<ul>
<li><img src="/images/javaweb/image-1660813843805.png" alt="image.png" loading="lazy"></li>
</ul>
</li>
<li>方式二：
<ul>
<li><img src="/images/javaweb/image-1660813845443.png" alt="image.png" loading="lazy"></li>
<li><img src="/images/javaweb/image-1660813848904.png" alt="image.png" loading="lazy"></li>
<li>添加后会显示为外部库文件
<ul>
<li><img src="/images/javaweb/image-1660813851541.png" alt="image.png" loading="lazy"></li>
</ul>
</li>
</ul>
</li>
</ol>
<h3 id="_4-5-部分错误类型及解决方式" tabindex="-1"><a class="header-anchor" href="#_4-5-部分错误类型及解决方式" aria-hidden="true">#</a> 4.5 部分错误类型及解决方式</h3>
<h4 id="_4-5-1-未添加servlet运行程序-容易404" tabindex="-1"><a class="header-anchor" href="#_4-5-1-未添加servlet运行程序-容易404" aria-hidden="true">#</a> 4.5.1 未添加Servlet运行程序（容易404）</h4>
<ol>
<li><img src="/images/javaweb/image-1660813853774.png" alt="image.png" loading="lazy"></li>
<li><img src="/images/javaweb/image-1660813856741.png" alt="image.png" loading="lazy"></li>
</ol>
<h2 id="第5章-servlet入门" tabindex="-1"><a class="header-anchor" href="#第5章-servlet入门" aria-hidden="true">#</a> 第5章 Servlet入门</h2>
<p><a href="https://www.yuque.com/attachments/yuque/0/2022/pdf/1604140/1656685756637-9de0d9a4-333f-4269-a645-e8560308393e.pdf" target="_blank" rel="noopener noreferrer">06_尚硅谷_Servlet_王振国 - 课堂笔记.pdf<ExternalLinkIcon/></a></p>
<h3 id="_5-1-servlet简介" tabindex="-1"><a class="header-anchor" href="#_5-1-servlet简介" aria-hidden="true">#</a> 5.1 Servlet简介</h3>
<h4 id="_5-1-1-servlet介绍" tabindex="-1"><a class="header-anchor" href="#_5-1-1-servlet介绍" aria-hidden="true">#</a> 5.1.1 Servlet介绍</h4>
<ol>
<li>作用：Servlet是Server Applet的缩写，称为服务器端小程序，是一种使用Java语言来开发动态网站的技术。</li>
<li>Serlet几乎可以使用Java的所有API。</li>
<li>出现背景：使用Java原生代码开发动态网站需要手动解析HTTP请求报头、需要分析用户的请求参数、需要加载数据库组件……过程极其麻烦，基于上述原因，Java官方推出了Servlet技术，对开发动态网站需要使用的JavaAPI进行了封装，形成了一套新的API，称为Servlet API。</li>
<li>本质：Servlet是一套Java Web的开发规范（开发技术标准），只有实现（编写代码实现Servlet规范中的各类功能——类、方法、属性）了该规范才能进行web开发。</li>
<li>体现：一个Servlet程序实际上是按照Servlet规范编写的Java类，Servlet程序需要编译成字节码文件（<code v-pre>.class</code>）才能部署到服务器运行。</li>
<li>Servlet功能实现方式：实现Servlet接口能获得Servlet的所有功能。但需要实现很多方法，比较麻烦，所以Servlet规范提供了两个实现了Servlet接口常用功能（方法）的类：GenericServlet 类和 HttpServlet 类，其中HttpServlet 类的使用更为方便。
<ul>
<li><img src="/images/javaweb/image-1660813864059.png" alt="image.png" loading="lazy"></li>
</ul>
</li>
<li>Servlet 就是JavaWeb 三大组件之一。三大组件分别是：Servlet 程序、Filter 过滤器、Listener 监听器 。</li>
</ol>
<h4 id="_5-1-2-servlet继承关系" tabindex="-1"><a class="header-anchor" href="#_5-1-2-servlet继承关系" aria-hidden="true">#</a> 5.1.2 Servlet继承关系</h4>
<ol>
<li>类图：
<ul>
<li><img src="/images/javaweb/image-1660813866216.png" alt="image.png" loading="lazy"></li>
<li><img src="/images/javaweb/image-1660813868112.png" alt="image.png" loading="lazy"></li>
<li>Tomcat8中，包为<code v-pre>javax</code>，Tomcat10中，包为<code v-pre>jakarta</code></li>
</ul>
</li>
<li>相关方法：
<ul>
<li><code v-pre>javax.servlet.Servlet</code>接口:
<ul>
<li><code v-pre>void init(config)</code> - 初始化方法</li>
<li><code v-pre>void service(request,response)</code>- 服务方法</li>
<li><code v-pre>void destory()</code>- 销毁方法</li>
</ul>
</li>
<li><code v-pre>javax.servlet.GenericServlet</code>抽象类：
<ul>
<li><code v-pre>void service(request,response)</code>- 仍然是抽象的</li>
</ul>
</li>
<li><code v-pre>javax.servlet.http.HttpServlet</code> 抽象子类：
<ul>
<li><code v-pre>void service(request,response)</code>- 不是抽象的</li>
</ul>
</li>
</ul>
</li>
<li>当有请求过来时，service方法会自动响应（其实是tomcat容器调用的）</li>
</ol>
<h3 id="_5-2-servlet容器-web容器" tabindex="-1"><a class="header-anchor" href="#_5-2-servlet容器-web容器" aria-hidden="true">#</a> 5.2 Servlet容器（Web容器）</h3>
<h4 id="_5-2-1-web服务器" tabindex="-1"><a class="header-anchor" href="#_5-2-1-web服务器" aria-hidden="true">#</a> 5.2.1 Web服务器</h4>
<ol>
<li>web服务器功能比较单一，一般只能提供http(s)服务，使用户可以访问静态资源（HTML 文档、图片、CSS 文件、JavaScript 文件等），它们不能执行任何编程语言，也不能访问数据库，更不能让用户注册和登录。——静态网站。</li>
<li>要部署动态网站，还要有编程语言运行环境和数据库管理系统的支持。
<ul>
<li>运行环境：支持脚本语言运行的部件（解释器、垃圾回收器、标准库等）的统称。又称运行时（Runtime)</li>
<li>数据库：mysql等</li>
</ul>
</li>
<li>常见web服务器：
<ul>
<li>运行 PHP 网站一般选择 Apache 或者 Nginx；</li>
<li>运行 ASP/ASP.NET 网站一般选择 IIS；</li>
<li>运行 Python 网站一般选择内置的 WSGI 服务器模块——wsgiref。</li>
</ul>
</li>
<li>动态网站三大组件：Web服务器+脚本语言运行环境+数据库</li>
</ol>
<h4 id="_5-2-2-web容器" tabindex="-1"><a class="header-anchor" href="#_5-2-2-web容器" aria-hidden="true">#</a> 5.2.2 web容器</h4>
<ol>
<li>servlet容器：servlet代码的运行环境，包括：
<ul>
<li>jre（JVM、Java核心类库、一些副属性文件），并不支持Servlet规范？</li>
<li>实现Servlet规范定义的各类接口和类：</li>
<li>管理用户编写的Servlet类，以及实例化以后的对象——我们编写的Servlet类没有main()，不能独立运行，知道能当作一个模块加载到Servlet容器，由容器进行实例化并调用方法。</li>
<li>提供HTTP服务，相当于简化web服务器。</li>
</ul>
</li>
<li>常见web容器：Tomcat、Jboss、Jetty、WebLogic等，实现了Servlet规范。</li>
<li>工作过程：一个动态页面对应一个Servlet类，开发一个动态页面就是编写一个 Servlet 类，当用户请求到达时，Servlet 容器会根据配置文件（web.xml）来决定调用哪个类。</li>
</ol>
<h3 id="_5-3-url地址到servlet程序的访问" tabindex="-1"><a class="header-anchor" href="#_5-3-url地址到servlet程序的访问" aria-hidden="true">#</a> 5.3 url地址到Servlet程序的访问</h3>
<h4 id="_5-3-1-servlet部署" tabindex="-1"><a class="header-anchor" href="#_5-3-1-servlet部署" aria-hidden="true">#</a> 5.3.1 Servlet部署</h4>
<ol>
<li>
<p>Servlet 规范规定，JavaWeb 应用必须采用固定的目录结构，即每种组件在 JavaWeb 应用中都有固定的存放目录。</p>
<ul>
<li><img src="/images/javaweb/image-1660813872416.png" alt="image.png" loading="lazy">
| 目录 | 描述 | 是否必需 |
| --- | --- | --- |
| \servletDemo | Web 应用的根目录，属于该 Web 应用的所有资源都存放在这个目录下。 | 是 |
| \servletDemo\WEB-INF | 存放 web.xml、lib 目录以及 classes 目录等。 | 是 |
| \servletDemo\WEB-INF\classes | 存放各种 .class 文件或者包含 .class 文件的目录，Servlet 类的 .class 文件也存放在此。 | 否 |
| \servletDemo\WEB-INF\lib | 存放应用所需的各种 jar 包，例如 JDBC 驱动程序的 jar 包。 | 否 |
| \servletDemo\WEB-INF\web.xml | web.xml 中包含应用程序的配置和部署信息。 | 是 |</li>
</ul>
</li>
<li>
<p>部署（手动不使用IDEA工具的方式）：将servletDemo文件夹复制到<code v-pre>/webapps</code>目录下</p>
<ul>
<li>——实质是在<code v-pre>/webapps</code>目录下编写程序。</li>
</ul>
</li>
</ol>
<h4 id="_5-3-2-servlet访问配置" tabindex="-1"><a class="header-anchor" href="#_5-3-2-servlet访问配置" aria-hidden="true">#</a> 5.3.2 Servlet访问配置</h4>
<p><img src="/images/javaweb/image-1660813876459.png" alt="image.png" loading="lazy"></p>
<h4 id="_5-3-3-servlet虚拟路径映射" tabindex="-1"><a class="header-anchor" href="#_5-3-3-servlet虚拟路径映射" aria-hidden="true">#</a> 5.3.3 Servlet虚拟路径映射</h4>
<ol>
<li>Servlet单一映射：
<ul>
<li>方式一：在web.xml文件中配置</li>
<li>方式二：使用@WebServlet：<code v-pre>@WebServlet(&quot;/MyServlet&quot;)</code>，省略了urlPatterns =</li>
</ul>
</li>
<li>Servlet多重映射：
<ul>
<li>方式一：在web.xml文件中配置多个<code v-pre>&lt;servlet-mapping&gt;</code>元素</li>
<li>方式一：在web.xml文件中配置多个<code v-pre>&lt;url-pattern&gt;</code>元素</li>
<li>方式二：使用@WebServlet：<code v-pre>@WebServlet(urlPatterns = {&quot;/MyServlet&quot;, &quot;/MyServlet2&quot;})</code></li>
</ul>
</li>
</ol>
<h4 id="_5-3-4-项目中地址的使用" tabindex="-1"><a class="header-anchor" href="#_5-3-4-项目中地址的使用" aria-hidden="true">#</a> 5.3.4 项目中地址的使用</h4>
<ol>
<li>开发中一般使用绝对路径+相对路径的形式，或者绝对路径的形式</li>
<li><code v-pre>&lt;base&gt;</code>标签设置在html文件中，只对当前的html页面生效。写路径时<code v-pre>/</code>配合<code v-pre>&lt;base&gt;</code>标签一起看。
<ul>
<li>一般不写<code v-pre>/</code></li>
<li>但也可以写为<code v-pre>./</code></li>
<li>html页面的所有地址【HTML的和servlet的】，都要配合<code v-pre>&lt;base&gt;</code>标签一起看。</li>
<li>建议规范：html页都不带<code v-pre>/</code></li>
</ul>
</li>
<li>在servlet程序中，默认为工程路径（Tomcat配置的http全路径）【忽略了src目录、各个包目录，直接到类】，写路径时带不带<code v-pre>/</code>都不影响【有影响，但规律还没把握】
<ul>
<li>建议规范：servlet页面都带<code v-pre>/</code></li>
<li><code v-pre>&lt;%@include file=&quot;/pages/common/manager_meun.jsp&quot;%&gt;</code>必须以<code v-pre>/</code>开头</li>
</ul>
</li>
<li><code v-pre>/</code>被web解析，表示<code v-pre>http://ip:port/</code>，被服务器解析，表示<code v-pre>http://ip:port/工程路径</code></li>
</ol>
<h3 id="_5-4-servlet的生命周期" tabindex="-1"><a class="header-anchor" href="#_5-4-servlet的生命周期" aria-hidden="true">#</a> 5.4 Servlet的生命周期</h3>
<p><img src="/images/javaweb/image-1660813880939.png" alt="image.png" loading="lazy"></p>
<ol>
<li>Servlet构造器方法（创建Servlet实例——由于是tomcat去创建，所以构造器不能用private修饰）
<ul>
<li>第一次访问时调用。</li>
</ul>
</li>
<li>init初始化方法
<ul>
<li>第一次访问时调用。</li>
<li>作用：建立数据库连接，获取配置信息等</li>
</ul>
</li>
<li>service方法
<ul>
<li>每次访问都会调用。</li>
</ul>
</li>
<li>destroy销毁方法
<ul>
<li>web工程停止的时候调用（工程停止不是切换浏览器的访问地址）</li>
</ul>
</li>
<li>默认情况下，第一此请求时tomcat才会创建Servlet实例化对象、调用<code v-pre>init()</code>，便于提高启动速度，但会造成首次请求等待时间较长。</li>
<li>xml文件中，配置<code v-pre>&lt;load-on-startup&gt;</code>控制创建实例对象、初始化方法的时机【见5.7.4】。这样的好处是提高了首次请求的响应时间，但带来问题是启动变慢。</li>
<li>Servlet在容器中是单例、线程不安全的。
<ul>
<li>单例：所有的请求都是同一个实例去响应</li>
<li>线程不安全：一个线程需要根据这个实例中的某个成员变量值去做逻辑判断。但是在中间某个时机，另一个线程改变了这个成员变量的值，从而导致第一个线程的执行路径发生了变化
<ul>
<li>尽量的不要在servlet中定义成员变量。如果不得不定义成员变量，那么：①不要去修改成员变量的值 ②不要去根据成员变量的值做一些逻辑判断</li>
</ul>
</li>
</ul>
</li>
</ol>
<h3 id="_5-5-get和post请求分发处理" tabindex="-1"><a class="header-anchor" href="#_5-5-get和post请求分发处理" aria-hidden="true">#</a> 5.5 GET和POST请求分发处理</h3>
<ol>
<li>实现Servlet接口的HttpServlet类中的service方法，会根据http数据传输方式不同做不同的处理。</li>
</ol>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token keyword">protected</span> <span class="token keyword">void</span> <span class="token function">service</span><span class="token punctuation">(</span><span class="token class-name">HttpServletRequest</span> req<span class="token punctuation">,</span> <span class="token class-name">HttpServletResponse</span> resp<span class="token punctuation">)</span> <span class="token keyword">throws</span> <span class="token class-name">ServletException</span><span class="token punctuation">,</span> <span class="token class-name">IOException</span> <span class="token punctuation">{</span>
    <span class="token class-name">String</span> method <span class="token operator">=</span> req<span class="token punctuation">.</span><span class="token function">getMethod</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token keyword">long</span> lastModified<span class="token punctuation">;</span>
    <span class="token keyword">if</span> <span class="token punctuation">(</span>method<span class="token punctuation">.</span><span class="token function">equals</span><span class="token punctuation">(</span><span class="token string">"GET"</span><span class="token punctuation">)</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
        lastModified <span class="token operator">=</span> <span class="token keyword">this</span><span class="token punctuation">.</span><span class="token function">getLastModified</span><span class="token punctuation">(</span>req<span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token keyword">if</span> <span class="token punctuation">(</span>lastModified <span class="token operator">==</span> <span class="token operator">-</span><span class="token number">1L</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
            <span class="token keyword">this</span><span class="token punctuation">.</span><span class="token function">doGet</span><span class="token punctuation">(</span>req<span class="token punctuation">,</span> resp<span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token punctuation">}</span> <span class="token keyword">else</span> <span class="token punctuation">{</span>
            <span class="token keyword">long</span> ifModifiedSince<span class="token punctuation">;</span>
            <span class="token keyword">try</span> <span class="token punctuation">{</span>
                ifModifiedSince <span class="token operator">=</span> req<span class="token punctuation">.</span><span class="token function">getDateHeader</span><span class="token punctuation">(</span><span class="token string">"If-Modified-Since"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
            <span class="token punctuation">}</span> <span class="token keyword">catch</span> <span class="token punctuation">(</span><span class="token class-name">IllegalArgumentException</span> var9<span class="token punctuation">)</span> <span class="token punctuation">{</span>
                ifModifiedSince <span class="token operator">=</span> <span class="token operator">-</span><span class="token number">1L</span><span class="token punctuation">;</span>
            <span class="token punctuation">}</span>

            <span class="token keyword">if</span> <span class="token punctuation">(</span>ifModifiedSince <span class="token operator">&lt;</span> lastModified <span class="token operator">/</span> <span class="token number">1000L</span> <span class="token operator">*</span> <span class="token number">1000L</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
                <span class="token keyword">this</span><span class="token punctuation">.</span><span class="token function">maybeSetLastModified</span><span class="token punctuation">(</span>resp<span class="token punctuation">,</span> lastModified<span class="token punctuation">)</span><span class="token punctuation">;</span>
                <span class="token keyword">this</span><span class="token punctuation">.</span><span class="token function">doGet</span><span class="token punctuation">(</span>req<span class="token punctuation">,</span> resp<span class="token punctuation">)</span><span class="token punctuation">;</span>
            <span class="token punctuation">}</span> <span class="token keyword">else</span> <span class="token punctuation">{</span>
                resp<span class="token punctuation">.</span><span class="token function">setStatus</span><span class="token punctuation">(</span><span class="token number">304</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
            <span class="token punctuation">}</span>
        <span class="token punctuation">}</span>
    <span class="token punctuation">}</span> <span class="token keyword">else</span> <span class="token keyword">if</span> <span class="token punctuation">(</span>method<span class="token punctuation">.</span><span class="token function">equals</span><span class="token punctuation">(</span><span class="token string">"HEAD"</span><span class="token punctuation">)</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
        lastModified <span class="token operator">=</span> <span class="token keyword">this</span><span class="token punctuation">.</span><span class="token function">getLastModified</span><span class="token punctuation">(</span>req<span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token keyword">this</span><span class="token punctuation">.</span><span class="token function">maybeSetLastModified</span><span class="token punctuation">(</span>resp<span class="token punctuation">,</span> lastModified<span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token keyword">this</span><span class="token punctuation">.</span><span class="token function">doHead</span><span class="token punctuation">(</span>req<span class="token punctuation">,</span> resp<span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token punctuation">}</span> <span class="token keyword">else</span> <span class="token keyword">if</span> <span class="token punctuation">(</span>method<span class="token punctuation">.</span><span class="token function">equals</span><span class="token punctuation">(</span><span class="token string">"POST"</span><span class="token punctuation">)</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
        <span class="token keyword">this</span><span class="token punctuation">.</span><span class="token function">doPost</span><span class="token punctuation">(</span>req<span class="token punctuation">,</span> resp<span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token punctuation">}</span> <span class="token keyword">else</span> <span class="token keyword">if</span> <span class="token punctuation">(</span>method<span class="token punctuation">.</span><span class="token function">equals</span><span class="token punctuation">(</span><span class="token string">"PUT"</span><span class="token punctuation">)</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
        <span class="token keyword">this</span><span class="token punctuation">.</span><span class="token function">doPut</span><span class="token punctuation">(</span>req<span class="token punctuation">,</span> resp<span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token punctuation">}</span> <span class="token keyword">else</span> <span class="token keyword">if</span> <span class="token punctuation">(</span>method<span class="token punctuation">.</span><span class="token function">equals</span><span class="token punctuation">(</span><span class="token string">"DELETE"</span><span class="token punctuation">)</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
        <span class="token keyword">this</span><span class="token punctuation">.</span><span class="token function">doDelete</span><span class="token punctuation">(</span>req<span class="token punctuation">,</span> resp<span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token punctuation">}</span> <span class="token keyword">else</span> <span class="token keyword">if</span> <span class="token punctuation">(</span>method<span class="token punctuation">.</span><span class="token function">equals</span><span class="token punctuation">(</span><span class="token string">"OPTIONS"</span><span class="token punctuation">)</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
        <span class="token keyword">this</span><span class="token punctuation">.</span><span class="token function">doOptions</span><span class="token punctuation">(</span>req<span class="token punctuation">,</span> resp<span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token punctuation">}</span> <span class="token keyword">else</span> <span class="token keyword">if</span> <span class="token punctuation">(</span>method<span class="token punctuation">.</span><span class="token function">equals</span><span class="token punctuation">(</span><span class="token string">"TRACE"</span><span class="token punctuation">)</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
        <span class="token keyword">this</span><span class="token punctuation">.</span><span class="token function">doTrace</span><span class="token punctuation">(</span>req<span class="token punctuation">,</span> resp<span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token punctuation">}</span> <span class="token keyword">else</span> <span class="token punctuation">{</span>
        <span class="token class-name">String</span> errMsg <span class="token operator">=</span> lStrings<span class="token punctuation">.</span><span class="token function">getString</span><span class="token punctuation">(</span><span class="token string">"http.method_not_implemented"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token class-name">Object</span><span class="token punctuation">[</span><span class="token punctuation">]</span> errArgs <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">Object</span><span class="token punctuation">[</span><span class="token punctuation">]</span><span class="token punctuation">{</span>method<span class="token punctuation">}</span><span class="token punctuation">;</span>
        errMsg <span class="token operator">=</span> <span class="token class-name">MessageFormat</span><span class="token punctuation">.</span><span class="token function">format</span><span class="token punctuation">(</span>errMsg<span class="token punctuation">,</span> errArgs<span class="token punctuation">)</span><span class="token punctuation">;</span>
        resp<span class="token punctuation">.</span><span class="token function">sendError</span><span class="token punctuation">(</span><span class="token number">501</span><span class="token punctuation">,</span> errMsg<span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token punctuation">}</span>

<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ol start="2">
<li>如果后端的处理方法（do方法）与请求方法不一致，会报405错误</li>
</ol>
<h3 id="_5-6-idea创建servlet程序" tabindex="-1"><a class="header-anchor" href="#_5-6-idea创建servlet程序" aria-hidden="true">#</a> 5.6 IDEA创建Servlet程序</h3>
<ol>
<li>确认模块添加了Tomcat依赖（步骤4.4，即添加了servlet api）
<ul>
<li><img src="/images/javaweb/image-1660813885254.png" alt="image.png" loading="lazy"></li>
</ul>
</li>
<li>右键src目录，新建servlet程序
<ul>
<li><img src="/images/javaweb/image-1660813887292.png" alt="image.png" loading="lazy"></li>
</ul>
</li>
</ol>
<h3 id="_5-7-servlet底层原理" tabindex="-1"><a class="header-anchor" href="#_5-7-servlet底层原理" aria-hidden="true">#</a> 5.7 Servlet底层原理</h3>
<h4 id="_5-7-1-servlet类的继承关系" tabindex="-1"><a class="header-anchor" href="#_5-7-1-servlet类的继承关系" aria-hidden="true">#</a> 5.7.1 Servlet类的继承关系</h4>
<p><img src="/images/javaweb/image-1660813889693.png" alt="image.png" loading="lazy"></p>
<h4 id="_5-7-2-servletconfig类" tabindex="-1"><a class="header-anchor" href="#_5-7-2-servletconfig类" aria-hidden="true">#</a> 5.7.2 ServletConfig类</h4>
<ol>
<li>servlet程序的配置信息类</li>
<li>Servlet程序和ServletConfig对象都是由Tomcat创建的，程序员负责使用
<ul>
<li>Servlet程序默认是第一次访问时创建</li>
<li>ServletConfig是每个Servlet程序创建时创建</li>
</ul>
</li>
<li>获取（假设MyServlet继承自HttpServlet）：
<ul>
<li>方式一：定义<code v-pre>private ServletConfig servletConfig</code>，重写<code v-pre>init()</code>方法
<ul>
<li>如果不声明<code v-pre>servletConfig</code>，则必须在重写<code v-pre>init()</code>方法时，显式的调用<code v-pre>super.init(config)</code>，否则会空指针异常</li>
</ul>
</li>
<li>方式二：调用 GenericServlet 提供的 getServletConfig()方法：<code v-pre>ServletConfig servletConfig = this.getServletConfig()</code></li>
</ul>
</li>
<li>配置Servlet初始化参数：
<ul>
<li>方式一：在web.xml文件中配置</li>
<li>方式二：使用@WebServlet配置</li>
</ul>
</li>
<li>作用：
<ul>
<li>获取Servlet程序的别名<code v-pre>&lt;servlet-name&gt;</code>的值。（web.xml文件中）
<ul>
<li>使用<code v-pre>servletConfig.getServletName()</code></li>
</ul>
</li>
<li>获取初始化参数<code v-pre>&lt;init-param&gt;</code>
<ul>
<li>使用<code v-pre>servletConfig.getInitParameter(&quot;参数名&quot;)</code>——参数名是web.xml文件中配置的<code v-pre>&lt;param-name&gt;</code>，获取到的值是<code v-pre>&lt;param-value&gt;</code></li>
</ul>
</li>
<li>获取ServletContext对象:getServletContext() 方法
<ul>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1656726016040-1da277bb-bac4-45dc-85c4-a91202787a74.png#clientId=u74efd510-37c1-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=27&amp;id=u1234f848&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=27&amp;originWidth=667&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=29987&amp;status=done&amp;style=none&amp;taskId=u1fedd3ce-082f-4439-8434-0572309b2f6&amp;title=&amp;width=667" alt="image.png" loading="lazy"></li>
</ul>
</li>
</ul>
</li>
</ol>
<h4 id="_5-7-3-servletcontext类" tabindex="-1"><a class="header-anchor" href="#_5-7-3-servletcontext类" aria-hidden="true">#</a> 5.7.3 ServletContext类</h4>
<ol>
<li>表示Servlet上下文对象的一个接口，一个web工程，只有一个ServletContext实例。
<ul>
<li>Servlet上下文：Servlet容器启动时，为每个Web应用（webapps文件夹下的每个目录）创建一个唯一的ServletContext对象，该对象称为Servlet上下文</li>
</ul>
</li>
<li>ServletContext对象是一个域对象
<ul>
<li>域对象：可以像map一样存储数据的对象，域指的是存储数据的操作范围，域对象是值服务器在内存上创建的存储空间，该空间用于不同资源之间共享数据。</li>
<li>ServletContext的域是整个工程。所以不同Servlet之间可以通过ServletContext对象实现数据通信。
<ul>
<li>域对象特性：<img src="/images/javaweb/image-1660813894254.png" alt="image.png" loading="lazy"></li>
</ul>
</li>
<li>另外两个域对象时reques和session</li>
</ul>
</li>
<li>ServletContext在web工程启动时创建，停止时销毁。</li>
<li>获取ServletContext对象：
<ul>
<li>通过 GenericServlet 提供的 getServletContext() 方法</li>
<li>通过 ServletConfig 提供的 getServletContext() 方法</li>
<li>通过 HttpSession 提供的 getServletContext() 方法</li>
<li>通过 HttpServletRequest 提供的 getServletContext() 方法</li>
</ul>
</li>
<li>作用：
<ul>
<li>获取web.xml 中配置的上下文参数context-param
<ul>
<li><code v-pre>getInitParameter(str)</code></li>
</ul>
</li>
<li>获取当前的工程路径，格式: <code v-pre>/工程路径</code>，<img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1656756489508-35845f43-e306-4be9-8970-8107842f7512.png#clientId=u74efd510-37c1-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=28&amp;id=ud53e2d6a&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=28&amp;originWidth=190&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=1193&amp;status=done&amp;style=none&amp;taskId=uc3c2d893-4827-453a-b5c8-ddaf2cc9634&amp;title=&amp;width=190" alt="image.png" loading="lazy">
<ul>
<li><code v-pre>getContextPath()</code></li>
</ul>
</li>
<li>获取工程部署后在服务器硬盘上的绝对路径，<code v-pre>D:\实践练习\07.JavaWeb\out\artifacts\servlet1_8_war_exploded\</code>
<ul>
<li><code v-pre>getRealPath(&quot;/&quot;)</code></li>
</ul>
</li>
<li>像Map 一样存取数据</li>
</ul>
</li>
<li>获取上下文初始化参数：
<ul>
<li>设置上下文初始化参数：
<ul>
<li>方式一：在web.xml文件中，使用<code v-pre>&lt;context-param&gt;</code>及其子标签</li>
<li>方式二：在Servlet程序中，使用ServletContext对象的<code v-pre>setAtrribute()</code>方法</li>
</ul>
</li>
<li>获取上下文初始化参数：
<ul>
<li>方式一：<img src="/images/javaweb/image-1660813897647.png" alt="image.png" loading="lazy"></li>
<li>方式二：<img src="/images/javaweb/image-1660813900275.png" alt="image.png" loading="lazy"></li>
</ul>
</li>
<li>两种方式对比：
<ul>
<li><img src="/images/javaweb/image-1660813902107.png" alt="image.png" loading="lazy"></li>
</ul>
</li>
</ul>
</li>
<li>读取web应用下的资源文件
<ul>
<li><img src="/images/javaweb/image-1660813903978.png" alt="image.png" loading="lazy"></li>
<li>参数 path 代表资源文件的虚拟路径，它以正斜线<code v-pre>/</code>开始，<code v-pre>/</code>表示当前 Web 应用的根目录。</li>
</ul>
</li>
</ol>
<h4 id="_5-7-4-load-on-startup元素" tabindex="-1"><a class="header-anchor" href="#_5-7-4-load-on-startup元素" aria-hidden="true">#</a> 5.7.4 load-on-startup元素</h4>
<ol>
<li>作用：控制Servlet启动优先级</li>
<li>使用在web.xml文件中，是<code v-pre>&lt;servlet&gt;</code>的子元素节点。</li>
<li>取值规则
<ul>
<li>它的取值必须是一个整数；</li>
<li>当值小于 0 或者没有指定时，则表示容器在该 Servlet 被首次请求时才会被加载；</li>
<li>当值大于 0 或等于 0 时，表示容器在启动时就加载并初始化该 Servlet，取值越小，优先级越高；</li>
<li>当取值相同时，容器就会自行选择顺序进行加载。</li>
</ul>
</li>
</ol>
<h4 id="_5-7-5-httpservletrequest类" tabindex="-1"><a class="header-anchor" href="#_5-7-5-httpservletrequest类" aria-hidden="true">#</a> 5.7.5 HttpServletRequest类</h4>
<ol>
<li>作用：每次Servlet容器接收到HTTP请求，就会创建一个HttpServletRequest对象，通过该对象，可以获取对象传递给服务器的信息。</li>
<li>生命周期：Servlet容器接到HTTP请求时创建，Servlet容器将响应信息返回给客户端后销毁。</li>
<li>获取请求行的方法：
<ul>
<li><img src="/images/javaweb/image-1660813908306.png" alt="image.png" loading="lazy"></li>
<li><code v-pre>getRemoteHost()</code>：在浏览器中使用localhost、127.0.0.1访问时，返回127.0.0.1，使用真实ip访问时，返回真实的客户端ip</li>
</ul>
</li>
<li>获取请求头的方法
<ul>
<li><img src="/images/javaweb/image-1660813911884.png" alt="image.png" loading="lazy"></li>
</ul>
</li>
<li>获取表单数据的方法：
<ul>
<li><img src="/images/javaweb/image-1660813914280.png" alt="image.png" loading="lazy"></li>
</ul>
</li>
<li>中文乱码问题：
<ul>
<li>GET请求：Get 请求将请求数据附加到 URL 后面作为参数，浏览器发送文字时采用的编码格式与页面编码保持一致（utf-8）。如果 Tomcat 没有设置字符集，接收 URL 时默认使用 ISO-8859-1 进行解码，ISO-8859-1 不兼容中文</li>
<li>POST请求：POST 提交的数据在请求体中，其所使用的编码格式时页面一致（即 utf-8）。request 对象接收到数据之后，会将数据放到 request 缓冲区，缓冲区的默认字符集是 ISO-8859-1（该字符集不支持中文），两者使用的字符集不一致导致乱码。</li>
<li>GET请求：【jdk8之前，jdk8及之后版本不会乱码】
<ul>
<li>方式一：修改 tomcat/conf/server.xml 中的配置：<code v-pre>&lt;Connector port=&quot;80&quot; protocol=&quot;HTTP/1.1&quot; connectionTimeout=&quot;20000&quot; redirectPort=&quot;8443&quot; URIEncoding=&quot;UTF-8&quot;/&gt;</code>【第70行左右】</li>
<li>方式二：使用 URLEncoder 和 URLDecoder 进行编码和解码的操作（逆向编解码）：
<ul>
<li><code v-pre>String username = request.getParameter(&quot;username&quot;);</code></li>
<li><code v-pre>username = URLEncoder.encode(username, &quot;ISO8859-1&quot;);</code></li>
<li><code v-pre>username = URLDecoder.decode(username, &quot;UTF-8&quot;);</code></li>
</ul>
</li>
<li>方式三：使用 String 的构造方法：String(byte[] bytes, String charset) ，对字节数组（bytes）按照指定的字符集（charset）进行解码，返回解码后的字符串
<ul>
<li><code v-pre>String username = request.getParameter(&quot;username&quot;);</code></li>
<li><code v-pre>username = new String(username.getBytes(&quot;ISO-8859-1&quot;),&quot;UTF-8&quot;);</code></li>
</ul>
</li>
</ul>
</li>
<li>POST请求：
<ul>
<li>在获取请求参数之前设置 request 缓冲区字符集为 utf-8
<ul>
<li><code v-pre>request.setCharacterEncoding(&quot;utf-8&quot;);</code></li>
<li><code v-pre>String username = request.getParameter(&quot;username&quot;);</code></li>
</ul>
</li>
</ul>
</li>
</ul>
</li>
</ol>
<h4 id="_5-7-6-请求转发" tabindex="-1"><a class="header-anchor" href="#_5-7-6-请求转发" aria-hidden="true">#</a> 5.7.6 请求转发</h4>
<ol>
<li>含义：容器接收请求后，Servlet 会先对请求做一些预处理，然后将请求传递给其他 Web 资源，来完成包括生成响应在内的后续工作。</li>
<li>对象：RequestDispatcher对象由Servlet容器创建，用于封装由路径所标识的Web资源。利用RequestDispatcher 对象可以把请求转发给其他的 Web 资源。</li>
<li>获取RequestDispatcher对象：
<ul>
<li>调用 ServletContext 的 getRequestDispatcher(String path) 方法，参数 path 指定目标资源的路径，必须为绝对路径——以<code v-pre>/</code>打头；</li>
<li>调用 ServletRequest 的 getRequestDispatcher(String path) 方法，参数 path 指定目标资源的路径，可以为绝对路径，也可以为相对路径。</li>
<li>绝对路径是指以符号“/”开头的路径，“/”表示当前 Web 应用的根目录。相对路径是指相对当前 Web 资源的路径，不以符号“/”开头。</li>
</ul>
</li>
<li>RequestDispatcher对象的方法：
<ul>
<li><img src="/images/javaweb/image-1660813918418.png" alt="image.png" loading="lazy"></li>
</ul>
</li>
<li>请求转发特点：
<ul>
<li>请求转发不支持跨域访问，只能跳转到当前应用中的资源。</li>
<li>请求转发之后，浏览器地址栏中的 URL 不会发生变化，因此浏览器不知道在服务器内部发生了转发行为，更无法得知转发的次数。</li>
<li>参与请求转发的 Web 资源之间共享同一 request 对象和 response 对象。</li>
<li>由于 forward() 方法会先清空 response 缓冲区，因此只有转发到最后一个 Web 资源时，生成的响应才会被发送到客户端。</li>
</ul>
</li>
<li>request域对象：
<ul>
<li>作用：不同Servlet程序间传递数据</li>
<li>方法：
<ul>
<li><img src="/images/javaweb/image-1660813920671.png" alt="image.png" loading="lazy"></li>
</ul>
</li>
<li>与Context域对象的不同点：
<ul>
<li><img src="/images/javaweb/image-1660813923031.png" alt="image.png" loading="lazy"></li>
</ul>
</li>
</ul>
</li>
</ol>
<h4 id="_5-7-7-httpservletresponse类" tabindex="-1"><a class="header-anchor" href="#_5-7-7-httpservletresponse类" aria-hidden="true">#</a> 5.7.7 HttpServletResponse类</h4>
<ol>
<li>作用：每次Servlet容器接收到HTTP请求，就会创建一个HttpServletResponse对象，通过该对象，可以向客户端传递信息。</li>
<li>生命周期：Servlet容器接到HTTP请求时创建，Servlet容器将响应信息返回给客户端后销毁。</li>
<li>设置响应行的方法：
<ul>
<li><img src="/images/javaweb/image-1660813924894.png" alt="image.png" loading="lazy"></li>
</ul>
</li>
<li>设置响应头的方法
<ul>
<li><img src="/images/javaweb/image-1660813927311.png" alt="image.png" loading="lazy"></li>
</ul>
</li>
<li>向客户端传递信息（响应体设置）的方法：
<ul>
<li><img src="/images/javaweb/image-1660813930245.png" alt="image.png" loading="lazy"></li>
<li>getOutputStream() 和 getWriter() 方法互相排斥，不可同时使用，否则会发生 IllegalStateException 异常。</li>
</ul>
</li>
<li>中文乱码问题：
<ul>
<li>字节流输出：不一定乱码，取决于服务器Servlet程序的字符集是否与浏览器字符集一致。</li>
<li>字符流输出：一定乱码。response 缓冲区的默认字符集是 ISO-8859-1，该字符集不支持中文。</li>
<li>字节流解决方案：将中文转成字节数组时和浏览器默认采用的字符集保持一致
<ul>
<li><code v-pre>response.setHeader(&quot;Content-Type&quot;, &quot;text/html;charset=UTF-8&quot;);</code></li>
<li><code v-pre>byte[] str = &quot;编程帮 www.biancheng.net&quot;.getBytes(&quot;UTF-8&quot;);</code></li>
</ul>
</li>
<li>字符流解决方案：将resopnse缓冲区编码与浏览器设置一致
<ul>
<li>方式一：
<ul>
<li><code v-pre>response.setCharacterEncoding(&quot;UTF-8&quot;);</code></li>
<li><code v-pre>response.setHeader(&quot;Content-Type&quot;, &quot;text/html;charset=UTF-8&quot;);</code></li>
</ul>
</li>
<li>方式二：
<ul>
<li><code v-pre>response.setContentType(&quot;text/html;charset=UTF-8&quot;);</code></li>
</ul>
</li>
</ul>
</li>
</ul>
</li>
</ol>
<h4 id="_5-7-8-请求重定向" tabindex="-1"><a class="header-anchor" href="#_5-7-8-请求重定向" aria-hidden="true">#</a> 5.7.8 请求重定向</h4>
<ol>
<li>含义：服务器端接收到请求后，通知客户端去请求另外的地址。</li>
<li>属于客户端行为。</li>
<li>本质上是2次Http请求。</li>
<li>工作流程：
<ul>
<li><img src="/images/javaweb/image-1660813933673.png" alt="image.png" loading="lazy"></li>
</ul>
</li>
<li>重定向和转发的区别：
<ul>
<li><img src="/images/javaweb/image-1660813935590.png" alt="image.png" loading="lazy"></li>
</ul>
</li>
<li>方法：
<ul>
<li>方式一：
<ul>
<li><img src="/images/javaweb/image-1660813937750.png" alt="image.png" loading="lazy"></li>
</ul>
</li>
<li>方式二：（推荐）
<ul>
<li><img src="/images/javaweb/image-1660813939580.png" alt="image.png" loading="lazy"></li>
<li>注意路径问题，该路径由浏览器解析</li>
</ul>
</li>
</ul>
</li>
<li><strong>经典案例：生成验证码</strong></li>
</ol>
<h3 id="_5-8-webservlet注解-servlet注解" tabindex="-1"><a class="header-anchor" href="#_5-8-webservlet注解-servlet注解" aria-hidden="true">#</a> 5.8 @WebServlet注解（Servlet注解）</h3>
<h4 id="_5-8-1-servlet注解介绍" tabindex="-1"><a class="header-anchor" href="#_5-8-1-servlet注解介绍" aria-hidden="true">#</a> 5.8.1 Servlet注解介绍</h4>
<ol>
<li>出现原因：解决Servlet程序过多，web.xml文件过长的问题。</li>
<li>使用方式：注解写在Servlet程序（类）中，只对当前类有效。</li>
<li>出现版本：Servlet3.0，使用注解使web.xml不再是必选项。
<ul>
<li>@WebServlet</li>
<li>@WebInitParm</li>
<li>@WebFilter</li>
<li>@WebLitener等</li>
</ul>
</li>
</ol>
<h4 id="_5-8-2-webservlet注解的属性" tabindex="-1"><a class="header-anchor" href="#_5-8-2-webservlet注解的属性" aria-hidden="true">#</a> 5.8.2 @WebServlet注解的属性</h4>
<p><img src="/images/javaweb/image-1660813942463.png" alt="image.png" loading="lazy"></p>
<h4 id="_5-8-3-webservlet-注解的使用" tabindex="-1"><a class="header-anchor" href="#_5-8-3-webservlet-注解的使用" aria-hidden="true">#</a> 5.8.3 @WebServlet 注解的使用</h4>
<ol>
<li>在web.xml文件中，将属性<code v-pre>metadata-complete</code>设置为fasle或不配置时，表示启用注解支持，配置为true时，表示容器部署时至依赖web.xml</li>
<li>示例：</li>
</ol>
<blockquote>
<p>@WebServlet(
asyncSupported =<strong>true</strong>,
name =&quot;myServlet&quot;,
description =&quot;name描述&quot;,
loadOnStartup =1,
urlPatterns ={&quot;/MyServlet&quot;,&quot;/*&quot;},
initParams ={
@WebInitParam(name =&quot;编程帮&quot;, value =&quot;<a href="http://www.biancheng.net" target="_blank" rel="noopener noreferrer">www.biancheng.net<ExternalLinkIcon/></a>&quot;, description =&quot;init参数1&quot;),
@WebInitParam(name =&quot;京东&quot;, value =&quot;<a href="http://www.jd.com" target="_blank" rel="noopener noreferrer">www.jd.com<ExternalLinkIcon/></a>&quot;, description =&quot;init参数2&quot;)
})</p>
</blockquote>
<ol start="3">
<li>注意点：
<ul>
<li>通过实现 Serlvet 接口或继承 GenericServlet 创建的 Servlet 类无法使用 @WebServlet 注解。</li>
<li>通过web.xml文件和注解同时配置属性时，若取值相同则忽略注解中的配置。</li>
</ul>
</li>
</ol>
<h3 id="_5-9-listener-监听器" tabindex="-1"><a class="header-anchor" href="#_5-9-listener-监听器" aria-hidden="true">#</a> 5.9 Listener 监听器</h3>
<h4 id="_5-9-1-介绍" tabindex="-1"><a class="header-anchor" href="#_5-9-1-介绍" aria-hidden="true">#</a> 5.9.1 介绍</h4>
<ol>
<li>本质：JavaEE的规范（接口）</li>
<li>作用：监听另一个Java对象的方法调用或属性改变，当监听到上述事件，监听器的方法立即执行。</li>
</ol>
<h4 id="_5-9-2-分类" tabindex="-1"><a class="header-anchor" href="#_5-9-2-分类" aria-hidden="true">#</a> 5.9.2 分类</h4>
<ol>
<li>Servlet 规范中定义了 8 个监听器接口，可以用于监听 ServletContext、HttpSession 和 ServletRequest 对象的生命周期和属性变化事件。</li>
<li>开发 Servlet 监听器需要实现相应的监听器接口并重写接口中的方法。</li>
<li>按照监听的事件划分，分为三类：
<ul>
<li>监听对象创建和销毁的监听器</li>
<li>监听对象中属性变更的监听器</li>
<li>监听 HttpSession 中的对象状态改变的监听器</li>
</ul>
</li>
</ol>
<h4 id="_5-9-3-监听对象创建和销毁的监听器" tabindex="-1"><a class="header-anchor" href="#_5-9-3-监听对象创建和销毁的监听器" aria-hidden="true">#</a> 5.9.3 监听对象创建和销毁的监听器</h4>
<p><img src="/images/javaweb/image-1660813946211.png" alt="image.png" loading="lazy"></p>
<ul>
<li>目前仅有<code v-pre>ServletContextListener</code>有使用机会。
<ul>
<li>作用：监听<code v-pre>SrvletContext</code>对象的创建和销毁</li>
<li>生命周期：web工程启动时创建，web工程停止时销毁</li>
</ul>
</li>
</ul>
<h4 id="_5-9-4-监听属性变更的监听器" tabindex="-1"><a class="header-anchor" href="#_5-9-4-监听属性变更的监听器" aria-hidden="true">#</a> 5.9.4 监听属性变更的监听器</h4>
<p><img src="/images/javaweb/image-1660813948157.png" alt="image.png" loading="lazy"></p>
<h4 id="_5-9-5-监听-session-中对象状态改变的监听器" tabindex="-1"><a class="header-anchor" href="#_5-9-5-监听-session-中对象状态改变的监听器" aria-hidden="true">#</a> 5.9.5 监听 Session 中对象状态改变的监听器</h4>
<p><img src="/images/javaweb/image-1660813950697.png" alt="image.png" loading="lazy"></p>
<h4 id="_5-9-6-注册监听器" tabindex="-1"><a class="header-anchor" href="#_5-9-6-注册监听器" aria-hidden="true">#</a> 5.9.6 注册监听器</h4>
<ol>
<li>在 web.xml 中注册监听器；
<ul>
<li><img src="/images/javaweb/image-1660813955374.png" alt="image.png" loading="lazy"></li>
</ul>
</li>
<li>使用 @WebListener 注册监听器。</li>
<li>使用 HttpSessionBindingListener 和 HttpSessionActivationListener 时，不必进行注册，直接创建 Java 类实现这两个接口即可。</li>
</ol>
<h4 id="_5-9-7-设置监听器参数" tabindex="-1"><a class="header-anchor" href="#_5-9-7-设置监听器参数" aria-hidden="true">#</a> 5.9.7 设置监听器参数</h4>
<ol>
<li>在xml文件中设置初始化参数：</li>
</ol>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token annotation punctuation">@WebListener</span>
<span class="token keyword">public</span> <span class="token keyword">class</span> <span class="token class-name">ContextLoaderListener</span> <span class="token keyword">implements</span> <span class="token class-name">ServletContextListener</span> <span class="token punctuation">{</span>
    <span class="token annotation punctuation">@Override</span>
    <span class="token keyword">public</span> <span class="token keyword">void</span> <span class="token function">contextInitialized</span><span class="token punctuation">(</span><span class="token class-name">ServletContextEvent</span> servletContextEvent<span class="token punctuation">)</span> <span class="token punctuation">{</span>
        <span class="token comment">//1.获取ServletContext对象</span>
        <span class="token class-name">ServletContext</span> application <span class="token operator">=</span> servletContextEvent<span class="token punctuation">.</span><span class="token function">getServletContext</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token comment">//2.获取上下文的初始化参数</span>
        <span class="token class-name">String</span> path <span class="token operator">=</span> application<span class="token punctuation">.</span><span class="token function">getInitParameter</span><span class="token punctuation">(</span><span class="token string">"contextConfigLocation"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token comment">//3.创建IOC容器</span>
        <span class="token class-name">BeanFactory</span> beanFactory <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">ClassPathXmlApplicationContext</span><span class="token punctuation">(</span>path<span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token comment">//4.将IOC容器保存到application作用域</span>
        application<span class="token punctuation">.</span><span class="token function">setAttribute</span><span class="token punctuation">(</span><span class="token string">"beanFactory"</span><span class="token punctuation">,</span>beanFactory<span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token punctuation">}</span>
    
    <span class="token annotation punctuation">@Override</span>
    <span class="token keyword">public</span> <span class="token keyword">void</span> <span class="token function">contextDestroyed</span><span class="token punctuation">(</span><span class="token class-name">ServletContextEvent</span> servletContextEvent<span class="token punctuation">)</span> <span class="token punctuation">{</span>
        
    <span class="token punctuation">}</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><h4 id="_5-9-7-经典案例——统计在线人数" tabindex="-1"><a class="header-anchor" href="#_5-9-7-经典案例——统计在线人数" aria-hidden="true">#</a> 5.9.7 经典案例——统计在线人数</h4>
<h3 id="_5-x-其他技术" tabindex="-1"><a class="header-anchor" href="#_5-x-其他技术" aria-hidden="true">#</a> 5.x 其他技术</h3>
<h4 id="_5-x-1-jsp" tabindex="-1"><a class="header-anchor" href="#_5-x-1-jsp" aria-hidden="true">#</a> 5.x.1 JSP</h4>
<ol>
<li>Servlet是第一代Java Web开发技术，编写HTML代码相当于拼接字符串，最后以字符串的形式向外输出。</li>
<li>JSP是第二代Java Web开发技术。允许 HTML 代码和 JSP 代码分离，让程序员能够在 HTML 文档中直接嵌入 JSP 代码。 分离了还是嵌入了？？？？</li>
</ol>
<h4 id="_5-x-2-applet" tabindex="-1"><a class="header-anchor" href="#_5-x-2-applet" aria-hidden="true">#</a> 5.x.2 Applet</h4>
<ol>
<li>Applet是客户端小程序，一般嵌入HTML页面，运行在支持Java的浏览器（安装了Java虚拟机）中。</li>
<li>目前已经被JavaScript全面代替。</li>
</ol>
<h2 id="第6章-xml" tabindex="-1"><a class="header-anchor" href="#第6章-xml" aria-hidden="true">#</a> 第6章 XML</h2>
<p><a href="https://www.yuque.com/attachments/yuque/0/2022/pdf/1604140/1656817155842-f32022ea-88f2-4c60-9aee-e42ffa537ff8.pdf" target="_blank" rel="noopener noreferrer">05_尚硅谷_xml_王振国 - 课堂笔记.pdf<ExternalLinkIcon/></a></p>
<h3 id="_6-1-作用" tabindex="-1"><a class="header-anchor" href="#_6-1-作用" aria-hidden="true">#</a> 6.1 作用</h3>
<ol>
<li>用来保存数据，而且这些数据具有自我描述性</li>
<li>它还可以做为项目或者模块的配置文件</li>
<li>还可以做为网络传输数据的格式（现在 JSON 为主）。</li>
</ol>
<h3 id="_6-2-语法" tabindex="-1"><a class="header-anchor" href="#_6-2-语法" aria-hidden="true">#</a> 6.2 语法</h3>
<h4 id="_6-2-1-文档声明" tabindex="-1"><a class="header-anchor" href="#_6-2-1-文档声明" aria-hidden="true">#</a> 6.2.1 文档声明</h4>
<ol>
<li><code v-pre>&lt;?xml version=&quot;1.0&quot; encoding=&quot;UTF-8&quot;?&gt;</code>
<ul>
<li><code v-pre>&lt;?xml</code>要连写在一起，否则会报错</li>
<li><code v-pre>version</code>版本号</li>
<li><code v-pre>encoding</code>编码</li>
<li><code v-pre>standalone=&quot;yes/no&quot;</code>表示这个xml文件是否是独立的xml文件</li>
</ul>
</li>
<li>xml是强语言，必须符合语法规则。使用浏览器打开会进行语法校验。</li>
<li>xml文档必须要有一对根标签（顶级标签——没有父级标签的标签），且必须唯一。</li>
</ol>
<h4 id="_6-2-2-xml注释" tabindex="-1"><a class="header-anchor" href="#_6-2-2-xml注释" aria-hidden="true">#</a> 6.2.2 xml注释</h4>
<ol>
<li>同HTML</li>
</ol>
<h4 id="_6-2-3-xml元素" tabindex="-1"><a class="header-anchor" href="#_6-2-3-xml元素" aria-hidden="true">#</a> 6.2.3 xml元素</h4>
<ol>
<li>元素是指从开始标签到结束标签的内容。</li>
<li>特殊字符语法同HTML</li>
<li>文本区域（CDATA）：告诉xml解析器，改区域内的内容为纯文本，不需要解析
<ul>
<li><code v-pre>&lt;![CDATA[ 内容xxxx ]]&gt;</code></li>
</ul>
</li>
</ol>
<h4 id="_6-2-4-xml标签" tabindex="-1"><a class="header-anchor" href="#_6-2-4-xml标签" aria-hidden="true">#</a> 6.2.4 xml标签</h4>
<ol>
<li>标签名可以含字母、数字以及其他的字符</li>
<li>标签名不能以数字或标点符号开始</li>
<li><s>标签名不能以</s><code v-pre>~~xml~~</code><s>、</s><code v-pre>~~XML~~</code><s>、</s><code v-pre>~~Xml~~</code><s>开始</s>——验证可行。</li>
<li>标签名不能包含空格。</li>
<li>标签分为单标签和双标签，但必须闭合。</li>
<li>标签的属性值必须使用<code v-pre>&quot;&quot;</code>包裹</li>
<li>标签对大小写敏感</li>
<li>标签必须正确嵌套</li>
</ol>
<h3 id="_6-3-xml解析技术" tabindex="-1"><a class="header-anchor" href="#_6-3-xml解析技术" aria-hidden="true">#</a> 6.3 xml解析技术</h3>
<h4 id="_6-3-1-dom解析技术" tabindex="-1"><a class="header-anchor" href="#_6-3-1-dom解析技术" aria-hidden="true">#</a> 6.3.1 dom解析技术</h4>
<ol>
<li>w3c制定</li>
</ol>
<h4 id="_6-3-2-sax解析技术" tabindex="-1"><a class="header-anchor" href="#_6-3-2-sax解析技术" aria-hidden="true">#</a> 6.3.2 Sax解析技术</h4>
<ol>
<li>sun公司在jdk5版本对dom技术进行了升级：Sax（Simple api for xml）</li>
<li>使用了类似事件机制，边读取边解析。</li>
</ol>
<h4 id="_6-3-4-dom4j" tabindex="-1"><a class="header-anchor" href="#_6-3-4-dom4j" aria-hidden="true">#</a> 6.3.4 dom4j</h4>
<ol>
<li>第三方解析</li>
<li>是对jdom的封装，jdom是对dom的封装</li>
<li>使用：
<ul>
<li>引入jar包</li>
<li>创建xml对应的类（JavaBean）</li>
<li>创建一个SAXReader对象：<code v-pre>SAXReader reader = new SAXReader()</code></li>
<li>通过SAXReader对象读取xml文件，并获取document对象：<code v-pre>Document document = reader.read(url)</code></li>
<li>通过document对象，获取根元素对象（Element类型）：<code v-pre>Element root = document.getRootElement()</code>
<ul>
<li>根元素对象的<code v-pre>asXML()</code>方法可以将Element对象转换为String</li>
</ul>
</li>
<li>通过根元素对象获取所有子元素集合：<code v-pre>List&lt;Element&gt; books = root.elements()</code>
<ul>
<li>单个子元素使用<code v-pre>element()</code>方法</li>
<li>可传入参数，传入参数时，参数名与子元素标签名一致。</li>
</ul>
</li>
<li>循环遍历得到每个book对象的各类属性对象，仍然使用<code v-pre>elements()</code>或<code v-pre>element()</code>方法</li>
<li>使用<code v-pre>getText</code>方法得到元素的内容。
<ul>
<li><code v-pre>element()</code>和<code v-pre>getText()</code>可以整合成一个<code v-pre>elementText()</code></li>
</ul>
</li>
<li>获取属性值：<code v-pre>attributeValue()</code></li>
</ul>
</li>
</ol>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token keyword">package</span> <span class="token namespace">service</span><span class="token punctuation">;</span>

<span class="token keyword">import</span> <span class="token import"><span class="token namespace">domain<span class="token punctuation">.</span></span><span class="token class-name">Book</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">org<span class="token punctuation">.</span>dom4j<span class="token punctuation">.</span></span><span class="token class-name">Document</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">org<span class="token punctuation">.</span>dom4j<span class="token punctuation">.</span></span><span class="token class-name">DocumentException</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">org<span class="token punctuation">.</span>dom4j<span class="token punctuation">.</span></span><span class="token class-name">Element</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">org<span class="token punctuation">.</span>dom4j<span class="token punctuation">.</span>io<span class="token punctuation">.</span></span><span class="token class-name">SAXReader</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">java<span class="token punctuation">.</span>util<span class="token punctuation">.</span></span><span class="token class-name">List</span></span><span class="token punctuation">;</span>

<span class="token doc-comment comment">/**
* <span class="token keyword">@author</span>: INFINITY https://juejin.cn/user/2788017217999896/posts
* <span class="token keyword">@date</span>: 2022/7/1 13:30
*/</span>
<span class="token keyword">public</span> <span class="token keyword">class</span> <span class="token class-name">Dom4jParseXML</span> <span class="token punctuation">{</span>
    <span class="token keyword">public</span> <span class="token keyword">static</span> <span class="token keyword">void</span> <span class="token function">main</span><span class="token punctuation">(</span><span class="token class-name">String</span><span class="token punctuation">[</span><span class="token punctuation">]</span> args<span class="token punctuation">)</span> <span class="token keyword">throws</span> <span class="token class-name">DocumentException</span> <span class="token punctuation">{</span>
        <span class="token class-name">SAXReader</span> saxReader <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">SAXReader</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token class-name">Document</span> document <span class="token operator">=</span> saxReader<span class="token punctuation">.</span><span class="token function">read</span><span class="token punctuation">(</span><span class="token string">"file:\\D:\\实践练习\\07.JavaWeb\\parsexml\\src\\books.xml"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token class-name">Element</span> rootElement <span class="token operator">=</span> document<span class="token punctuation">.</span><span class="token function">getRootElement</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token class-name">List</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">Element</span><span class="token punctuation">></span></span> books <span class="token operator">=</span> rootElement<span class="token punctuation">.</span><span class="token function">elements</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token keyword">for</span><span class="token punctuation">(</span><span class="token class-name">Element</span> book <span class="token operator">:</span> books<span class="token punctuation">)</span><span class="token punctuation">{</span>
            <span class="token class-name">String</span> sn <span class="token operator">=</span> book<span class="token punctuation">.</span><span class="token function">attributeValue</span><span class="token punctuation">(</span><span class="token string">"sn"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
            <span class="token class-name">Element</span> nameElement <span class="token operator">=</span> book<span class="token punctuation">.</span><span class="token function">element</span><span class="token punctuation">(</span><span class="token string">"name"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
            <span class="token class-name">String</span> nameElementText <span class="token operator">=</span> nameElement<span class="token punctuation">.</span><span class="token function">getText</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
            <span class="token class-name">Element</span> priceElement <span class="token operator">=</span> book<span class="token punctuation">.</span><span class="token function">element</span><span class="token punctuation">(</span><span class="token string">"price"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
            <span class="token class-name">String</span> priceElementText <span class="token operator">=</span> priceElement<span class="token punctuation">.</span><span class="token function">getText</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
            <span class="token class-name">String</span> authorElement <span class="token operator">=</span> book<span class="token punctuation">.</span><span class="token function">elementText</span><span class="token punctuation">(</span><span class="token string">"author"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
            <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span><span class="token keyword">new</span> <span class="token class-name">Book</span><span class="token punctuation">(</span>sn<span class="token punctuation">,</span>nameElementText<span class="token punctuation">,</span><span class="token class-name">Double</span><span class="token punctuation">.</span><span class="token function">parseDouble</span><span class="token punctuation">(</span>priceElementText<span class="token punctuation">)</span><span class="token punctuation">,</span>authorElement<span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token punctuation">}</span>
    <span class="token punctuation">}</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><h4 id="_6-3-5-pull" tabindex="-1"><a class="header-anchor" href="#_6-3-5-pull" aria-hidden="true">#</a> 6.3.5 pull</h4>
<ol>
<li>类似于sax，利用事件机制，用于Android开发</li>
</ol>
<h2 id="第7章-http协议" tabindex="-1"><a class="header-anchor" href="#第7章-http协议" aria-hidden="true">#</a> 第7章 HTTP协议</h2>
<h3 id="_7-1-http协议简述" tabindex="-1"><a class="header-anchor" href="#_7-1-http协议简述" aria-hidden="true">#</a> 7.1 Http协议简述</h3>
<ol>
<li>HyperText Transfer Protocol：超文本传输协议</li>
<li>基于 TCP/IP 通信协议来传递数据</li>
<li>http是无状态的，服务器无法判断两次请求时同一客户端发送，还是不同客户端发送。
<ul>
<li>通过会话跟踪技术解决无状态问题【session】</li>
</ul>
</li>
</ol>
<h3 id="_7-2-http请求" tabindex="-1"><a class="header-anchor" href="#_7-2-http请求" aria-hidden="true">#</a> 7.2 Http请求</h3>
<h4 id="_7-2-1-请求结构" tabindex="-1"><a class="header-anchor" href="#_7-2-1-请求结构" aria-hidden="true">#</a> 7.2.1 请求结构</h4>
<ol>
<li>由四个部分组成，分别为请求行、请求头、空行和请求体</li>
</ol>
<p><img src="/images/javaweb/5-200929133350160.gif" alt="" loading="lazy"></p>
<ul>
<li>上面的<code v-pre>URL</code>应该是<code v-pre>URI</code>？</li>
</ul>
<h4 id="_7-2-2-请求行" tabindex="-1"><a class="header-anchor" href="#_7-2-2-请求行" aria-hidden="true">#</a> 7.2.2 请求行</h4>
<ol>
<li>请求行是由请求方法、请求 URI（URI 全称为 Universal Resource Identifier，中文含义为“统一资源标志符”，是用来标识抽象或物理资源的字符串）和 HTTP 协议版本三个部分组成，每个部分使用空格分隔，在请求行的最后以回车符与换行符结尾。</li>
<li>8种请求方法：
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
| PATCH | 是对 PUT 方法的补充，用来对已知资源进行局部更新 |</li>
</ol>
<h4 id="_7-2-3-请求头" tabindex="-1"><a class="header-anchor" href="#_7-2-3-请求头" aria-hidden="true">#</a> 7.2.3 请求头</h4>
<ol>
<li>请求头是客户端传递给服务器的一系列有关本次请求和客户端本身的相关信息。请求头一般由头部字段名、冒号（:）、空格、值组成</li>
</ol>
<p><img src="/images/javaweb/image-1660813966216.png" alt="image.png" loading="lazy"></p>
<h4 id="_7-2-4-空行" tabindex="-1"><a class="header-anchor" href="#_7-2-4-空行" aria-hidden="true">#</a> 7.2.4 空行</h4>
<ul>
<li>由回车符和换行符组成，无特殊含义，分隔请求行和请求体</li>
</ul>
<h4 id="_7-2-5-请求体" tabindex="-1"><a class="header-anchor" href="#_7-2-5-请求体" aria-hidden="true">#</a> 7.2.5 请求体</h4>
<ul>
<li>
<p>一般出现在POST请中，表示提交给服务器的数据，以<code v-pre>key=value&amp;key=value</code>的形式传输</p>
</li>
<li>
<p>get请求：没有请求体，但有一个queryString</p>
</li>
<li></li>
</ul>
<h4 id="_7-2-6-get请求" tabindex="-1"><a class="header-anchor" href="#_7-2-6-get请求" aria-hidden="true">#</a> 7.2.6 GET请求</h4>
<ol>
<li>由请求行和请求头两部分组成</li>
<li>常见组成内容含义：
<ul>
<li><img src="/images/javaweb/image-1660813969163.png" alt="image.png" loading="lazy"></li>
</ul>
</li>
<li>GET请求有哪些：
<ul>
<li>form 标签method=get</li>
<li>a 标签</li>
<li>link 标签引入css</li>
<li>Script 标签引入js 文件</li>
<li>img 标签引入图片</li>
<li>iframe 引入html 页面</li>
<li>在浏览器地址栏中输入地址后敲回车</li>
</ul>
</li>
</ol>
<h4 id="_7-2-7-post请求" tabindex="-1"><a class="header-anchor" href="#_7-2-7-post请求" aria-hidden="true">#</a> 7.2.7 POST请求</h4>
<ol>
<li>由请求行、请求头、请求体三部分组成</li>
<li>常见组成内容含义：
<ul>
<li><img src="/images/javaweb/image-1660813972156.png" alt="image.png" loading="lazy"></li>
</ul>
</li>
<li>POST请求有哪些
<ul>
<li>form 标签method=post</li>
</ul>
</li>
</ol>
<h3 id="_7-3-http响应" tabindex="-1"><a class="header-anchor" href="#_7-3-http响应" aria-hidden="true">#</a> 7.3 HTTP响应</h3>
<h4 id="_7-3-1-响应结构" tabindex="-1"><a class="header-anchor" href="#_7-3-1-响应结构" aria-hidden="true">#</a> 7.3.1 响应结构</h4>
<ol>
<li>由响应行（状态行）、响应头、空行和响应体组成</li>
</ol>
<p><img src="/images/javaweb/5-20092913350O96.gif" alt="" loading="lazy"></p>
<h4 id="_7-3-2-响应行" tabindex="-1"><a class="header-anchor" href="#_7-3-2-响应行" aria-hidden="true">#</a> 7.3.2 响应行</h4>
<ol>
<li>由HTTP 协议版本、表示响应状态的状态码和形容这个状态词三部分组成
<ul>
<li>协议版本号，当前一般为<code v-pre>HTTP1.1</code></li>
<li>响应状态：
<ul>
<li><img src="/images/javaweb/image-1660813977376.png" alt="image.png" loading="lazy"></li>
<li>状态词：OK、Not Modified、Found 等。</li>
</ul>
</li>
</ul>
</li>
</ol>
<h4 id="_7-3-3-响应头" tabindex="-1"><a class="header-anchor" href="#_7-3-3-响应头" aria-hidden="true">#</a> 7.3.3 响应头</h4>
<ol>
<li>由头部字段名、冒号、空格和值组成。</li>
</ol>
<p><img src="/images/javaweb/image-1660813981756.png" alt="image.png" loading="lazy"></p>
<h4 id="_7-3-4-空行" tabindex="-1"><a class="header-anchor" href="#_7-3-4-空行" aria-hidden="true">#</a> 7.3.4 空行</h4>
<ul>
<li>同请求空行</li>
</ul>
<h4 id="_7-3-5-响应体" tabindex="-1"><a class="header-anchor" href="#_7-3-5-响应体" aria-hidden="true">#</a> 7.3.5 响应体</h4>
<ul>
<li>服务器根据客户端的请求返回给客户端的具体数据。</li>
</ul>
<h4 id="_7-3-6-响应示例" tabindex="-1"><a class="header-anchor" href="#_7-3-6-响应示例" aria-hidden="true">#</a> 7.3.6 响应示例</h4>
<p><img src="/images/javaweb/image-1660813985681.png" alt="image.png" loading="lazy"></p>
<h4 id="_7-3-7-常见响应状态码" tabindex="-1"><a class="header-anchor" href="#_7-3-7-常见响应状态码" aria-hidden="true">#</a> 7.3.7 常见响应状态码</h4>
<ol>
<li>200：请求成功。</li>
<li>302：请求重定向</li>
<li>404：服务器收到了请求，但客户端需要的资源不存在（请求地址有误）</li>
<li>500：服务器收到了请求，但服务器内部错误（代码错误）</li>
</ol>
<h3 id="_7-4-mime类型" tabindex="-1"><a class="header-anchor" href="#_7-4-mime类型" aria-hidden="true">#</a> 7.4 MIME类型</h3>
<ol>
<li>Multipurpose Internet Mail Extensions，多用途互联网邮件扩展类型”，它是一种标准，用来表示文档、文件或字节流的性质和格式。</li>
<li>设定在请求头的Acdept中，格式如下：
<ul>
<li><code v-pre>Accept: type/subtype [q=qvalue]</code></li>
<li>[q=qvalue]是可选项，表示MIME优先顺序（权重），取值范围为0~1</li>
<li>多个MIME使用<code v-pre>;</code>隔开</li>
</ul>
</li>
<li>常见类型：
<ul>
<li><img src="/images/javaweb/image-1660813989003.png" alt="image.png" loading="lazy"></li>
</ul>
</li>
</ol>
<h2 id="第8章-jsp" tabindex="-1"><a class="header-anchor" href="#第8章-jsp" aria-hidden="true">#</a> 第8章 JSP</h2>
<h3 id="_8-1-jsp入门" tabindex="-1"><a class="header-anchor" href="#_8-1-jsp入门" aria-hidden="true">#</a> 8.1 JSP入门</h3>
<h4 id="_8-1-1-jsp介绍" tabindex="-1"><a class="header-anchor" href="#_8-1-1-jsp介绍" aria-hidden="true">#</a> 8.1.1 JSP介绍</h4>
<ol>
<li>JSP是Java Servlet Pages的所系，是一种动态网页开发技术。
<ul>
<li>动态网页显式内容可以随时间、环境或数据库操作的结果而发生改变。</li>
</ul>
</li>
<li>本质：JSP本质是一个Java类（Servlet），可以在JSP页面嵌入Java代码。</li>
<li>运行过程：客户端请求JSP时，服务器内部会经历一次动态资源（JSP）到静态资源（HTML）的转化。服务器会自动把 JSP 中的 HTML 片段和数据拼接成静态资源响应给浏览器。也就是说，JSP 运行在服务器端，但最终发给客户端的是已经转换好的 HTML 静态页面。</li>
<li>组成：包括 Java Bean、自定义标签（Custom Tags）、EL 表达式（Expression Language）、JSTL 标准标签类库（Java Standard Tag Library）等。</li>
<li>JSP与Servlet的异同：
<ul>
<li>相同点：都用于生成动态网页</li>
<li>不同点：<img src="/images/javaweb/image-1660813992123.png" alt="image.png" loading="lazy"></li>
</ul>
</li>
</ol>
<h4 id="_8-1-2-jsp生命周期" tabindex="-1"><a class="header-anchor" href="#_8-1-2-jsp生命周期" aria-hidden="true">#</a> 8.1.2 JSP生命周期</h4>
<ol>
<li>编译：当浏览器请求 JSP 时，JSP 容器会首先检查是否需要编译页面。如果该页面从未被编译过，或者自上次编译以来对其进行了修改，则编译该页面。（JSP容器就是Servlet容器——Tomcat）
<ul>
<li>解析 JSP：JSP 容器解析 JSP 文件，查看是否有语法错误</li>
<li>翻译 JSP：JSP 容器把 JSP 文件翻译为 Servlet 类</li>
<li>编译 Servlet</li>
</ul>
</li>
<li>初始化：当容器加载 JSP 时，它将在处理任何请求之前调用 jspInit() 方法。一般情况下，程序只初始化一次。与 Servlet init 方法一样，我们通常在 jspInit() 方法中初始化数据库连接、打开文件。</li>
<li>执行：SP 页面完成初始化后，JSP 将会调用 _jspService() 方法。_jspService() 以 HttpServletRequest 对象和 HttpServletResponse 对象作为方法参数。</li>
<li>销毁：从容器中删除 JSP。jspDestroy() 方法等效于 Servlet 中的 destroy() 方法。通常在 jspDestroy() 方法中释放数据库连接、关闭打开的文件。</li>
</ol>
<h3 id="_8-2-jsp语句" tabindex="-1"><a class="header-anchor" href="#_8-2-jsp语句" aria-hidden="true">#</a> 8.2 JSP语句</h3>
<h4 id="_8-2-1-jsp脚本" tabindex="-1"><a class="header-anchor" href="#_8-2-1-jsp脚本" aria-hidden="true">#</a> 8.2.1 JSP脚本</h4>
<ol>
<li>含义：在JSP页面中，写入Java代码。</li>
<li>作用：在jsp页面中编写java功能</li>
<li>特点：
<ul>
<li>脚本翻译之后都在_jspService 方法中</li>
<li>在_jspService()方法中的现有对象都可以直接使用。</li>
<li>多个jsp脚本块组合完成一个完整的 java 语句。</li>
<li>和jsp表达式组合使用，在 jsp中数据数据。</li>
</ul>
</li>
<li>JSP 脚本可以包含任意数量的 Java 语句，变量、方法和表达式。JSP 脚本会把包含的内容插入到 Servlet 的 service() 方法中。</li>
<li>语法：<code v-pre>&lt;% Java语句 %&gt;</code>
<ul>
<li>等价于<code v-pre>&lt;jsp:script&gt; Java语句 &lt;/jsp:script&gt;</code></li>
<li>任何文本、HTML 标签和 JSP 元素（声明，表达式等）都必须在脚本程序之外。</li>
</ul>
</li>
</ol>
<h4 id="_8-2-2-jsp声明" tabindex="-1"><a class="header-anchor" href="#_8-2-2-jsp声明" aria-hidden="true">#</a> 8.2.2 JSP声明</h4>
<ol>
<li>作用：用于声明一个或多个变量、方法，以供后面的 Java 代码使用。
<ul>
<li>声明属性</li>
<li>声明static代码块</li>
<li>声明方法</li>
<li>声明内部类</li>
</ul>
</li>
<li>语法：<code v-pre>&lt;%! Java语句 %&gt;</code>
<ul>
<li>等价于<code v-pre>&lt;jsp:declaration&gt; Java语句 &lt;/jsp:declaration&gt;</code></li>
</ul>
</li>
<li>与JSP脚本的区别：
<ul>
<li>JSP 脚本只能声明变量，不能声明方法。JSP 声明语句可以声明变量和方法。
<ul>
<li>JSP脚本声明的内容会插入到Servlet的service()方法中，而Java中方法不允许嵌套方法</li>
<li>JSP声明声明的内容会添加到Servlet类中，是类的成员。</li>
</ul>
</li>
</ul>
</li>
</ol>
<h4 id="_8-2-3-jsp表达式" tabindex="-1"><a class="header-anchor" href="#_8-2-3-jsp表达式" aria-hidden="true">#</a> 8.2.3 JSP表达式</h4>
<ol>
<li>作用：把变量或者表达式输出到网页上，不需要 out.print() 就能输出数据。通常用于打印变量和方法的值。</li>
<li>语法：<code v-pre>&lt;%= Java语句 %&gt;</code>
<ul>
<li>等价于<code v-pre>&lt;jsp:expression&gt; Java语句 &lt;/jsp:expression&gt;</code></li>
</ul>
</li>
<li>特点：
<ul>
<li>都会被翻译到_jspService() 方法中</li>
<li>都会被翻译成为 out.print()输出到页面上</li>
<li>_jspService()方法中的对象都可以直接使用。</li>
<li>表达式不能以分号结束。</li>
</ul>
</li>
</ol>
<h4 id="_8-2-4-jsp注释" tabindex="-1"><a class="header-anchor" href="#_8-2-4-jsp注释" aria-hidden="true">#</a> 8.2.4 JSP注释</h4>
<ol>
<li>JSP页面中，可以有四种注释。
<ul>
<li>HTML注释：<code v-pre>&lt;-- 注释内容 --&gt;</code>。 会被翻译到 java 源代码中。在_jspService 方法里，以 out.writer 输出到客户端。
<ul>
<li>客户端访问看不到，客户端检查源码可以看到</li>
</ul>
</li>
<li>HTM注释中嵌套JSP表达式：<code v-pre>&lt;-- 注释内容 &lt;%= java语句 %&gt; --&gt;</code>
<ul>
<li>客户端访问看不到，客户端检查源码可以看到翻译后的JSP表达式</li>
</ul>
</li>
<li>隐藏注释：<code v-pre>&lt;%-- 注释内容 --%&gt;</code>
<ul>
<li>客户端访问看不到，客户端检查源码也看不到</li>
</ul>
</li>
<li>脚本程序（Scriptlet）中的注释：客户端访问看不到，客户端检查源码也看不到
<ul>
<li>单行注释：<code v-pre>//</code></li>
<li>多行注释：<code v-pre>/* */</code></li>
<li>文档注释：<code v-pre>/** */</code></li>
</ul>
</li>
</ul>
</li>
</ol>
<h3 id="_8-3-jsp指令" tabindex="-1"><a class="header-anchor" href="#_8-3-jsp指令" aria-hidden="true">#</a> 8.3 JSP指令</h3>
<ol>
<li>作用：告诉 Web 服务器如何处理 JSP 页面的请求和响应。服务器会根据 JSP 指令来编译 JSP，生成 Java 文件。JSP 指令不产生任何可见输出，在生成的 Java 文件中，不存在 JSP 指令。</li>
<li>语法：<code v-pre>&lt;%@ directive attribute = &quot;value&quot; [attribute2 = &quot;value2&quot; ...]%&gt;</code></li>
<li>分类：
<ul>
<li><img src="/images/javaweb/image-1660813996806.png" alt="image.png" loading="lazy"></li>
</ul>
</li>
</ol>
<h4 id="_8-3-1-jsp-page指令" tabindex="-1"><a class="header-anchor" href="#_8-3-1-jsp-page指令" aria-hidden="true">#</a> 8.3.1 JSP page指令</h4>
<ol>
<li>作用：定义当前页面的相关属性。可以在 JSP 页面的任意位置编写，通常放在页面的顶部</li>
<li>语法：<code v-pre>&lt;%@ page attribute = &quot;value&quot; %&gt;</code></li>
<li>常用属性：
<ul>
<li><img src="/images/javaweb/image-1660813999069.png" alt="image.png" loading="lazy"></li>
<li>import可以声明多个，其他只能出现一个</li>
</ul>
</li>
</ol>
<h4 id="_8-3-2-jsp-include指令" tabindex="-1"><a class="header-anchor" href="#_8-3-2-jsp-include指令" aria-hidden="true">#</a> 8.3.2 JSP include指令</h4>
<ol>
<li>作用：在 JSP 页面引入其它内容，可以是 JSP 文件、html 文件和文本文件等，相当于把文件的内容复制到 JSP 页面。引入的文件和 JSP 页面同时编译运行。</li>
<li>语法：<code v-pre>&lt;%@ include file=&quot;URL&quot; %&gt;</code> ，url代表相对路径，必须以<code v-pre>/</code>开头</li>
<li>优点：
<ul>
<li>增加代码的可重用性</li>
<li>使 JSP 页面的代码结构清晰易懂</li>
<li>维护简单</li>
</ul>
</li>
<li>特点：静态包含的页面会出现在包含它的jsp页面翻译后的servlet程序中
<ul>
<li>out.write()</li>
</ul>
</li>
</ol>
<h4 id="_8-3-3-jsp-taglib指令" tabindex="-1"><a class="header-anchor" href="#_8-3-3-jsp-taglib指令" aria-hidden="true">#</a> 8.3.3 JSP taglib指令</h4>
<ol>
<li>作用：声明并引入标签库。Java API 允许在页面中自定义标签，标签库就是自定义标签的集合。</li>
<li>语法：<code v-pre>&lt;%@ taglib uri=&quot;tagliburl&quot; prefix=&quot;tagPre&quot; %&gt;</code>
<ul>
<li>uri指定自定义标签库的存放位置；prefix 指定标签库的前缀。</li>
</ul>
</li>
</ol>
<h3 id="_8-4-jsp动作" tabindex="-1"><a class="header-anchor" href="#_8-4-jsp动作" aria-hidden="true">#</a> 8.4 JSP动作</h3>
<p>未学</p>
<h3 id="_8-5-jsp-九大内置对象" tabindex="-1"><a class="header-anchor" href="#_8-5-jsp-九大内置对象" aria-hidden="true">#</a> 8.5 JSP 九大内置对象</h3>
<h4 id="_8-5-1-九大内置对象介绍" tabindex="-1"><a class="header-anchor" href="#_8-5-1-九大内置对象介绍" aria-hidden="true">#</a> 8.5.1 九大内置对象介绍</h4>
<ol>
<li>作用：简化页面开发过程。</li>
<li>特点：JSP 内置对象又称为隐式对象，它们由容器实现和管理。在 JSP 页面中，这些内置对象不需要预先声明，也不需要进行实例化，可以直接在脚本和表达式中使用。
<ul>
<li>Tomcat将jsp页面翻译成Servlet源码后，内部提供</li>
<li>不能在JSP声明中使用</li>
</ul>
</li>
<li>分类：含4大域对象
<ul>
<li><img src="/images/javaweb/image-1660814002836.png" alt="image.png" loading="lazy"></li>
</ul>
</li>
<li>四大域对象：pageContext（page 域对象）、request（request 域对象）、session（session 域对象）、以及 application（application 域对象）
<ul>
<li>操作域对象的3个方法：
<ul>
<li><img src="/images/javaweb/image-1660814006417.png" alt="image.png" loading="lazy"></li>
</ul>
</li>
<li>4个域对象的不同点：
<ul>
<li><img src="/images/javaweb/image-1660814008238.png" alt="image.png" loading="lazy"></li>
</ul>
</li>
<li>使用原则：从小到大。page到application。对于内存的优化</li>
</ul>
</li>
</ol>
<h4 id="_8-5-2-pagecontext对象" tabindex="-1"><a class="header-anchor" href="#_8-5-2-pagecontext对象" aria-hidden="true">#</a> 8.5.2 pageContext对象</h4>
<ol>
<li>javax.servlet.jsp.PageContext 的实例对象。</li>
<li>本质是Servlet的ServletContext</li>
<li>常用方法：
<ul>
<li><img src="/images/javaweb/image-1660814010471.png" alt="image.png" loading="lazy"></li>
</ul>
</li>
</ol>
<h4 id="_8-5-3-request对象" tabindex="-1"><a class="header-anchor" href="#_8-5-3-request对象" aria-hidden="true">#</a> 8.5.3 request对象</h4>
<ol>
<li>javax.servlet.http.HttpServletRequest 的实例对象</li>
<li>常用方法：
<ul>
<li><img src="/images/javaweb/image-1660814012637.png" alt="image.png" loading="lazy"></li>
<li><code v-pre>getScheme()</code>：获取请求协议</li>
<li><code v-pre>getServerName()</code>：获取服务器IP地址</li>
<li><code v-pre>getServerPort()</code>：获取服务器端口号</li>
<li><code v-pre>getContextPath()</code>：获取工程路径（名）</li>
</ul>
</li>
</ol>
<h4 id="_8-5-4-session对象" tabindex="-1"><a class="header-anchor" href="#_8-5-4-session对象" aria-hidden="true">#</a> 8.5.4 session对象</h4>
<ol>
<li>javax.servlet.http.HttpSession 的实例对象，主要用来访问用户数据，记录客户的连接信息。</li>
<li>HTTP 协议是一种无状态的协议（即不保存连接状态的协议）。每次用户向服务器发出请求，且服务器接收请求并返回响应后，该连接就被关闭了，服务器端与客户端的连接被断开。此时，服务器端不保留连接的有关信息，要想记住客户的连接信息，就用到了 session 对象。</li>
<li>常用方法：
<ul>
<li><img src="/images/javaweb/image-1660814015963.png" alt="image.png" loading="lazy"></li>
</ul>
</li>
</ol>
<h4 id="_8-5-5-application对象" tabindex="-1"><a class="header-anchor" href="#_8-5-5-application对象" aria-hidden="true">#</a> 8.5.5 application对象</h4>
<ol>
<li>javax.servlet.ServletContext 的实例对象。一般用于保存应用程序的公用数据。非常占用服务器资源，实际开发中一般不用。</li>
<li>application 是 pageContext的一种，获取pageContext的参数可以获得application\session\request\page范围的所有参数；而获取application参数则不能获取其他三个范围的参数。</li>
<li>常用方法：
<ul>
<li><img src="/images/javaweb/image-1660814018073.png" alt="image.png" loading="lazy"></li>
</ul>
</li>
</ol>
<h4 id="_8-5-6-config对象" tabindex="-1"><a class="header-anchor" href="#_8-5-6-config对象" aria-hidden="true">#</a> 8.5.6 config对象</h4>
<ol>
<li>javax.servlet.ServletConfig 的实例对象，一般用于获取页面和 Servlet 的初始化参数。</li>
<li>常用方法：
<ul>
<li><img src="/images/javaweb/image-1660814020352.png" alt="image.png" loading="lazy"></li>
</ul>
</li>
</ol>
<h4 id="_8-5-7-response对象" tabindex="-1"><a class="header-anchor" href="#_8-5-7-response对象" aria-hidden="true">#</a> 8.5.7 response对象</h4>
<ol>
<li>javax.servlet.http.HttpServletResponse 的实例对象</li>
<li>常用方法：
<ul>
<li><img src="/images/javaweb/image-1660814022407.png" alt="image.png" loading="lazy"></li>
</ul>
</li>
</ol>
<h4 id="_8-5-8-out对象" tabindex="-1"><a class="header-anchor" href="#_8-5-8-out对象" aria-hidden="true">#</a> 8.5.8 out对象</h4>
<ol>
<li>javax.servlet.jsp.JspWriter的实例，常用于输出内容到HTML中</li>
<li>常用方法：
<ul>
<li><img src="/images/javaweb/image-1660814024609.png" alt="image.png" loading="lazy"></li>
</ul>
</li>
<li>out.write()和resopnse.getWrite().write()对象的区别
<ul>
<li>两个方法都有自己的缓冲区</li>
<li>jsp页面中输出内容时即使不用write()，jsp页面翻译成servlet程序时，都是用的是out.write()</li>
<li>输出是Tomcat服务器默认输出response缓冲区的内容，而out缓冲区的内容会追写到response的缓冲区中。【表现：总是response输出的内容先输出】
<ul>
<li>jsp页面的内容执行完后，会默认执行<code v-pre>out.flush()</code>，将out缓冲区内容追写到response缓缓从区中。</li>
</ul>
</li>
</ul>
</li>
<li><code v-pre>out.write()</code>和<code v-pre>out.print()</code>
<ul>
<li><code v-pre>print()</code>方法输出数据时，都会转为String类型</li>
<li><code v-pre>write()</code>方法输出数据时，如果为非String类型，则有乱码问题（如int类型，输出的是整数型对应的ascii码）
<ul>
<li>缓冲区使用字符数组存放数据</li>
</ul>
</li>
</ul>
</li>
</ol>
<h4 id="_8-5-9-page对象" tabindex="-1"><a class="header-anchor" href="#_8-5-9-page对象" aria-hidden="true">#</a> 8.5.9 page对象</h4>
<ol>
<li>实质是java.lang.Object 对象相当于 Java 中的 this 关键字。page 对象是指当前的 JSP 页面本身，在实际开发中并不常用。</li>
<li>常用方法：
<ul>
<li><img src="/images/javaweb/image-1660814028036.png" alt="image.png" loading="lazy"></li>
</ul>
</li>
</ol>
<h4 id="_8-5-10-exception对象" tabindex="-1"><a class="header-anchor" href="#_8-5-10-exception对象" aria-hidden="true">#</a> 8.5.10 exception对象</h4>
<h3 id="_8-6-jsp标签" tabindex="-1"><a class="header-anchor" href="#_8-6-jsp标签" aria-hidden="true">#</a> 8.6 JSP标签</h3>
<h4 id="_8-6-1-动态包含" tabindex="-1"><a class="header-anchor" href="#_8-6-1-动态包含" aria-hidden="true">#</a> 8.6.1 动态包含</h4>
<ol>
<li>语法：<code v-pre>&lt;jsp:include page=&quot;url&quot;&gt;&lt;/js:include&gt;</code></li>
<li>特点：动态包含的页面会出现在包含它的jsp页面翻译后的servlet程序中
<ul>
<li>出现形式：<code v-pre>JspRuntimeLibrary.include(request, response, &quot;url&quot;, out, false)</code></li>
</ul>
</li>
<li>底层原理：
<ul>
<li><img src="/images/javaweb/image-1660814030156.png" alt="image.png" loading="lazy"></li>
<li>被包含的页面out对象是父页面传过去的，是同一个对象，所以共享缓冲区。</li>
</ul>
</li>
<li>传递参数：
<ul>
<li><img src="/images/javaweb/image-1660814032577.png" alt="image.png" loading="lazy"></li>
<li>父页面中，使用request的getParameter(&quot;str&quot;)可以获取属性值。
<ul>
<li>两个页面request是同一个</li>
</ul>
</li>
</ul>
</li>
</ol>
<h4 id="_8-6-2-转发" tabindex="-1"><a class="header-anchor" href="#_8-6-2-转发" aria-hidden="true">#</a> 8.6.2 转发</h4>
<ol>
<li>语法：<code v-pre>&lt;jsp:forward page=&quot;url&quot;&gt;&lt;/jsp:fowrard&gt;</code></li>
<li>作用：请求转发</li>
</ol>
<h4 id="_8-6-3-自定义标签" tabindex="-1"><a class="header-anchor" href="#_8-6-3-自定义标签" aria-hidden="true">#</a> 8.6.3 自定义标签</h4>
<p>没学会</p>
<h3 id="_8-7-el表达式" tabindex="-1"><a class="header-anchor" href="#_8-7-el表达式" aria-hidden="true">#</a> 8.7 EL表达式</h3>
<h4 id="_8-7-1-简介" tabindex="-1"><a class="header-anchor" href="#_8-7-1-简介" aria-hidden="true">#</a> 8.7.1 简介</h4>
<ol>
<li>Excepssion Language，简化jsp页面，主要用于代替jsp输出页面的数据【主要是域对象的数据】</li>
<li>语法：<code v-pre>${}</code></li>
<li>等同于<code v-pre>&lt;%= %&gt;</code></li>
<li>不同：EL表达式在输出null值时，输出为空串，jsp表达式输出时，输出null【用户体验不好】</li>
</ol>
<h4 id="_8-7-2-运算" tabindex="-1"><a class="header-anchor" href="#_8-7-2-运算" aria-hidden="true">#</a> 8.7.2 运算</h4>
<ol>
<li>关系运算
<ul>
<li><img src="/images/javaweb/image-1660814035300.png" alt="image.png" loading="lazy"></li>
</ul>
</li>
<li>逻辑运算
<ul>
<li><img src="/images/javaweb/image-1660814037661.png" alt="image.png" loading="lazy"></li>
</ul>
</li>
<li>算数运算
<ul>
<li><img src="/images/javaweb/image-1660814039356.png" alt="image.png" loading="lazy"></li>
</ul>
</li>
<li>条件表达式：<code v-pre>${ 条件表达式? true : false }</code></li>
<li>其他运算符
<ul>
<li>empty：判断对象或变量是否为null
<ul>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1656921126525-5ec07703-b414-4d36-8296-651cb6bde781.png#clientId=uba4a2df0-32ab-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=104&amp;id=u0feb767a&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=104&amp;originWidth=272&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=17867&amp;status=done&amp;style=none&amp;taskId=u91d2aa7d-13e9-4115-8b45-559e0991b02&amp;title=&amp;width=272" alt="image.png" loading="lazy"></li>
</ul>
</li>
<li><code v-pre>.</code>和<code v-pre>[]</code>：访问 JavaBean 中的属性和隐式对象的数据。
<ul>
<li><code v-pre>.</code>访问 JavaBean 属性【实际上调用的是属性的geteer或isValue()，如果未设置会报错】或 Map 类型的值</li>
<li><code v-pre>[]</code>用来访问数组或者列表的元素。</li>
</ul>
</li>
</ul>
</li>
</ol>
<h4 id="_8-7-3-内置对象" tabindex="-1"><a class="header-anchor" href="#_8-7-3-内置对象" aria-hidden="true">#</a> 8.7.3 内置对象</h4>
<p><img src="/images/javaweb/image-1660814041933.png" alt="image.png" loading="lazy"></p>
<h4 id="_8-7-4-pagecontext域对象的使用" tabindex="-1"><a class="header-anchor" href="#_8-7-4-pagecontext域对象的使用" aria-hidden="true">#</a> 8.7.4 pageContext域对象的使用</h4>
<p><img src="/images/javaweb/image-1660814044305.png" alt="image.png" loading="lazy"></p>
<ul>
<li>EL域对象调用属性，其实是调用的该属性的getter，如果是布尔值，则调用的是isValue()</li>
</ul>
<h4 id="_8-7-5-禁用el表达式" tabindex="-1"><a class="header-anchor" href="#_8-7-5-禁用el表达式" aria-hidden="true">#</a> 8.7.5 禁用EL表达式</h4>
<ol>
<li>禁用单个表达式：<code v-pre>\${2+3}</code>页面会输出<code v-pre>${2+3</code></li>
<li>当前页面禁用：配置page指令中的<code v-pre>isELIgnored</code>属性
<ul>
<li><code v-pre>&lt;%@ page isELIgnored = &quot;true&quot; %&gt;</code></li>
</ul>
</li>
<li>整个web禁用：
<ul>
<li><img src="/images/javaweb/image-1660814046556.png" alt="image.png" loading="lazy"></li>
</ul>
</li>
</ol>
<h3 id="_8-8-文件传输" tabindex="-1"><a class="header-anchor" href="#_8-8-文件传输" aria-hidden="true">#</a> 8.8 文件传输</h3>
<blockquote>
<p>可以使用的第三方jar包（同时导入）</p>
<ul>
<li></li>
<li></li>
</ul>
</blockquote>
<h4 id="_8-8-0-commons-fileupload组件api" tabindex="-1"><a class="header-anchor" href="#_8-8-0-commons-fileupload组件api" aria-hidden="true">#</a> 8.8.0 Commons-FileUpload组件API</h4>
<ol>
<li>
<p>ServletFileUpload类：解析文件上传的数据
| 方  法 | 说  明 |
| --- | --- |
| public void setSizeMax(long sizeMax) | 设置上传文件总量的最大值 (包含文件和表单数据) |
| public List parseRequest(HttpServletRequest req) | 解析 form 表单提交的数据，返回一个 FileItem 实例的集合 |
| public static final boolean isMultipartContent(HttpServletRequest req) | 判断请求信息中的内容是否是”multipart/form-data“类型，是则返回 true，否则返回 false。 |
| public void setHeaderEncoding(String encoding) | 设置转换时所使用的字符集编码 |</p>
</li>
<li>
<p>FileItemFactory接口与实现类：创建ServletFileUpload实例，DiskFileItemFactory 是 FileItemFactory 接口的实现类
| 方  法 | 说  明 |
| --- | --- |
| public void setSizeThreshold(int sizeThreshold) | 设置内存缓冲区的大小 |
| public void setRepository(String path) | 设置临时文件存放的目录 |</p>
</li>
<li>
<p>FileItem接口：一个表单字段对应一个 FileItem 实例，其实现类之一是 DiskFileItem
| 方  法 | 说  明 |
| --- | --- |
| public boolean isFormField() | 用于判断 FileItem 类对象封装的数据是一个普通文本表单字段，还是一个文件表单字段，如果是普通表单字段则返回 true，否则返回 false。因此，可以使用该方法判断是否为普通表单域，还是文件上传表单域。 |
| public String getName() | 获取文件上传的文件名 |
| public String getFieldName() | 返回表单字段元素的 name 属性值 |
| public long getSize() | 获取上传文件的大小 |
| public String getString() | 将 FileItem 对象中保存的主体内容以一个字符串返回。其重载方法 public String getString(String encoding) 中的参数用指定的字符集编码方式 |
| public void write() | 将 FileItem 对象中保存的主体内容保存到指定的文件中。 |</p>
</li>
</ol>
<h4 id="_8-8-1-文件上传表单设计" tabindex="-1"><a class="header-anchor" href="#_8-8-1-文件上传表单设计" aria-hidden="true">#</a> 8.8.1 文件上传表单设计</h4>
<ol>
<li><code v-pre>&lt;form&gt;</code>标签属性为<code v-pre>method=&quot;post&quot;</code>、<code v-pre>enctype=&quot;multipart/form-data&quot;</code>
<ul>
<li>get方法也能传，但是长度有限，太短了不够用。</li>
<li>设置了enctype=&quot;multipart/form-data&quot;后，提交给服务器的数据变为二进制流的形式，使用<code v-pre>request.getParameter</code>不能获取属性值【为null】</li>
</ul>
</li>
<li><code v-pre>&lt;input&gt;</code>标签属性为<code v-pre>type=&quot;file&quot;</code></li>
</ol>
<h4 id="_8-8-2-文件上传请求体介绍" tabindex="-1"><a class="header-anchor" href="#_8-8-2-文件上传请求体介绍" aria-hidden="true">#</a> 8.8.2 文件上传请求体介绍</h4>
<p><img src="/images/javaweb/image-1660814059150.png" alt="image.png" loading="lazy"></p>
<h4 id="_8-8-3-使用第三方包完成上传" tabindex="-1"><a class="header-anchor" href="#_8-8-3-使用第三方包完成上传" aria-hidden="true">#</a> 8.8.3 使用第三方包完成上传</h4>
<ol>
<li>导入文件上传包和io包：
<ul>
<li><img src="/images/javaweb/image-1660814061257.png" alt="image.png" loading="lazy"></li>
</ul>
</li>
<li>创建表单JSP文件和文件上传Servlet类</li>
</ol>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token keyword">protected</span> <span class="token keyword">void</span> <span class="token function">doPost</span><span class="token punctuation">(</span><span class="token class-name">HttpServletRequest</span> req<span class="token punctuation">,</span> <span class="token class-name">HttpServletResponse</span> resp<span class="token punctuation">)</span> <span class="token keyword">throws</span> <span class="token class-name">ServletException</span><span class="token punctuation">,</span>
<span class="token class-name">IOException</span> <span class="token punctuation">{</span>
    <span class="token comment">//1 先判断上传的数据是否多段数据（只有是多段的数据，才是文件上传的）</span>
    <span class="token keyword">if</span> <span class="token punctuation">(</span><span class="token class-name">ServletFileUpload</span><span class="token punctuation">.</span><span class="token function">isMultipartContent</span><span class="token punctuation">(</span>req<span class="token punctuation">)</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
        <span class="token comment">// 创建 FileItemFactory 工厂实现类</span>
        <span class="token class-name">FileItemFactory</span> fileItemFactory <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">DiskFileItemFactory</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token comment">// 创建用于解析上传数据的工具类 ServletFileUpload 类</span>
        <span class="token class-name">ServletFileUpload</span> servletFileUpload <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">ServletFileUpload</span><span class="token punctuation">(</span>fileItemFactory<span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token keyword">try</span> <span class="token punctuation">{</span>
            <span class="token comment">// 解析上传的数据，得到每一个表单项 FileItem</span>
            <span class="token class-name">List</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">FileItem</span><span class="token punctuation">></span></span> list <span class="token operator">=</span> servletFileUpload<span class="token punctuation">.</span><span class="token function">parseRequest</span><span class="token punctuation">(</span>req<span class="token punctuation">)</span><span class="token punctuation">;</span>
            <span class="token comment">// 循环判断，每一个表单项，是普通类型，还是上传的文件</span>
            <span class="token keyword">for</span> <span class="token punctuation">(</span><span class="token class-name">FileItem</span> fileItem <span class="token operator">:</span> list<span class="token punctuation">)</span> <span class="token punctuation">{</span>
                <span class="token keyword">if</span> <span class="token punctuation">(</span>fileItem<span class="token punctuation">.</span><span class="token function">isFormField</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
                    <span class="token comment">// 普通表单项</span>
                    <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span><span class="token string">"表单项的 name 属性值："</span> <span class="token operator">+</span> fileItem<span class="token punctuation">.</span><span class="token function">getFieldName</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
                    <span class="token comment">// 参数 UTF-8.解决乱码问题</span>
                    <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span><span class="token string">"表单项的 value 属性值："</span> <span class="token operator">+</span> fileItem<span class="token punctuation">.</span><span class="token function">getString</span><span class="token punctuation">(</span><span class="token string">"UTF-8"</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
                <span class="token punctuation">}</span> <span class="token keyword">else</span> <span class="token punctuation">{</span>
                    <span class="token comment">// 上传的文件</span>
                    <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span><span class="token string">"表单项的 name 属性值："</span> <span class="token operator">+</span> fileItem<span class="token punctuation">.</span><span class="token function">getFieldName</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
                    <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span><span class="token string">"上传的文件名："</span> <span class="token operator">+</span> fileItem<span class="token punctuation">.</span><span class="token function">getName</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
                    fileItem<span class="token punctuation">.</span><span class="token function">write</span><span class="token punctuation">(</span><span class="token keyword">new</span> <span class="token class-name">File</span><span class="token punctuation">(</span><span class="token string">"e:\\"</span> <span class="token operator">+</span> fileItem<span class="token punctuation">.</span><span class="token function">getName</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
                <span class="token punctuation">}</span>
            <span class="token punctuation">}</span>
        <span class="token punctuation">}</span> <span class="token keyword">catch</span> <span class="token punctuation">(</span><span class="token class-name">Exception</span> e<span class="token punctuation">)</span> <span class="token punctuation">{</span>
            e<span class="token punctuation">.</span><span class="token function">printStackTrace</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token punctuation">}</span>
    <span class="token punctuation">}</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><h4 id="_8-8-4-使用第三方包完成下载" tabindex="-1"><a class="header-anchor" href="#_8-8-4-使用第三方包完成下载" aria-hidden="true">#</a> 8.8.4 使用第三方包完成下载</h4>
<ol>
<li>response.getOutputStream();</li>
<li>servletContext.getResourceAsStream();</li>
<li><code v-pre>servletContext.getMimeType()</code>：获取要下载的文件类型</li>
<li><code v-pre>response.setContentType()</code>：设置返回客户端的数据类型</li>
</ol>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token keyword">protected</span> <span class="token keyword">void</span> <span class="token function">doGet</span><span class="token punctuation">(</span><span class="token class-name">HttpServletRequest</span> req<span class="token punctuation">,</span> <span class="token class-name">HttpServletResponse</span> resp<span class="token punctuation">)</span> <span class="token keyword">throws</span> <span class="token class-name">ServletException</span><span class="token punctuation">,</span> <span class="token class-name">IOException</span> <span class="token punctuation">{</span>
    <span class="token comment">//        1、获取要下载的文件名</span>
    <span class="token class-name">String</span> downloadFileName <span class="token operator">=</span> <span class="token string">"2.jpg"</span><span class="token punctuation">;</span>
    <span class="token comment">//        2、读取要下载的文件内容 (通过ServletContext对象可以读取)</span>
    <span class="token class-name">ServletContext</span> servletContext <span class="token operator">=</span> <span class="token function">getServletContext</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token comment">// 获取要下载的文件类型</span>
    <span class="token class-name">String</span> mimeType <span class="token operator">=</span> servletContext<span class="token punctuation">.</span><span class="token function">getMimeType</span><span class="token punctuation">(</span><span class="token string">"/file/"</span> <span class="token operator">+</span> downloadFileName<span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span><span class="token string">"下载的文件类型："</span> <span class="token operator">+</span> mimeType<span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token comment">//        4、在回传前，通过响应头告诉客户端返回的数据类型</span>
    resp<span class="token punctuation">.</span><span class="token function">setContentType</span><span class="token punctuation">(</span>mimeType<span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token comment">//        5、还要告诉客户端收到的数据是用于下载使用（还是使用响应头）</span>
    <span class="token comment">// Content-Disposition响应头，表示收到的数据怎么处理</span>
    <span class="token comment">// attachment表示附件，表示下载使用</span>
    <span class="token comment">// filename= 表示指定下载的文件名</span>
    <span class="token comment">// url编码是把汉字转换成为%xx%xx的格式</span>
    <span class="token keyword">if</span> <span class="token punctuation">(</span>req<span class="token punctuation">.</span><span class="token function">getHeader</span><span class="token punctuation">(</span><span class="token string">"User-Agent"</span><span class="token punctuation">)</span><span class="token punctuation">.</span><span class="token function">contains</span><span class="token punctuation">(</span><span class="token string">"Firefox"</span><span class="token punctuation">)</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
        <span class="token comment">// 如果是火狐浏览器使用Base64编码</span>
        resp<span class="token punctuation">.</span><span class="token function">setHeader</span><span class="token punctuation">(</span><span class="token string">"Content-Disposition"</span><span class="token punctuation">,</span> <span class="token string">"attachment; filename==?UTF-8?B?"</span> <span class="token operator">+</span> <span class="token keyword">new</span> <span class="token class-name">BASE64Encoder</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">.</span><span class="token function">encode</span><span class="token punctuation">(</span><span class="token string">"中国.jpg"</span><span class="token punctuation">.</span><span class="token function">getBytes</span><span class="token punctuation">(</span><span class="token string">"UTF-8"</span><span class="token punctuation">)</span><span class="token punctuation">)</span> <span class="token operator">+</span> <span class="token string">"?="</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token punctuation">}</span> <span class="token keyword">else</span> <span class="token punctuation">{</span>
        <span class="token comment">// 如果不是火狐，是IE或谷歌，使用URL编码操作</span>
        resp<span class="token punctuation">.</span><span class="token function">setHeader</span><span class="token punctuation">(</span><span class="token string">"Content-Disposition"</span><span class="token punctuation">,</span> <span class="token string">"attachment; filename="</span> <span class="token operator">+</span> <span class="token class-name">URLEncoder</span><span class="token punctuation">.</span><span class="token function">encode</span><span class="token punctuation">(</span><span class="token string">"中国.jpg"</span><span class="token punctuation">,</span> <span class="token string">"UTF-8"</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token punctuation">}</span>
    <span class="token doc-comment comment">/**
         * /斜杠被服务器解析表示地址为http://ip:prot/工程名/  映射 到代码的Web目录
         */</span>
    <span class="token class-name">InputStream</span> resourceAsStream <span class="token operator">=</span> servletContext<span class="token punctuation">.</span><span class="token function">getResourceAsStream</span><span class="token punctuation">(</span><span class="token string">"/file/"</span> <span class="token operator">+</span> downloadFileName<span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token comment">// 获取响应的输出流</span>
    <span class="token class-name">OutputStream</span> outputStream <span class="token operator">=</span> resp<span class="token punctuation">.</span><span class="token function">getOutputStream</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token comment">//        3、把下载的文件内容回传给客户端</span>
    <span class="token comment">// 读取输入流中全部的数据，复制给输出流，输出给客户端</span>
    <span class="token class-name">IOUtils</span><span class="token punctuation">.</span><span class="token function">copy</span><span class="token punctuation">(</span>resourceAsStream<span class="token punctuation">,</span> outputStream<span class="token punctuation">)</span><span class="token punctuation">;</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><h2 id="第9章-jstl" tabindex="-1"><a class="header-anchor" href="#第9章-jstl" aria-hidden="true">#</a> 第9章 JSTL</h2>
<h3 id="_9-1-jstl简介" tabindex="-1"><a class="header-anchor" href="#_9-1-jstl简介" aria-hidden="true">#</a> 9.1 JSTL简介</h3>
<h4 id="_9-1-1-jstl介绍" tabindex="-1"><a class="header-anchor" href="#_9-1-1-jstl介绍" aria-hidden="true">#</a> 9.1.1 JSTL介绍</h4>
<ol>
<li>JSP Standard Tag Library，核心标签库，替换代码脚本，优化JSP页面编写
<ul>
<li>EL替换表达式脚本<code v-pre>&lt;% %&gt;</code></li>
</ul>
</li>
<li>使用：使用 JSTL 需要引入 JSTL 的 JAR 包和标签库描述符文件（扩展名为 .tld），标签库描述符文件内包含标签库中所有标签的定义、标签名、功能类及各种属性。
<ul>
<li><code v-pre>taglibs-standard-impl-1.2.1.jar</code>和<code v-pre>taglibs-standard-spec-1.2.1.jar</code></li>
<li>JSTL 1.2及之后版本只需要引入jstl包？</li>
</ul>
</li>
<li>地址：</li>
<li>组成：
<ul>
<li><img src="/images/javaweb/image-1660814065998.png" alt="image.png" loading="lazy"></li>
</ul>
</li>
</ol>
<h4 id="_9-1-2-使用" tabindex="-1"><a class="header-anchor" href="#_9-1-2-使用" aria-hidden="true">#</a> 9.1.2 使用</h4>
<ol>
<li>导入 taglibs-standard-impl-1.2.1.jar 和taglibs-standard-spec-1.2.1.jar</li>
</ol>
<div class="custom-container danger"><p class="custom-container-title">警告</p>
<ul>
<li>JSTL的两个库文件只支持Servlet4.0，Tomcat10创建的Servlet程序为5.0版本，所以需要单独导入servlet4.0的jar包</li>
</ul>
</div>
<ol start="2">
<li>使用JSP taglib指令引入使用的标签库地址
<ul>
<li>CORE标签库：<code v-pre>&lt;%@ taglib prefix=&quot;c&quot;uri=&quot;http://java.sun.com/jsp/jstl/core&quot; % &gt;</code></li>
<li>FMT标签库：<code v-pre>&lt;%@ taglib prefix=&quot;c&quot;uri=&quot;http://java.sun.com/jsp/jstl/fmt&quot; % &gt;</code></li>
<li>FUNCTIONS标签库：<code v-pre>&lt;%@ taglib prefix=&quot;c&quot;uri=&quot;http://java.sun.com/jsp/jstl/functions&quot; % &gt;</code></li>
<li>SQL标签库：<code v-pre>&lt;%@ taglib prefix=&quot;c&quot;uri=&quot;http://java.sun.com/jsp/jstl/sql&quot; % &gt;</code></li>
<li>XML标签库：<code v-pre>&lt;%@ taglib prefix=&quot;c&quot;uri=&quot;http://java.sun.com/jsp/jstl/xml&quot; % &gt;</code></li>
</ul>
</li>
</ol>
<h3 id="_9-2-各库介绍" tabindex="-1"><a class="header-anchor" href="#_9-2-各库介绍" aria-hidden="true">#</a> 9.2 各库介绍</h3>
<blockquote>
<p><strong>注：下文中表达式指EL表达式。</strong></p>
</blockquote>
<h4 id="_9-2-1-core核心库" tabindex="-1"><a class="header-anchor" href="#_9-2-1-core核心库" aria-hidden="true">#</a> 9.2.1 CORE核心库</h4>
<p><img src="/images/javaweb/image-1660814068678.png" alt="image.png" loading="lazy"></p>
<ol>
<li><code v-pre>&lt;c:set var=&quot;varname&quot; value=&quot;表达式&quot; [scope=&quot;request|page|session|application&quot;]&gt;表达式&lt;/c:set&gt;</code>：
<ul>
<li>等价于：<code v-pre>&lt;c:set var=&quot;varname&quot; value=&quot;表达式&quot; [scope=&quot;request|page|session|application&quot;]/&gt;</code></li>
<li>var：定义变量或属性名称</li>
<li>value：变量或属性值</li>
<li>scope：可选项，表示属性的作用域，默认为 page</li>
</ul>
</li>
<li><code v-pre>&lt;c:if test=&quot;判断条件&quot; [var=&quot;varname&quot;] [scope=&quot;request|page|session|application&quot;]&gt; 代码块 &lt;/c:if&gt;</code>
<ul>
<li>test：指定判断条件，返回值为 boolean</li>
<li>var：可选项，判断条件的执行结果</li>
<li>scope：可选项，执行结果的作用域</li>
</ul>
</li>
<li><code v-pre>&lt;c:choose&gt;&lt;c:when&gt;</code>和<code v-pre>&lt;c:otherwise&gt;</code>标签
<ul>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1656935842482-fd4bbe53-c257-4b6c-8385-251edc1bbbb7.png#clientId=u89a3eb69-b878-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=223&amp;id=ub3b7432e&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=223&amp;originWidth=309&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=5266&amp;status=done&amp;style=none&amp;taskId=u44251ce7-8e1f-413d-b027-5e9c34ac6e8&amp;title=&amp;width=309" alt="image.png" loading="lazy"></li>
<li>嵌套判断时，<code v-pre>&lt;c:when&gt;</code>的直接父标签只能是<code v-pre>&lt;c:choose&gt;</code>，且必须使用。</li>
<li>不存在穿透问题。</li>
<li>多个判断语句同时为true时，只会执行第一个判断为true的语句（同java只有一个入口）</li>
</ul>
</li>
<li><code v-pre>&lt;c:forEach&gt;</code>
<ul>
<li><img src="/images/javaweb/image-1660814074427.png" alt="image.png" loading="lazy"></li>
<li>items：要被循环的信息，可以是数组、Java 集合等；</li>
<li>var：可选项，指定迭代之的别名；</li>
<li>varStatus：可选项，当前迭代的状态信息；
<ul>
<li><img src="/images/javaweb/image-1660814082111.png" alt="image.png" loading="lazy"></li>
<li>varStatus可调用的方法，根据EL表达式的<code v-pre>.</code>运算符，可以直接写属性</li>
</ul>
</li>
<li>begin：可选项，迭代开始的元素，起始下标为 0；</li>
<li>end：可选项，迭代结束的元素；</li>
<li>step：可选项，迭代的步长；</li>
</ul>
</li>
</ol>
<h4 id="_9-2-2-fmt格式化库" tabindex="-1"><a class="header-anchor" href="#_9-2-2-fmt格式化库" aria-hidden="true">#</a> 9.2.2 FMT格式化库</h4>
<p><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1656941141080-690e876f-f026-48fe-8872-6c430745e5fb.png#clientId=u89a3eb69-b878-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=369&amp;id=u447293cd&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=369&amp;originWidth=755&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=34791&amp;status=done&amp;style=none&amp;taskId=u487b1392-9c54-479c-9168-d5202d93ce8&amp;title=&amp;width=755" alt="image.png" loading="lazy"></p>
<h4 id="_9-2-3-functions函数库" tabindex="-1"><a class="header-anchor" href="#_9-2-3-functions函数库" aria-hidden="true">#</a> 9.2.3 FUNCTIONS函数库</h4>
<p><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1656941214185-1d8adb7d-9eaf-470e-9f68-f8147d7324b3.png#clientId=u89a3eb69-b878-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=490&amp;id=uf874b7ff&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=490&amp;originWidth=755&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=59415&amp;status=done&amp;style=none&amp;taskId=u8143353c-2fd9-49fe-ac0c-8df74fdddf9&amp;title=&amp;width=755" alt="image.png" loading="lazy"></p>
<h4 id="_9-2-4-sql数据库" tabindex="-1"><a class="header-anchor" href="#_9-2-4-sql数据库" aria-hidden="true">#</a> 9.2.4 SQL数据库</h4>
<p><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1656941273043-3e27eb48-29b6-4620-bc0c-e8e84870e06f.png#clientId=u89a3eb69-b878-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=218&amp;id=ua552b4e2&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=218&amp;originWidth=630&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=17860&amp;status=done&amp;style=none&amp;taskId=u188305a0-a69e-4007-b5fa-51aba7c6999&amp;title=&amp;width=630" alt="image.png" loading="lazy"></p>
<h2 id="第10-章beanutils" tabindex="-1"><a class="header-anchor" href="#第10-章beanutils" aria-hidden="true">#</a> 第10 章BeanUtils</h2>
<blockquote>
<p>依赖</p>
<ul>
<li><a href="https://commons.apache.org/proper/commons-beanutils/" target="_blank" rel="noopener noreferrer">https://commons.apache.org/proper/commons-beanutils/<ExternalLinkIcon/></a>（引入）</li>
<li><a href="https://commons.apache.org/proper/commons-collections/" target="_blank" rel="noopener noreferrer">https://commons.apache.org/proper/commons-collections/<ExternalLinkIcon/></a>（引入）</li>
<li><a href="https://commons.apache.org/proper/commons-logging/" target="_blank" rel="noopener noreferrer">https://commons.apache.org/proper/commons-logging/<ExternalLinkIcon/></a>（不知道高版本还需要不需要引入）</li>
</ul>
</blockquote>
<p><img src="/images/javaweb/image-1660814090705.png" alt="image.png" loading="lazy">
注入原理：调用JavaBean的seteer
作用：将参数注入到JavaBean的对象中，方便创建对象</p>
<h2 id="第11章-mvc" tabindex="-1"><a class="header-anchor" href="#第11章-mvc" aria-hidden="true">#</a> 第11章 MVC</h2>
<h3 id="_11-1-mvc的概念" tabindex="-1"><a class="header-anchor" href="#_11-1-mvc的概念" aria-hidden="true">#</a> 11.1 MVC的概念</h3>
<ol>
<li>MVC 全称：Model 模型、 View 视图、 Controller 控制器。</li>
<li>MVC 最早出现在 JavaEE 三层中的 Web 层，它可以有效的指导 Web 层的代码如何有效分离，单独工作。</li>
<li>Model 模型：将与业务逻辑相关的数据封装为具体的 JavaBean 类，其中不掺杂任何与数据处理相关的代码—— JavaBean/domain/entity/pojo。</li>
<li>View 视图：只负责数据和界面的显示，不接受任何与显示数据无关的代码，便于程序员和美工的分工合作—— JSP/HTML。</li>
<li>Controller 控制器：只负责接收请求，调用业务层的代码处理请求，然后派发页面，是一个“调度者”的角色——Servlet。 转到某个页面。或者是重定向到某个页面。</li>
</ol>
<p><img src="/images/javaweb/image-1660814094548.png" alt="image.png" loading="lazy"></p>
<h2 id="第12章-cookie" tabindex="-1"><a class="header-anchor" href="#第12章-cookie" aria-hidden="true">#</a> 第12章 Cookie</h2>
<h3 id="_12-1-cookie概述" tabindex="-1"><a class="header-anchor" href="#_12-1-cookie概述" aria-hidden="true">#</a> 12.1 Cookie概述</h3>
<h4 id="_12-1-1-cookie概念" tabindex="-1"><a class="header-anchor" href="#_12-1-1-cookie概念" aria-hidden="true">#</a> 12.1.1 Cookie概念</h4>
<ol>
<li>服务器通知客户端保存键值对的一种技术。web应用程序利用Cookie在客户端缓存服务器端的文件。</li>
<li>Cookie时由服务器发送给客户端的，客户端保存时注明了Cookie的来源。</li>
<li>客户端再次访问服务器时，客户端的Cookie会保存在请求协议中，服务器端可以获取上次存储的缓存文件内容。</li>
</ol>
<h4 id="_12-1-2-用途" tabindex="-1"><a class="header-anchor" href="#_12-1-2-用途" aria-hidden="true">#</a> 12.1.2 用途</h4>
<ol>
<li>管理浏览网站的人数（其中包含有多少人访问过，多少人是新用户等）</li>
<li>电子商城中购物车功能（每买一样商品，保存一个Cookie）</li>
<li>用户自动登录功能（第一次登录时，将用户名和密码存储在Cookie）</li>
</ol>
<h4 id="_12-1-3-缺点" tabindex="-1"><a class="header-anchor" href="#_12-1-3-缺点" aria-hidden="true">#</a> 12.1.3 缺点</h4>
<ol>
<li>多人共用一台计算机（例如导致用户名和密码不安全等问题）。</li>
<li>Cookie被删除时，利用Cookie统计用户数量出现偏差。</li>
<li>一人使用多台计算机（网站会将看成多个用户等问题）</li>
<li>Cookie会被附加在每次Http请求协议中，增加流量。</li>
<li>Cookie使用明文（未加密）传递的，安全性低。</li>
<li>Cookie的大小限制在4KB左右，无法存储复杂需求。</li>
</ol>
<h4 id="_12-1-4-cookie规范" tabindex="-1"><a class="header-anchor" href="#_12-1-4-cookie规范" aria-hidden="true">#</a> 12.1.4 Cookie规范</h4>
<ol>
<li>Cookie存储的大小上限为4KB。</li>
<li>一个服务器最多在客户端浏览器中可以保存20个Cookie。</li>
<li>一个浏览器最多可以保存300个Cookie。</li>
<li>不同浏览器之间不能共享Cookie</li>
</ol>
<div class="custom-container warning"><p class="custom-container-title">注意</p>
<p>注意点：Cookie规范时Http协议提供的，浏览器厂商对该Cookie规范进行了一些“扩展”。</p>
</div>
<h3 id="_12-2-使用cookie" tabindex="-1"><a class="header-anchor" href="#_12-2-使用cookie" aria-hidden="true">#</a> 12.2 使用Cookie</h3>
<h4 id="_12-2-1-服务器端创建cookie" tabindex="-1"><a class="header-anchor" href="#_12-2-1-服务器端创建cookie" aria-hidden="true">#</a> 12.2.1 服务器端创建Cookie</h4>
<ol>
<li>创建Cookie对象：<code v-pre>Cookie cookie= new Cookie(&quot;name&quot;, &quot;value&quot;);</code></li>
<li>发送给客户端保存：<code v-pre>response.addCookie(cookie);</code></li>
</ol>
<h4 id="_12-2-2-服务器端获取cookie" tabindex="-1"><a class="header-anchor" href="#_12-2-2-服务器端获取cookie" aria-hidden="true">#</a> 12.2.2 服务器端获取Cookie</h4>
<ol>
<li>浏览器是通过请求头将Cookie发送给服务器的，所以可以使用获取请求头的方法：
<ul>
<li><code v-pre>request.getCokies()</code>：返回Cookie的对象数组</li>
<li>遍历Cookie数组，使用equals方法比较名字是否一致</li>
</ul>
</li>
<li>获取Cookie的工具类：</li>
</ol>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token keyword">public</span> <span class="token keyword">class</span> <span class="token class-name">CookieUtils</span> <span class="token punctuation">{</span>
    <span class="token doc-comment comment">/**
    * 查找指定名称的 Cookie 对象
    * <span class="token keyword">@param</span> <span class="token parameter">name</span>
    * <span class="token keyword">@param</span> <span class="token parameter">cookies</span>
    * <span class="token keyword">@return</span>
    */</span>
    <span class="token keyword">public</span> <span class="token keyword">static</span> <span class="token class-name">Cookie</span> <span class="token function">findCookie</span><span class="token punctuation">(</span><span class="token class-name">String</span> name <span class="token punctuation">,</span> <span class="token class-name">Cookie</span><span class="token punctuation">[</span><span class="token punctuation">]</span> cookies<span class="token punctuation">)</span><span class="token punctuation">{</span>
        <span class="token keyword">if</span> <span class="token punctuation">(</span>name <span class="token operator">==</span> <span class="token keyword">null</span> <span class="token operator">||</span> cookies <span class="token operator">==</span> <span class="token keyword">null</span> <span class="token operator">||</span> cookies<span class="token punctuation">.</span>length <span class="token operator">==</span> <span class="token number">0</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
            <span class="token keyword">return</span> <span class="token keyword">null</span><span class="token punctuation">;</span>
        <span class="token punctuation">}</span>
        <span class="token keyword">for</span> <span class="token punctuation">(</span><span class="token class-name">Cookie</span> cookie <span class="token operator">:</span> cookies<span class="token punctuation">)</span> <span class="token punctuation">{</span>
            <span class="token keyword">if</span> <span class="token punctuation">(</span>name<span class="token punctuation">.</span><span class="token function">equals</span><span class="token punctuation">(</span>cookie<span class="token punctuation">.</span><span class="token function">getName</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">)</span> <span class="token punctuation">{</span><span class="token comment">//上面判断的为空的情况，所以不会出现空指针异常</span>
            <span class="token keyword">return</span> cookie<span class="token punctuation">;</span>
            <span class="token punctuation">}</span>
        <span class="token punctuation">}</span>
        <span class="token keyword">return</span> <span class="token keyword">null</span><span class="token punctuation">;</span>
    <span class="token punctuation">}</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><h4 id="_12-2-3-修改cookie的值" tabindex="-1"><a class="header-anchor" href="#_12-2-3-修改cookie的值" aria-hidden="true">#</a> 12.2.3 修改Cookie的值</h4>
<ol>
<li>方式一：创建同名的新cookie进行覆盖</li>
</ol>
<blockquote>
<ul>
<li>创建Cookie对象：<code v-pre>Cookie cookie= new Cookie(&quot;name&quot;, &quot;value&quot;);</code></li>
<li>发送给客户端保存：<code v-pre>response.addCookie(cookie);</code></li>
</ul>
</blockquote>
<ol start="2">
<li>方式二：查找到指定的Cookie，使用<code v-pre>setValue()</code>方法</li>
</ol>
<blockquote>
<ul>
<li>查找指定Cookie（使用工具类）：<code v-pre>Cookie cookie = CookieUtils.findCookie(&quot;key&quot;,request.getCookies());</code></li>
<li>发送给客户端保存：<code v-pre>response.addCookie(cookie);</code></li>
</ul>
</blockquote>
<ol start="3">
<li>cookie不能保存<strong>空格、方括号、圆括号、等号、逗号、双引号、斜杠、问号、at 符号、冒号和分号以及汉字，同时空值在不同浏览器上表现页不一定一样。</strong>
<ul>
<li>要保存上述类型的值，可以使用BSE64编码对上述文本进行处置。</li>
</ul>
</li>
</ol>
<h4 id="_12-2-4-cookie的生命周期控制" tabindex="-1"><a class="header-anchor" href="#_12-2-4-cookie的生命周期控制" aria-hidden="true">#</a> 12.2.4 Cookie的生命周期控制</h4>
<ol>
<li>使用cookie的<code v-pre>setMaxAge(num)</code>可以设置cookie如何过期：
<ul>
<li>正数，表示在指定的秒数后过期</li>
<li>负数，表示浏览器一关，Cookie 就会被删除（默认值是-1）</li>
<li>零，表示马上删除 Cookie</li>
</ul>
</li>
</ol>
<h4 id="_12-2-5-cookie有效path的设置" tabindex="-1"><a class="header-anchor" href="#_12-2-5-cookie有效path的设置" aria-hidden="true">#</a> 12.2.5 Cookie有效Path的设置</h4>
<p><img src="/images/javaweb/image-1660814100767.png" alt="image.png" loading="lazy"></p>
<ul>
<li><code v-pre>setPath(&quot;路径&quot;)</code></li>
</ul>
<h2 id="第13章-session" tabindex="-1"><a class="header-anchor" href="#第13章-session" aria-hidden="true">#</a> 第13章 Session</h2>
<h3 id="_13-1-session概述" tabindex="-1"><a class="header-anchor" href="#_13-1-session概述" aria-hidden="true">#</a> 13.1 Session概述</h3>
<h4 id="_13-1-1-session会话介绍" tabindex="-1"><a class="header-anchor" href="#_13-1-1-session会话介绍" aria-hidden="true">#</a> 13.1.1 Session会话介绍</h4>
<ol>
<li>Session 就一个接口（HttpSession）。</li>
<li>Session 就是会话。它是用来维护一个客户端和服务器之间关联的一种技术。</li>
<li>每个客户端都有自己的一个 Session 会话。</li>
<li>Session 会话中，我们经常用来保存用户登录之后的信息。</li>
</ol>
<h3 id="_13-2-session的使用" tabindex="-1"><a class="header-anchor" href="#_13-2-session的使用" aria-hidden="true">#</a> 13.2 Session的使用</h3>
<h4 id="_13-2-1-session的创建、获取、判断、id" tabindex="-1"><a class="header-anchor" href="#_13-2-1-session的创建、获取、判断、id" aria-hidden="true">#</a> 13.2.1 Session的创建、获取、判断、id</h4>
<ol>
<li>创建和获取Session，使用的方法（API）是一样的：<code v-pre>request.getSession()</code>
<ul>
<li>第一次调用该方法：创建Session会话</li>
<li>后续掉调用该方法：获取已经存在的Session</li>
</ul>
</li>
<li>判断是否是新创建的Session：<code v-pre>session.isNew()</code>
<ul>
<li>true：标识新创建的</li>
<li>false：标识之前已经存在的</li>
</ul>
</li>
<li>获取sessionID：<code v-pre>session.getId()</code>
<ul>
<li>每个session都有一个id，且唯一存在</li>
</ul>
</li>
</ol>
<h4 id="_13-2-2-session域数据存取" tabindex="-1"><a class="header-anchor" href="#_13-2-2-session域数据存取" aria-hidden="true">#</a> 13.2.2 Session域数据存取</h4>
<ol>
<li>存储：调用session对象的<code v-pre>setAttribute(&quot;name&quot;, &quot;value&quot;)</code></li>
<li>获取：调用session对象的<code v-pre>getAttribute(&quot;name&quot;, &quot;value&quot;)</code></li>
</ol>
<h4 id="_13-3-3-session生命周期控制" tabindex="-1"><a class="header-anchor" href="#_13-3-3-session生命周期控制" aria-hidden="true">#</a> 13.3.3 Session生命周期控制</h4>
<ol>
<li>获取存活时间（超时后销毁）：<code v-pre>session.getMaxInactiveInterval()</code>，返回整数s。
<ul>
<li>Tomcat服务器中进行了默认配置：1800s（30min）</li>
<li>超时指的是客户端两次请求的最大间隔时长，否则请求一次会创建一次，时间重新开始算。</li>
</ul>
</li>
<li>设置存活时间：<code v-pre>session.setMaxInactiveInterval(int interval)</code>，超过指定秒数，就销毁该session</li>
<li>设置马上失效：<code v-pre>session.invalidate()</code></li>
</ol>
<h3 id="_13-3-应用" tabindex="-1"><a class="header-anchor" href="#_13-3-应用" aria-hidden="true">#</a> 13.3 应用</h3>
<h4 id="_13-3-1-登录验证码" tabindex="-1"><a class="header-anchor" href="#_13-3-1-登录验证码" aria-hidden="true">#</a> 13.3.1 登录验证码</h4>
<ol>
<li>原理：
<ul>
<li>第一次访问表单时，给表单生成一个随机验证码，并保存到session域中</li>
<li>提交表单后，将session提交给服务器，服务器获得该验证码，同时服务器清空sessionu域（移除该session的值）</li>
<li>后续点击表单时，再随机生成验证码保存到session域中，提交表单后与服务器上的进行比较，是否相等（字符串内容）</li>
</ul>
</li>
<li>谷歌验证码的使用（kaptcha）：
<ul>
<li>导入谷歌验证码的 jar 包 kaptcha-2.3.2.ja</li>
<li>在 web.xml 中去配置用于生成验证码的 Servlet 程
<ul>
<li><img src="/images/javaweb/image-1660814104733.png" alt="image.png" loading="lazy"></li>
</ul>
</li>
<li>在表单中使用 img 标签去显示验证码图片并使用它
<ul>
<li><img src="/images/javaweb/image-1660814106611.png" alt="image.png" loading="lazy"></li>
</ul>
</li>
<li>在服务器获取谷歌生成的验证码和客户端发送过来的验证码比较使用。
<ul>
<li><img src="/images/javaweb/image-1660814108268.png" alt="image.png" loading="lazy"></li>
</ul>
</li>
</ul>
</li>
</ol>
<h2 id="第14章-filter过滤器" tabindex="-1"><a class="header-anchor" href="#第14章-filter过滤器" aria-hidden="true">#</a> 第14章 Filter过滤器</h2>
<h3 id="_14-1-filter概述" tabindex="-1"><a class="header-anchor" href="#_14-1-filter概述" aria-hidden="true">#</a> 14.1 Filter概述</h3>
<h4 id="_14-1-1-filter介绍" tabindex="-1"><a class="header-anchor" href="#_14-1-1-filter介绍" aria-hidden="true">#</a> 14.1.1 Filter介绍</h4>
<ol>
<li>JavaWeb 的三大组件之一。三大组件分别是：Servlet 程序、Listener 监听器、Filter 过滤器</li>
<li>是 JavaEE 的规范。也就是接口，<code v-pre>**javax.servlet.Filter**</code></li>
<li>Filter 过滤器它的作用是：拦截请求，过滤响应 。对Servlet容器传给web资源的request对象和response对象进行检查和修改</li>
<li>常见拦截请求场景：
<ul>
<li>权限检查</li>
<li>日记操作</li>
<li>事务管理</li>
</ul>
</li>
<li>特点：
<ul>
<li>Filter不能直接访问，本身也不能生成request和response对象。
<ul>
<li>在 Web 资源被访问前，检查 request 对象，修改请求头和请求正文，或对请求进行预处理操作。</li>
<li>将请求传递到下一个过滤器或目标资源。</li>
<li>在 Web 资源被访问后，检查 response 对象，修改响应头和响应正文。</li>
</ul>
</li>
</ul>
</li>
</ol>
<h4 id="_14-1-2-filter的使用" tabindex="-1"><a class="header-anchor" href="#_14-1-2-filter的使用" aria-hidden="true">#</a> 14.1.2 Filter的使用</h4>
<ul>
<li>编写类，实现Filter接口</li>
<li>实现过滤方法doFilter()</li>
<li>在<code v-pre>web.xml</code>中注册Filter拦截路径</li>
</ul>
<h4 id="_14-1-3-xml配置" tabindex="-1"><a class="header-anchor" href="#_14-1-3-xml配置" aria-hidden="true">#</a> 14.1.3 xml配置</h4>
<ol>
<li>语法结构：</li>
</ol>
<div class="language-xml ext-xml line-numbers-mode"><pre v-pre class="language-xml"><code><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>filter</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>filter-name</span><span class="token punctuation">></span></span>myFilter<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>filter-name</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>filter-class</span><span class="token punctuation">></span></span>com.baidu.www.MyFilter<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>filter-class</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>init-param</span><span class="token punctuation">></span></span>
        <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>param-name</span><span class="token punctuation">></span></span>name<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>param-name</span><span class="token punctuation">></span></span>
        <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>param-value</span><span class="token punctuation">></span></span>123<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>param-value</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>init-param</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>init-param</span><span class="token punctuation">></span></span>
        <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>param-name</span><span class="token punctuation">></span></span>URL<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>param-name</span><span class="token punctuation">></span></span>
        <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>param-value</span><span class="token punctuation">></span></span>www.baidu.com<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>param-value</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>init-param</span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>filter</span><span class="token punctuation">></span></span>

<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>filter-mapping</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>filter-name</span><span class="token punctuation">></span></span>myFilter<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>filter-name</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>url-pattern</span><span class="token punctuation">></span></span>/login<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>url-pattern</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>dispatcher</span><span class="token punctuation">></span></span>REQUEST<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>dispatcher</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>dispatcher</span><span class="token punctuation">></span></span>FORWARD<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>dispatcher</span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>filter-mapping</span><span class="token punctuation">></span></span>

<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>filter-mapping</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>filter-name</span><span class="token punctuation">></span></span>myFilter<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>filter-name</span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>servlet-name</span><span class="token punctuation">></span></span>ServletDemo<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>servlet-name</span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>filter-mapping</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ol start="2">
<li>注意点：
<ul>
<li><code v-pre>&lt;init-param&gt;</code>标签内配置filter过滤器的初始化参数，可以配置多个</li>
<li><code v-pre>dispatcher</code>指定给filter拦截的资源被Servlet容器调用的方式【Filter什么时候工作】，默认值为<code v-pre>REQUEST</code>，可以设置多个。
<ul>
<li><code v-pre>REQUERST</code>：用户直接访问地址时，容器调用过滤器</li>
<li><code v-pre>INCLUDE</code>：通过请求转发<code v-pre>RequestDispatcher</code>的<code v-pre>include()</code>方法时调用</li>
<li><code v-pre>FORWARD</code>通过请求转发<code v-pre>RequestDispatcher</code>的<code v-pre>forward()</code>方法时调用</li>
<li><code v-pre>ERROR</code>：通过声明式异常处理机制访问，该过滤器被调用。</li>
</ul>
</li>
</ul>
</li>
<li>匹配方式：<code v-pre>&lt;url-pattern&gt;</code>的值：
<ul>
<li>精确匹配：如<code v-pre>&lt;url-pattern&gt;/login.&lt;/url-pattern&gt;</code></li>
<li>目录匹配：如<code v-pre>&lt;url-pattern&gt;/admin/*&lt;/url-pattern&gt;</code></li>
<li>后缀名匹配：如<code v-pre>&lt;url-pattern&gt;*.html&lt;/url-pattern&gt;</code></li>
</ul>
</li>
</ol>
<h4 id="_14-1-4-注解配置" tabindex="-1"><a class="header-anchor" href="#_14-1-4-注解配置" aria-hidden="true">#</a> 14.1.4 注解配置</h4>
<table>
<thead>
<tr>
<th>属性名</th>
<th>类型</th>
<th>描述</th>
</tr>
</thead>
<tbody>
<tr>
<td>filterName</td>
<td>String</td>
<td>指定过滤器的 name 属性，等价于 <code v-pre>&lt;filter-name&gt;</code>。</td>
</tr>
<tr>
<td>urlPatterns</td>
<td>String[]</td>
<td>指定过滤器的 URL 匹配模式。等价于 <code v-pre>&lt;url-pattern&gt;</code> 标签。</td>
</tr>
<tr>
<td>value</td>
<td>String[]</td>
<td>该属性等价于 urlPatterns 属性，但是两者不能同时使用。</td>
</tr>
<tr>
<td>servletNames</td>
<td>String[]</td>
<td>指定过滤器将应用于哪些 Servlet。取值是 @WebServlet 中 filterName 属性的取值，或者 web.xml 中 <code v-pre>&lt;servlet-name&gt;</code> 的取值。</td>
</tr>
<tr>
<td>dispatcherTypes</td>
<td>DispatcherType</td>
<td>指定过滤器拦截的资源被 Servlet 容器调用的方式。具体取值包括： ASYNC、ERROR、FORWARD、INCLUDE、REQUEST。</td>
</tr>
<tr>
<td>initParams</td>
<td>WebInitParam[]</td>
<td>指定一组过滤器初始化参数，等价于 <code v-pre>&lt;init-param&gt;</code> 标签。</td>
</tr>
<tr>
<td>asyncSupported</td>
<td>boolean</td>
<td>声明过滤器是否支持异步操作模式，等价于 <code v-pre>&lt;async-supported&gt;</code> 标签。</td>
</tr>
<tr>
<td>description</td>
<td>String</td>
<td>指定过滤器的描述信息，等价于 <code v-pre>&lt;description&gt;</code> 标签。</td>
</tr>
<tr>
<td>displayName</td>
<td>String</td>
<td>指定过滤器的显示名，等价于 <code v-pre>&lt;display-name&gt;</code> 标签。</td>
</tr>
</tbody>
</table>
<ul>
<li>value、urlPatterns、servletNames 三者必需至少包含一个，且 value 和 urlPatterns 不能共存，如果同时指定，通常忽略 value 的取值。</li>
<li>其余均为可选项</li>
<li>通过@WebFilter注解注册的Filter，其加载顺序与执行顺序无关</li>
<li>通过@WebFilter注解注册的Filter，其加载顺序与注解的filterName值相关（底层通过HashMap存储，key值即filterName值）</li>
<li>通过@WebFilter注解注册的Filter，其执行顺序与类名有关，按照类名的字典顺序执行</li>
</ul>
<h3 id="_14-2-filter的生命周期" tabindex="-1"><a class="header-anchor" href="#_14-2-filter的生命周期" aria-hidden="true">#</a> 14.2 Filter的生命周期</h3>
<h4 id="_14-2-1-filter工作流程" tabindex="-1"><a class="header-anchor" href="#_14-2-1-filter工作流程" aria-hidden="true">#</a> 14.2.1 Filter工作流程</h4>
<p><img src="/images/javaweb/image-1660814113664.png" alt="image.png" loading="lazy"></p>
<ol>
<li>客户端请求访问容器内的 Web 资源。</li>
<li>Servlet 容器接收请求，并针对本次请求分别创建一个 request 对象和 response 对象。</li>
<li>请求到达 Web 资源之前，先调用 Filter 的 doFilter() 方法，检查 request 对象，修改请求头和请求正文，或对请求进行预处理操作。</li>
<li>在 Filter 的 doFilter() 方法内，调用 FilterChain.doFilter() 方法，将请求传递给下一个过滤器或目标资源。</li>
<li>目标资源生成响应信息返回客户端之前，处理控制权会再次回到 Filter 的doFilter() 方法，执行 FilterChain.doFilter() 后的语句，检查 response 对象，修改响应头和响应正文。</li>
<li>响应信息返回客户端。</li>
</ol>
<h4 id="_14-2-2-filter生命周期阶段" tabindex="-1"><a class="header-anchor" href="#_14-2-2-filter生命周期阶段" aria-hidden="true">#</a> 14.2.2 Filter生命周期阶段</h4>
<ol>
<li>初始化阶段：
<ul>
<li>Servlet 容器负责加载和实例化 Filter。容器启动时，读取 web.xml 或 @WebFilter 的配置信息对所有的过滤器进行加载和实例化。</li>
<li>加载和实例化完成后，Servlet 容器调用 init() 方法初始化 Filter 实例。</li>
<li>在 Filter 的生命周期内，初始化阶段只执行一次。</li>
<li>执行Filter构造器方法和init方法</li>
</ul>
</li>
<li>拦截和过滤阶段：
<ul>
<li>客户端请求的 URL 与过滤器映射匹配时，容器将该请求的 request 对象、response 对象以及 FilterChain 对象以参数的形式传递给 Filter 的 doFilter() 方法，并调用该方法对请求/响应进行拦截和过滤。</li>
<li>拦截一次执行一次。</li>
<li>执行<code v-pre>doFilter()</code>方法</li>
</ul>
</li>
<li>销毁阶段：
<ul>
<li>Filter 对象创建后会驻留在内存中，直到容器关闭或应用被移除时销毁。</li>
<li>销毁 Filter 对象之前，容器会先调用 destory() 方法，释放过滤器占用的资源。</li>
<li>在 Filter 的生命周期内，destory() 只执行一次。</li>
</ul>
</li>
</ol>
<h3 id="_14-3-filterconfig类" tabindex="-1"><a class="header-anchor" href="#_14-3-filterconfig类" aria-hidden="true">#</a> 14.3 FilterConfig类</h3>
<ul>
<li>Tomcat创建Filter类时，同时会创建一个FilterConig类，包含有Filter配置文件的配置信息</li>
<li>作用：获取filter过滤器的配置内容
<ul>
<li>获取Filter的名称——<code v-pre>&lt;filter-name&gt;</code>的内容</li>
<li>获取Filter中配置的<code v-pre>&lt;init-param&gt;</code>参数</li>
<li>获取ServletContext对象
| 返回值类型 | 方法 | 描述 |
| --- | --- | --- |
| String | getInitParameter(String name) | 根据初始化参数名 name，返回对应的初始化参数值。 |
| Enumeration | getInitParameterNames() | 返回过滤器的所有初始化参数名的枚举集合。 |
| ServletContext | getServletContext() | 返回 Servlet 上下文对象的引用。 |
| String | getFilterName()  | 返回过滤器的名称。 |</li>
</ul>
</li>
</ul>
<h3 id="_14-4-filterchain——过滤器链" tabindex="-1"><a class="header-anchor" href="#_14-4-filterchain——过滤器链" aria-hidden="true">#</a> 14.4 FilterChain——过滤器链</h3>
<h4 id="_14-4-1-过滤器链概念" tabindex="-1"><a class="header-anchor" href="#_14-4-1-过滤器链概念" aria-hidden="true">#</a> 14.4.1 过滤器链概念</h4>
<ul>
<li>多个 Filter都拦截同一目标资源，则它们就组成了一个 Filter 链（也称过滤器链）。</li>
<li>过滤器链中的每个过滤器负责特定的操作和任务，客户端的请求在这些过滤器之间传递，直到传递给目标资源。</li>
<li><code v-pre>**javax.servlet**</code></li>
</ul>
<h4 id="_14-4-2-filter链拦截过程" tabindex="-1"><a class="header-anchor" href="#_14-4-2-filter链拦截过程" aria-hidden="true">#</a> 14.4.2 Filter链拦截过程</h4>
<p><img src="/images/javaweb/image-1660814117749.png" alt="image.png" loading="lazy"></p>
<h4 id="_14-4-3-filter链中filter中的执行顺序" tabindex="-1"><a class="header-anchor" href="#_14-4-3-filter链中filter中的执行顺序" aria-hidden="true">#</a> 14.4.3 Filter链中Filter中的执行顺序</h4>
<ol>
<li>通过 web.xml 配置的 Filter 过滤器，执行顺序由 <code v-pre>&lt;filter-mapping&gt;</code> 标签的配置顺序决定。<code v-pre>&lt;filter-mapping&gt;</code> 靠前，则 Filter 先执行，靠后则后执行。</li>
<li>通过 @WebFilter 注解配置的 Filter 过滤器，无法进行排序。</li>
<li>默认情况下，一个Filter链中的Filter只有一个线程——在同一个线程中</li>
<li>默认情况下，一个Filter链中的Filter只有一个request对象和一个response对象——即共享request域对象</li>
</ol>
<h2 id="第15章-threadlocal" tabindex="-1"><a class="header-anchor" href="#第15章-threadlocal" aria-hidden="true">#</a> 第15章 ThreadLocal</h2>
<ol>
<li>作用：解决多线程的数据安全问题——事务操作的线程安全问题。称为本地线程。</li>
<li>特点：
<ul>
<li>可以给当前线程关联一个数据（可以是普通变量、对象、数组、集合等）</li>
<li>每个ThreadLocal对象，只能为当前线程关联一个数据，需要关联多个线程，则需要多个ThreadLocal对象实例。</li>
<li>每个ThreadLocal对象实例定义后，一般为static类型</li>
<li>ThreadLocal对象实例销毁后，保存的数据由JVM虚拟机自动释放</li>
</ul>
</li>
<li><code v-pre>set(obj)</code>：在当前线程存储数据</li>
</ol>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token keyword">public</span> <span class="token keyword">void</span> <span class="token function">set</span><span class="token punctuation">(</span><span class="token class-name">T</span> value<span class="token punctuation">)</span> <span class="token punctuation">{</span>
    <span class="token class-name">Thread</span> t <span class="token operator">=</span> <span class="token class-name">Thread</span><span class="token punctuation">.</span><span class="token function">currentThread</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span> <span class="token comment">//获取当前的线程</span>
    <span class="token class-name">ThreadLocalMap</span> map <span class="token operator">=</span> <span class="token function">getMap</span><span class="token punctuation">(</span>t<span class="token punctuation">)</span><span class="token punctuation">;</span>    <span class="token comment">//每一个线程都维护各自的一个容器（ThreadLocalMap）</span>
    <span class="token keyword">if</span> <span class="token punctuation">(</span>map <span class="token operator">!=</span> <span class="token keyword">null</span><span class="token punctuation">)</span>
        map<span class="token punctuation">.</span><span class="token function">set</span><span class="token punctuation">(</span><span class="token keyword">this</span><span class="token punctuation">,</span> value<span class="token punctuation">)</span><span class="token punctuation">;</span>          <span class="token comment">//这里的key对应的是ThreadLocal，因为我们的组件中需要传输（共享）的对象可能会有多个（不止Connection）</span>
    <span class="token keyword">else</span>
        <span class="token function">createMap</span><span class="token punctuation">(</span>t<span class="token punctuation">,</span> value<span class="token punctuation">)</span><span class="token punctuation">;</span>           <span class="token comment">//默认情况下map是没有初始化的，那么第一次往其中添加数据时，会去初始化</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ol start="4">
<li><code v-pre>get()</code>：在当前线程上获取数据</li>
</ol>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token keyword">public</span> <span class="token class-name">T</span> <span class="token function">get</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
    <span class="token class-name">Thread</span> t <span class="token operator">=</span> <span class="token class-name">Thread</span><span class="token punctuation">.</span><span class="token function">currentThread</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span> <span class="token comment">//获取当前的线程</span>
    <span class="token class-name">ThreadLocalMap</span> map <span class="token operator">=</span> <span class="token function">getMap</span><span class="token punctuation">(</span>t<span class="token punctuation">)</span><span class="token punctuation">;</span>    <span class="token comment">//获取和这个线程（企业）相关的ThreadLocalMap（也就是工作纽带的集合）</span>
    <span class="token keyword">if</span> <span class="token punctuation">(</span>map <span class="token operator">!=</span> <span class="token keyword">null</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
        <span class="token class-name">ThreadLocalMap<span class="token punctuation">.</span>Entry</span> e <span class="token operator">=</span> map<span class="token punctuation">.</span><span class="token function">getEntry</span><span class="token punctuation">(</span><span class="token keyword">this</span><span class="token punctuation">)</span><span class="token punctuation">;</span>   <span class="token comment">//this指的是ThreadLocal对象，通过它才能知道是哪一个工作纽带</span>
        <span class="token keyword">if</span> <span class="token punctuation">(</span>e <span class="token operator">!=</span> <span class="token keyword">null</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
            <span class="token annotation punctuation">@SuppressWarnings</span><span class="token punctuation">(</span><span class="token string">"unchecked"</span><span class="token punctuation">)</span>
            <span class="token class-name">T</span> result <span class="token operator">=</span> <span class="token punctuation">(</span><span class="token class-name">T</span><span class="token punctuation">)</span>e<span class="token punctuation">.</span>value<span class="token punctuation">;</span>     <span class="token comment">//entry.value就可以获取到工具箱了</span>
            <span class="token keyword">return</span> result<span class="token punctuation">;</span>
        <span class="token punctuation">}</span>
    <span class="token punctuation">}</span>
    <span class="token keyword">return</span> <span class="token function">setInitialValue</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><h2 id="第16章-json" tabindex="-1"><a class="header-anchor" href="#第16章-json" aria-hidden="true">#</a> 第16章 JSON</h2>
<h3 id="_16-1-json概述" tabindex="-1"><a class="header-anchor" href="#_16-1-json概述" aria-hidden="true">#</a> 16.1 JSON概述</h3>
<ol>
<li>JSON (JavaScript Object Notation) 是一种轻量级的数据交换格式。易于人阅读和编写。同时也易于机器解析和生成。JSON 采用完全独立于语言的文本格式，而且很多语言都提供了对 json 的支持（包括 C, C++, C#, Java, JavaScript, Perl, Python 等）。 这样就使得 JSON 成为理想的数据交换格式。</li>
</ol>
<ul>
<li>数据交换：客户端和服务器之间的业务数据传递</li>
</ul>
<ol start="2">
<li>数据格式：json 是由键值对组成，并且由花括号（大括号）包围。每个键由引号引起来，键和值之间使用冒号进行分隔， 多组键值对之间进行逗号进行分隔。</li>
<li>保存形式：
<ul>
<li>对象形式：json对象——常用于json数据操作</li>
<li>字符串形式：json字符串——常用于数据交换</li>
</ul>
</li>
<li>JSON常用方法：
<ul>
<li><code v-pre>JSON.stringify(xxx)</code>：对象转为字符串</li>
<li><code v-pre>JSON.parse(xxx)</code>字符串转为对象</li>
</ul>
</li>
</ol>
<h3 id="_16-2-操作json" tabindex="-1"><a class="header-anchor" href="#_16-2-操作json" aria-hidden="true">#</a> 16.2 操作JSON</h3>
<h4 id="_16-2-1-客户端操作json" tabindex="-1"><a class="header-anchor" href="#_16-2-1-客户端操作json" aria-hidden="true">#</a> 16.2.1 客户端操作JSON</h4>
<ol>
<li>浏览器操作JSON由JavaScript完成。</li>
<li>操作方式：<code v-pre>json对象.key</code>或<code v-pre>json对象[key]</code></li>
</ol>
<h4 id="_16-2-1-服务器端操作json" tabindex="-1"><a class="header-anchor" href="#_16-2-1-服务器端操作json" aria-hidden="true">#</a> 16.2.1 服务器端操作JSON</h4>
<blockquote>
<ul>
<li>jar包：gson-2.2.4.jar</li>
</ul>
</blockquote>
<ol>
<li>JavaBean和json相互转换：
<ul>
<li>创建Gson对象：<code v-pre>Gson gson = new Gson();</code></li>
<li>JavaBean转换为json字符串：调用<code v-pre>gson.toJson(JavaBean对象);</code></li>
<li>json字符串转换为JavaBean：调用<code v-pre>gson.formJson(json字符串, JavaBean.class);</code></li>
</ul>
</li>
<li>List和json相互转换
<ul>
<li>创建Gson对象：<code v-pre>Gson gson = new Gson();</code></li>
<li>List转换为json字符串：调用<code v-pre>gson.toJson(List对象);</code></li>
<li>json字符串转换为List：调用<code v-pre>gson.formJson(json字符串, List.class);</code>——得到的是一个
<ul>
<li>注意：此时得到的数据类型为<code v-pre>LinkedTreeMap</code>，而不是List中保存的对象类型</li>
</ul>
</li>
<li><code v-pre>gson.formJson(json字符串, new PersonListType().getType());</code>此时得到才是List类型，使用<code v-pre>get(n)</code>方法可以获取到具体的对象
<ul>
<li>PersonListType类的定义：<code v-pre>class PersonListType extends TypeToken&lt;List&lt;Person&gt;&gt;{}</code>——反射机制</li>
</ul>
</li>
<li>匿名内部类省去创建PersonListType类：<code v-pre>gson.formJson(json字符串, new TypeToken&lt;ArrayList&lt;Integer, Person&gt;&gt;(){}.getType())</code></li>
</ul>
</li>
<li>List和json相互转换
<ul>
<li>创建Gson对象：<code v-pre>Gson gson = new Gson();</code></li>
<li>Map转换为json字符串：调用<code v-pre>gson.toJson(Map对象);</code></li>
<li>json字符串转换为Map：调用<code v-pre>gson.formJson(json字符串, Map.class);</code>——得到的是一个
<ul>
<li>注意：此时得到的数据类型为<code v-pre>LinkedTreeMap</code>，而不是List中保存的对象类型</li>
</ul>
</li>
<li><code v-pre>gson.formJson(json字符串, new PersonListType().getType());</code>此时得到才是List类型，使用<code v-pre>get(n)</code>方法可以获取到具体的对象
<ul>
<li>PersonListType类的定义：<code v-pre>class PersonListType extends TypeToken&lt;List&lt;Person&gt;&gt;{}</code>——反射机制</li>
</ul>
</li>
<li>匿名内部类省去创建PersonListType类：<code v-pre>gson.formJson(json字符串, new TypeToken&lt;HashMap&lt;Integer, Person&gt;&gt;(){}.getType())</code></li>
</ul>
</li>
<li>举例：</li>
</ol>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token keyword">public</span> <span class="token keyword">void</span> <span class="token function">test3</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">{</span>
    <span class="token class-name">Map</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">Integer</span><span class="token punctuation">,</span><span class="token class-name">Person</span><span class="token punctuation">></span></span> personMap <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">HashMap</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token punctuation">></span></span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span> 
    personMap<span class="token punctuation">.</span><span class="token function">put</span><span class="token punctuation">(</span><span class="token number">1</span><span class="token punctuation">,</span> <span class="token keyword">new</span> <span class="token class-name">Person</span><span class="token punctuation">(</span><span class="token number">1</span><span class="token punctuation">,</span> <span class="token string">"国哥好帅"</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
    personMap<span class="token punctuation">.</span><span class="token function">put</span><span class="token punctuation">(</span><span class="token number">2</span><span class="token punctuation">,</span> <span class="token keyword">new</span> <span class="token class-name">Person</span><span class="token punctuation">(</span><span class="token number">2</span><span class="token punctuation">,</span> <span class="token string">"康师傅也好帅"</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span> 
    
    <span class="token class-name">Gson</span> gson <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">Gson</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
    
    <span class="token comment">// 把map集合转换成为json 字符串</span>
    <span class="token class-name">String</span> personMapJsonString <span class="token operator">=</span> gson<span class="token punctuation">.</span><span class="token function">toJson</span><span class="token punctuation">(</span>personMap<span class="token punctuation">)</span><span class="token punctuation">;</span> 
    <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span>personMapJsonString<span class="token punctuation">)</span><span class="token punctuation">;</span>
    
    <span class="token comment">//Map&lt;Integer,Person> personMap2 = gson.fromJson(personMapJsonString, new PersonMapType().getType());</span>
    <span class="token class-name">Map</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">Integer</span><span class="token punctuation">,</span><span class="token class-name">Person</span><span class="token punctuation">></span></span> personMap2 <span class="token operator">=</span> gson<span class="token punctuation">.</span><span class="token function">fromJson</span><span class="token punctuation">(</span>personMapJsonString<span class="token punctuation">,</span> <span class="token keyword">new</span> 
    <span class="token class-name">TypeToken</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token class-name">HashMap</span><span class="token punctuation">&lt;</span><span class="token class-name">Integer</span><span class="token punctuation">,</span><span class="token class-name">Person</span><span class="token punctuation">></span><span class="token punctuation">></span></span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">{</span><span class="token punctuation">}</span><span class="token punctuation">.</span><span class="token function">getType</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
    
    <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span>personMap2<span class="token punctuation">)</span><span class="token punctuation">;</span> 
    <span class="token class-name">Person</span> p <span class="token operator">=</span> personMap2<span class="token punctuation">.</span><span class="token function">get</span><span class="token punctuation">(</span><span class="token number">1</span><span class="token punctuation">)</span><span class="token punctuation">;</span> 
    <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span>p<span class="token punctuation">)</span><span class="token punctuation">;</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><h3 id="第17章-ajax" tabindex="-1"><a class="header-anchor" href="#第17章-ajax" aria-hidden="true">#</a> 第17章 Ajax</h3>
<h3 id="_17-1-ajax概述" tabindex="-1"><a class="header-anchor" href="#_17-1-ajax概述" aria-hidden="true">#</a> 17.1 Ajax概述</h3>
<ul>
<li>AJAX  即“Asynchronous  Javascript  And  XML”（异步  JavaScript  和  XML），是指一种创建交互式网页应用的网页开发技术。
<ul>
<li>ajax  是一种浏览器通过  js 异步发起请求，局部更新页面的技术。</li>
<li>Ajax  请求的局部更新，浏览器地址栏不会发生变化。</li>
<li>局部更新不会舍弃原来页面的内容。</li>
</ul>
</li>
<li>同步与异步的区别：
<ul>
<li>同步：用户发送请求后，页面不可使用，等待服务器响应完成</li>
<li>异步：页面还可以继续使用。</li>
<li>这也就是与重定向回原页面的区别，而且在响应完成后，页面的数据还是旧的。</li>
</ul>
</li>
</ul>
<h3 id="_17-2-ajax使用" tabindex="-1"><a class="header-anchor" href="#_17-2-ajax使用" aria-hidden="true">#</a> 17.2 Ajax使用</h3>
<h4 id="_17-2-1-原生ajax请求演示" tabindex="-1"><a class="header-anchor" href="#_17-2-1-原生ajax请求演示" aria-hidden="true">#</a> 17.2.1 原生Ajax请求演示</h4>
<ol>
<li>创建ajax对象：<code v-pre>var ajax= new XMLHttpRequest();</code></li>
<li>调用open方法设置请求参数：<code v-pre>ajax.open(&quot;GET&quot;, url&amp;param);</code></li>
<li>绑定onreadystatechange事件：<code v-pre>ajax.onreadystatechange = function(){if (xmlhttprequest.readyState == 4 &amp;&amp; xmlhttprequest.status == 200) { ajax.send(); }}|</code>
<ul>
<li>调用send方法发送请求：<code v-pre>ajax.send()</code></li>
</ul>
</li>
</ol>
<div class="language-html ext-html line-numbers-mode"><pre v-pre class="language-html"><code><span class="token doctype"><span class="token punctuation">&lt;!</span><span class="token doctype-tag">DOCTYPE</span> <span class="token name">html</span> <span class="token name">PUBLIC</span> <span class="token string">"-//W3C//DTD HTML 4.01 Transitional//EN"</span> <span class="token string">"http://www.w3.org/TR/html4/loose.dtd"</span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>html</span><span class="token punctuation">></span></span>
 <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>head</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>meta</span> <span class="token attr-name">http-equiv</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>pragma<span class="token punctuation">"</span></span> <span class="token attr-name">content</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>no-cache<span class="token punctuation">"</span></span> <span class="token punctuation">/></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>meta</span> <span class="token attr-name">http-equiv</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>cache-control<span class="token punctuation">"</span></span> <span class="token attr-name">content</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>no-cache<span class="token punctuation">"</span></span> <span class="token punctuation">/></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>meta</span> <span class="token attr-name">http-equiv</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>Expires<span class="token punctuation">"</span></span> <span class="token attr-name">content</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>0<span class="token punctuation">"</span></span> <span class="token punctuation">/></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>meta</span> <span class="token attr-name">http-equiv</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>Content-Type<span class="token punctuation">"</span></span> <span class="token attr-name">content</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>text/html; charset=UTF-8<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>title</span><span class="token punctuation">></span></span>Insert title here<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>title</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>script</span> <span class="token attr-name">type</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>text/javascript<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token script"><span class="token language-javascript">
   <span class="token comment">// 在这里使用javaScript语言发起Ajax请求，访问服务器AjaxServlet中javaScriptAjax</span>
   <span class="token keyword">function</span> <span class="token function">ajaxRequest</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
<span class="token comment">//     1、我们首先要创建XMLHttpRequest </span>
    <span class="token keyword">var</span> xmlhttprequest <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">XMLHttpRequest</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
<span class="token comment">//     2、调用open方法设置请求参数</span>
    xmlhttprequest<span class="token punctuation">.</span><span class="token function">open</span><span class="token punctuation">(</span><span class="token string">"GET"</span><span class="token punctuation">,</span><span class="token string">"http://localhost:8080/16_json_ajax_i18n/ajaxServlet?action=javaScriptAjax"</span><span class="token punctuation">,</span><span class="token boolean">true</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
<span class="token comment">//     4、在send方法前绑定onreadystatechange事件，处理请求完成后的操作。</span>
    xmlhttprequest<span class="token punctuation">.</span><span class="token function-variable function">onreadystatechange</span> <span class="token operator">=</span> <span class="token keyword">function</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">{</span>
     <span class="token keyword">if</span> <span class="token punctuation">(</span>xmlhttprequest<span class="token punctuation">.</span>readyState <span class="token operator">==</span> <span class="token number">4</span> <span class="token operator">&amp;&amp;</span> xmlhttprequest<span class="token punctuation">.</span>status <span class="token operator">==</span> <span class="token number">200</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
      <span class="token function">alert</span><span class="token punctuation">(</span><span class="token string">"收到服务器返回的数据："</span> <span class="token operator">+</span> xmlhttprequest<span class="token punctuation">.</span>responseText<span class="token punctuation">)</span><span class="token punctuation">;</span>
      <span class="token keyword">var</span> jsonObj <span class="token operator">=</span> <span class="token constant">JSON</span><span class="token punctuation">.</span><span class="token function">parse</span><span class="token punctuation">(</span>xmlhttprequest<span class="token punctuation">.</span>responseText<span class="token punctuation">)</span><span class="token punctuation">;</span>
      <span class="token comment">// 把响应的数据显示在页面上</span>
      document<span class="token punctuation">.</span><span class="token function">getElementById</span><span class="token punctuation">(</span><span class="token string">"div01"</span><span class="token punctuation">)</span><span class="token punctuation">.</span>innerHTML <span class="token operator">=</span> <span class="token string">"编号："</span> <span class="token operator">+</span> jsonObj<span class="token punctuation">.</span>id <span class="token operator">+</span> <span class="token string">" , 姓名："</span> <span class="token operator">+</span> jsonObj<span class="token punctuation">.</span>name<span class="token punctuation">;</span>
     <span class="token punctuation">}</span>
    <span class="token punctuation">}</span>
<span class="token comment">//     3、调用send方法发送请求</span>
    xmlhttprequest<span class="token punctuation">.</span><span class="token function">send</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token function">alert</span><span class="token punctuation">(</span><span class="token string">"我是最后一行的代码"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
   <span class="token punctuation">}</span>
  </span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>script</span><span class="token punctuation">></span></span>
 <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>head</span><span class="token punctuation">></span></span>
 <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>body</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>button</span> <span class="token special-attr"><span class="token attr-name">onclick</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span><span class="token value javascript language-javascript"><span class="token function">ajaxRequest</span><span class="token punctuation">(</span><span class="token punctuation">)</span></span><span class="token punctuation">"</span></span></span><span class="token punctuation">></span></span>ajax request<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>button</span><span class="token punctuation">></span></span>
  <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>div</span> <span class="token attr-name">id</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>div01<span class="token punctuation">"</span></span><span class="token punctuation">></span></span><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>div</span><span class="token punctuation">></span></span>
 <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>body</span><span class="token punctuation">></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>html</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><h4 id="_17-2-2-jquery中ajax演示" tabindex="-1"><a class="header-anchor" href="#_17-2-2-jquery中ajax演示" aria-hidden="true">#</a> 17.2.2 jQuery中ajax演示</h4>
<ol>
<li><code v-pre>$.ajax({参数})</code>
<ul>
<li><code v-pre>url</code>：</li>
<li><code v-pre>type</code>：请求类型</li>
<li><code v-pre>data</code>：发送给服务区的数据
<ul>
<li>格式一：<code v-pre>key1=value1&amp;key2=value2</code></li>
<li>格式二：<code v-pre>{key1:value1, key2;value2}</code></li>
</ul>
</li>
<li><code v-pre>success</code>：请求成功时，响应的回调函数，服务器返回的<code v-pre>data</code>，以参数的形式被success使用</li>
<li><code v-pre>dataType</code>：响应数据类型
<ul>
<li><code v-pre>text</code></li>
<li><code v-pre>xml</code></li>
<li><code v-pre>json</code></li>
</ul>
</li>
</ul>
</li>
</ol>
<p>2.<code v-pre>$.get({参数})</code>和<code v-pre>$.post({参数})</code>：对<code v-pre>$.ajax({参数})</code>的进一步封装</p>
<ul>
<li><code v-pre>url</code>：</li>
<li><code v-pre>data</code>：发送给服务区的数据
<ul>
<li>格式一：<code v-pre>key1=value1&amp;key2=value2</code></li>
<li>格式二：<code v-pre>{key1:value1, key2;value2}</code></li>
</ul>
</li>
<li><code v-pre>callback</code>：请求成功时，响应的回调函数，服务器返回的<code v-pre>data</code>，以参数的形式被callback使用</li>
<li><code v-pre>type</code>：响应数据类型
<ul>
<li><code v-pre>text</code></li>
<li><code v-pre>xml</code></li>
<li><code v-pre>json</code></li>
</ul>
</li>
</ul>
<ol start="3">
<li><code v-pre>$.getJSON({参数})</code>：对<code v-pre>$.get({参数})</code>的进一步封装
<ul>
<li><code v-pre>url</code>：</li>
<li><code v-pre>data</code>：发送给服务区的数据
<ul>
<li>格式一：<code v-pre>key1=value1&amp;key2=value2</code></li>
<li>格式二：<code v-pre>{key1:value1, key2;value2}</code></li>
</ul>
</li>
<li><code v-pre>callback</code>：请求成功时，响应的回调函数，服务器返回的<code v-pre>data</code>，以参数的形式被callback使用</li>
</ul>
</li>
<li><code v-pre>serialize()</code>：表单序列化——将表单的内容以<code v-pre>key1=value1&amp;key2=value2</code>的形式拼接【表单的方法】</li>
</ol>
<h2 id="第18章-国际化-i18" tabindex="-1"><a class="header-anchor" href="#第18章-国际化-i18" aria-hidden="true">#</a> 第18章 国际化（i18）</h2>
<p><img src="/images/javaweb/image-1660814161711.png" alt="image.png" loading="lazy"></p>
<div class="language-properties ext-properties line-numbers-mode"><pre v-pre class="language-properties"><code><span class="token key attr-name">username</span><span class="token punctuation">=</span><span class="token value attr-value">username </span>
<span class="token key attr-name">password</span><span class="token punctuation">=</span><span class="token value attr-value">password </span>
<span class="token key attr-name">sex</span><span class="token punctuation">=</span><span class="token value attr-value">sex</span>
<span class="token key attr-name">age</span><span class="token punctuation">=</span><span class="token value attr-value">age </span>
<span class="token key attr-name">regist</span><span class="token punctuation">=</span><span class="token value attr-value">regist </span>
<span class="token key attr-name">boy</span><span class="token punctuation">=</span><span class="token value attr-value">boy </span>
<span class="token key attr-name">email</span><span class="token punctuation">=</span><span class="token value attr-value">email </span>
<span class="token key attr-name">girl</span><span class="token punctuation">=</span><span class="token value attr-value">girl </span>
<span class="token key attr-name">reset</span><span class="token punctuation">=</span><span class="token value attr-value">reset </span>
<span class="token key attr-name">submit</span><span class="token punctuation">=</span><span class="token value attr-value">submit</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><div class="language-properties ext-properties line-numbers-mode"><pre v-pre class="language-properties"><code><span class="token key attr-name">username</span><span class="token punctuation">=</span><span class="token value attr-value">用户名 </span>
<span class="token key attr-name">password</span><span class="token punctuation">=</span><span class="token value attr-value">密码 </span>
<span class="token key attr-name">sex</span><span class="token punctuation">=</span><span class="token value attr-value">性别</span>
<span class="token key attr-name">age</span><span class="token punctuation">=</span><span class="token value attr-value">年龄 </span>
<span class="token key attr-name">regist</span><span class="token punctuation">=</span><span class="token value attr-value">注册 </span>
<span class="token key attr-name">boy</span><span class="token punctuation">=</span><span class="token value attr-value">男 </span>
<span class="token key attr-name">girl</span><span class="token punctuation">=</span><span class="token value attr-value">女 </span>
<span class="token key attr-name">email</span><span class="token punctuation">=</span><span class="token value attr-value">邮箱 </span>
<span class="token key attr-name">reset</span><span class="token punctuation">=</span><span class="token value attr-value">重置 </span>
<span class="token key attr-name">submit</span><span class="token punctuation">=</span><span class="token value attr-value">提交</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ul>
<li>配置文件命名规则：<code v-pre>basename_en_US.pproperties</code></li>
<li>获取语言国家信息（en_US和zh_CN)：
<ul>
<li><code v-pre>java.utli.Locale</code>类实例化<code v-pre>Locale locale = Local.getDefault();</code></li>
<li><code v-pre>Locale</code>的静态常量获取：
<ul>
<li><code v-pre>Locale.CHINA</code></li>
<li><code v-pre>Locale.US</code></li>
</ul>
</li>
</ul>
</li>
<li>通过指定的basename和Locale对象，读取配置文件及文件内容
<ul>
<li><code v-pre>ResourceBundle bundle = ResourceBundle.getBundle(&quot;i18n&quot;, locale);</code></li>
<li><code v-pre>bundle.getString(&quot;key&quot;)</code></li>
</ul>
</li>
<li>方式一：使用请求头实现国际化：</li>
<li>方式二：使用手动选择实现国际化：</li>
<li>方式三：使用JSTL标签库实现国际化：需要使用fmt——格式化库，即导入相应包</li>
</ul>
<p><img src="/images/javaweb/image-1660814166873.png" alt="" loading="lazy">
<a href="https://www.yuque.com/attachments/yuque/0/2022/pdf/1604140/1657613355584-8bdaac8e-f448-476e-b78e-32ca64c4567a.pdf" target="_blank" rel="noopener noreferrer">16_尚硅谷_JSON、Aajx、i18n_王振国 - 课堂笔记.pdf<ExternalLinkIcon/></a></p>
<h2 id="第19章-thymeleaf" tabindex="-1"><a class="header-anchor" href="#第19章-thymeleaf" aria-hidden="true">#</a> 第19章 Thymeleaf</h2>
<blockquote>
<ul>
<li>
<p>视图模板技术</p>
</li>
<li>
<p>使用前添加jar包：</p>
</li>
<li></li>
</ul>
</blockquote>
<h4 id="使用步骤" tabindex="-1"><a class="header-anchor" href="#使用步骤" aria-hidden="true">#</a> 使用步骤</h4>
<ol>
<li>添加thymeleaf的jar包</li>
<li>新建一个Servlet类<code v-pre>ViewBaseServlet.java</code></li>
</ol>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token keyword">package</span> <span class="token namespace">myspringmvc</span><span class="token punctuation">;</span>

<span class="token keyword">import</span> <span class="token import"><span class="token namespace">org<span class="token punctuation">.</span>thymeleaf<span class="token punctuation">.</span></span><span class="token class-name">TemplateEngine</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">org<span class="token punctuation">.</span>thymeleaf<span class="token punctuation">.</span>context<span class="token punctuation">.</span></span><span class="token class-name">WebContext</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">org<span class="token punctuation">.</span>thymeleaf<span class="token punctuation">.</span>templatemode<span class="token punctuation">.</span></span><span class="token class-name">TemplateMode</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">org<span class="token punctuation">.</span>thymeleaf<span class="token punctuation">.</span>templateresolver<span class="token punctuation">.</span></span><span class="token class-name">ServletContextTemplateResolver</span></span><span class="token punctuation">;</span>

<span class="token keyword">import</span> <span class="token import"><span class="token namespace">javax<span class="token punctuation">.</span>servlet<span class="token punctuation">.</span></span><span class="token class-name">ServletContext</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">javax<span class="token punctuation">.</span>servlet<span class="token punctuation">.</span></span><span class="token class-name">ServletException</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">javax<span class="token punctuation">.</span>servlet<span class="token punctuation">.</span>http<span class="token punctuation">.</span></span><span class="token class-name">HttpServlet</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">javax<span class="token punctuation">.</span>servlet<span class="token punctuation">.</span>http<span class="token punctuation">.</span></span><span class="token class-name">HttpServletRequest</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">javax<span class="token punctuation">.</span>servlet<span class="token punctuation">.</span>http<span class="token punctuation">.</span></span><span class="token class-name">HttpServletResponse</span></span><span class="token punctuation">;</span>
<span class="token keyword">import</span> <span class="token import"><span class="token namespace">java<span class="token punctuation">.</span>io<span class="token punctuation">.</span></span><span class="token class-name">IOException</span></span><span class="token punctuation">;</span>

<span class="token keyword">public</span> <span class="token keyword">class</span> <span class="token class-name">ViewBaseServlet</span> <span class="token keyword">extends</span> <span class="token class-name">HttpServlet</span> <span class="token punctuation">{</span>

    <span class="token keyword">private</span> <span class="token class-name">TemplateEngine</span> templateEngine<span class="token punctuation">;</span>

    <span class="token annotation punctuation">@Override</span>
    <span class="token keyword">public</span> <span class="token keyword">void</span> <span class="token function">init</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token keyword">throws</span> <span class="token class-name">ServletException</span> <span class="token punctuation">{</span>

        <span class="token comment">// 1.获取ServletContext对象</span>
        <span class="token class-name">ServletContext</span> servletContext <span class="token operator">=</span> <span class="token keyword">this</span><span class="token punctuation">.</span><span class="token function">getServletContext</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>

        <span class="token comment">// 2.创建Thymeleaf解析器对象</span>
        <span class="token class-name">ServletContextTemplateResolver</span> templateResolver <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">ServletContextTemplateResolver</span><span class="token punctuation">(</span>servletContext<span class="token punctuation">)</span><span class="token punctuation">;</span>

        <span class="token comment">// 3.给解析器对象设置参数</span>
        <span class="token comment">// ①HTML是默认模式，明确设置是为了代码更容易理解</span>
        templateResolver<span class="token punctuation">.</span><span class="token function">setTemplateMode</span><span class="token punctuation">(</span><span class="token class-name">TemplateMode</span><span class="token punctuation">.</span>HTML<span class="token punctuation">)</span><span class="token punctuation">;</span>

        <span class="token comment">// ②设置前缀</span>
        <span class="token class-name">String</span> viewPrefix <span class="token operator">=</span> servletContext<span class="token punctuation">.</span><span class="token function">getInitParameter</span><span class="token punctuation">(</span><span class="token string">"view-prefix"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>

        templateResolver<span class="token punctuation">.</span><span class="token function">setPrefix</span><span class="token punctuation">(</span>viewPrefix<span class="token punctuation">)</span><span class="token punctuation">;</span>

        <span class="token comment">// ③设置后缀</span>
        <span class="token class-name">String</span> viewSuffix <span class="token operator">=</span> servletContext<span class="token punctuation">.</span><span class="token function">getInitParameter</span><span class="token punctuation">(</span><span class="token string">"view-suffix"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>

        templateResolver<span class="token punctuation">.</span><span class="token function">setSuffix</span><span class="token punctuation">(</span>viewSuffix<span class="token punctuation">)</span><span class="token punctuation">;</span>

        <span class="token comment">// ④设置缓存过期时间（毫秒）</span>
        templateResolver<span class="token punctuation">.</span><span class="token function">setCacheTTLMs</span><span class="token punctuation">(</span><span class="token number">60000L</span><span class="token punctuation">)</span><span class="token punctuation">;</span>

        <span class="token comment">// ⑤设置是否缓存</span>
        templateResolver<span class="token punctuation">.</span><span class="token function">setCacheable</span><span class="token punctuation">(</span><span class="token boolean">true</span><span class="token punctuation">)</span><span class="token punctuation">;</span>

        <span class="token comment">// ⑥设置服务器端编码方式</span>
        templateResolver<span class="token punctuation">.</span><span class="token function">setCharacterEncoding</span><span class="token punctuation">(</span><span class="token string">"utf-8"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>

        <span class="token comment">// 4.创建模板引擎对象</span>
        templateEngine <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">TemplateEngine</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>

        <span class="token comment">// 5.给模板引擎对象设置模板解析器</span>
        templateEngine<span class="token punctuation">.</span><span class="token function">setTemplateResolver</span><span class="token punctuation">(</span>templateResolver<span class="token punctuation">)</span><span class="token punctuation">;</span>

    <span class="token punctuation">}</span>

    <span class="token keyword">protected</span> <span class="token keyword">void</span> <span class="token function">processTemplate</span><span class="token punctuation">(</span><span class="token class-name">String</span> templateName<span class="token punctuation">,</span> <span class="token class-name">HttpServletRequest</span> req<span class="token punctuation">,</span> <span class="token class-name">HttpServletResponse</span> resp<span class="token punctuation">)</span> <span class="token keyword">throws</span> <span class="token class-name">IOException</span> <span class="token punctuation">{</span>
        <span class="token comment">// 1.设置响应体内容类型和字符集</span>
        resp<span class="token punctuation">.</span><span class="token function">setContentType</span><span class="token punctuation">(</span><span class="token string">"text/html;charset=UTF-8"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>

        <span class="token comment">// 2.创建WebContext对象</span>
        <span class="token class-name">WebContext</span> webContext <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">WebContext</span><span class="token punctuation">(</span>req<span class="token punctuation">,</span> resp<span class="token punctuation">,</span> <span class="token function">getServletContext</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>

        <span class="token comment">// 3.处理模板数据</span>
        templateEngine<span class="token punctuation">.</span><span class="token function">process</span><span class="token punctuation">(</span>templateName<span class="token punctuation">,</span> webContext<span class="token punctuation">,</span> resp<span class="token punctuation">.</span><span class="token function">getWriter</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
    <span class="token punctuation">}</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ol start="3">
<li>在web.xml文件中添加配置【init方法中会使用到】
<ul>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1658132551464-6092141d-4901-4df2-a797-89ced52f6dd0.png#clientId=u9bfe48f2-f53d-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=220&amp;id=u1f989b56&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=220&amp;originWidth=521&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=26050&amp;status=done&amp;style=none&amp;taskId=uc9563195-292f-4e8e-84df-26dba3a40ed&amp;title=&amp;width=521" alt="image.png" loading="lazy"></li>
</ul>
</li>
<li>业务Servlet继承ViewBaseServlet</li>
<li>调用父类（ViewBaseServlet）的<code v-pre>processTemplate</code>方法
<ul>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1658132770947-0b3a81d3-81f2-46af-b917-06b1bea5fba4.png#clientId=u9bfe48f2-f53d-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=135&amp;id=u9f24c1ff&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=135&amp;originWidth=500&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=34079&amp;status=done&amp;style=none&amp;taskId=u057be658-493e-4be3-a5ad-7feca79954f&amp;title=&amp;width=500" alt="image.png" loading="lazy"></li>
</ul>
</li>
<li>html页面使用thymeleaf的标签</li>
</ol>
<ul>
<li>修改html文件的表头：<code v-pre>&lt;html xmlns:th=&quot;http://www.thymeleaf.org&quot;&gt;</code></li>
<li><code v-pre>&lt;th:if&gt;</code></li>
<li><code v-pre>&lt;th:unless&gt;</code></li>
<li><code v-pre>&lt;th:each&gt;</code></li>
<li><code v-pre>&lt;th:text&gt;</code></li>
</ul>
<p><img src="/images/javaweb/image-1660814172741.png" alt="image.png" loading="lazy"></p>
<ul>
<li>如果要利用Java8中，反射获取方法真实的形参名称的话，需要开启上述设置。</li>
</ul>
<h2 id="第20章-ioc" tabindex="-1"><a class="header-anchor" href="#第20章-ioc" aria-hidden="true">#</a> 第20章 IoC</h2>
<ol>
<li>耦合/依赖
<ul>
<li>依赖指的是某某某离不开某某某。</li>
<li>在软件系统中，层与层之间是存在依赖的。我们也称之为耦合。</li>
<li>系统架构或者是设计的一个原则是： 高内聚低耦合。</li>
<li>层内部的组成应该是高度聚合的，而层与层之间的关系应该是低耦合的，最理想的情况0耦合（就是没有耦合）</li>
</ul>
</li>
<li>IOC - 控制反转 / DI - 依赖注入</li>
</ol>
<ul>
<li>控制反转：
<ul>
<li>之前在Servlet中，我们创建service对象 ， FruitService fruitService = new FruitServiceImpl();</li>
<li>这句话如果出现在servlet中的某个方法内部，那么这个fruitService的作用域（生命周期）应该就是这个方法级别；</li>
<li>如果这句话出现在servlet的类中，也就是说fruitService是一个成员变量，那么这个fruitService的作用域（生命周期）应该就是这个servlet实例级别</li>
<li>之后我们在applicationContext.xml中定义了这个fruitService。然后通过解析XML，产生fruitService实例，存放在beanMap中，这个beanMap在一个BeanFactory中</li>
<li>因此，我们转移（改变）了之前的service实例、dao实例等等他们的生命周期。控制权从程序员转移到BeanFactory。这个现象我们称之为控制反转</li>
</ul>
</li>
<li>依赖注入：
<ul>
<li>之前我们在控制层出现代码：FruitService fruitService = new FruitServiceImpl()；</li>
<li>那么，控制层和service层存在耦合。</li>
<li>之后，我们将代码修改成FruitService fruitService = null ;</li>
<li>然后，在配置文件中配置:</li>
</ul>
</li>
</ul>
<div class="language-xml ext-xml line-numbers-mode"><pre v-pre class="language-xml"><code><span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>bean</span> <span class="token attr-name">id</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>fruit<span class="token punctuation">"</span></span> <span class="token attr-name">class</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>FruitController<span class="token punctuation">"</span></span><span class="token punctuation">></span></span>
    <span class="token tag"><span class="token tag"><span class="token punctuation">&lt;</span>property</span> <span class="token attr-name">name</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>fruitService<span class="token punctuation">"</span></span> <span class="token attr-name">ref</span><span class="token attr-value"><span class="token punctuation attr-equals">=</span><span class="token punctuation">"</span>fruitService<span class="token punctuation">"</span></span><span class="token punctuation">/></span></span>
<span class="token tag"><span class="token tag"><span class="token punctuation">&lt;/</span>bean</span><span class="token punctuation">></span></span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><h2 id="开发经验" tabindex="-1"><a class="header-anchor" href="#开发经验" aria-hidden="true">#</a> 开发经验</h2>
<h3 id="_1-表单重复提交" tabindex="-1"><a class="header-anchor" href="#_1-表单重复提交" aria-hidden="true">#</a> 1. 表单重复提交</h3>
<h4 id="_1-1-情况一" tabindex="-1"><a class="header-anchor" href="#_1-1-情况一" aria-hidden="true">#</a> 1.1 情况一</h4>
<div class="custom-container danger"><p class="custom-container-title">警告</p>
<p>**问题描述：**web提交完表单。服务器使用请求转来进行页面跳转。这个时候，用户按下功能键 F5，就会发起最后一次的请求。 造成表单重复提交问题</p>
</div>
<div class="custom-container warning"><p class="custom-container-title">注意</p>
<p>**发生原因：**浏览器的地址带了请求参数，没有发生变化，刷新页面相当于再次提交请求。</p>
</div>
<blockquote>
<p>**解决方案：**使用重定向来进行跳转，改变浏览器ip</p>
</blockquote>
<h4 id="_1-2-情况二" tabindex="-1"><a class="header-anchor" href="#_1-2-情况二" aria-hidden="true">#</a> 1.2 情况二</h4>
<div class="custom-container danger"><p class="custom-container-title">警告</p>
<p><strong>问题描述：</strong> 用户正常提交服务器，但是由于网络延迟等原因，迟迟未收到服务器的响应，这个时候，用户以为提交失败， 就会着急，然后多点了几次提交操作，也会造成表单重复提交</p>
</div>
<div class="custom-container warning"><p class="custom-container-title">注意</p>
<p><strong>发生原因：</strong></p>
</div>
<blockquote>
<p>**解决方案：**使用验证码</p>
</blockquote>
<h4 id="_1-3-情况三" tabindex="-1"><a class="header-anchor" href="#_1-3-情况三" aria-hidden="true">#</a> 1.3 情况三</h4>
<div class="custom-container danger"><p class="custom-container-title">警告</p>
<p><strong>问题描述：</strong>  用户正常提交服务器。服务器也没有延迟，但是提交完成后，用户回退浏览器。重新提交。也会造成表单重复提交</p>
</div>
<div class="custom-container warning"><p class="custom-container-title">注意</p>
<p><strong>发生原因：</strong></p>
</div>
<blockquote>
<p>**解决方案：**使用验证码</p>
</blockquote>
<h3 id="_2-排错" tabindex="-1"><a class="header-anchor" href="#_2-排错" aria-hidden="true">#</a> 2. 排错</h3>
<ul>
<li>如果发现访问不到资源，工程启动后不经过servlet，问题多半是工件是web exploded，将它新建为war exploded即可。</li>
</ul>
<p><img src="/images/javaweb/image-1660814183971.png" alt="image.png" loading="lazy"></p>
<ul>
<li><strong>一个问题：idea 的项目部署的 web exploded 和 war exploded 和 war 的区别是啥？啥时候用哪个？</strong></li>
</ul>
</div></template>
