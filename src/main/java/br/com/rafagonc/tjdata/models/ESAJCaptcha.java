package br.com.rafagonc.tjdata.models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ESAJCaptcha {

    @Id
    @GeneratedValue( strategy= GenerationType.AUTO )
    private Long id;

    @OneToMany(mappedBy = "captcha", cascade = CascadeType.ALL)
    private Set<Cookie> cookies;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false, length = 2000)
    private String uuidCaptcha;

    @Column(nullable = true, length = 2000)
    private String jSessionID;

    @Column(nullable = false, length = 2000)
    private String gResponse;

    public ESAJCaptcha() {
    }

    public ESAJCaptcha(String state, Set<Cookie> cookies, String uuidCaptcha, String gResponse) {
        this.cookies = cookies;
        this.uuidCaptcha = uuidCaptcha;
        this.gResponse = gResponse;
        this.state = state;
    }

    public Set<Cookie> getCookies() {
        return cookies;
    }

    public String getUuidCaptcha() {
        return uuidCaptcha;
    }

    public String getgResponse() {
        return gResponse;
    }

    public void setCookies(Set<Cookie> cookies) {
        this.cookies = cookies;
    }

    public void setUuidCaptcha(String uuidCaptcha) {
        this.uuidCaptcha = uuidCaptcha;
    }

    public void setgResponse(String gResponse) {
        this.gResponse = gResponse;
    }

    public String getjSessionID() {
        return jSessionID;
    }

    public void setjSessionID(String jSessionID) {
        this.jSessionID = jSessionID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
