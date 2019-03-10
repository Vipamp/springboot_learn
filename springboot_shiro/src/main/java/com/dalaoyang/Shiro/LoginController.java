/**
 * File: Controller 　　2019/03/08 下午3:22
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

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class LoginController {

    @PostMapping("/mylogin")
    public void login(@RequestBody LogParams params) {
        String user = params.getUser();
        String passwd = params.getPassword();
        ShiroUtils.login(user, passwd);

    }
}
