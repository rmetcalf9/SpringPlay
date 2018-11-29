package metcarob.com.devplay.shoppingbasket.CurrencyServices;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Iterator;

/*
Fixer IO currency exchange provider
 */
@Component
public class FixerIO implements CurrencyRateSource {

    @Value("${userBucket.fixerio.apikey}")
    private String apikey;


    @Override
    public RateList getRateLists() throws Exception {
        RestTemplate rt = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://data.fixer.io/api/latest")
                .queryParam("access_key", this.apikey);

        HttpEntity<?> entity = new HttpEntity<>(headers);

        HttpEntity<String> response = rt.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                entity,
                String.class);

        if (((ResponseEntity<String>) response).getStatusCode().value() != 200) {

            throw new Exception(String.format("Bad resp status: %d %s",((ResponseEntity<String>) response).getStatusCode().value(),response.getBody()));
        }

        //create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        //read JSON like DOM Parser
        JsonNode rootNode = objectMapper.readTree(response.getBody());
        JsonNode idNode = rootNode.path("success");
        if (!idNode.asBoolean()) {
            throw new Exception(response.getBody());
        }

        /*
        System.out.println("id = "+idNode.asBoolean());

        JsonNode phoneNosNode = rootNode.path("phoneNumbers");
        Iterator<JsonNode> elements = phoneNosNode.elements();
        while(elements.hasNext()){
            JsonNode phone = elements.next();
            System.out.println("Phone No = "+phone.asLong());
        }

        System.out.println(response.getBody());
        */
        RateList rl = new RateList();
        return rl;
    }
}
