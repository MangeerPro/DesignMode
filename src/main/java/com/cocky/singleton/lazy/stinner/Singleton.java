package com.cocky.singleton.lazy.stinner;

public class Singleton {
	/**
	 * 类级内部类，即静态成员内部类，该内部类与外部类的实例
	 * 没有绑定关系，而且只有调用到时才会装载，从而实现延迟加载
	 */
	private static class SingletonHolder {
		/**
		 * 静态初始化器，由JVM来保证线程安全
		 */
		private static Singleton instance = new Singleton();
	}
	
	/**
	 * 私有化构造函数
	 */
	private Singleton() {
	}
	/**
	 * 获取对象
	 * @return
	 */
	public static Singleton getInstance() {
		return  SingletonHolder.instance;
	}
}
