package Java_DSA_Questions.Gfg160;

public class Day15_Add_Binary_Strings {
    public String addBinary(String s1, String s2) {
        // code here
         int i=s1.length()-1;
         int j=s2.length()-1;
         StringBuilder result=new StringBuilder();
         int carry=0;
         while(i>=0 || j>=0 || carry==1){
             int bit1=(i>=0)? s1.charAt(i--)-'0':0;
             int bit2=(j>=0)? s2.charAt(j--)-'0':0;
             
             int sum=bit1+bit2+carry;
             result.append(sum%2);
             carry=sum/2;
             
         }
         //cleaning out leading zeros.
         while(result.length()>1 && result.charAt(result.length()-1)=='0'){
             result.setLength(result.length()-1);
         }
         
         return result.reverse().toString();
         
    }
    public static void main(String[] args) {
        Day15_Add_Binary_Strings obj = new Day15_Add_Binary_Strings();
        String s1 = "1101";
        String s2 = "1011";
        System.out.println(obj.addBinary(s1, s2)); // Output: "11000"
        
        String s3 = "0";
        String s4 = "0";
        System.out.println(obj.addBinary(s3, s4)); // Output: "0"
        
        String s5 = "111";
        String s6 = "1";
        System.out.println(obj.addBinary(s5, s6)); // Output: "1000"
    }
}
