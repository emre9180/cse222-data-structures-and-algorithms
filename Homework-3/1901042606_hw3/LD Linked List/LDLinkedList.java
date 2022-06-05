import java.util.AbstractList;
import java.util.List;
import java.util.ListIterator;

/**
 * Lazy Deletion LinkedList data structure class
 * @param <E> The type of data that keep by LinkedList
 */
public class LDLinkedList<E> extends AbstractList<E> implements List<E>
{
    /* Head of the LinkedList */
    private Node<E> head;

    /* End of the LinkedList */
    private Node<E> tail;

    /* Deleted nodes */
    private Node<E> headDeleted;

    /* The size of the list. */
    int size;

    /* The size of the deleted list */
    int deletedSize;


    /**
     * Nodes class of the linked list, it is marked as static since it does not affect the outer class LinkedList
     * @param <E> Type of data keep by Node
     */
    private static class Node<E>
    {
        private E data; /* Data */
        private Node<E> next; /* Reference to the next Node */
        private Node<E> previous; /* Reference to the next Node */

        /**
         * Constructor with type E data parameter
         * @param data Type E data that will be kept by Node
         */
        private Node(E data)
        {
            this.data = data;
            this.next = null;
            this.previous = null;
        }

        /**
         * No parameter constructor
         */
        public Node(){}
    }

    /**
     * Iterator class
     */
    private class LDIterator implements ListIterator<E>
    {
        /**
         * Next node after the iterator
         */
        private Node<E> next;

        /**
         * Iterator position
         */
        private int index;

        /**
         * Last returned node by using next() or previous() methods
         */
        private Node<E> lastReturned;

        public LDIterator()
        {
            lastReturned = null;
            next = head;
            index = -1;
        }

        public LDIterator(int index)
        {
            lastReturned = null;
            this.index = -1;

            if(index<0 || index>size)
            {
                System.out.println("Out of index!");
            }

            else if(index==0)
            {
                next = head;
            }

            else
            {
                lastReturned = null;
                next = head;
                for(int i=0;i<index;++i)
                    next();
            }
        }
        /**
         * Checks whether there is a node after the iterator
         * @return If there is a node after the iterator, returns true
         */
        public boolean hasNext()
        {
            if(next==null)
                return false;
            else
                return true;
        }

        /**
         * Checks whether there is a node before the iterator
         * @return If there is a node before the iterator, returns true
         */
        public boolean hasPrevious()
        {
            if(next.previous==null || (next==null && size!=0) )
                return false;
            else
                return true;
        }

        /**
         * Move forward the iterator
         * @return Return the object of the next node
         */
        public E next()
        {
            if(hasNext())
            {
                lastReturned = next;
                next = next.next;
                ++index;
                return lastReturned.data;
            }

            else
            {
                System.out.printf("No such element!\n");
                return null;
            }
        }

        /**
         * Move backward the iterator
         * @return Return the object of the previous node
         */
        public E previous()
        {
            if(hasPrevious())
            {
                lastReturned = next.previous;
                next = lastReturned;
                --index;
                return lastReturned.data;
            }

            else
            {
                System.out.printf("No such element!\n");
                return null;
            }
        }

        /**
         * Returns the index of the node that will be returned when next() used
         * @return Next index after the next() using
         */
        public int nextIndex()
        {
            if(index+1==size)
                return size;
            else
                return size+1;
        }

        /**
         * Returns the index of the node that will be returned when previous() used
         * @return Previous index after the previous() using
         */
        public int previousIndex()
        {
            if(index-1==0)
                return 0;
            else
                return index-1;
        }


        /**
         * Update the data in the node that will be last returned
         * @param changeObj New data
         */
        public void set(E changeObj)
        {
            lastReturned.data = changeObj;
        }

        public void remove() {

            if (lastReturned == null) {
                System.out.printf("IllegalStateException!\n");
                return;
            }

            if (index < 1) {
                head = lastReturned.next;
                lastReturned.next = null;
                lastReturned.previous = null;
                addDeletedList(lastReturned);
                --size;
            }

            else if (index+1 == size)
            {
                tail = lastReturned.previous;
                lastReturned.next = null;
                lastReturned.previous = null;
                addDeletedList(lastReturned);
                --size;
            }

            else
            {
                lastReturned.previous.next = lastReturned.next;
                lastReturned.next.previous = lastReturned.previous;
                lastReturned.next = null;
                lastReturned.previous = null;
                addDeletedList(lastReturned);
                --size;
            }


        }

        /**
         *
         * @param object
         */
        public void add(E object)
        {
            if(lastReturned==null)
            {
                System.out.printf("IllegalStateException!\n");
                return;
            }

            Node<E> deletedListTarget = searchDeletedList(object);
            if(deletedListTarget!=null)
            {
                next.previous.next = deletedListTarget;
                deletedListTarget.next = next;
                ++size;
                removeDeletedList(deletedListTarget);
            }

            else
            {
                Node<E> newObject = new Node<>(object);
                next.previous.next = newObject;
                newObject.next = next;
                ++size;
            }


        }
    }


    /**
     * Search the second list that keeps deleted nodes from the first linked list.
     * @param object Searching node
     * @return Return the node. If searching is failed, return null
     */
    public Node<E> searchDeletedList(E object)
    {
        Node<E> temp = headDeleted;
        while(temp!=null)
        {
            if(object.equals(temp.data))
            {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    /**
     * Adds a node to second list that keeps deleted nodes from the first linked list
     * @param target The node will be added
     */
    public void addDeletedList(Node<E> target)
    {
        if(headDeleted==null)
        {
            headDeleted=target;
            headDeleted.next = null;
        }

        else
        {
            Node<E> iterationNode = headDeleted;
            while(iterationNode.next!=null)
                iterationNode = iterationNode.next;

            iterationNode.next = target;
        }
    }

    /**
     * Removes a node from the second list that keeps deleted nodes from the first linked list
     * @param target The node will be removed
     */
    private void removeDeletedList(Node <E> target)
    {
        Node<E> iterationNode = headDeleted;
        for(int i=0;i<deletedSize;++i)
        {
            if(iterationNode==null)
                break;

            if(iterationNode.next==target)
            {
                iterationNode.next = target.next;
                --deletedSize;
            }

            iterationNode = iterationNode.next;
        }
    }


    /**
     * Go to index and return the node
     * @param index Target index
     * @return Return the node
     */
    private Node<E> getNode(int index)
    {
        Node<E> iterationNode = head;
        for(int i=0;i<size;++i)
        {
            if(iterationNode==null)
                break;

            if(i==index)
                return iterationNode;
        }
        return null;
    }

    public int size(){return size;}

    /**
     * Returns the node at the index'th element in the LinkedList
     * @param index Indicates the order of the element that will be returned
     * @return Return the node at the 'index' position. If it does not exist, return null pointer
     */
    public E get(int index)
    {
        if(index<0 || index>size)
            return null;

        Node<E> iterationNode = head;
        for(int i=0;i<size;i++)
        {
            if(iterationNode==null) break;

            if(i==index)
                return iterationNode.data;

            iterationNode = iterationNode.next;
        }
        return null;
    }

    /**
     * Returns the head of the LinkedList
     * @return Return the head
     */
    public E getFirst()
    {return head.data;}

    /**
     * Returns the end of the LinkedList
     * @return Return the tail
     */
    public E getLast()
    {return tail.data;}



    /**
     * Adds a new item to LinkedList to the given position
     * @param index Target position
     * @param object Object that will be added
     * @return Return true if the adding process is successful
     */
    public void add(int index, E object)
    {
        /* If the target position is invalid */
        if(index<0 || index>size)
        {
            System.out.println("Out of index! Adding process cannot be done!");
            return;
        }

        /* Adding the first node */
        if(head==null) {
            Node<E> newNode = new Node<>(object); /* Create the Node to add the LinkedList */
            newNode.next = head;
            newNode.previous = null;
            head = newNode;
            tail = newNode;
            size++;
            return;
        }

        Node<E> target = getNode(index-1); /* Create the Node to add the LinkedList */
        if(target==null)
            return;

        Node<E> deletedListTarget = searchDeletedList(object);
        if(deletedListTarget!=null)
        {
            tail.next = deletedListTarget;
            deletedListTarget.previous = tail;
            tail = deletedListTarget;
            ++size;
            removeDeletedList(deletedListTarget);
            return;
        }


        /* Adding the node to the end of the LinkedList */
        if(index==size) {
            Node<E> newNode = new Node<>(object); /* Create the Node to add the LinkedList */
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
            ++size;
            return;
        }

        /* Adding the node between 2 nodes */
        else
        {
            Node<E> newNode = new Node<>(object);
            Node<E> temp = target.next;
            newNode.previous = target;
            target.next  = newNode;
            newNode.next = temp;
            temp.previous = newNode;

            ++size;
            return;
        }
    }

    /**
     * Add an object to end of the linked list
     * @param object Object will be added
     */
    public boolean add(E object)
    {    add(size,object);
        return true;
    }

    /**
     * Removes an object from the linked list at the index'th order
     * @param index target index
     * @return If the removing process is successful, return true
     */
    public E remove(int index)
    {
        if(index<0 || index>size)
        {
            System.out.println("Out of index!");
            return null;
        }

        Node<E> targetNode = getNode(index);
        targetNode.next.previous = targetNode.previous;
        targetNode.previous.next = targetNode.next;
        targetNode.next = null;
        targetNode.previous = null;
        addDeletedList(targetNode);
        --size;
        return targetNode.data;
    }



    /**
     * Creates an iterator
     * @return Return the iterator
     */
    public ListIterator<E> listIterator()
    {
        return new LDIterator();
    }

    /**
     * Creates an iterator at the index'th order in the list
     * @param index Target index
     * @return Return the iterator
     */
    public ListIterator<E> listIterator(int index)
    {
        return new LDIterator(index);
    }










}
