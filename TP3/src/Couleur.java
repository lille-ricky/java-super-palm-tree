/**
 * An enumerate class that contans the four card colors
 */
public enum Couleur{
 
    SPADE("\u2660"), 
    HEART("\u2665"), 
    CLUB("\u2663"), 
    DIAMOND("\u2666");

    private final String symbol;

    /**
     * COnstructor for the color enum 
     * @param symbol
     */
    Couleur(String symbol) {
        this.symbol = symbol;
    }

    /** 
     * Returns the color of the specified card
     */
    @Override
    public String toString() {
        return this.symbol;
    }
};