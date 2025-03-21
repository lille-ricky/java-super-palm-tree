import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
/**
 * Classe en charge du vue du jeu 
 */
public class ViewMemory {
    private ModeleMemory modele;
    private JFrame frame;
    private JButton[] boutonsCartes;
    private int premiereCarteIndex = -1;
    private int deuxiemeCarteIndex = -1;
    private Timer timer;
    private JLabel essaisLabel;
    private JLabel imagesLabel;
    private boolean enAttente = false;

    /**
     * Constructeur de la classe ViewMemory.
     * 
     * @param modele Le modèle du jeu.
     */
    public ViewMemory(ModeleMemory modele) {
        this.modele = modele;
        initialiserInterface();
    }

    /**
     * Initialise l'interface graphique.
     */
    private void initialiserInterface() {
        // L'entete du programme
        frame = new JFrame("Jeu de Memory");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JMenuBar menuBar = new JMenuBar();

        /**
         * Le menu du jeu, qui contient les options de : 
         * - Commencer une nouvelle partie
         * - Quitter le jeu
         */
        JMenu jeuMenu = new JMenu("Jeu");
        JMenuItem nouvellePartieItem = new JMenuItem(new RecommencerAction("Nouvelle partie", null, this));
        JMenuItem quitterItem = new JMenuItem(new QuitterAction("Quitter", null));
        jeuMenu.add(nouvellePartieItem);
        jeuMenu.add(quitterItem);
        menuBar.add(jeuMenu);

        /**
         * Le menu a propos qui donne les informations generales du projet
         */
        JMenu aideMenu = new JMenu("Aide");
        JMenuItem aProposItem = new JMenuItem(new AProposAction("À propos...", null, frame));
        aideMenu.add(aProposItem);
        menuBar.add(aideMenu);

        frame.setJMenuBar(menuBar);

        /**
         * Le panel des cartes
         */
        JPanel cardPanel = new JPanel(new GridLayout(2, modele.getCartes().size() / 2));
        frame.add(cardPanel, BorderLayout.CENTER);

        boutonsCartes = new JButton[modele.getCartes().size()];
        for (int i = 0; i < boutonsCartes.length; i++) {
            boutonsCartes[i] = new JButton();
            boutonsCartes[i].setIcon(new ImageIcon("images/twistedFate.png"));
            boutonsCartes[i].addActionListener(new CarteClickListener(i));
            cardPanel.add(boutonsCartes[i]);
        }

        JPanel infoPanel = new JPanel();
        essaisLabel = new JLabel("Essais : 0");
        imagesLabel = new JLabel("Images gagnées : 0");
        infoPanel.add(essaisLabel);
        infoPanel.add(imagesLabel);
        frame.add(infoPanel, BorderLayout.SOUTH);

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (premiereCarteIndex != -1 && deuxiemeCarteIndex != -1) {
                    modele.retournerCarte(premiereCarteIndex);
                    modele.retournerCarte(deuxiemeCarteIndex);
                    mettreAJourAffichage();

                    premiereCarteIndex = -1;
                    deuxiemeCarteIndex = -1;

                    enAttente = false;
                }
            }
        });

        timer.setRepeats(false);

        // Fait en sorte de definir la taille du JFrame par rapport au ecran
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();

        frame.setSize(screenSize);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /**
     * Met à jour l'affichage des cartes.
     */
    private void mettreAJourAffichage() {
        List<Carte> cartes = modele.getCartes();
        for (int i = 0; i < cartes.size(); i++) {
            if (cartes.get(i).estVisible()) {
                boutonsCartes[i].setIcon(new ImageIcon("images/" + cartes.get(i).getValeur() + ".png"));
            } else {
                boutonsCartes[i].setIcon(new ImageIcon("images/twistedFate.png"));
            }
        }

        essaisLabel.setText("Essais : " + modele.getNombreEssais());
        imagesLabel.setText("Images gagnées : " + (modele.getCartes().size() / 2 - modele.getPairesRestantes()));

        if (modele.estTermine()) {
            int choix = JOptionPane.showOptionDialog(
                    frame,
                    "Félicitations, vous avez gagné en " + modele.getNombreEssais() + " essais !",
                    "Partie terminée",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    new String[] { "Nouvelle partie", "Fermer" },
                    "Nouvelle partie");

            if (choix == JOptionPane.YES_OPTION) {
                recommencerJeu();
            }
        }
    }

    /**
     * Recommence une nouvelle partie.
     */
    public void recommencerJeu() {
        modele.initialiserJeu();
        for (JButton bouton : boutonsCartes) {
            bouton.setActionCommand("");
            bouton.setIcon(new ImageIcon("images/twistedFate.png"));
        }
        enAttente = false;
        premiereCarteIndex = -1;
        deuxiemeCarteIndex = -1;
        mettreAJourAffichage();
    }

    /**
     * Classe interne pour gérer les clics sur les cartes.
     */
    private class CarteClickListener implements ActionListener {
        private int index;

        public CarteClickListener(int index) {
            this.index = index;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if ("desactivee".equals(((JButton) e.getSource()).getActionCommand())) {
                return;
            }

            if (modele.estTermine() || enAttente) {
                return;
            }

            if (premiereCarteIndex == -1) {
                premiereCarteIndex = index;
                modele.retournerCarte(index);
            } else if (deuxiemeCarteIndex == -1 && index != premiereCarteIndex) {
                deuxiemeCarteIndex = index;
                modele.retournerCarte(index);

                if (modele.verifierPaire(premiereCarteIndex, deuxiemeCarteIndex)) {
                    boutonsCartes[premiereCarteIndex].setActionCommand("desactivee");
                    boutonsCartes[deuxiemeCarteIndex].setActionCommand("desactivee");

                    premiereCarteIndex = -1;
                    deuxiemeCarteIndex = -1;
                } else {
                    enAttente = true;
                    timer.start();
                }
            }

            mettreAJourAffichage();
        }
    }
}