package cn.yunquan.frameworkdemo.network;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;

import java.util.HashMap;

import cn.yunquan.frameworkdemo.enties.AccessTokenResponse;
import cn.yunquan.frameworkdemo.enties.ClientInfoResponse;
import cn.yunquan.frameworkdemo.event.YQNetworkResponseEvent;
import cn.yunquan.frameworkdemo.keeper.AccessTokenKeeper;
import de.greenrobot.event.EventBus;
import retrofit.RetrofitError;

/**
 * Created by Administrator on 2015-07-27.
 */
public class YQNetworkErrorResolver<T extends YQNetworkResponseEvent> {

    /**
     * 异常处理
     * @param throwable
     * @param responseEvent
     * @return
     */
    public boolean resolve(Throwable throwable, T responseEvent){
        if (throwable instanceof RetrofitError) {
            RetrofitError error = (RetrofitError) throwable;
            if (ApiException.RESPONSE_EXPIRED_SESSION == error.getResponse().getStatus()) {
                return handleSessionExpiredError();
            } else if (ApiException.VISIT_FORBIDDEN == error.getResponse().getStatus()) {
                return handleVisitForbiddenError();
            } else {
                return handleNetworkError(responseEvent);
            }
        } else if (throwable instanceof NoNetworkException){
            return handleNoNetworkError(responseEvent);
        }
        return false;
    }

    private boolean handleVisitForbiddenError() {
        getTokenInfo();
        return true;
    }


    /**
     * Session过期处理
     */
    private boolean handleSessionExpiredError() {
        AccessTokenKeeper keeper = AccessTokenKeeper.getInstance();
        if (TextUtils.isEmpty(keeper.readRefreshToken())){
            getTokenInfo();
        } else {
            // FixMe 通过 RefreshToken 重新获取
        }
        return true;
    }

    /**
     * 服务器错误
     * @param responseEvent
     * @return
     */
    private boolean handleNetworkError(@NonNull T responseEvent) {
        responseEvent.errorMessage = ApiException.SERVER_ERROR;
        responseEvent.isResponseSuccess = false;
        EventBus.getDefault().post(responseEvent);
        return false;
    }

    private boolean handleNoNetworkError(T responseEvent) {
        return false;
    }

    public void getTokenInfo() {
        AccessTokenKeeper keeper = AccessTokenKeeper.getInstance();
        ClientInfoResponse response = Api.getOauthService().getClientIntfo();
        Log.i("YQNetworkErrorResolver", "response=" + response);
        if (response != null){
            keeper.writeClientId(response.getClientId());
            keeper.writeClientSecret(response.getClientSecret());

            // FixMe 实际应该调到登录界面
            HashMap<String, String> params = new HashMap<>();
            params.put("username", "sharp");
            params.put("password", "123456");
            params.put("grant_type", "password");
            AccessTokenResponse accessTokenResponse = Api.getLoginService().getAccessToken(params);
            Log.i("YQNetworkErrorResolver", "accessTokenResponse=" + accessTokenResponse);
            keeper.saveAccessToken(accessTokenResponse);
        }
    }
}
