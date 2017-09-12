package preacher.poe.api.stash;

import java.net.URI;
import preacher.poe.api.stash.data.StashPage;
import preacher.utils.MapUriJsonToClass;

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
        return MapUriJsonToClass.getClassFromUriJson(stashApiEndpointUri, StashPage.class);
    }
}
