package hash;

import org.apache.shiro.authc.credential.Sha256CredentialsMatcher;
import org.apache.shiro.crypto.hash.Hash;
import org.apache.shiro.crypto.hash.SimpleHash;

public class CustomHashCredentialsMatcher extends Sha256CredentialsMatcher {

    protected Hash hashProvidedCredentials(Object credentials, Object salt, int hashIterations) {

        return new SimpleHash(getHashAlgorithmName(), credentials, salt, hashIterations);
    }
}
