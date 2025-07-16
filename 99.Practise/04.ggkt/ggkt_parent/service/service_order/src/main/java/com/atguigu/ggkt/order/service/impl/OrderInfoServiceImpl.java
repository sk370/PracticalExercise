package com.atguigu.ggkt.order.service.impl;

import com.atguigu.ggkt.client.activity.CouponInfoFeignClient;
import com.atguigu.ggkt.client.course.CourseFeignClient;
import com.atguigu.ggkt.client.user.UserInfoFeignClient;
import com.atguigu.ggkt.enums.ResultCodeEnum;
import com.atguigu.ggkt.exception.GgktException;
import com.atguigu.ggkt.model.activity.CouponInfo;
import com.atguigu.ggkt.model.order.OrderDetail;
import com.atguigu.ggkt.model.order.OrderInfo;
import com.atguigu.ggkt.model.user.UserInfo;
import com.atguigu.ggkt.model.vod.Course;
import com.atguigu.ggkt.order.mapper.OrderInfoMapper;
import com.atguigu.ggkt.order.service.OrderDetailService;
import com.atguigu.ggkt.order.service.OrderInfoService;
import com.atguigu.ggkt.utils.AuthContextHolder;
import com.atguigu.ggkt.utils.OrderNoUtils;
import com.atguigu.ggkt.vo.order.OrderFormVo;
import com.atguigu.ggkt.vo.order.OrderInfoQueryVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 订单表 订单表 服务实现类
 * </p>
 *
 * @author zhuyuqi
 * @since 2022-09-16
 */
@Service
public class OrderInfoServiceImpl extends ServiceImpl<OrderInfoMapper, OrderInfo> implements OrderInfoService {
    @Autowired
    private OrderDetailService orderDetailService;
    @Autowired
    private CourseFeignClient courseFeignClient;
    @Autowired
    private CouponInfoFeignClient couponInfoFeignClient;
    @Autowired
    private UserInfoFeignClient userInfoFeignClient;

    @Override
    public Map<String, Object> selectOrderInfoPage(Page<OrderInfo> pageParam, OrderInfoQueryVo orderInfoQueryVo) {
        // 1. 获取并封装查询条件
        QueryWrapper<OrderInfo> queryWrapper = new QueryWrapper<>();
        Long userId = orderInfoQueryVo.getUserId();
        String outTradeNo = orderInfoQueryVo.getOutTradeNo();
        String phone = orderInfoQueryVo.getPhone();
        String createTimeBegin = orderInfoQueryVo.getCreateTimeBegin();
        String createTimeEnd = orderInfoQueryVo.getCreateTimeEnd();
        Integer orderStatus = orderInfoQueryVo.getOrderStatus();
        if(!StringUtils.isEmpty(userId)){
            queryWrapper.eq("user_id", userId);
        }
        if(!StringUtils.isEmpty(outTradeNo)){
            queryWrapper.eq("out_trade_no", outTradeNo);
        }
        if(!StringUtils.isEmpty(phone)){
            queryWrapper.eq("phone", phone);
        }
        if(!StringUtils.isEmpty(createTimeBegin)){
            queryWrapper.ge("create_time", createTimeBegin);//大于等于
        }
        if(!StringUtils.isEmpty(createTimeEnd)){
            queryWrapper.le("create_time", createTimeEnd);//小于等于
        }
        if(!StringUtils.isEmpty(orderStatus)){
            queryWrapper.eq("order_status", orderStatus);//小于等于
        }

        // 2. 查询orderinfo
        Page<OrderInfo> orderInfoPage = baseMapper.selectPage(pageParam, queryWrapper);
        long totalCount = orderInfoPage.getTotal();
        long pageCount = orderInfoPage.getPages();//总页数
        List<OrderInfo> records = orderInfoPage.getRecords();//所有订单orderinfo

        // 3. 查询orderdetail
        //如果不使用steam流，则操作步骤为：遍历records。根据orderId查询orderdetail
        records.stream().forEach(item -> this.getOrderDetail(item));

        // 4. 组装orderinfo和ordertetail，创建一个map进行返回
        Map<String, Object> map = new HashMap<>();
        map.put("total", totalCount);
        map.put("pageCount", pageCount);
        map.put("records", records);

        return map;
    }

    /**
     * 生成订单
     * @param orderFormVo
     * @return
     */
    @Override
    public Long submitOrder(OrderFormVo orderFormVo) {
        //1. 获取生成订单条件值
        Long userId = AuthContextHolder.getUserId();
        Long courseId = orderFormVo.getCourseId();
        Long couponId = orderFormVo.getCouponId();

        //2. 判断当前用户是否已生成订单
        LambdaQueryWrapper<OrderDetail> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(OrderDetail::getCourseId, courseId);
        queryWrapper.eq(OrderDetail::getUserId, userId);
        OrderDetail orderDetailExist = orderDetailService.getOne(queryWrapper);
        if(orderDetailExist != null){
            return orderDetailExist.getId(); //如果订单已存在，则直接返回订单id
        }

        //3. 根据课程id查询课程信息
        Course course = courseFeignClient.getById(courseId);
        if (course == null) {
            throw new GgktException(ResultCodeEnum.DATA_ERROR.getCode(),
                    ResultCodeEnum.DATA_ERROR.getMessage());
        }

        //4. 根据用户id查询用户信息
        UserInfo userInfo = userInfoFeignClient.getById(userId);
        if (userInfo == null) {
            throw new GgktException(ResultCodeEnum.DATA_ERROR.getCode(),
                    ResultCodeEnum.DATA_ERROR.getMessage());
        }

        //5. 根据用户id查询优惠券信息
        BigDecimal couponReduce = new BigDecimal(0);
        if(null != couponId) {//当前用户有优惠券
            CouponInfo couponInfo = couponInfoFeignClient.getById(couponId);
            couponReduce = couponInfo.getAmount();
        }

        //6. 封装生成订单需要的条件
        //6.1 封装
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setUserId(userId);
        orderInfo.setNickName(userInfo.getNickName());
        orderInfo.setPhone(userInfo.getPhone());
        orderInfo.setProvince(userInfo.getProvince());
        orderInfo.setOriginAmount(course.getPrice());
        orderInfo.setCouponReduce(couponReduce);
        orderInfo.setFinalAmount(orderInfo.getOriginAmount().subtract(orderInfo.getCouponReduce()));//根据原价、优惠券，计算支付价格
        orderInfo.setOutTradeNo(OrderNoUtils.getOrderNo());//订单号
        orderInfo.setTradeBody(course.getTitle());
        orderInfo.setOrderStatus("0");
        this.save(orderInfo);//this即basemapper

        //6.2 封装订单详情
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderId(orderInfo.getId());
        orderDetail.setUserId(userId);
        orderDetail.setCourseId(courseId);
        orderDetail.setCourseName(course.getTitle());
        orderDetail.setCover(course.getCover());
        orderDetail.setOriginAmount(course.getPrice());
        orderDetail.setCouponReduce(new BigDecimal(0));
        orderDetail.setFinalAmount(orderDetail.getOriginAmount().subtract(orderDetail.getCouponReduce()));
        orderDetailService.save(orderDetail);

        //7. 更新优惠券状态
        if(null != orderFormVo.getCouponUseId()) {//是否使用优惠券
            couponInfoFeignClient.updateCouponInfoUseStatus(orderFormVo.getCouponUseId(), orderInfo.getId());
        }

        //8. 返回订单号
        return orderInfo.getId();
    }

    /**
     * 根据订单id查询详情
     * @param orderInfo
     * @return
     */
    private OrderInfo getOrderDetail(OrderInfo orderInfo) {
        Long orderInfoId = orderInfo.getId();

        OrderDetail orderDetail = orderDetailService.getById(orderInfoId);//一对一关系，两个id一样
        if(orderDetail != null){
            String courseName = orderDetail.getCourseName();
            orderInfo.getParam().put("courseName", courseName);//param是BaseEntity的自定义的参数，而OrderInfo继承了BaseEntity
        }
        return orderInfo;
    }
}
