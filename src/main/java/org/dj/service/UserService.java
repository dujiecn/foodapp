package org.dj.service;

import org.dj.bean.vo.UserVo;

public interface UserService {
	public UserVo findUser(String username,String password) throws Exception;
}
