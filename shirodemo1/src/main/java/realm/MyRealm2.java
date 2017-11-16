package realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.*;

/**
 * Realm是访问用户授权信息和认证信息的Dao
 * MyRealm1是自定义Realm，核心是doGetAuthorizationInfo，doGetAuthenticationInfo
 * supports方法返回true，shiro默认的多Realm认证器才会调用该Realm的认证方法
 */
public class MyRealm2 extends AuthorizingRealm {

    static Map<String, String> userPasswordMap;
    static Map<String, List<String>> permissionMap;
    static Map<String, List<String>> roleMap;
    static {
        userPasswordMap = new HashMap<>();
        userPasswordMap.put("root", "secret");
        userPasswordMap.put("lonestarr", "efg");

        roleMap = new HashMap<>();
//        roleMap.put("root", Arrays.asList("admin"));
//        roleMap.put("lonestarr", Arrays.asList("schwartz"));

        permissionMap = new HashMap<>();
//        permissionMap.put("admin", Arrays.asList("admin"));
//        permissionMap.put("schwartz", Arrays.asList("lightsaber:a:b:c:d:e:*"));
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String user = (String)principalCollection.getPrimaryPrincipal();
        List<String> roleList = roleMap.get(user);
        List<String> permissionList = new ArrayList<>();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addRoles(roleList);
        for (String role : roleMap.get(user)) {
            permissionList.addAll(permissionMap.get(role));
        }
        info.addStringPermissions(permissionList);
        return info;
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return true;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String useName = ((UsernamePasswordToken) authenticationToken).getUsername();
        String password = userPasswordMap.get(useName);

        return new SimpleAuthenticationInfo(useName, password, useName);
    }

}
