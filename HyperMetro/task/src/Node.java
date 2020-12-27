public class Node<E> {

    private E value;
    private Node<E> next;
    private Node<E> prev;

    public void setPrev(Node<E> prev) {
        this.prev = prev;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    Node(E element, Node<E> prev, Node<E> next) {
        this.value = element;
        this.next = next;
        this.prev = prev;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    Node<E> getNext() {
        return next;
    }

    Node<E> getPrev() {
        return prev;
    }
}