package org.market.foodapp.bean.vo;

import java.io.Serializable;

import org.market.foodapp.bean.Account;

public class UserVO implements Serializable {
	private static final long serialVersionUID = 5565951796297734886L;
	private String userId;
	private String username;
	private Account account;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}
