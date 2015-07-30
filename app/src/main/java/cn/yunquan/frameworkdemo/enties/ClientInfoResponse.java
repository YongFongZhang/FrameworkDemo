package cn.yunquan.frameworkdemo.enties;

/**
 * Created by Administrator on 2015-07-28.
 */
public class ClientInfoResponse{

    /**
     * clientSecret :
     * clientId :
     */
    private String clientSecret;
    private String clientId;

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public String getClientId() {
        return clientId;
    }


    @Override
    public String toString() {
        return "ClientInfoResponse{" +
                "clientSecret='" + clientSecret + '\'' +
                ", clientId='" + clientId + '\'' +
                '}';
    }
}
