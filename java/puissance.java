import java.util.Scanner;

public class puissance {
    
    public static double aLaPuissance(Scanner scanner) {

        try {
            System.out.print("Entrez la base : ");
            double base = Double.parseDouble(scanner.nextLine());
            // if (base <= 0) {
            //     System.out.println("Veuillez entrer un nombre réel positif pour la base.");
            //     return 0;
            // }
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


/*
┌─────────────────────────────────────────┐
│  1. DEMANDER LES ENTRÉES                │
│     - La base (double ?)                │
│     - L'exposant (int ?)                │
└─────────────────────────────────────────┘
              ↓
┌─────────────────────────────────────────┐
│  2. VALIDER LES ENTRÉES                 │
│     - Cas particuliers ?                │
│     - Exposant négatif ? (pour avancé)  │
└─────────────────────────────────────────┘
              ↓
┌─────────────────────────────────────────┐
│  3. CALCULER LE RÉSULTAT                │
│     - Algorithme de puissance           │
└─────────────────────────────────────────┘
              ↓
┌─────────────────────────────────────────┐
│  4. AFFICHER LE RÉSULTAT                │
│     - Message clair : "2^3 = 8"         │
└─────────────────────────────────────────┘
              ↓
┌─────────────────────────────────────────┐
│  5. GÉRER LES EXCEPTIONS                │
│     - try-catch comme les autres        │
└─────────────────────────────────────────┘
*/