package br.com.rafagonc.tjdata.models;

import br.com.rafagonc.tjdata.utils.ESAJUtils;
import org.jsoup.nodes.Element;

import javax.persistence.*;

/**
 * Created by rafagonc on 15/06/17.
 */
@Entity
public class ESAJMovimentacao {

    @Id
    @GeneratedValue( strategy= GenerationType.AUTO )
    private Long id;

    @Column(nullable = true, columnDefinition = "TEXT")
    private String text;

    @Column(nullable = true, columnDefinition = "TEXT")
    private String action;

    @Column(nullable = true, columnDefinition = "TEXT")
    private String date;

    @ManyToOne
    private ESAJProcesso processo;

    public ESAJMovimentacao(Element tr) {
        this.text = ESAJUtils.getTextoWithIndex(tr, 2);
        this.date = ESAJUtils.getTextoWithIndex(tr, 0);
        this.action = ESAJUtils.getTextoWithIndex(tr, 1);
    }

    public ESAJMovimentacao() {
    }

    public String getText() {
        return text;
    }

    public String getAction() {
        return action;
    }

    public String getDate() {
        return date;
    }

    public ESAJProcesso getProcesso() {
        return processo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ESAJMovimentacao that = (ESAJMovimentacao) o;

        if (text != null ? !text.equals(that.text) : that.text != null) return false;
        if (action != null ? !action.equals(that.action) : that.action != null) return false;
        return date != null ? date.equals(that.date) : that.date == null;

    }

    @Override
    public int hashCode() {
        int result = text != null ? text.hashCode() : 0;
        result = 31 * result + (action != null ? action.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}
