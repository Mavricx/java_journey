package Java_DSA_Questions.Leetcode75;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    ListNode(int x, ListNode next) {
        val = x;
        this.next = next;
    }
}

public class Reverse_the_LinkedList {
    public static ListNode reverseLinkedList(ListNode head) {
        ListNode temp = head;
        ListNode nextNode = null;
        ListNode prev = null;
        while (temp != null) {
            nextNode = temp.next;
            temp.next = prev;
            prev = temp;
            temp = nextNode;
        }
        return prev;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        ListNode reversedHead = reverseLinkedList(head);
        ListNode temp = reversedHead;
        while (temp != null) {
            System.out.print(temp.val+ "  ");
            temp = temp.next;
        }
    }
}
