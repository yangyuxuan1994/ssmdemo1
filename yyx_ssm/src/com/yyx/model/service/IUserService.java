package com.yyx.model.service;

import java.util.List;

import com.yyx.entity.User;
import com.yyx.util.Pager;
/**
 * ҵ���߼��ӿ�
 * @author iprcc
 *
 */
public interface IUserService {

	/**
	 * ��ѯȫ�����û�
	 * @return
	 */
	public abstract List<User> findAll();
	/**
	 * ɾ��
	 */
	public void delById(Integer id);
	
	public User findUserById(Integer id);
	
	public void update(User user);
	
	public void saveUser(User user);
	
	public void deleteBatch(Integer[] ids);
	
	//ģ����ѯ
    List<User> select(User user);
    
    public List<User> list(User user,Pager pager);

}