# 🧮 Calculatrice Java

Projet de calculatrice en ligne de commande développé en Java, proposant diverses opérations mathématiques via un menu interactif.

## 📋 Description

Cette application console permet d'effectuer différentes opérations mathématiques de manière interactive. L'utilisateur peut choisir parmi plusieurs fonctionnalités via un menu et effectuer autant d'opérations qu'il le souhaite jusqu'à ce qu'il décide de quitter.

## ✨ Fonctionnalités

### Opérations implémentées

- ✅ **Addition** : Additionner deux nombres décimaux
- ✅ **Factorisation** : Décomposer un nombre en facteurs premiers
- 🚧 **Vérification de nombres premiers** : Déterminer si un nombre est premier (en développement)
- 🚧 **Table de multiplication** : Afficher la table de multiplication d'un nombre (en développement)
- 🚧 **Mise à la puissance** : Calculer la puissance d'un nombre (en développement)

### Fonctionnalités prévues

- 📝 **Addition multiple** : Additionner plusieurs nombres en une seule opération

## 🗂️ Structure du projet

```
ExoProjet5_Calculatrice/
└── java/
    ├── Main.java              # Point d'entrée de l'application avec menu interactif
    ├── somme.java             # Opération d'addition de deux nombres
    ├── factorisation.java     # Décomposition en facteurs premiers
    ├── premier.java           # Vérification de nombres premiers
    └── sommeMultiple.java     # Addition de plusieurs nombres (à implémenter)
```

## 🚀 Utilisation

### Prérequis

- Java JDK 8 ou supérieur
- Terminal/Invite de commandes

### Compilation

```bash
cd java
javac *.java
```

### Exécution

```bash
java Main
```

### Navigation dans le menu

```
=== Calculatrice ===
1. Additionner
2. Factoriser un nombre
3. Vérifier si un nombre est premier
4. Afficher table de multiplication
5. Mettre à la puissance
6. Quitter
Choisissez une option (1-6) :
```

Entrez le numéro correspondant à l'opération souhaitée et suivez les instructions.

## 🔧 Détails techniques

### Gestion des entrées

- L'application utilise `Scanner` pour la saisie utilisateur
- Gestion des erreurs avec des blocs `try-catch` pour éviter les plantages
- Validation des entrées pour garantir la cohérence des données

### Algorithmes notables

#### Factorisation en nombres premiers

L'algorithme optimisé :
1. Extrait tous les facteurs 2
2. Teste les diviseurs impairs à partir de 3
3. S'arrête à la racine carrée du nombre pour optimiser les performances
4. Utilise une `ArrayList` pour stocker dynamiquement les facteurs

#### Vérification de nombre premier

Méthode efficace qui teste les diviseurs jusqu'à la racine carrée du nombre.

## 🎓 Contexte pédagogique

Ce projet fait partie d'un exercice d'apprentissage de Java, mettant en pratique :
- Les structures de contrôle (boucles, conditions)
- La gestion des exceptions
- L'utilisation de classes et méthodes statiques
- Les structures de données (ArrayList)
- L'interaction utilisateur via la console

## 📝 État du projet

**Version actuelle** : En développement

**Fonctionnalités complètes** :
- ✅ Menu principal
- ✅ Addition de deux nombres
- ✅ Factorisation en nombres premiers

**En cours de développement** :
- 🚧 Vérification de nombres premiers
- 🚧 Table de multiplication
- 🚧 Mise à la puissance
- 🚧 Addition multiple

## 🐛 Problèmes connus

Aucun problème majeur identifié pour les fonctionnalités implémentées.

## 🔜 Améliorations futures

- Implémenter toutes les opérations du menu
- Ajouter d'autres opérations (soustraction, division, modulo)
- Améliorer l'affichage des résultats
- Ajouter un historique des calculs

## 👤 Auteur

Projet développé dans le cadre d'un exercice d'apprentissage Java.

## 📄 Licence

Projet éducatif - Libre d'utilisation pour l'apprentissage.
