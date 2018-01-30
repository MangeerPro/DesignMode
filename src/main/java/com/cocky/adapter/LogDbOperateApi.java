package com.cocky.adapter;

import java.util.List;

/**
 * 定义操作日志的应用接口
 */
public interface LogDbOperateApi {
    /**
     * 新增日志
     *
     * @param lm 需要新增的日志对象
     */
    public void createLog(LogModel lm);

    /**
     * 修改日志
     *
     * @param lm 需要修改的日志对象
     */
    public void updateLog(LogModel lm);

    /**
     * 删除日志
     *
     * @param lm 需要删除的日志对象
     */
    public void removeLog(LogModel lm);

    /**
     * 获取所有日志
     *
     * @return 所有日志对象
     */
    public List<LogModel> getAllLog();
}
