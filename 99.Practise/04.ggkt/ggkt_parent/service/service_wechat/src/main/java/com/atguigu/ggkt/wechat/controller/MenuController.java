package com.atguigu.ggkt.wechat.controller;


import com.alibaba.fastjson.JSONObject;
import com.atguigu.ggkt.exception.GgktException;
import com.atguigu.ggkt.model.wechat.Menu;
import com.atguigu.ggkt.result.Result;
import com.atguigu.ggkt.vo.wechat.MenuVo;
import com.atguigu.ggkt.wechat.service.MenuService;
import com.atguigu.ggkt.wechat.utils.ConstantPropertiesUtil;
import com.atguigu.ggkt.wechat.utils.HttpClientUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.message.ReusableMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 微信公众号底部菜单栏
 *
 * @author zhuyuqi
 * @since 2022-09-16
 */
@RestController
@Api(tags = "微信平台接口")
@RequestMapping("admin/wechat/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @ApiOperation("删除公众号菜单")
    @DeleteMapping("removeMenu")
    public Result removeMenu(){
        menuService.removeMenu();
        return Result.ok(null);
    }

    @ApiOperation("同步微信菜单")
    @GetMapping("syncMenu")
    public Result syncMenu(){
        menuService.syncMenu();
        return Result.ok(null);
    }

    /**
     * 获取wechat的access_token：实际上不需要写，在syncMenu()方法中调用了wxMpService的方法，内部通过工具类获取到了。
     * @return
     */
    @ApiOperation("获取wechat的access_token")
    @GetMapping("getAccessToken")
    public Result getAccessToken(){
        try {
            //拼接请求地址
            StringBuffer buffer = new StringBuffer();
            buffer.append("https://api.weixin.qq.com/cgi-bin/token");
            buffer.append("?grant_type=client_credential");
            buffer.append("&appid=%s");//%s表示占位符
            buffer.append("&secret=%s");
            //请求地址设置参数
            String url = String.format(buffer.toString(), ConstantPropertiesUtil.ACCESS_KEY_ID, ConstantPropertiesUtil.ACCESS_KEY_SECRET);
            //发送http请求
            String tokenString = HttpClientUtils.get(url);
            //获取access_token
            JSONObject jsonObject = JSONObject.parseObject(tokenString);//解析字符串，变为json对象
            String access_token = jsonObject.getString("access_token");//根据名字取值
            //返回
            return Result.ok(access_token);
        } catch (Exception e) {
            e.printStackTrace();
            throw  new GgktException(20001,"获取access_token失败");
        }
    }

    //获取所有菜单，按照一级和二级菜单封装
    @ApiOperation("组合树形菜单")
    @GetMapping("findMenuInfo")
    public Result findMenuInfo() {
        List<MenuVo> list = menuService.findMenuInfo();
        return Result.ok(list);
    }

    //获取所有一级菜单
    @ApiOperation("获取是所有一级菜单")
    @GetMapping("findOneMenuInfo")
    public Result findOneMenuInfo() {
        List<Menu> list = menuService.findMenuOneInfo();
        return Result.ok(list);
    }

    @ApiOperation(value = "获取指定菜单")
    @GetMapping("get/{id}")
    public Result get(@PathVariable Long id) {
        Menu menu = menuService.getById(id);
        return Result.ok(menu);
    }

    @ApiOperation(value = "新增")
    @PostMapping("save")
    public Result save(@RequestBody Menu menu) {
        menuService.save(menu);
        return Result.ok(null);
    }

    @ApiOperation(value = "修改")
    @PutMapping("update")
    public Result updateById(@RequestBody Menu menu) {
        menuService.updateById(menu);
        return Result.ok(null);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("remove/{id}")
    public Result remove(@PathVariable Long id) {
        menuService.removeById(id);
        return Result.ok(null);
    }

    @ApiOperation(value = "根据id列表删除")
    @DeleteMapping("batchRemove")
    public Result batchRemove(@RequestBody List<Long> idList) {
        menuService.removeByIds(idList);
        return Result.ok(null);
    }
}

