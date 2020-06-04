
/**
 * Décrivez votre classe ChargeCommand ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class ChargeCommand extends Command
{
    
    /**
     * Constructeur d'objets de classe ChargeCommand
     */
    public ChargeCommand()
    {
        
    }
    public void execute(GameEngine pGameEngine)
    {
            if(!this.hasSecondWord()) {
                pGameEngine.getGui().println("Charge what?");
            return;
        }
            pGameEngine.charge(this.getSecondWord().toLowerCase());
        
    }
    
}
