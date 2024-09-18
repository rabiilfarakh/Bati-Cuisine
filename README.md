# Bati-Cuisine

## Description
**Bati-Cuisine** est une application console en Java conçue pour aider les professionnels de la construction et de la rénovation de cuisines à estimer les coûts des projets. Elle permet la gestion des clients, des matériaux, de la main-d'œuvre, et la génération de devis.

## Fonctionnalités

### 1. Gestion des Projets
- Ajouter et gérer des projets de rénovation de cuisine pour différents clients.
- Associer des composants au projet, tels que les matériaux et la main-d'œuvre.
- Suivi des coûts estimés des projets en fonction des informations fournies.

### 2. Gestion des Matériaux
- Ajouter des matériaux nécessaires au projet, avec leur coût unitaire et la quantité requise.
- Calcul automatique du coût total des matériaux pour le projet.

### 3. Gestion de la Main-d'œuvre
- Ajouter des informations sur la main-d'œuvre, y compris le coût horaire et le nombre d'heures nécessaires.
- Estimation du coût total de la main-d'œuvre pour chaque projet.

### 4. Gestion des Clients
- Enregistrer et gérer les informations des clients pour les projets de cuisine.
- Suivi des projets par client.

### 5. Création de Devis
- Générer un devis basé sur les matériaux, la main-d'œuvre, et les coûts associés au projet.
- Calcul des coûts totaux incluant les marges et les taxes applicables.

## Utilisation
L'application fonctionne via une interface en ligne de commande. Voici les étapes de base pour l'utiliser :

1. Lancer l'application depuis un terminal ou une ligne de commande.
2. Ajouter un nouveau client.
3. Créer un projet pour ce client en y ajoutant des matériaux et de la main-d'œuvre.
4. Afficher les détails du projet, y compris le coût total estimé.
5. Générer et afficher un devis pour le client.

### Exemple d'utilisation :
1. Lancer l'application.
2. Suivre les invites pour ajouter des informations sur les clients et les projets.
3. Gérer les matériaux et les coûts de main-d'œuvre pour obtenir une estimation des coûts totaux.

## Technologies Utilisées
- **Java** : Langage utilisé pour développer l'application.
- **PostgreSQL** : Base de données relationnelle utilisée pour stocker les informations sur les clients, les projets, les matériaux, et la main-d'œuvre.
- **JDBC** : API Java pour interagir avec la base de données PostgreSQL.
- **Application Console** : Interface utilisateur sous forme de CLI (Command Line Interface).

## Installation
1. Cloner le dépôt GitHub :
    ```bash
    git clone https://github.com/rabiilfarakh/Bati-Cuisine.git
    ```
2. Configurer la connexion à la base de données PostgreSQL en modifiant les paramètres JDBC dans le fichier de configuration.
3. Compiler le code source avec `javac` :
    ```bash
    javac BatiCuisine.java
    ```
4. Exécuter l'application :
    ```bash
    java BatiCuisine
    ```
