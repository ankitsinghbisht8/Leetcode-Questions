class Solution {
    public long getDescentPeriods(int[] prices) {
        int[] max = new int[prices.length];
        max[prices.length-1] = 1;
        for (int i=prices.length-2; i>=0; i--){
            max[i] = 1;
            if (prices[i] == prices[i+1]+1) max[i] = max[i+1]+1;
        }
        long res = 0;
        for (int i=0; i<max.length; i++) res += max[i];
        return res;
    }
}