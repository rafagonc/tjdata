package br.com.rafagonc.tjdata.repositories;

import br.com.rafagonc.tjdata.models.ESAJProcesso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by rafagonc on 29/06/17.
 */
@Repository
public interface ESAJProcessoRepository extends JpaRepository<ESAJProcesso, Long> {
}
