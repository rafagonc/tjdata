import br.com.rafagonc.tjdata.database.ESAJDatabase;
import br.com.rafagonc.tjdata.database.ESAJDatabaseManager;
import br.com.rafagonc.tjdata.models.ESAJDadosProcesso;
import org.hibernate.Transaction;
import org.junit.Before;

/**
 * Created by rafagonc on 15/07/17.
 */
public class ESAJDadosProcessoTest {

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

        ESAJDadosProcesso dadosProcesso = create();

        Transaction t = manager.begin();

        db.getDadosProcessoRepository().delete(dadosProcesso);

        t.commit();
    }

    private ESAJDadosProcesso create() {
        Transaction t = manager.begin();

        ESAJDadosProcesso dadosProcesso = new ESAJDadosProcesso();

        db.getDadosProcessoRepository().save(dadosProcesso);

        t.commit();

        return dadosProcesso;
    }


}
