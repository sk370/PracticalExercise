---
icon: edit
date: 2022-08-04
category:
  - 框架
  - 持久层
# tag:
#   - tag A
#   - tag B
description: 
  - MyBatis-Plus（简称 MP）是一个 MyBatis的增强工具，在 MyBatis 的基础上只做增强不做改变，为简化开发、提高效率而生。
---
# MyBatis Plus

> - 最好学了SpringBoot之后【SpringBoot使用时更简单】
> - 也可以学习了ssm之后
> - 代码发布地址:
>   - Github: <https://github.com/baomidou/mybatis-plus>
>   - Gitee: <https://gitee.com/baomidou/mybatis-plus>
> - 文档发布地址:<https://baomidou.com/pages/24112f>

## 第1章 MyBatis-Plus介绍

### 1.1 简介

### 1.2 特性

1. 无侵入：只做增强不做改变，引入它不会对现有工程产生影响
1. 损耗小：启动即会自动注入基本 CURD，性能基本无损耗，直接面向对象操作
1. 强大的 CRUD 操作：内置通用 Mapper、通用 Service，仅仅通过少量配置即可实现单表大部分CRUD 操作，更有强大的条件构造器，满足各类使用需求
1. 支持 Lambda 形式调用：通过 Lambda 表达式，方便的编写各类查询条件，无需再担心字段写错
1. 支持主键自动生成：支持多达 4 种主键策略（内含分布式唯一 ID 生成器 - Sequence），可自由配置，完美解决主键问题
1. 支持 ActiveRecord 模式：支持 ActiveRecord 形式调用，实体类只需继承 Model 类即可进行强大的 CRUD 操作
1. 支持自定义全局通用操作：支持全局通用方法注入（ Write once, use anywhere ）
1. 内置代码生成器：采用代码或者 Maven 插件可快速生成 Mapper 、 Model 、 Service 、Controller 层代码，支持模板引擎等超多自定义配置
1. 内置分页插件：基于 MyBatis 物理分页，开发者无需关心具体操作，配置好插件之后，写分页等同于普通 List 查询
1. 分页插件支持多种数据库：支持 MySQL、MariaDB、Oracle、DB2、H2、HSQL、SQLite、Postgre、SQLServer 等多种数据库
1. 内置性能分析插件：可输出 SQL 语句以及其执行时间，建议开发测试时启用该功能，能快速揪出慢查询
1. 内置全局拦截插件：提供全表 delete 、 update 操作智能分析阻断，也可自定义拦截规则，预防误操作

### 1.3 框架结构

![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1659436803386-cb40eae4-66da-405e-b2db-05509b797374.png#clientId=u0ce8d131-3c5b-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=852&id=ub42f8704&margin=%5Bobject%20Object%5D&name=image.png&originHeight=852&originWidth=1330&originalType=binary&ratio=1&rotation=0&showTitle=false&size=521774&status=done&style=none&taskId=u1ea72db8-18ad-435a-b7c2-0e132d84fb1&title=&width=1330)

### 1.4 入门案例

#### 1.5.1 开发环境

- jdk8
- Maven：3.6.1
- Spring：5.3.1
- My-Batis-Plus：3.4.3.4（注意：引入了mybatisplus，就不要再引入mybatis和mybatsi-spring，避免版本冲突（官网提示）

#### 1.5.2 创建数据表

```sql
CREATE DATABASE `mybatis_plus` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
use `mybatis_plus`;
CREATE TABLE `user` (
`id` bigint(20) NOT NULL COMMENT '主键ID',
`name` varchar(30) DEFAULT NULL COMMENT '姓名',
`age` int(11) DEFAULT NULL COMMENT '年龄',
`email` varchar(50) DEFAULT NULL COMMENT '邮箱',
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO user (id, name, age, email) VALUES
(1, 'Jone', 18, 'test1@baomidou.com'),
(2, 'Jack', 20, 'test2@baomidou.com'),
(3, 'Tom', 28, 'test3@baomidou.com'),
(4, 'Sandy', 21, 'test4@baomidou.com'),
(5, 'Billie', 24, 'test5@baomidou.com');
```

#### 1.5.3 创建Maven工程（基于Spring Boot）

1. 新建项目：
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1659616988189-b08420ae-9350-44b5-b27a-3a336bb6603e.png#clientId=uaf8d940b-efc7-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=625&id=ufa723ed7&margin=%5Bobject%20Object%5D&name=image.png&originHeight=625&originWidth=802&originalType=binary&ratio=1&rotation=0&showTitle=false&size=56687&status=done&style=none&taskId=u9c745177-091f-45ab-8f29-68be91bd4aa&title=&width=802)
   - 不选择依赖，通过手动编辑pom.xml文件的形式添加
2. 在pom.xml文件中添加依赖
   - 空项目默认有spring-boot-starter和spring-boot-starter-test依赖
   - 额外再引入mybatis-plus-boot-starter、lombok（同时须下载该插件）、mysql-connector-java

```xml
<dependency>
  <groupId>com.baomidou</groupId>
  <artifactId>mybatis-plus-boot-starter</artifactId>
  <version>3.5.1</version>
</dependency>
<dependency>
  <groupId>org.projectlombok</groupId>
  <artifactId>lombok</artifactId>
  <optional>true</optional>
</dependency>
<dependency>
  <groupId>mysql</groupId>
  <artifactId>mysql-connector-java</artifactId>
  <scope>runtime</scope>
</dependency>
```

3. 配置数据源及日志输出（该日志用于在控制台查看mybatis-plus生成了什么sql语句）
   - 在resources路径下新建application.yml核心配置文件

```xml
spring:
# 配置数据源信息
  datasource:
  # 配置数据源类型
    type: com.zaxxer.hikari.HikariDataSource
    # 配置连接数据库信息
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:13306/mybatis_plus?characterEncoding=utf-8&useSSL=false
    username: root
    password: dimitre123
# 配置MyBatis日志
mybatis-plus:
  configuration:
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
```

- spring boot 2.0内置jdbc5驱动
  - 驱动类使用com.mysql.jdbc.Driver
  - url使用：jdbc:mysql://localhost:13306/mybatis_plus?characterEncoding=utf-8&useSSL=false
- spring boot 2.1以上版本内置jdbc8驱动，
  - 驱动类使用com.mysql.cj.jdbc.Driver
  - url使用：jdbc:mysql://localhost:13306/mybatis_plus?
serverTimezone=GMT%2B8&characterEncoding=utf-8&useSSL=false

## 第2章 mybatis-plus使用

### 2.1 Crud功能

#### 2.1.1 基本使用

1. 创建User JavaBean，使用@Data注解生成无参构造器、getter、setter、equals、tosting、hashcode，没有生成带参的构造器。
   - 注意：数据表中id使用的数据类型为bigint，所以User类中的id使用了long类型
   - 之所以这样做是因为mybatis插入数据时，自增的id使用的雪花算法，比较长。
2. 创建UserMapper接口，继承自BaseMapper，范型使用User
   - spring boot的启动程序类，**使用@MapperScan("")指定扫描的mapper包**
      - **扫描会把扫描到的类交给ioc容器管理，所以不是必须要在UserMapper类前使用**@**Repository进行声明**
      - **但是idea工具在自动装配usermapper时，会报红线，如果要消除红线，可以添加**@**Repository注解标记成持久层组件**
3. 在test/iceriver.mybatisplus目录下创建测试类UserTests.java，使用@SpringBootTest注解进行标记，实验增删改查方法：

```java
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.baomidou.mybatisplus.core.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.ExceptionUtils;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

public interface BaseMapper<T> extends Mapper<T> {
    int insert(T entity);
    
    int deleteById(Serializable id);
    
    int deleteById(T entity);
    
    int deleteByMap(@Param("cm") Map<String, Object> columnMap);
    
    int delete(@Param("ew") Wrapper<T> queryWrapper);
    
    int deleteBatchIds(@Param("coll") Collection<?> idList);
    
    int updateById(@Param("et") T entity);
    
    int update(@Param("et") T entity, @Param("ew") Wrapper<T> updateWrapper);
    
    T selectById(Serializable id);
    
    List<T> selectBatchIds(@Param("coll") Collection<? extends Serializable> idList);
    
    List<T> selectByMap(@Param("cm") Map<String, Object> columnMap);
    
    default T selectOne(@Param("ew") Wrapper<T> queryWrapper) {
        List<T> ts = this.selectList(queryWrapper);
        if (CollectionUtils.isNotEmpty(ts)) {
            if (ts.size() != 1) {
                throw ExceptionUtils.mpe("One record is expected, but the query result is multiple records", new Object[0]);
            } else {
                return ts.get(0);
            }
        } else {
            return null;
        }
    }
    
    default boolean exists(Wrapper<T> queryWrapper) {
        Long count = this.selectCount(queryWrapper);
        return null != count && count > 0L;
    }
    
    Long selectCount(@Param("ew") Wrapper<T> queryWrapper);
    
    List<T> selectList(@Param("ew") Wrapper<T> queryWrapper);
    
    List<Map<String, Object>> selectMaps(@Param("ew") Wrapper<T> queryWrapper);
    
    List<Object> selectObjs(@Param("ew") Wrapper<T> queryWrapper);
    
    <P extends IPage<T>> P selectPage(P page, @Param("ew") Wrapper<T> queryWrapper);
    
    <P extends IPage<Map<String, Object>>> P selectMapsPage(P page, @Param("ew") Wrapper<T> queryWrapper);
}
```

#### 2.1.2 自定义增删改查方法

1. 使用自定义增删改查方法的流程与mybatis中操作一致
   - 在mapper接口中定义crud方法
   - 在reosources目录下创建mapper目录，创建对应的mapper.xml映射文件（是不是反过来了，默认不需要创建对应包名的mapper路径，如果是纯mapper路径需要指定？？需要测试下）
      - 如果映射文件不在mapper目录下，则需要在application.yml文件中进行配置，指定位置。
      - mybatis中正好相反，需要在resources文件目录下创建mapper.java对应报名的mapper路径
   - 在mapper.xml文件中编写sql语句
   - 调用mapper接口中的方法进行使用
2. 编写crud方法

```java
package iceriver.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import iceriver.mybatisplus.bean.User;

import java.util.Map;

/**
 * @author: INFINITY https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date: 2022/8/4 21:01
 */
public interface UserMapper extends BaseMapper<User> {
    /**
     * 自定义crud方法：根据id查询用户信息为map集合
     * @param id
     * @return
     */
    Map<String, Object> selectMapById(Long id);
}
```

3. 编写映射文件

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="iceriver.mybatisplus.mapper.UserMapper">
  
  <!--Map<String, Object> selectMapById(Long id);-->
  <select id="selectMapById" resultType="map">
    select id,name,age,email from user where id = #{id}
  </select>
</mapper>
```

- 这里resultType之所以可以直接写map，是因为mybatisplus定义的默认的类型别名。

4. 执行测试

```java
package iceriver.mybatisplus;

import iceriver.mybatisplus.bean.User;
import iceriver.mybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

/**
* @author: INFINITY https://developer.aliyun.com/profile/sagwrxp2ua66w
* @date: 2022/8/4 21:09
*/
@SpringBootTest
public class UserTests {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void testSelectMapById(){
        Map<String, Object> map = userMapper.selectMapById(1L);
        System.out.println(map);
    }
}
```

### 2.2 Service接口

1. MyBatis-Plus中有一个接口 IService和其实现类 ServiceImpl，封装了常见的业务层逻辑。
1. 由于实际开发中，service层的方法非常复杂，mybatis提供的通用service方法不能满足需求，为了既使用mybatis提供的sevice方法，又能满足实际开发的需要，可参照创建usermapper的方式，让自定义service继承自ISservice，自定义ServiceImpl既实现自定义service，又继承mybatisplus提供的ServiceImpl
   - `public interface UserService extends IService<User>`
   - `public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService`
      - 需要使用@Service注解创建bean，交给ioc容器管理
         - 或者使用配置类，使用@ConponentScan进行扫描
         - 或者在springboot 启动程序，使用@ConponentScan进行扫描
3. mybatis-plus中批量添加在service接口的方法中，底层实现批量添加的原理是循环。

### 2.3 雪花算法

#### 2.3.1 出现背景

- 需要选择合适的方案去应对数据规模的增长，以应对逐渐增长的访问压力和数据量。数据库的扩展方式主要包括：业务分库、主从复制，数据库分表。
- 实现主从表分离.

#### 2.3.2 数据库分表

1. 将不同业务数据分散存储到不同的数据库服务器，能够支撑百万甚至千万用户规模的业务，但如果业务继续发展，同一业务的单表数据也会达到单台数据库服务器的处理瓶颈。例如，淘宝的几亿用户数据，如果全部存放在一台数据库服务器的一张表中，肯定是无法满足性能要求的，此时就需要对单表数据进行拆分 。
1. 单表数据拆分有两种方式：垂直分表和水平分表。

- ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1659659388736-74b72435-ba59-45d4-95e8-19fb07864616.png#clientId=uaf8d940b-efc7-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=345&id=u5021e883&margin=%5Bobject%20Object%5D&name=image.png&originHeight=345&originWidth=649&originalType=binary&ratio=1&rotation=0&showTitle=false&size=38418&status=done&style=none&taskId=u8548c7d7-939b-4462-85b1-d6aa546e874&title=&width=649)
- 垂直分表适合将表中某些不常用且占了大量空间的列拆分出去。
- 水平分表根据表中数据的行数和实际的业务情况，对标进行拆分。

3. 水平分表的处置方式：
   - 主键自增：以最常见的用户ID为例，可以按照1000000的范围大小进行分段，1~999999放到表1中，1000000~1999999放到表2中，以此类推。
      - 复杂点：分段大小的选取。分段太小会导致切分后子表数量过多，增加维护复杂度；分段太大可能会导致单表依然存在性能问题，一般建议分段大小在100万至2000万之间。
      - 优点：可以随着数据的增加平滑地扩充新的表。例如，现在的用户是100万，如果增加到1000万，只需要增加新的表就可以了，原有的数据不需要动。
      - 缺点：分布不均匀。假如按照1000万来进行分表，有可能某个分段实际存储的数据量只有1条，而另外一个分段实际存储的数据量有1000万条。
   - 取模：同样以用户ID为例，假如我们一开始就规划了10个数据库表，可以简单地用user_id%10的值来表示数据所属的数据库表编号，ID为985的用户放到编号为5的子表中，ID为10086的用户放到编号为6的子表中。
      - 复杂点：初始表数量的确定。表数量太多维护比较麻烦，表数量太少又可能导致单表性能存在问题。
      - 优点：表分布比较均匀。
      - 缺点：扩充新的表很麻烦，所有数据都要重分布。
4. 雪花算法：水平分表的处置方式。Twitter公布的分布式主键生成算法，它能够保证不同表的主键的不重复性，以及相同表的主键的有序性。
   - 核心思想：长度共64bit（一个long型）。首先是一个符号位，1bit标识，由于long基本类型在Java中是带符号的，最高位是符号位，正数是0，负数是1，所以id一般是正数，最高位是0。41bit时间截(毫秒级)，存储的是时间截的差值（当前时间截 - 开始时间截)，结果约等于69.73年。10bit作为机器的ID（5个bit是数据中心，5个bit的机器ID，可以部署在1024个节点）。12bit作为毫秒内的流水号（意味着每个节点在每毫秒可以产生 4096 个 ID）。
      - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1659659948338-c45a9c48-746e-4c52-b7fc-7c7e7a431dc4.png#clientId=uaf8d940b-efc7-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=178&id=u1c7e9d59&margin=%5Bobject%20Object%5D&name=image.png&originHeight=178&originWidth=597&originalType=binary&ratio=1&rotation=0&showTitle=false&size=47115&status=done&style=none&taskId=ucead0634-41ff-42e0-bc3c-3f5918bf05f&title=&width=597)
   - 优点：整体上按照时间自增排序，并且整个分布式系统内不会产生ID碰撞，并且效率较高。

## 第3章 注解

### 3.1 @MapperScan

1. 配置在spring boot启动程序类上，指定扫描的mapper包

### 3.2 @TableName

1. 用于实体类pojo前，指定数据库中表名与实体类的对应关系。
1. 未指定改属性时，由basemapper的范型决定表名与实体类的对应关系，对应不上就会报错。
1. 也可以在application.yml核心配置文件中使用`mybatis-plus.global-config.db-config.table-prefix: t_`进行全局设置

### 3.3 @TableId

1. mybatis-plus在crud时，默认将字段名为id的列作为主键。
1. 如果表中主键的列名不是id，则会把主键列识别为普通列。
1. 此时可以在实体类pojo的主键列属性前使用改注解，将该属性标记为主键。
1. value属性：解决实体类pojo中的主键名与表中主键名不一致问题。可以使用value属性设置实体类pojo属性与表中主键名的对应关系。当只设置value时，value可以省略，直接写值。
1. type属性：设置主键生成策略。默认为IdType.ASSIGN_ID，为雪花算法，IdType.AUTO表示使用数据库设置的自增策略，但必须保证数据库进行了设置，否则报错。
1. 全局配置主键生成策略：在application.yml核心配置文件中使用`mybatis-plus.global.db-config.id-type: auto`

### 3.4 @TableField

1. 设置非主键字段实体类pojo中的属性名与数据库表中字段名的对应关系。
1. 指定表中非主键的字段名（属性可以在表中有，也可以没有，没有时使用exist=false）。

### 3.5 @TableLogic

1. 逻辑删除：在表中设置一个字段，标记字段的状态。
   - 逻辑删除会将删除功能变为修改功能，修改了标记为逻辑删除字段的值。
   - 逻辑删除后，查询不会显示。
   - 方式一：在数据库表中，给字段设置默认值，根据表中设置的默认值判断，如果默认值为0，则表示处于未删除状态，为其他值，表示删除状态。（好像也不用）
   - 方式二：在核心配置文件中使用mybatis-plus.global-config.db-config.logic-delete-value设置逻辑已删除值和mybatis-plus.global-config.db-config.logic-not-delete-value设置逻辑未删除值（可以不配置）
2. 使用场景：数据恢复。
2. @TableLogic标记逻辑删除的字段。

### 3.6 @Version

- 标识乐观锁本版好号字段
- 需要在配置类中开启乐观锁插件

### 3.7@EnumValue

- 根据实体类中取值为枚举类型的属性，创建枚举类
- 在枚举类中，将对应在实体类中的属性指定为枚举
  - 解释：如User实体类的属性sex，创建SexEunm的枚举类，在SexEnum中设定属性sex，给SexEnum中sex指定注解@EunmValue
- 需要在核心配置文件中开启通用枚举扫描：`mybatis-plus:.typeEnumsPackage: iceriver.mybatisplus.enums`

### 3.8 @DS

- 指定数据源，参数名称在核心配置文件中设定
- 可以用在类上，也可以用有在方法上，同时遵循就近原则

## 第4章 条件构造器

### 4.1 wapper介绍

1. BaseMapper中crud等方法传入的条件。
1. ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1659660893144-fe071a70-8296-4b82-b16a-b9e7c3d488e9.png#clientId=uaf8d940b-efc7-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=341&id=ud31d0cf1&margin=%5Bobject%20Object%5D&name=image.png&originHeight=341&originWidth=658&originalType=binary&ratio=1&rotation=0&showTitle=false&size=83429&status=done&style=none&taskId=u57eb0ad0-2d33-4efd-9f46-4281014d7ff&title=&width=658)
1. Wrapper ： 条件构造抽象类，最顶端父类
   - AbstractWrapper ： 用于查询条件封装，生成 sql 的 where 条件
      - QueryWrapper ： 查询条件封装
      - UpdateWrapper ： Update 条件封装
      - AbstractLambdaWrapper ： 使用Lambda 语法
         - LambdaQueryWrapper ：用于Lambda语法使用的查询Wrapper
         - LambdaUpdateWrapper ： Lambda 更新封装Wrapper

### 4.2 QueryWapper

1. 组装查询条件

```java
@SpringBootTest
public class QueryWapperTests {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void test01(){
//        查询用户名包含a，年龄在20到30之间的所有用户信息
//        SELECT id,name,age,email FROM user WHERE (name LIKE ? AND age BETWEEN ? AND ? AND email IS NOT NULL)
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", "a")
                    .between("age",20,30)
                    .isNotNull("email");
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(user -> System.out.print(user));
    }
}
```

- like()、between()等这些方法中传入的是表中的列名，不是pojo中的属性名。
- between()可以使用gt()、lt()代替

2. 组装排序条件

```java
@SpringBootTest
public class QueryWapperTests {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void test02(){
//        按年龄降序查询用户，如果年龄相同则按id升序排列
//        SELECT id,name,age,email FROM user ORDER BY age DESC,id ASC
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("age")
                    .orderByAsc("id");
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(user -> System.out.print(user));
    }
}
```

3. 组装删除功能

```java
@SpringBootTest
public class QueryWapperTests {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void test03(){
//        删除邮箱地址为null的用户
//        DELETE FROM user WHERE (email IS NULL)
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNull("email");
        int result = userMapper.delete(queryWrapper);
        System.out.println("result" + result);
    }
}
```

- 如果启用了逻辑删除功能，对应的删除sql语句会变为修改语句。

4. 组装修改功能

```java
@SpringBootTest
public class QueryWapperTests {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void test04(){
//        将（年龄大于20并且用户名包含a）或者邮箱为null的用户信息修改
//        UPDATE user SET name=?, email=? WHERE (age > ? AND name LIKE ? OR email IS NULL)
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("age", 20)
                    .like("name", "a")
                    .or()
                    .isNull("email");
        User user1 = new User();
        user1.setName("xiaoming");
        user1.setEmail("123@qq.com");
        int result = userMapper.update(user1, queryWrapper);
        System.out.println("result" + result);
    }
}
```

- 如果开启了逻辑删除，则逻辑删除后的不会被修改
- 注意OR查询条件在mybatis-plus中的用法（不传参，起拼接作用）

5. 组装查询优先级
   - 主要是mybatis-plus的条件构造器中lambda中的条件优先执行
   - 为了能够写lambda，`并且`这个查询条件不再用`.`代替，而是用`and()`

```java
@SpringBootTest
public class QueryWapperTests {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void test05(){
//        将用户名包含a并且（年龄大于20或者邮箱为null）的用户信息修改
//        mybatis-plus的条件构造器中lambda中的条件优先执行
//        UPDATE user SET name=?, email=? WHERE (name LIKE ? AND (age > ? AND email IS NULL))
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", "a")
                    .and(i -> i.gt("age", 20).isNull("email"));
        User user1 = new User();
        user1.setName("dazhuang");
        user1.setEmail("312@qq.com");
        int result = userMapper.update(user1, queryWrapper);
        System.out.println("result" + result);
    }
}
```

- 如果开启了逻辑删除，则逻辑删除后的不会被修改

6. 组装查询指定列

```java
@SpringBootTest
public class QueryWapperTests {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void test06(){
//        查询用户名、年龄、邮箱
//        SELECT name,age,email FROM user
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("name", "age", "email");
        List<Map<String, Object>> users = userMapper.selectMaps(queryWrapper);
        users.forEach(user -> System.out.println(user));
    }
}
```

7. 组装子查询

```java
@SpringBootTest
public class QueryWapperTests {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void test07(){
//        查询id小于等于100的用户
//        SELECT id,name,age,email FROM user WHERE (id IN (select id from user where id<=100))
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.inSql("id", "select id from user where id<=100");
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(user -> System.out.println(user));
    }
}
```

### 4.3 UpdateWapper

1. 组装修改条件（按照上文第5项修改）

```java
@SpringBootTest
public class UpdateWrapperTests {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void test01(){
//        将用户名包含a并且（年龄大于20或者邮箱为null）的用户信息修改
//        UPDATE user SET name=?,email=? WHERE (name LIKE ? AND (age > ? AND email IS NULL))
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.like("name", "i")
                     .and(i -> i.gt("age", 20).isNull("email"));
        updateWrapper.set("name","大王").set("email", "newd@sina.com");
        int result = userMapper.update(null, updateWrapper);
        System.out.println("result" + result);
    }
}
```

### 4.4 模拟开发中根据提交数据组装条件

1. 手动判断组装——利用mybatis-plus提供的工具类

```java
@SpringBootTest
public class ConditionTests {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void test01() {
//        SELECT id,name,age,email FROM user WHERE (age >= ? AND age <= ?)
        String name = "";
        Integer ageBegin = 20;
        Integer ageEnd = 30;

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(name)) {
            //isNotBlank判断某个字符创是否不为空字符串、不为null、不为空白符
            queryWrapper.like("user_name", name);
        }
        if (ageBegin != null) {
            queryWrapper.ge("age", ageBegin);
        }
        if (ageEnd != null) {
            queryWrapper.le("age", ageEnd);
        }
        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }
}
```

2. 使用带condition参数的重载方法构建查询条件

```java
@SpringBootTest
public class ConditionTests {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void test02() {
//        SELECT id,name,age,email FROM user WHERE (age >= ? AND age <= ?)
        String name = "";
        Integer ageBegin = 20;
        Integer ageEnd = 30;

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(name), "user_name", name)
                .ge(ageBegin != null, "age", ageBegin)
                .le(ageEnd != null, "age", ageEnd);
        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }
}
```

### 4.4 LambdaQueryWrapper

- 解决查询时不小心写错字段名的问题

```java
@SpringBootTest
public class LambdaQueryWrapperTests {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void test01() {
//        SELECT id,name,age,email FROM user WHERE (age >= ? AND age <= ?)
        String name = "";
        Integer ageBegin = 20;
        Integer ageEnd = 30;

        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(StringUtils.isNotBlank(name), User::getName, name)
                .ge(ageBegin != null, User::getAge, ageBegin)
                .le(ageEnd != null, User::getAge, ageEnd);
        List<User> list = userMapper.selectList(lambdaQueryWrapper);
        list.forEach(System.out::println);
    }
```

### 4.5 LambdaUpdateWrapper

- 解决修改时不小心写错字段名的问题

```java
@SpringBootTest
public class LambdaUpdateWrapperTests {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void test01(){
//        将用户名包含a并且（年龄大于20或者邮箱为null）的用户信息修改
//        UPDATE user SET name=?,email=? WHERE (name LIKE ? AND (age > ? AND email IS NULL))
        LambdaUpdateWrapper<User> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        lambdaUpdateWrapper.like(User::getName, "i")
                           .and(i -> i.gt(User::getAge, 20).isNull(User::getEmail));
        lambdaUpdateWrapper.set(User::getName,"大王").set(User::getEmail, "newd@sina.com");
        int result = userMapper.update(null, lambdaUpdateWrapper);
        System.out.println("result" + result);
    }
}
```

## 第5章 插件

### 5.1 分页插件

#### 5.1.1 使用mybatisplus的分页方法

1. 创建分页配置类：config.MyBatisPlusConfig.java
1. 使用@Configuration指定为配置类
   - 由于在springboot的启动类上已经使用了@MapperScan注解，所以配置类可以不使用@MapperScan注解
   - 但是为了程序规范化、语义化，建议将@MapperScan注解添加到配置类上
3. 编写分页器方法

```java
package iceriver.mybatisplus.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: INFINITY https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date: 2022/8/5 11:05
 */
@Configuration
public class MyBatisPlusConfig {
    /**
     * 定义了名为mybatisPlusInterceptor，返回类型为MybatisPlusInterceptor的方法
     * @return
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }
}
```

4. 测试：

```java
package iceriver.mybatisplus;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import iceriver.mybatisplus.bean.User;
import iceriver.mybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author: INFINITY https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date: 2022/8/5 11:16
 */
@SpringBootTest
public class MyBatisPlusPluginsTests {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void test(){
        Page<User> page = new Page<>(1, 3);
        Page<User> page1 = userMapper.selectPage(page, null);
        System.out.println(page);
        System.out.println("-------------------");
        System.out.println(page1==page);//true
    }
}
```

#### 5.1.2 自定义分页方法

1. 使用自定义分页方法的流程与mybatis中操作一致
   - 在mapper接口中定义分页方法
   - 在reosources目录下创建mapper目录，创建对应的mapper.xml映射文件
      - 如果映射文件不在mapper目录下，则需要在application.yml文件中进行配置使用mybatis-plus.mapper-location，指定位置。
   - 在mapper.xml文件中编写sql语句
   - 调用mapper接口中的方法进行使用
2. 编写分页方法

```java
package iceriver.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import iceriver.mybatisplus.bean.User;

import java.util.Map;

/**
 * @author: INFINITY https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date: 2022/8/4 21:01
 */
public interface UserMapper extends BaseMapper<User> {
    /**
     * 自定义分页查询方法：根据年龄查询用户信息并分页
     * @param page mybatis-plus提供的分页对象，必须位于第一个参数的位置
     * @param age
     * @return
     */
    Page<User> selectPageVo(@Param("page") Page<User> page,
                            @Param("age") Integer age);
}
```

- 自定义方法中，`Page<T>`对象必须作为第一个参数

3. 编写sql映射文件

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="iceriver.mybatisplus.mapper.UserMapper">
    <!--    Page<User> selectPageVo(@Param("page") Page<User> page, @Param("age") Integer age);-->
  <select id="selectPageVo" resultType="User">
    select uid,user_name,age,email from t_user where age > #{age}
  </select>  
</mapper>
```

- 这里resultType实用类型别名，指定类型别名要在springboot核心配置文件中进行设定：`mybatis-plus.type-aliases-package: iceriver.mybatisplus.pojo`

4. 测试方法：

```java
package iceriver.mybatisplus;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import iceriver.mybatisplus.bean.User;
import iceriver.mybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
* @author: INFINITY https://developer.aliyun.com/profile/sagwrxp2ua66w
* @date: 2022/8/4 21:09
*/
@SpringBootTest
public class UserTests {
    @Autowired
    private UserMapper userMapper;
    
    @Test
    public void testPageVo(){
        Page<User> page = new Page<>(1,3);
        Page<User> page1 = userMapper.selectPageVo(page, 20);
        System.out.println(page);
        System.out.println(page1);
        System.out.println(page==page1);
    }
}
```

### 5.2 乐观锁

#### 5.2.1 乐观锁悲观锁介绍

1. 场景：

> 一件商品，成本价是80元，售价是100元。老板先是通知小李，说你去把商品价格增加50元。小李正在玩游戏，耽搁了一个小时。正好一个小时后，老板觉得商品价格增加到150元，价格太高，可能会影响销量。又通知小王，你把商品价格降低30元。此时，小李和小王同时操作商品后台系统。小李操作的时候，系统先取出商品价格100元；小王也在操作，取出的商品价格也是100元。小李将价格加了50元，并将100+50=150元存入了数据库；小王将商品减了30元，并将100-30=70元存入了数据库。是的，如果没有锁，小李的操作就完全被小王的覆盖了。现在商品价格是70元，比成本价低10元。几分钟后，这个商品很快出售了1千多件商品，老板亏1万多。

2. 乐观锁与悲观锁

> 上面的故事，如果是乐观锁，小王保存价格前，会检查下价格是否被人修改过了。如果被修改过了，则重新取出的被修改后的价格，150元，这样他会将120元存入数据库。如果是悲观锁，小李取出数据后，小王只能等小李操作完之后，才能对价格进行操作，也会保证最终的价格是120元

3. 乐观锁要求数据表有表示数据版本的字段，在修改前，乐观锁会检查一下最新的数据版本版与自己持有的版本号是否一致。

#### 5.2.2 模拟修改冲突

1. 创建商品表

```sql
CREATE TABLE t_product
(
  id BIGINT(20) NOT NULL COMMENT '主键ID',
  NAME VARCHAR(30) NULL DEFAULT NULL COMMENT '商品名称',
  price INT(11) DEFAULT 0 COMMENT '价格',
  VERSION INT(11) DEFAULT 0 COMMENT '乐观锁版本号',
  PRIMARY KEY (id)
);
INSERT INTO t_product (id, NAME, price) VALUES (1, '外星人笔记本', 100);
```

2. 创建实体类

```java
package iceriver.mybatisplus.bean;

import lombok.Data;

/**
 * @author: INFINITY https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date: 2022/8/5 14:47
 */
@Data
public class Product {
    private Long id;
    private String name;
    private Integer price;
    private Integer version;
}
```

3. 创建mapper接口

```java
package iceriver.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import iceriver.mybatisplus.bean.Product;

/**
 * @author: INFINITY https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date: 2022/8/5 14:49
 */
public interface ProductMapper extends BaseMapper<Product> {
}
```

4. 测试

```java
package iceriver.mybatisplus;

import iceriver.mybatisplus.bean.Product;
import iceriver.mybatisplus.mapper.ProductMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author: INFINITY https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date: 2022/8/5 14:49
 */
@SpringBootTest
public class ProductMapperTests {
    @Autowired
    private ProductMapper productMapper;
    @Test
    public void  test(){
        //1. 小李查询商品价格
        Product productL = productMapper.selectById(1);
        System.out.println("小李查询的商品价格" + productL.getPrice());
        //2. 小王查询商品价格
        Product productW = productMapper.selectById(1);
        System.out.println("小王查询的商品价格" + productW.getPrice());
        System.out.println("----------修改价格前------------");
        //3. 小李对商品价格+50
        productL.setPrice(productL.getPrice() + 50);
        productMapper.updateById(productL);
        //4. 小王对商品价格-30
        System.out.println("小王查询的商品价格" + productW.getPrice());
        productW.setPrice(productW.getPrice() - 30);
        productMapper.updateById(productL);
        System.out.println("----------修改价格后------------");
        //5. 老板检查价格
        Product productB = productMapper.selectById(1);
        System.out.println("老板查询的商品价格" + productB.getPrice());
    }
}
```

#### 5.2.3 mybatis-plus乐观锁插件

1. 实体类中添加乐观锁版本号注解@Version
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1659688919504-55d5902e-fd61-46de-9eac-39c8d18a48ad.png#clientId=uaf8d940b-efc7-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=215&id=u8613ceac&margin=%5Bobject%20Object%5D&name=image.png&originHeight=215&originWidth=263&originalType=binary&ratio=1&rotation=0&showTitle=false&size=16333&status=done&style=none&taskId=u54889807-bba9-4686-8769-d86c2fa870e&title=&width=263)
2. 配置类中开启乐观锁插件

```java
package iceriver.mybatisplus.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: INFINITY https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date: 2022/8/5 16:38
 */
@Configuration
public class MyConfig {
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
        return interceptor;
    }
}
```

- 此时老板获得的价格为150，因为小李的修改会执行，小王的修改不会执行。
- 小王如果想要修改成功，可以进行判断，修改不成功重新获取最新版本的数据进行修改

```java
package iceriver.mybatisplus;

import iceriver.mybatisplus.bean.Product;
import iceriver.mybatisplus.mapper.ProductMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author: INFINITY https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date: 2022/8/5 14:49
 */
@SpringBootTest
public class ProductMapperTests {
    @Autowired
    private ProductMapper productMapper;
    @Test
    public void  test02(){
        //1. 小李查询商品价格
        Product productL = productMapper.selectById(1);
        System.out.println("小李查询的商品价格" + productL.getPrice());
        //2. 小王查询商品价格
        Product productW = productMapper.selectById(1);
        System.out.println("小王查询的商品价格" + productW.getPrice());
        System.out.println("----------修改价格前------------");
        //3. 小李对商品价格+50
        productL.setPrice(productL.getPrice() + 50);
        productMapper.updateById(productL);
        //4. 小王对商品价格-30
        System.out.println("小王查询的商品价格" + productW.getPrice());
        productW.setPrice(productW.getPrice() - 30);

        int result = productMapper.updateById(productW);
        if(result == 0){
            Product product = productMapper.selectById(1);
            product.setPrice(product.getPrice() - 30);
            productMapper.updateById(product);
        }

        productMapper.updateById(productL);
        System.out.println("----------修改价格后------------");
        //5. 老板检查价格
        Product productB = productMapper.selectById(1);
        System.out.println("老板查询的商品价格" + productB.getPrice());
    }
}
```

## 第6章 扩展

### 6.1 通用枚举

1. user数据表添加sex字段，用整数1、2表示男、女
1. User实体类定义SexEnum类型的属性sex
1. 创建SexEunm的枚举类，定义属性sex和sexNmae，并用@EnumValue注解标识sex属性
1. 在springboot核心配置文件中开启通用枚举扫描：`mybatis-plus:.typeEnumsPackage: iceriver.mybatisplus.enums`

### 6.2 代码生成器

与mybatis中的逆向工程插件类似，不过mybatis的逆向工程只能生成实体类、dao层mappper和mapper映射文件。
而mybatis-plus可以生成上述文件外，还能生成controller和service及serviceimpl

1. 创建新模块
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1659692726829-c1cf2bb3-96b5-4f6e-ac2c-79ee2a1fcd75.png#clientId=uaf8d940b-efc7-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=625&id=ua7120a9b&margin=%5Bobject%20Object%5D&name=image.png&originHeight=625&originWidth=721&originalType=binary&ratio=1&rotation=0&showTitle=false&size=56205&status=done&style=none&taskId=u9a7f8d5e-5a54-448e-997f-9c5848d34b0&title=&width=721)
2. 添加依赖：mybatis-plus-generator和freemarker

```xml
<dependency>
  <groupId>com.baomidou</groupId>
  <artifactId>mybatis-plus-generator</artifactId>
  <version>3.5.1</version>
</dependency>
<dependency>
  <groupId>org.freemarker</groupId>
  <artifactId>freemarker</artifactId>
  <version>2.3.31</version>
</dependency>
```

3. 创建测试类，执行main方法

```java
package iceriver.mybatisplus;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
* @author: INFINITY https://developer.aliyun.com/profile/sagwrxp2ua66w
* @date: 2022/8/5 17:54
*/
public class FastAutoGeneratorTest {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://127.0.0.1:13306/mybatis_plus?characterEncoding=utf-8&userSSL=false", "root", "dimitre123")
            .globalConfig(builder -> {
                builder.author("zhuyuqi") // 设置作者
                    //.enableSwagger() // 开启 swagger 模式
                    .fileOverride() // 覆盖已生成文件
                    .outputDir("D:\\PracticalExercise\\16.MyBatis-Plus\\plus04-generator\\mybatis_plus_generate_code"); // 指定输出目录
            })
            .packageConfig(builder -> {
                builder.parent("iceriver") // 设置父包名
                    .moduleName("mybatisplus") // 设置父包模块名
                    .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "D:\\PracticalExercise\\16.MyBatis-Plus\\plus04-generator\\mybatis_plus_generate_code")); // 设置mapperXml生成路径
            })
            .strategyConfig(builder -> {
                builder.addInclude("user") // 设置需要生成的表名
                    //.addTablePrefix("t_", "c_")// 设置过滤表前缀
                    ;
            })
            .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
            .execute();
    }
}
```

![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1659693799119-ca200b6b-cc26-40c1-bae7-b13791d027ad.png#clientId=uaf8d940b-efc7-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=169&id=u7a320ec9&margin=%5Bobject%20Object%5D&name=image.png&originHeight=169&originWidth=1203&originalType=binary&ratio=1&rotation=0&showTitle=false&size=49404&status=done&style=none&taskId=uf29dcb37-ff3d-439a-ac61-bea69b3b1a7&title=&width=1203)
![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1659693808006-d5b47311-cee6-449b-8761-2f72a99df0a8.png#clientId=uaf8d940b-efc7-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=223&id=ud35d298d&margin=%5Bobject%20Object%5D&name=image.png&originHeight=223&originWidth=818&originalType=binary&ratio=1&rotation=0&showTitle=false&size=21285&status=done&style=none&taskId=u9384fe84-dede-4138-8032-33a61a66338&title=&width=818)

### 6.3 多数据源

1. 使用场景：表分散在多库、读写分离、一主多从、混合模式
1. 创建数据库及表：
   - 第一个使用mybatis_plus库、user表
   - 第二个使用mybatis_plus_01库、product表
2. 新建模块
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1659694450169-6b20f6b2-bc65-4582-aa1a-2d00cda08215.png#clientId=uaf8d940b-efc7-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=625&id=u45402167&margin=%5Bobject%20Object%5D&name=image.png&originHeight=625&originWidth=721&originalType=binary&ratio=1&rotation=0&showTitle=false&size=56463&status=done&style=none&taskId=u8fd3063e-b8b0-48d7-b207-fc9d0c28bfd&title=&width=721)
3. 引入依赖：mybaitis-plus、lombok、mysql、dynamic-datasource-spring-boot-starter

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>2.7.2</version>
    <relativePath/> <!-- lookup parent from repository -->
  </parent>
  <groupId>iceriver.mybatisplus</groupId>
  <artifactId>plus05-datasources</artifactId>
  <version>0.0.1-SNAPSHOT</version>
  <name>plus05-datasources</name>
  <description>plus05-datasources</description>
  <properties>
    <java.version>1.8</java.version>
  </properties>
  <dependencies>
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter</artifactId>
    </dependency>
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-test</artifactId>
      <scope>test</scope>
    </dependency>
    
    <dependency>
      <groupId>mysql</groupId>
      <artifactId>mysql-connector-java</artifactId>
      <scope>runtime</scope>
    </dependency>
    
    <dependency>
      <groupId>org.projectlombok</groupId>
      <artifactId>lombok</artifactId>
      <optional>true</optional>
    </dependency>
    
    <dependency>
      <groupId>com.baomidou</groupId>
      <artifactId>mybatis-plus-boot-starter</artifactId>
      <version>3.5.1</version>
    </dependency>
    
    <dependency>
      <groupId>com.baomidou</groupId>
      <artifactId>dynamic-datasource-spring-boot-starter</artifactId>
      <version>3.5.0</version>
    </dependency>
  </dependencies>
  
  <build>
    <plugins>
      <plugin>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-maven-plugin</artifactId>
      </plugin>
    </plugins>
  </build>
</project>
```

4. 在springboot核心配置文件中添加多数据源

```xml
spring:
  # 配置数据源信息
  datasource:
    dynamic:
      # 设置默认的数据源或者数据源组,默认值即为master
      primary: master
      # 严格匹配数据源,默认false.true未匹配到指定数据源时抛异常,false使用默认数据源
      strict: false
      datasource:
        master:
          url: jdbc:mysql://localhost:13306/mybatis_plus?characterEncoding=utf-8&useSSL=false
          driver-class-name: com.mysql.cj.jdbc.Driver
          username: root
          password: dimitre123
        slave_1:
          url: jdbc:mysql://localhost:13306/mybatis_plus_01?characterEncoding=utf-8&useSSL=false
          driver-class-name: com.mysql.cj.jdbc.Driver
          username: root
          password: dimitre123
```

5. 创建相关的实体类、service、mapper
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1659696078093-f2b62834-e06b-4cf1-8ac4-841bab7b4325.png#clientId=uaf8d940b-efc7-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=340&id=u99f0df0b&margin=%5Bobject%20Object%5D&name=image.png&originHeight=340&originWidth=357&originalType=binary&ratio=1&rotation=0&showTitle=false&size=23766&status=done&style=none&taskId=uda14ce1a-d79f-4962-8805-118adc7b8f7&title=&width=357)
   - UserServiceImpl使用@DS("master")指定为主数据源
   - ProductServiceImpl使用@DS("master")指定为主数据源
6. 执行测试

```java
package iceriver.mybatisplus;

import iceriver.mybatisplus.bean.Product;
import iceriver.mybatisplus.mapper.ProductMapper;
import iceriver.mybatisplus.mapper.UserMapper;
import iceriver.mybatisplus.service.ProductService;
import iceriver.mybatisplus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Plus05DatasourcesApplicationTests {
    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;
    @Test
    public void test(){
        System.out.println(userService.getById(1));
        System.out.println(productService.getById(1));
    }
}
```

### 6.4 MyBatisX插件

#### 6.4.1 基本介绍

1. MyBatis-Plus为我们提供了强大的mapper和service模板，能够大大的提高开发效率但是在真正开发过程中，MyBatis-Plus并不能为我们解决所有问题，例如一些复杂的SQL，多表联查，我们就需要自己去编写代码和SQL语句，我们该如何快速的解决这个问题呢，这个时候可以使用MyBatisX插件
1. MyBatisX一款基于 IDEA 的快速开发插件，为效率而生
1.
1. 安装插件
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1659697674802-0561f33f-814a-4a87-920d-acd401cc883c.png#clientId=uaf8d940b-efc7-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=121&id=ud4e29187&margin=%5Bobject%20Object%5D&name=image.png&originHeight=121&originWidth=328&originalType=binary&ratio=1&rotation=0&showTitle=false&size=8815&status=done&style=none&taskId=ufb1e8160-ec90-45dc-8214-2ba4dc0aff2&title=&width=328)
5. 功能：
   - 可以快速定位mapper类和映射文件
      - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1659698085186-165bfca0-d7c8-44a4-a2f5-809add46b886.png#clientId=uaf8d940b-efc7-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=67&id=u023e5674&margin=%5Bobject%20Object%5D&name=image.png&originHeight=67&originWidth=540&originalType=binary&ratio=1&rotation=0&showTitle=false&size=8933&status=done&style=none&taskId=ubbe78765-073e-4f05-83c9-e3e859ca89f&title=&width=540)
   - 代替本文6.2代码生成器[https://www.yuque.com/zhuyuqi/zna9x5/hientp#W0v7A](#W0v7A)，并可视化操作生成过程。
   - 快速生成自定义curd方法
6. mapper映射文件的路径设置参见本文2.1.2第1点设置mapper文件路径[https://www.yuque.com/zhuyuqi/zna9x5/hientp#JebDR](#JebDR)

#### 6.4.2 mybatisx快速代码生成

1. 创建模块：
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1659698197863-31f3a3bc-7002-4f7e-af86-e36f45a95a38.png#clientId=uaf8d940b-efc7-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=625&id=u2f34ec6f&margin=%5Bobject%20Object%5D&name=image.png&originHeight=625&originWidth=721&originalType=binary&ratio=1&rotation=0&showTitle=false&size=56080&status=done&style=none&taskId=u86cf2be1-2ebd-4c26-a69b-ab1ecfc9134&title=&width=721)
2. 引入依赖：mybaitis-plus、lombok、mysql

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>2.7.2</version>
    <relativePath/> <!-- lookup parent from repository -->
  </parent>
  <groupId>iceriver.mybatisplus</groupId>
  <artifactId>plus06-mybatisx</artifactId>
  <version>0.0.1-SNAPSHOT</version>
  <name>plus06-mybatisx</name>
  <description>plus06-mybatisx</description>
  <properties>
    <java.version>1.8</java.version>
  </properties>
  <dependencies>
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter</artifactId>
    </dependency>
    
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-test</artifactId>
      <scope>test</scope>
    </dependency>
    
    <dependency>
      <groupId>mysql</groupId>
      <artifactId>mysql-connector-java</artifactId>
      <scope>runtime</scope>
    </dependency>
    
    <dependency>
      <groupId>org.projectlombok</groupId>
      <artifactId>lombok</artifactId>
      <optional>true</optional>
    </dependency>
    
    <dependency>
      <groupId>com.baomidou</groupId>
      <artifactId>mybatis-plus-boot-starter</artifactId>
      <version>3.5.1</version>
    </dependency>
  </dependencies>
  
  <build>
    <plugins>
      <plugin>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-maven-plugin</artifactId>
      </plugin>
    </plugins>
  </build>
</project>
```

3. applicaiton.yml核心配置文件中配置数据源

```xml
spring:
  # 配置数据源信息
  datasource:
    type: com.zaxxer.hikari.HikariDataSource
    url: jdbc:mysql://localhost:13306/mybatis_plus?characterEncoding=utf-8&useSSL=false
    driver-class-name: com.mysql.cj.jdbc.Driver
    username: root
    password: dimitre123
```

4. 在IDEA中连接数据库：
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1659698504507-bca089e9-1b4a-4e1a-8b14-db86216ee693.png#clientId=uaf8d940b-efc7-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=600&id=udfa7ee93&margin=%5Bobject%20Object%5D&name=image.png&originHeight=600&originWidth=738&originalType=binary&ratio=1&rotation=0&showTitle=false&size=82290&status=done&style=none&taskId=u7fe7d4d7-74c4-4300-a7e5-8eb8d9c0456&title=&width=738)
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1659698597031-4d610d14-9e57-4e3b-a651-1b5fbdf699f1.png#clientId=uaf8d940b-efc7-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=677&id=ub1dfb2c5&margin=%5Bobject%20Object%5D&name=image.png&originHeight=677&originWidth=800&originalType=binary&ratio=1&rotation=0&showTitle=false&size=59930&status=done&style=none&taskId=u2339b8f8-8679-4d5d-be6e-1a0d03a4d06&title=&width=800)
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1659698631044-9ba8daa9-bf24-4341-9570-e8b8085a5ca7.png#clientId=uaf8d940b-efc7-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=226&id=u8ac6520a&margin=%5Bobject%20Object%5D&name=image.png&originHeight=226&originWidth=646&originalType=binary&ratio=1&rotation=0&showTitle=false&size=20254&status=done&style=none&taskId=u0a5c8f84-2caf-4703-bc9c-c0a5fa2b57f&title=&width=646)
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1659698799412-36fca1d5-c216-4eb7-a253-b9c61e83e971.png#clientId=uaf8d940b-efc7-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=471&id=u2a57e47d&margin=%5Bobject%20Object%5D&name=image.png&originHeight=471&originWidth=984&originalType=binary&ratio=1&rotation=0&showTitle=false&size=33281&status=done&style=none&taskId=u3957b32d-daaf-4054-b14b-e1354bc5b7c&title=&width=984)
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1659698910002-5107fe40-9455-4054-8d2f-d70670347135.png#clientId=uaf8d940b-efc7-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=471&id=u62af602b&margin=%5Bobject%20Object%5D&name=image.png&originHeight=471&originWidth=1064&originalType=binary&ratio=1&rotation=0&showTitle=false&size=52643&status=done&style=none&taskId=u8a1d4ac0-3148-46b0-a7dc-04d68a7c0b0&title=&width=1064)
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1659698964321-10a1b54d-026c-4d1b-b314-9e884b73b3f8.png#clientId=uaf8d940b-efc7-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=366&id=ube9589aa&margin=%5Bobject%20Object%5D&name=image.png&originHeight=366&originWidth=390&originalType=binary&ratio=1&rotation=0&showTitle=false&size=24077&status=done&style=none&taskId=uc80dab8a-5ccd-4ac5-aaea-b7562a3aaec&title=&width=390)

#### 6.4.3 自定义CURD（快速生成xml中sql）

1. 以插入为例，输入insert，选择insertSelective
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1659699159924-b2e1f485-eeb8-4c1b-a14a-160b12db2088.png#clientId=uaf8d940b-efc7-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=212&id=u33dc8b4c&margin=%5Bobject%20Object%5D&name=image.png&originHeight=212&originWidth=612&originalType=binary&ratio=1&rotation=0&showTitle=false&size=40959&status=done&style=none&taskId=u5efaca41-13f3-498b-a125-38167a67461&title=&width=612)
2. 按下alt+enter，选择第二个，会快速生成mapper方法和sql
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1659699220698-bcdf6049-edbd-4bf9-befe-63ba0a583d3d.png#clientId=uaf8d940b-efc7-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=144&id=ua2c41f85&margin=%5Bobject%20Object%5D&name=image.png&originHeight=144&originWidth=581&originalType=binary&ratio=1&rotation=0&showTitle=false&size=15991&status=done&style=none&taskId=ud52bc66d-0146-464c-94e5-6fa3d1b740f&title=&width=581)
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1659699341541-94968d2c-8f73-4038-8d53-fc669bd298c9.png#clientId=uaf8d940b-efc7-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=392&id=ucccadde2&margin=%5Bobject%20Object%5D&name=image.png&originHeight=392&originWidth=584&originalType=binary&ratio=1&rotation=0&showTitle=false&size=27851&status=done&style=none&taskId=ue28e4dcb-8278-4881-a6e9-bb0cc2da7be&title=&width=584)
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1659699466652-99dae616-42ca-4ee6-8eef-318f89ce45a5.png#clientId=uaf8d940b-efc7-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=77&id=u5a73b0cf&margin=%5Bobject%20Object%5D&name=image.png&originHeight=77&originWidth=495&originalType=binary&ratio=1&rotation=0&showTitle=false&size=10413&status=done&style=none&taskId=u1f1d4078-d9bf-437e-a52c-85cfba8db7a&title=&width=495)
   - ![image.png](https://cdn.nlark.com/yuque/0/2022/png/1604140/1659699456180-1160fe93-8b5e-454f-a51e-9185f384eac3.png#clientId=uaf8d940b-efc7-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=431&id=u032238ac&margin=%5Bobject%20Object%5D&name=image.png&originHeight=431&originWidth=620&originalType=binary&ratio=1&rotation=0&showTitle=false&size=68626&status=done&style=none&taskId=ud3e5986c-d337-4d82-8797-fb8b1ef464c&title=&width=620)
