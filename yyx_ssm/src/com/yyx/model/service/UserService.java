package com.yyx.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yyx.entity.User;
import com.yyx.model.dao.UserMapper;
import com.yyx.util.Pager;

/**
 * 业务逻辑类
 * 	使用注解向spring注册
 * @author iprcc
 *
 */
@Service
public class UserService implements IUserService {
	//使用注解进行注入  相当于get set
	@Autowired
	private UserMapper userMapper;
	/* (non-Javadoc)
	 * @see com.yyx.model.service.IUserService#findAll()
	 */
	@Override
	public List<User> findAll(){
		
		return userMapper.selAll();
	}
	@Override
	public void delById(Integer id) {
		
		userMapper.deleteByPrimaryKey(id);
		
	}
	@Override
	public User findUserById(Integer id) {
		// TODO Auto-generated method stub
		return userMapper.selectByPrimaryKey(id);
	}
	@Override
	public void update(User user) {
		userMapper.updateByPrimaryKeySelective(user);
		
	}
	@Override
	public void saveUser(User user) {
		
		userMapper.insertSelective(user);
		
	}
	@Override
	public void deleteBatch(Integer[] ids) {
		
		userMapper.deleteBatch(ids);
		
	}
	/**
	 * 模糊查询
	 */
	@Override
	public List<User> select(User user) {
		// TODO Auto-generated method stub
		return userMapper.select(user);
	}
	@Override
	public List<User> list(User user, Pager pager) {
		//设置总记录数
		pager.setTotalCount(userMapper.selectCount(user));
		
		return userMapper.selectByPager(user, pager);
	}
	

}
