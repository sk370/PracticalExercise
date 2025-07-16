import com.yikekong.YkkApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author iceri
 * @create 2025/6/18 22:57
 */
@SpringBootTest(classes = YkkApplication.class)
@RunWith(SpringRunner.class)
public class TestLogin {
    @Test
    public void testLogin() throws Exception{
        String loginName = "admin";
        String password = "admin";
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println("=================");
        System.out.println(passwordEncoder.encode(password));
    }
}
