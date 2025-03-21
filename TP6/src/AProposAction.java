import javax.swing.*;
import java.awt.event.ActionEvent;
/**
 * Classe abstraite en charge de lu menu "A propos" 
 */
public class AProposAction extends AbstractAction {
    /**Le frame parent */
    private JFrame parent;

    /**
     * Constructeur de l'action "A propos"
     * @param name nom
     * @param icon icone
     * @param parent parent
     */
    public AProposAction(String name, Icon icon, JFrame parent) {
        super(name, icon);
        this.parent = parent;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(
            parent, 
            "Jeu de Memory\nAuteur : Enrik Pashaj\n\n\n"
            + "DISCLAIMER\n"
            + "Les images utilisées dans ce jeu de memory sont issues du League of Legends Wiki et sont utilisées conformément à la licence Creative Commons Attribution-NonCommercial-ShareAlike.\n"
            +"Ces images sont la propriété de Riot Games.\n" +
            "Ce jeu est strictement non-commercial et a été créé uniquement à des fins éducatives et de divertissement personnel.\n" +
            "Crédits d'images :\n" 
            +"© League of Legends Wiki  \n" + 
            "\n"  
            +"Licence : CC BY-NC-SA 3.0", 
            "À propos", 
            JOptionPane.INFORMATION_MESSAGE);
    }
}