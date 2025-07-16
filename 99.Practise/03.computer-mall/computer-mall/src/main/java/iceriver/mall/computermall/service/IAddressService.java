package iceriver.mall.computermall.service;

import iceriver.mall.computermall.entity.Address;

import java.util.List;

/**
 * @author: INFINITY https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date: 2022/8/10 21:47
 */
public interface IAddressService {
    /**
     * 创建新地址
     * @param uid 当前登录用户
     * @param username 创建人
     * @param address 地址对象
     */
    void addNewAddress(Integer uid, String username, Address address);
    /**
     * 查询某用户的收货地址列表数据
     * @param uid 收货地址归属的用户id
     * @return 该用户的收货地址列表数据
     */
    List<Address> getByUid(Integer uid); /**
     * 设置默认收货地址
     * @param aid 收货地址id
     * @param uid 归属的用户id
     * @param username 当前登录的用户名
     */
    void setDefault(Integer aid, Integer uid, String username);

    /**
     * 删除收货地址
     * @param aid 收货地址id
     * @param uid 归属的用户id
     * @param username 当前登录的用户名
     */
    void delete(Integer aid, Integer uid, String username);

    /**
     * 根据收货地址数据的id，查询收货地址详情
     * @param aid 收货地址id
     * @param uid 归属的用户id
     * @return 匹配的收货地址详情
     */
    Address getByAid(Integer aid, Integer uid);

    /**
     * 根据aid修改收获地址信息
     * @param aid
     * @param username
     * @param address
     */
    void updateAddress(Integer aid, String username, Address address);
}
