package metcarob.com.practice.sol;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class MainAppTest {

    private void playRecordedGame(String recording) throws Exception {
        MainApp app = new MainApp();
        List<Move> moves = new ArrayList<Move>();
        for (String s : recording.split(Move.SEPERATOR)) {
            moves.add(new Move(s));
        }
        for (Move c : moves) {
            assertTrue(String.format("Move %s didn't pass/fail as expected",c.getCmd()),app.runCommand(c.getCmd())==c.isExpectSuccess());

        }
        app.displayBoard();
    }


    @Test
    public void simpleGameNoErrors() throws Exception {
        MainApp app = new MainApp();

        List<Move> moves = Move.moveFactory(Arrays.asList("n453", "w", "w", "P2", "w", "w", "PH", "w"), true);

        for (Move c : moves) {
            assertTrue(String.format("Move %s didn't pass/fail as expected",c.getCmd()),app.runCommand(c.getCmd())==c.isExpectSuccess());

        }

        app.displayBoard();

    }

    @Test
    public void tt() throws Exception {
        playRecordedGame("Move(n123,true):Move(w,true):Move(w,true):Move(w,true):Move(w,true):Move(w,true):Move(2h,true):");

    }
}