package br.com.rafagonc.tjdata.models;

import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by rafagonc on 15/06/17.
 */
@Entity
public class ESAJProcesso {

    private Long id;
    private String numero;
    private ESAJDadosProcesso dadosProcessos;
    private Set<ESAJMovimentacao> movimentacoes;
    private Set<ESAJPartesProcesso> partesProcessos;
    private Set<ESAJPeticaoDiversa> peticaoDiversas;
    private Set<ESAJJulgamento> julgamentos;
    private Set<ESAJComposicaoJulgamento> composicaoJulgamento;
    private Set<ESAJSubprocesso> subprocessos;
    private Set<ESAJAcao> acoes;
    private Boolean terminado;
    private Boolean processando;
    private Boolean encontrado;

    public ESAJProcesso(String numero,
                        ESAJDadosProcesso dadosProcessos,
                        Set<ESAJMovimentacao> movimentacoes,
                        Set<ESAJPartesProcesso> partesProcessos,
                        Set<ESAJPeticaoDiversa> peticaoDiversas,
                        Set<ESAJAcao> acoes) {
        this.numero = numero;
        this.processando = false;
        this.encontrado = true;
        this.movimentacoes = movimentacoes;
        this.dadosProcessos = dadosProcessos;
        this.partesProcessos = partesProcessos;
        this.peticaoDiversas = peticaoDiversas;
        this.acoes = acoes;
        this.terminado = this.dadosProcessos.getNumero().contains("Julgado") || this.dadosProcessos.getNumero().contains("Extinto") || this.dadosProcessos.getNumero().contains("Arquivado");
    }

    public ESAJProcesso() {
        this.terminado = true;
        this.encontrado = false;
        this.processando = true;
    }

    @Id
    @GeneratedValue( strategy= GenerationType.AUTO )
    public Long getId() {
        return id;
    }

    @Column(nullable = false, unique = true)
    public String getNumero() {
        return numero;
    }

    @Column(nullable = false)
    public Boolean getTerminado() {
        return terminado;
    }

    @Column(nullable = false)
    public Boolean getProcessando() {
        return processando;
    }

    @Column(nullable = false)
    public Boolean getEncontrado() {
        return encontrado;
    }

    @OneToMany( targetEntity=ESAJAcao.class, orphanRemoval = true, cascade = {CascadeType.ALL}, mappedBy = "processo")
    @BatchSize(size = 5)
    public Set<ESAJAcao> getAcoes() {
        return acoes;
    }

    @OneToMany( targetEntity=ESAJMovimentacao.class, orphanRemoval = true, cascade = {CascadeType.ALL}, mappedBy = "processo")
    @BatchSize(size = 5)
    public Set<ESAJMovimentacao> getMovimentacoes() {
        return movimentacoes;
    }

    @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER, mappedBy = "processo")
    @BatchSize(size = 5)
    public ESAJDadosProcesso getDadosProcessos() {
        return dadosProcessos;
    }

    @OneToMany( targetEntity=ESAJPartesProcesso.class, orphanRemoval = true, cascade = {CascadeType.ALL}, mappedBy = "processo")
    @BatchSize(size = 5)
    public Set<ESAJPartesProcesso> getPartesProcessos() {
        return partesProcessos;
    }

    @OneToMany( targetEntity=ESAJPeticaoDiversa.class, orphanRemoval = true, cascade = {CascadeType.ALL}, mappedBy = "processo")
    @BatchSize(size = 5)
    public Set<ESAJPeticaoDiversa> getPeticaoDiversas() {
        return peticaoDiversas;
    }

    @OneToMany( targetEntity=ESAJSubprocesso.class, orphanRemoval = true, cascade = {CascadeType.ALL}, mappedBy = "processo")
    @BatchSize(size = 5)
    public Set<ESAJSubprocesso> getSubprocessos() {
        return subprocessos;
    }

    @OneToMany( targetEntity=ESAJJulgamento.class, orphanRemoval = true, cascade = {CascadeType.ALL}, mappedBy = "processo")
    @BatchSize(size = 5)
    public Set<ESAJJulgamento> getJulgamentos() {
        return julgamentos;
    }

    @OneToMany( targetEntity=ESAJComposicaoJulgamento.class, orphanRemoval = true, cascade = {CascadeType.ALL}, mappedBy = "processo")
    @BatchSize(size = 5)
    public Set<ESAJComposicaoJulgamento> getComposicaoJulgamento() {
        return composicaoJulgamento;
    }

    public void setProcessando(Boolean processando) {
        this.processando = processando;
    }

    public void setEncontrado(Boolean encontrado) {
        this.encontrado = encontrado;
    }

    public void setSubprocessos(Set<ESAJSubprocesso> subprocessos) {
//        if (subprocessos != null) {
//            for (ESAJSubprocesso c: subprocessos) {
//                c.setProcesso(this);
//            }
//        }
        this.subprocessos = subprocessos;
    }

    public void setComposicaoJulgamento(Set<ESAJComposicaoJulgamento> composicaoJulgamento) {
//        if (composicaoJulgamento != null) {
//            for (ESAJComposicaoJulgamento c: composicaoJulgamento) {
//                c.setProcesso(this);
//            }
//        }
        this.composicaoJulgamento = composicaoJulgamento;
    }

    public void setJulgamentos(Set<ESAJJulgamento> julgamentos) {
//        if (julgamentos != null) {
//            for (ESAJJulgamento c: julgamentos) {
//            c.setProcesso(this);
//        }}
        this.julgamentos = julgamentos;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDadosProcessos(ESAJDadosProcesso dadosProcessos) {
//        if (this.dadosProcessos != null) {
//            this.dadosProcessos.setProcesso(this);
//        }
        this.dadosProcessos = dadosProcessos;
    }

    public void setMovimentacoes(Set<ESAJMovimentacao> movimentacoes) {
//        if (movimentacoes != null) {
//            for (ESAJMovimentacao c: movimentacoes) {
//            c.setProcesso(this);
//        }}
        this.movimentacoes = movimentacoes;
    }

    public void setPartesProcessos(Set<ESAJPartesProcesso> partesProcessos) {
//        if (partesProcessos != null) {
//            for (ESAJPartesProcesso c: partesProcessos) {
//            c.setProcesso(this);
//        }}
        this.partesProcessos = partesProcessos;
    }

    public void setPeticaoDiversas(Set<ESAJPeticaoDiversa> peticaoDiversas) {
//        if (peticaoDiversas != null) {
//            for (ESAJPeticaoDiversa c: peticaoDiversas) {
//            c.setProcesso(this);
//        }}
        this.peticaoDiversas = peticaoDiversas;
    }

    public void setAcoes(Set<ESAJAcao> acoes) {
//        if (acoes != null) {
//            for (ESAJAcao c: acoes) {
//            c.setProcesso(this);
//        }}
        this.acoes = acoes;
    }

    public void setTerminado(Boolean terminado) {
        this.terminado = terminado;
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
