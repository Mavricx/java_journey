package Java_DSA_Questions.Other_Leetcode_Problems;
import java.util.Arrays;
public class Coin_Change_DP {
    public static int coinChange(int [] coins,int amount){
        int dp[]=new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0]=0;
        for(int x=0;x<=amount;x++){
            for(int c:coins){
                if(x-c>=0){
                    dp[x]=Math.min(dp[x],1+dp[x-c]);
                }
            }
        }
        return dp[amount]==amount+1?-1:dp[amount];
    }

    public static void main(String[] args) {
        int coins[]={1,2,5};
        int amount=11;
        int result=coinChange(coins,amount);
        System.out.println("Minimum number of coins required: "+result);
    }
}
