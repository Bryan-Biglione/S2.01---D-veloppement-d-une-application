public class Roi extends Piece {

    public Roi (int ligne, int colonne, String couleur, int v){
        super(ligne, colonne, couleur,v);
    }

    public Boolean coupOk(Case destination) {

        int dx = destination.getLigne()-getLigne();
        int dy = destination.getColonne()-getCol();

        if ((dx >= -1 && dx <= 1) && (dy >= -1 && dy <= 1)) {
            if (dx != 0 || dy != 0){
                return true;
            }
        }
        return false;
    }

    public boolean deplacement(Case destination) {
        return coupOk(destination);
    }

    public String icone(){
        if( this.getCouleur().equals("blanc")){
            return "Rb";
        }
        else{
            return "Rn";
        }
    }
}
