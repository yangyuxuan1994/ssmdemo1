package com.yyx.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yyx.entity.Bank;
import com.yyx.model.dao.BankMapper;

/**
 * 转账
 * @author iprcc
 *
 */
@Service //申请将该类向spring注册
public class BankService implements IBankService {
	
	@Autowired
	private BankMapper bankMapper;

	@Override
	public void transfer(String sourceNo, String targetNo, double salary) {
		
		//出款
		Bank bank = new Bank();
		bank.setBankno(sourceNo);
		bank.setSalary(salary);
		bank.setId(1);
		//出款操作
		bankMapper.out(bank);
		
		//收款
		Bank bankIn = new Bank();
		bankIn.setBankno(targetNo);
		bankIn.setSalary(salary);
		bankIn.setId(2);
		//收款操作
		bankMapper.in(bankIn);
	}

}
