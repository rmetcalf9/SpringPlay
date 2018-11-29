package metcarob.com.devplay.shoppingbasket.CurrencyServices;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FixerIOTest {

    @Autowired
    public FixerIO fixerIO;

    @Test
    public void getRateLists()  throws Exception {

        fixerIO.getRateLists();

    }
}