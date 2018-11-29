package metcarob.com.devplay.shoppingbasket.CurrencyServices;

import org.junit.Test;

import static org.junit.Assert.*;

public class FixerIOTest {

    @Test
    public void getRateLists()  throws Exception {

        FixerIO f = new FixerIO();
        f.getRateLists();

    }
}