package com.alkgorth.calculatrice.Service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class FactorisationService {

    public List<Integer> factoriser(int nombre) {

            List<Integer> facteurs = new ArrayList<>();

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

            return facteurs;
    }
}
