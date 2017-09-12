package preacher;

import preacher.poe.api.stash.StashApiPageStream;
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
        StashApiPageStream stashApiPageStream = new StashApiPageStream();
        
        while(true){
            StashPage page = stashApiPageStream.getNextStashPage();

            System.out.println("new page size: " + page.stashes.length);

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
