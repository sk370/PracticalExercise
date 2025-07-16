package iceriver.mall.computermall.service;

import iceriver.mall.computermall.entity.User;

/**
 * @author: INFINITY https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date: 2022/8/9 18:56
 */
public interface IUserService {
    /**
     * 用户注册
     * @param user
     */
    void reg(User user);

    /**
     * 用户登录
     * @param username
     * @param password
     * @return 登录成功返回用户数据，不成功返回null
     */
    User login(String username, String password);

    /**
     * 修改密码
     * @param uid
     * @param username 修改人
     * @param oldPassword
     * @param newPassword
     */
    void changePassword(Integer uid, String username, String oldPassword, String newPassword);

    /**
     * 获取当前登录的用户的信息
     * @param uid 当前登录的用户的id
     * @return 当前登录的用户的信息
     */
    User getByUid(Integer uid);

    /**
     * 修改用户资料
     * @param uid 当前登录的用户的id
     * @param username 当前登录的用户名
     * @param user 用户的新的数据
     */
    void changeInfo(Integer uid, String username, User user);

    /**
     * 修改用户头像
     * @param uid 当前登录的用户的id
     * @param username 当前登录的用户名
     * @param avatar 用户的新头像的路径
     */
    void changeAvatar(Integer uid, String username, String avatar);
}
