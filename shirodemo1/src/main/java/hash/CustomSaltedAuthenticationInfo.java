package hash;

import org.apache.shiro.authc.SaltedAuthenticationInfo;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.SimpleByteSource;

public class CustomSaltedAuthenticationInfo implements SaltedAuthenticationInfo {

    private String principal;
    private String credential;

    public CustomSaltedAuthenticationInfo(String principal, String credential) {
        this.principal = principal;
        this.credential = credential;
    }

    @Override
    public ByteSource getCredentialsSalt() {
        return new SimpleByteSource("rFFpkcTR8yRNueTT9/CnXQ==");
    }

    @Override
    public PrincipalCollection getPrincipals() {
        return null;
    }

    @Override
    public Object getCredentials() {
        return credential;
    }
}
