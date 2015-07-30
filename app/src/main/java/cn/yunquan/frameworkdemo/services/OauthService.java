package cn.yunquan.frameworkdemo.services;

import cn.yunquan.frameworkdemo.enties.ClientInfoResponse;
import retrofit.http.POST;

/**
 * Created by Administrator on 2015-07-28.
 */
public interface OauthService {
    /**
     * 获取客户端信息
     * @return
     */
    @POST("/o/login/")
    ClientInfoResponse getClientIntfo();
}
