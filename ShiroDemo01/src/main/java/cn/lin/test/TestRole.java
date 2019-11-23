package cn.lin.test;

import org.apache.shiro.subject.Subject;
import org.junit.Test;

import java.util.Arrays;

public class TestRole {
    @Test
    public void test1() {
        //得到当前用户
        Subject currentUser = ShiroUtil.login("classpath:shiro-role.ini", "admin", "123456");
        //Subject currentUser = ShiroUtil.login("classpath:shiro_role.ini", "test", "123");
        System.out.println(currentUser.hasRole("role2")?"有这个角色":"没有这个角色");
        //判断多个角色
        boolean [] results = currentUser.hasRoles(Arrays.asList("role1","role2","role3"));
        System.out.println(results[0]?"有role1这个角色":"没有role1这个角色");
        System.out.println(results[1]?"有role2这个角色":"没有role2这个角色");
        System.out.println(results[2]?"有role3这个角色":"没有role3这个角色");
        //退出
        currentUser.logout();
    }
    @Test
    public void testCheckRole() {
        //Subject currentUser = ShiroUtil.login("classpath:shiro_role.ini", "admin", "123456");
        Subject currentUser = ShiroUtil.login("classpath:shiro-role.ini", "test", "123");
        currentUser.checkRole("role1");
      //  currentUser.checkRoles(Arrays.asList("role1","role2"));
       // currentUser.checkRoles("role1","role2","role3");
        currentUser.logout();
    }
    @Test
    public void testPermission() {
        // 得到当前用户
        Subject currentUser = ShiroUtil.login("classpath:shiro_permission.ini", "test", "123");
        System.out.println(currentUser.isPermitted("user:select")?"有user:select这个权限":"没有user:select这个权限");
        boolean [] results = currentUser.isPermitted("user:select","user:update","user:delete","user:add");
        System.out.println(results[0]?"有user:select这个权限":"没有user:select这个权限");
        System.out.println(results[1]?"有user:update这个权限":"没有user:update这个权限");
        System.out.println(results[2]?"有user:delete这个权限":"没有user:delete这个权限");
        System.out.println(results[3]?"有user:add这个权限":"没有user:add这个权限");
        // 退出
        currentUser.logout();
    }

}
