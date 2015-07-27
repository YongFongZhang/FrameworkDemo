package cn.yunquan.frameworkdemo;

import android.app.Application;

/**
 * Created by Administrator on 2015-07-27.
 */
public class YQApplication extends Application {

    private static YQApplication mInstance;

    public static YQApplication getInstance(){
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }
}
