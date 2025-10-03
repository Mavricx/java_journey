package Java_DSA_Questions.Other_Leetcode_Problems;
public class Second_largest_digit_in_string {
    public int secondHighest(String s) {
        int len=s.length(); 
        int lar=Integer.MIN_VALUE;
        int secLar=Integer.MIN_VALUE;
        for(int i=0;i<len;i++){
          char c=s.charAt(i);
          if(Character.isDigit(c)){
              int ch=c-'0';
              if(ch>lar && ch> secLar){
                  secLar=lar;
                  lar=ch;
              }
              if(ch>secLar && ch<lar){
                  secLar=ch;
              }
          }
        }
        return secLar==Integer.MIN_VALUE?-1:secLar;  
      }
      public static void main(String[] args) {
        Second_largest_digit_in_string obj = new Second_largest_digit_in_string();
        String s = "abc12345"; // Example input
        int result = obj.secondHighest(s);
        System.out.println("The second largest digit is: " + result); // Output: 4
      }
}