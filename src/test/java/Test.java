import br.com.rafagonc.tjdata.database.ESAJDatabase;
import br.com.rafagonc.tjdata.database.ESAJDatabaseManager;
import br.com.rafagonc.tjdata.database.ESAJDatabaseWorker;

/**
 * Created by rafagonc on 29/06/17.
 */
public class Test {

    @org.junit.Test
    public void testDatabaseConnection() throws Exception {
        ESAJDatabaseManager.start(new ESAJDatabaseWorker() {
            @Override
            public void work(ESAJDatabase database) {

            }
        });
    }
}
