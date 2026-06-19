class Solution {
    public int largestAltitude(int[] gain) {
        int maxi = Integer.MIN_VALUE;
        int currsum = 0;
        for (int i = 0; i < gain.length; i++) {
            currsum += gain[i];
            maxi = Math.max(maxi, currsum);
        }
        return Math.max(maxi, 0);
    }
}