class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int profit = 0;
        int n = prices.length;
        
        for(int i = 0; i < n; i++){
            if(prices[i]<min)
                min = prices[i];
            
            int newProfit = prices[i] - min;
            if(newProfit > profit)
                profit = newProfit;
        }
        return profit;
    }
}