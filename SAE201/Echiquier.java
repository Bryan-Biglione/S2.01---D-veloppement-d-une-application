import java.util.*;
public class Echiquier{
/* 
    public void ChangerContenu(int li, int col, Piece c){
        this.board.get(li).get(col).setContenu(c);
    }
    
}
*/

private ArrayList<ArrayList<Case>> board = new ArrayList<ArrayList<Case>>(8);

    // Codes ANSI pour couleurs
    private static final String RESET = "\u001B[0m";
    private static final String BG_LIGHT = "\u001B[47m";  // fond blanc
    private static final String BG_DARK = "\u001B[100m";  // fond gris foncé
    private static final String FG_BLACK = "\u001B[30m";  // texte noir
    private static final String FG_WHITE = "\u001B[37m";  // texte blanc

    public Echiquier(){
        for (int i = 0; i < 8; i++) {
            ArrayList<Case> ligne = new ArrayList<Case>(8);
            for (int j = 0; j < 8; j++) {
                ligne.add(new Case(i,j));
            }
            board.add(ligne);
        }
    }

    public Case getCase(int ligne, int colonne){

        return board.get(ligne).get(colonne);
    }

    public void vider() {
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++)
                board.get(i).get(j).setContenu(null);
    }

    public void placerPiece(int ligne, int colonne, Piece piece) {
        if (ligne >= 0 && ligne < 8 && colonne >= 0 && colonne < 8)
            board.get(ligne).get(colonne).setContenu(piece);
    }

    public void afficher() {
        String lettres = "    A   B   C   D   E   F   G   H";
        System.out.println("\n" + lettres);

        for (int i = 0; i < 8; i++) {
            System.out.print((8 - i) + "  ");
            for (int j = 0; j < 8; j++) {
                boolean clair = (i + j) % 2 == 0;
                String fond = clair ? BG_LIGHT : BG_DARK;
                String texte = clair ? FG_BLACK : FG_WHITE;

                String affichage = board.get(i).get(j).toString();

                    String contenu = " " + affichage + " ";
                System.out.print(fond + texte + contenu + RESET);
            }

            System.out.println("  " + (8 - i));
        }

        System.out.println(lettres + "\n");
    }

    public void initialiser() {

        placerPiece(0, 0, new Tour(0, 0, "noir",5));
        placerPiece(0, 1, new Cavalier(0, 1, "noir",3));
        placerPiece(0, 2, new Fou(0, 2, "noir",3));
        placerPiece(0, 3, new Dame(0, 3, "noir",9));
        placerPiece(0, 4, new Roi(0, 4, "noir",0));
        placerPiece(0, 5, new Fou(0, 5, "noir",3));
        placerPiece(0, 6, new Cavalier(0, 6, "noir",3));
        placerPiece(0, 7, new Tour(0, 7, "noir",5));

        for (int col = 0; col < 8; col++) {
            placerPiece(1, col, new Pion(1, col, "noir",1));
        }

        placerPiece(7, 0, new Tour(7, 0, "blanc",5));
        placerPiece(7, 1, new Cavalier(7, 1, "blanc",3));
        placerPiece(7, 2, new Fou(7, 2, "blanc",3));
        placerPiece(7, 3, new Dame(7, 3, "blanc",9));
        placerPiece(7, 4, new Roi(7, 4, "blanc",0));
        placerPiece(7, 5, new Fou(7, 5, "blanc",3));
        placerPiece(7, 6, new Cavalier(7, 6, "blanc",3));
        placerPiece(7, 7, new Tour(7, 7, "blanc",5));

        for (int col = 0; col < 8; col++) {
            placerPiece(6, col, new Pion(6, col, "blanc",1));
        }
    }

    /**
    param l1 Ligne de départ
    param c1 Colonne de départ
    param l2 Ligne d'arrivée
    param c2 Colonne d'arrivée
    return true si le chemin est libre, false si une pièce bloque le chemin
    */
    public boolean cheminLibre(int l1, int c1, int l2, int c2){

    // Déplacement horizontal
    if (l1 == l2) {
        int start = Math.min(c1, c2);
        int end = Math.max(c1, c2);

        for (int c = start + 1; c < end; c++) {
            if (board.get(l1).get(c).getContenu() != null) {
                return false;            
            }
        }
        return true;
    }

    // Déplacement vertical
    if (c1 == c2) {
        int start = Math.min(l1, l2);
        int end = Math.max(l1, l2);

        for (int l = start + 1; l < end; l++) {
            if (board.get(l).get(c1).getContenu() != null) {
                return false;
            }
        }
        return true;
    }

    // Déplacement diagonal
    if (Math.abs(l2 - l1) == Math.abs(c2 - c1)){
        int dl;
        if (l2 > l1) {
            dl = 1;
        } else {
            dl = -1;
        }

        int dc;
        if (c2 > c1) {
            dc = 1;
        } else {
            dc = -1;
        }

        int l = l1 + dl;
        int c = c1 + dc;

        while (l != l2 && c != c2) {
            if (board.get(l).get(c).getContenu() != null) {
                return false;
            }
            l += dl;
            c += dc;
        }
        return true;
    }

    return false;
    }


    public boolean deplacer(Case Depart, Case Arrive) {
        if (Depart == null || Arrive == null) return false;
        int ld = Depart.getLigne();
        int cd = Depart.getColonne();
        int la = Arrive.getLigne();
        int ca = Arrive.getColonne();

        Piece piece = this.board.get(ld).get(cd).getContenu();


        this.board.get(la).get(ca).setContenu(piece);
        this.board.get(ld).get(cd).setContenu(null);
        return true;
    }


    public ArrayList<ArrayList<Case>> getEchiquier() {
        return this.board;
    }

public boolean estEnEchec(String couleurRoi) {
    //Trouver la position du Roi
    int roiLigne = -1;
    int roiColonne = -1;

    for (int i = 0; i < 8; i++) {
        for (int j = 0; j < 8; j++) {
            Piece piece = board.get(i).get(j).getContenu();
            if (piece != null && piece instanceof Roi && piece.getCouleur().equals(couleurRoi)) {
                roiLigne = i;
                roiColonne = j;
                break;
            }
        }
    }

    if (roiLigne == -1 || roiColonne == -1) {
        System.out.println("Erreur : Roi non trouvé !");
        return false;
    }

    // Vérifier si une pièce adverse peut attaquer le Roi
    for (int i = 0; i < 8; i++) {
        for (int j = 0; j < 8; j++) {
            Piece piece = board.get(i).get(j).getContenu();
            if (piece != null && !piece.getCouleur().equals(couleurRoi)) {
                Case destination = new Case(roiLigne, roiColonne);
                if (piece.deplacement(destination)) {
                    if (piece instanceof Tour || piece instanceof Dame || piece instanceof Fou) {
                        // Vérifier chemin libre aussi
                        if (!cheminLibre(i, j, roiLigne, roiColonne)) {
                            continue;
                        }
                    }
                    // Une pièce menace le Roi
                    return true;
                }
            }
        }
    }

    // Personne ne menace le Roi
    return false;
}

}
