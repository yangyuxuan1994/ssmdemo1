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
    //��ѯĳ��ѧԺ�µ���ʦ
    List<Teacher> selectByCollege(Integer collegeid);
    
}