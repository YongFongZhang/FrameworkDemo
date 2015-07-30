package cn.yunquan.frameworkdemo.services;

import java.util.List;

import cn.yunquan.frameworkdemo.model.Circle;
import retrofit.http.GET;

/**
 * Created by Administrator on 2015-07-27.
 */
public interface CircleService {

    @GET("/api/circles")
    List<Circle> getCiecleList();

}
