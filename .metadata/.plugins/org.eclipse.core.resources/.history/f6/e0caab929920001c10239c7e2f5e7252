package GUI;

import unogame.*;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.KeyEvent;

public class GuiAddPlayer {
	ArrayList<JLabel> players = new ArrayList<JLabel>(); /* player label lists */
	JLabel num_play; /* number of current game's players */
	JLabel num_AI_Play;
	JLabel num_basic_play;
	game game1; /* main constructor for game */
	ArrayList<Integer> Ai = new ArrayList<Integer>();/*list that contains AI player's index*/
	ArrayList<Integer> Ai_base = new ArrayList<Integer>();/*list that contains basic AI players index*/
    /**
     * constructor for add player scene
     */
    public GuiAddPlayer(game game1){
    	this.game1 = game1;
        JFrame window = new JFrame("Add Player");
        window.setSize(500, 500);
        JPanel npanel = initializePanel();
        window.add(npanel);

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel label1 = new JLabel("Name");
        label1.setBounds(10, 20, 50, 25);
        npanel.add(label1);
        
        JTextField name_text = new JTextField(20);
        name_text.setBounds(80, 20, 200, 25);
        npanel.add(name_text);
        
        name_text.addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
    				String text = name_text.getText();
    				if (text.length() < 3) {
    					JOptionPane.showMessageDialog(null, "invalid name");
    					return;
    				}
    				game1.add_player(text);
    				set_player();
    				name_text.setText("");
                }
            }

        });
        
        button_setup(game1, window, npanel, name_text);
        //set up all buttons
        
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    
    /**
     * set up buttons function
     * @param game1 main game constructor
     * @param window add player GUI window
     * @param npanel main panel
     * @param name_text text to input string
     */
	private void button_setup(game game1, JFrame window, JPanel npanel, JTextField name_text) {
		JButton button = new JButton("Add Player");
        button.setBounds(280,20,100,25);
        npanel.add(button);
        
        button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String text = name_text.getText();
				if (text.length() < 3) {
					JOptionPane.showMessageDialog(null, "invalid name");
					return;
				}
				game1.add_player(text);
				set_player();
				name_text.setText("");
			}
			
        });
        
        JButton button_ai = new JButton("Add AI Player");
        button_ai.setBounds(380,20,150,25);
        npanel.add(button_ai);
        
        button_ai.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String text = name_text.getText();
				if (text.length() < 3) {
					JOptionPane.showMessageDialog(null, "invalid name");
					return;
				}
				game1.add_player(text);
				Ai.add(game1.get_player_list().size()-1);
				set_player();
				set_AI_player();
				name_text.setText("");
			}
        	
        });
        
        JButton button_ai_base = new JButton("Add Base AI");
        button_ai_base.setBounds(300,60, 120,25);
        npanel.add(button_ai_base);
        
        button_ai_base.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String text = name_text.getText();
				if (text.length() < 3) {
					JOptionPane.showMessageDialog(null, "invalid name");
					return;
				}
				game1.add_player(text);
				Ai_base.add(game1.get_player_list().size()-1);
				set_player();
				set_Basic_AI_player();
				name_text.setText("");
			}
        	
        });
        
        num_play = new JLabel("Number of Player is 0");
        num_play.setBounds(80, 50, 200, 50);
        npanel.add(num_play);
        
        num_AI_Play = new JLabel("Number of AI is 0");
        num_AI_Play.setBounds(80, 100, 200, 50);
        npanel.add(num_AI_Play);
        
        num_basic_play = new JLabel("Number of basic AI is 0");
        num_basic_play.setBounds(80, 150, 200, 50);
        npanel.add(num_basic_play);
        
        JButton button_start = new JButton("Start");
        button_start.setBounds(200, 400, 100,25);
        npanel.add(button_start);
        
        button_start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (game1.get_player_list().size() < 2) {
					JOptionPane.showMessageDialog(null, "Not Enough Player");
					return;
				}
				game1.start();
				window.dispose();
				new GuiMain(game1, Ai, Ai_base);
			}
			
        });
	}
    
    /**
     * when player size change, reset the player label
     */
    private void set_player() {
    	int x = game1.get_player_list().size();
    	num_play.setText("Number of Player is " + String.valueOf(x));
    }
    
    /**
     * when player size change, reset the player label
     */
    private void set_AI_player() {
    	int x = Ai.size();
    	num_AI_Play.setText("Number of Ai is " + String.valueOf(x));
    }
    
    /**
     * when player size change, reset the player label
     */
    private void set_Basic_AI_player() {
    	int x = Ai_base.size();
    	num_basic_play.setText("Number of basic Ai is " + String.valueOf(x));
    }
    
    /*
     * Initialize panel for add player scene
     */
    private JPanel initializePanel() {
        JPanel myPanel = new JPanel();
        myPanel.setPreferredSize(new Dimension(500,500));
        myPanel.setLayout(null);
        return myPanel;
    }
    
    public static void main(String[] args) {
    }
}
