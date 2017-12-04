import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import nl.practice.aspect.model.Jedi;


public class App {

    public static void main(String[] args) {
        run();
    }

    public static void run(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("nl.practice");
        Jedi revan = (Jedi) applicationContext.getBean("createJedi");
        System.out.println(revan.getName());
    }
}
