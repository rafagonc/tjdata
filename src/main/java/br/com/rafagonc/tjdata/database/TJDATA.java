package br.com.rafagonc.tjdata.database;

import br.com.rafagonc.tjdata.models.ESAJProcesso;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by rafagonc on 27/06/17.
 */
public class TJDATA {

    private EntityManager entityManager;
    private JpaRepository<ESAJProcesso, Long> processoRepo;

    public TJDATA(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public static TJDATA start() {
        return TJDATA.start(null);
    }

    public static TJDATA start(TJDATAWorker worker) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tj");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TJDATA tjdata = new TJDATA(entityManager);
        JpaRepository<ESAJProcesso, Long> processoRepository = new SimpleJpaRepository<ESAJProcesso, Long>(ESAJProcesso.class, entityManager);
        Session session = entityManager.unwrap(Session.class);
        Transaction transaction = session.beginTransaction();
        if (worker!=null) {
            worker.work(entityManager, processoRepository);
        }
        transaction.commit();;
        tjdata.processoRepo = processoRepository;
        return tjdata;
    }

    public void work(TJDATAWorker worker) {
        Session session = entityManager.unwrap(Session.class);
        Transaction transaction = session.beginTransaction();
        transaction.setTimeout(5);
        worker.work(entityManager, this.processoRepo);
        transaction.commit();;
    }


}
