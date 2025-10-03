package Java_DSA_Questions.Other_Leetcode_Problems;

public class Count_Symmetric_Integers {
    public int countSymmetricIntegers(int low, int high) {
        int count=0;
        for(int num=low;num<=high;num++){
            String s=Integer.toString(num);//convert it to string.
            int len=s.length();
            if(len%2!=0){//if have odd nu of digits.
                continue;
            }
            int mid=len/2;
            int lsum=0;
            int rsum=0;
            for(int i=0;i<mid;i++){
                lsum+=s.charAt(i)-'0';
                rsum+=s.charAt(i+mid)-'0';
            }

            if(lsum==rsum){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Count_Symmetric_Integers obj = new Count_Symmetric_Integers();
        int low = 1;
        int high = 1000;
        System.out.println(obj.countSymmetricIntegers(low, high)); // Output: 552
    }
}
