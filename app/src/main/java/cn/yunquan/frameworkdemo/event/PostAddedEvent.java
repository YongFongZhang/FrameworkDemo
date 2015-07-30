package cn.yunquan.frameworkdemo.event;

import cn.yunquan.frameworkdemo.model.Post;

/**
 * Created by Administrator on 2015-07-28.
 */
public class PostAddedEvent extends YQNetworkResponseEvent {


    private Post post;

    public PostAddedEvent(boolean isResponseSuccess, Post post) {
        super(isResponseSuccess, null);
        this.post = post;
    }

    public PostAddedEvent(boolean isResponseSuccess, String errorMessage) {
        super(isResponseSuccess, errorMessage);
    }

    public PostAddedEvent() {
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Post getPost() {
        return post;
    }
}
