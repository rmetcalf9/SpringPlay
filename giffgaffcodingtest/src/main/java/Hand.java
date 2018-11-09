import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Hand{
    private List<String> cardList = null;

    public Hand(List<String> incommingHand) {
        cardList = incommingHand;

        Collections.sort(cardList, new Comparator<String>() {
            public int compare(String o1, String o2) {
                Integer v1 = Hand.getCardValue(o1);
                Integer v2 = Hand.getCardValue(o2);
                return v1.compareTo(v2);
            }
        });

    }

    public boolean isThisHandARoyalFlush() {
        return false;
    }

    //Return true if the hand is entirly the same suite
    public boolean isFlush() {
        HashMap<String,String> suitesSeen = new HashMap<String,String>();
        for (String cardString : cardList) {
            String suite = cardString.substring(cardString.length()-1);
            suitesSeen.put(suite,suite);
        }
        return suitesSeen.size()==1;
    }

    public static Integer getCardValue(String card) {
        return Integer.parseInt(card.substring(0,card.length()-1));

    }

    public boolean isStraight() {
        int card0Value = getCardValue(cardList.get(0));

        //Go through remaining cards and return if values are not consecutive
        for (int c=1;c<5;c++) {
            card0Value++; //this is now the value we expect the next card to be
            if (getCardValue(cardList.get(c))!=card0Value) return false;
        }

        return true;
    }
}
