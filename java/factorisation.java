import java.util.ArrayList;
import java.util.Scanner;

public class factorisation {

    public static void factoriser(Scanner scanner) {

        try {
            System.out.println("Entrer un nombre à factoriser : ");
            int nombre = Integer.parseInt(scanner.nextLine());

            ArrayList<Integer> facteurs = new ArrayList<>();

            while (nombre % 2 == 0) {
                facteurs.add(2);
                nombre /= 2;
            }

            int diviseur = 3;
            while (diviseur <= Math.sqrt(nombre)) {
                while (nombre % diviseur == 0) {
                    facteurs.add(diviseur);
                    nombre /= diviseur;
                }
                diviseur += 2;
            }

            if (nombre > 2) {
                facteurs.add(nombre);
            }

            System.out.print("Facteurs premiers : ");
            for (int i = 0; i < facteurs.size(); i++) {
                System.out.print(facteurs.get(i) + " ");
            }
        } catch (NumberFormatException e) {
            System.out.println("Entrée invalide. Veuillez entrer un nombre entier, exemple : 42");
            return;
        } catch (Exception e) {
            System.out.println("Une erreur est survenue : " + e.getMessage());
        }
        System.out.println();
    }
}