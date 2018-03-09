package br.com.rafagonc.tjdata.repositories;

import br.com.rafagonc.tjdata.models.ESAJCaptcha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ESAJCaptchaRepository extends JpaRepository<ESAJCaptcha, Long> {

    @Query("SELECT c FROM ESAJCaptcha c WHERE c.state LIKE :state ORDER BY id DESC")
    List<ESAJCaptcha> captchas(@Param("state") String state);

}
