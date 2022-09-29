package tree;

public class BinarySearchTreeMain {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(50);
        bst.insert(40);
        bst.insert(60);
        bst.insert(35);
        bst.insert(42);
        bst.insert(55);
        bst.insert(65);
        bst.insert(34);
        bst.insert(36);
        // bst.inorder();
        // bst.preorder(bst.getRootNode());
        // bst.postorder(bst.getRootNode());
        // bst.inorder(bst.getRootNode());
        bst.levelorder();
    }
}
