import com.wangyu.session.CustomSessionDao;
import com.wangyu.session.SpringContextHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class CustomSessionDaoTest {

    @Autowired
    private CustomSessionDao sessionDao;

    @Test
    public void test() {
        sessionDao.doCreate(null);
        System.out.println(sessionDao);
    }
}
