package com.cocky.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext applicationContext = 
				new AnnotationConfigApplicationContext(AopConfig.class);
		Chinese chinese = applicationContext.getBean(Chinese.class);
		chinese.sayHello("New");
	}
}
