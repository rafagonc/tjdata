package br.com.rafagonc.tjdata.database;

import br.com.rafagonc.tjdata.repositories.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by rafagonc on 27/06/17.
 */
public class ESAJDatabaseManager {

    private static ESAJDatabaseManager shared;

    private final EntityManager entityManager;

    public ESAJDatabaseManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public static ESAJDatabaseManager start() {
        return ESAJDatabaseManager.start(null);
    }

    public static ESAJDatabaseManager start(ESAJDatabaseWorker worker) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tj");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        ESAJDatabaseManager tjdata = new ESAJDatabaseManager(entityManager);
        Session session = entityManager.unwrap(Session.class);
        Transaction transaction = session.beginTransaction();
        if (worker!=null) {
            worker.work(tjdata.getDatabase());
        }
        transaction.commit();;
        return tjdata;
    }

    public static ESAJDatabaseManager share() {
        if (shared == null) {
            shared = start();
            return shared;
        }
        if (!shared.alive()) {
            shared = start();
            return shared;
        }
        return shared;
    }

    public void work(ESAJDatabaseWorker worker) {
        synchronized (entityManager) {
            Session session = entityManager.unwrap(Session.class);
            Transaction transaction = session.beginTransaction();
            transaction.setTimeout(5);
            worker.work(getDatabase());
            transaction.commit();
        }
    }

    public Transaction begin() {
        synchronized (entityManager) {
            Session session = entityManager.unwrap(Session.class);
            Transaction transaction = session.beginTransaction();
            transaction.setTimeout(5);
            return transaction;
        }
    }

    public void end() {
        synchronized (entityManager) {
            entityManager.close();
        }
    }

    public Boolean alive() {
        return entityManager.isOpen();
    }

    public ESAJDatabase getDatabase() {
        RepositoryFactorySupport repositoryFactorySupport = new JpaRepositoryFactory(entityManager);
        ESAJProcessoRepository processoRepository = repositoryFactorySupport.getRepository(ESAJProcessoRepository.class);
        ESAJPartesProcessoRepository partesProcessoRepository = repositoryFactorySupport.getRepository(ESAJPartesProcessoRepository.class);
        ESAJDadosProcessoRepository dadosProcessoRepository = repositoryFactorySupport.getRepository(ESAJDadosProcessoRepository.class);
        ESAJPeticaoDiversaRepository peticaoDiversaRepository = repositoryFactorySupport.getRepository(ESAJPeticaoDiversaRepository.class);
        ESAJMovimentacaoRepository movimentacaoRepository = repositoryFactorySupport.getRepository(ESAJMovimentacaoRepository.class);
        ESAJJulgamentoRepository julgamentoRepository = repositoryFactorySupport.getRepository(ESAJJulgamentoRepository.class);
        ESAJSubprocessoRepository subprocessoRepository = repositoryFactorySupport.getRepository(ESAJSubprocessoRepository.class);
        ESAJComposicaoJulgamentoRepository composicaoJulgamentoRepository = repositoryFactorySupport.getRepository(ESAJComposicaoJulgamentoRepository.class);
        ESAJDocumentoRepository documentoRepository = repositoryFactorySupport.getRepository(ESAJDocumentoRepository.class);
        ESAJAcaoRepository acaoRepository = repositoryFactorySupport.getRepository(ESAJAcaoRepository.class);
        ESAJPesquisaFoneticaProcessoRepository pesquisaFoneticaProcessoRepository = repositoryFactorySupport.getRepository(ESAJPesquisaFoneticaProcessoRepository.class);
        ESAJPesquisaFoneticaRepository pesquisaFoneticaRepository = repositoryFactorySupport.getRepository(ESAJPesquisaFoneticaRepository.class);
        ESAJCaptchaRepository captchaRepository = repositoryFactorySupport.getRepository(ESAJCaptchaRepository.class);
        CookieRepository cookieRepository = repositoryFactorySupport.getRepository(CookieRepository.class);
        ESAJDatabase database = new ESAJDatabase(processoRepository,
                movimentacaoRepository,
                partesProcessoRepository,
                julgamentoRepository,
                dadosProcessoRepository,
                composicaoJulgamentoRepository,
                subprocessoRepository,
                documentoRepository,
                acaoRepository,
                peticaoDiversaRepository,
                pesquisaFoneticaProcessoRepository,
                pesquisaFoneticaRepository,
                captchaRepository,
                cookieRepository);
        return database;
    }


}
