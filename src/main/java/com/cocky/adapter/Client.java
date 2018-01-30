package com.cocky.adapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Client {
    public Client() {
    }

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

        LogFileOperateApi fileOperate = new LogFileOperate("");

        //保存日志
        fileOperate.writeLogFile(list);

        //读取日志
        List<LogModel> list1 = fileOperate.readLogFile();
        System.out.println("readlog :" + list1.get(0));


    }
}
