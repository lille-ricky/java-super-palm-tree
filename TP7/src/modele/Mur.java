package modele;

public class Mur extends Element {
    
    /**
     * 
     *  */ 
    @Override
    public char getCaractere() {
        return '#';
    }

    
    /**
     * Renvoie si le mur est accessible.
     * Hint : il n'est pas.
     */
    @Override 
    public boolean estAccessible() {
        return false;
    }
}
