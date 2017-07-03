package br.com.rafagonc.tjdata.repositories;

import br.com.rafagonc.tjdata.models.ESAJDocumento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by rafagonc on 02/07/17.
 */
@Repository
public interface ESAJDocumentoRepository extends JpaRepository<ESAJDocumento, Long> {
}
