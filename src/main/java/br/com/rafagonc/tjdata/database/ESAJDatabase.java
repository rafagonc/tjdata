package br.com.rafagonc.tjdata.database;

import br.com.rafagonc.tjdata.models.ESAJProcesso;
import br.com.rafagonc.tjdata.repositories.*;
import org.springframework.transaction.annotation.Transactional;

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
    private ESAJDocumentoRepository documentoRepository;
    private ESAJAcaoRepository acaoRepository;
    private ESAJPeticaoDiversaRepository peticoesDiversasRepository;

    public ESAJDatabase(ESAJProcessoRepository processoRepository,
                        ESAJMovimentacaoRepository movimentacaoRepository,
                        ESAJPartesProcessoRepository partesProcessoRepository,
                        ESAJJulgamentoRepository julgamentoRepository,
                        ESAJDadosProcessoRepository dadosProcessoRepository,
                        ESAJComposicaoJulgamentoRepository composicaoJulgamentoRepository,
                        ESAJSubprocessoRepository subprocessoRepository,
                        ESAJPeticaoDiversaRepository peticoesDiversasRepository,
                        ESAJAcaoRepository acaoRepository,
                        ESAJDocumentoRepository documentoRepository) {
        this.processoRepository = processoRepository;
        this.movimentacaoRepository = movimentacaoRepository;
        this.partesProcessoRepository = partesProcessoRepository;
        this.julgamentoRepository = julgamentoRepository;
        this.dadosProcessoRepository = dadosProcessoRepository;
        this.composicaoJulgamentoRepository = composicaoJulgamentoRepository;
        this.subprocessoRepository = subprocessoRepository;
        this.peticoesDiversasRepository = peticoesDiversasRepository;
        this.documentoRepository = documentoRepository;
        this.acaoRepository = acaoRepository;
    }

    @Transactional
    public boolean save(ESAJProcesso processo) {
        try {
            processoRepository.save(processo);
//            if (processo.getDadosProcessos() != null) this.dadosProcessoRepository.save(processo.getDadosProcessos());
//            if (processo.getPartesProcessos() != null) this.partesProcessoRepository.save(processo.getPartesProcessos());
//            if (processo.getMovimentacoes() != null) {
//                for (ESAJMovimentacao movimentacoes : processo.getMovimentacoes()) {
//                    this.documentoRepository.save(movimentacoes.getDocumentos());
//                }
//                this.movimentacaoRepository.save(processo.getMovimentacoes());
//            }
//            if (processo.getPeticaoDiversas() != null) this.peticoesDiversasRepository.save(processo.getPeticaoDiversas());
//            if (processo.getComposicaoJulgamento() != null) this.composicaoJulgamentoRepository.save(processo.getComposicaoJulgamento());
//            if (processo.getJulgamentos() != null) this.julgamentoRepository.save(processo.getJulgamentos());
//            if (processo.getSubprocessos() != null) this.subprocessoRepository.save(processo.getSubprocessos());
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

    public ESAJDocumentoRepository getDocumentoRepository() {
        return documentoRepository;
    }

    public ESAJAcaoRepository getAcaoRepository() {
        return acaoRepository;
    }
}
