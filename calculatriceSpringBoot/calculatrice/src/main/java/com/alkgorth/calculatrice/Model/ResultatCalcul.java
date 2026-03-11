package com.alkgorth.calculatrice.Model;

import java.util.List;

public class ResultatCalcul {
    private String operation;
    private Double resultat;
    private Boolean estPremier;
    private List<Integer> facteurs;
    private Integer base;
    private Integer exposant;
    private List<String> table;
    private Integer nombre;

    // Constructeur vide
    public ResultatCalcul() {
    }

    // Constructeur avec tous les paramètres
    public ResultatCalcul(String operation, Double resultat, Boolean estPremier, 
                         List<Integer> facteurs, Integer base, Integer exposant, 
                         List<String> table, Integer nombre) {
        this.operation = operation;
        this.resultat = resultat;
        this.estPremier = estPremier;
        this.facteurs = facteurs;
        this.base = base;
        this.exposant = exposant;
        this.table = table;
        this.nombre = nombre;
    }

    // Getters et Setters
    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Double getResultat() {
        return resultat;
    }

    public void setResultat(Double resultat) {
        this.resultat = resultat;
    }

    public Boolean getEstPremier() {
        return estPremier;
    }

    public void setEstPremier(Boolean estPremier) {
        this.estPremier = estPremier;
    }

    public List<Integer> getFacteurs() {
        return facteurs;
    }

    public void setFacteurs(List<Integer> facteurs) {
        this.facteurs = facteurs;
    }

    public Integer getBase() {
        return base;
    }

    public void setBase(Integer base) {
        this.base = base;
    }

    public Integer getExposant() {
        return exposant;
    }

    public void setExposant(Integer exposant) {
        this.exposant = exposant;
    }

    public List<String> getTable() {
        return table;
    }

    public void setTable(List<String> table) {
        this.table = table;
    }

    public Integer getNombre() {
        return nombre;
    }

    public void setNombre(Integer nombre) {
        this.nombre = nombre;
    }
}
