package com.gavin.community.mvp.model;

import com.gavin.community.app.db.DBHelper;
import com.gavin.community.app.http.HttpHelper;

/**
 * Created by Administrator on 2017/7/10.
 */

public class DataManager implements HttpHelper, DBHelper {
    HttpHelper mHttpHelper;
    DBHelper mDbHelper;

    public DataManager(HttpHelper httpHelper, DBHelper dbHelper) {
        mHttpHelper = httpHelper;
        mDbHelper = dbHelper;
    }

    @Override
    public  boolean queryPostId(int id){
        return true;
    }
}
