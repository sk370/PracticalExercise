package com.atguigu.ggkt.wechat.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.atguigu.ggkt.exception.GgktException;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.ggkt.model.wechat.Menu;
import com.atguigu.ggkt.vo.wechat.MenuVo;
import com.atguigu.ggkt.wechat.mapper.MenuMapper;
import com.atguigu.ggkt.wechat.service.MenuService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * <p>
 * 订单明细 订单明细 服务实现类
 * </p>
 *
 * @author zhuyuqi
 * @since 2022-09-16
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {
    @Autowired
    private WxMpService wxMpService;

    /**
     * 获取一级菜单
     *
     * @return
     */
    @Override
    public List<Menu> findMenuOneInfo() {
        QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parent_id", 0);
        List<Menu> parentMenus = baseMapper.selectList(queryWrapper);
        return parentMenus;
    }

    /**
     * 组装树形菜单
     *
     * @return
     */
    @Override
    public List<MenuVo> findMenuInfo() {
        // 1. 查询所有菜单数据
        List<Menu> menus = baseMapper.selectList(null);

        // 2. 查找父菜单（parent_id=0）
        List<Menu> parentMenuList = menus.stream()
                .filter(parentMenu -> parentMenu.getParentId().longValue() == 0)
                .collect(Collectors.toList());//longValue()转换为long类型

        // 3. 封装数据进行返回
        List<MenuVo> parentMenuVos = new ArrayList<>();
        // 3.1 将父级菜单的menu转换为menuvo
        for (Menu parentMenu : parentMenuList) {
            MenuVo parentMenuVo = new MenuVo();
            BeanUtils.copyProperties(parentMenu, parentMenuVo);

            // 3.2 给父级menuvo组装子元素
            List<MenuVo> sonMenuVos = new ArrayList<>();
            List<Menu> sonMenuList = menus.stream()
                    .filter(sonMenu -> sonMenu.getParentId() == parentMenu.getId())
                    .collect(Collectors.toList());//longValue()转换为long类型
            for(Menu sonMenu : sonMenuList){
                MenuVo sonMenuVo = new MenuVo();
                BeanUtils.copyProperties( sonMenu, sonMenuVo);
                sonMenuVos.add(sonMenuVo);
            }
            parentMenuVo.setChildren(sonMenuVos);//组装子菜单
            parentMenuVos.add(parentMenuVo);
        }

        return parentMenuVos;
    }

    /**
     * 同步公众号菜单
     */
    @Override
    public void syncMenu() {
        // 1. 获取所有菜单数据
        List<MenuVo> menuVoList = this.findMenuInfo();
        // 2. 按照微信要求的菜单字符串格式进项菜单数据转换
        JSONArray buttonList = new JSONArray();
        // 2.1 封装一级菜单
        for(MenuVo oneMenuVo : menuVoList){
            JSONObject one = new JSONObject();
            one.put("name", oneMenuVo.getName());

            // 2.2 封装二级菜单
            JSONArray subButton = new JSONArray();
            for (MenuVo twoMenuVo : oneMenuVo.getChildren()){
                JSONObject view = new JSONObject();
                view.put("type", twoMenuVo.getType());

                if(twoMenuVo.getType().equals("view")) {
                    view.put("name", twoMenuVo.getName());
//                    view.put("url", "http://ggkt2.vipgz1.91tunnel.com/#"+twoMenuVo.getUrl());//老师的
                    view.put("url", "http://ggkt.sk370.top:81/#"+twoMenuVo.getUrl());//vue-mobile的地址
                } else {
                    view.put("name", twoMenuVo.getName());
                    view.put("key", twoMenuVo.getMeunKey());
                }

                subButton.add(view);
            }

            one.put("sub_button", subButton);
            buttonList.add(one);
        }

        // 3. 按照微信要求的菜单字符串格式进行最后的拼接
        JSONObject button = new JSONObject();
        button.put("button", buttonList);

        try {
            String menuId = wxMpService.getMenuService().menuCreate(button.toJSONString());//同步菜单到微信平台
            System.out.println("menuId" +  menuId);
        } catch (WxErrorException e) {
            e.printStackTrace();
            throw new GgktException(20001, "微信公众号菜单同步失败");
        }
    }

    /**
     * 删除公众号菜单
     */
    @Override
    public void removeMenu() {
        try {
            wxMpService.getMenuService().menuDelete();
        } catch (WxErrorException e) {
            e.printStackTrace();
            throw new GgktException(20001, "微信公众号菜单删除失败");
        }
    }
}
