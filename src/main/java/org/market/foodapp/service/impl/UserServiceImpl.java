package org.market.foodapp.service.impl;

import org.market.foodapp.bean.vo.UserVO;
import org.market.foodapp.mapper.UserMapper;
import org.market.foodapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public UserVO findUserById(String id) {
		return userMapper.queryUserById(id);
	}
}
