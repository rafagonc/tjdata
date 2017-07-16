import br.com.rafagonc.tjdata.database.ESAJDatabase;
import br.com.rafagonc.tjdata.database.ESAJDatabaseManager;
import br.com.rafagonc.tjdata.models.ESAJMovimentacao;
import org.hibernate.Transaction;
import org.junit.Before;

/**
 * Created by rafagonc on 15/07/17.
 */
public class ESAJMovimentacaoTest {

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

        ESAJMovimentacao movimentacao = create();

        Transaction t = manager.begin();

        db.getMovimentacaoRepository().delete(movimentacao);

        t.commit();
    }

    private ESAJMovimentacao create() {
        Transaction t = manager.begin();

        ESAJMovimentacao movimentacao = new ESAJMovimentacao();

        db.getMovimentacaoRepository().save(movimentacao);

        t.commit();

        return movimentacao;
    }

}
