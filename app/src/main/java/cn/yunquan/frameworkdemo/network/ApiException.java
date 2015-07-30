package cn.yunquan.frameworkdemo.network;

/**
 * Created by Administrator on 2015-07-27.
 */
public class ApiException extends RuntimeException {

    // response status code
    public static final int RESPONSE_SUCCESS = 200; // 成功
    public static final int RESPONSE_EXPIRED_SESSION = 401; // session过期
    public static final int VISIT_FORBIDDEN = 403; // 无token,禁止访问

    // response error message
    public static final String SERVER_ERROR = "服务器繁忙，请稍后重试...";
    public static final String NO_NETWORK_ERROR= "无法连接网络，请检查当前网络连接...";

    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }
}
