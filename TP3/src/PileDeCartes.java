import java.util.ArrayList;
import java.util.List;
/**
 * A stack works using the last in, first out (LIFO) principle
 * 
 */
public class PileDeCartes {
    private static final int MAX_CAPACITY = 52;
    private List<Carte> cards;
    /**
     * Constructor of an empty stack
     */
    public PileDeCartes() {
        cards = new ArrayList<>();
    }

    /**
     * Adds a card to the stack
     * @param card
     */
    public void ajouterCarte(Carte card) {
        if (cards.size() < MAX_CAPACITY) {
            cards.add(card);
        } else {
            System.out.println("La pile est pleine, carte non ajoute.");
        }
    }

    /**
     * Removes a card from the stack
     * 
     */
    public Carte retirerCarte(Carte card) {
        if (!cards.isEmpty()) {
            return cards.remove(cards.size() - 1);
        } else {
            System.out.println("La pile est vide, on ne peut pas retirer une carte inexistente ;)");
            return null;
        }

    }

    /**
     * Number of cards getter 
     */
    public int getNombreCartes() {
        return cards.size();
    }

}