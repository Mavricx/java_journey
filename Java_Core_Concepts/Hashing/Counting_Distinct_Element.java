package Java_Core_Concepts.Hashing;
import java.util.*;
public class Counting_Distinct_Element {
    public static void main(String[] args) {
        // List<String> elements = Arrays.asList("apple", "banana", "orange", "apple", "banana", "kiwi");
        // Set<String> distinctElements = new HashSet<>(elements);
        // System.out.println("Number of distinct elements: " + distinctElements.size());

        int nums[] = {1, 2, 3, 1, 2, 4, 5};
        Set<Integer> distinctNums = new HashSet<>();
        for (int num : nums) {
            distinctNums.add(num);
        }
        System.out.println("Number of distinct elements: " + distinctNums.size());
    }
}
