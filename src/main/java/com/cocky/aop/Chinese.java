package com.cocky.aop;

import org.springframework.stereotype.Component;

@Component
public class Chinese implements Person {

	public Chinese() {
		System.out.println("constructor");
	}
	
//	@Timer
	@Override
	public String sayHello(String name) {
		// TODO Auto-generated method stub
		System.out.println("--sayHello()--");
		return name + " hello, AOP";
	}
	
	public void eat(String food) {
		System.out.println("我正在吃: " + food);
	}
		
}
