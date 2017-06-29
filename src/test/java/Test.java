import br.com.rafagonc.tjdata.database.TJDATA;
import br.com.rafagonc.tjdata.database.TJDATAWorker;

import javax.persistence.EntityManager;

/**
 * Created by rafagonc on 29/06/17.
 */
public class Test {

    @org.junit.Test
    public void testDatabaseConnection() throws Exception {
        TJDATA.start(new TJDATAWorker() {
            @Override
            public void work(EntityManager em) {

            }
        });

    }
}
