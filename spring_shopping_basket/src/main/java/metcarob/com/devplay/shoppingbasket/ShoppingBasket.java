package metcarob.com.devplay.shoppingbasket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShoppingBasket {
    private List<ShoppingBasketItem> items = null;

    public ShoppingBasket(List<ShoppingBasketItem> items) {
        this.items = new ArrayList<ShoppingBasketItem>(items);
    }

    public ShoppingBasket() {
        this.items = new ArrayList<ShoppingBasketItem>();
    }

    public List<ShoppingBasketItem> getItems() {
        return items;
    }

    public void setItems(List<ShoppingBasketItem> items) {
        this.items = items;
    }
}
