package Java_Core_Concepts.Linked_List;

class Node {
    int data;
    Node next;

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class CircularLinkedList {
    Node head = null;
    Node tail = null;

    public void addNode(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        } else {
            tail.next = newNode;
            newNode.next = head;
            return;
        }
    }

    public void displayList() {
        Node curNode = head;
        if (head == null) {
            return;
        }
        if (head == tail) {
            System.out.println(head + " =>");
        }
        while (true) {
            System.out.print(curNode.data + "=>");
            curNode = curNode.next;
            if (curNode == head) {
                break;
            }
        }
        System.out.println("head");

    }

    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        list.tail = new Node(50);
        list.head = new Node(10, new Node(20, new Node(30, new Node(40, list.tail))));
        list.tail.next = list.head;// made the linked list circular.
        list.addNode(60);
        list.displayList();
    }
}
