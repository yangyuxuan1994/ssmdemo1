package com.yyx.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yyx.entity.Teacher;
import com.yyx.model.dao.TeacherMapper;

@Service
public class TeacherService implements ITeacherService {
	
	@Autowired
	private TeacherMapper teacherMapper;
	/* (non-Javadoc)
	 * @see com.yyx.model.service.ITeacherService#list(java.lang.Integer)
	 */
	@Override
	public List<Teacher> list(Integer collegeid){
		
		List<Teacher> list = teacherMapper.selectByCollege(collegeid);
		
		return list;
		
	}

}
