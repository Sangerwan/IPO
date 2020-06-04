import java.util.HashMap;

/**
 * 
 * This class holds an enumeration table of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author Erwan SANGCHANMAHOLA
 * @version 0.2
 */
public class CommandWords
{
    // tableau constant qui contient tous les mots de commande valides
    // private static final String[] sValidCommands = {
            // "go", "quit", "help", "look", "eat" , "back" , "test", "take", "drop", "items"
        // };
    private HashMap<String,CommandWord> aValidCommands;
    /**
     * Constructor - initialise the command words.
     */
    public CommandWords()
    {
        this.aValidCommands = new HashMap<String, CommandWord>();
        for(CommandWord vCommand : CommandWord.values()) {
            if(vCommand != CommandWord.UNKNOWN) {
                for(String vS : vCommand.toString().split(" ")){
                aValidCommands.put(vS, vCommand);
            }
            }
        }
        
    } // CommandWords()
    /**
     * Find the CommandWord associated with a command word.
     * @param commandWord The word to look up.
     * @return The CommandWord correspondng to commandWord, or UNKNOWN
     *         if it is not a valid command word.
     */
    public CommandWord getCommandWord(String commandWord)
    {
        CommandWord vCommand = aValidCommands.get(commandWord);
        
        if(vCommand != null) {
            
            return vCommand;
            
        }
        else {
            
            return CommandWord.UNKNOWN;
        }
    }
    
    /**
     * Verifie si une String donnee fait partie des commandes valides. 
     * @param pString la String a tester
     * @return true si pString est une comande valide, false sinon
     */
    public boolean isCommand( final String pString )
    {
        return aValidCommands.containsKey(pString.toLowerCase());
    } // isCommand()
    /**
     * @return les commandes possibles.
     */
    public String getCommandList(){
        
        String vS="";
        for(String vCommand : aValidCommands.keySet()){
            vS=vS+vCommand+" ";
        }
        return vS;
    }
} // CommandWords