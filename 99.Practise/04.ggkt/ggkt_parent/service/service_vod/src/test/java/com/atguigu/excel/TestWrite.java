package com.atguigu.excel;

import com.alibaba.excel.EasyExcel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: INFINITY https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date: 2022/8/16 11:12
 */
public class TestWrite {
    public static void main(String[] args) {
        String fileName = "D:\\11.xlsx";
        EasyExcel.write(fileName, User.class)
                 .sheet("sheet1")
                 .doWrite(data());
    }
    //循环设置要添加的数据，最终封装到list集合中
    private static List<User> data() {
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User data = new User();
            data.setId(i);
            data.setName("张三"+i);
            list.add(data);
        }
        return list;
    }
}
