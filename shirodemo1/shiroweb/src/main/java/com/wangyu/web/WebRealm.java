package com.wangyu.web;

import com.wangyu.model.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class WebRealm extends AuthorizingRealm {

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.addRole("goodguy");
        authorizationInfo.addStringPermission("user:query");
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        User user = new User();
        user.setFirstName((String)authenticationToken.getPrincipal());
        user.setLastName("aaa");
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, "vespa", "WebRealm");
        return info;
    }
}
