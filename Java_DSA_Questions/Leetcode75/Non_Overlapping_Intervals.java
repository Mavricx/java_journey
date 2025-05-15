package Java_DSA_Questions.Leetcode75;

import java.util.Arrays;

public class Non_Overlapping_Intervals {
    class Solution {
        public int eraseOverlapIntervals(int[][] intervals) {
            int res = 0;

            Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
            int lastEnd = intervals[0][1];

            for (int i = 1; i < intervals.length; i++) {
                if (lastEnd > intervals[i][0]) {
                    res++;
                } else {
                    lastEnd = intervals[i][1];
                }
            }
            return res;
        }
    }
    public static void main(String[] args) {
        Non_Overlapping_Intervals obj = new Non_Overlapping_Intervals();
        Solution sol = obj.new Solution();
        int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};
        System.out.println(sol.eraseOverlapIntervals(intervals)); // Output: 1
    }
}
