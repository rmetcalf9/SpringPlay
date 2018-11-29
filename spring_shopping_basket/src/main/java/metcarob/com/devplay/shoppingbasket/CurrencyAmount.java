package metcarob.com.devplay.shoppingbasket;

public class CurrencyAmount {
    private String currenctCode;
    private long amount;

    public CurrencyAmount(String currenctCode, long amount) {
        this.currenctCode = currenctCode;
        this.amount = amount;
    }

    public CurrencyAmount() {
    }

    public String getCurrenctCode() {
        return currenctCode;
    }

    public long getAmount() {
        return amount;
    }

    public void setCurrenctCode(String currenctCode) {
        this.currenctCode = currenctCode;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }
}
