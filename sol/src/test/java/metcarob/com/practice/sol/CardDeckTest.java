package metcarob.com.practice.sol;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CardDeckTest {


    @Test
    public void setupNewDeck() {
        try {
            CardDeck deck = new CardDeck();
        } catch (Exception e) {
            assert(true);
        }

    }

    @Test
    public void makeSureWeCanOnlyTakeCorrectNumberOfCards() {
        checkCorrectNumberOfCards(true);
        checkCorrectNumberOfCards(false);
    }

    private void checkCorrectNumberOfCards(boolean withJokers) {
        try {
            CardDeck deck = new CardDeck(withJokers);
            int c=0;
            while (deck.takeNextCardFromDeck() != null) {
                c++;
            }
            int expectedNum = (Card.SUITE.normalValues().length * Card.CARDVALUE.normalValues().length);
            if (withJokers) {
                expectedNum++;
                expectedNum++;
            }
            assertEquals("Was not able to take right number of cards",c,expectedNum);
        } catch (Exception e) {
            e.printStackTrace();
            assert(false);
        }
    }

    private boolean cardIsInList(List<Card> list, Card card) {
        for (Card c : list) {
            if (c.compareTo(card)==0) return true;
        }
        return false;
    }

    @Test
    public void makeSureWeCanNotTakeSameCardTwice() throws Exception {
        CardDeck deck = new CardDeck();
        List<Card> cards = new ArrayList<Card>();
        for (int c=0;c<52;c++) {
            Card card = deck.takeNextCardFromDeck();
            if (cardIsInList(cards, card)) {
                assertTrue("Got the same card more than once from deck", false);
            }
            cards.add(card);
        }

    }
}