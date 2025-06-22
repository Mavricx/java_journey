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
            System.out.print(temp.data + " <=> ");
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

    public void reverseList() {
        // Node current = head;
        // Node temp = null;
        // while (current != null) {
        // temp = current.prev;// Store the previous node
        // current.prev = current.next;// Reverse the next pointer
        // current.next = temp;// Reverse the previous pointer
        // current = current.prev;// Move to the next node (which is now previous)
        // }
        // if (temp != null) { // If temp is not null, it means we have a new head
        // head = temp.prev;
        // }

        Node currNode = head;
        Node prevNode = null;
        Node nextNode;

        while (currNode != null) {
            nextNode = currNode.next;// store the next node
            currNode.next = prevNode;// set the next of the current node to the previous
            currNode.prev = nextNode;// set the prev of the current node to the next

            prevNode = currNode;// now set value of prevNode as currNode
            currNode = nextNode;// move the currNode to next.
        }
        head = prevNode;
    }

    public static void main(String[] args) {
        Doubly_LinkedList list = new Doubly_LinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addFirst(0);
        // list.removeFirst();
        // list.removeLast();
        list.display();
        list.reverseList();
        list.display();
    }

}
