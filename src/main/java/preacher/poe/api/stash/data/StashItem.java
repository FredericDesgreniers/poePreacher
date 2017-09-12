package preacher.poe.api.stash.data;

import com.google.gson.annotations.SerializedName;

public class StashItem {
    public boolean verified;
    
    @SerializedName("w")
    public int width;
    @SerializedName("h")
    public int h;
    
    @SerializedName("ilvl")
    public int itemLevel;
    
    public String icon;
    public String league;
    public String id;
    
    //TODO sockets
    
    public String name;
    public String typeLine;
    
    public boolean identified;
    public boolean corrupted;
    public boolean lockedToCharacter;
    
    public String note;
    
    public String[] explicitMods;
    public String[] implicitMods;
    public String[] enchantMods;
    public String[] craftedMods;
    public String[] flavorText;
    public int frameType;
    
    public int x;
    public int y;
    
    public String inventoryId;
    public String secDescrText;
    public String descrText;
    
    public String artFilename;
    
    public boolean duplicated;
    
    public int maxStackSize;
    
    public int stackSize;
    public int talismanTier;
    public String[] utilityMods;
    
    public boolean support;
    
    public String[] cosmeticMods;
    
    public String prophecyDiffText;
    public String prophecyText;
    
    public boolean isRelic;
    
}
