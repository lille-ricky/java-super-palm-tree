/**
 * Handles the queue of cards using the circular buffer data structure (FIFO)
 */
public class FileDeCartes {
    private static final int MAX_CAPACITY = 52;
    private Carte[] cards;
    private int front, rear, size;


     /**
      * Constructor for the queue of cards
      */
    public FileDeCartes() {
        cards = new Carte[MAX_CAPACITY];
        front = 0;
        rear = -1;
        size = 0;
    }

    /**
     * Adds a card to the queue
     */
    public void ajouterCarte(Carte card) {
        if (size < MAX_CAPACITY) {
            rear = (rear + 1) % MAX_CAPACITY;
            cards[rear] = card;
            size++;
        }
    }

    /**
     * Removes a card from the queue
     */
    public Carte retirerCarte() {
        if (size > 0) {
            Carte removedCard = cards[front];
            front = (front + 1) % MAX_CAPACITY;
            size--;
            return removedCard;
        } else {
            System.out.println("La file est vide, on ne peut pas retirer une carte inexistente ;)");
            return null;
        }

    }

    /**
     * Size getter
     */
    public int getSize() {
        return size;
    }
}