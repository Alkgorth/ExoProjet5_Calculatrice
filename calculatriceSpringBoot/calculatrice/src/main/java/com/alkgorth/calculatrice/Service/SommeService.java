package com.alkgorth.calculatrice.Service;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SommeService {

    public double somme(double a, double b) {
        return a + b;
    }

    public double sommeMultiple(List<Double> nombres) {
        double somme = 0;
        for (double nombre : nombres) {
            somme += nombre;
        }
        return somme;
    }
}
