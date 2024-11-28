package Common_java_problems;
public class LinkedList {

    public static class Node {
        int data;
        Node next;
        Node head;
        Node tail;
    }

    public static void insertion(int k, Node head) {// insertion at last position
        Node newNode = new Node();
        newNode.data = k;
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.next = null;
    }

    public static void deletion(Node head) {// delete last node
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
    }

    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "  ");
            temp = temp.next;
        }
    }

    public static void insertMiddle(int k, int position, Node head) {
        Node temp = head;
        Node newNode = new Node();
        newNode.data = k;
        int count = 0;
        while (count < position) {
            temp = temp.next;
            count++;
        }
        Node temp2 = temp.next;
        temp.next = newNode;
        newNode.next = temp2;
    }

    public static void deleteMiddle(int position, Node head) {
        Node temp = head;
        int count = 0;
        while (count < position) {
            temp = temp.next;
            count++;
        }
        Node temp1 = temp.next;
        Node temp2 = temp1.next;
        temp.next = temp2;
    }
    

    public static void main(String[] args) {
        Node head = new Node();
        head.data = 5;
        insertion(10, head);
        insertion(12, head);
        insertion(13, head);
        insertion(17, head);
        insertion(19, head);
        deleteMiddle(0, head);
        // deletion(head);
        printList(head);

    }

}
