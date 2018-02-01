package com.cocky.singleton.eager;

/**
 * 饿汉模式单例
 */
public class Singleton {
    /**
     * 定义一个变量来存储，创建好的类实例，直接在定义时创建，只能创建一次
     */
    private static Singleton uniqueSingleton = new Singleton();

    /**
     * 定义一个方法为客户端提供实例
     *
     * @return uniqueSingleton
     */
    public static Singleton getUniqueSingleton() {
        //直接使用创建好的实例
        return uniqueSingleton;
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
