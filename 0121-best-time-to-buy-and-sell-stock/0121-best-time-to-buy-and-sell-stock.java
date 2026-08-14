class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int bestBuy = prices[0];
        for(int i=1;i<prices.length; i++){
            int currPrice = prices[i];
            if(currPrice>bestBuy){
                profit = Math.max(profit, currPrice-bestBuy);
            }
            bestBuy = Math.min(bestBuy, currPrice);
        }
        return profit;        
    }
}