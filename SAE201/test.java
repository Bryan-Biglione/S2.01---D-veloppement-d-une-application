import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class test {
    public static void main(String[] args){

        partie p = new partie();

    boolean echecMat = true;
    while (echecMat){

        p.getEchiquier().afficher();
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Le traint est a "+p.getJoueurCourant());
        System.out.print("Saisissez votre coup (ex: A2 A3) : ");
        String coup = scanner.nextLine();

        String regex = "[A-Za-z][0-9] [A-Za-z][0-9]";
        while(!(coup.matches(regex))){
            System.out.print("La syntaxe est invalide, entrer un coup sous le bon format (ex: A2 A3) : ");
            coup = scanner.nextLine();
        }

        int colonneDepart = coup.charAt(0) - 'A';
        int ligneDepart = 8 - Character.getNumericValue(coup.charAt(1));

        int colonneArrive = coup.charAt(3) - 'A';
        int ligneArrive = 8 - Character.getNumericValue(coup.charAt(4));

        Case destination = new Case(ligneArrive,colonneArrive);
        Case depart = new Case(ligneDepart,colonneDepart);

         boolean enEchec = p.getEchiquier().estEnEchec(p.getCouleur());
            if (enEchec) {
                System.out.println("Vous êtes en échec ! Vous devez sortir de l'échec.");
            }

            //Tentative de jouer le coup
            echecMat = p.jouerTour(depart, destination);

    } 
}// fin main
}
        /*
        if (p.verification(destination, depart)) {
            System.out.println("Coup Bon !");
            p.deplacement(destination, depart);
            p.changerJoueur();
        }
        

        p.getEchiquier().afficher();



    }

}

}

*/