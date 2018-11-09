package metcarob.com.practice.sol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainApp {
    GameBoard board = null;
    boolean playing = true;

    public void say(String str) {
        System.out.println(str);
    }

    public void run(String[] args) throws Exception {
        playing = true;
        say("Welcome to my Sol App");

        while (playing) {
            displayBoard();
            String cmd = inputCommand();
            runCommand(cmd);
        }

        say("Thanks for Playing");

    }

    private void runCommand(String cmd) throws Exception {
        cmd = cmd.toUpperCase();
        if (cmd.equals("Q")) {
            playing = false;
            return;
        }
        if (cmd.equals("N")) {
            board = new GameBoard();
            return;
        }

        if (board!=null) {
            if (cmd.equals("W")) {
                board.turnCardInPile();
                ;
                return;
            }
            if (cmd.length()==2) {
                if (cmd.equals("PH")) {
                    if (!board.isCardReadyToMoveFromPile()) {
                        say("There is no card in pile");
                        return;
                    }
                    if (!board.moveCardFromPileToHome()) {
                        say("Invalid Move");
                        return;
                    }
                    return;
                }
                if (cmd.substring(0,1).equals("P")) {
                    int colToMoveTo = 0;
                    try {
                        colToMoveTo = Integer.parseInt(cmd.substring(1, 2));
                    } catch (Exception e) {
                        say("Invalid Column");
                        return;
                    }
                    if (colToMoveTo>GameBoardMainArea.NUMCOLS) {
                        say("Invalid Column");
                        return;
                    }
                    if (colToMoveTo<1) {
                        say("Invalid Column");
                        return;
                    }
                    if (!board.isCardReadyToMoveFromPile()) {
                        say("There is no card in pile");
                        return;
                    }
                    if (!board.moveCardFromPileToCol(colToMoveTo-1)) {
                        say("Invalid move");
                        return;
                    }
                    return;
                }
            }
        }
        say("Unrecognised command");
        say( "n = new game");
        say( "w = turn");
        say( "p1-7 = move card from pile to col 1-7");
        say( "ph = move card from pile to home");
        say( "q = quit");
    }

    private String inputCommand() throws IOException {
        System.out.print("?:");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String s = br.readLine();
        return s;

    }

    private void displayBoard() {
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
