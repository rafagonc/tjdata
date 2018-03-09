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
    private ESAJPesquisaFoneticaProcessoRepository pesquisaFoneticaProcessoRepository;
    private ESAJPesquisaFoneticaRepository pesquisaFoneticaRepository;
    private ESAJCaptchaRepository captchaRepository;


    public ESAJDatabase(ESAJProcessoRepository processoRepository, ESAJMovimentacaoRepository movimentacaoRepository, ESAJPartesProcessoRepository partesProcessoRepository, ESAJJulgamentoRepository julgamentoRepository, ESAJDadosProcessoRepository dadosProcessoRepository, ESAJComposicaoJulgamentoRepository composicaoJulgamentoRepository, ESAJSubprocessoRepository subprocessoRepository, ESAJDocumentoRepository documentoRepository, ESAJAcaoRepository acaoRepository, ESAJPeticaoDiversaRepository peticoesDiversasRepository, ESAJPesquisaFoneticaProcessoRepository pesquisaFoneticaProcessoRepository, ESAJPesquisaFoneticaRepository pesquisaFoneticaRepository, ESAJCaptchaRepository captchaRepository) {
        this.processoRepository = processoRepository;
        this.captchaRepository = captchaRepository;
        this.movimentacaoRepository = movimentacaoRepository;
        this.partesProcessoRepository = partesProcessoRepository;
        this.julgamentoRepository = julgamentoRepository;
        this.dadosProcessoRepository = dadosProcessoRepository;
        this.composicaoJulgamentoRepository = composicaoJulgamentoRepository;
        this.subprocessoRepository = subprocessoRepository;
        this.documentoRepository = documentoRepository;
        this.acaoRepository = acaoRepository;
        this.peticoesDiversasRepository = peticoesDiversasRepository;
        this.pesquisaFoneticaProcessoRepository = pesquisaFoneticaProcessoRepository;
        this.pesquisaFoneticaRepository = pesquisaFoneticaRepository;
    }

    @Transactional
    public boolean save(ESAJProcesso processo) {
        try {
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

    public ESAJDocumentoRepository getDocumentoRepository() {
        return documentoRepository;
    }

    public ESAJAcaoRepository getAcaoRepository() {
        return acaoRepository;
    }

    public ESAJCaptchaRepository getCaptchaRepository() {
        return captchaRepository;
    }

    public ESAJPesquisaFoneticaProcessoRepository getPesquisaFoneticaProcessoRepository() {
        return pesquisaFoneticaProcessoRepository;
    }

    public ESAJPesquisaFoneticaRepository getPesquisaFoneticaRepository() {
        return pesquisaFoneticaRepository;
    }
}
