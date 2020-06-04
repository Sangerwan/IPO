import java.util.ArrayList;
import java.util.*;
/**
 * Décrivez votre classe TransporterRoom ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class TransporterRoom extends Room
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private RoomRandomizer aRoomRandomizer;
    /**
     * Constructeur d'objets de classe TransporterRoom
     */
    public TransporterRoom(final String pDescription,final String pImage)
    {
        super(pDescription,pImage);

        this.aRoomRandomizer=new RoomRandomizer(new ArrayList());
    }
    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     */
    public Room getExit(final String pDirection){
        return this.getRandomRoom();
    }                                                                         
    public void setRoomList(final List pListRoom){
        this.aRoomRandomizer.setRoomList(pListRoom);
    }
    private Room getRandomRoom(){
        return this.aRoomRandomizer.getRandom();
    }
}
