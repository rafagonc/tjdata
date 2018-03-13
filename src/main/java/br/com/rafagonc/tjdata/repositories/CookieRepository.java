package br.com.rafagonc.tjdata.repositories;

import br.com.rafagonc.tjdata.models.Cookie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CookieRepository extends JpaRepository<Cookie, Long>{
}
