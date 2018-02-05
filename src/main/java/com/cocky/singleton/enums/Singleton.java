package com.cocky.singleton.enums;

public enum Singleton {
	/**
	 * 定义一个枚举的元素，就代表了一个single实例，而且已经完成序列化
	 */
	uniqueInstance;
	/**
	 * 示意方法，单例可以有自己的操作
	 */
	public void singletonOperation() {
		//功能处理
		System.out.println("Enum Singleton!");
	}
}
