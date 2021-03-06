# ProgWebProject
Projet web de 5ieme année ESIEA ecolé d'ingénieur informatique

Le but de ce projet est de créer un blog capable de gérer :
  - plusieurs utilisateurs
  - multiplicité d'articles

Cette application doit être un site web dit "one page".

________________ Récupération du projet et lancement de l'application________________

Pour pouvoir exploiter le projet, il faut d'abord cloner le repository.
Pour cloner le repository :
  - soit le télécharger au format zip
  - soit utiliser "Git CMD" de GUI et utiliser la commande "git clone  [repo url]" à partir du dossier de destination.

Pour obtenir GUI, se référer à la section "Participation au projet"
  
Une fois le répository cloner, avec un interpréteur de commande :
  - se placer dans le dossier du projet
  - utiliser la commande "gradlew eclipse", l'exécution peut prendre quelques minutes
De cette façon les fichiers ".classpath" et ".project" seront créés, les dépendances bibliothèques externes seront téléchargées et le projet pour être exploitable.

Pour lancer l'application sans utiliser un .jar il faut avoir effectué le "gradlew eclipse" expliqué précédemment.
Ensuite il faut ouvrir le projet avec eclipse et :
  - clic droit sur le fichier "src/main/java/ProgWebProjectApplication.class"
  - sélectionner "Run as > Java application"

Le projet est désormais lancé. Pour avoir accès à l'interface web il faut utiliser l'url :
  http://localhost:8090/index.html

________________ Participation au projet ________________

Dans le cas d'un premier commit, il faut télécharger l'interface git à l'url suivant et l'installer :
  https://git-scm.com/downloads
  
En utilisant "Git CMD" se placer dans le dossier de projet.

Avant toutes modification sur le repository, il est nécessaire d'être à jour. Pour cela, il faut utiliser la commande :
 - git pull

Ensuite, il faut ajouter les fichiers modifiés au commit en utilisant la commande :
  - git add .

Puis créer le commit commenter avec la commande :
  - git commit -m 'coment'

Enfin, il faut push les changements avec la commande :
 - git push origin master

________________ Création de l'exécutable ________________

Pour créer un exécutable il faut utiliser un invite de commande et se placer dans le dossier root du projet.
Ensuite il faut lancer la commande :
  - gradlew clean build

Le fichier '.jar' se trouve dans le dossier "build/lib" du projet.
