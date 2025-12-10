class Solution {
    public int countPermutations(int[] complexity) {
        int n = complexity.length;
        int mod = 1000000007;
        int shouldbelowest = complexity[0];
        for (int i = 1; i < n; i++) {
            if (complexity[i] <= shouldbelowest) {
                return 0;
            }
        }
        int ans = 1;
        
        for (int i = 1; i < n; i++) {
            ans = (int) (((long) ans * i) % mod);
        }
        return ans;
    }
}