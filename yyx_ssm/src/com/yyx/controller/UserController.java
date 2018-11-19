package com.yyx.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yyx.entity.User;
import com.yyx.model.service.IUserService;
import com.yyx.util.Pager;

/**
 * ʹ����ͨ������Ϊ������
 * ����·����
 * http://localhost:8080/yyx_ssm/user/list.action
 * @author iprcc
 *
 */
@Controller//�����һ��������
@RequestMapping("user")//խ��·������
public class UserController {
	//ע��service
	@Autowired
	private IUserService userService;
	
	//ʹ�ö��ַ�ʽ����������
	/**
	 * ��һ�ַ���
	 * 
	 * @return
	 */
	@RequestMapping("list")
	public List<User> list(User user,Pager pager){
		//��ѯȫ��
//		return userService.findAll();
		//ģ����ѯ
//		return userService.select(user);
		//��ҳ��ѯ
		return userService.list(user, pager);
		
	}
	
	/**
	 * �ڶ��ַ���
	 * ʹ��servlet api
	 * @return
	 * @throws IOException 
	 * @throws ServletException 
	 */
//	@RequestMapping("list")
//	public void list(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
//		//��ȡ����
//		List<User> list = userService.findAll();
//		
//		request.setAttribute("userList", list);
//		
//		request.getRequestDispatcher("/WEB-INF/content/user/list.jsp").forward(request, response);
//	}
	
	/**
	 * �����ַ���
	 * ArrayList���Ϸ�ʽ
	 * @return
	 */
//	@RequestMapping("list")
//	public String list(ArrayList<User> userList){
//		List<User> list = userService.findAll();
//		
//		userList.addAll(list);
//		
//		return "user/list";
//	}
	
	/**
	 * �����ַ���
	 * map���Ϸ�ʽ1
	 * @return
	 */
//	@RequestMapping("list")
//	public String list(Map<String, Object> map){
//		List<User> list = userService.findAll();
//		
//		map.put("userList", list);
//		
//		return "user/list";
//	}
	
	/**
	 * �����ַ���
	 * map���Ϸ�ʽ2
	 * @return
	 */
//	@RequestMapping("list")
//	public void list(Map<String, Object> map){
//		List<User> list = userService.findAll();
//		
//		map.put("userList", list);
//		
//	}
	
	/**
	 * �����ַ���
	 * ModelAndView��ʽ
	 * @return
	 */
//	@RequestMapping("list")
//	public ModelAndView list(){
//		ModelAndView mav = new ModelAndView();
//		List<User> list = userService.findAll();
//		mav.addObject(list);
//		mav.setViewName("user/list");
//		return mav;
//	}
	@RequestMapping("del")
	public String del(int id){
		userService.delById(id);
		
		return "redirect:list";
	}
	
	@RequestMapping("edit")
	public User edit(int id){
		User user=userService.findUserById(id);
		return user;
	}
	
	
	@RequestMapping("updateUser")
	public String updateUser(User user){
		userService.update(user);
		return "redirect:list";
	}
	
	@RequestMapping("add")
	public void add(){
	
	}
	
	@RequestMapping("save")
	public String save(User user){
		userService.saveUser(user);
		return "redirect:list";
	}
	
	@RequestMapping("batchDel")
	public String batchDel(Integer[] ids){
		
		userService.deleteBatch(ids);
		
		return "redirect:list";
		
	}
	
	

}
