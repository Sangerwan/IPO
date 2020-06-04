import java.util.Iterator;
import java.util.HashMap;
import java.util.Set;

/**
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits and may possess items.  For each existing exit, the room 
 * stores a reference to the neighboring room.
 * 
 * @author Erwan SANGCHANMAHOLA
 * @version 0.2
 */
public class Room
{
    /*private Room aNorthExit;
    private Room aSouthExit;
    private Room aEastExit;
    private Room aWestExit;
     */
    
    private String aDescription;
    private HashMap<String, Room> aExits;
    private HashMap<String,Door> aDoors;
    private String aImageName;
    //private HashMap<String, Item> aItems;
    private ItemList aItems;
    /**
     * Create a room described "description" with a given image. 
     * Initially, it has no exits. "description" is something like 
     * "in a kitchen" or "in an open court yard".
     */
    public Room(final String pDescription,final String pImage)
    {
        this.aDescription=pDescription;
        this.aExits=new HashMap<String,Room>();
        this.aDoors=new HashMap<String,Door>();
        this.aImageName = pImage;
        this.aItems=new ItemList();
    }
    /**
     * @return The Room's description.
     */
    public String getDescription(){
        return this.aDescription;
    }
    /**
     * Defines an exit from this room.
     */
    public void setDoor(final String pDirection,final Door pDoor){
        this.aDoors.put(pDirection,pDoor);
    }
    /**
     * Return the door that is reached if we go from this room in direction
     * "direction". If there is no door in that direction, return null.
     */
    public Door getDoor(final String pDirection){
        return this.aDoors.get(pDirection);
    }
    /**
     * Defines an exit from this room.
     */
    public void setExit(final String pDirection,final Room pNeighbor){
        /*this.aNorthExit=pNorthExit;
        this.aSouthExit=pSouthExit;
        this.aEastExit=pEastExit;
        this.aWestExit=pWestExit;*/
        /*if(pNorth!=null) this.aExits.put("north", pNorth);
        if(pSouth!=null) this.aExits.put("south", pSouth);
        if(pEast!=null) this.aExits.put("east", pEast);
        if(pWest!=null) this.aExits.put("west", pWest);
         */
        
        this.aExits.put(pDirection, pNeighbor);
    }
    public boolean isExit(final Room pRoom){
        return this.aExits.containsValue(pRoom);
    }
    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     */
    public Room getExit(final String pDirection){
        /*if(pDirection.equals("north")) return aNorthExit;
        if(pDirection.equals("south")) return aSouthExit;
        if(pDirection.equals("east")) return aEastExit;
        if(pDirection.equals("west")) return aWestExit;
        System.out.println("Unknown direction !");
        return null;
         */
        
        return this.aExits.get(pDirection);
    }
    
    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     */
    public String getExitString(){
        /*String vString="Exits";
        if (this.getExit("north")!=null) vString=vString+"North ";
        if (this.getExit("south")!=null) vString=vString+"South ";
        if (this.getExit("east")!=null) vString=vString+"East ";
        if (this.getExit("west")!=null) vString=vString+"West ";
        if (this.getExit("up")!=null) vString=vString+"Up ";
        if (this.getExit("down")!=null) vString=vString+"Down ";
        return vString;*/
        
        String vReturnString = "Exits:";
        Set<String> vKeys= this.aExits.keySet();
        for(String vExits : vKeys){
            vReturnString +=" "+ vExits;
        }
        return vReturnString;
    }
    /**
     * Return a string with the Romm's items.
     */
    public HashMap getDoorList(){
        return this.aDoors;
    }
    /**
     * @return Retrun Room description with exits.
     */
    public String getLongDescription(){
        return this.aDescription + 
        ".\n" + this.getExitString() +
        ".\n" + this.getItemListString();
    }
    /**
     * Return a string with the Romm's items.
     */
    public String getItemListString(){
        return "Item(s): "+this.aItems.getItemListString();
    }
    /**
     * Return a string describing the room's image name
     */
    public String getImageName()
    {
        return this.aImageName;
    }    
    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     */
    public Item getItem(final String pItem){
        return this.aItems.getItem(pItem);
    }
    /**
     * Return a string describing the room's image name
     */
    public String getItemName(final Item pItem)
    {
        return this.aItems.getItemName(pItem);
    }
    /**
     * Place an Item into the Room
     * @param pNItem String with which the specified Item is to be associated.
     * @param pItem Item to be associated with the specified String.
     */
    public void addItem(final String pNItem,final Item pItem){
        
        this.aItems.addItem(pNItem, pItem);
    }
    /**
     * Remove an Item into the Room
     * @param pNItem String with which the specified Item is to be deleted.
     */
    public void removeItem(final String pNItem){
        
        this.aItems.removeItem(pNItem);
    }
    public void setImage(final String pImage){
        this.aImageName=pImage;
    }
} // Room
