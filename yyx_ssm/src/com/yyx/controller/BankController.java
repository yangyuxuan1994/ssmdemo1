package com.yyx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yyx.model.service.BankService;
import com.yyx.model.service.IBankService;

/**
 * ���еĿ�����
 * @author iprcc
 *
 */
@Controller
@RequestMapping("bank")
public class BankController {
	@Autowired
	private IBankService bankService;
	
	@RequestMapping("transfer")
	public String transfer() {
		
		bankService.transfer("����", "����", 100);
		
		
		return "bank/success";
	}

}
