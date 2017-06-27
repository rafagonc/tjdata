package br.com.rafagonc.tjdata.database;

import javax.persistence.EntityManager;

/**
 * Created by rafagonc on 27/06/17.
 */
public interface TJDATAWorker {

    void work(EntityManager em);

}
