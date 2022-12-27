import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public abstract class AbstractTree {
    protected Node root;

    public AbstractTree() {
        this.root = null;
    }
    public abstract int getHeightTree(Node racine);
    public abstract Node insert(Node node, String key, int numPage);
    
    public void infixe(Node n,FileWriter fos) throws IOException {
        while (n != null) {
            infixe(n.getLeftChild(),fos);
            n.writeInFile(fos);
            n = n.getRightChild();
        }
    }
    public Node search(String name) {

        Node cur = null;
        cur = root;
        while (cur != null) {
            String v = cur.getName();
            if (name.equals(v)) {
                return cur;
            } else if (name.compareTo(v) > 0) {
                cur = cur.getRightChild();
            } else if (name.compareTo(v) < 0) {
                cur = cur.getLeftChild();
            }
        }
        return null;
    }

    public void largeur(Node a) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(a);
        while (queue.size() != 0) {
            a = queue.remove();
            System.out.println(a.name + ' ');
            if (a.getLeftChild() != null) {
                System.out.println(" a un fils g");
                queue.add(a.getLeftChild());
            }
            if (a.getRightChild() != null) {
                System.out.println("a un fils d");
                queue.add(a.getRightChild());
            }
        }
    }
}
