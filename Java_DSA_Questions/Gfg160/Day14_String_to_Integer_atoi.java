package Java_DSA_Questions.Gfg160;
public class Day14_String_to_Integer_atoi {
    public int myAtoi(String s) {
        int intMax=Integer.MAX_VALUE;
        int intMin=Integer.MIN_VALUE;
        int n=s.length();
        int result=0;
        int sign=1;
        int i=0;
        
        if(n==0){
            return 0;
        }

        while(i<n && s.charAt(i)==' '){ //trimming white space
            i++;}
        
        
        if(i<n && (s.charAt(i)=='-' || s.charAt(i)=='+')){//getting the sign 
            sign=s.charAt(i)=='-'?-1:1;
            i++;
        }
        
        while(i<n && (s.charAt(i)-'0'>=0 && s.charAt(i)-'0'<=9)){//adding element while checking its digits
            int digit=s.charAt(i)-'0';
           
            //to check overflow
            if(result>(intMax-digit)/10){
                return sign==1?intMax:intMin;
            }
            
            result=result*10+digit;
            i++;    
        }
        return result*sign;
    }
    public static void main(String[] args) {
        Day14_String_to_Integer_atoi obj = new Day14_String_to_Integer_atoi();
        String s = "   -42";
        System.out.println(obj.myAtoi(s)); // Output: -42
        String s2 = "4193 with words";
        System.out.println(obj.myAtoi(s2)); // Output: 4193
        String s3 = "words and 987";
        System.out.println(obj.myAtoi(s3)); // Output: 0
        String s4 = "-91283472332";
        System.out.println(obj.myAtoi(s4)); // Output: -2147483648 (Integer.MIN_VALUE)
        String s5 = "2147483648"; // Overflow case
        System.out.println(obj.myAtoi(s5)); // Output: 2147483647 (Integer.MAX_VALUE)

    }
}
