package Java_DSA_Questions.Gfg160;

public class Day11_Maximum_product_subarray {
    int maxProduct(int[] arr) {
        // code here
        int pref=1;
        int suff=1;
        int len=arr.length;
        int result=Integer.MIN_VALUE;
        for(int i=0;i<len;i++){
            if(pref==0) pref=1; //reset the subarray in case of occurance of zero
            if(suff==0) suff=1;//do the same for subarray starting from end
            
            pref=pref*arr[i];//start multipling  from start
            suff=suff*arr[len-1-i];//multipling  from end
            
            result=Math.max(result,Math.max(pref,suff));
        }
        return result;
    }
    public static void main(String[] args) {
        Day11_Maximum_product_subarray obj = new Day11_Maximum_product_subarray();
        int[] arr = {2, 3, -2, 4};
        System.out.println(obj.maxProduct(arr)); // Output: 6 (Subarray [2, 3] has the maximum product)
    }
}
