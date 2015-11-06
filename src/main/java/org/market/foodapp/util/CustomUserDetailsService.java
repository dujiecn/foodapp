package org.market.foodapp.util;

import java.util.ArrayList;
import java.util.List;

import org.market.foodapp.bean.Account;
import org.market.foodapp.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * 
 * 项目名称：foodapp 类描述：登陆用户的权限管理
 * 类名称：org.market.foodapp.util.CustomUserDetailsService 创建人：dujie
 * 创建时间：2015年11月6日 下午1:15:19
 * 
 * @version V1.0
 */
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private AccountMapper accountMapper;

	@Autowired
	private Md5PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String accountName) throws UsernameNotFoundException {
		UserDetails user = null;
		Account account = getLoginAccount(accountName);
		// user = new User(account.getAccountName(),
		// account.getPassword().toLowerCase(), true, true, true, true,
		// getAccountAuthorities(account.getRole()));
		user = new SaltUser(account.getAccountName(), account.getPassword().toLowerCase(), true, true, true, true,
				getAccountAuthorities(account.getRole()), account.getCreateTime().toString());
		return user;
	}

	/**
	 * 
	 * 功能描述:获取访问用户的信息
	 * 
	 * @param accountName
	 * @return
	 */
	private Account getLoginAccount(String accountName) {
		// TODO
		// return accountMapper.queryAccountByName(accountName);
		Account account = new Account();
		account.setAccountName(accountName);
		account.setCreateTime(1234567890L);
		account.setPassword(passwordEncoder.encodePassword("123", account.getCreateTime()));
		account.setRole(2);
		return account;
	}

	/**
	 * 
	 * 功能描述:获取用户的访问权限
	 * 
	 * @param roleId
	 * @return
	 */
	private List<GrantedAuthority> getAccountAuthorities(Integer roleId) {
		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(2);

		// 所有的用户默认拥有ROLE_USER权限 GrantedAuthorityImpl
		authList.add(new SimpleGrantedAuthority("USER"));

		// 如果参数roleId为1.则拥有ROLE_ADMIN权限
		if (roleId == 1) {
			authList.add(new SimpleGrantedAuthority("ADMIN"));
		}

		return authList;
	}

}
