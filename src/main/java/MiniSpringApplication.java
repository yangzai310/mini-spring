import com.mini.domain.core.ClassPathXmlApplicationContext;

public class MiniSpringApplication {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("beans.xml");
        Object userService = classPathXmlApplicationContext.getBean("userService");
        System.out.println(userService);
    }
}