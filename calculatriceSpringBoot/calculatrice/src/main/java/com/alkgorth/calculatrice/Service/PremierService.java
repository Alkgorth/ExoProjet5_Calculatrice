package com.alkgorth.calculatrice.Service;

import org.springframework.stereotype.Service;

@Service
public class PremierService {

    public boolean estPremier(int nombre) {
        if (nombre < 2) {
            return false;
        }
        if (nombre == 2) {
            return true;
        }
        if (nombre % 2 == 0) {
            return false;
        }
        for (int i = 3; i <= Math.sqrt(nombre); i += 2) {
            if (nombre % i == 0) {
                return false;
            }
        }
        return true;
    }

}
