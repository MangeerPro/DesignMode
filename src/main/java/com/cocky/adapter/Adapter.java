package com.cocky.adapter;

import java.util.List;

public class Adapter implements LogDbOperateApi {
    /**
     * 持有需要适配的对象
     */
    private LogFileOperateApi adaptee;

    /**
     * 构造方法，传入需要适配的对象
     *
     * @param adaptee 需要被适配的对象
     */
    public Adapter(LogFileOperateApi adaptee) {
        this.adaptee = adaptee;
    }

    /**
     * @param lm 需要新增的日志对象
     */
    @Override
    public void createLog(LogModel lm) {
        //1、读取文件
        List<LogModel> list = adaptee.readLogFile();
        //2、加入新的日志对象
        list.add(lm);
        //3、写入文件
        adaptee.writeLogFile(list);
    }

    @Override
    public void updateLog(LogModel lm) {
        //1、读取文件
        List<LogModel> list = adaptee.readLogFile();
        //2、更新列表
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getLogId() == lm.getLogId()) {
                list.set(i, lm);
            }
        }
        adaptee.writeLogFile(list);
    }

    @Override
    public void removeLog(LogModel lm) {
        //1、读取文件
        List<LogModel> list = adaptee.readLogFile();
        //2、更新列表
        list.remove(lm);
        adaptee.writeLogFile(list);
    }

    @Override
    public List<LogModel> getAllLog() {
        return adaptee.readLogFile();
    }
}
