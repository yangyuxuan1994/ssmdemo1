package com.yyx.model.dao;

import com.yyx.entity.Bank;

public interface BankMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Bank record);

    int insertSelective(Bank record);

    Bank selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Bank record);

    int updateByPrimaryKey(Bank record);
    /**
     * ����
     * @param bank
     */
    public void out(Bank bank);
    /**
     * ����
     * @param bank
     */
    public void in(Bank bank);
    
}