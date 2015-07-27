package cn.yunquan.frameworkdemo.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import cn.yunquan.frameworkdemo.YQApplication;

/**
 * Created by Administrator on 2015-07-27.
 */
public class SystemUtils {


    /**
     * 网络类型
     */
    public enum NetWorkType {
        none, mobile, wifi
    }

    /**
     * 获取当前网络类型
     * @return
     */
    public static NetWorkType getNetworkType() {

        ConnectivityManager connMgr = (ConnectivityManager) YQApplication.getInstance().getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        if (networkInfo != null) {
            switch (networkInfo.getType()) {
                case ConnectivityManager.TYPE_MOBILE:
                    return NetWorkType.mobile;
                case ConnectivityManager.TYPE_WIFI:
                    return NetWorkType.wifi;
            }
        }

        return NetWorkType.none;
    }
}
