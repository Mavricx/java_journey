package Java_DSA_Questions.Other_Problems;

public class Partition_List {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode partition(ListNode head, int x) {
        if(head==null || head.next==null) return head;

        ListNode beforeHead=new ListNode(0);
        ListNode before=beforeHead;
        ListNode afterHead=new ListNode(0);
        ListNode after=afterHead;

        while(head!=null){
            if(head.val<x){
                before.next=head;
                before=before.next;
            }else{
                after.next=head;
                after=after.next;
            }
            head=head.next;
        }
        after.next=null;
        before.next=afterHead.next;

        return beforeHead.next;
    }

    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        head.next=new ListNode(4);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(2);
        head.next.next.next.next=new ListNode(5);
        head.next.next.next.next.next=new ListNode(2);

        int x=3;

        ListNode result=partition(head, x);

        while(result!=null){
            System.out.print(result.val+" ");
            result=result.next;
        }
    }
}
