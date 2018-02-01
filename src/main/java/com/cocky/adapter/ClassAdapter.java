package com.cocky.adapter;

import java.util.List;

/**
 * 类适配器
 */
public class ClassAdapter extends LogFileOperate implements LogDbOperateApi {
    /**
     * 构造方法，传入文件的路径和名称
     *
     * @param logFilePathName 文件路径和名称
     */
    public ClassAdapter(String logFilePathName) {
        super(logFilePathName);
    }

    /**
     * @param lm 需要新增的日志对象
     */
    @Override
    public void createLog(LogModel lm) {
        //1、读取文件
        List<LogModel> list = this.readLogFile();
        //2、加入新的日志对象
        list.add(lm);
        //3、写入文件
        this.writeLogFile(list);
    }

    @Override
    public void updateLog(LogModel lm) {
        //1、读取文件
        List<LogModel> list = this.readLogFile();
        //2、更新列表
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getLogId() == lm.getLogId()) {
                list.set(i, lm);
            }
        }
        this.writeLogFile(list);
    }

    @Override
    public void removeLog(LogModel lm) {
        //1、读取文件
        List<LogModel> list = this.readLogFile();
        //2、更新列表
        list.remove(lm);
        this.writeLogFile(list);
    }

    @Override
    public List<LogModel> getAllLog() {
        return this.readLogFile();
    }
}
