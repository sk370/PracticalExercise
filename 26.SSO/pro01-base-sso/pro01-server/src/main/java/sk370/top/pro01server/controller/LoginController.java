package sk370.top.pro01server.controller;

import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @author zhuyuqi
 * @version v0.0.1
 * @className LoginController
 * @description https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date 2022/11/05 10:01
 */
@Controller
public class LoginController {
    @Autowired
    StringRedisTemplate redisTemplate;

    @GetMapping("login.html")
    public String longinPage(@RequestParam("redirect_url") String url, Model model, @CookieValue(value = "sso_token", required = false) String sso_token){
        if (!StringUtils.isEmpty(sso_token)){
            // 说明已经有人登陆过，有了指定cookie
            return "redirect:" + url + "?token=" + sso_token;//路径中带token参数，主要是为了让别？
        }
        model.addAttribute("url", url);//?
        return "login";
    }

    @PostMapping("/doLogin")
    public String doLogin(@RequestParam("username") String username,
                          @RequestParam("password") String password,
                          @RequestParam("url") String url,
                          HttpServletResponse response){
        if(!StringUtils.isEmpty(username) && !StringUtils.quoteIfString(password)){
            String uuid = UUID.randomUUID().toString().replace("-", "");
            redisTemplate.opsForValue().set(uuid, username);//将用户信息存入redis

            Cookie sso_token = new Cookie("sso_token", uuid);
            response.addCookie(sso_token);//用于不同域名间共享

            return "redirect:" + url + "?token=" + uuid;
        }

        return "login";
    }
}
