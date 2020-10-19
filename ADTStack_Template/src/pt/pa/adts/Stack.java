package pt.pa.adts;

/**
 * Interface that defines the behavior of a stack in Java.
 * A stack is a container of elements that ensures an LIFO access policy.
 * Implementations should implement this interface.
 *
 * @param <T> type of element to store in stack.
 */
public interface Stack<T> {
    /**
     * Inserts the element <i>element</i> on top of the stack.
     *
     * @param element element to insert.
     * @throws FullStackException if there is no capacity / memory for more elements.
     */
    public void push(T element) throws FullStackException;

    /**
     * Removes the element at the top of the stack.
     *
     * @return the removed element at the top of the stack.
     * @throws EmptyStackException if the stack is empty.
     */
    public T pop() throws EmptyStackException;

    /**
     * Returns without removing the element at the top of the stack.
     *
     * @return the element at the top of the stack.
     * @throws EmptyStackException if stack is empty.
     */
    public T peek() throws EmptyStackException;

    /**
     * Returns the count of the number of elements in stack.
     *
     * @return size of stack.
     */
    public int size();

    /**
     * Returns true if stack empty, false if stack is populated.
     *
     * @return if stack is empty.
     */
    public boolean isEmpty();

    /**
     * Discards all elements present in stack returning to an empty state.
     */
    public void clear();
}