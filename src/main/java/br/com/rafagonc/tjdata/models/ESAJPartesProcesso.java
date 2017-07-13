package br.com.rafagonc.tjdata.models;

import br.com.rafagonc.tjdata.utils.ESAJUtils;
import org.jsoup.nodes.Element;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by rafagonc on 15/06/17.
 */
@Entity
public class ESAJPartesProcesso implements Serializable {

    @Id
    @GeneratedValue( strategy= GenerationType.AUTO )
    private Long id;

    @Column(nullable = true, columnDefinition = "TEXT")
    private String titulo;

    @Column(nullable = true, columnDefinition = "TEXT")
    private String advogados;

    @ManyToOne
    private ESAJProcesso processo;

    public ESAJPartesProcesso(Element tr) {
        this.advogados = ESAJUtils.getTextoWithIndex(tr,1);
        this.titulo = ESAJUtils.getTextoWithIndex(tr,0);
    }

    public ESAJPartesProcesso() {
    }

    public Long getId() {
        return id;
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
