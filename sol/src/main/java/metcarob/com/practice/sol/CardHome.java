package metcarob.com.practice.sol;

//Object to represent all 4 card homes
public class CardHome {

    Card.SUITE[] suite = {null, null, null, null};
    Card.CARDVALUE[] curValue = {null, null, null, null};

    public String toString() {
        String out = "";
        for (int c=0;c<4;c++) {
            if (null==suite[c]) {
                out += "___  ";
            } else {
                out += Card.boardString(suite[c],curValue[c]);
            }
        }
        return out;
    }


    public boolean canPlaceCard(Card cardToPlace) throws Exception {
        if (cardToPlace.getValue().equals(Card.CARDVALUE.ACE)) return true;
        for (int c=0;c<4;c++) {
            if (suite[c] == cardToPlace.getSuite()) {
                return (curValue[c].getValue()+1)==cardToPlace.getValue().getValue();
            }
        }
        return false;
    }

    public void placeCard(Card cardToPlace) throws Exception {
        if (cardToPlace.getValue().equals(Card.CARDVALUE.ACE)) {
            for (int c=0;c<4;c++) {
                if (suite[c]==null) {
                    suite[c]=cardToPlace.getSuite();
                    curValue[c]=cardToPlace.getValue();
                    return;
                }
            }
        } else {
            for (int c=0;c<4;c++) {
                if (suite[c] == cardToPlace.getSuite()) {
                    if ( (curValue[c].getValue()+1)==cardToPlace.getValue().getValue()) {
                        curValue[c] = cardToPlace.getValue();
                        return;
                    }
                }
            }
        }
        throw new Exception("Logically should not reach this line");
    }
}
