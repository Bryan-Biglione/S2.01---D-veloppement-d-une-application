public class Fou extends Piece {
    
        public Fou(int ligne, int colonne, String couleur, int v) {
        super(ligne, colonne, couleur, v);
    }

    public Boolean coupOk(Case destination) {

        int dx = destination.getLigne() - getLigne();
        int dy = destination.getColonne() - getCol();

        return (dx == dy) || (dx == -dy);    
    }

    public boolean deplacement(Case destination) {
        return coupOk(destination);
    }

    public String icone(){
        if( this.getCouleur().equals("blanc")){
            return "Fb";
        }
        else{
            return "Fn";
        }
    }
}
