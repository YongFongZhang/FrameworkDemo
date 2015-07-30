package cn.yunquan.frameworkdemo.job.posts;

import java.util.List;

import cn.yunquan.frameworkdemo.event.PostListGotEvent;
import cn.yunquan.frameworkdemo.event.YQNetworkResponseEvent;
import cn.yunquan.frameworkdemo.job.HttpNetworkJob;
import cn.yunquan.frameworkdemo.model.Post;
import cn.yunquan.frameworkdemo.network.Api;

/**
 * Created by Administrator on 2015-07-28.
 */
public class GetPostListJob extends HttpNetworkJob {
    @Override
    public YQNetworkResponseEvent getResponseEvent() {
        return new PostListGotEvent();
    }

    @Override
    public void onAdded() {

    }

    @Override
    protected void onJobRun() {
        List<Post> posts = Api.getPostService().getPostList();
        if (posts != null) {
            for (Post post : posts) {
                if (post.isIs_removed() == true) {
                    post.delete();
                } else {
                    post.save();
                }
            }
        }
    }

    @Override
    protected void onCancel() {

    }
}
