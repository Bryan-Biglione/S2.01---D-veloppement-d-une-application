public class Tour extends Piece {

    public Tour(int ligne, int colonne, String couleur, int v) {
        super(ligne, colonne, couleur, v);
    }

    public Boolean coupOk(Case destination) {
        
        int dx = destination.getLigne() - getLigne();
        int dy = destination.getColonne() - getCol();

        return (dx == 0 && dy != 0) || (dx != 0 && dy == 0);
    }

    public boolean deplacement(Case destination) {
        return coupOk(destination);
    }

    public String icone(){
        if( this.getCouleur().equals("blanc")){
            return "Tb";
        }
        else{
            return "Tn";
        }
    }
}
