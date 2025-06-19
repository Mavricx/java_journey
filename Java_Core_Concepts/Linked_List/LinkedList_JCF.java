package Java_Core_Concepts.Linked_List;

import java.util.LinkedList;

public class LinkedList_JCF {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.addFirst(11);
        list.addLast(24);
        list.addFirst(34);
        System.out.println(list);
        // list.removeFirst();
        // list.removeLast();
        list.add(2, 58);
        System.out.println(list);
        list.set(1, 100);
        System.out.println(list);
        System.out.println(list.contains(100));
        System.out.println(list.get(1));
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        // list.clear();
        // System.out.println(list);
        list.remove(1);
        System.out.println(list);
    }  
}
