package br.com.rafagonc.tjdata.models;

import java.util.Set;

/**
 * Created by rafagonc on 24/07/17.
 */
public class ESAJProcessoSubscribe {

    private ESAJProcesso processo;
    private ESAJPush push;

    public ESAJProcessoSubscribe(ESAJProcesso processo) {
        this.processo = processo;
    }

    public ESAJProcessoSubscribe(ESAJProcesso processo, ESAJPush push) {
        this.processo = processo;
        this.push = push;
    }

    public ESAJProcessoSubscribe(ESAJProcesso processo, Set<String> recipients) {
        this.processo = processo;
        this.push = new ESAJPush("", recipients);
    }

    public ESAJProcesso getProcesso() {
        return processo;
    }

    public void setPush(ESAJPush push) {
        this.push = push;
    }

    public ESAJPush getPush() {
        return push;
    }
}
