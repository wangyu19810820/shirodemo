package hash;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.SimpleByteSource;

import java.util.ArrayList;
import java.util.List;

public class CustomHashRealm extends AuthorizingRealm {

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String useName = ((UsernamePasswordToken) authenticationToken).getUsername();
        String salt = "0ef77cfb7aafd7a2022ceb8552acfabe";
//        String password = "ca784fcc60db4319c6b8ef327e9fa284b55c9d652b96ddbc4e755624e52fecb1";
        String password = "ynhPzGDbQxnGuO8yfp+ihLVcnWUrlt28TnVWJOUv7LE=";

        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(useName, password, "CustomHashRealm");
        authenticationInfo.setCredentialsSalt(new SimpleByteSource(salt));

        return authenticationInfo;
    }
}
