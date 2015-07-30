package cn.yunquan.frameworkdemo.network;

/**
 * Created by Administrator on 2015-07-28.
 */
public class NoNetworkException extends ApiException {
    public NoNetworkException() {
        super(NO_NETWORK_ERROR, null);
    }
}
