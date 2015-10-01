package org.dj.service.impl;

import org.dj.dao.UserDao;
import org.dj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.incrementer.DataFieldMaxValueIncrementer;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private DataFieldMaxValueIncrementer incrementer;

}
