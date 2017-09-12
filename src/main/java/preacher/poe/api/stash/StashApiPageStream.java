package preacher.poe.api.stash;

import java.net.URI;
import preacher.poe.api.PoeEndpointGetter;
import preacher.poe.api.stash.data.StashPage;

public class StashApiPageStream {
    private URI apiEndpointUri;
    private StashPage lastStashPage;
    
    public StashApiPageStream(){
        try {
            this.apiEndpointUri = PoeEndpointGetter.getEndpointUri("public-stash-tabs");
        }catch(Exception e){
            e.printStackTrace();
            throw new StashApiPageStreamException("Could not get a valid endpoint URI");
        }
    }
    
    public StashPage getNextStashPage(){
        try {
            return tryToGetNextStashPage();
        }catch(Exception e){
            e.printStackTrace();
            throw new StashApiPageStreamException("Could not get stash page");
        }
    }
    
    private StashPage tryToGetNextStashPage(){
        
        URI nextPageEndpointUri = getNextPageEndpointUri();
        StashPage newStashPage = new StashApiPageGetter(nextPageEndpointUri).getStashPage();
        
        lastStashPage = newStashPage;
        
        return newStashPage;
    }
    
    private URI getNextPageEndpointUri(){
        String nextChangeId = getNextChangeId();
        return new StashApiPageUriGetter(apiEndpointUri, nextChangeId).getUriForStashPage();
    }
    
    private String getNextChangeId(){
        if(lastStashPage == null){
            return null;
        }
        
        return lastStashPage.next_change_id;
    }
}
