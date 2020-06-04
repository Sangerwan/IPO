
/**
 * Décrivez votre classe UseCommand ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class UseCommand extends Command
{
    
    /**
     * Constructeur d'objets de classe UseCommand
     */
    public UseCommand()
    {
        
    }

    public void execute(GameEngine pGameEngine)
    {
            if(!this.hasSecondWord()) {
                pGameEngine.getGui().println("Use what?");
            return;
        }
            pGameEngine.use(this.getSecondWord().toLowerCase());
        
    }
}
