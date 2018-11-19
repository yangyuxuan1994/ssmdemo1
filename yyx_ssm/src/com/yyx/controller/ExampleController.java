package com.yyx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yyx.entity.College;
import com.yyx.entity.Teacher;
import com.yyx.model.service.ICollegeService;
import com.yyx.model.service.ITeacherService;
import com.yyx.model.service.TeacherService;

/**
 * ���������Ŀ�����
 * @author iprcc
 *
 */
@Controller
@RequestMapping("example")
public class ExampleController {
	
	@Autowired
	private ICollegeService collegeService;
	@Autowired
	private ITeacherService teacherService;
	
	@RequestMapping("liandong")
	public List<College> liandong(){
		
		List<College> list = collegeService.list();
		
		return list;
		
	}
	@RequestMapping("ajaxTeacherList")
	@ResponseBody //���������ķ��ض���ת��json����
	public List<Teacher> ajaxTeacherList(Integer collegeid){
		
		List<Teacher> list = teacherService.list(collegeid);
		
		return list;
	}

}
