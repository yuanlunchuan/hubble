package com.hubble.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.hubble.entiy.User;
import com.hubble.service.IUserService;

@Component
public class RegisterRealm extends AuthorizingRealm {
	@Autowired
	private IUserService userService;

	/**
	 * 权限部分代码
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		return authorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String email = (String) token.getPrincipal();
		User user = userService.findByEmail(email);
		if (null != user) {
			AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(user.getEmail(), user.getPassword(), "xx");
			return authcInfo;
		} else {
			return null;
		}
	}
}