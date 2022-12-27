
import java.util.HashSet;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;

public class Utils {


    /*
     * copie le fichier d'origine tout en le paginant (pour simplifier la
     * vérification du bon fonctionnement du programme)
     */
    public static void copyAndPaginate(){
        try {
            File source=new File("source.txt");
            File destination = new File("copie_paginee.txt");
            BufferedReader file = new BufferedReader(new FileReader(source.getAbsolutePath(),StandardCharsets.UTF_8));
            BufferedWriter filePagine = new BufferedWriter(
                    new FileWriter(destination.getAbsolutePath(), StandardCharsets.UTF_8));
            String line = null;
            int nbLine =0;
            int numPage=0;
            int lineWhereBeginsNewPage=50;
            
            while ((line = file.readLine()) != null) {
                nbLine++;
                numPage = nbLine / lineWhereBeginsNewPage + 1;
                if (nbLine % lineWhereBeginsNewPage == 0) {
                    filePagine.newLine();
                    filePagine.write("******page " + numPage + "******");
                    filePagine.newLine();
                    filePagine.newLine();
                }
                filePagine.write(line);
                filePagine.newLine();
            }
            file.close();
            filePagine.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }
    
   
    /*Renvoie la liste des personnages de Tartuffe*/
    public static HashSet<String> getListOfCharacters() {
        HashSet<String> liste = new HashSet<String>();
        liste.add("PERNELLE");
        liste.add("ORGON");
        liste.add("DAMIS");
        liste.add("MARIANE");
        liste.add("VALÈRE");
        liste.add("CLÉANTE");
        liste.add("EXEMPT");
        liste.add("TARTUFFE");
        liste.add("LOYAL");
        liste.add("DORINE");
        liste.add("FLIPOTE");
        return liste;
    }
    /*renvoie une liste de mots présents dans Tartuffe */
    public static HashSet<String> getListOfWords() {
        HashSet<String> liste = new HashSet<String>();
        liste.add("père".toUpperCase());
        liste.add("fille".toUpperCase());
        liste.add("dessein".toUpperCase());
        liste.add("devoir".toUpperCase());
        liste.add("humeur".toUpperCase());
        liste.add("dieu".toUpperCase());
        liste.add("mère".toUpperCase());
        liste.add("diantre".toUpperCase());
        liste.add("gens".toUpperCase());
        liste.add("heure".toUpperCase());
        liste.add("honneur".toUpperCase());
        liste.add("zèle".toUpperCase());
        liste.add("mariage".toUpperCase());
        liste.add("mot".toUpperCase());
        
        
        
        
        return liste;
    }

}
