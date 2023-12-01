package lb10_1;

class Node<T> {
    T data;
    Node<T> next, prev;

    Node(T data) {
        this.data = data;
        next = prev = null;
    }
}
