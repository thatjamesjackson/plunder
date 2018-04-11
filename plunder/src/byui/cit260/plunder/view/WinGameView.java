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
public class WinGameView extends View {
    
    @Override
    public String[] getInputs() {
        // display menu
        this.console.println(
"================================================================\n"
+"                             _.--.\n" +
 "                        _.-'_:-'||\n" +
 "                    _.-'_.-::::'||\n" +
 "               _.-:'_.-::::::'  ||\n" +
 "             .'`-.-:::::::'     ||\n" +
 "            /.'`;|:::::::'      ||_\n" +
 "           ||   ||::::::'     _.;._'-._\n" +
 "           ||   ||:::::'  _.-!oo @.!-._'-.\n" +
 "           \\'.  ||:::::.-!()oo @!()@.-'_.|\n" +
 "            '.'-;|:.-'.&$@.& ()$%-'o.'|U||\n" +
 "              `>'-.!@%()@'@_%-'_.-o _.|'||\n" +
 "               ||-._'-.@.-'_.-' _.-o  |'||\n" +
 "               ||=[ '-._.-/U/.-'    o |'||\n" +
 "               || '-.]=|| |'|      o  |'||\n" +
 "               ||      || |'|        _| ';\n" +
 "               ||      || |'|    _.-'_.-'\n" +
 "               |'-._   || |'|_.-'_.-'\n" +
 "            jgs '-._'-.|| |' `_.-'\n" +
 "                    '-.||_/.-'\n\n"
+ "================================================================\n"
+ "       Are ya gonna take the treasure for yerself?");
        //declare new
        String [] inputs = new String[1];
        
        // retrieve input from user
        String input = this.getInput(
"                      Yea or Nae?");
        inputs [0] = input;
        return inputs;
    }

    @Override
    public boolean doAction(String[] inputs) {
        // do things
        return false;
    }
    
}
