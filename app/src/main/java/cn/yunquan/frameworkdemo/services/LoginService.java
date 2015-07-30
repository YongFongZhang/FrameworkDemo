package cn.yunquan.frameworkdemo.services;

import java.util.HashMap;

import cn.yunquan.frameworkdemo.enties.AccessTokenResponse;
import retrofit.http.Multipart;
import retrofit.http.POST;
import retrofit.http.PartMap;

/**
 * Created by Administrator on 2015-07-27.
 */
public interface LoginService {

    @Multipart
    @POST("/o/token/")
    AccessTokenResponse getAccessToken(@PartMap HashMap<String, String> params);
}
