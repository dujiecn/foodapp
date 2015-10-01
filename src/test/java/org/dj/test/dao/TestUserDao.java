package org.dj.test.dao;

import java.util.Date;

import org.dj.bean.po.User;
import org.dj.dao.UserDao;
import org.dj.test.BaseTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.incrementer.DataFieldMaxValueIncrementer;

import com.alibaba.fastjson.JSONObject;

public class TestUserDao extends BaseTest {
	@Autowired
	private UserDao ud;
	@Autowired
	private DataFieldMaxValueIncrementer incrementer;

	@Override
	public void test() throws Exception {
//		inserUser();
		queryUser();
	}

	public void queryUser() {
		System.err.println(JSONObject.toJSONString(ud.queryUserById("00002")));
	}

	public void inserUser() {
		User user = new User();
		user.setUserId(incrementer.nextStringValue());
		user.setUsername("堵杰");
		user.setPassword("123");
		user.setCreateTime(new Date());
		user.setLastLoginTime(new Date());
		user.setCell("13770855082");
		user.setWechat("13770855082");
		user.setQq("760813193");
		ud.insertUser(user);
	}

}
