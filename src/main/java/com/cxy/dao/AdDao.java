package com.cxy.dao;

import com.cxy.bean.Ad;

import java.util.List;

/**
 * Created by caoxingyun on 2018/6/6.
 */
public interface AdDao {
    public int insert(Ad ad);

    List<Ad> selectByPage(Ad condition);

    Ad selectById(Long id);
}
