<template><div><h1 id="java语言基础-上" tabindex="-1"><a class="header-anchor" href="#java语言基础-上" aria-hidden="true">#</a> Java语言基础（上）</h1>
<h2 id="第1章-java语言概述" tabindex="-1"><a class="header-anchor" href="#第1章-java语言概述" aria-hidden="true">#</a> 第1章 java语言概述</h2>
<h3 id="_1-0-计算机基础" tabindex="-1"><a class="header-anchor" href="#_1-0-计算机基础" aria-hidden="true">#</a> 1.0 计算机基础</h3>
<h4 id="_1-0-1-基本知识" tabindex="-1"><a class="header-anchor" href="#_1-0-1-基本知识" aria-hidden="true">#</a> 1.0.1 基本知识</h4>
<ol>
<li>现代计算机基础：冯诺依曼体系结构</li>
<li>IT定律（硬件）：
<ul>
<li>摩尔定律：18-24个月，计算机性能提升一倍。</li>
<li>反摩尔定律：如果现在和18个月前卖掉同样多的同样的产品，营业也就会下降一半。</li>
<li>安迪-比尔定律：硬件性能的提高，很快会被软件消耗掉。</li>
</ul>
</li>
<li>DOS命令：
<ul>
<li><code v-pre>md</code>：创建文件夹</li>
<li><code v-pre>rd</code>：删除文件夹</li>
<li><code v-pre>del</code>：删除文件</li>
<li><code v-pre>cd</code>：切换路径</li>
<li><code v-pre>dir</code>：查看当前路径下的文件和文件夹</li>
<li><code v-pre>cd</code>：切换路径
<ul>
<li><code v-pre>cd \</code>：切换到根路径。</li>
</ul>
</li>
<li><code v-pre>tree</code>：指定目录下的所有文件（显示文件树）</li>
<li><code v-pre>cls</code>：清屏</li>
<li><code v-pre>exit</code>：退出dos</li>
</ul>
</li>
<li>编码：
<ul>
<li>ASCII：一个字节表示一个字符，共128个。</li>
<li>Unicode：两个字节表示一个字符，字母和汉字都用2个字符表示，存在浪费空间问题。<strong>兼容ASCII编码</strong></li>
<li>UTF-8：大小可变编码，字母用一个字节，汉字用3个字节</li>
<li>gbk：字母用1个字节，汉字用2个字节。</li>
<li>gb2312：同gbk，表示范围小于gbk</li>
<li>big5：繁体中文</li>
</ul>
</li>
</ol>
<h4 id="_1-0-2-整数的四种表示方式" tabindex="-1"><a class="header-anchor" href="#_1-0-2-整数的四种表示方式" aria-hidden="true">#</a> 1.0.2 整数的四种表示方式</h4>
<ol>
<li>二进制：0和1，以0b或0B开头。</li>
<li>八进制：0-7，以0开头。</li>
<li>十进制：0-9。</li>
<li>十六进制：0-9以及A-F（a-f），以0x或0X开头。</li>
</ol>
<h4 id="_1-0-3-进制转换" tabindex="-1"><a class="header-anchor" href="#_1-0-3-进制转换" aria-hidden="true">#</a> 1.0.3 进制转换</h4>
<ol>
<li>其他进制转十进制：
<ul>
<li>二进制转十进制：<code v-pre>每个位上的数 * 2^indx</code>的和，index从右向左依次为0至n。</li>
<li>八进制转十进制：<code v-pre>每个位上的数 * 8^indx</code>的和，index从右向左依次为0至n。</li>
<li>十六进制转十进制：<code v-pre>每个位上的数 * 16^indx</code>的和，index从右向左依次为0至n。</li>
</ul>
</li>
<li>十进制转其他进制：
<ul>
<li>十进制转二进制：该数不断除2，直到商为0，将余数倒序拼接。</li>
<li>十进制转八进制：该数不断除8，直到商为0，将余数倒序拼接。</li>
<li>十进制转十六进制：该数不断除16，直到商为0，将余数倒序拼接。</li>
</ul>
</li>
<li>二进制转其他进制：
<ul>
<li>二进制转八进制：从右向左，3个数一组，对应的十进制数组合后即为八进制。</li>
<li>二进制转十六进制：从右向左，4个数一组，对应的十进制数组合后即为十六进制。</li>
</ul>
</li>
<li>其他进制转二进制：
<ul>
<li>八进制转二进制：将八进制的每一个数，转成对应的3位数二进制即可。</li>
<li>十六进制转二进制：将十六进制的每一个数，转成对应的4位数二进制即可。</li>
</ul>
</li>
</ol>
<h3 id="_1-1-java简介" tabindex="-1"><a class="header-anchor" href="#_1-1-java简介" aria-hidden="true">#</a> 1.1 java简介</h3>
<h4 id="_1-1-1-java的常见概念及关系" tabindex="-1"><a class="header-anchor" href="#_1-1-1-java的常见概念及关系" aria-hidden="true">#</a> 1.1.1 Java的常见概念及关系</h4>
<ol>
<li>java SE、Java EE、Java ME的关系
<ul>
<li><img src="/images/javase/java-1/image.png" alt="image.png" loading="lazy"></li>
</ul>
</li>
<li>JDK和JRE：
<ul>
<li>JDK： Java Development Kit，把Java源码编译成Java字节码。
<ul>
<li>JDK=JRE+Java开发工具</li>
</ul>
</li>
<li>JRE： Java Runtime Environment，运行Java字节码的虚拟机。
<ul>
<li>JRE=JVM+核心类库</li>
</ul>
</li>
<li><img src="/images/javase/java-1/image-1660367247860.png" alt="image.png" loading="lazy"></li>
</ul>
</li>
<li>JSR和JCP：
<ul>
<li>JSR规范：Java Specification Request</li>
<li>JCP组织：Java Community Process，负责JSR。</li>
</ul>
</li>
<li>JDK的可执行文件：
<ul>
<li>java：这个可执行程序其实就是JVM，运行Java程序，就是启动JVM，然后让JVM执行指定的编译后的代码；</li>
<li>javac：这是Java的编译器，它用于把Java源码文件（以.java后缀结尾）编译为Java字节码文件（以.class后缀结尾）；</li>
<li>jar：用于把一组.class文件打包成一个.jar文件，便于发布；</li>
<li>javadoc：用于从Java源码中自动提取注释并生成文档；</li>
<li>jdb：Java调试器，用于开发阶段的运行调试。</li>
</ul>
</li>
<li>Java的特点：
<ul>
<li>面向对象（oop）</li>
<li>健壮性：强类型机制、异常处理、垃圾自动收集等。</li>
<li>跨平台的。</li>
<li>解释性的：
<ul>
<li>解释性语言编译后不能直接被机器运行，需要解释器执行。</li>
<li>编译性语言编译后的代码可以直接被机器执行，如C，C++</li>
</ul>
</li>
</ul>
</li>
</ol>
<h4 id="_1-1-2-下载jdk程序" tabindex="-1"><a class="header-anchor" href="#_1-1-2-下载jdk程序" aria-hidden="true">#</a> 1.1.2 下载JDK程序</h4>
<ol>
<li>由于发展原因：推荐下载jdk8U201版本（最后一稳定版本、长期支持版本）
<ul>
<li><img src="/images/javase/java-1/image-1660367252184.png" alt="image.png" loading="lazy"></li>
<li>安装jdk8时，已经带了jre，但安装程序最后还会额外安装jre8，为了避免开发工具配置出错（如Eclipse），建议安装。
<ul>
<li><img src="/images/javase/java-1/image-1660367312841.png" alt="image.png" loading="lazy"></li>
<li><img src="/images/javase/java-1/image-1660367317422.png" alt="image.png" loading="lazy"></li>
</ul>
</li>
</ul>
</li>
<li>本机的安装参考：<img src="/images/javase/java-1/image-1660367330866.png" alt="image.png" loading="lazy"></li>
</ol>
<h4 id="_1-1-3-jdk环境变量配置" tabindex="-1"><a class="header-anchor" href="#_1-1-3-jdk环境变量配置" aria-hidden="true">#</a> 1.1.3 JDK环境变量配置</h4>
<ol>
<li>虽然安装java时，环境变量<code v-pre>Path</code>下已经有默认配置，能够在任何位置的cmd终端执行<code v-pre>java</code>命令。
<ul>
<li><img src="/images/javase/java-1/image-1660367339703.png" alt="image.png" loading="lazy"></li>
</ul>
</li>
<li>但依赖JDK环境变量的其他程序配置仍然需要重新配置<code v-pre>JAVA_HOME</code>，如Tomcat，不配置会出现执行Tomcat的开启命令会出现一闪而过的情况，Tomcat也不会运行起来。</li>
<li>配置参数：
<ul>
<li><code v-pre>JAVA_HOME</code>：<img src="/images/javase/java-1/image-1660367346864.png" alt="image.png" loading="lazy"></li>
<li><code v-pre>CLASSPATH</code>：<code v-pre>.;%JAVA_HOME%\lib\dt.jar;%JAVA_HOME%\lib\tools.jar;</code>——JDK5之后不需要配置了，jre会自动搜索当前路径下的jar包，并加载dt.jar和tools.jar，这是Oracle公司的改进设计。这个路径表示class文件的路径，即JVM去哪里寻找要运行的class文件。<img src="/images/javase/java-1/image-1660367350746.png" alt="image.png" loading="lazy"></li>
<li><code v-pre>Path</code>：<code v-pre>%JAVA_HOME%\bin;%JAVA_HOME%\jre\bin;</code><img src="/images/javase/java-1/image-1660367353788.png" alt="image.png" loading="lazy"></li>
</ul>
</li>
</ol>
<h4 id="_1-1-4-java命令基本使用" tabindex="-1"><a class="header-anchor" href="#_1-1-4-java命令基本使用" aria-hidden="true">#</a> 1.1.4 java命令基本使用</h4>
<ol>
<li>运行Java程序：
<ul>
<li><code v-pre>javac 文件名.java</code>编译代码，生成<code v-pre>文件名.class</code>字节码文件。</li>
<li><code v-pre>java 文件名</code>自动查找对应的<code v-pre>文件.class</code>文件并执行。</li>
<li><strong>java11后，</strong><code v-pre>**java 文件名.java**</code><strong>可以直接运行一个单文件源码，但多数情况下，无法直接这样操作，因为</strong><code v-pre>**文件名.java**</code><strong>文件需要依赖其他库。</strong></li>
</ul>
</li>
</ol>
<h3 id="_1-2-java程序基础" tabindex="-1"><a class="header-anchor" href="#_1-2-java程序基础" aria-hidden="true">#</a> 1.2 Java程序基础</h3>
<h4 id="_1-2-1-java程序基本结构" tabindex="-1"><a class="header-anchor" href="#_1-2-1-java程序基本结构" aria-hidden="true">#</a> 1.2.1 Java程序基本结构</h4>
<ol>
<li>
<p>Java编程的特点：</p>
<ul>
<li>Java源码的缩进不是必须的。</li>
<li>Java代码保存为文件时，文件名和main方法外部的类名要完全一致。</li>
<li>一个源文件最多只能有一个public类，其他类的个数不限。
<ul>
<li>也可以没有public类。</li>
<li>编译后每一个类都对应生成一个<code v-pre>.class</code>文件。</li>
<li>每个类都可以有main方法，且都可以被执行。
<ul>
<li><strong>被执行的前提是同文件内有一个public类。</strong></li>
<li><strong>执行方式是</strong><code v-pre>**java 类名**</code><strong>。</strong></li>
<li><strong>main方法必须按java程序规定的入口语法编写，即</strong><code v-pre>public static void main(String[] args)</code></li>
</ul>
</li>
</ul>
</li>
<li>类名必须以英文字母开头（习惯首字母大写），后接字母、数字、下划线的组合。</li>
<li><code v-pre>public static void main(String[] args)</code>规定的java程序入口
<ul>
<li>main方法名必须以英文字母开头（习惯首字母小写），后接字母、数字、下划线。</li>
</ul>
</li>
<li>Java的每一行语句必须以分号结束。</li>
</ul>
</li>
<li>
<p>java注释</p>
<ul>
<li>单行注释：<code v-pre>//</code></li>
<li>多行注释：</li>
</ul>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token comment">/*
xxxx
*/</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ul>
<li>
<p>多行注释不能嵌套多行注释。</p>
</li>
<li>
<p>文档注释：注释内容可以被JDK提供的javadoc所解析，生成一套以网页文件形式体现在该程序</p>
</li>
</ul>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token doc-comment comment">/** 
xxx
*/</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div></li>
</ol>
<ul>
<li><strong>拓展：javadoc命令。</strong></li>
</ul>
<ol>
<li>转义字符
<ul>
<li><code v-pre>\t</code>：一个制表符，实现对齐功能。</li>
<li><code v-pre>\n</code>：换行符</li>
<li><code v-pre>\\</code>：\</li>
<li><code v-pre>\r</code>：回车（光标移至本行前面）
<ul>
<li><code v-pre>霜冷长河\r寒冬</code>---------&gt;输出后<code v-pre>寒冬长河</code></li>
</ul>
</li>
</ul>
</li>
<li>Java代码规范：
<ul>
<li>类、方法的注释，要以javadoc的方式书写。</li>
<li>非javadoc的注释，写给代码维护者看，为什么这样写、如何修改、注意什么问题。</li>
<li>使用tab缩进。</li>
<li>运算符“+-*/=”两边各使用一个空格增加代码的可读性。</li>
<li>源文件使用UTF-8编码。</li>
<li>每行字符不要超过80字符。</li>
<li>代码编写行尾风格（起始大括号在同一行）或次行风格（起始大括号在下一行）</li>
</ul>
</li>
</ol>
<h4 id="_1-1-2-标识符规范" tabindex="-1"><a class="header-anchor" href="#_1-1-2-标识符规范" aria-hidden="true">#</a> 1.1.2 标识符规范</h4>
<ol>
<li>包名：多单词组成时全部写成小写。</li>
<li>文件名、类名、接口名：使用大驼峰形式。</li>
<li>变量名、方法名：小驼峰。</li>
<li>常量名：所有字母都大写，多个单词用下划线连接。</li>
</ol>
<h4 id="_1-1-3-键盘输入语句" tabindex="-1"><a class="header-anchor" href="#_1-1-3-键盘输入语句" aria-hidden="true">#</a> 1.1.3 键盘输入语句</h4>
<ol>
<li>
<p>使用步骤：</p>
<ul>
<li>导入<code v-pre>Scanner</code>所在的包：<code v-pre>import java.util.Scanner;</code></li>
<li>创建<code v-pre>Scanner</code>实例对象：<code v-pre>Scanner myScanner = new Scanner(System.in);</code></li>
<li>使用<code v-pre>myScanner</code>的实例对象方法：
<ul>
<li>接收字符串：<code v-pre>String str = myScanner.next();</code></li>
<li>接收整数：<code v-pre>int num = myScanner.nextInt();</code></li>
<li>接收浮点数：<code v-pre>double sth = myScanner.netDouble();</code></li>
<li>接收字符：<code v-pre>char charNum = myScanner.next().charAt(0);</code></li>
</ul>
</li>
</ul>
</li>
</ol>
<h2 id="第2章-基本语法" tabindex="-1"><a class="header-anchor" href="#第2章-基本语法" aria-hidden="true">#</a> 第2章 基本语法</h2>
<h3 id="_2-1-变量和数据类型" tabindex="-1"><a class="header-anchor" href="#_2-1-变量和数据类型" aria-hidden="true">#</a> 2.1 变量和数据类型</h3>
<h4 id="_2-1-1-变量" tabindex="-1"><a class="header-anchor" href="#_2-1-1-变量" aria-hidden="true">#</a> 2.1.1 变量</h4>
<ol>
<li>概念：相当于内存中一个数据存储空间的表示。
<ul>
<li>不同类型的变量，占用的内存空间大小不同。</li>
<li>该存储空间的值，可以在同种类型范围内不断变化。</li>
</ul>
</li>
<li>三个基本要素：类型、名称、值。
<ul>
<li><strong>java中变量的声明和初始化可以是两条语句，但使用前必须必须赋值进行初始化。</strong>
<ul>
<li><code v-pre>**int num; num = 10;**</code></li>
</ul>
</li>
</ul>
</li>
<li>注意点：
<ul>
<li>变量必须先声明，后使用。</li>
<li>同一作用域内，变量不能重名。</li>
<li><code v-pre>int a = b = c;</code>这种初始化方式会报错。</li>
<li><code v-pre>int a, b, c;</code>这种初始化方式不会报错。</li>
</ul>
</li>
<li>输出语句中<code v-pre>+</code>的含义：
<ul>
<li>左右两边都是数值时，做加法运算。</li>
<li>左右一边有字符串时，做拼接运算。</li>
</ul>
</li>
</ol>
<h4 id="_2-1-2-数据类型" tabindex="-1"><a class="header-anchor" href="#_2-1-2-数据类型" aria-hidden="true">#</a> 2.1.2 数据类型</h4>
<p><img src="/images/javase/java-1/yuque_mind.jpeg" alt="" loading="lazy"></p>
<ol>
<li>基本数据类型
<ul>
<li>
<p>整数型：</p>
<ul>
<li>整数型默认使用int大小的存储空间，使用long大小的存储空间时结尾加L。</li>
</ul>
<table>
<thead>
<tr>
<th>类型</th>
<th>占用存储空间</th>
<th>表示范围</th>
</tr>
</thead>
<tbody>
<tr>
<td>byte</td>
<td>1字节</td>
<td>-21<em>8-1~21</em>8-1-1</td>
</tr>
<tr>
<td>short</td>
<td>2字节</td>
<td>-22<em>8-1~22</em>8-1-1</td>
</tr>
<tr>
<td>int</td>
<td>4字节</td>
<td>-24<em>8-1~24</em>8-1-1</td>
</tr>
<tr>
<td>long</td>
<td>8字节</td>
<td>-28<em>8-1~28</em>8-1-1</td>
</tr>
</tbody>
</table>
</li>
<li>
<p>浮点类型：</p>
<ul>
<li>浮点类型都是近似值，因为存在小数位丢失的问题。</li>
<li>内存中的存放形式：浮点数=符号位+指数位+尾数位。</li>
<li>浮点型默认使用double大小的存储空间，使用float大小的存储空间时末尾加f或F。</li>
<li>浮点型除以整形存在精度问题，<strong>在编程中，应当注意对运算结果是小数的运算、判断！应该以两个数差值的绝对值在某个精度范围内判断。</strong></li>
</ul>
<table>
<thead>
<tr>
<th>类型</th>
<th>占用存储空间</th>
<th>表示范围</th>
</tr>
</thead>
<tbody>
<tr>
<td>float</td>
<td>4字节</td>
<td></td>
</tr>
<tr>
<td>double</td>
<td>8字节</td>
<td></td>
</tr>
</tbody>
</table>
</li>
<li>
<p>字符：</p>
<ul>
<li>字符型要用单引号，不能使用双引号。</li>
<li>字符型也可以直接赋值（整数），不需要用单引号，输出时显示对应的Unicode编码。</li>
<li>字符型本质上是一个整数，可以参与运算。</li>
<li>字符型还可以赋值为转义字符，需要单引号。</li>
<li>字符型也可以赋值为单个汉字，需要单引号。</li>
</ul>
</li>
<li>
<p>布尔类型：</p>
<ul>
<li>Java对布尔类型的存储占用空间大小没有做规定，理论上只需要1bit（0或者1），但由于计算机中最小存储单元为字节（Byte），所以占用应为1字节，同时又因为编译后虚拟机（JVM）中布尔类型的值会被转换为int类型的数据代替，所以会占用4个字节。</li>
<li>Java中不可以用0或者非0的整数代替 false或true，即Java中布尔类型的值只能为true或false。</li>
</ul>
</li>
</ul>
</li>
<li>自动类型转换：
<ul>
<li>Java中程序在进行赋值或运算时，精度小的类型会自动转换为精度大的类型。
<ul>
<li><code v-pre>char→int→long→float→double</code></li>
<li><code v-pre>byte、short→int→long→float→double</code></li>
</ul>
</li>
<li>几点规律：
<ul>
<li>多种类型的数据混合运算时，系统会将所有数据自动转换为容量最大的那种数据类型，然后再进行计算。</li>
<li>（byte、short）和char之间不会相互自动转换。</li>
<li>无法进行容量大的类型向容量小的类型自动转换，会报错。</li>
<li>byte、short、char在进行运算时，会自动转换为int，所以需要存储空间大于等于int的类型。
<ul>
<li>int=byte+byte（对），short=byte+byte（错），其他同理。</li>
</ul>
</li>
<li>布尔类型不参与自动类型转换。</li>
</ul>
</li>
</ul>
</li>
<li>强制类型转换
<ul>
<li>自动类型转换的逆过程。</li>
<li>转换过程中会造成精度降低或溢出。</li>
<li>char类型可以保存int的常量值（自动类型转换，int自动转char），但不能保存int的变量值。【原因：类型转换问题】</li>
</ul>
</li>
<li>基本数据类型和String类型的转换
<ul>
<li>基本数据类型---&gt;String类型：<code v-pre>基本数据类型 + &quot;&quot;</code></li>
<li>String类型---&gt;基本数据类型：
<ul>
<li><code v-pre>Byte.parseByte()</code></li>
<li><code v-pre>Short.parseShort()</code></li>
<li><code v-pre>Integer.parseInt()</code></li>
<li><code v-pre>Long.parseLong()</code></li>
<li><code v-pre>Float.parseFloat()</code></li>
<li><code v-pre>Double.parseDouble()</code></li>
<li><code v-pre>Boolean.parseBoolean()</code></li>
<li><code v-pre>char</code>类型没有上述的方法，<code v-pre>s.charAt(n)</code>可以获取字符串<code v-pre>s</code>指定位置的字符。</li>
<li>注意点：
<ul>
<li>String类型转换为基本类型时，必须先确保可以转换为对应的类型。如<code v-pre>123hello</code>不能转换为<code v-pre>int</code></li>
<li>如果格式不正确，会抛出异常，程序终止。</li>
</ul>
</li>
</ul>
</li>
</ul>
</li>
<li>变量的赋值：
<ul>
<li>如果变量是基本数据类型，此时赋值的是变量所保存的数据值。</li>
<li>如果变量是引用数据类型，此时赋值的是变量所保存的数据的地址值。</li>
</ul>
</li>
</ol>
<h3 id="_2-2-运算符" tabindex="-1"><a class="header-anchor" href="#_2-2-运算符" aria-hidden="true">#</a> 2.2 运算符</h3>
<p><img src="/images/javase/java-1/yuque_mind-1660367368284.jpeg" alt="" loading="lazy"></p>
<h4 id="_2-2-1-算术运算符" tabindex="-1"><a class="header-anchor" href="#_2-2-1-算术运算符" aria-hidden="true">#</a> 2.2.1 算术运算符</h4>
<ol>
<li><code v-pre>%</code>本质是<code v-pre>a % b = a - a / b *b</code>，所以<code v-pre>**10 % -3** = 10 - 10 / (-3) * (-3) = **1**</code></li>
<li><code v-pre>++</code>的经典面试题：
<ul>
<li><code v-pre>i = i++</code>：(1)temp=i，(2)i=i+1，(3)i=temp，结果为i</li>
<li><code v-pre>i = ++i</code>：(1)i=i+1，(2)temp=i，(3)i=temp，结果为i+1</li>
</ul>
</li>
<li>进行<code v-pre>b++</code>时不会进行强制类型转换，如：
<ul>
<li><code v-pre>byte b=127;b++</code>不会报错，输出-128。</li>
</ul>
</li>
<li><strong>注意：前减减/前加加的优先级高于=，后加加/后减减的优先级低于=</strong></li>
<li>整数运算在除数为0时会报错，而浮点数运算在除数为0时，不会报错，但会返回几个特殊值：
<ul>
<li>NaN表示Not a Number，<code v-pre>0.0 / 0</code></li>
<li>Infinity表示无穷大，<code v-pre>1.0 / 0</code></li>
<li>-Infinity表示负无穷大，<code v-pre>-1.0 / 0</code></li>
</ul>
</li>
</ol>
<h4 id="_2-2-2-关系运算符" tabindex="-1"><a class="header-anchor" href="#_2-2-2-关系运算符" aria-hidden="true">#</a> 2.2.2 关系运算符</h4>
<ol>
<li>关系运算符的结果都是boolean类型，要么是true，要么是false。</li>
<li><code v-pre>==</code>判断引用数据类型时，比较的是地址值。
<ul>
<li>左右两侧数据类型要一致，否则编译报错。</li>
</ul>
</li>
<li><code v-pre>==</code>判断基本数据类型时，比较的是具体值。
<ul>
<li>左右两侧不一定类型要相同，会进行自动数据类型提升
<ul>
<li>boolean除外，boolean与不是boolean的比较时会报错。</li>
</ul>
</li>
</ul>
</li>
<li>判断字符串时：
<ul>
<li>字符串以字面量形式声明：比较内容</li>
<li>字符串以new关键字声明：比较地址值</li>
<li>规范情况：须使用isequals（）方法</li>
</ul>
</li>
</ol>
<h4 id="_2-2-3-逻辑运算符" tabindex="-1"><a class="header-anchor" href="#_2-2-3-逻辑运算符" aria-hidden="true">#</a> 2.2.3 逻辑运算符</h4>
<ol>
<li>逻辑运算符的结果都是boolean类型，要么是true，要么是false。</li>
<li><code v-pre>&amp;&amp;</code>：第一个条件为false时，立即得出结果为false，效率高，<strong>而且后面部分不会被执行</strong>。</li>
<li><code v-pre>&amp;</code>：即使第一个条件为false，第二个条件的计算还会执行。
<ul>
<li><img src="/images/javase/java-1/image-1660367375513.png" alt="image.png" loading="lazy"></li>
</ul>
</li>
<li><code v-pre>||</code>：第一个条件为true时，立即得出结果为true，效率高，<strong>而且后面部分不会被执行</strong>。</li>
<li><code v-pre>|</code>：即使第一个条件为true，第二个条件的计算还会执行。</li>
<li>开发中常用<code v-pre>&amp;&amp;</code>和<code v-pre>||</code>。</li>
</ol>
<h4 id="_2-2-4-赋值运算符" tabindex="-1"><a class="header-anchor" href="#_2-2-4-赋值运算符" aria-hidden="true">#</a> 2.2.4 赋值运算符</h4>
<ol>
<li>赋值运算符左边只能是变量，右边可以是变量、表达式、常量值。</li>
<li><strong>复合运算符会进行强制类型转换。</strong></li>
</ol>
<h4 id="_2-2-5-三元运算符" tabindex="-1"><a class="header-anchor" href="#_2-2-5-三元运算符" aria-hidden="true">#</a> 2.2.5 三元运算符</h4>
<ol>
<li>本质实际上是if-else语句。
<ul>
<li><code v-pre>条件表达式1 ？ 表达式1 : 表达式2</code>
<ul>
<li>表达式1和表达式2要求类型一致，所以会自动类型提升。</li>
</ul>
</li>
</ul>
</li>
</ol>
<h4 id="_2-2-6-位运算符" tabindex="-1"><a class="header-anchor" href="#_2-2-6-位运算符" aria-hidden="true">#</a> 2.2.6 位运算符</h4>
<ol>
<li>原码、反码、补码：
<ul>
<li>二进制数的最高位为符号位，0表示正数，1表示负数。</li>
<li>正数的原码、反码、补码都一样。</li>
<li>负数的反码 = 原码符号位不变，其他位的数取反。</li>
<li>负数的补码 = 反码 + 1，负数的反码 = 补码 - 1。</li>
<li>0的反码，补码都是0。</li>
<li>java没有无符号数  ，即java中的数都是有符号的。
<ul>
<li>0在java中表示正数。</li>
</ul>
</li>
<li>计算机运算的时候，都是以补码进行运算。</li>
<li>使用运算结果的时候，需要看它的原码。</li>
</ul>
</li>
<li>算数右移<code v-pre>&gt;&gt;</code>：符号位不变，低位溢出，高位补0。
<ul>
<li><code v-pre>m &gt;&gt; n</code>本质是<code v-pre>m / 2^n</code></li>
<li><strong>注意：负数跨越0时输出均为-1。</strong></li>
<li><strong>负数的算数右移？</strong></li>
</ul>
</li>
<li>算术左移<code v-pre>&lt;&lt;</code>：符号位不变，高位溢出，低位补0。
<ul>
<li><code v-pre>m &lt;&lt; n</code>本质是<code v-pre>m * 2^n</code></li>
</ul>
</li>
<li>逻辑右移或无符号右移<code v-pre>&gt;&gt;&gt;</code>：低位溢出，高位补0（符号位也跟着移动）。</li>
<li>没有<code v-pre>&lt;&lt;&lt;</code>。</li>
</ol>
<h4 id="_2-2-7-运算符优先级" tabindex="-1"><a class="header-anchor" href="#_2-2-7-运算符优先级" aria-hidden="true">#</a> 2.2.7 运算符优先级</h4>
<ul>
<li><img src="/images/javase/java-1/image-1660367379235.png" alt="image.png" loading="lazy"></li>
<li><code v-pre>++</code>优先级的问题：
<ul>
<li>算术运算（赋值）：</li>
<li>逻辑运算：</li>
<li>三元运算：</li>
</ul>
</li>
</ul>
<h3 id="_2-3-流程控制" tabindex="-1"><a class="header-anchor" href="#_2-3-流程控制" aria-hidden="true">#</a> 2.3 流程控制</h3>
<p><img src="/images/javase/java-1/yuque_mind-1660367382325.jpeg" alt="" loading="lazy"></p>
<h4 id="_2-3-1-顺序控制" tabindex="-1"><a class="header-anchor" href="#_2-3-1-顺序控制" aria-hidden="true">#</a> 2.3.1 顺序控制</h4>
<ol>
<li>java程序默认的执行流程，从上到下逐行执行，所以 变量必须先声明后使用。</li>
</ol>
<h4 id="_2-3-2-分支控制" tabindex="-1"><a class="header-anchor" href="#_2-3-2-分支控制" aria-hidden="true">#</a> 2.3.2 分支控制</h4>
<ol>
<li>
<p>单分支【if】：</p>
<ul>
<li>即使执行的代码块语句只有一条，也建议加上<code v-pre>{}</code></li>
<li>当只有一条语句时，可以不用<code v-pre>{}</code>直接换行写，也可以不用换行，与<code v-pre>if</code>写在同一行。</li>
</ul>
</li>
<li>
<p>双分支【if……else】：</p>
</li>
<li>
<p>多分支【if……else if……else】：</p>
<ul>
<li>
<p>多分支可以没有最后的else。</p>
</li>
<li>
<p>多分支只有一个执行入口，即从这个入口执行了语句，其余入口的语句不会被执行 。<strong>【先入为主】</strong></p>
<ul>
<li><strong>如下述的伪代码，最高分为80时，考了90分的只会从第一个入口进，输出A，而不会再去判断后面的B、C、D</strong></li>
</ul>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token keyword">if</span><span class="token punctuation">(</span>成绩成绩<span class="token operator">>=</span>最高分<span class="token operator">-</span><span class="token number">10</span><span class="token punctuation">)</span><span class="token punctuation">{</span>
   等级为<span class="token class-name">A</span> 
<span class="token punctuation">}</span><span class="token keyword">else</span> <span class="token keyword">if</span><span class="token punctuation">(</span>成绩<span class="token operator">>=</span>最高分<span class="token operator">-</span><span class="token number">20</span><span class="token punctuation">)</span><span class="token punctuation">{</span>
   等级为<span class="token class-name">B</span>
<span class="token punctuation">}</span><span class="token keyword">else</span> <span class="token keyword">if</span><span class="token punctuation">(</span>成绩<span class="token operator">>=</span>最高分<span class="token operator">-</span><span class="token number">30</span><span class="token punctuation">)</span><span class="token punctuation">{</span>
   等级为<span class="token class-name">C</span>
<span class="token punctuation">}</span><span class="token keyword">else</span><span class="token punctuation">{</span>
   等级为<span class="token class-name">D</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div></li>
</ul>
</li>
<li>
<p>嵌套分支：</p>
<ul>
<li>一个分支结构中嵌套了另一个完整的分支结构。</li>
</ul>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token keyword">if</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">{</span>
<span class="token keyword">if</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">{</span>
   <span class="token keyword">else</span> <span class="token keyword">if</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">{</span>
      xxx<span class="token punctuation">;</span>
      <span class="token punctuation">}</span><span class="token keyword">else</span><span class="token punctuation">{</span>
      xxx<span class="token punctuation">;</span>
      <span class="token punctuation">}</span>
   <span class="token punctuation">}</span><span class="token keyword">else</span><span class="token punctuation">{</span>
   xxx<span class="token punctuation">;</span>
   <span class="token punctuation">}</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ul>
<li>为了保证可读性，不要超过三层。</li>
</ul>
</li>
<li>
<p>switch分支：</p>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token keyword">switch</span><span class="token punctuation">(</span>表达式<span class="token punctuation">)</span><span class="token punctuation">{</span>
   <span class="token keyword">case</span> 常量<span class="token number">1</span><span class="token operator">:</span>
      语句<span class="token number">1</span><span class="token punctuation">;</span>
      <span class="token keyword">break</span><span class="token punctuation">;</span>
      ……
   <span class="token keyword">case</span> 常量n<span class="token operator">:</span>
      语句n<span class="token punctuation">;</span>
      <span class="token keyword">break</span><span class="token punctuation">;</span> 
   <span class="token keyword">default</span><span class="token operator">:</span>
      <span class="token keyword">default</span>语句块<span class="token punctuation">;</span>
      <span class="token keyword">break</span>；
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ul>
<li>穿透：如果case语句没有break语句，程序会继续执行下一个case的语句，而不会进行case判断。</li>
<li><img src="/images/javase/java-1/image-1660367386923.png" alt="image.png" loading="lazy"></li>
<li>switch表达式的数据类型，应和case后面的常量类型一致，或者表达式的数据类型可以自动转换为常量类型。</li>
<li>switch表达式的返回值必须是byte、short、int、char、enum【枚举】、String。</li>
<li>case语句的值必须是常量或常量表达式，不能是变量或带变量的表达式。</li>
</ul>
</li>
<li>
<p>switch和if的选择：</p>
<ul>
<li>运算的结果数值不多，且是byte、short、int、char、enmu、String的某种类型，建议使用swtich。</li>
<li>对于区间判断、结果为boolean的判断，建议使用if。</li>
</ul>
</li>
</ol>
<h4 id="_2-3-3-循环控制" tabindex="-1"><a class="header-anchor" href="#_2-3-3-循环控制" aria-hidden="true">#</a> 2.3.3 循环控制</h4>
<ol>
<li>
<p>for循环：</p>
<ul>
<li>基本语法：</li>
</ul>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token keyword">for</span><span class="token punctuation">(</span>循环变量初始化<span class="token punctuation">;</span>循环条件<span class="token punctuation">;</span>循环变量迭代<span class="token punctuation">)</span><span class="token punctuation">{</span>
   循环操作<span class="token punctuation">;</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ul>
<li>四要素：循环变量初始化、循环条件、循环操作、循环变量迭代。
<ul>
<li>循环初始值可以有多条初始化语句，但要求类型一样，并用逗号隔开<code v-pre>int i = 0, j = 0</code></li>
<li>循环变量迭代可以有多条变量迭代语句，中间用逗号隔开<code v-pre>i++, j++</code></li>
</ul>
</li>
<li>如果循环操作只有一条语句，可以省略<code v-pre>{}</code>，建议不要省略。</li>
<li><code v-pre>for(;循环条件;)</code>
<ul>
<li>循环变量初始化和循环变量迭代可以写到其他地方，但是<code v-pre>;</code>不能省略。</li>
<li>循环变量初始化写到其他地方时，作用域再循环体外。否则只能作用域循环体内。</li>
</ul>
</li>
<li><code v-pre>for(;;)</code>：表示无限循环。</li>
</ul>
</li>
<li>
<p>while循环：</p>
<ul>
<li>基本语法：</li>
</ul>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code>循环变量初始化<span class="token punctuation">;</span>
<span class="token keyword">while</span><span class="token punctuation">(</span>循环条件<span class="token punctuation">)</span><span class="token punctuation">{</span>
循环体<span class="token punctuation">;</span>
循环变量迭代<span class="token punctuation">;</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ul>
<li>四要素：同for循环。</li>
</ul>
</li>
<li>
<p>do…while循环</p>
<ul>
<li>基本语法</li>
</ul>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code>循环变量初始化<span class="token punctuation">;</span>
<span class="token keyword">do</span><span class="token punctuation">{</span>
   循环体<span class="token punctuation">;</span>
   循环变量迭代<span class="token punctuation">;</span>
<span class="token punctuation">}</span><span class="token keyword">while</span><span class="token punctuation">(</span>循环条件<span class="token punctuation">)</span><span class="token punctuation">;</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ul>
<li>四要素：同for循环。</li>
<li>注意while后面的<code v-pre>;</code>。</li>
</ul>
</li>
<li>
<p>增强for循环</p>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token keyword">for</span><span class="token punctuation">(</span><span class="token keyword">int</span> i <span class="token operator">:</span> nums<span class="token punctuation">)</span> <span class="token punctuation">{</span>
   <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span><span class="token string">"i="</span> <span class="token operator">+</span> i<span class="token punctuation">)</span><span class="token punctuation">;</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ul>
<li>依次从nums数组、枚举类等中取出数据，赋给i</li>
</ul>
</li>
</ol>
<h4 id="_2-3-4-多重循环控制" tabindex="-1"><a class="header-anchor" href="#_2-3-4-多重循环控制" aria-hidden="true">#</a> 2.3.4 多重循环控制</h4>
<ol>
<li>
<p>建议循环嵌套不要超过2层，否则可读性非常差。</p>
</li>
<li>
<p>外层循环m次，内层循环n次，则内层循环体实际上需要执行m*n次。</p>
</li>
<li>
<p>break：结束<strong>当前循环。</strong></p>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code>label1<span class="token operator">:</span>
<span class="token keyword">for</span><span class="token punctuation">(</span><span class="token punctuation">.</span><span class="token punctuation">.</span><span class="token punctuation">.</span><span class="token punctuation">)</span><span class="token punctuation">{</span>
   label2<span class="token operator">:</span> 
   <span class="token keyword">for</span><span class="token punctuation">(</span><span class="token punctuation">.</span><span class="token punctuation">.</span><span class="token punctuation">.</span><span class="token punctuation">)</span><span class="token punctuation">{</span>
      label3<span class="token operator">:</span>
      <span class="token keyword">for</span><span class="token punctuation">(</span><span class="token punctuation">.</span><span class="token punctuation">.</span><span class="token punctuation">.</span><span class="token punctuation">)</span><span class="token punctuation">{</span>
            <span class="token keyword">break</span> label1<span class="token punctuation">;</span>
         <span class="token punctuation">}</span>
   <span class="token punctuation">}</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ul>
<li>break配合label标签可以指定跳出哪层循环。</li>
<li>label是标签名，由程序员指定，实际开发中，尽量不要使用标签。</li>
<li>如果break后没有指定的label标签名，则表示跳出最近的循环体.</li>
</ul>
</li>
<li>
<p>continue：结束<strong>当次循环</strong></p>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code>label1<span class="token operator">:</span>
<span class="token keyword">for</span><span class="token punctuation">(</span><span class="token punctuation">.</span><span class="token punctuation">.</span><span class="token punctuation">.</span><span class="token punctuation">)</span><span class="token punctuation">{</span>
   label2<span class="token operator">:</span> 
   <span class="token keyword">for</span><span class="token punctuation">(</span><span class="token punctuation">.</span><span class="token punctuation">.</span><span class="token punctuation">.</span><span class="token punctuation">)</span><span class="token punctuation">{</span>
      label3<span class="token operator">:</span>
      <span class="token keyword">for</span><span class="token punctuation">(</span><span class="token punctuation">.</span><span class="token punctuation">.</span><span class="token punctuation">.</span><span class="token punctuation">)</span><span class="token punctuation">{</span>
            <span class="token keyword">continue</span> label1<span class="token punctuation">;</span>
         <span class="token punctuation">}</span>
   <span class="token punctuation">}</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ul>
<li>continue配合label标签可以指定跳出哪层循环。</li>
<li>label是标签名，由程序员指定，实际开发中，尽量不要使用标签。</li>
<li>如果contineu后没有指定的label标签名，则表示跳出最近的循环体。</li>
<li>continue不能用于switch-case语句中</li>
</ul>
</li>
<li>
<p>return:</p>
<ul>
<li>return用在方法内时，表示跳出方法，用在main方法中表示退出程序。本质上不是退出循环。</li>
</ul>
</li>
</ol>
<h2 id="第3章-数组和数组操作" tabindex="-1"><a class="header-anchor" href="#第3章-数组和数组操作" aria-hidden="true">#</a> 第3章 数组和数组操作</h2>
<h3 id="_3-1-数组介绍" tabindex="-1"><a class="header-anchor" href="#_3-1-数组介绍" aria-hidden="true">#</a> 3.1 数组介绍</h3>
<h4 id="_3-1-1-一维数组" tabindex="-1"><a class="header-anchor" href="#_3-1-1-一维数组" aria-hidden="true">#</a> 3.1.1 一维数组</h4>
<ol>
<li>定义：存放同一类型数据的组合。是一种引用数据类型。</li>
<li>动态初始化——方式一：
<ul>
<li>声明、创建、定义：
<ul>
<li><code v-pre>数据类型 数组名[] = new 数据类型[大小]</code></li>
<li><code v-pre>数据类型[] 数组名 = new 数据类型[大小]</code></li>
</ul>
</li>
<li>初始化：<code v-pre>a[0] = 1;……</code></li>
</ul>
</li>
<li>动态初始化——方式二：
<ul>
<li>声明数组：
<ul>
<li><code v-pre>数据类型 数组名[];</code></li>
<li><code v-pre>数据类型[] 数组名;</code></li>
<li>声明数组时，[]内不能写数组大小。</li>
</ul>
</li>
<li>创建数组（分配空间）：<code v-pre>数组名 = new 数据类型[大小];</code></li>
<li>初始化：<code v-pre>a[0] = 1;……</code></li>
</ul>
</li>
<li>静态初始化——方式一：
<ul>
<li><code v-pre>数据类型 数组名[] = {值1, 值2,……}</code></li>
<li><code v-pre>数据类型[] 数组名 = {值1, 值2,……}</code></li>
<li>静态初始化时，[]内不能写数组大小。</li>
</ul>
</li>
<li>静态初始化——方式二：
<ul>
<li><code v-pre>数据类型 数组名[] = new 数据类型[]{值1, 值2,……}</code></li>
<li><code v-pre>数据类型[] 数组名 = new 数据类型[]{值1, 值2,……}</code></li>
<li>静态初始化时，[]内不能写数组大小。</li>
</ul>
</li>
<li>注意事项：
<ul>
<li>数组创建后，如果没有进行初始化，默认初始值如下：
<ul>
<li>byte、short、int、long：0</li>
<li>float、double：0.0</li>
<li>char：\u0000（空字符）</li>
<li>boolean：false</li>
<li>String：null</li>
</ul>
</li>
<li>数组是引用类型，是对象类型的一种。</li>
<li>数组定义后不能直接改变大小（容量），但可以通过以下两种方式改变大小
<ul>
<li>数组的拷贝：将一个大容量的数组赋值给小容量的数组</li>
<li>通过new关键字重新确定容量大小。</li>
<li><s>动态初始化情况下改变传入变量的大小控制数组的大小。</s></li>
</ul>
</li>
</ul>
</li>
</ol>
<h4 id="_3-1-2-二维数组" tabindex="-1"><a class="header-anchor" href="#_3-1-2-二维数组" aria-hidden="true">#</a> 3.1.2 二维数组</h4>
<ol>
<li>动态初始化——方式一：
<ul>
<li>声明、创建、定义：
<ul>
<li><code v-pre>数据类型 数组名[][] = new 数据类型[大小][大小]</code></li>
<li><code v-pre>数据类型[][] 数组名 = new 数据类型[大小][大小]</code></li>
<li><code v-pre>数据类型[] 数组名[] = new 数据类型[大小][大小]</code></li>
</ul>
</li>
<li>初始化：
<ul>
<li><code v-pre>a[0][0] = 1;……</code></li>
<li>或者<code v-pre>a[0] = {1,3……}</code></li>
</ul>
</li>
<li>未初始化的默认值：
<ul>
<li><code v-pre>a[0]</code>：指向内存地址。</li>
<li><code v-pre>a[0][0]</code>：输出该数组对应数据类型的默认值。</li>
</ul>
</li>
</ul>
</li>
<li>动态初始化——方式二：
<ul>
<li>声明数组：
<ul>
<li><code v-pre>数据类型 数组名[][];</code></li>
<li><code v-pre>数据类型[][] 数组名;</code></li>
<li><code v-pre>数据类型[] 数组名[];</code></li>
</ul>
</li>
<li>创建数组（分配空间）：<code v-pre>数组名 = new 数据类型[大小][大小];</code></li>
<li>初始化：
<ul>
<li><code v-pre>a[0][0] = 1;……</code></li>
<li>或者<code v-pre>a[0] = {1,3……}</code></li>
</ul>
</li>
<li>未初始化的默认值：
<ul>
<li><code v-pre>a[0]</code>：指向内存地址。</li>
<li><code v-pre>a[0][0]</code>：输出该数组对应数据类型的默认值。</li>
</ul>
</li>
</ul>
</li>
<li>动态初始化——列数不确定：
<ul>
<li>声明数组：
<ul>
<li><code v-pre>数据类型 数组名[][] = new 数据类型[大小][]</code></li>
<li><code v-pre>数据类型[][] 数组名 = new 数据类型[大小][]</code></li>
<li><code v-pre>数据类型[] 数组名[] = new 数据类型[大小][]</code></li>
<li><code v-pre>数据类型 数组名[][];数组名 = new 数据类型[大小][];</code></li>
<li><code v-pre>数据类型[][] 数组名;数组名 = new 数据类型[大小][];</code></li>
<li><code v-pre>数据类型[] 数组名[];数组名 = new 数据类型[大小][];</code></li>
</ul>
</li>
<li>初始化：
<ul>
<li><code v-pre>a[0] = new int[1];……</code></li>
<li>或者<code v-pre>a[0] = {1,3……}</code></li>
</ul>
</li>
<li>注意点：
<ul>
<li><code v-pre>数据类型 数组名[][] = new 数据类型[a][]</code>声明了具有a个一维数组的二维数组，但一维数组内部的元素个数还不确定。</li>
<li><code v-pre>数据类型 数组名[][] = new 数据类型[][a]</code>这种声明方式非法。</li>
</ul>
</li>
<li>未初始化的默认值：
<ul>
<li><code v-pre>a[0] = new int[3];a[0]</code>：指向内存地址。</li>
<li><code v-pre>没有a[0] = new int[3];直接a[0]</code>：null。</li>
<li><code v-pre>a[0] = new int[3];a[0][0]</code>：输出该数组对应数据类型的默认值，本例为0。</li>
<li><code v-pre>没有a[0] = new int[3];直接a[0]</code>：报错。</li>
</ul>
</li>
</ul>
</li>
<li>静态初始化——方式一：
<ul>
<li><code v-pre>数据类型 数组名[][] = {{值1, 值2,……},{值1, 值2,……},{值1, 值2,……}}</code></li>
<li><code v-pre>数据类型[][] 数组名 = {{值1, 值2,……},{值1, 值2,……},{值1, 值2,……}}</code></li>
<li><code v-pre>数据类型[] 数组名[] = {{值1, 值2,……},{值1, 值2,……},{值1, 值2,……}}</code></li>
<li>静态初始化时，[]内不能写数组大小。</li>
</ul>
</li>
<li>静态初始化——方式二：
<ul>
<li><code v-pre>数据类型 数组名[][] = new int[][]{{值1, 值2,……},{值1, 值2,……},{值1, 值2,……}}</code></li>
<li><code v-pre>数据类型[][] 数组名 = new int[][]{{值1, 值2,……},{值1, 值2,……},{值1, 值2,……}}</code></li>
<li><code v-pre>数据类型[] 数组名[] = new int[][]{{值1, 值2,……},{值1, 值2,……},{值1, 值2,……}}</code></li>
<li>静态初始化时，[]内不能写数组大小。</li>
</ul>
</li>
<li>特殊写法情况：int[] x,y[]; x是一维数组，y是二维数组。</li>
</ol>
<h3 id="_3-2-数组操作" tabindex="-1"><a class="header-anchor" href="#_3-2-数组操作" aria-hidden="true">#</a> 3.2 数组操作</h3>
<h4 id="_3-2-1-基本操作" tabindex="-1"><a class="header-anchor" href="#_3-2-1-基本操作" aria-hidden="true">#</a> 3.2.1 基本操作</h4>
<ol>
<li>拷贝数组：
<ul>
<li>基本数据类型：<code v-pre>b=0;a=b;</code>，两个数值互不影响，拷贝的是数据。</li>
<li>引用数据类型：<code v-pre>int[] arr1 = {1,2……};arr2 = arr1;</code>
<ul>
<li>默认情况下：拷贝的是内存中的地址，arr1和arr2不论哪个的值变化，都会引起另外一个的变化。</li>
<li>值拷贝方式：给arr1和arr2分别开辟独立的内存空间。<code v-pre>int[] arr1 = {1,2……};int[] arr2 = new int[arr1.length];</code></li>
</ul>
</li>
</ul>
</li>
<li>反转数组：
<ul>
<li>交换数据法：</li>
<li>逆序赋值法：</li>
</ul>
</li>
<li>数组扩容：
<ul>
<li>创建新数组，新数组添加元素，将新数组赋值给旧数组。</li>
</ul>
</li>
<li>数组缩减：</li>
</ol>
<p>创建新数组，新数组长度比旧数组少1，循环赋值。</p>
<ol start="5">
<li>数组排序：
<ul>
<li>内部排序：将所有数据加载到内存中进行排序。
<ul>
<li>冒泡排序：</li>
</ul>
</li>
<li>外部排序：数据量过大，无法全部加载到内存中，借助外部的存储空间进行排序。</li>
</ul>
</li>
<li>数组查找：
<ul>
<li>顺序查找：</li>
<li>二分查找：</li>
</ul>
</li>
</ol>
<h4 id="_3-2-2-arrays工具类-常用" tabindex="-1"><a class="header-anchor" href="#_3-2-2-arrays工具类-常用" aria-hidden="true">#</a> 3.2.2 Arrays工具类（常用）</h4>
<ol>
<li><code v-pre>Arrays.equals(int[] a, int[] b)</code>：
<ul>
<li>返回<code v-pre>boolean</code>，<code v-pre>boolean isEquals = Arrays.equals(a, b);</code></li>
<li>返回true的条件：两数组指向同一个内存地址（a=b）、a和b内部的元素值相等</li>
<li>返回false的条件：两数组均为null、a和b内部的元素值不想等</li>
<li>除int外，其余各种类型的对象都可判断</li>
</ul>
</li>
<li><code v-pre>Arrays.toString(int[] a)</code>：
<ul>
<li>返回<code v-pre>String</code>，<code v-pre>String aStr = Arrays.toString(a);</code></li>
<li>输出为<code v-pre>[值1,,……]</code>的形式，实际为字符串的拼接</li>
</ul>
</li>
<li><code v-pre>Arrays.fill(int[] a,10)</code>
<ul>
<li>返回为空，所以不能赋值给其他语句。</li>
<li>表示将数组a的所有元素替换为10。</li>
</ul>
</li>
<li><code v-pre>Arrays.sort(int[] a)</code>
<ul>
<li>返回为空，所以不能赋值给其他语句。</li>
<li>表示将数组a按照从小到大的顺序排序，底层排序方式为快速排序。</li>
</ul>
</li>
<li><code v-pre>Arrays.binarySearch(int[] a, 10)</code>：
<ul>
<li>返回<code v-pre>int</code>，<code v-pre>int index = Arrays.binarySearch(a, 10);</code></li>
<li>返回值为正数时，为目标数据（10）所在的元素下标。返回值为负数时，表示没找到。</li>
<li>底层排序方式为二分法查找。</li>
</ul>
</li>
<li>使用上述方法需要引入对应的工具类：<code v-pre>import java.util.Arrays;</code></li>
</ol>
<h4 id="_1-4-5-数组常见异常" tabindex="-1"><a class="header-anchor" href="#_1-4-5-数组常见异常" aria-hidden="true">#</a> 1.4.5 数组常见异常</h4>
<ol>
<li>编译时不报错，运行出错。</li>
<li><code v-pre>ArrayIndexOutOfBoundsExcetion</code>：</li>
</ol>
<ul>
<li>角标越界：
<ul>
<li>角标为负数</li>
<li>角标为数组长度（应为数组长度-1）</li>
</ul>
</li>
</ul>
<ol start="3">
<li><code v-pre>NullPointerException</code>：</li>
</ol>
<ul>
<li>数组指向null
<ul>
<li>数组只声明、未初始化</li>
<li>数组赋值为null</li>
</ul>
</li>
<li>不定列二维数组某个一维数组未初始化，访问了该一维数组的具体值。</li>
<li>一维字符串数组的某个值赋值为空。</li>
</ul>
<h4 id="_3-2-4-数组输出问题" tabindex="-1"><a class="header-anchor" href="#_3-2-4-数组输出问题" aria-hidden="true">#</a> 3.2.4 数组输出问题</h4>
<ol>
<li>详见（详见Java问答，1.4.14）.</li>
<li>一维数组：</li>
</ol>
<ul>
<li>声明未创建（没有指定数组大小）：编译报错</li>
<li>声明并初始化（指定数组大小）：输出数组显示内存地址、输出元素显示默认值或指定值</li>
</ul>
<ol start="3">
<li>二维数组：</li>
</ol>
<ul>
<li>声明未创建（没有指定数组大小）：编译报错</li>
<li>声明并初始化（指定数组大小）：
<ul>
<li>指定两个大小：输出数组显示内存地址、输出一维元素显示内存地址或一维数组、输出二维元素为默认值或指定值</li>
<li>指定一个大小：输出数组显示内存地址、输出一位元素显式为空、输出二维元素编译不报错，运行报错</li>
</ul>
</li>
</ul>
<h2 id="第4章-面向对象" tabindex="-1"><a class="header-anchor" href="#第4章-面向对象" aria-hidden="true">#</a> 第4章 面向对象</h2>
<h3 id="_4-0-面向对象的学习内容" tabindex="-1"><a class="header-anchor" href="#_4-0-面向对象的学习内容" aria-hidden="true">#</a> 4.0 面向对象的学习内容</h3>
<p><img src="/images/javase/java-1/yuque_mind-1660367396423.jpeg" alt="" loading="lazy"></p>
<h3 id="_4-1-类和对象" tabindex="-1"><a class="header-anchor" href="#_4-1-类和对象" aria-hidden="true">#</a> 4.1  类和对象</h3>
<ol>
<li>类和对象是面向对象的核心概念。
<ul>
<li>类是对一类事物的描述，是抽象、概念上的定义。</li>
<li>对象是实际存在的该类事物的每个个体，因而也被称为实例。</li>
</ul>
</li>
<li>类和对象的书面理解：
<ul>
<li>Java语言范畴中，将功能、结构等封装到类中，通过类的实例化，来调用具体的功能、结构。
<ul>
<li>Scanner、String等</li>
<li>文件：File</li>
<li>网络资源：URL</li>
</ul>
</li>
<li>涉及到Java语言与HTML、后端数据库交互时，前后端的结构在java层面交互时，都体现为类、对象。</li>
</ul>
</li>
</ol>
<h4 id="_4-1-1-类" tabindex="-1"><a class="header-anchor" href="#_4-1-1-类" aria-hidden="true">#</a> 4.1.1 类</h4>
<ol>
<li>
<p>类的语法格式：</p>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code>修饰符 <span class="token keyword">class</span> 类名<span class="token punctuation">{</span>
   属性声明<span class="token punctuation">;</span>
   方法声明<span class="token punctuation">;</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token keyword">public</span> <span class="token keyword">class</span> <span class="token class-name">Person</span><span class="token punctuation">{</span>
   <span class="token keyword">private</span> <span class="token keyword">int</span> age <span class="token punctuation">;</span> <span class="token comment">//声明私有变量 age</span>
   <span class="token keyword">public</span> <span class="token keyword">void</span> <span class="token function">showAge</span><span class="token punctuation">(</span><span class="token keyword">int</span> i<span class="token punctuation">)</span> <span class="token punctuation">{</span> <span class="token comment">//声明方法showAge( )</span>
      age <span class="token operator">=</span> i<span class="token punctuation">;</span> 
   <span class="token punctuation">}</span> 
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div></li>
<li>
<p>类的成员：</p>
<ul>
<li>属性：对应类中的成员变量
<ul>
<li>Field = 属性 = 成员变量</li>
</ul>
</li>
<li>行为：对应类中的成员方法
<ul>
<li>Method = 方法 = 函数</li>
</ul>
</li>
</ul>
</li>
<li>
<p>类权限修饰符只能缺省或public</p>
</li>
</ol>
<h4 id="_4-1-2-类的成员——属性" tabindex="-1"><a class="header-anchor" href="#_4-1-2-类的成员——属性" aria-hidden="true">#</a> 4.1.2 类的成员——属性</h4>
<ol>
<li>属性的定义（声明）：语法同变量：<code v-pre>访问修饰符 属性类型 属性名;</code></li>
<li>细节和注意事项：
<ul>
<li>访问修饰符：public、proctected、默认、private。</li>
<li>属性的类型：可以是任意类型，包括基本数据类型和引用数据类型。</li>
<li>属性的默认值：属性不赋值时，有默认值，规则同数组
<ul>
<li>byte、byte、short、int、long：0</li>
<li>float、double：0.0</li>
<li>char：\u0000（空字符）</li>
<li>boolean：false</li>
<li>String：null</li>
</ul>
</li>
</ul>
</li>
<li>属性赋值：遵循变量赋值的规定，即：
<ul>
<li>如果变量是基本数据类型，此时赋值的是变量所保存的数据值。</li>
<li>如果变量是引用数据类型，此时赋值的是变量所保存的数据的地址值。</li>
</ul>
</li>
</ol>
<h4 id="_4-1-3-类的成员——方法" tabindex="-1"><a class="header-anchor" href="#_4-1-3-类的成员——方法" aria-hidden="true">#</a> 4.1.3 类的成员——方法</h4>
<ol>
<li>
<p>方法的定义：</p>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code>访问修饰符 返回数据类型 方法名<span class="token punctuation">(</span>形参列表……<span class="token punctuation">)</span><span class="token punctuation">{</span>
   语句<span class="token punctuation">;</span>
   <span class="token keyword">return</span> 返回值<span class="token punctuation">;</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div></li>
</ol>
<ul>
<li>形参列表：表示成员方法的输入</li>
<li>返回数据类型：表示成员变量的输出类型。void表示没有返回值。</li>
<li><code v-pre>{}</code>：表示方法体，实现某一功能的代码块</li>
<li>return语句：不是必须的。
<ul>
<li>无返回值类型的方法也可以用return，用于结束方法。</li>
</ul>
</li>
</ul>
<ol start="2">
<li>细节和注意事项
<ul>
<li>访问修饰符：
<ul>
<li>public、proctected、默认、private</li>
<li>控制方法的使用范围。</li>
</ul>
</li>
<li>返回数据类型：
<ul>
<li>一个方法只能有一个返回值。返回多个值可以使用数组接收。</li>
<li>返回类型可以是任意类型包含基本类型或引用类型（数组、对象）</li>
<li>如果要求有返回值，则必须有return语句，且return语句的数据类型与方法的返回数据类型一致或兼容。</li>
<li>如果方法时void，则方法体中可以没有return语句，或者只写return。</li>
</ul>
</li>
<li>方法名：
<ul>
<li>见名知义</li>
<li>小驼峰命名方法，遵循标识符的规则、规范</li>
</ul>
</li>
<li>形参列表：
<ul>
<li>一个方法可以有0个参数，也可以有多个参数，多个参数用逗号分开。</li>
<li>参数类型可以是任意类型，包括基本类型和引用类型。</li>
<li>调用带参数的方法时，必须传入对应类型或兼容类型的实参。</li>
<li>调用方法时，实参和形参的数量、类型、顺序必须一致。</li>
</ul>
</li>
<li>方法体：
<ul>
<li>方法体的语句可以为输入、输出、变量、运算、分支、循环、方法调用，但是不能嵌套定义——方法中不能再声明方法。</li>
</ul>
</li>
</ul>
</li>
<li>方法调用的细节
<ul>
<li>同一个类中的方法A（非main方法）中调用方法B时，可以直接调用<code v-pre>方法名()</code>
<ul>
<li>main方法需要调用同一个类中的方法B时，需要通过实例化类，<code v-pre>对象名.B方法名()</code>调用</li>
</ul>
</li>
<li>跨类中的方法A调用方法B时，需要通过对象名（实例化对象）调用<code v-pre>类名 对象名 = new 类名();对象名.方法名()</code></li>
<li>跨类调用的方法和它的访问修饰符有关。</li>
</ul>
</li>
<li>方法的调用机制：
<ul>
<li>当程序执行（main方法）到方法时，会在jvm的栈内存内开辟一个独立的空间</li>
<li>当方法执行完毕时，或执行到return语句时，就会将方法的运行结果返回给栈内存中调用方法的地方。同时销毁开辟的独立空间。</li>
<li>返回后，程序继续执行后面的代码</li>
<li>当jvm内存内的main方法执行完毕，整个程序退出。</li>
<li><img src="/images/javase/java-1/image-1660367405772.png" alt="image.png" loading="lazy"></li>
</ul>
</li>
<li>使用方法的优点：
<ul>
<li>提高了代码的复用性。</li>
<li>将实现的细节封装起来，供其他用户调用。</li>
</ul>
</li>
<li>方法的传参机制（值传递）：
<ul>
<li>基本数据类型：传递的是值（值拷贝），形参的任何改变不影响实参。</li>
<li>引用数据类型：传递的是地址，可以通过形参影响实参。
<ul>
<li>形参不影响实参的情况：形参在方法内开辟了新的内存空间（需要在方法体内的语句实现）。</li>
<li>字符串的传参？</li>
</ul>
</li>
</ul>
</li>
<li>克隆对象：创建两个独立的对象，只是属性、方法一致。
<ul>
<li>利用引用数据类型传参的机制（在方法体内创建新对象，逐一赋值）。</li>
</ul>
</li>
</ol>
<h4 id="_4-1-4-类的实例化——对象" tabindex="-1"><a class="header-anchor" href="#_4-1-4-类的实例化——对象" aria-hidden="true">#</a> 4.1.4 类的实例化——对象</h4>
<ol>
<li>创建对象：
<ul>
<li>方式一：<code v-pre>类名 对象名 = new 类名();</code></li>
<li>方式二：<code v-pre>类名 对象名;对象名 = new 类名();</code></li>
<li><code v-pre>Person p1 = new Person();</code>
<ul>
<li>p1是对象的名（对象的引用），保存实例化对象的内存地址</li>
<li>new Person()创建的对象空间（数据）才是真正的对象</li>
</ul>
</li>
<li>方式三：创建对象数组<code v-pre>类名[] 对象数组名 = new 类名[n];</code></li>
</ul>
</li>
<li>访问成员：<code v-pre>对象名.对象成员</code>
<ul>
<li>访问属性：<code v-pre>对象名.属性</code></li>
<li>访问方法：<code v-pre>对象名.方法()</code></li>
</ul>
</li>
<li>匿名对象：
<ul>
<li>含义：创建对象时，如果没有显式地给对象起名，只是进行了<code v-pre>new 类名()</code>，则<code v-pre>new 类名()</code>为匿名对象。</li>
<li>特征：匿名对象只能调用一次。
<ul>
<li>第二次调用时已经是新对象了，跟前一个对象没有关系。</li>
</ul>
</li>
<li>使用：
<ul>
<li>临时使用、不需要保留</li>
<li>作为方法的参数</li>
</ul>
</li>
</ul>
</li>
</ol>
<h4 id="_4-1-5-方法重载-overload" tabindex="-1"><a class="header-anchor" href="#_4-1-5-方法重载-overload" aria-hidden="true">#</a> 4.1.5 方法重载（OverLoad）</h4>
<ol>
<li>定义：在同一个类中，允许存在一个以上的同名方法，只要它们的参数个数或者参数类型不同即可。</li>
<li>判断是否是重载：
<ul>
<li>“两同一不同”：
<ul>
<li>在同一个类中</li>
<li>相同方法名</li>
<li>参数列表不同：
<ul>
<li>参数个数不同</li>
<li>参数类型不同</li>
<li>同类型参数顺序不同</li>
</ul>
</li>
</ul>
</li>
<li>跟方法的权限修饰符、返回值类型、形参变量名、方法体都没有关系！</li>
</ul>
</li>
<li>在通过对象调用方法时，如何确定某一个指定的方法：
<ul>
<li>判断方法名是否一致</li>
<li>判断参数列表是否一致：参数类型、参数个数、参数顺序一致</li>
</ul>
</li>
<li>注意点：子类可以重载父类同名不同参的方法。</li>
</ol>
<h4 id="_4-1-6-方法递归-recrusion" tabindex="-1"><a class="header-anchor" href="#_4-1-6-方法递归-recrusion" aria-hidden="true">#</a> 4.1.6 方法递归（Recrusion）</h4>
<ol>
<li>含义：方法自己调用自己，每次调用时传入的参数不同</li>
<li>调用规则：
<ul>
<li>递归执行一次，会在栈内存内创建一个受保护的独立空间（栈空间）</li>
<li>方法的局部变量相互独立，不会相互影响</li>
<li>方法中使用引用数据类型的变量时，就会共享该引用类型的数据。</li>
<li>递归必须向退出递归的条件逼近，否则就是无限递归。</li>
<li>当一个方法执行完毕，或者遇到return语句，就会返回，遵循谁调用，结果就返回给谁。同时该方法执行完毕或返回时，该方法也就执行完毕。</li>
</ul>
</li>
</ol>
<h4 id="_4-1-7-构造方法-构造器-constructor" tabindex="-1"><a class="header-anchor" href="#_4-1-7-构造方法-构造器-constructor" aria-hidden="true">#</a> 4.1.7 构造方法/构造器（Constructor）</h4>
<ol>
<li>基本语法：<code v-pre>[修饰符] 方法名(形参列表){}</code></li>
<li>语法说明：
<ul>
<li>修饰符可以默认（无），也可以用private、protected、public。
<ul>
<li>修饰符为默认（无）时，与类的修饰符一致。</li>
</ul>
</li>
<li>构造器没有返回值，也不可以写<code v-pre>void</code></li>
<li>方法名必须和类名一模一样</li>
<li>参数列表和方法的规则一致</li>
<li>在创建对象时，系统会自动调用该类的对象完成属性的初始化。
<ul>
<li>完成对象的初始化不是创建对象</li>
</ul>
</li>
<li>不能被static、final、synchronized、abstract、native修饰，不能有return语句返回值</li>
</ul>
</li>
<li>主要作用：完成新对象（属性）的初始化。</li>
<li>构造器重载：
<ul>
<li>一个类可以定义多个构造器</li>
<li><strong>如果一个构造器没写，系统会自动生成一个无参、默认的构造器（该构造器的修饰符与类一致）。</strong></li>
<li>一旦定义了一个构造器，默认的无参构造器就不能使用了，使用了会报错。
<ul>
<li>如果想继续使用，需要再重新显式定义一下。</li>
</ul>
</li>
</ul>
</li>
<li>对象创建流程：
<ul>
<li>加载类信息，加载到方法区，只会加载一次</li>
<li>在堆空间中分配空间（地址）</li>
<li>完成对象的初始化
<ul>
<li>默认初始化</li>
<li>显式初始化</li>
<li>构造器初始化</li>
</ul>
</li>
<li>将对象在堆空间的地址返回给创建对象时定义的对象</li>
</ul>
</li>
<li>父类的构造器不可被子类继承</li>
<li>注意点：使用了构造器后，实例化对象要用构造器的方法，否则会报错。
<ul>
<li>原因为：显式声明构造器后，默认的无参构造器会不可用。</li>
</ul>
</li>
</ol>
<h4 id="_4-1-8-方法重写-override-overwrite" tabindex="-1"><a class="header-anchor" href="#_4-1-8-方法重写-override-overwrite" aria-hidden="true">#</a> 4.1.8 方法重写（override/overwrite）</h4>
<ol>
<li>定义：子类继承父类以后，可以对父类中同名同参数的方法，进行覆盖操作</li>
<li>应用：重写以后，当创建子类对象以后，通过子类对象调用子父类中的同名同参数的方法时，实际执行的是子类重写父类的方法。</li>
<li>语法：<code v-pre>权限修饰符 返回值类型 方法名(形参列表) throws 异常的类型{}</code>
<ul>
<li>方法名：父子一致。</li>
<li>形参列表：父子一致。</li>
<li>权限修饰符：子类不小于父类
<ul>
<li>不能重写父类中private修饰的方法，因为private修饰的方法对外部不可见。</li>
</ul>
</li>
<li>返回值类型：
<ul>
<li>void：父子一致。</li>
<li>基本数据类型：父子一致。</li>
<li>引用数据类型：子类不大于父类</li>
</ul>
</li>
<li>异常类型：子类不大于父类</li>
</ul>
</li>
<li>注意点：子类和父类中的同名同参数的方法要么都声明为非static的（考虑重写），要么都声明为static的（不是重写）。</li>
</ol>
<h4 id="_4-1-9-代码块" tabindex="-1"><a class="header-anchor" href="#_4-1-9-代码块" aria-hidden="true">#</a> 4.1.9 代码块</h4>
<ol>
<li>作用：用来初始化类、对象</li>
<li>修饰：
<ul>
<li>权限修饰：只能缺省。</li>
<li>关键字：只能用static或没有。</li>
</ul>
</li>
<li>分类：静态代码块与非静态代码块，
<ul>
<li>相同点：
<ul>
<li>都可以用于对类的属性、声明初始化</li>
<li>都可以声明多个代码块，但一般每种最多写一个</li>
<li>多个代码块默认执行顺序都是先上后下</li>
</ul>
</li>
<li>不同点：
<ul>
<li>静态代码块：
<ul>
<li>只能调用静态的属性和方法</li>
<li>随类的加载而执行，只执行一次
<ul>
<li>类加载的三个时机：
<ul>
<li>创建对象实例时（new）</li>
<li>创建子对象实例时，父类会被加载</li>
<li>使用类的静态成员时。</li>
</ul>
</li>
</ul>
</li>
</ul>
</li>
<li>非静态代码块：
<ul>
<li>既可以调用静态的属性和方法，也可以调用非静态的属性方法</li>
<li>随对象的创建而执行，创建一次执行一次。<strong>先于构造器执行</strong>
<ul>
<li><strong>可以将构造器相同的部分写到代码块内，减少不同构造器间的代码冗余。</strong></li>
</ul>
</li>
</ul>
</li>
</ul>
</li>
</ul>
</li>
<li>创建对象时，类的调用顺序：
<ul>
<li>静态代码块和静态属性。取决于书写顺序。</li>
<li>普通代码块和普通属性。取决于书写顺序。</li>
<li>构造器。</li>
</ul>
</li>
<li>创建子类对象时，类的调用顺序：
<ul>
<li>父类的静态代码块和静态属性。取决于书写顺序。</li>
<li>子类的静态代码块和静态属性。取决于书写顺序。</li>
<li>父类的普通代码块和普通属性。取决于书写顺序。</li>
<li>父类的构造器。</li>
<li>子类的普通代码块和普通属性。取决于书写顺序。</li>
<li>子类的构造器。</li>
</ul>
</li>
</ol>
<h4 id="_4-1-10-内部类-inenerclass" tabindex="-1"><a class="header-anchor" href="#_4-1-10-内部类-inenerclass" aria-hidden="true">#</a> 4.1.10 内部类（InenerClass）</h4>
<ol>
<li>
<p>含义：定义在类内部的一个类，包含内部的类叫外部类</p>
<ul>
<li>外部引用时需要完整写出类名称（含包名）</li>
<li>编译以后生成OuterClass$InnerClass.class字节码文件</li>
</ul>
</li>
<li>
<p>分类：</p>
<ul>
<li>局部内部类：定义在方法、代码块、构造器中。</li>
<li>成员内部类（static修饰和无修饰）：定义在成员位置，类内可定义类的五大组成部分（属性、方法、构造器、代码块、内部类）
<ul>
<li>可以被final修饰，表示此类不能被继承。</li>
<li>可以被abstract修饰，表示不能被实例化</li>
</ul>
</li>
</ul>
</li>
<li>
<p>局部内部类：</p>
<ul>
<li>可以直接访问外部类的所有成员，包含私有的
<ul>
<li>但是如果调用局部内部类所在方法中的局部变量时，要求该方法中的局部变量为final修饰，JDK8之前显式声明，JDK8之后可省略。</li>
</ul>
</li>
<li>不能添加权限修饰符（只能缺省，同局部变量的修饰符范围），可以被final修饰，修饰后不可被继承
<ul>
<li>不能被static修饰，也不能包含static成员</li>
</ul>
</li>
<li>内部类的成员与外部类的成员重名时，内部类调用遵循就近原则，需要调用外部成员时，需要通过<code v-pre>外部类.this.成员名</code>的方式</li>
<li>由于局部内部类定义在方法、代码块、构造器中，实际上是一个局部变量，只能在定义它的位置生效，即只能在这个位置实例化。
<ul>
<li>外部类需要访问内部类的成员时，需要通过上述流程，在外部类的方法中，将内部类实例化。</li>
<li>外部其他类不能访问。</li>
</ul>
</li>
</ul>
</li>
<li>
<p>成员内部类：</p>
<ul>
<li>可以直接访问外部类的所有成员，包含私有的
<ul>
<li>使用static修饰时，只能调用外部类声明为static的结构</li>
<li>非静态内部类，内部不能声明静态成员</li>
<li>前面省略了<code v-pre>外部类.this.</code>，不能使用<code v-pre>this.</code></li>
</ul>
</li>
<li>可以使用四种权限修饰符修饰</li>
<li>实例化内部类：
<ul>
<li>静态内部类：<code v-pre>外部类.内部类 变量名 = new 外部类.内部类();</code></li>
<li>非静态内部类：<code v-pre>外部类.内部类 变量名 = 外部类的引用.new 内部类();</code>
<ul>
<li><code v-pre>外部类.内部类 变量名 = 外部类的引用.new 外部类.内部类();</code></li>
</ul>
</li>
</ul>
</li>
<li>内部类的成员与外部类的成员重名时，内部类调用遵循就近原则，需要调用外部成员时，需要通过<code v-pre>外部类.this.成员名</code>的方式，调用内部类自身的属性，<code v-pre>this.成员名</code></li>
</ul>
</li>
<li>
<p>匿名内部类：</p>
<ul>
<li>
<p>语法：<code v-pre>new 父类构造器（实参列表）|实现接口(){ //匿名内部类的类体部分 };</code></p>
<ul>
<li>可以基于接口实现、也可基于父类实现</li>
<li>分号不能少</li>
</ul>
</li>
<li>
<p>可以是成员内部类、也可以是局部内部类。</p>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token doc-comment comment">/**
* <span class="token keyword">@author</span> INFITNITY Juejin:https://juejin.cn/user/2788017217999896
* <span class="token keyword">@date</span> 2022年5月24日下午9:25:26
*/</span>
<span class="token keyword">package</span> <span class="token namespace">com<span class="token punctuation">.</span>infinity<span class="token punctuation">.</span>interfacetest</span><span class="token punctuation">;</span>

<span class="token keyword">public</span> <span class="token keyword">class</span> <span class="token class-name">Cellphone</span><span class="token punctuation">{</span>
   <span class="token comment">// 1.1 匿名内部类是成员内部类</span>
<span class="token keyword">double</span> b <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">Calculator</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
<span class="token keyword">double</span> c <span class="token operator">=</span> <span class="token number">9.0</span><span class="token punctuation">;</span>
<span class="token annotation punctuation">@Override</span>
<span class="token keyword">public</span> <span class="token keyword">double</span> <span class="token function">work</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
   <span class="token comment">// TODO Auto-generated method stub</span>
   <span class="token keyword">return</span> <span class="token number">0</span><span class="token punctuation">;</span>
<span class="token punctuation">}</span>
<span class="token punctuation">}</span><span class="token punctuation">.</span>c<span class="token punctuation">;</span>
   <span class="token comment">// 1.2 匿名内部类是成员内部类</span>
<span class="token keyword">double</span> a  <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">Calculator</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
<span class="token annotation punctuation">@Override</span>
<span class="token keyword">public</span> <span class="token keyword">double</span> <span class="token function">work</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
   <span class="token comment">// TODO Auto-generated method stub</span>
   <span class="token keyword">return</span> <span class="token number">0</span><span class="token punctuation">;</span>
<span class="token punctuation">}</span>
<span class="token punctuation">}</span><span class="token punctuation">.</span><span class="token function">work</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
<span class="token keyword">public</span> <span class="token keyword">double</span>  <span class="token function">testWork</span><span class="token punctuation">(</span><span class="token class-name">Calculator</span> c<span class="token punctuation">)</span> <span class="token punctuation">{</span>
<span class="token keyword">double</span> result<span class="token punctuation">;</span>
result <span class="token operator">=</span> c<span class="token punctuation">.</span><span class="token function">work</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
      <span class="token comment">// 2.1 匿名内部类是局部内部类</span>
<span class="token keyword">double</span> b <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">Calculator</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
   <span class="token keyword">double</span> c <span class="token operator">=</span> <span class="token number">9.0</span><span class="token punctuation">;</span>
   <span class="token annotation punctuation">@Override</span>
   <span class="token keyword">public</span> <span class="token keyword">double</span> <span class="token function">work</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
   <span class="token keyword">return</span> <span class="token number">0</span><span class="token punctuation">;</span>
   <span class="token punctuation">}</span>
<span class="token punctuation">}</span><span class="token punctuation">.</span>c<span class="token punctuation">;</span>
      <span class="token comment">// 2.2 匿名内部类是局部内部类</span>
<span class="token keyword">double</span> a  <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">Calculator</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
   <span class="token annotation punctuation">@Override</span>
   <span class="token keyword">public</span> <span class="token keyword">double</span> <span class="token function">work</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
   <span class="token comment">// TODO Auto-generated method stub</span>
   <span class="token keyword">return</span> <span class="token number">0</span><span class="token punctuation">;</span>
   <span class="token punctuation">}</span>
<span class="token punctuation">}</span><span class="token punctuation">.</span><span class="token function">work</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
<span class="token keyword">return</span> result<span class="token punctuation">;</span>
<span class="token punctuation">}</span>
<span class="token keyword">public</span> <span class="token keyword">static</span> <span class="token keyword">void</span> <span class="token function">main</span><span class="token punctuation">(</span><span class="token class-name">String</span><span class="token punctuation">[</span><span class="token punctuation">]</span> args<span class="token punctuation">)</span> <span class="token punctuation">{</span>
<span class="token class-name">Cellphone</span> cp <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">Cellphone</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
      <span class="token comment">// 2.3 匿名内部类是局部内部类</span>
<span class="token keyword">double</span> a <span class="token operator">=</span> cp<span class="token punctuation">.</span><span class="token function">testWork</span><span class="token punctuation">(</span><span class="token keyword">new</span> <span class="token class-name">Calculator</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
   <span class="token annotation punctuation">@Override</span>
   <span class="token keyword">public</span> <span class="token keyword">double</span> <span class="token function">work</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
   <span class="token keyword">return</span> <span class="token number">1</span> <span class="token operator">+</span> <span class="token number">1</span><span class="token punctuation">;</span>
   <span class="token punctuation">}</span>
<span class="token punctuation">}</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
<span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span>a<span class="token punctuation">)</span><span class="token punctuation">;</span>
<span class="token punctuation">}</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ul>
<li>匿名内部类本身也是一个对象，因此它也可以调用内部类内部的方法，执行时遵循多态的规则（匿名内部类重写了就执行内部类里的方法）</li>
<li>其他有关问题参见4.4.8第6部分。</li>
</ul>
</li>
</ul>
</li>
<li>
<p>外部类不能被static修饰</p>
</li>
<li>
<p>成员内部类和局部内部类，在编译以后，都会生成字节码文件。</p>
<ul>
<li>成员内部类：外部类$内部类名.class</li>
<li>局部内部类：外部类$数字 内部类名.class</li>
</ul>
</li>
</ol>
<h3 id="_4-2-jvm内存分析" tabindex="-1"><a class="header-anchor" href="#_4-2-jvm内存分析" aria-hidden="true">#</a> 4.2 jvm内存分析</h3>
<h4 id="_4-2-1-内存结构" tabindex="-1"><a class="header-anchor" href="#_4-2-1-内存结构" aria-hidden="true">#</a> 4.2.1 内存结构</h4>
<ol>
<li>图结构：
<ul>
<li><img src="/images/javase/java-1/image-1660367414351.png" alt="image.png" loading="lazy"></li>
</ul>
</li>
<li>引用类型的变量只能存储两类值：
<ul>
<li>null</li>
<li>包含变量类型的地址值。</li>
</ul>
</li>
</ol>
<h4 id="_4-2-2-内存分配" tabindex="-1"><a class="header-anchor" href="#_4-2-2-内存分配" aria-hidden="true">#</a> 4.2.2 内存分配</h4>
<ol>
<li>栈：一般指虚拟机栈，存储局部变量。</li>
<li>堆：存放对象（含对象的属性）、数组。</li>
<li>方法区：常量池（常量、字符串）、静态变量、即时编译后的代码。</li>
</ol>
<h4 id="_4-2-3-成员变量与局部变量的异同" tabindex="-1"><a class="header-anchor" href="#_4-2-3-成员变量与局部变量的异同" aria-hidden="true">#</a> 4.2.3 成员变量与局部变量的异同</h4>
<ol>
<li>相同点：
<ul>
<li>定义变量的格式相同：<code v-pre>数据类型  变量名 = 变量值</code></li>
<li>先声明，后使用</li>
<li>都有其对应的作用域以及生命周期</li>
</ul>
</li>
<li>不同点：
<ul>
<li>在类中声明的位置的不同
<ul>
<li>属性：直接定义在类的一对<code v-pre>{}</code>内</li>
<li>局部变量：声明在方法内、方法形参、代码块内、构造器形参、构造器内部的变量</li>
</ul>
</li>
<li>作用域范围不同：
<ul>
<li>属性：可以被本类使用、也可以被其他类使用（通过对象调用）</li>
<li>局部变量：只能在本类中对应的方法使用。</li>
</ul>
</li>
<li>关于权限修饰符的不同
<ul>
<li>属性：可以在声明属性时，指明其权限，使用权限修饰符。</li>
<li>局部变量：不可以使用权限修饰符。</li>
</ul>
</li>
<li>默认初始化值的情况不同：
<ul>
<li>属性：类的属性，根据其类型，都有默认初始化值。</li>
<li>局部变量：没有默认初始化值。在调用局部变量之前，一定要显式赋值。形参在调用时赋值即可。</li>
</ul>
</li>
<li>在内存中加载的位置不同：
<ul>
<li>属性：加载到堆空间中（非static），因为对象加载到了堆空间</li>
<li>局部变量：加载到栈空间</li>
</ul>
</li>
<li>生命周期不同：
<ul>
<li>属性：生命周期长，伴随对象的创建而创建，伴随对象的销毁而销毁。</li>
<li>局部变量：生命周期短，伴随代码块的执行而创建，伴随代码块的执行结束而销毁。</li>
</ul>
</li>
</ul>
</li>
<li>属性和局部变量可以重名，访问时遵循就近原则。</li>
</ol>
<p><img src="/images/javase/java-1/yuque_mind-1660367418504.jpeg" alt="" loading="lazy"></p>
<ol start="4">
<li>属性赋值过程：
<ul>
<li>默认初始化</li>
<li>显式初始化 / 代码块
<ul>
<li>取决于类中书写的顺序</li>
</ul>
</li>
<li>构造器中初始化</li>
<li>通过“对象.属性“或“对象.方法”的方式赋值</li>
</ul>
</li>
</ol>
<h4 id="_4-2-4-可变个数形参" tabindex="-1"><a class="header-anchor" href="#_4-2-4-可变个数形参" aria-hidden="true">#</a> 4.2.4 可变个数形参</h4>
<ol>
<li>语法：
<ul>
<li>JDK 5.0以前：采用数组形参来定义方法，传入多个同一类型变量
<ul>
<li><code v-pre>public static void test(int a, String[] books);</code></li>
</ul>
</li>
<li>JDK5.0：采用可变个数形参来定义方法，传入多个同一类型变量
<ul>
<li><code v-pre>public static void test(int a, String… books);</code></li>
</ul>
</li>
</ul>
</li>
<li>注意点：
<ul>
<li>调用方法时，可传入的参数个数可以是0个，1个或多个</li>
<li>可变参数的方法可与其他方法构成重载，调用时，优先调用匹配度高的
<ul>
<li>用<code v-pre>...</code>和<code v-pre>[]</code>作为方法参数的同名方法视为同一个类里视为重复定义（编译报错），父子类内视为重写。</li>
</ul>
</li>
<li>可变参数方法的使用与方法参数部分使用数组是一致的，方法体内使用for循环</li>
<li>方法的参数部分有可变形参时，需要放在形参声明的最后</li>
<li>一个方法最多只能声明一个可变个数形参</li>
</ul>
</li>
</ol>
<h3 id="_4-3-封装、继承和多态" tabindex="-1"><a class="header-anchor" href="#_4-3-封装、继承和多态" aria-hidden="true">#</a> 4.3 封装、继承和多态</h3>
<h4 id="_2-3-1-封装与隐藏" tabindex="-1"><a class="header-anchor" href="#_2-3-1-封装与隐藏" aria-hidden="true">#</a> 2.3.1 封装与隐藏</h4>
<ol>
<li>含义：将类中的属性（数据）私有化，并提供外部可访问的类进行属性操作。</li>
<li>好处：
<ul>
<li>对（变量）数据进行验证，保证数据安全</li>
<li>隐藏实现细节</li>
<li>便于修改，增强代码可维护性</li>
</ul>
</li>
<li>体现：
<ul>
<li>将属性使用private修饰，进行私有化，并提供公共的set和get方法获取和设置此属性的值
<ul>
<li>提供public修饰的setter，用于判断并修改属性，无返回值</li>
<li>提供public修饰的getter，用于判断并读取属性，有返回值</li>
</ul>
</li>
<li>不对外暴露私有方法</li>
<li>单例模式（将构造器私有化）</li>
<li>如果不希望类在包外调用，可以将类设置为缺省的</li>
</ul>
</li>
<li>权限修饰符：</li>
</ol>
<table>
<thead>
<tr>
<th>修饰符</th>
<th>类内部</th>
<th>同一个包</th>
<th>不同包的子类（其父类是protected）</th>
<th>同一个工程</th>
</tr>
</thead>
<tbody>
<tr>
<td>private</td>
<td>√</td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>缺省</td>
<td>√</td>
<td>√</td>
<td></td>
<td></td>
</tr>
<tr>
<td>但修饰的属性子类访问不到</td>
<td></td>
<td></td>
<td></td>
<td></td>
</tr>
<tr>
<td>protected</td>
<td>√</td>
<td>√</td>
<td>√</td>
<td></td>
</tr>
<tr>
<td>public</td>
<td>√</td>
<td>√</td>
<td>√</td>
<td>√</td>
</tr>
</tbody>
</table>
<ul>
<li>类的权限修饰符只能用public或缺省
<ul>
<li>使用public时，本工程下使用
<ul>
<li>需要导入全类名</li>
</ul>
</li>
<li>使用缺省时，只可以被同一个包内部的类访问</li>
</ul>
</li>
<li>局部变量（方法内、方法形参等）的修饰符只能缺省。</li>
<li>protected修饰的属性、方法需要在不同包内访问时，一是需要父子继承关系，且protected修饰的内容是父类，二是需要在子类中导入包</li>
</ul>
<h4 id="_4-3-2-继承-inheritance" tabindex="-1"><a class="header-anchor" href="#_4-3-2-继承-inheritance" aria-hidden="true">#</a> 4.3.2 继承（<strong>inheritance</strong>）</h4>
<ol>
<li>作用：
<ul>
<li>减少代码的冗余，提高代码的复用性，提高开发效率</li>
<li>有利于功能扩展</li>
<li>使类与类之间产生联系，为多态提供了前提</li>
</ul>
</li>
<li>格式：<code v-pre>class A extends B{}</code>
<ul>
<li><code v-pre>A</code>：子类、派生类、subclass</li>
<li><code v-pre>B</code>：父类、超类、superclas</li>
</ul>
</li>
<li>体现：
<ul>
<li>子类A继承父类B以后，子类A中就自动获取了父类B中声明的所有的属性和方法。
<ul>
<li>直接父类、间接父类、自身都有同名属性的情况下，访问时执行就近原则。
<ul>
<li>方法按重写规定执行。</li>
</ul>
</li>
<li>父类中声明为private的属性或方法，子类继承父类以后，仍然认为获取了父类中私有的结构。只有因为封装性的影响，使得子类不能直接调用父类的结构而已。需要通过setter和getter调用属性。
<ul>
<li>通过<code v-pre>super.属性</code>的方法也访问不到。</li>
</ul>
</li>
</ul>
</li>
<li>子类继承父类以后，还可以声明自己特有的属性或方法：实现功能的拓展。</li>
<li>子类必须调用父类的构造器，完成父类的初始化。
<ul>
<li>实例化过程中会一直调用至Object对象。</li>
</ul>
</li>
<li>**注意点：**子类A继承自父类B后，如果父类B中声明了带参的构造器，则必须在子类A中声明A的构造函数，且必须在首行通过<code v-pre>super(形参列表)</code>调用B的构造函数。否则会编译报错。
<ul>
<li>原因为如果子类A中不写构造器，其默认构造器为无参构造器，无参构造器中默认会调用B的无参构造器<code v-pre>super()</code>。由于父类B中显式地声明了构造器，导致默认的无参构造器不可用，从而会报错。而如果不在首行写<code v-pre>super(形参列表)</code>语句，则表明调用的是<code v-pre>super()</code>，同样会报错。
<ul>
<li>解决方案一：父类B中显式声明无参构造器。</li>
<li>解决方案二：子类A中调用父类B中指定的构造器。声明A的构造器方法体内使用<code v-pre>super(形参列表)</code></li>
</ul>
</li>
</ul>
</li>
</ul>
</li>
<li>规定：
<ul>
<li>一个父类可以被多个子类继承。</li>
<li>子类直接继承的父类，称为：直接父类。间接继承的父类称为：间接父类。</li>
<li>子类继承父类以后，就获取了直接父类以及所有间接父类中声明的属性和方法。</li>
<li>如果我们没有显式的声明一个类的父类的话，则此类继承于java.lang.Object类。</li>
<li>所有的java类（除java.lang.Object类之外）都直接或间接的继承于java.lang.Object类</li>
<li>所有的java类具有java.lang.Object类声明的功能。</li>
</ul>
</li>
<li>子类对象的实例化过程
<ul>
<li>从结果上来看：（继承性）
<ul>
<li>子类继承父类以后，就获取了父类中声明的属性或方法。</li>
<li>创建子类的对象，在堆空间中，就会加载所有父类中声明的属性。</li>
</ul>
</li>
<li>从过程上来看：
<ul>
<li>通过子类的构造器创建子类对象时，一定会直接或间接的调用其父类的构造器，进而调用父类的父类的构造器，直到调用了java.lang.Object类中空参的构造器为止。</li>
<li>正因为加载过所有的父类的结构，所以才可以看到内存中有父类中的结构，子类对象才可以考虑进行调用。</li>
</ul>
</li>
<li>虽然创建子类对象时，调用了父类的构造器，但是自始至终就创建过一个对象，即为new的子类对象。</li>
<li><img src="/images/javase/java-1/18446744072569838818556192156.png" alt="18446744072569838818556192156.png" loading="lazy"></li>
</ul>
</li>
</ol>
<h4 id="_4-3-3-多态性-polymorphism" tabindex="-1"><a class="header-anchor" href="#_4-3-3-多态性-polymorphism" aria-hidden="true">#</a> 4.3.3 多态性（<strong>Polymorphism</strong>）</h4>
<ol>
<li>理解：方法和对象的多种形态。实现代码的通用性。</li>
<li>体现：
<ul>
<li>方法多态：
<ul>
<li>重载多态（参数不同，方法体现出多重形态）。</li>
<li>重写多态。</li>
</ul>
</li>
<li>对象多态：
<ul>
<li>对象的编译类型和运行类型可以不一致，编译类型在定义时确定，不能变化。</li>
<li>对象的运行类型可以是变化的，可以通过<code v-pre>getClass()</code>查看运行类型。</li>
</ul>
</li>
<li>常将父类对象作为方法形参，执行方法时根据具体实例化的父/子类对象进行传入。</li>
</ul>
</li>
<li>使用：虚拟方法调用
<ul>
<li>子类中定义了与父类同名同参数的方法，在多态情况下，将此时<strong>父类的方法称为虚拟方法</strong>，父类根据赋给它的不同子类对象，动态调用属于子类的该方法。这样的方法调用在编译期是无法确定的。</li>
<li>编译期只能调用父类中声明的方法，但在运行期，实际执行的是子类重写父类的方法。</li>
<li>不能调用子类中特有的成员。
<ul>
<li>需要调用子类特有成员时，需要使用向下转型。</li>
</ul>
</li>
<li>总结：编译，看左边；运行，看右边。</li>
</ul>
</li>
<li>使用前提：
<ul>
<li>类的继承关系</li>
<li>方法的重写</li>
</ul>
</li>
<li>对象的多态性，只适用于方法，不适用于属性（编译和运行都看左边）。
<ul>
<li>使用向下转型声明的父类对象，调用父子类同名的属性时，实际调用的是父类的属性。
<ul>
<li>属性不具有多态性。</li>
<li>由于父类的属性通常设置为private，所以需要getter方法才能获取到。</li>
</ul>
</li>
</ul>
</li>
<li><code v-pre>instance of</code>操作符：
<ul>
<li>
<p><code v-pre>x instanceof A</code>：检验x的运行类是否为类A或其子类的对象，返回值为boolean型。</p>
<ul>
<li>如果x是类B的对象，而B是A的子类，则仍返回true。</li>
</ul>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token class-name">AA</span> aa <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">BB</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
<span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span>aa <span class="token keyword">instanceof</span> <span class="token class-name">AA</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
<span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span>aa <span class="token keyword">instanceof</span> <span class="token class-name">BB</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
<span class="token comment">//设BB继承自AA</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ul>
<li>强制转型后的类型判断：这里均返回true，因为运行的是BB类</li>
</ul>
</li>
</ul>
</li>
</ol>
<ul>
<li><code v-pre>x instanceof Object</code>：总是返回true。</li>
<li>检验的A类必须与x的类有父子类关系，否则编译会报错。</li>
</ul>
<ol start="7">
<li>造型：对java类型的强制类型转换
<ul>
<li>子类到父类可以自动类型转换——多态、向上转型</li>
<li>父类到子类必须通过造型<code v-pre>()</code>实现——向下转型。</li>
<li>无继承关系的引用类型造型非法，运行报错：<code v-pre>ClassCastException</code></li>
<li>通常首先使用<code v-pre>instanceof</code>操作符进行判断后进行造型操作，避免报错。</li>
</ul>
</li>
<li>java的动态绑定机制：
<ul>
<li>当调用对象的方法时，该方法会和对象的内存地址/运行类型绑定。</li>
<li>当调用对象的属性时，没有动态绑定机制，哪里声明，哪里使用。</li>
</ul>
</li>
</ol>
<h3 id="_4-4-关键字" tabindex="-1"><a class="header-anchor" href="#_4-4-关键字" aria-hidden="true">#</a> 4.4 关键字</h3>
<h4 id="_4-4-1-this" tabindex="-1"><a class="header-anchor" href="#_4-4-1-this" aria-hidden="true">#</a> 4.4.1 this</h4>
<ol>
<li>作用：
<ul>
<li>方法内部使用时，代表方法所属对象的引用</li>
<li>构造器内部使用时，代表该构造器正在初始化的对象。【子类构造器初始化时，父类构造器中的this指向的是子类正在实例化的对象】</li>
</ul>
</li>
<li>使用范围：属性、方法、构造器</li>
<li>时机：方法内需要调用该方法的对象时，可以使用this。
<ul>
<li>在任意方法或构造器内，如果使用当前类的成员变量或成员方法可以在其前面添加this，增强程序的阅读性。不过，通常我们都习惯省略this。</li>
<li>当形参与成员变量同名时，如果在方法内或构造器内需要使用成员变量，必须添加this来表明该变量是类的成员变量</li>
<li>使用this访问属性和方法时，如果在本类中未找到，会从父类中查找</li>
</ul>
</li>
<li>this调用构造器
<ul>
<li>可以在类的构造器中使用<code v-pre>this(形参列表)</code>的方式，调用本类中重载的其他的构造器！</li>
<li>明确：构造器中不能通过<code v-pre>this(形参列表)</code>的方式调用自身构造器</li>
<li>如果一个类中声明了n个构造器，则最多有n-1个构造器中使用了<code v-pre>this(形参列表)</code></li>
<li><code v-pre>this(形参列表)</code>必须声明在类的构造器的首行！</li>
<li>在类的一个构造器中，最多只能声明一个<code v-pre>this(形参列表)</code></li>
</ul>
</li>
<li>有参的构造器如果没有显式地调用this()，则不会调用无参的构造器。因为如果没写this()，也没写super(0，默认调用的是super()。super()不能使用<code v-pre>this.super()</code></li>
</ol>
<h4 id="_4-4-2-package" tabindex="-1"><a class="header-anchor" href="#_4-4-2-package" aria-hidden="true">#</a> 4.4.2 package</h4>
<ol>
<li>作用：package语句作为Java源文件的第一条语句，指明该文件中定义的类所在的包。(若缺省该语句，则指定为无名包)。</li>
<li>格式：<code v-pre>package 顶层包名.子包名</code>
<ul>
<li>一般：<code v-pre>com.公司名.项目名.业务模块名</code></li>
</ul>
</li>
<li>使用规范：
<ul>
<li>包对应于文件系统的目录，package语句中，用<code v-pre>.</code>来指明包(目录)的层次</li>
<li>包通常用小写单词标识。通常使用所在公司域名的倒置</li>
</ul>
</li>
<li>作用：
<ul>
<li>包帮助管理大型软件系统：将功能相近的类划分到同一个包中。比如：MVC的设计模式</li>
<li>包可以包含类和子包，划分项目层次，便于管理</li>
<li>解决类命名冲突的问题</li>
<li>控制访问权限</li>
</ul>
</li>
<li>注意点：
<ul>
<li>同一个包下，不能命名同名的接口、类。</li>
<li>不同的包下，可以命名同名的接口、类。</li>
</ul>
</li>
<li>常见包：
<ul>
<li>java.lang----包含一些Java语言的核心类，如String、Math、Integer、 System和Thread，提供常用功能</li>
<li>java.net----包含执行与网络相关的操作的类和接口。</li>
<li><a href="http://java.io" target="_blank" rel="noopener noreferrer">java.io<ExternalLinkIcon/></a> ----包含能提供多种输入/输出功能的类。</li>
<li>java.util----包含一些实用工具类，如定义系统特性、接口的集合框架类、使用与日期日历相关的函数。</li>
<li>java.text----包含了一些java格式化相关的类</li>
<li>java.sql----包含了java进行JDBC数据库编程的相关类/接口</li>
<li>java.awt----包含了构成抽象窗口工具集（abstract window toolkits）的多个类，这些类被用来构建和管理应用程序的图形用户界面(GUI)。 B/S C/S</li>
</ul>
</li>
</ol>
<h4 id="_4-4-3-import" tabindex="-1"><a class="header-anchor" href="#_4-4-3-import" aria-hidden="true">#</a> 4.4.3 import</h4>
<ol>
<li>作用：为使用定义在不同包中的Java类，需用import语句来引入指定包层次下所需要的类或全部类(.*)。</li>
<li>语法格式：<code v-pre>import 包名.类名;</code></li>
<li>使用细节：
<ul>
<li>在源文件中使用import显式的导入指定包下的类或接口</li>
<li>声明在包的声明和类的声明之间。</li>
<li>如果需要导入多个类或接口，那么就并列显式多个import语句即可</li>
<li>可以使用java.util.*的方式，一次性导入util包下所有的类或接口。</li>
<li>如果导入的类或接口是java.lang包下的，或者是当前包下的，则可以省略此import语句。</li>
<li>如果在代码中使用不同包下的同名的类。那么就需要使用类的全类名的方式指明调用的是哪个类。</li>
<li>如果已经导入java.a包下的类。那么如果需要使用a包的子包下的类的话，仍然需要导入。</li>
<li>import static组合的使用：调用指定类或接口下的静态的属性或方法</li>
</ul>
</li>
</ol>
<h4 id="_4-4-4-super" tabindex="-1"><a class="header-anchor" href="#_4-4-4-super" aria-hidden="true">#</a> 4.4.4 super</h4>
<ol>
<li>用途：子类调用父类的属性、方法、构造器
<ul>
<li>解决子父子类属性、方法冲突的问题。</li>
<li>在合适的位置调用父类的属性、方法、构造器。</li>
</ul>
</li>
<li>操作对象：属性、方法、构造器</li>
<li>调用属性和方法：
<ul>
<li>子类的方法和构造器中，使用父类的属性和方法时，默认使用了<code v-pre>super.</code>的方式调用属性、方法。编程中习惯不写<code v-pre>super.</code>。
<ul>
<li>super不能调用父类的私有属性。</li>
</ul>
</li>
<li>当子类和父类中定义了同名的属性时，使用<code v-pre>super.属性</code>调用的是父类的属性；如果属性没有重名，使用<code v-pre>super.属性</code>同<code v-pre>this.属性</code>作用一样。</li>
<li>在子类中重写的方法中调用父类被重写的方法时，必须使用<code v-pre>super.方法</code>的方式。
<ul>
<li>super不能调用父类的私有方法。</li>
</ul>
</li>
<li>super调用父类时，不局限于直接父类，有多个上级类有重名方法、属性时，遵循就近原则。</li>
</ul>
</li>
<li>调用构造器：
<ul>
<li>可以在子类的构造器中，显式地使用<code v-pre>super(形参列表)</code>的方式调用父类的构造器。</li>
<li><code v-pre>super(形参列表)</code>必须声明在首行。</li>
<li>由于<code v-pre>this(形参列表)</code>也必须出现在首行，所以一个构造器中<code v-pre>this(形参列表)</code>或<code v-pre>super(形参列表)</code>只能二选一，不能同时出现。</li>
<li><strong>在构造器的首行，没有显式的声明</strong><code v-pre>**this(形参列表)**</code><strong>或</strong><code v-pre>**super(形参列表)**</code><strong>，则默认调用的是父类中空参的构造器：</strong><code v-pre>**super()**</code><strong>。</strong></li>
<li>在类的多个构造器中，至少有一个类的构造器中使用了<code v-pre>super(形参列表)</code>，调用父类中的构造器。
<ul>
<li>因为所有的对象都是继承来的，都必然具有父类的特征。</li>
</ul>
</li>
</ul>
</li>
<li>默认的无参构造器默认调用的<code v-pre>super()</code>
<ul>
<li>无论哪个构造器创建子类对象，需要先保证初始化父类，当子类继承父类以后，继承了父类中的属性和方法，因此子类有必要知道父类如何对对象初始化。</li>
</ul>
</li>
</ol>
<h4 id="_4-4-5-static" tabindex="-1"><a class="header-anchor" href="#_4-4-5-static" aria-hidden="true">#</a> 4.4.5 static</h4>
<ol>
<li>设计思想：
<ul>
<li>属性：在各个对象间共享，不因对象的不同而改变。</li>
<li>方法：方法的调用与对象无关，不需要创建对象就可调用方法。</li>
</ul>
</li>
<li>修饰范围：
<ul>
<li>可修饰：属性、方法、代码块、内部类
<ul>
<li>被static修饰的属性叫：静态属性、静态变量、类变量。</li>
<li>没有被static修饰的属性叫非静态属性、实例变量。</li>
<li>被static修饰的方法叫：静态方法。</li>
</ul>
</li>
<li>不能修饰：局部变量、形参、构造器、外部类
<ul>
<li>不能修饰构造器的原因：static随着类的加载而加载，根据构造器的加载时机区分static和非static，先于构造器加载的为static，后于构造器加载的为非static</li>
</ul>
</li>
</ul>
</li>
<li>特点：
<ul>
<li>属性和方法随着类的加载而加载，与是否创建对象无关。
<ul>
<li>由于类只会在JVM的内存里加载一次，所以属性会只有一份。</li>
<li>存在于方法区的静态域中。</li>
<li>无论创建多少次对象，使用多少次类，都只有一份</li>
</ul>
</li>
<li>属性和方法优先于对象而存在。</li>
<li>被static修饰的成员，被所有对象所共享。</li>
<li>访问权限允许时，可不创建对象，直接被类调用。</li>
</ul>
</li>
</ol>
<blockquote>
<p>被static修饰的内部类实例化的特点呢？以及与多线程的关系？</p>
</blockquote>
<ol start="4">
<li>注意点：
<ul>
<li>静态属性和静态方法可以通过<code v-pre>类名.静态属性</code>、<code v-pre>类名、静态方法名()</code>的方式直接调用，也可以通过<code v-pre>对象名.静态属性</code>、<code v-pre>对象名、静态方法名()</code>的方式调用。</li>
<li>静态方法中，只能调用静态的方法或属性；
<ul>
<li>同类中的静态方法调用静态方法，可以直接使用<code v-pre>方法名();</code>或<code v-pre>类名、静态方法名()</code>，不能使用<code v-pre>this</code></li>
<li>实例化当前类后，可以通过<code v-pre>对象名.静态属性</code>、<code v-pre>对象名、静态方法名()</code>的方式调用非静态的属性和方法。</li>
</ul>
</li>
<li>非静态方法中，既可以调用非静态的方法或属性，也可以调用静态的方法或属性。</li>
<li>在静态的方法内，不能使用this关键字、super关键字。
<ul>
<li>也不能通过<code v-pre>this.</code>、<code v-pre>super.</code>的方式调用静态属性、静态方法，只能通过<code v-pre>类名.</code>的方式调用。</li>
</ul>
</li>
<li>static修饰的方法不能被重写，但可以被继承。
<ul>
<li>不能被重写：父类、子类的同名、同参静态方法都会被加载。</li>
<li>可以被继承：子类可以直接通过<code v-pre>类名.方法名()</code>的方式调用。</li>
</ul>
</li>
<li>static修饰内部类，类中的属性、方法、代码块可以是非静态的</li>
<li>static可与四种权限修饰符搭配使用，控制可见范围。
<ul>
<li>设置为private时，只能被<code v-pre>类名.静态属性</code>、<code v-pre>类名.静态方法名()</code>调用，不能被对象的引用调用。</li>
</ul>
</li>
</ul>
</li>
<li>使用时机：
<ul>
<li>属性：
<ul>
<li>属性需要被多个对象共享</li>
<li>常量</li>
</ul>
</li>
<li>方法：
<ul>
<li>操作静态属性</li>
<li>工具类中的方法。如Math、Collection、Arrays</li>
</ul>
</li>
</ul>
</li>
</ol>
<h4 id="_4-4-6-main" tabindex="-1"><a class="header-anchor" href="#_4-4-6-main" aria-hidden="true">#</a> 4.4.6 main</h4>
<ol>
<li>main()说明：
<ul>
<li>main方法的权限修饰符必须是public</li>
<li>main方法的修饰符必须是static，因为main方法也是一个内中的方法，需要加载对象的时候执行，而不是创建main方法所在类的对象时候执行。</li>
<li>由于main方法使用static修饰了，所有不能直接访问本类中的非static属性和方法，必须通过实例化创建本类对象的方式进行调用。</li>
<li>main方法可以作为与控制台交互的方式
<ul>
<li>在命令行中执行（运行时，先要生成字节码文件）<code v-pre>java 文件名 参数</code>
<ul>
<li>参数可以带引号，也可以不带，多个参数使用空格分开</li>
</ul>
</li>
</ul>
</li>
</ul>
</li>
</ol>
<blockquote>
<ol start="2">
<li>在eclipse工具中执行：
<ul>
<li><img src="/images/javase/java-1/image-1660367439818.png" alt="image.png" loading="lazy"></li>
<li><img src="/images/javase/java-1/image-1660367436734.png" alt="image.png" loading="lazy"></li>
</ul>
</li>
</ol>
</blockquote>
<ol start="3">
<li>main方法中访问直接访问本类中的静态方法和静态静态属性可以不需要<code v-pre>类名.</code>的方式调用。</li>
</ol>
<h4 id="_4-4-7-final" tabindex="-1"><a class="header-anchor" href="#_4-4-7-final" aria-hidden="true">#</a> 4.4.7 final</h4>
<ol>
<li>用途：修饰类、变量（成员变量及局部变量）、方法、内部类
<ul>
<li>变量分为局部变量和成员变量</li>
</ul>
</li>
<li>final修饰类：不能被继承，提高安全性、可读性。
<ul>
<li>通常final修饰类后，内部的方法没必要在用final修饰</li>
<li>String类、StringBuffer类、System类</li>
</ul>
</li>
<li>final修饰方法：不能被子类重写
<ul>
<li>Object的getClass()</li>
<li>不能修饰构造器</li>
</ul>
</li>
<li>final修饰属性（成员变量）：表示常量，且必须在定义时初始化。
<ul>
<li>赋值的位置可以是类中显式初始化、代码块、构造器内。</li>
<li>搭配static使用时，初始化位置只能是显示初始化和静态代码块内</li>
</ul>
</li>
<li>final修饰局部变量：。
<ul>
<li>final修饰形参时，表示给常量赋值，方法体内只能使用该常量，不能修改该形参。</li>
<li>修饰方法体内局部变量时，称为局部常量。</li>
</ul>
</li>
<li>final可以和static搭配使用，
<ul>
<li><code v-pre>static final</code>：只能用于修饰属性、普通方法，修饰属性时，表示全局常量。</li>
</ul>
</li>
</ol>
<h4 id="_4-4-8-abstract-抽象类与抽象方法" tabindex="-1"><a class="header-anchor" href="#_4-4-8-abstract-抽象类与抽象方法" aria-hidden="true">#</a> 4.4.8 abstract（抽象类与抽象方法）</h4>
<ol>
<li>修饰结构：类、方法、内部类
<ul>
<li>不能修饰属性、私有（private）方法、静态（static）方法、final方法、final类</li>
<li>通常用于处理父类方法不缺定时的需求。</li>
<li>先有抽象方法，后有抽象类。</li>
</ul>
</li>
<li>不可修饰结构：属性、构造器等。</li>
<li>修饰类：
<ul>
<li>此类不能实例化</li>
<li>开发中一般提供抽象类的子类，该子类使用多态的方式实例化父类。否则匿名化。</li>
</ul>
</li>
<li>修饰方法：
<ul>
<li>抽象方法只有方法名，没有方法体，用<code v-pre>;</code>结束</li>
<li>包含抽象方法的类，一定是抽象类；但抽象类不一定包含抽象方法。</li>
<li>抽象类不能被private修饰（因为要对外可见，需要被重写）</li>
<li>若子类重写了父类所有的抽象方法，则该子类可实例化；</li>
<li>若子类没有重写或部分重写了父类的所有抽象方法，则该子类也是一个抽象类，需要使用abstract修饰。</li>
</ul>
</li>
<li>抽象类的应用：模板方法的设计模式。（见2.6.2）</li>
<li>匿名类（不一定为抽象类）与匿名对象：共有四种格式
<ul>
<li>非匿名类非匿名对象：<code v-pre>Worker worker = new Worker();</code></li>
<li>非匿名类匿名对象：<code v-pre>new Worker();</code></li>
<li>匿名类非匿名对象：<code v-pre>Person p = new Person(){重写Person的虚拟方法};</code>
<ul>
<li>注意分号不能省略。</li>
<li>Person是一个虚拟类，按理不能实例化，实际上也正是通过方法体中的重写，将Person类变成了其他类，正常来说应该单独定义一个非虚拟具名的类继承自Person，再将方法体写入其中，但正由于没有这样做，不知道这个子类叫什么名字，所以就是匿名类。
<ul>
<li>在匿名类非匿名对象的方法体中，如果声明了属性a，通过<code v-pre>对象引用.p.a</code>的方式访问属性a的值，如果Person类中没有定义过a，则报错，如果Person中定义了a，则返回的是Person类中的a的值。即，匿名类非匿名对象中声明的自有属性访问不到。</li>
<li>如果要能访问到，可采用<code v-pre>int p = new Person(){int a = 1;重写Person的虚拟方法}.a;</code>
<ul>
<li><code v-pre>int p = new Person(){int a = 1;重写Person的虚拟方法}.a;</code>改变返回值类型、<code v-pre>.a</code>为<code v-pre>.方法名()</code>可以获取<code v-pre>.方法名()</code>的返回值。但是仅限于有返回值类型的方法（含自有方法）。</li>
</ul>
</li>
</ul>
</li>
</ul>
</li>
<li>匿名类匿名对象：<code v-pre>new Person(){重写Person的虚拟方法}</code>
<ul>
<li>注意分号不能省略。</li>
</ul>
</li>
</ul>
</li>
</ol>
<h3 id="_4-5-面向对象补充知识" tabindex="-1"><a class="header-anchor" href="#_4-5-面向对象补充知识" aria-hidden="true">#</a> 4.5 面向对象补充知识</h3>
<h4 id="_4-5-1-javabean" tabindex="-1"><a class="header-anchor" href="#_4-5-1-javabean" aria-hidden="true">#</a> 4.5.1 JavaBean</h4>
<ol>
<li>JavaBean是一种Java语言编写的可重用组件。</li>
<li>特征：
<ul>
<li>类是公共的</li>
<li>有一个无参的公共构造器</li>
<li>有属性
<ul>
<li>属性一般定义为private，有对应的getter、setter</li>
</ul>
</li>
</ul>
</li>
<li>可以使用JavaBean将功能、处理、值、数据库访问和其他任何可以用Java代码创造的对象进行打包，并且其他的开发者可以通过内部的JSP页面、Servlet、其他JavaBean、applet程序或者应用来使用这些对象。用户可以认为JavaBean提供了一种随时随地的复制和粘贴的功能，而不用关心任何改变。</li>
</ol>
<h4 id="_4-5-2-uml类图" tabindex="-1"><a class="header-anchor" href="#_4-5-2-uml类图" aria-hidden="true">#</a> 4.5.2 UML类图</h4>
<p><img src="/images/javase/java-1/yuque_mind-1660367444659.jpeg" alt="" loading="lazy"></p>
<ul>
<li>Accout：类名</li>
<li><code v-pre>+</code>表示public，<code v-pre>-</code>表示private，<code v-pre>#</code>表示protected</li>
<li>属性：<code v-pre>：</code>前表示属性名，<code v-pre>：</code>后表示属性类型</li>
<li>方法：方法的<code v-pre>()</code>外面有<code v-pre>：</code>表示有返回值，<code v-pre>：</code>后面为返回值类型</li>
<li>方法有下划线表示构造器</li>
</ul>
<h4 id="_4-5-3-mvc设计模式" tabindex="-1"><a class="header-anchor" href="#_4-5-3-mvc设计模式" aria-hidden="true">#</a> 4.5.3 MVC设计模式</h4>
<!-- ![](/images/javase/java-1/b03533fa828ba61edbddc04d4034970a304e59a4) -->
<ol>
<li>内容：常用的设计模式之一，将整个程序分为三个层次：视图模型层，控制器层，与数据模型层。</li>
<li>优点：这种将程序输入输出、数据处理，以及数据的展示分离开来的设计模式使程序结构变的灵活而且清晰，同时也描述了程序各个对象间的通信方式，降低了程序的耦合性。</li>
<li>模型层（model）：主要处理数据
<ul>
<li>数据对象封装：model.bean/domain</li>
<li>数据库操作类：model.dao</li>
<li>数据库：model.db</li>
</ul>
</li>
<li>控制层（controller）：处理业务逻辑
<ul>
<li>应用界面相关：controller.activity</li>
<li>存放fragment：controller.fragment</li>
<li>显示列表的适配器：controller.adapter</li>
<li>服务相关的：controller.service</li>
<li>抽取的基类：controller.base</li>
</ul>
</li>
<li>视图层（view ）：显示数据
<ul>
<li>相关工具类：view.utils</li>
<li>自定义view：view.ui</li>
</ul>
</li>
</ol>
<h4 id="_4-5-4-object类的使用" tabindex="-1"><a class="header-anchor" href="#_4-5-4-object类的使用" aria-hidden="true">#</a> 4.5.4 Object类的使用</h4>
<ol>
<li>Object类是所有Java类的根父类。</li>
<li>如果在类的声明中未使用extends关键字指明其父类，则默认直接父类为java.lang.Object类。</li>
<li>Object类中的属性：无</li>
<li>Object类中的方法：
<ul>
<li><code v-pre>equals()</code> ：
<ul>
<li>只能比较引用数据类型，作用与<code v-pre>==</code>相同，比较是否指向同一对象。</li>
<li>类<code v-pre>File、String、Date及包装类</code>由于重写了<code v-pre>equals()</code>，所以比较的时内容是否相同。</li>
<li>重写<code v-pre>equals()</code>原则：
<ul>
<li>对称性：如果x.equals(y)返回是true，那么y.equals(x)也应该返回是true。</li>
<li>自反性：x.equals(x)必须返回是true。</li>
<li>传递性：如果x.equals(y)返回是true，而且y.equals(z)返回是true，那么z.equals(x)也应该返回是true。</li>
<li>一致性：如果x.equals(y)返回是true，只要x和y内容一直不变，不管重复x.equals(y)多少次，返回都是true。</li>
<li>任何情况下，x.equals(null)，永远返回是false，null。equals(x)会空指针异常。</li>
<li>x.equals(和x不同类型的对象)永远返回是false。</li>
</ul>
</li>
</ul>
</li>
<li><code v-pre>toString()</code>：
<ul>
<li>返回值为String，返回类名和它的内存地址——全类名+@+哈希值的十六进制。
<ul>
<li>全类名：包名+类名</li>
</ul>
</li>
<li>类<code v-pre>File、String、Date及包装类</code>由于重写了<code v-pre>toString()</code>，返回&quot;实体内容&quot;信息。</li>
<li>使用String类型的数据与<code v-pre>+</code>进行连接操作时，自动调用<code v-pre>toString()</code></li>
</ul>
</li>
<li><code v-pre>getClass()</code>：获取当前对象所处的类</li>
<li><code v-pre>hashCode()</code>：返回该对象的哈希值，用于提高哈希表的性能。
<ul>
<li>两个引用指向同一对象，哈希码值一定一样。</li>
<li>两个引用指向不同对象，哈希码值一般不一样，（极少数情况一样）。</li>
<li>哈希值主要根据地址值生成，但与地址值不同。</li>
</ul>
</li>
<li><code v-pre>clone()</code></li>
<li><code v-pre>finalize()</code>：
<ul>
<li>当对象被回收时，系统会自动调用该方法。</li>
<li>当某个对象没有任何引用，则jvm认为该对象是一个垃圾对象。在销毁该对象前，会先调用该方法。</li>
<li>可以通过System.gc()主动出发垃圾回收机制。</li>
</ul>
</li>
<li><code v-pre>wait()</code></li>
<li><code v-pre>notify()</code></li>
<li><code v-pre>notifyAll()</code></li>
</ul>
</li>
<li>Object类只声明了一个空参的构造器</li>
<li>final、finally、finalize的区别？</li>
</ol>
<h4 id="_4-5-5-junit单元测试" tabindex="-1"><a class="header-anchor" href="#_4-5-5-junit单元测试" aria-hidden="true">#</a> 4.5.5 JUnit单元测试</h4>
<ol>
<li>步骤：</li>
</ol>
<div class="custom-container warning"><p class="custom-container-title">注意</p>
<ul>
<li>选中当前工程 - 右键选择：build path - add libraries - JUnit 5.4 - 下一步</li>
<li>创建Java类，进行单元测试。</li>
<li><strong>简便方式：在测试方法上一行写上</strong><code v-pre>**@Test**</code><strong>，然后Ctrl+1修复。</strong></li>
</ul>
</div>
<ol start="2">
<li>此时的Java类要求：① 此类是public的  ②此类提供公共的无参的构造器</li>
<li>此类中声明单元测试方法：方法的权限是public,没有返回值，没有形参。</li>
<li>此单元测试方法上需要声明注解：@Test,并在单元测试类中导入：import org.junit.Test;</li>
<li>声明好单元测试方法以后，就可以在方法体内测试相关的代码。</li>
<li>写完代码以后，左键双击单元测试方法名，右键：run as - JUnit Test</li>
<li>说明：
<ul>
<li>如果执行结果没有任何异常：绿条</li>
<li>如果执行结果出现异常：红条</li>
</ul>
</li>
<li>测试方法没有返回值，也没有参数</li>
</ol>
<h3 id="_4-6-设计模式" tabindex="-1"><a class="header-anchor" href="#_4-6-设计模式" aria-hidden="true">#</a> 4.6 设计模式</h3>
<ol>
<li>概念：开发过程中经过大量的实践中总结和理论化之后优选的代码结构、编程风格、 以及解决问题的思考方式。</li>
<li>分类：
<ul>
<li>创建型（5种）：</li>
<li>结构型（7种）：</li>
<li>行为型（11种）：</li>
</ul>
</li>
</ol>
<h4 id="_4-6-1-单例模式-singleton" tabindex="-1"><a class="header-anchor" href="#_4-6-1-单例模式-singleton" aria-hidden="true">#</a> 4.6.1 单例模式（<strong>Singleton</strong>）</h4>
<ol>
<li>
<p>定义：采取一定的方法保证在整个的软件系统中，对某个类只能存在一个对象实例，并且该类只提供一个取得其对象实例的方法。</p>
</li>
<li>
<p>实现原理：</p>
<ul>
<li>构造器私有化，防止new</li>
<li>类的内部创建静态实例对象</li>
<li>向外暴露一个静态的公共方法。</li>
</ul>
</li>
<li>
<p>实现方式：</p>
<ul>
<li>饿汉式：</li>
</ul>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token keyword">class</span> <span class="token class-name">Singleton</span> <span class="token punctuation">{</span>
   <span class="token comment">// 1.私有化构造器</span>
   <span class="token keyword">private</span> <span class="token class-name">Singleton</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span><span class="token punctuation">}</span>
   <span class="token comment">// 2.内部提供一个当前类的实例</span>
   <span class="token comment">// 4.此实例也必须静态化</span>
   <span class="token keyword">private</span> <span class="token keyword">static</span> <span class="token class-name">Singleton</span> single <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">Singleton</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
   <span class="token comment">// 3.提供公共的静态的方法，返回当前类的对象</span>
   <span class="token keyword">public</span> <span class="token keyword">static</span> <span class="token class-name">Singleton</span> <span class="token function">getInstance</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
      <span class="token keyword">return</span> single<span class="token punctuation">;</span> 
   <span class="token punctuation">}</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ul>
<li>懒汉式：</li>
</ul>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token keyword">class</span> <span class="token class-name">Singleton</span> <span class="token punctuation">{</span>
   <span class="token comment">// 1.私有化构造器</span>
   <span class="token keyword">private</span> <span class="token class-name">Singleton</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span><span class="token punctuation">}</span>
   <span class="token comment">// 2.内部提供一个当前类的实例</span>
   <span class="token comment">// 4.此实例也必须静态化</span>
   <span class="token keyword">private</span> <span class="token keyword">static</span> <span class="token class-name">Singleton</span> single<span class="token punctuation">;</span>
   <span class="token comment">// 3.提供公共的静态的方法，返回当前类的对象</span>
   <span class="token keyword">public</span> <span class="token keyword">static</span> <span class="token class-name">Singleton</span> <span class="token function">getInstance</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
      <span class="token keyword">if</span><span class="token punctuation">(</span>single <span class="token operator">==</span> <span class="token keyword">null</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
            single <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">Singleton</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
      <span class="token punctuation">}</span>
      <span class="token keyword">return</span> single<span class="token punctuation">;</span> 
   <span class="token punctuation">}</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div></li>
<li>
<p>优缺点：</p>
<ul>
<li>饿汉式：
<ul>
<li>优点：线程安全。</li>
<li>缺点：对象加载时间过长。全生命周期。</li>
</ul>
</li>
<li>懒汉式：
<ul>
<li>优点：延迟对象的创建。</li>
<li>缺点线程不安全。</li>
</ul>
</li>
</ul>
</li>
<li>
<p>应用场景：</p>
<ul>
<li>网站计数器：</li>
<li>应用程序的日志程序：</li>
<li>数据库的连接池</li>
<li>读取配置文件的类：</li>
<li>Application：
<ul>
<li>windows系统的任务管理器</li>
<li>windows系统的回收站</li>
</ul>
</li>
</ul>
</li>
</ol>
<h4 id="_4-6-2-模板方法设计模式-templatemethod" tabindex="-1"><a class="header-anchor" href="#_4-6-2-模板方法设计模式-templatemethod" aria-hidden="true">#</a> 4.6.2 模板方法设计模式（<strong>TemplateMethod</strong>）</h4>
<ol>
<li>体现：就是一种模板模式的设计，抽象类作为多个子类的通用模板，子类在抽象类的基础上进行扩展、改造，但子类总体上会保留抽象类的行为方式。
<ul>
<li>也是多态行的一种体现。</li>
</ul>
</li>
<li>解决的问题：
<ul>
<li>当功能内部一部分实现是确定的，一部分实现是不确定的。这时可以把不确定的部分暴露出去，让子类去实现。</li>
<li>换句话说，在软件开发中实现一个算法时，整体步骤很固定、通用，这些步骤已经在父类中写好了。但是某些部分易变，易变部分可以抽象出来，供不同子类实现。</li>
</ul>
</li>
<li>应用：模板方法设计模式是编程中经常用得到的模式。各个框架、类库中都有他的影子，比如常见的有：
<ul>
<li>数据库访问的封装</li>
<li>Junit单元测试</li>
<li>JavaWeb的Servlet中关于doGet/doPost方法调用</li>
<li>Hibernate中模板程序</li>
<li>Spring中JDBCTemlate、HibernateTemplate等</li>
</ul>
</li>
<li>实现过程：
<ul>
<li>定义抽象类
<ul>
<li>抽象类中写明确定的流程，定义在一个方法（模板方法）内，模板方法调用各个流程</li>
<li>将不确定的内容插入到方法中的合适位置调用</li>
<li>将不确定的内容定义成抽象方法。</li>
</ul>
</li>
<li>子类继承抽象类，重写抽象方法，在方法中完成需要工作的代码。</li>
<li>实例化子类，子类由于继承了父类的方法，通过子类对象的引用调用父类的模板方法的那个方法。</li>
</ul>
</li>
</ol>
<h4 id="_4-6-3-代理模式-proxy" tabindex="-1"><a class="header-anchor" href="#_4-6-3-代理模式-proxy" aria-hidden="true">#</a> 4.6.3 代理模式（Proxy）</h4>
<ol>
<li>体现：类A实现了接口，实际需要类A去调用（操作）接口时，表面上通过实例化类B去操作，而将A作为一个参数调用。</li>
<li>步骤：
<ul>
<li>类A实现接口C</li>
<li>类B实现接口C</li>
<li>类B构造函数传入接口C</li>
<li>在类B内定义检查、校验等方法，并在实现的接口C的方法内调用</li>
<li>创建<code v-pre>C 变量名 = new B(new A())</code></li>
<li><code v-pre>变量名.C的虚拟方法</code></li>
</ul>
</li>
<li>应用场景
<ul>
<li>安全代理</li>
<li>远程代理</li>
<li>延迟加载</li>
</ul>
</li>
<li>分类：
<ul>
<li>静态代理（上述描述）</li>
<li>动态代理（JDK自带的静态代理，需要反射实现）</li>
</ul>
</li>
</ol>
<h4 id="_4-6-4-工厂模式-略" tabindex="-1"><a class="header-anchor" href="#_4-6-4-工厂模式-略" aria-hidden="true">#</a> 4.6.4 工厂模式（略）</h4>
<h3 id="_4-7-interface-接口" tabindex="-1"><a class="header-anchor" href="#_4-7-interface-接口" aria-hidden="true">#</a> 4.7 Interface（接口）</h3>
<ol>
<li>
<p>概述：接口是一组规则的集成，是抽象方法和常量值的集合。</p>
</li>
<li>
<p>修饰符：public、缺省。</p>
<ul>
<li>public修饰的接口需要单独建一个文件</li>
</ul>
</li>
<li>
<p>级别：接口是和类并列的一类结构</p>
</li>
<li>
<p>语法：</p>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token keyword">interface</span> 接口名<span class="token punctuation">{</span>
   属性<span class="token punctuation">;</span>
   抽象方法<span class="token punctuation">;</span>
<span class="token punctuation">}</span>
<span class="token keyword">class</span> 类名 <span class="token keyword">extends</span> 父类 <span class="token keyword">implements</span> 接口<span class="token number">1</span><span class="token punctuation">,</span> 接口<span class="token number">2</span><span class="token punctuation">{</span>
   类的自有属性；
   类的自有方法；
   必须实现的接口的抽象方法<span class="token punctuation">;</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div></li>
</ol>
<ul>
<li>属性为全局常量，<code v-pre>public static final</code>修饰，不写时仍然为<code v-pre>public static final</code>，一般不写。
<ul>
<li>可以省略任意多个修饰符。</li>
<li>声明时必须初始化，因为为final修饰。</li>
</ul>
</li>
<li>接口中的抽象方法可以不用<code v-pre>public abstract</code>修饰，不写时仍然为<code v-pre>public abstract</code>，一般不写**（不写时注意不是缺省，override方法时注意权限修饰符范围，即实现类的重写方法权限修饰符必须为public，重写方法不能写abstract）**。
<ul>
<li>可以省略任意多个修饰符。</li>
</ul>
</li>
<li>不能new</li>
<li>接口名有没有abstract修饰不影响</li>
<li>JDK7之前：只能定义全局常量和抽象方法：没有方法体</li>
<li>JDK8及之后：还可以定义静态方法、默认方法：有方法体
<ul>
<li>静态方法：static修饰
<ul>
<li>可以通过接口直接调用并执行方法体。</li>
<li>实现类可以不用重写接口的静态方法</li>
</ul>
</li>
<li>默认方法：default修饰
<ul>
<li>可以通过类对象来调用</li>
<li>实现类可以不用重写接口的默认方法</li>
</ul>
</li>
</ul>
</li>
</ul>
<ol start="5">
<li>注意点：
<ul>
<li>接口不能被实例化（不能声明构造器），匿名接口的方式可以new</li>
<li>普通类实现接口，必须实现接口中的所有方法（重写接口中的所有抽象方法）</li>
<li>抽象类实现接口，可以不用实现（重写）接口中的方法</li>
<li>接口可以相互继承，子类接口含有了直接父类、间接父类的所有属性和方法，其实现接口的类必须实现所有方法</li>
<li>接口中属性的访问形式：<code v-pre>接口名.属性名</code>或实现接口的<code v-pre>类名.属性名</code>、<code v-pre>对象名.属性名</code>（同虚拟类访问静态属性）
<ul>
<li><code v-pre>类名.属性名</code>、<code v-pre>对象名.属性名</code>的方式不能和继承的父类中的属性名冲突，否则会报错，原因为不明确
<ul>
<li>继承+实现情况下属性名重复会报错</li>
<li>实现+实现情况下属性名重复会报错</li>
</ul>
</li>
</ul>
</li>
</ul>
</li>
<li>接口也具有多态性
<ul>
<li><code v-pre>接口名 变量名 = new 实现接口的类名()</code></li>
</ul>
</li>
<li>类优先原则：
<ul>
<li>
<p><code v-pre>class C extends A implements B</code>中，如果A、B、C中均定义了同名的属性，实例化C后访问该属性时，返回C中的，如果C中没有，则会报错。</p>
<ul>
<li>如果A中实现了B中的抽象方法，而C中什么也没写，这时根据继承原则，默认C中有了A的方法，从而重写了B中的方法。</li>
</ul>
</li>
<li>
<p>两个接口同时定义了同名同参的默认方法：</p>
<ul>
<li>如果返回值不一致（权限修饰符均一致）， 一个类都实现了接口时，会发生接口冲突（报错），无法通过重写两个同名同参不同返回值类型的方法，因为两个接口不知道谁是它的重写。</li>
<li>如果返回值一致，则一个实现类可只写一个重写方法，表示对两个接口方法的重写。</li>
</ul>
</li>
<li>
<p>一个接口定义了默认方法，一个父类定义了同名同参数的非抽象方法，不会发生冲突，且<strong>类优先，接口中定义的同名同参方法会被忽略。</strong></p>
<ul>
<li>调用指定接口的方法：<code v-pre>接口名.super.默认方法名</code></li>
</ul>
<table>
<thead>
<tr>
<th></th>
<th>类</th>
<th>内部类</th>
<th>属性</th>
<th>局部变量</th>
<th>方法</th>
<th>构造器</th>
<th>代码块</th>
<th>接口</th>
</tr>
</thead>
<tbody>
<tr>
<td>public</td>
<td>是</td>
<td>是</td>
<td>是</td>
<td>否</td>
<td>是</td>
<td>是</td>
<td>否</td>
<td>是</td>
</tr>
<tr>
<td>protected</td>
<td>否</td>
<td>是</td>
<td>是</td>
<td>否</td>
<td>是</td>
<td>是</td>
<td>否</td>
<td>否</td>
</tr>
<tr>
<td>缺省</td>
<td>是</td>
<td>是</td>
<td>是</td>
<td>否</td>
<td>是</td>
<td>是</td>
<td>是</td>
<td>是</td>
</tr>
<tr>
<td>private</td>
<td>否</td>
<td>是</td>
<td>是</td>
<td>否</td>
<td>是</td>
<td>是</td>
<td>否</td>
<td>否</td>
</tr>
</tbody>
</table>
</li>
<li>
<p>public修饰类和接口时，必须单独设置一个文件。</p>
<table>
<thead>
<tr>
<th></th>
<th>类</th>
<th>内部类</th>
<th>属性</th>
<th>局部变量</th>
<th>方法</th>
<th>构造器</th>
<th>代码块</th>
<th>接口</th>
</tr>
</thead>
<tbody>
<tr>
<td>static</td>
<td>否</td>
<td>是</td>
<td>是</td>
<td>否</td>
<td>是</td>
<td>否</td>
<td>是</td>
<td>否</td>
</tr>
<tr>
<td>final</td>
<td>是</td>
<td>是</td>
<td>是</td>
<td>是</td>
<td>是</td>
<td>否</td>
<td>否</td>
<td>否</td>
</tr>
<tr>
<td>abstract</td>
<td>是</td>
<td>是</td>
<td>否</td>
<td>否</td>
<td>非private的方法</td>
<td>否</td>
<td>否</td>
<td>是</td>
</tr>
</tbody>
</table>
</li>
<li>
<p>static、final、abstract要写在语句的开头，但与权限修饰符的先后顺序没关系。</p>
</li>
<li>
<p>final和abstract修饰符永远二选一（类、内部类、方法）。</p>
</li>
<li>
<p>final和static永远可搭配（内部类、属性、方法）</p>
</li>
<li>
<p>static和abstract可同时修饰内部类，不可同时修饰方法。</p>
</li>
</ul>
</li>
</ol>
<h2 id="第5章-常用类" tabindex="-1"><a class="header-anchor" href="#第5章-常用类" aria-hidden="true">#</a> 第5章 常用类</h2>
<h3 id="_5-1-包装类" tabindex="-1"><a class="header-anchor" href="#_5-1-包装类" aria-hidden="true">#</a> 5.1 包装类</h3>
<h4 id="_5-1-1-来源原因" tabindex="-1"><a class="header-anchor" href="#_5-1-1-来源原因" aria-hidden="true">#</a> 5.1.1 来源原因</h4>
<ol>
<li>Java定义了8种数据类型对应的引用类型（包装类、封装类），使得可以调用类中的方法。</li>
</ol>
<h4 id="_5-1-2-分类" tabindex="-1"><a class="header-anchor" href="#_5-1-2-分类" aria-hidden="true">#</a> 5.1.2 分类</h4>
<ul>
<li><img src="/images/javase/java-1/image-1660367461238.png" alt="image.png" loading="lazy"></li>
</ul>
<h4 id="_5-1-3-基本数据类型、包装类、string类型的相互转换" tabindex="-1"><a class="header-anchor" href="#_5-1-3-基本数据类型、包装类、string类型的相互转换" aria-hidden="true">#</a> 5.1.3 基本数据类型、包装类、String类型的相互转换</h4>
<ol>
<li>基本数据类型转换为包装类：
<ul>
<li>装箱：基本数据类型包装成包装类的实例。</li>
<li>使用包装类的构造器：<code v-pre>new Integer()</code>。
<ul>
<li>可传入基本数据类型。</li>
<li>可传入字符串。</li>
</ul>
</li>
<li>使用包装类的方法：<code v-pre>Integer.valueOf();</code></li>
</ul>
</li>
<li>包装类转换为基本数据类型：
<ul>
<li>拆箱：获得包装类对象中包装的基本类型变量。</li>
<li>调用包装类的<code v-pre>.intValue()</code>方法。</li>
</ul>
</li>
<li>基本数据类型转换为字符串：
<ul>
<li>调用字符串重载的<code v-pre>valueOf()</code>方法。</li>
<li>使用<code v-pre>+</code>拼接<code v-pre>&quot;&quot;</code>空字符串。</li>
</ul>
</li>
<li>字符串转换为基本数据类型：
<ul>
<li>使用包装类的构造器：<code v-pre>new Integer()</code>，传入字符串。</li>
<li>使用包装类的<code v-pre>parseInteger(String s)</code>静态方法。</li>
</ul>
</li>
<li>字符串转换为包装类：
<ul>
<li>调用包装类的构造器：<code v-pre>new Integer()</code>。</li>
</ul>
</li>
<li>包装类转换为字符串：
<ul>
<li>调用包装类的<code v-pre>tostring()</code>方法。</li>
</ul>
</li>
</ol>
<p><img src="/images/javase/java-1/image-1660367464182.png" alt="image.png" loading="lazy"></p>
<ol start="5">
<li>JDK1.5之后支持自动装箱、自动拆箱，但类型必须匹配
<ul>
<li>Integer a = 10;   自动封箱</li>
<li>int b = a;        自动拆箱</li>
</ul>
</li>
<li>基本数据类型和包装类型使用功能<code v-pre>==</code>号比较时，比较的是数值值。</li>
</ol>
<h3 id="_5-2-string类" tabindex="-1"><a class="header-anchor" href="#_5-2-string类" aria-hidden="true">#</a> 5.2 String类</h3>
<h4 id="_5-2-1-string对象的特点" tabindex="-1"><a class="header-anchor" href="#_5-2-1-string对象的特点" aria-hidden="true">#</a> 5.2.1 String对象的特点</h4>
<ol>
<li>继承自Object</li>
<li>使用双引号包裹。</li>
<li>字符串的字符使用Unicode字符编码，一个字符（不区分字母和汉字）占用2个字节。</li>
<li>常见创建方式（常用构造器）：
<ul>
<li><code v-pre>new String()</code>：空参</li>
<li><code v-pre>new String(String str)</code>：字符串字面量</li>
<li><code v-pre>new String(char[] a)</code>：字符型数组</li>
<li><code v-pre>new String(byte[] b)</code>：btye型数字（一个byte数占1个字节）</li>
<li><code v-pre>new String()</code>：</li>
</ul>
</li>
<li>String由final修饰，不可被继承。<strong>源码</strong><code v-pre>**public final class String{}**</code></li>
<li>String内定义了<code v-pre>private final char value[]</code>，用于存放字符串内容。
<ul>
<li>由于value数组被final修饰，所以不能改变value的地址值。</li>
<li>如果改变字符串变量的字面量值，如将<code v-pre>String str = s;</code>改为<code v-pre>String str = str;</code>则表示str指向常量池中新的地址。而不是对常量池中s所在的地址空间重新填充内容。</li>
<li>体现：
<ul>
<li>当对字符串重新赋值时，需要重写指定内存区域赋值，不能使用原有的value进行赋值。
当对现有的字符串进行连接操作时，也需要重新指定内存区域赋值，不能使用原有的value进行赋值。</li>
<li>当调用String的replace()方法修改指定字符或字符串时，也需要重新指定内存区域赋值，不能使用原有的value进行赋值。</li>
</ul>
</li>
</ul>
</li>
</ol>
<h4 id="_5-2-2-创建string对象细节" tabindex="-1"><a class="header-anchor" href="#_5-2-2-创建string对象细节" aria-hidden="true">#</a> 5.2.2 创建String对象细节</h4>
<ol>
<li>比较对象：
<ul>
<li>字面量方式：<code v-pre>String str = &quot;string&quot;;</code></li>
<li>构造器方式：<code v-pre>String str = new String(string);</code></li>
</ul>
</li>
<li>字面量方式：
<ul>
<li>从常量池检查是否已有该字符串</li>
<li>常量池中有，str指向常量池中该字符串的地址</li>
<li>常量池中没有，先创建该字符串，然后str指向该字符串在常量池中的地址</li>
</ul>
</li>
<li>构造器方式：
<ul>
<li>new String在堆空间创建了地址空间，str指向该地址</li>
<li>new String开辟的内存空间中的属性value数组，在常量池中查找字符串</li>
<li>常量池中有，value指向常量池中该字符串的地址</li>
<li>常量池中没有，先创建该字符串，然后value指向该字符串在常量池中的地址</li>
</ul>
</li>
<li>字面方式创建注意点：
<ul>
<li><code v-pre>String d = &quot;helloabc&quot;;</code>与<code v-pre>String e = &quot;hello&quot; + &quot;abc&quot;;</code>等价，指向常量池同一地址。</li>
<li><code v-pre>String a = &quot;hello&quot;;String b = &quot;abc&quot;;String c = a + b;</code>与<code v-pre>String e = &quot;hello&quot; + &quot;abc&quot;;</code>不等价。
<ul>
<li><code v-pre>String c = a + b;</code>底层会先进行<code v-pre>StringBuilder c = new StringBuilder()</code>，然后调用append()方法将a和b添加进去，此时创建的StringBuilder()对象在堆内存中，所以c保存的是堆空间的地址。</li>
<li>如果再执行<code v-pre>c.intern();</code>则与<code v-pre>String e = &quot;hello&quot; + &quot;abc&quot;;</code>等价。
<ul>
<li>原因为intern()方法会在常量池中查找是否存在该字符串，存在时返回常量池中的对象（含地址），不存在则创建。</li>
</ul>
</li>
</ul>
</li>
<li><code v-pre>String a = &quot;hello&quot;;String b = &quot;abc&quot; +  a;</code>只要有变量参与，就会调用StringBuilder()创建对象。
<ul>
<li>但假如<code v-pre>final String a = &quot;hello&quot;</code>，则结果仍在常量池，因为此时a变成了常量</li>
</ul>
</li>
<li>结论：
<ul>
<li>常量与常量的拼接结果在常量池。且常量池中不会存在相同内容的常量。</li>
<li>只要其中有一个是变量，结果就在堆中。</li>
<li>如果拼接的结果调用intern()方法，返回值就在常量池中</li>
</ul>
</li>
</ul>
</li>
</ol>
<h4 id="_5-2-3-jvm中涉及字符串的存放位置" tabindex="-1"><a class="header-anchor" href="#_5-2-3-jvm中涉及字符串的存放位置" aria-hidden="true">#</a> 5.2.3 JVM中涉及字符串的存放位置</h4>
<p>【参见JVM虚拟机】</p>
<ol>
<li>jdk 1.6：字符串常量池存储在方法区（永久区）</li>
<li>jdk 1.7：字符串常量池存储在堆空间</li>
<li>jdk 1.8：字符串常量池存储在方法区（元空间）</li>
</ol>
<h4 id="_5-2-4-string常见方法" tabindex="-1"><a class="header-anchor" href="#_5-2-4-string常见方法" aria-hidden="true">#</a> 5.2.4 String常见方法</h4>
<ol>
<li>操作：
<ul>
<li><code v-pre>int length()</code>：返回字符串的长度： return value.length</li>
<li><code v-pre>char charAt(int index)</code>： 返回某索引处的字符return value[index]</li>
<li><code v-pre>boolean isEmpty()</code>：判断是否是空字符串：return value.length == 0</li>
<li><code v-pre>String toLowerCase()</code>：使用默认语言环境，将 String 中的所有字符转换为小写</li>
<li><code v-pre>String toUpperCase()</code>：使用默认语言环境，将 String 中的所有字符转换为大写</li>
<li><code v-pre>String trim()</code>：返回字符串的副本，忽略前导空白和尾部空白</li>
<li><code v-pre>boolean equals(Object obj)</code>：比较字符串的内容是否相同</li>
<li><code v-pre>boolean equalsIgnoreCase(String anotherString)</code>：与equals方法类似，忽略大小写</li>
<li><code v-pre>String concat(String str)</code>：将指定字符串连接到此字符串的结尾。 等价于用“+”</li>
<li><code v-pre>int compareTo(String anotherString)</code>：比较两个字符串的大小</li>
</ul>
</li>
<li>查找：
<ul>
<li><code v-pre>boolean endsWith(String suffix)</code>：测试此字符串是否以指定的后缀结束</li>
<li><code v-pre>boolean startsWith(String prefix)</code>：测试此字符串是否以指定的前缀开始</li>
<li><code v-pre>boolean startsWith(String prefix, int toffset)</code>：测试此字符串从指定索引开始的子字符串是否以指定前缀开始</li>
<li><code v-pre>boolean contains(CharSequence s)</code>：当且仅当此字符串包含指定的 char 值序列时，返回 true</li>
<li><code v-pre>int indexOf(String str)</code>：返回指定子字符串在此字符串中第一次出现处的索引</li>
<li><code v-pre>int indexOf(String str, int fromIndex)</code>：返回指定子字符串在此字符串中第一次出现处的索引，从指定的索引开始
<ul>
<li>如果<code v-pre>fromIndex</code>为负数，表示从尾部开始，到头部的顺序查找，仍然是正序查找。</li>
</ul>
</li>
<li><code v-pre>int lastIndexOf(String str)</code>：返回指定子字符串在此字符串中最右边出现处的索引</li>
<li><code v-pre>int lastIndexOf(String str, int fromIndex)</code>：返回指定子字符串在此字符串中最后一次出现处的索引，从指定的索引开始反向搜索</li>
</ul>
</li>
<li>替换：
<ul>
<li><code v-pre>String replace(char oldChar, char newChar)</code>：返回一个新的字符串，它是通过用 newChar 替换此字符串中出现的所有 oldChar 得到的。</li>
<li><code v-pre>String replace(CharSequence target, CharSequence replacement)</code>：使用指定的字面值替换序列替换此字符串所有匹配字面值目标序列的子字符串。</li>
<li><code v-pre>String replaceAll(String regex, String replacement)</code>：使用给定的 replacement 替换此字符串所有匹配给定的正则表达式的子字符串。</li>
<li><code v-pre>String replaceFirst(String regex, String replacement)</code>：使用给定的 replacement 替换此字符串匹配给定的正则表达式的第一个子字符串。</li>
</ul>
</li>
<li>匹配:
<ul>
<li><code v-pre>boolean matches(String regex)</code>：告知此字符串是否匹配给定的正则表达式。</li>
</ul>
</li>
<li>切片：
<ul>
<li><code v-pre>String[] split(String regex)</code>：根据给定正则表达式的匹配拆分此字符串。</li>
<li><code v-pre>String[] split(String regex, int limit)</code>：根据匹配给定的正则表达式来拆分此字符串，最多不超过limit个，如果超过了，剩下的全部都放到最后一个元素中。</li>
<li><code v-pre>String substring(int beginIndex)</code>：返回一个新的字符串，它是此字符串的从beginIndex开始截取到最后的一个子字符串。</li>
<li><code v-pre>String substring(int beginIndex, int endIndex)</code> ：返回一个新字符串，它是此字符串从beginIndex开始截取到endIndex(不包含)的一个子字符串。</li>
</ul>
</li>
<li>String 与 char[]之间的转换
<ul>
<li>String --&gt; char[]:调用String的toCharArray()</li>
<li>char[] --&gt; String:调用String的构造器</li>
</ul>
</li>
<li>String 与 byte[]之间的转换
<ul>
<li>编码：String --&gt; byte[]:调用String的getBytes()</li>
<li>解码：byte[] --&gt; String:调用String的构造器</li>
<li>解码时，要求解码使用的字符集必须与编码时使用的字符集一致，否则会出现乱码。</li>
</ul>
</li>
<li>String 与基本数据类型、包装类之间的转换。
<ul>
<li>String --&gt; 基本数据类型、包装类：调用包装类的静态方法：parseXxx(str)</li>
<li>基本数据类型、包装类 --&gt; String:调用String重载的valueOf(xxx)</li>
</ul>
</li>
</ol>
<ul>
<li>**注意：**由于字符串是不可变的，所以操作字符串的方法基本都有返回值，而原字符串不会发生改变。</li>
</ul>
<h4 id="_5-2-5-stringbuffer" tabindex="-1"><a class="header-anchor" href="#_5-2-5-stringbuffer" aria-hidden="true">#</a> 5.2.5 StringBuffer</h4>
<ol>
<li>特性：
<ul>
<li>可变的字符序列，对字符串进行增删，不会产生新的对象</li>
<li>作为参数传递时，方法内部可以改变值。</li>
</ul>
</li>
<li>构造器：
<ul>
<li><code v-pre>StringBuffer()</code>：初始容量为16的char型字符串数组</li>
<li><code v-pre>StringBuffer(int size)</code>：指定size容量的字符串</li>
<li><code v-pre>StringBuffer(String str)</code>：将内容初始化为指定字符串内容。</li>
</ul>
</li>
<li>常用方法：
<ul>
<li>增：<code v-pre>StringBuffer append(xxx)</code>：</li>
<li>删：<code v-pre>StringBuffer delete(int start,int end)</code>：</li>
<li>改：
<ul>
<li><code v-pre>StringBuffer replace(int start, int end, String str)</code>：</li>
<li><code v-pre>public void setCharAt(int n ,char ch)</code>：</li>
</ul>
</li>
<li>查：<code v-pre>public char charAt(int n)</code>：</li>
<li>插：<code v-pre>StringBuffer insert(int offset, xxx)</code>：</li>
<li>遍历：<code v-pre>for() + charAt()</code>或者<code v-pre>toString()</code></li>
<li>其他：
<ul>
<li><code v-pre>StringBuffer reverse()</code> ：把当前字符序列逆转</li>
<li><code v-pre>public int indexOf(String str)</code></li>
<li><code v-pre>public String substring(int start,int end)</code>:</li>
<li><code v-pre>public int length()</code>：</li>
</ul>
</li>
<li>注意点：返回值类型为StringBuffer的方法会对原数据进行修改，返回值类型为String类型的方法不会对元数据进行修改。
<ul>
<li>底层原理：StringBuffer的方法底层返回了this，既是对当前数据的返回，也表明支持链式操作</li>
</ul>
</li>
</ul>
</li>
</ol>
<h4 id="_5-2-6-stringbuilder" tabindex="-1"><a class="header-anchor" href="#_5-2-6-stringbuilder" aria-hidden="true">#</a> 5.2.6 StringBuilder</h4>
<ul>
<li>同StringBuffer，JDK5.0新增，只是线程不安全，效率优于StringBuffer。</li>
<li>开发中建议使用：<code v-pre>StringBuffer(int capacity)</code> 或 <code v-pre>StringBuilder(int capacity)</code>。</li>
</ul>
<h3 id="_5-3-时间api" tabindex="-1"><a class="header-anchor" href="#_5-3-时间api" aria-hidden="true">#</a> 5.3 时间API</h3>
<ol>
<li>JDK8之前：</li>
</ol>
<blockquote>
<ul>
<li>java.lang.System类：<code v-pre>currentTimeMillis()</code>，获取当前时间距离1970年1月1日0时0分0秒的毫秒数</li>
<li>java.util.Date类  ：
<ul>
<li>构造器：
<ul>
<li><code v-pre>Date()</code></li>
<li><code v-pre>Date(long date)</code></li>
</ul>
</li>
<li>方法：
<ul>
<li><code v-pre>getTime()</code>：获取当前时间距离1970年1月1日0时0分0秒的毫秒数</li>
<li><code v-pre>toString()</code>：【重写方法】按照down mon dd hh:mm:ss zzz yyy的格式输出
<ul>
<li>down：星期几</li>
<li>zzz：时间标准</li>
</ul>
</li>
</ul>
</li>
<li>java.sql.Date类：
<ul>
<li>java.util.Date类的子类</li>
<li>创建时使用全包名：即<code v-pre>new java.sql.Date()</code></li>
<li>相互转换：
<ul>
<li>方式一：创建Date对象的多态java.sql.Date对象；创建java.sql.Date对象，使用向上转型（强转）——注意：强转的前提是Date对象是由java.sql.Date创建的。</li>
<li>方式二：通过共有方法<code v-pre>getTime()</code>获取时间戳</li>
</ul>
</li>
</ul>
</li>
</ul>
</li>
<li>java.text.SimpleDataFormat类：
<ul>
<li>用于对Date类的格式化和解析</li>
<li>创建指定格式的对象：
<ul>
<li><code v-pre>SimpleDateFormat()</code>：默认格式</li>
<li><code v-pre>SimpleDateFormat(&quot;yyyy-MM-dd&quot;)</code>：指定格式</li>
</ul>
</li>
<li>格式化：将日期输出为字符串
<ul>
<li>调用<code v-pre>foramt(Date date)</code>方法：</li>
</ul>
</li>
<li>解析：将字符串转换为日期
<ul>
<li>调用<code v-pre>parse(String sourse)</code>方法：
<ul>
<li>这里sourse的格式必须与创建<code v-pre>SimpleDateFormat()</code>对象的格式一致</li>
<li>有异常问题</li>
</ul>
</li>
</ul>
</li>
</ul>
</li>
<li>java.util.Calendar(日历)类 ：
<ul>
<li>用于日期字段（fileld）间的相互操作
<ul>
<li>field：Calendar类的静态属性：YEAR、MONTH、DAY_OF_WEEK、HOUR_OF_DAY 、 MINUTE、SECOND</li>
</ul>
</li>
<li>获取Calendar实例：<code v-pre>Calendar calendar = Calendar.getInstance();</code>
<ul>
<li>Calendar时抽象类，无法实例化，调用静态方法<code v-pre>getInstance()</code>实际上会调用其子类<code v-pre>GregorianCalendar</code>创建对象。</li>
</ul>
</li>
<li>常用方法：
<ul>
<li><code v-pre>int get(int field,int value)</code></li>
<li><code v-pre>void set(int field,int value)</code></li>
<li><code v-pre>void add(int field,int amount)</code></li>
<li><code v-pre>Date getTime()</code>：日历类转换Date类</li>
<li><code v-pre>void setTime(Date date)</code>：Date类转换日历类</li>
</ul>
</li>
</ul>
</li>
</ul>
</blockquote>
<ol start="2">
<li>日期时间API的迭代：
<ul>
<li>第一代：jdk 1.0 Date类</li>
<li>第二代：jdk 1.1 Calendar类，一定程度上替换Date类</li>
<li>第三代：jdk 1.8 提出了新的一套API</li>
</ul>
</li>
<li>前两代存在的问题举例：
<ul>
<li>可变性：像日期和时间这样的类应该是不可变的。</li>
<li>偏移性：Date中的年份是从1900开始的，而月份都从0开始。</li>
<li>格式化：格式化只对Date用，Calendar则不行。</li>
<li>此外，它们也不是线程安全的；不能处理闰秒等。</li>
</ul>
</li>
<li>JDK8新增API
<ul>
<li>java.time – 包含值对象的基础包</li>
<li>java.time.chrono – 提供对不同的日历系统的访问</li>
<li>java.time.format – 格式化和解析时间和日期</li>
<li>java.time.temporal – 包括底层框架和扩展特性</li>
<li>java.time.zone – 包含时区支持的类</li>
</ul>
</li>
<li>JDK8新增时间类（构造方法私有的，不能实例化）：
<ul>
<li>LocalDate：获取ISO格式（yyyy-MM-dd)的日期</li>
<li>LocalTime：获取时间</li>
<li>LocalDateTime：获取日期和时间</li>
<li>常用方法：
<ul>
<li><code v-pre>now()</code>（静态方法）：获取当前的日期、时间、日期+时间，创建类对象</li>
<li><code v-pre>of()</code>：设置指定的年、月、日、时、分、秒。没有偏移量</li>
<li><code v-pre>getXxx()</code>：获取相关的属性</li>
<li><code v-pre>withXxx()</code>：设置相关的属性</li>
</ul>
</li>
<li>Instant（类似于Calendar，不可实例化)：
<ul>
<li><code v-pre>now()</code>（静态方法）：获取本初子午线对应的标准时间。<code v-pre>Instant instant = Instant.now()</code></li>
<li><code v-pre>atOffset()</code>：添加时间的偏移量</li>
<li><code v-pre>toEpochMilli()</code>：获取自1970年1月1日0时0分0秒（UTC）开始的毫秒数</li>
<li><code v-pre>ofEpochMilli()</code>：通过给定的毫秒数，获取Instant实例</li>
</ul>
</li>
<li>DateTimeFormatter：格式化或解析日期、时间
<ul>
<li>预定义的标准格式：
<ul>
<li><code v-pre>DateTimeFormatter.ISO_LOCAL_DATE_TIME</code></li>
<li><code v-pre>DateTimeFormatter.ISO_LOCAL_DATE</code></li>
<li><code v-pre>DateTimeFormatter.ISO_LOCAL_TIME</code></li>
</ul>
</li>
<li>本地化相关格式：
<ul>
<li><code v-pre>DateTimeFormatter._ofLocalizedDateTime_(FFormatStyle.LONG / FormatStyle.MEDIUM / FormatStyle.SHORT)</code></li>
<li><code v-pre>DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL / FormatStyle.LONG / FormatStyle.MEDIUM / FormatStyle.SHORT)</code></li>
</ul>
</li>
<li>自定义格式：
<ul>
<li><code v-pre>DateTimeFormatter._ofPattern_(&quot;yyyy-MM-dd hh:mm:ss&quot;)</code></li>
</ul>
</li>
<li>格式化：<code v-pre>时间格式.format(时间)</code>，返回字符串</li>
<li>解析：<code v-pre>时间格式.parse(符合时间格式的字符串)</code>，返回TemporalAccessor类型日期</li>
</ul>
</li>
</ul>
</li>
</ol>
<h3 id="_5-4-其他类" tabindex="-1"><a class="header-anchor" href="#_5-4-其他类" aria-hidden="true">#</a> 5.4 其他类</h3>
<ol>
<li>Math类：
<ul>
<li>常用方法：
<ul>
<li><code v-pre>double floor(double a)</code>：——向坐标轴左侧取整，如1.2、1.6得1.0；-1.2、-1.6得-2.0。</li>
<li><code v-pre>int round(double a)</code>：——本质是<code v-pre>(int)Math.floor(a + 0.5f)</code>。
<ul>
<li>正数四舍五入；负数不可记按正数四舍五入加负号，因为<code v-pre>round(-1.5)</code>得-1</li>
</ul>
</li>
</ul>
</li>
</ul>
</li>
<li>System类
<ul>
<li>构造器是private的，无法创建该类的对象，内部的成员变量和成员方法都是static的，可以直接进行调用。</li>
<li>方法：
<ul>
<li><code v-pre>native long currentTimeMillis()</code></li>
<li><code v-pre>void exit(int status)</code>：退出当前程序
<ul>
<li>status：0表示正常状态。</li>
</ul>
</li>
<li><code v-pre>arrayCopy()</code>：
<ul>
<li>参数1：源数组</li>
<li>参数2：源数组开始索引（包含）</li>
<li>参数3：目标数组</li>
<li>参数4：目标数组位置开始索引（包含）</li>
<li>参数5：源数组拷贝数量</li>
</ul>
</li>
<li><code v-pre>void gc()</code></li>
<li><code v-pre>String getProperty(String key)</code></li>
</ul>
</li>
</ul>
</li>
<li>BigInteger类
<ul>
<li>BigInteger可以表示不可变的任意精度的整数</li>
<li>不能使用<code v-pre>+、-、*、/</code>，需要使用相应的方法。</li>
</ul>
</li>
<li>BigDecimal类</li>
<li>Array类：
<ul>
<li><code v-pre>toString()</code>：重写Object方法，默认调用，输出数组元素
<ul>
<li>对象数组时，输出的时数组内每个对象的地址，如果还要显示每个对象的内容，就需要重写类的toString方法。</li>
</ul>
</li>
<li><code v-pre>sort()</code>：默认从小到大排序</li>
<li><code v-pre>binarySearch()</code>：通过二分法查找指定数，返回索引，要求必须排好序，无序数组不能使用。如果不存在，返回<code v-pre>-(low+1)</code></li>
<li><code v-pre>copyOf()</code>：拷贝指定数量的数组元素。
<ul>
<li>新数组比就数组长，最后几位为null</li>
<li>拷贝长度小于0，抛出异常，等于0，新数组为空</li>
</ul>
</li>
<li><code v-pre>fill()</code>：替换数组的全部元素</li>
<li><code v-pre>equals()</code>：比较数组元素是否一致</li>
<li><code v-pre>asList()</code>：将括号内数据转换为List集合。</li>
</ul>
</li>
<li>Scanner类：
<ul>
<li><code v-pre>next()</code>：接收数据，输入空格、回车、英文引号表示结束</li>
</ul>
</li>
</ol>
<h3 id="_5-5-比较器" tabindex="-1"><a class="header-anchor" href="#_5-5-比较器" aria-hidden="true">#</a> 5.5 比较器</h3>
<ol>
<li>作用：比较两个对象，用于对象数组排序。</li>
<li>自然排序：
<ul>
<li><code v-pre>java.lang.Comparable</code>包中的<code v-pre>Comparable</code>接口</li>
<li>String、包装类等实现了Comparable接口，重写了compareTo(obj)方法，给出了比较两个对象大小的方式。</li>
<li>像String、包装类重写compareTo()方法以后，进行了从小到大的排列</li>
<li>重写compareTo(obj)的规则：
<ul>
<li>如果当前对象this大于形参对象obj，则返回正整数</li>
<li>如果当前对象this小于形参对象obj，则返回负整数</li>
<li>如果当前对象this等于形参对象obj，则返回零</li>
</ul>
</li>
<li>对于自定义类来说，如果需要排序，可以让自定义类实现Comparable接口，重写compareTo(obj)方法。在compareTo(obj)方法中指明如何排序</li>
</ul>
</li>
<li>定制排序：
<ul>
<li>当元素的类型没实现java.lang.Comparable接口而又不方便修改代码，或者实现了java.lang.Comparable接口的排序规则不适合当前的操作，那么可以考虑使用 匿名的Comparator 的对象来排序</li>
<li>重写compare(Object o1,Object o2)方法，比较o1和o2的大小：
<ul>
<li>如果方法返回正整数，则表示o1大于o2；</li>
<li>如果返回0，表示相等；</li>
<li>返回负整数，表示o1小于o2。</li>
</ul>
</li>
</ul>
</li>
<li>补充：
<ul>
<li>包装类具有<code v-pre>compare</code>、<code v-pre>compareTo</code>两个方法，其中<code v-pre>compareTo</code>是静态方法。</li>
<li>String具有<code v-pre>compareTo</code>、<code v-pre>conpareToIngoreCase</code>方法</li>
</ul>
</li>
<li>比较：
<ul>
<li>Comparable 位于 java.lang 包， Comparator 位于java.util 包。</li>
<li>实现Comparable接口需要重写compareTo()方法，实现Comparator方法需要重写compare()方法，这两个方法的类型都是int</li>
<li>Comparable是排序接口，相当于内部比较器，称为自然排序，Comparator是比较器，相当于外部比较器，称为比较器排序，外部比较器可以对内部比较器进行扩充。</li>
<li>int test = s1.compareTo(s2); result = 0 , 则 s1=s2 ; result &lt; 0, 则 s1 0 , 则 s1 &gt; s2 。</li>
<li>int test= compare(T o1, T o2); 结果同上。 （若是 o2-o1，则反之。）</li>
<li>如果对象的排序需要基于自然顺序，使用 Comparable比较合适，如果需要按照对象的不同属性进行排序，使用 Comparator比较合适。</li>
</ul>
</li>
</ol>
<h2 id="第6章-枚举和注解" tabindex="-1"><a class="header-anchor" href="#第6章-枚举和注解" aria-hidden="true">#</a> 第6章 枚举和注解</h2>
<h3 id="_6-1-枚举类型" tabindex="-1"><a class="header-anchor" href="#_6-1-枚举类型" aria-hidden="true">#</a> 6.1 枚举类型</h3>
<h4 id="_6-1-1-枚举的概念" tabindex="-1"><a class="header-anchor" href="#_6-1-1-枚举的概念" aria-hidden="true">#</a> 6.1.1 枚举的概念</h4>
<ol>
<li>enumeration、enum</li>
<li>一组常量类型的集合。</li>
<li>是一种特殊的类，只包含有限的特定的对象，与Object并列</li>
<li>特点：
<ul>
<li>属性不允许被改动：属性使用private final修饰、且不设置setter</li>
<li>为了能够初始化属性，使用构造器传参的方式，在构造器内赋值。</li>
<li>在枚举类内创建实例。</li>
</ul>
</li>
</ol>
<h4 id="_6-1-2-枚举类型的实现" tabindex="-1"><a class="header-anchor" href="#_6-1-2-枚举类型的实现" aria-hidden="true">#</a> 6.1.2 枚举类型的实现</h4>
<ol>
<li>
<p>自定义类（JDK1.5之前）：</p>
<ul>
<li>私有化属性，只配置getter，不配置seter：防止属性被修改
<ul>
<li>private final修饰</li>
</ul>
</li>
<li>私有化构造器：防止new
<ul>
<li>private修饰</li>
</ul>
</li>
<li>在类内部，创建公开的枚举对象
<ul>
<li>命名规范：属性名使用大写形式</li>
<li>对象使用public static final修饰，进行底层优化
<ul>
<li>三个可省略任意多个</li>
</ul>
</li>
</ul>
</li>
</ul>
</li>
<li>
<p>enum关键字（JDK1.5之后）：</p>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token keyword">enum</span> <span class="token class-name">Season</span><span class="token punctuation">{</span>
   <span class="token function">SPRING</span><span class="token punctuation">(</span><span class="token string">"春天"</span><span class="token punctuation">,</span> <span class="token string">"温暖"</span>）<span class="token punctuation">,</span> <span class="token function">SUMMER</span><span class="token punctuation">(</span><span class="token string">"夏天"</span><span class="token punctuation">,</span> <span class="token string">"炎热"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
   <span class="token keyword">private</span> <span class="token class-name">String</span> name<span class="token punctuation">;</span>
   <span class="token keyword">private</span> <span class="token class-name">String</span> desc<span class="token punctuation">;</span>
   <span class="token keyword">private</span> <span class="token class-name">Season</span><span class="token punctuation">(</span><span class="token class-name">String</span> name<span class="token punctuation">,</span> <span class="token class-name">String</span> desc<span class="token punctuation">)</span><span class="token punctuation">{</span>
         <span class="token keyword">this</span><span class="token punctuation">.</span>name <span class="token operator">=</span> name<span class="token punctuation">;</span>
         <span class="token keyword">this</span><span class="token punctuation">.</span>desc <span class="token operator">=</span> desc<span class="token punctuation">;</span>
   <span class="token punctuation">}</span>
   nam getter<span class="token punctuation">;</span>
   desc getter<span class="token punctuation">;</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div></li>
<li>
<p>使用enum关键字的注意点：</p>
<ul>
<li>枚举类：
<ul>
<li>枚举类前默认有final关键字，所以枚举类不能被继承
<ul>
<li>final的特性导致</li>
</ul>
</li>
<li>默认继承自java.lang.Enum类，所以也不能继承其他类</li>
</ul>
</li>
<li>枚举对象：
<ul>
<li>实例化的枚举类对象必须声明在枚举类的首行</li>
<li>实例化的枚举类对象必须与构造器的参数对应，且枚举对象必须传入参数</li>
<li>实例化的枚举对象前默认有public static final，可以省略任意多个</li>
</ul>
</li>
<li>构造器：
<ul>
<li>使用无参构造器实例化枚举类对象时，枚举对象的括号可以省略</li>
<li>构造器默认使用private修饰，可以省略</li>
</ul>
</li>
<li>属性：
<ul>
<li>默认使用private final修饰，可以省略</li>
</ul>
</li>
</ul>
</li>
</ol>
<h4 id="_6-1-3-常用方法" tabindex="-1"><a class="header-anchor" href="#_6-1-3-常用方法" aria-hidden="true">#</a> 6.1.3 常用方法</h4>
<ol>
<li>enum声明的类会隐式继承Enum类，因此可以使用Enum中的相关方法：
<ul>
<li><code v-pre>toString()</code>：返回当前对象名，声明enum类时可重写，用于返回类中的属性内容</li>
<li><code v-pre>name()</code>：返回当前对象名，不能重写。
<ul>
<li>有限使用<code v-pre>toString()</code></li>
</ul>
</li>
<li><code v-pre>ordinal()</code>：返回当前对象的位置号，从0开始</li>
<li><code v-pre>values()</code>：返回当前枚举类中的所有实例化对象，返回一个enum声明的枚举类型数组</li>
<li><code v-pre>valueOf()</code>：返回指定字符串的实例化对象，如果传入的字符串枚举类中没有，会报错
<ul>
<li>传入的字符串名称要跟实例化对象名一致</li>
</ul>
</li>
<li><code v-pre>compareTo()</code>：比较两个枚举常量的位置编号，返回常量值。
<ul>
<li>调用的 - 参数的</li>
</ul>
</li>
</ul>
</li>
</ol>
<h4 id="_6-1-4-enum实现接口" tabindex="-1"><a class="header-anchor" href="#_6-1-4-enum实现接口" aria-hidden="true">#</a> 6.1.4 enum实现接口</h4>
<ol>
<li>语法：<code v-pre>enum 类名 implements 接口 1，接口 2{}</code></li>
</ol>
<h4 id="_6-1-5-枚举配合switch-case" tabindex="-1"><a class="header-anchor" href="#_6-1-5-枚举配合switch-case" aria-hidden="true">#</a> 6.1.5 枚举配合switch-case</h4>
<ol>
<li>switch()中传入一个枚举对象，case后是枚举对象的值</li>
</ol>
<h3 id="_6-2-注解-anotation" tabindex="-1"><a class="header-anchor" href="#_6-2-注解-anotation" aria-hidden="true">#</a> 6.2 注解（Anotation）</h3>
<h4 id="_6-2-1-概念" tabindex="-1"><a class="header-anchor" href="#_6-2-1-概念" aria-hidden="true">#</a> 6.2.1 概念</h4>
<ol>
<li>含义：又称为元数据（Meatdata），用于修饰解释包、类、方法、属性、构造器、局部变量等数据信息。</li>
<li>特点：和注释一样，不影响程序运行，但注解可以被编译或运行，相当于嵌入代码的补充信息。</li>
<li>功能：
<ul>
<li>javase中，注解主要用于标记过时功能、忽略警告等</li>
<li>Javaee中，可以用于配置应用程序的任何切面，代替旧版javaee中的繁冗代码和XML配置</li>
</ul>
</li>
</ol>
<h4 id="_6-2-2-常见类型及基本使用" tabindex="-1"><a class="header-anchor" href="#_6-2-2-常见类型及基本使用" aria-hidden="true">#</a> 6.2.2 常见类型及基本使用</h4>
<ol>
<li><code v-pre>@Override</code>：方法前使用，表示重写父类方法
<ul>
<li>只能用在方法前。</li>
<li>重写的方法前不写该注解不影响编译运行</li>
<li>如果写了该注解，程序在编译阶段检查是否真正重写。
<ul>
<li>非重写时会报错。</li>
</ul>
</li>
</ul>
</li>
<li><code v-pre>@Deprecated</code>：表示程序元素（类、方法等）已过时。
<ul>
<li>可以用在类、方法（构造器）、变量（成员变量、局部变量）、包等</li>
<li>用于新旧版本的兼容和过渡</li>
</ul>
</li>
<li><code v-pre>@SuppressWarnings()</code>：抑制编译器警告
<ul>
<li>可以用在类、方法（构造器）、变量（成员变量、局部变量）、包等
<ul>
<li>主要用在方法、类前</li>
</ul>
</li>
<li><code v-pre>()</code>：传入字符串值，表示抑制的警告类型
<ul>
<li>多种类型时，可以传入数组字面量<code v-pre>{}</code></li>
</ul>
</li>
<li>作用范围与书写位置有关</li>
</ul>
</li>
</ol>
<blockquote>
<p>@SuppressWarning 中的属性介绍以及属性说明</p>
<ul>
<li>all，抑制所有警告</li>
<li>boxing，抑制与封装/拆装作业相关的警告</li>
<li>cast，抑制与强制转型作业相关的警告</li>
<li>dep-ann，抑制与淘汰注释相关的警告</li>
<li>deprecation，抑制与淘汰的相关警告</li>
<li>fallthrough，抑制与switch陈述式中遗漏break相关的警告</li>
<li>finally，抑制与未传回finally区块相关的警告</li>
<li>hiding，抑制与隐藏变数的区域变数相关的警告</li>
<li>incomplete-switch，抑制与switch陈述式(enum case)中遗漏项目相关的警告</li>
<li>javadoc，抑制与javadoc相关的警告</li>
<li>nls，抑制与非nls字串文字相关的警告</li>
<li>null，抑制与空值分析相关的警告</li>
<li>rawtypes，抑制与使用raw类型相关的警告</li>
<li>resource，抑制与使用Closeable类型的资源相关的警告</li>
<li>restriction，抑制与使用不建议或禁止参照相关的警告</li>
<li>serial，抑制与可序列化的类别遗漏serialVersionUID栏位相关的警告</li>
<li>static-access，抑制与静态存取不正确相关的警告</li>
<li>static-method，抑制与可能宣告为static的方法相关的警告</li>
<li>super，抑制与置换方法相关但不含super呼叫的警告</li>
<li>synthetic-access，抑制与内部类别的存取未最佳化相关的警告</li>
<li>sync-override，抑制因为置换同步方法而遗漏同步化的警告</li>
<li>unchecked，抑制与未检查的作业相关的警告</li>
<li>unqualified-field-access，抑制与栏位存取不合格相关的警告</li>
<li>unused，抑制与未用的程式码及停用的程式码相关的警告</li>
</ul>
</blockquote>
<ol start="4">
<li>源码中<code v-pre>@interface xxx</code>表示xxx是一个注解类。</li>
<li>元注解：修饰其他注解的注解
<ul>
<li><code v-pre>@Retention(RetentionPolicy.xxx)</code>：指定注解的作用时机
<ul>
<li>SOURCE：只在源码中显示，编译后丢弃这种注解策略</li>
<li>CLASS：在字节码文件中显示，运行时不会保留。是注解的默认值。</li>
<li>RUNTIME：运行时仍然保留，可以通过反射获取该注解</li>
</ul>
</li>
<li><code v-pre>@Target(ElementType.xxx)</code>：指定注解用于修饰哪些元素。
<ul>
<li>作用时机是RUNTIME</li>
<li>只能用于修饰注解</li>
</ul>
</li>
<li><code v-pre>@Documented</code>：被修饰的注解会在生成文档注释时保留。
<ul>
<li>作用时机时RUNTIME</li>
</ul>
</li>
<li><code v-pre>@Inherited</code>：被修饰的注解具有继承性，子类自动具有该注解</li>
</ul>
</li>
<li>与文档相关的注解：</li>
</ol>
<blockquote>
<ul>
<li>@author 标明开发该类模块的作者，多个作者之间使用,分割</li>
<li>@version 标明该类模块的版本</li>
<li>@see 参考转向，也就是相关主题</li>
<li>@since 从哪个版本开始增加的</li>
<li>@param 对方法中某参数的说明，如果没有参数就不能写</li>
<li>标记方法</li>
<li>可以并列多个</li>
<li>@return 对方法返回值的说明，如果方法的返回值类型是void就不能写</li>
<li>标记方法</li>
<li>格式要求：@return 返回值类型 返回值说明</li>
<li>@exception 对方法可能抛出的异常进行说明 ，如果方法没有用throws显式抛出的异常就不能写</li>
<li>标记方法</li>
<li>格式要求：@exception 异常类型 异常说明</li>
<li>可以并列多个</li>
</ul>
</blockquote>
<ol start="7">
<li><code v-pre>@WebServle()</code>：</li>
<li><code v-pre>@Transactional(propagation=Propagation.REQUIRES_NEW, isolation=Isolation.READ_COMMITTED,readOnly=false,timeout=3)</code>：</li>
</ol>
<h4 id="_6-3-3-自定义注解" tabindex="-1"><a class="header-anchor" href="#_6-3-3-自定义注解" aria-hidden="true">#</a> 6.3.3 自定义注解</h4>
<div class="custom-container warning"><p class="custom-container-title">注意</p>
<ul>
<li>自定义注解使用@interface 关键字声明</li>
<li>自定义注解自动继承了java.lang.annotation.Annotation接口</li>
<li>自定义注解的成员变量以无参数方法的形式来声明。方法名和返回值类型称为配置参数。返回值类型只能是八种基本数据类型、String类型、Class类型、enum类型、Annotation类型、 及以上所有类型的数组。</li>
<li>自定义注解的成员变量声明时可使用 default 关键字指定初始值
<ul>
<li>如果只有一个参数成员，通常使用value</li>
</ul>
</li>
<li>使用自定义注解时，如果定义注解时声明了成员变量（配置参数），那么使用时必须指定参数值，除非它有默认 值。格式是“参数名 = 参数值” ，如果只有一个参数成员，且名称为value， 可以省略“value=”</li>
<li>自定义注解通过都会指明两个元注解：Retention、Target</li>
</ul>
</div>
<p><img src="/images/javase/java-1/image-1660367481422.png" alt="image.png" loading="lazy"></p>
<h2 id="第7章-异常处理" tabindex="-1"><a class="header-anchor" href="#第7章-异常处理" aria-hidden="true">#</a> 第7章 异常处理</h2>
<h3 id="_7-1-异常理解" tabindex="-1"><a class="header-anchor" href="#_7-1-异常理解" aria-hidden="true">#</a> 7.1 异常理解</h3>
<ol>
<li>概念：程序运行过程中发生的不正常情况。</li>
</ol>
<h3 id="_7-2-异常的体系结构" tabindex="-1"><a class="header-anchor" href="#_7-2-异常的体系结构" aria-hidden="true">#</a> 7.2 异常的体系结构</h3>
<ol>
<li>Error：Java虚拟机无法解决的严重问题。一般不做处理。
<ul>
<li>StackOverflowError：栈溢出</li>
<li>OutOfMemoryError（OOM）：堆溢出</li>
</ul>
</li>
<li>Exception：
<ul>
<li>编译时异常：</li>
<li>运行时异常：
java.lang.Throwabe&gt; java.lang.Throwable</li>
</ul>
</li>
</ol>
<blockquote>
<pre><code>|-----java.lang.Error:一般不编写针对性的代码进行处理。
</code></pre>
<p>|-----java.lang.Exception:可以进行异常的处理
|------编译时异常(checked)
|-----IOException
|-----FileNotFoundException
|-----ClassNotFoundException
|------运行时异常(unchecked,RuntimeException)
|-----NullPointerException：空指针异常
|-----ArrayIndexOutOfBoundsException：数组下标越界
|-----ClassCastException：类型不匹配
|-----NumberFormatException：数字格式错误
|-----InputMismatchException：输入不匹配
|-----ArithmeticException：运算错误</p>
</blockquote>
<h3 id="_7-3-异常处理机制" tabindex="-1"><a class="header-anchor" href="#_7-3-异常处理机制" aria-hidden="true">#</a> 7.3 异常处理机制</h3>
<h4 id="_7-3-1-抓抛模型" tabindex="-1"><a class="header-anchor" href="#_7-3-1-抓抛模型" aria-hidden="true">#</a> 7.3.1 抓抛模型</h4>
<ul>
<li>&quot;抛&quot;：程序执行的过程中，一旦出现异常，就会在异常代码处生成一个对应异常类的对象，并会将此对象抛出给调用它的方法，直到main方法，如果main方法没能处理，则程序运行终止，发生异常位置后面的代码也不会执行。
<ul>
<li>异常产生有两种形式：一是系统自动产生，二是手动生成并抛出（throw）</li>
</ul>
</li>
<li>&quot;抓&quot;：即异常的处理方式：
<ul>
<li>try-catch-finally</li>
<li>throws</li>
</ul>
</li>
</ul>
<h4 id="_7-3-2-try-catch-finally" tabindex="-1"><a class="header-anchor" href="#_7-3-2-try-catch-finally" aria-hidden="true">#</a> 7.3.2 try-catch-finally</h4>
<ol>
<li>
<p>语法：</p>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token keyword">try</span><span class="token punctuation">{</span>
   <span class="token punctuation">.</span><span class="token punctuation">.</span><span class="token punctuation">.</span><span class="token punctuation">.</span><span class="token punctuation">.</span><span class="token punctuation">.</span> <span class="token comment">//可能产生异常的代码</span>
   <span class="token punctuation">}</span>
   <span class="token keyword">catch</span><span class="token punctuation">(</span> <span class="token class-name">ExceptionName1</span> e <span class="token punctuation">)</span><span class="token punctuation">{</span>
   <span class="token punctuation">.</span><span class="token punctuation">.</span><span class="token punctuation">.</span><span class="token punctuation">.</span><span class="token punctuation">.</span><span class="token punctuation">.</span> <span class="token comment">//当产生ExceptionName1型异常时的处置措施</span>
   <span class="token punctuation">}</span>
   <span class="token keyword">catch</span><span class="token punctuation">(</span> <span class="token class-name">ExceptionName2</span> e <span class="token punctuation">)</span><span class="token punctuation">{</span>
   <span class="token punctuation">.</span><span class="token punctuation">.</span><span class="token punctuation">.</span><span class="token punctuation">.</span><span class="token punctuation">.</span><span class="token punctuation">.</span> <span class="token comment">//当产生ExceptionName2型异常时的处置措施</span>
   <span class="token punctuation">}</span>
   <span class="token punctuation">[</span> <span class="token keyword">finally</span><span class="token punctuation">{</span>
   <span class="token punctuation">.</span><span class="token punctuation">.</span><span class="token punctuation">.</span><span class="token punctuation">.</span><span class="token punctuation">.</span><span class="token punctuation">.</span> <span class="token comment">//无论是否发生异常，都无条件执行的语句</span>
<span class="token punctuation">}</span> <span class="token punctuation">]</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ul>
<li>try不能单独使用</li>
<li>catch和finally是可选的。
<ul>
<li>try-finally：没有catch语句，相当于捕获到了异常但没有处置，会先输出finally中的语句，再报异常，程序也会中止。</li>
<li>try-catch-finally：先报异常，再输出finally语句，程序不会中止</li>
</ul>
</li>
<li>在try结构中声明的变量，出了try结构以后，就不能再被调用</li>
<li>try-catch-finally结构可以嵌套</li>
</ul>
</li>
<li>
<p>使用：IDE快捷键： 选中-&gt;ctrl + alt + t</p>
</li>
<li>
<p>执行流程：</p>
<ul>
<li>如果异常没有发生，则顺序执行try的代码块，不会进入到catch。</li>
<li>如果异常发生了，则异常发生后try块中的代码不会执行，直接进入到catch块。执行完catch块后再执行try-catch语句后的代码。</li>
<li>如果希望不管是否发生异常，都执行某段代码(比如关闭连接，释放资源等)则使用finally
<ul>
<li>即使try、catch语句里有return（正常情况return结束方法），执行完之后仍然会执行finally中的语句，再返回结束方法。但当finally中有return语句，则不再执行try或catch的return。</li>
</ul>
</li>
<li>可以使用多个catch分别捕获不同的异常，要求子类异常写在前面，父类异常写在后面
<ul>
<li>try中有多个异常，且父类一致（如Exception），如果catch只匹配父类，则只捕获第一个异常，try中后面的代码（所有代码）不会被执行</li>
<li>try中有多个异常，catch匹配多个异常，但只捕获第一个异常，try块中后面的代码（所有代码）不会被执行，异常也不会捕获到</li>
</ul>
</li>
</ul>
</li>
<li>
<p>常用的异常对象处理的方式：</p>
<ul>
<li>getMessage() ：打印异常信息</li>
<li>printStackTrace()： 获取异常类名和异常信息，以及异常出现在程序中的位置。返回值void。</li>
</ul>
</li>
</ol>
<h4 id="_7-3-3-throws-异常类型" tabindex="-1"><a class="header-anchor" href="#_7-3-3-throws-异常类型" aria-hidden="true">#</a> 7.3.3 throws + 异常类型</h4>
<ol>
<li>&quot;throws + 异常类型&quot;写在方法的声明处，指明此方法执行时，可能会抛出的异常类型。
<ul>
<li>抛出多个异常使用<code v-pre>,</code>分隔</li>
</ul>
</li>
<li>一旦当方法体执行时，出现异常，仍会在异常代码处生成一个异常类的对象，此对象满足throws后异常类型时，就会被抛出。不满足则相当于异常没有处理。异常代码后续的代码，就不再执行！</li>
<li>throws的方式只是将异常抛给了方法的调用者。并没有真正将异常处理掉，方法调用者再抛出时，异常类型要不小于接收到的异常类型。</li>
<li>运行异常的默认处理方式为throws，可不处理，编译异常没有默认处理方式，必须处理</li>
<li>子类重写父类的方法时，对抛出异常的规定:子类重写的方法，抛出的异常类型要么和父类抛出的异常一致，要么为父类抛出的异常类型的子类型</li>
<li>在throws 过程中，如果有方法 try-catch , 就相当于处理异常，就可以不必throws</li>
</ol>
<h3 id="_7-4-try-catch-finally和throws的选择" tabindex="-1"><a class="header-anchor" href="#_7-4-try-catch-finally和throws的选择" aria-hidden="true">#</a> 7.4 try-catch-finally和throws的选择</h3>
<ol>
<li>拥有继承关系的父子类，如果父类中被重写的方法没有throws方式处理异常，则子类重写的方法也不能使用throws，意味着如果子类重写的方法中有异常，必须使用try-catch-finally方式处理。</li>
<li>执行的方法a中，先后又调用了另外的几个方法，这几个方法是递进关系执行的。建议这几个方法使用throws的方式进行处理。而执行的方法a可以考虑使用try-catch-finally方式进行处理。</li>
</ol>
<h3 id="_7-5-手动抛出异常" tabindex="-1"><a class="header-anchor" href="#_7-5-手动抛出异常" aria-hidden="true">#</a> 7.5 手动抛出异常</h3>
<ol>
<li>在可能发生异常的位置生成异常类对象，然后通过throw语句实现抛出操作</li>
<li>可以抛出的异常必须是Throwable或其子类的实例，否则会报错。</li>
</ol>
<h3 id="_7-6自定义异常类" tabindex="-1"><a class="header-anchor" href="#_7-6自定义异常类" aria-hidden="true">#</a> 7.6自定义异常类</h3>
<ol>
<li>继承于现有的异常结构：RuntimeException 、Exception
<ul>
<li>继承exception时为编译异常</li>
<li>一般使用RuntimeException，且需要方法再thows异常</li>
</ul>
</li>
<li>提供全局常量（static final修饰）：serialVersionUID</li>
<li>提供重载的构造器，传入<code v-pre>String msg</code>参数</li>
<li>构造器内执行<code v-pre>super(msg);</code></li>
</ol>
</div></template>
