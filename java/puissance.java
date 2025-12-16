import java.util.Scanner;

public class puissance {
    
    public static double puissance(Scanner scanner) {
        System.out.print("Entrez la base : ");
        double base = scanner.nextDouble();
        System.out.print("Entrez l'exposant : ");
        int exposant = scanner.nextInt();
        double resultat = 1;
        for (int i = 0; i < exposant; i++) {
            resultat *= base;
        }
        return resultat;
    }
}
