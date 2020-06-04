
/**
 * Décrivez votre classe Beamer ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Beamer extends Item
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre

    private Room aChargedRoom;
    private boolean aIsCharged;
    /**
     * Constructeur d'objets de classe Beamer
     */
    public Beamer(final String pN, final String pD, final int pW)
    {
        super(pN,pD,pW);
        this.aChargedRoom=null;
        this.aIsCharged=false;
        this.setItemDescription(this.getDescription()+this.state());
    }
    public String state(){
        if(this.isCharged()) return "charged";
        else return "discharged";
    }
    public boolean isCharged(){
        return this.aIsCharged;
    }
    public void charge(final Room pRoom){
        this.aIsCharged=true;
        this.aChargedRoom=pRoom;
        this.setItemDescription(this.getDescription()+this.state());
    }
    public Room use(){
        this.aIsCharged=false;
        this.setItemDescription(this.getDescription()+this.state());
        return this.aChargedRoom;

    }
}
