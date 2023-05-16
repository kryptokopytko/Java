import java.io.*; //zadanie 1
import java.io.Serializable;

public class MyList<T> implements Serializable {
    protected class Node implements Serializable {
        public T val;
        public Node next;
        public Node prev;
    }
    private Node first;
    private Node last;
    public T getfirst() { return first.val;}
    public void AddToEnd(T value) {
        if (first == null) {
            first = new Node();
            first.val = value;
            last = first;
            return;
        }
        last.next = new Node();
        last.next.prev = last;
        last = last.next;
        last.val = value;
        return;
    }
    public void AddToBeginning(T value) {
        if (first == null) {
            first = new Node();
            first.val = value;
            first.next = first.prev = null;
            last = first;
            return;
        }
        first.prev = new Node();
        first.prev.next = first;
        first = first.prev;
        first.val = value;
        return;
    }
    public T DeleteFromEnd()  throws Exception {
        if (first == null) throw new Exception("no items on the list");
        T pom = last.val;
        last = last.prev;
        last.next = null;
        return pom;
    }
    public T DeleteFromBeginning()  throws Exception{ 
        if (first == null) throw new Exception("no items on the list");
        T pom = first.val;
        first = first.next;
        first.prev = null;
        return pom;
    }
    public boolean IsEmpty(){
        return (first == null);
    }
}
