package br.com.rafagonc.tjdata.models.models;

import java.util.List;

/**
 * Created by rafagonc on 15/06/17.
 */
public class ESAJProcesso {

    private List<ESAJMovimentacao> movimentacoes;
    private ESAJDadosProcesso dadosProcessos;
    private List<ESAJPartesProcesso> partesProcessos;
    private List<ESAJPeticaoDiversa> peticaoDiversas;
    private List<ESAJJulgamento> julgamentos;
    private List<ESAJComposicaoJulgamento> composicaoJulgamento;
    private List<ESAJSubprocesso> subprocessos;

    public ESAJProcesso(List<ESAJMovimentacao> movimentacoes, ESAJDadosProcesso dadosProcessos, List<ESAJPartesProcesso> partesProcessos, List<ESAJPeticaoDiversa> peticaoDiversas) {
        this.movimentacoes = movimentacoes;
        this.dadosProcessos = dadosProcessos;
        this.partesProcessos = partesProcessos;
        this.peticaoDiversas = peticaoDiversas;
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

        if (movimentacoes != null ? !movimentacoes.equals(processo.movimentacoes) : processo.movimentacoes != null)
            return false;
        if (dadosProcessos != null ? !dadosProcessos.equals(processo.dadosProcessos) : processo.dadosProcessos != null)
            return false;
        if (partesProcessos != null ? !partesProcessos.equals(processo.partesProcessos) : processo.partesProcessos != null)
            return false;
        if (peticaoDiversas != null ? !peticaoDiversas.equals(processo.peticaoDiversas) : processo.peticaoDiversas != null)
            return false;
        if (julgamentos != null ? !julgamentos.equals(processo.julgamentos) : processo.julgamentos != null)
            return false;
        if (composicaoJulgamento != null ? !composicaoJulgamento.equals(processo.composicaoJulgamento) : processo.composicaoJulgamento != null)
            return false;
        return subprocessos != null ? subprocessos.equals(processo.subprocessos) : processo.subprocessos == null;

    }

    @Override
    public String toString() {
        return "ESAJProcesso{"+ this.dadosProcessos.getProcesso() +"}";
    }

    @Override
    public int hashCode() {
        int result = movimentacoes != null ? movimentacoes.hashCode() : 0;
        result = 31 * result + (dadosProcessos != null ? dadosProcessos.hashCode() : 0);
        result = 31 * result + (partesProcessos != null ? partesProcessos.hashCode() : 0);
        result = 31 * result + (peticaoDiversas != null ? peticaoDiversas.hashCode() : 0);
        result = 31 * result + (julgamentos != null ? julgamentos.hashCode() : 0);
        result = 31 * result + (composicaoJulgamento != null ? composicaoJulgamento.hashCode() : 0);
        result = 31 * result + (subprocessos != null ? subprocessos.hashCode() : 0);
        return result;
    }
}
