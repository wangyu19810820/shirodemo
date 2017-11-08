package configuration.ini;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.Ini;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

/**
 * 以编程方式，从ini实例中载入配置
 */
public class ConfigureFromIniInstance {

    public static void main(String[] args) {
        // 新建ini实例，添加两个section:users, roles
        Ini ini = new Ini();
        ini.addSection("users");
        ini.addSection("roles");

        // users section中添加用户lonestarr, 密码vespa， 拥有角色goodguy,schwartz
        Ini.Section usersSesction = ini.getSection("users");
        usersSesction.put("lonestarr", "vespa,goodguy,schwartz");

        // roles section中添加：角色schwartz拥有权限lightsaber:*, 角色goodguy拥有权限winnebago:drive:eagle5
        Ini.Section rolesSection = ini.getSection("roles");
        rolesSection.put("schwartz", "lightsaber:*");
        rolesSection.put("goodguy", "winnebago:drive:eagle5");

        // 从ini实例中载入配置
        Factory<SecurityManager> factory = new IniSecurityManagerFactory(ini);
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        // 认证
        Subject currentUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("lonestarr", "vespa");
        token.setRememberMe(true);
        currentUser.login(token);

        // 授权
        System.out.println(currentUser.getPrincipal());
        System.out.println(currentUser.hasRole("goodguy"));
        System.out.println(currentUser.isPermitted("lightsaber:weild"));
        System.out.println(currentUser.isPermitted("winnebago:drive:eagle5"));
        currentUser.logout();
    }
}
