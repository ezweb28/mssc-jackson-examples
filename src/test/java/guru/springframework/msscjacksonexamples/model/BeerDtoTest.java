package guru.springframework.msscjacksonexamples.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@JsonTest
class BeerDtoTest extends BaseTest {

    @Test
    void testSerializeDto() throws JsonProcessingException {
        BeerDto beerDto = getDto();

        String jsonString = objectMapper.writeValueAsString(beerDto);

        System.out.println(jsonString);
    }

    @Test
    void testDeserialize() throws IOException {
        String json = "{\"beerName\":\"BeerName\",\"beerStyle\":\"Ale\",\"upc\":123123123123,\"price\":\"12.99\",\"createdDate\":\"2023-01-17T21:38:09-0500\",\"lastUpdatedDate\":\"2023-01-17T21:38:09.3745219-05:00\",\"myLocalDate\":\"20230117\",\"beerId\":\"48fc3835-8e3c-4b98-b241-f17c7555f18c\"}";

        BeerDto dto = objectMapper.readValue(json, BeerDto.class);

        System.out.println(dto);
    }
}