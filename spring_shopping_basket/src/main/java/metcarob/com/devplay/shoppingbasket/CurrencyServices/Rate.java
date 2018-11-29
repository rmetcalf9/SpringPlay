package metcarob.com.devplay.shoppingbasket.CurrencyServices;

public class Rate {
    String currency = "";
    long amount = 0;  //Divide by 1000000 for actual rate

    public Rate() {
    }

    public String getCurrency() {
        return currency;
    }

    public long getAmount() {
        return amount;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

}
