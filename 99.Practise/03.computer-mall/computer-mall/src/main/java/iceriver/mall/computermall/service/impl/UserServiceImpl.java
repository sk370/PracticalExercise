package iceriver.mall.computermall.service.impl;

import iceriver.mall.computermall.entity.User;
import iceriver.mall.computermall.mapper.UserMapper;
import iceriver.mall.computermall.service.IUserService;
import iceriver.mall.computermall.service.ex.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.UUID;

/**
 * @author: INFINITY https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date: 2022/8/9 18:57
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public void reg(User user) {
        String username = user.getUsername();

        User result = userMapper.findByUsername(username);
        if(result != null){
            throw new UsernameDuplicatedException("用户名" + username + "已被占用！");
        }

        String password = user.getPassword();
        String salt = UUID.randomUUID().toString().toUpperCase();//随机生成盐值
        user.setSalt(salt);
        user.setPassword(this.getMD5Password(password, salt));//加密密码

        user.setIsDelete(0);//逻辑未删除
        user.setModifiedUser(user.getUsername());
        user.setCreatedUser(user.getUsername());
        Date date = new Date();
        user.setModifiedTime(date);
        user.setCreatedTime(date);

        Integer rows = userMapper.insert(user);
        if(rows != 1){
            throw new InsertException("添加用户数据出现未知错误，请联系系统管理员");
        }
    }

    @Override
    public User login(String username, String password) {
        User user = userMapper.findByUsername(username);
        if(user == null){
            throw new UserNotFoundException("用户数据不存在！");
        }
        if(user.getIsDelete() == 1){
            throw new UserNotFoundException("用户数据不存在！");
        }

        String salt = user.getSalt();
        String md5Password = this.getMD5Password(password, salt);

        if(!user.getPassword().equals(md5Password)){
            throw new PasswordNotMatchException("用户密码错误！");
        }
        User forWebUser = new User();//需要保存到session的对象
        forWebUser.setUsername(user.getUsername());
        forWebUser.setUid(user.getUid());
        forWebUser.setAvatar(user.getAvatar());
        return forWebUser;
    }

    @Override
    public void changePassword(Integer uid, String username, String oldPassword, String newPassword) {
        User user = userMapper.findByUid(uid);
        if(user == null || user.getIsDelete() == 1){
            throw new UserNotFoundException("用户数据不存在");//讲道理不需要判断，因为修改密码只能在登录情况下进行，既然登陆了，那这个用户肯定存在
        }
        String oldMd5Password = this.getMD5Password(oldPassword, user.getSalt());
        if(!user.getPassword().equals(oldMd5Password)){
            throw new PasswordNotMatchException("原密码不正确！");
        }
        String newMd5Password = this.getMD5Password(newPassword, user.getSalt());
        Integer rows = userMapper.updatePasswordByUid(uid, newMd5Password, username, new Date());
        if(rows != 1){
            throw new UpdateException("修改密码出现未知异常！");
        }
    }

    @Override
    public User getByUid(Integer uid) {
        User result = userMapper.findByUid(uid);
        if (result == null) {
            throw new UserNotFoundException("用户数据不存在");//如果登陆了不应该有这个异常
        }
        if (1 == result.getIsDelete()) {
            throw new UserNotFoundException("用户数据不存在");//如果登陆了不应该有这个异常
        }
        return result;
    }

    @Override
    public void changeInfo(Integer uid, String username, User user) {
        User result = userMapper.findByUid(uid);
        if (result == null) {
            throw new UserNotFoundException("用户数据不存在");//如果登陆了不应该有这个异常
        }
        if (result.getIsDelete().equals(1)) {
            throw new UserNotFoundException("用户数据不存在");//如果登陆了不应该有这个异常
        }

        user.setUid(uid);
        user.setModifiedUser(username);
        user.setModifiedTime(new Date());
        Integer rows = userMapper.updateInfoByUid(user);
        if (rows != 1) {
            throw new UpdateException("更新用户数据时出现未知错误，请联系系统管理员");
        }
    }

    @Override
    public void changeAvatar(Integer uid, String username, String avatar) {
        User result = userMapper.findByUid(uid);
        if (result == null) {
            throw new UserNotFoundException("用户数据不存在");
        }
        if (result.getIsDelete().equals(1)) {
            throw new UserNotFoundException("用户数据不存在");
        }
        Date now = new Date();
        Integer rows = userMapper.updateAvatarByUid(uid, avatar, username, now);
        if (rows != 1) {
            throw new UpdateException("更新用户数据时出现未知错误，请联系系统管理员");
        }
    }

    /**
     * 利用盐值进行md5密码加密
     * @param password
     * @param salt
     * @return
     */
    private String getMD5Password(String password, String salt){
        for (int i = 0; i < 3; i++) {
            password = DigestUtils.md5DigestAsHex((salt + password + salt).getBytes()).toUpperCase();//算法：密码 = 盐值 + password + 盐值
        }
        return password;
    }


}
