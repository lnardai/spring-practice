package nl.practice.aspect.beans;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectsExample {

	@Before("execution(public void nl.practice.jpa.entity.Jedi.setName(String))")
	public void logStudentSetter(JoinPoint joinPoint){
		System.out.println("*** " + joinPoint.getSignature().getName() + " has been called, with:");
		Object[] objects = joinPoint.getArgs();
		Arrays.stream(objects).forEach(System.out::println);
	}
}
