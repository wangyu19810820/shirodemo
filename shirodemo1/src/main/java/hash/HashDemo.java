package hash;

import beanutils.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.Factory;

public class HashDemo {

    public static void main(String[] args) {
//        String plainTextPassword = "123";
//        RandomNumberGenerator rng = new SecureRandomNumberGenerator();
//        ByteSource salt = rng.nextBytes();
//        String hashedPasswordBase64 = new Sha256Hash(plainTextPassword, salt, 1024).toBase64();
//        System.out.println(hashedPasswordBase64);
//        System.out.println(salt.toBase64());

        login();

    }

    public static void login() {
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro2.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        Subject currentUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("lonestarr", "vespa");
        currentUser.login(token);
    }
}
