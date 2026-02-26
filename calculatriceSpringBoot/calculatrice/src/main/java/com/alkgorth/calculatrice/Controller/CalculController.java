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

    // Injection des Services par Spring Boot
    @Autowired
    private SommeService sommeService;

    @Autowired
    private FactorisationService factorisationService;

    // Page d'accueil
    @GetMapping("/")
    public String accueil() {
        return "index"; // Affiche templates/index.html
    }

    // Calcul de somme (addition de 2 nombres)
    @PostMapping("/calculer/somme")
    public String calculerSomme(
            @RequestParam double a,
            @RequestParam double b,
            Model model) {

        double resultat = sommeService.somme(a, b);
        model.addAttribute("operation", "Addition");
        model.addAttribute("resultat", resultat);
        return "resultat"; // Affiche templates/resultat.html
    }

    // Calcul de somme multiple (liste de nombres séparés par des virgules)
    @PostMapping("/calculer/sommeMultiple")
    public String calculerSommeMultiple(
            @RequestParam String nombres,
            Model model) {

        // Parse la chaîne "5, 10, 15, 20" en List<Double>
        String[] parts = nombres.split(",");
        List<Double> listeNombres = new ArrayList<>();
        
        for (String part : parts) {
            listeNombres.add(Double.parseDouble(part.trim()));
        }

        double resultat = sommeService.sommeMultiple(listeNombres);
        model.addAttribute("operation", "Addition Multiple");
        model.addAttribute("resultat", resultat);
        return "resultat"; // Affiche templates/resultat.html
    }

    // Calcul de factorisation
    @PostMapping("/calculer/factorisation")
    public String calculerFactorisation(
            @RequestParam int nombre,
            Model model) {

        List<Integer> facteurs = factorisationService.factoriser(nombre);
        model.addAttribute("operation", "Factorisation");
        model.addAttribute("facteurs", facteurs);
        return "resultat"; // Affiche templates/resultat.html
    }
}
