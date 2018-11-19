package com.yyx.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yyx.entity.User;
import com.yyx.model.dao.UserMapper;
import com.yyx.util.Pager;

/**
 * ҵ���߼���
 * 	ʹ��ע����springע��
 * @author iprcc
 *
 */
@Service
public class UserService implements IUserService {
	//ʹ��ע�����ע��  �൱��get set
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
	 * ģ����ѯ
	 */
	@Override
	public List<User> select(User user) {
		// TODO Auto-generated method stub
		return userMapper.select(user);
	}
	@Override
	public List<User> list(User user, Pager pager) {
		//�����ܼ�¼��
		pager.setTotalCount(userMapper.selectCount(user));
		
		return userMapper.selectByPager(user, pager);
	}
	

}
