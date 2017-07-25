package br.com.rafagonc.tjdata.models;

import java.util.Set;

/**
 * Created by rafagonc on 25/07/17.
 */
public class ESAJPush {

    private String message;
    private Set<ESAJRecipient> recipients;
    private String sound = "default";

    public ESAJPush() {
    }

    public ESAJPush(String message, Set<ESAJRecipient> recipients) {
        this.message = message;
        this.recipients = recipients;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public String getMessage() {
        return message;
    }

    public Set<ESAJRecipient> getRecipients() {
        return recipients;
    }

    public void setRecipients(Set<ESAJRecipient> recipients) {
        this.recipients = recipients;
    }

    public String getSound() {
        return sound;
    }


}
