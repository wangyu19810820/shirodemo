package hash;

import beanutils.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.Factory;
import org.apache.shiro.util.SimpleByteSource;

public class HashDemo {

    public static void main(String[] args) {
        String plainTextPassword = "123";
//        RandomNumberGenerator rng = new SecureRandomNumberGenerator();
//        ByteSource salt = rng.nextBytes();
        SimpleByteSource salt = new SimpleByteSource("0ef77cfb7aafd7a2022ceb8552acfabe");
        String hashedPasswordBase641 = new Sha256Hash(plainTextPassword, salt, 1024).toHex();
        String hashedPasswordBase642 = new Sha256Hash(plainTextPassword, "0ef77cfb7aafd7a2022ceb8552acfabe", 1024).toBase64();
        System.out.println(hashedPasswordBase641);
        System.out.println(hashedPasswordBase642);
//        System.out.println(salt.toHex());

        login();

    }

    public static void login() {
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro2.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        Subject currentUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("lonestarr", "123");
        try {
            currentUser.login(token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
        System.out.println(currentUser.isAuthenticated());
    }
}
