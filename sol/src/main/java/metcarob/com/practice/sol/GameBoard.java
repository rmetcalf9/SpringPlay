package metcarob.com.practice.sol;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameBoard {

    private final static int NUMCOLS = 7;
    private final static int MAXLINESINOUTPUT = 20;

    List<List<GameBoardSlot>> cols = new ArrayList<List<GameBoardSlot>>();

    CardDeck deck = null;

    public GameBoard() throws Exception {
        IntStream.range(0,NUMCOLS).boxed().collect(Collectors.toList()).forEach(i -> cols.add(new ArrayList<GameBoardSlot>()));
        deck = new CardDeck(true);
        deck.shuffle();

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
        for (int line=0;line<MAXLINESINOUTPUT;line++) {
            String l = "";
            for (int col=0; col<NUMCOLS;col++) {
                if (cols.get(col).size()>line) {
                    l += cols.get(col).get(line).boardString();
                } else {
                    l += "     ";
                }
            }
            lines.add(l);
        }

        String out = "";
        for (String s : lines) {
            out += s;
            out += "\n";
        }
        return out;
    }
}
