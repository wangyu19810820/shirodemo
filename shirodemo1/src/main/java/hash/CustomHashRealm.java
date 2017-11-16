package hash;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

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
        String salt = "rFFpkcTR8yRNueTT9/CnXQ==";
        String password = "oYnvAYVKeVWzjH/8RlCp3zS4s3zmye/lx4Kd5JKVyYA=";
        String pwd = "aefc8a8af393f536d9918ee9166a7f1584025b541df5d38b09f3d74ddc0dcd95";

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String useName = ((UsernamePasswordToken) authenticationToken).getUsername();

        return new SimpleAuthenticationInfo(useName, pwd, "CustomHashRealm");
    }
}
