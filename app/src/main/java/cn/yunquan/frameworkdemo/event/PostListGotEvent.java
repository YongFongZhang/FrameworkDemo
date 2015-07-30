package cn.yunquan.frameworkdemo.event;


import java.util.List;

import cn.yunquan.frameworkdemo.model.Post;

/**
 * Created by Administrator on 2015-07-28.
 */
public class PostListGotEvent extends YQNetworkResponseEvent{

    private List<Post> posts;

    public PostListGotEvent(boolean isResponseSuccess, String errorMessage) {
        super(isResponseSuccess, errorMessage);
    }

    public PostListGotEvent(boolean isResponseSuccess, List<Post> posts) {
        super(isResponseSuccess);
        this.posts = posts;
    }

    public PostListGotEvent() {
    }
}
