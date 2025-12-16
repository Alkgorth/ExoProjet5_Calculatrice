import java.util.Scanner;

public class premier {
    
    public static void estPremier(Scanner scanner) {

        try {
            System.out.print("Entrez un nombre à vérifier : ");
            int nombre = Integer.parseInt(scanner.nextLine());
            if (nombre <= 1) {
                System.out.println("Veuillez entrer un nombre entier supérieur à 1.");
                return;
            }
            for (int i = 2; i <= Math.sqrt(nombre); i++) {
                if (nombre % i == 0) {
                    System.out.println("Le nombre " + nombre + " n'est pas premier ");
                    return;
                }
            }
            System.out.println("Le nombre " + nombre + " est premier ");
        } catch (NumberFormatException e) {
            System.out.println("Entrée invalide. Veuillez entrer un nombre entier, exemple : 42");
            return;
        } catch (Exception e) {
            System.out.println("Une erreur est survenue : " + e.getMessage());
        }
        
        return;
    }
}


/*
 Checklist de ce que vous devez faire
 Changer scanner.nextInt() en Integer.parseInt(scanner.nextLine())
 Changer le type de retour : void au lieu de boolean
 Supprimer tous les return (ou les remplacer par return; sans valeur)
 Ajouter un message pour le cas "n'est PAS premier"
 Vérifier que le catch correspond à l'exception réelle
 Tester avec : -5, 0, 1, 2, 17, 20, 97
┌─────────────────────────────────────────┐
│  1. DEMANDER L'ENTRÉE UTILISATEUR       │
│     - Afficher un message clair         │
│     - Lire le nombre (attention au type)│
└─────────────────────────────────────────┘
              ↓
┌─────────────────────────────────────────┐
│  2. VALIDER L'ENTRÉE                    │
│     - Vérifier les cas limites          │
│     - Gérer les nombres ≤ 1             │
└─────────────────────────────────────────┘
              ↓
┌─────────────────────────────────────────┐
│  3. EFFECTUER LE CALCUL                 │
│     - Tester la primalité               │
│     - Utiliser l'algorithme optimal     │
└─────────────────────────────────────────┘
              ↓
┌─────────────────────────────────────────┐
│  4. AFFICHER LE RÉSULTAT                │
│     - Message clair pour l'utilisateur  │
│     - "X est premier" OU "X n'est pas   │
│       premier"                          │
└─────────────────────────────────────────┘
              ↓
┌─────────────────────────────────────────┐
│  5. RETOURNER (si nécessaire)           │
│     - Que doit retourner votre méthode ?│
└─────────────────────────────────────────┘
*/