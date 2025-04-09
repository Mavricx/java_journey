package Java_DSA_Questions.Gfg160;

public class Day12_Max_Circular_Subarray {
    public int circularSubarraySum(int arr[]) {
        int globMax=arr[0];
        int curMax=0;
        int globMin=arr[0];
        int curMin=0;
        int total=0;
        for(int num:arr){
            curMax=Math.max(curMax+num,num);
            curMin=Math.min(curMin+num,num);
            total+=num;
            globMax=Math.max(globMax,curMax);
            globMin=Math.min(globMin,curMin);
        }
        if(globMax<0){//if all the element in the array are negative.
            return globMax;
        }
        else {
            return Math.max(globMax, total-globMin);//circular logic
        }
    }
    public static void main(String[] args) {
        Day12_Max_Circular_Subarray obj = new Day12_Max_Circular_Subarray();
        int[] arr = {8, -8, 9, -9, 10, -11, 12};
        System.out.println(obj.circularSubarraySum(arr)); // Output: 10 (Subarray [3, -4, 5] has the maximum sum)
    }
}
