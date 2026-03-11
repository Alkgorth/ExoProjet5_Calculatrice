package com.alkgorth.calculatrice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alkgorth.calculatrice.Service.SommeService;
import com.alkgorth.calculatrice.Service.FactorisationService;
import com.alkgorth.calculatrice.Service.PremierService;
import com.alkgorth.calculatrice.Service.PuissanceService;
import com.alkgorth.calculatrice.Service.TableMultiplicationService;
import com.alkgorth.calculatrice.Model.ResultatCalcul;

import java.util.List;
import java.util.ArrayList;

@Controller
public class CalculController {

    @Autowired
    private SommeService sommeService;

    @Autowired
    private FactorisationService factorisationService;

    @Autowired
    private PremierService premierService;

    @Autowired
    private PuissanceService puissanceService;

    @Autowired
    private TableMultiplicationService tableMultiplicationService;

    @GetMapping("/")
    public String accueil() {
        return "index";
    }

    // Calcul de somme (addition de 2 nombres)
    @PostMapping("/calculer/somme")
    public String calculerSomme(
            @RequestParam(required = false) Double a,
            @RequestParam(required = false) Double b,
            Model model) {
        if (a == null || b == null) {
            model.addAttribute("error", "Veuillez fournir deux nombres valides pour l'addition.");
            return "index";
        }
        try {
            double resultat = sommeService.somme(a, b);
            ResultatCalcul resultatObj = new ResultatCalcul();
            resultatObj.setOperation("Addition");
            resultatObj.setResultat(resultat);
            model.addAttribute("resultat", resultatObj);
        } catch (Exception e) {
            model.addAttribute("error", "Erreur lors du calcul : " + e.getMessage());
            return "index";
        }
        return "resultat";
    }

    // Calcul de somme multiple (liste de nombres séparés par des virgules)
    @PostMapping("/calculer/sommeMultiple")
    public String calculerSommeMultiple(
            @RequestParam(required = false) String nombres,
            Model model) {
        if (nombres == null || nombres.trim().isEmpty()) {
            model.addAttribute("error", "Veuillez fournir une liste de nombres séparés par des virgules.");
            return "index";
        }
        try {
            String[] parts = nombres.split(",");
            List<Double> listeNombres = new ArrayList<>();
            for (String part : parts) {
                String trimmed = part.trim();
                if (trimmed.isEmpty()) continue; // Ignorer les parties vides
                listeNombres.add(Double.parseDouble(trimmed));
            }
            if (listeNombres.isEmpty()) {
                throw new IllegalArgumentException("Aucun nombre valide trouvé.");
            }
            double resultat = sommeService.sommeMultiple(listeNombres);
            ResultatCalcul resultatObj = new ResultatCalcul();
            resultatObj.setOperation("Addition Multiple");
            resultatObj.setResultat(resultat);
            model.addAttribute("resultat", resultatObj);
        } catch (NumberFormatException e) {
            model.addAttribute("error", "Format invalide : veuillez entrer uniquement des nombres séparés par des virgules.");
            return "index";
        } catch (Exception e) {
            model.addAttribute("error", "Erreur lors du calcul : " + e.getMessage());
            return "index";
        }
        return "resultat";
    }

    // Calcul de factorisation
    @PostMapping("/calculer/factorisation")
    public String calculerFactorisation(
            @RequestParam(required = false) Integer nombre,
            Model model) {
        if (nombre == null) {
            model.addAttribute("error", "Veuillez fournir un nombre entier positif pour la factorisation.");
            return "index";
        }
        try {
            List<Integer> facteurs = factorisationService.factoriser(nombre);
            ResultatCalcul resultatObj = new ResultatCalcul();
            resultatObj.setOperation("Factorisation");
            resultatObj.setFacteurs(facteurs);
            model.addAttribute("resultat", resultatObj);
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "index";
        } catch (Exception e) {
            model.addAttribute("error", "Erreur lors de la factorisation : " + e.getMessage());
            return "index";
        }
        return "resultat";
    }

    // Méthode pour nombre premier
    @PostMapping("/calculer/estPremier")
    public String calculerEstPremier(
            @RequestParam(required = false) Integer nombre,
            Model model) {
        if (nombre == null) {
            model.addAttribute("error", "Veuillez fournir un nombre entier pour vérifier s'il est premier.");
            return "index";
        }
        try {
            boolean estPremier = premierService.estPremier(nombre);
            ResultatCalcul resultatObj = new ResultatCalcul();
            resultatObj.setOperation("Nombre Premier");
            resultatObj.setEstPremier(estPremier);
            model.addAttribute("resultat", resultatObj);
        } catch (Exception e) {
            model.addAttribute("error", "Erreur lors de la vérification : " + e.getMessage());
            return "index";
        }
        return "resultat";
    }

    // Calcul de puissance
    @PostMapping("/calculer/puissance")
    public String calculerPuissance(
            @RequestParam(required = false) Double base,
            @RequestParam(required = false) Integer exposant,
            Model model) {
        if (base == null || exposant == null) {
            model.addAttribute("error", "Veuillez fournir une base et un exposant valides.");
            return "index";
        }
        try {
            double resultat = puissanceService.calculerPuissance(base, exposant);
            ResultatCalcul resultatObj = new ResultatCalcul();
            resultatObj.setOperation("Puissance");
            resultatObj.setBase(base.intValue());
            resultatObj.setExposant(exposant);
            resultatObj.setResultat(resultat);
            model.addAttribute("resultat", resultatObj);
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "index";
        } catch (Exception e) {
            model.addAttribute("error", "Erreur lors du calcul de puissance : " + e.getMessage());
            return "index";
        }
        return "resultat";
    }

    // Calcul de table de multiplication
    @PostMapping("/calculer/tableMultiplication")
    public String calculerTableMultiplication(
            @RequestParam(required = false) Integer nombre,
            Model model) {
        if (nombre == null) {
            model.addAttribute("error", "Veuillez fournir un nombre entier positif pour la table de multiplication.");
            return "index";
        }
        try {
            java.util.List<String> table = tableMultiplicationService.construireTable(nombre);
            ResultatCalcul resultatObj = new ResultatCalcul();
            resultatObj.setOperation("Table de Multiplication");
            resultatObj.setNombre(nombre);
            resultatObj.setTable(table);
            model.addAttribute("resultat", resultatObj);
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "index";
        } catch (Exception e) {
            model.addAttribute("error", "Erreur lors de la génération de la table : " + e.getMessage());
            return "index";
        }
        return "resultat";
    }
}
