package org.market.foodapp.service;

import org.market.foodapp.TestBaseConfig;
import org.market.foodapp.bean.Account;
import org.market.foodapp.service.AccountService;
import org.market.foodapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;

public class TestUserService extends TestBaseConfig{
	@Autowired
	private UserService userService;
	
	@Autowired
	private AccountService accountService;
	
	@Override
	public void test() throws Exception {
		System.out.println(JSONObject.toJSONString(userService.findUserById("00002")));
		Account account = new Account();
		account.setUserId("00002");
		account.setAccountName("dujie2");
		accountService.modAccount(account);
		System.out.println(JSONObject.toJSONString(userService.findUserById("00002")));
	}

}
