package authorization;

import configuration.ini.ConfigureFromIniFile;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.subject.Subject;

import java.util.Arrays;

public class AuthorizationPermissionDemo {

    public static void main(String[] args) {
        ConfigureFromIniFile.login("lonestarr", "vespa");
        Subject currentUser = SecurityUtils.getSubject();
//        Permission permission = new SysPermission("user", "query");
//        System.out.println(currentUser.isPermitted(permission));

        System.out.println(currentUser.isPermitted("winnebago:ss:eagle5"));
        System.out.println(currentUser.isPermitted("winnebago:ss:aa"));

        System.out.println(Arrays.toString(currentUser.isPermitted(
                "winnebago:ss:eagle5", "lightsaber", "aaa")));

        System.out.println(currentUser.isPermittedAll(
                "winnebago:ss:eagle5", "lightsaber"));
        System.out.println(currentUser.isPermittedAll(
                "winnebago:ss:eagle5", "lightsaber", "aaa"));

        currentUser.checkPermission("winnebago:ss:eagle5");
        currentUser.checkPermissions("winnebago:ss:eagle5", "lightsaber");
        currentUser.checkPermissions("winnebago:ss:eagle5", "lightsaber", "aaa");
    }
}

class SysPermission implements Permission {

    private String module;
    private String oper;

    public SysPermission(String module, String oper) {
        this.module = module;
        this.oper = oper;
    }

    @Override
    public boolean implies(Permission permission) {
        return true;
    }
}
