package com.cocky.singleton.extend;

import java.util.HashMap;
import java.util.Map;

/**
 * 扩展单例模式，控制实例数为3
 * @author haohao
 *
 */
public class OneExtend {
	/**
	 * 定义一个缺省的key值前缀
	 */
	private final static String DEFAULT_KEY = "Cache";
	/**
	 * 定义控制实例的最大数量
	 */
	private final static int NUM_MAX = 3;
	/**
	 * 存储实例容器
	 */
	private static Map<String, OneExtend> map = new HashMap<>();
	
	/**
	 * 用来记录当前正在使用第几个实例，到了控制的最大数目，就返回从1开始
	 */
	private static int num = 1;
	
	private OneExtend() {}
	
	public static OneExtend getInstance() {
		String key = DEFAULT_KEY + num;
		//获取实例
		OneExtend instance = map.get(key);
		if(instance == null) {
			instance = new OneExtend();
			map.put(key, instance);
		}
		//把当前序号加1
		num++;
		//如果num大于最大实例数，则重制为1
		if(num > NUM_MAX) {
			num = 1;
		}
		return instance;
	}
	public static void main(String[] args) {
		System.out.println(getInstance());
		System.out.println(getInstance());
		System.out.println(getInstance());
		System.out.println(getInstance());
	}
}
