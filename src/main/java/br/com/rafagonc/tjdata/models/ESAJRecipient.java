package br.com.rafagonc.tjdata.models;

/**
 * Created by rafagonc on 25/07/17.
 */
public class ESAJRecipient {

    public String token;
    public String platform;

    public ESAJRecipient(String token, String platform) {
        this.token = token;
        this.platform = platform;
    }

    public ESAJRecipient(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }
}
