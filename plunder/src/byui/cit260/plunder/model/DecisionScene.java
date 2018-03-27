/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.plunder.model;

import byui.cit260.plunder.view.View;

/**
 *
 * @author James
 */
public class DecisionScene extends RegularScene{
    
    private View nextView;

    public DecisionScene() {
    }

    public DecisionScene( String description, String mapSymbol,  View nextView) {
        super(description, mapSymbol);
        
        this.nextView = nextView;
    }

    public View getNextView() {
        return nextView;
    }

    public void setNextView(View nextView) {
        this.nextView = nextView;
    }


   

   
}
