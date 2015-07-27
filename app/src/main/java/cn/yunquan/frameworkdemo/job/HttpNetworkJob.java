package cn.yunquan.frameworkdemo.job;

import com.path.android.jobqueue.Job;
import com.path.android.jobqueue.Params;

import cn.yunquan.frameworkdemo.network.YQNetworkErrorResolver;
import retrofit.RetrofitError;

/**
 * Created by Administrator on 2015-07-27.
 */
public class HttpNetworkJob extends Job {

    YQNetworkErrorResolver errorResolver;

    protected HttpNetworkJob(Params params) {
        super(params);
        errorResolver = new YQNetworkErrorResolver();
    }

    @Override
    public void onAdded() {

    }

    @Override
    public void onRun() throws Throwable {

    }

    @Override
    protected void onCancel() {

    }

    @Override
    protected boolean shouldReRunOnThrowable(Throwable throwable) {
        if (throwable instanceof RetrofitError){
            RetrofitError e = (RetrofitError)throwable;
            return errorResolver.resolve(e);
        }
        return false;
    }
}
