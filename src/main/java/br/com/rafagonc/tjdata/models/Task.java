package br.com.rafagonc.tjdata.models;


import javax.persistence.*;

@Entity
public class Task {

    private Long id;
    private Integer result;
    private Integer feed;
    private Integer lawsuit;
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

    public void setId(Long id) {
        this.id = id;
    }
    @Column(nullable = false, unique = false)

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }
    @Column(nullable = false, unique = false)

    public Integer getFeed() {
        return feed;
    }

    public void setFeed(Integer feed) {
        this.feed = feed;
    }
    @Column(nullable = false, unique = false)

    public Integer getLawsuit() {
        return lawsuit;
    }

    public void setLawsuit(Integer lawsuit) {
        this.lawsuit = lawsuit;
    }
}
