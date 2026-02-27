import java.util.Scanner;

public class puissance {
    
    public static double aLaPuissance(Scanner scanner) {

        try {
            System.out.print("Entrez la base : ");
            double base = Double.parseDouble(scanner.nextLine());

            System.out.print("Entrez l'exposant : ");
            int exposant = Integer.parseInt(scanner.nextLine());

            if (base == 0 && exposant == 0) {
                System.out.println("0 à la puissance 0 est mathématiquement indéfini.");
                return 0;
            }
            else if (exposant < 0) {
                System.out.println("Les exposants négatifs ne sont pas pris en charge.");
                return 0;
            }
            double resultat = 1;
            for (int i = 0; i < exposant; i++) {
                resultat *= base;
            }
            System.out.println(base + "^" + exposant + " = " + resultat);
            return resultat;
            
        } catch (NumberFormatException e) {
            System.out.println("Entrée invalide. Veuillez entrer un nombre entier, exemple : 42");
            return 0;
        }catch (Exception e) {
            System.out.println("Une erreur est survenue : " + e.getMessage());
        }
        return 0;
    }
}
