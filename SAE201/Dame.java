public class Dame extends Piece {

    public Dame (int ligne, int colonne, String couleur,int v ){
        super(ligne, colonne, couleur, v);
    }

    public Boolean coupOk(Case destination){
        int dx = destination.getLigne() - getLigne();
        int dy = destination.getColonne() - getCol();

        // Mouvement de Tour 
        if ((dx == 0 && dy != 0) || (dx != 0 && dy == 0)) {
            return true;
        }

        // Mouvement de Fou 
        if (dx == dy || dx == -dy) {
            return true;
        }

        return false;
    }

    public boolean deplacement(Case destination) {
        return coupOk(destination);
    }

    public String icone(){
        if( this.getCouleur().equals("blanc")){
            return "Db";
        }
        else{
            return "Dn";
        }
    }
}