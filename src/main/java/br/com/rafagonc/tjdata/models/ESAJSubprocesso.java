package br.com.rafagonc.tjdata.models;

import br.com.rafagonc.tjdata.utils.ESAJUtils;
import org.jsoup.nodes.Element;

import javax.persistence.*;

/**
 * Created by rafagonc on 25/06/17.
 */
@Entity
@Table(name = "subprocesso")
public class ESAJSubprocesso {

    private Long id;
    private String recebido;
    private String classe;
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

    @Id
    @GeneratedValue( strategy= GenerationType.AUTO )
    public Long getId() {
        return id;
    }

    @Column(nullable = true, columnDefinition = "TEXT")
    public String getRecebido() {
        return recebido;
    }

    @Column(nullable = true, columnDefinition = "TEXT")
    public String getClasse() {
        return classe;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "processo_id")
    public ESAJProcesso getProcesso() {
        return processo;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRecebido(String recebido) {
        this.recebido = recebido;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public void setProcesso(ESAJProcesso processo) {
        this.processo = processo;
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
