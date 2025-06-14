public class Joueur {

    String prenom;
    String couleur;
    int score;


    public Joueur (String prenom, String couleur){

        this.prenom = prenom;
        this.couleur = couleur;
        this.score = 0;
    }

    public String getPrenom(){
        return prenom;
    }

    public String getCouleur(){
        return couleur;
    }

    public int getScore() {
        return score;
    }

    public String toString(){
        return prenom + " (" + couleur + ")" + " score :" + score;
    }

    public void setScore(int s){
        this.score += s;
    }
}