package Common_java_problems;
public class BinarySolution {
    public static String addBinary(String a, String b) {
        StringBuilder ans=new StringBuilder();
        int p=a.length()-1;
        int q=b.length()-1;
        int carry=0;
        while(p>=0||q>=0){
            int sum=carry; //carrying previous carry value
            if(p>=0) sum=sum+a.charAt(p--)-'0'; //adding number each individual number
            if(q>=0) sum=sum+b.charAt(q--)-'0';
            carry=sum>1?1:0;  //carry will be 1 is sum is 2 or 3
            ans.append(sum%2); //changing sum so that only 0 or 1 will be selected           
        }
        if(carry!=0) ans.append(carry);  //after end of loop if carry is not 0 then add it at front
        return ans.reverse().toString(); //reverse it and return it.

    }
    public static void main(String[] args) {
        String a="1010",b="1011";
        System.out.println(addBinary(a,b));
             
    }
    }

