package unogame;

import java.util.ArrayList;
import java.util.Random;

public class deck{
    public static final int NUMBER_OF_WILD_CARDS = 4; /* the number of wild and wild4 cards */
	
    private ArrayList<unocard> cards = new ArrayList<unocard>(); /* main deck */
    private ArrayList<unocard> discardedCards = new ArrayList<unocard>(); /* discarded deck */

    /**
     * new deck constructor
     * @param i: shuffle factor
     */
    public deck(int i) {
    	deck_initialize();
    	shuffle_deck(i);
    }
    
    /**
     * Initialize 108 cards deck
     */
    public void deck_initialize() {
    	ArrayList<unocard.Color> colors = new ArrayList<unocard.Color>();
    	add_color(colors);
    	for(int i = 0; i < colors.size() ; i++) {
    		
    		//initialize all number cards except 0 twice
    		for(int j = 1; j <= 9; j++) {
    			cards.add(new unocard(colors.get(i),j));
    			cards.add(new unocard(colors.get(i),j));
    		}
    		
    		// initialize all effect cards except Wild && Wild4 twice and one number 0 card
    		add_double_effect_card(colors, i);
    		add_double_effect_card(colors, i);
    		cards.add(new unocard(colors.get(i),0));
    	}
    	
    	//initialize Wild and WIldF cards
    	for(int i = 0; i < NUMBER_OF_WILD_CARDS; i++) {
    		cards.add(new unocard(unocard.Color.NONE,unocard.Effect.WILD));
    		cards.add(new unocard(unocard.Color.NONE,unocard.Effect.WILD_F));
    	}
    }
    
    /**
     * method to add all four colors to a ArrayList
     * @param colors: ArrayList that may contain unocard.Color type variable
     */
	private void add_color(ArrayList<unocard.Color> colors) {
		colors.add(unocard.Color.BLUE);
    	colors.add(unocard.Color.GREEN);
    	colors.add(unocard.Color.YELLOW);
    	colors.add(unocard.Color.RED);
	}

	private void add_double_effect_card(ArrayList<unocard.Color> colors, int i) {
		cards.add(new unocard(colors.get(i),unocard.Effect.REVERSE));
		cards.add(new unocard(colors.get(i),unocard.Effect.DRAW_TWO));
		cards.add(new unocard(colors.get(i),unocard.Effect.SKIP));
	}
	
    /**
     * get main deck's size
     */
    public int get_deck_size() {
    	return cards.size();
    }
    
    /**
     * check whether main deck is empty or not
     */
    public boolean is_deck_empty() {
    	return cards.isEmpty();
    }
    
    /**
     * randomly shuffle the main deck with specific shuffle factor
     * @param name: new player's name
     */
    public void shuffle_deck(int shuffle_factor) {
    	Random rand = new Random();
    	for(int i = 0; i < cards.size()*shuffle_factor; i++) {
    		if (i >= cards.size()) {
    			i = i % cards.size();
    		}
    		int shuffle_number = rand.nextInt(cards.size());
    		unocard temp_card = cards.get(shuffle_number);
    		cards.set(shuffle_number, cards.get(i));
    		cards.set(i, temp_card);
    	}
    }
    
    /**
     * Refill the main deck with discarded deck
     */
    public void refill_with_discarded_deck() {
    	unocard top_card = discardedCards.get(discardedCards.size()-1);
    	for(int i = 0; i < discardedCards.size()-1; i++) {
    		cards.add(discardedCards.get(i));
    	}
    	shuffle_deck(1);
    	discardedCards.clear();
    	discarded(top_card);
    }    
    
    /**
     * draw specific number of cards from the top of main deck
     * @param number_draws: the amount of cards to be drawed
     */
    public ArrayList<unocard> draw_cards(int number_draws){
    	ArrayList<unocard> drawed = new ArrayList<unocard>();
    	for(int i = 0 ; i < number_draws; i++) {
    		if (cards.isEmpty()) {
    			refill_with_discarded_deck();
    		}
    		drawed.add(cards.remove(0));
    	}
		return drawed;
    }
    
    /**
     *add cards into discarded deck
     *@param card: card that going to be discarded
     */
    public void discarded(unocard card) {
    	discardedCards.add(card);
    }
    
    /**
     *return main deck 
     */
    public ArrayList<unocard> get_deck() {
    	return cards;
    }
    
    /**
     * return discarded deck
     */
    public ArrayList<unocard> get_discarded_deck() {
    	return discardedCards;
    }
}