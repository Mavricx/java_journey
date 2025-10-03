package Java_DSA_Questions.Other_Leetcode_Problems;

public class Swap_Nodes_Pairs {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode swapPairs(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        ListNode dummy=new ListNode(0);
        ListNode prev=dummy.next;
        while(prev.next!=null  && prev.next.next!=null){
            ListNode first=prev.next;
            ListNode second=prev.next.next;

            prev.next=second.next;
            first.next=second.next;
            second.next=first;

            prev=first;
        }
        return dummy.next;

    }

    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);

        ListNode result=swapPairs(head);
        while(result!=null){
            System.out.print(result.val+" ");
            result=result.next;
        }
        
    }

}
