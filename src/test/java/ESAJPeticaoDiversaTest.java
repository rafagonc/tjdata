import br.com.rafagonc.tjdata.database.ESAJDatabase;
import br.com.rafagonc.tjdata.database.ESAJDatabaseManager;
import br.com.rafagonc.tjdata.models.ESAJPeticaoDiversa;
import org.hibernate.Transaction;
import org.junit.Before;

/**
 * Created by rafagonc on 15/07/17.
 */
public class ESAJPeticaoDiversaTest {

    private ESAJDatabase db;
    private ESAJDatabaseManager manager;

    @Before
    public void setUp() throws Exception {
        manager = ESAJDatabaseManager.share();
        db = manager.getDatabase();
    }

    @org.junit.Test
    public void testCreate() throws Exception {
        create();
    }

    @org.junit.Test
    public void testDelete() throws Exception {

        ESAJPeticaoDiversa peticaoDiversa = create();

        Transaction t = manager.begin();

        db.getPeticoesDiversasRepository().delete(peticaoDiversa);

        t.commit();
    }

    private ESAJPeticaoDiversa create() {
        Transaction t = manager.begin();

        ESAJPeticaoDiversa peticaoDiversa = new ESAJPeticaoDiversa();

        db.getPeticoesDiversasRepository().save(peticaoDiversa);

        t.commit();

        return peticaoDiversa;
    }


}
