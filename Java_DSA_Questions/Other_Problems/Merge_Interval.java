package Java_DSA_Questions.Other_Problems;

import java.util.*;

public class Merge_Interval {
     public static int [][] merge(int [][] intervals){
        if(intervals.length<=1){
            return intervals;
        }
        Arrays.sort(intervals,Comparator.comparingInt(i->i[0]));//sort the array based on the starting time of the each interval
        //or
        // Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        LinkedList<int[]> result=new LinkedList<>();

        //store the first element in the result.
        int [] newInterval=intervals[0];
        result.add(newInterval);
        for( int [] interval: intervals){
            if(interval[0]<=newInterval[1]){//overlapping interval
                //update the end time of the current interval
                newInterval[1]=Math.max(interval[1],newInterval[1]);
                // This does change the value inside the LinkedList as well. This happens because newInterval is a reference to the same array object that was added to the LinkedList. In Java, arrays are reference types, so modifying the array through newInterval directly affects the array stored in the LinkedList.
            }
            else{
                //non-overlapping interval
                //store the current interval
                newInterval=interval;
                result.add(newInterval);
            }
        }
        return result.toArray(new int[result.size()][]);
     }
     public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] merged = merge(intervals);
        System.out.println(Arrays.deepToString(merged));
     }
}
