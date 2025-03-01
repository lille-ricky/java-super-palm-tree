import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Exo1b {
    public static void main(String[] args) {
        JFrame fenetre = new JFrame("Une fenêtre");

        Dimension tailleEcran = Toolkit.getDefaultToolkit().getScreenSize();
        int largeur = tailleEcran.width;
        int hauteur = tailleEcran.height;
        String dimEcran = largeur + " x " + hauteur;
        

        URL url = Exo1b.class.getResource("images/Bird2.gif");
        JLabel label = new JLabel(new ImageIcon(url));

        
        fenetre.getContentPane().add(label);
        

        fenetre.pack();
        

        fenetre.setLocation((tailleEcran.width - fenetre.getWidth()) / 2, 
                           (tailleEcran.height - fenetre.getHeight()) / 2);
        
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        fenetre.setVisible(true);
    }
}