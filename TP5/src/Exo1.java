import javax.swing.*; 
import java.awt.*;

public class Exo1 {
    public static void main(String[] args) {
        JFrame fenetre = new JFrame("La fenetre");
        
        Dimension tailleEcran = Toolkit.getDefaultToolkit().getScreenSize();
        int largeur = tailleEcran.width;
        int hauteur = tailleEcran.height;

        JLabel message = new JLabel("Taille de l'ecran : " + largeur + " x " + hauteur);
        message .setHorizontalAlignment(JLabel.CENTER);

        fenetre.getContentPane().add(message);

        fenetre.setSize(300, 100);
        fenetre.setLocationRelativeTo(null);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        fenetre.setVisible(true);

    }
}