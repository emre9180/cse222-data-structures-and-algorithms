import java.io.Serializable;
import java.util.Scanner;

/**
 * The Binary Tree class in the TextBook.
 * Since we were asked to extend this class in the assignment, some of the functions were taken directly from the book. However, any of them is used except the Node Class.
 * @param <E> Comperable object
 */
public class BinaryTree<E extends Comparable<? super E>>  implements Comparable<E>{

    /**
     * Node class that will be represent a single node. 
     */
    protected static class Node<E extends Comparable<? super E>>  implements Comparable<E>
    {   
        /**
         * Data that be kept in Node
         */
        protected E data;

        /**
         * Left child of the node
         */
        protected Node<E> left;

        /**
         * Right child of the node
         */
        protected Node<E> right;

        /**
         * Parent of the node
         */
        protected Node<E> parent;

        /**
         * Constructor with a data
         * @param data The data that will be stored in the node
         */
        public Node(E data)
        {
            this.data = data;
            left = null;
            right = null;
            parent = null;
        }

        /**
         * No paramater constructor. Initiliaze the data fields as null
         */
        public Node()
        {
            this.data = null;
            this.left = null;
            this.right = null;
            parent = null;
        }

        /**
         * Implements comparable interface. Compare the E objects
         */
        public int compareTo(E obj2)
        {
            return obj2.compareTo(data);
        }

        /**
         * Convert data to string
         */
        public String toString()
        {
            return data.toString();
        }
    }

    /**
     * Root node of the tree
     */
    protected Node<E> root;

    /** This constructor comes from Binary Tree Class implementation in the text book.
     * Constructs a new binary tree with data in its root leftTree as its left subtree and rightTree as its right subtree.
     */
    public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree)
    {
        root = new Node<E>(data);

        if (leftTree != null)
            root.left = leftTree.root;

        else
            root.left = null;

        if (rightTree != null)
            root.right = rightTree.root;

        else
            root.right = null;
    }

    /**
     * Constructor with a root node. 
     * @param root
     */
    protected BinaryTree(Node<E> root)
    {
        this.root = root;
    }

    /**
     * No parameter constructor. Initiliaze the root as null
     */
    protected BinaryTree()
    {
        this.root = null;
    }


    /** Return the left subtree.
     * @return The left subtree or null if either the root or the left subtree is null
     */
    public BinaryTree<E> getLeftSubtree()
    {
        if (root != null && root.left != null)
            return new BinaryTree<E>(root.left);
        else
            return null;
    }

    /** Return the right subtree.
     * @return The right subtree or null if either the root or the right subtree is null
     */
    public BinaryTree<E> getRightSubtree()
    {
        if (root != null && root.right != null)
            return new BinaryTree<E>(root.right);
        else
            return null;
    }


    /** Determine whether this tree is a leaf.
     * @return true if the root has no children
     */
    public boolean isLeaf()
    {
        return (root.left == null && root.right == null);
    }

    /**
     * Convert tree to string 
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder(); toString(root, 1, sb); return sb.toString();
    }

    /** Converts a sub‐tree to a string. Performs a preorder traversal. @param node The local root @param depth The depth @param sb The StringBuilder to save the output
     */
    private void toString(Node<E> node, int depth, StringBuilder sb) {
        for (int i = 1; i < depth; i++) { sb.append(" ");
        }
        if (node == null) { sb.append("null\n");
        } else {
            sb.append(node.toString()); sb.append("\n");
            toString(node.left, depth + 1, sb); toString(node.right, depth + 1, sb);
        }
    }

    /**
     * Implementing the comperable interface. ComparesE objects
     */
    public int compareTo(E obj2)
    {
        return 1;
    }

    /** Method to read a binary tree. pre: The input consists of a preorder traversal of the binary tree. The line "null" indicates a null tree.
     @param scan the Scanner attached to the input file. @return The binary tree
     */
    public static BinaryTree<String> readBinaryTree(Scanner scan) // Read a line and trim leading and trailing spaces.
    {
        String data = scan.nextLine().trim();
        if (data.equals("null"))
                return null;
        else
        {
            BinaryTree<String> leftTree = readBinaryTree(scan);
            BinaryTree<String> rightTree = readBinaryTree(scan);
            return new BinaryTree<>(data, leftTree, rightTree);
        }
    }

}
