package com.yyx.model.service;
/**
 * ����ת������
 * ���aop
 * @author iprcc
 *
 */
public interface IBankService {
	/**
	 * ת��
	 * @param sourceNo ���
	 * @param targetNo �տ
	 * @param salary ת�˽��
	 */
	public void transfer(String sourceNo,String targetNo,double salary);

}
