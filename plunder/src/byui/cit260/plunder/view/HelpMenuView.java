/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.plunder.view;

/**
 *
 * @author abigailking
 */
public class HelpMenuView extends View {

    public HelpMenuView() {
        
    }

    @Override
    public String[] getInputs() {
        //declare new
        String [] inputs = new String[1];

        //retrive inputs from user
        this.console.println("    G - What is the goal of the game?\n" +
                             "    M - How to move\n" +
                             "    C – How to engage in combat\n" +
                             "    T – How to trade \n" +
                             "    S - Save game\n" +
                             "    R - Restart game\n" +
                             "    Q - Quit help menu");
        
        String input = this.getInput("Select a menu item");
        inputs [0] = input;
        return inputs;
    }

    @Override
    public boolean doAction(String[] inputs) {
        switch(inputs[0]){
         case "G":                   
               this.console.println(
                                  "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"
                                + "  Ye be a pirate Captain sailing the seas of Paradise. \n"
                                + "  Others on yer ship tell tales of treasure on a near by \n"
                                + "  island. Yer goal is to take the treasure first,  \n"
                                + "  before anyone else reaches it. Good luck! \n"
                                + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
             break;

         case "M":
               this.console.println(
                                  "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"
                                + "  Yer ship is the method that ye can explore the map. \n"
                                + "  Gander at yer map and choose a direction. \n"
                                + "  Input the cardinal direction ye desire and off ye go.  \n"
                                + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
             break;

         case "C":
               this.console.println(
                                  "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"
                                + "  If perchance ye find something in the waters of Paradise, \n"
                                + "  ye can blast them out of the water with yer cannons on \n"
                                + "  board, simply choose how ye will attack.\n"
                                + "  Be it reckless, ye may land more damange on yer opponent.\n"
                                + "  Be it aimed, ye may more likely hit yer opponent.\n"
                                + "  Be it careful, ye make it hard for yer opponent to hit ye.\n"
                                + "  Choose carefully, lest ye find yer selves in Davy Jones' locker.\n"
                                + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
             break;

         case "T":
               this.console.println(
                                  "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"
                                + "  On the islands there may be a trader for ye to see \n"
                                + "  If ye have any booty, ye may sell it for gold. \n"
                                + "  Look around to see what the trader may have for ye. \n"
                                + "  Buy it up with yer gold.  \n"
                                + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
             break;

         case "S":
               this.console.println(
                                  "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"
                                + "  This be simple. Open the main menu and chose to save. \n"
                                + "  Yer time, yer map, yer discoveries be waiting for ya, \n"
                                + "  for the next time ye return to the waters of Paradise.  \n"
                                + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
             break;

         case "R":
               this.console.println(
                                  "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"
                                + "  Treasure, adventure, and all yer discoveries from before \n"
                                + "  await ye on the main menu. Load a previous game \n"
                                + "  and contine on! Have fun! We are glad ye are back.  \n"
                                + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
             break;

         case "Q":
             return true;
             
         default:
             this.console.println("Invalid Menu Item");
                    
        }
     return false;
    }
}
