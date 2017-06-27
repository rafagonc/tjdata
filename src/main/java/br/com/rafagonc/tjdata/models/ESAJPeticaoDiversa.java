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

    @Column(nullable = true)
    private String date;

    @Column(nullable = true)
    private String type;

    public ESAJPeticaoDiversa(Element tr) {
        this.date = ESAJUtils.normalize(tr.child(0).toString());
        this.type = ESAJUtils.normalize(tr.child(1).toString());
    }

    public ESAJPeticaoDiversa() {
    }

    public String getDate() {
        return date;
    }

    public String getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ESAJPeticaoDiversa that = (ESAJPeticaoDiversa) o;

        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        return type != null ? type.equals(that.type) : that.type == null;

    }

    @Override
    public int hashCode() {
        int result = date != null ? date.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}
