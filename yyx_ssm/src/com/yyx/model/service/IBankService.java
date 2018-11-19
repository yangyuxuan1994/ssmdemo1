package com.yyx.model.service;
/**
 * 银行转账问题
 * 理解aop
 * @author iprcc
 *
 */
public interface IBankService {
	/**
	 * 转账
	 * @param sourceNo 出款方
	 * @param targetNo 收款方
	 * @param salary 转账金额
	 */
	public void transfer(String sourceNo,String targetNo,double salary);

}
