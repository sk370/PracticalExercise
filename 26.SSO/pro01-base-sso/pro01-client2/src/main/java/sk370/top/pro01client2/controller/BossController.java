package sk370.top.pro01client2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @author zhuyuqi
 * @version v0.0.1
 * @className BossController
 * @description https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date 2022/11/05 10:19
 */
@Controller
public class BossController {
    @Autowired
    StringRedisTemplate redisTemplate;

    @GetMapping("/boss")
    public String boss(Model model, HttpSession session, @RequestParam(value = "token",required = false) String token){
        if(!StringUtils.isEmpty(token)){
            String username = redisTemplate.opsForValue().get(token);
            session.setAttribute("loginUser",username);
        }
        if(session.getAttribute("loginUser") == null){
            return "redirect:http://localhost80" +
        }
    }
}
