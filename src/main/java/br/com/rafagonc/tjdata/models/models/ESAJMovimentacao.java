package br.com.rafagonc.tjdata.models.models;

import br.com.rafagonc.esaj.crawler.utils.ESAJUtils;
import org.jsoup.nodes.Element;

/**
 * Created by rafagonc on 15/06/17.
 */
public class ESAJMovimentacao {

    private String text;
    private String action;
    private String date;

    public ESAJMovimentacao(Element tr) {
        this.text = ESAJUtils.getTextoWithIndex(tr, 2);
        this.date = ESAJUtils.getTextoWithIndex(tr, 0);
        this.action = ESAJUtils.getTextoWithIndex(tr, 1);

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
