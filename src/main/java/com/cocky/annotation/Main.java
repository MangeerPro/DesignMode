package com.cocky.annotation;

import org.aspectj.weaver.ast.Test;

public class Main {
	public static void main(String[] args) {
		TestAnnotation test = new TestAnnotation();
		
		test.say();
	}
}
