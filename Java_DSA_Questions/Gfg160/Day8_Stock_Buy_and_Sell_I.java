package Java_DSA_Questions.Gfg160;

public class Day8_Stock_Buy_and_Sell_I {
    public static int maximumProfit(int prices[]) {
        // Code here
        int maxProfit=0;
        int minPrice=Integer.MAX_VALUE;
        int profit=0;
        for(int i=0;i<prices.length;i++){//looking for the minimum price in the array
            //and calculating the profit at each index
            if(minPrice>prices[i]) {
            minPrice=prices[i];
            }
            
            profit=prices[i]-minPrice;
            
            if(maxProfit<profit){   //if the profit is greater than the maxProfit then update the maxProfit
                //and also update the minPrice to the current price
                //because we are looking for the minimum price to buy the stock
            maxProfit=profit;
                
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maximumProfit(prices)); // Output: 5 (Buy on day 2 and sell on day 5)
    } 
}
