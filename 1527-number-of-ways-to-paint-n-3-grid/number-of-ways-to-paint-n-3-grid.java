class Solution {
    static final int MOD = 1000000007;

    public int numOfWays(int n) {
        long[] a = new long[n];
        long[] b = new long[n];

        a[0] = 6;
        b[0] = 6;

        for (int i = 1; i < n; i++) {
            a[i] = (2 * a[i - 1] + 2 * b[i - 1]) % MOD;
            b[i] = (2 * a[i - 1] + 3 * b[i - 1]) % MOD;
        }

        return (int)((a[n - 1] + b[n - 1]) % MOD);
    }
}