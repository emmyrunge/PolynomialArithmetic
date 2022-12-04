public interface IGDSLL<T extends Comparable<? super T>>
{
    /**
     * insert value into this sorted doublyy-linked list
     * @param value value to be inserted
     */
    void insert(T value);
    /**
     * remove specified value from the list
     * @param value value to be removed
     * @return boolean success or failure (if value not found)
     */
    boolean remove(T value);
    /**
     * determine whether value is contained in this list
     * @param value value to be located
     * @return boolean was specified value found or not
     */
    boolean contains(T value);
    /**
     * determines if the list is empty
     * @return true if the list is empty, otherwise false
     */
    boolean isEmpty();
}
