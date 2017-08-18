package br.com.rafagonc.tjdata.repositories;

import br.com.rafagonc.tjdata.models.ESAJPesquisaFonetica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

/**
 * Created by rafagonc on 13/08/17.
 */
public interface ESAJPesquisaFoneticaRepository extends JpaRepository<ESAJPesquisaFonetica, Long> {

    @Query("SELECT p FROM ESAJPesquisaFonetica p WHERE p.nome LIKE :np AND p.numeroForo = :f AND p.numeroGrau = :g")
    Set<ESAJPesquisaFonetica> findPesquisaFoneticaByNomeParteAndForoAndGrau(@Param("np") String np, @Param("f") Integer foro, @Param("g") Integer grau);

    @Query("SELECT p FROM ESAJPesquisaFonetica p WHERE p.nome LIKE :np AND p.numeroForo = :f")
    Set<ESAJPesquisaFonetica> findPesquisaFoneticaByNomeParteAndForo(@Param("np") String np, @Param("f") Integer foro);

    @Query("SELECT p FROM ESAJPesquisaFonetica p WHERE p.nome LIKE :np")
    Set<ESAJPesquisaFonetica> findPesquisaFoneticaByNomeParte(@Param("np") String np);

}
