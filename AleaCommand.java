
/**
 * Décrivez votre classe AleaCommand ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class AleaCommand extends Command
{
    
    /**
     * Constructeur d'objets de classe AleaCommand
     */
    public AleaCommand()
    {
        
    }

    public void execute(GameEngine pGameEngine)
    {
            if(!this.hasSecondWord()) {
            return;
        }
            pGameEngine.alea(this.getSecondWord().toLowerCase());
        
    }
}
