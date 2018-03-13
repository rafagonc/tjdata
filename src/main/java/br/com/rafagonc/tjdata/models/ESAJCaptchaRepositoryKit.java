package br.com.rafagonc.tjdata.models;

import br.com.rafagonc.tjdata.repositories.CookieRepository;
import br.com.rafagonc.tjdata.repositories.ESAJCaptchaRepository;

public class ESAJCaptchaRepositoryKit {

    private ESAJCaptchaRepository captchaRepository;
    private CookieRepository cookieRepository;

    public ESAJCaptchaRepositoryKit(ESAJCaptchaRepository captchaRepository, CookieRepository cookieRepository) {
        this.captchaRepository = captchaRepository;
        this.cookieRepository = cookieRepository;
    }

    public ESAJCaptchaRepository getCaptchaRepository() {
        return captchaRepository;
    }

    public void setCaptchaRepository(ESAJCaptchaRepository captchaRepository) {
        this.captchaRepository = captchaRepository;
    }

    public CookieRepository getCookieRepository() {
        return cookieRepository;
    }

    public void setCookieRepository(CookieRepository cookieRepository) {
        this.cookieRepository = cookieRepository;
    }
}
