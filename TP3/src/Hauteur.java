/**
 * An enum of the game card numbers and their respective names
 */
public enum Hauteur {
    DEUX(2, "2"),
    TROIS(3, "3"),
    QUATRE(4, "4"),
    CINQ(5, "5"),
    SIX(6, "6"),
    SEPT(7, "7"),
    HUIT(8, "8"),
    NEUF(9, "9"),
    DIX(10,"10"),
    VALET(11,"Valet"),
    DAME(12,"Dame"),
    ROI(13,"Roi"),
    AS(14,"As");

    private final int points;
    private final String name;

    /**
     * Construor of the Hauteur enum
     */
    Hauteur(int points, String name) {
        this.points = points;
        this.name = name;
    }

    /**
     * @return the number of points 
     */
    public int getRang() {
        return this.points;
    }

    /**
     * @return the name of the card
     */
    @Override
    public String toString() {
        return this.name;
    }
}
