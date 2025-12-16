import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        boolean continuer = true;

        while (continuer) {
            System.out.println("\n=== Calculatrice ===");
            System.out.println("1. Additionner 2 nombres");
            System.out.println("2. Additionner plusieurs nombres");
            System.out.println("3. Factoriser un nombre");
            System.out.println("4. Vérifier si un nombre est premier");
            System.out.println("5. Afficher table de multiplication");
            System.out.println("6. Mettre à la puissance");
            System.out.println("7. Quitter");
            System.out.print("Choisissez une option (1-7) : ");
            
            try {
                int choix = Integer.parseInt(scanner.nextLine());

                switch (choix) {
                    case 1:
                        // Appel de l'addition
                        somme.somme(scanner);
                        break;
                    case 2:
                        // Appel de l'addition multiple
                        sommeMultiple.sommeMultiple(scanner);
                        break;
                    case 3:
                        // Appel de la factorisation
                        factorisation.factoriser(scanner);
                        break;
                    case 4:
                        // Appel pour la vérification de nombre premier
                        premier.estPremier(scanner);
                        break;
                    case 5:
                        // Appel pour afficher la table de multiplication

                        break;
                    case 6:
                        // Appel pour la mise à la puissance
                        puissance.puissance(scanner);
                        break;
                    case 7:
                        continuer = false;
                        System.out.println("Au revoir!");
                        break;
                
                    default:
                        System.out.println("Option invalide. Veuillez choisir entre 1 et 7.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrée invalide. Veuillez entrer un nombre entier.");
            }
        }
        
        scanner.close();

    }
}