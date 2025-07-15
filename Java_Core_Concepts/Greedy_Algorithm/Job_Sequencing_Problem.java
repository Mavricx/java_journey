package Java_Core_Concepts.Greedy_Algorithm;

import java.util.*;

// Given an array of jobs where every job has a deadline and profit if the job is finished
// before the deadline. It is also given that every job takes a single unit of time, so the
// minimum possible deadline for any job is 1. Maximize the total profit if only one job can
// be scheduled at a time.
public class Job_Sequencing_Problem {
    static class Job {
        int deadline;
        int profit;
        int id;

        public Job(int i, int d, int p) {
            this.id = i;
            this.deadline = d;
            this.profit = p;

        }
    }

    // int deadline[]={4,1,1,1};
    // int profit[]={20,10,40,30};
    // //1st sort the jobs on the basis of the profit..
    public static void main(String[] args) {
        int jobsInfo[][] = { { 4, 20 }, { 1, 10 }, { 1, 40 }, { 1, 30 } };
        int time = 0;
        ArrayList<Job> jobs = new ArrayList<>();
        for (int i = 0; i < jobsInfo.length; i++) {
            jobs.add(new Job(i, jobsInfo[i][0], jobsInfo[i][1]));
        }

        Collections.sort(jobs, (a, b) -> b.profit - a.profit);// descending order of profit.

        ArrayList<Integer> seq = new ArrayList<>();
        for (int i = 0; i < jobs.size(); i++) {
            Job curr = jobs.get(i);
            if (curr.deadline > time) {
                seq.add(curr.id);
                time++;
            }
        }

        System.out.println("Max jobs= " + seq.size());
        for (int i = 0; i < seq.size(); i++) {
            System.out.print(seq.get(i) + " ");
        }
        System.out.println();
    }

}
