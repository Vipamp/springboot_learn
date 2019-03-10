/**
 * File: MyEealm 　　2019/03/08 下午2:29
 * <p>
 * Copyright (c) 2018-2028  HeQingsong(ahheqingsong@126.com) All rights reserved.
 * <p>
 * //TODO
 *
 * @version: 1.0
 * @since: JDK1.8
 * @author: HeQingsong
 */
package com.dalaoyang.Shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class MyEealm extends AuthorizingRealm {

    private static final String USER = "admin";
    private static final String PASSWORD = "123";

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo();
        return (AuthorizationInfo) info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String user = (String) token.getPrincipal();
        String password = new String((char[])token.getCredentials());
        if(!user.equals(USER)){
            throw new UnknownAccountException();
        }
        if(!password.equals(PASSWORD)){
            throw new IncorrectCredentialsException();
        }
        return new SimpleAuthenticationInfo(user,password,"MyRealm");
    }
}
