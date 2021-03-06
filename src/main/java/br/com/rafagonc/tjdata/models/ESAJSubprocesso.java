package br.com.rafagonc.tjdata.models;

import br.com.rafagonc.tjdata.utils.ESAJUtils;
import org.jsoup.nodes.Element;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by rafagonc on 25/06/17.
 */
@Entity
public class ESAJSubprocesso implements Comparable {

    private Long id;
    private String recebido;
    private String classe;
    private String link;
    private transient ESAJProcesso processo;

    public ESAJSubprocesso(Element tr) {
        this.recebido = ESAJUtils.normalize(tr.child(0).toString());
        this.classe = ESAJUtils.normalize(tr.child(1).toString());
        this.link = tr.child(1).attr("href");
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

    @Column(nullable = true, columnDefinition = "TEXT")
    public String getLink() {
        return link;
    }

    @ManyToOne(fetch = FetchType.EAGER)
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

    public void setLink(String link) {
        this.link = link;
    }

    public void setProcesso(ESAJProcesso processo) {
        this.processo = processo;
    }

    @Override
    public int compareTo(Object o) {
        ESAJSubprocesso subprocesso = (ESAJSubprocesso)o;
        try {
            Date movDate = ESAJUtils.BR_parseDDMMYYYYDateString(subprocesso.recebido);
            Date thisDate = ESAJUtils.BR_parseDDMMYYYYDateString(this.recebido);
            return thisDate.compareTo(movDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
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
