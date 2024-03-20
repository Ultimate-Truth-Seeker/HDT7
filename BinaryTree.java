import java.util.ArrayList;
import java.util.List;

/**
 * Clase adaptada que implementa el árbol binario
 * @author Ultimate-Truth-Seeker, adaptado de Introduction to Java Structures
 */

// Clase para representar un árbol de búsqueda binario
class BinarySearchTree<E extends Comparable<E>> {
    private class Node {
        E data;
        Node left, right;

        Node(E data) {
            this.data = data;
            left = right = null;
        }
    }

    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(E data) {
        root = insertRecursive(root, data);
    }

    private Node insertRecursive(Node root, E data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data.compareTo(root.data) < 0)
            root.left = insertRecursive(root.left, data);
        else if (data.compareTo(root.data) > 0)
            root.right = insertRecursive(root.right, data);

        return root;
    }

    public E get(E data) {
        return getRecursive(root, data);
    }

    private E getRecursive(Node root, E data) {
        if (root == null || root.data.compareTo(data) == 0)
            return (root != null) ? root.data : null;

        if (data.compareTo(root.data) < 0)
            return getRecursive(root.left, data);
        else
            return getRecursive(root.right, data);
    }

    public List<E> inOrderTraversal() {
        List<E> result = new ArrayList<>();
        inOrderTraversalRecursive(root, result);
        return result;
    }

    private void inOrderTraversalRecursive(Node root, List<E> result) {
        if (root != null) {
            inOrderTraversalRecursive(root.left, result);
            result.add(root.data);
            inOrderTraversalRecursive(root.right, result);
        }
    }
}