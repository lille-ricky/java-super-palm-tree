
import java.util.ArrayList;
import java.util.Random;
import java.awt.Point;
import java.util.List;
import guilines.IJeuDesBilles;

/**
 * Classe qui contient la grille du jeu des billes
 */
public class MonJeu implements IJeuDesBilles {
    private Bille[][] grille;
    private Random random;
    private static final int VIDE = -1;
    private static final int TAILLE_GRILLE = 3; // A remettre a 9 apres le debeuggage
    private static final int COUNT_COULEURS = 8; 
    private static final int NB_BILLES_ALIGNEES = 3; // Rappel :remets le a 5 apres les tests mon gros
    private List<Point> lastModified = new ArrayList<>();
    private int score = 0;

    public MonJeu() {
        grille = new Bille[TAILLE_GRILLE][TAILLE_GRILLE];
        random = new Random();
        reinit();
    }

    /**
     * Renvoie le nombre de lignes 
     * @return le nombre de lignes
     */
    @Override 
    public int getNbLignes() {
        return TAILLE_GRILLE;
    }

    /**
     * Renvoie le nombre de colonnes
     * @return le nombre de colonnes
     */
    @Override 
    public int getNbColonnes() {
        return TAILLE_GRILLE;
    }

    /**
     * Renvoie le nombre de billes ajoutes apres chaque mouvement
     * @return le nombre de billes ajoutes apres un mouvement    
     */
    public int getNbBillesAjoutees() {
        return 3;
    }

    /**
     * Renvoie le score
     * @return le score
     */
    @Override
    public int getScore() {
        return score;
    }

    /**
     * Renvoie le nombre de couleurs
     */
    @Override 
    public int getNbCouleurs() {
        return COUNT_COULEURS;
    }

    /**
     * Renvoie la couleur avec les cordonnees specifiees en parametre
     * @return la couleur desiree 
     */
    @Override
    public int getCouleur(int x, int y) {
        if (x < 0 || x >= TAILLE_GRILLE || y < 0 || y >= TAILLE_GRILLE) {
            return VIDE;
        }
        return grille[x][y].getCouleur();
    }

    /**
     * Verifie si la partie est fini
     * @return true si la partie est finie, false sinon
     */
    @Override
    public boolean partieFinie() {
        for (int i = 0; i < TAILLE_GRILLE; i++) {
            for (int j = 0; j < TAILLE_GRILLE; j++){
                if (grille[i][j].estVide()) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Initialise la grille en ajoutant les cinq premieres billes.
     */
    @Override
    public void reinit() {
        lastModified.clear();

        for (int i = 0; i < TAILLE_GRILLE; i++) {
            for (int j = 0; j < TAILLE_GRILLE; j++) {
                grille[i][j] = new Bille();
            }
        }
        ajouteBilles(5);
        score = 0;
    }

    /**
     * Ajoute une bille dans la grille
     * @param nombre le nombre de billes a ajouter
     */
    private void ajouteBilles(int nombre) {
        lastModified.clear();
        for (int i = 0; i < nombre; i++) {
            boolean placed = false;
            while (!placed) {
                int x = random.nextInt(TAILLE_GRILLE);
                int y = random.nextInt(TAILLE_GRILLE);
                if (grille[x][y].estVide()) {
                    grille[x][y].setCouleur(random.nextInt(COUNT_COULEURS));
                    lastModified.add(new Point(x, y));
                    placed = true;
                }
            }
        }
    }

    /**
     * Vérifie l'alignement des billes dans une direction donnée
     * @param x coordonnée x de départ
     * @param y coordonnée y de départ
     * @param dx déplacement en x
     * @param dy déplacement en y
     * @return liste des points alignés
     */
    private List<Point> checkLine(int x, int y, int dx, int dy) {
        List<Point> aligned = new ArrayList<>();
        int color = grille[x][y].getCouleur();

        // controle les deux directions
        for (int direction = -1; direction <= 1; direction += 2) {
            int currX = x;
            int currY = y;
            while (currX >= 0 && currX < TAILLE_GRILLE &&
                   currY >= 0 && currY < TAILLE_GRILLE &&
                   grille[currX][currY].getCouleur() == color) { 
                aligned.add(new Point(currX, currY));
                currX += dx * direction;
                currY += dy * direction;
            }
        }
        // Enleve le point central s'il a été compté deux fois
        if (!aligned.isEmpty()) {
            aligned.remove(aligned.size() - 1);
        }
        return aligned;
    }

    /**
     * Verifie si le mouvement desire peut etre effectue
     * @param srcX point x d'origine
     * @param srcY point y d'origine
     * @param destX point x destination
     * @param destY point y destination
     * @return true si le mouvement est possible, false sinon
     */
    private boolean isValidMove(int srcX, int srcY, int destX, int destY) {
        if (srcX < 0 || srcX >= TAILLE_GRILLE || srcY < 0 || srcY >= TAILLE_GRILLE ||
            destX < 0 || destX >= TAILLE_GRILLE || destY < 0 || destY >= TAILLE_GRILLE || 
            grille[srcX][srcY].estVide() || grille[destX][destY].estVide()) {
            return false;
        }
        return findPath(srcX, srcY, destX, destY); 
    }

    /**
     * Verifie si on peut passer d'un point a l'autre en utilisant un algo breadth-first search
     * @param srcX point x de source
     * @param srcY point y de source
     * @param destX point x de destination
     * @param destY point y de destination
     * @return true si le chemin est possible, false sinon
     */
    private boolean findPath(int srcX, int srcY, int destX, int destY) {
        boolean[][] visited = new boolean[TAILLE_GRILLE][TAILLE_GRILLE];
        List<Point> queue = new ArrayList<>();
        queue.add(new Point(srcX, srcY));
        visited[srcX][srcY] = true;

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            Point current = queue.remove(0);
            if (current.x == destX && current.y == destY) {
                return true;
            }

            for (int[] dir : directions) {
                int newX = current.x + dir[0];
                int newY = current.y + dir[1];

                if (newX >= 0 && newX < TAILLE_GRILLE && newY >= 0 && newY < TAILLE_GRILLE &&
                    !visited[newX][newY] && grille[newX][newY].estVide()) {
                    queue.add(new Point(newX, newY));
                    visited[newX][newY] = true;
                }
            }
        }
        return false;
    }

    /**
     * Deplace une bille dans la grille 
     * @param srcX la cordonnee X initiale
     * @param srcY la cordonnee Y initiale
     * @param destX La cordonnee X destinataire
     * @param destY La cordonnee Y destinataire
     * @return true si le deplacement a ete effectue, false sinon
     */
    @Override
    public List<Point> deplace(int srcX, int srcY, int destX, int destY) {
        lastModified.clear();
        if (!isValidMove(srcX, srcY, destX, destY)) {
            return lastModified;
        }

        lastModified.add(new Point(srcX, srcY));
        lastModified.add(new Point(destX, destY));

        // Faire le mouvement
        grille[destX][destY].setCouleur(grille[srcX][srcY].getCouleur());
        grille[srcX][srcY].setVide(true);

        boolean alignmentFound = checkAndRemoveAlignedBalls(destX, destY);
        // Controle si des billes sont alignes avant d'ajouter les nouvelles
        if (!alignmentFound) {
            ajouteBilles(getNbBillesAjoutees());
        } 
        return lastModified;
    }

    /**
     * Controle et enleve les billes alignees, si elles sont presentes
     * @return true si le changement est fait, false sinon
     */
    private boolean checkAndRemoveAlignedBalls(int x, int y) {
        // Controle les alignements respectivement :
        List<Point> aligned = new ArrayList<>(); 

        aligned.addAll(checkLine(x, y, 1, 0));  // Horizontalement
        aligned.addAll(checkLine(x, y, 0, 1));  // Verticalement
        aligned.addAll(checkLine(x, y, 1, 1));  // Diagonalement (bas -> haut)
        aligned.addAll(checkLine(x, y, 1, -1)); // Diagonalement (haut -> bas)

        if (aligned.size() >= NB_BILLES_ALIGNEES) { 
            for (Point p : aligned) {
                grille[p.x][p.y].setVide(true);
                lastModified.add(p);
            }
            score += aligned.size() * 2;
            return true;
        }
        return false;
    }

    /**
     * Renvoie les cellules modifiees
     * @return les cellules modifiees
     */
    public List<Point> getModifiedCells() {
        return new ArrayList<>(lastModified);
    }


    @Override
    public int[] getNouvellesCouleurs() {
        int[] nouvellesCouleurs = new int[lastModified.size()];
        for (int i = 0; i < lastModified.size(); i++) {
            Point p = lastModified.get(i);
            nouvellesCouleurs[i] = grille[p.x][p.y].getCouleur();
        }
        return nouvellesCouleurs;
    }
    

    
}