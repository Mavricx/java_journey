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

    public void deleteAt(int idx) {
        Node curNode = head;
        int curIdx = 1;
        Node temp = head;
        while (curNode != null) {
            curIdx++;
            if (curIdx == idx) {
                temp.next = curNode.next;
            }
            temp = curNode;
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
    // find out if the linked list is palindrome or not
    // method-1 we can store all the value in an array ,arraylist and check its
    // palindrome ness with O(n) time complexity
    // method-2 :
    // step-1:find middle node
    // step-2:reverse the second half
    // step-3:check if first half==second half
    // Time complexity:O(1)
    // slow-fast concept:- take two pointer slow one(turtle) jumps one node at a
    // time (+1) while fast one(hare) jumps two node at a time(+2).
    // after half iteration the fast one will be at last and the slow one will at
    // middle of the linked list

    public Node findMid() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public boolean isPalindrome() {
        if (head == null || head.next == null) {
            return true;
        }

        Node midNode = findMid();

        Node prev = null;
        Node curr = midNode;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev;// right half head
        Node left = head;

        while (right != null) {
            if (left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    private Node getMid(Node head) {
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private Node merge(Node head1, Node head2) {
        Node dummyHead = new Node(-1);
        Node temp = dummyHead;
        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }

        while (head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while (head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        return dummyHead.next;
    }

    public Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        // find the middle of the linked list
        Node mid = getMid(head);
        // then divide the linked list into two linked list
        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        return merge(newLeft, newRight);
    }

    public void makeZigzag(Node head) {
        // similar to palindrome
        // 1.find mid node
        Node mid = findMid();

        // 2.reverse second half
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node left = head;
        Node right = prev;
        Node nextL, nextR;

        // 3.alternate merging.one from 1st half then 2nd from 2nd half, third from 1st
        // half. etc.
        while (left != null && right != null) {
            nextL = left.next;// store next node of left
            left.next = right;// link left to right
            nextR = right.next;// store next node of right
            right.next = nextL;// link right to next left

            left = nextL;// move left to next left node
            right = nextR;// move right to next right node
        }

    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        LinkedList list2 = new LinkedList();
        LinkedList list3 = new LinkedList();
        list.head = new Node(8,
                new Node(69, new Node(3, new Node(47, new Node(61, new Node(57, new Node(25, new Node(65))))))));
        list3.head = new Node(94, new Node(30, new Node(83, new Node(29, new Node(14, new Node(83))))));
        list2.head = new Node(1,
                new Node(2, new Node(3, new Node(4, new Node(3, new Node(2, new Node(1, null)))))));
        // list.display();
        // list.deleteByValue(2);
        // list.deleteLast();
        // list.deleteFirst();
        // list.deleteByIndex(3);
        // list.reverseLinkedList();
        // list.insertAt(3, 78);
        // list.deleteAt(3);
        // list.display();
        // list2.display();
        // System.out.println(list.isPalindrome());
        // System.out.println(list2.isPalindrome());
        list3.head = list3.mergeSort(list3.head);
        list2.makeZigzag(list2.head);
        list2.display();

    }
}