import br.com.rafagonc.tjdata.database.ESAJDatabase;
import br.com.rafagonc.tjdata.database.ESAJDatabaseManager;
import br.com.rafagonc.tjdata.models.ESAJPesquisaFoneticaProcesso;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.UUID;

/**
 * Created by rafagonc on 13/08/17.
 */
public class ESAJPesquisaFoneticaProcessoTest {

    private ESAJDatabase db;
    private ESAJDatabaseManager manager;

    @Before
    public void setUp() throws Exception {
        manager = ESAJDatabaseManager.share();
        db = manager.getDatabase();
    }

    @Test
    public void testCreate() throws Exception {
        create();
    }

    @Test
    public void testDelete() throws Exception {
        ESAJPesquisaFoneticaProcesso pf = create();

        Transaction t = manager.begin();

        db.getPesquisaFoneticaProcessoRepository().delete(pf);

        t.commit();

    }

    private ESAJPesquisaFoneticaProcesso create() {
        Transaction t = manager.begin();

        ESAJPesquisaFoneticaProcesso pf = new ESAJPesquisaFoneticaProcesso();
        pf.setNumero(UUID.randomUUID().toString());
        pf.setDataProcesso(new Date());
        pf.setForo(503);

        db.getPesquisaFoneticaProcessoRepository().save(pf);

        t.commit();

        return pf;
    }

}
