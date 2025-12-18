class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        long total = 0L;
        long sum = 0L;
        for(int i = 0;i<k/2;i++){
            total += prices[i]*strategy[i];

            sum -= prices[i]*strategy[i];
        }

        for(int i = k/2;i<k;i++){
            total += prices[i]*strategy[i];
            sum += prices[i]*(1-strategy[i]);
        }
        long max = Math.max(sum, 0);
        
        for(int i = k;i<prices.length;i++){

            total += prices[i]*strategy[i];

            sum += prices[i]*(1-strategy[i]);

            sum -= prices[i-k/2];

            sum += prices[i-k]*strategy[i-k];

            max = Math.max(max, sum);
        }
        return total + max;
    }
}