public class HashChainBT <K extends Comparable<? super K>,V> implements KWHashMap{

    /**
     * Hash table array that consists of binary search trees
     */
    private BinarySearch<Entry<K, V>>[] table;

    /**
     * Key number in the table
     */
    private int keyNum;

    /**
     * Table capacity
     */
    private int tableSize;

    /**
     * Threshold for load factor
     */
    private final double THRESHOLD = 0.8;

    /**
     * Load factor for rehashing
     */
    private float loadFactor;




    /**
     * Constructor for hash table
     */
    public HashChainBT()
    {
        table = new BinarySearch[10];
        keyNum=0;
        tableSize = 10;
        loadFactor = 0;
    }

    /**
     * Get function for load factor
     * @return Returns the load factor
     */
    public double getLoadFactor()
    {return loadFactor;}

    /**
     * Updates the load factor
     */
    private void updateLoadFactor()
    {
        loadFactor = (float) keyNum/tableSize;
    }

    /**
     * Traverse the tree. Inorder trevarse. Put all the nodes to new hash table
     * @param tree
     */
    private void traverse(BinarySearch tree)
    {
        if(tree==null)
            return;
        traverse(tree.getLeftSubtree());
        put(((Entry) tree.root.data).getKey(),((Entry) tree.root.data).getValue());
        traverse(tree.getRightSubtree());
    }

    private int findPrimeTableSize()
    {
        int i;

        /* Find the largest prime number */
        for(i = tableSize*2+1;;++i)
        {
            boolean dividible = false;

            for(int j=2;j<i/2;j++)
                if(i%j==0) dividible=true;

            if(dividible==false)
                break;
        }

        return i;
    }

    private void rehash()
    {
        int newSize = findPrimeTableSize();
        BinarySearch<Entry<K, V>>[] tempTable = table;
        BinarySearch<Entry<K, V>>[] newTable = new BinarySearch[newSize];
        int oldTableSize = tableSize;
        tableSize = newSize;
        table = newTable;
        keyNum = 0;
        updateLoadFactor();

        for(int i=0;i<oldTableSize;++i)
            if(tempTable[i]!=null)
                traverse(tempTable[i]);

    }

    /**
     * Returns the value associated with the specified key. Returns null if the key is not present
     * @param key Key
     * @return Return the element with the specified key, if there is such element returns null
     */
    public V get(Object key)
    {
        int index = key.hashCode() % table.length;

        if(table[index]==null)
            return null;

        else
        {
            BinarySearch tree = table[index];
            while(tree!=null)
            {
                Entry root = (Entry) tree.getRoot();
                if(root.getKey().compareTo((K) key)<0)
                    tree = (BinarySearch) tree.getLeftSubtree();

                if(root.getKey().compareTo((K) key)>0)
                    tree = (BinarySearch) tree.getRightSubtree();

                else
                    return (V) root.getValue();


            }
            return null;
        }
    }

    /**
     * Returns true if this table contains no key‐value mappings
     * @return If the table is empty returns true
     */
    public boolean isEmpty()
    {
        if(keyNum==0)
            return true;
        else
            return false;
    }

    /**
     * Associates the specified value with the specified key.
     * @param key Key
     * @param value Target value
     * @return Returns the previous value associated with the specified key, or null if there was no mapping for the key
     */
    public V put(Object key, Object value)
    {
        int index = (int) key % tableSize;
        if(index<0)
            index += table.length;

        if(table[index]==null) // If the index is null, put the object there
        {
            table[index] = new BinarySearch<>();
            table[index].add(new Entry<K,V>((K) key,(V) value));
            keyNum++;
            updateLoadFactor();
            if(getLoadFactor()>=THRESHOLD)
                rehash();
            return null;
        }

        else // If the index is NOT null, we go to tree and move on it
        {
            BinarySearch tree = table[index];
            while(tree!=null)
            {
                Entry root = (Entry) tree.getRoot();
                if((root.getKey().compareTo((K) key)>0)) // If the root is greater than key
                {
                    if(tree.getLeftSubtree()==null)
                    {
                        tree.setLeftTree(new Entry((K) key,(V) value));
                        keyNum++;
                        updateLoadFactor();
                        if(getLoadFactor()>=THRESHOLD)
                            rehash();
                        return null;
                    }
                    tree = (BinarySearch) tree.getLeftSubtree();
                }


                if((root.getKey().compareTo((K) key)<0)) // If the root is smaller than key
                {
                    if(tree.getRightSubtree()==null)
                    {
                        tree.setRightTree(new Entry((K) key,(V) value));
                        keyNum++;
                        updateLoadFactor();
                        if(getLoadFactor()>=THRESHOLD)
                            rehash();
                        return null;
                    }
                    tree = (BinarySearch) tree.getRightSubtree();
                }

                else // If the root is equal to key
                {
                    tree.setRoot(new Entry((K) key,(V) value));
                    return (V) root.getValue();
                }

            }

            updateLoadFactor();
            if(getLoadFactor()>=THRESHOLD)
                rehash();
            return null;
        }


    }

    /**
     * Returns the table size
     * @return Returns the table size
     */
    public int size()
    {
        return tableSize;
    }

    /**
     * Removes the object with target key from the hash table.
     * @param key Target key
     * @return Returns the removed value. If it cannot find, returns null
     */
    public V remove(Object key)
    {
        int index = (int) key % tableSize;

        if(index<0)
            index += table.length;

        if(table[index]==null) // If the index is null, it means that there is no such element
            return null;

        else // If the index is not null, it means that we have to go forward
        {
            BinarySearch tree = table[index]; // Target tree. We have to move on it
            while(tree!=null)
            {
                //System.out.printf("size-<%d AAAAAAAAAAA %d ve %d\n",tableSize, ((Entry)tree.getRoot()).getKey(), key);
                if(tree.getRoot() == null)
                    break;

                Entry root = (Entry) tree.getRoot();

                //If the key is greater than root go left
                if(root.getKey().compareTo((K) key)<0)
                    tree = (BinarySearch) tree.getLeftSubtree();


                //If the key is smaller than root go right
                if(root.getKey().compareTo((K) key)>0)
                    tree = (BinarySearch) tree.getRightSubtree();

                else if(tree!=null)
                {
                    root = (Entry) tree.getRoot();
                    tree.delete(root);
                }

            }
            keyNum--;
            return null;
        }
    }


    /** Converts a sub‐tree to a string. Performs a preorder traversal. @param node The local root @param depth The depth @param sb The StringBuilder to save the output
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tableSize; i++){
            sb.append(String.format("\n%d. Index Tree:\n",i));


            if(table[i]!=null)
            {
                //KWHashMap.Entry ent = (KWHashMap.Entry) table[i].root.data;
                sb.append(table[i].toString());
            }
            else sb.append("NULL\n");
        }

        return sb.toString();

    }
}
