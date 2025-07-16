package iceriver.mall.computermall.controller;

import iceriver.mall.computermall.controller.ex.*;
import iceriver.mall.computermall.entity.User;
import iceriver.mall.computermall.service.ex.*;
import iceriver.mall.computermall.utils.JSONResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpSession;

/**
 * 控制类基类，主要用于异常捕获及处理
 * @author: INFINITY https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date: 2022/8/9 20:04
 */
public class BaseController {
    public static final int OK = 200;

    /**
     * 统一处理service层的异常，有ServiceException会自动执行被@ExceptionHandler的秀芳
     * @return
     */
    @ExceptionHandler({ServiceException.class, FileUploadException.class})//springboot提供的异常处理注解，统一处理抛出的异常
    public JSONResult<Void> handleException(Throwable e){
        JSONResult<Void> result = new JSONResult<>();
        if(e instanceof UsernameDuplicatedException) {
            result.setState(4000);
            result.setMessage("用户名已存在！");
        }else if (e instanceof InsertException ){
            result.setState(4001);
            result.setMessage("注册时产生未知的异常！");
        }else if (e instanceof UserNotFoundException){
            result.setState(4002);
            result.setMessage("用户数据不存在！");
        }else if (e instanceof PasswordNotMatchException){
            result.setState(4003);
            result.setMessage("密码不匹配！");
        }else if (e instanceof AddressCountLimitException){
            result.setState(5000);
            result.setMessage("收货地址已达20个，无法新增！");
        }else if (e instanceof AddressNotFoundException){
            result.setState(5001);
            result.setMessage("用户的收获地址数据不存在！");
        }else if (e instanceof AccessDeniedException){
            result.setState(5002);
            result.setMessage("收获地址非法访问异常！");
        }else if (e instanceof DeleteException){
            result.setState(5003);
            result.setMessage("删除收获地址异常！");
        }else if (e instanceof FileEmptyException) {
            result.setState(6000);
            result.setMessage("上传文件为空！");
        } else if (e instanceof FileSizeException) {
            result.setState(6001);
            result.setMessage("文件大小超出限制！");
        } else if (e instanceof FileTypeException) {
            result.setState(6002);
            result.setMessage("文件类型不匹配！");
        } else if (e instanceof FileStateException) {
            result.setState(6003);
            result.setMessage("文件状态异常！");
        } else if (e instanceof FileUploadIOException) {
            result.setState(6004);
            result.setMessage("文件读写异常！");
        }
        return result;
    }

    /**
     * 获取session对象中的uid
     * @param session
     * @return
     */
    protected final Integer getUidFromSession(HttpSession session){
        return Integer.valueOf(session.getAttribute("uid").toString());
    }
    /**
     * 获取session对象中的username
     * @param session
     * @return
     */
    protected final String getUsernameFromSession(HttpSession session){
        return session.getAttribute("username").toString();
    }
}
