package com.cocky.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AdviceTest {
	
	@Pointcut("@annotation(com.cocky.aop.Timer)")
	public void pointcut() {}
	
	@Before("pointcut()")
	public void before() {
		System.out.println("before");
	}
	
	@After("execution(* com.cocky.aop.Chinese.sayHello(..))")
	public void after() {
		
	}
}
