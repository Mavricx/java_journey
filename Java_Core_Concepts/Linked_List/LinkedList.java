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

public class LinkedList {
    Node head;

    public void addInFront(int data) {
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

    public void deleteLast() {
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

    public void deleteFirst() {
        if (head != null) {
            head = head.next;
            return;
        }

    }

    public void deleteByValue(int data) {
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

    public void deleteByIndex(int index) {
        Node temp = head;
        Node curNode = head;
        int curIdx = 0;
        while (curNode != null) {
            curIdx++;
            if (curIdx == index) {
                temp.next = curNode.next;
                break;
            }
            temp = curNode;
            curNode = curNode.next;
        }

    }

    public void reverseLinkedList() {
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;// store the next node
            current.next = prev;// reverse the current node pointer
            prev = current;// move prev to step forward
            current = next;// move current one step forward
        }
        head = prev;// set new head
    }

    public void insertAt(int index, int data) {
        Node curNode = head;
        Node newNode = new Node(data);
        int idx = 1;
        while (curNode != null) {
            idx += 1;
            if (idx == index) {
                Node temp = curNode.next;
                curNode.next = newNode;
                newNode.next = temp;
            }
            curNode = curNode.next;
        }
    }

    public void display() {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + "=>");
            currentNode = currentNode.next;

        }
        System.out.print("null\n");
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.head = new Node(1,
                new Node(2, new Node(3, new Node(4, new Node(5, new Node(6, new Node(7, new Node(8))))))));

        list.display();
        // list.deleteByValue(2);
        // list.deleteLast();
        // list.deleteFirst();
        // list.deleteByIndex(3);
        // list.reverseLinkedList();
        list.insertAt(3, 78);
        list.display();
    }
}