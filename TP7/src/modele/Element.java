package modele;
/**
 * Un element base du jeu
 */
public abstract class Element {
    protected boolean avecCaisse;
    protected boolean avecRobot;


    /**
     * Constructeur de l'element
     */
    public Element() {
        this.avecCaisse = false;
        this.avecRobot = false;
    }

    //----------------------------Getters 

    /**
     * renvoie true si le joueur est avec la caisse, false sinon
     */
    public boolean estAvecCaisse() {
        return avecCaisse;
    }

    /**
     */
    public boolean estAvecRobot() {
        return avecRobot;
    }

    // ----------------------------Setters 

    /**
     * Definit la variable avecCaisse
     */
    public void setAvecCaisse(boolean newCaisse) {
        this.avecCaisse = newCaisse;
    }

    /**
     * defini la variable avecRobot par la le parametre passee
     */
    public void setAvecRobot(boolean newRobot) {
        this.avecRobot = newRobot;
    }

    /**
     * 
     */
    public abstract char getCaractere();

    /**
     * 
     */
    public abstract char estAccessible();

}