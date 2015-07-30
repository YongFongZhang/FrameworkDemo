package cn.yunquan.frameworkdemo.event;

/**
 * Created by Administrator on 2015-07-28.
 */
public class YQNetworkResponseEvent {
    public boolean isResponseSuccess;
    public String errorMessage;

    public YQNetworkResponseEvent(boolean isResponseSuccess, String errorMessage) {
        this.isResponseSuccess = isResponseSuccess;
        this.errorMessage = errorMessage;
    }

    public YQNetworkResponseEvent(boolean isResponseSuccess){
        this.isResponseSuccess = isResponseSuccess;
    }

    public YQNetworkResponseEvent() {
    }
}
