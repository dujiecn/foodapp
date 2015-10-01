package org.dj.dao;

import org.dj.bean.po.User;
import org.dj.bean.vo.UserVo;
import org.springframework.dao.DataAccessException;

public interface UserDao {
	public UserVo queryUserById(String userId) throws DataAccessException;
	
	public void insertUser(User user) throws DataAccessException;
}
