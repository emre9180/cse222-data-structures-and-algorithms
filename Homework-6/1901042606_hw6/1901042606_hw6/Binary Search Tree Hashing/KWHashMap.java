/**
 * Hash Map Interface. It is copied from the text-book as it is asked in the HW PDF
 */
public interface KWHashMap<K extends Comparable<? super K>,V> {
    /**
     * Returns the value associated with the specified key. Returns null if the key is not present
     * @param key Key
     * @return Return the element with the specified key, if there is such element returns null
     */
    public V get(Object key);

    /**
     * Returns true if this table contains no key‐value mappings
     * @return If the table is empty returns true
     */
    public boolean isEmpty();

    /**
     * Associates the specified value with the specified key.
     * @param key Key
     * @param value Target value
     * @return Returns the previous value associated with the specified key, or null if there was no mapping for the key
     */
    public V put(Object key, Object value);

    /**
     * Removes the mapping for this key from this table if it is present.
     * @param key
     * @return Returns the previous value associated with the specified key, or null if there was no mapping
     */
    public V remove(Object key);

    /**
     * Returns the size of the table
     * @return
     */
    int size();



    /**
     * Contains key-value pairs fora a hash table
     * @param <K> Key type
     * @param <V> Value type
     */
    public class Entry<K extends Comparable<? super K>,V> implements Comparable<Entry<K, V>> {
        /**
         * The key
         */
        public K key;

        /**
         * The value
         */
        public V value;

        /**
         * Creates a new key-value pair
         * @param key The key
         * @param value The value
         */
        public Entry(K key, V value)
        {
            this.key = key;
            this.value = value;
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

        public int compareTo(Entry obj)
        {
            return obj.getKey().compareTo(this.key);
        }

        public int compareTo(K key)
        {
            return this.key.compareTo(key);
        }

        public String toString()
        {
            return key.toString();
        }



    }


}
