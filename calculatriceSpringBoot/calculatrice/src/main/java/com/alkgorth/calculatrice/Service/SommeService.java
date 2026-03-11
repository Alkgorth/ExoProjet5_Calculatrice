package com.alkgorth.calculatrice.Service;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SommeService {

    public double somme(double a, double b) {
        // Pas de validation métier spécifique, mais on pourrait vérifier NaN ou infini si nécessaire
        return a + b;
    }

    public double sommeMultiple(List<Double> nombres) {
        if (nombres == null || nombres.isEmpty()) {
            throw new IllegalArgumentException("La liste des nombres ne peut pas être nulle ou vide.");
        }
        double somme = 0;
        for (double nombre : nombres) {
            somme += nombre;
        }
        return somme;
    }
}
