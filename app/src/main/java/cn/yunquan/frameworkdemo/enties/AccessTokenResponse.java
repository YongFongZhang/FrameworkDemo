package cn.yunquan.frameworkdemo.enties;

import java.io.Serializable;

/**
 * Created by Administrator on 2015-07-28.
 */
public class AccessTokenResponse implements Serializable {

    /**
     * scope : read write admin user
     * expires_in : 36000
     * token_type : Bearer
     * refresh_token : idxVedK2y6Dc2oBogn4a0bKsDuPDsQ
     * access_token : 1nKQ0CfAiZsnItQjCVFovjUBUFWdSG
     */
    private String scope;
    private int expires_in;
    private String token_type;
    private String refresh_token;
    private String access_token;

    public void setScope(String scope) {
        this.scope = scope;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getScope() {
        return scope;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public String getToken_type() {
        return token_type;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public String getAccess_token() {
        return access_token;
    }

    @Override
    public String toString() {
        return "AccessTokenResponse{" +
                "scope='" + scope + '\'' +
                ", expires_in=" + expires_in +
                ", token_type='" + token_type + '\'' +
                ", refresh_token='" + refresh_token + '\'' +
                ", access_token='" + access_token + '\'' +
                '}';
    }
}
