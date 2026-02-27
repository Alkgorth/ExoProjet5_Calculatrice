import java.util.Scanner;

public class premier {
    
    public static double estPremier(Scanner scanner) {

        try {
            System.out.print("Entrez un nombre à vérifier : ");
            int nombre = Integer.parseInt(scanner.nextLine());
            if (nombre <= 1) {
                System.out.println("Veuillez entrer un nombre entier supérieur à 1.");
                return 0;
            }
            for (int i = 2; i <= Math.sqrt(nombre); i++) {
                if (nombre % i == 0) {
                    System.out.println("Le nombre " + nombre + " n'est pas premier ");
                    return 0;
                }
            }
            System.out.println("Le nombre " + nombre + " est premier ");
        } catch (NumberFormatException e) {
            System.out.println("Entrée invalide. Veuillez entrer un nombre entier, exemple : 42");
            return 0;
        } catch (Exception e) {
            System.out.println("Une erreur est survenue : " + e.getMessage());
            return 0;
        }
        
        return 1;
    }
}