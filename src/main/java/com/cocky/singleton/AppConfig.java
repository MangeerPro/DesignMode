package com.cocky.singleton;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 读取应用配置文件,非单例模式
 */
public class AppConfig {
    /**
     * 用来存放配置文件中参数A的值
     */
    private String parameterA;

    /**
     * 用来存放配置文件中参数B的值
     */
    private String parameterB;

    public String getParameterA() {
        return parameterA;
    }

    public String getParameterB() {
        return parameterB;
    }

    /**
     * 构造方法
     */
    public AppConfig() {
        Properties properties = new Properties();
        InputStream inputStream = null;
        try {
            inputStream = AppConfig.class.getClassLoader().getResourceAsStream("AppConfig.properties");
            if (inputStream != null)
                properties.load(inputStream);
            this.parameterA = properties.getProperty("paramA");
            this.parameterB = properties.getProperty("paramB");
        } catch (IOException e) {
            System.err.println("装载配置文件出错，具体堆栈信息如下：");
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
}
