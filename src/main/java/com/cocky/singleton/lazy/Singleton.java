package com.cocky.singleton.lazy;

/**
 * 懒汉模式单例
 */

public class Singleton {
    /**
     * 定义一个变量来存储创建好的实例
     */
    private static Singleton uniqueInstance = null;

    /**
     * 私有化构造函数
     */
    private Singleton() {
        //
    }

    /**
     * 定义一个方法来为客户端提供实例
     */
    public Singleton getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }

    /**
     * 示意方法，单例模式可以有自己的处理
     */
    public void singletonOperation() {
        //功能处理
    }

    /**
     * 单例模式可以有自己属性
     */
    private String singletonData;

    /**
     * 示意方法，外部通过这些方法访问属性的指
     *
     * @return singletonData
     */
    public String getSingletonData() {
        return singletonData;
    }
}
