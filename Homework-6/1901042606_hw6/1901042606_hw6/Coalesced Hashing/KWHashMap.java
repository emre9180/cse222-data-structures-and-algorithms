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






}
