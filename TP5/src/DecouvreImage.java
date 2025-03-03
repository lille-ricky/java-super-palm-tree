import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DecouvreImage {

    public static void main(String[] args){
        JFrame fenetre = new JFrame("Images");
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        fenetre.setLayout(new GridLayout(2, 2));

        fenetre.add(new UneImage(0));
        fenetre.add(new UneImage(1));
        fenetre.add(new UneImage(2));
        fenetre.add(new UneImage(3));

        fenetre.setSize(400, 400);
        fenetre.setLocationRelativeTo(null);
        fenetre.setVisible(true);
    }
}

class UneImage extends JButton implements MouseListener {
    private static final ImageIcon[] TABIMAGES = {
        new ImageIcon("bin/images/Bird.gif"),
        new ImageIcon("bin/images/Bird2.gif"),
        new ImageIcon("bin/images/Cat.gif"),
        new ImageIcon("bin/images/Cat2.gif"),
        new ImageIcon("bin/images/Dog.gif"),
        new ImageIcon("bin/images/Dog2.gif"),
        new ImageIcon("bin/images/Pig.gif"),
        new ImageIcon("bin/images/Rien.gif")
    };

    private int indice;

    public UneImage(int indice) {
        this.indice = indice;

        setIcon(TABIMAGES[7]);
        addMouseListener(this);
    }


    @Override
    public void mouseEntered(MouseEvent e) {
        setIcon(TABIMAGES[indice]);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        setIcon(TABIMAGES[5]);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override 
    public void mousePressed(MouseEvent e) {

    }

    @Override 
    public void mouseReleased(MouseEvent e) {

    }
}
