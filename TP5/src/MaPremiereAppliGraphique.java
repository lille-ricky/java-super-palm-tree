import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MaPremiereAppliGraphique {
    public static final ImageIcon[] TABIMAGES = {
        new ImageIcon("bin/images/Bird.gif"),
        new ImageIcon("bin/images/Bird2.gif"),
        new ImageIcon("bin/images/Cat.gif"),
        new ImageIcon("bin/images/Cat2.gif"),
        new ImageIcon("bin/images/Dog.gif"),
        new ImageIcon("bin/images/Dog2.gif"),
        new ImageIcon("bin/images/Rabbit.gif")
    };
    
    public static void main(String[] args) {
        JFrame fenetre = new JFrame("Les images");
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setSize(400, 300);
        
        JButton leBtn = new JButton(TABIMAGES[0]);
        
        fenetre.getContentPane().add(leBtn, BorderLayout.CENTER);
        
        leBtn.addActionListener(new GereClickBouton(leBtn));
        
        fenetre.setVisible(true);
    }
}

class GereClickBouton implements ActionListener {
    private int compteur;
    private JButton btn;
    
    public GereClickBouton(JButton btn) {
        this.compteur = 0;
        this.btn = btn;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        compteur++;
        
        if (compteur >= MaPremiereAppliGraphique.TABIMAGES.length) {
            compteur = 0;
        }
        
        btn.setIcon(MaPremiereAppliGraphique.TABIMAGES[compteur]);
    }
}