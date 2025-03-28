import javax.swing.*;
import java.awt.*;

public class Exo1 {
    public static void main(String[] args) {
        // Création de la fenêtre
        JFrame fenetre = new JFrame("Une fenêtre");
        
        // Obtention de la taille de l'écran
        Dimension tailleEcran = Toolkit.getDefaultToolkit().getScreenSize();
        int largeur = tailleEcran.width;
        int hauteur = tailleEcran.height;
        String dimEcran = largeur + " x " + hauteur;
        
        // Création et ajout du JLabel à la fenêtre
        JLabel label = new JLabel("Taille de l'écran : "+dimEcran);
        fenetre.getContentPane().add(label);
        
        // Ajustement de la taille de la fenêtre selon son contenu
        fenetre.pack();
        
        // Placement de la fenêtre au centre de l'écran
        fenetre.setLocation((tailleEcran.width - fenetre.getWidth()) / 2, 
                           (tailleEcran.height - fenetre.getHeight()) / 2);
        
        // Configuration de la fermeture de la fenêtre
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Affichage de la fenêtre
        fenetre.setVisible(true);
    }
}