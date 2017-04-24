package ru.itis.lists;

import java.util.Iterator;

/**
 * 20.04.2017
 * LinkedList
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class LinkedList<T> implements List<T> {

    private class Node {

        private T value;
        private Node next;

        public Node(T value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T element) {
            this.value = element;
        }

        public void setNext(Node node) {
            this.next = node;
        }
    }

    // Итератор связного списка
    private class LinkedListIterator implements Iterator<T> {

        // итератор всегда помнит текущий узел, а если точнее, тот
        // который следует вернуть
        private Node current;

        LinkedListIterator(Node current) {
            this.current = current;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            // копируем значение из current
            T value = current.value;
            // current сдвигаем
            current = current.next;
            // возвращаем значение
            return value;
        }
    }

    private Node head;
    private Node last;
    private int count;

    public LinkedList() {
        this.count = 0;
        this.head = null;
        this.last = null;
    }

    @Override
    public void add(T element) {
        Node newNode = new Node(element);

        if (head == null) {
            head = newNode;
            last = newNode;
        } else {
            /*
            Node current = this.head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            */
            this.last.next = newNode;
            this.last = newNode;
        }
        count++;
    }

    @Override
    public void delete(T element) {
        Node current = head;
        while (current != null) {
            if (current.getValue().equals(element)) {
                while (current != null) {
                    current.setValue(current.getValue());
                    current = current.getNext();
                }
                count--;
                return;
            }
            current = current.getNext();
        }
    }


    //Implemented removeByIndex method:
    @Override
    public void removeByIndex(int index) {
        int i = 0;
        Node current = head;
        while (i + 1 != index) {
            i++;
            current = current.getNext();
        }
        Node newNextEl = current.getNext().getNext();
        if (newNextEl != null) {
            current.setNext(newNextEl);
        } else {
            current.setNext(null);
            this.last = current;
        }
    }


    @Override
    public T get(int index) {
        if (index < count && index >= 0) {
            Node current = this.head;
            int i = 0;
            while (i < index) {
                current = current.next;
                i++;
            }
            return current.value;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public int indexOf(T element) {
        int index = 0;
        Node current = this.head;
        while (current != null) {
            if (current.value.equals(element)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    // Implemented addToBegin method:
    @Override
    public void addToBegin(T element) {
        if (head == null) {
            head = new Node(element);
        } else {
            Node temp = new Node(element);
            temp.next = head;
            head = temp;
        }
    }



    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator(head);
    }

    @Override
    public int size() {
        return count;
    }


}
