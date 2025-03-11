import javax.swing.*;
import java.awt.event.ActionEvent;

public class AProposAction extends AbstractAction {
    private JFrame parent;

    public AProposAction(String name, Icon icon, JFrame parent) {
        super(name, icon);
        this.parent = parent;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(parent, "Jeu de Memory\nAuteur : Enrik Pashaj", "À propos", JOptionPane.INFORMATION_MESSAGE);
    }
}