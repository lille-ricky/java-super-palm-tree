import java.util.ArrayList;
import java.util.List;


public class MemoryGame {
    private List<Carte> cartes;
    private int nbPaires;
    
    private int cartesRetournees;
    private  Carte carteSelectionnee1;
    private  Carte carteSelectionnee2;

    public MemoryGame(int nbPaires) {
        this.nbPaires = nbPaires;
        this.cartes = new ArrayList<>();

        initialiserCartes();
    }

    private void initialiserCartes() {
        for (int i = 0; i < nbPaires; i++) {
            Carte carte1 = new Carte(i);
            Carte carte2 = new Carte(i);

            cartes.add(carte1);
            cartes.add(carte2);
        }
    }

    

}