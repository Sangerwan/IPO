import java.util.ArrayList;
import java.util.Random;
import java.util.*;
/**
 * Décrivez votre classe RoomRandomizer ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class RoomRandomizer
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private ArrayList aListRoom;

    /**
     * Constructeur d'objets de classe RoomRandomizer
     */
    public RoomRandomizer(final ArrayList pListRoom)
    {
        this.aListRoom=pListRoom;
    }
    public void setRoomList(final List pListRoom){
        this.aListRoom=(ArrayList)pListRoom;
    }
    /**
     * Un exemple de méthode - remplacez ce commentaire par le vôtre
     *
     * @param  y   le paramètre de la méthode
     * @return     la somme de x et de y
     */
    public Room getRandom()
    {
        Random vR=new Random();
        return (Room)this.aListRoom.get(vR.nextInt(this.aListRoom.size()));
    }
}
