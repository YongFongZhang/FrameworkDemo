package cn.yunquan.frameworkdemo.services;

import java.util.List;
import java.util.Map;

import cn.yunquan.frameworkdemo.model.Post;
import retrofit.http.DELETE;
import retrofit.http.Field;
import retrofit.http.FieldMap;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.mime.TypedString;

/**
 * Created by Administrator on 2015-07-28.
 */
public interface PostService {

    @POST("/api/simple_posts/")
    Post addPost(@FieldMap Map<String, TypedString> params);

    @GET("/api/simple_posts/")
    List<Post> getPostList();

    @DELETE("/api/simple_posts/")
    Post deletePost(@Field("id")String postId);

}
