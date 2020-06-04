import java.util.Stack;
import java.util.HashMap;
import java.util.Set;

/**
 * 
 *  A Player is needed to create a game, it contains information about player, the current room, the items carried,...
 * @author Erwan SANGCHANMAHOLA
 * @version 0.2
 */
public class Player
{
    private Room aCurrentRoom;
    private Stack aStackRooms;
    private HashMap<String,Room> aRooms;
    //private HashMap<String,Item> aItems;
    private ItemList aItemList;
    private int aMaxWeight;
    private int aCurrentWeight;
    /**
     * Create a Player
     */
    public Player()
    {
        this.aCurrentRoom=null;
        this.aStackRooms=new Stack();
        this.aRooms=new HashMap<String, Room>();
        this.aItemList=new ItemList();
        this.aMaxWeight=5000;
        this.aCurrentWeight=0;
    }
    /** 
     * Try to go to one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    public boolean move(final Room pRoom) 
    {
        if (pRoom == null){
            return false;
        }
        else {
            this.aStackRooms.push(aCurrentRoom);
            this.aCurrentRoom=pRoom;
            return true;
        }
    }
    public boolean back(){
        if(!(this.aStackRooms.size()>0)){
            return false;
        }
        else if(this.aCurrentRoom.isExit((Room) aStackRooms.peek())){
            this.aCurrentRoom = (Room) aStackRooms.peek();
            this.aStackRooms.pop();
            return true;
        }
        else return false;
    }
    public void eat(final String pItem){
                switch(pItem){
                case "Champignon":
                    this.aMaxWeight*=2;
                    this.aItemList.removeItem("Champignon");
                    break;
                default: 
                    break;
            }
    }
    /**
     * Return an item owned by the Player.
     * @param   pItem The item' String.
     */
    public ItemList getItems(){
        return this.aItemList;
    }
    
    /**
     * Return a string with the Player's items.
     */
    public String getItemListString(){
        return this.aItemList.getItemListString();
    }
     /**
     * Return an item owned by the Player.
     * @param   pItem The item' String.
     */
    public Item getItem(final String pItem){
        return this.aItemList.getItem(pItem);
    }
    
    /**
     * Take an item from the current room and add the item's weight to the player.
     * * @param   pItem The item' String.
     */
    public boolean takeItem(final String pItem){
        Item vItem=this.aCurrentRoom.getItem(pItem);
        if(this.aCurrentWeight+vItem.getWeight() <= aMaxWeight){
            this.aCurrentWeight+=vItem.getWeight();
            this.aItemList.addItem(vItem.getName(),vItem);
            this.aCurrentRoom.removeItem(vItem.getName());
            return true;
        }
        else{
            
            return false;
        }
    }
    /**
     * Use an item and remove the item's weight to the player.
     * * @param   pItem The item' String.
     */
    public void useItem(final String pItem){
        Item vItem= this.aItemList.getItem(pItem);
        switch(pItem){
                case "Beamer":
                    this.aCurrentRoom=((Beamer)vItem).use();
                    break;
                default: 
                    break;
            }
        // this.aCurrentWeight-=vItem.getWeight();
        // this.aItemList.removeItem(vItem.getName());
    }
    /**
     * Drop an item in the current room and remove the item's weight to the player.
     * * @param   pItem The item' String.
     */
    public void dropItem(final String pItem){
        Item vItem= this.aItemList.getItem(pItem);
        this.aCurrentWeight-=vItem.getWeight();
        this.aCurrentRoom.addItem(vItem.getName(),vItem);
        this.aItemList.removeItem(vItem.getName());
    }
    /**
     * Return the Player's weight
     */
    public int getCurrentWeight(){
        return this.aCurrentWeight;
    }
    /**
     * Return the Player's max weight
     */
    public int getMaxWeight(){
        return this.aMaxWeight;
    }
    // /**
     // * Set Player's weight
     // */
    // public void setCurrentWeight(final int pCW){
        // this.aCurrentWeight=pCW;
    // }
    // /**
     // * Set Player's max weight
     // */
    // public void setMaxWeight(final int pMW){
        // this.aMaxWeight=pMW;
    // }
    /**
     * Return the Player's current room
     */
    public Room getCurrentRoom(){
        return this.aCurrentRoom;
    }
    /**
     * Set the Player's current room
     */
    public void setCurrentRoom(final Room pRoom){
        this.aCurrentRoom=pRoom;
    }
    // /**
     // * @return Stack which contains previous rooms
     // */
    // public Stack getStackRooms(){
        // return this.aStackRooms;
    // }
    // /**
     // * @return The last Room registered.
     // */
    // public Object peekStackRooms(){
        // return this.aStackRooms.peek();
    // }
    // /**
     // * Remove the last room registered.
     // */
    // public void popStackRooms(){
        // this.aStackRooms.pop();
    // }

    // /**
     // * Add a Room onto the top of aStackRooms.
     // * @param pA Room to be added to aStackRooms.
     // */
    // public void pushRoom(final Room pA){
        // this.aStackRooms.push(pA);
    // }
}
