public abstract class Piece {
    private int ligne;
    private int colonne;
    private String couleur ;
    private int valeur;
 
    public Piece(int lig,int col, String c, int v){
        this.ligne = lig;
        this.colonne = col;
        this.couleur = c;
        this.valeur = v;
    } 

    public abstract Boolean coupOk(Case destination);



    public int getLigne(){
        return this.ligne;
    }

    public int getCol(){
        return this.colonne;
    }

    public String getCouleur(){
        return this.couleur;
    }

    public void setPosition(int lig, int col) {
        this.ligne = lig;
        this.colonne = col;
    }

    public abstract boolean deplacement(Case destination);

    public abstract String icone();

    public int getValeur(){
        return this.valeur;
    }
     
}