import java.util.Scanner;

public class somme {
    
    public static double somme(Scanner scanner) {

        // détail de l'addition
        // je demande les deux nombres à l'utilisateur
        // je retourne la somme des deux nombres
        try {
            
            System.out.print("Entrez le premier nombre : ");
            double a = Double.parseDouble(scanner.nextLine());
            
            System.out.print("Entrez le deuxième nombre : ");
            double b = Double.parseDouble(scanner.nextLine());

            double resultat = a + b;
            System.out.println("Le résultat de l'addition est : " + resultat);
            return resultat;

            
        } catch (NumberFormatException e) {
            System.out.println("Entrée invalide. Veuillez entrer un nombre, exemple : 3.14");
            return 0;
        } catch (Exception e) {
            System.out.println("Une erreur est survenue : " + e.getMessage());
            return 0;
        }
    }
}
