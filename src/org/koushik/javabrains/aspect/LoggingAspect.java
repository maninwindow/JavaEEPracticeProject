package org.koushik.javabrains.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {
	//@Before("execution(public String getName())")
	@Before("execution(public * get*())")
	public void LoggingAdvice(){
		System.out.println("Advice run, Get method called");
	}
}
