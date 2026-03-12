🚀 ÉTAPE 1 : Créer le projet Spring Boot (30 min)
1.1 Aller sur start.spring.io
Ouvrir https://start.spring.io

Configuration :

Project : Maven
Language : Java
Spring Boot : 3.2.x (dernière version)
Group : com.votreNom
Artifact : calculatrice
Java : 17 ou 21
Dépendances à ajouter (bouton "Add Dependencies") :

✅ Spring Web
✅ Thymeleaf
✅ Spring Boot DevTools
Cliquer "Generate" → Téléchargement d'un .zip

Dézipper dans C:\Env\Workspace\IntroJava\CalculatriceWeb\

Ouvrir dans VS Code

🗂️ ÉTAPE 2 : Structure du projet (10 min)
Créer cette structure :
calculatrice/
├── src/main/java/com/votreNom/calculatrice/
│   ├── CalculatriceApplication.java  (déjà créé)
│   ├── Controller/
│   │   └── CalculController.java
│   ├── Service/
│   │   ├── SommeService.java
│   │   ├── FactorisationService.java
│   │   ├── PuissanceService.java
│   │   ├── PremierService.java
│   │   └── TableMultiplicationService.java
│   └── Model/
│       └── ResultatCalcul.java
├── src/main/resources/
│   ├── templates/
│   │   ├── index.html
│   │   └── resultat.html
│   ├── static/
│   │   ├── css/
│   │   │   ├── common.css
│   │   │   ├── index.css
│   │   │   └── resultat.css
│   │   └── js/
│   │       └── script.js
│   └── application.properties
├── pom.xml
└── Dockerfile

💻 ÉTAPE 3 : Réutiliser votre code (2-3h)
3.1 Créer le modèle de données (ResultatCalcul.java)
Model/ResultatCalcul.java :
```java
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

    // Constructeurs
    public ResultatCalcul() {
    }

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

    // Getters and Setters (générer automatiquement avec votre IDE)
    public String getOperation() { return operation; }
    public void setOperation(String operation) { this.operation = operation; }
    
    public Double getResultat() { return resultat; }
    public void setResultat(Double resultat) { this.resultat = resultat; }
    
    // ... etc pour tous les attributs
}
```

3.2 Créer les Services
Copiez vos calculs existants dans des Services Spring.

Exemple : SommeService.java
```java
@Service
public class SommeService {
    
    public double somme(double a, double b) {
        return a + b;
    }
    
    public double sommeMultiple(List<Double> nombres) {
        return nombres.stream().mapToDouble(Double::doubleValue).sum();
    }
}
```

Faites pareil pour :

FactorisationService → copier la logique de factorisation.java
PuissanceService → copier depuis puissance.java
PremierService → copier depuis premier.java
TableMultiplicationService → copier depuis tableMultiplication.java

3.3 Créer le Controller
CalculController.java :
```java
@Controller
public class CalculController {
    
    @Autowired
    private SommeService sommeService;
    
    @GetMapping("/")
    public String accueil() {
        return "index";
    }
    
    @PostMapping("/calculer/somme")
    public String calculerSomme(
            @RequestParam(required = false) Double a,
            @RequestParam(required = false) Double b,
            Model model) {
        if (a == null || b == null) {
            model.addAttribute("error", "Veuillez fournir deux nombres valides.");
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
    
    // Autres méthodes pour factorisation, puissance, vérification nombre premier, table de multiplication
}
```



🎨 ÉTAPE 4 : Créer l'interface (3-4h)
4.1 Page d'accueil : templates/index.html

Formulaires Bootstrap pour :
- Addition de 2 nombres
- Addition multiple (liste de nombres séparés par des virgules)
- Factorisation en nombres premiers
- Vérification si un nombre est premier
- Calcul de puissance (base^exposant)
- Table de multiplication

Exemple de structure :
```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org" lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Calculatrice - Accueil</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/index.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h1 class="text-center mb-4">🧮 Calculatrice Spring Boot</h1>
        
        <!-- Message d'erreur (si existe) -->
        <div th:if="${error != null}" class="alert alert-danger alert-dismissible fade show">
            <strong>Erreur :</strong> <span th:text="${error}"></span>
        </div>
        
        <!-- Chaque opération dans une carte -->
        <div class="card">
            <div class="card-header">➕ Addition de 2 nombres</div>
            <div class="card-body">
                <form action="/calculer/somme" method="post">
                    <input type="number" step="0.01" name="a" class="form-control" placeholder="Nombre 1" required>
                    <input type="number" step="0.01" name="b" class="form-control" placeholder="Nombre 2" required>
                    <button type="submit" class="btn btn-primary w-100">Calculer</button>
                </form>
            </div>
        </div>
        
        <!-- Autres cartes pour les autres opérations... -->
    </div>
</body>
</html>
```

4.2 Page résultat : templates/resultat.html

Affiche le résultat de l'opération en utilisant l'objet `ResultatCalcul` :
- Affichage du résultat numérique (addition, puissance, etc.)
- Affichage du test de primalité (✨ Premier ! ou ❌ Pas premier)
- Affichage des facteurs premiers avec symbole "×"
- Affichage de la table de multiplication
- Bouton "Retour à l'accueil"

Exemple :
```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org" lang="fr">
<head>
    <title>Résultat - Calculatrice</title>
    <link href="/css/resultat.css" rel="stylesheet">
</head>
<body>
    <div class="result-card">
        <h1>✅ Calcul terminé</h1>
        <p class="operation-title" th:text="${resultat.operation}">Opération</p>
        
        <!-- Affichage du résultat numérique -->
        <div th:if="${resultat.resultat != null}" class="result-value" th:text="${resultat.resultat}">42</div>
        
        <!-- Affichage du test de primalité -->
        <div th:if="${resultat.estPremier != null}" class="result-value">
            <div th:if="${resultat.estPremier}" class="result-premier-true">✨ Ce nombre EST premier !</div>
            <div th:unless="${resultat.estPremier}" class="result-premier-false">❌ Ce nombre N'est PAS premier</div>
        </div>
        
        <!-- Affichage des facteurs -->
        <div th:if="${resultat.facteurs != null}" class="facteurs-list">
            <h5>Facteurs premiers :</h5>
            <span th:each="facteur, stat : ${resultat.facteurs}">
                <span class="facteur-item" th:text="${facteur}">2</span>
                <span th:if="${!stat.last}" class="facteur-separator"> × </span>
            </span>
        </div>
        
        <!-- Affichage de la table -->
        <div th:if="${resultat.table != null}" class="facteurs-list">
            <h5>Table de multiplication de <span th:text="${resultat.nombre}">7</span> :</h5>
            <div class="table-multiplication">
                <div th:each="ligne : ${resultat.table}" th:text="${ligne}">3 x 1 = 3</div>
            </div>
        </div>
        
        <a href="/" class="btn-home">🏠 Retour à l'accueil</a>
    </div>
</body>
</html>
```

4.3 Style CSS

Créer/modifier les fichiers CSS :
- `common.css` : Variables globales (couleurs, gradients)
- `index.css` : Style des formulaires et cartes
- `resultat.css` : Style de la page résultat

Utiliser les classes CSS pour styliser, sans CSS inline dans le HTML.

▶️ ÉTAPE 5 : Tester localement (15 min)
# Dans le terminal
cd C:\Env\Workspace\IntroJava\CalculatriceWeb\calculatrice
mvn spring-boot:run

Ouvrir : http://localhost:8080

🐳 ÉTAPE 6 : Préparation Docker (30 min)
6.1 Créer Dockerfile multi-stage à la racine du projet

À la racine du projet, créer `Dockerfile` :
```dockerfile
# Stage 1: Build avec Maven
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Runtime avec JRE minimaliste
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
```

6.2 Créer .dockerignore à la racine
```
target/
.mvn/
*.iml
.idea/
.git/
.gitignore
*.md
node_modules/
*.log
```

6.3 Builder et tester localement
```bash
# Compiler le projet Maven
mvn clean package

# Builder l'image Docker
docker build -t calculatrice-web:latest .

# Tester en local
docker run -p 8080:8080 calculatrice-web:latest

# Accéder
http://localhost:8080
```

✅ **C'est prêt pour le déploiement !**

🌐 ÉTAPE 7 : Déployer sur votre VPS (1-2h)
7.1 Préparer le projet pour production
Créer docker-compose.yml à la racine :
```yaml
version: '3.8'
services:
  traefik:
    image: traefik:v2.10
    container_name: traefik
    restart: unless-stopped
    command:
      - "--api.insecure=false"
      - "--providers.docker=true"
      - "--providers.docker.exposedbydefault=false"
      - "--entrypoints.web.address=:80"
      - "--entrypoints.websecure.address=:443"
      - "--certificatesresolvers.letsencrypt.acme.httpchallenge=true"
      - "--certificatesresolvers.letsencrypt.acme.httpchallenge.entrypoint=web"
      - "--certificatesresolvers.letsencrypt.acme.email=votre-email@example.com"
      - "--certificatesresolvers.letsencrypt.acme.storage=/letsencrypt/acme.json"
    ports:
      - "80:80"
      - "443:443"
    volumes:
      - /var/run/docker.sock:/var/run/docker.sock:ro
      - ./letsencrypt:/letsencrypt
    networks:
      - web

  calculatrice:
    build: .
    container_name: calculatrice-web
    restart: unless-stopped
    environment:
      - SPRING_PROFILES_ACTIVE=prod
    labels:
      - "traefik.enable=true"
      - "traefik.http.routers.calculatrice.rule=Host(`calculatrice.votredomaine.com`)"
      - "traefik.http.routers.calculatrice.entrypoints=web,websecure"
      - "traefik.http.routers.calculatrice.tls.certresolver=letsencrypt"
      - "traefik.http.services.calculatrice.loadbalancer.server.port=8080"
      - "traefik.http.middlewares.redirect-to-https.redirectscheme.scheme=https"
      - "traefik.http.routers.calculatrice-http.middlewares=redirect-to-https@docker"
    networks:
      - web

networks:
  web:
    external: false
```

7.2 Créer la structure de déploiement
```bash
# Structure attendue sur le VPS
/var/www/calculatrice/
├── src/
├── pom.xml
├── Dockerfile           # Créé à l'ÉTAPE 6
├── .dockerignore        # Créé à l'ÉTAPE 6
├── docker-compose.yml   # Créé à l'ÉTAPE 7.1
├── letsencrypt/         # Sera créé automatiquement
└── .git/
```

7.3 Transférer sur le VPS
```bash
# Sur votre machine locale
git add .
git commit -m "Conversion en application Spring Boot avec Traefik"
git push origin main

# Sur votre VPS (SSH)
ssh votre-user@votre-vps
cd /var/www/calculatrice  # Ou votre chemin préféré
git clone votre-repo .
```

7.4 Configurer Traefik (reverse proxy & certificats SSL auto)
Traefik est déjà configuré dans le docker-compose.yml ci-dessus. Les étapes principales :

✅ Traefik écoute sur les ports 80 (HTTP) et 443 (HTTPS)
✅ Certificats SSL automatiques avec Let's Encrypt
✅ Redirection automatique HTTP → HTTPS
✅ Routing automatique basé sur les labels du service

**Configuration importante :**
- Remplacez `votre-email@example.com` par votre email
- Remplacez `calculatrice.votredomaine.com` par votre domaine
- Assurez-vous que les ports 80 et 443 ne sont pas bloqués par le firewall

7.5 Configurer le sous-domaine DNS
Dans votre registrar/DNS :
```
Type: A
Nom: calculatrice
Valeur: IP-de-votre-VPS
TTL: 3600
```

7.6 Lancer l'application
```bash
cd /var/www/calculatrice

# Créer le dossier pour les certificats Let's Encrypt
mkdir -p letsencrypt
chmod 600 letsencrypt

# Lancer les containers
docker-compose up -d --build
```

7.7 Vérifier que tout fonctionne
```bash
# Vérifier que les containers tournent
docker ps

# Voir les logs de Traefik
docker logs -f traefik

# Voir les logs de l'application
docker logs -f calculatrice-web

# Tester en local (remplacer par votre IP)
curl http://localhost
```

Accéder depuis votre navigateur :
https://calculatrice.votredomaine.com

La redirection HTTPS est automatique ! 🔒

📝 ÉTAPE 8 : Maintenance et mise à jour (bonus)
8.1 Script de déploiement (deploy.sh)
```bash
#!/bin/bash
echo "🚀 Déploiement de la calculatrice..."

# Pull dernières modifications
git pull origin main

# Rebuild et restart
docker-compose down
docker-compose up -d --build

# Nettoyage
docker image prune -f

echo "✅ Déploiement terminé !"
echo "📊 Logs en temps réel :"
docker logs -f calculatrice-web
```

Rendre exécutable :
```bash
chmod +x deploy.sh
```

8.2 Commandes utiles
```bash
# Voir les logs
docker logs -f calculatrice-web

# Redémarrer
docker-compose restart

# Arrêter
docker-compose down

# Rebuild complète
docker-compose down && docker-compose up -d --build

# Voir l'utilisation des ressources
docker stats calculatrice-web
```

8.3 Monitoring (optionnel)
Ajouter dans docker-compose.yml :
```yaml
services:
  calculatrice:
    # ... config existante
    healthcheck:
      test: ["CMD", "curl", "-f", "http://localhost:8080/actuator/health"]
      interval: 30s
      timeout: 10s
      retries: 3
```

Et ajouter dans pom.xml :
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

⏱️ TEMPS TOTAL : 10-14 heures
📍 Votre application sera accessible sur : https://calculatrice.votredomaine.com