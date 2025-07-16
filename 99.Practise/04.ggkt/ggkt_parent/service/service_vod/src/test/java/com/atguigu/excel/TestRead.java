package com.atguigu.excel;

import com.alibaba.excel.EasyExcel;

/**
 * @author: INFINITY https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date: 2022/8/16 11:23
 */
public class TestRead {
    public static void main(String[] args) {
        String fileName = "D:\\11.xlsx";
        EasyExcel.read(fileName, User.class, new ExcelListener()).sheet().doRead();
    }
}
