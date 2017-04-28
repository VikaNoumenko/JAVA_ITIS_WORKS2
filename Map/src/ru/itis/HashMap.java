package ru.itis;

/**
 * 27.04.2017
 * HashMap
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class HashMap<K, V> {
    private class Node<E, T> {
        E key;
        T value;
        int hash;
        Node next;

        Node(E key, T value, int hash) {
            this.key = key;
            this.value = value;
            this.hash = hash;
        }
    }

    // количество корзин. Корзина - элемент массива - связный список
    private int bucketsCount;

    // массив корзин
    private Node[] nodes;

    public HashMap() {
        bucketsCount = 16;
        this.nodes = new Node[bucketsCount];
    }

    public void put(K key, V value) {
        int hash = hash(key);
        int position = indexFor(hash, nodes.length);

        Node<K, V> newNode = new Node<>(key, value, hash);
        if (nodes[position] != null) {
            newNode.next = nodes[position];
        }

        nodes[position] = newNode;

    }

    public V get(K key) {
        int hash = hash(key);
        int position = indexFor(hash, nodes.length);

        Node<K,V> current = nodes[position];

        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }

        return null;
    }

    private int hash(K key) {
        int h;
        return (h = key.hashCode()) ^ (h >>> 16);
    }

    private int indexFor(int hash, int length) {
        return (length - 1) & hash;
    }

}
