package metcarob.com.devplay.shoppingbasket;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class ShoppingBasketRestController {

    @RequestMapping(value="/shoppingBasket", method= RequestMethod.POST)
    public ResponseEntity<ShoppingBasket> postShoppingBasket(@RequestBody ShoppingBasket basket) {
        /*
        List<ShoppingBasketItem> items = new ArrayList<ShoppingBasketItem>();

        ShoppingBasketItem i = new ShoppingBasketItem("Raspberry Pi",new CurrencyAmount("GBP",12300));
        items.add(i);

        ShoppingBasket basket = new ShoppingBasket(items);
        */
        return new ResponseEntity<ShoppingBasket>(basket, HttpStatus.OK);
    }
}
