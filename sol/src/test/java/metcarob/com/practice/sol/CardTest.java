package metcarob.com.practice.sol;

import org.junit.Test;

import static org.junit.Assert.*;

public class CardTest {

    @Test
    public void CreationOfCards() {
        try {
            Card c = new Card(Card.SUITE.HEARTS, 4);
        } catch (Exception e) {
            assertTrue( "Creation of card failed", true);
        }
    }

    @Test
    public void CreationOfINvalidCardFAils() {
        boolean thrown = false;
        try {
            Card c = new Card(Card.SUITE.HEARTS, 123);
        } catch (Exception e) {
            thrown = true;
        }
        assertTrue("Invald card creation didn't except", thrown);
    }

    @Test
    public void SameCards() throws Exception{
        Card card1 = new Card(Card.SUITE.HEARTS, 1);
        Card card2 = new Card(Card.SUITE.HEARTS, 1);
        Card card3 = new Card(Card.SUITE.CLUBS, 1);
        if (card1==card2) {
            assertTrue("Card objects are the same", false);
        }
        if (card1==card3) {
            assertTrue("Card objects are the same", false);
        }
        if (card1.compareTo(card2) != 0) {
            assertTrue(String.format("Same card didn't compare properley - %d",card1.compareTo(card2)), false);
        }
        if (card1.compareTo(card3) == 0) {
            assertTrue(String.format("Different suites didn't compare properley - %d",card1.compareTo(card3)), false);
        }

    }
}