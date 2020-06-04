
/**
 * Décrivez votre classe TakeCommand ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class TakeCommand extends Command
{
    
    /**
     * Constructeur d'objets de classe TakeCommand
     */
    public TakeCommand()
    {
    
    }

    public void execute(GameEngine pGameEngine)
    {
            if(!this.hasSecondWord()) {
            
            pGameEngine.getGui().println("Take what?");
            return;
        }
            pGameEngine.take(this.getSecondWord().toLowerCase());
        
    }
}
