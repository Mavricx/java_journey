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
    Node temp = null;

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

    public boolean detectLoop() {// Floyd's cycle finding algorithm, again use the slow-fast concept.
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
    // how to remove the cycle
    // step-1:find the last node
    // step-2: lastNode.next=null

    public void removeCycle() {
        // once cycle is detected then set the slow to the head and left the fast as it
        // is.
        // now the slow and fast will move at the same pace +1 and +1 respectively and
        // next time they will meet at the start of the cycle.
        // then implement this lastNode.next=null

        Node slow = head;
        Node fast = head;
        boolean loopFound = false;
        // detect cycle
        while (fast != null && fast.next != null) {
            if (!loopFound) {
                slow = slow.next;
                fast = fast.next.next;
            }

            if (slow == fast) {
                loopFound = true;
                break;
            }
        }
        if (loopFound) {
            // find meeting point
            slow = head;
            Node prev = null;
            while (slow != fast) {
                prev = fast;
                slow = slow.next;
                fast = fast.next;
            }
            // remove the cycle
            prev.next = null;
        }

    }

    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        list.tail = new Node(50);
        list.head = new Node(10, new Node(20, new Node(30, new Node(40, list.tail))));
        list.tail.next = list.head;// made the linked list circular.

        CircularLinkedList list2 = new CircularLinkedList();
        list2.temp = new Node(30, new Node(40, new Node(50, new Node(60, list2.temp))));
        list2.head = new Node(10, new Node(20, list2.temp));

        list.addNode(60);
        System.out.println(list.detectLoop());
        // list.displayList();
        System.out.println(list2.detectLoop());
        list2.removeCycle();
        System.out.println(list2.detectLoop());
        // list.displayList();
    }
}
