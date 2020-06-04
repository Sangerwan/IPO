
/**
 * Décrivez votre classe UnlockCommand ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class UnlockCommand extends Command
{
    
    /**
     * Constructeur d'objets de classe UnlockCommand
     */
    public UnlockCommand()
    {
        
    }

    public void execute(GameEngine pGameEngine)
    {
            if(this.hasSecondWord()) {
                pGameEngine.getGui().println("Doesn't need second word!");
            return;
        }
            pGameEngine.unlock();
        
    }
}
