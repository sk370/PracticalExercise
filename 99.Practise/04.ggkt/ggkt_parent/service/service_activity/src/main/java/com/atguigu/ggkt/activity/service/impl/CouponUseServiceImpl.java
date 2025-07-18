package com.atguigu.ggkt.activity.service.impl;

import com.atguigu.ggkt.activity.mapper.CouponUseMapper;
import com.atguigu.ggkt.activity.service.CouponUseService;
import com.atguigu.ggkt.model.activity.CouponUse;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 优惠券领用表 服务实现类
 * </p>
 *
 * @author zhuyuqi
 * @since 2022-09-16
 */
@Service
public class CouponUseServiceImpl extends ServiceImpl<CouponUseMapper, CouponUse> implements CouponUseService {
}
