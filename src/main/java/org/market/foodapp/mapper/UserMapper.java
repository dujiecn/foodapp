package org.market.foodapp.mapper;

import org.market.foodapp.bean.vo.UserVO;

public interface UserMapper {
	public UserVO queryUserById(String id);
}
