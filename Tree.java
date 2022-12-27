
public class Tree extends AbstractTree{
    
    
    public Tree(){
        super();
    }
    
    @Override
    public int getHeightTree(Node cur) {
        if (cur == null) {
            return 0;
        }
        int gauche = getHeightTree(cur.getLeftChild());
        int droit =getHeightTree(cur.getRightChild());
        return ((gauche >= droit) ? gauche : droit) + 1;
    }
   

    @Override
    public Node insert(Node treeRoot, String key, int numPage) {
        if (treeRoot== null) {
            this.root = new Node(key);
            this.root.insertPage(numPage);
            return this.root;
        }
        Node cur = treeRoot;
        while (cur != null) {
            if (key.compareTo(cur.getName()) < 0) {

                if (!cur.existsLeftChild()) {
                    cur.setleftChild(new Node(key));
                    cur.getLeftChild().insertPage(numPage);
                    cur = null;
                } else {
                    cur = cur.leftChild;
                }
            } else if (key.compareTo(cur.getName()) > 0) {
                if (!cur.existsRightChild()) {
                    cur.setRightChild(new Node(key));
                    cur.getRightChild().insertPage(numPage);
                    cur = null;
                } else {
                    cur = cur.rightChild;
                }
            } else {
                cur.insertPage(numPage);
                cur = null;
            }
        }
        return this.root;
    }  
}
