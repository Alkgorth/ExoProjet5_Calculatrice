package com.alkgorth.calculatrice.Service;

import org.springframework.stereotype.Service;

@Service
public class PuissanceService {

    public double calculerPuissance(double base, int exposant) {
        if (base == 0 && exposant == 0) {
            throw new IllegalArgumentException("0 à la puissance 0 est mathématiquement indéfini.");
        }
        if (exposant < 0) {
            throw new IllegalArgumentException("Les exposants négatifs ne sont pas pris en charge.");
        }
        if (base == 0 && exposant < 0) {
            throw new IllegalArgumentException("Division par zéro : base nulle avec exposant négatif.");
        }

        double resultat = 1;
        for (int i = 0; i < exposant; i++) {
            resultat *= base;
        }
        return resultat;
    }
}
