package Java_DSA_Questions.Gfg160;
import java.util.Arrays;
public class Day9_Minimize_the_heights {
    
    int getMinDIff(int arr[],int k){
        int n=arr.length;
        
        Arrays.sort(arr);
        int firstDiff=arr[n-1]-arr[0];//storing the first difference of the array
        for(int i=0;i<n-1;i++){
            if((arr[i]-k)<0){//skipping the loop util we get arr[i]-k>0
                continue;
            }

            //use intuition to find the minimum height and maximum height after addition and subtraction of k
            int minHeight=Math.min(arr[0]+k,arr[i]-k);//where it comes to choosing who have smallest height
            int maxHeight=Math.max(arr[i-1]+k,arr[n-1]-k);//where it comes to choosing who have largest height

            firstDiff=Math.min(firstDiff,maxHeight-minHeight);

        }

        return firstDiff;
    }
    public static void main(String[] args) {
        Day9_Minimize_the_heights obj=new Day9_Minimize_the_heights();
        int arr[]={1,5,15,10};
        int k=3;
        System.out.println(obj.getMinDIff(arr,k));
    }
}
