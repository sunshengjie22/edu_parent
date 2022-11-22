package com.ssj.educms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ssj.educms.entity.CrmBanner;
import com.ssj.educms.mapper.CrmBannerMapper;
import com.ssj.educms.service.CrmBannerService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 首页banner表 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2020-06-29
 */
@Service
public class CrmBannerServiceImpl extends ServiceImpl<CrmBannerMapper, CrmBanner> implements CrmBannerService {
    // 查询所有banner
    @Cacheable(value = "banner", key = "'selectIndexList'")
    @Override
    public List<CrmBanner> selectAllBanner() {
        // 根据id进行降序排序，显示排列之后的前两条记录
        QueryWrapper<CrmBanner> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("id");
        // last方法拼接sql语句
        wrapper.last("limit 5");

        List<CrmBanner> list = baseMapper.selectList(null);
        return list;
    }
}
