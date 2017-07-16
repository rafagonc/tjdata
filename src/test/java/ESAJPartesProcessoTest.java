import br.com.rafagonc.tjdata.database.ESAJDatabase;
import br.com.rafagonc.tjdata.database.ESAJDatabaseManager;
import br.com.rafagonc.tjdata.models.ESAJPartesProcesso;
import org.hibernate.Transaction;
import org.junit.Before;

/**
 * Created by rafagonc on 15/07/17.
 */
public class ESAJPartesProcessoTest {

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

        ESAJPartesProcesso partesProcesso = create();

        Transaction t = manager.begin();

        db.getPartesProcessoRepository().delete(partesProcesso);

        t.commit();
    }

    private ESAJPartesProcesso create() {
        Transaction t = manager.begin();

        ESAJPartesProcesso partesProcesso = new ESAJPartesProcesso();

        db.getPartesProcessoRepository().save(partesProcesso);

        t.commit();

        return partesProcesso;
    }


}
