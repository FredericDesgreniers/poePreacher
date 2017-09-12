package preacher.utils;

import java.net.URI;
import java.net.URISyntaxException;

public class UriQueryAppender {
    public static URI appendQueryToUri(URI original, String query){
        try {
            return tryAppendQueryToUri(original, query);
        } catch (URISyntaxException e) {
            e.printStackTrace();
            throw new UriQueryAppenderException("Could not append query "+query + " to "+ original.toString());
        }
    }
    
    private static URI tryAppendQueryToUri(URI original, String query) throws URISyntaxException {
        return new URI(original.getScheme(), original.getAuthority(), original.getPath(), query, original.getFragment());
    }
}
