package com.yyx.model.service;

import java.util.List;

import com.yyx.entity.Teacher;

public interface ITeacherService {

	/**
	 * ��ѯѧԺ�µ���ʦ
	 * @param collegeid
	 * @return
	 */
	public abstract List<Teacher> list(Integer collegeid);

}