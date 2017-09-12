package preacher.poe.api.stash;

import java.net.URI;
import preacher.utils.UriQueryAppender;

public class StashApiPageUriGetter {

    private final URI stashApiEndpoint;
    private final String nextChangeId;

    public StashApiPageUriGetter(URI stashApiEndpoint, String nextChangeId){

        this.stashApiEndpoint = stashApiEndpoint;
        this.nextChangeId = nextChangeId;
    }
    
    public URI getUriForStashPage(){
        if(nextChangeId == null){
            return stashApiEndpoint;
        }else{
            return getUriForStashPageWithLastPageId();
        }
    }

    private URI getUriForStashPageWithLastPageId(){
        try{
            return tryGetUriForStashPageWithLastPageId();
        }catch (Exception e){
            e.printStackTrace();
            throw new StashApiPageUriGetterException("Could not get URI for "+stashApiEndpoint+ " and " + nextChangeId);
        }
    }
    
    private URI tryGetUriForStashPageWithLastPageId(){
        return UriQueryAppender.appendQueryToUri(stashApiEndpoint, "id="+nextChangeId);   
    }
    
}
