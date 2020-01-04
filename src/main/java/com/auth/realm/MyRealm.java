package com.auth.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/**
 * @Description TODO
 * @Author zhenxing.dong
 * @Date 2019/11/20 17:06
 */
public class MyRealm implements Realm {

    public String getName() {
        return "myRealm";
    }

    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
    }

    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String userName = token.getPrincipal().toString();

        String pwd = new String((char[])token.getCredentials());

        if(!"zhang".equals(userName)) {
            //如果用户名错误
            throw new UnknownAccountException();
        }
        if(!"123".equals(pwd)) {
            //如果密码错误
            System.out.println(pwd);
            throw new IncorrectCredentialsException();
        }
        //如果身份认证验证成功，返回一个AuthenticationInfo实现；
        return new SimpleAuthenticationInfo(userName, pwd, getName());
    }
}
