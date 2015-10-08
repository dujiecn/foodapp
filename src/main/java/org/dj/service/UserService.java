package org.dj.service;

import org.dj.bean.po.User;
import org.dj.bean.vo.ResumeVo;
import org.dj.bean.vo.UserVo;

public interface UserService {
	public UserVo findUser(String username, String password) throws Exception;

	public ResumeVo findUserResume(String id) throws Exception;
	
	public void modUser(User user) throws Exception;
}
