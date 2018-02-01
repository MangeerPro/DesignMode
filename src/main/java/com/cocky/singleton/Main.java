package com.cocky.singleton;

public class Main {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        System.out.println(appConfig.getParameterA() + "|" + appConfig.getParameterB());
    }
}
