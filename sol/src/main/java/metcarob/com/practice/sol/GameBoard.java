package metcarob.com.practice.sol;

public class GameBoard {
    GameBoardMainArea mainArea = null;
    CardHome homeArea = null;
    CardDeck deck = null;
    CardPile pile = null;

    public GameBoard(long seed) {
        CardDeck cd = new CardDeck(false);
        cd.shuffle(seed);
        construct(cd);
    }


    public GameBoard() throws Exception {
        CardDeck cd = new CardDeck(false);
        cd.shuffle();
        construct(cd);
    }

    private void construct(CardDeck cardDeck) {
        deck = cardDeck;
        mainArea = new GameBoardMainArea(deck);
        homeArea = new CardHome();
        pile = new CardPile(deck);
    }

    public String toString() {
        String out = "";

        out += pile.toString();
        out += "     ";
        out += homeArea.toString();
        out += "\n\n";

        out += mainArea.toString();

        return out;
    }

    public void turnCardInPile() {
        pile.turn();
    }

    public boolean isCardReadyToMoveFromPile() {
        return pile.isCardReadyToMove();
    }

    public boolean moveCardFromPileToCol(int zeroBasedColumnNumber) {
        if (!mainArea.canPlaceCard(zeroBasedColumnNumber, pile.getVisibleCard())) {
            System.out.println(String.format("%s can't go on top of %s",pile.getVisibleCard().toString(),mainArea.bottomCardInCol(zeroBasedColumnNumber).toString()));
            return false;
        }
        Card c = pile.takeCard();
        mainArea.placeCard(zeroBasedColumnNumber, c);
        return true;
    }

    public boolean moveCardFromPileToHome() throws Exception {
        if (!homeArea.canPlaceCard(pile.getVisibleCard())) {
            return false;
        }
        homeArea.placeCard(pile.takeCard());
        return true;
    }

    public boolean moveCardFromColToHome(int zeroBasedColumnNumber) throws Exception {
        Card cardToMove = mainArea.bottomCardInCol(zeroBasedColumnNumber);
        if (cardToMove==null) return false;
        if (!homeArea.canPlaceCard(cardToMove)) return false;
        homeArea.placeCard(mainArea.takeBottomCardInCol(zeroBasedColumnNumber));
        return true;
    }
}
