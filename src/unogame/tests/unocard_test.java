package unogame.tests;

import org.junit.Test;

import unogame.*;
import static org.junit.Assert.assertEquals;

public class unocard_test {
	@Test
	public void getPropertyRightNumberCard() throws Exception {
		unocard card = new unocard(unocard.Color.BLUE, 1);
		
		assertEquals(unocard.Color.BLUE,card.get_color());
		assertEquals(1,card.get_number());
		assertEquals(unocard.Effect.NUMBER,card.get_effect());
	}
	
	@Test
	public void getPropertyRightEffectCard() throws Exception {
		unocard card = new unocard(unocard.Color.BLUE, unocard.Effect.REVERSE);
		
		assertEquals(unocard.Color.BLUE,card.get_color());
		assertEquals(unocard.Effect.REVERSE,card.get_effect());
		assertEquals(-1,card.get_number());
	}
}
