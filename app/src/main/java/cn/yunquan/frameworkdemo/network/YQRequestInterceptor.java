package cn.yunquan.frameworkdemo.network;

import cn.yunquan.frameworkdemo.keeper.AccessTokenKeeper;
import retrofit.RequestInterceptor;

/**
 * Created by Administrator on 2015-07-28.
 */
public class YQRequestInterceptor implements RequestInterceptor {
    @Override
    public void intercept(RequestFacade request) {
        AccessTokenKeeper keeper = AccessTokenKeeper.getInstance();
        request.addHeader("Authorization", keeper.readTokenType() + " " + keeper.readAccessToken());
    }
}
