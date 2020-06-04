import java.util.HashMap;
/**
 * Representations for all the valid command words for the game.
 * 
 * @author Erwan SANGCHANMAHOLA
 * @version 0.2
 */
public enum CommandWord
{
    GO("go aller"), QUIT("quit quitter"), HELP("help aide"), EAT("eat manger"), TAKE("take prendre"), DROP("drop laisser"),
    LOOK("look regarder"), ITEMS("items inventaire"), BACK("back retour"), LOCK("lock verouiller"), UNLOCK("unlock deverouiller"),
    TEST("test"),USE("use utiliser"),CHARGE("charge charger"),ALEA("alea"),  UNKNOWN("?");

    
    private String aCommandString;
    private static HashMap<CommandWord,Command> aCommands;
    static{
        
        aCommands=new HashMap<CommandWord,Command>();
        aCommands.put(GO,new GoCommand());
        aCommands.put(QUIT,new QuitCommand());
        aCommands.put(HELP,new HelpCommand());
        aCommands.put(EAT,new EatCommand());
        aCommands.put(TAKE,new TakeCommand());
        aCommands.put(DROP,new DropCommand());
        aCommands.put(LOOK,new LookCommand());
        aCommands.put(ITEMS,new ItemsCommand());
        aCommands.put(BACK,new BackCommand());
        aCommands.put(LOCK,new LockCommand());
        aCommands.put(UNLOCK,new UnlockCommand());
        aCommands.put(TEST,new TestCommand());
        aCommands.put(USE,new UseCommand());
        aCommands.put(CHARGE,new ChargeCommand());
        aCommands.put(ALEA,new AleaCommand());
        aCommands.put(UNKNOWN,null);
    }
    /**
     * Initialise with the corresponding command word.
     * @param commandWord The command string.
     */
    CommandWord(final String pCommandString)
    {
        this.aCommandString = pCommandString;
    }
    public Command getCommand(){
        return aCommands.get(this);
    }
    /**
     * @return The command word as a string.
     */
    public String toString()
    {
        return this.aCommandString;
    }
    /**
     * Verifie si une String donnee fait partie des commandes valides. 
     * @param pString la String a tester
     * @return true si pString est une comande valide, false sinon
     */
    public boolean isCommand()
    {
        return aCommands.containsKey(this);
    } // isCommand()
}
