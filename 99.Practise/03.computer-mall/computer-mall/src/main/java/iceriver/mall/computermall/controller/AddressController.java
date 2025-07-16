package iceriver.mall.computermall.controller;

import iceriver.mall.computermall.entity.Address;
import iceriver.mall.computermall.service.IAddressService;
import iceriver.mall.computermall.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author: INFINITY https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date: 2022/8/11 8:59
 */
@RestController
@RequestMapping("address")
public class AddressController extends BaseController{
    @Autowired
    private IAddressService addressService;

    @RequestMapping("add-address")
    public JSONResult<Void> addNewAddress(Address address, HttpSession session){
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        addressService.addNewAddress(uid, username, address);
        return new JSONResult<>(OK);
    }

    @GetMapping({"", "/"})//表示两个路径都可以
    public JSONResult<List<Address>> getByUid(HttpSession session) {
        Integer uid = getUidFromSession(session);
        List<Address> data = addressService.getByUid(uid);
        return new JSONResult<>(OK, data);
    }
    @RequestMapping("{aid}/set_default")
    public JSONResult<Void> setDefault(@PathVariable("aid") Integer aid, HttpSession session) {
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        addressService.setDefault(aid, uid, username);
        return new JSONResult<>(OK);
    }

    @RequestMapping("{aid}/delete")
    public JSONResult<Void> delete(@PathVariable("aid") Integer aid, HttpSession session) {
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        addressService.delete(aid, uid, username);
        return new JSONResult<>(OK);
    }
    @RequestMapping("{aid}/search")
    public JSONResult<Address> search(@PathVariable("aid") Integer aid, HttpSession session) {
        Integer uid = getUidFromSession(session);
        Address data = addressService.getByAid(aid, uid);
        return new JSONResult<>(OK, data);
    }
    @RequestMapping("{aid}/update-address")
    public JSONResult<Void> updateAddress(@PathVariable("aid") Integer aid, HttpSession session, Address address) {
        System.out.println(address);
        String username = getUsernameFromSession(session);
        addressService.updateAddress(aid, username, address);
        return new JSONResult<>(OK);
    }
}
