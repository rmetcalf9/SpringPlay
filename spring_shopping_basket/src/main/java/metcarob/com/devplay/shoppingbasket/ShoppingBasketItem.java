package metcarob.com.devplay.shoppingbasket;

public class ShoppingBasketItem {
    private String description;
    private CurrencyAmount amount;

    public ShoppingBasketItem(String description, CurrencyAmount amount) {
        this.description = description;
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public CurrencyAmount getAmount() {
        return amount;
    }
}
