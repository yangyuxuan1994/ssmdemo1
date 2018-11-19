package com.yyx.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yyx.entity.College;
import com.yyx.model.dao.CollegeMapper;

@Service
public class CollegeService implements ICollegeService {
	
	@Autowired
	private CollegeMapper collegeMapper;
	
	/* (non-Javadoc)
	 * @see com.yyx.model.service.ICollegeService#list()
	 */
	@Override
	public List<College> list(){
		
		List<College> list = collegeMapper.selectAll();
		
		return list;
		
	}

}
