package pt.pa.adts;

/**
 * Implementation of stack ({@link Stack}) based in array list.
 *
 * @param <T> element to store.
 */
public class StackArrayList<T> implements Stack<T> {

    private static final int DEFAULT_CAPACITY = 40;
    /**
     * array that contains stored elements
     */
    private T[] elements;
    /**
     * count of stored elements
     */
    private int size;

    @SuppressWarnings("unchecked")
    public StackArrayList() {
        this.elements = (T[]) new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    @Override
    public void push(T element) throws FullStackException {
        //complexidade algoritmica constante - 0(1)
        if (this.size >= this.elements.length) {
            try{
                int nCapacity = this.elements.length * 2;
                T[] nElements = (T[]) new Object[nCapacity];
                //1.//for(int i = 0; i < this.size; i++) nElements[i] = elements[i];
                System.arraycopy(elements, 0, nElements, 0, this.size);
                elements = nElements;
            }catch (OutOfMemoryError e){
                throw new FullStackException("No memory for more elements");
            }
        }
        this.elements[this.size++] = element;
    }

    @Override
    public T pop() throws EmptyStackException {
        if (isEmpty()) throw new EmptyStackException();
        //complexidade algoritmica constante - 0(1)
        //T elem = this.elements[this.size - 1];
        //this.elements[this.size - 1] = null; //Q: Strictly necessary? Why is it a good idea?
        this.size--;
        return this.elements[this.size];
    }

    //TODO: fornecer implementação e testar
    @Override
    public T peek() throws EmptyStackException {
        if (isEmpty()) throw new EmptyStackException();
        return this.elements[this.size - 1];
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return (this.size == 0);
    }

    //TODO: fornecer implementação e testar
    @Override
    public void clear() {
        size = 0;
    }
}
