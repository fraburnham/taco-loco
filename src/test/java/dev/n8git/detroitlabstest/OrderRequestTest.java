package dev.n8git.detroitlabstest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OrderRequestTest extends Assertions {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate api;

    @Test
    public void validOrderShouldReturnTotal() {
        Order order = new Order(0, 1, 0);
        ResponseEntity<String> response = api.postForEntity("http://localhost:" + this.port + "/order", order, String.class);
        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
    }

    @Test
    public void orderWithNegativeItemShouldReturnError() {
        Order order = new Order(-1, 1, 0);
        ResponseEntity<String> response = api.postForEntity("http://localhost:" + this.port + "/order", order, String.class);
        assertEquals(400, response.getStatusCodeValue());
        assertNotNull(response.getBody());
    }

    @Test
    public void orderWithoutItemsShouldReturnError() {
        Order order = new Order(0, 0, 0);
        ResponseEntity<String> response = api.postForEntity("http://localhost:" + this.port + "/order", order, String.class);
        assertEquals(400, response.getStatusCodeValue());
        assertNotNull(response.getBody());
    }
}
