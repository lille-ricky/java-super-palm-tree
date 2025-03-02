import javax.swing.*;
import java.awt.*;

public class Exo2c {
    
    public Exo2c() {
        JFrame fenetre = new JFrame("BoxLayout Example");
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Container cont = fenetre.getContentPane();
        
        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel label = new JLabel("Trouvez un nbre entre 0 et 99");
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(label);

        JTextField txtField = new JTextField(5);
        txtField.setMaximumSize(new Dimension(100, 30));
        txtField.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(txtField);

        JButton btnCommencer = new JButton("Commencer");
        btnCommencer.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(btnCommencer);

        JButton btnFin = new JButton("Fin");
        btnFin.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(btnFin);

        JLabel lblCoups = new JLabel("Nombre de coups : 0");
        lblCoups.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(lblCoups);



        fenetre.getContentPane().add(panel);
        
        fenetre.pack();
        fenetre.setLocationRelativeTo(null);
        fenetre.setVisible(true);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Exo2c();
            }
        });
    }
}