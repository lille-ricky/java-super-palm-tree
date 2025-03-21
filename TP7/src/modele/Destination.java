package modele;

/**
 * Objet qui determine une une destination dans le jeu
 */
public class Destination extends Element {
    /**
     * Renvoie le caractere destinataire
     */
    @Override 
    public char getCaractere() {
        if (estAvecRobot()) {
            return '+';
        } else if (estAvecCaisse()) {
            return '*';
        } else {
            return '.';
        }
    }
    
    /**
     * Renvoie true s'il n'y a pas de caisse associe, false sinon
     */
    @Override 
    public boolean estAccessible() {
        return !estAccessible();
    }
}
