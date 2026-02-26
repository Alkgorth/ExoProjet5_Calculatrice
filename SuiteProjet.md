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
│   ├── controller/
│   │   └── CalculController.java
│   ├── service/
│   │   ├── SommeService.java
│   │   ├── FactorisationService.java
│   │   ├── PuissanceService.java
│   │   ├── PremierService.java
│   │   └── TableMultiplicationService.java
│   └── model/
│       └── ResultatCalcul.java
├── src/main/resources/
│   ├── templates/
│   │   ├── index.html
│   │   └── resultat.html
│   └── static/
│       ├── css/
│       │   └── style.css
│       └── js/
│           └── script.js
└── pom.xml

💻 ÉTAPE 3 : Réutiliser votre code (2-3h)
3.1 Créer les Services
Copiez vos calculs existants dans des Services Spring.

Exemple : SommeService.java
@Service
public class SommeService {
    
    public double additionner(double a, double b) {
        return a + b;  // Votre logique existante !
    }
    
    public double additionnerMultiple(List<Double> nombres) {
        return nombres.stream().mapToDouble(Double::doubleValue).sum();
    }
}

Faites pareil pour :

FactorisationService → copier la logique de factorisation.java
PuissanceService → copier depuis puissance.java
etc.

3.2 Créer le Controller
CalculController.java :
@Controller
public class CalculController {
    
    @Autowired
    private SommeService sommeService;
    
    @GetMapping("/")
    public String accueil() {
        return "index";  // Affiche index.html
    }
    
    @PostMapping("/calculer/somme")
    public String calculerSomme(@RequestParam double a, @RequestParam double b, Model model) {
        double resultat = sommeService.additionner(a, b);
        model.addAttribute("resultat", resultat);
        return "resultat";  // Affiche resultat.html
    }
    
    // Autres méthodes pour factorisation, puissance, etc.
}

🎨 ÉTAPE 4 : Créer l'interface (3-4h)
4.1 Page d'accueil : templates/index.html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Calculatrice</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h1 class="text-center">🧮 Calculatrice</h1>
        
        <!-- Formulaire Addition -->
        <div class="card mt-4">
            <div class="card-body">
                <h3>Addition</h3>
                <form action="/calculer/somme" method="post">
                    <input type="number" name="a" step="0.01" class="form-control mb-2" placeholder="Nombre 1">
                    <input type="number" name="b" step="0.01" class="form-control mb-2" placeholder="Nombre 2">
                    <button type="submit" class="btn btn-primary">Calculer</button>
                </form>
            </div>
        </div>
        
        <!-- Autres opérations... -->
    </div>
</body>
</html>

4.2 Page résultat : templates/resultat.html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Résultat</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h1>Résultat</h1>
        <div class="alert alert-success">
            <h2 th:text="${resultat}">42</h2>
        </div>
        <a href="/" class="btn btn-primary">Retour</a>
    </div>
</body>
</html>

▶️ ÉTAPE 5 : Tester localement (15 min)
# Dans le terminal
cd C:\Env\Workspace\IntroJava\CalculatriceWeb\calculatrice
mvn spring-boot:run

Ouvrir : http://localhost:8080

🐳 ÉTAPE 6 : Dockeriser (1h)
6.1 Créer Dockerfile à la racine :
FROM openjdk:17-slim
WORKDIR /app
COPY target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]

6.2 Créer .dockerignore :
target/
.mvn/
*.iml
.idea/

6.3 Builder :
mvn clean package
docker build -t calculatrice-web .
docker run -p 8080:8080 calculatrice-web

🌐 ÉTAPE 7 : Déployer sur votre VPS (1-2h)
7.1 Préparer le projet pour production
Créer docker-compose.yml à la racine :
```yaml
version: '3.8'
services:
  calculatrice:
    build: .
    container_name: calculatrice-web
    restart: unless-stopped
    ports:
      - "8081:8080"  # Port interne 8081 (à adapter selon vos projets, 8082, 8083,.. )
    environment:
      - SPRING_PROFILES_ACTIVE=prod
    networks:
      - web

networks:
  web:
    external: true  # Réseau partagé avec nginx
```

7.2 Optimiser le Dockerfile (build multi-stage)
```dockerfile
# Stage 1: Build
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Runtime
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
```

7.3 Transférer sur le VPS
```bash
# Sur votre machine locale
git add .
git commit -m "Conversion en application Spring Boot"
git push origin main

# Sur votre VPS (SSH)
ssh votre-user@votre-vps
cd /var/www/calculatrice  # Ou votre chemin préféré
git clone votre-repo .
```

7.4 Configurer Nginx (reverse proxy)
Créer /etc/nginx/sites-available/calculatrice :
```nginx
server {
    listen 80;
    server_name calculatrice.votredomaine.com;  # Votre sous-domaine

    location / {
        proxy_pass http://localhost:8081;  # Port du docker-compose
        proxy_set_header Host $host;
        proxy_set_header X-Real-IP $remote_addr;
        proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_set_header X-Forwarded-Proto $scheme;
        
        # Pour les requêtes longues
        proxy_connect_timeout 60s;
        proxy_send_timeout 60s;
        proxy_read_timeout 60s;
    }
}
```

Activer le site :
```bash
sudo ln -s /etc/nginx/sites-available/calculatrice /etc/nginx/sites-enabled/
sudo nginx -t
sudo systemctl reload nginx
```

7.5 Configurer le sous-domaine DNS
Dans votre registrar/DNS :
```
Type: A
Nom: calculatrice
Valeur: IP-de-votre-VPS
TTL: 3600
```

7.6 Configurer SSL (Let's Encrypt)
```bash
sudo certbot --nginx -d calculatrice.votredomaine.com
```
Certbot va automatiquement modifier la config nginx pour ajouter HTTPS.

7.7 Lancer l'application
```bash
cd /var/www/calculatrice
docker-compose up -d --build
```

7.8 Vérifier que tout fonctionne
```bash
docker ps  # Vérifier que le container tourne
docker logs calculatrice-web  # Voir les logs
curl http://localhost:8081  # Tester en local
```

Accéder depuis votre navigateur :
https://calculatrice.votredomaine.com

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