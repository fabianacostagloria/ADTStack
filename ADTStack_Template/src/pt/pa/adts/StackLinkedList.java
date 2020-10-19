package pt.pa.adts;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class StackLinkedList<T> implements Stack<T> {

    private Node top; //sentinel of linked list
    //private int size;

    public StackLinkedList() {
        /*
        The configuration of an empty singly linked list is the sentinel pointing to null.
         */
        this.top = new Node(null, null);
        //this.size = 0;
    }

    @Override
    public void push(T element) throws FullStackException {
        /*
        Element should be stored in a new node which is pointed by top sentinel.
        Must maintain the chaining of all nodes.
         */
        try {
            top.next = new Node(element, top.next);
            //size++;
        } catch (OutOfMemoryError e) {
            throw new FullStackException("No memory for more elements");
        }
    }

    @Override
    public T pop() throws EmptyStackException {
        /*
        The element at the top of the stack is the element stored in the node immediately after the top sentinel.
         */
        if (isEmpty()) throw new EmptyStackException();
        T element = top.next.element;
        top.next = top.next.next;
        //size--;
        return element;
    }

    @Override
    public T peek() throws EmptyStackException {
        if (isEmpty()) throw new EmptyStackException();
        return top.next.element;
    }

    @Override
    public int size() {
        //return size;
        Node cur = top.next;
        int counter = 0;
        while (cur != null) {
            counter++;
            cur = cur.next;
        }
        return counter;
    }

    @Override
    public boolean isEmpty() {
        //return (this.size == 0);
        return (top.next == null);
    }

    @Override
    public void clear() {
        this.top.next = null;
        //this.size = 0;
    }

    /**
     * Inner class representing a linked list node.
     * Only recognized in the context of this class (private).
     */
    private class Node {
        private T element;
        private Node next;

        public Node(T element, Node next) {
            this.element = element;
            this.next = next;
        }
    }
}
