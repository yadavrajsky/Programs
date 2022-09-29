package tree;

public class BinarySearchTree {
    private Node root;

    class Node {
        int key;
        Node left;
        Node right;

        Node(int key) {
            this.key = key;
            left = right = null;
        }
    }

    public void levelorder() {
        int h = height(root);
        for (int i = 1; i <= h; i++) {
            currentLevel(root, i);
        }
    }

    void currentLevel(Node node, int l) {
        if (node == null)
            return;
        else if (l == 1)
            System.out.println(node.key);
        else {
            currentLevel(node.left, l - 1);
            currentLevel(node.right, l - 1);
        }
    }

    int height(Node node) {
        if (node == null)
            return 0;
        int lh = height(node.left);
        int rh = height(node.right);
        if (lh > rh)
            return lh + 1;
        else
            return rh + 1;
    }

    public void preorder(Node temp) {
        if (temp == null)
            return;
        System.out.println(temp.key);
        preorder(temp.left);
        preorder(temp.right);
    }

    public void inorder(Node temp) {
        if (temp == null)
            return;
        inorder(temp.left);
        System.out.println(temp.key);
        inorder(temp.right);
    }

    public void postorder(Node temp) {
        if (temp == null)
            return;
        postorder(temp.left);
        postorder(temp.right);
        System.out.println(temp.key);
    }

    public void insert(int key) {
        Node node = new Node(key);
        if (root == null) {
            root = node;
            return;
        }
        Node temp = root;
        Node prev = null;
        while (temp != null) {
            prev = temp;
            if (temp.key > key) {
                temp = temp.left;
            } else if (temp.key < key) {
                temp = temp.right;
            }
        }
        if (prev.key < key) {
            prev.right = node;
        } else {
            prev.left = node;
        }
    }

    public void inorder() {
        Stack st = new Stack();
        Node temp = root;
        while (temp != null || !st.isEmpty()) {
            if (temp != null) {
                st.push(temp);
                temp = temp.left;
            } else {
                temp = st.pop();
                System.out.println(temp.key);
                temp = temp.right;
            }
        }
    }

    public Node getRootNode() {
        return root;
    }
}
