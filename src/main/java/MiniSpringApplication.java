import com.mini.context.ClassPathXmlApplicationContext;
import com.mini.domain.IUserService;

public class MiniSpringApplication {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("beans.xml");
        IUserService userService = (IUserService) classPathXmlApplicationContext.getBean("userService");
        userService.test();
    }
}