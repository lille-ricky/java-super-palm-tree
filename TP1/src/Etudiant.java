/**
 * Classe qui modelise la gestion d'un etudiant dans une universite.
 */
public class Etudiant {
    public final static int MAXNOTES = 10;
    public final static int MINVALUE = 0;
    public final static int MAXVALUE = 20;

    private String nom;
    private String prenom;
    private boolean estAdmis = false;

    // private Formation formation;

    private float[] lesNotes = new float[MAXNOTES];
    private int nbNotes; // nombre actuel de notes de l'etudiant

    /**
     * Constructeur d'un etudiant
     * @param nom : le nom de l'etudiant 
     * @param prenom : le prenom de l'etudiant
     */
    public Etudiant(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;

    }

    /** accesseur pour le nom de l'etudiant
     * @return le nom de l'etudiant
     */
    public String getNom() {
        return nom;
    }

    /** accesseur pour le prenom de l'etudiant
     * @return le nprenom de l'etudiant
     */
    public String getPrenom(){
        return prenom;
    }

    /**
     * Renvoie l'etat d'admission en diplome, false par defaut.
     * @return true si l'etudiant est admis dans le diplome, flase sinon
     */
    public boolean getAdmission() {
        return estAdmis;
    }

    /** return une presentation textuelle d'un etuediant :
     * son nom, son prenom, son nombre de notes
     */
    public String toString(){
        return prenom + " " + nom + ", " + nbNotes + " notes(s) .";
    }

    /**
     * ajoute une note a un etudiant dans la limite de la capacite de l'etudiant 
     * @param note; la note qu'on peut ajoputer a l'etudiant
     * @return vrai si l'ajout a pu etre fait */
    public boolean ajouteNote(float note) {
        float noteMin = 0;
        // cas du plus petit
        for(int i = 0; i < lesNotes.length; i++) {
            if (lesNotes[i] < noteMin) {
                noteMin = lesNotes[i];
            }
        }

        if (nbNotes < lesNotes.length && note > noteMin) {
            lesNotes[nbNotes] = note;
            nbNotes++;
            return true;
        }
        return false;
    }
    
    /**
     * Calculer la moyenne de l'etudiant
     * @return la moyenne de l'etudiant
     */
    public float calculMoyenne() {
        if (lesNotes.length == 5) {
            float somme = 0;
            for (int i = 0; i < lesNotes.length; i++) {
                somme += lesNotes[i];
            }
            return somme / lesNotes.length;
        }

        return -1;
    }

    /**
     * Calcule l'admission de l'etudiant dans la promotion
     * 
     */
    public void calculAdmission() {
        float moyenne = calculMoyenne();
        if (moyenne >= 10) {
            estAdmis = true;
        }
        getAdmission();
    }
    

    

}