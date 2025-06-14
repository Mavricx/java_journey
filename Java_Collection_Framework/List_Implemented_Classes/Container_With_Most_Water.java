package List_Implemented_Classes;

import java.util.*;

public class Container_With_Most_Water {
    public static void main(String[] args) {
        // int height[] = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 8, 6, 2, 5, 4, 8, 3, 7));
        System.out.println(list);
        int left = 0;
        int right = list.size() - 1;
        int maxArea = 0;
        while (left < right) {
            maxArea = Math.max(maxArea, (right - left) * Math.min(list.get(left), list.get(right)));
            if (list.get(left) < list.get(right)) {
                left++;
            } else {
                right--;
            }
        }
        System.out.println(maxArea);
    }
}
