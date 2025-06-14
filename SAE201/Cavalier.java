public class Cavalier extends Piece{

    public Cavalier(int lig,int col, String c, int v){
        super(lig , col ,c, v);
        
    }

    public Boolean coupOk(Case destination){
        if ((destination.getLigne() == this.getLigne() + 2 && destination.getColonne() == this.getCol() + 1) ||
             (destination.getLigne() == this.getLigne() + 2 && destination.getColonne() == this.getCol() - 1) ||
             (destination.getLigne() == this.getLigne() - 2 && destination.getColonne() == this.getCol() + 1) ||
             (destination.getLigne() == this.getLigne() - 2 && destination.getColonne() == this.getCol() - 1) ||
             (destination.getLigne() == this.getLigne() + 1 && destination.getColonne() == this.getCol() + 2) ||
             (destination.getLigne() == this.getLigne() - 1 && destination.getColonne() == this.getCol() + 2) ||
             (destination.getLigne() == this.getLigne() + 1 && destination.getColonne() == this.getCol() - 2) ||
             (destination.getLigne() == this.getLigne() - 1 && destination.getColonne() == this.getCol() - 2) )
{
            return true;
        }
        return false;
    }

    public boolean deplacement(Case destination) {
        return coupOk(destination);
    }

    public String toString(){
        return "Cavalier [ x : "+this.getLigne()+", y : "+this.getCol()+", couleur : "+this.getCouleur()+"]" ;
    }
    
    public String icone(){
        if( this.getCouleur().equals("blanc")){
            return "Cb";
        }
        else{
            return "Cn";
        }
    }
}
