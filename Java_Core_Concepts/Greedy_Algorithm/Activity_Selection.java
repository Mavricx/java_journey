package Java_Core_Concepts.Greedy_Algorithm;

import java.util.*;

//You are given n activities with their start and end times. Select the maximum number of activities
// that can be performed by a single person, assuming that a person can only work on a single
// activity at a time. Activities are sorted according to end time.
// start [10, 12, 20]
// ans 2 (AO & A2)
// end [20, 25, 30]
public class Activity_Selection {

    public static void main(String[] args) {
        int start[] = { 1, 3, 0, 5, 8, 5 };
        int end[] = { 2, 4, 6, 7, 9, 9 };

        //the below code is for the case when activities are not sorted according to end time
        
        // int maxAct=0;
        // ArrayList <Integer> ans=new ArrayList<>();
        // maxAct=1;
        // ans.add(0);
        // int lastEnd=end[0];
        // for(int i=1;i<end.length;i++){
        // if(start[i]>=lastEnd){
        // maxAct++;
        // ans.add(i);
        // lastEnd=end[i];
        // }
        // }
        // System.out.println("Max Activities: " + maxAct );

        // for(int i=0;i<ans.size();i++){
        // System.out.print("A"+ans.get(i)+" ");
        // }

        // System.out.println();

        //storing the activities in a 2D array where each row contains the index, start time, and end time
        int activities[][] = new int[start.length][3];
        for (int i = 0; i < start.length; i++) {
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }

       //lambda function to sort the activities on the basis of end time/column no 2

        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));
        int maxAct = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        maxAct = 1;
        ans.add(activities[0][0]);
        int lastEnd = activities[0][2];
        for (int i = 1; i < end.length; i++) {
            if (activities[i][1] >= lastEnd) {
                maxAct++;
                ans.add(activities[i][0]);
                lastEnd = activities[i][2];
            }
        }
        System.out.println("Max Activities: " + maxAct);
        System.out.print("Activities: ");
        for (int i = 0; i < ans.size(); i++) {
            System.out.print("A" + ans.get(i) + " ");
        }
    }

}
