package com.cocky.proxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

public class JdkProxyTest {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<?> proxyClass = Proxy.getProxyClass(JdkProxyTest.class.getClassLoader(), HelloWorld.class);
		final Constructor<?> constructor = proxyClass.getConstructor(InvocationHandler.class);
		final InvocationHandler invocationHandler = new CustomInvocationHandler(new HelloWorldImpl());
		HelloWorld object = (HelloWorld)constructor.newInstance(invocationHandler);
		object.sayHello();
		
		HelloWorld newInstance = (HelloWorld)Proxy.getProxyClass(JdkProxyTest.class.getClassLoader(), HelloWorld.class).
			getConstructor(InvocationHandler.class).newInstance(new CustomInvocationHandler(new HelloWorldImpl()));
		newInstance.sayHello();
	}
}
