package br.com.rafagonc.tjdata.repositories;

import br.com.rafagonc.tjdata.models.ESAJDadosProcesso;
import br.com.rafagonc.tjdata.models.ESAJProcesso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by rafagonc on 29/06/17.
 */
@Repository
public interface ESAJDadosProcessoRepository extends JpaRepository<ESAJDadosProcesso, Long> {

    @Query("SELECT d FROM ESAJDadosProcesso d WHERE d.processo = :p")
    ESAJDadosProcesso dadosDoProcesso(@Param("p") ESAJProcesso processo);

}
