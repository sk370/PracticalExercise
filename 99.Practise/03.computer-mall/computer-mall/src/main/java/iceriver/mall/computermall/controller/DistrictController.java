package iceriver.mall.computermall.controller;

import iceriver.mall.computermall.entity.District;
import iceriver.mall.computermall.service.IDistrictService;
import iceriver.mall.computermall.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: INFINITY https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date: 2022/8/11 9:42
 */
@RestController
@RequestMapping("district")
public class DistrictController extends BaseController{
    @Autowired
    private IDistrictService districtService;
    @RequestMapping("/")
    public JSONResult<List<District>> getByParent(String parent){
        System.out.println(parent);
        List<District> data = districtService.getByParent(parent);
        return new JSONResult<>(OK, data);
    }
}
