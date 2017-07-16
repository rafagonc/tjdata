import br.com.rafagonc.tjdata.database.ESAJDatabase;
import br.com.rafagonc.tjdata.database.ESAJDatabaseManager;
import br.com.rafagonc.tjdata.models.ESAJAcao;
import org.hibernate.Transaction;
import org.junit.Before;

/**
 * Created by rafagonc on 15/07/17.
 */
public class ESAJAcaoTest {

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

        ESAJAcao acao = create();

        Transaction t = manager.begin();

        db.getAcaoRepository().delete(acao);

        t.commit();
    }

    private ESAJAcao create() {
        Transaction t = manager.begin();

        ESAJAcao acao = new ESAJAcao();

        db.getAcaoRepository().save(acao);

        t.commit();

        return acao;
    }


}
