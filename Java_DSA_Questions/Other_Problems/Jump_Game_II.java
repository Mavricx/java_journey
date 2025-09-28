package Java_DSA_Questions.Other_Problems;

public class Jump_Game_II {
    public static int jump(int [] arr){
        int jumps=0,curEnd=0,farthest=0;
        int n=arr.length;
        if(n==1|| n==0) return 0;
        for(int i=0;i<n;i++){
            farthest=Math.max(farthest,i+arr[i]);//see how far we can go from current position
            if(i==curEnd){//we have come to the end of the range for the current jump
                jumps++;//make the large jump
                curEnd=farthest;//update the range for the next jump
            }
            if(curEnd>=n-1) break;
        }
        return jumps;
    }
    public static void main(String[] args) {
        int [] arr={2,3,1,1,4};
        System.out.println(jump(arr));
    }
}
