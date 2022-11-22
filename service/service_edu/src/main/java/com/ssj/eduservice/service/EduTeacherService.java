package com.ssj.eduservice.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ssj.eduservice.entity.EduTeacher;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author testjava
 * @since 2022-11-09
 */
public interface EduTeacherService extends IService<EduTeacher> {
    List<EduTeacher> getList();

    // 1、分页查询讲师的方法
    Map<String, Object> getTeacherFrontList(Page<EduTeacher> pageTeacher);
}
