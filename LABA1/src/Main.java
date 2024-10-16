class Node<T> {
    T data;
    Node<T> next;

    Node(T data) {
        this.data = data;
        this.next = null;
    }
}

class Container<T> {
    private Node<T> head;
    private int size;

    public Container() {
        this.head = null;
        this.size = 0;
    }

    // Метод для добавления элемента в контейнер
    public void add(T element) {
        Node<T> newNode = new Node<>(element);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    // Метод для извлечения элемента по индексу
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    // Метод для удаления элемента по индексу
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        if (index == 0) {
            head = head.next;
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;
    }

    // Метод для получения размера контейнера
    public int size() {
        return size;
    }

    // Метод для проверки, пуст ли контейнер
    public boolean isEmpty() {
        return size == 0;
    }
}

// Пример использования контейнера
public class Main {
    public static void main(String[] args) {
        Container<String> container = new Container<>();

        container.add("Hello");
        container.add("World");
        container.add("Java");

        System.out.println("Size: " + container.size()); // Size: 3

        System.out.println("Element at index 1: " + container.get(1)); // Element at index 1: World

        container.remove(1);

        System.out.println("Size after removal: " + container.size()); // Size after removal: 2
        System.out.println("Element at index 1 after removal: " + container.get(1)); // Element at index 1 after removal: Java
    }
}
