package iceriver.mall.computermall.mapper;

import iceriver.mall.computermall.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @author: INFINITY https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date: 2022/8/9 17:05
 */
@SpringBootTest
@RunWith(SpringRunner.class)//用JUnit加载Spring的配置文件以完成Context的初始化，然后从Context中取出Bean并完成测试
public class UserMapperTests {
    @Autowired
    UserMapper userMapper;//报红原因为idea检测中，接口不能创建bean，mybaits在运行过程中使用动态代理来创建该接口的实现类
    @Test
    public void insert(){
        User user = new User();
        user.setUsername("tim");
        user.setPassword("123");
        Integer insert = userMapper.insert(user);
        System.out.println(insert);
    }
    @Test
    public void updatePasswordByUid(){
        userMapper.updatePasswordByUid(1,"123", "管理员", new Date());
    }

    @Test
    public void updateInfoByUid(){
        User user = new User();
        user.setUid(6);
        user.setPhone("15454143346");
        user.setEmail("123154@sa.com");
        userMapper.updateInfoByUid(user);
    }
}

