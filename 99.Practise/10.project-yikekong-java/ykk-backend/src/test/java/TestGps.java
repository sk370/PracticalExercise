import com.yikekong.YkkApplication;
import com.yikekong.entity.GPSEntity;
import com.yikekong.service.impl.GpsServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author iceri
 * @create 2025/6/24 22:03
 */
@SpringBootTest(classes = YkkApplication.class)
@RunWith(SpringRunner.class)
public class TestGps {
    @Autowired
    GpsServiceImpl gpsService;

    @Test
    public void testGpsEntity(){
        GPSEntity gps = gpsService.getGps();
        System.out.println(gps);
    }
}
