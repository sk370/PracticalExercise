package com.atguigu.ggkt.order.controller;


import com.atguigu.ggkt.model.order.OrderInfo;
import com.atguigu.ggkt.order.service.OrderInfoService;
import com.atguigu.ggkt.result.Result;
import com.atguigu.ggkt.vo.order.OrderInfoQueryVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sf.jsqlparser.statement.select.Limit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p>
 * 订单表 订单表 前端控制器
 * </p>
 *
 * @author zhuyuqi
 * @since 2022-09-16
 */
@RestController
@Api(tags = "订单接口")
@RequestMapping("admin/order/orderInfo")
public class OrderInfoController {
    @Autowired
    private OrderInfoService orderInfoService;

    @ApiOperation("订单列表分页")
    @GetMapping("{page}/{limit}")
    public Result listOrder(@PathVariable Long page, @PathVariable Long limit, OrderInfoQueryVo orderInfoQueryVo){
        Page<OrderInfo> pageParam = new Page<>(page, limit);

//        Page<OrderInfo> page1 = orderInfoService.page(pageParam);//不带查询条件的分页【默认方法】

        Map<String, Object> orderInfoPage =  orderInfoService.selectOrderInfoPage(pageParam, orderInfoQueryVo);//带条件查询，除了查到orderinfo，还能查到orderdetail
        return Result.ok(orderInfoPage);
    }


}

