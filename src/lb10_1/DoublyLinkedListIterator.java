package lb10_1;
import java.util.*;
class DoublyLinkedListIterator<T> implements Iterator<T> {
    Node<T> current;

    DoublyLinkedListIterator(DoublyLinkedList<T> list) {
        this.current = list.head;
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        T data = current.data;
        current = current.next;
        return data;
    }
}