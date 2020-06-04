
/**
 * Décrivez votre classe DropCommand ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class DropCommand extends Command
{
    

    /**
     * Constructeur d'objets de classe DropCommand
     */
    public DropCommand()
    {
        
    }
    /** 
     * Try to go to one direction. If there is an exit, enter the new
     * room, otherwise print an error message. Returns always 'false'.
     */
    public void execute(GameEngine pGameEngine)
    {
            if(!this.hasSecondWord()) {
            
            pGameEngine.getGui().println("Drop what?");
            return;
        }
            pGameEngine.drop(this.getSecondWord().toLowerCase());
        
    }
    
}
