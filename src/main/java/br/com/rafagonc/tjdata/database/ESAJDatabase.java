package br.com.rafagonc.tjdata.database;

import br.com.rafagonc.tjdata.models.*;
import br.com.rafagonc.tjdata.repositories.*;

/**
 * Created by rafagonc on 30/06/17.
 */
public class ESAJDatabase {

    private ESAJProcessoRepository processoRepository;
    private ESAJMovimentacaoRepository movimentacaoRepository;
    private ESAJPartesProcessoRepository partesProcessoRepository;
    private ESAJJulgamentoRepository julgamentoRepository;
    private ESAJDadosProcessoRepository dadosProcessoRepository;
    private ESAJComposicaoJulgamentoRepository composicaoJulgamentoRepository;
    private ESAJSubprocessoRepository subprocessoRepository;
    private ESAJPeticaoDiversaRepository peticoesDiversasRepository;

    public ESAJDatabase(ESAJProcessoRepository processoRepository, ESAJMovimentacaoRepository movimentacaoRepository, ESAJPartesProcessoRepository partesProcessoRepository, ESAJJulgamentoRepository julgamentoRepository, ESAJDadosProcessoRepository dadosProcessoRepository, ESAJComposicaoJulgamentoRepository composicaoJulgamentoRepository, ESAJSubprocessoRepository subprocessoRepository, ESAJPeticaoDiversaRepository peticoesDiversasRepository) {
        this.processoRepository = processoRepository;
        this.movimentacaoRepository = movimentacaoRepository;
        this.partesProcessoRepository = partesProcessoRepository;
        this.julgamentoRepository = julgamentoRepository;
        this.dadosProcessoRepository = dadosProcessoRepository;
        this.composicaoJulgamentoRepository = composicaoJulgamentoRepository;
        this.subprocessoRepository = subprocessoRepository;
        this.peticoesDiversasRepository = peticoesDiversasRepository;
    }

    public boolean save(ESAJProcesso processo) {
        try {
            if (processo.getDadosProcessos() != null) {
                this.dadosProcessoRepository.save(processo.getDadosProcessos());
            }

            if (processo.getPartesProcessos() != null) {
                for (ESAJPartesProcesso partesProcesso: processo.getPartesProcessos()) {
                    this.partesProcessoRepository.save(partesProcesso);
                }
            }

            if (processo.getMovimentacoes() != null) {
                for (ESAJMovimentacao movimentacao: processo.getMovimentacoes()) {
                    this.movimentacaoRepository.save(movimentacao);
                }
            }

            if (processo.getPeticaoDiversas() != null) {
                for (ESAJPeticaoDiversa peticaoDiversa: processo.getPeticaoDiversas()) {
                    this.peticoesDiversasRepository.save(peticaoDiversa);
                }
            }

            if (processo.getComposicaoJulgamento() != null) {
                for (ESAJComposicaoJulgamento composicao: processo.getComposicaoJulgamento()) {
                    this.composicaoJulgamentoRepository.save(composicao);
                }
            }

            if (processo.getJulgamentos() != null) {
                for (ESAJJulgamento julgamento : processo.getJulgamentos()) {
                    this.julgamentoRepository.save(julgamento);
                }
            }

            if (processo.getSubprocessos() != null) {
                for (ESAJSubprocesso subprocesso: processo.getSubprocessos()) {
                    this.subprocessoRepository.save(subprocesso);
                }
            }

            processoRepository.save(processo);
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public ESAJProcessoRepository getProcessoRepository() {
        return processoRepository;
    }

    public ESAJMovimentacaoRepository getMovimentacaoRepository() {
        return movimentacaoRepository;
    }

    public ESAJPartesProcessoRepository getPartesProcessoRepository() {
        return partesProcessoRepository;
    }

    public ESAJJulgamentoRepository getJulgamentoRepository() {
        return julgamentoRepository;
    }

    public ESAJDadosProcessoRepository getDadosProcessoRepository() {
        return dadosProcessoRepository;
    }

    public ESAJComposicaoJulgamentoRepository getComposicaoJulgamentoRepository() {
        return composicaoJulgamentoRepository;
    }

    public ESAJSubprocessoRepository getSubprocessoRepository() {
        return subprocessoRepository;
    }

    public ESAJPeticaoDiversaRepository getPeticoesDiversasRepository() {
        return peticoesDiversasRepository;
    }
}
