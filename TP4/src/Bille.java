/**
 * Une bille dans le jeu
 */
public class Bille {
    private int couleur;
    private boolean vide;

    /**
     * Constructeur de la bille
     */
    public Bille() {
        this.vide = true;
        this.couleur = -1; // par defaut vide
    }

    /**
     * Renvoie la couleur de la bille
     * @return la vouleur de la bille
     */
    public int getCouleur() {
        return couleur;
    }

    /**
     * definie la couelur
     */
    public void setCouleur(int couleur) {
        if (couleur < -1) {
            throw new IllegalArgumentException("Invalid color");
        }
        this.couleur = couleur;
        this.vide = (couleur == -1);
    }

    /**
     * Verifie si la cellulle est vide
     * @return true si la cellule est vide, false sinon
     */
    public boolean estVide() {
        return vide;
    }

    /**
     * Definie la variable vide
     */
    public void setVide(boolean vide) {
        this.vide = vide;
        if (vide) {
            this.couleur = -1;
        }
    }

    
}
