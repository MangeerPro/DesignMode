package com.cocky.annotation;

import lombok.Data;

@Data
public class TestAnnotation {
	private String name;
	
	@New
	public void say() {
		System.out.println(name);
	}
}
