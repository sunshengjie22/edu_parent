package com.ssj.eduservice.client;

import com.ssj.eduservice.entity.EduComment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "service-ucenter", fallback = com.ssj.eduservice.client.UcenterFileDegradeFeignClient.class)
public interface UcenterClient {

    @GetMapping("/educenter/member/getUserInfo/{userId}")
    public EduComment getUserInfo(@PathVariable("userId") String userId);
}
