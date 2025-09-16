package Java_DSA_Questions.Gfg160;

public class Day7_Stock_Buy_and_Sell_II {
    public static int maximumProfit(int prices[]) {
        int profit=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>prices[i-1]){
                profit+=prices[i]-prices[i-1];//if the current price is greater than the previous price we will buy at the previous price and sell at the current price
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        int prices[] = {100, 180, 260, 310, 40, 535, 695};
        System.out.println(maximumProfit(prices)); // Output: 865 (Buy on day 1 and sell on day 4, buy on day 5 and sell on day 6)
        // Explanation: Buy on day 1 (price = 100) and sell on day 4 (price = 310) for a profit of 210.
        // Then buy on day 5 (price = 40) and sell on day 6 (price = 695) for a profit of 655.
        // Total profit = 210 + 655 = 865.

    }

}
