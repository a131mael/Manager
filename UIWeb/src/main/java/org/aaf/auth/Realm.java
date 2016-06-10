package org.aaf.auth;


import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.naming.NamingException;

import org.aaf.dto.UserDTO;
import org.aaf.uiweb.service.UserService;
import org.aaf.uiweb.util.ServiceLocator;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;


/**
 *
 * @author abimael
 */
public class Realm extends AuthorizingRealm {
	
	private UserService userService;
	
	@PostConstruct
	public void initializy(){
		setUserService(new UserService());
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {

//        User usuario = (User) SecurityUtils.getSubject().getPrincipal();
//
//        SimpleAuthorizationInfo info = null;
//        
//        if (usuario != null) {
//        	info = new SimpleAuthorizationInfo();
//        }
//
//		return info;
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
		System.out.println("Autorizacao");
		try {
			StringBuilder sb = new StringBuilder();
			
			for(char c : (char [])arg0.getCredentials()){
				sb.append(c);	
			}
			
			UserDTO m = new UserDTO();
			m.setLogin((String)arg0.getPrincipal());
			m.setSenha(sb.toString());
			getUserService().login(m);
			UserDTO member = getUserService().login(m);
			if(member != null){
				return new SimpleAuthenticationInfo(member, m.getSenha(), getName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return null;
	}

	public UserService getUserService() {
		return userService!= null?userService:new UserService();
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}