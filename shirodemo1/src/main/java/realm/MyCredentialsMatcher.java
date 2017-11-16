package realm;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

/**
 * 自定义凭证匹配器，SimpleCredentialsMatcher是默认的匹配器，其功能就是简单直接比较是否相等
 */
public class MyCredentialsMatcher extends SimpleCredentialsMatcher {

    @Override
    public boolean doCredentialsMatch(AuthenticationToken authenticationToken,
                                      AuthenticationInfo authenticationInfo) {
//        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
//        if (token.getUsername().equals("lonestarr") && new String(token.getPassword()).equals("abc")) {
//            return true;
//        }
//        return false;
       return super.doCredentialsMatch(authenticationToken, authenticationInfo);
    }
}
