import java.util.Scanner;

public class tableMultiplication {
    
    public static void afficherTable(Scanner scanner) {

        try {
            System.out.print("Entrez le nombre pour afficher sa table de multiplication : ");
            int nombre = Integer.parseInt(scanner.nextLine());

            if (nombre < 0) {
                System.out.println("Erreur : veuillez entrer un nombre entier positif.");
                return;
            }
            
            System.out.println("Table de multiplication de " + nombre + " :");
            for (int i = 1; i <= 10; i++) {
                System.out.println(nombre + " x " + i + " = " + (nombre * i));
            }
            
        } catch (NumberFormatException e) {
            System.out.println("Entrée invalide. Veuillez entrer un nombre entier, exemple : 3");
            return;
        } catch (Exception e) {
            System.out.println("Une erreur est survenue : " + e.getMessage());
            return;
        }
    }
}
