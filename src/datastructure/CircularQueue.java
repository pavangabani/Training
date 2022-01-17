package datastructure;
class Node {
    Node first;
    Node next;
    int value;

    Node(int value) {
        this.value = value;
    }

    void start() {
        first = this;
        first.next=first;
    }

    void add(int value) {
        Node node = new Node(value);
        Node traverse = first;
        while (traverse.next != first) {
            traverse = traverse.next;
        }
        traverse.next = node;
        node.next = first;
    }

    void display() {
        Node traverse = first;
        while (traverse.next != first) {
            System.out.println(traverse.value);
            traverse = traverse.next;
        }
        System.out.println(traverse.value);
    }
}
//remove
    public class CircularQueue {
        public static void main(String[] args) {
            Node node = new Node(1);
            node.start();
            node.add(3);
            node.add(5);
            node.display();
        }
    }

