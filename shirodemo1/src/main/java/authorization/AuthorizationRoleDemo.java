package authorization;

import configuration.ini.ConfigureFromIniFile;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import java.util.Arrays;

public class AuthorizationRoleDemo {

    public static void main(String[] args) {
        ConfigureFromIniFile.login("lonestarr", "vespa");
        Subject currentUser = SecurityUtils.getSubject();
        System.out.println(currentUser.hasRole("goodguy"));
        System.out.println(Arrays.toString(currentUser.hasRoles(Arrays.asList("goodguy", "schwartz"))));
        System.out.println(Arrays.toString(currentUser.hasRoles(Arrays.asList("schwartz", "aaa"))));
        System.out.println(currentUser.hasAllRoles(Arrays.asList("goodguy", "schwartz")));
        System.out.println(currentUser.hasAllRoles(Arrays.asList("schwartz", "aaa")));

        currentUser.checkRole("goodguy");
//        currentUser.checkRole("aaa");

        // 角色检验全通过则安静返回，否则抛运行时异常：UnauthorizedException
        currentUser.checkRoles(Arrays.asList("goodguy", "schwartz"));
//        currentUser.checkRoles(Arrays.asList("schwartz", "aaa"));

        currentUser.checkRoles("goodguy", "schwartz");
        currentUser.checkRoles("goodguy", "aaa");
    }
}
