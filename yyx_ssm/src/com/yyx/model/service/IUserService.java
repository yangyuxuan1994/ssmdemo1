package com.yyx.model.service;

import java.util.List;

import com.yyx.entity.User;
import com.yyx.util.Pager;
/**
 * 业务逻辑接口
 * @author iprcc
 *
 */
public interface IUserService {

	/**
	 * 查询全部的用户
	 * @return
	 */
	public abstract List<User> findAll();
	/**
	 * 删除
	 */
	public void delById(Integer id);
	
	public User findUserById(Integer id);
	
	public void update(User user);
	
	public void saveUser(User user);
	
	public void deleteBatch(Integer[] ids);
	
	//模糊查询
    List<User> select(User user);
    
    public List<User> list(User user,Pager pager);

}