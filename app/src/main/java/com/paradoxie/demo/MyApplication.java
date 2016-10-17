package com.paradoxie.demo;/**
 * Created by xiehehe on 2016/10/16.
 */

import android.app.Application;

import com.paradoxie.demo.db.DbCore;

/**
 * User: xiehehe
 * Date: 2016-10-16
 * Time: 22:46
 * FIXME
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化数据库
        DbCore.init(this);
    }
}
