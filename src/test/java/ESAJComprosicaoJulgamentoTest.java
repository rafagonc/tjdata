import br.com.rafagonc.tjdata.database.ESAJDatabase;
import br.com.rafagonc.tjdata.database.ESAJDatabaseManager;
import br.com.rafagonc.tjdata.models.ESAJComposicaoJulgamento;
import org.hibernate.Transaction;
import org.junit.Before;

/**
 * Created by rafagonc on 15/07/17.
 */
public class ESAJComprosicaoJulgamentoTest {

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

        ESAJComposicaoJulgamento composicaoJulgamento = create();

        Transaction t = manager.begin();

        db.getComposicaoJulgamentoRepository().delete(composicaoJulgamento);

        t.commit();
    }

    private ESAJComposicaoJulgamento create() {
        Transaction t = manager.begin();

        ESAJComposicaoJulgamento composicaoJulgamento = new ESAJComposicaoJulgamento();

        db.getComposicaoJulgamentoRepository().save(composicaoJulgamento);

        t.commit();

        return composicaoJulgamento;
    }

}
