package session;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

public class SessionListenerDemo {

    public static void main(String[] args) {
        login("lonestarr", "vespa");
        Subject currentUser = SecurityUtils.getSubject();
    }

    public static void login(String username, String password) {
        // 从ini文件中载入配置
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-session.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        // 认证
        Subject currentUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        token.setRememberMe(true);
        currentUser.login(token);
    }
}
