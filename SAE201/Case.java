import java.util.ArrayList;
public class Case {

    private int ligne;
    private int colonne;
    private Piece contenu;
    private ArrayList<Piece> Danger = new ArrayList<Piece>(20);

    public Case(int l, int c){
        this.ligne = l;
        this.colonne = c;
        this.contenu = null;
    }

    public String toString() {
    if (contenu == null) {
        return "  "; // case vide
    } else {
        String symbole = contenu.icone();
        return symbole;
    }
    }

    public Piece getContenu(){
        return this.contenu;
    }

    public void setContenu(Piece p){
        this.contenu = p;
    }

    public int getLigne(){
        return this.ligne;
    }

    public int getColonne(){
        return this.colonne;
    }

    public void setLigne(int ligne){
        this.ligne = ligne;
    }

    public void setColonne(int colonne){
        this.colonne = colonne;
    }

    
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Case other = (Case) o;
        return ligne == other.ligne && colonne == other.colonne;
    }
    
}
