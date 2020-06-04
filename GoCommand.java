
/**
 * Décrivez votre classe GoCommand ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class GoCommand extends Command
{
    

    /**
     * Constructeur d'objets de classe GoCommand
     */
    public GoCommand()
    {
        
    }

    /** 
     * Try to go to one direction. If there is an exit, enter the new
     * room, otherwise print an error message. Returns always 'false'.
     */
    public void execute(GameEngine pGameEngine)
    {
            if(!this.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            pGameEngine.getGui().println("Go where?");
            return;
        }
            pGameEngine.goRoom(this.getSecondWord().toLowerCase());
        
    }
}
