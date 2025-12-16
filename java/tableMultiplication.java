import java.util.Scanner;

public class tableMultiplication {
    
    public static void afficherTable(Scanner scanner) {
        System.out.print("Entrez le nombre pour afficher sa table de multiplication : ");
        int nombre = scanner.nextInt();
        System.out.println("Table de multiplication de " + nombre + " :");
        for (int i = 1; i <= 10; i++) {
            System.out.println(nombre + " x " + i + " = " + (nombre * i));
        }
    }
}
