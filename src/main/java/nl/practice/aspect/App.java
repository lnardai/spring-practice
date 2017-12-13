package nl.practice.aspect;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import nl.practice.jpa.entity.Jedi;

public class App {

    public static void main(String[] args) {
        run();
    }

    public static void run(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("nl.practice.aspect");
        Jedi revan = (Jedi) applicationContext.getBean("createJedi");
        revan.setName("Laci");
    }
}
