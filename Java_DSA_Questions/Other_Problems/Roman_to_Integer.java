package Java_DSA_Questions.Other_Problems;
public class Roman_to_Integer {
    public static int romanToInteger(String s){
        int num=0;
        int sum=0;
        for(int i=s.length()-1;i>=0;i--){
            switch(s.charAt(i)){
                case 'I':num=1; break;
                case 'V':num=5; break;
                case 'X':num=10; break;
                case 'L':num=50; break;
                case 'C':num=100; break;
                case 'D':num=500; break;
                case 'M':num=1000; break;
            }
            if(4*num<sum)
                sum-=num;
            else
                sum+=num;
        }
        return sum;
    }
    public static void main(String[] args) {
        String s="MCMXCIV";
        System.out.println(romanToInteger(s));
    }
}
