import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MaPremiereAppliGraphique {
    
    private static final ImageIcon[] TABIMAGES = {
        new ImageIcon("images/Bird.gif"),
        new ImageIcon("images/Bird2.gif"),
        new ImageIcon("images/Cat.gif"),
        new ImageIcon("images/Cat2.gif"),
        new ImageIcon("images/Dog.gif"),
        new ImageIcon("images/Dog2.gif"),
        new ImageIcon("images/Pig.gif")
    };
    
    private int currentImageIndex = 0;
    private JLabel imageLabel;
    
    public MaPremiereAppliGraphique() {
        JFrame fenetre = new JFrame("Les images");
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        imageLabel = new JLabel(TABIMAGES[currentImageIndex]);
        
        imageLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Passage à l'image suivante
                currentImageIndex = (currentImageIndex + 1) % TABIMAGES.length;
                imageLabel.setIcon(TABIMAGES[currentImageIndex]);
            }
        });
        
        fenetre.getContentPane().add(imageLabel, BorderLayout.CENTER);
        
        fenetre.pack();
        fenetre.setLocationRelativeTo(null);
        fenetre.setVisible(true);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MaPremiereAppliGraphique();
            }
        });
    }
}