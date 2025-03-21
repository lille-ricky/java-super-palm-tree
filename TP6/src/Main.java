/**
 * Classe manifest du projet
 */
public class Main {
    /**
     * Constructeur du manifeste
     * @param args vide
     */
    public static void main(String[] args) {
        java.util.List<String> valeurs = java.util.List.of("kat", "mf", "morgana", "nasus", "olaf", "rammus");
        ModeleMemory modele = new ModeleMemory(valeurs);

        // GUI
        javax.swing.SwingUtilities.invokeLater(() -> new ViewMemory(modele));
    }
}