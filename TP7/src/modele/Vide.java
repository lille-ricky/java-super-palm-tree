package modele;

/**
 * 
 */
public class Vide extends Element{
    /**
     * Renvoie le caractere associe au Vide
     */
    @Override 
    public char getCaractere() {
        return '/';
    }

    /**
     * Renvoie true si le mur est accessible.
     * Hint : Le vide n'est pas accessible
     */
    @Override 
    public boolean estAccessible() {
        return false;
    }
}
