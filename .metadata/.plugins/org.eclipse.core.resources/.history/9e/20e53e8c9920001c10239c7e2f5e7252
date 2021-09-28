package GUI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import unogame.*;

public class GuiGame {
	static GuiGame uno;
	public game game1;
	
    /*
     * constructor for game initialize scene
     */
    public GuiGame(){
    	game1 = new game(1);
        JFrame window = new JFrame("Initial Game");
        window.setSize(500, 500);
        JPanel npanel = initializePanel();
        window.add(npanel);
        
        
        JButton button = new JButton("Initialize Game");
        button.setBounds(50,200,400,100);
        npanel.add(button);
        button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				window.dispose();
		    	new GuiAddPlayer(game1);
			}
   
        });
        
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    /*
     * Initialize panel for game initialize scene
     */
    private JPanel initializePanel() {
        JPanel myPanel = new JPanel();
        myPanel.setPreferredSize(new Dimension(500,500));
        myPanel.setLayout(null);
        return myPanel;
    }
    
    public static void main(String[] args) {
        uno = new GuiGame();
    }

}
