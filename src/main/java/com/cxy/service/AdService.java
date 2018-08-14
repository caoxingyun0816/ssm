package com.cxy.service;

import com.cxy.dto.AdDto;

import java.util.List;

/**
 * Created by caoxingyun on 2018/6/6.
 * 广告服务类
 */
public interface AdService {

    /***
     * 新增广告
     * @param adDto
     * @return 成功true，失败false
     */
    boolean adAdd(AdDto adDto);

    /***
     * 查询广告
     * @param adDto
     * @return
     */
    List<AdDto> searchByPage(AdDto adDto);

    AdDto getById(Long id);
}
