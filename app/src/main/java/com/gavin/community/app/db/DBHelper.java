package com.gavin.community.app.db;

/**
 * Created by Administrator on 2017/7/10.
 */

public interface DBHelper {
    void insertNewsId(int id);

    /**
     * 查询 阅读记录
     * @param id
     * @return
     */
    boolean queryPostId(int id);
}
