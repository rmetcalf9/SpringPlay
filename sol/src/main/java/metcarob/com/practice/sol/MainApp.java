package metcarob.com.practice.sol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainApp {
    GameBoard board = null;
    boolean playing = true;
    List<Move> movesPlayedSoFar = new ArrayList<Move>();

    public void say(String str) {
        System.out.println(str);
    }

    public void run(String[] args) throws Exception {
        playing = true;
        say("Welcome to my Sol App");

        while (playing) {
            displayBoard();
            String cmd = inputCommand();
            movesPlayedSoFar.add(new Move(cmd,runCommand(cmd)));
        }

        say("Thanks for Playing");

    }

    //Given a 1 char string return it's col or -1 for invalid
    private static int getColumn(String s) {
        int i = -1;
        try {
            i = Integer.parseInt(s);
        } catch (Exception e) {
            return -1;
        }
        if (i>GameBoardMainArea.NUMCOLS) {
            return -1;
        }
        if (i<1) {
            return -1;
        }
        return i;
    }

    public boolean runCommand(String cmd) throws Exception {
        cmd = cmd.toUpperCase();
        if (cmd.equals("Q")) {
            playing = false;
            return true;
        }
        if (cmd.equals("N")) {
            board = new GameBoard();
            return true;
        }
        if (cmd.substring(0,1).equals("N")) {
            long seed = Long.parseLong(cmd.substring(1));
            board = new GameBoard(seed);
            return true;
        }
        if (cmd.equals("O")) {
            say("");
            String s = "Output all moves\n";
            for (Move m : this.movesPlayedSoFar) {
                s += m.toString();
            }
            say(s);
            say("");
            return true;
        }

        if (board!=null) {
            if (cmd.equals("W")) {
                board.turnCardInPile();
                return true;
            }
            if (cmd.equals("T")) {
                //board.turnCardInPile();
                //TODO
                return true;
            }
            if (cmd.length()==2) {
                if (cmd.equals("PH")) {
                    if (!board.isCardReadyToMoveFromPile()) {
                        say("There is no card in pile");
                        return false;
                    }
                    if (!board.moveCardFromPileToHome()) {
                        say("Invalid Move");
                        return false;
                    }
                    return true;
                }
                if (cmd.substring(0,1).equals("P")) {
                    int colToMoveTo = MainApp.getColumn(cmd.substring(1, 2));
                    if (colToMoveTo == -1) {
                        say("Invalid Column");
                        return false;
                    }
                    if (!board.isCardReadyToMoveFromPile()) {
                        say("There is no card in pile");
                        return false;
                    }
                    if (!board.moveCardFromPileToCol(colToMoveTo-1)) {
                        say("Invalid move");
                        return false;
                    }
                    return true;
                }
                if (cmd.substring(1,2).equals("H")) {
                    int colToMoveFrom = MainApp.getColumn(cmd.substring(0, 1));
                    if (colToMoveFrom == -1) {
                        say("Invalid Column");
                        return false;
                    }
                    if (!board.moveCardFromColToHome(colToMoveFrom-1)) {
                        say("Invalid move");
                        return false;
                    }
                    return true;
                }
            }
        }
        say("Unrecognised command");
        say( "n = new game");
        say( "w = turn");
        say( "p1-7 = move card from pile to col 1-7");
        say( "ph = move card from pile to home");
        say( "1-7h = move card from col 1-7 to home");
        say( "t = turn cards over (if possible)");
        say( "o = output all moves you played (Used for testing");
        say( "q = quit");
        return false;
    }

    private String inputCommand() throws IOException {
        System.out.print("?:");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String s = br.readLine();
        return s;

    }

    public void displayBoard() {
        System.out.println("\n");
        if (board == null) {
            return;
        }
        System.out.println(board.toString());
    }


    public static void main(String[] args) {
        MainApp ma = new MainApp();
        try {
            ma.run(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
