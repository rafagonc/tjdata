package br.com.rafagonc.tjdata.models;

public class Task {

    private Integer result_id;
    private Integer old_mov_len;
    private Integer old_partes_len;
    private Boolean is_new;
    private Integer lawsuit_id;

    public Task() {
    }

    public Integer getResult_id() {
        return result_id;
    }

    public void setResult_id(Integer result_id) {
        this.result_id = result_id;
    }

    public Integer getOld_mov_len() {
        return old_mov_len;
    }

    public void setOld_mov_len(Integer old_mov_len) {
        this.old_mov_len = old_mov_len;
    }

    public Integer getOld_partes_len() {
        return old_partes_len;
    }

    public void setOld_partes_len(Integer old_partes_len) {
        this.old_partes_len = old_partes_len;
    }

    public Boolean getIs_new() {
        return is_new;
    }

    public void setIs_new(Boolean is_new) {
        this.is_new = is_new;
    }

    public Integer getLawsuit_id() {
        return lawsuit_id;
    }

    public void setLawsuit_id(Integer lawsuit_id) {
        this.lawsuit_id = lawsuit_id;
    }
}
