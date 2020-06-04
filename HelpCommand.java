
/**
 * Décrivez votre classe HelpCommand ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class HelpCommand extends Command
{
    
    /**
     * Constructeur d'objets de classe HelpCommand
     */
    public HelpCommand()
    {
        
    }

    public void execute(GameEngine pGameEngine)
    {
            if(this.hasSecondWord()) {
                pGameEngine.getGui().println("Doesn't need second word!");
            return;
        }
            pGameEngine.printHelp();
        
    }
}
