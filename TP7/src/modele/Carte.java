package modele;

import java.util.ArrayList;
import java.util.List;

/**
 * Represent une carte dans le jeu 
 */
public class Carte {
    private Element[][] elements;
    private int largeur;
    private int hauteur;
    private int posRobotX; 
    private int posRobotY;

    /**
     * Constructeur d'une carte
     */
    public Carte(List<String> representation) {
        this.hauteur = representation.size();
        this.largeur = 0;

        for (String ligne : representation) {
            if (ligne.length() > this.largeur) {
                this.largeur = ligne.length();
            }
        }

        this.elements = new Element[hauteur][largeur];

        for (int y = 0; y < hauteur; y++) {
            String ligne = representation.get(y);
            for (int x = 0; x < ligne.length(); x++) {
                char c = ligne.charAt(x);


                switch(c) {
                    case '#': 
                        elements[y][x] = new Mur();
                        break;
                    case '/':
                        elements[y][x] = new Vide();
                        break;
                    case '.':
                        elements[y][x] = new Sol();
                        break; 
                    case ',':
                        elements[y][x] = new Destination();
                        break;
                    case '@':
                        elements[y][x] = new Sol();
                        elements[y][x].setAvecRobot(true);
                        break;
                    case '*':
                        elements[y][x] = new Destination();
                        elements[y][x].setAvecCaisse(true);
                        break;
                    case '$':
                        elements[y][x] = new Sol();
                        elements[y][x].setAvecCaisse(true);
                        break;
                    case '+':
                        elements[y][x] = new Destination();
                        elements[y][x].setAvecRobot(true);
                        posRobotX = x;
                        posRobotY = y;
                        break;
                    // Sinon vide par defaut
                    default :
                        elements[y][x] = new Vide();
                    
                }
            }

            for (int x = ligne.length(); x < largeur; x++) {
                elements[y][x] = new Vide();
            }
        }
    }

    /*
     * Deplace le robot dans la distance passe en parametre, renvoie true si deplacement effectue,
     * false sinon.
     */
    public boolean deplacerRobot(int dx, int dy) {
        int nouveauX = posRobotX + dx;
        int nouveauY = posRobotY + dy;

        if (nouveauX < 0 || nouveauX >= largeur || nouveauY < 0) {
            return false;
        }

        Element elementCourant = elements[posRobotY][posRobotX];
        Element elementCible = elements[nouveauY][nouveauX];

        if (elementCible.estAccessible()) {
            elementCourant.setAvecRobot(false);
            elementCible.setAvecRobot(true);
            posRobotX = nouveauX;
            posRobotY = nouveauY;
            return true;
        }
        else if (elementCible.estAvecCaisse()) {
            int posApresCaisseX = nouveauX + dx;
            int posApresCaisseY = nouveauY + dy;

            if (posApresCaisseX < 0 || posApresCaisseX >= largeur ||
                posApresCaisseY < 0 || posApresCaisseY >= hauteur) {
                    return false;
                }
        }
    }




}
