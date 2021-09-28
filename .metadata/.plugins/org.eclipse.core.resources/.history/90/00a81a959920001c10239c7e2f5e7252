package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import unogame.*;

public class wild_color {
	static game game1; /* main game */
	unocard card; /* card for this scene to play */
	GuiMain main; /* main GUI */
	static ArrayList<Integer> Ai = new ArrayList<Integer>(); /*list that contains AI player's index*/
	static ArrayList<Integer> Ai_base = new ArrayList<Integer>();/*list that contains basic AI players index*/
	/**
	 * constructor for choosing color when use wild scene
	 */
    public wild_color(GuiMain main,game game1, unocard card, ArrayList<Integer> Ai, ArrayList<Integer> Ai_base){
    	this.card = card;
    	this.main = main;
        JFrame window = new JFrame("wild_color");
        window.setSize(500, 200);
        JPanel npanel = initializePanel();
        window.add(npanel);
        
        JButton red = new ColorButton("Red", Color.RED, 100, 150);
        red.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				window.dispose();
				new wild_direction(main,card,game1, unocard.Color.RED, Ai, Ai_base);
			}
        	
        });
        npanel.add(red);
        
        JButton blue = new ColorButton("Blue", Color.BLUE, 100, 150);
        npanel.add(blue);
        blue.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				window.dispose();
				new wild_direction(main,card,game1, unocard.Color.BLUE, Ai,Ai_base);
			}
        	
        });
        
        JButton yellow = new ColorButton("Yellow", Color.YELLOW, 100, 150);
        npanel.add(yellow);
        yellow.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				window.dispose();
				new wild_direction(main,card,game1, unocard.Color.YELLOW, Ai,Ai_base);
			}
        	
        });
        
        JButton green = new ColorButton("green", Color.GREEN, 100, 150);
        npanel.add(green);
        green.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				window.dispose();
				new wild_direction(main,card,game1, unocard.Color.GREEN, Ai,Ai_base);
			}
        	
        });
        
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
		ai_action(game1, Ai, Ai_base, red, blue, yellow, green);
		// do AI action if AI detected
    }

    /**
     * AI choose color and direction
     * @param game1 main game
     * @param Ai strategic AI
     * @param Ai_base basic AI
     * @param red red button
     * @param blue blue button
     * @param yellow yellow button
     * @param green greem button
     */
	private void ai_action(game game1, ArrayList<Integer> Ai, ArrayList<Integer> Ai_base, JButton red, JButton blue,
			JButton yellow, JButton green) {
		int cur = game1.get_currplayer();
		if (Ai.contains(cur)) {
			unocard.Color color = game1.ai_color();
			if (color == unocard.Color.BLUE) {
				blue.doClick();
			}
			if (color == unocard.Color.RED) {
				red.doClick();
			}
			if (color == unocard.Color.GREEN) {
				green.doClick();
			}
			if (color == unocard.Color.YELLOW) {
				yellow.doClick();
			}
		}
		if (Ai_base.contains(cur)) {
			unocard.Color color = game1.ai_color();
			if (color == unocard.Color.BLUE) {
				blue.doClick();
			}
			if (color == unocard.Color.RED) {
				red.doClick();
			}
			if (color == unocard.Color.GREEN) {
				green.doClick();
			}
			if (color == unocard.Color.YELLOW) {
				yellow.doClick();
			}
		}
	}
    
    /**
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
    
    /**
     * extend class for J button, aim to give button different color
     */
    private static class ColorButton extends JButton{
    	/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public ColorButton(String text, Color color, int x , int y) {
    		super(text);
    		setOpaque(true);
    		setBackground(color);
    		setPreferredSize(new Dimension(x,y));
    		setHorizontalAlignment(SwingConstants.CENTER);
    	}

    }
}
