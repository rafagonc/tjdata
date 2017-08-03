package br.com.rafagonc.tjdata.models;

import java.util.Set;

/**
 * Created by rafagonc on 25/07/17.
 */
public class ESAJPush {

    private String message;
    private Set<ESAJPushRecipient> pushRecipients;
    private String sound = "default";

    public ESAJPush() {
    }

    public ESAJPush(String message, Set<ESAJPushRecipient> pushRecipients, String sound) {
        this.message = message;
        this.pushRecipients = pushRecipients;
        this.sound = sound;
    }

    public ESAJPush(String message, Set<ESAJPushRecipient> pushRecipients) {
        this.message = message;
        this.pushRecipients = pushRecipients;
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

    public Set<ESAJPushRecipient> getPushRecipients() {
        return pushRecipients;
    }

    public void setPushRecipients(Set<ESAJPushRecipient> pushRecipients) {
        this.pushRecipients = pushRecipients;
    }

    public String getSound() {
        return sound;
    }

}
