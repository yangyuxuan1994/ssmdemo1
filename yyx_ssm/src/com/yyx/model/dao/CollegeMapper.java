package com.yyx.model.dao;

import java.util.List;

import com.yyx.entity.College;

public interface CollegeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(College record);

    int insertSelective(College record);

    College selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(College record);

    int updateByPrimaryKey(College record);
    //��ѯ���е�ѧԺ
    List<College> selectAll();
}