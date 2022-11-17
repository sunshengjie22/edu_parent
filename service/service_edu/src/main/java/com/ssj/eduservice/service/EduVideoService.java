package com.ssj.eduservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ssj.eduservice.entity.EduVideo;

/**
 * <p>
 * 课程视频 服务类
 * </p>
 *
 * @author testjava
 * @since 2020-06-22
 */
public interface EduVideoService extends IService<EduVideo> {

    void removeVideoByCourseId(String courseId);
}
