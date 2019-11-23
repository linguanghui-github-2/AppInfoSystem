
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

public class HelloWorld {
    public static void main(String[] args){
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:jdbc_realm.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject currenUtils = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("admin","123456");
        try {
            currenUtils.login(token);
            System.out.println("身份验证成功！");
        } catch (AuthenticationException e) {
            e.printStackTrace();
            System.out.println("身份验证失败！");
        }
        currenUtils.logout();
    }
}
