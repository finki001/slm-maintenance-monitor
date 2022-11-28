package at.fhtw.slmmaintenancemonitor;

import at.fhtw.slmmaintenancemonitor.controller.StatusController;
import at.fhtw.slmmaintenancemonitor.service.StatusService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StatusControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private StatusService statusService;

    @Autowired
    private StatusController statusController;

    @Test
    void testGetStatus() {
        final String message = "Test Message";
        statusService.setMessage(message);
        final String messageResponse = testRestTemplate.getForObject("http://localhost:" + port + "/message", String.class);
        assertEquals(message, messageResponse);
    }

}
