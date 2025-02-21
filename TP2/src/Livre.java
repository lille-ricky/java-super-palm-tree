/**
 * Book class
 * 
 */
public class Livre {
    /**
     * Enumere les genres possibles du livre 
     */
    public enum Genre {
        /** Litterature francaise */
        LITTERATURE_FRANCAISE,
        /**Litterature jeunesse */
        LITTERATURE_JEUNESSE,
        /**Litterature Etrangere */
        LITTERATURE_ETRANGERE,
        /**Roman Policier */
        POLICIER,
        /**Roman Politique */
        POLITIQUE,
        /**Livre scientifique */
        SCIENCES,
        /**Livre en Sciences Humaines */
        SCIENCES_HUMAINES,
        /** Livre non specifie */
        NON_SPECIFIE
    }
    private  final String titre;
    private  final String auteur;
    private  final String editeur;
    private Genre genre;
    private int exemplaires;

    /**
     * Constructeur Livre
     * @param titre le titre du livre
     * @param auteur le nom de l'auteur
     * @param editeur l'editeur
     * @param genre le genre du livre
     */
    public Livre(String titre, String auteur, String editeur, Genre genre) {
        if (titre == null || auteur == null || editeur == null) {
            throw new IllegalArgumentException("L'auteur, le titre ou l'editeur ne doivent pas etre nuls.");
        }
        this.titre = titre;
        this.auteur = auteur;
        this.editeur = editeur;
        this.exemplaires = 1;
        this.genre = genre;
    }

    /**
     * Renvoie le titre du livre
     * @return le titre du livre
     */
    public String getTitre() {
        return titre;
    }

    /**
     * Renvoie le nom de l'auteur du livre
     * @return le nom de l'auteur du livre
     */
    public String getAuteur() {
        return auteur;
    } 

    /**
     * Renvoie le nom de l'editeur du livre
     * @return le nom de l'editeur du livre
     */
    public String getEditeur() {
        return editeur;
    }

    /**
     *  Renvoie le nombre d'exemplaires du livre
     * @return le nombre d'exemplaires du livre
     */
    public int getExemplaires() {
        return this.exemplaires;
    }

    /**
     * Ajoute un exemplaire dans un 
     *
     */
    public void ajouterExemplaire() {
        this.exemplaires++;
    }

    /**
     * 
     * Ajoute un certain nombre specifie d'exemplaires
     * @param nombre specifie d'exemplaires a ajouter
     */
    public void ajouterExemplaires(int nombre) {
        if (nombre <= 0) {
            throw new IllegalArgumentException("Le nombre d'exemplaires doit etre positif.");
        }
        this.exemplaires += nombre;
    }

    /**
     * Supprime un nombre d'exemplaires
     *
     */
    public void suppExemplaire(){
        if (this.exemplaires == 0) {
            throw new IllegalStateException("Exemplaire ne peut pas etre negatif");
        }
        this.exemplaires--;
    }

    /**
     * 
     * Signale la perte d'un exemplaire du livre
     * @return true si un exemplaire du livre a ete perdu, false sinon
     */
    public boolean signalerPerte() {
        if (this.exemplaires > 0) {
            this.exemplaires--;
            return true;
        }

        return false;
    }

    /**
     * Renvoie vrai si le livre est reelement present dans le bibliobuis, false sinon
     * @return true si le livre est reelement present dans le b
     */
    public boolean estPresent() {
        return this.exemplaires > 0;
    }

    /**
     * Affiche les informations du livre
     * @return une chaine de caracteres decrivant les attributs du livre
     * */
    public String toString() {
        return "Livre : " + " titre : " + titre + "," + " auteur : " + auteur + ", " + " editeur : " + editeur + "," + " grenre : " + genre + "," + " nombre d'exemplaires : " + exemplaires;
    }


    /**
     * Definie le genre du livre
     * @param genre le genre a difinir
     */
    public void setGenre(Genre genre) {
        this.genre = genre;
    }
     
    /**
     * Verifie si deux livre sont representatifs de la meme oeuvre
     * @return true si les objects sont egaux, false sinon
     */
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Livre livre = (Livre) obj;
        return titre.equals(livre.titre) && auteur.equals(livre.auteur) && editeur.equals(livre.editeur);
    }

    /**
     * Cree une nouvelle edition
     * @param nouvelEdit la nouvelle editiona c reer
     * @return la nouvelle edition cree
     */
    public Livre nouvelEditeur(String nouvelEdit) {
        return new Livre(this.titre, this.auteur, nouvelEdit, this.genre);
    }
}