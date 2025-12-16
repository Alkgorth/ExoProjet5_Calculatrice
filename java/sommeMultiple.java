import java.util.Scanner;

public class sommeMultiple {

    public static double sommeMultiple(Scanner scanner) {
        // Demander combien de nombres
        System.out.println("Combien de nombres voulez-vous additionner ?");
        // Créer un tableau ou utiliser une liste
        int taille = scanner.nextInt();
        double[] nombres = new double[taille];
        // Demander chaque nombre à l'utilisateur
        // Calculer la somme
        for (int i = 0; i < taille; i++) {
            System.out.print("Entrez le nombre " + (i + 1) + " : ");
            nombres[i] = scanner.nextDouble();
        }
        double somme = 0;
        for (double nombre : nombres) {
            somme += nombre;
        }
        
        // Afficher le résultat
        System.out.println("La somme des nombres est : " + somme);
        return somme;

        // Gérer les exceptions

    }
}
