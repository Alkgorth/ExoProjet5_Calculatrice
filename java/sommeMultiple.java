import java.util.Scanner;

public class sommeMultiple {

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
