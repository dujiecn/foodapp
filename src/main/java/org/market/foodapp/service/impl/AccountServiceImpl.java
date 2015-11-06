package org.market.foodapp.service.impl;

import org.market.foodapp.bean.Account;
import org.market.foodapp.mapper.AccountMapper;
import org.market.foodapp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountMapper accountMapper;
	
	@Override
	public void modAccount(Account account) {
		accountMapper.updateAccountById(account);
	}

}
