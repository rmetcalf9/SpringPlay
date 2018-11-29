package metcarob.com.devplay.shoppingbasket;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ShoppingBasketRestController.class)
public class ShoppingBasketRestControllerTest {

    private String emptyBasketRequest = "{\n"+
            "    \"items\": []\n"+
            "}";
    private String emptyBasketResponse = "{\"items\":[]}";

    private String oneItemBasketRequest = "{\n"+
            "    \"items\": [\n"+
            "        {\n"+
            "            \"description\": \"Raspberry Pixxx\",\n"+
            "            \"amount\": {\n"+
            "                \"currenctCode\": \"GBP\",\n"+
            "                \"amount\": 12300\n"+
            "            }\n"+
            "        }\n"+
            "    ]\n"+
            "}";
    private String oneItemBasketResponse = "{\"items\":[{\"description\":\"Raspberry Pixxx\",\"amount\":{\"currenctCode\":\"GBP\",\"amount\":12300}}]}";

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void postShoppingBasketEmptyBasket() throws Exception {

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/shoppingBasket")
                .contentType(MediaType.APPLICATION_JSON)
                .content(emptyBasketRequest);


        MvcResult result = this.mockMvc.perform(builder).andExpect(status().isOk()).andReturn();
        assertEquals(emptyBasketResponse, result.getResponse().getContentAsString());
    }

    @Test
    public void postShoppingBasketSingleItemBasket() throws Exception {

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/shoppingBasket")
                .contentType(MediaType.APPLICATION_JSON)
                .content(oneItemBasketRequest);


        MvcResult result = this.mockMvc.perform(builder).andExpect(status().isOk()).andReturn();
        assertEquals(oneItemBasketResponse, result.getResponse().getContentAsString());

    }

}