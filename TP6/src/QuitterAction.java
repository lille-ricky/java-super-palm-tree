import javax.swing.*;
import java.awt.event.ActionEvent;
/**
 * Classe abstraite en charge de l'action "Quitter" du jeu 
 */
public class QuitterAction extends AbstractAction {
    /**
     * Constructeur de l'action quitter
     * @param name name
     * @param icon icon
     */
    public QuitterAction(String name, Icon icon) {
        super(name, icon);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0); 
    }
}