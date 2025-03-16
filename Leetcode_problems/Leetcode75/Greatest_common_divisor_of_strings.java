public class Greatest_common_divisor_of_strings {
    public String gcdOfStrings(String str1, String str2) {
        if(!(str1+str2).equals(str2+str1)){//only if the two strings are not in correct format.
            return "";
        }
        int lengthGcd=gcd(str1.length(), str2.length());
        return str1.substring(0,lengthGcd);
    }
    public int gcd(int x, int y){
        if(x%y==0) return y;
        else return gcd(y, x%y);
    }
    public static void main(String[] args) {
        Greatest_common_divisor_of_strings obj=new Greatest_common_divisor_of_strings();
        String str1="ABCABC";
        String str2="ABC";
        System.out.println(obj.gcdOfStrings(str1, str2));
    }
}