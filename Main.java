import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

        /* Copie du texte avec une pagination pour pouvoir vérifier plus facilement
         le bon fonctionnement du programme*/
        //Utils.copyAndPaginate();


        //permet d'instancier un constructeur d'index qui utilisera une structure de données héritant d'AbstractTree : donc ici soit un ABR standard soit un AVL
        IndexBuilder<AbstractTree> indexBuilder = new IndexBuilder<AbstractTree>();
        //récupère une liste prédéfinie de personnages
        HashSet<String> listePersonnages = Utils.getListOfCharacters();
        // récupère une liste prédéfinie de mots
        HashSet<String> listeMots = Utils.getListOfWords();
        //récupère des index(arbres) créé à partir d'un fichier source, d'une liste prédéfinie 
        AbstractTree indexPerso = indexBuilder.build("source.txt",listePersonnages, new AVL());
        AbstractTree indexMots = indexBuilder.build("source.txt", listeMots, new Tree());
        FileWriter fos = null;
        try {
            File file = new File("index.txt");
            //Décommenter les 2 lignes suivantes pour vider le fichier avant d'y écrire dedans
            //fos = new FileWriter(file.getAbsolutePath());
            //fos.write("");
            fos = new FileWriter(file.getAbsolutePath(), StandardCharsets.UTF_8, true);
            fos.write("\n********INDEX PERSONNAGES****************************\n");
            System.out.println("\n********INDEX PERSONNAGES****************************\n");
            indexPerso.infixe(indexPerso.root, fos);
            fos.write("\n********INDEX MOTS****************************\n");
            System.out.println("\n********INDEX MOTS****************************\n");
            indexMots.infixe(indexMots.root, fos);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //System.out.println("hauteur="+indexPerso.getHeightTree(indexPerso.root));
        //System.out.println("hauteur=" +indexMots.getHeightTree(indexMots.root));    
    }
}
