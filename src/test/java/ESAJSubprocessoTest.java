import br.com.rafagonc.tjdata.database.ESAJDatabase;
import br.com.rafagonc.tjdata.database.ESAJDatabaseManager;
import br.com.rafagonc.tjdata.models.ESAJSubprocesso;
import org.hibernate.Transaction;
import org.junit.Before;

/**
 * Created by rafagonc on 15/07/17.
 */
public class ESAJSubprocessoTest {

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

        ESAJSubprocesso subprocesso = create();

        Transaction t = manager.begin();

        db.getSubprocessoRepository().delete(subprocesso);

        t.commit();
    }

    private ESAJSubprocesso create() {
        Transaction t = manager.begin();

        ESAJSubprocesso subprocesso = new ESAJSubprocesso();

        db.getSubprocessoRepository().save(subprocesso);

        t.commit();

        return subprocesso;
    }

}
