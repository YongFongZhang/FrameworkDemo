package cn.yunquan.frameworkdemo.job.posts;

import java.util.Map;

import cn.yunquan.frameworkdemo.event.PostAddedEvent;
import cn.yunquan.frameworkdemo.event.YQNetworkResponseEvent;
import cn.yunquan.frameworkdemo.job.HttpNetworkJob;
import cn.yunquan.frameworkdemo.model.Post;
import cn.yunquan.frameworkdemo.network.Api;
import de.greenrobot.event.EventBus;
import retrofit.mime.TypedString;

/**
 * Created by Administrator on 2015-07-28.
 */
public class AddPostJob extends HttpNetworkJob {

    private Post post;

    protected AddPostJob(Post post) {
        this.post = post;
    }

    @Override
    public YQNetworkResponseEvent getResponseEvent() {
        return new PostAddedEvent();
    }

    @Override
    public void onAdded() {

    }

    @Override
    protected void onJobRun() {
        Map<String, TypedString> params = post.toHashMap();
        post = Api.getPostService().addPost(params);
        post.save();
        EventBus.getDefault().post(new PostAddedEvent(true, post));
    }

    @Override
    protected void onCancel() {

    }
}
