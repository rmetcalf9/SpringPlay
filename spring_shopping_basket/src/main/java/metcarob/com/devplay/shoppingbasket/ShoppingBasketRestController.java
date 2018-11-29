package metcarob.com.devplay.shoppingbasket;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class ShoppingBasketRestController {

    @RequestMapping(path="/shoppingBasket", method=POST)
    public String postShoppingBasket() {
        return "ABC";
    }
}
