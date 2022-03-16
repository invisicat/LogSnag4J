package cc.ricecx.logsnag4j;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LogSnagClientTest {

    private LogSnagClient client;

    @BeforeEach
    void setUp() {
        String testAPIKey = System.getenv("TEST_LOGSNAG_API_KEY");

        assertNotNull(testAPIKey, "API key not found in environment variables");

        client = new LogSnagClient(testAPIKey, "base-test-project");
    }

    @Test
    void log() {
        assertDoesNotThrow(() -> client.log("money-received", "paypal", "$100 has been received!", "💵"));
        assertDoesNotThrow(() -> client.log("money-sent", "paypal", "$15.39 has been withdrawn!", "💵"));
    }

    @Test
    void logCallback() {
        LogSnagRequest event = new LogSnagRequest("money-received", "paypal", "$100 has been received!", "💵");

        assertDoesNotThrow(() -> client.logCallback(event, () -> System.out.println("Logged!")));

    }
}