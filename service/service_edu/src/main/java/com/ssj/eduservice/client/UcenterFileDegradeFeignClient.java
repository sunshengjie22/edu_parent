package com.ssj.eduservice.client;


import com.ssj.eduservice.entity.EduComment;
import org.springframework.stereotype.Component;


@Component
public class UcenterFileDegradeFeignClient implements UcenterClient {
    // 出错的时候会执行
    @Override
    public EduComment getUserInfo(String userId) { return null; }
}
