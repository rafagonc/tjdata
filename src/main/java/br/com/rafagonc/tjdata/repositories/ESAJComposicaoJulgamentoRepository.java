package br.com.rafagonc.tjdata.repositories;

import br.com.rafagonc.tjdata.models.ESAJComposicaoJulgamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by rafagonc on 29/06/17.
 */
@Repository
public interface ESAJComposicaoJulgamentoRepository extends JpaRepository<ESAJComposicaoJulgamento, Long> {
}
