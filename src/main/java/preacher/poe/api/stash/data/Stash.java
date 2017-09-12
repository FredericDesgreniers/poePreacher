package preacher.poe.api.stash.data;

import com.google.gson.annotations.SerializedName;

public class Stash {
    public String accountName;
    public String lastCharacterName;
    public String id;
    
    @SerializedName("stash")
    public String name;
    
    @SerializedName("stashType")
    public String type;
    
    public StashItem[] items;
    
    @SerializedName("public")
    public boolean isPublic;
}
