package br.com.rafagonc.tjdata.models;

import br.com.rafagonc.tjdata.utils.ESAJUtils;
import org.jsoup.nodes.Element;

import javax.persistence.*;

/**
 * Created by rafagonc on 25/06/17.
 */
@Entity
public class ESAJComposicaoJulgamento {

    @Id
    @GeneratedValue( strategy= GenerationType.AUTO )
    private Long id;

    @Column(nullable = true)
    private String participacao;

    @Column(nullable = true)
    private String magistrado;

    public ESAJComposicaoJulgamento(Element tr) {
        this.participacao = ESAJUtils.normalize(tr.child(0).toString().replace("&nbsp;"," "));
        this.magistrado = ESAJUtils.normalize(tr.child(1).toString().replace("&nbsp;"," "));
    }

    public ESAJComposicaoJulgamento() {
    }

    public String getParticipacao() {
        return participacao;
    }

    public String getMagistrado() {
        return magistrado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ESAJComposicaoJulgamento that = (ESAJComposicaoJulgamento) o;

        if (participacao != null ? !participacao.equals(that.participacao) : that.participacao != null) return false;
        return magistrado != null ? magistrado.equals(that.magistrado) : that.magistrado == null;

    }

    @Override
    public int hashCode() {
        int result = participacao != null ? participacao.hashCode() : 0;
        result = 31 * result + (magistrado != null ? magistrado.hashCode() : 0);
        return result;
    }

}
