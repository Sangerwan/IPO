
/**
 * Décrivez votre classe QuitCommand ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class QuitCommand extends Command
{
    

    /**
     * Constructeur d'objets de classe QuitCommand
     */
    public QuitCommand()
    {
       
    }

    public void execute(GameEngine pGameEngine)
    {
            if(this.hasSecondWord()) {
            
            pGameEngine.getGui().println("I can't quit that.");
            return;
        }
            pGameEngine.quit();
        
    }
}
