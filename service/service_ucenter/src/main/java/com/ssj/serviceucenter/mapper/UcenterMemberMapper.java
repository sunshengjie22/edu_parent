package com.ssj.serviceucenter.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ssj.serviceucenter.entity.UcenterMember;

/**
 * <p>
 * 会员表 Mapper 接口
 * </p>
 *
 * @author testjava
 * @since 2020-07-01
 */
public interface UcenterMemberMapper extends BaseMapper<UcenterMember> {

    // 查询某一天的注册人数
    Integer countRegister(String day);
}
