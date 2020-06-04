/**
 *  To play this game, create an instance of this class.
 * 
 *  This main class creates the necessary implementation objects and starts the game off.
 *  
 * @author Erwan SANGCHANMAHOLA
 * @version 0.2
 */

public class Game
{
	private UserInterface aGui;
	private GameEngine aEngine;

    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
		this.aEngine = new GameEngine();
		this.aGui = new UserInterface(this.aEngine);
		this.aEngine.setGUI(this.aGui);
    }
}
