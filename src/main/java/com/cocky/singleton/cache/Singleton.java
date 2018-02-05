package com.cocky.singleton.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * 使用缓存来模拟实现单例
 */
public class Singleton {
    /**
     * 定义一个默认的key值，用来标识缓存中的存放
     */
    private final static String DEFAULT_KEY = "One";
    /**
     * 缓存实例容器
     */
    private static Map<String, Singleton> map = new HashMap<>();

    /**
     * 私有化构造函数
     */
    private Singleton() {
    }

    /**
     * 获取单例实例对象
     */
    public static Singleton getInstance() {
        //从缓存中获取实例
        Singleton instance = map.get(DEFAULT_KEY);
        //没有的话就创建一个存储缓存
        if (instance == null) {
            instance = new Singleton();
            map.put(DEFAULT_KEY, instance);
        }
        return instance;
    }

}
