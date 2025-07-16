---
icon: edit
date: 2022-06-25
category:
  - 数据库
  - SpringMVC
# tag:
#   - tag A
#   - tag B
description: 
  - MySQL是一个关系型数据库管理系统，由瑞典MySQLAB公司开发，属于Oracle旗下产品。MySQL是最流行的关系型数据库管理系统之一，在 WEB 应用方面，MySQL是最好的 RDBMS (Relational Database Management System，关系数据库管理系统) 应用软件之一。关系数据库将数据保存在不同的表中，而不是将所有数据放在一个大仓库内，这样就增加了速度并提高了灵活性。
---
# MySQL

### 1. 数据库操作

> - 使用图形化界面书写sql语句可以不要分号。
> - 使用终端书写sql语句必须要写分号。
> - sql语句不区分大小写（Windows）环境下。

#### 1.1 创建数据库

1. `CREATE DATABASE [IF NOT EXISTS] db_name [CHARSET xxx COLLATE xxx ……]`
   - `[IF NOT EXISTS]`（可选）：不写时数据库已存在则报错
   - `[CHARSET xxx]`（可选）：指定数据库字符集，默认uft8
   - `[COLLATE xxx]`（可选）：指定数据库字符集校对规则，默认utf8_general_ci，不区分大小写。
      - utf8_bin：区分大小写
   - 表不指定字符集及字符集校对规则时，按照数据库规则执行。
   - db_name与关键字冲突时，可采用反引号包裹。

![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1655551947949-b5543859-8fa2-4a30-8929-7c25adc23e60.png#clientId=ud20487ba-4ed4-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=546&id=u38c60454&margin=%5Bobject%20Object%5D&name=image.png&originHeight=683&originWidth=860&originalType=binary&ratio=1&rotation=0&showTitle=false&size=58613&status=done&style=none&taskId=u0375bb5c-d1f5-4367-8c7b-3049dcc738d&title=&width=688)

- 我的默认字符集怎么不对？
:::danger

- 那是因为msql5.7版本默认的字符集为拉丁文
- 在mysql命令模式下查看编码：`show variables like 'character_%'`
- ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1655809639667-097fbace-a7e0-438f-a156-adf413cb44dc.png#clientId=u9f958873-dea0-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=261&id=ud0f24f27&margin=%5Bobject%20Object%5D&name=image.png&originHeight=261&originWidth=806&originalType=binary&ratio=1&rotation=0&showTitle=false&size=23104&status=done&style=none&taskId=uf9343dd3-4ada-4e27-b750-355fb819e55&title=&width=806)
- 查看比较规则：`show variables like 'collation_%';`
- ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1655809716341-c6c1835d-84dc-4fca-8e9c-8795d667f076.png#clientId=u9f958873-dea0-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=108&id=ue5171d90&margin=%5Bobject%20Object%5D&name=image.png&originHeight=154&originWidth=460&originalType=binary&ratio=1&rotation=0&showTitle=false&size=11220&status=done&style=none&taskId=ud5e20eba-763f-44d8-a9d1-fb045ce30e2&title=&width=323)
- 修改mysql5.7配置文件：`C:\ProgramData\MySQL\MySQL Server 5.7.37\my.ini`
- ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1655809884263-3fe35e1a-b7b4-4158-a04a-4fca1b66f783.png#clientId=u9f958873-dea0-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=60&id=u151f16fa&margin=%5Bobject%20Object%5D&name=image.png&originHeight=104&originWidth=441&originalType=binary&ratio=1&rotation=0&showTitle=false&size=8840&status=done&style=none&taskId=ue514db7a-67ed-4850-a496-679f2eadbd0&title=&width=256)
  - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1655809960705-df066e1c-de92-487d-9220-365d26d525ae.png#clientId=u9f958873-dea0-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=64&id=u42031050&margin=%5Bobject%20Object%5D&name=image.png&originHeight=98&originWidth=342&originalType=binary&ratio=1&rotation=0&showTitle=false&size=8020&status=done&style=none&taskId=u5e3ada03-1dbc-4335-b932-e1bab744f54&title=&width=223)
- ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1655809946347-57bfd092-edc4-4ca5-bc43-a7db8ccb4e1d.png#clientId=u9f958873-dea0-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=172&id=uddcba523&margin=%5Bobject%20Object%5D&name=image.png&originHeight=373&originWidth=613&originalType=binary&ratio=1&rotation=0&showTitle=false&size=64528&status=done&style=none&taskId=u0af97158-ad6a-4c79-9700-b89e42a07fd&title=&width=283)
  - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1655809998830-acb2bd41-28ef-419d-8d3f-fd63574090c1.png#clientId=u9f958873-dea0-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=156&id=u215ba79b&margin=%5Bobject%20Object%5D&name=image.png&originHeight=403&originWidth=730&originalType=binary&ratio=1&rotation=0&showTitle=false&size=72103&status=done&style=none&taskId=u7a56cf56-f185-47a7-9196-342da87ddb0&title=&width=282)
- 配置完后需要重新启动mysql服务
:::

#### 1.2 查看、删除数据库

1. 显示数据库：`SHOW DATABASES`，查看当前数据库服务器中的所有数据库
1. 显示数据库的创建信息：`SHOW CREATE DATABASE db_name`
   - 例：`CREATE DATABASE`db01`/*!40100 DEFAULT CHARACTER SET latin1 */`
   - 例：`CREATE DATABASE`db03`/*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */`
3. 删除数据库：`DROP DATABSE db_name`

#### 1.3 备份、恢复数据库

1. 备份数据库：
   - （DOS命令下）`mysqldump -h 主机名 -P 端口号 -u 用户名 -p -B 数据库1 数据库2 > 文件绝对路径\文件名.sql`
      - 省略规则同开启mysql服务。
      - 备份表：`mysqldump -h 主机名 -P 端口号 -u 用户名 -p 数据库 表1 表2 > 文件绝对路径\文件名.sql`
2. 恢复数据库：
   - 方式一：（mysql环境下）`source 文件绝对路径\文件名.sql`
   - 方式二：（图形界面下）
      - 文本模式打开要恢复的数据库文件，拷贝至图形化界面的查询语句输入区，点击运行
      - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1655623850229-cda84fc5-4e72-4c90-a9f0-31673ffa3c7f.png#clientId=ud20487ba-4ed4-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=814&id=ud9ee2643&margin=%5Bobject%20Object%5D&name=image.png&originHeight=1017&originWidth=1920&originalType=binary&ratio=1&rotation=0&showTitle=false&size=142438&status=done&style=none&taskId=u88e6c749-9571-401e-af44-dcd1270d017&title=&width=1536)
3. 安装（导入）数据库：方式同恢复数据库。

### 2. 表（结构）操作

#### 2.1 创建表

```sql
CREATE TABLE table_name
(
  field1 datatype,
  field2 datatype,
  field3 datatype,
)character set 字符集 collate 校对规则 engine 存储引擎;
```

- character、collate、engine为可选内容
- character set与charset等价
- 存储引擎默认为INNODB
- `CREATE TABLE table_name1 LIKE table_name2;`将table_name2的结构复制到table_name1。

#### 2.2 删除表

- `DROP TABLE table_name`

#### 2.3 备份、恢复表

- 备份表：`mysqldump -h 主机名 -P 端口号 -u 用户名 -p 数据库 表1 表2 > 文件绝对路径\文件名.sql`
- 恢复表：同数据库恢复操作

#### 2.4 修改表

1. 添加列：`ALTER TABLE table_name ADD (column datatype [NOT NULL DEFAULT 'XXX']) AFTER TARGETCOLUMN;`
   - 在目标列`TARGETCOLUMN`后添加指定列，目标列可以大写，也可以小写。
   - 可以一次添加多列（使用`()`包裹），添加一列时，可以不使用括号。
   - 不指定添加在哪一列后面时，默认添加到最后一列
2. 修改列：`ALTER TABLE table_name MODIFY(TARGETCOLUMN datatype [NOT NULL DEFAULT 'XXX']);`
2. 删除列：`ALTER TABLE table_name MODIFY(TARGETCOLUMN）`
2. 修改表名：`RENAME table_name TO new_name;`
2. 显示表结构（查看表的所有列）：`DESC table_name;`
2. 修改表字符集：`ALTER TABLE table_name CHARSET utf8`
2. 修改列名：`ALTER TABLE table_name CHANGE 旧名 新名 datatype`
2. 修改表存储引擎：`ALETER TABLE table_name ENGINE = 引擎类型`

### 3. 常用数据类型（列类型）

![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1655625944752-87f31c5e-3946-4489-8b94-477577d4b2bb.png#clientId=ud20487ba-4ed4-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=311&id=uf530b382&margin=%5Bobject%20Object%5D&name=image.png&originHeight=651&originWidth=1277&originalType=binary&ratio=1&rotation=0&showTitle=false&size=1046755&status=done&style=none&taskId=ue6186fce-d114-464c-9431-ee8748c811f&title=&width=609.2000122070312)
[MySQL数据类型.mmap](https://www.yuque.com/attachments/yuque/0/2022/mmap/1604140/1655627087671-30b49822-daac-4a2f-982a-8228a2f3a11c.mmap)

#### 3.1 数值型

1. 使用原则：满足要求情况下，尽量选择占用空间小的。
1. 整数型：
   - 指定数据类型时，如果未指定unsinged，则为有符号范围，指定unsigned时，为无符号范围。
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1655627179048-1143d987-bf03-4246-8972-a77579f8ac46.png#clientId=ud20487ba-4ed4-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=246&id=u6d68222a&margin=%5Bobject%20Object%5D&name=image.png&originHeight=356&originWidth=574&originalType=binary&ratio=1&rotation=0&showTitle=false&size=215668&status=done&style=none&taskId=u856dec7b-cdb9-498b-9760-e4a318a438d&title=&width=396.20001220703125)
3. bit(m)：
   - m在1～64范围内，表示字节值在0～2^m-1范围内的二进制数
      - 如：m为8时，表示这个数的字节最大有8位，即11111111（255）。
   - 显示bit时，按照二进制数显示。
   - m默认为1。
   - 均为无符号数。
4. 小数型：
   - 指定数据类型时，如果未指定unsinged，则为有符号范围，指定unsigned时，为无符号范围。
   - DECIMAL(M, D)：
      - M表示小数位数（精度），最大65，省略时默认为10。
      - D表示小数点后位数（标度），最大30，省略时默认为0（代表整数）。

#### 3.2 字符型

1. 内容使用单引号`''`包裹
1. char(m)：固定长度字符串，m表示占用内存空间，最大为255，m表示指定的字符数。
1. varchar(m)：可变长度字符串，0～65535字节，m表示指定的字符数。
   - m具体表示的字符位数与表设置的编码有关：
      - utf8：（65535-3）/3=21844
      - gbk：（65535-3）/2=32766
3. 使用细节：
   - char和varchar指定空间后，存入的数据字符长度不能超过指定的空间大小。
   - char为固定长度，指定空间后数据必然占用m个字符的空间。
   - varchar为可变长度，即使指定空间，实际的占用空间与字符编码有关。
   - char查询速度大于varchar
4. text：存放文本数据时，可以使用，有0～65535字节。
   - mediumtext：0～2^24-1
   - longtext：0～2^32-1
   - text不能有默认值
   - 实际占用与字符编码有关

#### 3.3 日期类型

```sql
CREATE TABLE table_name
(
  field1 DATE,
  field2 DATETIME,
  field3 TIMESTAMP,
)character set 字符集 collate 校对规则 engine 存储引擎;
```

- TIMESTAMP：作为时间戳使用时，需要进行配置，即在TIMESTAMP后增加`NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP`

### 4. CRUD（表中数据操作）

#### 4.1 Insert语句——添加数据

```sql
INSERT INTO table_name [column……]
  VALUES (XXX……);
```

- 添加的数据与字段类型须一致。
  - `'34'`这种字符型会自动转换，也能添加到`int`类型的字段中
- 数据长度不能超过字段设定的存储范围。
- 数据的添加数量、顺序须与字段的数量、顺序一致。
- 字符型和日期类型数据必须要用`''`包裹
- 字段可以插入空值`NULL`（前提是字段设置为允许为空）
- 多组数据需要使用`()`包裹，并用`,`隔开。
- 给表中所有字段添加数据，可以不写前面的字段名称。数据的数量与顺序须与表定义时的一致。
- 如果某个字段未指定为`NOT NULL`，添加数据时如果没有给值，则会默认为`null`。
  - 如果需要设定有意义的默认值，则需要在定义表时，在字段声明后增加`NOT NULL DEAFULT 'XXX'`

##### 4.1.1复制表数据

1. 从其他表拷贝数据：

```sql
INSERT INTO table_name1 (col1, col2, col3)
  SELECT col1, col2, col3 FROM table_name2;
```

- 如果table_name1和table_name2有一样的表结构，可以采用`INSERT INTO table_name1 SELECT * FROM table_name2;`
- `INSERT INTO table_name1 SELECT DISTINCT * FROM table_name2;`可以去重。

2. 自我复制（蠕虫复制）

```sql
INSERT INTO table_name
  SELECT * FROM table_name;
```

- 执行多次，可以创建`n×COUNT(*)`条数据。

#### 4.2 Update语句——修改数据

```sql
UPDATE table_name
  SET col_name = expr[,col_name = expr……]
  [WHERE col_name = expr];
```

- 不写WHERE语句时，表示将该字段的所有值都修改。

#### 4.3 Delete语句——删除数据

```sql
DELETE from table_name
  [WHERE col_name = expr];
```

- 不写WHERE语句时，表示清空表中数据。

#### 4.4 Select语句——查询数据

```sql
SELECT [DISTINCT] * | col1,col2
  FROM table_name;
```

- 查询为`*`时，显示表中所有数据。（查看表）
- 查询为`col`时，显示该列（字段）
- 查询时如有`DISTINCT`，显示的时候会去重。
  - distinct也可用于字段col前
- 查询内容可以书写表达式进行计算
  - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1655688546790-131c2a4a-1fb2-4c1b-b449-88b8dbadcb0c.png#clientId=ubb6307e6-4f7d-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=68&id=u8f8f8e69&margin=%5Bobject%20Object%5D&name=image.png&originHeight=113&originWidth=881&originalType=binary&ratio=1&rotation=0&showTitle=false&size=116371&status=done&style=none&taskId=u4f3c7df1-5b42-4e30-9071-bed662a3989&title=&width=533.2000122070312)
- 设置别名：`AS`可以省略
  - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1655688592076-6e471460-d8ae-4d44-b6b8-de36cfb17c0a.png#clientId=ubb6307e6-4f7d-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=69&id=ufc5ad5d6&margin=%5Bobject%20Object%5D&name=image.png&originHeight=136&originWidth=1060&originalType=binary&ratio=1&rotation=0&showTitle=false&size=144112&status=done&style=none&taskId=u62011166-a112-4998-bf9c-dc6535e20d9&title=&width=536.2000122070312)
- `WHERE`子句过滤查询：
  - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1655688687383-05d63c50-4cd5-401b-a449-89e136a3c608.png#clientId=ubb6307e6-4f7d-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=244&id=udc83c6c9&margin=%5Bobject%20Object%5D&name=image.png&originHeight=447&originWidth=868&originalType=binary&ratio=1&rotation=0&showTitle=false&size=352343&status=done&style=none&taskId=u3b5bbf1a-39f9-4309-9f41-a4c31f1b35d&title=&width=473.20001220703125)
    - 不等于可以使用`<>`或`!=`两种方式。
    - BETWEEN AND是闭区间。
- `ORDER BY`排序查询：
  - `ORDER BY col asc | desc, col asc | desc……`
    - `asc`升序，默认为升序。
    - `desc`降序
- **基本语法（书写顺序）：**

```sql
SELECT col1, col2,…… FROM table_name
  group by col
  having condition
  order by col
  limit start, rows;
```

##### 4.4.1 查询加强

1. WHERE：
   - 日期格式也可以使用`> 、<`等比较运算符，但是比较的日期格式须一致。
2. LIKE：
   - `%`表示0个或多个字符。
   - `_`表示单个任意字符。
3. 分页查询：  
   - `limit start, rows`
      - 从第start+1行开始，取出rows行，start取值范围从0开始
      - 实际上为：`limit rows * (第几页 - 1)  , rows`

### 5. 函数

#### 5.1 合计/统计统计函数

1. count

```sql
SELECT COUNT(*) | COUNT(col1), COUNT(col2)
  FROM table_name
  [WHERE where_defined;]
```

- `COUNT(*)`和`COUNT(col)`的区别是`COUT(col)`会排除为null的情况
- `COUNT()`会统计非空（null及`""`）的情况

2. sum

```sql
SELECT sum(col1), sum(col2)……
  FROM table_name
  [WHERE where_defined;]
```

- 作用：统计表中符合条件的数据的和。
- 仅对数值起作用，用在其他数据类型会报错。

3. avg

```sql
SELECT avg(col1), sum(col2)……
  FROM table_name
  [WHERE where_defined;]
```

- 作用：统计表中符合条件的数据的平均值。
- 仅对数值起作用，用在其他数据类型会报错。

4. max/min

```sql
SELECT max(col1), min(col2)……
  FROM table_name
  [WHERE where_defined;]
```

- 作用：统计表中符合条件的数据的最大值/最小值。
- 仅对数值起作用，用在其他数据类型会报错。

#### 5.2 分组

1. group by——分组显示

```sql
SELECT 查询要求, 列
  FROM table_name
  GROUP BY col
  [WHERE where_defined;]
```

- 按照`table_name`中的`col`列进行分组显示，会忽略col中的空值。

2. having——分组后过滤

```sql
SELECT 查询要求, 列
  FROM table_name
  GROUP BY col HAVING 过滤条件;
```

- 过滤条件可以是函数。

#### 5.3 字符串

![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1655692935016-08d96a64-f1f4-4f33-9e1b-bc3dd2aa9ed0.png#clientId=ubb6307e6-4f7d-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=243&id=u65ca6dc4&margin=%5Bobject%20Object%5D&name=image.png&originHeight=463&originWidth=939&originalType=binary&ratio=1&rotation=0&showTitle=false&size=383772&status=done&style=none&taskId=u218f58ea-695f-48ab-8ab2-236578ee9c6&title=&width=492.20001220703125)

- `MySQL`中字符串的index是从1开始的。
- `STRCAMP`比较字符串大小时，是否区分大小写与数据库的查询编码有关。

#### 5.4 数学函数

![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1655699331185-e748c21c-6e8a-4b01-8e89-020659796a7f.png#clientId=ubb6307e6-4f7d-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=257&id=u90cb8405&margin=%5Bobject%20Object%5D&name=image.png&originHeight=460&originWidth=871&originalType=binary&ratio=1&rotation=0&showTitle=false&size=279000&status=done&style=none&taskId=ucc0cceea-fcca-4e87-ab6e-364f662056f&title=&width=487.20001220703125)

- seed为任意的整数参数，作为参数传入`RAND()`时，表示生成的随机数第一次生成后不再变化

#### 5.5 日期函数

![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1655700829579-66e73e22-3d10-424b-9791-53028e9062cd.png#clientId=ubb6307e6-4f7d-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=210&id=u7bd2bf55&margin=%5Bobject%20Object%5D&name=image.png&originHeight=459&originWidth=949&originalType=binary&ratio=1&rotation=0&showTitle=false&size=339221&status=done&style=none&taskId=u76a7c3d5-fd38-4263-86f5-eef4b6d2ddb&title=&width=434.20001220703125)

- `DATE_ADD()`、`DATE_SUB()`中的`INTERVAL`后面可以是year、month、day、hour、minute、second
- `YEAR|MONTH|DATE(datetime)`：返回指定datetime的年、月、日
- `UNIX_TIMESTAMP()`：返回距离1970-1-1的秒数。
- `FROM_UNIXTIME(unix_timestamp(), '时间格式')`：将一个unix_timestamp()的秒数，转换为年月日时分秒.
  - 时间格式：
    - `%Y-%m-%d %H:%i:%s`
    - `%Y-%m-%d`

#### 5.6 加密函数

1. `USER()`：显示当前mysql服务的登录用户。格式为：user@IP地址
1. `DATABASE()`：显示当前使用的数据库名称
1. `MD5(str)`：为str计算一个32位的MD5字符串。
   - 应用场景：用户的密码使用md5加密
4. `password(str)`：另一种加密方式。

#### 5.7 流程控制

1. `if(expr1, expr2, expr3)`：如果expr1为true，返回expr2，否则返回expr3
1. `ifnull(expr1, expr2)`：如果expr1为空，返回expr2，否则返回expr1
1. 多重分支：

```sql
SELECT CASE
  WHEN expr1 THEN expr2
  WHEN expr3 THEN expr4
  ELSE expr5
  END;
```

- 如果expr1为true，则返回expr2
- 如果expr3为true，则返回expr4
- 否则返回expr5

### 6. 多表查询

#### 6.1 笛卡尔积

1. `SELECT * FROM table1, table2`：
   - 该种情况下，会取出table1的每一行与table2的每一行组合进行显示，显示的行数为table1的行数×table2的行数，称为笛卡尔集
   - table1和table2共有的col，要指定该列作为查询内容时，需要使用`table1.col`的方式指定是哪个表的col列，否则会报错。
   - 多表查询的条件（WHERE）不能少于表的个数-1，否则会出现笛卡尔积。

#### 6.2 自连接

1. 含义：在同一个表查询该表内的多个数据进行显示。
1. 原理：给表起个别名，把它当成多个表，然后用`别名.col`指定多个查询列，进行多表查询
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1656034785648-7c57e9a3-8ddd-4f8b-83e0-60801b45a983.png#clientId=u41d7c6a8-95c2-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=85&id=cnOm2&margin=%5Bobject%20Object%5D&name=image.png&originHeight=85&originWidth=442&originalType=binary&ratio=1&rotation=0&showTitle=false&size=21420&status=done&style=none&taskId=u70baf46d-3ec4-40dd-9053-26cc20b9a1a&title=&width=442)
   - 这里只有emp一个表，给表起了个worker和boss两个名字
3. 特点：
   - 把同一张表当作两张表使用
   - 需要给表取别名，as可用也可不用
   - 可以给查询的列取别名。

#### 6.3 合并查询

1. 作用：合并多条SELECT单表查询语句的结果，进行多行显示。
1. 语法：`SELECT …… FROM …… WHERE …… UNION | UNION ALL SELECT …… FROM …… WHERE ……`
1. `UNION`：查询结果不会去重。
1. `UNION ALL`：查询结果会去重。

#### 6.4 外连接

1. 出现背景：笛卡尔积筛选的数据会根据关联条件匹配，如果关联条件一个表有，另一个表没有，那么就会匹配不上，就不会显示该条数据。
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1656034955869-5bcc2525-7aee-43d4-8e4f-5a66acfa799c.png#clientId=u41d7c6a8-95c2-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=85&id=u537a4c38&margin=%5Bobject%20Object%5D&name=image.png&originHeight=85&originWidth=218&originalType=binary&ratio=1&rotation=0&showTitle=false&size=9397&status=done&style=none&taskId=u4a9a2089-b07e-46a9-9a8a-0b1ea5937b7&title=&width=218)
2. 左外连接：左侧表完全显示。
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1656034993812-3f0ae7fe-6340-45bc-add4-2fbbd562c3ff.png#clientId=u41d7c6a8-95c2-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=85&id=u6331c139&margin=%5Bobject%20Object%5D&name=image.png&originHeight=85&originWidth=218&originalType=binary&ratio=1&rotation=0&showTitle=false&size=12280&status=done&style=none&taskId=ubdd4a8ca-5002-47c6-9f9f-b27c0efaeaf&title=&width=218)
3. 右外连接：右侧表完全显示。
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1656035011791-0c5a9aeb-291e-4389-994b-c4c03528dd18.png#clientId=u41d7c6a8-95c2-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=88&id=u71451ef6&margin=%5Bobject%20Object%5D&name=image.png&originHeight=88&originWidth=240&originalType=binary&ratio=1&rotation=0&showTitle=false&size=10278&status=done&style=none&taskId=u5d68156d-512f-463c-af07-28a0d3a6e67&title=&width=240)

### 7. 子查询

- 嵌入在其他sql语句中的select语句，也叫嵌套查询。

#### 7.1 单行子查询

- 查询只返回一行数据的子查询语句。
- `WHERE col = (SELECT子句)`

#### 7.2 多行子查询

- 查询返回多行数据的子查询。
- `WHERE col IN (SELECT子句)`

#### 7.3 ALL和ANY关键字

- `all`：
- `any`：
- 用在`WHERE`子句中，子查询语句包裹在`all()`或`any()`中。

#### 7.4 多列子查询

- 查询返回多个列数据的子查询语句。
- `WHERE(col1, col2) = (SELECT子句)`

#### 7.5 子查询当作临时表

- 将子查询结果当作一个表，再使用多表查询的方式查询。

### 8. 约束

1. 作用：确保数据库的数据满足特定的商业规则。
1. 种类：not null、unique、primary key、foreign key、check五种。
1. primary key：用于标示该字段的数据不能重复
   - 定义位置：
      - 第一种：创建表时datatype后声明`PRIMAY KEY`。
      - 第二种：所有字段声明完的`)`前写上`PRIMAY KEY(col1, col2)`
      - 第三种：`ALTER TABLE table_name ADD PRIMARY KEY (id)`
   - 使用细节：
      - 不能重复且不能为空（不需要显式地声明not null）
      - 一张表最多只能有一个主键，但可以是复合主键（只能用第二种定义位置的方式）。
4. not null：用于标示该字段插入数据时必须提供数据。
   - 定义位置：
      - 创建表时datatype后声明`NOT NULL`。
   - 使用细节：
      - 一般配合`DEFAULT`给该字段设定默认初始值——`NOT NULL DEAFULT`。
5. unique：用于标示该字段的值不能重复
   - 定义位置：
      - 创建表时datatype后声明`UNIQUE`。
   - 使用细节：
      - 如果该字段没有声明为`NOT NULL`，那么声明为`UNIQUE`的字段可以有多个null
      - 一张表可以有多个unique字段
6. foreign key：用于定义主表与从表的关系。
   - 定义位置：
      - 创建从表时所有字段声明完的`)`前写上`FOREIGN KEY(外键名) REFERENCES 主表(主键列)`。
   - 使用细节：
      - 外键定义在从表上，主表必须有`PRIMAY KEY`或`UNIQUE`约束。
      - 从表定义外键后，从表该字段的值必须在主表的主键列存在，或者从表该字段为null。
         - 前提是从表的该外键字段没有设置`NOT NULL`
      - 一旦建立主外键关系，数据就不能随意删除。
      - 只有表类型设置为`innodb`，才支持外键。
      - 外键字段的类型与主键的字段类型须一直，但长度可以不同。
7. check：用于插入数据时检验是否满足设定要求。
   - 定义位置：
      - 创建表时datatype后声明`CHECK(检验条件)`。
   - 使用细节：
      - oracle和sql server均支持check，但mysql5.7还不支持check，只做语法校验，但不会生效。
8. 自增长：用于在插入数据时，自动更新数据并插入。
   - 定义位置：
      - 创建表时datatype后声明`AUTO_INCREMENT`。
   - 使用细节：
      - 自增长一般配合`PRIMAY KEY`使用，也可以配合`UNIQUE`使用。
         - 但不能两个约束键一个也没有。
      - 自增长修饰的字段一般为整数型，极少情况使用小数型。
      - 自增长默认从1开始，可以通过`ALTER TABLE table_name AUTO_INCREMENT = 新的开始值;`进行修改。插入的第一条数据的值为设定的新开的开始值。
         - 也可以通过显式赋值的方式给自增长字段设定新值，但一般不这样操作。
         - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1656037394194-04b67dee-896f-4c2a-8332-ebff7f9797ea.png#clientId=u41d7c6a8-95c2-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=55&id=uf3c426b7&margin=%5Bobject%20Object%5D&name=image.png&originHeight=55&originWidth=268&originalType=binary&ratio=1&rotation=0&showTitle=false&size=9315&status=done&style=none&taskId=u2a833173-9413-4928-89f7-f406f4ecbab&title=&width=268)
      - 自增长的后续值，按照表内最新的值开始，或者修改后的自增长值开始。
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1656037085732-67b5477c-4855-41f5-b80a-bbf296790946.png#clientId=u41d7c6a8-95c2-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=92&id=ucd4d7c62&margin=%5Bobject%20Object%5D&name=image.png&originHeight=92&originWidth=542&originalType=binary&ratio=1&rotation=0&showTitle=false&size=86429&status=done&style=none&taskId=u8b9e0093-b84e-4b9a-862c-2712aebcd99&title=&width=542)
      - 这里设定了字段1为自增长字段。

### 9. 索引

1. 作用：提高数据库的性能，在不增加内存、不修改程序、不调用sql的情况下，提升查询性能。
1. 细节：
   - 创建索引后，会导致表文件的的大小增加。
   - 创建索引只会提升该列的查询速度，不会提升其他列。
3. 原理：没有创建索引时，查询数据采用全表扫描的方式；创建索引后，会按照索引列创建一个易于查询的数据结构，比如二叉树。
3. 类型：
   - 主键索引：有`PRIMAY KEY`约束的索引
   - 唯一索引：有`UNIQUE`约束的索引、
   - 普通索引：通过`INDEX`创建的索引
   - 全文索引：`FULLTEXT`，适用于`MyISAM`
      - 一般不使用mysql自带的全文索引，而是使用全文搜索框架`Solr`或`ElasticSearch(ES)`
5. 查询是否有有索引：
   - `SHOW INDEX FROM table_name`
   - `SHOW INDEXES FROM table_name`
   - `SHOW KEYS FROM table_name`
6. 创建：
   - 主键索引：`ALTER TABLE table_name ADD PRIMARY KEY (id)`——添加主键的第三种方式，也是创建主键索引的方式
   - 唯一索引：`CREATE UNIQUE INDEX 索引名 ON table_name(col)`
   - 普通索引：`CREATE INDEX 索引名 ON table_name(col)`
7. 删除：
   - `DROP INDEX 索引名 ON table_name`
   - `ALTER TABLE table_name DROP PRIMARY KEY`
8. 修改：需要先删除，再创建
8. 使用规律该：
   - 较频繁的查询字段应创建索引。
   - 唯一性太差的字段即使查询频繁，但一般不作为索引。
   - 更新频繁的字段不适合创建索引。
   - 不会作为`WHERE`查询条件的字段不该创建索引。

### 10. 事务

#### 10.1 基本概念

1. 事务概念：一组相关的DML语句（增、删、改）在执行时，为了保证数据的一致性，需要全部成功，或者全部失败。
1. 原理：当执行事务操作（DML语句）时，mysql会在表上加锁，防止其他用户改变表的数据。
1. 事务的几个重要操作：
   - `start transaction | set autocommit=off`：开始一个事务
   - `savepoint 点名`：设置保存点
      - 执行`commit`会自动删除该事务所定义的所有保存点。
   - `rollback to 点名`：回退事务到该点
   - `rollback`：回退所有事务
      - 回退所有事务后，不能再执行回退至指定点。
   - `commit`：提交事务，操作后不能再回退。
      - 本事务提交后，所有的DML数据会更新到数据库中，其他连接可以看到更新后的数据。
4. 使用细节：
   - 不开始事务，默认情况下DML操作是自动提交的，没有保存点，也不能回滚。
   - 开始一个事务，未创建保存点时执行`rollback`，会回退到事务开始的状态。
   - 开启一个事务后，在`commit`前，可以创建多个保存点，并可以回退到指定点。
      - 注意：回退操作是单向的，即一旦回退到更早的位置，想再回退到最近的位置，是不能回退的。（A、B、C的顺序，选择了回退到A，这不能再回退至B或C）
   - 事务机制需要`INNODB`引擎，`MYISAM`不起作用。

#### 10.2 事务隔离级别

1. 事务隔离：多个连接开启各自事务操作数据库时，数据库系统负责隔离操作，保证各个俩捏在获取数据时的准确性（保证获取到的数据时开启事务时的数据，每个事务对表中数据的更新，不影响其他事务看到的数据的改变）。
1. 未隔离后果：
   - 脏读（dirty read）：一个事务读取到另一个事务尚未提交的DML操作的数据。
   - 不可重复读（nonrepeatable read）：一个事务在执行DML（修改、删除）操作，另一个事务在进行DQL（查询）操作，每次查询返回的结果集不同。
   - 幻读（phantom read）：一个事务在执行DML（插入）操作，另一个事务在进行DQL（查询）操作，每次查询返回的结果集不同。
3. 事务隔离级别：事务与事务之间的隔离程度。
3. 分类：
| 隔离级别 | 脏读 | 不可重复读 | 幻读 | 加锁读 |
| --- | --- | --- | --- | --- |
| 读未提交
（read uncommitted) | √ | √ | √ | 不加锁 |
| 读已提交
（read committed） | × | √ | √ | 不加锁 |
| 可重复读
（repeatable read） | × | × | × | 不加锁 |
| 可串行化
（serializable） | × | × | × | 加锁 |

   - 默认级别为`repeatable read`，一般不需要修改。
   - 可串行化级别的隔离会让本事务执行查询时处于等待状态，直到其他事务进行commit或者等待超时。
5. 操作：
   - 查看当前会话隔离级别：`select @@tx_isolation`
   - 查看系统当前隔离级别：`select @@global.tx_isolation`
   - 设置当前会话隔离级别：`set session transaction isolation level 隔离级别`
   - 设置系统当前隔离级别：`set global transaction isolation level 隔离级别`
6. 全局修改隔离级别：编辑数据库文件路径下的`my.ini`文件，在最后添加`transaction-isolation = 隔离级别`

#### 10.3 ACID

1. 原子性（atomicity）：事务是一个不可分割的工作单位，事务中的操作要么都发生，要么都不发生。
1. 一致性（consistency）：事务必须使数据库从一个一致性状态变换到另一个一致性状态。
1. 隔离性（isolation）：多个用户并发访问数据库时，多个事务的数据操作相互隔离，不会互相干扰。
1. 持久性（durability）：一个事务一旦被提交，则它对数据库的改变就是永久性的，不会因为数据库发生故障等情况也不会有任何影响。

### 11. mysql表类型和存储类型

1. 表类型：mysql的存储引擎（storage engines）决定了表类型。
1. 分类：
   - 事务安全型：
      - innodb
   - 非事务安全型：
      - mysiam
      - memory
3. 显示当前数据库支持的存储引擎：`show engines`

![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1656052103965-d3b5dffa-6a5b-4f31-8ad8-9390ca7e2166.png#clientId=u1bf8d8f9-fd63-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=252&id=uf973a6b0&margin=%5Bobject%20Object%5D&name=image.png&originHeight=252&originWidth=1081&originalType=binary&ratio=1&rotation=0&showTitle=false&size=27287&status=done&style=none&taskId=uc3f65dba-3db2-466f-af96-2ad22ea4afe&title=&width=1081)

4. 主要的存储引擎/表的特点

![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1656052213217-59042449-e1d4-444b-9a98-068abcc27104.png#clientId=u1bf8d8f9-fd63-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=504&id=u3fb4791d&margin=%5Bobject%20Object%5D&name=image.png&originHeight=504&originWidth=805&originalType=binary&ratio=1&rotation=0&showTitle=false&size=221277&status=done&style=none&taskId=u24621fcd-786f-4f3d-9e0c-4e03e262796&title=&width=805)

5. MyISAM、InnoDB、MEMORY对比
   - innodb：支持事务、支持外键、支持行级锁
   - myisam：添加速度快、不支持事务和外键、支持表级锁
   - memory：数据存储在内存中【关闭mysql服务数据丢失，表结构存在】、执行速度很快（没有io读写）、默认支持索引（hash表）
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1656052277951-b999cd9d-176c-41e8-a7d1-db651fbd1aec.png#clientId=u1bf8d8f9-fd63-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=362&id=ub9874917&margin=%5Bobject%20Object%5D&name=image.png&originHeight=362&originWidth=1174&originalType=binary&ratio=1&rotation=0&showTitle=false&size=633757&status=done&style=none&taskId=ubcd761b7-662e-4e2c-a371-2c4cd0cd1fa&title=&width=1174)
6. 表的存储引擎选择
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1656052488975-1f0e8045-d896-4dee-b091-4f8cdb48e2e0.png#clientId=u1bf8d8f9-fd63-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=227&id=u4ee47190&margin=%5Bobject%20Object%5D&name=image.png&originHeight=227&originWidth=1078&originalType=binary&ratio=1&rotation=0&showTitle=false&size=381982&status=done&style=none&taskId=u7aff4452-ac43-4041-8618-bc0f812f1fb&title=&width=1078)

### 12. 视图

1. 基本概念：虚拟表，内容由查询定义，数据来源于真实表（基表）。
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1656054728161-b5ec2d0d-b301-42ba-9b6d-9a2e3971a907.png#clientId=u1bf8d8f9-fd63-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=238&id=uba336c79&margin=%5Bobject%20Object%5D&name=image.png&originHeight=300&originWidth=462&originalType=binary&ratio=1&rotation=0&showTitle=false&size=18315&status=done&style=none&taskId=u7020c425-2694-4e41-b78d-4ea549edf72&title=&width=367)
2. 特点：
   - 通过视图可以修改基表的数据
   - 基表的数据改变（MDL），会影响视图的数据。
3. 操作：
   - 创建视图：`CREATE VIEW 视图名 AS SELECT语句`
   - 更新视图：`ALTER VIEW 视图名 AS SELECT语句`
   - 查看视图创建指令：`SHOW CREATE VIEW 视图名`
      - 查看视图信息：`DESC 视图名`
   - 删除视图：`DROP VIEW 视图1, 视图2`
4. 视图细节：
   - 创建视图后，本地数据库文件并没有视图的数据文件，只有一个视图结构的文件（形式：`视图名.frm）`
   - 可以从视图中再创建视图
5. 视图应用：
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1656055417087-4466f745-1bdb-4c74-96fb-a17d708373e5.png#clientId=u1bf8d8f9-fd63-4&crop=0.0039&crop=0&crop=1&crop=1&from=paste&height=434&id=u77fb10e9&margin=%5Bobject%20Object%5D&name=image.png&originHeight=436&originWidth=1257&originalType=binary&ratio=1&rotation=0&showTitle=false&size=731923&status=done&style=none&taskId=u16290788-87fb-41c0-95c5-dbcece364e8&title=&width=1252)

### 13. Mysql管理

#### 13.1 mysql用户

- mysql用户存储在mysql数据库中的user表中
  - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1656056438112-d5185ea7-380f-44c1-a8cb-e25cf2954e4f.png#clientId=u1bf8d8f9-fd63-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=1033&id=uc07fc50c&margin=%5Bobject%20Object%5D&name=image.png&originHeight=1033&originWidth=1920&originalType=binary&ratio=1&rotation=0&showTitle=false&size=108481&status=done&style=none&taskId=ub121b419-05c2-4303-9107-fdb7d730fc6&title=&width=1920)
- host：允许登陆的位置，localhost表示只允许本机登录，可以通过ip地址修改
- user：用户名
- authentication_string：默认使用password()函数加密之后的密码

#### 13.2 创建用户

- `CREATE USER '用户名'@'允许登录位置' IDENTIFIED BY '密码'`
  - 不指定密码时，默认为空（无密码）

#### 13.3 删除用户

- `DROP USER '用户名'@'允许登录位置'`

#### 13.4 修改用户密码

- 修改自己的密码：
  - `SET PASSWORD = PASSWORD('新密码')`
- 修改别人的密码：（需要具有权限）
  - `SET PASSWORD FOR '用户名'@'登录位置' = PASWORD('密码')`

#### 13.5 MYSQL中的权限

![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1656057761625-7f413062-d0c9-4491-b77d-af4610c06a57.png#clientId=u1bf8d8f9-fd63-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=712&id=u386d86bc&margin=%5Bobject%20Object%5D&name=image.png&originHeight=712&originWidth=746&originalType=binary&ratio=1&rotation=0&showTitle=false&size=406563&status=done&style=none&taskId=u4074dbb0-4772-441e-a1da-c81fb8c425d&title=&width=746)

#### 13.6 给用户授权

![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1656057825390-3b1057d9-d9e7-48f8-a5e1-9e0ad8a2f6df.png#clientId=u1bf8d8f9-fd63-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=499&id=uc2d50d5f&margin=%5Bobject%20Object%5D&name=image.png&originHeight=499&originWidth=1205&originalType=binary&ratio=1&rotation=0&showTitle=false&size=605237&status=done&style=none&taskId=u690d7f04-f02d-4908-83a5-40a80e6ea5b&title=&width=1205)

#### 13.7 回收用户权限

![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1656057957845-ae57ca1a-e0df-413d-8963-09a28e9eee80.png#clientId=u1bf8d8f9-fd63-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=36&id=uf9db93c1&margin=%5Bobject%20Object%5D&name=image.png&originHeight=83&originWidth=846&originalType=binary&ratio=1&rotation=0&showTitle=false&size=81984&status=done&style=none&taskId=uf5fcb934-e5e2-4def-8888-6ca6746d01e&title=&width=367)

#### 13.8 权限生效指令

![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1656058010820-109f709f-45c9-4522-9fcf-67b54eaacee9.png#clientId=u1bf8d8f9-fd63-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=50&id=ud422b47b&margin=%5Bobject%20Object%5D&name=image.png&originHeight=109&originWidth=527&originalType=binary&ratio=1&rotation=0&showTitle=false&size=78702&status=done&style=none&taskId=u907878a1-5a51-4bad-b11b-4c2fd2b53e8&title=&width=243)

#### 13.9 用户管理细节

![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1656059258130-eb63fb43-ab02-40d5-b1bd-4b1057b5b4fa.png#clientId=u1bf8d8f9-fd63-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=265&id=u693f2f81&margin=%5Bobject%20Object%5D&name=image.png&originHeight=265&originWidth=1203&originalType=binary&ratio=1&rotation=0&showTitle=false&size=393773&status=done&style=none&taskId=ued421188-2a5b-4e3e-a0a1-499a090d9cc&title=&width=1203)
