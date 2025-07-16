package com.atguigu.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.Map;

/**
 * @author: INFINITY https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date: 2022/8/16 11:19
 */
public class ExcelListener extends AnalysisEventListener<User> {
    @Override
    public void invokeHeadMap(Map headMap, AnalysisContext context) {
        System.out.println("表头"+ headMap);
    }

    @Override
    public void invoke(User user, AnalysisContext analysisContext) {
        System.out.println(user);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
