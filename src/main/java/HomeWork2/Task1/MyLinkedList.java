package HomeWork2.Task1;

import java.util.Objects;

public class MyLinkedList<T> {


    private class Node<T> {
        T obj;
        Node next;
        Node before;

        public Node(T obj) {
            this.obj = obj;
        }

        @Override
        public String toString() {
            return "Node {" +
                    "object = " + obj +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node<?> node = (Node<?>) o;
            return Objects.equals(obj, node.obj) && Objects.equals(next, node.next) && Objects.equals(before, node.before);
        }
    }

    private Node<T> head;
    private Node<T> tail;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void push(T obj) {
        Node<T> n = new Node(obj);
        n.next = head;
        if (head == null) {
            tail = n;
        } else {
            head.before = n;
        }
        head = n;
    }

    public T pop() {
        if (isEmpty()) {return null;}
        T obj = tail.obj;
        if (tail.before != null) {
            tail.before.next = null;
            tail = tail.before;
        } else {
            tail = null;
            head = null;
        }

        return obj;
    }

    public boolean contains(T obj) {
        Node<T> n = new Node(obj);
        Node<T> current = head;
        while (!current.equals(n)) {
            if (current.next == null) return false;
            else current = current.next;
        }
        return true;
    }

    public T delete(T obj) {
        Node<T> n = new Node<>(obj);
        Node<T> current = head;
        Node<T> previous = head;
        while (!current.equals(n)) {
            if (current.next == null) return null;
            else {
                previous = current;
                current = current.next;
            }
        }
        if (current == head && current == tail) {
            head = null;
            tail = null;
        } else if (current == head) {
            head.next.before = null;
            head = head.next;
        } else if (current == tail) {
            tail.before.next = null;
            tail = tail.before;
        } else {
            previous.next = current.next;
            current.next.before = previous;
        }
        return current.obj;
    }

    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        Node<T> current = head;
        StringBuilder sb = new StringBuilder("[");
        while(current != null) {
            sb.append(current);
            current = current.next;
            sb.append((current == null) ? "]" : ",");
        }
        return sb.toString();
    }
}
