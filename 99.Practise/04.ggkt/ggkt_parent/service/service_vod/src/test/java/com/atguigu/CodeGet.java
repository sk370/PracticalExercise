package com.atguigu;


import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class CodeGet {

    public static void main(String[] args) {

        // 1、创建代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 2、全局配置
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        //gc.setOutputDir(projectPath + "/src/main/java");
//        gc.setOutputDir("D:\\PracticalExercise\\99.Practise\\04.ggkt\\ggkt_parent\\service\\service_activity"+"/src/main/java");
//        gc.setOutputDir("D:\\PracticalExercise\\99.Practise\\04.ggkt\\ggkt_parent\\service\\service_user"+"/src/main/java");
        gc.setOutputDir("D:\\PracticalExercise\\99.Practise\\04.ggkt\\ggkt_parent\\service\\service_wechat"+"/src/main/java");

        gc.setServiceName("%sService");	//设置Service接口的首字母I
        gc.setAuthor("zhuyuqi");
        gc.setOpen(false);
        mpg.setGlobalConfig(gc);

        // 3、数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:13306/glkt_wechat");
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("dimitre123");
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);

        // 4、包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName("wechat"); //模块名
        pc.setParent("com.atguigu.ggkt");
        pc.setController("controller");
        pc.setEntity("entity");
        pc.setService("service");
        pc.setMapper("mapper");
        mpg.setPackageInfo(pc);

        // 5、策略配置
        StrategyConfig strategy = new StrategyConfig();

//        strategy.setInclude("video_visitor");
//        strategy.setInclude("order_info", "order_detail");
//        strategy.setInclude("coupon_info", "coupon_use");
//        strategy.setInclude("user_info");
        strategy.setInclude("menu");

        strategy.setNaming(NamingStrategy.underline_to_camel);//数据库表映射到实体的命名策略

        strategy.setColumnNaming(NamingStrategy.underline_to_camel);//数据库表字段映射到实体的命名策略
        strategy.setEntityLombokModel(true); // lombok 模型 @Accessors(chain = true) setter链式操作

        strategy.setRestControllerStyle(true); //restful api风格控制器
        strategy.setControllerMappingHyphenStyle(true); //url中驼峰转连字符

        mpg.setStrategy(strategy);

        // 6、执行
        mpg.execute();
    }
}
