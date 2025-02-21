
import guilines.Lines;
import guilines.IJeuDesBilles;


public class DemoLines {
    public static void main(String[] args) {
        IJeuDesBilles monJeu = new MonJeu();
        new Lines("LILines",monJeu);
        
    }
}
