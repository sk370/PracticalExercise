package iceriver.mall.computermall.mapper;

import iceriver.mall.computermall.entity.Address;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @author: INFINITY https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date: 2022/8/10 21:14
 */
public interface AddressMapper {
    /**
     * 插入收货地址数据
     * @param address 收货地址数据
     * @return 受影响的行数
     */
    Integer insert(Address address);
    /**
     * 统计某用户的收货地址数据的数量 最大可设置20个
     * @param uid 用户的id
     * @return 该用户的收货地址数据的数量
     */
    Integer countByUid(Integer uid);

    /**
     * 查询某用户的收货地址列表数据，默认地址优先显示，其他地址按照修改事件排序
     * @param uid 收货地址归属的用户id
     * @return 该用户的收货地址列表数据
     */
    List<Address> findByUid(Integer uid);

    /**
     * 将某用户的所有收货地址设置为非默认地址
     * @param uid 收货地址归属的用户id
     * @return 受影响的行数
     */
    Integer updateNonDefaultByUid(Integer uid);

    /**
     * 将指定的收货地址设置为默认地址
     * @param aid 收货地址id
     * @param modifiedUser 修改执行人
     * @param modifiedTime 修改时间
     * @return 受影响的行数
     */
    Integer updateDefaultByAid(
            @Param("aid") Integer aid,
            @Param("modifiedUser") String modifiedUser,
            @Param("modifiedTime") Date modifiedTime);

    /**
     * 根据收货地址aid值，查询收货地址详情
     * @param aid 收货地址id
     * @return 匹配的收货地址详情，如果没有匹配的数据，则返回null
     */
    Address findByAid(Integer aid);

    /**
     * 根据收货地址id删除数据
     * @param aid 收货地址id
     * @return 受影响的行数
     */
    Integer deleteByAid(Integer aid);

    /**
     * 查询某用户最后修改的收货地址
     * @param uid 归属的用户id
     * @return 该用户最后修改的收货地址，如果该用户没有收货地址数据则返回null
     */
    Address findLastModified(Integer uid);

    /**
     * 修改用户收获地址信息
     * @param aid
     */
    void updateAddress(Integer aid, Address address);
}
