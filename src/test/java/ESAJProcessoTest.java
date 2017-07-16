import br.com.rafagonc.tjdata.database.ESAJDatabase;
import br.com.rafagonc.tjdata.database.ESAJDatabaseManager;
import br.com.rafagonc.tjdata.models.*;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by rafagonc on 15/07/17.
 */
public class ESAJProcessoTest {

    private ESAJDatabase db;
    private ESAJDatabaseManager manager;

    @Before
    public void setUp() throws Exception {
        manager = ESAJDatabaseManager.share();
        db = manager.getDatabase();
    }

    @org.junit.Test
    public void testCreate() throws Exception {
        create("319-");
    }

    @org.junit.Test
    public void testDelete() throws Exception {

        ESAJProcesso processo = create("3123");

        Transaction t = manager.begin();

        db.getProcessoRepository().delete(processo);

        t.commit();
    }

    @Test
    public void testQuery() throws Exception {

        String numero = "ProcessoTeste-0000";

        ESAJProcesso processo = create(numero);

        ESAJProcesso objectQueried = db.getProcessoRepository().getProcessoNumero(numero);

        Assert.assertTrue(processo.equals(objectQueried));

    }

    private ESAJProcesso create() {
        return create("abc");
    }

    private ESAJProcesso create(String numero) {


        ESAJProcesso p = db.getProcessoRepository().getProcessoNumero(numero);

        if (p != null) {
            Transaction t = manager.begin();
            db.getProcessoRepository().delete(p);
            t.commit();

        }

        Transaction t = manager.begin();

        ESAJDadosProcesso dadosProcesso = new ESAJDadosProcesso();
        dadosProcesso.setNumero(numero);

        Set<ESAJPartesProcesso> partesProcessos = new HashSet<ESAJPartesProcesso>();

        ESAJPartesProcesso partesProcesso = new ESAJPartesProcesso("advg","reqte");
        partesProcessos.add(partesProcesso);

        Set<ESAJMovimentacao> movimentacaos = new HashSet<ESAJMovimentacao>();

        ESAJMovimentacao movimentacao = new ESAJMovimentacao("a","b");
        movimentacaos.add(movimentacao);

        Set<ESAJPeticaoDiversa> peticoesDiversas = new HashSet<ESAJPeticaoDiversa>();

        ESAJPeticaoDiversa peticaoDiversa = new ESAJPeticaoDiversa("a","b");
        peticoesDiversas.add(peticaoDiversa);

        Set<ESAJAcao> acoes = new HashSet<ESAJAcao>();

        ESAJAcao acao = new ESAJAcao("a","b");
        acoes.add(acao);

        ESAJProcesso processo = new ESAJProcesso(numero, dadosProcesso, movimentacaos, partesProcessos, peticoesDiversas, acoes);

        db.getProcessoRepository().save(processo);

        t.commit();

        return processo;
    }


}
