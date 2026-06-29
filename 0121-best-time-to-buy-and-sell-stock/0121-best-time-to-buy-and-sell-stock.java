class Solution {
    public int maxProfit(int[] prices) {
        int maxp = 0;
        int bestBuy = prices[0];
        for(int curPrice:prices){
            if(curPrice>bestBuy){
                maxp = Math.max(maxp,curPrice-bestBuy);
            }
            bestBuy = Math.min(bestBuy,curPrice);
        }
        return maxp;
    }
}