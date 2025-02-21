import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Game container for all 52 cards 
 */
public class Jeu {
    private List<Carte> cards;

    /**
     * Constructor for all 52 cards
     */
    public Jeu() {
        cards = new ArrayList<>();
        for (Couleur color : Couleur.values()) {
            for (Hauteur hauteur : Hauteur.values()) {
                cards.add(new Carte(hauteur, color));
            }
        }
    }

    /**
     * Displays the game
     */
    public void afficheJeu() {
        for (Carte card : cards) {
            System.out.println(card);
        }
    }

    /**
     * Shuffles the game cards
     */
    public void melangerJeu() {
        Collections.shuffle(cards);
    }

    /**
     * Draws a card
     */
    public Carte  tirerCarte() {
        if (!cards.isEmpty())  {
            return cards.remove(0);
        }
        return null;
    }


}

