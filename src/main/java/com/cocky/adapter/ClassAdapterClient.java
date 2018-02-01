package com.cocky.adapter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 类适配器模式客户端
 */
public class ClassAdapterClient {
    public static void main(String[] args) {
        //准备日志内容
        LogModel lml = new LogModel();
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss E");
        String time = simpleDateFormat.format(date);
        lml.setLogId("001");
        lml.setOperateUser("admin");
        lml.setOperateTime(time);
        lml.setLogContent("这是一个测试");

        LogDbOperateApi logDbOperateApi = new ClassAdapter("");
        logDbOperateApi.createLog(lml);

        List<LogModel> list = logDbOperateApi.getAllLog();

        System.out.println("AllLog: " + list.get(0));
    }
}
