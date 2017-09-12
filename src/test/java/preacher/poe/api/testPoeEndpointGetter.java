package preacher.poe.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.junit.jupiter.api.Test;

import preacher.poe.api.PoeEndpointGetter;

public class testPoeEndpointGetter {
    @Test
    void testGettingAnEndpoint() throws MalformedURLException, URISyntaxException {
        URI endpointUri = PoeEndpointGetter.getEndpointUri("test");
        
        assertEquals(new URL(new URL(PoeEndpointGetter.BASE_ENDPOINT_URL), "test").toURI().toString(), endpointUri.toString());
    }
}
