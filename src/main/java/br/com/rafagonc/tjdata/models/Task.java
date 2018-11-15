package br.com.rafagonc.tjdata.models;

public class Task {

    private Integer result_id;
    private Integer feed_id;
    private Integer lawsuit_id;
    private String cpf;
    private String password;
    private Boolean force;

    public Task() {
    }

    public Boolean getForce() {
        return force;
    }

    public void setForce(Boolean force) {
        this.force = force;
    }

    public Integer getResultId() {
        return result_id;
    }

    public void setResultId(Integer result_id) {
        this.result_id = result_id;
    }

    public Integer getFeedId() {
        return feed_id;
    }

    public void setFeedId(Integer feed_id) {
        this.feed_id = feed_id;
    }

    public Integer getLawsuiId() {
        return lawsuit_id;
    }

    public void setLawsuit_id(Integer lawsuit_id) {
        this.lawsuit_id = lawsuit_id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
