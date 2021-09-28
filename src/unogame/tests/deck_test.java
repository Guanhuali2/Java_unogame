package unogame.tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import unogame.*;

public class deck_test {
	@Test
	public void checkNewDeckSize() throws Exception {
		deck new_deck = new deck(1);
		assertEquals(108, new_deck.get_deck_size());
	}
	
	@Test
	public void checkNewDeckRedSize() throws Exception {
		deck new_deck = new deck(1);
		ArrayList<unocard> decks = new_deck.get_deck();
		int count = 0;
		for(int i = 0; i < decks.size(); i++) {
			if(decks.get(i).get_color() == unocard.Color.RED) {
				count += 1;
			}
		}
		
		assertEquals(25, count);
	}
	
	@Test
	public void checkNewDeckBlueSize() throws Exception {
		deck new_deck = new deck(1);
		ArrayList<unocard> decks = new_deck.get_deck();
		int count = 0;
		for(int i = 0; i < decks.size(); i++) {
			if(decks.get(i).get_color() == unocard.Color.BLUE) {
				count += 1;
			}
		}
		
		assertEquals(25, count);
	}
	
	@Test
	public void checkNewDeckGreenSize() throws Exception {
		deck new_deck = new deck(1);
		ArrayList<unocard> decks = new_deck.get_deck();
		int count = 0;
		for(int i = 0; i < decks.size(); i++) {
			if(decks.get(i).get_color() == unocard.Color.GREEN) {
				count += 1;
			}
		}
		
		assertEquals(25, count);
	}
	
	@Test
	public void checkNewDeckYellowSize() throws Exception {
		deck new_deck = new deck(1);
		ArrayList<unocard> decks = new_deck.get_deck();
		int count = 0;
		for(int i = 0; i < decks.size(); i++) {
			if(decks.get(i).get_color() == unocard.Color.YELLOW) {
				count += 1;
			}
		}
		
		assertEquals(25, count);
	}
	
	@Test
	public void checkNewDeckWildSize() throws Exception {
		deck new_deck = new deck(1);
		ArrayList<unocard> decks = new_deck.get_deck();
		int count = 0;
		for(int i = 0; i < decks.size(); i++) {
			if(decks.get(i).get_effect() == unocard.Effect.WILD) {
				count += 1;
			}
		}
		
		assertEquals(4, count);
	}
	
	@Test
	public void checkNewDeckWildFSize() throws Exception {
		deck new_deck = new deck(1);
		ArrayList<unocard> decks = new_deck.get_deck();
		int count = 0;
		for(int i = 0; i < decks.size(); i++) {
			if(decks.get(i).get_effect() == unocard.Effect.WILD_F) {
				count += 1;
			}
		}
		
		assertEquals(4, count);
	}
	
	@Test
	public void checkNewDeckReverseSize() throws Exception {
		deck new_deck = new deck(1);
		ArrayList<unocard> decks = new_deck.get_deck();
		int count = 0;
		for(int i = 0; i < decks.size(); i++) {
			if(decks.get(i).get_effect() == unocard.Effect.REVERSE) {
				count += 1;
			}
		}
		
		assertEquals(8, count);
	}
	
	@Test
	public void checkNewDeckSkipSize() throws Exception {
		deck new_deck = new deck(1);
		ArrayList<unocard> decks = new_deck.get_deck();
		int count = 0;
		for(int i = 0; i < decks.size(); i++) {
			if(decks.get(i).get_effect() == unocard.Effect.SKIP) {
				count += 1;
			}
		}
		
		assertEquals(8, count);
	}
	
	@Test
	public void checkNewDeckDrawTwoSize() throws Exception {
		deck new_deck = new deck(1);
		ArrayList<unocard> decks = new_deck.get_deck();
		int count = 0;
		for(int i = 0; i < decks.size(); i++) {
			if(decks.get(i).get_effect() == unocard.Effect.DRAW_TWO) {
				count += 1;
			}
		}
		
		assertEquals(8, count);
	}
	
	@Test
	public void checkNewDeckZeroSize() throws Exception {
		deck new_deck = new deck(1);
		ArrayList<unocard> decks = new_deck.get_deck();
		int count = 0;
		for(int i = 0; i < decks.size(); i++) {
			if(decks.get(i).get_number() == 0) {
				count += 1;
			}
		}
		assertEquals(4, count);
	}
	
	@Test
	public void checkNewDeckOneSize() throws Exception {
		deck new_deck = new deck(1);
		ArrayList<unocard> decks = new_deck.get_deck();
		int count = 0;
		for(int i = 0; i < decks.size(); i++) {
			if(decks.get(i).get_number() == 1) {
				count += 1;
			}
		}
		assertEquals(8, count);
	}
	
	@Test
	public void checkNewDeckTwoSize() throws Exception {
		deck new_deck = new deck(1);
		ArrayList<unocard> decks = new_deck.get_deck();
		int count = 0;
		for(int i = 0; i < decks.size(); i++) {
			if(decks.get(i).get_number() == 2) {
				count += 1;
			}
		}
		assertEquals(8, count);
	}
	
	@Test
	public void checkNewDeckThreeSize() throws Exception {
		deck new_deck = new deck(1);
		ArrayList<unocard> decks = new_deck.get_deck();
		int count = 0;
		for(int i = 0; i < decks.size(); i++) {
			if(decks.get(i).get_number() == 3) {
				count += 1;
			}
		}
		assertEquals(8, count);
	}
	
	@Test
	public void checkNewDeckFourSize() throws Exception {
		deck new_deck = new deck(1);
		ArrayList<unocard> decks = new_deck.get_deck();
		int count = 0;
		for(int i = 0; i < decks.size(); i++) {
			if(decks.get(i).get_number() == 4) {
				count += 1;
			}
		}
		assertEquals(8, count);
	}
	
	@Test
	public void checkNewDeckFiveSize() throws Exception {
		deck new_deck = new deck(1);
		ArrayList<unocard> decks = new_deck.get_deck();
		int count = 0;
		for(int i = 0; i < decks.size(); i++) {
			if(decks.get(i).get_number() == 5) {
				count += 1;
			}
		}
		assertEquals(8, count);
	}
	
	@Test
	public void checkNewDeckSixSize() throws Exception {
		deck new_deck = new deck(1);
		ArrayList<unocard> decks = new_deck.get_deck();
		int count = 0;
		for(int i = 0; i < decks.size(); i++) {
			if(decks.get(i).get_number() == 6) {
				count += 1;
			}
		}
		assertEquals(8, count);
	}
	
	@Test
	public void checkNewDeckSevenSize() throws Exception {
		deck new_deck = new deck(1);
		ArrayList<unocard> decks = new_deck.get_deck();
		int count = 0;
		for(int i = 0; i < decks.size(); i++) {
			if(decks.get(i).get_number() == 7) {
				count += 1;
			}
		}
		assertEquals(8, count);
	}
	
	@Test
	public void checkNewDeckEightSize() throws Exception {
		deck new_deck = new deck(1);
		ArrayList<unocard> decks = new_deck.get_deck();
		int count = 0;
		for(int i = 0; i < decks.size(); i++) {
			if(decks.get(i).get_number() == 8) {
				count += 1;
			}
		}
		assertEquals(8, count);
	}
	
	@Test
	public void checkNewDeckNineSize() throws Exception {
		deck new_deck = new deck(1);
		ArrayList<unocard> decks = new_deck.get_deck();
		int count = 0;
		for(int i = 0; i < decks.size(); i++) {
			if(decks.get(i).get_number() == 9) {
				count += 1;
			}
		}
		assertEquals(8, count);
	}
	
	@Test 
	public void checkShuffledDeck() throws Exception {
		deck new_deck = new deck(1);
		deck another_deck = new deck(1);
		boolean isEqual = new_deck.equals(another_deck);
		assertEquals(false, isEqual);
	}
	
	@Test
	public void checkDrawCard() throws Exception {
		deck new_deck = new deck(1);
		ArrayList<unocard> drawed_card = new_deck.draw_cards(1);
		
		assertEquals(107, new_deck.get_deck_size());
		assertEquals(1, drawed_card.size());
	}
	
	@Test
	public void checkRefillCard() throws Exception {
		deck new_deck = new deck(1);
		ArrayList<unocard> drawed_card = new_deck.draw_cards(108);
		for (int i = 0; i < drawed_card.size(); i++) {
			new_deck.discarded(drawed_card.get(i));
		}
		new_deck.refill_with_discarded_deck();
		assertEquals(107, new_deck.get_deck_size());
		assertEquals(1, new_deck.get_discarded_deck().size());
	}
}
