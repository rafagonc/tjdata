package br.com.rafagonc.tjdata.models;

import br.com.rafagonc.tjdata.utils.ESAJUtils;
import org.jsoup.nodes.Element;

import javax.persistence.*;

/**
 * Created by rafagonc on 25/06/17.
 */
@Entity
public class ESAJSubprocesso {

    @Id
    @GeneratedValue( strategy= GenerationType.AUTO )
    private Long id;

    @Column(nullable = true, columnDefinition = "TEXT")
    private String recebido;

    @Column(nullable = true, columnDefinition = "TEXT")
    private String classe;

    @ManyToOne
    private ESAJProcesso processo;

    public ESAJSubprocesso(Element tr) {
        this.recebido = ESAJUtils.normalize(tr.child(0).toString());
        this.classe = ESAJUtils.normalize(tr.child(1).toString());
    }

    public ESAJSubprocesso(String recebido, String classe) {
        this.recebido = recebido;
        this.classe = classe;
    }

    public ESAJSubprocesso() {
    }

    public Long getId() {
        return id;
    }

    public String getRecebido() {
        return recebido;
    }

    public String getClasse() {
        return classe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ESAJSubprocesso that = (ESAJSubprocesso) o;

        if (recebido != null ? !recebido.equals(that.recebido) : that.recebido != null) return false;
        return classe != null ? classe.equals(that.classe) : that.classe == null;

    }

    @Override
    public int hashCode() {
        int result = recebido != null ? recebido.hashCode() : 0;
        result = 31 * result + (classe != null ? classe.hashCode() : 0);
        return result;
    }
}
