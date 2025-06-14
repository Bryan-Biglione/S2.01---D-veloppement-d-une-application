import java.util.Scanner;
public class partie {

    private Joueur joueur1;
    private Joueur joueur2;
    private Echiquier echiquier;
    private int tour;
    private Boolean jeuEnCours;
    private String couleurCourante;
    private Joueur JoueurCourant;

    public partie(){

        this.echiquier = new Echiquier();
        this.echiquier.initialiser();
        this.tour = 0;
        this.jeuEnCours = true;
        this.couleurCourante = "blanc";

        Scanner scanner = new Scanner(System.in);

        System.out.println(" /$$$$$$$$  /$$$$$$  /$$   /$$ /$$$$$$$$  /$$$$$$                                                                                                            ");
        System.out.println("| $$_____/ /$$__  $$| $$  | $$| $$_____/ /$$__  $$                                                                                                           ");
        System.out.println("| $$      | $$  \\__/| $$  | $$| $$      | $$  \\__/                                                                                                           ");
        System.out.println("| $$$$$   | $$      | $$$$$$$$| $$$$$   | $$                                                                                                                 ");
        System.out.println("| $$__/   | $$      | $$__  $$| $$__/   | $$                                                                                                                 ");
        System.out.println("| $$      | $$    $$| $$  | $$| $$      | $$    $$                                                                                                           ");
        System.out.println("| $$$$$$$$|  $$$$$$/| $$  | $$| $$$$$$$$|  $$$$$$/                                                                                                           ");
        System.out.println("|________/ \\______/ |__/  |__/|________/ \\______/                                                                                                            ");
        System.out.println(" /$$$$$$$                     /$$$$$                                                         /$$$           /$$$$$$$                                         ");
        System.out.println("| $$__  $$                   |__  $$                                                        /$$ $$         | $$__  $$                                        ");
        System.out.println("| $$  \\ $$ /$$   /$$            | $$ /$$$$$$   /$$$$$$$  /$$$$$$   /$$$$$$   /$$$$$$       |  $$$          | $$  \\ $$  /$$$$$$  /$$   /$$  /$$$$$$  /$$$$$$$ ");
        System.out.println("| $$$$$$$ | $$  | $$            | $$|____  $$ /$$_____/ /$$__  $$ /$$__  $$ /$$__  $$       /$$ $$/$$      | $$$$$$$  /$$__  $$| $$  | $$ |____  $$| $$__  $$");
        System.out.println("| $$__  $$| $$  | $$       /$$  | $$ /$$$$$$$|  $$$$$$ | $$  \\ $$| $$$$$$$$| $$  \\__/      | $$  $$_/      | $$__  $$| $$  \\__/| $$  | $$  /$$$$$$$| $$  \\ $$");
        System.out.println("| $$  \\ $$| $$  | $$      | $$  | $$/$$__  $$ \\____  $$| $$  | $$| $$_____/| $$            | $$\\  $$       | $$  \\ $$| $$      | $$  | $$ /$$__  $$| $$  | $$");
        System.out.println("| $$$$$$$/|  $$$$$$$      |  $$$$$$/  $$$$$$$ /$$$$$$$/| $$$$$$$/|  $$$$$$$| $$            |  $$$$/$$      | $$$$$$$/| $$      |  $$$$$$$|  $$$$$$$| $$  | $$");
        System.out.println("|_______/  \\____  $$       \\______/ \\_______/|_______/ | $$____/  \\_______/|__/             \\____/\\_/      |_______/ |__/       \\____  $$ \\_______/|__/  |__/");
        System.out.println("           /$$  | $$                                   | $$                                                                     /$$  | $$                    ");
        System.out.println("          |  $$$$$$/                                   | $$                                                                    |  $$$$$$/                    ");
        System.out.println("           \\______/                                   |__/                                                                     \\______/                     ");
        System.out.println(" ");
        System.out.println("Bienvenue dans notre jeu d'echec en Java");
        System.out.println("Ce dernier a ete realiser dans le cadre de la SAE2.01");
        System.out.println("Pour deplacer une piece, indiquer d'abord la case de celle-ci puis la case de destination, separe par un espace (ex: A2 A3)");
        System.err.println("Les blancs sont situé en bas du plateau et commences la partie");
        System.out.println("Vous allez maintenant pouvoir commencer a jouer, bonne partie");

        System.out.print("Joueur 1, entrez votre prénom : ");
        String prenom1 = scanner.nextLine();

        System.out.print("Joueur 1, entrez votre couleur (blanc ou noir) : ");
        String couleur1 = scanner.nextLine().toLowerCase();

        while (!couleur1.equals("blanc") && !couleur1.equals("noir")) {
            System.out.print("Couleur invalide. Entrez 'blanc' ou 'noir' : ");
            couleur1 = scanner.nextLine().toLowerCase();
        }
        this.joueur1 = new Joueur(prenom1, couleur1);

        System.out.print("Joueur 2, entrez votre prénom : ");
        String prenom2 = scanner.nextLine();

        String couleur2;
        if (couleur1.equals("blanc")) {
            couleur2 = "noir";
        } else {
            couleur2 = "blanc";
        }

        System.out.println("Joueur 2, votre couleur est automatiquement : " + couleur2);
        this.joueur2 = new Joueur(prenom2, couleur2);

        if(couleur1.equals("blanc")){
            this.JoueurCourant = joueur1;
        } else{
            this.JoueurCourant = joueur2;
        }


        this.echiquier.afficher();


        }

    public void changerJoueur() {
        if (this.JoueurCourant.equals(joueur1)) {
            this.JoueurCourant = joueur2;
            this.couleurCourante = joueur2.getCouleur();

        } else {
            this.JoueurCourant = joueur1;
            this.couleurCourante = joueur1.getCouleur();
        }
        this.tour++;
    }

    public Joueur getJoueurCourant() {
        return this.JoueurCourant;
    }
    

    public Echiquier getEchiquier() {
        return this.echiquier;
    }

    public String getCouleur() {
        return this.couleurCourante;
    }

    public boolean deplacement(Case destination, Case Origine) {
    // Vérifie si la couleur de la case de depart est la meme que le joueur qui essaie de la deplacer
    if (!(this.echiquier.getEchiquier().get(Origine.getLigne()).get(Origine.getColonne()).getContenu().getCouleur().equals(couleurCourante))) {
        return false;
    }

    Piece piece = this.echiquier.getEchiquier().get(Origine.getLigne()).get(Origine.getColonne()).getContenu();

    // Déplacement
    this.echiquier.deplacer(Origine, destination);
    piece.setPosition(destination.getLigne(), destination.getColonne());
    return true;
}

    public boolean verification(Case destination, Case Origine){

        if(destination.getColonne()>7 || destination.getColonne()<0 || destination.getLigne()>7 || destination.getLigne()<0 || Origine.getColonne() >7 || Origine.getColonne()<0 || Origine.getLigne() >7 || Origine.getLigne()<0){
            System.out.println("Les corrdonées ne sont pas valides");
            return false;
        }

        if(destination.equals(Origine)){
            System.out.println("Vous devez bouger votre piece");
            return false;
        }

        Piece piece = this.echiquier.getEchiquier().get(Origine.getLigne()).get(Origine.getColonne()).getContenu();
        Piece desti = this.echiquier.getEchiquier().get(destination.getLigne()).get(destination.getColonne()).getContenu();

        //On verfie que la piece dans la case n'est pas null
        if (piece == null) {
            System.out.println("Vous ne possédez pas de pièce dans cette case");
            return false;
        }


        // On verifie que la piece dans la case nous appartient
        if (!(this.echiquier.getEchiquier().get(Origine.getLigne()).get(Origine.getColonne()).getContenu().getCouleur().equals(this.couleurCourante))) {
            System.out.println("La pièce dans cette case ne vous appartient pas");
            return false;
        }

        //On verfie que le coup de la piece soit legal
        if (!piece.deplacement(destination)) {
            System.out.println("Vous ne pouvez pas déplacer la pièce ici");
            return false;
        }

        if (piece instanceof Tour || piece instanceof Dame || piece instanceof Fou) {
            if (!this.echiquier.cheminLibre(Origine.getLigne(), Origine.getColonne(), destination.getLigne(), destination.getColonne())) {
                System.out.println("Une pièce bloque le passage !");
             return false;
            }
        }

        if(desti == null){
            return true;
        }else if(desti.getCouleur().equals(this.couleurCourante)){
            System.out.println("Vous ne pouvez pas manger l'une de vos piece");
            return false;
        } else if (desti instanceof Roi) {
            System.out.println("Vous ne pouvez pas capturer le Roi !");
            return false;
        }else{
            this.JoueurCourant.setScore(desti.getValeur());
        }

        return true;

    }

public boolean jouerTour(Case origine, Case destination) {

    if (verification(destination, origine)) {

        Piece pieceOrigine = echiquier.getCase(origine.getLigne(), origine.getColonne()).getContenu();
        Piece pieceDestination = echiquier.getCase(destination.getLigne(), destination.getColonne()).getContenu();

        // Si le déplacement retourne false, ça signifie que le roi a été capturé
        if (!deplacement(destination, origine)) {
            return false; // Fin du jeu
        }

        if (echiquier.estEnEchec(this.getCouleur())) {
            // Annuler le déplacement
            echiquier.getCase(origine.getLigne(), origine.getColonne()).setContenu(pieceOrigine);
            echiquier.getCase(destination.getLigne(), destination.getColonne()).setContenu(pieceDestination);
            pieceOrigine.setPosition(origine.getLigne(), origine.getColonne());

            System.out.println("Vous êtes en échec ! Vous ne pouvez pas faire ce coup. Vous devez rejouer.");
            return true;
        } else {
            // Coup valide
            System.out.println("Coup Bon !");
            echiquier.afficher();

            String couleurAdverse = this.getCouleur().equals("blanc") ? "noir" : "blanc";
            if (echiquier.estEnEchec(couleurAdverse)) {
                System.out.println("Attention, le joueur " + couleurAdverse + " est en échec !");
            }

            changerJoueur();
        }

    } else {
        System.out.println("Coup non valide, rejouez.");
    }

    return true;
}


}

