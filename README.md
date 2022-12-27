
# Projet

Construire un index alphabétique à partir d'une liste prédéfinie

## Comment le programme fonctionne?
J'ai implémenté 2 structures (ABR standard(**Tree.java**) et AVL(**AVL.java**)) qui permettent de construire un index et de réaliser un parcours infixe pour obtenir un index par ordre alphabétique.
La classe **AbstractTree** (dont hérite Tree et AVL)est une classe abstraite qui regroupe les méthodes identiques aux 2 structures et qui contient également des méthodes abstraites (notamment insert) afin de répondre aux spécificités des 2 structures(par ex : équilibrage nécessaire pour l'AVL)

La classe **IndexBuilder.java** permet de créer un objet dont la méthode build prend en paramètres :
- le chemin d'un fichier source, 
- une liste prédéfinie sous forme de Hashset, 
- un objet héritant d'Abstract Tree.  

Le fichier est lu, découpé en mots, si un mot appartient à la liste prédéfinie il est inséré dans l'AVL ou l'ABR reçu en paramètre. Plus exactement si un mot de la liste est rencontré pour la 1ere fois, un nouveau noeud sera inséré, s' il existe déjà seul le numéro de page sera rajouté (si pas déjà présent) dans le noeud(liste chainée de pages **ListeDePage**). Quand tout le fichier a été parcouru, build retourne l'arbre.

Il n'y a plus qu'à réaliser un parcours infixe sur cet arbre, qui se chargera à chaque traitement du noeud courant, d'appeler la méthode writeInFile de ce noeud. Cette méthode écrit le nom du noeud, et parcourt la liste chaînée de pages pour les écrire également dans le fichier.
 
**La classe Utils**

- Pour obtenir les listes de mots.
- Pour obtenir une copié paginée du fichier source