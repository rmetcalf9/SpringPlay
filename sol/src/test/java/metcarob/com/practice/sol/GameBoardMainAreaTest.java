package metcarob.com.practice.sol;

import org.junit.Test;

import static org.junit.Assert.*;

public class GameBoardMainAreaTest {

    @Test
    public void canGoOnTopOfSimpleChecks() {

        Card a = new Card(Card.SUITE.HEARTS, Card.CARDVALUE.NINE);
        Card b = new Card(Card.SUITE.CLUBS, Card.CARDVALUE.TEN);
        assertTrue(String.format("%s should be able to go on top of %s",a.toString(),b.toString()),GameBoardMainArea.canCardGoOnTopOf(a, b));

    }
}