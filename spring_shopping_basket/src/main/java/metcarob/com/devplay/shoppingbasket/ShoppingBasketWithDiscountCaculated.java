package metcarob.com.devplay.shoppingbasket;

/*
This class will caculate the discount on construction
 */

import java.util.Date;

public class ShoppingBasketWithDiscountCaculated extends ShoppingBasket {
    Date priceExpiry = null;
    ShoppingBasketTotals totals = null;


    public ShoppingBasketWithDiscountCaculated(ShoppingBasket basket) throws Exception {
        this.setItems(basket.getItems());

        String expectedCurrency = "GBP";
        long totalAmountInInputCurrency = 0;
        for (ShoppingBasketItem i : basket.getItems()) {
            if (!expectedCurrency.equals(i.getAmount().getCurrenctCode())) {
                throw new Exception("Input currency must be GBP");
            }
            totalAmountInInputCurrency += i.getAmount().getAmount();
        }

        totals = new ShoppingBasketTotals(10, new CurrencyAmount("USD", totalAmountInInputCurrency));
        priceExpiry = new Date();
    }

    public Date getPriceExpiry() {
        return priceExpiry;
    }

    public ShoppingBasketTotals getTotals() {
        return totals;
    }

    public void setPriceExpiry(Date priceExpiry) {
        this.priceExpiry = priceExpiry;
    }

    public void setTotals(ShoppingBasketTotals totals) {
        this.totals = totals;
    }
}
