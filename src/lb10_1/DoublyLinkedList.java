package lb10_1;

class DoublyLinkedList<T> implements DataStructure<T> {
    Node<T> head;

    @Override
    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
            newNode.prev = last;
        }
    }

    @Override
    public void remove(T data) {
        Node<T> temp = head, prev = null;
        if (temp != null && temp.data == data) {
            head = temp.next;
            return;
        }
        while (temp != null && temp.data != data) {
            prev = temp;
            temp = temp.next;
        }
        if (temp == null) return;
        prev.next = temp.next;
    }

    @Override
    public Iterator<T> iterator() {
        return new DoublyLinkedListIterator<>(this);
    }
}