import java.util.ArrayList;
import java.util.List;
/**
 * Game model, where the card objets are initiated
 */

public class ModeleMemory {
    private List<Carte> cartes;
    private int nbPaires;
    
    private int cartesRetournees;
    private  Carte carteSelectionnee1;
    private  Carte carteSelectionnee2;

    public ModeleMemory(int nbPaires) {
        this.nbPaires = nbPaires;
        this.cartes = new ArrayList<>();

        initialiserCartes();
    }

    /**
     * Game initialisation method 
     */
    private void initialiserCartes() {
        for (int i = 0; i < nbPaires; i++) {
            Carte carte1 = new Carte(i);
            Carte carte2 = new Carte(i);

            cartes.add(carte1);
            cartes.add(carte2);
        }
    }

    /**
     * Flips the card face up
     * @param index the index of the card
     * @return true if the card is flipped face up, false otherwise
     */
    public boolean retournerCarte(int index) {
        Carte carteSelectionnee = cartes.get(index);

        if (carteSelectionnee.estRetournee() || carteSelectionnee.estGagnee()) {
            return false;
        }

        carteSelectionnee.retourner();
        cartesRetournees++;

        if (cartesRetournees == 1) {
            carteSelectionnee1 = carteSelectionnee;
        } else if (cartesRetournees == 2) {
            carteSelectionnee2 = carteSelectionnee;

            if (carteSelectionnee1.getId() == carteSelectionnee2.getId()) {
                carteSelectionnee1.setGagnee(true);
                carteSelectionnee2.setGagnee(true);
            } else {
                retournerCartesFaceCachee();
            }

            cartesRetournees = 0;
        }

        return true;

    }

    /**
     * Returns the cards face down 
     */
    private void retournerCartesFaceCachee() {
        if (carteSelectionnee1 != null) {
            carteSelectionnee1.retournerFaceCachee();
        }
        if (carteSelectionnee2 != null) {
            carteSelectionnee2.retournerFaceCachee();
        }
    }

    /**
     * Checks to see if the game is over
     * @return true if the game is over, false otherwise
     */
    public boolean estTermine() {
        for (Carte carte : cartes) {
            if (!carte.estGagnee()) {
                return false;
            }

        }
        return true;
    }

    /**
     * Card list getter
     */

     public List<Carte> getCartes() {
        return cartes;
     }



}