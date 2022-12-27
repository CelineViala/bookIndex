

public class AVL extends AbstractTree{
   
    
    public AVL(){
        super();
    }
    
    @Override
    public int getHeightTree(Node racine) {
        return racine.getHeight();
    }
    
    public int height(Node courant) {
        return (courant == null) ? 0 : courant.getHeight();
    }
    
    public void updateHeight(Node node) {
        int leftChildHeight = height(node.getLeftChild());
        int rightChildHeight = height(node.getRightChild());
        node.height = Math.max(leftChildHeight, rightChildHeight) + 1;
        

    }
    public Node rotationG(Node node) 
    {
        Node rightChild = node.getRightChild();
        node.setRightChild(rightChild.getLeftChild());
        rightChild.setleftChild(node);
        updateHeight(node);
        updateHeight(rightChild);
        return rightChild;
        
    }

    public Node rotationD(Node node)
    {
        
        Node leftChild=node.getLeftChild();
        node.setleftChild(leftChild.getRightChild());
        leftChild.setRightChild(node);
        updateHeight(node);
        updateHeight(leftChild);
        return leftChild;
    }

    public Node equilibrer(Node node) {

        if (height(node.getLeftChild()) - height(node.getRightChild()) == 2) {
            if (height(node.getLeftChild().getLeftChild()) < height(node.getLeftChild().getRightChild()))
                node.setleftChild(rotationG(node.getLeftChild()));
            node=rotationD(node);
        } 
        if (height(node.getLeftChild()) - height(node.getRightChild()) == -2) {
            if (height(node.getRightChild().getRightChild()) < height(node.getRightChild().getLeftChild()))
                node.setRightChild(rotationD(node.getRightChild())); 
            node= rotationG(node);
        }
        return node;
}
 
    public Node insert(Node node,String key, int numPage) {  
        if(node==null)
        {
            node=new Node(key);
            node.insertPage(numPage);
            return node;
        }
        if (node.getName().compareTo(key) > 0)
        {
            node.setleftChild(insert(node.getLeftChild(),key,numPage));
        }else if (node.getName().compareTo(key) < 0) {
            node.setRightChild(insert(node.getRightChild(), key, numPage));          
        } else{
            node.insertPage(numPage);
            return node;
        }
        updateHeight(node);
        node=equilibrer(node);
        return node;
    }    
}
