package com.cocky.singleton.eager;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 单例模式，实现参数配置文件加载
 */
public class SingleAppConfig {
    /**
     * 用于存储单例实例的参数
     */
    private static SingleAppConfig instance = new SingleAppConfig();
    /**
     * 用于存储参数A，B
     */
    private String parameterA;
    private String parameterB;

    /**
     * 私有化构造函数，隐藏
     */
    private SingleAppConfig() {
        //读取配置文件方法
        System.out.println("饿汉模式读取配置文件开始：");
        readConfig();
    }

    /**
     * 读取配置文件方法
     */
    private void readConfig() {
        InputStream inputStream = null;
        Properties properties = new Properties();
        try {
            inputStream = SingleAppConfig.class.getClassLoader().getResourceAsStream("AppConfig.properties");
            properties.load(inputStream);
            //获取参数赋值
            this.parameterA = properties.getProperty("paramA");
            this.parameterB = properties.getProperty("paramB");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 外部获取单例方法
     * @return instance
     */
    public static SingleAppConfig getInstance() {
        return instance;
    }

    public String getParameterA() {
        return parameterA;
    }

    public String getParameterB() {
        return parameterB;
    }


}

