package com.cocky.adapter;

import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.List;

/**
 * 实现对日志文件的操作
 */
public class LogFileOperate implements LogFileOperateApi {
    /**
     * 日志文件的路径和文件名称，默认是当前项目根目录下的AdapterLog.log
     */
    private String logFilePathName = "AdapterLog.log";

    /**
     * 构造方法，传入文件的路径和名称
     *
     * @param logFilePathName 文件路径和名称
     */
    public LogFileOperate(String logFilePathName) {
        //先判断是否传入了文件的路径和名称，如果是，就设置
        if (logFilePathName != null && StringUtils.isNotBlank(logFilePathName)) {
            this.logFilePathName = logFilePathName;
        }
    }

    @Override
    public List<LogModel> readLogFile() {
        List<LogModel> list = null;
        ObjectInputStream oin = null;
        try {
            File file = new File(logFilePathName);
            if (file.exists()) {
                oin = new ObjectInputStream(
                        new BufferedInputStream(new FileInputStream(file)));
                list = (List<LogModel>) oin.readObject();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (oin != null) {
                    oin.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    @Override
    public void writeLogFile(List<LogModel> list) {
        File file = new File(logFilePathName);
        ObjectOutputStream outputStream = null;

        try {
            outputStream = new ObjectOutputStream(
                    new BufferedOutputStream(new FileOutputStream(file)));
            outputStream.writeObject(list);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
