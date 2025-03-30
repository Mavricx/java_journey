package Java_DSA_Questions.Gfg160;

public class Day1_Seccond_Largest {
    public static int getSecondLargest(int[] arr) {
        // Code Here
        if(arr.length==1) 
            return -1;
            
        int lar=Integer.MIN_VALUE;
        int secLar=Integer.MIN_VALUE;
        
        for(int i=0;i<arr.length;i++){
            if(arr[i]>lar){
                secLar=lar;
                lar=arr[i];
            }
            if(arr[i]>secLar && arr[i]<lar){//if element is larger than the current and smaller than the largest
                secLar=arr[i];
            }
            
        }
        return secLar==Integer.MIN_VALUE ? -1 : secLar;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5}; // Example input
        int result = getSecondLargest(arr);
        System.out.println("The second largest element is: " + result); // Output: 4
    }
}
