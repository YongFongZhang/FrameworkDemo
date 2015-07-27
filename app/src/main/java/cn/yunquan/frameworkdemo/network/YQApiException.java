package cn.yunquan.frameworkdemo.network;

/**
 * Created by Administrator on 2015-07-27.
 */
public class YQApiException extends RuntimeException {

    public static final int RESPONSE_EXPIRED_SESSION = 401; // session过期

    public YQApiException(String message, Throwable cause) {
        super(message, cause);
    }
}
