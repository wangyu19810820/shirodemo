package realm;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.permission.WildcardPermission;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

/**
 * 测试自定义Realm和多Realm
 */
public class CustomRealmDemo {

    public static void main(String[] args) {
        login("lonestarr", "efg");
    }

    private static void login(String username, String password) {
        // 从ini文件中载入配置
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro1.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        // 认证
        Subject currentUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        token.setRememberMe(true);
        currentUser.login(token);
        System.out.println(currentUser.isAuthenticated());
        System.out.println(currentUser.hasRole("schwartz"));
        System.out.println(currentUser.isPermitted("lightsaber:a:b:c:d:e:f"));
    }
}
