package metcarob.com.practice.sol;

import java.util.ArrayList;
import java.util.List;

//Object to represent the pile of cards shown/to be dealt
public class CardPile {

    List<Card> stackOfCards = new ArrayList<Card>();
    int cardsDealt = -1; //-1 if no card showing, otherwise it's the current position in array

    public CardPile(CardDeck deck) {
        Card curCard = null;
        while ((curCard = deck.takeNextCardFromDeck()) != null) {
            stackOfCards.add(curCard);
        }

    }
    public String toString() {

        if (stackOfCards.size()==0) {
            return "___  ___  ";
        }
        if (cardsDealt == -1) {
            return "XXX  ___  ";
        }

        String out = "";
        //If we are showing the last card then there is no face down cards in deck
        if (cardsDealt == (stackOfCards.size()-1)) {
            out += "___  ";
        } else {
            out += "XXX  ";
        }
        out += stackOfCards.get(cardsDealt).boardString();
        return out;
    }

    public void turn() {
        cardsDealt++;
        if (cardsDealt >= stackOfCards.size()) cardsDealt = -1;
    }

    public boolean isCardReadyToMove() {
        return cardsDealt != -1;
    }

    public Card takeCard() {
        Card c = getVisibleCard();
        stackOfCards.remove(cardsDealt);
        cardsDealt--; //make sure we are showing the card underneath
        return c;
    }

    public Card getVisibleCard() {
        return stackOfCards.get(cardsDealt);
    }
}
