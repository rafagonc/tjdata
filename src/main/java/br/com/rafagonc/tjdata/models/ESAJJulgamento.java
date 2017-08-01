package br.com.rafagonc.tjdata.models;

import br.com.rafagonc.tjdata.utils.ESAJUtils;
import org.jsoup.nodes.Element;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by rafagonc on 25/06/17.
 */
@Entity
public class ESAJJulgamento implements Comparable {

    private Long id;
    private String data;
    private String situacao;
    private String decisao;
    private transient ESAJProcesso processo;

    public ESAJJulgamento(Element tr) {
        this.data = ESAJUtils.normalize(tr.child(0).toString());
        this.situacao = ESAJUtils.normalize(tr.child(1).toString());
        this.decisao = ESAJUtils.normalize(tr.child(2).toString());
    }

    public ESAJJulgamento(String data, String situacao, String decisao) {
        this.data = data;
        this.situacao = situacao;
        this.decisao = decisao;
    }

    public ESAJJulgamento() {
    }

    @Id
    @GeneratedValue( strategy= GenerationType.AUTO )
    public Long getId() {
        return id;
    }

    @Column(nullable = true, columnDefinition = "TEXT")
    public String getData() {
        return data;
    }

    @Column(nullable = true, columnDefinition = "TEXT")
    public String getSituacao() {
        return situacao;
    }

    @Column(nullable = true, columnDefinition = "TEXT")
    public String getDecisao() {
        return decisao;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "processo_id")
    public ESAJProcesso getProcesso() {
        return processo;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public void setDecisao(String decisao) {
        this.decisao = decisao;
    }

    public void setProcesso(ESAJProcesso processo) {
        this.processo = processo;
    }

    @Override
    public int compareTo(Object o) {
        ESAJJulgamento julgamento = (ESAJJulgamento)o;
        try {
            Date movDate = ESAJUtils.BR_parseDDMMYYYYDateString(julgamento.data);
            Date thisDate = ESAJUtils.BR_parseDDMMYYYYDateString(this.data);
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

        ESAJJulgamento that = (ESAJJulgamento) o;

        if (data != null ? !data.equals(that.data) : that.data != null) return false;
        if (situacao != null ? !situacao.equals(that.situacao) : that.situacao != null) return false;
        return decisao != null ? decisao.equals(that.decisao) : that.decisao == null;

    }

    @Override
    public int hashCode() {
        int result = data != null ? data.hashCode() : 0;
        result = 31 * result + (situacao != null ? situacao.hashCode() : 0);
        result = 31 * result + (decisao != null ? decisao.hashCode() : 0);
        return result;
    }
}
