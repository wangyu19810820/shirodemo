package configuration.ini;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

/**
 * 从ini文件中加载配置
 */
public class ConfigureFromIniFile {

    public static void main( String[] args ) {
        login("lonestarr", "vespa");
        Subject currentUser = SecurityUtils.getSubject();
        // 授权
        System.out.println(currentUser.getPrincipal());
        System.out.println(currentUser.hasRole("roleNoPermission"));
        System.out.println(currentUser.isPermitted("lightsaber:weild"));
        System.out.println(currentUser.isPermitted("winnebago:drive:eagle5"));
        currentUser.logout();
    }

    public static void login(String username, String password) {
        // 从ini文件中载入配置
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        // 认证
        Subject currentUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        token.setRememberMe(true);
        currentUser.login(token);
    }
}
