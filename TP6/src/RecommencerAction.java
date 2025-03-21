import javax.swing.*;
import java.awt.event.ActionEvent;
/**
 * Classe en charge de l'action "Recommencer jeu" dans le menu integre
 */
public class RecommencerAction extends AbstractAction {
    /**Instance de view */
    private ViewMemory viewMemory; 

    /**
     * Constructeur de la classe recommencer action
     * @param name nom
     * @param icon icone
     * @param viewMemory la classe view
     */
    public RecommencerAction(String name, Icon icon, ViewMemory viewMemory) {
        super(name, icon);
        this.viewMemory = viewMemory;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        viewMemory.recommencerJeu(); 
    }
}