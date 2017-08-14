package br.com.rafagonc.tjdata.models;

/**
 * Created by rafagonc on 13/08/17.
 */
public class ESAJPesquisaFonecticaSubscribe {

    private ESAJPush push;
    private ESAJPesquisaFonetica pesquisaFonetica;

    public ESAJPesquisaFonecticaSubscribe(ESAJPush push, ESAJPesquisaFonetica pesquisaFonetica) {
        this.push = push;
        this.pesquisaFonetica = pesquisaFonetica;
    }

    public ESAJPush getPush() {
        return push;
    }

    public void setPush(ESAJPush push) {
        this.push = push;
    }

    public ESAJPesquisaFonetica getPesquisaFonetica() {
        return pesquisaFonetica;
    }

    public void setPesquisaFonetica(ESAJPesquisaFonetica pesquisaFonetica) {
        this.pesquisaFonetica = pesquisaFonetica;
    }
}
