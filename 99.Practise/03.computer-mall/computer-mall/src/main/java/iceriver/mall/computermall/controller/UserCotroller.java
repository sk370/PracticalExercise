package iceriver.mall.computermall.controller;

import iceriver.mall.computermall.controller.ex.*;
import iceriver.mall.computermall.entity.User;
import iceriver.mall.computermall.service.IUserService;
import iceriver.mall.computermall.service.ex.InsertException;
import iceriver.mall.computermall.service.ex.UsernameDuplicatedException;
import iceriver.mall.computermall.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author: INFINITY https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date: 2022/8/9 19:47
 */
@RestController
@RequestMapping("users")
public class UserCotroller extends BaseController {
    @Autowired
    private IUserService userService;

    /**
     * 继承BaseController后，如果没异常，则由UserCotroller中的方法处理请求，返回new JSONResult<>(OK);
     *                      如果有异常，则由BaseController中的方法处理请求，返回方法的执行结果;
     * @param user
     * @return
     */
    @RequestMapping("reg")
    public JSONResult<Void> reg(User user){
        userService.reg(user);
        return new JSONResult<>(OK);
    }
    @RequestMapping("login")
    public JSONResult<User> reg(String username, String password, HttpSession session){
        User user = userService.login(username, password);
        session.setAttribute("uid", user.getUid());
        session.setAttribute("username", user.getUsername());
        return new JSONResult<>(OK, user);
    }
    @RequestMapping("change_password")
    public JSONResult<User> changePassword(String oldPassword, String newPassword, HttpSession session){
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        userService.changePassword(uid, username, oldPassword, newPassword);
        return new JSONResult<>(OK);
    }
    @GetMapping("get_by_uid")
    public JSONResult<User> getByUid(HttpSession session) {
        Integer uid = getUidFromSession(session);
        User data = userService.getByUid(uid);
        return new JSONResult<>(OK, data);
    }

    @RequestMapping("change_info")
    public JSONResult<Void> changeInfo(User user, HttpSession session) {
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        userService.changeInfo(uid, username, user);
        return new JSONResult<>(OK);
    }

    @RequestMapping("change_avatar")
    public JSONResult<String> changeAvatar(HttpSession session, @RequestParam("file") MultipartFile file) {
        if(file.isEmpty()){
            throw new FileEmptyException("文件为空！");
        }
        if(file.getSize() > AVATAR_MAX_SIZE){
            throw new FileSizeException("文件大小超限！");
        }
        String type = file.getContentType();
        if(!AVATAR_TYPE.contains(type)){
            throw new FileTypeException("文件类型不支持！");
        }
        String upload = session.getServletContext().getRealPath("upload");
        System.out.println(session.getServletContext());
        System.out.println(session.getServletContext().getRealPath("/"));
        System.out.println(upload);
        File dir = new File(upload);//带文件名的路径
        if(!dir.exists()){
            dir.mkdir();
        }
        String originalFilename = file.getOriginalFilename();//获取文件名
        int index = originalFilename.lastIndexOf(".");
        String suffix = originalFilename.substring(index);//获取文件后缀——扩展名
        String fileName = UUID.randomUUID().toString().toUpperCase() + suffix;
        File dest = new File(dir, fileName);//创建空文件
        try {
            file.transferTo(dest);//将上传的file文件写入到dest
        } catch (FileStateException e) {
            throw new FileStateException("文件状态异常");
        } catch (IOException e) {
            throw new FileUploadException("文件读写异常");
        }

        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        String avatar = "/upload/" + fileName;
        userService.changeAvatar(uid, username, avatar);
        return new JSONResult<>(OK, avatar);
    }

    public static final int AVATAR_MAX_SIZE = 10 * 1024 *1024;
    public static final List<String> AVATAR_TYPE = new ArrayList<>();

    /**
     * 初始化上传文件类型
     */
    static {
        AVATAR_TYPE.add("image/jpeg");
        AVATAR_TYPE.add("image/png");
        AVATAR_TYPE.add("image/bmp");
        AVATAR_TYPE.add("image/gif");
    }
}
