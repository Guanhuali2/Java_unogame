package GUI;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import unogame.*;

public class End {
	game game1;
	String winner; /*the name of winner player */
	
    /*
     * Constructor for end scene
     */
    public End(game game1, String winner){
    	this.game1 = game1;
    	this.winner = winner;
        JFrame window = new JFrame("Initial Game");
        window.setSize(500, 200);
        JPanel npanel = initializePanel();
        window.add(npanel);
        JLabel win = new JLabel("Winner is " + winner + "!");
        win.setBounds(100, 0, 500, 200);
        win.setFont(new java.awt.Font("Dialog", 1, 30));
        win.setForeground(java.awt.Color.red);
        npanel.add(win);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    /*
     * Initialize panel for end scene
     */
    private JPanel initializePanel() {
        JPanel myPanel = new JPanel();
        myPanel.setPreferredSize(new Dimension(500,500));
        myPanel.setLayout(null);
        return myPanel;
    }
    
    
}
