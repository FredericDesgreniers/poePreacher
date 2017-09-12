package preacher.poe.api;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class PoeEndpointGetter {
    public static final String BASE_ENDPOINT_URL = "http://www.pathofexile.com/api/";
    
    public static URI getEndpointUri(String apiSectionName){
        try {
            return tryToGetEndpointUri(apiSectionName);
        } catch (URISyntaxException e) {
            e.printStackTrace();
            throw new PoeEndpointGetterException("URI error");
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new PoeEndpointGetterException("URL error");
        }
    }
    
    public static URI tryToGetEndpointUri(String apiSectionName)
        throws MalformedURLException, URISyntaxException {
        return new URL(new URL(BASE_ENDPOINT_URL), apiSectionName).toURI();
    }
}
