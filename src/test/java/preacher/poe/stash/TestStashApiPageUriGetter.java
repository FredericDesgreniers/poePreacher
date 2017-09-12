package preacher.poe.stash;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import preacher.poe.api.PoeEndpointGetter;
import preacher.poe.api.stash.StashApiPageUriGetter;
import preacher.poe.api.stash.data.StashPage;
import preacher.utils.UriQueryAppender;

public class TestStashApiPageUriGetter {
    static URI stashApiEndpoint;
    
    @BeforeAll
    static void initAll(){
        stashApiEndpoint = PoeEndpointGetter.getEndpointUri("stash");
    }
    
    @Test
    void testGetUriForStashPageWithoutNextChangeId(){
        String actualUriString = new StashApiPageUriGetter(stashApiEndpoint, null).getUriForStashPage().toString();
        
        assertEquals(stashApiEndpoint.toString(),actualUriString);
    }

    @Test
    void testGetUriForStashPageWithNextChangeId(){
        String actualUriString = new StashApiPageUriGetter(stashApiEndpoint, "111-111").getUriForStashPage().toString();

        assertEquals(UriQueryAppender.appendQueryToUri(stashApiEndpoint, "id="+"111-111").toString(), actualUriString); 
    }
}
