@Service

public class SommeService {

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

    public static double sommeMultiple(Scanner scanner) {

        try {
            System.out.println("Combien de nombres voulez-vous additionner ? (max 100) : ");
            int taille = Integer.parseInt(scanner.nextLine());
            if (taille <= 0 || taille > 100) {
                System.out.println("Erreur : veuillez entrer une valeur positive et inférieure à 100.");
                return 0;
            }
            double[] nombres = new double[taille];

            for (int i = 0; i < taille; i++) {
                System.out.print("Entrez le nombre " + (i + 1) + " : ");
                nombres[i] = Double.parseDouble(scanner.nextLine());
            }
            double somme = 0;
            for (double nombre : nombres) {
                somme += nombre;
            }

            System.out.println("La somme des nombres est : " + somme);
            return somme;

        } catch (Exception e) {
            System.out.println("Entrée invalide : " + e.getMessage() + ". Veuillez entrer des nombres valides.");
            return 0;
        }

    }
}
