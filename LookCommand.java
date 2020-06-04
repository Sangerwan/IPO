
/**
 * Décrivez votre classe LookCommand ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class LookCommand extends Command
{
    
    /**
     * Constructeur d'objets de classe LookCommand
     */
    public LookCommand()
    {
       
    }

    public void execute(GameEngine pGameEngine)
    {
            if(this.hasSecondWord()) {
            
            pGameEngine.getGui().println("Doesn't need second word!");
            return;
        }
            pGameEngine.look();
        
    }
}
