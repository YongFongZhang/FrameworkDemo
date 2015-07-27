package cn.yunquan.frameworkdemo.network;

import com.google.gson.GsonBuilder;
import com.squareup.okhttp.Cache;
import com.squareup.okhttp.OkHttpClient;

import java.io.File;
import java.util.concurrent.TimeUnit;

import cn.yunquan.frameworkdemo.BuildConfig;
import cn.yunquan.frameworkdemo.YQApplication;
import retrofit.ErrorHandler;
import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;

/**
 * Created by Administrator on 2015-07-27.
 */
public class Api {
    private static final long DISK_CACHE_SIZE = 2 * 1024 * 1024; // 2M
    private static final long SESSION_TIME_OUT_SECONDS = 8 ; // 请求超时8s
    private static RestAdapter restAdapter;

    /**
     * 获取Rest代理
     * @return
     */
    private static RestAdapter getRestAdapter(){
        if (restAdapter != null){
            return restAdapter;
        } else {
            restAdapter = new RestAdapter.Builder()
                    .setEndpoint(BuildConfig.API_ENDPOINT)  // api终端
                    .setConverter(new GsonConverter(new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create())) // 数据转换
                    .setClient(new OkClient(getOkHttpClient())) // 网络连接客户端
                    .setErrorHandler(ErrorHandler.DEFAULT) // 错误处理
                    .setLogLevel(BuildConfig.DEBUG ? RestAdapter.LogLevel.FULL : RestAdapter.LogLevel.NONE) // 日志级别
                    .setErrorHandler(ErrorHandler.DEFAULT)
                    .build();
            return restAdapter;
        }
    }

    /**
     * 生成OkHttp网络客户端
     * @return
     */
    public static OkHttpClient getOkHttpClient() {
        OkHttpClient client = new OkHttpClient();
        configureHttpCache(client);
        return client;
    }

    /**
     *  配置OkHttp网络客户端
     * @param client
     */
    public static void configureHttpCache(OkHttpClient client) {
        // Install an HTTP cache in the application cache directory.
        File cacheDir = new File(YQApplication.getInstance().getCacheDir(), "http");
        Cache cache = new Cache(cacheDir, DISK_CACHE_SIZE);
        client.setCache(cache);
        client.setConnectTimeout(SESSION_TIME_OUT_SECONDS, TimeUnit.SECONDS);
    }


    /**
     * 圈子Api服务
     * @return
     */
    public static CircleService getCircleService(){
        return getRestAdapter().create(CircleService.class);
    }

    /**
     * Oauth认证Api服务
     * @return
     */
    public static OauthService getOauthService(){
        return getRestAdapter().create(OauthService.class);
    }
}
