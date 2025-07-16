package iceriver.mall.computermall;

import iceriver.mall.computermall.entity.User;
import iceriver.mall.computermall.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
class ComputerMallApplicationTests {
    @Autowired
    private DataSource dataSource;

    @Test
    void contextLoads() {
    }

    @Test
    public void testConnction() throws SQLException {
        System.out.println(dataSource.getConnection());
    }
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
}
