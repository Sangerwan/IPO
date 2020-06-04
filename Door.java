

/**
 * Décrivez votre classe Door ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Door
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private boolean aIsLocked;
    private Item aItemNeeded;
    
    
    /**
     * Constructeur d'objets de classe Door
     */
    public Door(final boolean pLocked,final Item pItem)
    {        
        this.aIsLocked=pLocked;
        this.aItemNeeded=pItem;
    }
    public boolean getIsLocked(){
        return this.aIsLocked;
    }
    public Item getItemNeeded(){
        return this.aItemNeeded;
    }
    public void lock(){
        this.aIsLocked=true;
    }
    public void unlock(){
        this.aIsLocked=false;
    }
}
