package Java_DSA_Questions.Other_Leetcode_Problems;
import java.util.*;
public class Insert_Intervals {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res=new ArrayList<>();
        int n=intervals.length;
        int i=0;
        while(i<n && intervals[i][1] <newInterval[0]){//left side of the newInterval
            res.add(intervals[i]);
            i++;
        }

        while(i<n && intervals[i][0] <= newInterval[1]){//for the overlapping part
            newInterval[0]=Math.min(intervals[i][0],newInterval[0]);
            newInterval[1]=Math.max(intervals[i][1],newInterval[1]);
            i++;
        }
        res.add(newInterval);
        //add right most non-overlapping part.
        while(i<n){
            res.add(intervals[i]);
            i++;
        }

        return res.toArray(new int[0][]);
    }
    public static void main(String[] args) {
        Insert_Intervals obj=new Insert_Intervals();
        int intervals[][]={{1,3},{6,9}};
        int newInterval[]={2,5};
        int res[][]=obj.insert(intervals,newInterval);
        for(int i=0;i<res.length;i++){
            System.out.println(res[i][0]+" "+res[i][1]);
        }
    }

}

