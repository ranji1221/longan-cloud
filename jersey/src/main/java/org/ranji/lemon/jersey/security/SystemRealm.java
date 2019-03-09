package org.ranji.lemon.jersey.security;

import java.util.HashSet;
import java.util.Set;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.ranji.lemon.jersey.model.permission.Permission;
import org.ranji.lemon.jersey.model.permission.Role;
import org.ranji.lemon.jersey.model.permission.User;
import org.ranji.lemon.jersey.service.permission.prototype.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

public class SystemRealm extends AuthorizingRealm {
	
	@Autowired
	@Lazy		//-- 解决redis缓存和shiro冲突的问题
	private IUserService userService;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String username = (String)principals.getPrimaryPrincipal();
//System.out.println(username);
		
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		//-- 查找用户所具有的角色，并设置用户角色信息
		Set<Role> rs = userService.findRoles(username);
		Set<String> roles = new HashSet<String>();
		for (Role role : rs) {
			roles.add(role.getRole());
//System.out.println(role.getRole());
		}
        authorizationInfo.setRoles(roles);
        
        //-- 查找用户所有的权限信息，并设置用户权限信息
        Set<Permission> ps = userService.findPermissions(username);
        Set<String> permissions = new HashSet<String>();
        for (Permission permission : ps) {
			permissions.add(permission.getPermission());
//System.out.println(permission.getPermission());
		}
        authorizationInfo.setStringPermissions(permissions);

        return authorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authToken) throws AuthenticationException {
		AuthenticationInfo authenInfo = null;
		UsernamePasswordToken token = (UsernamePasswordToken)authToken;
		User user = userService.findByUsername(token.getUsername());
		if(user!=null)authenInfo = new SimpleAuthenticationInfo(user.getUsername(),user.getPassword(),getName());
		return authenInfo;
	}
}

