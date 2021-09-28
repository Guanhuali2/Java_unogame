package unogame.tests;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import unogame.*;

public class player_test {
	@Test
	public void canCreateNewPlayer() throws Exception {
		String player1 = "Jason";
		player play_1 = new player(player1);
		
		assertEquals("Jason", play_1.pname);
	}
	
	@Test
	public void checkEmpty() throws Exception {
		String player1 = "Jason";
		player play_1 = new player(player1);
		
		assertEquals(play_1.is_empty(), true);
	}
	
	@Test
	public void canAddCard() throws Exception {
		String player1 = "Jason";
		player play_1 = new player(player1);
		unocard card = new unocard(unocard.Color.BLUE,1);
		play_1.add_hand(card);
		
		assertEquals(play_1.get_hand().size(), 1);
		assertEquals(play_1.get_hand().get(0),card);
		
	}
	
	@Test
	public void canRemoveCard() throws Exception {
		String player1 = "Jason";
		player play_1 = new player(player1);
		unocard card = new unocard(unocard.Color.BLUE,1);
		play_1.add_hand(card);
		
		play_1.remove_hand(card);
		assertEquals(true,play_1.is_empty());
	}
}
