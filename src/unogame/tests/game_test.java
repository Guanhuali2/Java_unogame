package unogame.tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

import unogame.*;

public class game_test {
	@Test
	public void canCreateInitialGame() throws Exception {
		game new_game = new game(1);
		
		assertEquals(108,new_game.main_deck.get_deck_size());
		assertEquals(true, new_game.get_direction());
		assertEquals(0, new_game.get_stack());
	}
	
	@Test
	public void canNotStartGame() throws Exception {
		game new_game = new game(1);
		String player1 = "Mike";
		new_game.add_player(player1);
		new_game.start();
	}
	
	@Test
	public void canStartGame() throws Exception {
		game new_game = new game(1);
		String player1 = "Mike";
		new_game.add_player(player1);
		String player2 = "Jason";
		new_game.add_player(player2);
		new_game.start();
		
		assertEquals(2,new_game.get_player_list().size());
		assertEquals("Mike",new_game.get_player_list().get(0).pname);
		assertEquals("Jason",new_game.get_player_list().get(1).pname);
	}
	
	
	@Test
	public void checkAddPlayer() throws Exception {
		game new_game = new game(1);
		String player1 = "Mike";
		new_game.add_player(player1);
		assertEquals(1,new_game.get_player_list().size());
		assertEquals("Mike",new_game.get_player_list().get(0).pname);
	}
	
	@Test
	public void allowedToPlayNumberToNumber() throws Exception {
		game new_game = new game(1);
		new_game.changeValidState(unocard.Color.RED, 1, unocard.Effect.NUMBER);
		unocard card = new unocard(unocard.Color.BLUE,1);
		assertEquals(true, new_game.allowedToPlay(card));
	}
	
	@Test
	public void allowedToPlayColorToColor() throws Exception {
		game new_game = new game(1);
		new_game.changeValidState(unocard.Color.RED, 0, unocard.Effect.NUMBER);
		unocard card = new unocard(unocard.Color.RED,1);
		assertEquals(true, new_game.allowedToPlay(card));
	}
	
	@Test
	public void allowedToPlayEffectToEffect() throws Exception {
		game new_game = new game(1);
		new_game.changeValidState(unocard.Color.RED, -1, unocard.Effect.REVERSE);
		unocard card = new unocard(unocard.Color.BLUE,unocard.Effect.REVERSE);
		assertEquals(true, new_game.allowedToPlay(card));
	}
	
	@Test
	public void allowedToPlayNumberToWild() throws Exception {
		game new_game = new game(1);
		new_game.changeValidState(unocard.Color.RED, 1, unocard.Effect.NUMBER);
		unocard card = new unocard(unocard.Color.NONE,unocard.Effect.WILD);
		assertEquals(true, new_game.allowedToPlay(card));
	}
	
	@Test
	public void allowedToPlayEffectToWild() throws Exception {
		game new_game = new game(1);
		unocard card = new unocard(unocard.Color.NONE,unocard.Effect.WILD);
		new_game.changeValidState(unocard.Color.RED, -1, unocard.Effect.REVERSE);
		assertEquals(true, new_game.allowedToPlay(card));
	}
	
	@Test
	public void notAllowedToPlayWildFToWild() throws Exception {
		game new_game = new game(1);
		unocard card = new unocard(unocard.Color.NONE,unocard.Effect.WILD);
		new_game.changeValidState(unocard.Color.NONE, -1, unocard.Effect.WILD_F);
		new_game.penalty = true;
		assertEquals(false, new_game.allowedToPlay(card));
	}
	
	@Test
	public void notAllowedToPlayDrawTwoToWild() throws Exception {
		game new_game = new game(1);
		unocard card = new unocard(unocard.Color.NONE,unocard.Effect.WILD);
		new_game.changeValidState(unocard.Color.RED, -1, unocard.Effect.DRAW_TWO);
		new_game.penalty = true;
		assertEquals(false, new_game.allowedToPlay(card));
	}
	
	@Test
	public void notAllowedToPlayWildFToWildnoP() throws Exception {
		game new_game = new game(1);
		unocard card = new unocard(unocard.Color.NONE,unocard.Effect.WILD);
		new_game.changeValidState(unocard.Color.NONE, -1, unocard.Effect.WILD_F);
		new_game.penalty = false;
		assertEquals(true, new_game.allowedToPlay(card));
	}
	
	@Test
	public void notAllowedToPlayDrawTwoToWildnoP() throws Exception {
		game new_game = new game(1);
		unocard card = new unocard(unocard.Color.NONE,unocard.Effect.WILD);
		new_game.changeValidState(unocard.Color.RED, -1, unocard.Effect.DRAW_TWO);
		new_game.penalty = false;
		assertEquals(true, new_game.allowedToPlay(card));
	}
	
	@Test
	public void allowedToPlayDrawTwoToDrawTwo() throws Exception {
		game new_game = new game(1);
		unocard card = new unocard(unocard.Color.BLUE,unocard.Effect.DRAW_TWO);
		new_game.changeValidState(unocard.Color.RED, -1, unocard.Effect.DRAW_TWO);
		assertEquals(true, new_game.allowedToPlay(card));
	}
	
	@Test
	public void allowedToPlayNumberToWildF() throws Exception {
		game new_game = new game(1);
		new_game.changeValidState(unocard.Color.RED, 1, unocard.Effect.NUMBER);
		unocard card = new unocard(unocard.Color.NONE,unocard.Effect.WILD_F);
		assertEquals(true, new_game.allowedToPlay(card));
	}
	
	@Test
	public void allowedToPlayEffectToWildF() throws Exception {
		game new_game = new game(1);
		unocard card = new unocard(unocard.Color.NONE,unocard.Effect.WILD_F);
		new_game.changeValidState(unocard.Color.RED, -1, unocard.Effect.REVERSE);
		assertEquals(true, new_game.allowedToPlay(card));
	}
	
	@Test
	public void allowedToPlayWildFToWildF() throws Exception {
		game new_game = new game(1);
		unocard card = new unocard(unocard.Color.NONE,unocard.Effect.WILD_F);
		new_game.changeValidState(unocard.Color.NONE, -1, unocard.Effect.WILD_F);
		assertEquals(true, new_game.allowedToPlay(card));
	}
	
	@Test
	public void notAllowedToPlayNumberColorNoMatch() throws Exception {
		game new_game = new game(1);
		new_game.changeValidState(unocard.Color.BLUE, 0, unocard.Effect.NUMBER);
		unocard card = new unocard(unocard.Color.RED,1);
		assertEquals(false, new_game.allowedToPlay(card));
	}
	
	@Test
	public void notAllowedToPlayEffectColorNoMatch() throws Exception {
		game new_game = new game(1);
		new_game.changeValidState(unocard.Color.BLUE, -1, unocard.Effect.REVERSE);
		unocard card = new unocard(unocard.Color.RED,unocard.Effect.SKIP);
		assertEquals(false, new_game.allowedToPlay(card));
	}
	
	@Test
	public void checkDrawTwoEffect() throws Exception {
		game new_game = new game(1);
		String player1 = "Mike";
		new_game.add_player(player1);
		String player2 = "Jason";
		new_game.add_player(player2);
		String player3 = "Joe";
		new_game.add_player(player3);
		new_game.start();
		new_game.draw_two();
		
		ArrayList<player> players = new_game.get_player_list();
		
		assertEquals(8, players.get(2).get_hand().size());
		assertEquals(8, players.get(1).get_hand().size());
		assertEquals(2, new_game.get_stack());
	}
	
	@Test
	public void checkReverseEffect() throws Exception {
		game new_game = new game(1);
		new_game.reverse_card();
		
		assertEquals(false, new_game.get_direction());
	}
	
	@Test
	public void checkSkipEffect() throws Exception {
		game new_game = new game(1);
		String player1 = "Mike";
		new_game.add_player(player1);
		String player2 = "Jason";
		new_game.add_player(player2);
		String player3 = "Joe";
		new_game.add_player(player3);
		new_game.start();
		assertEquals(0,new_game.get_currplayer());
		
		new_game.skip_card();
		new_game.turn_to_next_player();
		assertEquals(2, new_game.get_currplayer());
	}
	
	@Test
	public void checkWildEffect() throws Exception{
		game new_game = new game(1);
		new_game.wild(unocard.Color.BLUE, false);
		
		assertEquals(false,new_game.get_direction());
		assertEquals(new_game.valid_color, unocard.Color.BLUE);
	}
	
	@Test
	public void checkWildFEffect() throws Exception{
		game new_game = new game(1);
		new_game.wild_F(unocard.Color.BLUE, false);
		
		assertEquals(new_game.valid_color, unocard.Color.BLUE);
		assertEquals(false,new_game.get_direction());
		assertEquals(new_game.get_stack(), 4);
	}
	
	@Test
	public void checkPenalty() throws Exception {
		game new_game = new game(1);
		String player1 = "Mike";
		new_game.add_player(player1);
		String player2 = "Jason";
		new_game.add_player(player2);
		new_game.start();
		new_game.draw_two();
		new_game.givePenalty(0);
		
		assertEquals(10, new_game.get_player_list().get(0).get_hand().size());
		assertEquals(0, new_game.get_stack());
	}
	
	@Test
	public void checkGameEnd() throws Exception {
		game new_game = new game(1);
		String player1 = "Mike";
		new_game.add_player(player1);
		String player2 = "Jason";
		new_game.add_player(player2);
		new_game.start();
		
		assertEquals(true, new_game.overallGameState);
		for (int i = 0 ; i < 7; i++ ) {
			new_game.get_player_list().get(0).remove_hand_index(0);
		}
		new_game.checkGameEndingCondition(0);
		assertEquals(false, new_game.overallGameState);
	}
	
	@Test
	public void checkGameCanNotPlay() throws Exception {
		game new_game = new game(1);
		String player1 = "Mike";
		new_game.add_player(player1);
		String player2 = "Jason";
		new_game.add_player(player2);
		new_game.start();
		
		unocard card = new unocard(unocard.Color.BLUE,1);
		new_game.valid_color = unocard.Color.GREEN;
		new_game.valid_effect = unocard.Effect.NUMBER;
		new_game.valid_number = 0;
		
		new_game.play(card);
		
		assertEquals(unocard.Color.GREEN, new_game.valid_color);
	}
	
	@Test
	public void checkGameCanPlay() throws Exception {
		game new_game = new game(1);
		String player1 = "Mike";
		new_game.add_player(player1);
		String player2 = "Jason";
		new_game.add_player(player2);
		new_game.start();
		
		unocard card = new unocard(unocard.Color.BLUE,1);
		new_game.valid_color = unocard.Color.GREEN;
		new_game.valid_effect = unocard.Effect.NUMBER;
		new_game.valid_number = 1;
		
		new_game.play(card);
		
		assertEquals(unocard.Color.BLUE, new_game.valid_color);
	}
	
	@Test
	public void checkPlayWild() throws Exception {
		game new_game = new game(1);
		String player1 = "Mike";
		new_game.add_player(player1);
		String player2 = "Jason";
		new_game.add_player(player2);
		new_game.start();
		
		unocard wild = new unocard(unocard.Color.NONE, unocard.Effect.WILD);
		new_game.play_wild(wild, unocard.Color.BLUE, true);
		
		
		assertEquals(new_game.valid_color, unocard.Color.BLUE);
		assertEquals(new_game.get_direction(),true);
	}
	
	@Test
	public void checkAiCanPlay() throws Exception {
		game new_game = new game(1);
		String player1 = "Mike";
		new_game.add_player(player1);
		String player2 = "Jason";
		new_game.add_player(player2);
		new_game.start();
		
		new_game.valid_color = unocard.Color.GREEN;
		new_game.valid_effect = unocard.Effect.NUMBER;
		new_game.valid_number = 1;
		
		unocard card0 = new_game.base_AI_play();
		unocard card1 = new_game.game_AI_play();
		unocard.Color color1 = new_game.ai_color();
		ArrayList<unocard> cards = new_game.get_player_list().get(new_game.get_currplayer()).get_hand();
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
		
		assertEquals(true, new_game.allowedToPlay(card0));
		assertEquals(true, new_game.allowedToPlay(card1));
		assertEquals(color, color1);
	}
}
