package com.cocky.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.Assert;

public class Main {
	public static void main(String[] args) {
		ApplicationContext context = 
				new AnnotationConfigApplicationContext(DiConfig.class);
		context.getBean(SayHello.class).say();
	}
}
