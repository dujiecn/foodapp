package org.market.foodapp.service;

import org.market.foodapp.bean.vo.UserVO;

/**
 * 
 * 项目名称：foodapp   
 * 类描述：用户业务接口，根据实际需要抛出BusinessException异常
 * 类名称：org.market.foodapp.service.UserService     
 * 创建人：dujie 
 * 创建时间：2015年11月5日 下午10:06:45
 * @version   V1.0
 */
public interface UserService {

	UserVO findUserById(String id);

}
