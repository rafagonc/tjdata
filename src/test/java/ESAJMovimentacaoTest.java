import br.com.rafagonc.tjdata.database.ESAJDatabase;
import br.com.rafagonc.tjdata.database.ESAJDatabaseManager;
import br.com.rafagonc.tjdata.models.ESAJMovimentacao;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    private ESAJMovimentacao createWithText() {
        Transaction t = manager.begin();

        ESAJMovimentacao movimentacao = new ESAJMovimentacao();

        db.getMovimentacaoRepository().save(movimentacao);

        t.commit();

        return movimentacao;
    }

    @Test
    public void testSort() throws Exception {
        ESAJMovimentacao movimentacao = new ESAJMovimentacao();
        movimentacao.setData("12/12/2015");

        ESAJMovimentacao movimentacao2 = new ESAJMovimentacao();
        movimentacao2.setData("12/12/2016");

        List<ESAJMovimentacao> list = new ArrayList<ESAJMovimentacao>();
        list.add(movimentacao);
        list.add(movimentacao2);

        Collections.sort(list, Collections.<ESAJMovimentacao>reverseOrder());

        Assert.assertTrue(list.get(0).equals(movimentacao2));
        Assert.assertTrue(list.get(1).equals(movimentacao));
    }
}
