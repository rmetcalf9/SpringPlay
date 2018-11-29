package metcarob.com.devplay.shoppingbasket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShoppingBasket {
    private List<ShoppingBasketItem> items = null;

    public ShoppingBasket(List<ShoppingBasketItem> items) {
        this.items = new ArrayList<ShoppingBasketItem>(items);
    }
}
