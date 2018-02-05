package com.cocky.singleton.lazy.threadsafe;

/**
 * 线程安全的单例模式,双重校验加锁
 */
public class Singleton {
    /**
     * 存储单例对象实例，对保存实例的变量添加volatile关键字，该变量读写共享内存
     * volatile关键字会屏蔽掉虚拟机的一些必要的代码优化，运行效率并不高
     */
    private volatile static Singleton instance = null;

    private Singleton() {
        //处理相关操作
    }

    /**
     * 获取单例对象实例
     */
    public static Singleton getInstance() { 
    			//先检查实例是否存在
            if (instance == null) {
            		//同步块，线程安全的创建实例
            		synchronized(Singleton.class) {
            			if(instance == null) {
            			instance = new Singleton();
            			}
            		}
            }
        return instance;
    }

}
