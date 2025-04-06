package Java_DSA_Questions.Leetcode75;

public class Find_the_Highest_Altitude {
    public int largestAltitude(int[] gain) {
        int maxAltitude=0;
        int altitude=0;
        for(int i=0;i<gain.length;i++){
            altitude+=gain[i];
            maxAltitude=Math.max(altitude,maxAltitude);
            
        }
        return maxAltitude;
    }
    public static void main(String[] args) {
        Find_the_Highest_Altitude obj=new Find_the_Highest_Altitude();
        int arr[]={-5,1,5,0,-7};
        System.out.println(obj.largestAltitude(arr));
    }
}
