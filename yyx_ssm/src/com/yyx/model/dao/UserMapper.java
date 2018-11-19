package com.yyx.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yyx.entity.User;
import com.yyx.util.Pager;
/**
 * mapper�ӿ�
 * @author iprcc
 *
 */

public interface UserMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    List<User> selAll();
    
    //�������ɾ���ķ���
    public void deleteBatch(Integer[] ids);
    //ģ����ѯ
    List<User> select(User user);
    
    List<User> selectByPager(@Param("user")User user, @Param("pager")Pager pager);
    
    int selectCount(@Param("user")User user);
    
    
    
}