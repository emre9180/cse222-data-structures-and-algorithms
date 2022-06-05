/**
 * Node based Binary Search Tree class
 * @param <E> Comparable object that will be kept in Binary Search Tree Array
 */
public class BinarySearch<E extends Comparable<E>> extends BinaryTree {
    protected E deleteReturn;

    private boolean addRecursively(Node<E> head, E obj) {
        if (head.compareTo(obj) == 0)
            return false;

        else if (head.compareTo(obj) < 0) {
            if (head.left == null) {
                head.left = new Node<>(obj);
                return true;
            } else
                return addRecursively(head.left, obj);
        } else {
            if (head.right == null) {
                head.right = new Node<>(obj);
                return true;
            } else
                return addRecursively(head.right, obj);
        }
    }

    /**
     * Returns the root of the tree
     * @return Returns the root of the tree
     */
    public E getRoot()
    {
        if(root==null)
            return null;
        else
            return (E) root.data;
    }

    /**
     * Set function for root of the tree
     * @param data Data that will be set
     */
    public void setRoot(E data)
    {
        root.data= data;
    }

    /**
     * Set function for left subtree
     * @param data Data for setting
     */
    public void setLeftTree(E data)
    {
        root.left = new Node<>(data);
    }

    /**
     * Set function for right subtree
     * @param data Data for setting
     */
    public void setRightTree(E data)
    {
        root.right = new Node(data);
    }



    /**
     * Inserts item where it belongs in the tree.
     *
     * @param obj Object that will be added
     * @return Returns true if item is inserted; false if it isn’t (already in tree)
     */
    public boolean add(E obj) {
        if (root == null) {
            root = new Node<>(obj);
            return true;
        }

        return addRecursively(root, obj);
    }


    /**
     * Make a search for the target.
     *
     * @param target Target object.
     * @return Returns true if target is found in the tree
     */
    public boolean contains(E target) {
        E findObject = find(target);
        if (findObject == null)
            return false;
        else
            return true;
    }

    /**
     * Recursive searching function to find an object.
     * @param target Target obj
     * @param node Node
     * @return Return the found object, if there is no match return null
     */
    private E findRecursively(Node<E> node, E target) {
        if (node == null)
            return null;

        if (node.data.compareTo(target) == 0)
            return node.data;

        else if (node.data.compareTo(target) < 0)
            return findRecursively(node.left, target);

        else
            return findRecursively(node.right, target);
    }

    /**
     * Make a search for the target.
     *
     * @param target Target object
     * @return Returns a reference to the data in the node that is equal to target. If no such node is found, returns null
     */
    public E find(E target) {
        return (E) findRecursively(root, target);
    }




    /** Find the node that is the
     inorder predecessor and replace it
     with its left child (if any).
     post: The inorder predecessor is removed from the tree.
     @param parent The parent of possible inorder
     predecessor (ip)
     @return The data in the ip
     */
    private E findLargestChild(Node<E> parent) {
        // If the right child has no right child, it is
        // the inorder predecessor.
        if (parent.right.right == null) {
            E returnValue = parent.right.data;
            parent.right = parent.right.left;
            return returnValue;
        } else {
            return findLargestChild(parent.right);
        }
    }








    public E delete(E target) {
        root = delete(root, target);
        return deleteReturn;
    }

    private Node<E> delete(Node<E> localRoot, E item) {
        if (localRoot == null)
        {
            deleteReturn = null;
            return localRoot;
        }

        int compResult = item.compareTo(localRoot.data);
        if (compResult < 0)
        {
            localRoot.left = delete(localRoot.left, item);
            return localRoot;
        }
        else if (compResult > 0)
        {

            localRoot.right = delete(localRoot.right, item);
            return localRoot;
        }
        else
        {
            deleteReturn = localRoot.data;

            if (localRoot.left == null)
            {
                return localRoot.right;
            }

            else if (localRoot.right == null)
            {
                return localRoot.left;
            }

            else
            {
                if (localRoot.left.right == null)
                {

                    localRoot.data = localRoot.left.data;

                    localRoot.left = localRoot.left.left;
                    return localRoot;
                }

                else
                {
                    localRoot.data = findLargestChild(localRoot.left);
                    return localRoot;
                }
            }
        }
    }

    /** Return the left subtree.
     * @return The left subtree or null if either the root or the left subtree is null
     */
    public BinarySearch<E> getLeftSubtree()
    {
        if (root != null && root.left != null)
            return new BinarySearch<E>(root.left);
        else
            return null;
    }

    /** Return the right subtree.
     * @return The right subtree or null if either the root or the right subtree is null
     */
    public BinarySearch<E> getRightSubtree()
    {
        if (root != null && root.right != null)
            return new BinarySearch<E>(root.right);
        else
            return null;
    }


    /**
     * Constructor with a root node.
     * @param root
     */
    protected BinarySearch(Node<E> root)
    {
        this.root = root;
    }

    protected  BinarySearch()
    {}

}


