
/**
 * Décrivez votre classe LockCommand ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class LockCommand extends Command
{
    

    /**
     * Constructeur d'objets de classe LockCommand
     */
    public LockCommand()
    {
        
    }

    public void execute(GameEngine pGameEngine)
    {
            if(!this.hasSecondWord()) {
                pGameEngine.getGui().println("Which direction?");
            return;
        }
            pGameEngine.lock(this.getSecondWord().toLowerCase());
        
    }
}
