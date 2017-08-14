import br.com.rafagonc.tjdata.database.ESAJDatabase;
import br.com.rafagonc.tjdata.database.ESAJDatabaseManager;
import br.com.rafagonc.tjdata.models.ESAJPesquisaFonetica;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

/**
 * Created by rafagonc on 13/08/17.
 */
public class ESAJPesquisaFoneticaTest {

    private ESAJDatabase db;
    private ESAJDatabaseManager manager;

    @Before
    public void setUp() throws Exception {
        manager = ESAJDatabaseManager.share();
        db = manager.getDatabase();
    }

    @Test
    public void testCreate() throws Exception {
        ESAJPesquisaFonetica pf = create();
    }

    @Test
    public void testDelete() throws Exception {
        ESAJPesquisaFonetica pf = create();

        Transaction t = manager.begin();

        db.getPesquisaFoneticaRepository().delete(pf);

        t.commit();

    }

    private ESAJPesquisaFonetica create() {
        Transaction t = manager.begin();

        ESAJPesquisaFonetica pf = new ESAJPesquisaFonetica();
        pf.setNome(UUID.randomUUID().toString());

        db.getPesquisaFoneticaRepository().save(pf);

        t.commit();

        return pf;
    }
}
