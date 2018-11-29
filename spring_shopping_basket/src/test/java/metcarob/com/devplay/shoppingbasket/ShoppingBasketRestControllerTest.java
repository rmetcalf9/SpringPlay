package metcarob.com.devplay.shoppingbasket;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Date;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
//@WebMvcTest(ShoppingBasketRestController.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ShoppingBasketRestControllerTest {

    private String emptyBasketRequest = "{\n"+
            "    \"items\": []\n"+
            "}";
    private String emptyBasketResponse = "{\"items\":[],\"priceExpiry\":\"1970-01-01T00:00:00.123+0000\",\"totals\":{\"totalPayable\":{\"currenctCode\":\"USD\",\"amount\":0},\"discountPercentage\":10}}";

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
    private String oneItemBasketResponse = "{\"items\":[{\"description\":\"Raspberry Pixxx\",\"amount\":{\"currenctCode\":\"GBP\",\"amount\":12300}}],\"priceExpiry\":\"1970-01-01T00:00:00.123+0000\",\"totals\":{\"totalPayable\":{\"currenctCode\":\"USD\",\"amount\":12300},\"discountPercentage\":10}}";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ShoppingBasketRestController controller;


    @Test
    public void postShoppingBasketEmptyBasket() throws Exception {

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/shoppingBasket")
                .contentType(MediaType.APPLICATION_JSON)
                .content(emptyBasketRequest);


        this.controller.getDateFactory().overrideDate(new Date(123));

        MvcResult result = this.mockMvc.perform(builder).andExpect(status().isOk()).andReturn();
        assertEquals(emptyBasketResponse, result.getResponse().getContentAsString());
    }

    @Test
    public void postShoppingBasketSingleItemBasket() throws Exception {

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/shoppingBasket")
                .contentType(MediaType.APPLICATION_JSON)
                .content(oneItemBasketRequest);

        this.controller.getDateFactory().overrideDate(new Date(123));

        MvcResult result = this.mockMvc.perform(builder).andExpect(status().isOk()).andReturn();
        assertEquals(oneItemBasketResponse, result.getResponse().getContentAsString());

    }

}