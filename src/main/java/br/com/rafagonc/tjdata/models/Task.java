package br.com.rafagonc.tjdata.models;


import javax.persistence.*;

@Entity
public class Task {

    private Long id;
    private Integer result_id;
    private Integer feed_id;
    private Integer lawsuit_id;
    private String cpf;
    private String password;
    private Boolean force;

    @Id
    @GeneratedValue( strategy= GenerationType.AUTO )
    public Long getId() {
        return id;
    }


    public Task() {
    }
    @Column(nullable = false, unique = false)

    public Boolean getForce() {
        return force;
    }

    public void setForce(Boolean force) {
        this.force = force;
    }
    @Column(nullable = false, unique = false)

    public Integer getResultId() {
        return result_id;
    }

    public void setResultId(Integer result_id) {
        this.result_id = result_id;
    }
    @Column(nullable = false, unique = false)

    public Integer getFeedId() {
        return feed_id;
    }

    public void setFeedId(Integer feed_id) {
        this.feed_id = feed_id;
    }
    @Column(nullable = false, unique = false)

    public Integer getLawsuiId() {
        return lawsuit_id;
    }

    public void setLawsuit_id(Integer lawsuit_id) {
        this.lawsuit_id = lawsuit_id;
    }
    @Column(nullable = false, unique = false)

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    @Column(nullable = false, unique = false)

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Column(nullable = false, unique = false)
    public Integer getResult_id() {
        return result_id;
    }
    @Column(nullable = false, unique = false)
    public Integer getFeed_id() {
        return feed_id;
    }
    @Column(nullable = false, unique = false)
    public Integer getLawsuit_id() {
        return lawsuit_id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setResult_id(Integer result_id) {
        this.result_id = result_id;
    }

    public void setFeed_id(Integer feed_id) {
        this.feed_id = feed_id;
    }
}
