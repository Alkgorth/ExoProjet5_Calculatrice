# 🧮 Calculatrice Java

Projet de calculatrice en ligne de commande développé en Java, proposant diverses opérations mathématiques via un menu interactif.

## 📋 Description

Cette application console permet d'effectuer différentes opérations mathématiques de manière interactive. L'utilisateur peut choisir parmi plusieurs fonctionnalités via un menu et effectuer autant d'opérations qu'il le souhaite jusqu'à ce qu'il décide de quitter.

## ✨ Fonctionnalités

### Opérations implémentées

- ✅ **Addition** : Additionner deux nombres décimaux
- ✅ **Addition multiple** : Additionner plusieurs nombres (jusqu'à 100) en une seule opération
- ✅ **Factorisation** : Décomposer un nombre en facteurs premiers avec algorithme optimisé
- ✅ **Vérification de nombres premiers** : Déterminer si un nombre est premier
- ✅ **Table de multiplication** : Afficher la table de multiplication d'un nombre (1-999) avec alignement formaté
- ✅ **Mise à la puissance** : Calculer la puissance d'un nombre (exposants positifs uniquement)

## 🗂️ Structure du projet

```
ExoProjet5_Calculatrice/
└── java/
    ├── Main.java                   # Point d'entrée de l'application avec menu interactif
    ├── somme.java                  # Addition de deux nombres décimaux
    ├── sommeMultiple.java          # Addition de plusieurs nombres (max 100)
    ├── factorisation.java          # Décomposition en facteurs premiers
    ├── premier.java                # Vérification de nombres premiers
    ├── tableMultiplication.java    # Table de multiplication avec formatage
    └── puissance.java              # Calcul de puissance
```

## 🚀 Utilisation

### 📱 Version Web - Spring Boot (Recommandée pour le portfolio)

Il existe maintenant une **version web moderne** de cette calculatrice utilisée pour le portfolio !

#### 🐳 Lancer avec Docker (Local)

**Prérequis** :
- Docker installé et démarré
- Être dans le dossier `calculatriceSpringBoot/calculatrice/`

**Étapes** (à exécuter dans le terminal, une après l'autre) :

##### **1️⃣ Compiler le projet**
```bash
.\mvnw.cmd clean package
```
Cette commande :
- Télécharge les dépendances Maven
- Compile le code Java
- Crée un fichier `.jar` dans le dossier `target/`
- ⏳ Cela peut prendre 2-5 minutes la première fois

**Attendez le message :**
```
[INFO] BUILD SUCCESS
```

---

##### **2️⃣ Construire l'image Docker**
```bash
docker build -t calculatrice-web:latest .
```
Cette commande :
- Crée une image Docker multi-stage
- Stage 1 : Compile avec Maven
- Stage 2 : Crée une image runtime minimale (70MB)
- Les fichiers source sont supprimés de l'image finale (sécurité 🔒)

**Attendez le message :**
```
Successfully tagged calculatrice-web:latest
```

---

##### **3️⃣ Lancer le container**
```bash
docker run -p 8080:8080 calculatrice-web:latest
```
Cette commande :
- Lance le container
- Mappe le port 8080 du container au port 8080 local
- L'application démarre automatiquement

**Vous verrez :**
```
Started CalculatriceApplication in X seconds (JVM running for X.XXs)
```

---

#### 🌐 Accéder à l'application

Ouvrez votre navigateur et allez à :
```
http://localhost:8080
```

Vous verrez la calculatrice web avec une belle interface Bootstrap ! 🎨

---

#### ⏹️ Arrêter l'application

Dans le terminal, appuyez sur :
```
Ctrl + C
```

---

#### 📋 Commandes utiles Docker

```bash
# Voir les containers en cours d'exécution
docker ps

# Voir les images disponibles
docker images

# Voir les logs en temps réel
docker logs -f calculatrice-web

# Supprimer l'image
docker rmi calculatrice-web:latest

# Nettoyer les images inutilisées
docker image prune -f
```

---

### 💻 Version Console - Java pur (Original)

#### Prérequis

- Java JDK 8 ou supérieur
- Terminal/Invite de commandes

#### Compilation

```bash
cd java
javac *.java
```

#### Exécution

```bash
java Main
```

#### Navigation dans le menu

```
=== Calculatrice ===
1. Additionner 2 nombres
2. Additionner plusieurs nombres
3. Factoriser un nombre
4. Vérifier si un nombre est premier
5. Afficher table de multiplication
6. Calculer la puissance
7. Quitter
Choisissez une option (1-7) :
```

Entrez le numéro correspondant à l'opération souhaitée et suivez les instructions.

## 🔧 Détails techniques

### Gestion des entrées

- L'application utilise `Scanner` pour la saisie utilisateur
- Gestion des erreurs avec des blocs `try-catch` pour éviter les plantages
- Validation des entrées pour garantir la cohérence des données

### Algorithmes notables

#### Addition multiple
- Utilise un tableau dynamique pour stocker les nombres
- Limite de 100 nombres maximum pour éviter les abus
- Validation stricte des entrées

#### Factorisation en nombres premiers
L'algorithme optimisé :
1. Extrait tous les facteurs 2
2. Teste les diviseurs impairs à partir de 3
3. S'arrête à la racine carrée du nombre pour optimiser les performances
4. Utilise une `ArrayList` pour stocker dynamiquement les facteurs

#### Vérification de nombre premier
Méthode efficace qui teste les diviseurs jusqu'à la racine carrée du nombre.

#### Table de multiplication
- Affichage formaté avec alignement des colonnes (`printf`)
- Limite de 1 à 999 pour garantir un affichage optimal
- Table de 1 à 10 (standard)

#### Calcul de puissance
- Algorithme itératif avec boucle
- Gère le cas spécial 0^0 (indéfini)
- Accepte les bases négatives
- Refuse les exposants négatifs (simplification volontaire)

## 🎓 Contexte pédagogique

Ce projet fait partie d'un exercice d'apprentissage de Java, mettant en pratique :
- Les structures de contrôle (boucles, conditions)
- La gestion des exceptions
- L'utilisation de classes et méthodes statiques
- Les structures de données (ArrayList)
- L'interaction utilisateur via la console

## 📝 État du projet

**Version actuelle** : 1.0 - Complète ✅

**Fonctionnalités complètes** :
- ✅ Menu principal interactif
- ✅ Addition de deux nombres décimaux
- ✅ Addition de plusieurs nombres (jusqu'à 100)
- ✅ Factorisation en nombres premiers
- ✅ Vérification de nombres premiers
- ✅ Table de multiplication formatée (1-999)
- ✅ Calcul de puissance (exposants positifs)
- ✅ Gestion complète des erreurs et validations
- ✅ Messages d'erreur clairs et cohérents

## 🐛 Problèmes connus

Aucun problème majeur identifié pour les fonctionnalités implémentées.

## 🔜 Améliorations futures possibles

- Ajouter d'autres opérations (soustraction, division, modulo, racine carrée)
- Implémenter les exposants négatifs pour la puissance
- Ajouter un historique des calculs effectués
- Permettre de sauvegarder les résultats dans un fichier
- Interface graphique (GUI) avec Swing ou JavaFX

## 👤 Auteur

Projet développé dans le cadre d'un exercice d'apprentissage Java.

## 📄 Licence

Projet éducatif - Libre d'utilisation pour l'apprentissage.
