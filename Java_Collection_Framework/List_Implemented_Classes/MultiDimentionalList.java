package List_Implemented_Classes;

import java.util.*;

public class MultiDimentionalList {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        // ArrayList<Integer> list1 = new ArrayList<>();
        // list1.add(1);
        // list1.add(2);
        // list1.add(3);
        // ArrayList<Integer> list2 = new ArrayList<>();
        // list2.add(4);
        // list2.add(5);
        // list2.add(6);

        // list.add(list1);
        // list.add(list2);
        // System.out.println(list);

        for (int i = 1; i <= 3; i++) {
            ArrayList<Integer> currList = new ArrayList<>();
            for (int j = 1; j <= 5; j++) {
                currList.add(j * i);
            }
            list.add(currList);
        }

        System.out.println(list);
    }

}
