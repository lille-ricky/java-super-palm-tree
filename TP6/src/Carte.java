
/**
 * Represents a card in the game 
 */
public class Carte {
    private int id;
    private boolean retournee;
    private boolean gagnee;

    /**
     * Card constructor 
     * @param id the id of the card
     */
    public Carte(int id) {
        this.id = id;
        this.retournee = false;
        this.gagnee = false;
    }

    /**
     * Returns the id of the card
     * @return the id of the card
     */
    public int getId() {
        return id;
    }

    /**
     * Returns true if the card has been flipped, false otherwise.
     * @return true if the card is flipped. false otherwise
     */
    public boolean estRetournee() {
        return retournee;
    }

    /**
     * Returns true if the couple has been found, false otherwise
     * @return true if the same image couple has been found, flase otherwise
     * 
     */
    public boolean estGagnee() {
        return gagnee;
    }

    /**
     * Flips the card
     */
    public void retourner() {
        retournee = true;
    }

    /**
     * Flips the card face down
     */
    public void retournerFaceCachee() {
        retournee = false;
    }

    /**
     * Defines the card's winning status by passing ti tas a parameter
     */
    public void setGagnee(boolean gagnee) {
        this.gagnee = gagnee;
    }
    
}
