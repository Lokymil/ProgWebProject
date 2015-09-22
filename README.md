# ProgWebProject
Projet web de 5ieme année

________________ Récupération du projet ________________

Pour pouvoir exploiter le projet, il faut d'abord cloner le repository.
Pour cloner le repository :
  - soit le télécharger au format zip
  - soit utiliser "Git CMD" de GUI et utiliser la commande "git pull <repo url>" à partir du dossier de destination
Pour obtenir GUI, se référer à la section "Participation au projet"
  
Une fois le répository cloner, avec un interpréteur de commande :
  - se placer dans le dossier du projet
  - utiliser la commande "gradlew eclipse", l'exécution peut prendre quelques minutes
De cette façon les fichiers ".classpath" et ".project" seront créés et le projet pour être exploitable.

________________ Participation au projet ________________

Dans le cas d'un premier commit, il faut télécharger l'interface git à l'url suivant et l'installer :

  https://git-scm.com/downloads
  
En utilisant "Git CMD" et se placer dans le dossier de projet.

Ensuite, exclure les fichiers ".classpath" et ".project" en utilisant la commande :

  "git rm --cached <fichier>"
  
L'exclusion est normalement nécéssaire qu'au premier commit pour une machine donnée.

Puis créer le commit commenter avec la commande :

  "git commit -m 'coment'"
  
Enfin, il faut push les changements avec la commande :

  "git push origin master"
