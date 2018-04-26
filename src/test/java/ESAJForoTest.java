import br.com.rafagonc.tjdata.models.ESAJForo;
import org.junit.Assert;
import org.junit.Test;

import java.util.Set;

/**
 * Created by rafagonc on 13/08/17.
 */
public class ESAJForoTest {

    @Test
    public void testForos() throws Exception {
        Set<ESAJForo> foros = ESAJForo.foros("foro.json");
        System.out.print(foros);
        Assert.assertTrue(foros.size() > 0);

    }
}
