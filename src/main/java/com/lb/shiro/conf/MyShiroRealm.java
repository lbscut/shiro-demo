package com.lb.shiro.conf;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class MyShiroRealm extends AuthorizingRealm {

	//获取用户的角色和权限
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		// 此处写死，用户拥有createUser的角色和create的权限
		// 实际应根据principalCollection.getPrimaryPrincipal()得到用户名，在数据库中查询角色和权限
		simpleAuthorizationInfo.addRole("createUser");
		simpleAuthorizationInfo.addStringPermission("create");
		return simpleAuthorizationInfo;
	}

	//获取用户的认证信息（登陆检查）
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
			throws AuthenticationException {
		if (authenticationToken.getPrincipal() == null) {
			return null;
		}
		String name = authenticationToken.getPrincipal().toString();
		//此处写死密码为pwd
		//实际应根据name在数据库中查询密码
		SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(name, "pwd", getName());
		return simpleAuthenticationInfo;
	}
}
