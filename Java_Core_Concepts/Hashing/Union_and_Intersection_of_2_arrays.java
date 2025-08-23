package Java_Core_Concepts.Hashing;

import java.util.*;

public class Union_and_Intersection_of_2_arrays {

    public static void main(String[] args) {
        int arr1[] = { 7, 3, 9 };
        int arr2[] = { 3, 6, 9, 2, 9, 4 };

        HashSet<Integer> union = new HashSet<>();
        for (int i : arr1)
            union.add(i);
        for (int i : arr2)
            union.add(i);

        System.out.println("Union: " + union);
        System.out.println("Size of union set:" + union.size());

        HashSet<Integer> intersection = new HashSet<>();
        int intersectionCount = 0;
        for (int i : arr1)
            intersection.add(i);
        for (int i : arr2) {
            if (intersection.contains(i)) {
                intersectionCount++;
                System.out.print(i + " ");
                intersection.remove(i);// to avoid counting duplicates.
            }
        }
        System.out.println();
        System.out.println("Size of intersection set:" + intersectionCount);
    }
}
