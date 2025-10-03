package Java_DSA_Questions.Other_Leetcode_Problems;
//Answer to the question https://leetcode.com/problems/integer-to-roman/

class integer_to_roman {
    public static String intToRoman(int num) {
         int arr[]={1000 ,900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4,1};
      String str[]={"M" ,"CM","D", "CD", "C","XC","L","XL","X","IX","V","IV","I"};
      StringBuilder res=new StringBuilder();
      for(int i=0;i<arr.length;i++){
        while(num>=arr[i]){
            res.append(str[i]);
            num-=arr[i];
        }
      }
       return res.toString();
    }
    public static void main(String[] args) {
        int num=5995;
        System.out.println(intToRoman(num));
    }
}