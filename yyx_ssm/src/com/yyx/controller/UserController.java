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
 * 使用普通的类作为控制器
 * 访问路径：
 * http://localhost:8080/yyx_ssm/user/list.action
 * @author iprcc
 *
 */
@Controller//标记是一个控制器
@RequestMapping("user")//窄化路径请求
public class UserController {
	//注入service
	@Autowired
	private IUserService userService;
	
	//使用多种方式开发控制器
	/**
	 * 第一种方法
	 * 
	 * @return
	 */
	@RequestMapping("list")
	public List<User> list(User user,Pager pager){
		//查询全部
//		return userService.findAll();
		//模糊查询
//		return userService.select(user);
		//分页查询
		return userService.list(user, pager);
		
	}
	
	/**
	 * 第二种方法
	 * 使用servlet api
	 * @return
	 * @throws IOException 
	 * @throws ServletException 
	 */
//	@RequestMapping("list")
//	public void list(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
//		//获取集合
//		List<User> list = userService.findAll();
//		
//		request.setAttribute("userList", list);
//		
//		request.getRequestDispatcher("/WEB-INF/content/user/list.jsp").forward(request, response);
//	}
	
	/**
	 * 第三种方法
	 * ArrayList集合方式
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
	 * 第四种方法
	 * map集合方式1
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
	 * 第五种方法
	 * map集合方式2
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
	 * 第六种方法
	 * ModelAndView方式
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
