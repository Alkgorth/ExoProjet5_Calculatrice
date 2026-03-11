package com.alkgorth.calculatrice.Service;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class TableMultiplicationService {

    public List<String> construireTable(int nombre) {
        if (nombre <= 0) {
            throw new IllegalArgumentException("Le nombre doit être positif et supérieur à 0.");
        }
        if (nombre > 10000) {
            throw new IllegalArgumentException("Le nombre ne peut pas dépasser 10000 pour éviter les débordements.");
        }

        List<String> table = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            long produit = (long) nombre * i; // Utiliser long pour éviter débordement
            String ligne = String.format("%d x %d = %d", nombre, i, produit);
            table.add(ligne);
        }
        return table;
    }
}
