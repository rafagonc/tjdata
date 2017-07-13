package br.com.rafagonc.tjdata.models;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by rafagonc on 15/06/17.
 */
@Entity
public class ESAJProcesso {

    @Id
    @GeneratedValue( strategy= GenerationType.AUTO )
    private Long id;

    @Column(nullable = false, unique = true)
    private String numero;

    @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private ESAJDadosProcesso dadosProcessos;

    @OneToMany( targetEntity=ESAJMovimentacao.class, cascade = {CascadeType.ALL} )
    @BatchSize(size = 20)
    @Fetch(FetchMode.SELECT)
    private Set<ESAJMovimentacao> movimentacoes;

    @OneToMany( targetEntity=ESAJPartesProcesso.class, cascade = {CascadeType.ALL} )
    @BatchSize(size = 20)
    @Fetch(FetchMode.SELECT)
    private Set<ESAJPartesProcesso> partesProcessos;

    @OneToMany( targetEntity=ESAJPeticaoDiversa.class, cascade = {CascadeType.ALL} )
    @BatchSize(size = 20)
    @Fetch(FetchMode.SELECT)
    private Set<ESAJPeticaoDiversa> peticaoDiversas;

    @OneToMany( targetEntity=ESAJJulgamento.class, cascade = {CascadeType.ALL} )
    @BatchSize(size = 20)
    @Fetch(FetchMode.SELECT)
    private Set<ESAJJulgamento> julgamentos;

    @OneToMany( targetEntity=ESAJComposicaoJulgamento.class, cascade = {CascadeType.ALL} )
    @BatchSize(size = 20)
    @Fetch(FetchMode.SELECT)
    private Set<ESAJComposicaoJulgamento> composicaoJulgamento;

    @OneToMany( targetEntity=ESAJSubprocesso.class, cascade = {CascadeType.ALL} )
    @BatchSize(size = 20)
    @Fetch(FetchMode.SELECT)
    private Set<ESAJSubprocesso> subprocessos;

    @OneToMany( targetEntity=ESAJAcao.class, cascade = {CascadeType.ALL} )
    @BatchSize(size = 20)
    @Fetch(FetchMode.SELECT)
    private Set<ESAJAcao> acoes;

    @Column(nullable = false)
    private Boolean terminado;

    public ESAJProcesso(String numero,
                        ESAJDadosProcesso dadosProcessos,
                        Set<ESAJMovimentacao> movimentacoes,
                        Set<ESAJPartesProcesso> partesProcessos,
                        Set<ESAJPeticaoDiversa> peticaoDiversas,
                        Set<ESAJAcao> acoes) {
        this.numero = numero;
        this.movimentacoes = movimentacoes;
        this.dadosProcessos = dadosProcessos;
        this.partesProcessos = partesProcessos;
        this.peticaoDiversas = peticaoDiversas;
        this.acoes = acoes;
        this.terminado = this.dadosProcessos.getNumero().contains("Julgado") || this.dadosProcessos.getNumero().contains("Extinto") || this.dadosProcessos.getAssunto().contains("Arquivado");
    }

    public ESAJProcesso() {
    }

    public Long getId() {
        return id;
    }

    public Set<ESAJAcao> getAcoes() {
        return acoes;
    }

    public Set<ESAJMovimentacao> getMovimentacoes() {
        return movimentacoes;
    }

    public ESAJDadosProcesso getDadosProcessos() {
        return dadosProcessos;
    }

    public Set<ESAJPartesProcesso> getPartesProcessos() {
        return partesProcessos;
    }

    public Set<ESAJPeticaoDiversa> getPeticaoDiversas() {
        return peticaoDiversas;
    }

    public Set<ESAJSubprocesso> getSubprocessos() {
        return subprocessos;
    }

    public void setSubprocessos(Set<ESAJSubprocesso> subprocessos) {
        this.subprocessos = subprocessos;
    }

    public Set<ESAJComposicaoJulgamento> getComposicaoJulgamento() {
        return composicaoJulgamento;
    }

    public void setComposicaoJulgamento(Set<ESAJComposicaoJulgamento> composicaoJulgamento) {
        this.composicaoJulgamento = composicaoJulgamento;
    }

    public Set<ESAJJulgamento> getJulgamentos() {
        return julgamentos;
    }

    public void setJulgamentos(Set<ESAJJulgamento> julgamentos) {
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
        return "ESAJProcesso{"+ this.numero +
                "\n movimentações -> " + this.movimentacoes.size() +
                "\n partes -> " + this.partesProcessos.size() +
                "\n peticoes -> " + this.peticaoDiversas.size() +
                "\n acoes -> " + this.acoes.size() + "\n}";
    }
}
