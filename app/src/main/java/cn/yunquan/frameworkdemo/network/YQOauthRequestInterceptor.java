package cn.yunquan.frameworkdemo.network;

import android.util.Log;

import cn.yunquan.frameworkdemo.keeper.AccessTokenKeeper;
import retrofit.RequestInterceptor;

/**
 * Created by Administrator on 2015-07-28.
 */
public class YQOauthRequestInterceptor implements RequestInterceptor {
    @Override
    public void intercept(RequestFacade request) {
        AccessTokenKeeper keeper = AccessTokenKeeper.getInstance();
        Log.i("YQOInterceptor", "keeper.getAuthorization()=" + keeper.getAuthorization());
        request.addHeader("Authorization", keeper.getAuthorization());
    }
}
