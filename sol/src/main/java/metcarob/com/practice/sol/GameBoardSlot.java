package metcarob.com.practice.sol;

public class GameBoardSlot {
    private Card card = null;
    private boolean visible = false;

    public GameBoardSlot(Card card) {
        this.card = card;
    }

    public void turnCard() {
        visible = true;
    }

    public Card getCard() {
        return card;
    }

    public String boardString() {
        if (visible) return card.boardString();
        return "???  ";
    }

    public boolean isVisible() {
        return visible;
    }
}
