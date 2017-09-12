package preacher.utils;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.net.MalformedURLException;
import java.net.URI;

public class MapUriJsonToClass {
    public static <C> C getClassFromUriJson(URI uri, Class<C> classToReturn){
        try {
            return tryToGetClassFromUriJson(uri, classToReturn);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new MapUriJsonToClassException("Could not get class from uri json");
        }
    }
    
    public static <C> C tryToGetClassFromUriJson(URI uri, Class<C> classToReturn)
        throws MalformedURLException {
        BufferedReader urlReader = BufferedReaderFromUrl.getBufferedReader(uri.toURL());
        String jsonText = BufferedReaderToString.getString(urlReader);
        return new Gson().fromJson(jsonText, classToReturn);
    }
}
