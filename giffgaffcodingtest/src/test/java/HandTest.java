import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class HandTest {

    //SUites
    //Value
    //

    //D = diamonds
    //C = Clubs
    //S = Spades
    //H = Hearts
    //2-14 (Aces high)

    //Royal flush is 10-14 same suite
    @Test
    public void notARoyalFlush() {
        List<String> myHand = new ArrayList<String>();
        myHand.add("2D");
        myHand.add("4D");
        myHand.add("6D");
        myHand.add("10C");
        myHand.add("11S");
        Hand ranker = new Hand(myHand);
        assertFalse("Wrongly identified a royal flush", ranker.isThisHandARoyalFlush());

    }
    /*
    @Test
    public void aRoyalFlush() {
        List<String> myHand = new ArrayList<String>();
        myHand.add("5D");
        myHand.add("11D");
        myHand.add("12D");
        myHand.add("13D");
        myHand.add("14D");
        Hand ranker = new Hand(myHand);

        assertTrue("Missed a royal flush", ranker.isThisHandARoyalFlush());

    }

    @Test
    public void aRoyalFlush() {
        List<String> myHand = new ArrayList<String>();
        myHand.add("10D");
        myHand.add("11D");
        myHand.add("12D");
        myHand.add("13D");
        myHand.add("14D");
        Hand ranker = new Hand(myHand);

        assertTrue("Missed a royal flush", ranker.isThisHandARoyalFlush());

    }*/

    @Test
    public void aFlush() {
        List<String> myHand = new ArrayList<String>();
        myHand.add("10D");
        myHand.add("11D");
        myHand.add("7D");
        myHand.add("13D");
        myHand.add("14D");
        Hand ranker = new Hand(myHand);

        assertTrue("Missed detecting a flush", ranker.isFlush());

    }
    @Test
    public void aNotFlush2Suites() {
        List<String> myHand = new ArrayList<String>();
        myHand.add("10D");
        myHand.add("11D");
        myHand.add("7D");
        myHand.add("13C");
        myHand.add("14D");
        Hand ranker = new Hand(myHand);

        assertFalse("Detecting a flush with two different suites", ranker.isFlush());

    }
    @Test
    public void aNotFlush4Suites() {
        List<String> myHand = new ArrayList<String>();
        myHand.add("10D");
        myHand.add("11H");
        myHand.add("7D");
        myHand.add("13C");
        myHand.add("14S");
        Hand ranker = new Hand(myHand);

        assertFalse("Detecting a flush with four different suites", ranker.isFlush());

    }

    @Test
    public void aStraight() {
        List<String> myHand = new ArrayList<String>();
        myHand.add("10D");
        myHand.add("11D");
        myHand.add("12D");
        myHand.add("13C");
        myHand.add("14D");
        Hand ranker = new Hand(myHand);

        assertTrue("Missed a straight", ranker.isStraight());

    }

    @Test
    public void notAStraight() {
        List<String> myHand = new ArrayList<String>();
        myHand.add("5D");
        myHand.add("11D");
        myHand.add("12D");
        myHand.add("13C");
        myHand.add("14D");
        Hand ranker = new Hand(myHand);

        assertFalse("Detected a straight when it is not", ranker.isStraight());

    }

    @Test
    public void notLastCardMeansItISNotStraight() {
        List<String> myHand = new ArrayList<String>();
        myHand.add("5D");
        myHand.add("6D");
        myHand.add("7D");
        myHand.add("8C");
        myHand.add("10D");
        Hand ranker = new Hand(myHand);

        assertFalse("Detected a straight when it is not", ranker.isStraight());
    }

    @Test
    public void notLastCardMeansItISNotStraight2() {
        List<String> myHand = new ArrayList<String>();
        myHand.add("5D");
        myHand.add("6D");
        myHand.add("7D");
        myHand.add("8C");
        myHand.add("10D");
        Hand ranker = new Hand(myHand);

        assertFalse("Detected a straight when it is not", ranker.isStraight());
    }

}