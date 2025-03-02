import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Exo2 {

    public Exo2() {
        JFrame fenetre = new JFrame("Nombre mysterieux");

        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton btnFin = new JButton("Fin");
        JButton btnCommencer = new JButton("Commencer");

        JLabel lblResultat = new JLabel("Trouvez un nombre entre 0 et 99 ");
        JLabel lblNbCoups = new JLabel("0");

        lblResultat.setHorizontalAlignment(SwingConstants.CENTER);
        lblNbCoups.setHorizontalAlignment(SwingConstants.CENTER);

        JTextField txtSaisie = new JTextField(5);

        // 
        Container cont = fenetre.getContentPane();

        cont.setLayout(new BorderLayout());
        cont.add(lblResultat, BorderLayout.NORTH);

        JPanel panelCenter = new JPanel();
        panelCenter.add(new JLabel("Saisissez : "));
        panelCenter.add(txtSaisie);
        cont.add(panelCenter, BorderLayout.CENTER);

        JPanel panelSouth = new JPanel();
        panelSouth.add(btnCommencer);
        panelSouth.add(btnFin);
        panelSouth.add(new JLabel("Nombre de coups : "));
        panelSouth.add(lblNbCoups);
        cont.add(panelSouth, BorderLayout.SOUTH);

        // associer les controles graphiques au jeu du nbre mysterieux
        LiaisonMystIG.setBtnFin(btnFin);
        LiaisonMystIG.setBtnCommencer(btnCommencer);
        LiaisonMystIG.setLblResultat(lblResultat);
        LiaisonMystIG.setLblNbCoups(lblNbCoups);
        LiaisonMystIG.setZoneSaisie(txtSaisie);



        fenetre.pack();
        fenetre.setLocationRelativeTo(null);
        fenetre.setVisible(true);


    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Exo2();
            }            
        });
    }
}
