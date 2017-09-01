package br.com.rafagonc.tjdata.models;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by rafagonc on 13/08/17.
 */
@Entity
public class ESAJPesquisaFoneticaProcesso {

    private Long id;
    private Date dataProcesso;
    private String numero;
    private Integer foro;
    private String nomeParte;
    private String atribuicao;
    private String vara;
    private transient ESAJPesquisaFonetica pesquisaFonetica;

    public ESAJPesquisaFoneticaProcesso(String numero, String nomeParte, String atribuicao, String vara, Date dataProcesso, Integer foro, ESAJPesquisaFonetica pesquisaFonetica) {
        this.foro = foro;
        this.numero = numero;
        this.nomeParte = nomeParte;
        this.vara = vara;
        this.atribuicao = atribuicao;
        this.dataProcesso = dataProcesso;
        this.pesquisaFonetica = pesquisaFonetica;
    }

    public ESAJPesquisaFoneticaProcesso() {
        this.foro = -1;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    @Column(nullable = true)
    public Date getDataProcesso() {
        return dataProcesso;
    }

    @Column(nullable = false)
    public String getNumero() {
        return numero;
    }

    @Column(nullable = false)
    public Integer getForo() {
        return foro;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pesquisa_fonetica_id")
    public ESAJPesquisaFonetica getPesquisaFonetica() {
        return pesquisaFonetica;
    }

    @Column(nullable = false)
    public String getNomeParte() {
        return nomeParte;
    }

    @Column(nullable = true)
    public String getAtribuicao() {
        return atribuicao;
    }

    @Column(nullable = true)
    public String getVara() {
        return vara;
    }

    public void setForo(Integer foro) {
        this.foro = foro;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDataProcesso(Date dataProcesso) {
        this.dataProcesso = dataProcesso;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setPesquisaFonetica(ESAJPesquisaFonetica pesquisaFonetica) {
        this.pesquisaFonetica = pesquisaFonetica;
    }

    public void setNomeParte(String nomeParte) {
        this.nomeParte = nomeParte;
    }

    public void setAtribuicao(String atribuicao) {
        this.atribuicao = atribuicao;
    }

    public void setVara(String vara) {
        this.vara = vara;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ESAJPesquisaFoneticaProcesso that = (ESAJPesquisaFoneticaProcesso) o;

        if (dataProcesso != null ? !dataProcesso.equals(that.dataProcesso) : that.dataProcesso != null) return false;
        if (numero != null ? !numero.equals(that.numero) : that.numero != null) return false;
        if (foro != null ? !foro.equals(that.foro) : that.foro != null) return false;
        if (nomeParte != null ? !nomeParte.equals(that.nomeParte) : that.nomeParte != null) return false;
        if (atribuicao != null ? !atribuicao.equals(that.atribuicao) : that.atribuicao != null) return false;
        return vara != null ? vara.equals(that.vara) : that.vara == null;

    }

    @Override
    public int hashCode() {
        int result = dataProcesso != null ? dataProcesso.hashCode() : 0;
        result = 31 * result + (numero != null ? numero.hashCode() : 0);
        result = 31 * result + (foro != null ? foro.hashCode() : 0);
        result = 31 * result + (nomeParte != null ? nomeParte.hashCode() : 0);
        result = 31 * result + (atribuicao != null ? atribuicao.hashCode() : 0);
        result = 31 * result + (vara != null ? vara.hashCode() : 0);
        return result;
    }
}
