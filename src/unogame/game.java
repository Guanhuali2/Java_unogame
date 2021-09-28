package unogame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import unogame.unocard.Color;

public class game{
	
	private int stack_number; //Cards number that is stacked by Wild4 or Draw2
	private boolean direction;	//true means right direction, false means left direction, game will initial with right direction
	private int current_player; //represent current player's index in player_list
	private int distance; //the distance between current and next player
    private ArrayList<player> player_list; //ArrayList that contains all players

    
    public unocard.Color valid_color; // latest recorded color 
    public int valid_number; // latest recorded number
    public unocard.Effect valid_effect; // latest recorded effect
    int winner_pid; // winner's id
    
    public deck main_deck; // main deck of the game, player will draw cards from this deck
    boolean curPlayerState;  // player's state to skip his turn or not, true means player still want to play, false means skip his turn
    public boolean overallGameState; // game state of the whole game, if someone has no card on his hand, game state will be false then game ends
    private String winner;
    public boolean penalty;
    /**
     * Initialize the game with shuffled 108 deck
     * Initial direction is true which means right
     * Initial stack number is 0
     * @param shuffle_factor: how many times player wants to shuffle the deck
     */
    public game(int shuffle_factor) {
    	this.penalty = false;
    	this.stack_number = 0;
    	this.direction = true;
    	this.overallGameState = false;
    	this.player_list = new ArrayList<player>();
    	main_deck = new deck(shuffle_factor);
    }
    
    /**
     * start the game
     * the first player is player with index 0
     * if total amount of player is less than two, the game is not able to start
     * each player will have 7 initial cards
     * the top card of the main deck will be the start card
     * record the property of the start card and discard it
     */
    public void start() {
    	if (player_list.size() < 2) {
    		System.out.print("not allowed to start");
    		return;
    	}
    	for (int i = 0; i < player_list.size(); i++) {
    		ArrayList<unocard> initial_cards = main_deck.draw_cards(7);
    		for (int j = 0; j < initial_cards.size(); j++) {
    			player_list.get(i).add_hand(initial_cards.get(j));
    		}
    	}
    	this.current_player = 0;
    	this.distance = 1;
    	winner_pid = -1;
    	unocard start_card = main_deck.draw_cards(1).get(0);
    	while (start_card.get_number() == -1) {
    		main_deck.discarded(start_card);
    		start_card = main_deck.draw_cards(1).get(0);
    	}
    	valid_color = start_card.get_color();
    	valid_effect = start_card.get_effect();
    	valid_number = start_card.get_number();
    	this.curPlayerState = true;
    	this.overallGameState = true;
    	main_deck.discarded(start_card);
    	winner = "no winner yet";
    }
    
    /**
     * this function implement basic AI
     * it will randomly choose a card that allowed to play
     * @return UNO card that base AI wants to play
     */
    public unocard base_AI_play() {
    	ArrayList<unocard> cards = player_list.get(current_player).get_hand(); 
    	unocard output = null;
    	
    	ArrayList<unocard> candidate = new ArrayList<unocard>();
    	
    	for (int i = 0; i < cards.size(); i++) {
    		unocard card = cards.get(i);
    		
    		if (allowedToPlay(card)) {
    			candidate.add(card);
    		}
    	}
    	
    	Random rand = new Random();
    	if (candidate.isEmpty()) {
    		return output;
    	}else {
    		output = candidate.get(rand.nextInt(candidate.size()));
    		return output;
    	}
    }
    
    
    /**
     * this function implement when AI play wild or wild four
     * AI needs to choose a color
     * AI will choose the color that repeat most in his hands
     * @return color that AI wants to choose
     */
    public unocard.Color ai_color() {
    	ArrayList<unocard> cards = player_list.get(current_player).get_hand();
    	Map<unocard.Color , Integer> mapc = new HashMap<unocard.Color , Integer>(); 
    	
    	for(unocard.Color c:unocard.Color.values()) {
        	mapc.put(c, 0);
    	}
    	
    	for (int i = 0; i < cards.size(); i++) {
    		unocard card = cards.get(i);
    		mapc.put(card.get_color(), mapc.get(card.get_color())+1);
    	}
    	
    	int max = 0;
    	unocard.Color color = unocard.Color.NONE;
    	for(Entry<unocard.Color, Integer> entry: mapc.entrySet()) {
    		unocard.Color key = entry.getKey();
    		int j = entry.getValue();
    		if (j > max) {
    			max = j;
    			color = key;
    		}
    	}
    	return color;
    }
    
    /**
     * function that implements an strategic AI play UNO card
     * among all the cards at hands
     * AI will compare number, color and effect
     * and choose the card with most repeat times
     * @return return the card that AI prefer to play
     */
    public unocard game_AI_play() {
    	ArrayList<unocard> cards = player_list.get(current_player).get_hand();
    	Map<unocard.Color , Integer> mapc = new HashMap<unocard.Color , Integer>(); 
    	Map<Integer , Integer> mapn = new HashMap<Integer , Integer>(); 
    	Map<unocard.Effect, Integer> mape = new HashMap<unocard.Effect , Integer>(); 
    	unocard output = null;
    	int rep = 0;
    	
    	for(unocard.Color c:unocard.Color.values()) {
        	mapc.put(c, 0);
    	}

    	for(unocard.Effect e:unocard.Effect.values()) {
        	mape.put(e, 0);
    	}
    	
    	for(int i = -1; i < 10; i++) {
        	mapn.put(i, 0);
    	}
    	
    	
    	ArrayList<unocard> candidate = new ArrayList<unocard>();
    	
    	for (int i = 0; i < cards.size(); i++) {
    		unocard card = cards.get(i);
    		mapc.put(card.get_color(), mapc.get(card.get_color())+1);
    		mape.put(card.get_effect(), mape.get(card.get_effect())+1);
    		mapn.put(card.get_number(), mapn.get(card.get_number())+1);
    		
    		if (allowedToPlay(card)) {
    			candidate.add(card);
    		}
    	}
    	
    	if (candidate.isEmpty()) {
    		return output;
    	}else {
    		output = candidate.get(0);
    		rep = mapc.get(candidate.get(0).get_color()) + mapn.get(candidate.get(0).get_number()) + mape.get(candidate.get(0).get_effect());
    	}
    	
    	for (int i = 1; i < candidate.size(); i++) {
    		int temp = mapc.get(candidate.get(i).get_color()) + mapn.get(candidate.get(i).get_number()) + mape.get(candidate.get(i).get_effect());
    		if (temp > rep) {
    			output = candidate.get(i);
    			rep = temp;
    		}
    	}
    	return output;
    }
    
    /**
     * action of player in his round
     * @param current_play: player with index current_play can play in this round
     * @param card: card that the player wants to play
     * @param calledColor: if the card is WIld or WIld4, players' called color, else None
     * @param willToPlay: if player wants to skip his turn, then false, else true
     */
    public void play(unocard card) {
    	unocard.Color cur_color = card.get_color();
    	int cur_number = card.get_number();
    	unocard.Effect cur_effect = card.get_effect();
    	if (allowedToPlay(card)) {
    		if ((valid_color != unocard.Color.NONE && card.get_color() == valid_color) ||
                    (valid_number != -1 && card.get_number() == valid_number)) {
    			changeValidState(cur_color, cur_number, cur_effect);
    			if (valid_effect == unocard.Effect.DRAW_TWO) {
    				draw_two();
    			}
    			if (valid_effect == unocard.Effect.REVERSE) {
    				reverse_card();
    			}
    			if (valid_effect == unocard.Effect.SKIP) {
    				skip_card();
    			}
    		}
    		else if(valid_effect == unocard.Effect.DRAW_TWO && card.get_effect() == unocard.Effect.DRAW_TWO) {
    			changeValidState(cur_color, cur_number, cur_effect);
    			draw_two();
    		} 
    		player_list.get(current_player).remove_hand(card);
        	main_deck.discarded(card);
        	curPlayerState = false;
        	turn_to_next_player();
    	}else {
    		System.out.print("not allowed to play");
    		return;
    	}
    }
    
    public void play_wild(unocard card,unocard.Color color, boolean direction) {
    	changeValidState(color, -1, card.get_effect());
    	if (card.get_effect() == unocard.Effect.WILD) {
    		wild(color, direction);
    	}else {
    		wild_F(color, direction);
    	}
		player_list.get(current_player).remove_hand(card);
		main_deck.discarded(card);
    	curPlayerState = false;
    	turn_to_next_player();
    }
    
    
    /**
     * change three valid state for the game
     * @param cur_color: valid color for the next round
     * @param cur_number: valid number for the next round
     * @param cur_effecy: valid effect for the next round
     */
	public void changeValidState(unocard.Color cur_color, int cur_number, unocard.Effect cur_effect) {
		valid_color = cur_color;
		valid_number = cur_number;
		valid_effect = cur_effect;
	}
    
	/**
	 * check whether the card is allowed to play according to uno cards rules
	 * @param card: the card that need to be checked
	 * @return return boolean that indicate whether this card is allowed to play
	 */
    public boolean allowedToPlay(unocard card) {
    	if (penalty == true) {
	    	if (valid_effect == unocard.Effect.WILD_F && card.get_effect() != unocard.Effect.WILD_F) {
	    		return false;
	    	}
	    	if (valid_effect == unocard.Effect.DRAW_TWO && 
	    			(card.get_effect() != unocard.Effect.DRAW_TWO && card.get_effect() != unocard.Effect.WILD_F)) {
	    		return false;
	    	}
    	}
    	if (card.get_effect() == unocard.Effect.WILD ||
    			card.get_effect() == unocard.Effect.WILD_F ||
                (valid_color != unocard.Color.NONE && card.get_color() == valid_color) ||
                (valid_number != -1 && card.get_number() == valid_number) ||
                (valid_effect != unocard.Effect.NUMBER && valid_effect == card.get_effect()))
            {
                return true;
            } 	
    	return false;
    }
    
    /**
     * Add new player
     * @param name: new player's name
     */
    public void add_player(String name) {
    	player_list.add(new player(name));
    }
    
    /**
     * According to direction, move round to next player
     */
    public void turn_to_next_player() {
    	int live_player = player_list.size();
    	if (direction == true) {
    		current_player = (current_player + distance) % live_player;
    	}else{
    		current_player = (current_player - distance) % live_player;
    		if (current_player < 0) {
    			current_player = live_player + current_player;
    		}
    	}
    	this.distance = 1;
    }
    
    /**
     * return player list of the game
     */
    public ArrayList<player> get_player_list(){
    	return player_list;
    }
    
    /**
     * get current direction of the game
     */
    public boolean get_direction() {
    	return direction;
    }
    
    /**
     * get current stack number of the game
     */
    public int get_stack() {
		return stack_number;
    }
    
    /**
     * get current played player's index
     */
    public int get_currplayer() {
    	return current_player;
    }
    
    /**
     * Skip card effect
     */
    public void skip_card() {
    	this.distance += 1;
    }
    
    /**
     * Reverse card effect
     */
    public void reverse_card() {
    	if (direction == true) {
    		direction = false;
    	}else {
    		direction = true;
    	}
    }
    
    /**
     * Draw two card effect, can be stacked
     * besides the stack effect, the player before and after this player
     * will immediately draw one card
     */
    public void draw_two() {
    	int live_player = player_list.size();
    	int following = (current_player + 1)%live_player;
    	int preceding = (current_player - 1)%live_player;
    	if (preceding < 0) {
    		preceding = live_player + preceding;
    	}
    	ArrayList<unocard> cards = main_deck.draw_cards(2);
    	this.player_list.get(following).add_hand(cards.get(0));
    	this.player_list.get(preceding).add_hand(cards.get(1));
    	stack_number += 2;
    	this.penalty = true;
    }
    
    /**
     * Wild card effect
     * @param color: players called color for his wild card
     */
    public void wild(unocard.Color color, boolean direct) {
    	this.direction = direct;
    	valid_number = -1;
    	valid_effect = unocard.Effect.WILD;
    	valid_color = color;
    }
    
    /**
     * Wild4 card effect
     * player can also choose the direction 
     * @param color: players called color for his wild4 card
     */
    public void wild_F(unocard.Color color, boolean direct) {
    	this.direction = direct;
    	valid_number = -1;
    	valid_effect = unocard.Effect.WILD_F;
    	valid_color = color;
    	stack_number += 4;
    	this.penalty = true;
    }
    
    /**
     * Penalty that player needs to receive when skip his turn
     * player will draw 1+stack number of cards from deck
     * player will also able to choose direction
     * @param cur_play: index of player that received the penalty
     */
    public void givePenalty(int cur_play) {
    	int drawed_card_num = 1 + stack_number;
    	ArrayList<unocard> drawCardList = main_deck.draw_cards(drawed_card_num);
    	for(int i = 0; i < drawCardList.size(); i++) {
    		player_list.get(cur_play).add_hand(drawCardList.get(i));
    	}
    	stack_number = 0;
    	this.penalty = false;
    }
    
    /**
     * if a player does not have any hand card, the game end
     */
    public boolean checkGameEndingCondition(int player) {
    	if (player_list.get(player).is_empty()) {
    		overallGameState = false;
        	winner = this.player_list.get(player).pname;
        	return true;
    	}
    	return false;
    }
    
    /**
     * getter for winner
     */
    public String get_winner() {
    	return winner;
    }
}