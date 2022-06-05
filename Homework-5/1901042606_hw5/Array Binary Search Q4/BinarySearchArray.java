/**
 * Array based Binary Search Tree class
 * @param <E> Comparable object that will be kept in Binary Search Tree Array
 */
public class BinarySearchArray<E extends Comparable<? super E>>
{
    private Object [] array; // Array that will keep the objects in the tree
    private int capacity; // Capacity of array
    private int height; // Height of tree

    /**
     * No-parameter Constructor, initiliaze the rray
     */
    public BinarySearchArray()
    {
        capacity = 0;
        height = 0;
        array = new Object[1];
    }

    /**
     * Recursive searching function to find an object.
     * @param target Target obj
     * @param index Current index that we are checking
     * @return Return the found object, if there is no match return null
     */
    private E recursiveFind(E target, int index, int capacity)
    {
        if(index>=capacity)
            return null;

        // If we find the object, return it
        if(array[index]!=null && target.compareTo((E) array[index])==0)
            return (E) array[index];

        // Right child position: 2p+2
        // Left child position:  2p+1
        if(array[index]!=null && target.compareTo((E) array[index])<0)
            return recursiveFind(target, 2*index+1, capacity);
        else
            return recursiveFind(target, 2*index+2, capacity);
    }

    /**
     * Searching function to find an object. Calls a recursive helper method to find.
     * @param target Target object
     * @return Return the found object
     */
    public E find(E target)
    {
        return recursiveFind(target,0,capacity);
    }

    /**
     * Reallocate the array and copy the content
     */
    private void reallocate()
    {
        int newCapacity = 0;
        for(int i=0;i<height;i++)
            newCapacity += Math.pow(2,i);

        Object [] newArray = new Object[newCapacity];

        for(int i=0;i<capacity;i++)
            newArray[i] = array[i];

        array = newArray;
        capacity = newCapacity;
    }

    /**
     * Recursive method to find correct node and to add the object
     * @param object The object that will be add
     * @param index Current index parameter in the function
     * @param currentLevel Current depth in the function
     */
    private void recursiveAdd(E object, int index, int currentLevel)
    {
        if(index>=capacity)
        {
            ++height;
            reallocate();
            array[index] = object;
            return ;
        }

        if(array[index]==null)
        {
            array[index] = object;
            return;
        }

        else if(object.compareTo((E) array[index])<0)
            recursiveAdd(object,2*index+1, currentLevel+1);

        else
            recursiveAdd(object,2*index+2, currentLevel+1);
    }

    /**
     * First, checks whether the object will be add is in the tree. If it is not, calls a recursive method to find correct node and to add the object
     * @param object The object that will be add
     * @return If the adding process is done successfuly, return true; else false
     */
    public boolean add(E object)
    {
        // If we are adding the root
        if(capacity==0)
        {
            array[0] = object;
            ++capacity;
            ++height;
        }
        // Check that the target object is already in the array
        E duplicate = find(object);

        // If the object is not in the array, add it to binary tree
        if(duplicate==null)
        {
            recursiveAdd(object,0,1);
            return true;
        }

        else
            return false;
    }

    /**
     * Recursive method to find target node and remove it
     * @param object Target node to delete
     * @param index Current index in the recursive function
     * @param level Current depth in the recursive function
     * @return If the removing process is done successfuly, returns true; else false
     */
    public E removeRecursively(E object, int index, int level)
    {
        // If we exceed the capacity, terminate the recursion
        if(index>=capacity)
            return null;

        // If we find the node, remove it. Then set its children to the correct indices
        if(array[index]!=null && object.compareTo((E) array[index])==0)
        {
            E returnObj = (E) array[index];
            do {
                if(index*2+1<capacity && array[index*2+1]!=null)
                {
                    array[index] = array[index*2+1];
                    index = index*2+1;
                }
                else if(index*2+2<capacity && array[index*2+2]!=null)
                {
                    array[index] = array[index*2+2];
                    index = index*2+2;
                }
                else
                {
                    array[index] = null;
                    break;
                }

                ++level;
            }while(level!=height-1);

            // Setting the last node that is in the most deep
            if(index*2+2<capacity && array[index*2+2]!=null)
            {
                array[index] = array[index*2+2];
                array[index*2+2] = null;
                index = index*2+2;
            }

            // Setting the last node that is in the most deep
            if(index*2+1<capacity && array[index*2+1]!=null)
            {
                array[index] = array[index*2+1];
                array[index*2+1] = null;
                index = index*2+1;
            }

            return returnObj;
        }

        else if(array[index]!=null && object.compareTo((E) array[index])<0)
            return removeRecursively(object,index*2+1,level+1);
        else
            return removeRecursively(object,index*2+2,level+1);
    }

    /**
     * Remove method that calls the recursive function to find target node and remove it
     * @param object
     * @return
     */
    public boolean remove(E object)
    {
        if(removeRecursively(object,0,1)!=null) return true;
        else return false;
    }

    /**
     * Removes target (if found) from tree and returns it; otherwise, returns null
     */
    public E delete(E object)
    {
        E deletedObject = removeRecursively(object,0,1);
        return deletedObject;
    }

    /**
     * Convert to string
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder(); toString(0, 1,sb); return sb.toString();
    }

    /** Converts a sub‐tree to a string. Performs a preorder traversal. @param node The local root @param depth The depth @param sb The StringBuilder to save the output
     */
    private void toString(int index, int currentLevel, StringBuilder sb) {

        if(index>=capacity)
            return;

        for (int i = 1; i < currentLevel; i++) { sb.append(" ");}
        if (array[index] == null) { sb.append("null\n");}

        else
        {
            sb.append(((E) array[index]).toString()); sb.append("\n");
            toString(index*2+1, currentLevel + 1, sb);
            toString(index*2+2, currentLevel + 1, sb);
        }
    }

    /**
     * Returns true if target is found in the tree
     * @param target Target object
     * @return Returns true if target is found in the tree
     */
    public boolean contains(E target)
    {
        if(find(target)!=null) return true;
        else return false;
    }
}



