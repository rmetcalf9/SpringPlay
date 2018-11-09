package metcarob.com.practice.sol;

import java.util.*;

// Represents a deck of cards
// Standard card deck with one of each card
// Starts in order - must be shuffeled
public class CardDeck {

    Stack<Card> cards = new Stack<Card>();

    public CardDeck() {
        this.ConstructDeck();
    }

    public CardDeck(boolean includeJokers) {
        this.ConstructDeck();
        if (includeJokers) {
            cards.add(Card.constructJokerCard());
            cards.add(Card.constructJokerCard());
        }
    }

    private void ConstructDeck() {
        for (Card.SUITE suite : Card.SUITE.normalValues()) {
            for (Card.CARDVALUE value : Card.CARDVALUE.normalValues()) {
                cards.add(new Card(suite,value));
            }
        }
    }

    public Card takeNextCardFromDeck() {
        if (cards.empty()) return null;
        return cards.pop();
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }
    public void shuffle(long seed) {
        Collections.shuffle(cards, new Random(seed));
    }
}
