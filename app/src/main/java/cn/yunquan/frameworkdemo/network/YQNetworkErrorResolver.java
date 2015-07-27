package cn.yunquan.frameworkdemo.network;

import retrofit.RetrofitError;

/**
 * Created by Administrator on 2015-07-27.
 */
public class YQNetworkErrorResolver {

    /**
     * 异常处理
     * @param error
     * @return
     */
    public boolean resolve(RetrofitError error){
        if (YQApiException.RESPONSE_EXPIRED_SESSION == error.getResponse().getStatus()){
            return handleSessionExpiredError();
        } else if (RetrofitError.Kind.NETWORK == error.getKind()){
            handleNetworkError(error);
        } else if (RetrofitError.Kind.CONVERSION == error.getKind()){
            handleConversionError(error);
        } else if (RetrofitError.Kind.HTTP == error.getKind()){
            handleHttpError(error);
        } else {
            handleUnexpectedError(error);
        }
        return false;
    }

    /**
     * Session过期处理
     */
    private boolean handleSessionExpiredError() {
        // TODO 重新授权
        return true;
    }

    private void handleNetworkError(RetrofitError error) {

    }
}
