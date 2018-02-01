package com.cocky.singleton.lazy;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SingleAppConfig {
    /**
     * 存储单例实例参数
     */
    private static SingleAppConfig instance = null;

    private String parameterA;
    private String parameterB;

    /**
     * 私有化构造函数
     */
    private SingleAppConfig() {

    }

    /**
     * 读取配置文件方法
     */
    private void readConfig() {
        InputStream inputStream = null;
        Properties properties = new Properties();
        try {
            com.cocky.singleton.eager.SingleAppConfig.class.getClassLoader().getResourceAsStream("AppConfig.properties");
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
                System.err.println("读取配置文件参数失败，堆栈错误信息如下：");
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取单例对象实例
     *
     * @return
     */
    public static SingleAppConfig getInstance() {
        if (instance == null) {
            instance = new SingleAppConfig();
        }
        return instance;
    }

    public String getParameterA() {
        return parameterA;
    }

    public String getParameterB() {
        return parameterB;
    }

}
