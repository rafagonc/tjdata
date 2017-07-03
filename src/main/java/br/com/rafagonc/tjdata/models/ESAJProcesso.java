package br.com.rafagonc.tjdata.models;

import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import java.util.List;

/**
 * Created by rafagonc on 15/06/17.
 */
@Entity
public class ESAJProcesso {

    @Id
    @GeneratedValue( strategy= GenerationType.AUTO )
    private Long id;

    @OneToOne(cascade = {CascadeType.ALL})
    private ESAJDadosProcesso dadosProcessos;

    @OneToMany( targetEntity=ESAJMovimentacao.class, cascade = {CascadeType.ALL} )
    @BatchSize(size = 20)
    private List<ESAJMovimentacao> movimentacoes;

    @OneToMany( targetEntity=ESAJPartesProcesso.class, cascade = {CascadeType.ALL} )
    @BatchSize(size = 20)
    private List<ESAJPartesProcesso> partesProcessos;

    @OneToMany( targetEntity=ESAJPeticaoDiversa.class, cascade = {CascadeType.ALL} )
    @BatchSize(size = 20)
    private List<ESAJPeticaoDiversa> peticaoDiversas;

    @OneToMany( targetEntity=ESAJJulgamento.class, cascade = {CascadeType.ALL} )
    @BatchSize(size = 20)
    private List<ESAJJulgamento> julgamentos;

    @OneToMany( targetEntity=ESAJComposicaoJulgamento.class, cascade = {CascadeType.ALL} )
    @BatchSize(size = 20)
    private List<ESAJComposicaoJulgamento> composicaoJulgamento;

    @OneToMany( targetEntity=ESAJSubprocesso.class, cascade = {CascadeType.ALL} )
    @BatchSize(size = 20)
    private List<ESAJSubprocesso> subprocessos;

    @OneToMany( targetEntity=ESAJAcao.class, cascade = {CascadeType.ALL} )
    @BatchSize(size = 20)
    private List<ESAJAcao> acoes;

    @Column(nullable = false)
    private Boolean terminado;

    public ESAJProcesso(ESAJDadosProcesso dadosProcessos,
                        List<ESAJMovimentacao> movimentacoes,
                        List<ESAJPartesProcesso> partesProcessos,
                        List<ESAJPeticaoDiversa> peticaoDiversas,
                        List<ESAJAcao> acoes) {
        this.movimentacoes = movimentacoes;
        this.dadosProcessos = dadosProcessos;
        this.partesProcessos = partesProcessos;
        this.peticaoDiversas = peticaoDiversas;
        this.acoes = acoes;
        this.terminado = this.dadosProcessos.getProcesso().contains("Julgado") || this.dadosProcessos.getProcesso().contains("Extinto") || this.dadosProcessos.getAssunto().contains("Arquivado");
    }

    public ESAJProcesso() {
    }

    public Long getId() {
        return id;
    }

    public List<ESAJAcao> getAcoes() {
        return acoes;
    }

    public List<ESAJMovimentacao> getMovimentacoes() {
        return movimentacoes;
    }

    public ESAJDadosProcesso getDadosProcessos() {
        return dadosProcessos;
    }

    public List<ESAJPartesProcesso> getPartesProcessos() {
        return partesProcessos;
    }

    public List<ESAJPeticaoDiversa> getPeticaoDiversas() {
        return peticaoDiversas;
    }

    public List<ESAJSubprocesso> getSubprocessos() {
        return subprocessos;
    }

    public void setSubprocessos(List<ESAJSubprocesso> subprocessos) {
        this.subprocessos = subprocessos;
    }

    public List<ESAJComposicaoJulgamento> getComposicaoJulgamento() {
        return composicaoJulgamento;
    }

    public void setComposicaoJulgamento(List<ESAJComposicaoJulgamento> composicaoJulgamento) {
        this.composicaoJulgamento = composicaoJulgamento;
    }

    public List<ESAJJulgamento> getJulgamentos() {
        return julgamentos;
    }

    public void setJulgamentos(List<ESAJJulgamento> julgamentos) {
        this.julgamentos = julgamentos;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ESAJProcesso processo = (ESAJProcesso) o;

        if (id != null ? !id.equals(processo.id) : processo.id != null) return false;
        if (dadosProcessos != null ? !dadosProcessos.equals(processo.dadosProcessos) : processo.dadosProcessos != null)
            return false;
        if (movimentacoes != null ? !movimentacoes.equals(processo.movimentacoes) : processo.movimentacoes != null)
            return false;
        if (partesProcessos != null ? !partesProcessos.equals(processo.partesProcessos) : processo.partesProcessos != null)
            return false;
        if (peticaoDiversas != null ? !peticaoDiversas.equals(processo.peticaoDiversas) : processo.peticaoDiversas != null)
            return false;
        if (julgamentos != null ? !julgamentos.equals(processo.julgamentos) : processo.julgamentos != null)
            return false;
        if (composicaoJulgamento != null ? !composicaoJulgamento.equals(processo.composicaoJulgamento) : processo.composicaoJulgamento != null)
            return false;
        if (subprocessos != null ? !subprocessos.equals(processo.subprocessos) : processo.subprocessos != null)
            return false;
        return acoes != null ? acoes.equals(processo.acoes) : processo.acoes == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (dadosProcessos != null ? dadosProcessos.hashCode() : 0);
        result = 31 * result + (movimentacoes != null ? movimentacoes.hashCode() : 0);
        result = 31 * result + (partesProcessos != null ? partesProcessos.hashCode() : 0);
        result = 31 * result + (peticaoDiversas != null ? peticaoDiversas.hashCode() : 0);
        result = 31 * result + (julgamentos != null ? julgamentos.hashCode() : 0);
        result = 31 * result + (composicaoJulgamento != null ? composicaoJulgamento.hashCode() : 0);
        result = 31 * result + (subprocessos != null ? subprocessos.hashCode() : 0);
        result = 31 * result + (acoes != null ? acoes.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ESAJProcesso{"+ this.dadosProcessos.getProcesso() +
                "\n movimentações -> " + this.movimentacoes.size() +
                "\n partes -> " + this.partesProcessos.size() +
                "\n peticoes -> " + this.peticaoDiversas.size() +
                "\n acoes -> " + this.acoes.size() + "\n}";
    }
}
