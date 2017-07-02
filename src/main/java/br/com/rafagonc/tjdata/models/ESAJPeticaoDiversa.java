package br.com.rafagonc.tjdata.models;

import br.com.rafagonc.tjdata.utils.ESAJUtils;
import org.jsoup.nodes.Element;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by rafagonc on 15/06/17.
 */
@Entity
public class ESAJPeticaoDiversa implements Serializable {

    @Id
    @GeneratedValue( strategy= GenerationType.AUTO )
    private Long id;

    @Column(nullable = true, columnDefinition = "TEXT")
    private String data;

    @Column(nullable = true, columnDefinition = "TEXT")
    private String tipo;

    public ESAJPeticaoDiversa(Element tr) {
        this.data = ESAJUtils.normalize(tr.child(0).toString());
        this.tipo = ESAJUtils.normalize(tr.child(1).toString());
    }

    public ESAJPeticaoDiversa() {
    }

    public Long getId() {
        return id;
    }

    public String getData() {
        return data;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ESAJPeticaoDiversa that = (ESAJPeticaoDiversa) o;

        if (data != null ? !data.equals(that.data) : that.data != null) return false;
        return tipo != null ? tipo.equals(that.tipo) : that.tipo == null;

    }

    @Override
    public int hashCode() {
        int result = data != null ? data.hashCode() : 0;
        result = 31 * result + (tipo != null ? tipo.hashCode() : 0);
        return result;
    }
}
