package com.yyx.model.service;

import java.util.List;

import com.yyx.entity.Teacher;

public interface ITeacherService {

	/**
	 * 查询学院下的老师
	 * @param collegeid
	 * @return
	 */
	public abstract List<Teacher> list(Integer collegeid);

}