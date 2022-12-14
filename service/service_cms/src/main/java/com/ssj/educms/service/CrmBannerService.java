package com.ssj.educms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ssj.educms.entity.CrmBanner;

import java.util.List;

/**
 * <p>
 * 首页banner表 服务类
 * </p>
 *
 * @author testjava
 * @since 2020-06-29
 */
public interface CrmBannerService extends IService<CrmBanner> {
    // 查询所有banner
    List<CrmBanner> selectAllBanner();
}
