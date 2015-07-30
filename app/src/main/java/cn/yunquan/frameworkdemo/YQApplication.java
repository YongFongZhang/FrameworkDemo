package cn.yunquan.frameworkdemo;

import android.app.Application;
import android.util.Log;

import com.activeandroid.ActiveAndroid;
import com.path.android.jobqueue.JobManager;
import com.path.android.jobqueue.config.Configuration;
import com.path.android.jobqueue.log.CustomLogger;

/**
 * Created by Administrator on 2015-07-27.
 */
public class YQApplication extends Application {

    private static YQApplication mInstance;
    private static JobManager jobManager;

    public static YQApplication getInstance(){
        return mInstance;
    }

    public JobManager getJobManager() {
        return jobManager;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;

        ActiveAndroid.initialize(this);
        configJobManager();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    private void configJobManager() {
        Configuration configuration = new Configuration.Builder(this)
                .customLogger(new CustomLogger() {
                    private static final String TAG = "JOBS";
                    @Override
                    public boolean isDebugEnabled() {
                        return BuildConfig.DEBUG;
                    }

                    @Override
                    public void d(String text, Object... args) {
                        Log.d(TAG, String.format(text, args));
                    }

                    @Override
                    public void e(Throwable t, String text, Object... args) {
                        Log.e(TAG, String.format(text, args), t);
                    }

                    @Override
                    public void e(String text, Object... args) {
                        Log.e(TAG, String.format(text, args));
                    }
                })
                .minConsumerCount(0) // always keep at least one consumer alive
                .maxConsumerCount(3) // up to 3 consumers at a time
                .loadFactor(3) // 3 jobs per consumer
                .consumerKeepAlive(120)// wait 2 minute
                .build();
        jobManager = new JobManager(this, configuration);
    }

}
