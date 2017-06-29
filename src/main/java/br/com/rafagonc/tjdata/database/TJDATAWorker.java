package br.com.rafagonc.tjdata.database;

import br.com.rafagonc.tjdata.models.ESAJProcesso;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityManager;

/**
 * Created by rafagonc on 27/06/17.
 */
public interface TJDATAWorker {

    void work(EntityManager em, JpaRepository<ESAJProcesso, Long> processoRepository);

}
