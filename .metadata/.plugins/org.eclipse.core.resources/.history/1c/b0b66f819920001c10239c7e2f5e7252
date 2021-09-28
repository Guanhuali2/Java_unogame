package GUI;


import java.awt.Image;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import unogame.game;
import unogame.unocard;

public class GuiMain {
	game game1; /* the main UNO game we start */
	ArrayList<JButton> buttons = new ArrayList<JButton>(); /* lists that store available card buttons for each player*/
	JLabel color; /* label for latest card color */
	JLabel number; /* label for latest card number */
	JLabel effect; /* label for latest card effect */
	JLabel stack; /* label for current stack number */
	JLabel cur_player;  /* label for current player index */
	JLabel deck_size; /* label for main deck size */
	GuiMain main = this; /*this GUI*/
	JButton skip_button;  /* skip button for player */
	JFrame window; /*the main window */
	JPanel npanel; /*the main panel */
	int button_size; /* number of buttons for player hands*/
	ArrayList<Integer> Ai = new ArrayList<Integer>(); /*list that contains AI player's index*/
	ArrayList<Integer> Ai_base = new ArrayList<Integer>(); /*list that contains basic AI players index*/
	
    /**
     * Constructor for main scene
     */
    public GuiMain(game game1, ArrayList<Integer> Ai, ArrayList<Integer> Ai_base){
    	this.game1 = game1;
		this.Ai = Ai;
		this.Ai_base = Ai_base;
		this.button_size = 18;
        window = new JFrame("Basic Application Example");
        // create the frame for main scene
        
        initialize_panel_label();
        //add all labels
        
 
        ini_buttons(button_size);
        for (int i = 0; i < buttons.size(); i++) {
        	npanel.add(buttons.get(i));
        }
        //initialize empty buttons
        
        window_update();
        //set window
        
        button_setup(game1);
        //set buttons
        
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        update();
    }
    
    /**
     * set up and initialize all buttons
     * @param game1 main game GUI
     */
	private void button_setup(game game1) {
		skip_button = new JButton("Skip");
        skip_button.setBounds(0,300, 100, 20);
        npanel.add(skip_button);
        skip_button.addActionListener((e)->
        	{
        		game1.givePenalty(game1.get_currplayer());
        		game1.turn_to_next_player();
        		update();
        	}
        	);
        
        JButton deck_pick = new JButton(new ImageIcon(getClass().getResource("../unogame/image/card_back_alt.png")));
        deck_pick.setBounds(700, 0, 120, 150);
        npanel.add(deck_pick);
        deck_pick.addActionListener(e->
        	{
        		skip_button.doClick();
        	}
        	);
        
        JButton reveal_button = new JButton("Reveal");
        reveal_button.setBounds(0,350, 100, 20);
        npanel.add(reveal_button);
        reveal_button.addActionListener((e)->
        	{
        		reset_button();
        		set_icon();
        	}
        );
        
        JButton hide_button = new JButton("Hide");
        hide_button.setBounds(0,400, 100, 20);
        npanel.add(hide_button);
        
        hide_button.addActionListener((e)->
        	{
        		hide_hands();
        	}
        );
	}
    
    /**
     * do all initialize stuff
     */
	private void initialize_panel_label() {
		color = setLabel("", 100, 50, 80, 20);
        number = setLabel("", 110, 80, 100, 20);
        effect = setLabel("", 100, 110, 100, 20);
        stack = setLabel("", 110, 140, 100, 20);
        cur_player = setLabel("", 120, 170, 100, 20);
        deck_size = setLabel("", 700, 160, 200, 20);
        
        window.setSize(1500, 1000);
        npanel = initializePanel(0,0,1500,1000);
        npanel.setLayout(null);
        window.add(npanel);
        
        JLabel valid_color = setLabel("valid_color",10, 50, 80, 20);
        npanel.add(valid_color);
        
        JLabel valid_num = setLabel("valid_number",10, 80, 100, 20);
        npanel.add(valid_num);
        
        JLabel valid_eff = setLabel("valid_effect",10, 110, 80, 20);
        npanel.add(valid_eff);
        
        JLabel valid_stack = setLabel("stack_number",10, 140, 80, 20);
        npanel.add(valid_stack);
        
        JLabel valid_cur = setLabel("current_player",10, 170, 100, 20);
        npanel.add(valid_cur);
        
        npanel.add(color);
        npanel.add(number);
        npanel.add(effect);
        npanel.add(stack);
        npanel.add(cur_player);
        npanel.add(deck_size);
	}
	
	/**
	 * only update window status
	 */
	private void window_update() {
		set_number();
        set_color();
        set_effect();
        set_stack();
        set_curPlay();
        set_deck();
		reset_button();
		set_icon();
	}
    
    /**
     * this function update the whole GUI
     * every time a player ends his turn
     * it will detect buttons size and expand buttons list
     * it will detect whether the next player is AI or not
     */
    public void update() {
    	//expands button lists
    	if (game1.get_player_list().get(game1.get_currplayer()).get_hand().size() >= button_size) {
    		button_size += 18;
    		ini_buttons(button_size);
            for (int i = button_size - 18; i < buttons.size(); i++) {
            	npanel.add(buttons.get(i));
            }
    	}
        window_update();
		int cur = game1.get_currplayer();
		if (Ai.contains(cur)) {
			//do smarter AI stuff
			ai_control();
		}
		if (Ai_base.contains(cur)) {
			//do basic AI stuff
			base_ai_control();
		}
    }
    
    /**
     * smart AI controller
     */
    private void ai_control() {
    	unocard card = game1.game_AI_play();
    	int index = game1.get_player_list().get(game1.get_currplayer()).get_hand().indexOf(card);
    	if(index == -1) {
    		skip_button.doClick();
    		return;
    	}
    	buttons.get(index).doClick();
    }
    
    /**
     * basic AI controller
     */
    private void base_ai_control() {
    	unocard card = game1.base_AI_play();
    	int index = game1.get_player_list().get(game1.get_currplayer()).get_hand().indexOf(card);
    	if(index == -1) {
    		skip_button.doClick();
    		return;
    	}
    	buttons.get(index).doClick();
    }
    
    /**
     * function for hide hands card
     */
    private void hide_hands() {
    	ArrayList<unocard> cards = game1.get_player_list().get(game1.get_currplayer()).get_hand();
    	for(int i = 0; i < cards.size(); i++) {
    		ImageIcon icon = new ImageIcon(getClass().getResource("../unogame/image/card_back.png"));
    		Image img = icon.getImage();
    		Image newimg = img.getScaledInstance(88,110,java.awt.Image.SCALE_SMOOTH); 
    		ImageIcon icon1 = new ImageIcon(newimg); 
    		buttons.get(i).setIcon(icon1);
    	}
    }
    
    /**
     * set deck label size
     */
    private void set_deck() {
    	int deck_num = game1.main_deck.get_deck_size();
    	deck_size.setText("Remaining deck number: " + String.valueOf(deck_num));
    }
    
    /**
     * set valid number label value
     */
    private void set_number() {
    	int cur_num = game1.valid_number;
    	number.setText(String.valueOf(cur_num));
    }
    
    /**
     * set valid color label value
     */
    private void set_color() {
    	unocard.Color cur_cor = game1.valid_color;
    	switch(cur_cor) {
			case BLUE:
				color.setText("blue");
				break;
			case GREEN:
				color.setText("green");
				break;
			case NONE:
				color.setText("none");
				break;
			case RED:
				color.setText("red");
				break;
			case YELLOW:
				color.setText("yellow");
				break;
			default:
				break;
    	}
    }
    
    /**
     * set current player's index
     */
    private void set_curPlay() {
    	int cur_play = game1.get_currplayer();
    	cur_player.setText(String.valueOf(cur_play));
    }
    
    /**
     * set the stack number
     */
    private void set_stack() {
    	int stack_number = game1.get_stack();
    	stack.setText(String.valueOf(stack_number));
    }
    
    /**
     * set valid effect label value
     */
    private void set_effect() {
    	unocard.Effect cur_eff = game1.valid_effect;
    	switch(cur_eff) {
			case DRAW_TWO:
				effect.setText("Draw Two");
				break;
			case NUMBER:
				effect.setText("Number Card");
				break;
			case REVERSE:
				effect.setText("Reverse");
				break;
			case SKIP:
				effect.setText("Skip");
				break;
			case WILD:
				effect.setText("Wild");
				break;
			case WILD_F:
				effect.setText("Wild Draw Four");
				break;
			default:
				break;	
    	}
    }
    
    /**
     * functions help create labels
     * @param label: text of the label.
     * @param x: x coordinate of the label.
     * @param y: y coordinate of the label.
     * @param width: width of the label.
     * @param height: height of the label.
     */
    private JLabel setLabel(String label, int x, int y, int width,int height) {
    	JLabel new_label = new JLabel(label);
    	new_label.setBounds(x, y, width, height);
    	return new_label;
    }
    
    /**
     * add available buttons to button lists
     * @param num: number of button wants to addd
     */
    private void ini_buttons(int num) {
    	int layer = num/18;
    	int num_each_layer = num/layer;
    	int x = 0;
    	int y = 780;
    	int width = 1500/num_each_layer;
    	int height = 100;
    	for (int j = layer; j < layer+1; j++) {
	    	for (int i = 0; i < num; i++) {
	    		JButton temp_button = new JButton("empty");
	    		temp_button.setBounds(x, y-(100*j), width, height);
	    		buttons.add(temp_button);
	    		x += width;
	    	}
    	}
    }
    
    /**
     * reset all buttons' function
     */
    public void reset_button() {
    	for(int i = 0; i < buttons.size(); i++) {
    		  for( ActionListener x : buttons.get(i).getActionListeners() ) {
    			    buttons.get(i).removeActionListener(x);
    			  }
    	}
    }
    
    
    /**
     * update the image of each players hand cards button,  
     * empty button will be covered by UNO card back image.
     */
    public void set_icon() {
    	ArrayList<unocard> card_list = game1.get_player_list().get(game1.get_currplayer()).get_hand();
    	for (int i = 0; i < card_list.size();i++) {
    		String[] stored_string = new String[2];
    		stored_string = to_string(card_list.get(i));
    		ImageIcon icon = new ImageIcon(getClass().getResource("../unogame/image/" + stored_string[0] + "_" + stored_string[1] + ".png"));
    		Image img = icon.getImage();
    		Image newimg = img.getScaledInstance(88,110,java.awt.Image.SCALE_SMOOTH); 
    		ImageIcon icon1 = new ImageIcon(newimg); 
    		buttons.get(i).setIcon(icon1);
    		buttons.get(i).addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					int cur_play = game1.get_currplayer();
					JButton button = (JButton)e.getSource();
					int index = buttons.indexOf(button);
					unocard card = card_list.get(index);
					if (game1.allowedToPlay(card)) {
						//implement play method
						if (card.get_effect() != unocard.Effect.WILD && card.get_effect() != unocard.Effect.WILD_F) {
							game1.play(card);
							update();
							if (game1.checkGameEndingCondition(cur_play)) {
								window.dispose();
								new End(game1, game1.get_winner());
							}
						}else{
							//implement wild
							new wild_color(main ,game1, card, Ai, Ai_base);
						}
					}else{
						JOptionPane.showMessageDialog(null, "not allowed to play");
					}

				}
    			
    		});
    	}
    	for (int i = card_list.size(); i < buttons.size(); i++) {
    		ImageIcon icon = new ImageIcon(getClass().getResource("../unogame/image/empty.png"));
    		Image img = icon.getImage();
    		Image newimg = img.getScaledInstance(88,110,java.awt.Image.SCALE_SMOOTH); 
    		ImageIcon icon1 = new ImageIcon(newimg); 
    		buttons.get(i).setIcon(icon1);
    		buttons.get(i).addActionListener(e->{
    			JOptionPane.showMessageDialog(null, "empty card");
    		});
    	}
    }
    
    /**
     * initialize panel for main scene
     */
    private JPanel initializePanel(int x, int y, int whith,int height) {
        JPanel myPanel = new JPanel();
        myPanel.setBounds(x, y, whith, height);
        return myPanel;
    }
    

    /**
     * convert card properties to corresponding string
     */
    public static String[] to_string(unocard card) {
    	String[] store = new String[2];
    	if (card.get_number() == -1) {
    		store[0] = card.get_color().toString().toLowerCase();
	    	switch(card.get_effect()) {
				case DRAW_TWO:
					store[1] = "picker";
					break;
				case REVERSE:
					store[1] = "reverse";
					break;
				case SKIP:
					store[1] = "skip";
					break;
				case WILD:
					store[1] = "wild";
					break;
				case WILD_F:
					store[1] = "wildf";
					break;
				default:
					break;

	    	}
    	}else {
    		store[0] = card.get_color().toString().toLowerCase();
    		store[1] = Integer.toString(card.get_number());
    	}
		return store;
    }
    
    public static void main(String[] args) {
    }
    
    /**
     * getter for current game
     */
    public game get_curGame() {
		return game1;
    }
}
