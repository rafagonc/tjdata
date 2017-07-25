package br.com.rafagonc.tjdata.models;

import java.util.Set;

/**
 * Created by rafagonc on 25/07/17.
 */
public class ESAJPush {

    private String message;
    private Set<String> recipients;
    private String sound = "default";

    public ESAJPush(String message, Set<String> recipients, String sound) {
        this.message = message;
        this.recipients = recipients;
        this.sound = sound;
    }

    public ESAJPush(String message, Set<String> recipients) {
        this.message = message;
        this.recipients = recipients;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setRecipients(Set<String> recipients) {
        this.recipients = recipients;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public String getMessage() {
        return message;
    }

    public Set<String> getRecipients() {
        return recipients;
    }

    public String getSound() {
        return sound;
    }
}
