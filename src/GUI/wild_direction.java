package GUI;

import unogame.*;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class wild_direction {
	static game game1; /*main game*/
	unocard.Color color;  /* color picked */
	unocard card; /* card to play*/
	GuiMain main; /*main GUI*/
	static ArrayList<Integer> Ai = new ArrayList<Integer>(); /*list that contains AI player's index*/
	static ArrayList<Integer> Ai_base = new ArrayList<Integer>();/*list that contains basic AI players index*/
	static JButton right;
	/*
	 * constructor for choose direction when use a wild card
	 */
    public wild_direction(GuiMain main, unocard card, game game1, unocard.Color color1,	ArrayList<Integer> Ai, ArrayList<Integer> Ai_base){
    	this.color = color1;
    	this.card = card;
    	this.main = main;
        JFrame window = new JFrame("wild_directs");
        window.setSize(500, 200);
        JPanel npanel = initializePanel();
        window.add(npanel);
        
        JButton left = new JButton("");
        ImageIcon lefticon = new ImageIcon(getClass().getResource("../unogame/image/left.png"));
        Image leftimg = lefticon.getImage();
        Image leftnewimg = leftimg.getScaledInstance(120, 150, java.awt.Image.SCALE_SMOOTH);
        left.setIcon(new ImageIcon(leftnewimg));
        npanel.add(left);
        left.addActionListener(e->
        	{
        		window.dispose();
        		game1.play_wild(card,color,false);
				main.update();
        	}
        );
        
        right = new JButton("");
        ImageIcon icon = new ImageIcon(getClass().getResource("../unogame/image/right.png"));
		Image img = icon.getImage();
		Image newimg = img.getScaledInstance(120,150,java.awt.Image.SCALE_SMOOTH); 
        right.setIcon(new ImageIcon(newimg));
        npanel.add(right);
        right.addActionListener(e->
    	{
    		window.dispose();
    		game1.play_wild(card,color,true);
			main.update();
    	}
    );
       
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
		int cur = game1.get_currplayer();
		if (Ai.contains(cur)) {
			right.doClick();
		}
		if (Ai_base.contains(cur)) {
			right.doClick();
		}
    }
    
    /*
     * initialize panel for this scene
     */
    private JPanel initializePanel() {
        JPanel myPanel = new JPanel();
        myPanel.setPreferredSize(new Dimension(500,200));
        myPanel.setLayout(new FlowLayout(FlowLayout.CENTER,20,5));
        return myPanel;
    }
    
    public static void main(String[] args) {

    }
}