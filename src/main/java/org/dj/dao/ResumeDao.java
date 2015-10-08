package org.dj.dao;

import org.dj.bean.vo.ResumeVo;
import org.springframework.dao.DataAccessException;

public interface ResumeDao {
	public ResumeVo queryResumeByUserId(String userId) throws DataAccessException;
}
