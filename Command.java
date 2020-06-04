/**
 * A Command can contains up to 2 words
 * 
 * @author Erwan SANGCHANMAHOLA
 * @version 0.2
 */

public abstract class Command
{
    
    private String aSecondWord;

    /**
     * Create a command object. First and second word must be supplied, but
     * either one (or both) can be null. The command word should be null to
     * indicate that this was a command that is not recognised by this game.
     */
    public Command()
    {
        this.aSecondWord = null;
    }


    /**
     * Return the second word of this command. Returns null if there was no
     * second word.
     */
    public String getSecondWord()
    {
        return this.aSecondWord;
    }
    /**
     * Define the second word of this command (the word
     * entered after the command word). Null indicates that 
     * there was no second word.
     */
    public void setSecondWord(String pSecondWord)
    {
        this.aSecondWord = pSecondWord;
    }
    // /**
     // * Return true if this command was not understood.
     // */
    // public boolean isUnknown()
    // {
        // return (this.aCommandWord == CommandWord.UNKNOWN);
    // }

    /**
     * Return true if the command has a second word.
     */
    public boolean hasSecondWord()
    {
        return (this.aSecondWord != null);
    }
    /**
     * Execute this command. A flag is returned indicating whether
     * the game is over as a result of this command.
     * 
     * @return True, if game should exit; false otherwise.
     */
    public abstract void execute(GameEngine pGameEngine);
    
}

