package com.yyx.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 分页类
 * @author iprcc
 *
 */
public class Pager {
	
	private int currentNo=1;//当前页号
	private int pageCount=3;//每页显示的记录数
	private int totalCount=0;//总记录
	private int totalPage=1;//总页数
	private int begin;//开始
	
	private boolean hasNext=false;//是否有下一页
	private boolean hasPrevious=false;//是否有上一页
	
	private String path;//路径问题
	
	//单独写一个方法处理请求所有的参数
	public void parseParamter(){
		//获取请求(去线程中去拿)
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		//获取当前的请求地址
		path = request.getRequestURI()+"?1=1";
		
		//获取请求中的所有参数
		Enumeration<String> paramterNames = request.getParameterNames();
		//好多数据我们要循环遍历
		while (paramterNames.hasMoreElements()) {
			//进行数据读取
			//获取名称
			String paramterName = paramterNames.nextElement();
			
			if (!"1".equals(paramterName) && !"currentNo".equals(paramterName)) {
				//获取值
				String paramterValue = request.getParameter(paramterName);
				
					
					try {
						//处理中文乱码问题
						paramterValue = URLEncoder.encode(paramterValue, "UTF-8");
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				
				path+="&"+paramterName+"="+paramterValue;
				
			}
			
		}
		
	}
	/**
	 * 计算位置
	 */
	public void countPosition(){
		begin = (currentNo-1)*pageCount;
		
		
	}

	
	
	public int getBegin() {
		return begin;
	}
	public void setBegin(int begin) {
		this.begin = begin;
	}
	public int getCurrentNo() {
		return currentNo;
	}

	public void setCurrentNo(int currentNo) {
		this.currentNo = currentNo;
		countPosition();
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		//计算总页数
		totalPage = totalCount/pageCount;
		if (totalCount%pageCount>0) {
			totalPage+=1;
		}
		
		//判断是否有下一页
		if (currentNo!=totalPage) {
			hasNext=true;
		}
		//是否有上一页
		if (currentNo!=1) {
			hasPrevious=true;
		}
		
	}
	
	public Pager(){
		//计算位置
		countPosition();
		//处理路径
		parseParamter();
		
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public boolean getHasNext() {
		return hasNext;
	}

	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}

	public boolean getHasPrevious() {
		return hasPrevious;
	}

	public void setHasPrevious(boolean hasPrevious) {
		this.hasPrevious = hasPrevious;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	
	
	
}
