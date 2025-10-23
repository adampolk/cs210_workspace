import java.util.Iterator;
import java.util.NoSuchElementException;
import stdlib.StdOut;
import stdlib.StdRandom;

// A data type to represent a double-ended queue (aka deque), implemented using a doubly-linked list as the underlying 
// data structure.
public class LinkedDeque<T> implements Iterable<T> {
    private Node first; // the first node in the linked list
    private Node last;  // the last node in the linked list
    private int n;      // the number of nodes in the linked list

    // Constructs an empty deque.
    public LinkedDeque() {
        this.first = null;
        this.last = null;
        this.n = 0;
    }

    // Returns true if this deque is empty, and false otherwise.
    public boolean isEmpty() {
        return n <= 0;
    }

    // Returns the number of items in this deque.
    public int size() {
        return n;
    }

    // Adds item to the front of this deque.
    public void addFirst(T item) {
        if(item == null){
            throw new NullPointerException("item is null");
        }
        // Create a new node with item T
        Node x = new Node();
        x.item = item;
        n++;
        // If there is no front element, then the list is empty, so set the first and last equal to the new node.
        if(first == null){
            first = x;
            last = x;
        }else{  
            // If there is already a front node, then it will now point to x and become the next node after x
            x.next = first;
            first.prev = x;
            first = x;
        }
    }

    // Adds item to the back of this deque.
    public void addLast(T item) {
        if(item == null){
            throw new NullPointerException("item is null");
        }
        
        Node x = new Node();
        x.item = item;
        n++;
        if(last == null){
            first = x;
            last = x;
        }else{
            x.prev = last;
            last.next = x;
            last = x;
        }
    }

    // Returns the item at the front of this deque.
    public T peekFirst() {
        if(this.isEmpty()){
            throw new NoSuchElementException("Deque is empty");
        }
        return first.item;
    }

    // Removes and returns the item at the front of this deque.
    public T removeFirst() {
        if(this.isEmpty()){
            throw new NoSuchElementException("Deque is empty");
        }
        n--;
        T item = first.item;
        first = first.next;
        
        // Handle the cases where the first element becomes the last or the queue becomes empty after removal
        if(first == null){  
            last = null;
        }else{
            first.prev = null;
        }
        return item;
    }

    // Returns the item at the back of this deque.
    public T peekLast() {
        if(this.isEmpty()){
            throw new NoSuchElementException("Deque is empty");
        }
        return last.item;
    }

    // Removes and returns the item at the back of this deque.
    public T removeLast() {
        if(this.isEmpty()){
            throw new NoSuchElementException("Deque is empty");
        }
        n--;
        T item = last.item;
        last = last.prev;

        // Handle the cases where the last element becomes the first or the queue becomes empty after removal
        if(last == null){
            first = null;
        }else{
            last.next = null;
        }
        return item;
    }

    // Returns an iterator to iterate over the items in this deque from front to back.
    public Iterator<T> iterator() {
        return new DequeIterator();
    }

    // Returns a string representation of this deque.
    public String toString() {
        String s = "";
        for (T item : this) {
            s += item + ", ";
        }
        return isEmpty() ? s + "[]" : "[" + s.substring(0, s.length() - 2) + "]";
    }

    // A deque iterator.
    private class DequeIterator implements Iterator<T> {
        private int index;
        private Node current;

        // Constructs an iterator.
        public DequeIterator() {
            current = first;
            this.index = 0;
        }

        // Returns true if there are more items to iterate, and false otherwise.
        public boolean hasNext() {
            return this.index < n;
        }

        // Returns the next item.
        public T next() {
            if(index == n){
                throw new NoSuchElementException("Iterator is empty");
            }
            T item = current.item;
            current = current.next;
            index++;
            return item;
        }
    }

    // A data type to represent a doubly-linked list. Each node in the list stores a generic item
    // and references to the next and previous nodes in the list.
    private class Node {
        private T item;  // the item
        private Node next;  // the next node
        private Node prev;  // the previous node
    }

    // Unit tests the data type. [DO NOT EDIT]
    public static void main(String[] args) {
        LinkedDeque<Character> deque = new LinkedDeque<Character>();
        String quote = "There is grandeur in this view of life, with its several powers, having " +
                "been originally breathed into a few forms or into one; and that, whilst this " +
                "planet has gone cycling on according to the fixed law of gravity, from so simple" +
                " a beginning endless forms most beautiful and most wonderful have been, and are " +
                "being, evolved. ~ Charles Darwin, The Origin of Species";
        int r = StdRandom.uniform(0, quote.length());
        StdOut.println("Filling the deque...");
        for (int i = quote.substring(0, r).length() - 1; i >= 0; i--) {
            deque.addFirst(quote.charAt(i));
        }
        for (int i = 0; i < quote.substring(r).length(); i++) {
            deque.addLast(quote.charAt(r + i));
        }
        StdOut.printf("The deque (%d characters): ", deque.size());
        for (char c : deque) {
            StdOut.print(c);
        }
        StdOut.println();
        StdOut.println("Emptying the deque...");
        double s = StdRandom.uniform();
        for (int i = 0; i < quote.length(); i++) {
            if (StdRandom.bernoulli(s)) {
                deque.removeFirst();
            } else {
                deque.removeLast();
            }
        }
        StdOut.println("deque.isEmpty()? " + deque.isEmpty());
    }
}
