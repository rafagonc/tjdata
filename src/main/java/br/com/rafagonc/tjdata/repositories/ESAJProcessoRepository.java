package br.com.rafagonc.tjdata.repositories;

import br.com.rafagonc.tjdata.models.ESAJProcesso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by rafagonc on 29/06/17.
 */
@Repository
public interface ESAJProcessoRepository extends JpaRepository<ESAJProcesso, Long> {

    @Query("SELECT a FROM ESAJProcesso a WHERE a.id = (SELECT max(p.id) FROM ESAJProcesso p WHERE p.numero LIKE :n)")
    ESAJProcesso getProcessoNumero(@Param("n") String numero);

}
