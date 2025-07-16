package com.atguigu.ggkt.vod.service;

import com.atguigu.ggkt.model.vod.Subject;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author zhuyuqi
 * @since 2022-08-16
 */
public interface SubjectService extends IService<Subject> {
    /**
     * 自定义：懒加载查询数据
     * @param id
     * @return
     */
    List<Subject> selecetSubjectList(Long id);
    /**
     * 导出
     * @param response
     */
    void exportData(HttpServletResponse response);

    /**
     * 导入
     * @param file
     */
    void importData(MultipartFile file);
}
