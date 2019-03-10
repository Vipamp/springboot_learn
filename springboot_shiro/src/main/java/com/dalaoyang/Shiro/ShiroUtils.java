/**
 * File: ShiroUtils 　　2019/03/08 下午3:29
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

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;


public class ShiroUtils {

    public static Subject getSubject(){
        return SecurityUtils.getSubject();
    }

    public static Session getSession(){
        return SecurityUtils.getSubject().getSession();
    }

    public static void login(String user, String passwd){
        UsernamePasswordToken token = new UsernamePasswordToken(user,passwd);
        try{
            getSubject().login(token);
            System.out.println("成功");
        }catch (UnknownAccountException e){
            e.printStackTrace();
            System.out.println("用户名不存在");
        }catch (IncorrectCredentialsException e){
            e.printStackTrace();
            System.out.println("免密错误");
        }
    }
}
