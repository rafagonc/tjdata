import br.com.rafagonc.tjdata.database.ESAJDatabase;
import br.com.rafagonc.tjdata.database.TJDATA;
import br.com.rafagonc.tjdata.database.TJDATAWorker;

/**
 * Created by rafagonc on 29/06/17.
 */
public class Test {

    @org.junit.Test
    public void testDatabaseConnection() throws Exception {
        TJDATA.start(new TJDATAWorker() {
            @Override
            public void work(ESAJDatabase database) {

            }
        });
    }
}
