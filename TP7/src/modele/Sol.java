package modele;
/**
 * Represente le sol
 */
public class Sol extends Element{

    /**
     * 
     */
    @Override
    public char getCaractere() {
        if (estAvecRobot()) {
            return '@';
        } else if (estAvecCaisse()) {
            return '$';
        } else {
            return '.';
        }

    }

    /**
     * Methode qui verifie si le sol est accessible,
     * true s'il n'y a pas de caisse associe, false sinon.
     */
    @Override 
    public boolean estAccessible() {
        return !estAvecCaisse();
    }
    
}
