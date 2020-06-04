
/**
 * Décrivez votre classe BackCommand ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class BackCommand extends Command
{
   
    /**
     * Constructeur d'objets de classe BackCommand
     */
    public BackCommand()
    {
        
    }

    public void execute(GameEngine pGameEngine)
    {
            if(this.hasSecondWord()) {
                pGameEngine.getGui().println("Doesn't need second word!");
            return;
        }
            pGameEngine.back();
        
    }
}
