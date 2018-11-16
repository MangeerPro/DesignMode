package com.cocky.annotation;

import java.util.concurrent.CompletableFuture;

public class Main {
	public static void main(String[] args) {
		TestAnnotation test = new TestAnnotation();
		CompletableFuture<String> comp = 
				CompletableFuture.completedFuture("complete");
			assertTrue(comp.isDone());
		test.say();
	}
}
