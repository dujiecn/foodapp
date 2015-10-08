package org.dj.service.impl;

import org.dj.bean.po.User;
import org.dj.bean.vo.ResumeVo;
import org.dj.bean.vo.UserVo;
import org.dj.dao.ResumeDao;
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
	private ResumeDao resumeDao;

	@Autowired
	private DataFieldMaxValueIncrementer incrementer;

	@Override
	public UserVo findUser(String username, String password) throws Exception {
		return userDao.queryUser(username, password);
	}

	@Override
	public ResumeVo findUserResume(String id) throws Exception {
		return resumeDao.queryResumeByUserId(id);
	}

	@Override
	public void modUser(User user) throws Exception {
		userDao.updateUser(user);
	}

}
