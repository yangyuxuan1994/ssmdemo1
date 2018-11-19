package com.yyx.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * ��ҳ��
 * @author iprcc
 *
 */
public class Pager {
	
	private int currentNo=1;//��ǰҳ��
	private int pageCount=3;//ÿҳ��ʾ�ļ�¼��
	private int totalCount=0;//�ܼ�¼
	private int totalPage=1;//��ҳ��
	private int begin;//��ʼ
	
	private boolean hasNext=false;//�Ƿ�����һҳ
	private boolean hasPrevious=false;//�Ƿ�����һҳ
	
	private String path;//·������
	
	//����дһ�����������������еĲ���
	public void parseParamter(){
		//��ȡ����(ȥ�߳���ȥ��)
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		//��ȡ��ǰ�������ַ
		path = request.getRequestURI()+"?1=1";
		
		//��ȡ�����е����в���
		Enumeration<String> paramterNames = request.getParameterNames();
		//�ö���������Ҫѭ������
		while (paramterNames.hasMoreElements()) {
			//�������ݶ�ȡ
			//��ȡ����
			String paramterName = paramterNames.nextElement();
			
			if (!"1".equals(paramterName) && !"currentNo".equals(paramterName)) {
				//��ȡֵ
				String paramterValue = request.getParameter(paramterName);
				
					
					try {
						//����������������
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
	 * ����λ��
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
		//������ҳ��
		totalPage = totalCount/pageCount;
		if (totalCount%pageCount>0) {
			totalPage+=1;
		}
		
		//�ж��Ƿ�����һҳ
		if (currentNo!=totalPage) {
			hasNext=true;
		}
		//�Ƿ�����һҳ
		if (currentNo!=1) {
			hasPrevious=true;
		}
		
	}
	
	public Pager(){
		//����λ��
		countPosition();
		//����·��
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
