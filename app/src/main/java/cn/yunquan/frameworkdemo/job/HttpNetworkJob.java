package cn.yunquan.frameworkdemo.job;

import com.path.android.jobqueue.Job;
import com.path.android.jobqueue.Params;

import cn.yunquan.frameworkdemo.event.YQNetworkResponseEvent;
import cn.yunquan.frameworkdemo.network.NoNetworkException;
import cn.yunquan.frameworkdemo.network.YQNetworkErrorResolver;
import cn.yunquan.frameworkdemo.utils.SystemUtils;

/**
 * Created by Administrator on 2015-07-27.
 */
public abstract class HttpNetworkJob<T extends YQNetworkResponseEvent> extends Job {

    YQNetworkErrorResolver errorResolver;

    protected HttpNetworkJob() {
        super(new Params(1000));
        errorResolver = new YQNetworkErrorResolver();
    }

    @Override
    public void onRun() throws Throwable {
        if (SystemUtils.getNetworkType() == SystemUtils.NetWorkType.none){
            throw new NoNetworkException();
        }
        onJobRun();
    }

    protected abstract void onJobRun();

    @Override
    protected boolean shouldReRunOnThrowable(Throwable throwable) {
        return errorResolver.resolve(throwable, getResponseEvent());
    }

    /**
     * 请求响应处理事件
     * @return
     */
    public abstract T getResponseEvent();
}
