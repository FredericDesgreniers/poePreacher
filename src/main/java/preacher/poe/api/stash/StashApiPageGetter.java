package preacher.poe.api.stash;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.net.MalformedURLException;
import java.net.URI;
import preacher.poe.api.stash.data.StashPage;
import preacher.utils.BufferedReaderFromUrl;
import preacher.utils.BufferedReaderToString;

public class StashApiPageGetter {

    private final URI stashApiEndpointUri;

    public StashApiPageGetter(URI stashApiEndpointUri){
        this.stashApiEndpointUri = stashApiEndpointUri;
    }
    
    public StashPage getStashPage(){
        try {
            return tryToGetStashPage();
        }catch(Exception e){
            e.printStackTrace();
            throw new StashApiPageGetterException("Could not get stash page for uri "+stashApiEndpointUri.toString());
        }
    }
    
    public StashPage tryToGetStashPage(){
        return new Gson().fromJson(getStashPageAsString(), StashPage.class);
    }
    
    private String getStashPageAsString(){
        return BufferedReaderToString.getString(getBufferedReaderForStashPage());
    }

    private BufferedReader getBufferedReaderForStashPage(){
        try {
            return tryGetBufferedReaderForStashPage();
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new StashApiPageStreamException("Could not get buffered reader for uri");
        }
    }

    private BufferedReader tryGetBufferedReaderForStashPage() throws MalformedURLException {
        return BufferedReaderFromUrl.getBufferedReader(stashApiEndpointUri.toURL());
    }


}
