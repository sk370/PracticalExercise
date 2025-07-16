package iceriver.mall.computermall.mapper;

import iceriver.mall.computermall.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * @author: INFINITY https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date: 2022/8/9 16:40
 */
public interface UserMapper {
    /**
     * 注册用户
     * @param user 用户信息
     * @return 受影响的行数
     */
    Integer insert(User user);

    /**
     * 根据用户名查找用户
     * @param username 用户名
     * @return 找到时返回用户对象，失败返回null
     */
    User findByUsername(String username);

    /**
     * 根据uid查找用户
     * @param uid
     * @return 找到时返回用户对象，失败返回null
     */
    User findByUid(Integer uid);

    /**
     * 根据用户uid修改密码
     * @param uid
     * @return 受影响的行数
     */
    Integer updatePasswordByUid(Integer uid, String password, String modifiedUser, Date modifiedTime);

    /**
     * 根据用户uid修改信息
     * @return
     */
    Integer updateInfoByUid(User user);
    /**
     * 根据uid更新用户的头像
     * @param uid 用户的id
     * @param avatar 新头像的路径
     * @param modifiedUser 修改执行人
     * @param modifiedTime 修改时间
     * @return 受影响的行数
     */
    Integer updateAvatarByUid(
            @Param("uid") Integer uid,
            @Param("avatar") String avatar,
            @Param("modifiedUser") String modifiedUser,
            @Param("modifiedTime") Date modifiedTime);

}
