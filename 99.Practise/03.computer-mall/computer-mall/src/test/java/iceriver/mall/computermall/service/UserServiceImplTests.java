package iceriver.mall.computermall.service;

import iceriver.mall.computermall.entity.User;
import iceriver.mall.computermall.service.ex.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author: INFINITY https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date: 2022/8/9 19:10
 */
@SpringBootTest
@RunWith(SpringRunner.class)//用JUnit加载Spring的配置文件以完成Context的初始化，然后从Context中取出Bean并完成测试
public class UserServiceImplTests {
    @Autowired
    IUserService userService;

    @Test
    public void reg() {
        try {
            User user = new User();
            user.setUsername("张三3");
            user.setPassword("12391023");
            userService.reg(user);
            System.out.println("注册成功！");
        } catch (ServiceException e) {
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void login(){
        try{
            User user = userService.login("罗翔", "1231");
            System.out.println(user);
        }catch (ServiceException e) {
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void changePassword(){
        try {
            userService.changePassword(6, "管理员", "1231", "123");
        } catch (ServiceException e) {
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
        }
    }
}