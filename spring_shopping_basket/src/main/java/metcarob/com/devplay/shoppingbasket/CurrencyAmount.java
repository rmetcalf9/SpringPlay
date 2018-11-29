package metcarob.com.devplay.shoppingbasket;

public class CurrencyAmount {
    private String currenctCode;
    private long amount;

    public CurrencyAmount(String currenctCode, long amount) {
        this.currenctCode = currenctCode;
        this.amount = amount;
    }

    public String getCurrenctCode() {
        return currenctCode;
    }

    public long getAmount() {
        return amount;
    }
}
