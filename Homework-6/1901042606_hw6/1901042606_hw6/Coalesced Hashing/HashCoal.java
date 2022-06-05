public class HashCoal<K,V> implements KWHashMap{
    /**
     * Contains key-value pairs fora a hash table
     * @param <K> Key type
     * @param <V> Value type
     */
    public class Entry<K ,V>{
        /**
         * The key
         */
        private K key;

        /**
         * The value
         */
        private V value;

        /**
         * Referance to the next node
         */
        private Entry next;

        /**
         * Creates a new key-value pair
         * @param key The key
         * @param value The value
         */
        public Entry(K key, V value)
        {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        /**
         * Retrieves the key
         * @return The key
         */
        public K getKey()
        {
            return key;
        }

        /**
         * Retrieves the value
         * @return The value
         */
        public V getValue()
        {
            return value;
        }

        public V setValue(V val)
        {
            V oldVal = value;
            value = val;
            return oldVal;
        }

        public String toString()
        {
            if(value==null)
                return "NULL";
            else
                return value.toString();
        }

        public void copy(Entry copyObject)
        {
            if(copyObject==null) return;

            this.key = (K) copyObject.key;
            this.value = (V) copyObject.value;
            this.next = copyObject.next;
        }



    }

    /**
     * Hash array
     */
    private Entry<K, V>[] table;

    /**
     * Indicates the size of the table.
     */
    private int tableSize;

    /**
     * Indicates element numbe in the hash table
     */
    public int keyNumber;

    /* Indicates the deleted entries */
    private final Entry DELETED;

    /* Load factor threshold */
    private final double THRESHOLD = 0.8;

    private double loadFactor;

    /* Prime number in the hashing function. It does not need to calculate in every hash function. Only rehashing is enough. */
    private int primeNum;

    /**
     * Constructor. Initiliaze the entry as null, Table size is 11.
     */
    public HashCoal()
    {
        DELETED = new Entry(null,null);
        table = new Entry[11];
        tableSize = 11;
        keyNumber = 0;
        loadFactor = 0;
        primeNum = findPrimeNum();
    }

    /**
     * Get function for load factor
     * @return Returns the load factor
     */
    public double getLoadFactor()
    {return loadFactor;}

    /**
     * Update the load factor
     */
    private void updateLoadFactor()
    {
        loadFactor = (float) keyNumber/tableSize;
    }

    /**
     * Returns true if this table contains no key‐value mappings
     * @return If the table is empty returns true
     */
    public boolean isEmpty()
    {
        if(keyNumber==0)
            return true;
        else
            return false;
    }

    /**
     * Returns the size of the table
     * @return
     */
    public int size()
    {
        return tableSize;
    }

    /**
     * This function finds the largest prime number smaller than 0.8 * tableSize
     * @return Returns the number found
     */
    private int findPrimeNum()
    {
        int i;

        /* Find the starting point to find a prime number */
        double start = 0.8 * tableSize;

        /* Find the largest prime number */
        for(i = (int) start;i>=2;--i)
        {
            boolean dividible = false;

            if(i==2)
            {
                dividible = true;
                break;
            }

            for(int j=2;j<i/2;j++)
                if(i%j==0) dividible=true;

            if(dividible==false)
                break;
        }

        return i;


    }

    /**
     * Finds the next prime number for hash table
     * @return Return the new prime table size
     */
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

    /**
     * Makes rehash. Uses put function to rehash. All the old elements are put the new table
     */
    private void rehash()
    {
        int newSize = findPrimeTableSize();
        Entry<K, V>[] tempTable = table;
        Entry<K, V>[] newTable = new Entry[newSize];
        int oldTableSize = tableSize;
        table = newTable;
        keyNumber = 0;
        tableSize = newSize;
        updateLoadFactor();

        for(int i=0;i<oldTableSize;++i)
            if(tempTable[i]!=null)
                put(tempTable[i].getKey(), tempTable[i]);

        primeNum = findPrimeNum();
    }

    /**
     * Get function. It finds the object with key value.
     * @param key Key
     * @return If it finds returns the object, else returns null
     */
    public V get(Object key)
    {
        /* Calculated the index */
        int probNum = 1;
        int hash1 = (int) key % tableSize;
        int hash2 = primeNum - ((int) key % primeNum);
        int index = hashFunc(hash1,hash2,probNum);
        if(index<0)
            index+=tableSize;

        /* Start to search */
        if(table[index]!=null && table[index].getKey().equals(key))
            return table[index].getValue();

        else if (table[index]==null)
            return null;

        else
        {
            Entry<K, V> entry = table[index];
            while(entry.next!=null)
            {
                //System.out.printf("asd %d ve %d\n",entry.key, index);
                if(entry.getKey().equals(key))
                    return entry.getValue();

                entry = entry.next;
                if(entry==null) break;
            }
        }
        return null;
    }

    /**
     * Double hash function
     * Calculates the index that we are going to try to add the new element to hash table
     * @param hashCode1 The first hash code
     * @param hashCode2 The second hash code
     * @return Returns the calculated index
     */
    private int hashFunc(int hashCode1, int hashCode2, int prob)
    {
        return ( (hashCode1 + ((prob * hashCode2) )) % tableSize);
    }

    /**
     * Returns the value associated with the specified key. Returns null if the key is not present
     * @param key Key
     * @return Return the element with the specified key, if there is such element returns null
     */
    public V put(Object key, Object value)
    {
        /* Calculate the index */
        int probNum = 1;
        int hash1 = (int) key % tableSize;
        int hash2 = primeNum - ((int) key % primeNum);
        int index = hashFunc(hash1,hash2,probNum);
        if(index<0)
            index+=tableSize;

        // If the index is null, put the new object there
        if(table[index]==null)
        {
            table[index] = new Entry<>((K) key, (V) value);
            keyNumber++;
            updateLoadFactor();
            if(getLoadFactor()>=THRESHOLD)
                rehash();
            return null;
        }

        // If it is not, we have to go forward
        else
        {
            int mainIndex = index;
            while(table[index]!=null)
            {
                if(table[index].getKey().equals((K) key)) // If we find the correct node and it is not null, we have to update it
                {
                    V oldValue = table[index].getValue();
                    table[index].setValue((V) value);
                    return oldValue;
                }

                // Go to new index with new probe value since we have not the correct node yet
                mainIndex = index;
                hash1 = (int) key % tableSize;
                hash2 = primeNum - ((int) key % primeNum);
                index = hashFunc(hash1,hash2,probNum);
                if(index<0)
                    index+=tableSize;
                ++probNum;

            }

            // Put the new object
            table[index] = new Entry<>((K) key, (V) value);
            table[mainIndex].next = table[index];
            keyNumber++;
            updateLoadFactor();
            if(getLoadFactor()>=THRESHOLD)
                rehash();
            return null;
        }
    }

    /**
     * Removes the object with target key from the hash table.
     * @param key Target key
     * @return Returns the removed value. If it cannot find, returns null
     */
    public V remove(Object key)
    {
        /* Calculated the index */
        int probNum = 1;
        int hash1 = (int) key % tableSize;
        int hash2 = primeNum - ((int) key % primeNum);
        int index = hashFunc(hash1,hash2,probNum);
        if(index<0)
            index+=tableSize;

        /* Find the node */
        Entry<K,V> target = null;
        Entry<K,V> iter = table[index];

        if(table[index]==null || table[index].value==null)
            return null;

        // If we find the key, mark it as target
        else if(iter.getKey().equals((K) key))
        {
            //System.out.printf("Buldu size: %d -- %d ve %d\n",tableSize, iter.getKey(), key);
            target = iter;
        }
        else // If we are in the correct index but wrong key, we have to go move forward
        {
            //System.out.printf("Bulamadi size: %d -- %d ve %d\n",tableSize, iter.getKey(), key);
            boolean findFlag = false;

            while(iter!=null && iter.value!=null) // Run until we find the correct place with key
            {
                //System.out.printf("size: %d -- %d ve %d\n",tableSize, iter.getKey(), key);
                if(iter.getKey().equals((K) key))
                {
                    target = iter;
                    findFlag = true;
                    break;
                }

                else
                    iter = iter.next;
            }

            if(findFlag==false) // If we cannot find, returns null
                return null;
        }



        // If a node points our target,
        for(int i=0;i<tableSize;++i)
        {
            if(table[i]==null)
                continue;
            if(table[i].next!=null)
                if(table[i].next!=null && table[i].next.getValue()!=null && table[i].value!=null && table[i].value!=null && table[i].next.getKey().equals(target.getKey()))
                {
                    V deleted = target.getValue();
                    table[i].next = target.next;
                    if(target.next == null);
                    //target.setValue((V) DELETED.getValue());
                    target.copy(new Entry<>(null,null));
                    target.next = null;
                    keyNumber--;
                    return deleted;
                }
        }

        /* If the target node is not pointed by ant other node */
        Entry deleted = target;
        while(true)
        {
            Entry nextNode = target.next;
            if(nextNode==null)
            {
                keyNumber--;
                //target.copy(new Entry<>(null,null));
                //target.setValue((V) DELETED.getValue());
                return (V) deleted.value;
            }
            target.copy(target.next);
            target = nextNode;

            if(target.next==null)
            {
                keyNumber--;
                //target.setValue((V) DELETED.getValue());
                target.copy(new Entry<>(null,null));
                return (V) deleted.value;
            }
        }
    }

    /**
     * Print function for the hash table
     * @return Returns the string
     */
    public String toString()
    {
        String str = new String();

        for(int i=0;i<size();++i)
        {
            int nextIndex = -1;
            if(table[i]!=null)
            {
                for(int j=0;j<size();j++)
                {
                    if(table[j]==table[i].next)
                    {
                        nextIndex = j;
                        break;
                    }
                }
            }

            if(table[i]!=null && table[i].getValue()!=null)
            {
                if(table[i].next==null)
                    str += String.format("%d.) %s -> NULL\n",i,table[i].toString());
                else
                    str += String.format("%d.) %s -> %d\n",i,table[i].toString(),nextIndex);
            }
            else str += String.format("%d.) NULL\n",i);
        }
        return str;
    }
}
