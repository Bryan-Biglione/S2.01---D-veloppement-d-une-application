public class Pion extends Piece{

    private Boolean Deplacement2;

    public Pion(int lig,int col, String c, int v){
        super(lig, col, c, v);
        Deplacement2 = true;
    }

    public Boolean coupOk(Case destination){
        int dx = destination.getLigne() - getLigne();
        int dy = destination.getColonne() - getCol();

        int direction;
        if (this.getCouleur().equals("blanc")) {
            direction = -1;
        } else {
            direction = 1;
        }

        if (dx == direction && dy == 0) {
            Deplacement2 = false;
            return true;
        }

        if (Deplacement2 && dx == 2 * direction && dy == 0) {
            Deplacement2 = false;
            return true;
        }

        if (dx == direction && (dy == 1 || dy == -1)) {
            Deplacement2 = false;
            return true;
        }



        return false;
    }
    
    public boolean deplacement(Case destination) {
        return coupOk(destination);
    }

    public String icone(){
        if( this.getCouleur().equals("blanc")){
            return "Pb";
        }
        else{
            return "Pn";
        }
    
}
}