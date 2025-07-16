<template><div><h1 id="mysql" tabindex="-1"><a class="header-anchor" href="#mysql" aria-hidden="true">#</a> MySQL</h1>
<h3 id="_1-数据库操作" tabindex="-1"><a class="header-anchor" href="#_1-数据库操作" aria-hidden="true">#</a> 1. 数据库操作</h3>
<blockquote>
<ul>
<li>使用图形化界面书写sql语句可以不要分号。</li>
<li>使用终端书写sql语句必须要写分号。</li>
<li>sql语句不区分大小写（Windows）环境下。</li>
</ul>
</blockquote>
<h4 id="_1-1-创建数据库" tabindex="-1"><a class="header-anchor" href="#_1-1-创建数据库" aria-hidden="true">#</a> 1.1 创建数据库</h4>
<ol>
<li><code v-pre>CREATE DATABASE [IF NOT EXISTS] db_name [CHARSET xxx COLLATE xxx ……]</code>
<ul>
<li><code v-pre>[IF NOT EXISTS]</code>（可选）：不写时数据库已存在则报错</li>
<li><code v-pre>[CHARSET xxx]</code>（可选）：指定数据库字符集，默认uft8</li>
<li><code v-pre>[COLLATE xxx]</code>（可选）：指定数据库字符集校对规则，默认utf8_general_ci，不区分大小写。
<ul>
<li>utf8_bin：区分大小写</li>
</ul>
</li>
<li>表不指定字符集及字符集校对规则时，按照数据库规则执行。</li>
<li>db_name与关键字冲突时，可采用反引号包裹。</li>
</ul>
</li>
</ol>
<p><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1655551947949-b5543859-8fa2-4a30-8929-7c25adc23e60.png#clientId=ud20487ba-4ed4-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=546&amp;id=u38c60454&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=683&amp;originWidth=860&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=58613&amp;status=done&amp;style=none&amp;taskId=u0375bb5c-d1f5-4367-8c7b-3049dcc738d&amp;title=&amp;width=688" alt="image.png" loading="lazy"></p>
<ul>
<li>我的默认字符集怎么不对？</li>
</ul>
<div class="custom-container danger"><p class="custom-container-title">警告</p>
<ul>
<li>那是因为msql5.7版本默认的字符集为拉丁文</li>
<li>在mysql命令模式下查看编码：<code v-pre>show variables like 'character_%'</code></li>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1655809639667-097fbace-a7e0-438f-a156-adf413cb44dc.png#clientId=u9f958873-dea0-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=261&amp;id=ud0f24f27&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=261&amp;originWidth=806&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=23104&amp;status=done&amp;style=none&amp;taskId=uf9343dd3-4ada-4e27-b750-355fb819e55&amp;title=&amp;width=806" alt="image.png" loading="lazy"></li>
<li>查看比较规则：<code v-pre>show variables like 'collation_%';</code></li>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1655809716341-c6c1835d-84dc-4fca-8e9c-8795d667f076.png#clientId=u9f958873-dea0-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=108&amp;id=ue5171d90&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=154&amp;originWidth=460&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=11220&amp;status=done&amp;style=none&amp;taskId=ud5e20eba-763f-44d8-a9d1-fb045ce30e2&amp;title=&amp;width=323" alt="image.png" loading="lazy"></li>
<li>修改mysql5.7配置文件：<code v-pre>C:\ProgramData\MySQL\MySQL Server 5.7.37\my.ini</code></li>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1655809884263-3fe35e1a-b7b4-4158-a04a-4fca1b66f783.png#clientId=u9f958873-dea0-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=60&amp;id=u151f16fa&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=104&amp;originWidth=441&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=8840&amp;status=done&amp;style=none&amp;taskId=ue514db7a-67ed-4850-a496-679f2eadbd0&amp;title=&amp;width=256" alt="image.png" loading="lazy">
<ul>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1655809960705-df066e1c-de92-487d-9220-365d26d525ae.png#clientId=u9f958873-dea0-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=64&amp;id=u42031050&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=98&amp;originWidth=342&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=8020&amp;status=done&amp;style=none&amp;taskId=u5e3ada03-1dbc-4335-b932-e1bab744f54&amp;title=&amp;width=223" alt="image.png" loading="lazy"></li>
</ul>
</li>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1655809946347-57bfd092-edc4-4ca5-bc43-a7db8ccb4e1d.png#clientId=u9f958873-dea0-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=172&amp;id=uddcba523&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=373&amp;originWidth=613&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=64528&amp;status=done&amp;style=none&amp;taskId=u0af97158-ad6a-4c79-9700-b89e42a07fd&amp;title=&amp;width=283" alt="image.png" loading="lazy">
<ul>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1655809998830-acb2bd41-28ef-419d-8d3f-fd63574090c1.png#clientId=u9f958873-dea0-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=156&amp;id=u215ba79b&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=403&amp;originWidth=730&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=72103&amp;status=done&amp;style=none&amp;taskId=u7a56cf56-f185-47a7-9196-342da87ddb0&amp;title=&amp;width=282" alt="image.png" loading="lazy"></li>
</ul>
</li>
<li>配置完后需要重新启动mysql服务</li>
</ul>
</div>
<h4 id="_1-2-查看、删除数据库" tabindex="-1"><a class="header-anchor" href="#_1-2-查看、删除数据库" aria-hidden="true">#</a> 1.2 查看、删除数据库</h4>
<ol>
<li>显示数据库：<code v-pre>SHOW DATABASES</code>，查看当前数据库服务器中的所有数据库</li>
<li>显示数据库的创建信息：<code v-pre>SHOW CREATE DATABASE db_name</code>
<ul>
<li>例：<code v-pre>CREATE DATABASE</code>db01<code v-pre>/*!40100 DEFAULT CHARACTER SET latin1 */</code></li>
<li>例：<code v-pre>CREATE DATABASE</code>db03<code v-pre>/*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */</code></li>
</ul>
</li>
<li>删除数据库：<code v-pre>DROP DATABSE db_name</code></li>
</ol>
<h4 id="_1-3-备份、恢复数据库" tabindex="-1"><a class="header-anchor" href="#_1-3-备份、恢复数据库" aria-hidden="true">#</a> 1.3 备份、恢复数据库</h4>
<ol>
<li>备份数据库：
<ul>
<li>（DOS命令下）<code v-pre>mysqldump -h 主机名 -P 端口号 -u 用户名 -p -B 数据库1 数据库2 &gt; 文件绝对路径\文件名.sql</code>
<ul>
<li>省略规则同开启mysql服务。</li>
<li>备份表：<code v-pre>mysqldump -h 主机名 -P 端口号 -u 用户名 -p 数据库 表1 表2 &gt; 文件绝对路径\文件名.sql</code></li>
</ul>
</li>
</ul>
</li>
<li>恢复数据库：
<ul>
<li>方式一：（mysql环境下）<code v-pre>source 文件绝对路径\文件名.sql</code></li>
<li>方式二：（图形界面下）
<ul>
<li>文本模式打开要恢复的数据库文件，拷贝至图形化界面的查询语句输入区，点击运行</li>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1655623850229-cda84fc5-4e72-4c90-a9f0-31673ffa3c7f.png#clientId=ud20487ba-4ed4-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=814&amp;id=ud9ee2643&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=1017&amp;originWidth=1920&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=142438&amp;status=done&amp;style=none&amp;taskId=u88e6c749-9571-401e-af44-dcd1270d017&amp;title=&amp;width=1536" alt="image.png" loading="lazy"></li>
</ul>
</li>
</ul>
</li>
<li>安装（导入）数据库：方式同恢复数据库。</li>
</ol>
<h3 id="_2-表-结构-操作" tabindex="-1"><a class="header-anchor" href="#_2-表-结构-操作" aria-hidden="true">#</a> 2. 表（结构）操作</h3>
<h4 id="_2-1-创建表" tabindex="-1"><a class="header-anchor" href="#_2-1-创建表" aria-hidden="true">#</a> 2.1 创建表</h4>
<div class="language-sql ext-sql line-numbers-mode"><pre v-pre class="language-sql"><code><span class="token keyword">CREATE</span> <span class="token keyword">TABLE</span> table_name
<span class="token punctuation">(</span>
  field1 datatype<span class="token punctuation">,</span>
  field2 datatype<span class="token punctuation">,</span>
  field3 datatype<span class="token punctuation">,</span>
<span class="token punctuation">)</span><span class="token keyword">character</span> <span class="token keyword">set</span> 字符集 <span class="token keyword">collate</span> 校对规则 <span class="token keyword">engine</span> 存储引擎<span class="token punctuation">;</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ul>
<li>character、collate、engine为可选内容</li>
<li>character set与charset等价</li>
<li>存储引擎默认为INNODB</li>
<li><code v-pre>CREATE TABLE table_name1 LIKE table_name2;</code>将table_name2的结构复制到table_name1。</li>
</ul>
<h4 id="_2-2-删除表" tabindex="-1"><a class="header-anchor" href="#_2-2-删除表" aria-hidden="true">#</a> 2.2 删除表</h4>
<ul>
<li><code v-pre>DROP TABLE table_name</code></li>
</ul>
<h4 id="_2-3-备份、恢复表" tabindex="-1"><a class="header-anchor" href="#_2-3-备份、恢复表" aria-hidden="true">#</a> 2.3 备份、恢复表</h4>
<ul>
<li>备份表：<code v-pre>mysqldump -h 主机名 -P 端口号 -u 用户名 -p 数据库 表1 表2 &gt; 文件绝对路径\文件名.sql</code></li>
<li>恢复表：同数据库恢复操作</li>
</ul>
<h4 id="_2-4-修改表" tabindex="-1"><a class="header-anchor" href="#_2-4-修改表" aria-hidden="true">#</a> 2.4 修改表</h4>
<ol>
<li>添加列：<code v-pre>ALTER TABLE table_name ADD (column datatype [NOT NULL DEFAULT 'XXX']) AFTER TARGETCOLUMN;</code>
<ul>
<li>在目标列<code v-pre>TARGETCOLUMN</code>后添加指定列，目标列可以大写，也可以小写。</li>
<li>可以一次添加多列（使用<code v-pre>()</code>包裹），添加一列时，可以不使用括号。</li>
<li>不指定添加在哪一列后面时，默认添加到最后一列</li>
</ul>
</li>
<li>修改列：<code v-pre>ALTER TABLE table_name MODIFY(TARGETCOLUMN datatype [NOT NULL DEFAULT 'XXX']);</code></li>
<li>删除列：<code v-pre>ALTER TABLE table_name MODIFY(TARGETCOLUMN）</code></li>
<li>修改表名：<code v-pre>RENAME table_name TO new_name;</code></li>
<li>显示表结构（查看表的所有列）：<code v-pre>DESC table_name;</code></li>
<li>修改表字符集：<code v-pre>ALTER TABLE table_name CHARSET utf8</code></li>
<li>修改列名：<code v-pre>ALTER TABLE table_name CHANGE 旧名 新名 datatype</code></li>
<li>修改表存储引擎：<code v-pre>ALETER TABLE table_name ENGINE = 引擎类型</code></li>
</ol>
<h3 id="_3-常用数据类型-列类型" tabindex="-1"><a class="header-anchor" href="#_3-常用数据类型-列类型" aria-hidden="true">#</a> 3. 常用数据类型（列类型）</h3>
<p><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1655625944752-87f31c5e-3946-4489-8b94-477577d4b2bb.png#clientId=ud20487ba-4ed4-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=311&amp;id=uf530b382&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=651&amp;originWidth=1277&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=1046755&amp;status=done&amp;style=none&amp;taskId=ue6186fce-d114-464c-9431-ee8748c811f&amp;title=&amp;width=609.2000122070312" alt="image.png" loading="lazy">
<a href="https://www.yuque.com/attachments/yuque/0/2022/mmap/1604140/1655627087671-30b49822-daac-4a2f-982a-8228a2f3a11c.mmap" target="_blank" rel="noopener noreferrer">MySQL数据类型.mmap<ExternalLinkIcon/></a></p>
<h4 id="_3-1-数值型" tabindex="-1"><a class="header-anchor" href="#_3-1-数值型" aria-hidden="true">#</a> 3.1 数值型</h4>
<ol>
<li>使用原则：满足要求情况下，尽量选择占用空间小的。</li>
<li>整数型：
<ul>
<li>指定数据类型时，如果未指定unsinged，则为有符号范围，指定unsigned时，为无符号范围。</li>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1655627179048-1143d987-bf03-4246-8972-a77579f8ac46.png#clientId=ud20487ba-4ed4-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=246&amp;id=u6d68222a&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=356&amp;originWidth=574&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=215668&amp;status=done&amp;style=none&amp;taskId=u856dec7b-cdb9-498b-9760-e4a318a438d&amp;title=&amp;width=396.20001220703125" alt="image.png" loading="lazy"></li>
</ul>
</li>
<li>bit(m)：
<ul>
<li>m在1～64范围内，表示字节值在0～2^m-1范围内的二进制数
<ul>
<li>如：m为8时，表示这个数的字节最大有8位，即11111111（255）。</li>
</ul>
</li>
<li>显示bit时，按照二进制数显示。</li>
<li>m默认为1。</li>
<li>均为无符号数。</li>
</ul>
</li>
<li>小数型：
<ul>
<li>指定数据类型时，如果未指定unsinged，则为有符号范围，指定unsigned时，为无符号范围。</li>
<li>DECIMAL(M, D)：
<ul>
<li>M表示小数位数（精度），最大65，省略时默认为10。</li>
<li>D表示小数点后位数（标度），最大30，省略时默认为0（代表整数）。</li>
</ul>
</li>
</ul>
</li>
</ol>
<h4 id="_3-2-字符型" tabindex="-1"><a class="header-anchor" href="#_3-2-字符型" aria-hidden="true">#</a> 3.2 字符型</h4>
<ol>
<li>内容使用单引号<code v-pre>''</code>包裹</li>
<li>char(m)：固定长度字符串，m表示占用内存空间，最大为255，m表示指定的字符数。</li>
<li>varchar(m)：可变长度字符串，0～65535字节，m表示指定的字符数。
<ul>
<li>m具体表示的字符位数与表设置的编码有关：
<ul>
<li>utf8：（65535-3）/3=21844</li>
<li>gbk：（65535-3）/2=32766</li>
</ul>
</li>
</ul>
</li>
<li>使用细节：
<ul>
<li>char和varchar指定空间后，存入的数据字符长度不能超过指定的空间大小。</li>
<li>char为固定长度，指定空间后数据必然占用m个字符的空间。</li>
<li>varchar为可变长度，即使指定空间，实际的占用空间与字符编码有关。</li>
<li>char查询速度大于varchar</li>
</ul>
</li>
<li>text：存放文本数据时，可以使用，有0～65535字节。
<ul>
<li>mediumtext：0～2^24-1</li>
<li>longtext：0～2^32-1</li>
<li>text不能有默认值</li>
<li>实际占用与字符编码有关</li>
</ul>
</li>
</ol>
<h4 id="_3-3-日期类型" tabindex="-1"><a class="header-anchor" href="#_3-3-日期类型" aria-hidden="true">#</a> 3.3 日期类型</h4>
<div class="language-sql ext-sql line-numbers-mode"><pre v-pre class="language-sql"><code><span class="token keyword">CREATE</span> <span class="token keyword">TABLE</span> table_name
<span class="token punctuation">(</span>
  field1 <span class="token keyword">DATE</span><span class="token punctuation">,</span>
  field2 <span class="token keyword">DATETIME</span><span class="token punctuation">,</span>
  field3 <span class="token keyword">TIMESTAMP</span><span class="token punctuation">,</span>
<span class="token punctuation">)</span><span class="token keyword">character</span> <span class="token keyword">set</span> 字符集 <span class="token keyword">collate</span> 校对规则 <span class="token keyword">engine</span> 存储引擎<span class="token punctuation">;</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ul>
<li>TIMESTAMP：作为时间戳使用时，需要进行配置，即在TIMESTAMP后增加<code v-pre>NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP</code></li>
</ul>
<h3 id="_4-crud-表中数据操作" tabindex="-1"><a class="header-anchor" href="#_4-crud-表中数据操作" aria-hidden="true">#</a> 4. CRUD（表中数据操作）</h3>
<h4 id="_4-1-insert语句——添加数据" tabindex="-1"><a class="header-anchor" href="#_4-1-insert语句——添加数据" aria-hidden="true">#</a> 4.1 Insert语句——添加数据</h4>
<div class="language-sql ext-sql line-numbers-mode"><pre v-pre class="language-sql"><code><span class="token keyword">INSERT</span> <span class="token keyword">INTO</span> table_name <span class="token punctuation">[</span><span class="token keyword">column</span>……<span class="token punctuation">]</span>
  <span class="token keyword">VALUES</span> <span class="token punctuation">(</span>XXX……<span class="token punctuation">)</span><span class="token punctuation">;</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div></div></div><ul>
<li>添加的数据与字段类型须一致。
<ul>
<li><code v-pre>'34'</code>这种字符型会自动转换，也能添加到<code v-pre>int</code>类型的字段中</li>
</ul>
</li>
<li>数据长度不能超过字段设定的存储范围。</li>
<li>数据的添加数量、顺序须与字段的数量、顺序一致。</li>
<li>字符型和日期类型数据必须要用<code v-pre>''</code>包裹</li>
<li>字段可以插入空值<code v-pre>NULL</code>（前提是字段设置为允许为空）</li>
<li>多组数据需要使用<code v-pre>()</code>包裹，并用<code v-pre>,</code>隔开。</li>
<li>给表中所有字段添加数据，可以不写前面的字段名称。数据的数量与顺序须与表定义时的一致。</li>
<li>如果某个字段未指定为<code v-pre>NOT NULL</code>，添加数据时如果没有给值，则会默认为<code v-pre>null</code>。
<ul>
<li>如果需要设定有意义的默认值，则需要在定义表时，在字段声明后增加<code v-pre>NOT NULL DEAFULT 'XXX'</code></li>
</ul>
</li>
</ul>
<h5 id="_4-1-1复制表数据" tabindex="-1"><a class="header-anchor" href="#_4-1-1复制表数据" aria-hidden="true">#</a> 4.1.1复制表数据</h5>
<ol>
<li>从其他表拷贝数据：</li>
</ol>
<div class="language-sql ext-sql line-numbers-mode"><pre v-pre class="language-sql"><code><span class="token keyword">INSERT</span> <span class="token keyword">INTO</span> table_name1 <span class="token punctuation">(</span>col1<span class="token punctuation">,</span> col2<span class="token punctuation">,</span> col3<span class="token punctuation">)</span>
  <span class="token keyword">SELECT</span> col1<span class="token punctuation">,</span> col2<span class="token punctuation">,</span> col3 <span class="token keyword">FROM</span> table_name2<span class="token punctuation">;</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div></div></div><ul>
<li>如果table_name1和table_name2有一样的表结构，可以采用<code v-pre>INSERT INTO table_name1 SELECT * FROM table_name2;</code></li>
<li><code v-pre>INSERT INTO table_name1 SELECT DISTINCT * FROM table_name2;</code>可以去重。</li>
</ul>
<ol start="2">
<li>自我复制（蠕虫复制）</li>
</ol>
<div class="language-sql ext-sql line-numbers-mode"><pre v-pre class="language-sql"><code><span class="token keyword">INSERT</span> <span class="token keyword">INTO</span> table_name
  <span class="token keyword">SELECT</span> <span class="token operator">*</span> <span class="token keyword">FROM</span> table_name<span class="token punctuation">;</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div></div></div><ul>
<li>执行多次，可以创建<code v-pre>n×COUNT(*)</code>条数据。</li>
</ul>
<h4 id="_4-2-update语句——修改数据" tabindex="-1"><a class="header-anchor" href="#_4-2-update语句——修改数据" aria-hidden="true">#</a> 4.2 Update语句——修改数据</h4>
<div class="language-sql ext-sql line-numbers-mode"><pre v-pre class="language-sql"><code><span class="token keyword">UPDATE</span> table_name
  <span class="token keyword">SET</span> col_name <span class="token operator">=</span> expr<span class="token punctuation">[</span><span class="token punctuation">,</span>col_name <span class="token operator">=</span> expr……<span class="token punctuation">]</span>
  <span class="token punctuation">[</span><span class="token keyword">WHERE</span> col_name <span class="token operator">=</span> expr<span class="token punctuation">]</span><span class="token punctuation">;</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ul>
<li>不写WHERE语句时，表示将该字段的所有值都修改。</li>
</ul>
<h4 id="_4-3-delete语句——删除数据" tabindex="-1"><a class="header-anchor" href="#_4-3-delete语句——删除数据" aria-hidden="true">#</a> 4.3 Delete语句——删除数据</h4>
<div class="language-sql ext-sql line-numbers-mode"><pre v-pre class="language-sql"><code><span class="token keyword">DELETE</span> <span class="token keyword">from</span> table_name
  <span class="token punctuation">[</span><span class="token keyword">WHERE</span> col_name <span class="token operator">=</span> expr<span class="token punctuation">]</span><span class="token punctuation">;</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div></div></div><ul>
<li>不写WHERE语句时，表示清空表中数据。</li>
</ul>
<h4 id="_4-4-select语句——查询数据" tabindex="-1"><a class="header-anchor" href="#_4-4-select语句——查询数据" aria-hidden="true">#</a> 4.4 Select语句——查询数据</h4>
<div class="language-sql ext-sql line-numbers-mode"><pre v-pre class="language-sql"><code><span class="token keyword">SELECT</span> <span class="token punctuation">[</span><span class="token keyword">DISTINCT</span><span class="token punctuation">]</span> <span class="token operator">*</span> <span class="token operator">|</span> col1<span class="token punctuation">,</span>col2
  <span class="token keyword">FROM</span> table_name<span class="token punctuation">;</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div></div></div><ul>
<li>查询为<code v-pre>*</code>时，显示表中所有数据。（查看表）</li>
<li>查询为<code v-pre>col</code>时，显示该列（字段）</li>
<li>查询时如有<code v-pre>DISTINCT</code>，显示的时候会去重。
<ul>
<li>distinct也可用于字段col前</li>
</ul>
</li>
<li>查询内容可以书写表达式进行计算
<ul>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1655688546790-131c2a4a-1fb2-4c1b-b449-88b8dbadcb0c.png#clientId=ubb6307e6-4f7d-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=68&amp;id=u8f8f8e69&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=113&amp;originWidth=881&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=116371&amp;status=done&amp;style=none&amp;taskId=u4f3c7df1-5b42-4e30-9071-bed662a3989&amp;title=&amp;width=533.2000122070312" alt="image.png" loading="lazy"></li>
</ul>
</li>
<li>设置别名：<code v-pre>AS</code>可以省略
<ul>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1655688592076-6e471460-d8ae-4d44-b6b8-de36cfb17c0a.png#clientId=ubb6307e6-4f7d-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=69&amp;id=ufc5ad5d6&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=136&amp;originWidth=1060&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=144112&amp;status=done&amp;style=none&amp;taskId=u62011166-a112-4998-bf9c-dc6535e20d9&amp;title=&amp;width=536.2000122070312" alt="image.png" loading="lazy"></li>
</ul>
</li>
<li><code v-pre>WHERE</code>子句过滤查询：
<ul>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1655688687383-05d63c50-4cd5-401b-a449-89e136a3c608.png#clientId=ubb6307e6-4f7d-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=244&amp;id=udc83c6c9&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=447&amp;originWidth=868&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=352343&amp;status=done&amp;style=none&amp;taskId=u3b5bbf1a-39f9-4309-9f41-a4c31f1b35d&amp;title=&amp;width=473.20001220703125" alt="image.png" loading="lazy">
<ul>
<li>不等于可以使用<code v-pre>&lt;&gt;</code>或<code v-pre>!=</code>两种方式。</li>
<li>BETWEEN AND是闭区间。</li>
</ul>
</li>
</ul>
</li>
<li><code v-pre>ORDER BY</code>排序查询：
<ul>
<li><code v-pre>ORDER BY col asc | desc, col asc | desc……</code>
<ul>
<li><code v-pre>asc</code>升序，默认为升序。</li>
<li><code v-pre>desc</code>降序</li>
</ul>
</li>
</ul>
</li>
<li><strong>基本语法（书写顺序）：</strong></li>
</ul>
<div class="language-sql ext-sql line-numbers-mode"><pre v-pre class="language-sql"><code><span class="token keyword">SELECT</span> col1<span class="token punctuation">,</span> col2<span class="token punctuation">,</span>…… <span class="token keyword">FROM</span> table_name
  <span class="token keyword">group</span> <span class="token keyword">by</span> col
  <span class="token keyword">having</span> condition
  <span class="token keyword">order</span> <span class="token keyword">by</span> col
  <span class="token keyword">limit</span> <span class="token keyword">start</span><span class="token punctuation">,</span> <span class="token keyword">rows</span><span class="token punctuation">;</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><h5 id="_4-4-1-查询加强" tabindex="-1"><a class="header-anchor" href="#_4-4-1-查询加强" aria-hidden="true">#</a> 4.4.1 查询加强</h5>
<ol>
<li>WHERE：
<ul>
<li>日期格式也可以使用<code v-pre>&gt; 、&lt;</code>等比较运算符，但是比较的日期格式须一致。</li>
</ul>
</li>
<li>LIKE：
<ul>
<li><code v-pre>%</code>表示0个或多个字符。</li>
<li><code v-pre>_</code>表示单个任意字符。</li>
</ul>
</li>
<li>分页查询：
<ul>
<li><code v-pre>limit start, rows</code>
<ul>
<li>从第start+1行开始，取出rows行，start取值范围从0开始</li>
<li>实际上为：<code v-pre>limit rows * (第几页 - 1)  , rows</code></li>
</ul>
</li>
</ul>
</li>
</ol>
<h3 id="_5-函数" tabindex="-1"><a class="header-anchor" href="#_5-函数" aria-hidden="true">#</a> 5. 函数</h3>
<h4 id="_5-1-合计-统计统计函数" tabindex="-1"><a class="header-anchor" href="#_5-1-合计-统计统计函数" aria-hidden="true">#</a> 5.1 合计/统计统计函数</h4>
<ol>
<li>count</li>
</ol>
<div class="language-sql ext-sql line-numbers-mode"><pre v-pre class="language-sql"><code><span class="token keyword">SELECT</span> <span class="token function">COUNT</span><span class="token punctuation">(</span><span class="token operator">*</span><span class="token punctuation">)</span> <span class="token operator">|</span> <span class="token function">COUNT</span><span class="token punctuation">(</span>col1<span class="token punctuation">)</span><span class="token punctuation">,</span> <span class="token function">COUNT</span><span class="token punctuation">(</span>col2<span class="token punctuation">)</span>
  <span class="token keyword">FROM</span> table_name
  <span class="token punctuation">[</span><span class="token keyword">WHERE</span> where_defined<span class="token punctuation">;</span><span class="token punctuation">]</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ul>
<li><code v-pre>COUNT(*)</code>和<code v-pre>COUNT(col)</code>的区别是<code v-pre>COUT(col)</code>会排除为null的情况</li>
<li><code v-pre>COUNT()</code>会统计非空（null及<code v-pre>&quot;&quot;</code>）的情况</li>
</ul>
<ol start="2">
<li>sum</li>
</ol>
<div class="language-sql ext-sql line-numbers-mode"><pre v-pre class="language-sql"><code><span class="token keyword">SELECT</span> <span class="token function">sum</span><span class="token punctuation">(</span>col1<span class="token punctuation">)</span><span class="token punctuation">,</span> <span class="token function">sum</span><span class="token punctuation">(</span>col2<span class="token punctuation">)</span>……
  <span class="token keyword">FROM</span> table_name
  <span class="token punctuation">[</span><span class="token keyword">WHERE</span> where_defined<span class="token punctuation">;</span><span class="token punctuation">]</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ul>
<li>作用：统计表中符合条件的数据的和。</li>
<li>仅对数值起作用，用在其他数据类型会报错。</li>
</ul>
<ol start="3">
<li>avg</li>
</ol>
<div class="language-sql ext-sql line-numbers-mode"><pre v-pre class="language-sql"><code><span class="token keyword">SELECT</span> <span class="token function">avg</span><span class="token punctuation">(</span>col1<span class="token punctuation">)</span><span class="token punctuation">,</span> <span class="token function">sum</span><span class="token punctuation">(</span>col2<span class="token punctuation">)</span>……
  <span class="token keyword">FROM</span> table_name
  <span class="token punctuation">[</span><span class="token keyword">WHERE</span> where_defined<span class="token punctuation">;</span><span class="token punctuation">]</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ul>
<li>作用：统计表中符合条件的数据的平均值。</li>
<li>仅对数值起作用，用在其他数据类型会报错。</li>
</ul>
<ol start="4">
<li>max/min</li>
</ol>
<div class="language-sql ext-sql line-numbers-mode"><pre v-pre class="language-sql"><code><span class="token keyword">SELECT</span> <span class="token function">max</span><span class="token punctuation">(</span>col1<span class="token punctuation">)</span><span class="token punctuation">,</span> <span class="token function">min</span><span class="token punctuation">(</span>col2<span class="token punctuation">)</span>……
  <span class="token keyword">FROM</span> table_name
  <span class="token punctuation">[</span><span class="token keyword">WHERE</span> where_defined<span class="token punctuation">;</span><span class="token punctuation">]</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ul>
<li>作用：统计表中符合条件的数据的最大值/最小值。</li>
<li>仅对数值起作用，用在其他数据类型会报错。</li>
</ul>
<h4 id="_5-2-分组" tabindex="-1"><a class="header-anchor" href="#_5-2-分组" aria-hidden="true">#</a> 5.2 分组</h4>
<ol>
<li>group by——分组显示</li>
</ol>
<div class="language-sql ext-sql line-numbers-mode"><pre v-pre class="language-sql"><code><span class="token keyword">SELECT</span> 查询要求<span class="token punctuation">,</span> 列
  <span class="token keyword">FROM</span> table_name
  <span class="token keyword">GROUP</span> <span class="token keyword">BY</span> col
  <span class="token punctuation">[</span><span class="token keyword">WHERE</span> where_defined<span class="token punctuation">;</span><span class="token punctuation">]</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ul>
<li>按照<code v-pre>table_name</code>中的<code v-pre>col</code>列进行分组显示，会忽略col中的空值。</li>
</ul>
<ol start="2">
<li>having——分组后过滤</li>
</ol>
<div class="language-sql ext-sql line-numbers-mode"><pre v-pre class="language-sql"><code><span class="token keyword">SELECT</span> 查询要求<span class="token punctuation">,</span> 列
  <span class="token keyword">FROM</span> table_name
  <span class="token keyword">GROUP</span> <span class="token keyword">BY</span> col <span class="token keyword">HAVING</span> 过滤条件<span class="token punctuation">;</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ul>
<li>过滤条件可以是函数。</li>
</ul>
<h4 id="_5-3-字符串" tabindex="-1"><a class="header-anchor" href="#_5-3-字符串" aria-hidden="true">#</a> 5.3 字符串</h4>
<p><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1655692935016-08d96a64-f1f4-4f33-9e1b-bc3dd2aa9ed0.png#clientId=ubb6307e6-4f7d-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=243&amp;id=u65ca6dc4&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=463&amp;originWidth=939&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=383772&amp;status=done&amp;style=none&amp;taskId=u218f58ea-695f-48ab-8ab2-236578ee9c6&amp;title=&amp;width=492.20001220703125" alt="image.png" loading="lazy"></p>
<ul>
<li><code v-pre>MySQL</code>中字符串的index是从1开始的。</li>
<li><code v-pre>STRCAMP</code>比较字符串大小时，是否区分大小写与数据库的查询编码有关。</li>
</ul>
<h4 id="_5-4-数学函数" tabindex="-1"><a class="header-anchor" href="#_5-4-数学函数" aria-hidden="true">#</a> 5.4 数学函数</h4>
<p><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1655699331185-e748c21c-6e8a-4b01-8e89-020659796a7f.png#clientId=ubb6307e6-4f7d-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=257&amp;id=u90cb8405&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=460&amp;originWidth=871&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=279000&amp;status=done&amp;style=none&amp;taskId=ucc0cceea-fcca-4e87-ab6e-364f662056f&amp;title=&amp;width=487.20001220703125" alt="image.png" loading="lazy"></p>
<ul>
<li>seed为任意的整数参数，作为参数传入<code v-pre>RAND()</code>时，表示生成的随机数第一次生成后不再变化</li>
</ul>
<h4 id="_5-5-日期函数" tabindex="-1"><a class="header-anchor" href="#_5-5-日期函数" aria-hidden="true">#</a> 5.5 日期函数</h4>
<p><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1655700829579-66e73e22-3d10-424b-9791-53028e9062cd.png#clientId=ubb6307e6-4f7d-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=210&amp;id=u7bd2bf55&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=459&amp;originWidth=949&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=339221&amp;status=done&amp;style=none&amp;taskId=u76a7c3d5-fd38-4263-86f5-eef4b6d2ddb&amp;title=&amp;width=434.20001220703125" alt="image.png" loading="lazy"></p>
<ul>
<li><code v-pre>DATE_ADD()</code>、<code v-pre>DATE_SUB()</code>中的<code v-pre>INTERVAL</code>后面可以是year、month、day、hour、minute、second</li>
<li><code v-pre>YEAR|MONTH|DATE(datetime)</code>：返回指定datetime的年、月、日</li>
<li><code v-pre>UNIX_TIMESTAMP()</code>：返回距离1970-1-1的秒数。</li>
<li><code v-pre>FROM_UNIXTIME(unix_timestamp(), '时间格式')</code>：将一个unix_timestamp()的秒数，转换为年月日时分秒.
<ul>
<li>时间格式：
<ul>
<li><code v-pre>%Y-%m-%d %H:%i:%s</code></li>
<li><code v-pre>%Y-%m-%d</code></li>
</ul>
</li>
</ul>
</li>
</ul>
<h4 id="_5-6-加密函数" tabindex="-1"><a class="header-anchor" href="#_5-6-加密函数" aria-hidden="true">#</a> 5.6 加密函数</h4>
<ol>
<li><code v-pre>USER()</code>：显示当前mysql服务的登录用户。格式为：user@IP地址</li>
<li><code v-pre>DATABASE()</code>：显示当前使用的数据库名称</li>
<li><code v-pre>MD5(str)</code>：为str计算一个32位的MD5字符串。
<ul>
<li>应用场景：用户的密码使用md5加密</li>
</ul>
</li>
<li><code v-pre>password(str)</code>：另一种加密方式。</li>
</ol>
<h4 id="_5-7-流程控制" tabindex="-1"><a class="header-anchor" href="#_5-7-流程控制" aria-hidden="true">#</a> 5.7 流程控制</h4>
<ol>
<li><code v-pre>if(expr1, expr2, expr3)</code>：如果expr1为true，返回expr2，否则返回expr3</li>
<li><code v-pre>ifnull(expr1, expr2)</code>：如果expr1为空，返回expr2，否则返回expr1</li>
<li>多重分支：</li>
</ol>
<div class="language-sql ext-sql line-numbers-mode"><pre v-pre class="language-sql"><code><span class="token keyword">SELECT</span> <span class="token keyword">CASE</span>
  <span class="token keyword">WHEN</span> expr1 <span class="token keyword">THEN</span> expr2
  <span class="token keyword">WHEN</span> expr3 <span class="token keyword">THEN</span> expr4
  <span class="token keyword">ELSE</span> expr5
  <span class="token keyword">END</span><span class="token punctuation">;</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ul>
<li>如果expr1为true，则返回expr2</li>
<li>如果expr3为true，则返回expr4</li>
<li>否则返回expr5</li>
</ul>
<h3 id="_6-多表查询" tabindex="-1"><a class="header-anchor" href="#_6-多表查询" aria-hidden="true">#</a> 6. 多表查询</h3>
<h4 id="_6-1-笛卡尔积" tabindex="-1"><a class="header-anchor" href="#_6-1-笛卡尔积" aria-hidden="true">#</a> 6.1 笛卡尔积</h4>
<ol>
<li><code v-pre>SELECT * FROM table1, table2</code>：
<ul>
<li>该种情况下，会取出table1的每一行与table2的每一行组合进行显示，显示的行数为table1的行数×table2的行数，称为笛卡尔集</li>
<li>table1和table2共有的col，要指定该列作为查询内容时，需要使用<code v-pre>table1.col</code>的方式指定是哪个表的col列，否则会报错。</li>
<li>多表查询的条件（WHERE）不能少于表的个数-1，否则会出现笛卡尔积。</li>
</ul>
</li>
</ol>
<h4 id="_6-2-自连接" tabindex="-1"><a class="header-anchor" href="#_6-2-自连接" aria-hidden="true">#</a> 6.2 自连接</h4>
<ol>
<li>含义：在同一个表查询该表内的多个数据进行显示。</li>
<li>原理：给表起个别名，把它当成多个表，然后用<code v-pre>别名.col</code>指定多个查询列，进行多表查询
<ul>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1656034785648-7c57e9a3-8ddd-4f8b-83e0-60801b45a983.png#clientId=u41d7c6a8-95c2-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=85&amp;id=cnOm2&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=85&amp;originWidth=442&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=21420&amp;status=done&amp;style=none&amp;taskId=u70baf46d-3ec4-40dd-9053-26cc20b9a1a&amp;title=&amp;width=442" alt="image.png" loading="lazy"></li>
<li>这里只有emp一个表，给表起了个worker和boss两个名字</li>
</ul>
</li>
<li>特点：
<ul>
<li>把同一张表当作两张表使用</li>
<li>需要给表取别名，as可用也可不用</li>
<li>可以给查询的列取别名。</li>
</ul>
</li>
</ol>
<h4 id="_6-3-合并查询" tabindex="-1"><a class="header-anchor" href="#_6-3-合并查询" aria-hidden="true">#</a> 6.3 合并查询</h4>
<ol>
<li>作用：合并多条SELECT单表查询语句的结果，进行多行显示。</li>
<li>语法：<code v-pre>SELECT …… FROM …… WHERE …… UNION | UNION ALL SELECT …… FROM …… WHERE ……</code></li>
<li><code v-pre>UNION</code>：查询结果不会去重。</li>
<li><code v-pre>UNION ALL</code>：查询结果会去重。</li>
</ol>
<h4 id="_6-4-外连接" tabindex="-1"><a class="header-anchor" href="#_6-4-外连接" aria-hidden="true">#</a> 6.4 外连接</h4>
<ol>
<li>出现背景：笛卡尔积筛选的数据会根据关联条件匹配，如果关联条件一个表有，另一个表没有，那么就会匹配不上，就不会显示该条数据。
<ul>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1656034955869-5bcc2525-7aee-43d4-8e4f-5a66acfa799c.png#clientId=u41d7c6a8-95c2-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=85&amp;id=u537a4c38&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=85&amp;originWidth=218&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=9397&amp;status=done&amp;style=none&amp;taskId=u4a9a2089-b07e-46a9-9a8a-0b1ea5937b7&amp;title=&amp;width=218" alt="image.png" loading="lazy"></li>
</ul>
</li>
<li>左外连接：左侧表完全显示。
<ul>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1656034993812-3f0ae7fe-6340-45bc-add4-2fbbd562c3ff.png#clientId=u41d7c6a8-95c2-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=85&amp;id=u6331c139&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=85&amp;originWidth=218&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=12280&amp;status=done&amp;style=none&amp;taskId=ubdd4a8ca-5002-47c6-9f9f-b27c0efaeaf&amp;title=&amp;width=218" alt="image.png" loading="lazy"></li>
</ul>
</li>
<li>右外连接：右侧表完全显示。
<ul>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1656035011791-0c5a9aeb-291e-4389-994b-c4c03528dd18.png#clientId=u41d7c6a8-95c2-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=88&amp;id=u71451ef6&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=88&amp;originWidth=240&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=10278&amp;status=done&amp;style=none&amp;taskId=u5d68156d-512f-463c-af07-28a0d3a6e67&amp;title=&amp;width=240" alt="image.png" loading="lazy"></li>
</ul>
</li>
</ol>
<h3 id="_7-子查询" tabindex="-1"><a class="header-anchor" href="#_7-子查询" aria-hidden="true">#</a> 7. 子查询</h3>
<ul>
<li>嵌入在其他sql语句中的select语句，也叫嵌套查询。</li>
</ul>
<h4 id="_7-1-单行子查询" tabindex="-1"><a class="header-anchor" href="#_7-1-单行子查询" aria-hidden="true">#</a> 7.1 单行子查询</h4>
<ul>
<li>查询只返回一行数据的子查询语句。</li>
<li><code v-pre>WHERE col = (SELECT子句)</code></li>
</ul>
<h4 id="_7-2-多行子查询" tabindex="-1"><a class="header-anchor" href="#_7-2-多行子查询" aria-hidden="true">#</a> 7.2 多行子查询</h4>
<ul>
<li>查询返回多行数据的子查询。</li>
<li><code v-pre>WHERE col IN (SELECT子句)</code></li>
</ul>
<h4 id="_7-3-all和any关键字" tabindex="-1"><a class="header-anchor" href="#_7-3-all和any关键字" aria-hidden="true">#</a> 7.3 ALL和ANY关键字</h4>
<ul>
<li><code v-pre>all</code>：</li>
<li><code v-pre>any</code>：</li>
<li>用在<code v-pre>WHERE</code>子句中，子查询语句包裹在<code v-pre>all()</code>或<code v-pre>any()</code>中。</li>
</ul>
<h4 id="_7-4-多列子查询" tabindex="-1"><a class="header-anchor" href="#_7-4-多列子查询" aria-hidden="true">#</a> 7.4 多列子查询</h4>
<ul>
<li>查询返回多个列数据的子查询语句。</li>
<li><code v-pre>WHERE(col1, col2) = (SELECT子句)</code></li>
</ul>
<h4 id="_7-5-子查询当作临时表" tabindex="-1"><a class="header-anchor" href="#_7-5-子查询当作临时表" aria-hidden="true">#</a> 7.5 子查询当作临时表</h4>
<ul>
<li>将子查询结果当作一个表，再使用多表查询的方式查询。</li>
</ul>
<h3 id="_8-约束" tabindex="-1"><a class="header-anchor" href="#_8-约束" aria-hidden="true">#</a> 8. 约束</h3>
<ol>
<li>作用：确保数据库的数据满足特定的商业规则。</li>
<li>种类：not null、unique、primary key、foreign key、check五种。</li>
<li>primary key：用于标示该字段的数据不能重复
<ul>
<li>定义位置：
<ul>
<li>第一种：创建表时datatype后声明<code v-pre>PRIMAY KEY</code>。</li>
<li>第二种：所有字段声明完的<code v-pre>)</code>前写上<code v-pre>PRIMAY KEY(col1, col2)</code></li>
<li>第三种：<code v-pre>ALTER TABLE table_name ADD PRIMARY KEY (id)</code></li>
</ul>
</li>
<li>使用细节：
<ul>
<li>不能重复且不能为空（不需要显式地声明not null）</li>
<li>一张表最多只能有一个主键，但可以是复合主键（只能用第二种定义位置的方式）。</li>
</ul>
</li>
</ul>
</li>
<li>not null：用于标示该字段插入数据时必须提供数据。
<ul>
<li>定义位置：
<ul>
<li>创建表时datatype后声明<code v-pre>NOT NULL</code>。</li>
</ul>
</li>
<li>使用细节：
<ul>
<li>一般配合<code v-pre>DEFAULT</code>给该字段设定默认初始值——<code v-pre>NOT NULL DEAFULT</code>。</li>
</ul>
</li>
</ul>
</li>
<li>unique：用于标示该字段的值不能重复
<ul>
<li>定义位置：
<ul>
<li>创建表时datatype后声明<code v-pre>UNIQUE</code>。</li>
</ul>
</li>
<li>使用细节：
<ul>
<li>如果该字段没有声明为<code v-pre>NOT NULL</code>，那么声明为<code v-pre>UNIQUE</code>的字段可以有多个null</li>
<li>一张表可以有多个unique字段</li>
</ul>
</li>
</ul>
</li>
<li>foreign key：用于定义主表与从表的关系。
<ul>
<li>定义位置：
<ul>
<li>创建从表时所有字段声明完的<code v-pre>)</code>前写上<code v-pre>FOREIGN KEY(外键名) REFERENCES 主表(主键列)</code>。</li>
</ul>
</li>
<li>使用细节：
<ul>
<li>外键定义在从表上，主表必须有<code v-pre>PRIMAY KEY</code>或<code v-pre>UNIQUE</code>约束。</li>
<li>从表定义外键后，从表该字段的值必须在主表的主键列存在，或者从表该字段为null。
<ul>
<li>前提是从表的该外键字段没有设置<code v-pre>NOT NULL</code></li>
</ul>
</li>
<li>一旦建立主外键关系，数据就不能随意删除。</li>
<li>只有表类型设置为<code v-pre>innodb</code>，才支持外键。</li>
<li>外键字段的类型与主键的字段类型须一直，但长度可以不同。</li>
</ul>
</li>
</ul>
</li>
<li>check：用于插入数据时检验是否满足设定要求。
<ul>
<li>定义位置：
<ul>
<li>创建表时datatype后声明<code v-pre>CHECK(检验条件)</code>。</li>
</ul>
</li>
<li>使用细节：
<ul>
<li>oracle和sql server均支持check，但mysql5.7还不支持check，只做语法校验，但不会生效。</li>
</ul>
</li>
</ul>
</li>
<li>自增长：用于在插入数据时，自动更新数据并插入。
<ul>
<li>定义位置：
<ul>
<li>创建表时datatype后声明<code v-pre>AUTO_INCREMENT</code>。</li>
</ul>
</li>
<li>使用细节：
<ul>
<li>自增长一般配合<code v-pre>PRIMAY KEY</code>使用，也可以配合<code v-pre>UNIQUE</code>使用。
<ul>
<li>但不能两个约束键一个也没有。</li>
</ul>
</li>
<li>自增长修饰的字段一般为整数型，极少情况使用小数型。</li>
<li>自增长默认从1开始，可以通过<code v-pre>ALTER TABLE table_name AUTO_INCREMENT = 新的开始值;</code>进行修改。插入的第一条数据的值为设定的新开的开始值。
<ul>
<li>也可以通过显式赋值的方式给自增长字段设定新值，但一般不这样操作。</li>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1656037394194-04b67dee-896f-4c2a-8332-ebff7f9797ea.png#clientId=u41d7c6a8-95c2-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=55&amp;id=uf3c426b7&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=55&amp;originWidth=268&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=9315&amp;status=done&amp;style=none&amp;taskId=u2a833173-9413-4928-89f7-f406f4ecbab&amp;title=&amp;width=268" alt="image.png" loading="lazy"></li>
</ul>
</li>
<li>自增长的后续值，按照表内最新的值开始，或者修改后的自增长值开始。</li>
</ul>
</li>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1656037085732-67b5477c-4855-41f5-b80a-bbf296790946.png#clientId=u41d7c6a8-95c2-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=92&amp;id=ucd4d7c62&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=92&amp;originWidth=542&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=86429&amp;status=done&amp;style=none&amp;taskId=u8b9e0093-b84e-4b9a-862c-2712aebcd99&amp;title=&amp;width=542" alt="image.png" loading="lazy">
<ul>
<li>这里设定了字段1为自增长字段。</li>
</ul>
</li>
</ul>
</li>
</ol>
<h3 id="_9-索引" tabindex="-1"><a class="header-anchor" href="#_9-索引" aria-hidden="true">#</a> 9. 索引</h3>
<ol>
<li>作用：提高数据库的性能，在不增加内存、不修改程序、不调用sql的情况下，提升查询性能。</li>
<li>细节：
<ul>
<li>创建索引后，会导致表文件的的大小增加。</li>
<li>创建索引只会提升该列的查询速度，不会提升其他列。</li>
</ul>
</li>
<li>原理：没有创建索引时，查询数据采用全表扫描的方式；创建索引后，会按照索引列创建一个易于查询的数据结构，比如二叉树。</li>
<li>类型：
<ul>
<li>主键索引：有<code v-pre>PRIMAY KEY</code>约束的索引</li>
<li>唯一索引：有<code v-pre>UNIQUE</code>约束的索引、</li>
<li>普通索引：通过<code v-pre>INDEX</code>创建的索引</li>
<li>全文索引：<code v-pre>FULLTEXT</code>，适用于<code v-pre>MyISAM</code>
<ul>
<li>一般不使用mysql自带的全文索引，而是使用全文搜索框架<code v-pre>Solr</code>或<code v-pre>ElasticSearch(ES)</code></li>
</ul>
</li>
</ul>
</li>
<li>查询是否有有索引：
<ul>
<li><code v-pre>SHOW INDEX FROM table_name</code></li>
<li><code v-pre>SHOW INDEXES FROM table_name</code></li>
<li><code v-pre>SHOW KEYS FROM table_name</code></li>
</ul>
</li>
<li>创建：
<ul>
<li>主键索引：<code v-pre>ALTER TABLE table_name ADD PRIMARY KEY (id)</code>——添加主键的第三种方式，也是创建主键索引的方式</li>
<li>唯一索引：<code v-pre>CREATE UNIQUE INDEX 索引名 ON table_name(col)</code></li>
<li>普通索引：<code v-pre>CREATE INDEX 索引名 ON table_name(col)</code></li>
</ul>
</li>
<li>删除：
<ul>
<li><code v-pre>DROP INDEX 索引名 ON table_name</code></li>
<li><code v-pre>ALTER TABLE table_name DROP PRIMARY KEY</code></li>
</ul>
</li>
<li>修改：需要先删除，再创建</li>
<li>使用规律该：
<ul>
<li>较频繁的查询字段应创建索引。</li>
<li>唯一性太差的字段即使查询频繁，但一般不作为索引。</li>
<li>更新频繁的字段不适合创建索引。</li>
<li>不会作为<code v-pre>WHERE</code>查询条件的字段不该创建索引。</li>
</ul>
</li>
</ol>
<h3 id="_10-事务" tabindex="-1"><a class="header-anchor" href="#_10-事务" aria-hidden="true">#</a> 10. 事务</h3>
<h4 id="_10-1-基本概念" tabindex="-1"><a class="header-anchor" href="#_10-1-基本概念" aria-hidden="true">#</a> 10.1 基本概念</h4>
<ol>
<li>事务概念：一组相关的DML语句（增、删、改）在执行时，为了保证数据的一致性，需要全部成功，或者全部失败。</li>
<li>原理：当执行事务操作（DML语句）时，mysql会在表上加锁，防止其他用户改变表的数据。</li>
<li>事务的几个重要操作：
<ul>
<li><code v-pre>start transaction | set autocommit=off</code>：开始一个事务</li>
<li><code v-pre>savepoint 点名</code>：设置保存点
<ul>
<li>执行<code v-pre>commit</code>会自动删除该事务所定义的所有保存点。</li>
</ul>
</li>
<li><code v-pre>rollback to 点名</code>：回退事务到该点</li>
<li><code v-pre>rollback</code>：回退所有事务
<ul>
<li>回退所有事务后，不能再执行回退至指定点。</li>
</ul>
</li>
<li><code v-pre>commit</code>：提交事务，操作后不能再回退。
<ul>
<li>本事务提交后，所有的DML数据会更新到数据库中，其他连接可以看到更新后的数据。</li>
</ul>
</li>
</ul>
</li>
<li>使用细节：
<ul>
<li>不开始事务，默认情况下DML操作是自动提交的，没有保存点，也不能回滚。</li>
<li>开始一个事务，未创建保存点时执行<code v-pre>rollback</code>，会回退到事务开始的状态。</li>
<li>开启一个事务后，在<code v-pre>commit</code>前，可以创建多个保存点，并可以回退到指定点。
<ul>
<li>注意：回退操作是单向的，即一旦回退到更早的位置，想再回退到最近的位置，是不能回退的。（A、B、C的顺序，选择了回退到A，这不能再回退至B或C）</li>
</ul>
</li>
<li>事务机制需要<code v-pre>INNODB</code>引擎，<code v-pre>MYISAM</code>不起作用。</li>
</ul>
</li>
</ol>
<h4 id="_10-2-事务隔离级别" tabindex="-1"><a class="header-anchor" href="#_10-2-事务隔离级别" aria-hidden="true">#</a> 10.2 事务隔离级别</h4>
<ol>
<li>
<p>事务隔离：多个连接开启各自事务操作数据库时，数据库系统负责隔离操作，保证各个俩捏在获取数据时的准确性（保证获取到的数据时开启事务时的数据，每个事务对表中数据的更新，不影响其他事务看到的数据的改变）。</p>
</li>
<li>
<p>未隔离后果：</p>
<ul>
<li>脏读（dirty read）：一个事务读取到另一个事务尚未提交的DML操作的数据。</li>
<li>不可重复读（nonrepeatable read）：一个事务在执行DML（修改、删除）操作，另一个事务在进行DQL（查询）操作，每次查询返回的结果集不同。</li>
<li>幻读（phantom read）：一个事务在执行DML（插入）操作，另一个事务在进行DQL（查询）操作，每次查询返回的结果集不同。</li>
</ul>
</li>
<li>
<p>事务隔离级别：事务与事务之间的隔离程度。</p>
</li>
<li>
<p>分类：
| 隔离级别 | 脏读 | 不可重复读 | 幻读 | 加锁读 |
| --- | --- | --- | --- | --- |
| 读未提交
（read uncommitted) | √ | √ | √ | 不加锁 |
| 读已提交
（read committed） | × | √ | √ | 不加锁 |
| 可重复读
（repeatable read） | × | × | × | 不加锁 |
| 可串行化
（serializable） | × | × | × | 加锁 |</p>
<ul>
<li>默认级别为<code v-pre>repeatable read</code>，一般不需要修改。</li>
<li>可串行化级别的隔离会让本事务执行查询时处于等待状态，直到其他事务进行commit或者等待超时。</li>
</ul>
</li>
<li>
<p>操作：</p>
<ul>
<li>查看当前会话隔离级别：<code v-pre>select @@tx_isolation</code></li>
<li>查看系统当前隔离级别：<code v-pre>select @@global.tx_isolation</code></li>
<li>设置当前会话隔离级别：<code v-pre>set session transaction isolation level 隔离级别</code></li>
<li>设置系统当前隔离级别：<code v-pre>set global transaction isolation level 隔离级别</code></li>
</ul>
</li>
<li>
<p>全局修改隔离级别：编辑数据库文件路径下的<code v-pre>my.ini</code>文件，在最后添加<code v-pre>transaction-isolation = 隔离级别</code></p>
</li>
</ol>
<h4 id="_10-3-acid" tabindex="-1"><a class="header-anchor" href="#_10-3-acid" aria-hidden="true">#</a> 10.3 ACID</h4>
<ol>
<li>原子性（atomicity）：事务是一个不可分割的工作单位，事务中的操作要么都发生，要么都不发生。</li>
<li>一致性（consistency）：事务必须使数据库从一个一致性状态变换到另一个一致性状态。</li>
<li>隔离性（isolation）：多个用户并发访问数据库时，多个事务的数据操作相互隔离，不会互相干扰。</li>
<li>持久性（durability）：一个事务一旦被提交，则它对数据库的改变就是永久性的，不会因为数据库发生故障等情况也不会有任何影响。</li>
</ol>
<h3 id="_11-mysql表类型和存储类型" tabindex="-1"><a class="header-anchor" href="#_11-mysql表类型和存储类型" aria-hidden="true">#</a> 11. mysql表类型和存储类型</h3>
<ol>
<li>表类型：mysql的存储引擎（storage engines）决定了表类型。</li>
<li>分类：
<ul>
<li>事务安全型：
<ul>
<li>innodb</li>
</ul>
</li>
<li>非事务安全型：
<ul>
<li>mysiam</li>
<li>memory</li>
</ul>
</li>
</ul>
</li>
<li>显示当前数据库支持的存储引擎：<code v-pre>show engines</code></li>
</ol>
<p><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1656052103965-d3b5dffa-6a5b-4f31-8ad8-9390ca7e2166.png#clientId=u1bf8d8f9-fd63-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=252&amp;id=uf973a6b0&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=252&amp;originWidth=1081&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=27287&amp;status=done&amp;style=none&amp;taskId=uc3f65dba-3db2-466f-af96-2ad22ea4afe&amp;title=&amp;width=1081" alt="image.png" loading="lazy"></p>
<ol start="4">
<li>主要的存储引擎/表的特点</li>
</ol>
<p><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1656052213217-59042449-e1d4-444b-9a98-068abcc27104.png#clientId=u1bf8d8f9-fd63-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=504&amp;id=u3fb4791d&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=504&amp;originWidth=805&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=221277&amp;status=done&amp;style=none&amp;taskId=u24621fcd-786f-4f3d-9e0c-4e03e262796&amp;title=&amp;width=805" alt="image.png" loading="lazy"></p>
<ol start="5">
<li>MyISAM、InnoDB、MEMORY对比
<ul>
<li>innodb：支持事务、支持外键、支持行级锁</li>
<li>myisam：添加速度快、不支持事务和外键、支持表级锁</li>
<li>memory：数据存储在内存中【关闭mysql服务数据丢失，表结构存在】、执行速度很快（没有io读写）、默认支持索引（hash表）</li>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1656052277951-b999cd9d-176c-41e8-a7d1-db651fbd1aec.png#clientId=u1bf8d8f9-fd63-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=362&amp;id=ub9874917&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=362&amp;originWidth=1174&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=633757&amp;status=done&amp;style=none&amp;taskId=ubcd761b7-662e-4e2c-a371-2c4cd0cd1fa&amp;title=&amp;width=1174" alt="image.png" loading="lazy"></li>
</ul>
</li>
<li>表的存储引擎选择
<ul>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1656052488975-1f0e8045-d896-4dee-b091-4f8cdb48e2e0.png#clientId=u1bf8d8f9-fd63-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=227&amp;id=u4ee47190&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=227&amp;originWidth=1078&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=381982&amp;status=done&amp;style=none&amp;taskId=u7aff4452-ac43-4041-8618-bc0f812f1fb&amp;title=&amp;width=1078" alt="image.png" loading="lazy"></li>
</ul>
</li>
</ol>
<h3 id="_12-视图" tabindex="-1"><a class="header-anchor" href="#_12-视图" aria-hidden="true">#</a> 12. 视图</h3>
<ol>
<li>基本概念：虚拟表，内容由查询定义，数据来源于真实表（基表）。
<ul>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1656054728161-b5ec2d0d-b301-42ba-9b6d-9a2e3971a907.png#clientId=u1bf8d8f9-fd63-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=238&amp;id=uba336c79&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=300&amp;originWidth=462&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=18315&amp;status=done&amp;style=none&amp;taskId=u7020c425-2694-4e41-b78d-4ea549edf72&amp;title=&amp;width=367" alt="image.png" loading="lazy"></li>
</ul>
</li>
<li>特点：
<ul>
<li>通过视图可以修改基表的数据</li>
<li>基表的数据改变（MDL），会影响视图的数据。</li>
</ul>
</li>
<li>操作：
<ul>
<li>创建视图：<code v-pre>CREATE VIEW 视图名 AS SELECT语句</code></li>
<li>更新视图：<code v-pre>ALTER VIEW 视图名 AS SELECT语句</code></li>
<li>查看视图创建指令：<code v-pre>SHOW CREATE VIEW 视图名</code>
<ul>
<li>查看视图信息：<code v-pre>DESC 视图名</code></li>
</ul>
</li>
<li>删除视图：<code v-pre>DROP VIEW 视图1, 视图2</code></li>
</ul>
</li>
<li>视图细节：
<ul>
<li>创建视图后，本地数据库文件并没有视图的数据文件，只有一个视图结构的文件（形式：<code v-pre>视图名.frm）</code></li>
<li>可以从视图中再创建视图</li>
</ul>
</li>
<li>视图应用：
<ul>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1656055417087-4466f745-1bdb-4c74-96fb-a17d708373e5.png#clientId=u1bf8d8f9-fd63-4&amp;crop=0.0039&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=434&amp;id=u77fb10e9&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=436&amp;originWidth=1257&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=731923&amp;status=done&amp;style=none&amp;taskId=u16290788-87fb-41c0-95c5-dbcece364e8&amp;title=&amp;width=1252" alt="image.png" loading="lazy"></li>
</ul>
</li>
</ol>
<h3 id="_13-mysql管理" tabindex="-1"><a class="header-anchor" href="#_13-mysql管理" aria-hidden="true">#</a> 13. Mysql管理</h3>
<h4 id="_13-1-mysql用户" tabindex="-1"><a class="header-anchor" href="#_13-1-mysql用户" aria-hidden="true">#</a> 13.1 mysql用户</h4>
<ul>
<li>mysql用户存储在mysql数据库中的user表中
<ul>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1656056438112-d5185ea7-380f-44c1-a8cb-e25cf2954e4f.png#clientId=u1bf8d8f9-fd63-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=1033&amp;id=uc07fc50c&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=1033&amp;originWidth=1920&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=108481&amp;status=done&amp;style=none&amp;taskId=ub121b419-05c2-4303-9107-fdb7d730fc6&amp;title=&amp;width=1920" alt="image.png" loading="lazy"></li>
</ul>
</li>
<li>host：允许登陆的位置，localhost表示只允许本机登录，可以通过ip地址修改</li>
<li>user：用户名</li>
<li>authentication_string：默认使用password()函数加密之后的密码</li>
</ul>
<h4 id="_13-2-创建用户" tabindex="-1"><a class="header-anchor" href="#_13-2-创建用户" aria-hidden="true">#</a> 13.2 创建用户</h4>
<ul>
<li><code v-pre>CREATE USER '用户名'@'允许登录位置' IDENTIFIED BY '密码'</code>
<ul>
<li>不指定密码时，默认为空（无密码）</li>
</ul>
</li>
</ul>
<h4 id="_13-3-删除用户" tabindex="-1"><a class="header-anchor" href="#_13-3-删除用户" aria-hidden="true">#</a> 13.3 删除用户</h4>
<ul>
<li><code v-pre>DROP USER '用户名'@'允许登录位置'</code></li>
</ul>
<h4 id="_13-4-修改用户密码" tabindex="-1"><a class="header-anchor" href="#_13-4-修改用户密码" aria-hidden="true">#</a> 13.4 修改用户密码</h4>
<ul>
<li>修改自己的密码：
<ul>
<li><code v-pre>SET PASSWORD = PASSWORD('新密码')</code></li>
</ul>
</li>
<li>修改别人的密码：（需要具有权限）
<ul>
<li><code v-pre>SET PASSWORD FOR '用户名'@'登录位置' = PASWORD('密码')</code></li>
</ul>
</li>
</ul>
<h4 id="_13-5-mysql中的权限" tabindex="-1"><a class="header-anchor" href="#_13-5-mysql中的权限" aria-hidden="true">#</a> 13.5 MYSQL中的权限</h4>
<p><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1656057761625-7f413062-d0c9-4491-b77d-af4610c06a57.png#clientId=u1bf8d8f9-fd63-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=712&amp;id=u386d86bc&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=712&amp;originWidth=746&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=406563&amp;status=done&amp;style=none&amp;taskId=u4074dbb0-4772-441e-a1da-c81fb8c425d&amp;title=&amp;width=746" alt="image.png" loading="lazy"></p>
<h4 id="_13-6-给用户授权" tabindex="-1"><a class="header-anchor" href="#_13-6-给用户授权" aria-hidden="true">#</a> 13.6 给用户授权</h4>
<p><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1656057825390-3b1057d9-d9e7-48f8-a5e1-9e0ad8a2f6df.png#clientId=u1bf8d8f9-fd63-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=499&amp;id=uc2d50d5f&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=499&amp;originWidth=1205&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=605237&amp;status=done&amp;style=none&amp;taskId=u690d7f04-f02d-4908-83a5-40a80e6ea5b&amp;title=&amp;width=1205" alt="image.png" loading="lazy"></p>
<h4 id="_13-7-回收用户权限" tabindex="-1"><a class="header-anchor" href="#_13-7-回收用户权限" aria-hidden="true">#</a> 13.7 回收用户权限</h4>
<p><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1656057957845-ae57ca1a-e0df-413d-8963-09a28e9eee80.png#clientId=u1bf8d8f9-fd63-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=36&amp;id=uf9db93c1&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=83&amp;originWidth=846&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=81984&amp;status=done&amp;style=none&amp;taskId=uf5fcb934-e5e2-4def-8888-6ca6746d01e&amp;title=&amp;width=367" alt="image.png" loading="lazy"></p>
<h4 id="_13-8-权限生效指令" tabindex="-1"><a class="header-anchor" href="#_13-8-权限生效指令" aria-hidden="true">#</a> 13.8 权限生效指令</h4>
<p><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1656058010820-109f709f-45c9-4522-9fcf-67b54eaacee9.png#clientId=u1bf8d8f9-fd63-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=50&amp;id=ud422b47b&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=109&amp;originWidth=527&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=78702&amp;status=done&amp;style=none&amp;taskId=u907878a1-5a51-4bad-b11b-4c2fd2b53e8&amp;title=&amp;width=243" alt="image.png" loading="lazy"></p>
<h4 id="_13-9-用户管理细节" tabindex="-1"><a class="header-anchor" href="#_13-9-用户管理细节" aria-hidden="true">#</a> 13.9 用户管理细节</h4>
<p><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1656059258130-eb63fb43-ab02-40d5-b1bd-4b1057b5b4fa.png#clientId=u1bf8d8f9-fd63-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=265&amp;id=u693f2f81&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=265&amp;originWidth=1203&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=393773&amp;status=done&amp;style=none&amp;taskId=ued421188-2a5b-4e3e-a0a1-499a090d9cc&amp;title=&amp;width=1203" alt="image.png" loading="lazy"></p>
</div></template>
