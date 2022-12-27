import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;

public class IndexBuilder <T extends AbstractTree> {
    protected File file;
    protected File filePagine;
    protected int nbLine;
    protected int numPage;

    protected int lineWhereBeginsNewPage;
    protected String word;
    protected String line;
    protected String[] words;
    

    public IndexBuilder() { 
        lineWhereBeginsNewPage = 50;   
    }

    /*construit puis retourne un index*/
    public T build(String filePath,HashSet<String> liste, T index) {

        file = new File(filePath);
        nbLine = 0;
        numPage = 0;
        try {

            BufferedReader fichier = new BufferedReader(new FileReader(this.file.getAbsolutePath(),
                    StandardCharsets.UTF_8));
            
            String line = null;

            /* lecture du fichier source et insertion dans un arbre */
            while ((line = fichier.readLine()) != null) {

                nbLine++;
                numPage = nbLine / lineWhereBeginsNewPage + 1;
               

                /* découpage des lignes en mots */
                words = line.split(" ");
                for (String word : words) {
                    /*
                     * nettoyage et formatage du mot:
                     * suppression ponctuation et comme
                     * la liste prédéfinie est en majuscule, on passe le mot en upperCase
                     * pour comparer
                     */
                    String wordCleaned = word.replaceAll("[\\[\\]().,!?:;]", "");
                    // pour enlever l' et L':
                    wordCleaned = wordCleaned.replaceAll("(?i)\\bl'\\b", "");
                    String wordUpper=wordCleaned.toUpperCase();
                    if (liste.contains(wordUpper)) {
                        //on récupère à chaque fois la racine (utile surtout pour AVL)
                        index.root=index.insert(index.root,wordUpper, numPage);
                    } 
                }
            }
            fichier.close();  
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return index;
    }

}
