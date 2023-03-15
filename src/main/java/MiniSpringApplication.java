import com.mini.domain.IUserService;
import com.mini.domain.core.ClassPathXmlApplicationContext;

public class MiniSpringApplication {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("beans.xml");
        IUserService userService = (IUserService) classPathXmlApplicationContext.getBean("userService");
        userService.test();
    }
}