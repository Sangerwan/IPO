
/**
 * Décrivez votre classe EatCommand ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class EatCommand extends Command
{
    
    /**
     * Constructeur d'objets de classe EatCommand
     */
    public EatCommand()
    {
        
    }

    public void execute(GameEngine pGameEngine)
    {
            if(!this.hasSecondWord()) {
                pGameEngine.getGui().println("Eat what?");
            return;
        }
            pGameEngine.eat(this.getSecondWord().toLowerCase());
        
    }
}
