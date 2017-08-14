package br.com.rafagonc.tjdata.models;

import org.jsoup.nodes.Element;

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
    private ESAJPesquisaFonetica pesquisaFonetica;

    public ESAJPesquisaFoneticaProcesso(Element td, Integer foro, ESAJPesquisaFonetica pesquisaFonetica) {
        this.foro = foro;
        this.pesquisaFonetica = pesquisaFonetica;
    }

    public ESAJPesquisaFoneticaProcesso() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    @Column(nullable = false)
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
}
