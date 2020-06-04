import java.util.HashMap;
import java.util.Set;
import java.util.Collection;
/**
 * This class store a list of items.
 *
 * @author Erwan SANGCHANMAHOLA
 * @version 0.2
 */
public class ItemList
{

    private HashMap<String, Item> aItemList;
    
    /**
     * Constructeur par defaut
     */
    public ItemList()
    {
        this.aItemList=new HashMap<String, Item>();
        
    } 
    /**
     * @return Item The item associated with pItem
     * @param pItem The item's name
     */
    public Collection<Item> getAllItem(){
        return this.aItemList.values();
    }
    /**
     * @return Item The item associated with pItem
     * @param pItem The item's name
     */
    public Item getItem(final String pItem){
        return this.aItemList.get(pItem);
    }
    /**
     * 
     * @return Item The String associated with pItem
     * @param pItem The item
     */
    public String getItemName(final Item pItem){
        return this.aItemList.get(pItem).getName();
    }
    /**
     * @return String with the Romm's items.
     */
    public String getItemListString(){
        String vReturnString = "";
        Set<String> vKeys= this.aItemList.keySet();
        for(String vItem : vKeys){
            vReturnString +=vItem+" ";
        }
        return vReturnString;
    }
    /**
     * Add item into the hashmap
     */
    public void addItem(final String pNItem,final Item pItem){
        
        this.aItemList.put(pNItem, pItem);
    }
    /**
     * Remove an Item into the Room
     * @param pNItem String with which the specified Item is to be deleted.
     */
    public void removeItem(final String pNItem){
        this.aItemList.remove(pNItem);
    }
    
}
