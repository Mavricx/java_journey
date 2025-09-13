package Java_DSA_Questions.Leetcode75;
import java.util.*;

public class Three_Sum {

    public List<List<Integer>> threeSum_bruteForce(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        int n = nums.length;

        // check all triplets
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(triplet); // sort triplet to avoid permutation duplicates
                        set.add(triplet); // use set to avoid duplicates
                    }
                }
            }
        }

        return new ArrayList<>(set);
    }

    //approach
    // 1. Use a HashSet to store the unique triplets.
    // 2. Iterate through the array and for each element, use a HashSet to find pairs that sum to the negative of the current element.
    // 3. Sort the triplet before adding to the result to avoid duplicates.
    //time complexity: O(n^2) average case, O(n^3) worst case due to sorting each triplet.
    public List<List<Integer>> threeSum_hashing (int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            Set<Integer> seen = new HashSet<>();
            for (int j = i + 1; j < n; j++) {
                int complement = -(nums[i] + nums[j]);

                if (seen.contains(complement)) {
                    List<Integer> triplet = Arrays.asList(nums[i], nums[j], complement);
                    Collections.sort(triplet); // sort to handle duplicates
                    result.add(triplet);
                }

                seen.add(nums[j]);// add current number to the set
            }
        }

        return new ArrayList<>(result);
    }

    //approach
    // 1. Sort the array.
    // 2. Iterate through the array, and for each element, use the two-pointer technique to find pairs that sum to the negative of the current element.
    // 3. Skip duplicate elements to avoid duplicate triplets.
    //time complexity: O(n^2)
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);  // sort array first

        for (int i = 0; i < nums.length - 2; i++) {
            // skip duplicate values for 'i'
            if (i > 0 && nums[i] == nums[i - 1]) continue;// skip same result

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;

                    // skip duplicates for left and right
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;

                } else if (sum < 0) {
                    left++; // need bigger sum
                } else {
                    right--; // need smaller sum
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Three_Sum ts = new Three_Sum();
        int[] nums = {-1, 0, 1, 2, -1, -4};

        System.out.println("Brute Force Result: " + ts.threeSum_bruteForce(nums));
        System.out.println("Hashing Result: " + ts.threeSum_hashing(nums));
        System.out.println("Two Pointer Result: " + ts.threeSum(nums));
    }
}
