package wangyu1981;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.apache.shiro.mgt.SecurityManager;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        session.setAttribute("someKey", "aValue");
        System.out.println(currentUser);
        UsernamePasswordToken token = new UsernamePasswordToken("lonestarr", "vespa");
        token.setRememberMe(true);
        currentUser.login(token);
        System.out.println(currentUser.getPrincipal());
        System.out.println(currentUser.hasRole("goodguy"));
        System.out.println(currentUser.isPermitted("lightsaber:weild"));
        System.out.println(currentUser.isPermitted("winnebago:drive:eagle5"));
        currentUser.logout();
        System.out.println(currentUser);
//        System.out.println(session.getAttribute("someKey"));
    }
}
