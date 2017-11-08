package authorization;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresGuest;

public class AuthorizationAnnotationDemo {

    public static void main(String[] args) {
        signUp();
        updateAccount();
    }

    @RequiresGuest
    public static void signUp() {

    }

    @RequiresAuthentication
    public static void updateAccount() {

    }
}


