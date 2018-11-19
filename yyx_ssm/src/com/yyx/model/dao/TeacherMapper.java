package com.yyx.model.dao;

import java.util.List;

import com.yyx.entity.Teacher;

public interface TeacherMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);
    //查询某个学院下的老师
    List<Teacher> selectByCollege(Integer collegeid);
    
}