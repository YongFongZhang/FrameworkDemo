package cn.yunquan.frameworkdemo.network;

import java.io.IOException;
import java.util.Collections;

import retrofit.client.Client;
import retrofit.client.Request;
import retrofit.client.Response;
import retrofit.mime.TypedByteArray;

/**
 * Created by Administrator on 2015-07-28.
 */
public class OauthServiceClient implements Client{
    @Override
    public Response execute(Request request) throws IOException {
        Response response = new Response(request.getUrl(),
                200,
                "nothing",
                Collections.EMPTY_LIST,
                new TypedByteArray("application/json", DATA.getBytes()) );
        return response;
    }

    public static final String DATA = "{\n" +
            "  \"clientId\": WcG7623xJtrPG7p5ZTPW1bx4UayOl3Pad9ZL3at0,\n" +
            "  \"clientSecret\":rM90fW0wBaqQmTC38WxMkm8iewVEemraN0xr9LfNGzDB5KjwE3BCNjrJBaSAYpBYqgzZTwaxFtVlCeMbMabIHDbgi9Vh4SaX1kV36D4AfX9MjOcCGMEKQfP0SxKxwzJF\n" +
            "}";

}
