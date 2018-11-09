package metcarob.com.practice.sol;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameBoardMainArea {
    public final static int NUMCOLS = 7;

    List<List<GameBoardSlot>> cols = new ArrayList<List<GameBoardSlot>>();



    public GameBoardMainArea(CardDeck deck) {
        IntStream.range(0,NUMCOLS).boxed().collect(Collectors.toList()).forEach(i -> cols.add(new ArrayList<GameBoardSlot>()));

        for (int col=0; col<NUMCOLS;col++) {
            for (int c=0;c<(col+1);c++) {
                cols.get(col).add(new GameBoardSlot(deck.takeNextCardFromDeck()));
            }
        }
        turnFreeCards();

    }

    public void turnFreeCards() {
        //We can turn over a card if the last card in it's column is not visible
        for (int col=0; col<NUMCOLS; col++) {
            List<GameBoardSlot> thisCol = cols.get(col);
            if (thisCol.size()>0) {
                if (!thisCol.get(thisCol.size()-1).isVisible()) thisCol.get(thisCol.size()-1).turnCard();
            }
        }
    }

    public String toString() {
        List<String> lines = new ArrayList<String>();
        boolean cardOutput = true;
        int line = 0;
        while (cardOutput) {
            cardOutput = false;
            String l = "";
            for (int col=0; col<NUMCOLS;col++) {
                if (cols.get(col).size()>line) {
                    l += cols.get(col).get(line).boardString();
                    cardOutput = true;
                } else {
                    l += "     ";
                }
            }
            lines.add(l);
            line++;
        }

        String out = "";
        for (String s : lines) {
            out += s;
            out += "\n";
        }
        return out;
    }

    public void placeCard(int zeroBasedColumnNumber, Card c) {
        GameBoardSlot slot = new GameBoardSlot(c);
        slot.turnCard();
        cols.get(zeroBasedColumnNumber).add(slot);
    }



    public boolean canPlaceCard(int zeroBasedColumnNumber, Card cardToPlace) {
        List<GameBoardSlot> col = cols.get(zeroBasedColumnNumber);
        if (col.size()==0) {
            return (cardToPlace.getValue() == Card.CARDVALUE.KING);
        }
        return GameBoardMainArea.canCardGoOnTopOf(cardToPlace, bottomCardInCol(zeroBasedColumnNumber));
    }

    public static boolean canCardGoOnTopOf(Card cardToPlace, Card baseCard) {
        //Must be decending value
        if ((baseCard.getValue().getValue()) != (cardToPlace.getValue().getValue()+1)) return false;

        //Must alternate red/black
        if (baseCard.getSuite().getColour() == cardToPlace.getSuite().getColour()) return false;

        return true;
    }

    public Card bottomCardInCol(int zeroBasedColumnNumber) {
        List<GameBoardSlot> col = cols.get(zeroBasedColumnNumber);
        if (col.size()==0) return null;
        return col.get(col.size()-1).getCard();
    }

    public Card takeBottomCardInCol(int zeroBasedColumnNumber) {
        List<GameBoardSlot> col = cols.get(zeroBasedColumnNumber);
        Card c = this.bottomCardInCol(zeroBasedColumnNumber);
        col.remove(col.size()-1);
        return c;
    }
}
