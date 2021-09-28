package unogame;

import java.util.ArrayList;

public class player {
	public String pname;
    private ArrayList<unocard> hand_cards; /* hand on this player's hand */
    
    /**
     * main constructor of player class
     * @param pname: name of player, should be a string 
     */
    public player(String pname) {
    	this.pname = pname;
    	hand_cards = new ArrayList<unocard>();
    }
    
    /**
     * return this player's hand cards
     */
    public ArrayList<unocard> get_hand() {
    	return hand_cards;
    }
    
    /**
     * add new card to this player's hand
     * @param c: card to be added in this player's hand
     */
    public void add_hand(unocard c) {
    	hand_cards.add(c);
    }
    
    /**
     * remove certain card from this player's hand
     * @param c: card to be removed in this player's hand
     */
    public void remove_hand(unocard c) {
    	hand_cards.remove(c);
    }
    
    /**
     * remove certain card from this player's hand
     * @param i: card to be removed in this player's hand according to its index
     */
    public void remove_hand_index(int i) {
    	hand_cards.remove(i);
    }
    
    /**
     * check whether this player has no card on his hand
     */
    public boolean is_empty() {
    	return hand_cards.size() == 0;
    }
}
