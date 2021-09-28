package unogame;

public class unocard{
    
    public enum Color {RED, GREEN, YELLOW, BLUE, NONE}   //Card may have five types of color, and None represent cards like Wild and Wild4
    public enum Effect {DRAW_TWO, REVERSE, SKIP, WILD, WILD_F, NUMBER} //Card may have six types of effect
    
    private Color color;
    private Effect effect;
    private int number;
    
    /**
     * Constructor for non-number cards 
     * @param color: Color that will be assigned to this card
     * @param effect: Effect that will be assigned to this card
     */
    public unocard(Color color, Effect effect){
        this.color = color;
        this.effect = effect;
        this.number = -1;
    }

    /**
     * Constructor for number cards 
     * @param color: Color that will be assigned to this card
     * @param i: numbers that will be assigned to this card 
     */
    public unocard(Color color, int i){
        this.color = color;
        this.effect = Effect.NUMBER;
        this.number = i;
    }
    
    /**
     * return this card's color
     */
    public Color get_color() {
    	return color;
    }
    
    /**
     * return this card's number
     */
    public int get_number() {
    	return number;
    }
    
    /**
     * return this card's effect
     */
    public Effect get_effect() {
    	return effect;
    }
    
    
}