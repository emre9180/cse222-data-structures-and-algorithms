/**
 *
 * @param <E> Comperable object that will be kept in Binary Heap Tree as Linked List Structure
 */
public class LLHeapTree<E extends Comparable<? super E>> extends BinaryTree<E> implements Comparable<E>
{
    private int height; // Height of the binary tree
    private int nodeNum; // Total node number in the most deep level

    /**
     * No parameter constructor
     */
    public LLHeapTree()
    {
        root = null;
        height = 0;
        nodeNum = 0;
    }

    private void shifting(Node<E> object)
    {
        if(object.parent!=null)
        {
            while(object.parent != null && object.data.compareTo(object.parent.data)<0)
            {
                E temp = object.parent.data;
                object.parent.data = object.data;
                object.data = temp;
                object = object.parent;
            }
        }
    }

    /**
     * Recursive function to find the node that the next item will be add
     * @param tree The current tree
     * @param currentLevel The current depth
     * @return Return the found node
     */
    private Node<E> findTargetRecursively(Node<E> tree, int currentLevel)
    {
        if(tree==null)
            return null;

        if(tree.left==null && (currentLevel==height || 0==nodeNum))
            return tree;

        else if(tree.right==null && currentLevel==height)
            return tree;

        Node<E> result = findTargetRecursively(tree.left,currentLevel+1);

        if(result==null)
            result = findTargetRecursively(tree.right,currentLevel+1);

        return result;
    }

    /**
     * Calls a private recursive function to find the node that the next object will be add
     * @return Return the found node. If there is no match, returns null
     */
    protected Node<E> findTarget()
    {
        return findTargetRecursively(root,1);
    }

    /**
     * Adds the object in the parameter to the binary heap tree.
     * @param object The object that will be add
     * @return Returns true if the adding process is done successfuly
     */
    public boolean add(E object)
    {
        if(root==null)
        {
            root = new Node<E>(object);
            root.parent = null;
            ++height;
            return true;
        }

        Node<E> targetNode = findTarget();
        if(targetNode.left==null)
        {
            targetNode.left = new Node<E>(object);
            targetNode.left.parent = targetNode;
            shifting(targetNode.left);
        }

        else
        {
            targetNode.right = new Node<E>(object);
            targetNode.right.parent = targetNode;
            shifting(targetNode.right);
        }

        ++nodeNum;
        if(nodeNum==Math.pow(2,height))
        {
            nodeNum=0;
            ++height;
        }
        return true;
    }

    /**
     * Remove function. It removes the root and makes shifting to set the binary heap tree
     */
    public boolean remove()
    {
        Node<E> iter = root;
        if(iter==null) return false;

        while(iter.left!=null || iter.right!=null)
        {
            if(iter==root)
            {
                if( (iter.data.compareTo(iter.left.data)<0) &&  (iter.right==null || iter.left.data.compareTo(iter.right.data)<0))
                {
                    iter.data = iter.left.data;
                    iter = iter.left;
                }

                else if( (iter.data.compareTo(iter.right.data)<0) &&  (iter.left==null || iter.right.data.compareTo(iter.left.data)<0))
                {
                    iter.data = iter.right.data;
                    iter = iter.right;
                }
            }

            else
            {
                if( (iter.right==null || iter.left.data.compareTo(iter.right.data)<0))
                {
                    iter.data = iter.left.data;
                    iter = iter.left;
                }

                else if( (iter.left==null || iter.right.data.compareTo(iter.left.data)<0))
                {
                    iter.data = iter.right.data;
                    iter = iter.right;
                }
            }

        }

        iter = iter.parent;
        if(iter!=null)
        {
            if( (iter.left==null || (iter.right!=null && iter.right.data.compareTo(iter.left.data)<0)))
                iter.right = null;
            else if(iter.left!=null)
                iter.left = null;
        }

        return true;
    }
}
