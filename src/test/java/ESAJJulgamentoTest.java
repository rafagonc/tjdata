import br.com.rafagonc.tjdata.database.ESAJDatabase;
import br.com.rafagonc.tjdata.database.ESAJDatabaseManager;
import br.com.rafagonc.tjdata.models.ESAJJulgamento;
import org.hibernate.Transaction;
import org.junit.Before;

/**
 * Created by rafagonc on 15/07/17.
 */
public class ESAJJulgamentoTest {

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

        ESAJJulgamento julgamento = create();

        Transaction t = manager.begin();

        db.getJulgamentoRepository().delete(julgamento);

        t.commit();
    }

    private ESAJJulgamento create() {
        Transaction t = manager.begin();

        ESAJJulgamento julgamento = new ESAJJulgamento();

        db.getJulgamentoRepository().save(julgamento);

        t.commit();

        return julgamento;
    }


}
