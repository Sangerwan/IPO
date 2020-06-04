
/**
 *  An Item is an object usable in the game.
 *  Effect may vary between each Items.
 *
 * @author Erwan SANGCHANMAHOLA
 * @version 0.2
 */
public class Item
{
    
    private int aItemW;
    private String aItemD;
    private String aItemN;
    /**
     * Create Item with name, description and weight
     * @param pN Item's Name.
     * @param pD Item's Description.
     * @param pW Item's Weight.
     */
    

    public Item(final String pN, final String pD, final int pW )
    {
        this.aItemW  = pW;
        this.aItemD = pD;
        this.aItemN = pN;
    } 
    /**
     * @return The Item's weight.
     */
    public int getWeight()
    {
        return this.aItemW;
    } 
    /**
     * @return The Item's Description.
     */
    public String getDescription()
    {
        return this.aItemD;
    } 
    /**
     * @return The Item's Name.
     */
    public String getName()
    {
        return this.aItemN;
    } 
    public void setItemDescription(final String pD){
        this.aItemD=pD;
    }
    /**
     * @return String with the Name, Description, Weight of the Item.
     */
    @Override public String toString(){
        return this.aItemN+": "+this.aItemD+" ("+this.aItemW+" g"+")";
    }
    
}
