class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
public class BinarySearchTree {
    public static Node insert(Node root, int data) {

    if (root == null) {
        return new Node(data);
    }
    
    if (data < root.data) {
        root.left = insert(root.left, data);
    } 

    else if (data > root.data) {
        root.right = insert(root.right, data);
    }
    
    return root;
}
}
