package cn.lin.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

public class ShiroUtil {
    public static Subject login(String path,String userName,String password){
        Factory<SecurityManager> factory = new IniSecurityManagerFactory(path);
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject currenUtils = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userName,password);
        try {
            currenUtils.login(token);
            System.out.println("身份验证成功！");
        } catch (AuthenticationException e) {
            e.printStackTrace();
            System.out.println("身份验证失败！");
        }
        return currenUtils;
    }
}
