
/**
 * Décrivez votre classe TestCommand ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class TestCommand extends Command
{
    
    /**
     * Constructeur d'objets de classe TestCommand
     */
    public TestCommand()
    {
        
    }

    public void execute(GameEngine pGameEngine)
    {
            if(!this.hasSecondWord()) {
                pGameEngine.getGui().println("You have add a file name");
            return;
        }
            pGameEngine.test(this.getSecondWord().toLowerCase());
        
    }
}
