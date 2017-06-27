package br.com.rafagonc.tjdata.database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by rafagonc on 27/06/17.
 */
public class TJDATA {

    private EntityManager entityManager;

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
        if (worker!=null) {
            worker.work(entityManager);
        }
        return tjdata;
    }

    public void work(TJDATAWorker worker) {
        worker.work(entityManager);
    }


}
