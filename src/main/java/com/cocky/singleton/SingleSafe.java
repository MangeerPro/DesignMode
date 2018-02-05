package com.cocky.singleton;

/**
 * 线程安全的单例模式
 */
public class SingleSafe {
    /**
     * 存储单例对象实例
     */
    private static volatile SingleSafe instance = null;

    private SingleSafe() {
        //处理相关操作
    }

    /**
     * 获取单例对象实例
     */
    public static SingleSafe getInstance() {
        synchronized (SingleSafe.class) {
            if (instance == null) {
                instance = new SingleSafe();
            }
        }
        return instance;
    }

}
