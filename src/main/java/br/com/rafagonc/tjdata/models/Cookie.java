package br.com.rafagonc.tjdata.models;

import javax.persistence.*;

@Entity
public class Cookie {


    @Id
    @GeneratedValue( strategy= GenerationType.AUTO )
    private Long id;

    @Column(nullable = false)
    private String key;

    @Column(nullable = false)
    private String value;

    @Column(nullable = false)
    private String domain;

    @Column(nullable = false)
    private String path;

    @ManyToOne(fetch = FetchType.EAGER)
    private ESAJCaptcha captcha;

    public Cookie(String key, String value, String domain) {
        this.key = key;
        this.value = value;
        this.domain = domain;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public String getDomain() {
        return domain;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ESAJCaptcha getCaptcha() {
        return captcha;
    }

    public void setCaptcha(ESAJCaptcha captcha) {
        this.captcha = captcha;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }
}
