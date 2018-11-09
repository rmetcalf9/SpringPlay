package metcarob.com.practice.sol;

import java.util.ArrayList;
import java.util.List;

public class Move {
    public static final String PREFIX = "Move(";
    public static final String POSTFIX = ")";
    public static final String SEPERATOR = ":";

    String cmd = "";
    boolean expectSuccess = false;

    public Move(String cmd, boolean expectSuccess) {
        this.cmd = cmd;
        this.expectSuccess = expectSuccess;
    }
    public Move(String toSetingOutput) {
        String withoutStart = toSetingOutput.substring(PREFIX.length());
        if (withoutStart.endsWith(String.format(",true%s",Move.POSTFIX))) {
            this.expectSuccess = true;
            withoutStart = withoutStart.substring(0,withoutStart.length()-6);
        } else {
            this.expectSuccess = false;
            withoutStart = withoutStart.substring(0,withoutStart.length()-7);
        }
        this.cmd = withoutStart;
    }

    public String getCmd() {
        return cmd;
    }

    public boolean isExpectSuccess() {
        return expectSuccess;
    }

    public static List<Move> moveFactory(List<String> moves, boolean expRes) {
        List<Move> res = new ArrayList<Move>();
        for (String s : moves) {
            Move m = new Move(s, expRes);
            res.add(m);
        }
        return res;
    }

    public String toString() {
        return String.format("%s%s,%b%s%s",Move.PREFIX,this.cmd,this.expectSuccess,Move.POSTFIX,Move.SEPERATOR);
    }

}
