/**
 * Tests the Etudiant class
 */
public class TestEtudiant {
    /**
     * TestEtudiant constructor
     * @param args
     */
    public static void main(String[] args) {
        Etudiant e1 = new Etudiant("Pashaj", "Enrik");
        Etudiant e2 = new Etudiant("Ogryzek", "Steve");
        System.out.println(e1);
        System.out.println(e2);
        e1.ajouteNote(15);
        e2.ajouteNote(17);
        e1.ajouteNote(13);
        e2.ajouteNote(8);
        System.out.println(e1);
        System.out.println(e2);
    }
}