package Java_Core_Concepts.Linked_List.Doubly_LinkedList;

class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class Doubly_LinkedList {
    Node head;
    Node tail;
    int size;

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " => ");
            temp = temp.next;
        }
        System.out.println("Null");
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            size++;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            size++;
        }

    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            size++;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            newNode.prev = temp;
            temp.next = newNode;
            tail = newNode;
            size++;
        }

    }

    public void removeFirst() {
        if (head == null) {
            System.out.println("List is empty, nothing to remove.");
            size = 0;
            return;
        }
        if (head.next == null) {
            head = null;
            size--;
            return;
        } else {
            head = head.next;
            head.prev = null;
            size--;

        }
    }

    public void removeLast() {
        if (head == null) {
            System.out.println("List is empty, nothing to remove.");
            size = 0;
            return;
        }
        if (head.next == null) {
            head = null;
            size--;
            return;
        } else {
            tail = tail.prev;
            tail.next = null;
            size--;
        }
    }

    public static void main(String[] args) {
        Doubly_LinkedList list = new Doubly_LinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addFirst(0);
        list.removeFirst();
        list.removeLast();
        list.display();
        System.out.println(list.tail.data);
    }

}
