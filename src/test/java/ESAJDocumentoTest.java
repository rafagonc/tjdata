import br.com.rafagonc.tjdata.database.ESAJDatabase;
import br.com.rafagonc.tjdata.database.ESAJDatabaseManager;
import br.com.rafagonc.tjdata.models.ESAJDocumento;
import org.hibernate.Transaction;
import org.junit.Before;

/**
 * Created by rafagonc on 15/07/17.
 */
public class ESAJDocumentoTest {

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

        ESAJDocumento documento = create();

        Transaction t = manager.begin();

        db.getDocumentoRepository().delete(documento);

        t.commit();
    }

    private ESAJDocumento create() {
        Transaction t = manager.begin();

        ESAJDocumento documento = new ESAJDocumento();

        db.getDocumentoRepository().save(documento);

        t.commit();

        return documento;
    }

}
