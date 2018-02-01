package com.cocky.adapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
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
        List<LogModel> list = new ArrayList<LogModel>();
        list.add(lml);

        LogFileOperateApi logFileOperateApi = new LogFileOperate("");
        logFileOperateApi.writeLogFile(list);

        List<LogModel> list1 = logFileOperateApi.readLogFile();
        System.out.println("Log: " + list1.get(0));
    }
}
