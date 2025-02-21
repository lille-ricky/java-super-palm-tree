import java.util.Random;

/**
 * Le jeu de bataille se deroule ainsi :
 * Les deux joueurs ont chacun un tas de cartes face cachée. Pour chaque tour de jeu, les deux
 * joueurs retournent une carte de leurs paquets simultanément pour les dévoiler et le joueur qui
 * possède la plus haute carte prend toutes les cartes retournées pour les mettre en dessous de son
 * paquet. En cas d'égalité, personne ne prend les cartes et elles sont laissées retournées tant que
 * personne ne les a récupérées. On joue le tour suivant en déposant les nouvelles cartes au-dessus
 * de celles qui sont retournées. Toutes les cartes doivent être récupérées par un des joueurs pour
 * gagner.
 */
public class Bataille {
    private Joueur player1;  // Changed from FileDeCartes to Joueur
    private Joueur player2;  // Changed from FileDeCartes to Joueur
    private PileDeCartes centerCards;

    /**
     * Built-in class that represents a player
     */
    public class Joueur {
        private FileDeCartes hand;
        private String id;

        /**
         * Constructor of the Joueur class
         * @param id Player identifier
         * @param hand Player's cards
         */
        public Joueur(String id, FileDeCartes hand) {
            this.id = id;
            this.hand = hand;
        }

        /**
         * Checks if the player has any cards left
         * @return true if player has cards, false otherwise
         */
        public boolean aPlusDeCarte() {
            return hand.getSize() > 0;
        }

        /**
         * Plays a card from the hand
         * @return the card played
         */
        public Carte jouerCarte() {
            return hand.retirerCarte();
        }

        /**
         * Recovers cards from the center pile
         * @param centerCards pile of cards to recover
         */
        public void recupererCartes(PileDeCartes centerCards) {
            while (centerCards.getNombreCartes() > 0) {
                Carte drawnCard = centerCards.retirerCarte(null);  // Fixed: passing null as parameter
                this.hand.ajouterCarte(drawnCard);
            }
        }

        /**
         * Returns the id of the player
         * @return player's id
         */
        public String getId() {
            return id;
        }

        /**
         * Returns the number of cards
         * @return number of cards in hand
         */
        public int getNombreCartes() {
            return hand.getSize();
        }
    }

    /**
     * Constructor of the Bataille class
     * Initializes the game by creating and distributing cards to players
     */
    public Bataille() {
        Jeu game = new Jeu();
        game.melangerJeu();

        FileDeCartes player1Cards = new FileDeCartes();
        FileDeCartes player2Cards = new FileDeCartes();

        // Distribute cards to players
        for (int i = 0; i < 52; i++) {
            if (i % 2 == 0) {
                player1Cards.ajouterCarte(game.tirerCarte());
            } else {
                player2Cards.ajouterCarte(game.tirerCarte());
            }
        }

        // Initialize players
        player1 = new Joueur("First Player", player1Cards);
        player2 = new Joueur("Second Player", player2Cards);
        centerCards = new PileDeCartes();
    }

    /**
     * Method that plays a turn
     * @return false if game is over, true otherwise
     */
    public boolean jouerTour() {
        if (!player1.aPlusDeCarte()) {
            System.out.println(player2.getId() + " Won !!!");
            return false;
        }
        if (!player2.aPlusDeCarte()) {
            System.out.println(player1.getId() + " Won!!!");
            return false;
        }

        Carte player1Card = player1.jouerCarte();
        Carte player2Card = player2.jouerCarte();
    
        centerCards.ajouterCarte(player1Card);
        centerCards.ajouterCarte(player2Card);

        if (player1Card.getRank().getRang() > player2Card.getRank().getRang()) {
            System.out.println(player1.getId() + " Gagne le tour avec " + player1Card + " contre " + player2Card); 
            player1.recupererCartes(centerCards);
        } else if (player1Card.getRank().getRang() < player2Card.getRank().getRang()) {  // Fixed: removed extra dot
            System.out.println(player2.getId() + " Gagne le tour avec " + player2Card + " contre " + player1Card); 
            player2.recupererCartes(centerCards);
        } else {
            System.out.println("Égalité, les cartes sont retournées");
            bataille();
        }

        System.out.println(player1.getId() + ": " + player1.getNombreCartes() + " cartes");
        System.out.println(player2.getId() + ": " + player2.getNombreCartes() + " cartes");

        return true;
    }

    /**
     * Handles the battle case when cards are equal
     */
    public void bataille() {
        for (int i = 0; i < 3; i++) {
            if (!player1.aPlusDeCarte() || !player2.aPlusDeCarte()) {
                return;
            }
            centerCards.ajouterCarte(player1.jouerCarte());
            centerCards.ajouterCarte(player2.jouerCarte());
        }
    }

    /**
     * Plays the entire game
     */
    public void jouerPartie() {
        System.out.println("On commence la bataille !");
        while (jouerTour()) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Bataille bataille = new Bataille();
        bataille.jouerPartie();
    }
}