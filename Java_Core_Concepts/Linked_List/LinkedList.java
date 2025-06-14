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

public class LinkedList {

    public void addInFront(int data, Node head) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;

    }

    public void deleteLast(Node head) {
        Node curNode = head;
        if (curNode == null) {
            return;
        }
        if (curNode.next == null) {
            head = null;
            return;
        }
        while (curNode.next.next != null) {
            curNode = curNode.next;
        }
        curNode.next = null;
    }

    public void deleteByValue(int data, Node head) {
        if (head == null) {
            return;
        }
        if (head.data == data) {
            head = head.next;
            return;
        }
        Node curNode = head;
        Node temp = head;
        while (curNode.next != null) {
            if (curNode.data == data) {
                temp.next = curNode.next;
            }
            temp = curNode;// store the previous value.
            curNode = curNode.next;
        }

    }

    public void display(Node head) {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + "=>");
            currentNode = currentNode.next;

        }
        System.out.print("null\n");
    }

    public static void main(String[] args) {
        Node head = new Node(1, new Node(2, new Node(3, null)));
        LinkedList list = new LinkedList();
        list.addInFront(4, head);
        list.addInFront(5, head);
        list.addInFront(6, head);
        list.addInFront(7, head);

        list.display(head);
        list.deleteByValue(2, head);
        list.deleteLast(head);
        list.deleteByValue(5, head);
        list.display(head);

    }
}