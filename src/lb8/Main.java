package lb8;
import java.util.ArrayList;
import java.util.Collection;

class Node<T> {
    T data;
    Node<T> next;

    Node(T data) {
        this.data = data;
        this.next = null;
    }
}

class GenericClass<T> {
    private Node<T> head;

    GenericClass() {
        this.head = null;
    }

    void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            head.next = head;
        } else {
            Node<T> temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
        }
    }

    void display() {
        if (head != null) {
            Node<T> temp = head;
            do {
                System.out.print(temp.data + " ");
                temp = temp.next;
            } while (temp != head);
            System.out.println();
        }
    }

    GenericClass<T> getOddGroup() {
        GenericClass<T> oddGroup = new GenericClass<>();
        if (head != null) {
            Node<T> temp = head;
            do {
                if (temp.data instanceof Integer) {
                    Integer value = (Integer) temp.data;
                    if (value % 2 != 0) {
                        oddGroup.add(temp.data);
                    }
                }
                temp = temp.next;
            } while (temp != head);
        }
        return oddGroup;
    }
}

public class Main {
    public static void main(String[] args) {
        GenericClass<Integer> integerGroup = new GenericClass<>();
        integerGroup.add(1);
        integerGroup.add(2);
        integerGroup.add(3);
        integerGroup.add(4);
        integerGroup.add(5);

        System.out.println("Original Group:");
        integerGroup.display();

        GenericClass<Integer> oddIntegerGroup = integerGroup.getOddGroup();
        System.out.println("Group with Odd Numbers:");
        oddIntegerGroup.display();

        // Приклад для рядка
        GenericClass<String> stringGroup = new GenericClass<>();
        stringGroup.add("one");
        stringGroup.add("two");
        stringGroup.add("three");
        stringGroup.add("four");
        stringGroup.add("five");

        System.out.println("Original String Group:");
        stringGroup.display();
    }
}