package br.com.rafagonc.tjdata.models.models;

import br.com.rafagonc.esaj.crawler.utils.ESAJUtils;
import org.jsoup.nodes.Element;

import java.io.Serializable;

/**
 * Created by rafagonc on 15/06/17.
 */
public class ESAJPartesProcesso implements Serializable {

    private String titulo;
    private String advogados;

    public ESAJPartesProcesso(Element tr) {
        this.advogados = ESAJUtils.getTextoWithIndex(tr,1);
        this.titulo = ESAJUtils.getTextoWithIndex(tr,0);
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAdvogados() {
        return advogados;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ESAJPartesProcesso that = (ESAJPartesProcesso) o;

        if (titulo != null ? !titulo.equals(that.titulo) : that.titulo != null) return false;
        if (advogados != null ? !advogados.equals(that.advogados) : that.advogados != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = titulo != null ? titulo.hashCode() : 0;
        result = 31 * result + (advogados != null ? advogados.hashCode() : 0);
        return result;
    }
}
