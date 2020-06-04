
/**
 * Décrivez votre classe ItemsCommand ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class ItemsCommand extends Command
{
   

    /**
     * Constructeur d'objets de classe ItemsCommand
     */
    public ItemsCommand()
    {
        
    }

    public void execute(GameEngine pGameEngine)
    {
            if(this.hasSecondWord()) {
            
            pGameEngine.getGui().println("Doesn't need second word!");
            return;
        }
            pGameEngine.items();
        
    }
}
