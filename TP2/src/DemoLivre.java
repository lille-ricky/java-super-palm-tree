/**
 * Classe de test de Livre
 * Il y a juste une methode main
 */
public class DemoLivre {
    /**
     * Classe de test d'un objet livre
     * @param args default arguments
     */
    public static void main(String[] args) {
        System.out.println("Test creation du livre :");
        Livre monLivre1 = new Livre("Steppenwolf", "Herman Hesse", "jack Bauer", Livre.Genre.LITTERATURE_ETRANGERE);
        System.out.println(monLivre1);
        System.out.println();

        System.out.println(" Test ajout d'exemplaire :");
        monLivre1.ajouterExemplaire();
        System.out.println("Nombre d'exemplaires : " + monLivre1.getExemplaires());
        monLivre1.ajouterExemplaires(3);
        System.out.println("Apres l'ajout de trois exemplaires : " + monLivre1.getExemplaires());
        System.out.println();

        System.out.println("Test de perte d'exemplaire :");
        boolean pertePossible = monLivre1.signalerPerte();
        System.out.println("Perte signalee succesfully : " + pertePossible);
        System.out.println("Nombre d'exemplaires apres perte : " + monLivre1.getExemplaires());
        System.out.println("Nombre d'exemplaires apres perte : " + monLivre1.getExemplaires());
        System.out.println();

        // Test de rpesence
        System.out.println("Le livre est present : " + monLivre1.estPresent());
        System.out.println();

        // Test de comparaison des livres
        Livre monLivre2 = new Livre("Steppenwolf", "Herman Hesse", "LIRIA", Livre.Genre.LITTERATURE_ETRANGERE);
        Livre monLivre3 = new Livre("Steppenwolf", "Herman Hesse", "Penguin Publishing", Livre.Genre.LITTERATURE_ETRANGERE);

        System.out.println("Livres identiques : " + monLivre1.equals(monLivre2));
        System.out.println("Livres differents : " + monLivre1.equals(monLivre3));
        System.out.println();

        // Test creation nouvel edition 
        Livre nouvelEdition = monLivre1.nouvelEditeur("Blacksmith");
        System.out.println("Nouvel edition du livre :" + nouvelEdition);
        System.out.println();

        // Test des cas limites
        System.out.println("7. Test des cas limites :");

        try {
            Livre livreInvalide = new Livre(null, "Auteur", "Editeur", Livre.Genre.NON_SPECIFIE);   
        } catch (IllegalArgumentException e){
            System.out.println("Exception attendue pour titre null :" + e.getMessage());

        }

        try {
            monLivre1.ajouterExemplaires(-1);
        } catch (IllegalArgumentException e) {
            System.out.println("exception attendue pour nombre negatif d'argument :" + e.getMessage());
        }

    }
}
