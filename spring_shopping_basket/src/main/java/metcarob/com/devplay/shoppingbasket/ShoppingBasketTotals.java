package metcarob.com.devplay.shoppingbasket;

public class ShoppingBasketTotals {
    private int DiscountPercentage = 10;
    private CurrencyAmount totalPayable = null;

    public ShoppingBasketTotals(int discountPercentage, CurrencyAmount totalPayable) {
        DiscountPercentage = discountPercentage;
        this.totalPayable = totalPayable;
    }

    public void setDiscountPercentage(int discountPercentage) {
        DiscountPercentage = discountPercentage;
    }

    public void setTotalPayable(CurrencyAmount totalPayable) {
        this.totalPayable = totalPayable;
    }

    public int getDiscountPercentage() {
        return DiscountPercentage;
    }

    public CurrencyAmount getTotalPayable() {
        return totalPayable;
    }
}
