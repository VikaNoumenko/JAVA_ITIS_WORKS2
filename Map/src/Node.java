import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Node<K, V> {

    private T key;
    private T value;
    private Node next;

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }


    List<Map<Integer, String>> data = new ArrayList<>();


}
