public class Main {
    public static void main(String[] args) {
        // Créer le modèle avec les valeurs des cartes
        java.util.List<String> valeurs = java.util.List.of("kat", "mf", "morgana", "nasus", "olaf", "rammus");
        ModeleMemory modele = new ModeleMemory(valeurs);

        // Créer l'interface graphique
        javax.swing.SwingUtilities.invokeLater(() -> new ViewMemory(modele));
    }
}