package com.cocky.singleton.lazy;

/**
 * 饿汉模式单例客户端
 */
public class SingleConfigClient {
    public static void main(String[] args) {
        SingleAppConfig singleAppConfig
                = SingleAppConfig.getInstance();
        System.out.println("paramA = " + singleAppConfig.getParameterA()
                + ", paramB = " + singleAppConfig.getParameterB());
    }
}
