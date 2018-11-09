package metcarob.com.practice.sol;

import org.junit.Test;

public class GameBoardTest {

    @Test
    public void instalisationOfNewGameBoard() throws Exception {
        GameBoard board = new GameBoard();

        System.out.println(board.toString());
        //assertTrue(false);
    }

    @Test
    public void takeThreeCardsFromPile() throws Exception {
        GameBoard board = new GameBoard();

        board.turnCardInPile();
        board.turnCardInPile();
        board.turnCardInPile();

        System.out.println(board.toString());
    }
}