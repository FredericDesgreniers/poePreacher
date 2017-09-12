package preacher.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class BufferedReaderFromUrl {
    public static BufferedReader getBufferedReader(URL url){
        try{
            return tryToGetBufferedReader(url);
        } catch (IOException e) {
            e.printStackTrace();
            throw new BufferedReaderFromUrlException("Could not get buffered reader from url: "+url.toString());
        }
    }

    private static BufferedReader tryToGetBufferedReader(URL url) throws IOException {
        return new BufferedReader(new InputStreamReader(url.openStream()));
    }
}
