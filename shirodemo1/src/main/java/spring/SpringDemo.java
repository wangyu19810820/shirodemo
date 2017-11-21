package spring;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringDemo {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "classpath:spring.xml");

        Subject curUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("lonestarr", "123");
        curUser.login(token);

        System.out.println(curUser.isAuthenticated());
        System.out.println(curUser.hasRole("schwartz"));
        System.out.println(curUser.isPermitted("lightsaber:a:b:c:d:e"));
    }
}
