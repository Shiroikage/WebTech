package maja.webtech.entities;

import maja.webtech.ApiToken;

public class User {
    private String clientId;
    private String clientSecret;
    private String country;
    private String userId;
    private ApiToken token;

    public User(String clientId, String clientSecret) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.token = new ApiToken(clientId, clientSecret);
        //add api calls for other information in constructor
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
