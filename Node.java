
import java.io.FileWriter;
import java.io.IOException;


public class Node {
    protected ListeDePage first, end;
    protected String name;
    protected int height;
    protected Node leftChild, rightChild;
    protected Node parent;

    public Node(String name) {
        this.name = name;
        this.height = 1;
    }

    public int getHeight() {
        return height;
    }

    public String getName() {
        return name;
    }

    public Node getLeftChild() {
        return this.leftChild;
    }

    public Node getRightChild() {
        return this.rightChild;
    }

    public void setleftChild(Node node) {
        this.leftChild = node;
    }

    public void setFirst(ListeDePage liste) {
        this.first = liste;
    }

    public void setEnd(ListeDePage liste) {
        this.end = liste;
    }

    public void setRightChild(Node node) {
        this.rightChild = node;
    }

    public boolean existsRightChild() {
        return this.rightChild != null;
    }

    public boolean existsLeftChild() {
        return this.leftChild != null;
    }

    /* écrit la liste de pages associée à un Noeud dans un fichier*/
    public void writeInFile(FileWriter fos) throws IOException {

            System.out.print(this.name + " : ");
            fos.write(this.name + " : ");
            ListeDePage page = this.first;

            /*
             * isSuite permet de verifier si un mot se retrouve sur plusieurs pages
             * consécutives.
             * Alors on aura un affichage de type "1-5" signifiant "pages de 1 à 5"
             */
            boolean isSuite = false;

            while (page.next != null) {
                if (page.numeroPage == page.next.numeroPage - 1 && !isSuite) {
                    isSuite = true;
                    System.out.print(page.numeroPage + "-");
                    fos.write(page.numeroPage + "-");
                } else if (page.numeroPage != page.next.numeroPage - 1) {
                    System.out.print(page.numeroPage + ", ");
                    fos.write(page.numeroPage + ", ");
                    isSuite = false;
                }
                page = page.next;
            }
            System.out.println(page.numeroPage);
            fos.write(page.numeroPage + "\n");
       
    }

    /* insère une page dans la liste de pages du noeud */
    public void insertPage(int numpage) {

        ListeDePage page= new ListeDePage(numpage);
        if (this.first == null) {
            this.first = page;
            this.end = page;
            return;
        }
        if (this.end.numeroPage == page.numeroPage)
            return;
        this.end.next = page;
        this.end = page;
    }

}
