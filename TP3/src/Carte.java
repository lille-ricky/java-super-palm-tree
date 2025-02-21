/**
 * Represents a card in the game, having a rank and a color
 */
public class Carte {
    private final Hauteur rank;
    private final Couleur color;
    /**
     * Constructor for the card object
     */
    public Carte(Hauteur rank, Couleur color) {
        this.rank = rank;
        this.color = color;
    }

    /**
     * Rank getter
     * @return the card's rank
     */
    public Hauteur getRank() {
        return rank;
    }

    /**
     * Color getter
     * @return the card's color
     */
    public Couleur getColor(){
        return color;
    }

    @Override
    public String toString(){
        return this.rank.toString() + this.color.toString();
    }
}
