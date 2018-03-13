import br.com.rafagonc.tjdata.database.ESAJDatabase;
import br.com.rafagonc.tjdata.database.ESAJDatabaseManager;
import br.com.rafagonc.tjdata.models.Cookie;
import br.com.rafagonc.tjdata.models.ESAJCaptcha;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;

public class ESAJCaptchaTest {

    private ESAJDatabase db;
    private ESAJDatabaseManager manager;

    @Before
    public void setUp() throws Exception {
        manager = ESAJDatabaseManager.share();
        db = manager.getDatabase();
    }

    @Test
    public void testCreate() {
        create("");
    }

    private ESAJCaptcha create(String uuid) {
        Transaction t = manager.begin();

        ESAJCaptcha captcha = new ESAJCaptcha("sp", new HashSet<Cookie>(), uuid, "");

        HashSet hashSet = new HashSet<Cookie>();

        Cookie cookie = new Cookie("a","","");
        cookie.setPath("");
        db.getCookieRepository().save(cookie);

        hashSet.add(cookie);

        captcha.setCookies(hashSet);

        db.getCaptchaRepository().save(captcha);

        t.commit();

        return captcha;
    }

    @Test
    public void testSelectLast() {
        create("1");
        create("2");
        create("3");
        ESAJCaptcha captcha1 = db.getCaptchaRepository().captchas("sp").get(0);
        create("4");
        ESAJCaptcha captcha2 = db.getCaptchaRepository().captchas("sp").get(0);
        Assert.assertTrue(captcha1.getUuidCaptcha().equals("3"));
        Assert.assertTrue(captcha2.getUuidCaptcha().equals("4"));
    }



}
