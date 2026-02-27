package com.alkgorth.calculatrice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alkgorth.calculatrice.Service.SommeService;
import com.alkgorth.calculatrice.Service.FactorisationService;

import java.util.List;
import java.util.ArrayList;

@Controller
public class CalculController {

    @Autowired
    private SommeService sommeService;

    @Autowired
    private FactorisationService factorisationService;

    @GetMapping("/")
    public String accueil() {
        return "index";
    }

    // Calcul de somme (addition de 2 nombres)
    @PostMapping("/calculer/somme")
    public String calculerSomme(

            @RequestParam double a,
            @RequestParam double b,
            Model model) {
        try {

            double resultat = sommeService.somme(a, b);
            model.addAttribute("operation", "Addition");
            model.addAttribute("resultat", resultat);

        } catch (Exception e) {
            model.addAttribute("error", "Erreur lors du calcul : " + e.getMessage());
            return "index";
        }

        return "resultat";
    }

    // Calcul de somme multiple (liste de nombres séparés par des virgules)
    @PostMapping("/calculer/sommeMultiple")
    public String calculerSommeMultiple(
            @RequestParam String nombres,
            Model model) {

        try {
            String[] parts = nombres.split(",");
            List<Double> listeNombres = new ArrayList<>();

            for (String part : parts) {
                listeNombres.add(Double.parseDouble(part.trim()));
            }

            double resultat = sommeService.sommeMultiple(listeNombres);
            model.addAttribute("operation", "Addition Multiple");
            model.addAttribute("resultat", resultat);

        } catch (Exception e) {
            model.addAttribute("error", "Format invalide, veuillez entrer des nombres séparés par des virgules.");
            return "index";
        }
        return "resultat";
    }

    // Calcul de factorisation
    @PostMapping("/calculer/factorisation")
    public String calculerFactorisation(
            @RequestParam int nombre,
            Model model) {
        try {
            List<Integer> facteurs = factorisationService.factoriser(nombre);
            model.addAttribute("operation", "Factorisation");
            model.addAttribute("facteurs", facteurs);

        } catch (Exception e) {
            model.addAttribute("error", "Erreur lors de la factorisation : " + e.getMessage());
            return "index";
        }
        return "resultat";
    }
}
