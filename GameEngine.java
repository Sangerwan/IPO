import java.util.*;
import java.util.Set;
import java.util.HashMap;
import java.util.Stack;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
/**
 *  This class creates all rooms, creates the parser and starts
 *  the game.  It also evaluates and executes the commands that 
 *  the parser returns.
 *  
 * @author Erwan SANGCHANMAHOLA
 * @version 0.2
 */
public class GameEngine
{
    private Player aPlayer;
    private UserInterface aGui;
    private Parser aParser;
    private HashMap<String,Room> aListRoom;
    private boolean aDevMode;
    /**
     * Constructor for objects of class GameEngine
     */
    public GameEngine()
    {
        this.aPlayer=new Player();
        this.aListRoom= new HashMap<String,Room>();

        this.createRooms();  
        this.aParser=new Parser();
        this.aDevMode=false;
    }

    /**
     * Initialize GUI and print welcome.
     */
    public void setGUI(final UserInterface pUserInterface)
    {
        this.aGui = pUserInterface;
        printWelcome();
    }

    /**
     * Create all the rooms, link their exits together and add some items.
     */
    private void createRooms(){

        Room vEntrance0=new Room("C'est l'endroit où vous vous êtes réveillé(e)","img/0,1.png");
        Room   vMoon1=new Room("C'est l'endroit où vous vous êtes réveillé(e)","img/1.png");
        TransporterRoom   vMoon2=new TransporterRoom("Vous êtes perdus, tous les chemins se ressemblent","img/2.png");
        TransporterRoom    vMoon3=new TransporterRoom("Vous êtes perdus, mais vous avez l'intuition que ce n'est pas par là","img/3.png");
        Room   vMoon4=new Room("Vous êtes perdus, vous apercevez une lumière droit devant!, mais vous ne pourrez plus revenir en arrière","img/4.png");

        Room    vMoon9=new Room("Vous venez de tomber par terre.","img/9.png");
        Room    vMoon11=new Room("Quelque chose ici pourra vous être utile","img/11.png");
        Room    vMoon13=new Room("Vous êtes perdus, mais vous avez l'intuition que ce n'est pas par là","img/13.png");
        Room   vMoon15=new Room("Vous êtes perdus, et vous êtes toujours perdus","img/15.png");

        Room   vMoon10=new Room("Une grande structure se trouve au loin","img/10.png");
        Room   vMoon12=new Room("Vous êtes perdus, cet endroit à l'air abandonné","img/12.png");
        Room   vMoon14=new Room("Vous aperçevez une tour étrange devant vous","img/14.png");
        Room   vMoon16=new Room("Vous êtes perdus, vous apercevez une lumière droit devant!","img/16.png");

        Room    vMoon19=new Room("Vous êtes perdus, et vous êtes toujours perdus","img/19.png");

        Room   vTowerWest17=new Room("C'est le côté ouest de la tour, vous apercevez des motifs étranges","img/17.png");
        Room   vTowerEast18=new Room("C'est le côté est de la tour, vous avez un sentiment de déjà-vu","img/18.png");
        Room   vMoon5=new Room("Vous êtes perdus, et vous êtes toujours perdus","img/5.png");

        Room   vTower6=new Room("Vous ressentez une aura étrange, un teleporteur est devant vous","img/6.png");
        Room   vTower7=new Room("Il est écrit: "+'"'+"ce vaisseau vous permet d'accédez en haut de la tour"+ '"',"img/7.png");
        Room   vTower8=new Room("??????????????????? Quelque chose approche!","img/8.png");

        this.aListRoom.put("0",vEntrance0);
        this.aListRoom.put("1",vMoon1);
        this.aListRoom.put("2",vMoon2);
        this.aListRoom.put("3",vMoon3);
        this.aListRoom.put("4",vMoon4);
        this.aListRoom.put("5",vMoon5);
        this.aListRoom.put("6",vTower6);
        this.aListRoom.put("7",vTower7);
        this.aListRoom.put("8",vTower8);
        this.aListRoom.put("9",vMoon9);
        this.aListRoom.put("10",vMoon10);
        this.aListRoom.put("11",vMoon11);
        this.aListRoom.put("12",vMoon12);
        this.aListRoom.put("13",vMoon13);
        this.aListRoom.put("14",vMoon14);
        this.aListRoom.put("15",vMoon15);
        this.aListRoom.put("16",vMoon16);
        this.aListRoom.put("17",vTowerWest17);
        this.aListRoom.put("18",vTowerEast18);
        this.aListRoom.put("19",vMoon19);

        ArrayList vRandomList2= new ArrayList();
        vRandomList2.add(this.aListRoom.get("1"));
        vRandomList2.add(this.aListRoom.get("2"));
        vRandomList2.add(this.aListRoom.get("3"));
        vMoon2.setRoomList(vRandomList2);
        ArrayList vRandomList3= new ArrayList();
        vRandomList3.add(this.aListRoom.get("1"));
        vRandomList3.add(this.aListRoom.get("2"));
        vRandomList3.add(this.aListRoom.get("3"));
        vRandomList3.add(this.aListRoom.get("4"));
        vMoon3.setRoomList(vRandomList3);

        Item vCaillou = new Item("Rock","d'apparance tout a fait normale", 10 );
        Item vTruc = new Item("Truc","impossible à décrire", 50);
        Item vChampignon = new Item("Champignon","ce champignon augmente votre force, vous pouvez porter plus d'items", 2500);

        Item vFKey1=new Item("False_key","attention ce n'est pas la clé",5000);
        Item vKey2=new Item("Key","c'est la clé",25);
        Item vKey3=new Item("Rock","elle a une forme étrange",2500);
        Item vFKey4=new Item("Rock","elle a une forme carrée",2500);
        Item vFKey5=new Item("Rock","elle a une forme triangulaire",2500);
        Item vFKey6=new Item("Rock","elle a une forme patatoïdale",2500);
        Item vFKey7=new Item("Rock","elle a une forme rectangulaire",2500);

        Beamer vBeamer = new Beamer("Beamer","Use for tp, statuts: ", 500);

        Door vDoor0_1 =new Door(true,vKey2);
        Door vDoor7_8 =new Door(true,vKey3);
        vEntrance0.setExit("north", vMoon1);

        vEntrance0.addItem("Caillou",vCaillou);
        vEntrance0.addItem("Beamer",vBeamer);
        vEntrance0.addItem("Key",vFKey1);
        vEntrance0.addItem(".",vKey2);

        vEntrance0.setDoor("north",vDoor0_1);

        vMoon1.setExit("north", vMoon2);
        vMoon1.setExit("south", vEntrance0);
        vMoon1.setExit("east", vMoon10);
        vMoon1.setExit("west", vMoon9);
        vMoon1.setDoor("south",vDoor0_1);

        vMoon2.setExit("north", vMoon3);
        vMoon2.setExit("south", vMoon1);
        vMoon2.setExit("east", vMoon12);
        vMoon2.setExit("west", vMoon11);

        vMoon3.setExit("north", vMoon4);
        vMoon3.setExit("south", vMoon2);
        vMoon3.setExit("east", vMoon14);
        vMoon3.setExit("west", vMoon13);

        vMoon4.setExit("north", vMoon19);
        vMoon4.setExit("south", vMoon3);
        vMoon4.setExit("east", vMoon16);
        vMoon4.setExit("west", vMoon15);

        vMoon5.setExit("north", vTower6);
        vMoon5.setExit("south", vMoon19);
        vMoon5.setExit("northeast", vTowerEast18);
        vMoon5.setExit("northwest", vTowerWest17);
        vMoon5.addItem("Rock",vFKey4);

        vTower6.setExit("teleporter", vTower7);
        vTower6.setExit("south", vMoon5);
        vTower6.addItem("Rock", vKey3);

        vTower7.setExit("up", vTower8);
        vTower7.setExit("south", vTower6);
        vTower7.setDoor("up", vDoor7_8);
        vTower8.setExit("down", vTower7);

        vMoon9.setExit("north", vMoon11);
        vMoon9.setExit("east", vMoon1);

        vMoon10.setExit("north", vMoon12);
        vMoon10.setExit("west", vMoon1);

        vMoon11.setExit("north", vMoon13);
        vMoon11.setExit("south", vMoon9);
        vMoon11.setExit("east", vMoon2);
        vMoon11.addItem("Champignon", vChampignon);

        vMoon12.setExit("north", vMoon14);
        vMoon12.setExit("south", vMoon10);
        vMoon12.setExit("west", vMoon2);

        vMoon13.setExit("north", vMoon15);
        vMoon13.setExit("south", vMoon11);
        vMoon13.setExit("east", vMoon3);

        vMoon14.setExit("north", vMoon16);
        vMoon14.setExit("south", vMoon12);
        vMoon14.setExit("west", vMoon3);

        vMoon15.setExit("south", vMoon13);
        vMoon15.setExit("east", vMoon4);

        vMoon16.setExit("west", vMoon4);
        vMoon16.setExit("south", vMoon14);

        vTowerWest17.setExit("northeast", vMoon5);
        vTowerWest17.addItem("Rock", vFKey5);
        vTowerEast18.setExit("northwest", vMoon5);
        vTowerEast18.addItem("Rock", vFKey6);

        vMoon19.setExit("north", vMoon5);
        vMoon19.addItem("Rock", vFKey7);

        this.aPlayer.setCurrentRoom(vEntrance0);
    }

    /** 
     * Try to go to one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    public void goRoom(final String vDirection) 
    {
        // if(!pCommand.hasSecondWord()) {
        // // if there is no second word, we don't know where to go...
        // this.aGui.println("Go where?");
        // return;
        // }

        // String vDirection = pCommand.getSecondWord().toLowerCase();

        // // Try to leave current room.
        Room vNextRoom = this.aPlayer.getCurrentRoom().getExit(vDirection);
        test:
        {
            if(this.aPlayer.getCurrentRoom().getDoor(vDirection)!=null){
                if(this.aPlayer.getCurrentRoom().getDoor(vDirection).getIsLocked()){       
                    this.aGui.println("You have to unlock the door first with "+ 
                        this.aPlayer.getCurrentRoom().getDoor(vDirection).getItemNeeded().getName());
                    return;
                }
                else break test;   
            }
        }
        if(this.aPlayer.move(vNextRoom)){
            this.aGui.println(this.aPlayer.getCurrentRoom().getLongDescription());
            if(this.aPlayer.getCurrentRoom().getImageName() != null)
                this.aGui.showImage(this.aPlayer.getCurrentRoom().getImageName());
            return;
        }
        this.aGui.println("There is no door!");
        return;
    }

    public void alea(final String pRoomName){
        if(this.aDevMode&& this.aPlayer.getCurrentRoom().getClass().equals(TransporterRoom.class)){
            ArrayList vR=new ArrayList();
            vR.add(this.aListRoom.get(pRoomName));
            ((TransporterRoom)this.aPlayer.getCurrentRoom()).setRoomList(vR);
        }
    }

    /**
     * Take the player into the previous Room he/she was in.
     */
    public void back() 
    {
        if(this.aPlayer.back()){
            this.aGui.println(aPlayer.getCurrentRoom().getLongDescription());
            if(this.aPlayer.getCurrentRoom().getImageName() != null)
                this.aGui.showImage(this.aPlayer.getCurrentRoom().getImageName());
        }
        else{
            this.aGui.println("You can't go back anymore.");
        }
    }

    /**
     * Print out the opening message for the gui.
     */
    private void printWelcome()
    {
        this.aGui.print("\n");
        this.aGui.println("Welcome to the world of Moonnkown!");
        this.aGui.println("Moonnknown is a new, incredibly boring adventure game.");
        this.aGui.println("Type 'help' if you need help.");
        this.aGui.print("\n");
        printLocationInfo();
    }

    /**
     * Print current Room description.
     */
    private void printLocationInfo(){
        /*if (this.aCurrentRoom.getExit("north")!=null) System.out.println("North");
        if (this.aCurrentRoom.getExit("south")!=null) System.out.println("South");
        if (this.aCurrentRoom.getExit("east")!=null) System.out.println("East");
        if (this.aCurrentRoom.getExit("west")!=null) System.out.println("West");   */

        /*System.out.println(this.aCurrentRoom.getDescription()+"\n");
        System.out.println(this.aCurrentRoom.getExitString());*/
        this.aGui.println(this.aPlayer.getCurrentRoom().getLongDescription());
        this.aGui.showImage(this.aPlayer.getCurrentRoom().getImageName());
    }

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    public void printHelp() 
    {
        this.aGui.println("You are lost. You are alone. You wander");
        this.aGui.println("around on the Moon." + "\n");
        this.aGui.print("Your command words are: " + aParser.showCommands()+"\n");
        this.aGui.print("You can carry a limited weight; your max weight is "+this.aPlayer.getMaxWeight()+"g.");
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    public void quit(){
        this.endGame();

    }

    /**
     * Given a command, process (that is: execute) the command.
     * If this command ends the game, true is returned, otherwise false is
     * returned.
     */
    public void interpretCommand(final String pCommandLine) 
    {

        this.aGui.println(pCommandLine);
        Command vCommand = aParser.getCommand(pCommandLine);

        if(vCommand == null) {
            this.aGui.println("I don't know what you mean...");
        }
        else{
            vCommand.execute(this);
        }

    }

    /**
     * Show your items.
     */
    public void items(){
        this.aGui.println("You are carrying :");
        if(this.aPlayer.getCurrentWeight()!=0){
            String[] vS=this.aPlayer.getItemListString().split(" ");
            for(int i=0;i<vS.length;i++){            
                this.aGui.println(vS[i] +", "+this.aPlayer.getItem(vS[i]).getDescription());
            }
        }
        this.aGui.println(this.aPlayer.getCurrentWeight()+ " g in total.");
    }

    /**
     * It's a cheat code
     * @param pCommand The second word is the name of the cheat file.
     */
    public void test(final String pS){
        this.aDevMode=true;
        String vTxt=pS;

        if(!pS.contains(".txt")){
            aGui.println("Abra,Kadabra");
            vTxt=pS+".txt";
        }
        try{
            Scanner vSc = new Scanner (new File(vTxt));

            while(vSc.hasNextLine()){
                interpretCommand(vSc.nextLine());

            }
        }

        catch(final FileNotFoundException pFNFE){
            this.aGui.println("File not found");
        }
        catch(final Exception pE){
            this.aGui.println( "Exception message -> " + pE.getMessage() );
        }
        finally{

        }

        this.aDevMode=false;
    }

    /**
     * Print out the current Room description into the text area.
     */
    public void unlock(){
        Set<String> vSet=this.aPlayer.getCurrentRoom().getDoorList().keySet();
        Boolean vSomethingHappened=false;
        for(String vS:vSet){
            vSomethingHappened=false;
            if(this.aPlayer.getCurrentRoom().getDoor(vS)!=null){
                for(Item vI : this.aPlayer.getItems().getAllItem()){
                    if(this.aPlayer.getCurrentRoom().getDoor(vS).getItemNeeded()==vI){
                        if(this.aPlayer.getCurrentRoom().getDoor(vS).getIsLocked()){
                            this.aPlayer.getCurrentRoom().getDoor(vS).unlock();
                            this.aGui.println("The "+vS+" door is now unlocked.");
                            if(this.aPlayer.getCurrentRoom()==aListRoom.get("0")){
                                
                                this.aPlayer.getCurrentRoom().setImage("img/0,2.png");
                                this.aGui.showImage(this.aPlayer.getCurrentRoom().getImageName());
                            }
                            vSomethingHappened=true;
                            break;
                        }
                        else{
                            this.aGui.println("The "+vS+" door is already unlocked.");
                            vSomethingHappened=true;
                            break;
                        }
                    }

                }
                if(!vSomethingHappened){
                    this.aGui.println("You need "+this.aPlayer.getCurrentRoom().getDoor(vS).getItemNeeded().getName()
                        +" to unlock the "+vS+" door.");
                    vSomethingHappened=true;
                }
            }
        }
        if(!vSomethingHappened){
            this.aGui.println("There is no door to unlock!");
        }
    }

    public void lock(final String pDirection){

        if(this.aPlayer.getCurrentRoom().getDoor(pDirection)!=null){

            if(!this.aPlayer.getCurrentRoom().getDoor(pDirection).getIsLocked()){
                if(this.playerHasItem(this.aPlayer.getCurrentRoom().getDoor(pDirection).getItemNeeded().getName())){
                    this.aPlayer.getCurrentRoom().getDoor(pDirection).lock();
                    this.aGui.println("The "+pDirection+" door is now locked.");
                    if(this.aPlayer.getCurrentRoom()==aListRoom.get("0")){
                                
                                this.aPlayer.getCurrentRoom().setImage("img/0,1.png");
                                this.aGui.showImage(this.aPlayer.getCurrentRoom().getImageName());
                            }
                }

                else{
                    this.aGui.println("You need "+this.aPlayer.getCurrentRoom().getDoor(pDirection).getItemNeeded().getName()
                        +" to lock the "+pDirection+" door.");
                    return;
                }
            }
            else{
                this.aGui.println("The "+pDirection+" door is already locked.");
                return;
            }

        }
        else{
            this.aGui.println("There is no door in this direction!");
        }
    }

    /**
     * End the game.
     */
    private void endGame()
    {
        this.aGui.println("Thank you for playing.  Good bye.");
        this.aGui.enable(false);
    }

    /**
     * Print out the current Room description into the text area.
     */
    public void look(){
        this.aGui.println(this.aPlayer.getCurrentRoom().getLongDescription());
    }

    private boolean playerHasItem(final String pItem){
        String vItem=pItem.toLowerCase();
        String[] vTest=this.aPlayer.getItemListString().toLowerCase().split(" ");
        for(String vTest2 : vTest){
            if(vTest2.equalsIgnoreCase(vItem)) return true;
        }
        return false;
    }

    private boolean roomHasItem(final String pItem){
        String vItem=pItem.toLowerCase();
        String[] vTest=this.aPlayer.getCurrentRoom().getItemListString().toLowerCase().split(" ");
        for(String vTest2 : vTest){
            if(vTest2.equalsIgnoreCase(vItem)) return true;
        }
        return false;
    }

    /**
     * Charge 
     */
    public void charge(final String pItemName){

        String vItemName = pItemName.substring(0,1).toUpperCase()+pItemName.substring(1).toLowerCase();

        if (!playerHasItem(vItemName))
            this.aGui.println("You don't have this");
        else {

            switch(vItemName){
                case "Beamer":
                ((Beamer)this.aPlayer.getItem(vItemName)).charge(this.aPlayer.getCurrentRoom());
                this.aGui.println(vItemName+" successfully charged."+ '\n'+ "You can teleport here by using it");
                break;   
                default:
                this.aGui.println("Item "+vItemName+" is not usable.");
                break;
            }

        }  
    }

    /**
     * Use 
     */
    public void use(final String pItemName){

        String vItemName = pItemName.substring(0,1).toUpperCase()+pItemName.substring(1).toLowerCase();
        if (!playerHasItem(vItemName))
            this.aGui.println("You don't have this");
        else {

            switch(vItemName){
                case "Beamer":
                if(((Beamer)this.aPlayer.getItem(vItemName)).isCharged()){
                    this.aPlayer.useItem(vItemName);
                    this.aGui.println(vItemName+" successfully used."+ '\n'+ "You get teleported!"+ '\n'+
                        "You need to charge it again if you want to reuse it");
                    this.aGui.println(this.aPlayer.getCurrentRoom().getLongDescription());
                    if(this.aPlayer.getCurrentRoom().getImageName() != null)
                        this.aGui.showImage(this.aPlayer.getCurrentRoom().getImageName());
                    break;   
                }
                else{
                    this.aGui.println("You need to charge it first");
                    break;
                }
                default:
                this.aGui.println("Item "+vItemName+" is not usable.");
                break;
            }  

        }
    }

    /**
     * Eat
     */
    public void eat(final String pItemName){

        String vItemName = pItemName.substring(0,1).toUpperCase()+pItemName.substring(1).toLowerCase();
        if (!playerHasItem(vItemName))
            this.aGui.println("You don't have this");
        else {
            this.aPlayer.eat(vItemName);
            switch(vItemName){
                case "Champignon":

                this.aGui.println(vItemName+" successfully eaten."+ '\n'+ "You can carry more items!");
                break;   

                default:
                this.aGui.println("Item "+vItemName+" is not edible.");
                break;
            }  

        }
    }

    /**
     * Makes the player to take an item
     */
    public void take(final String pItemName){

        String vItemName = pItemName.substring(0,1).toUpperCase()+pItemName.substring(1).toLowerCase();
        if (!roomHasItem(vItemName))
            this.aGui.println("This Item doesn't exist");
        else {
            if(this.aPlayer.takeItem(vItemName)){
                this.aGui.println("Item "+vItemName+" successfully taken.");
            }
            else{
                this.aGui.println("You can no longer carry objects, your inventory is too heavy .");    
            }
        }
    }

    /**
     * Drop item.
     */
    public void drop(final String pItemName){

        String vItemName = pItemName.substring(0,1).toUpperCase()+pItemName.substring(1).toLowerCase();
        if (!playerHasItem(vItemName))
            this.aGui.println("You don't have this Item");
        else {
            this.aPlayer.dropItem(vItemName);
            this.aGui.println("Item "+vItemName+" successfully dropped.");

        }
    }

    public Player getPlayer(){
        return this.aPlayer;
    }

    public UserInterface getGui(){
        return this.aGui;
    }
} // Game
