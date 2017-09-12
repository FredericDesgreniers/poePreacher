package preacher;

import preacher.poe.api.stash.StashApiPageStream;
import preacher.poe.api.stash.data.Stash;
import preacher.poe.api.stash.data.StashItem;
import preacher.poe.api.stash.data.StashPage;

public class Main {
    public static void main(String[] args){
        try {
            getAllStashPages();
            
        }  catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static void getAllStashPages(){
        StashApiPageStream stashApiPageStream = StashApiPageStream.getStreamWidthLastPageId("94231307-98897277-92965589-107319074-100119458");
        
        StashPage page = stashApiPageStream.getNextStashPage();

        System.out.println("new page size: " + page.stashes.length);
        for (Stash stash : page.stashes) {
            for (StashItem item : stash.items) {
                System.out.println(item.name + " <"+item.typeLine+"> -- lvl"+item.itemLevel);
                System.out.println("\t"+item.descrText + " - "+item.secDescrText);
            }
        }
    }
}
