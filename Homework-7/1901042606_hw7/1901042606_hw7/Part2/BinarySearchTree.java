import java.io.*;

/** A class to represent a binary search tree.
 *  @author Koffman and Wolfgang
 */

public class BinarySearchTree < E
        extends Comparable < E >>
        extends BinaryTree < E >
        implements SearchTree < E > {
    // Data Fields
    /** Return value from the public add method. */
    protected boolean addReturn;

    /** Return value from the public delete method. */
    protected E deleteReturn;

    /**
     * Height of the tree
     */
    protected int height;

	/**
	* No parameter constructor. Makes height=5, root=null
	*/
    public BinarySearchTree()
    {
        this.root = null;
        this.height = 0;
    }
	
	/**
	* NEW METHOD FOR THIS HOMEWORK! Crates a new BST with a new root and finds it height
	@param root Creates new BST with this root
	*/
    public BinarySearchTree(Node<E> root)
    {
        this.root = root;
        this.height = findHeight(root);
    }

    //Methods
    /** Starter method find.
     pre: The target object must implement
     the Comparable interface.
     @param target The Comparable object being sought
     @return The object, if found, otherwise null
     */
    public E find(E target) {
        return find(root, target);
    }

    /** Recursive find method.
     @param localRoot The local subtree s root
     @param target The object being sought
     @return The object, if found, otherwise null
     */
    private E find(Node < E > localRoot, E target) {
        if (localRoot == null)
            return null;

        // Compare the target with the data field at the root.
        int compResult = target.compareTo(localRoot.data);
        if (compResult == 0)
            return localRoot.data;
        else if (compResult < 0)
            return find(localRoot.left, target);
        else
            return find(localRoot.right, target);
    }

    /** Starter method add.
     pre: The object to insert must implement the
     Comparable interface.
     @param item The object being inserted
     @return true if the object is inserted, false
     if the object already exists in the tree
     */
    public boolean add(E item)
    {
        root = add(root, item,true);
        return addReturn;
    }

    /** Recursive add method.
     post: The data field addReturn is set true if the item is added to
     the tree, false if the item is already in the tree.
     @param localRoot The local root of the subtree
     @param item The object to be inserted
     @return The new local root that now contains the
     inserted item
     */
    private Node < E > add(Node < E > localRoot, E item, boolean height) {
        if (localRoot == null) {
            // item is not in the tree   insert it.
            addReturn = true;
            if(height) ++this.height;
            return new Node < E > (item);
        }
        else if (item.compareTo(localRoot.data) == 0) {
            // item is equal to localRoot.data
            addReturn = false;
            return localRoot;
        }
        else if (item.compareTo(localRoot.data) < 0) {
            // item is less than localRoot.data
            if(localRoot.right==null) localRoot.left = add(localRoot.left, item,true);
            else add(localRoot.left, item,false);
            return localRoot;
        }
        else {
            // item is greater than localRoot.data
            if(localRoot.left==null) localRoot.right = add(localRoot.right, item,true);
            else add(localRoot.right, item,false);
            return localRoot;
        }
    }

    /** Starter method delete.
     post: The object is not in the tree.
     @param target The object to be deleted
     @return The object deleted from the tree
     or null if the object was not in the tree
     @throws ClassCastException if target does not implement
     Comparable
     */
    public E delete(E target) {
        root = delete(root, target);
        return deleteReturn;
    }

    /** Recursive delete method.
     post: The item is not in the tree;
     deleteReturn is equal to the deleted item
     as it was stored in the tree or null
     if the item was not found.
     @param localRoot The root of the current subtree
     @param item The item to be deleted
     @return The modified local root that does not contain
     the item
     */
    private Node < E > delete(Node < E > localRoot, E item) {
        if (localRoot == null) {
            // item is not in the tree.
            deleteReturn = null;
            return localRoot;
        }

        // Search for item to delete.
        int compResult = item.compareTo(localRoot.data);
        if (compResult < 0) {
            // item is smaller than localRoot.data.
            localRoot.left = delete(localRoot.left, item);
            return localRoot;
        }
        else if (compResult > 0) {
            // item is larger than localRoot.data.
            localRoot.right = delete(localRoot.right, item);
            return localRoot;
        }
        else {
            // item is at local root.
            deleteReturn = localRoot.data;
            if (localRoot.left == null) {
                // If there is no left child, return right child
                // which can also be null.
                return localRoot.right;
            }
            else if (localRoot.right == null) {
                // If there is no right child, return left child.
                return localRoot.left;
            }
            else {
                // Node being deleted has 2 children, replace the data
                // with inorder predecessor.
                if (localRoot.left.right == null) {
                    // The left child has no right child.
                    // Replace the data with the data in the
                    // left child.
                    localRoot.data = localRoot.left.data;
                    // Replace the left child with its left child.
                    localRoot.left = localRoot.left.left;
                    return localRoot;
                }
                else {
                    // Search for the inorder predecessor (ip) and
                    // replace deleted node s data with ip.
                    localRoot.data = findLargestChild(localRoot.left);
                    return localRoot;
                }
            }
        }
    }

    /**** BEGIN EXERCISE ****/
    /** Removes target from tree.
     @param target Item to be removed
     @return true if the object was in the tree, false otherwise
     @post target is not in the tree
     @throws ClassCastException if target is not Comparable
     */
    public boolean remove(E target) {
        return delete(target) != null;
    }

    /** Determine if an item is in the tree
     @param target Item being sought in tree
     @return true If the item is in the tree, false otherwise
     @throws ClassCastException if target is not Comparable
     */
    public boolean contains(E target) {
        return find(target) != null;
    }

    /**** END EXERCISE ****/

    /** Find the node that is the
     inorder predecessor and replace it
     with its left child (if any).
     post: The inorder predecessor is removed from the tree.
     @param parent The parent of possible inorder
     predecessor (ip)
     @return The data in the ip
     */
    private E findLargestChild(Node < E > parent) {
        // If the right child has no right child, it is
        // the inorder predecessor.
        if (parent.right.right == null) {
            E returnValue = parent.right.data;
            parent.right = parent.right.left;
            return returnValue;
        }
        else {
            return findLargestChild(parent.right);
        }
    }

    /** Method to perform a right rotation.
     pre:  root is the root of a binary search tree.
     post: root.right is the root of a binary search tree,
     root.right.right is raised one level,
     root.right.left does not change levels,
     root.left is lowered one level,
     the new root is returned.
     @param root The root of the binary tree to be rotated
     @return The new root of the rotated tree
     */
    protected Node < E > rotateRight(Node < E > root) {
        Node < E > temp = root.left;
        root.left = temp.right;
        temp.right = root;
        return temp;
    }

    /** Method to perform a left rotation (rotateLeft).
     /**** BEGIN EXERCISE ****/
    /** rotateLeft
     pre:  localRoot is the root of a binary search tree
     post: localRoot.right is the root of a binary search tree
     localRoot.right.right is raised one level
     localRoot.right.left does not change levels
     localRoot.left is lowered one level
     the new localRoot is returned.
     @param localRoot The root of the binary tree to be rotated
     @return the new root of the rotated tree
     */
    protected Node < E > rotateLeft(Node < E > localRoot) {
        Node < E > temp = localRoot.right;
        localRoot.right = temp.left;
        temp.left = localRoot;
        return temp;
    }


    private int findMax(int a, int b){
        if(a >= b)
            return a;
        else
            return b;
    }

    /**
     * NEW METHOD FOR THIS HOMEWORK! Finds the height of the root
     * @param root Target root
     * @return Returns the height
     */
    public int findHeight(Node<E> root) {
        // Base case:
        if (root == null)
            return 0;

        return findMax(findHeight(root.left), findHeight(root.right)) + 1;
    }
	
	/** NEW METHOD FOR THIS HOMEWORK! Return the left sub-tree
     @return the left sub-tree or
     null if either the root or the
     left subtree is null.
     */
    public BinarySearchTree < E > getLeftSubtree() {
        if (root != null && root.left != null) {
            return new BinarySearchTree < E > (root.left);
        }
        else {
            return null;
        }
    }

    /** NEW METHOD FOR THIS HOMEWORK! Return the right sub-tree
     @return the right sub-tree or
     null if either the root or the
     right subtree is null.
     */
    public BinarySearchTree<E> getRightSubtree() {
        if (root != null && root.right != null) {
            return new BinarySearchTree<E>(root.right);
        } else {
            return null;
        }
    }


    /**
     * NEW METHOD FOR THIS HOMEWORK! Takes a binary search tree (BST) as a parameter and returns the AVL tree obtained by rearranging the BST. The method should convert the BST into an AVL tree by using rotation operations.
     * @param tree Input tree
     * @return Returns the AVL tree
     */
    public AVLTree rotation(BinarySearchTree tree)
    {
        while(true)
        {
            boolean leftBalance = true;
            boolean rightBalance = true;

            int leftHeight;
            int rightHeight;

            if(tree.getRightSubtree()==null)
                rightHeight=0;
            else
                rightHeight = tree.getRightSubtree().height;


            if(tree.getLeftSubtree()==null)
                leftHeight=0;
            else
                leftHeight = tree.getLeftSubtree().height;

            if(rightHeight-leftHeight>1)
                rightBalance = false;

            else if(rightHeight-leftHeight<-1)
                leftBalance = false;


            if(rightBalance==false)
            {
                if(tree.getRightSubtree()!=null)
                {
                    int childLeftHeight;
                    int childRightHeight;
                    boolean childRightBalance = true;
                    boolean childLeftBalance = true;

                    if(tree.getRightSubtree().getRightSubtree()==null)
                        childRightHeight=0;
                    else
                    {
                        if(tree.getRightSubtree()!=null)
                            childRightHeight = tree.getRightSubtree().getRightSubtree().height;
                        else childRightHeight = 0;
                    }


                    if(tree.getRightSubtree().getLeftSubtree()==null)
                        childLeftHeight=0;
                    else
                    {
                        if(tree.getRightSubtree()!=null)
                            childLeftHeight = tree.getRightSubtree().getLeftSubtree().height;
                        else childLeftHeight = 0;
                    }

                    if(childRightHeight-childLeftHeight>=1)
                        childRightBalance = false;

                    else if(childRightHeight-childLeftHeight<=-1)
                        childLeftBalance = false;


                    //Right-Left Case
                    if(childLeftBalance==false)
                    {

                            tree.root.right = tree.getRightSubtree().rotateRight(tree.getRightSubtree().root);
                    }

                    tree.root = tree.rotateLeft(tree.root);
                }
            }



            else if(leftBalance==false)
            {
                if(tree.getLeftSubtree()!=null)
                {
                    int childLeftHeight;
                    int childRightHeight;
                    boolean childRightBalance = true;
                    boolean childLeftBalance = true;

                    if(tree.getLeftSubtree().getRightSubtree()==null)
                        childRightHeight=0;
                    else
                    {
                        if(tree.getLeftSubtree()!=null)
                            childRightHeight = tree.getLeftSubtree().getRightSubtree().height;
                        else childRightHeight = 0;
                    }


                    if(tree.getLeftSubtree().getLeftSubtree()==null)
                        childLeftHeight=0;
                    else
                    {
                        if(tree.getLeftSubtree()!=null)
                            childLeftHeight = tree.getLeftSubtree().getLeftSubtree().height;
                        else childLeftHeight = 0;
                    }

                    if(childRightHeight-childLeftHeight>=1)
                        childRightBalance = false;

                    else if(childRightHeight-childLeftHeight<=-1)
                        childLeftBalance = false;


                    if(childRightBalance==false)
                    {

                            tree.root.left = tree.rotateLeft(tree.getLeftSubtree().root);
                    }
                    tree.root = tree.rotateRight(tree.root);
                }
            }

            else
                break;


        }
        return new AVLTree(tree);
    }

}
