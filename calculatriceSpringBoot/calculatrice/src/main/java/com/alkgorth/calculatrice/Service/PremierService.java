package com.alkgorth.calculatrice.Service;

import org.springframework.stereotype.Service;

@Service
public class PremierService {

    public boolean estPremier(int nombre) {
        if (nombre <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(nombre); i++) {
            if (nombre % i == 0) {
                return false;
            }
        }
        return true;
    }

}
