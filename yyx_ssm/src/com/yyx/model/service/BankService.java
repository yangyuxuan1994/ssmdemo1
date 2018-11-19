package com.yyx.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yyx.entity.Bank;
import com.yyx.model.dao.BankMapper;

/**
 * ת��
 * @author iprcc
 *
 */
@Service //���뽫������springע��
public class BankService implements IBankService {
	
	@Autowired
	private BankMapper bankMapper;

	@Override
	public void transfer(String sourceNo, String targetNo, double salary) {
		
		//����
		Bank bank = new Bank();
		bank.setBankno(sourceNo);
		bank.setSalary(salary);
		bank.setId(1);
		//�������
		bankMapper.out(bank);
		
		//�տ�
		Bank bankIn = new Bank();
		bankIn.setBankno(targetNo);
		bankIn.setSalary(salary);
		bankIn.setId(2);
		//�տ����
		bankMapper.in(bankIn);
	}

}
