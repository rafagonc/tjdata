package br.com.rafagonc.tjdata.models.models;

import br.com.rafagonc.esaj.crawler.utils.ESAJUtils;
import org.jsoup.nodes.Element;

/**
 * Created by rafagonc on 25/06/17.
 */
public class ESAJJulgamento {

    private String data;
    private String situacao;
    private String decisao;

    public ESAJJulgamento(Element tr) {
        this.data = ESAJUtils.normalize(tr.child(0).toString());
        this.situacao = ESAJUtils.normalize(tr.child(1).toString());
        this.decisao = ESAJUtils.normalize(tr.child(2).toString());
    }

    public String getData() {
        return data;
    }

    public String getSituacao() {
        return situacao;
    }

    public String getDecisao() {
        return decisao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ESAJJulgamento that = (ESAJJulgamento) o;

        if (data != null ? !data.equals(that.data) : that.data != null) return false;
        if (situacao != null ? !situacao.equals(that.situacao) : that.situacao != null) return false;
        return decisao != null ? decisao.equals(that.decisao) : that.decisao == null;

    }

    @Override
    public int hashCode() {
        int result = data != null ? data.hashCode() : 0;
        result = 31 * result + (situacao != null ? situacao.hashCode() : 0);
        result = 31 * result + (decisao != null ? decisao.hashCode() : 0);
        return result;
    }
}
