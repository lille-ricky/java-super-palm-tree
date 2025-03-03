import javax.swing.*;
import java.awt.*;

public class Exo2d {
    
    public Exo2d() {
        JFrame fenetre = new JFrame("GridLayout Example");
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Container cont = fenetre.getContentPane();
        
        

        cont.setLayout(new GridLayout(3, 2, 5, 5));

        cont.add(new JLabel("Trouvez un nbre entre 0 et 99"));
        cont.add(new JTextField(5));
        cont.add(new JButton("Commencer"));
        cont.add(new JButton("Fin"));
        cont.add(new JLabel("Nombre de coups:"));
        cont.add(new JLabel("0"));

        
        fenetre.pack();
        fenetre.setLocationRelativeTo(null);
        fenetre.setVisible(true);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Exo2d();
            }
        });
    }
}